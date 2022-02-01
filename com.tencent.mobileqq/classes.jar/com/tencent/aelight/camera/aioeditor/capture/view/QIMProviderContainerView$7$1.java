package com.tencent.aelight.camera.aioeditor.capture.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder;

class QIMProviderContainerView$7$1
  implements Runnable
{
  QIMProviderContainerView$7$1(QIMProviderContainerView.7 param7, int paramInt, Drawable[] paramArrayOfDrawable) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a)
    {
      if (QIMProviderContainerView.f(this.c.this$0).c(i))
      {
        Object localObject = (ImageView)this.c.this$0.b.getChildAt(i);
        Drawable[] arrayOfDrawable = this.b;
        if (arrayOfDrawable[i] != null)
        {
          ((ImageView)localObject).setImageDrawable(arrayOfDrawable[i]);
          if ((((ImageView)localObject).getDrawable() instanceof AnimationDrawable))
          {
            localObject = (AnimationDrawable)((ImageView)localObject).getDrawable();
            ((AnimationDrawable)localObject).stop();
            ((AnimationDrawable)localObject).setOneShot(true);
            ((AnimationDrawable)localObject).start();
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.7.1
 * JD-Core Version:    0.7.0.1
 */