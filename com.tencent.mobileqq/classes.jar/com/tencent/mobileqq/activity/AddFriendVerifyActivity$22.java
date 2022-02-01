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

class AddFriendVerifyActivity$22
  extends Handler
{
  AddFriendVerifyActivity$22(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        QQToast.a(this.a.getApplicationContext(), 1, 2131720148, 0).b(this.a.getTitleBarHeight());
        return;
      }
      if (this.a.isFinishing()) {
        return;
      }
      if (TextUtils.isEmpty(AddFriendVerifyActivity.c(this.a))) {}
    }
    try
    {
      paramMessage = new File(AddFriendVerifyActivity.d(this.a)).toURL();
      AddFriendVerifyActivity.a(this.a).setImageDrawable(URLDrawable.getDrawable(paramMessage, 100, 100));
    }
    catch (MalformedURLException paramMessage)
    {
      label110:
      break label110;
    }
    if (AddFriendVerifyActivity.a(this.a) != null)
    {
      AddFriendVerifyActivity.a(this.a).setVisibility(8);
      return;
      if (this.a.isFinishing()) {
        return;
      }
      if (AddFriendVerifyActivity.a(this.a) != null)
      {
        AddFriendVerifyActivity.a(this.a).setVisibility(0);
        ((Animatable)AddFriendVerifyActivity.a(this.a).getDrawable()).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.22
 * JD-Core Version:    0.7.0.1
 */