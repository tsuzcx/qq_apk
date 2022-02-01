package com.tencent.aelight.camera.aebase;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;

class AECameraPlugin$DownloadRunnable
  implements Runnable
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  INetEngineListener jdField_a_of_type_ComTencentMobileqqTransfileINetEngineListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public void run()
  {
    AECameraPlugin.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngineListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */