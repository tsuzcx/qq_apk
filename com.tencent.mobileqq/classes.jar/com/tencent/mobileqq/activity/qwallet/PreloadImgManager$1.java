package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import mqq.os.MqqHandler;

class PreloadImgManager$1
  extends DownloadListener
{
  PreloadImgManager$1(PreloadImgManager paramPreloadImgManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    ThreadManager.getFileThreadHandler().post(new PreloadImgManager.1.1(this, paramDownloadTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1
 * JD-Core Version:    0.7.0.1
 */