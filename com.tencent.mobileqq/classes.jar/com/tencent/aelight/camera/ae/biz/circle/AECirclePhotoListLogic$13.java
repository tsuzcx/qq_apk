package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class AECirclePhotoListLogic$13
  implements ThreadExcutor.IThreadListener
{
  AECirclePhotoListLogic$13(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onAdded()
  {
    AEQLog.a("AECirclePhotoListLogic", "onAdded--serialCompressVideos");
  }
  
  public void onPostRun()
  {
    AEQLog.a("AECirclePhotoListLogic", "onPostRun--serialCompressVideos");
  }
  
  public void onPreRun()
  {
    AEQLog.a("AECirclePhotoListLogic", "onPreRun--serialCompressVideos");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.13
 * JD-Core Version:    0.7.0.1
 */