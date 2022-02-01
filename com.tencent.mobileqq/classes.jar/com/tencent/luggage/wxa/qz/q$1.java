package com.tencent.luggage.wxa.qz;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class q$1
  extends ThreadLocal<MessageDigest>
{
  protected MessageDigest a()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.q.1
 * JD-Core Version:    0.7.0.1
 */