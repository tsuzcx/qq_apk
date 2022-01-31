package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import oos;
import oot;
import org.json.JSONException;
import org.json.JSONObject;

public class WeishiGuideUtils
{
  public static WeShiGuideDialog a(Context paramContext, Object paramObject)
  {
    String[] arrayOfString = a(paramObject);
    paramObject = arrayOfString[0];
    String str1 = arrayOfString[1];
    String str2 = arrayOfString[2];
    if (a(paramContext))
    {
      ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 1, paramObject, str1, "", "");
      if (paramContext != null)
      {
        paramObject = new Intent();
        paramObject.setAction("android.intent.action.VIEW");
        paramObject.setData(Uri.parse(str2));
        paramContext.startActivity(paramObject);
      }
      return null;
    }
    str2 = arrayOfString[3];
    ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 2, paramObject, str1, "", "");
    paramContext = new WeShiGuideDialog(paramContext, 2131624517);
    paramContext.a("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg");
    paramContext.a("", str2, "");
    paramContext.show();
    return paramContext;
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
      QLog.e("WeishiGuideUtils", 4, "json err:" + paramString);
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!NetworkUtils.b(paramContext))
    {
      QQToast.a(paramContext, "网络连接错误，请检查网络并重试!", 0).a();
      return;
    }
    Object localObject = a("{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://mobile.qzone.qq.com/l?g=4025\",\"via\":\"ANDROIDQQ.FEED\"}");
    if (localObject != null)
    {
      if (NetworkState.getNetworkType() == 1)
      {
        b((DownloadInfo)localObject);
        return;
      }
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setTitle(null);
      paramContext.setMessage("当前为非WiFi网络，确定要下载吗？");
      paramContext.setNegativeButton("取消", new oot()).setPositiveButton("下载", new oos((DownloadInfo)localObject));
      paramContext.show();
      return;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://mobile.qzone.qq.com/l?g=4025");
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("no")))
    {
      str = paramString;
      if (!paramString.equals("default")) {}
    }
    else
    {
      str = "weishi://main?goto=recommend&logsour=3006";
    }
    paramString = new Intent();
    paramString.setAction("android.intent.action.VIEW");
    paramString.setData(Uri.parse(str));
    paramContext.startActivity(paramString);
  }
  
  public static void a(Object paramObject)
  {
    paramObject = a(paramObject);
    ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", "exp_ws", 0, 0, paramObject[0], paramObject[1], "", "");
  }
  
  public static boolean a(Context paramContext)
  {
    return PackageUtil.a(paramContext, "com.tencent.weishi");
  }
  
  public static String[] a(Object paramObject)
  {
    String str3 = "5";
    String str1;
    String str2;
    if (paramObject != null) {
      if ((paramObject instanceof FilterCategory))
      {
        str1 = ((FilterCategory)paramObject).a;
        paramObject = null;
        str2 = "10";
      }
    }
    for (;;)
    {
      Object localObject = paramObject;
      if (StringUtil.a(paramObject)) {
        localObject = "weishi://camera?logsour=3006";
      }
      return new String[] { str2, str1, localObject, str3 };
      if ((paramObject instanceof QIMFilterCategoryItem))
      {
        paramObject = (QIMFilterCategoryItem)paramObject;
        str2 = "2";
        str1 = paramObject.b;
        paramObject = paramObject.g;
        str3 = "7";
      }
      else if ((paramObject instanceof MusicItemInfo))
      {
        paramObject = (MusicItemInfo)paramObject;
        str2 = "4";
        str1 = paramObject.a;
        paramObject = paramObject.f;
        str3 = "9";
      }
      else if ((paramObject instanceof PtvTemplateManager.PtvTemplateInfo))
      {
        paramObject = (PtvTemplateManager.PtvTemplateInfo)paramObject;
        str2 = "3";
        str1 = paramObject.name;
        paramObject = paramObject.jump_ws;
        str3 = "8";
      }
      else if ((paramObject instanceof PressDarkImageButton))
      {
        paramObject = null;
        str1 = "";
        str2 = "5";
      }
      else if ((paramObject instanceof String))
      {
        str2 = "1";
        str1 = "";
        paramObject = (String)paramObject;
        str3 = "6";
      }
      else
      {
        paramObject = null;
        str1 = "";
        str2 = "1";
      }
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo)
  {
    DownloadManager.a().a(paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.WeishiGuideUtils
 * JD-Core Version:    0.7.0.1
 */