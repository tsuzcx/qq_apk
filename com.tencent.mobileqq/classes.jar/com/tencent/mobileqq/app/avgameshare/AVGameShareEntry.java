package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.sharehelper.ArkShareInfo;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.QzoneLinkShareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class AVGameShareEntry
  extends AVGameShareBase
{
  public long a;
  
  public AVGameShareEntry(Activity paramActivity, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt)
  {
    super(paramActivity, paramString1, paramString2, paramString3, paramInt);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static String a(String paramString1, long paramLong, String paramString2)
  {
    long l = System.currentTimeMillis() / 1000L;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "invite");
    JSONObject localJSONObject3 = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder("mqqapi://avgame/join_room");
    localStringBuilder.append("?");
    localStringBuilder.append("uin");
    localStringBuilder.append("=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&");
    localStringBuilder.append("room");
    localStringBuilder.append("=");
    localStringBuilder.append(paramLong);
    localJSONObject3.put("jump_url", localStringBuilder.toString());
    localJSONObject3.put("h5_url", paramString2);
    localJSONObject3.put("icon_url", "https://qqvgame.qq.com/d55d788cc3c423807d830230aad935b2.png");
    localJSONObject3.put("roomid", String.valueOf(paramLong));
    localJSONObject3.put("timestamp", String.valueOf(l));
    localJSONObject2.put("extra", localJSONObject3);
    localJSONObject1.put("invite", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  protected Intent a()
  {
    QLog.d("AVGameShareEntry", 1, "getShareArkIntent");
    Intent localIntent = new Intent(a(), ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 27);
    localIntent.putExtra("is_ark_display_share", true);
    localIntent.putExtra("forward_ark_app_name", "com.tencent.avgame");
    localIntent.putExtra("forward_ark_app_view", "invite");
    localIntent.putExtra("forward_ark_app_ver", "1.0.0.1");
    boolean bool = TextUtils.isEmpty(c());
    Object localObject = "邀请你加入派对";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append("邀请你加入派对");
      localObject = ((StringBuilder)localObject).toString();
    }
    localIntent.putExtra("forward_ark_app_prompt", (String)localObject);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("avgame_share_callback_key", true);
    localObject = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append((String)localObject);
    QLog.d("AVGameShareEntry", 1, localStringBuilder.toString());
    localIntent.putExtra("forward_ark_app_meta", (String)localObject);
    localIntent.putExtras(QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", (String)localObject, ArkAppCenterUtil.a(), null, null));
    return localIntent;
  }
  
  protected void a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("shareToWeChat: shareType is ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("AVGameShareEntry", 1, ((StringBuilder)localObject1).toString());
    if (paramInt == 9)
    {
      if (a() == 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "3", String.valueOf(this.jdField_a_of_type_Long), "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "3", String.valueOf(this.jdField_a_of_type_Long), "", "");
      }
    }
    else if (paramInt == 10) {
      if (a() == 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "4", String.valueOf(this.jdField_a_of_type_Long), "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "4", String.valueOf(this.jdField_a_of_type_Long), "", "");
      }
    }
    localObject1 = c();
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = "派对已开始，你在等什么";
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("的派对已开始，你在等什么");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    if (paramInt == 9) {
      localObject2 = "QQ一起派对";
    } else {
      localObject2 = "快来QQ，加入我的派对";
    }
    if (a())
    {
      localObject1 = b(paramInt);
      localObject2 = a(paramInt);
    }
    a("avShareEntry", paramInt, a(), a(), String.valueOf(System.currentTimeMillis()), (String)localObject1, (String)localObject2, g());
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Activity paramActivity, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareLinkToWeChat(paramString1, paramInt, paramString2, paramActivity, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void b()
  {
    QLog.d("AVGameShareEntry", 1, "showActionSheet");
    if ((a() != null) && (!TextUtils.isEmpty(b())) && (!TextUtils.isEmpty(a())))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
      {
        QLog.e("AVGameShareEntry", 1, "mShareActionSheet is null");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
        return;
      }
      a().getIntent().putExtra("big_brother_source_key", "biz_src_jc_av_game");
      List localList1 = a();
      List localList2 = b();
      Intent localIntent = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList1, localList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AVGameShareEntry.1(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
    }
    QLog.e("AVGameShareEntry", 1, "showActionSheet error: params wrong");
    QQToast.a(a(), 2131690527, 0).a();
  }
  
  public void b(int paramInt)
  {
    AVGameShareUtil.a().a(a(), 2, true);
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareEntry", 1, "shareToSpecifiedFriend");
    h();
    boolean bool = TextUtils.isEmpty(c());
    Object localObject = "邀请你加入派对";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append("邀请你加入派对");
      localObject = ((StringBuilder)localObject).toString();
    }
    Bundle localBundle = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", h(), ArkAppCenterUtil.a(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", (String)localObject, h(), localBundle, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkDirectly("avShareEntry", a(), (ArkShareInfo)localObject, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    i();
    QLog.d("AVGameShareEntry", 1, "shareToSpecifiedFriend success");
  }
  
  protected void c()
  {
    f();
    boolean bool = TextUtils.isEmpty(c());
    Object localObject = "邀请你加入派对";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append("邀请你加入派对");
      localObject = ((StringBuilder)localObject).toString();
    }
    Bundle localBundle = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", h(), ArkAppCenterUtil.a(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", (String)localObject, h(), localBundle, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkBySelect("avShareEntry", a(), (ArkShareInfo)localObject);
    g();
  }
  
  public void c(int paramInt)
  {
    QQToast.a(a(), 1, 2131690526, 0).a();
  }
  
  protected void d()
  {
    QLog.d("AVGameShareEntry", 1, "shareToQzone");
    j();
    e();
    k();
  }
  
  public void d(int paramInt)
  {
    QQToast.a(a(), 1, 2131690526, 0).a();
  }
  
  protected void e()
  {
    QLog.d("AVGameShareEntry", 1, "shareLinkToQzone");
    QzoneLinkShareInfo localQzoneLinkShareInfo = new QzoneLinkShareInfo();
    if (TextUtils.isEmpty(c()))
    {
      localQzoneLinkShareInfo.b("邀请你加入派对");
      localQzoneLinkShareInfo.d("邀请你加入派对");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append("邀请你加入派对");
      localQzoneLinkShareInfo.b(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append("邀请你加入派对");
      localQzoneLinkShareInfo.d(localStringBuilder.toString());
    }
    localQzoneLinkShareInfo.a("QQ一起派对");
    localQzoneLinkShareInfo.a(new ArrayList());
    localQzoneLinkShareInfo.a().add(f());
    if (b())
    {
      localQzoneLinkShareInfo.b(e());
      localQzoneLinkShareInfo.d(e());
      localQzoneLinkShareInfo.a(d());
    }
    localQzoneLinkShareInfo.c(a());
    localQzoneLinkShareInfo.a(0);
    localQzoneLinkShareInfo.e(b());
    localQzoneLinkShareInfo.b(b());
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareToQZoneWithLink("avShareEntry", a(), localQzoneLinkShareInfo);
  }
  
  public void f()
  {
    if (a() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  public void f(int paramInt)
  {
    String str;
    if (a() == 0)
    {
      if (paramInt == 9) {
        str = "3";
      } else {
        str = "4";
      }
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", 0, 0, str, "", "", "");
      return;
    }
    int i = a();
    if (paramInt == 9) {
      str = "3";
    } else {
      str = "4";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", i, 0, str, "", "", "");
  }
  
  public void g()
  {
    if (a() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  protected String h()
  {
    try
    {
      String str = a(b(), this.jdField_a_of_type_Long, a());
      return str;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMetaString exception message: ");
      localStringBuilder.append(localJSONException);
      QLog.e("AVGameShareEntry", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  public void h()
  {
    if (a() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  public void i()
  {
    if (a() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  public void j()
  {
    if (a() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  public void k()
  {
    if (a() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareEntry
 * JD-Core Version:    0.7.0.1
 */