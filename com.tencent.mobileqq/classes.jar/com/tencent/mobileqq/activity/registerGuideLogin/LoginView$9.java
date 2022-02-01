package com.tencent.mobileqq.activity.registerGuideLogin;

import android.widget.ImageView;
import com.tencent.mobileqq.widget.ConfigClearableEditText.CustomClearButtonCallback;

class LoginView$9
  implements ConfigClearableEditText.CustomClearButtonCallback
{
  LoginView$9(LoginView paramLoginView, ImageView paramImageView, int paramInt) {}
  
  public int a()
  {
    return this.b;
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.a;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setAlpha(0.5F);
      return;
    }
    this.a.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.9
 * JD-Core Version:    0.7.0.1
 */