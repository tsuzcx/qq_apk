package com.tencent.aelight.camera.ae.data;

import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.List;

class AEGifMaterialManager$2
  implements Runnable
{
  AEGifMaterialManager$2(AEGifMaterialManager paramAEGifMaterialManager) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (AEGifMaterialManager.a(this.this$0))
      {
        List localList = AEGifMaterialManager.b(this.this$0);
        if (!CollectionUtils.isEmpty(localList)) {
          AEGifMaterialManager.a(this.this$0, localList);
        }
        AEGifMaterialManager localAEGifMaterialManager = this.this$0;
        if (!CollectionUtils.isEmpty(localList))
        {
          bool = true;
          AEGifMaterialManager.a(localAEGifMaterialManager, bool);
          return;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager.2
 * JD-Core Version:    0.7.0.1
 */