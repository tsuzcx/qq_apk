package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.opengl.effects.EGLScreenCaptureThread.onVideoFrameAvailableListener;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.ui.ScreenRecordHelper.OnMediaProjectionReadyListener;
import com.tencent.avcore.data.RecordParam;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ScreenShareCtrl$ScreenShareListener
  implements EGLScreenCaptureThread.onVideoFrameAvailableListener, ScreenRecordHelper.OnMediaProjectionReadyListener
{
  private final ScreenShareCtrl.ShareDataInfo jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareDataInfo = new ScreenShareCtrl.ShareDataInfo();
  private final WeakReference<ScreenShareCtrl> jdField_a_of_type_MqqUtilWeakReference;
  
  public ScreenShareCtrl$ScreenShareListener(ScreenShareCtrl paramScreenShareCtrl)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramScreenShareCtrl);
  }
  
  @TargetApi(21)
  public void a(int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMediaProjectionEnd fromType:=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AVShare", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (((ScreenShareCtrl)localObject).a(2) == 1) {
        paramInt = i;
      } else {
        paramInt = 3;
      }
      ScreenShareCtrl.a(paramInt);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Bitmap paramBitmap, RecordParam paramRecordParam)
  {
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramBitmap, paramRecordParam);
    }
  }
  
  @TargetApi(21)
  public void a(RecordParam paramRecordParam, int paramInt1, int paramInt2)
  {
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl == null) {
      return;
    }
    localScreenShareCtrl.a(paramRecordParam, paramInt1, paramInt2);
    if (localScreenShareCtrl.a(1) == 1)
    {
      ScreenShareCtrl.a(4);
      return;
    }
    ScreenShareCtrl.a(6);
    paramRecordParam = VideoController.a().a();
    if (paramRecordParam != null) {
      paramRecordParam.a(1);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, RecordParam paramRecordParam)
  {
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareDataInfo.a(1, paramArrayOfByte, paramInt1, paramInt2, paramRecordParam);
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramArrayOfByte, paramInt1, paramInt2, paramRecordParam);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMediaProjectionReady errorReason:=");
      localStringBuilder.append(paramInt);
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ScreenShareListener
 * JD-Core Version:    0.7.0.1
 */