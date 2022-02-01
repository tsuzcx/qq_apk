package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallUICtr$4
  extends VideoObserver
{
  MultiIncomingCallUICtr$4(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnected, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
    this.b.D.p();
    SmallScreenActivityPlugin.a(this.b.c).a(paramLong, false);
    if (this.b.o != null) {
      this.b.o.c();
    }
    if (this.b.l.g == 1) {
      this.b.E = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
    }
    TraeHelper.a().a(this.b.E);
    this.b.c.a().postDelayed(this.b.H, 1000L);
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if ((this.b.m != null) && (this.b.m.equals(paramString)))
    {
      this.b.a(paramLong, paramInt);
      this.b.a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClose, reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mPeerUin[");
      localStringBuilder.append(this.b.m);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if (this.b.o != null) {
      this.b.o.a();
    }
    this.b.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyUI, peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isQuit:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mPeerUin:");
      localStringBuilder.append(this.b.m);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.4
 * JD-Core Version:    0.7.0.1
 */