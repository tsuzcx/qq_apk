package com.tencent.aelight.camera.ae.download.old;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;

class AEOldResManager$9
  extends RunnableTask
{
  AEOldResManager$9(AEOldResManager paramAEOldResManager, BaseQQAppInterface paramBaseQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramBaseQQAppInterface, paramString, paramRunnable, paramLong);
  }
  
  protected void realCancel()
  {
    AEQLog.b("AEOldResManager", "[startPreDownLoad], preDownloadTask.realCancel()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldResManager.9
 * JD-Core Version:    0.7.0.1
 */