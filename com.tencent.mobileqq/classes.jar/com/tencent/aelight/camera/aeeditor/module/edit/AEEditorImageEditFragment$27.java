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
    if (AEEditorImageEditFragment.a(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.a(this.this$0).toString();
    }
    put("filterId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.c(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.c(this.this$0).toString();
    }
    put("frameId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.b(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.b(this.this$0).toString();
    }
    put("stickerId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.d(this.this$0) == null) {
      paramAEEditorImageEditFragment = "none";
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.d(this.this$0).toString();
    }
    put("ImageTemplateId", paramAEEditorImageEditFragment);
    if (AEEditorImageEditFragment.e(this.this$0) == null) {
      paramAEEditorImageEditFragment = paramString;
    } else {
      paramAEEditorImageEditFragment = AEEditorImageEditFragment.e(this.this$0).toString();
    }
    put("textId", paramAEEditorImageEditFragment);
    put("cropId", this.val$finalCropInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.27
 * JD-Core Version:    0.7.0.1
 */