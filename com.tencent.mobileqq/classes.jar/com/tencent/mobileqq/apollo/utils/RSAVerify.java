package com.tencent.mobileqq.apollo.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class RSAVerify
{
  private String a;
  private String b;
  
  public RSAVerify(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.a = paramString2;
  }
  
  public static boolean a(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (!TextUtils.isEmpty(paramString)) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
      if (paramArrayOfByte1.length == 0) {
        return false;
      }
    }
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Util.decode(paramString.getBytes("UTF-8"), 0)));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(paramString);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Throwable paramArrayOfByte1)
    {
      label81:
      break label81;
    }
    QLog.d("[cmshow]RSAVerify", 1, "verify failed");
    return false;
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      if (FileUtils.fileExists(this.a))
      {
        if (!FileUtils.fileExists(this.b)) {
          return false;
        }
        byte[] arrayOfByte1 = FileUtils.readFile(this.a);
        byte[] arrayOfByte2 = FileUtils.readFile(this.b);
        if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0) && (arrayOfByte2 != null))
        {
          if (arrayOfByte2.length == 0) {
            return false;
          }
          if (paramInt == 0) {
            return a(arrayOfByte1, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq8i/7++SDj/syS1oKlYdNJXuRQo1IxcizuFBwq9Ohi9q9u0GInkVFi/3mRU6opILNqNVUoVncxnvfrBrrzxXgPkOow4TFTfo0f2wQRxsuVud/Fjtiz256JKFvIXHdTJ+ZAFIHLtcJMrDhvTUgIIfv5uDZIXARy2KFSzUhqoEwZt3I3Uv9beVecgYofjQ/N/YtG2uWb5dpHMXfsq6JpEpfKxbbFPYJLnrMol0ngsgDrF1h3C28R6l28jFL1nzkxBNt1dIrmitveA0dXbZhYWpRDjg7Ywwt96c1Qq85rs+TL6pNKAYt7aJy/6+PGfMcbkRrtsL72eokicKHnMKVC84fQIDAQAB", arrayOfByte2);
          }
          if (1 == paramInt)
          {
            boolean bool = a(arrayOfByte1, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5ZRiTq5kd+Bsb7Rsvrk/8kF3jRPEAln7kLVAKRi4+jb/gdKEAI9y5jhuyobFq9jLMqKCYKJKb8v/KaGjX0LFZg5+FnC/duF829s7lWPKXNggne+hQOwhWFiamCwf8r8Hzi3YmrKPR4iA/bJUwTbey9T0hKpYbB9QA7IpIQAmGd4cn1ylq/2vblqNwpVV53+SCSg5XRqIXwPYRL9siMZEJAtXbjbpHw8B18zYUGlh2XRJssZyNtgtHOQIvwmdUOGTVRTt7sBZy7adUnq3cpH6/qpdLlAVUAFq/WLwUHNviC+uW47884PSdwqHg8NdeIhitfbcdtOmCNt3OJUvf91L/QIDAQAB", arrayOfByte2);
            return bool;
          }
          return true;
        }
      }
      return false;
    }
    catch (OutOfMemoryError|Throwable localOutOfMemoryError) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.RSAVerify
 * JD-Core Version:    0.7.0.1
 */