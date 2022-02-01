package com.tencent.mobileqq.apollo.player.api.impl;

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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecordDone mActionId not same! current ");
        ((StringBuilder)localObject).append(ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0));
        ((StringBuilder)localObject).append(" onRecordDone id ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.w("[cmshow]ApolloBrickPlayer", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.this$0;
    localObject = (ImageView)ApolloBrickPlayerImpl.BrickCMSPlayerListener.a((ApolloBrickPlayerImpl.BrickCMSPlayerListener)localObject, ApolloBrickPlayerImpl.BrickCMSPlayerListener.a((ApolloBrickPlayerImpl.BrickCMSPlayerListener)localObject));
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() == 1) {
        ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0);
      } else {
        ((URLDrawable)localObject).setURLDrawableListener(ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.this$0, this.jdField_a_of_type_JavaLangString));
      }
    }
    localObject = this.this$0;
    localObject = (RelativeLayout)ApolloBrickPlayerImpl.BrickCMSPlayerListener.a((ApolloBrickPlayerImpl.BrickCMSPlayerListener)localObject, ApolloBrickPlayerImpl.BrickCMSPlayerListener.b((ApolloBrickPlayerImpl.BrickCMSPlayerListener)localObject));
    if (localObject != null) {
      ((RelativeLayout)localObject).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener.2
 * JD-Core Version:    0.7.0.1
 */