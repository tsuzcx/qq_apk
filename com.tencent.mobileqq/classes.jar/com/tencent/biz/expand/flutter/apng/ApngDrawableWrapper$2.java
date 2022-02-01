package com.tencent.biz.expand.flutter.apng;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.annotation.NonNull;
import com.peterlmeng.animate_image.support.common.IInvalidateCallback;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ApngDrawableWrapper$2
  implements Drawable.Callback
{
  ApngDrawableWrapper$2(ApngDrawableWrapper paramApngDrawableWrapper) {}
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable.draw(ApngDrawableWrapper.a(this.a));
    Object localObject;
    if ((ApngDrawableWrapper.a(this.a) != null) && ((paramDrawable instanceof URLDrawable)))
    {
      localObject = ((URLDrawable)paramDrawable).getCurrDrawable();
      if (!(localObject instanceof ApngDrawable)) {
        break label143;
      }
      localObject = ((ApngDrawable)localObject).getImage();
      Bitmap localBitmap = ((ApngImage)localObject).getCurrentFrame();
      if (ApngDrawableWrapper.a(this.a) == null) {
        break label84;
      }
      ApngDrawableWrapper.a(this.a).onInvalidate(localBitmap, ((ApngImage)localObject).currentApngLoop);
    }
    label84:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApngDrawableWrapper", 2, new Object[] { "[" + ApngDrawableWrapper.a(this.a) + "] ", "invalidateDrawable() callback is null", paramDrawable });
    return;
    label143:
    QLog.d("ApngDrawableWrapper", 2, new Object[] { "[" + ApngDrawableWrapper.a(this.a) + "] ", "invalidateDrawable() strange drawable is: ", localObject });
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.apng.ApngDrawableWrapper.2
 * JD-Core Version:    0.7.0.1
 */