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
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onServiceConnected uin = " + this.a.c);
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_b_of_type_Int, this.a.c, this.a.d);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.A, this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.p);
    }
    this.a.a(false);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoInviteFloatBarUICtr", 1, "onConnected, seq[" + paramLong + "]");
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.b();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramLong, false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 1000L);
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.d == 1) {
      this.a.f = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    }
    TraeHelper.a().a(this.a.f);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "onClose  reason = " + paramInt + ",peerUin =  " + paramString);
    if (TextUtils.equals(this.a.c, paramString))
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "onClose  wrong uin: " + this.a.c + ", " + paramString);
      this.a.a();
    }
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.j())) {
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onGetStrangeFace uin = " + this.a.c);
    }
    if ((this.a.jdField_b_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroyUI  peerUin: " + this.a.c + ", isQuit : " + paramBoolean);
    if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)) && (paramBoolean)) {
      this.a.a();
    }
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
  
  public void d(String paramString)
  {
    super.d(paramString);
    if (this.a.jdField_b_of_type_Int == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "VideoInviteActivity onGetQCallNickName nickName:" + paramString);
      }
      this.a.jdField_b_of_type_JavaLangString = paramString;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.d(this.a.jdField_b_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.2
 * JD-Core Version:    0.7.0.1
 */