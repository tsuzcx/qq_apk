package com.tencent.mobileqq.addfriend.ui;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;

class AddFriendVerifyFragment$12
  implements URLDrawable.URLDrawableListener
{
  AddFriendVerifyFragment$12(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = AvatarUtil.a(BaseImageUtil.a(paramURLDrawable), 50, 50);
      AddFriendVerifyFragment.i(this.a).setImageDrawable(new BitmapDrawable(paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.12
 * JD-Core Version:    0.7.0.1
 */