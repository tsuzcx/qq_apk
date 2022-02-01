package com.tencent.aelight.camera.aeeditor.module.edit;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;

class AEEditorImageEditFragment$12
  implements StickerOperationCallback
{
  AEEditorImageEditFragment$12(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onAddStickerDone(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramString);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramString);
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a();
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a();
    ViewUtils.b(AEEditorImageEditFragment.a(this.a), 0);
  }
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    int i;
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramTextEditorData.getItemID()) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0)
      {
        onStickerSelect(paramTextEditorData);
        return;
      }
      onTextEditButtonClick(paramTextEditorData);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.getVisibility() != 0)
    {
      onStickerSelect(paramTextEditorData);
      return;
    }
    onTextEditButtonClick(paramTextEditorData);
  }
  
  public void onStickerMoving(String paramString) {}
  
  public void onStickerOutsideClick()
  {
    AEEditorImageEditFragment.d(this.a);
    AEQLog.a("AEEditorImageEditFragment", "[onStickerOutsideClick]textEditorData = null");
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramTextEditorData.getItemID()) != null)
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122562);
      this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramTextEditorData);
    }
    else if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramTextEditorData.getItemID()) != null)
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122349);
      this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramTextEditorData);
    }
    ViewUtils.b(AEEditorImageEditFragment.a(this.a), 4);
    AEEditorImageEditFragment.a(this.a).setScrollable(false);
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      if (this.a.c) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramTextEditorData.getItemID()) != null)
      {
        this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122562);
        this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(null);
        this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramTextEditorData);
        if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.getVisibility() != 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(0, 2000L);
        }
      }
      else if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramTextEditorData.getItemID()) != null)
      {
        this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122349);
        this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(null);
        this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramTextEditorData);
        if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(0, 2000L);
        }
      }
    }
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return;
    }
    MetaMaterial localMetaMaterial2 = this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramTextEditorData.getItemID());
    MetaMaterial localMetaMaterial1 = localMetaMaterial2;
    if (localMetaMaterial2 == null) {
      localMetaMaterial1 = this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramTextEditorData.getItemID());
    }
    if (localMetaMaterial1 != null) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerPart.a(this.a.getActivity(), localMetaMaterial1, paramTextEditorData);
    }
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUpdateTextStickerDone] uniqueId:");
    localStringBuilder.append(paramString);
    AEQLog.d("AEEditorImageEditFragment", localStringBuilder.toString());
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(paramString);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.12
 * JD-Core Version:    0.7.0.1
 */