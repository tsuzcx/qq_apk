package com.tencent.aelight.camera.aeeditor.module.text;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.bean.TextEditorData;

class AEEditorStickerPart$1
  implements AEEditorTextEditDialog.AEEditorTextEditListener
{
  AEEditorStickerPart$1(AEEditorStickerPart paramAEEditorStickerPart) {}
  
  public void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      if (AEEditorStickerPart.a(this.a) != null) {
        AEEditorStickerPart.a(this.a).a(paramTextEditorData);
      }
    }
    else {
      AEQLog.d("AEEditorTextPart", "update text newTextEditorData is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart.1
 * JD-Core Version:    0.7.0.1
 */