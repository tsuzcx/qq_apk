package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.app.VideoObserver;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallsActivity$13
  extends VideoObserver
{
  MultiIncomingCallsActivity$13(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    QLog.w(this.a.b, 1, "VideoObserver_onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.a.c + "], seq[" + paramLong + "]");
    if (TextUtils.equals(this.a.c, paramString))
    {
      this.a.b("VideoObserver_onClose");
      this.a.a(paramLong, paramInt);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.w(this.a.b, 1, "VideoObserver_onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.a.c + "]");
    if (TextUtils.equals(this.a.c, paramString)) {
      this.a.b("VideoObserver_onDestroyUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.13
 * JD-Core Version:    0.7.0.1
 */