package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;

public class EditPicForQzoneImpl
  implements IEditPicForQzone
{
  public Intent newPictureEditIntentWithoutPublish(Activity paramActivity, String paramString)
  {
    return QzoneEditPictureActivity.a(paramActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.EditPicForQzoneImpl
 * JD-Core Version:    0.7.0.1
 */