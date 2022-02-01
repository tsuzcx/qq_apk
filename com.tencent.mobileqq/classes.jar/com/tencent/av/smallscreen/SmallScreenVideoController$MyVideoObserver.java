package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class SmallScreenVideoController$MyVideoObserver
  extends VideoObserver
{
  SmallScreenVideoController$MyVideoObserver(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnected, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    VideoNodeManager.a(32);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.u();
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().b(paramLong, this.a.jdField_c_of_type_Boolean ^ true);
      if (this.a.jdField_c_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        boolean bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean;
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject, 1, bool, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().b(paramLong, false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(0, 0, true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.d();
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a();
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onDetectNoDevicePermission, DeviceType[");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append("], seq[");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)???).toString());
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      paramLong = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, 1);
      if (paramInt == -1) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.remove(paramInt);
      synchronized (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
      {
        paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().b(paramLong, 1);
        if (paramInt == -1) {
          return;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.remove(paramInt);
        return;
      }
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClose, reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("SmallScreenVideoController", 1, localStringBuilder.toString());
    }
    if (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.closeCamera(paramLong, false);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1011)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(paramString, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.m();
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.d(paramInt);
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(0, 0, true);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[random room owner] onDestroyUI isQuit = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mSessionType = ");
      localStringBuilder.append(this.a.jdField_c_of_type_Int);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    super.a(paramString, paramBoolean);
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.MyVideoObserver.2(this, paramString, paramBoolean), 1500L);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    if (paramBoolean1) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.a("float-onRecvWatchTogetherStatusChanged", null);
    localWatchTogetherMediaPlayCtrl.g();
    localWatchTogetherMediaPlayCtrl.h();
    CameraUtils.a(this.a.jdField_a_of_type_AndroidContentContext).setCameraSensorMode(false);
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramInt);
    }
  }
  
  protected void b(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResumeVideo, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject, 1, true, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (paramInt != this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q)
    {
      paramString = new StringBuilder();
      paramString.append("setGlassWaitTime nTime=");
      paramString.append(paramInt);
      paramString.append(", mCurrentVideoGlassWaitTime=");
      paramString.append(this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q);
      QLog.d("SmallScreenVideoController", 1, paramString.toString());
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q = paramInt;
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" # isQuit :");
      localStringBuilder.append(paramBoolean);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_c_of_type_Int == 1) || (this.a.jdField_c_of_type_Int == 2))
    {
      if ((this.a.jdField_a_of_type_JavaLangString != null) && (paramString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        paramString = this.a;
        paramString.b = paramBoolean;
        paramString.d();
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
      {
        paramString = SharedPreUtils.a(this.a.jdField_a_of_type_AndroidContentContext).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.h());
        paramString.commit();
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b(paramBoolean);
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void c()
  {
    long l = AudioHelper.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPauseVideo, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      SmallScreenVideoController.a(this.a, 1);
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1011) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j))
    {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.closeCamera(l, true);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().H == 3) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 0;
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate receive id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
    }
    int i = VipFunCallUtil.a();
    Object localObject = VipFunCallUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (localObject == null) {
      return;
    }
    if ((new File((String)localObject).exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f != 4) && (this.a.jdField_c_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.v();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate finish id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramString, paramBoolean);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(paramString, paramBoolean);
    }
    QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  protected void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.q();
    }
  }
  
  protected void e()
  {
    super.e();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.r();
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 2;
    this.a.b();
  }
  
  protected void f()
  {
    ThreadManager.getUIHandler().post(new SmallScreenVideoController.MyVideoObserver.1(this));
  }
  
  public void f(String paramString)
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAcceptVideoMode, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("SmallScreenVideoController", 1, localStringBuilder.toString());
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 3;
    this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(l);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.c(l, this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRejectVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 0;
  }
  
  protected void h(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    super.h(paramString);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 0;
  }
  
  protected void j()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.d();
    }
  }
  
  protected void k()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */