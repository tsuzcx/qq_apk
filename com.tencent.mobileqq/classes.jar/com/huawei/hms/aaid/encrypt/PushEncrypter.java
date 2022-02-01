package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.c;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

public class PushEncrypter
{
  public static String decrypter(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return AesCbc.decrypt(paramString, c.c(paramContext));
  }
  
  public static String encrypter(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return AesCbc.encrypt(paramString, c.c(paramContext));
  }
  
  public static String encrypterOld(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return AesCbc.encrypt(paramString, c.a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.aaid.encrypt.PushEncrypter
 * JD-Core Version:    0.7.0.1
 */