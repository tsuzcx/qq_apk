package com.tencent.biz.common.util;

import org.apache.http.conn.ssl.AbstractVerifier;

final class HttpUtil$1
  extends AbstractVerifier
{
  HttpUtil$1(String paramString) {}
  
  public final String toString()
  {
    return "CUSTOM_COMPATIBLE";
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    verify(this.val$originHost, paramArrayOfString1, paramArrayOfString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.HttpUtil.1
 * JD-Core Version:    0.7.0.1
 */