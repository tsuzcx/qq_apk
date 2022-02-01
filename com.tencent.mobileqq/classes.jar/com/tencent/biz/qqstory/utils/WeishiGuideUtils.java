package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.capture.data.QIMBeautyItem;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMBeautyManager;
import org.json.JSONException;
import org.json.JSONObject;

public class WeishiGuideUtils
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://qzs.qzone.qq.com/qzone/qzact/act/external/weishi/weishi-download/index.html?pkg=3006\",\"via\":\"ANDROIDQQ.FEED\"}";
  }
  
  public static WeishiGuideUtils.JumpObject a(Object paramObject)
  {
    int k = 1;
    String str1 = "1";
    String str3 = "";
    String str2 = "5";
    String str4 = "";
    int j = 0;
    WeishiGuideUtils.JumpObject localJumpObject = null;
    Object localObject = "";
    if (paramObject != null) {
      if ((paramObject instanceof QIMFilterCategoryItem))
      {
        localObject = (QIMFilterCategoryItem)paramObject;
        if (((QIMFilterCategoryItem)localObject).a)
        {
          str3 = ((QIMFilterCategoryItem)localObject).jdField_b_of_type_JavaLangString;
          paramObject = ((QIMFilterCategoryItem)localObject).h;
          if (!((QIMFilterCategoryItem)localObject).a()) {
            break label471;
          }
        }
      }
    }
    label461:
    label466:
    label471:
    for (int i = 2;; i = 1)
    {
      str4 = "1";
      str1 = "2";
      str2 = "7";
      localObject = "clk_combo";
      j = 1;
      if (StringUtil.a(paramObject))
      {
        paramObject = "weishi://camera?logsour=3006";
        i = k;
        label105:
        localJumpObject = new WeishiGuideUtils.JumpObject();
        localJumpObject.jdField_a_of_type_JavaLangString = str1;
        localJumpObject.jdField_b_of_type_JavaLangString = str3;
        localJumpObject.jdField_c_of_type_JavaLangString = str2;
        localJumpObject.jdField_a_of_type_Int = i;
        localJumpObject.e = str4;
        localJumpObject.f = paramObject;
        localJumpObject.g = ((String)localObject);
        localJumpObject.jdField_b_of_type_Int = j;
        if (i == 2)
        {
          localJumpObject.jdField_d_of_type_JavaLangString = "DOV";
          return localJumpObject;
          str1 = "11";
          str3 = ((QIMFilterCategoryItem)localObject).jdField_b_of_type_JavaLangString;
          paramObject = ((QIMFilterCategoryItem)localObject).h;
          str2 = "11";
          if (!((QIMFilterCategoryItem)localObject).a()) {
            break label466;
          }
        }
      }
      for (i = 2;; i = 1)
      {
        j = 0;
        str4 = "11";
        localObject = "clk_filter";
        break;
        if ((paramObject instanceof MusicItemInfo))
        {
          paramObject = (MusicItemInfo)paramObject;
          str1 = "4";
          str3 = paramObject.mMusicName;
          paramObject = paramObject.jumpWs;
          str2 = "9";
          localObject = "clk_music";
          str4 = "2";
          i = 1;
          j = 2;
          break;
        }
        if ((paramObject instanceof PtvTemplateManager.PtvTemplateInfo))
        {
          localObject = (PtvTemplateManager.PtvTemplateInfo)paramObject;
          str1 = "3";
          str3 = ((PtvTemplateManager.PtvTemplateInfo)localObject).name;
          paramObject = ((PtvTemplateManager.PtvTemplateInfo)localObject).jump_app;
          str2 = "8";
          if (!((PtvTemplateManager.PtvTemplateInfo)localObject).isDovItem()) {
            break label461;
          }
        }
        for (i = 2;; i = 1)
        {
          j = 3;
          str4 = "3";
          localObject = "clk_poster";
          break;
          if ((paramObject instanceof PressDarkImageButton))
          {
            str1 = "5";
            i = 1;
            paramObject = localJumpObject;
            break;
          }
          if ((paramObject instanceof String))
          {
            str1 = "1";
            str3 = "";
            paramObject = (String)paramObject;
            str2 = "6";
            i = 1;
            break;
          }
          if ((paramObject instanceof QIMBeautyItem))
          {
            localObject = (QIMBeautyItem)paramObject;
            str1 = "10";
            str3 = ((QIMBeautyItem)localObject).jdField_b_of_type_JavaLangString;
            paramObject = ((QIMBeautyItem)localObject).jdField_d_of_type_JavaLangString;
            str2 = "10";
            if (((QIMBeautyItem)localObject).a()) {}
            for (i = 2;; i = 1)
            {
              str4 = "10";
              localObject = "clk_beauty";
              break;
              localJumpObject.jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131716731);
              return localJumpObject;
              break label105;
            }
          }
          i = 1;
          paramObject = localJumpObject;
          break;
        }
      }
    }
  }
  
  public static WeShiGuideDialog a(Context paramContext, Object paramObject)
  {
    WeishiGuideUtils.JumpObject localJumpObject = a(paramObject);
    if (localJumpObject == null) {
      return null;
    }
    String str1 = localJumpObject.jdField_a_of_type_JavaLangString;
    String str2 = localJumpObject.jdField_b_of_type_JavaLangString;
    String str3 = localJumpObject.f;
    int j = localJumpObject.jdField_a_of_type_Int;
    String str4 = localJumpObject.e;
    int k = localJumpObject.jdField_b_of_type_Int;
    int i;
    int m;
    if (((paramContext instanceof EditPicActivity)) || ((paramContext instanceof EditVideoActivity)))
    {
      i = 1;
      if (!(paramContext instanceof Activity)) {
        break label525;
      }
      paramObject = ((Activity)paramContext).getIntent();
      if (paramObject == null) {
        break label519;
      }
      m = paramObject.getIntExtra("entrance_type", 0);
      if (m != 1) {
        break label170;
      }
      paramObject = "biz_src_jc_hyws";
      label107:
      if (!(paramContext instanceof QIMCameraCaptureActivity)) {
        break label190;
      }
      paramObject = "biz_src_jc_camera";
    }
    for (;;)
    {
      label117:
      if (j == 2)
      {
        if (com.tencent.mobileqq.utils.PackageUtil.a(paramContext, "com.tencent.qim"))
        {
          ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 1, str4, "dov", "", "");
          com.tencent.mobileqq.utils.PackageUtil.a(paramContext, "com.tencent.qim", null);
        }
        for (;;)
        {
          return null;
          i = 0;
          break;
          if ((m != 120) && (m != 121)) {
            break label519;
          }
          paramObject = "biz_src_jc_story";
          break label107;
          if (!(paramContext instanceof EditVideoActivity)) {
            break label516;
          }
          paramObject = "biz_src_jc_editor";
          break label117;
          ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 0, str4, "dov", "", "");
          StoryTagUtil.a(paramContext);
        }
      }
      label170:
      label190:
      if ("biz_src_jc_hyws".equals(paramObject)) {
        if (!a(paramContext)) {
          break label417;
        }
      }
      label417:
      for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
      {
        ReportController.b(null, "dc00898", "", "", "weishi_share_shoot", (String)localObject, k, 0, "", "", "", "");
        ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", localJumpObject.g, 0, 0, str1, str2, "", "");
        if (!a(paramContext)) {
          break;
        }
        ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 1, str4, "weishi", "", "");
        ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 1, str1, str2, "", "");
        if (paramContext != null)
        {
          localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse(str3));
          if (!TextUtils.isEmpty(paramObject)) {
            ((Intent)localObject).putExtra("big_brother_source_key", paramObject);
          }
          paramContext.startActivity((Intent)localObject);
        }
        return null;
      }
      ReportController.b(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 0, str4, "weishi", "", "");
      localObject = localJumpObject.jdField_c_of_type_JavaLangString;
      ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 2, str1, str2, "", "");
      paramContext = new WeShiGuideDialog(paramContext, 2131756059, paramObject);
      paramContext.a("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg");
      paramContext.a("", (String)localObject, "");
      paramContext.show();
      return paramContext;
      label516:
      continue;
      label519:
      paramObject = "";
      break label107;
      label525:
      paramObject = "";
    }
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
      localDownloadInfo.jdField_c_of_type_JavaLangString = localJSONObject.getString("appid");
      localDownloadInfo.jdField_d_of_type_JavaLangString = localJSONObject.getString("url");
      localDownloadInfo.e = localJSONObject.getString("packageName");
      localDownloadInfo.h = localJSONObject.getString("via");
      localDownloadInfo.a = true;
      localDownloadInfo.jdField_d_of_type_Boolean = true;
      localDownloadInfo.i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
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
          break label195;
        }
      }
      label195:
      for (int i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;; i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE)
      {
        localDownloadInfo.i = i;
        localDownloadInfo.jdField_c_of_type_Boolean = true;
        localDownloadInfo.m = "biz_src_jc_qzone";
        localDownloadInfo.f = localJSONObject.getString("appName");
        return localDownloadInfo;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("WeishiGuideUtils", 4, "json err:" + paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!NetworkUtils.b(paramContext))
    {
      QQToast.a(paramContext, HardCodeUtil.a(2131716733), 0).a();
      return;
    }
    QIMBeautyManager.a().a();
    DownloadInfo localDownloadInfo = a(jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null)
    {
      SLog.d("WeishiGuideUtils", "get null info");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("gotoWeishiDownload", 2, " gotoWeishiDownload = " + localDownloadInfo.jdField_d_of_type_JavaLangString);
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", localDownloadInfo.jdField_d_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("big_brother_source_key", paramString);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    String str;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("no")))
    {
      str = paramString2;
      if (!paramString2.equals("default")) {}
    }
    else
    {
      str = "weishi://main?goto=recommend&logsour=3006";
    }
    paramString2 = new Intent();
    paramString2.setAction("android.intent.action.VIEW");
    paramString2.setData(Uri.parse(str));
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2.putExtra("big_brother_source_key", paramString1);
    }
    if (!(paramContext instanceof Activity)) {
      paramString2.addFlags(268435456);
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject == null) {}
    int i;
    int j;
    do
    {
      return;
      i = paramObject.jdField_a_of_type_Int;
      j = paramObject.jdField_b_of_type_Int;
    } while (i != 1);
    ReportController.b(null, "dc00898", "", "", "weishi_share_shoot", "story_entry_exp", j, 0, "", "", "", "");
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return com.tencent.util.pm.PackageUtil.a(paramContext, "com.tencent.weishi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.WeishiGuideUtils
 * JD-Core Version:    0.7.0.1
 */