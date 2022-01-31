package com.tencent.av.screenshare;

import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lid;
import mqq.util.WeakReference;

class ScreenShareCtrl$ShareOpsTimeOutTask
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final VideoConstants.EmShareOps jdField_a_of_type_ComTencentAvVideoConstants$EmShareOps;
  private final lid jdField_a_of_type_Lid;
  private final WeakReference<VideoController> jdField_a_of_type_MqqUtilWeakReference;
  
  public ScreenShareCtrl$ShareOpsTimeOutTask(VideoController paramVideoController, lid paramlid, VideoConstants.EmShareOps paramEmShareOps, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramVideoController);
    this.jdField_a_of_type_Lid = paramlid;
    this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareOps = paramEmShareOps;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    VideoController localVideoController = (VideoController)this.jdField_a_of_type_MqqUtilWeakReference.get();
    int i;
    if ((localVideoController != null) && (this.jdField_a_of_type_Lid != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareOps != VideoConstants.EmShareOps.START) {
        break label136;
      }
      i = 86;
      if (!this.jdField_a_of_type_Lid.j) {
        break label142;
      }
    }
    label136:
    label142:
    for (int j = 2;; j = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "ShareOpsTimeOutTask, actionResult[" + i + "], session[" + this.jdField_a_of_type_Lid + "], multiAVSubType[" + j + "]");
      }
      localVideoController.a(i, this.jdField_a_of_type_Int, this.jdField_a_of_type_Lid.E, this.jdField_a_of_type_Lid.g, this.jdField_a_of_type_Lid.C, j);
      return;
      i = 89;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareOpsTimeOutTask
 * JD-Core Version:    0.7.0.1
 */