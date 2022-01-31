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
      byte[] arrayOfByte = com.tencent.dlsdk.yybutil.apkchannel.v2.a.a(paramString);
      paramString = arrayOfByte;
    }
    catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException localSignatureNotFoundException)
    {
      for (;;)
      {
        paramString = com.tencent.dlsdk.yybutil.apkchannel.a.a.a(paramString);
      }
      b localb = new b(null);
      try
      {
        localb.a(paramString);
        return localb;
      }
      catch (ProtocolException paramString)
      {
        paramString.printStackTrace();
      }
    }
    if (paramString == null) {
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a
 * JD-Core Version:    0.7.0.1
 */