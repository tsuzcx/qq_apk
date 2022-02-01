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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDataFromVideoProcess cmd = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",subCmd = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",request = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",callbackCookie = ");
      localStringBuilder.append(paramString);
      QLog.d("QQServiceProxy", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 1) {
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
    QLog.i("QQServiceProxy", 2, "onReceivePushMsg");
    if (TextUtils.equals(paramString, "avChatRoom"))
    {
      localObject = this.a.a.a();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a(paramInt, paramArrayOfByte);
      }
    }
    else if (TextUtils.equals(paramString, "avWatchTogether"))
    {
      localObject = (WTogetherMng)this.a.a.a(16);
      if (localObject != null) {
        ((WTogetherMng)localObject).a(paramInt, paramArrayOfByte);
      }
    }
    else if ((TextUtils.equals(paramString, "avScreenShareAsk")) || (TextUtils.equals(paramString, "avScreenShareAnswer")))
    {
      localObject = (ScreenShareManager)this.a.a.a(17);
      if (localObject != null) {
        ((ScreenShareManager)localObject).a(paramInt, paramArrayOfByte);
      }
    }
    boolean bool = QLog.isDevelopLevel();
    int j = 0;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivePushMsg , key[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], msgType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], bytes[");
      int i;
      if (paramArrayOfByte == null) {
        i = 0;
      } else {
        i = paramArrayOfByte.length;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomMng", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceivePushMsg  , key[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], msgType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], bytes[");
    if (paramArrayOfByte == null) {
      paramInt = j;
    } else {
      paramInt = paramArrayOfByte.length;
    }
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    QLog.i("ChatRoomMng", 4, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy.IQQServiceCallbackStub
 * JD-Core Version:    0.7.0.1
 */