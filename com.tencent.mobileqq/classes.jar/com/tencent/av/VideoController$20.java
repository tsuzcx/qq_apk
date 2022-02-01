package com.tencent.av;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VideoController$20
  implements Runnable
{
  VideoController$20(VideoController paramVideoController, ArrayList paramArrayList, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.this$0.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (this.this$0.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoRecv(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Boolean) == 0) {
      QLog.e(VideoController.jdField_a_of_type_JavaLangString, 1, "RequestGVideo failed. viewInfos = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.20
 * JD-Core Version:    0.7.0.1
 */