package com.tencent.biz.qqstory.playmode.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import mqq.os.MqqHandler;

public class SendVideoToFriendHelper
  implements IEventReceiver
{
  private static SendVideoToFriendHelper d;
  public Bundle a;
  public StoryVideoItem b;
  public String c;
  private boolean e = false;
  
  private SendVideoToFriendHelper()
  {
    StoryDispatcher.a().registerSubscriber(new SendVideoToFriendHelper.DownloadStatusUpdateReceiver(this));
  }
  
  public static SendVideoToFriendHelper a()
  {
    if (d == null) {
      d = new SendVideoToFriendHelper();
    }
    return d;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("forward", 2, "handleForwardData");
    }
    Object localObject = ForwardUtils.a(paramIntent);
    if ((((SessionInfo)localObject).a == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(((SessionInfo)localObject).b, true).b))
    {
      QQToast.makeText(paramQQAppInterface.getApp(), 2131895180, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
      return false;
    }
    int j = paramIntent.getIntExtra("forward_type", 2147483647);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleForwardData() forwardType");
      localStringBuilder.append(j);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (j == 2147483647) {
      return false;
    }
    paramIntent.removeExtra("forward_type");
    paramIntent.getStringExtra("forward_filepath");
    if (((SessionInfo)localObject).a == 9501) {
      return true;
    }
    if (paramIntent.getBooleanExtra("isFromFavorite", false)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleForwardData(): ShortVideo => ");
      ((StringBuilder)localObject).append(paramIntent.getExtras());
      QLog.d("SendVideoToFriendHelper", 2, ((StringBuilder)localObject).toString());
    }
    j = paramIntent.getIntExtra("from_busi_type", 0);
    if (j != 1) {
      if (j == 2) {
        i = 3;
      } else {
        i = 0;
      }
    }
    localObject = SVBusiUtil.a(3, i);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.b(i, paramIntent, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, paramQQAppInterface);
    return true;
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem.mVideoWidth <= 0) || (paramStoryVideoItem.mVideoHeight <= 0))
    {
      int[] arrayOfInt = MediaUtil.b(paramStoryVideoItem.mLocalVideoPath);
      if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
      {
        paramStoryVideoItem.mVideoWidth = arrayOfInt[0];
        paramStoryVideoItem.mVideoHeight = arrayOfInt[1];
        ThreadManager.getSubThreadHandler().post(new SendVideoToFriendHelper.2(this, paramStoryVideoItem));
        return;
      }
      SLog.e("SendVideoToFriendHelper", "getVideoSize error, localPath:%s, width:%s, height:%s", new Object[] { paramStoryVideoItem.mLocalVideoPath, Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putString("forward_thumb", paramString);
      localBundle.putString("forward_filepath", paramString);
      localBundle.putString("forward_extra", paramString);
      localBundle.putBoolean("k_favorites", false);
      localBundle.putBoolean("isFromFavorites", true);
      localBundle.putBoolean("isFromShare", true);
      paramString = new Intent(paramActivity, ForwardRecentActivity.class);
      paramString.putExtras(localBundle);
      paramActivity.startActivity(paramString);
      c();
      return;
    }
    SLog.e("SendVideoToFriendHelper", "start forward activity failed.");
    c();
  }
  
  public void a(Activity paramActivity, String paramString, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramStoryVideoItem != null) && (paramInt > 0))
    {
      this.c = paramString;
      this.b = paramStoryVideoItem;
      paramStoryVideoItem = new Bundle();
      paramStoryVideoItem.putInt("forward_type", 21);
      paramStoryVideoItem.putString("forward_thumb", paramString);
      paramStoryVideoItem.putBoolean("forward_need_sendmsg", true);
      paramStoryVideoItem.putBoolean("is_need_show_toast", false);
      paramString = new Intent();
      paramString.putExtras(paramStoryVideoItem);
      ForwardBaseOption.a(paramActivity, paramString, paramInt);
      return;
    }
    SLog.e("SendVideoToFriendHelper", "start forward activity failed.");
    c();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      SLog.e("SendVideoToFriendHelper", "start forward activity failed.");
      c();
      return;
    }
    this.a = paramBundle;
    a(this.b);
  }
  
  public void a(Bundle paramBundle, StoryVideoItem paramStoryVideoItem, String paramString1, String paramString2)
  {
    if ((paramBundle != null) && (paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str1 = MD5.b(paramString2);
      String str2 = MD5.b(paramString1);
      paramBundle.putInt("forward_type", 21);
      paramBundle.putString("from_uin", PlayModeUtils.b().getCurrentUin());
      paramBundle.putString("file_uuid", paramStoryVideoItem.mVid);
      paramBundle.putString("file_send_path", paramString2);
      paramBundle.putString("file_shortvideo_md5", str1);
      paramBundle.putInt("file_send_size", (int)paramStoryVideoItem.mVideoBytes);
      long l;
      if (paramStoryVideoItem.mVideoDuration <= 100L) {
        l = paramStoryVideoItem.mVideoDuration;
      } else {
        l = paramStoryVideoItem.mVideoDuration / 1000L;
      }
      paramBundle.putInt("file_send_duration", (int)l);
      paramBundle.putString("file_name", ShortVideoUtils.getShortVideoPath(str1, "mp4"));
      paramBundle.putString("thumbfile_send_path", paramString1);
      paramBundle.putString("thumbfile_md5", str2);
      paramBundle.putInt("thumbfile_send_width", paramStoryVideoItem.mVideoWidth);
      paramBundle.putInt("thumbfile_send_height", paramStoryVideoItem.mVideoHeight);
      paramString1 = AIOUtils.a(new Intent(BaseApplicationImpl.getContext(), SplashActivity.class), null);
      paramString1.putExtras(paramBundle);
      a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1);
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131911249), 0).show();
      StoryReportor.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      c();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131911248), 0).show();
    SLog.e("SendVideoToFriendHelper", "send video to friend failed because data is not validate.");
    c();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.e = true;
    ThreadManager.post(new SendVideoToFriendHelper.3(this, paramStoryVideoItem), 10, null, false);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    c();
    long l = System.currentTimeMillis();
    SLog.d("SendVideoToFriendHelper", "generateShareThumb start: %d.", new Object[] { Long.valueOf(l) });
    ThreadManager.post(new SendVideoToFriendHelper.1(this, l, paramStoryVideoItem, paramString), 10, null, false);
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.e = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper
 * JD-Core Version:    0.7.0.1
 */