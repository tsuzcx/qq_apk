package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AEARCakeMaterialManager$3$1
  implements Runnable
{
  AEARCakeMaterialManager$3$1(AEARCakeMaterialManager.3 param3, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a != 200)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064187644), 1).show();
      return;
    }
    if ((this.b != null) && (this.c))
    {
      this.d.a.b.a(this.b);
      if (this.d.a.a != null) {
        this.d.a.a.notifyItemChanged(0, Integer.valueOf(1));
      }
      if (AEARCakeMaterialManager.a(this.d.a) != null)
      {
        AEARCakeMaterialManager.a(this.d.a).a(this.b);
        AEARCakeMaterialManager.a(this.d.a, true);
        AEARCakeMaterialManager.a(this.d.a, null);
      }
      return;
    }
    AEQLog.a("AEARCakeMaterialManager", "arcake : can not set material ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.3.1
 * JD-Core Version:    0.7.0.1
 */