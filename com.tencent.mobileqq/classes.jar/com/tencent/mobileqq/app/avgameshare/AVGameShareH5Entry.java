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
  private String c;
  private String d;
  private String e;
  private String f;
  
  public AVGameShareH5Entry(Activity paramActivity, String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    super(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt);
    this.c = paramString4;
    this.d = paramString5;
    this.e = paramString6;
    this.f = paramString7;
    if (TextUtils.isEmpty(this.e)) {
      this.e = paramActivity.getResources().getString(2131887238);
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = "https://qqvgame.qq.com/116da9321d03f927e434a165c14c7c1b.png";
    }
  }
  
  protected String a(int paramInt)
  {
    return this.c;
  }
  
  protected String b(int paramInt)
  {
    return this.d;
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareResultLink", 1, "shareToSpecifiedFriend");
    x();
    Object localObject = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", t(), ArkAppCenterUtil.d(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", "邀请你领礼包", t(), (Bundle)localObject, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkDirectly("avShareH5Entry", a(), (ArkShareInfo)localObject, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    y();
    QLog.d("AVGameShareResultLink", 1, "shareToSpecifiedFriend success");
  }
  
  protected boolean f()
  {
    return true;
  }
  
  protected boolean g()
  {
    return true;
  }
  
  protected String h()
  {
    return this.c;
  }
  
  protected String i()
  {
    return this.d;
  }
  
  protected int l()
  {
    return -1;
  }
  
  protected String n()
  {
    return this.f;
  }
  
  protected String o()
  {
    return this.f;
  }
  
  protected void q()
  {
    v();
    Object localObject = QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", t(), ArkAppCenterUtil.d(), null, null);
    localObject = new ArkShareInfo("com.tencent.avgame", "invite", "1.0.0.1", "邀请你领礼包", t(), (Bundle)localObject, "avgame_share_callback_key");
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkBySelect("avShareH5Entry", a(), (ArkShareInfo)localObject);
    w();
  }
  
  protected Intent s()
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
    String str = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append(str);
    QLog.d("AVGameShareResultLink", 1, localStringBuilder.toString());
    localIntent.putExtra("forward_ark_app_meta", str);
    localIntent.putExtras(QQCustomArkDialog.AppInfo.a("com.tencent.avgame", "invite", "1.0.0.1", str, ArkAppCenterUtil.d(), null, null));
    return localIntent;
  }
  
  protected String t()
  {
    try
    {
      c();
      long l = this.b;
      String str = b();
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
      localJSONObject2.put("icon_url", this.f);
      localJSONObject2.put("title", this.c);
      localJSONObject2.put("summary", this.d);
      localJSONObject2.put("button", this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareH5Entry
 * JD-Core Version:    0.7.0.1
 */