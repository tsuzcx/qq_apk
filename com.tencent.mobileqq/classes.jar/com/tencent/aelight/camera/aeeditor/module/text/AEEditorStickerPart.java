package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qcircle.tavcut.bean.TextEditorData;

public class AEEditorStickerPart
{
  private AEEditorTextEditDialog a;
  private AEEditorStickerPart.AEEditorTextDialogListener b;
  
  private TextEditorData a(TextEditorData paramTextEditorData, Integer paramInteger)
  {
    if (paramTextEditorData == null) {
      return new TextEditorData();
    }
    return new TextEditorData(paramTextEditorData.getUniqueID(), paramTextEditorData.getItemID(), paramTextEditorData.getTextColor(), paramTextEditorData.getContent(), paramTextEditorData.getPagFilePath(), paramTextEditorData.getFontPath(), paramInteger.intValue());
  }
  
  private void b()
  {
    AEEditorTextEditDialog localAEEditorTextEditDialog = this.a;
    if (localAEEditorTextEditDialog != null) {
      localAEEditorTextEditDialog.setOnDismissListener(new AEEditorStickerPart.2(this));
    }
  }
  
  public void a()
  {
    AEEditorTextEditDialog localAEEditorTextEditDialog = this.a;
    if (localAEEditorTextEditDialog != null) {
      localAEEditorTextEditDialog.a();
    }
  }
  
  public void a(Context paramContext, @NonNull MetaMaterial paramMetaMaterial, TextEditorData paramTextEditorData)
  {
    if (!"fixed_text".equals(TextMetaMaterialKt.b(paramMetaMaterial)))
    {
      if ("blur".equals(TextMetaMaterialKt.b(paramMetaMaterial))) {
        return;
      }
      AEEditorTextEditDialog localAEEditorTextEditDialog = this.a;
      if ((localAEEditorTextEditDialog != null) && (localAEEditorTextEditDialog.isShowing())) {
        return;
      }
      this.a = new AEEditorTextEditDialog(paramContext, 2131951619, new AEEditorStickerPart.1(this));
      b();
      int j = 0;
      int i;
      if (paramTextEditorData != null)
      {
        j = TextEditorDataExKt.a(paramTextEditorData);
        if ("color_text".equals(TextMetaMaterialKt.b(paramMetaMaterial))) {
          i = j;
        } else {
          i = paramTextEditorData.getTextColor();
        }
      }
      else
      {
        i = 0;
      }
      paramContext = a(paramTextEditorData, Integer.valueOf(j));
      this.a.a(paramContext, i);
      this.a.show();
    }
  }
  
  public void a(AEEditorStickerPart.AEEditorTextDialogListener paramAEEditorTextDialogListener)
  {
    this.b = paramAEEditorTextDialogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart
 * JD-Core Version:    0.7.0.1
 */