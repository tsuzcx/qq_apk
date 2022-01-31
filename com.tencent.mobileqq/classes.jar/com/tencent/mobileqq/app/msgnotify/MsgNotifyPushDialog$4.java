package com.tencent.mobileqq.app.msgnotify;

import amij;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import bcwc;
import com.tencent.qphone.base.util.QLog;

public class MsgNotifyPushDialog$4
  implements Runnable
{
  public MsgNotifyPushDialog$4(amij paramamij) {}
  
  public void run()
  {
    int i = 0;
    AnimationDrawable localAnimationDrawable;
    if (this.this$0.isShowing())
    {
      amij.a(this.this$0, true);
      localAnimationDrawable = new AnimationDrawable();
    }
    try
    {
      long l1 = System.currentTimeMillis();
      while (i < amij.jdField_a_of_type_Int)
      {
        Bitmap localBitmap = bcwc.a(String.format(amij.c + amij.e, new Object[] { Integer.valueOf(i) }));
        localAnimationDrawable.addFrame(new BitmapDrawable(amij.a(this.this$0).getResources(), localBitmap), 1000 / amij.jdField_a_of_type_Int);
        i += 1;
      }
      localAnimationDrawable.setOneShot(true);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(amij.jdField_a_of_type_JavaLangString, 2, new Object[] { "Frame Animation decode cost ", Long.valueOf(l2 - l1) });
      }
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new MsgNotifyPushDialog.4.1(this, localAnimationDrawable), 500L);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.4
 * JD-Core Version:    0.7.0.1
 */