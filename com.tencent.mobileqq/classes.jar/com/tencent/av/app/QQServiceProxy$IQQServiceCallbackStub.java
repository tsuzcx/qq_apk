package com.tencent.av.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.qphone.base.util.QLog;

class QQServiceProxy$IQQServiceCallbackStub
  extends IQQServiceCallback.Stub
{
  QQServiceProxy$IQQServiceCallbackStub(QQServiceProxy paramQQServiceProxy) {}
  
  public Bundle a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "getDataFromVideoProcess cmd = " + paramInt1 + ",subCmd = " + paramInt2 + ",request = " + paramBundle + ",callbackCookie = " + paramString);
    }
    switch (paramInt1)
    {
    default: 
      return null;
    }
    paramString = new Bundle();
    paramString.putString("camera_used_desc", QavCameraUsage.a);
    return paramString;
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg != null) {
      this.a.a.a(new Object[] { Integer.valueOf(12), paramRecvMsg });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    int j = 0;
    QLog.i("QQServiceProxy", 2, "onReceivePushMsg");
    Object localObject;
    int i;
    if (TextUtils.equals(paramString, "avChatRoom"))
    {
      localObject = this.a.a.a();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a(paramInt, paramArrayOfByte);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("onReceivePushMsg , key[").append(paramString).append("], msgType[").append(paramInt).append("], bytes[");
        if (paramArrayOfByte != null) {
          break label259;
        }
        i = 0;
        label89:
        QLog.i("ChatRoomMng", 4, i + "]");
      }
      paramString = new StringBuilder().append("onReceivePushMsg  , key[").append(paramString).append("], msgType[").append(paramInt).append("], bytes[");
      if (paramArrayOfByte != null) {
        break label266;
      }
    }
    label259:
    label266:
    for (paramInt = j;; paramInt = paramArrayOfByte.length)
    {
      QLog.i("ChatRoomMng", 4, paramInt + "]");
      return;
      if (TextUtils.equals(paramString, "avWatchTogether"))
      {
        localObject = (WTogetherMng)this.a.a.a(15);
        if (localObject == null) {
          break;
        }
        ((WTogetherMng)localObject).a(paramInt, paramArrayOfByte);
        break;
      }
      if ((!TextUtils.equals(paramString, "avScreenShareAsk")) && (!TextUtils.equals(paramString, "avScreenShareAnswer"))) {
        break;
      }
      localObject = (ScreenShareManager)this.a.a.a(16);
      if (localObject == null) {
        break;
      }
      ((ScreenShareManager)localObject).a(paramInt, paramArrayOfByte);
      break;
      i = paramArrayOfByte.length;
      break label89;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.a.a.a(new Object[] { Integer.valueOf(47), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3 });
  }
  
  public void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
  {
    if ((paramArrayOfRecvGVideoLevelInfo != null) && (paramArrayOfRecvGVideoLevelInfo.length > 0)) {
      this.a.a.a(new Object[] { Integer.valueOf(501), paramArrayOfRecvGVideoLevelInfo });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy.IQQServiceCallbackStub
 * JD-Core Version:    0.7.0.1
 */