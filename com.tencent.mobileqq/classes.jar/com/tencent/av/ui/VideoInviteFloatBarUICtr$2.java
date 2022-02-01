package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class VideoInviteFloatBarUICtr$2
  extends VideoObserver
{
  VideoInviteFloatBarUICtr$2(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  protected void a()
  {
    super.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceConnected uin = ");
      localStringBuilder.append(this.b.m);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if (this.b.c != null)
    {
      this.b.c.b(this.b.g, this.b.m, this.b.n);
      this.b.c.c(this.b.l.az, this.b.l.aB);
    }
    this.b.a(false);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnected, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    }
    this.b.s.p();
    SmallScreenActivityPlugin.a(this.b.c).a(paramLong, false);
    if (this.b.o != null) {
      this.b.o.c();
    }
    this.b.c.a().postDelayed(this.b.E, 1000L);
    if (this.b.l.g == 1) {
      this.b.A = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
    }
    TraeHelper.a().a(this.b.A);
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose  reason = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",peerUin =  ");
    localStringBuilder.append(paramString);
    QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if (TextUtils.equals(this.b.m, paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClose  wrong uin: ");
      localStringBuilder.append(this.b.m);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
      this.b.a();
      return;
    }
    if (this.b.s != null) {
      this.b.l.h();
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetStrangeFace uin = ");
      localStringBuilder.append(this.b.m);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if ((this.b.g == 25) && (this.b.o != null)) {
      this.b.o.a(paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyUI  peerUin: ");
    localStringBuilder.append(this.b.m);
    localStringBuilder.append(", isQuit : ");
    localStringBuilder.append(paramBoolean);
    QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if ((this.b.m != null) && (paramString != null) && (this.b.m.equals(paramString)) && (paramBoolean)) {
      this.b.a();
    }
  }
  
  protected void b(int paramInt) {}
  
  protected void c(int paramInt) {}
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if (this.b.g == 25)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VideoInviteActivity onGetQCallNickName nickName:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("VideoInviteFloatBarUICtr", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.b;
      ((VideoInviteFloatBarUICtr)localObject).e = paramString;
      if (((VideoInviteFloatBarUICtr)localObject).o != null) {
        this.b.o.d(this.b.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.2
 * JD-Core Version:    0.7.0.1
 */