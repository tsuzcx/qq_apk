package com.tencent.mobileqq.apollo;

import amsm;
import amsn;
import amsp;
import anbd;
import android.text.TextUtils;
import ands;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;

public class AVCameraCaptureModel$1$2$1
  extends IApolloRunnableTask
{
  public AVCameraCaptureModel$1$2$1(amsp paramamsp, AVVideoCtrl.VideoFrame paramVideoFrame, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public String a()
  {
    return "nativeRemotePreviewCallback";
  }
  
  public void run()
  {
    ands localands = anbd.a(amsm.a(this.jdField_a_of_type_Amsp.a.a));
    if (localands == null) {
      return;
    }
    String str2 = localands.b(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = localands.a(Long.parseLong(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier));
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativeRemotePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2.1
 * JD-Core Version:    0.7.0.1
 */