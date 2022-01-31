package com.tencent.map.sdk.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class oy$1
  implements ow.d<ow.h<MessageDigest>>
{
  oy$1(oy paramoy) {}
  
  private static ow.h<MessageDigest> b()
  {
    try
    {
      ow.h localh = new ow.h(MessageDigest.getInstance("SHA-256"));
      return localh;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oy.1
 * JD-Core Version:    0.7.0.1
 */