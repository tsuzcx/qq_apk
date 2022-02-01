package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import mqq.util.WeakReference;

class AEPlayMaterialDownloadWrap$2
  implements Runnable
{
  AEPlayMaterialDownloadWrap$2(AEPlayMaterialDownloadWrap paramAEPlayMaterialDownloadWrap, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    if (this.val$item.P == 0)
    {
      if ((AEPlayMaterialDownloadWrap.access$200(this.this$0) != null) && (AEPlayMaterialDownloadWrap.access$200(this.this$0).get() != null))
      {
        AEPlayShowGridAdapter.selectedMidMaterial = this.val$item;
        ((VideoStoryCapturePartManager)AEPlayMaterialDownloadWrap.access$200(this.this$0).get()).b(393218, new Object[] { this.val$item });
      }
    }
    else if (((this.val$item.P == 4) || (this.val$item.P == 5) || (this.val$item.P == 6) || (this.val$item.P == 7)) && (AEPlayMaterialDownloadWrap.access$200(this.this$0) != null) && (AEPlayMaterialDownloadWrap.access$200(this.this$0).get() != null)) {
      ((VideoStoryCapturePartManager)AEPlayMaterialDownloadWrap.access$200(this.this$0).get()).b(655361, new Object[] { this.val$item });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayMaterialDownloadWrap.2
 * JD-Core Version:    0.7.0.1
 */