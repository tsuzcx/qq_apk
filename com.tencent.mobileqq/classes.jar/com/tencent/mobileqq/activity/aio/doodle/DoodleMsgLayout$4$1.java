package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$4$1
  implements Runnable
{
  DoodleMsgLayout$4$1(DoodleMsgLayout.4 param4, Drawable paramDrawable1, Drawable paramDrawable2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDoodleContent start update drawable:");
    ((StringBuilder)localObject).append(DoodleMsgLayout.f(this.c.this$0));
    QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    if ((this.a != null) && (DoodleMsgLayout.c(this.c.this$0) != null)) {
      DoodleMsgLayout.c(this.c.this$0).setImageDrawable(this.a);
    }
    if (DoodleMsgLayout.d(this.c.this$0) != null) {
      DoodleMsgLayout.d(this.c.this$0).setImageDrawable(this.b);
    }
    localObject = this.a;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof GifDrawable)) {
        ((GifDrawable)localObject).getImage().reset();
      }
      ((URLDrawable)this.a).setIndividualPause(false);
    }
    DoodleMsgLayout.b(this.c.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.4.1
 * JD-Core Version:    0.7.0.1
 */