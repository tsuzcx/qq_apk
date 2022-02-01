package com.tencent.aelight.camera.aeeditor.module.edit;

import android.text.TextUtils;
import java.util.HashMap;

class AEEditorVideoEditFragment$21
  extends HashMap<String, String>
{
  AEEditorVideoEditFragment$21(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    boolean bool = TextUtils.isEmpty(this.val$shuiyinId);
    paramString1 = "none";
    if (bool) {
      paramAEEditorVideoEditFragment = "none";
    } else {
      paramAEEditorVideoEditFragment = this.val$shuiyinId;
    }
    put("shuiyinId", paramAEEditorVideoEditFragment);
    if (TextUtils.isEmpty(this.val$guajianId)) {
      paramAEEditorVideoEditFragment = "none";
    } else {
      paramAEEditorVideoEditFragment = this.val$guajianId;
    }
    put("guajianId", paramAEEditorVideoEditFragment);
    if (TextUtils.isEmpty(this.val$currentFilterReport)) {
      paramAEEditorVideoEditFragment = "none";
    } else {
      paramAEEditorVideoEditFragment = this.val$currentFilterReport;
    }
    put("filterId", paramAEEditorVideoEditFragment);
    if (TextUtils.isEmpty(this.val$currentStickerReport)) {
      paramAEEditorVideoEditFragment = "none";
    } else {
      paramAEEditorVideoEditFragment = this.val$currentStickerReport;
    }
    put("stickerId", paramAEEditorVideoEditFragment);
    if (TextUtils.isEmpty(this.val$currentTextReport)) {
      paramAEEditorVideoEditFragment = "none";
    } else {
      paramAEEditorVideoEditFragment = this.val$currentTextReport;
    }
    put("textId", paramAEEditorVideoEditFragment);
    if (TextUtils.isEmpty(this.val$currentMusicReport)) {
      paramAEEditorVideoEditFragment = "none";
    } else {
      paramAEEditorVideoEditFragment = this.val$currentMusicReport;
    }
    put("musicId", paramAEEditorVideoEditFragment);
    if (TextUtils.isEmpty(this.val$currentTemplateReport)) {
      paramAEEditorVideoEditFragment = paramString1;
    } else {
      paramAEEditorVideoEditFragment = this.val$currentTemplateReport;
    }
    put("templateId", paramAEEditorVideoEditFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.21
 * JD-Core Version:    0.7.0.1
 */