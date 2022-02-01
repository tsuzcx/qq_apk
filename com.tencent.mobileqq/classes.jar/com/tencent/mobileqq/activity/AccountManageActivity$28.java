package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.FaceDrawable;

class AccountManageActivity$28
  implements Runnable
{
  AccountManageActivity$28(AccountManageActivity paramAccountManageActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.this$0.app, this.a, (byte)3);
      ((ImageView)this.this$0.a.getChildAt(this.b).findViewById(2131435219)).setImageDrawable(localFaceDrawable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.28
 * JD-Core Version:    0.7.0.1
 */