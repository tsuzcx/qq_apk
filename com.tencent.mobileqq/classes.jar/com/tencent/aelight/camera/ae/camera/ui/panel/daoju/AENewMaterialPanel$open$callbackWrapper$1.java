package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AENewMaterialPanel$open$callbackWrapper$1
  implements Runnable
{
  AENewMaterialPanel$open$callbackWrapper$1(AENewMaterialPanel paramAENewMaterialPanel, Runnable paramRunnable, String paramString1, String paramString2) {}
  
  public final void run()
  {
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      localRunnable.run();
    }
    if (this.b != null) {
      this.this$0.post((Runnable)new AENewMaterialPanel.open.callbackWrapper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.open.callbackWrapper.1
 * JD-Core Version:    0.7.0.1
 */