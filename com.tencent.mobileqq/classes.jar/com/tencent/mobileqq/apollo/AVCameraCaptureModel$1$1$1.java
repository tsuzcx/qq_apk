package com.tencent.mobileqq.apollo;

import aknm;
import aknn;
import akno;
import akwd;
import akyu;
import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.common.app.AppInterface;

public class AVCameraCaptureModel$1$1$1
  extends IApolloRunnableTask
{
  public AVCameraCaptureModel$1$1$1(akno paramakno, ApolloSurfaceView paramApolloSurfaceView, AVVideoCtrl.VideoFrame paramVideoFrame) {}
  
  public String a()
  {
    return "nativePreviewCallback";
  }
  
  public void run()
  {
    String str = akwd.a().getCurrentAccountUin();
    akyu localakyu = akwd.a(aknm.a(this.jdField_a_of_type_Akno.a.a));
    if (localakyu == null) {}
    while (TextUtils.isEmpty(localakyu.b(str))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1
 * JD-Core Version:    0.7.0.1
 */