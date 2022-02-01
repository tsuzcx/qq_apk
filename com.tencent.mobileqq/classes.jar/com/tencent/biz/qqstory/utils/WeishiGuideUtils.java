package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IGategoryItemManager;
import com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.util.pm.PackageUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class WeishiGuideUtils
{
  public static String a = "{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://qzs.qzone.qq.com/qzone/qzact/act/external/weishi/weishi-download/index.html?pkg=3006\",\"via\":\"ANDROIDQQ.FEED\"}";
  
  public static WeishiGuideUtils.JumpObject a(Object paramObject)
  {
    Object localObject5 = "3";
    Object localObject4 = "2";
    Object localObject3 = "5";
    String str = "";
    int i = 0;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject7;
    if (paramObject != null)
    {
      if (paramObject.getClass().getName().contains("QIMFilterCategoryItem"))
      {
        if (((IGategoryItemManager)QRoute.api(IGategoryItemManager.class)).isCombo(paramObject))
        {
          str = ((IGategoryItemManager)QRoute.api(IGategoryItemManager.class)).getItemName(paramObject);
          paramObject = ((IGategoryItemManager)QRoute.api(IGategoryItemManager.class)).getJumApp(paramObject);
          localObject3 = "7";
          localObject4 = "clk_combo";
          localObject1 = "2";
          localObject2 = "1";
          i = 1;
          break label306;
        }
        str = ((IGategoryItemManager)QRoute.api(IGategoryItemManager.class)).getItemName(paramObject);
        paramObject = ((IGategoryItemManager)QRoute.api(IGategoryItemManager.class)).getJumApp(paramObject);
        localObject4 = "clk_filter";
        localObject1 = "11";
        localObject2 = localObject1;
        localObject3 = localObject2;
        break label306;
      }
      if ((paramObject instanceof MusicItemInfo))
      {
        paramObject = (MusicItemInfo)paramObject;
        str = paramObject.mMusicName;
        paramObject = paramObject.jumpWs;
        localObject1 = "4";
        localObject3 = "9";
        localObject5 = "clk_music";
        i = 2;
        localObject2 = localObject4;
        localObject4 = localObject5;
        break label306;
      }
      if ((paramObject instanceof PtvTemplateInfo))
      {
        paramObject = (PtvTemplateInfo)paramObject;
        str = paramObject.e;
        paramObject = paramObject.h;
        localObject3 = "8";
        localObject4 = "clk_poster";
        i = 3;
        localObject2 = "3";
        localObject1 = localObject5;
        break label306;
      }
      if ((paramObject instanceof PressDarkImageButton))
      {
        localObject1 = "5";
        paramObject = localObject6;
        break label299;
      }
      localObject1 = localObject3;
      localObject2 = localObject7;
      if ((paramObject instanceof String))
      {
        localObject2 = (String)paramObject;
        localObject1 = "6";
      }
    }
    localObject4 = "1";
    paramObject = localObject2;
    localObject3 = localObject1;
    localObject1 = localObject4;
    label299:
    localObject4 = "";
    localObject2 = localObject4;
    label306:
    localObject5 = paramObject;
    if (StringUtil.a(paramObject)) {
      localObject5 = "weishi://camera?logsour=3006";
    }
    paramObject = new WeishiGuideUtils.JumpObject();
    paramObject.jdField_a_of_type_JavaLangString = ((String)localObject1);
    paramObject.jdField_b_of_type_JavaLangString = str;
    paramObject.jdField_c_of_type_JavaLangString = ((String)localObject3);
    paramObject.jdField_a_of_type_Int = 1;
    paramObject.e = ((String)localObject2);
    paramObject.f = ((String)localObject5);
    paramObject.g = ((String)localObject4);
    paramObject.jdField_b_of_type_Int = i;
    paramObject.jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131716381);
    return paramObject;
  }
  
  public static WeShiGuideDialog a(Context paramContext, Object paramObject, int paramInt)
  {
    WeishiGuideUtils.JumpObject localJumpObject = a(paramObject);
    if (localJumpObject == null) {
      return null;
    }
    String str1 = localJumpObject.jdField_a_of_type_JavaLangString;
    String str2 = localJumpObject.jdField_b_of_type_JavaLangString;
    String str3 = localJumpObject.f;
    int i = localJumpObject.jdField_a_of_type_Int;
    String str4 = localJumpObject.e;
    int j = localJumpObject.jdField_b_of_type_Int;
    if (paramInt == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramContext instanceof Activity))
    {
      paramObject = ((Activity)paramContext).getIntent();
      if (paramObject != null)
      {
        int k = paramObject.getIntExtra("entrance_type", 0);
        if (k == 1)
        {
          paramObject = "biz_src_jc_hyws";
          break label129;
        }
        if ((k == 120) || (k == 121))
        {
          paramObject = "biz_src_jc_story";
          break label129;
        }
      }
      paramObject = "";
      label129:
      if (paramInt == 1) {
        paramObject = "biz_src_jc_camera";
      } else if (paramInt == 2) {
        paramObject = "biz_src_jc_editor";
      }
    }
    else
    {
      paramObject = "";
    }
    if ("biz_src_jc_hyws".equals(paramObject))
    {
      if (a(paramContext)) {
        localObject = "story_clk_ws";
      } else {
        localObject = "story_dl_ws";
      }
      ReportController.b(null, "dc00898", "", "", "weishi_share_shoot", (String)localObject, j, 0, "", "", "", "");
    }
    ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", localJumpObject.g, 0, 0, str1, str2, "", "");
    if (a(paramContext))
    {
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
    Object localObject = localJumpObject.jdField_c_of_type_JavaLangString;
    ReportController.b(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 2, str1, str2, "", "");
    paramContext = new WeShiGuideDialog(paramContext, 2131756410, paramObject);
    paramContext.a("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg");
    paramContext.a("", (String)localObject, "");
    paramContext.show();
    return paramContext;
  }
  
  private static DownloadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString = localJSONObject.getString("appid");
      ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString = localJSONObject.getString("url");
      ((DownloadInfo)localObject).e = localJSONObject.getString("packageName");
      ((DownloadInfo)localObject).h = localJSONObject.getString("via");
      ((DownloadInfo)localObject).a = true;
      ((DownloadInfo)localObject).jdField_d_of_type_Boolean = true;
      ((DownloadInfo)localObject).i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
      String str = localJSONObject.getString("isAutoInstall");
      if (str != null) {
        ((DownloadInfo)localObject).a = str.equals("1");
      }
      str = localJSONObject.getString("isAutoInstallBySDK");
      if (str != null) {
        ((DownloadInfo)localObject).jdField_d_of_type_Boolean = str.equals("1");
      }
      str = localJSONObject.getString("isShowNotification");
      if (str != null)
      {
        int i;
        if (str.equals("1")) {
          i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
        } else {
          i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
        }
        ((DownloadInfo)localObject).i = i;
      }
      ((DownloadInfo)localObject).jdField_c_of_type_Boolean = true;
      ((DownloadInfo)localObject).m = "biz_src_jc_qzone";
      ((DownloadInfo)localObject).f = localJSONObject.getString("appName");
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      label202:
      break label202;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("json err:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("WeishiGuideUtils", 4, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!NetworkUtils.b(paramContext))
    {
      QQToast.a(paramContext, HardCodeUtil.a(2131716383), 0).a();
      return;
    }
    ((IQIMBeautyManager)QRoute.api(IQIMBeautyManager.class)).parseConfig();
    DownloadInfo localDownloadInfo = a(jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null)
    {
      SLog.d("WeishiGuideUtils", "get null info");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" gotoWeishiDownload = ");
      ((StringBuilder)localObject).append(localDownloadInfo.jdField_d_of_type_JavaLangString);
      QLog.d("gotoWeishiDownload", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", localDownloadInfo.jdField_d_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString)) {
      ((Intent)localObject).putExtra("big_brother_source_key", paramString);
    }
    paramContext.startActivity((Intent)localObject);
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
    if (paramObject == null) {
      return;
    }
    int i = paramObject.jdField_a_of_type_Int;
    int j = paramObject.jdField_b_of_type_Int;
    if (i == 1) {
      ReportController.b(null, "dc00898", "", "", "weishi_share_shoot", "story_entry_exp", j, 0, "", "", "", "");
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      PackageUtil.a(paramContext, "com.tencent.weishi");
      return true;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ErrorMsg:");
      localStringBuilder.append(paramContext.getLocalizedMessage());
      QLog.e("WeishiGuideUtils", 2, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.WeishiGuideUtils
 * JD-Core Version:    0.7.0.1
 */