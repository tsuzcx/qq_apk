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
  public long b = 0L;
  
  public AVGameShareEntry(Activity paramActivity, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt)
  {
    super(paramActivity, paramString1, paramString2, paramString3, paramInt);
    this.b = paramLong;
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
  
  public void A()
  {
    if (e() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", e(), 0, "2", String.valueOf(this.b), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", e(), 0, "2", String.valueOf(this.b), "", "");
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Activity paramActivity, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareLinkToWeChat(paramString1, paramInt, paramString2, paramActivity, paramString3, paramString4, paramString5, paramString6);
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareEntry", 1, "shareToSpecifiedFriend");
    x();
    boolean bool = TextUtils.isEmpty(d());
    Object localObject = "邀请你加入派对";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(d());
      ((StringBuilder)localObject).append("邀请你加入派对");
      localObject = ((StringBuilder)localObject).toString();
    }
    Bundle localBundle = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", t(), ArkAppCenterUtil.d(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", (String)localObject, t(), localBundle, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkDirectly("avShareEntry", a(), (ArkShareInfo)localObject, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    y();
    QLog.d("AVGameShareEntry", 1, "shareToSpecifiedFriend success");
  }
  
  protected void c(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("shareToWeChat: shareType is ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("AVGameShareEntry", 1, ((StringBuilder)localObject1).toString());
    if (paramInt == 9)
    {
      if (e() == 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", e(), 0, "3", String.valueOf(this.b), "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "3", String.valueOf(this.b), "", "");
      }
    }
    else if (paramInt == 10) {
      if (e() == 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", e(), 0, "4", String.valueOf(this.b), "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "4", String.valueOf(this.b), "", "");
      }
    }
    localObject1 = d();
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
    if (f())
    {
      localObject1 = b(paramInt);
      localObject2 = a(paramInt);
    }
    a("avShareEntry", paramInt, b(), a(), String.valueOf(System.currentTimeMillis()), (String)localObject1, (String)localObject2, o());
  }
  
  public void d(int paramInt)
  {
    AVGameShareUtil.a().a(a(), 2, true);
  }
  
  public void e(int paramInt)
  {
    QQToast.makeText(a(), 1, 2131887437, 0).show();
  }
  
  public void f(int paramInt)
  {
    QQToast.makeText(a(), 1, 2131887437, 0).show();
  }
  
  public void h(int paramInt)
  {
    String str;
    if (e() == 0)
    {
      if (paramInt == 9) {
        str = "3";
      } else {
        str = "4";
      }
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", 0, 0, str, "", "", "");
      return;
    }
    int i = e();
    if (paramInt == 9) {
      str = "3";
    } else {
      str = "4";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", i, 0, str, "", "", "");
  }
  
  public void p()
  {
    QLog.d("AVGameShareEntry", 1, "showActionSheet");
    if ((a() != null) && (!TextUtils.isEmpty(c())) && (!TextUtils.isEmpty(b())))
    {
      if (this.a == null)
      {
        QLog.e("AVGameShareEntry", 1, "mShareActionSheet is null");
        return;
      }
      if (this.a.isShowing())
      {
        this.a.dismiss();
        return;
      }
      a().getIntent().putExtra("big_brother_source_key", "biz_src_jc_av_game");
      List localList1 = j();
      List localList2 = k();
      Intent localIntent = s();
      this.a.setIntentForStartForwardRecentActivity(localIntent);
      this.a.setRowVisibility(0, 0, 0);
      this.a.setActionSheetItems(localList1, localList2);
      this.a.setItemClickListenerV2(new AVGameShareEntry.1(this));
      this.a.show();
      return;
    }
    QLog.e("AVGameShareEntry", 1, "showActionSheet error: params wrong");
    QQToast.makeText(a(), 2131887438, 0).show();
  }
  
  protected void q()
  {
    v();
    boolean bool = TextUtils.isEmpty(d());
    Object localObject = "邀请你加入派对";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(d());
      ((StringBuilder)localObject).append("邀请你加入派对");
      localObject = ((StringBuilder)localObject).toString();
    }
    Bundle localBundle = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", t(), ArkAppCenterUtil.d(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", (String)localObject, t(), localBundle, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkBySelect("avShareEntry", a(), (ArkShareInfo)localObject);
    w();
  }
  
  protected void r()
  {
    QLog.d("AVGameShareEntry", 1, "shareToQzone");
    z();
    u();
    A();
  }
  
  protected Intent s()
  {
    QLog.d("AVGameShareEntry", 1, "getShareArkIntent");
    Intent localIntent = new Intent(a(), ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 27);
    localIntent.putExtra("is_ark_display_share", true);
    localIntent.putExtra("forward_ark_app_name", "com.tencent.avgame");
    localIntent.putExtra("forward_ark_app_view", "invite");
    localIntent.putExtra("forward_ark_app_ver", "1.0.0.1");
    boolean bool = TextUtils.isEmpty(d());
    Object localObject = "邀请你加入派对";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(d());
      ((StringBuilder)localObject).append("邀请你加入派对");
      localObject = ((StringBuilder)localObject).toString();
    }
    localIntent.putExtra("forward_ark_app_prompt", (String)localObject);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("avgame_share_callback_key", true);
    localObject = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append((String)localObject);
    QLog.d("AVGameShareEntry", 1, localStringBuilder.toString());
    localIntent.putExtra("forward_ark_app_meta", (String)localObject);
    localIntent.putExtras(QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", (String)localObject, ArkAppCenterUtil.d(), null, null));
    return localIntent;
  }
  
  protected String t()
  {
    try
    {
      String str = a(c(), this.b, b());
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
  
  protected void u()
  {
    QLog.d("AVGameShareEntry", 1, "shareLinkToQzone");
    QzoneLinkShareInfo localQzoneLinkShareInfo = new QzoneLinkShareInfo();
    if (TextUtils.isEmpty(d()))
    {
      localQzoneLinkShareInfo.b("邀请你加入派对");
      localQzoneLinkShareInfo.d("邀请你加入派对");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d());
      localStringBuilder.append("邀请你加入派对");
      localQzoneLinkShareInfo.b(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d());
      localStringBuilder.append("邀请你加入派对");
      localQzoneLinkShareInfo.d(localStringBuilder.toString());
    }
    localQzoneLinkShareInfo.a("QQ一起派对");
    localQzoneLinkShareInfo.a(new ArrayList());
    localQzoneLinkShareInfo.c().add(n());
    if (g())
    {
      localQzoneLinkShareInfo.b(i());
      localQzoneLinkShareInfo.d(i());
      localQzoneLinkShareInfo.a(h());
    }
    localQzoneLinkShareInfo.c(b());
    localQzoneLinkShareInfo.a(0);
    localQzoneLinkShareInfo.e(c());
    localQzoneLinkShareInfo.b(l());
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareToQZoneWithLink("avShareEntry", a(), localQzoneLinkShareInfo);
  }
  
  public void v()
  {
    if (e() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", e(), 0, "1", String.valueOf(this.b), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "1", String.valueOf(this.b), "", "");
  }
  
  public void w()
  {
    if (e() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", e(), 0, "1", String.valueOf(this.b), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", e(), 0, "1", String.valueOf(this.b), "", "");
  }
  
  public void x()
  {
    if (e() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", e(), 0, "0", String.valueOf(this.b), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "0", String.valueOf(this.b), "", "");
  }
  
  public void y()
  {
    if (e() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B068", "0X800B068", e(), 0, "0", String.valueOf(this.b), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", e(), 0, "0", String.valueOf(this.b), "", "");
  }
  
  public void z()
  {
    if (e() == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", e(), 0, "2", String.valueOf(this.b), "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B065", "0X800B065", e(), 0, "2", String.valueOf(this.b), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareEntry
 * JD-Core Version:    0.7.0.1
 */