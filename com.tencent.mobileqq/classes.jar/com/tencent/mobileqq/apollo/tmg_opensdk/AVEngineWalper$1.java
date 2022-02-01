package com.tencent.mobileqq.apollo.tmg_opensdk;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AVEngineWalper$1
  extends TMG_Downloader.TMG_Downloader_DownloadEvent
{
  AVEngineWalper$1(AVEngineWalper paramAVEngineWalper) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      ThreadManager.getUIHandler().post(new AVEngineWalper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.1
 * JD-Core Version:    0.7.0.1
 */