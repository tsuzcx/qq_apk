package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.util.PicChooseJumpUtil;
import java.util.HashMap;
import org.light.MaterialConfig;

class AECaptureCustomMaterialPart$1
  implements View.OnClickListener
{
  AECaptureCustomMaterialPart$1(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart) {}
  
  public void onClick(View paramView)
  {
    if ((AECaptureCustomMaterialPart.a(this.a) != null) && (AECaptureCustomMaterialPart.b(this.a).containsKey(AECaptureCustomMaterialPart.a(this.a).m)))
    {
      paramView = ((AECaptureCustomMaterialPart.MaterialConfigWrapper)AECaptureCustomMaterialPart.b(this.a).get(AECaptureCustomMaterialPart.a(this.a).m)).a;
      if (paramView != null)
      {
        boolean bool;
        if ((paramView.aiFilterList != null) && (paramView.aiFilterList.containsKey("ai.face"))) {
          bool = true;
        } else {
          bool = false;
        }
        PicChooseJumpUtil.a(AECaptureCustomMaterialPart.c(this.a), 1027, bool, paramView.minImageWidth, paramView.minImageHeight);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.1
 * JD-Core Version:    0.7.0.1
 */