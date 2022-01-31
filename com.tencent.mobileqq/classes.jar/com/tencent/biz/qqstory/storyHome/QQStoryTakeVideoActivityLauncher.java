package com.tencent.biz.qqstory.storyHome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.boundaries.StoryDepends.CameraFlow;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.io.File;

public class QQStoryTakeVideoActivityLauncher
{
  @NonNull
  private final QQAppInterface a;
  
  public QQStoryTakeVideoActivityLauncher(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      SLog.e("QQStoryTakeVideoActivityLauncher", "ShortVideoUtils.isVideoSoLibLoaded() is false");
      ShortVideoUtils.a(paramAppInterface);
    } while (ShortVideoUtils.a());
    SLog.e("QQStoryTakeVideoActivityLauncher", "ShortVideoUtils.isVideoSoLibLoaded() is false after loadShortVideoSo");
    return false;
  }
  
  public Intent a(Context paramContext, int paramInt)
  {
    if (!ShortVideoUtils.a(paramInt)) {
      throw new IllegalArgumentException("illegal entrance type : " + paramInt);
    }
    paramContext = a(paramContext, false, a(this.a));
    paramContext.putExtra("entrance_type", paramInt);
    return paramContext;
  }
  
  public Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramContext, paramBoolean1, paramBoolean2, new Intent());
  }
  
  public Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Intent paramIntent)
  {
    boolean bool1 = false;
    paramIntent.putExtra("videoIsUsable", paramBoolean2);
    Object localObject1 = (RedTouchManager)this.a.getManager(35);
    Object localObject2 = ((RedTouchManager)localObject1).a("103100.103500.103501");
    if (localObject2 != null) {
      if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
      if (((SharedPreferences)localObject2).getBoolean("flow_filter_reddot_key", false))
      {
        ((RedTouchManager)localObject1).b("103100.103500.103501");
        ((SharedPreferences)localObject2).edit().putBoolean("flow_filter_reddot_key", false).commit();
        paramBoolean1 = false;
      }
      for (;;)
      {
        if (!BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + this.a.getCurrentAccountUin(), 4).getBoolean("flow_filter_reddot_key", false)) {
          bool1 = true;
        }
        boolean bool2 = PtvFilterSoLoad.a(this.a, BaseApplicationImpl.getContext());
        localObject1 = PlusPanelUtils.a(QQStoryConstant.c);
        localObject2 = new File(AppConstants.aW);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        return StoryDepends.CameraFlow.a(paramContext, paramBoolean2, paramIntent, paramBoolean1, bool1, bool2, (String)localObject1, this.a.getAccount());
        paramBoolean1 = false;
        break;
      }
      paramBoolean1 = false;
    }
  }
  
  public void a(@NonNull Intent paramIntent)
  {
    paramIntent.putExtra("short_video_refer", "qqstory");
    paramIntent.putExtra("set_user_callback", QQStoryFlowCallback.class.getCanonicalName());
    paramIntent.putExtra("enable_local_video", true);
    paramIntent.putExtra("ignore_dpc_duration", true);
    paramIntent.putExtra("video_duration", 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher
 * JD-Core Version:    0.7.0.1
 */