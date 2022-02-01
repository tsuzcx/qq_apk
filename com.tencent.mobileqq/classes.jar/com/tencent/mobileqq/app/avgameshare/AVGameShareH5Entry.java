package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.sharehelper.ArkShareInfo;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class AVGameShareH5Entry
  extends AVGameShareEntry
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  public AVGameShareH5Entry(Activity paramActivity, String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    super(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt);
    this.jdField_a_of_type_JavaLangString = paramString4;
    this.b = paramString5;
    this.c = paramString6;
    this.d = paramString7;
    if (TextUtils.isEmpty(this.c)) {
      this.c = paramActivity.getResources().getString(2131690327);
    }
    if (TextUtils.isEmpty(this.d)) {
      this.d = "https://qqvgame.qq.com/116da9321d03f927e434a165c14c7c1b.png";
    }
  }
  
  protected Intent a()
  {
    QLog.d("AVGameShareResultLink", 1, "getShareArkIntent");
    if (a() == null)
    {
      QLog.e("AVGameShareResultLink", 1, "getShareArkIntent error: activity is null");
      return null;
    }
    Intent localIntent = new Intent(a(), ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 27);
    localIntent.putExtra("is_ark_display_share", true);
    localIntent.putExtra("forward_ark_app_name", "com.tencent.avgame");
    localIntent.putExtra("forward_ark_app_view", "invite");
    localIntent.putExtra("forward_ark_app_ver", "1.0.0.1");
    localIntent.putExtra("forward_ark_app_prompt", "邀请你领礼包");
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("avgame_share_callback_key", false);
    String str = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append(str);
    QLog.d("AVGameShareResultLink", 1, localStringBuilder.toString());
    localIntent.putExtra("forward_ark_app_meta", str);
    localIntent.putExtras(QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", str, ArkAppCenterUtil.a(), null, null));
    return localIntent;
  }
  
  protected String a(int paramInt)
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected int b()
  {
    return -1;
  }
  
  protected String b(int paramInt)
  {
    return this.b;
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareResultLink", 1, "shareToSpecifiedFriend");
    h();
    Object localObject = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", h(), ArkAppCenterUtil.a(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", "邀请你领礼包", h(), (Bundle)localObject, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkDirectly("avShareH5Entry", a(), (ArkShareInfo)localObject, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    i();
    QLog.d("AVGameShareResultLink", 1, "shareToSpecifiedFriend success");
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    f();
    Object localObject = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", h(), ArkAppCenterUtil.a(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", "邀请你领礼包", h(), (Bundle)localObject, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkBySelect("avShareH5Entry", a(), (ArkShareInfo)localObject);
    g();
  }
  
  protected String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String e()
  {
    return this.b;
  }
  
  protected String f()
  {
    return this.d;
  }
  
  protected String g()
  {
    return this.d;
  }
  
  protected String h()
  {
    try
    {
      b();
      long l = this.jdField_a_of_type_Long;
      String str = a();
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "award");
      JSONObject localJSONObject2 = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder("mqqapi://avgame/create_room");
      localStringBuilder.append("?");
      localStringBuilder.append("gameType");
      localStringBuilder.append("=");
      localStringBuilder.append("4");
      localJSONObject2.put("jump_url", localStringBuilder.toString());
      localJSONObject2.put("h5_url", str);
      localJSONObject2.put("icon_url", this.d);
      localJSONObject2.put("title", this.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("summary", this.b);
      localJSONObject2.put("button", this.c);
      localJSONObject1.put("extra", localJSONObject2);
      ((JSONObject)localObject).put("invite", localJSONObject1);
      str = ((JSONObject)localObject).toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMetaString exception message: ");
      ((StringBuilder)localObject).append(localJSONException);
      QLog.e("AVGameShareResultLink", 1, ((StringBuilder)localObject).toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareH5Entry
 * JD-Core Version:    0.7.0.1
 */