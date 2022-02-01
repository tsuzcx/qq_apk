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
  private static SendVideoToFriendHelper jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilSendVideoToFriendHelper;
  public Bundle a;
  public StoryVideoItem a;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  
  private SendVideoToFriendHelper()
  {
    StoryDispatcher.a().registerSubscriber(new SendVideoToFriendHelper.DownloadStatusUpdateReceiver(this));
  }
  
  public static SendVideoToFriendHelper a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilSendVideoToFriendHelper == null) {
      jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilSendVideoToFriendHelper = new SendVideoToFriendHelper();
    }
    return jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilSendVideoToFriendHelper;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("forward", 2, "handleForwardData");
    }
    Object localObject = ForwardUtils.a(paramIntent);
    if ((((SessionInfo)localObject).jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(((SessionInfo)localObject).jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131697407, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
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
    if (((SessionInfo)localObject).jdField_a_of_type_Int == 9501) {
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
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(i, paramIntent, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, paramQQAppInterface);
    return true;
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem.mVideoWidth <= 0) || (paramStoryVideoItem.mVideoHeight <= 0))
    {
      int[] arrayOfInt = MediaUtil.a(paramStoryVideoItem.mLocalVideoPath);
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
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
      a();
      return;
    }
    SLog.e("SendVideoToFriendHelper", "start forward activity failed.");
    a();
  }
  
  public void a(Activity paramActivity, String paramString, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramStoryVideoItem != null) && (paramInt > 0))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
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
    a();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      SLog.e("SendVideoToFriendHelper", "start forward activity failed.");
      a();
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
  
  public void a(Bundle paramBundle, StoryVideoItem paramStoryVideoItem, String paramString1, String paramString2)
  {
    if ((paramBundle != null) && (paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str1 = MD5.a(paramString2);
      String str2 = MD5.a(paramString1);
      paramBundle.putInt("forward_type", 21);
      paramBundle.putString("from_uin", PlayModeUtils.a().getCurrentUin());
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
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131713706), 0).a();
      StoryReportor.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131713705), 0).a();
    SLog.e("SendVideoToFriendHelper", "send video to friend failed because data is not validate.");
    a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new SendVideoToFriendHelper.3(this, paramStoryVideoItem), 10, null, false);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    a();
    long l = System.currentTimeMillis();
    SLog.d("SendVideoToFriendHelper", "generateShareThumb start: %d.", new Object[] { Long.valueOf(l) });
    ThreadManager.post(new SendVideoToFriendHelper.1(this, l, paramStoryVideoItem, paramString), 10, null, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper
 * JD-Core Version:    0.7.0.1
 */