package com.tencent.biz.anonymous;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class AnonymousChatHelper$AnonymousExtInfo
{
  public int a;
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  
  public byte[] a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = this.b.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousChatHelper", 2, "getByteAnId UnsupportedEncodingException");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo
 * JD-Core Version:    0.7.0.1
 */