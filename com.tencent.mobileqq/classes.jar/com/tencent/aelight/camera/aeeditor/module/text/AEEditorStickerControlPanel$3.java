package com.tencent.aelight.camera.aeeditor.module.text;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AEEditorStickerControlPanel$3
  extends BottomSheetBehavior.BottomSheetCallback
{
  AEEditorStickerControlPanel$3(AEEditorStickerControlPanel paramAEEditorStickerControlPanel) {}
  
  public void onSlide(@NonNull View paramView, float paramFloat) {}
  
  public void onStateChanged(@NonNull View paramView, int paramInt)
  {
    if (paramInt == 3) {
      AEReportUtils.d(AEEditorStickerControlPanel.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel.3
 * JD-Core Version:    0.7.0.1
 */