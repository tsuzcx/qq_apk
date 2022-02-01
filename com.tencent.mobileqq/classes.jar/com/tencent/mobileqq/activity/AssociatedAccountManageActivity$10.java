package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable;

class AssociatedAccountManageActivity$10
  implements Runnable
{
  AssociatedAccountManageActivity$10(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, String paramString, View paramView) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.this$0.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368603);
      if (localImageView != null) {
        localImageView.setImageDrawable(localFaceDrawable);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.10
 * JD-Core Version:    0.7.0.1
 */