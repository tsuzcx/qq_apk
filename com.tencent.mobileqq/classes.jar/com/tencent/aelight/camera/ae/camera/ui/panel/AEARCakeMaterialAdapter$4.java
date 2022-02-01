package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

class AEARCakeMaterialAdapter$4
  implements Runnable
{
  AEARCakeMaterialAdapter$4(AEARCakeMaterialAdapter paramAEARCakeMaterialAdapter, int paramInt1, AEMaterialMetaData paramAEMaterialMetaData, int paramInt2) {}
  
  public void run()
  {
    this.this$0.notifyItemChanged(this.a, Integer.valueOf(1));
    AEARCakeMaterialManager.IARCakeDownloadListener localIARCakeDownloadListener = AEARCakeMaterialAdapter.a(this.this$0).e();
    if (localIARCakeDownloadListener != null) {
      localIARCakeDownloadListener.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.4
 * JD-Core Version:    0.7.0.1
 */