package com.tencent.mobileqq.apollo;

import akix;
import akiy;
import akja;
import akro;
import akuf;
import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;

public class AVCameraCaptureModel$1$2$1
  extends IApolloRunnableTask
{
  public AVCameraCaptureModel$1$2$1(akja paramakja, AVVideoCtrl.VideoFrame paramVideoFrame, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public String a()
  {
    return "nativeRemotePreviewCallback";
  }
  
  public void run()
  {
    akuf localakuf = akro.a(akix.a(this.jdField_a_of_type_Akja.a.a));
    if (localakuf == null) {
      return;
    }
    String str2 = localakuf.b(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = localakuf.a(Long.parseLong(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier));
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativeRemotePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2.1
 * JD-Core Version:    0.7.0.1
 */