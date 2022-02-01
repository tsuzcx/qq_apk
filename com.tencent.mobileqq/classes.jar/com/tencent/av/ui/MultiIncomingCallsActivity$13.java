package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.app.VideoObserver;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallsActivity$13
  extends VideoObserver
{
  MultiIncomingCallsActivity$13(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    String str = this.b.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoObserver_onClose, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.b.u);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (TextUtils.equals(this.b.u, paramString))
    {
      this.b.b("VideoObserver_onClose");
      this.b.a(paramLong, paramInt);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    String str = this.b.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoObserver_onDestroyUI, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isQuit[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.b.u);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (TextUtils.equals(this.b.u, paramString)) {
      this.b.b("VideoObserver_onDestroyUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.13
 * JD-Core Version:    0.7.0.1
 */