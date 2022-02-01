package com.tencent.aelight.camera.util.api.impl;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aeeditor.util.AEEditorJumpUtil;
import com.tencent.aelight.camera.util.api.IAEEditorJumpUtil;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;

public class AEEditorJumpUtilImpl
  implements IAEEditorJumpUtil
{
  public void picChooseJump(int paramInt, @Nullable Activity paramActivity, @Nullable PhotoCommonBaseData paramPhotoCommonBaseData, boolean paramBoolean)
  {
    AEEditorJumpUtil.a(paramInt, paramActivity, paramPhotoCommonBaseData, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.AEEditorJumpUtilImpl
 * JD-Core Version:    0.7.0.1
 */