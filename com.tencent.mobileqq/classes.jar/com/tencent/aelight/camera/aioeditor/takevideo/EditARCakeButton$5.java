package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;

class EditARCakeButton$5
  implements Runnable
{
  EditARCakeButton$5(EditARCakeButton paramEditARCakeButton, boolean paramBoolean) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      int i;
      if (this.a) {
        i = 2;
      } else {
        i = 1;
      }
      Resources localResources = localActivity.getResources();
      int j;
      if (this.a) {
        j = 2064515314;
      } else {
        j = 2064515313;
      }
      QQToast.a(localActivity, i, localResources.getString(j), 0).b(localActivity.getResources().getDimensionPixelSize(2063991155));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.5
 * JD-Core Version:    0.7.0.1
 */