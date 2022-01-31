package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import com.tencent.open.component.cache.util.LocalConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import org.json.JSONObject;
import xty;

public class QzoneSyncQQStoryTool
{
  public static int a(long paramLong)
  {
    String str = LocalMultiProcConfig.getString4Uin("key_qzone_sync_to_qqstory_config", null, paramLong);
    try
    {
      int i = new JSONObject(str).optInt("video_size_limit_for_android");
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("QzoneSyncQQStoryTool", 2, "parse json error", localThrowable);
    }
    return 90;
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      LpReportInfo_pf00064.allReport(608, 12, 1);
    }
    for (;;)
    {
      LocalConfig.a(paramLong).edit().putBoolean("isSyncQQStory", paramBoolean).apply();
      return;
      LpReportInfo_pf00064.allReport(608, 12, 2);
    }
  }
  
  public static void a(Activity paramActivity, View paramView, long paramLong)
  {
    if ((paramActivity == null) || (paramView == null)) {
      return;
    }
    new Handler().postDelayed(new xty(paramActivity, paramView), 500L);
    LocalConfig.a(paramLong).edit().putBoolean("isShowSyncQQStoryTip", true).apply();
  }
  
  public static boolean a(long paramLong)
  {
    return LocalConfig.a(paramLong).getBoolean("isShowSyncQQStoryTip", false);
  }
  
  public static boolean a(long paramLong, int paramInt)
  {
    boolean bool = true;
    int i;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "keySyncToQQStory", 1) > 0)
    {
      i = 1;
      if (i != 0) {
        break label34;
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label34:
      Object localObject = LocalMultiProcConfig.getString4Uin("key_qzone_sync_to_qqstory_config", null, paramLong);
      try
      {
        localObject = new JSONObject((String)localObject);
        if (paramInt == 1)
        {
          if (((JSONObject)localObject).optInt("show_sync_btn_for_takepic") != 1) {
            return false;
          }
        }
        else if (paramInt == 2)
        {
          if (((JSONObject)localObject).optInt("show_sync_btn_for_takevideo") != 1) {
            return false;
          }
        }
        else if (paramInt == 3)
        {
          paramInt = ((JSONObject)localObject).optInt("show_sync_btn_for_localvideo");
          if (paramInt == 1) {
            continue;
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i("QzoneSyncQQStoryTool", 2, "parse json error", localThrowable);
      }
    }
    return false;
  }
  
  public static boolean b(long paramLong)
  {
    return LocalConfig.a(paramLong).getBoolean("isSyncQQStory", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSyncQQStoryTool
 * JD-Core Version:    0.7.0.1
 */