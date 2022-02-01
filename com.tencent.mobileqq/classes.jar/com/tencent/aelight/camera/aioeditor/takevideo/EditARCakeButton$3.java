package com.tencent.aelight.camera.aioeditor.takevideo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper.AIOWXShareListener;

class EditARCakeButton$3
  implements IAIOShareHelper.AIOWXShareListener
{
  EditARCakeButton$3(EditARCakeButton paramEditARCakeButton) {}
  
  public void a(boolean paramBoolean, int paramInt, @NonNull String paramString, @NonNull AIOShareObject paramAIOShareObject)
  {
    if (TextUtils.equals(EditARCakeButton.a(this.a), paramString))
    {
      if (paramBoolean)
      {
        EditARCakeButton.b(this.a);
        return;
      }
      EditARCakeButton.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.3
 * JD-Core Version:    0.7.0.1
 */