package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialPanel$closeContainer$1
  implements Runnable
{
  AEFlashShowMaterialPanel$closeContainer$1(Activity paramActivity) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    this.a.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialPanel.closeContainer.1
 * JD-Core Version:    0.7.0.1
 */