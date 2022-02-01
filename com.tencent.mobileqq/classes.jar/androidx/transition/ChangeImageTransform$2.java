package androidx.transition;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

final class ChangeImageTransform$2
  extends Property<ImageView, Matrix>
{
  ChangeImageTransform$2(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Matrix get(ImageView paramImageView)
  {
    return null;
  }
  
  public void set(ImageView paramImageView, Matrix paramMatrix)
  {
    ImageViewUtils.animateTransform(paramImageView, paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeImageTransform.2
 * JD-Core Version:    0.7.0.1
 */