package com.tencent.mobileqq.apollo.api.player.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ApolloBrickPlayerImpl$BrickCMSPlayerListener$2
  implements Runnable
{
  ApolloBrickPlayerImpl$BrickCMSPlayerListener$2(ApolloBrickPlayerImpl.BrickCMSPlayerListener paramBrickCMSPlayerListener, int paramInt, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int != ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ApolloBrickPlayer", 2, "onRecordDone mActionId not same! current " + ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0) + " onRecordDone id " + this.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject = (ImageView)ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0, ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0));
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
    {
      localObject = (URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (((URLDrawable)localObject).getStatus() != 1) {
        break label154;
      }
      ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0);
    }
    for (;;)
    {
      localObject = (RelativeLayout)ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0, ApolloBrickPlayerImpl.BrickCMSPlayerListener.b(this.this$0));
      if (localObject == null) {
        break;
      }
      ((RelativeLayout)localObject).invalidate();
      return;
      label154:
      ((URLDrawable)localObject).setURLDrawableListener(ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0, this.jdField_a_of_type_JavaLangString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener.2
 * JD-Core Version:    0.7.0.1
 */