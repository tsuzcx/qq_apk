package com.tencent.mobileqq.apollo;

import amsm;
import amsn;
import amso;
import anbd;
import android.text.TextUtils;
import ands;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.common.app.AppInterface;

public class AVCameraCaptureModel$1$1$1
  extends IApolloRunnableTask
{
  public AVCameraCaptureModel$1$1$1(amso paramamso, ApolloSurfaceView paramApolloSurfaceView, AVVideoCtrl.VideoFrame paramVideoFrame) {}
  
  public String a()
  {
    return "nativePreviewCallback";
  }
  
  public void run()
  {
    String str = anbd.a().getCurrentAccountUin();
    ands localands = anbd.a(amsm.a(this.jdField_a_of_type_Amso.a.a));
    if (localands == null) {}
    while (TextUtils.isEmpty(localands.b(str))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1
 * JD-Core Version:    0.7.0.1
 */