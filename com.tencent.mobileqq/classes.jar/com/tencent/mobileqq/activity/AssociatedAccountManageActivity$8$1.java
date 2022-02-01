package com.tencent.mobileqq.activity;

import acti;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class AssociatedAccountManageActivity$8$1
  implements Runnable
{
  public AssociatedAccountManageActivity$8$1(acti paramacti, String paramString, View paramView) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_Acti.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368236);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8.1
 * JD-Core Version:    0.7.0.1
 */