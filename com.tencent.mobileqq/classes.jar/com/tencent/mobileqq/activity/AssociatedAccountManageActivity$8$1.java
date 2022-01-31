package com.tencent.mobileqq.activity;

import aakn;
import android.view.View;
import android.widget.ImageView;
import baxt;

public class AssociatedAccountManageActivity$8$1
  implements Runnable
{
  public AssociatedAccountManageActivity$8$1(aakn paramaakn, String paramString, View paramView) {}
  
  public void run()
  {
    try
    {
      baxt localbaxt = baxt.a(this.jdField_a_of_type_Aakn.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367679);
      if (localImageView != null) {
        localImageView.setImageDrawable(localbaxt);
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
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8.1
 * JD-Core Version:    0.7.0.1
 */