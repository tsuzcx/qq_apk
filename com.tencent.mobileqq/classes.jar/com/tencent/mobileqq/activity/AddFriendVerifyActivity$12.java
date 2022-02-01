package com.tencent.mobileqq.activity;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;

class AddFriendVerifyActivity$12
  implements URLDrawable.URLDrawableListener
{
  AddFriendVerifyActivity$12(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = ImageUtil.a(paramURLDrawable);
      QQAppInterface localQQAppInterface = this.a.app;
      paramURLDrawable = QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
      this.a.a.setImageDrawable(new BitmapDrawable(paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.12
 * JD-Core Version:    0.7.0.1
 */