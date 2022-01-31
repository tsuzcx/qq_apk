package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import bdnl;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;

class FriendProfileCardActivity$BlurBackgroundJob
  implements Runnable
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  
  FriendProfileCardActivity$BlurBackgroundJob(Handler paramHandler, Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void run()
  {
    Bitmap localBitmap = ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).b();
    }
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * 0.125F), (int)(((Bitmap)localObject).getHeight() * 0.125F), true);
      bdnl.a((Bitmap)localObject, 2);
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localObject);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.BlurBackgroundJob
 * JD-Core Version:    0.7.0.1
 */