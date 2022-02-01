package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;

class AVCameraCaptureModel$1$1$1
  extends IApolloRunnableTask
{
  AVCameraCaptureModel$1$1$1(AVCameraCaptureModel.1.1 param1, ApolloSurfaceView paramApolloSurfaceView, AVVideoCtrl.VideoFrame paramVideoFrame) {}
  
  public String a()
  {
    return "nativePreviewCallback";
  }
  
  public void run()
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(AVCameraCaptureModel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAVCameraCaptureModel$1$1.a.a));
    if (localCmGameOpenIdFinder == null) {}
    while (TextUtils.isEmpty(localCmGameOpenIdFinder.b(str))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1
 * JD-Core Version:    0.7.0.1
 */