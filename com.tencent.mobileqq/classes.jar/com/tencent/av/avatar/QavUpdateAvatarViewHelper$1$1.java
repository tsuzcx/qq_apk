package com.tencent.av.avatar;

import android.graphics.Bitmap;
import android.widget.ImageView;

class QavUpdateAvatarViewHelper$1$1
  implements Runnable
{
  QavUpdateAvatarViewHelper$1$1(QavUpdateAvatarViewHelper.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QavUpdateAvatarViewHelper.b(this.b.a) != null) {
      QavUpdateAvatarViewHelper.b(this.b.a).setImageBitmap(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avatar.QavUpdateAvatarViewHelper.1.1
 * JD-Core Version:    0.7.0.1
 */