package com.tencent.mobileqq.activity;

import acnv;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class AccountManageActivity$25$1
  implements Runnable
{
  public AccountManageActivity$25$1(acnv paramacnv, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_Acnv.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ((ImageView)this.jdField_a_of_type_Acnv.a.a.getChildAt(this.jdField_a_of_type_Int).findViewById(2131368236)).setImageDrawable(localFaceDrawable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.25.1
 * JD-Core Version:    0.7.0.1
 */