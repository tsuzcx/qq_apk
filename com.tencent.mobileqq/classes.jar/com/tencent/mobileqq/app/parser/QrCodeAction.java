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
  
  private boolean j()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) {
      l = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) {
      m = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"))) {
      o = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey");
    }
    if ("true".equals(this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
      return b();
    }
    return c();
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = j();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QrCodeAction", 1, localStringBuilder.toString());
      b_("QrCodeAction");
    }
    return false;
  }
  
  protected boolean b()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).length() >= 5))
    {
      localObject = TroopInfoUIUtil.a((String)localObject, "", 14);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        ((Bundle)localObject).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
        ((Bundle)localObject).putString("openid", c(JumpAction.m));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openkey")) {
        ((Bundle)localObject).putString("openkey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_from_game")) {
        ((Bundle)localObject).putString("is_from_game", (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("guild_id")) {
        ((Bundle)localObject).putString("guild_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("guild_id"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("zone_id")) {
        ((Bundle)localObject).putString("zone_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("zone_id"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("role_id")) {
        ((Bundle)localObject).putString("role_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("role_id"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("gc")) {
        ((Bundle)localObject).putString("gc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc"));
      }
      TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
      return true;
    }
    return false;
  }
  
  protected boolean c()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("attr_original_url");
    boolean bool3 = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Intent localIntent = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localIntent == null) {
        bool1 = bool2;
      } else {
        bool1 = localIntent.getBooleanExtra("fromQrcode", false);
      }
    }
    ((IQRJumpApi)QRoute.api(IQRJumpApi.class)).startQRJumpActivity(this.jdField_a_of_type_AndroidContentContext, str1, str2, bool1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QrCodeAction
 * JD-Core Version:    0.7.0.1
 */