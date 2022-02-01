package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

class AEARCakeMaterialManager$3$2
  implements Runnable
{
  AEARCakeMaterialManager$3$2(AEARCakeMaterialManager.3 param3, AEMaterialMetaData paramAEMaterialMetaData, int paramInt) {}
  
  public void run()
  {
    if (this.c.a.a != null) {
      this.c.a.a.notifyItemChanged(0, Integer.valueOf(1));
    }
    if (AEARCakeMaterialManager.a(this.c.a) != null) {
      AEARCakeMaterialManager.a(this.c.a).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.3.2
 * JD-Core Version:    0.7.0.1
 */