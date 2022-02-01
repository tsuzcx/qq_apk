package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import java.util.HashMap;

class AccountManageActivity$14$1
  implements Runnable
{
  AccountManageActivity$14$1(AccountManageActivity.14 param14, boolean paramBoolean, String paramString, Bitmap paramBitmap, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.e.a == this.e.this$0.app)
    {
      if (this.e.a == null) {
        return;
      }
      if (this.a)
      {
        this.e.e.setText(this.b);
        AccountManageActivity.g(this.e.this$0).put(this.e.b, this.b);
      }
      if ((this.e.f.getDrawable() != null) && ((this.e.f.getDrawable() instanceof FaceDrawable))) {
        ((FaceDrawable)this.e.f.getDrawable()).cancel();
      }
      if (this.c != null)
      {
        this.e.f.setImageBitmap(this.c);
        return;
      }
      this.e.f.setImageDrawable(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14.1
 * JD-Core Version:    0.7.0.1
 */