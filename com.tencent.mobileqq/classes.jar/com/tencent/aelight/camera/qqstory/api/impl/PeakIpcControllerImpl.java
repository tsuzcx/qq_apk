package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.mobileqq.data.MessageRecord;

public class PeakIpcControllerImpl
  implements IPeakIpcController
{
  public void report(String paramString1, String paramString2)
  {
    PeakIpcController.a(paramString1, paramString2);
  }
  
  public void report(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    PeakIpcController.a(paramString1, paramString2, paramString3, paramLong, paramString4);
  }
  
  public void updatePeakVideoAndPicStatus(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    PeakIpcController.a(paramMessageRecord, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.PeakIpcControllerImpl
 * JD-Core Version:    0.7.0.1
 */