package com.tencent.aelight.camera.aeeditor.module.text;

import com.tencent.qcircle.tavcut.bean.TextEditorData;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;

class AEEditorTextEditDialog$5
  implements Runnable
{
  AEEditorTextEditDialog$5(AEEditorTextEditDialog paramAEEditorTextEditDialog, PAGFile paramPAGFile, TextEditorData paramTextEditorData, PAGText paramPAGText) {}
  
  public void run()
  {
    if (this.a != AEEditorTextEditDialog.a(this.this$0).getComposition()) {
      AEEditorTextEditDialog.a(this.this$0).setComposition(this.a);
    }
    PAGFont localPAGFont = AEEditorTextEditDialog.a(this.this$0, this.b);
    if (localPAGFont != null)
    {
      this.c.fontStyle = localPAGFont.fontStyle;
      this.c.fontFamily = localPAGFont.fontFamily;
    }
    this.a.replaceText(0, this.c);
    AEEditorTextEditDialog.a(AEEditorTextEditDialog.d(this.this$0).getColorList(), AEEditorTextEditDialog.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextEditDialog.5
 * JD-Core Version:    0.7.0.1
 */