package com.tencent.mobileqq.apollo.process.data;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class CmGameAppInterface$1
  implements TVK_SDKMgr.InstallListener
{
  CmGameAppInterface$1(CmGameAppInterface paramCmGameAppInterface) {}
  
  public void onInstallProgress(float paramFloat)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onInstallProgress] v:" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onInstalledFailed], i:" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onInstalledSuccessed]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface.1
 * JD-Core Version:    0.7.0.1
 */