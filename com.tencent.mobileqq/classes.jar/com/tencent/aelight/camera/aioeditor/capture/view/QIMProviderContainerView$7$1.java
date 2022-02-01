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
    while (i < this.jdField_a_of_type_Int)
    {
      if (QIMProviderContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView$7.this$0).a(i))
      {
        Object localObject = (ImageView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView$7.this$0.a.getChildAt(i);
        Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.7.1
 * JD-Core Version:    0.7.0.1
 */