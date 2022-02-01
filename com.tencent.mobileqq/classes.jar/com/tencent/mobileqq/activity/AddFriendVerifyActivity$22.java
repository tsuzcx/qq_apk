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
        QQToast.makeText(this.a.getApplicationContext(), 1, 2131917778, 0).show(this.a.getTitleBarHeight());
        return;
      }
      if (this.a.isFinishing()) {
        return;
      }
      if (TextUtils.isEmpty(AddFriendVerifyActivity.u(this.a))) {}
    }
    try
    {
      paramMessage = new File(AddFriendVerifyActivity.v(this.a)).toURL();
      AddFriendVerifyActivity.w(this.a).setImageDrawable(URLDrawable.getDrawable(paramMessage, 100, 100));
    }
    catch (MalformedURLException paramMessage)
    {
      label110:
      break label110;
    }
    if (AddFriendVerifyActivity.t(this.a) != null)
    {
      AddFriendVerifyActivity.t(this.a).setVisibility(8);
      return;
      if (this.a.isFinishing()) {
        return;
      }
      if (AddFriendVerifyActivity.t(this.a) != null)
      {
        AddFriendVerifyActivity.t(this.a).setVisibility(0);
        ((Animatable)AddFriendVerifyActivity.t(this.a).getDrawable()).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.22
 * JD-Core Version:    0.7.0.1
 */