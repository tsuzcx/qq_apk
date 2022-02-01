package com.tencent.mobileqq.app.msgnotify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;

class MsgNotifyPushDialog$4
  implements Runnable
{
  MsgNotifyPushDialog$4(MsgNotifyPushDialog paramMsgNotifyPushDialog) {}
  
  public void run()
  {
    int i = 0;
    AnimationDrawable localAnimationDrawable;
    if (this.this$0.isShowing())
    {
      MsgNotifyPushDialog.a(this.this$0, true);
      localAnimationDrawable = new AnimationDrawable();
    }
    try
    {
      long l1 = System.currentTimeMillis();
      while (i < MsgNotifyPushDialog.jdField_a_of_type_Int)
      {
        Bitmap localBitmap = BitmapManager.a(String.format(MsgNotifyPushDialog.c + MsgNotifyPushDialog.e, new Object[] { Integer.valueOf(i) }));
        localAnimationDrawable.addFrame(new BitmapDrawable(MsgNotifyPushDialog.a(this.this$0).getResources(), localBitmap), 1000 / MsgNotifyPushDialog.jdField_a_of_type_Int);
        i += 1;
      }
      localAnimationDrawable.setOneShot(true);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(MsgNotifyPushDialog.jdField_a_of_type_JavaLangString, 2, new Object[] { "Frame Animation decode cost ", Long.valueOf(l2 - l1) });
      }
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new MsgNotifyPushDialog.4.1(this, localAnimationDrawable), 500L);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.4
 * JD-Core Version:    0.7.0.1
 */