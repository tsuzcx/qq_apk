package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;

class AEResManager$5
  extends RunnableTask
{
  AEResManager$5(AEResManager paramAEResManager, BaseQQAppInterface paramBaseQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramBaseQQAppInterface, paramString, paramRunnable, paramLong);
  }
  
  protected void realCancel()
  {
    AEQLog.b("AEResManager", "[startPreDownLoad], preDownloadTask.realCancel()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResManager.5
 * JD-Core Version:    0.7.0.1
 */