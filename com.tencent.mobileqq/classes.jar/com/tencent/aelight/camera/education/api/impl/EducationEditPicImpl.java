package com.tencent.aelight.camera.education.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.education.api.IEducationEditPic;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;

public class EducationEditPicImpl
  implements IEducationEditPic
{
  public void startAnswerSearchPicEditActivity(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("qq_sub_business_id", 0);
    ((Bundle)localObject).putInt("entrance_type", 99);
    ((Bundle)localObject).putInt("pic_entrance_type", 0);
    if (paramBoolean) {
      paramString = new EditTakePhotoSource(paramString);
    } else {
      paramString = new EditLocalPhotoSource(paramString, new LocalMediaInfo());
    }
    paramString = new EditVideoParams(2, 4, paramString, (Bundle)localObject);
    localObject = new Intent(paramActivity, AnswerSearchEditPictureActivity.class);
    ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramString);
    paramActivity.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.EducationEditPicImpl
 * JD-Core Version:    0.7.0.1
 */