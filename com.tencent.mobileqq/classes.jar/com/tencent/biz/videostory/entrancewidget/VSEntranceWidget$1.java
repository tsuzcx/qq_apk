package com.tencent.biz.videostory.entrancewidget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

class VSEntranceWidget$1
  implements ImageLoader.ImageLoadListener
{
  VSEntranceWidget$1(VSEntranceWidget paramVSEntranceWidget, View paramView) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramDrawable != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (!(this.jdField_a_of_type_AndroidViewView instanceof FrameLayout)) {
        break label39;
      }
      this.jdField_a_of_type_AndroidViewView.post(new VSEntranceWidget.1.1(this, paramDrawable));
    }
    label39:
    while (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.post(new VSEntranceWidget.1.2(this, paramDrawable));
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.1
 * JD-Core Version:    0.7.0.1
 */