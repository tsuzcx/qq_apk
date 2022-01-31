package com.tencent.mobileqq.activity.richmedia.view;

import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.util.NUserEglContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterOpenglFrameBuffer;
import com.tencent.qphone.base.util.QLog;

public class GameplayRenderFilter
{
  private static boolean jdField_a_of_type_Boolean = CameraCompatibleList.b(CameraCompatibleList.D);
  private NUserEglContext jdField_a_of_type_ComTencentMobileqqShortvideoUtilNUserEglContext = new NUserEglContext(true);
  private PtvFilterOpenglFrameBuffer jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = new PtvFilterOpenglFrameBuffer();
  private String jdField_a_of_type_JavaLangString = "";
  
  static
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameplayRenderFilter", 2, "sNeedSync3DRender=" + jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.GameplayRenderFilter
 * JD-Core Version:    0.7.0.1
 */