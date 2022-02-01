package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEBottomListAdapter$4
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEBottomListAdapter$4(AEBottomListAdapter paramAEBottomListAdapter) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (AEBottomListAdapter.g(this.a) != null))
    {
      if ((paramAEMaterialMetaData.m.equals(AEBottomListAdapter.c(this.a).b())) && (paramAEMaterialMetaData.m.equals(AEBottomListAdapter.g(this.a).m)))
      {
        AEBottomListAdapter.i(this.a);
        AEBottomListAdapter localAEBottomListAdapter = this.a;
        AEBottomListAdapter.a(localAEBottomListAdapter, AEBottomListAdapter.g(localAEBottomListAdapter));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.2(this, paramAEMaterialMetaData));
    }
    else
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.1(this, paramAEMaterialMetaData));
    }
    VSReporter.a("record_decoration_download", VSReporter.a(paramBoolean ^ true, System.currentTimeMillis() - paramAEMaterialMetaData.D, paramAEMaterialMetaData.r, paramAEMaterialMetaData.E, paramAEMaterialMetaData.m));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.3(this, paramAEMaterialMetaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4
 * JD-Core Version:    0.7.0.1
 */