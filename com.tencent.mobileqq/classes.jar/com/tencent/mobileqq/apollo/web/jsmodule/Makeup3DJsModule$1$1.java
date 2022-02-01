package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class Makeup3DJsModule$1$1
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  Makeup3DJsModule$1$1(Makeup3DJsModule.1 param1, CmShowAssetsData paramCmShowAssetsData) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new Makeup3DJsModule.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.1.1
 * JD-Core Version:    0.7.0.1
 */