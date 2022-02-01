package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
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
public class AVGameShareResultLink
  extends AVGameShareEntry
{
  private String c;
  
  public AVGameShareResultLink(Activity paramActivity, String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4)
  {
    super(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt);
    this.c = paramString4;
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if (!bool2)
    {
      if (e() == 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareResultLink", 1, "shareToSpecifiedFriend");
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
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkDirectly("avShareResultLink", a(), (ArkShareInfo)localObject, paramActionSheetItem.uinType, paramActionSheetItem.uin);
    y();
    QLog.d("AVGameShareResultLink", 1, "shareToSpecifiedFriend success");
  }
  
  protected String n()
  {
    String str2 = AVGameShareUtil.a().a(this.c);
    String str1 = str2;
    if (a(str2)) {
      str1 = super.n();
    }
    return str1;
  }
  
  protected String o()
  {
    String str2 = AVGameShareUtil.a().a(this.c);
    String str1 = str2;
    if (a(str2)) {
      str1 = super.o();
    }
    return str1;
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
    ((IShareActionHelper)QRoute.api(IShareActionHelper.class)).doShareArkBySelect("avShareResultLink", a(), (ArkShareInfo)localObject);
    w();
  }
  
  protected String t()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", "result");
      localJSONObject2.put("gameType", e());
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("jump_url", b());
      localObject2 = AVGameShareUtil.a().a(this.c);
      Object localObject1 = localObject2;
      if (a((String)localObject2)) {
        localObject1 = "https://qqvgame.qq.com/d55d788cc3c423807d830230aad935b2.png";
      }
      localJSONObject3.put("icon_url", localObject1);
      localJSONObject2.put("extra", localJSONObject3);
      localJSONObject1.put("invite", localJSONObject2);
      localObject1 = localJSONObject1.toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getMetaString exception message: ");
      ((StringBuilder)localObject2).append(localJSONException);
      QLog.e("AVGameShareResultLink", 1, ((StringBuilder)localObject2).toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultLink
 * JD-Core Version:    0.7.0.1
 */