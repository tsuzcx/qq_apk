package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import mqq.util.WeakReference;

class PlayDownloadManagerWrap$2
  implements Runnable
{
  PlayDownloadManagerWrap$2(PlayDownloadManagerWrap paramPlayDownloadManagerWrap, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    if (this.val$item.h == 0)
    {
      if ((PlayDownloadManagerWrap.access$200(this.this$0) != null) && (PlayDownloadManagerWrap.access$200(this.this$0).get() != null))
      {
        AEPlayShowGridAdapter.selectedMidMaterial = this.val$item;
        ((VideoStoryCapturePartManager)PlayDownloadManagerWrap.access$200(this.this$0).get()).a(393218, new Object[] { this.val$item });
      }
    }
    else if (((this.val$item.h == 4) || (this.val$item.h == 5) || (this.val$item.h == 6) || (this.val$item.h == 7)) && (PlayDownloadManagerWrap.access$200(this.this$0) != null) && (PlayDownloadManagerWrap.access$200(this.this$0).get() != null)) {
      ((VideoStoryCapturePartManager)PlayDownloadManagerWrap.access$200(this.this$0).get()).a(655361, new Object[] { this.val$item });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */