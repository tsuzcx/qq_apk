package com.huawei.hiar;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

abstract class a
{
  static final String a = a.class.getSimpleName();
  HttpURLConnection b;
  b c;
  
  public a(@NonNull HttpURLConnection paramHttpURLConnection, b paramb)
  {
    this.b = paramHttpURLConnection;
    this.c = paramb;
  }
  
  protected Pair<ConfigAccessRainbowConst.ResponseCode, String> a(String[] paramArrayOfString)
  {
    if (this.b != null) {
      try
      {
        this.b.connect();
        if ((this.b.getRequestMethod().equals(ConfigAccessRainbowConst.b)) && (paramArrayOfString != null) && (paramArrayOfString.length >= 1))
        {
          OutputStream localOutputStream = this.b.getOutputStream();
          localOutputStream.write(paramArrayOfString[0].getBytes());
          localOutputStream.flush();
          localOutputStream.close();
        }
        int i = this.b.getResponseCode();
        if ((i >= 200) && (i < 300))
        {
          paramArrayOfString = a(this.b.getInputStream());
          paramArrayOfString = new Pair(ConfigAccessRainbowConst.ResponseCode.SUCCESS, paramArrayOfString);
          return paramArrayOfString;
        }
        paramArrayOfString = new Pair(ConfigAccessRainbowConst.ResponseCode.FAILED_ERRORCODE, String.valueOf(i));
        return paramArrayOfString;
      }
      catch (IOException paramArrayOfString)
      {
        Log.e(a, "doInBackground: " + paramArrayOfString.toString());
        paramArrayOfString = new Pair(ConfigAccessRainbowConst.ResponseCode.FAILED_TIMEOUT, "TIME_OUT");
        return paramArrayOfString;
      }
      finally
      {
        this.b.disconnect();
      }
    }
    Log.w(a, "doInBackground: mConnection is null");
    return new Pair(ConfigAccessRainbowConst.ResponseCode.FAILED_NULL, "NULL");
  }
  
  String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.close();
    }
    catch (Exception paramInputStream)
    {
      Log.e(a, paramInputStream.toString());
      return null;
    }
    paramInputStream.close();
    paramInputStream = new String(localByteArrayOutputStream.toByteArray());
    return paramInputStream;
  }
  
  public void a()
  {
    b();
    a(a(null));
  }
  
  protected void a(Pair<ConfigAccessRainbowConst.ResponseCode, String> paramPair)
  {
    switch (a.1.a[((ConfigAccessRainbowConst.ResponseCode)paramPair.first).ordinal()])
    {
    default: 
      return;
    case 1: 
      this.c.a((String)paramPair.second);
      return;
    case 2: 
      this.c.a(HuaweiArApkBase.ARAvailability.UNKNOWN_TIMED_OUT);
      return;
    case 3: 
      Log.e(a, "onPostExecute: http connection is null");
      this.c.a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
      return;
    }
    Log.e(a, "onPostExecute: http connection code is " + (String)paramPair.second);
    this.c.a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
  }
  
  protected void b()
  {
    Log.d(a, "start to request from config server: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.a
 * JD-Core Version:    0.7.0.1
 */