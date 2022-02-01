package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QrCodeAction
  extends JumpAction
{
  public QrCodeAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean d()
  {
    if (!TextUtils.isEmpty((CharSequence)this.f.get("appid"))) {
      y = (String)this.f.get("appid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.f.get("openid"))) {
      z = (String)this.f.get("openid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.f.get("openkey"))) {
      B = (String)this.f.get("openkey");
    }
    if ("true".equals(this.f.get("is_from_game"))) {
      return b();
    }
    return c();
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = d();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QrCodeAction", 1, localStringBuilder.toString());
      h_("QrCodeAction");
    }
    return false;
  }
  
  protected boolean b()
  {
    Object localObject = (String)this.f.get("uin");
    if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).length() >= 5))
    {
      localObject = TroopInfoUIUtil.a((String)localObject, "", 14);
      if (this.f.containsKey("appid")) {
        ((Bundle)localObject).putString("appid", (String)this.f.get("appid"));
      }
      if (this.f.containsKey("openid")) {
        ((Bundle)localObject).putString("openid", h(JumpAction.z));
      }
      if (this.f.containsKey("openkey")) {
        ((Bundle)localObject).putString("openkey", (String)this.f.get("openkey"));
      }
      if (this.f.containsKey("is_from_game")) {
        ((Bundle)localObject).putString("is_from_game", (String)this.f.get("is_from_game"));
      }
      if (this.f.containsKey("guild_id")) {
        ((Bundle)localObject).putString("guild_id", (String)this.f.get("guild_id"));
      }
      if (this.f.containsKey("zone_id")) {
        ((Bundle)localObject).putString("zone_id", (String)this.f.get("zone_id"));
      }
      if (this.f.containsKey("role_id")) {
        ((Bundle)localObject).putString("role_id", (String)this.f.get("role_id"));
      }
      if (this.f.containsKey("gc")) {
        ((Bundle)localObject).putString("gc", (String)this.f.get("gc"));
      }
      TroopUtils.a(this.b, (Bundle)localObject, 2);
      return true;
    }
    return false;
  }
  
  protected boolean c()
  {
    String str2 = (String)this.f.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.c;
    }
    str2 = (String)this.f.get("attr_original_url");
    boolean bool3 = this.b instanceof Activity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Intent localIntent = ((Activity)this.b).getIntent();
      if (localIntent == null) {
        bool1 = bool2;
      } else {
        bool1 = localIntent.getBooleanExtra("fromQrcode", false);
      }
    }
    ((IQRJumpApi)QRoute.api(IQRJumpApi.class)).startQRJumpActivity(this.b, str1, str2, bool1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QrCodeAction
 * JD-Core Version:    0.7.0.1
 */