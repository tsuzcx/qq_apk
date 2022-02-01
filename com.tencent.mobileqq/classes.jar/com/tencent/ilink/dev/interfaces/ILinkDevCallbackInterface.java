package com.tencent.ilink.dev.interfaces;

import android.util.Log;

class ILinkDevCallbackInterface
{
  private static final String TAG = "ILinkDevCbkInterface";
  
  static void onFinishGetStrategy()
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.a();
    }
  }
  
  static void onLoginComplete(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoginComplete errCode:");
    ((StringBuilder)localObject).append(paramInt1);
    Log.d("ILinkDevCbkInterface", ((StringBuilder)localObject).toString());
    b.a().h();
    localObject = b.a().g();
    if (localObject != null) {
      ((a)localObject).a(paramInt1, paramInt2);
    }
  }
  
  static void onLogoutComplete(int paramInt)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.b(paramInt);
    }
  }
  
  static void onNetStatusChanged(int paramInt)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.a(paramInt);
    }
  }
  
  static void onReceiveMessage(int paramInt, byte[] paramArrayOfByte)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.a(paramInt, paramArrayOfByte);
    }
  }
  
  static void onReceivePullLogCmd(byte[] paramArrayOfByte)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.a(paramArrayOfByte);
    }
  }
  
  static void onReceiveResponse(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.a(paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  static void onSendMsgResult(int paramInt, String paramString)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.a(paramInt, paramString);
    }
  }
  
  static void onUploadLogComplete(int paramInt)
  {
    a locala = b.a().g();
    if (locala != null) {
      locala.c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.dev.interfaces.ILinkDevCallbackInterface
 * JD-Core Version:    0.7.0.1
 */