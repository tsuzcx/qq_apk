package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.tavcut.bean.TextEditorData;

public class AEEditorStickerPart
{
  private AEEditorStickerPart.AEEditorTextDialogListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerPart$AEEditorTextDialogListener;
  private AEEditorTextEditDialog jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog;
  
  private TextEditorData a(TextEditorData paramTextEditorData, Integer paramInteger)
  {
    if (paramTextEditorData == null) {
      return new TextEditorData();
    }
    return new TextEditorData(paramTextEditorData.getUniqueID(), paramTextEditorData.getItemID(), paramTextEditorData.getTextColor(), paramTextEditorData.getContent(), paramTextEditorData.getPagFilePath(), paramTextEditorData.getFontPath(), paramInteger.intValue());
  }
  
  private void b()
  {
    AEEditorTextEditDialog localAEEditorTextEditDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog;
    if (localAEEditorTextEditDialog != null) {
      localAEEditorTextEditDialog.setOnDismissListener(new AEEditorStickerPart.2(this));
    }
  }
  
  public void a()
  {
    AEEditorTextEditDialog localAEEditorTextEditDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog;
    if (localAEEditorTextEditDialog != null) {
      localAEEditorTextEditDialog.a();
    }
  }
  
  public void a(Context paramContext, @NonNull MetaMaterial paramMetaMaterial, TextEditorData paramTextEditorData)
  {
    if (!"fixed_text".equals(TextMetaMaterialKt.a(paramMetaMaterial)))
    {
      if ("blur".equals(TextMetaMaterialKt.a(paramMetaMaterial))) {
        return;
      }
      AEEditorTextEditDialog localAEEditorTextEditDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog;
      if ((localAEEditorTextEditDialog != null) && (localAEEditorTextEditDialog.isShowing())) {
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog = new AEEditorTextEditDialog(paramContext, 2131755011, new AEEditorStickerPart.1(this));
      b();
      int j = 0;
      int i;
      if (paramTextEditorData != null)
      {
        j = TextEditorDataExKt.a(paramTextEditorData);
        if ("color_text".equals(TextMetaMaterialKt.a(paramMetaMaterial))) {
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
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog.a(paramContext, i);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog.show();
    }
  }
  
  public void a(AEEditorStickerPart.AEEditorTextDialogListener paramAEEditorTextDialogListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerPart$AEEditorTextDialogListener = paramAEEditorTextDialogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart
 * JD-Core Version:    0.7.0.1
 */