package com.tencent.mobileqq.activity;

import adnh;
import android.view.View;
import android.widget.ImageView;
import aoch;

public class AssociatedAccountManageActivity$8$1
  implements Runnable
{
  public AssociatedAccountManageActivity$8$1(adnh paramadnh, String paramString, View paramView) {}
  
  public void run()
  {
    try
    {
      aoch localaoch = aoch.a(this.jdField_a_of_type_Adnh.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368138);
      if (localImageView != null) {
        localImageView.setImageDrawable(localaoch);
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