package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.FaceDrawable;

class AccountManageActivity$31
  implements Runnable
{
  AccountManageActivity$31(AccountManageActivity paramAccountManageActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.this$0.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ((ImageView)this.this$0.a.getChildAt(this.jdField_a_of_type_Int).findViewById(2131368603)).setImageDrawable(localFaceDrawable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.31
 * JD-Core Version:    0.7.0.1
 */