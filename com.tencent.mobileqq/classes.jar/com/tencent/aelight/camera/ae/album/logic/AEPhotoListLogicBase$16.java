package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class AEPhotoListLogicBase$16
  implements ThreadExcutor.IThreadListener
{
  AEPhotoListLogicBase$16(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void onAdded()
  {
    AEQLog.a("AEPhotoListLogicBase", "onAdded--serialCompressVideos");
  }
  
  public void onPostRun()
  {
    AEQLog.a("AEPhotoListLogicBase", "onPostRun--serialCompressVideos");
  }
  
  public void onPreRun()
  {
    AEQLog.a("AEPhotoListLogicBase", "onPreRun--serialCompressVideos");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.16
 * JD-Core Version:    0.7.0.1
 */