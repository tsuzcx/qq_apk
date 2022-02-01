package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.identity.jwt.JWTUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class IdentityUtils
{
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    return DialogUtil.a(paramContext, paramString4, paramString3, paramString1, paramString2, paramBoolean, 5, paramOnClickListener1, paramOnClickListener2);
  }
  
  private static <T> T a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString2).opt(paramString1);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    catch (ClassCastException paramString1)
    {
      QLog.e("IdentityUtils", 1, new Object[] { "getValueFromPayload ClassCastException : ", paramString1.getMessage() });
    }
    catch (JSONException paramString1)
    {
      QLog.e("IdentityUtils", 1, new Object[] { "getValueFromPayload JSONException : ", paramString1.getMessage() });
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = JWTUtil.a(paramString, "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvpgaMJnHS3HZLto4PIoH\n8LLs/QBNSWe0jEMxWulLOPfpC3jh+jbuVAv/65lDoJEoisvBNB5eAkILd9iI8IIQ\nAaW8ehqYat32ggZTtuJ52NZWLAZtMIMk/eL2Un+o+/7ZA+P3u8aCzbruWZyR01lw\n31GchZfLcv5BeGEDHvGyrArsjAnWsoW8/jJhdqbiVBIsgMh+k+n2rEKX1iG81ATb\nktbp2mTBLxpJSExuM3FhEOPTiosz4TTbuC5oI4VMKpqsUWYkav66v3f3jKkof1ym\nUiC+tqkuDzHcRDRzy8BKCwIrv290FOY5TixXHbNcKupks4Z82H9kE/dUNb+gjssz\nIQIDAQAB\n-----END PUBLIC KEY-----");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("IdentityUtils", 1, new Object[] { "getJwtPayloadWithKey1 error， jwt : ", paramString, " exception : ", localException });
    }
    return null;
  }
  
  public static boolean a(Dialog paramDialog)
  {
    return (paramDialog != null) && (paramDialog.isShowing());
  }
  
  public static boolean a(Dialog paramDialog, Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramDialog != null)
    {
      if (paramActivity == null) {
        return false;
      }
      bool1 = bool2;
      if (b(paramDialog) == paramActivity) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = a(paramString);
    if (paramString == null) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      long l1 = paramString.optLong("iat");
      long l2 = paramString.optLong("exp");
      if ((paramLong > l1) && (paramLong < l2)) {
        return true;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("IdentityUtils", 1, new Object[] { "parse payload error : ", paramString.getMessage() });
    }
    return false;
  }
  
  private static Context b(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return null;
    }
    Context localContext = paramDialog.getContext();
    if ((localContext instanceof Activity)) {
      return localContext;
    }
    paramDialog = localContext;
    if ((localContext instanceof ContextThemeWrapper)) {
      paramDialog = ((ContextThemeWrapper)localContext).getBaseContext();
    }
    return paramDialog;
  }
  
  public static boolean b(String paramString)
  {
    paramString = (Boolean)a("force", paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.IdentityUtils
 * JD-Core Version:    0.7.0.1
 */