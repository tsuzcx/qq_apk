package com.tencent.mobileqq.activity;

import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.net.MalformedURLException;

class AddFriendVerifyActivity$21
  extends Handler
{
  AddFriendVerifyActivity$21(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      if ((this.a.isFinishing()) || (AddFriendVerifyActivity.a(this.a) == null)) {
        continue;
      }
      AddFriendVerifyActivity.a(this.a).setVisibility(0);
      ((Animatable)AddFriendVerifyActivity.a(this.a).getDrawable()).start();
      return;
      if (this.a.isFinishing()) {
        continue;
      }
      if (!TextUtils.isEmpty(AddFriendVerifyActivity.c(this.a))) {}
      try
      {
        paramMessage = new File(AddFriendVerifyActivity.d(this.a)).toURL();
        AddFriendVerifyActivity.a(this.a).setImageDrawable(URLDrawable.getDrawable(paramMessage, 100, 100));
        label142:
        if (AddFriendVerifyActivity.a(this.a) == null) {
          continue;
        }
        AddFriendVerifyActivity.a(this.a).setVisibility(8);
        return;
        QQToast.a(this.a.getApplicationContext(), 1, 2131720409, 0).b(this.a.getTitleBarHeight());
        return;
      }
      catch (MalformedURLException paramMessage)
      {
        break label142;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.21
 * JD-Core Version:    0.7.0.1
 */