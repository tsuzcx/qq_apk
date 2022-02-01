package com.tencent.aelight.camera.aeeditor.manage;

import android.os.Bundle;
import eipc.EIPCResult;

class AEEditorEffectIpcModule$1
  implements AEEditorEffectConfigManager.IEffectGroupListBack
{
  AEEditorEffectIpcModule$1(AEEditorEffectIpcModule paramAEEditorEffectIpcModule, int paramInt) {}
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("effect_group_json_path", paramString);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectIpcModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectIpcModule.1
 * JD-Core Version:    0.7.0.1
 */