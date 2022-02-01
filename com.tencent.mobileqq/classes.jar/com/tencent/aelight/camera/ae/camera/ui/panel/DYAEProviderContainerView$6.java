package com.tencent.aelight.camera.ae.camera.ui.panel;

import org.jetbrains.annotations.NotNull;

class DYAEProviderContainerView$6
  implements DYAEEffectListHolder.ItemClickListener
{
  DYAEProviderContainerView$6(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void a(@NotNull DYAEEffectItem paramDYAEEffectItem, int paramInt)
  {
    if ((paramDYAEEffectItem instanceof DYAESecondaryBeautyItem))
    {
      paramDYAEEffectItem = ((DYAESecondaryBeautyItem)paramDYAEEffectItem).g();
      if (DYAEProviderContainerView.j(this.a) != null) {
        DYAEProviderContainerView.j(this.a).a(paramDYAEEffectItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.6
 * JD-Core Version:    0.7.0.1
 */