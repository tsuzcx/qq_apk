package com.tencent.dlsdk.yybutil.apkchannel;

import com.tencent.dlsdk.yybutil.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException;
import java.net.ProtocolException;
import java.util.Properties;

public final class a
{
  public static String a(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.a.getProperty("channelId");
  }
  
  private static b b(String paramString)
  {
    try
    {
      localObject = com.tencent.dlsdk.yybutil.apkchannel.v2.a.a(paramString);
      paramString = (String)localObject;
    }
    catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException localSignatureNotFoundException)
    {
      Object localObject;
      label10:
      break label10;
    }
    paramString = com.tencent.dlsdk.yybutil.apkchannel.a.a.a(paramString);
    if (paramString == null) {
      return null;
    }
    localObject = new b(null);
    try
    {
      ((b)localObject).a(paramString);
      return localObject;
    }
    catch (ProtocolException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a
 * JD-Core Version:    0.7.0.1
 */