package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
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
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import org.json.JSONException;
import org.json.JSONObject;
import oth;
import oti;

public class WeishiGuideUtils
{
  public static WeishiGuideUtils.JumpObject a(Object paramObject)
  {
    int j = 1;
    String str1 = "1";
    String str2 = "";
    String str3 = "5";
    Object localObject;
    label59:
    WeishiGuideUtils.JumpObject localJumpObject;
    if (paramObject != null) {
      if ((paramObject instanceof FilterCategory))
      {
        paramObject = (FilterCategory)paramObject;
        str1 = "10";
        str2 = paramObject.jdField_a_of_type_JavaLangString;
        paramObject = null;
        localObject = "";
        i = 1;
        if (!StringUtil.a(paramObject)) {
          break label316;
        }
        paramObject = "weishi://camera?logsour=3006";
        i = j;
        localJumpObject = new WeishiGuideUtils.JumpObject();
        localJumpObject.jdField_a_of_type_JavaLangString = str1;
        localJumpObject.b = str2;
        localJumpObject.jdField_c_of_type_JavaLangString = str3;
        localJumpObject.jdField_a_of_type_Int = i;
        localJumpObject.jdField_e_of_type_JavaLangString = ((String)localObject);
        localJumpObject.f = paramObject;
        if (i == 2)
        {
          localJumpObject.jdField_d_of_type_JavaLangString = "DOV";
          return localJumpObject;
        }
      }
      else if ((paramObject instanceof QIMFilterCategoryItem))
      {
        localObject = (QIMFilterCategoryItem)paramObject;
        str2 = ((QIMFilterCategoryItem)localObject).b;
        paramObject = ((QIMFilterCategoryItem)localObject).g;
        if (!((QIMFilterCategoryItem)localObject).a()) {
          break label334;
        }
      }
    }
    label316:
    label329:
    label334:
    for (int i = 2;; i = 1)
    {
      localObject = "1";
      str3 = "7";
      str1 = "2";
      break;
      if ((paramObject instanceof MusicItemInfo))
      {
        paramObject = (MusicItemInfo)paramObject;
        str2 = paramObject.jdField_a_of_type_JavaLangString;
        paramObject = paramObject.f;
        localObject = "2";
        str1 = "4";
        str3 = "9";
        i = 1;
        break;
      }
      if ((paramObject instanceof PtvTemplateManager.PtvTemplateInfo))
      {
        localObject = (PtvTemplateManager.PtvTemplateInfo)paramObject;
        str2 = ((PtvTemplateManager.PtvTemplateInfo)localObject).name;
        paramObject = ((PtvTemplateManager.PtvTemplateInfo)localObject).jump_app;
        if (!((PtvTemplateManager.PtvTemplateInfo)localObject).isDovItem()) {
          break label329;
        }
      }
      for (i = 2;; i = 1)
      {
        localObject = "3";
        str3 = "8";
        str1 = "3";
        break;
        if ((paramObject instanceof PressDarkImageButton))
        {
          str1 = "5";
          paramObject = null;
          localObject = "";
          i = 1;
          break;
        }
        if ((paramObject instanceof String))
        {
          paramObject = (String)paramObject;
          str1 = "1";
          str2 = "";
          str3 = "6";
          localObject = "";
          i = 1;
          break;
          localJumpObject.jdField_d_of_type_JavaLangString = "微视";
          return localJumpObject;
          break label59;
        }
        paramObject = null;
        localObject = "";
        i = 1;
        break;
      }
    }
  }
  
  public static WeShiGuideDialog a(Context paramContext, Object paramObject)
  {
    WeishiGuideUtils.JumpObject localJumpObject = a(paramObject);
    if (localJumpObject == null) {
      return null;
    }
    paramObject = localJumpObject.jdField_a_of_type_JavaLangString;
    String str1 = localJumpObject.b;
    String str2 = localJumpObject.f;
    int j = localJumpObject.jdField_a_of_type_Int;
    String str3 = localJumpObject.jdField_e_of_type_JavaLangString;
    int i;
    if (((paramContext instanceof EditPicActivity)) || ((paramContext instanceof EditVideoActivity)))
    {
      i = 1;
      if (j != 2) {
        break label146;
      }
      if (!PackageUtil.a(paramContext, "com.tencent.qim")) {
        break label115;
      }
      ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 1, str3, "dov", "", "");
      PackageUtil.a(paramContext, "com.tencent.qim", null);
    }
    for (;;)
    {
      return null;
      i = 0;
      break;
      label115:
      ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 0, str3, "dov", "", "");
      StoryTagUtil.a(paramContext);
    }
    label146:
    if (a(paramContext))
    {
      ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 1, str3, "weishi", "", "");
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
    ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 0, str3, "weishi", "", "");
    str2 = localJumpObject.jdField_c_of_type_JavaLangString;
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
      paramContext.setNegativeButton("取消", new oti()).setPositiveButton("下载", new oth((DownloadInfo)localObject));
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
  
  public static void a(Object paramObject) {}
  
  public static boolean a(Context paramContext)
  {
    return PackageUtil.a(paramContext, "com.tencent.weishi");
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