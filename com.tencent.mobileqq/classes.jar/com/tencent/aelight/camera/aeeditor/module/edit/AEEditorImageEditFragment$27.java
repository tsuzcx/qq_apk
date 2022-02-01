package com.tencent.aelight.camera.aeeditor.module.edit;

import android.os.Bundle;
import java.util.HashMap;

class AEEditorImageEditFragment$27
  extends HashMap<String, String>
{
  AEEditorImageEditFragment$27(AEEditorImageEditFragment paramAEEditorImageEditFragment, String paramString)
  {
    paramAEEditorImageEditFragment = this.this$0.getArguments();
    paramString = "none";
    if (paramAEEditorImageEditFragment == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = this.this$0.getArguments().getString("water_mark_id");
    }
    put("shuiyinId", paramAEEditorImageEditFragment);
    if (this.this$0.getArguments() == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = this.this$0.getArguments().getString("guajian_id");
    }
    put("guajianId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.F(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.F(this.this$0).toString();
    }
    put("filterId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.H(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.H(this.this$0).toString();
    }
    put("frameId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.G(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.G(this.this$0).toString();
    }
    put("stickerId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.I(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.I(this.this$0).toString();
    }
    put("ImageTemplateId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.J(this.this$0) == null) {
      paramAEEditorImageEditFragment = paramString;
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.J(this.this$0).toString();
    }
    put("textId", paramAEEditorImageEditFragment);
    put("cropId", this.val$finalCropInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.27
 * JD-Core Version:    0.7.0.1
 */