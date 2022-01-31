package com.tencent.component.media.photogif;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

class QzoneAnimationDrawable$PhotoLoadListener
  implements ImageLoader.ImageLoadListener
{
  private QzoneAnimationDrawable$PhotoLoadListener(QzoneAnimationDrawable paramQzoneAnimationDrawable) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
  {
    QzoneAnimationDrawable.access$200(this.this$0);
  }
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    QzoneAnimationDrawable.access$200(this.this$0);
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    QzoneAnimationDrawable.access$302(this.this$0, paramDrawable);
    if (QzoneAnimationDrawable.access$400(this.this$0))
    {
      QzoneAnimationDrawable.access$402(this.this$0, false);
      QzoneAnimationDrawable.access$500(this.this$0);
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.QzoneAnimationDrawable.PhotoLoadListener
 * JD-Core Version:    0.7.0.1
 */