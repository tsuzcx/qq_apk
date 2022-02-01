package com.tencent.mobileqq.apollo.meme.api.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ApolloBrickPlayerImpl$CustomMemePlayerListener$2
  implements Runnable
{
  ApolloBrickPlayerImpl$CustomMemePlayerListener$2(ApolloBrickPlayerImpl.CustomMemePlayerListener paramCustomMemePlayerListener, int paramInt, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if (this.a != ApolloBrickPlayerImpl.CustomMemePlayerListener.a(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecordDone mActionId not same! current ");
        ((StringBuilder)localObject).append(ApolloBrickPlayerImpl.CustomMemePlayerListener.a(this.this$0));
        ((StringBuilder)localObject).append(" onRecordDone id ");
        ((StringBuilder)localObject).append(this.a);
        QLog.w("[cmshow]ApolloBrickPlayer", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.this$0;
    localObject = (ImageView)ApolloBrickPlayerImpl.CustomMemePlayerListener.a((ApolloBrickPlayerImpl.CustomMemePlayerListener)localObject, ApolloBrickPlayerImpl.CustomMemePlayerListener.b((ApolloBrickPlayerImpl.CustomMemePlayerListener)localObject));
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(this.b);
    }
    localObject = this.b;
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() == 1) {
        ApolloBrickPlayerImpl.CustomMemePlayerListener.c(this.this$0);
      } else {
        ((URLDrawable)localObject).setURLDrawableListener(ApolloBrickPlayerImpl.CustomMemePlayerListener.a(this.this$0, this.c));
      }
    }
    localObject = this.this$0;
    localObject = (RelativeLayout)ApolloBrickPlayerImpl.CustomMemePlayerListener.a((ApolloBrickPlayerImpl.CustomMemePlayerListener)localObject, ApolloBrickPlayerImpl.CustomMemePlayerListener.d((ApolloBrickPlayerImpl.CustomMemePlayerListener)localObject));
    if (localObject != null) {
      ((RelativeLayout)localObject).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.2
 * JD-Core Version:    0.7.0.1
 */