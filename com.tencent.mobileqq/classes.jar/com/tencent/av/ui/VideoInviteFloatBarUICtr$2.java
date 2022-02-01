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
      localStringBuilder.append(this.a.c);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_b_of_type_Int, this.a.c, this.a.d);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.A, this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.o);
    }
    this.a.a(false);
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
    this.a.jdField_a_of_type_ComTencentAvVideoController.d();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramLong, false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 1000L);
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.d == 1) {
      this.a.f = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
    }
    TraeHelper.a().a(this.a.f);
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose  reason = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",peerUin =  ");
    localStringBuilder.append(paramString);
    QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if (TextUtils.equals(this.a.c, paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClose  wrong uin: ");
      localStringBuilder.append(this.a.c);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
      this.a.a();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.h();
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetStrangeFace uin = ");
      localStringBuilder.append(this.a.c);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_b_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a(paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyUI  peerUin: ");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append(", isQuit : ");
    localStringBuilder.append(paramBoolean);
    QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)) && (paramBoolean)) {
      this.a.a();
    }
  }
  
  protected void b(int paramInt) {}
  
  protected void c(int paramInt) {}
  
  protected void d(String paramString)
  {
    super.d(paramString);
    if (this.a.jdField_b_of_type_Int == 25)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VideoInviteActivity onGetQCallNickName nickName:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("VideoInviteFloatBarUICtr", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      ((VideoInviteFloatBarUICtr)localObject).jdField_b_of_type_JavaLangString = paramString;
      if (((VideoInviteFloatBarUICtr)localObject).jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.d(this.a.jdField_b_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.2
 * JD-Core Version:    0.7.0.1
 */