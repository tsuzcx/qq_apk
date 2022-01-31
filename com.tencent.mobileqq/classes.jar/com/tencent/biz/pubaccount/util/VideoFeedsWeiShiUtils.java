package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import mwy;
import mwz;
import mxa;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsWeiShiUtils
{
  private static DownloadInfo a;
  
  public static WeShiGuideDialog a(Activity paramActivity, String paramString)
  {
    WeShiGuideDialog localWeShiGuideDialog = new WeShiGuideDialog(paramActivity, 2131624517);
    localWeShiGuideDialog.getWindow().getDecorView().setSystemUiVisibility(2);
    localWeShiGuideDialog.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new mwy(localWeShiGuideDialog, paramActivity));
    localWeShiGuideDialog.a("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg").b(paramString);
    localWeShiGuideDialog.show();
    int i = paramActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    if ("video_type_videopublic".equals(paramString))
    {
      PublicAccountReportUtils.b(null, "", "0X80092A6", "0X80092A6", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null), false);
      return localWeShiGuideDialog;
    }
    PublicAccountReportUtils.b(null, "", "0X80092A8", "0X80092A8", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null), false);
    return localWeShiGuideDialog;
  }
  
  private static DownloadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localDownloadInfo.b = localJSONObject.getString("appid");
      localDownloadInfo.jdField_c_of_type_JavaLangString = localJSONObject.getString("url");
      localDownloadInfo.jdField_d_of_type_JavaLangString = localJSONObject.getString("packageName");
      localDownloadInfo.g = localJSONObject.getString("via");
      localDownloadInfo.a = true;
      localDownloadInfo.jdField_d_of_type_Boolean = true;
      localDownloadInfo.j = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
      String str = localJSONObject.getString("isAutoInstall");
      if (str != null) {
        localDownloadInfo.a = str.equals("1");
      }
      str = localJSONObject.getString("isAutoInstallBySDK");
      if (str != null) {
        localDownloadInfo.jdField_d_of_type_Boolean = str.equals("1");
      }
      str = localJSONObject.getString("isShowNotification");
      if (str != null) {
        if (!str.equals("1")) {
          break label186;
        }
      }
      label186:
      for (int i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;; i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE)
      {
        localDownloadInfo.j = i;
        localDownloadInfo.jdField_c_of_type_Boolean = true;
        localDownloadInfo.jdField_e_of_type_Int = 6;
        localDownloadInfo.jdField_e_of_type_JavaLangString = localJSONObject.getString("appName");
        return localDownloadInfo;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("VideoFeedsWeiShiUtils", 4, "json err:" + paramString);
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "https://mobile.qzone.qq.com/l?g=3993";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "https://mobile.qzone.qq.com/l?g=3994";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "https://mobile.qzone.qq.com/l?g=3995";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(c(paramString)));
    } while (!VideoFeedsHelper.a(paramContext, localIntent));
    paramContext.startActivity(localIntent);
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://mobile.qzone.qq.com/l?g=3993\",\"via\":\"ANDROIDQQ.FEED\"}";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://mobile.qzone.qq.com/l?g=3994\",\"via\":\"ANDROIDQQ.FEED\"}";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://mobile.qzone.qq.com/l?g=3995\",\"via\":\"ANDROIDQQ.FEED\"}";
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TextUtils.isEmpty(b(paramString))) {
      a = a(b(paramString));
    }
    if (a != null)
    {
      if (NetworkState.getNetworkType() == 1)
      {
        DownloadManager.a().a(a);
        return;
      }
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setTitle(null);
      paramContext.setMessage("当前为非WiFi网络，确定要下载吗？");
      paramContext.setNegativeButton("取消", new mxa()).setPositiveButton("下载", new mwz());
      paramContext.show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", a(paramString));
    paramContext.startActivity(localIntent);
  }
  
  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "weishi://main?goto=recommend&logsour=5001";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "weishi://main?goto=recommend&logsour=5002";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "weishi://main?goto=recommend&logsour=5003";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils
 * JD-Core Version:    0.7.0.1
 */