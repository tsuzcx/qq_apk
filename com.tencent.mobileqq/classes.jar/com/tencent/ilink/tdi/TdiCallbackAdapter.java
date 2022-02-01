package com.tencent.ilink.tdi;

import java.util.HashMap;

public class TdiCallbackAdapter
{
  private static HashMap<Long, x> a = new HashMap();
  
  static x getCallback(long paramLong)
  {
    return (x)a.get(Long.valueOf(paramLong));
  }
  
  static void onAppSessionTimeout(long paramLong)
  {
    x localx = getCallback(paramLong);
    if (localx != null) {
      try
      {
        localx.onAppSessionTimeout();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  static void onCancelOAuthComplete(long paramLong, int paramInt1, int paramInt2)
  {
    x localx = getCallback(paramLong);
    if (localx != null) {
      localx.onCancelOAuthComplete(paramInt1, paramInt2);
    }
  }
  
  static void onCheckLoginQrCodeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.g.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onCheckLoginQrCodeComplete(paramInt, paramArrayOfByte);
    }
  }
  
  static void onFaceExtVerifyComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.j.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onFaceExtVerifyComplete(paramInt, paramArrayOfByte);
    }
  }
  
  static void onFaceRecognizeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.n.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onFaceRecognizeComplete(paramInt, paramArrayOfByte);
    }
  }
  
  static void onFaceRecognizeConfigComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.l.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onFaceRecognizeConfigComplete(paramInt, paramArrayOfByte);
    }
  }
  
  static void onGetAppPushTokenComplete(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.b.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onGetAppPushTokenComplete(paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  static void onGetLoginQrCodeComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.p.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onGetLoginQrCodeComplete(paramInt, paramArrayOfByte);
    }
  }
  
  static void onGetOAuthCodeComplete(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.r.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onGetOAuthCodeComplete(paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  static void onLoginComplete(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.v.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onLoginComplete(paramInt, paramArrayOfByte);
    }
  }
  
  static void onLogoutComplete(long paramLong, int paramInt)
  {
    x localx = getCallback(paramLong);
    if (localx != null) {
      try
      {
        localx.onLogoutComplete(paramInt);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  static void onReceiveAppMessage(long paramLong, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.a.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onReceiveAppMessage(paramArrayOfByte);
    }
  }
  
  static void onReceiveAppResponse(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null)
    {
      Object localObject = null;
      try
      {
        paramArrayOfByte = b.d.a(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
      localx.onReceiveAppResponse(paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  static void onRequestUploadLogfiles(long paramLong, byte[] paramArrayOfByte)
  {
    x localx = getCallback(paramLong);
    if (localx != null) {
      try
      {
        localx.onRequestUploadLogfiles(paramArrayOfByte);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  static void removeCallback(long paramLong)
  {
    a.remove(Long.valueOf(paramLong));
  }
  
  static void setCallback(long paramLong, x paramx)
  {
    a.put(Long.valueOf(paramLong), paramx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.TdiCallbackAdapter
 * JD-Core Version:    0.7.0.1
 */