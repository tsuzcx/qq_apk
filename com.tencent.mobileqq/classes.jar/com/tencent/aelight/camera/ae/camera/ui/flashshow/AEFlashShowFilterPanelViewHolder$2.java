package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

class AEFlashShowFilterPanelViewHolder$2
  implements Observer<AEFlashSHOWFilterViewModel.FilterSeekBarData>
{
  AEFlashShowFilterPanelViewHolder$2(AEFlashShowFilterPanelViewHolder paramAEFlashShowFilterPanelViewHolder) {}
  
  public void a(AEFlashSHOWFilterViewModel.FilterSeekBarData paramFilterSeekBarData)
  {
    AEFlashShowFilterPanelViewHolder.a(this.a, paramFilterSeekBarData.b, paramFilterSeekBarData.a);
    paramFilterSeekBarData = (MetaMaterial)AEFlashShowFilterPanelViewHolder.a(this.a).a().getValue();
    if ((paramFilterSeekBarData != null) && (paramFilterSeekBarData.id != null) && (!"".equals(paramFilterSeekBarData.id))) {
      AEFlashShowFilterPanelViewHolder.b(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterPanelViewHolder.2
 * JD-Core Version:    0.7.0.1
 */