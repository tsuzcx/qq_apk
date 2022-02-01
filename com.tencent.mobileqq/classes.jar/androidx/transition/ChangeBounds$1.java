package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

final class ChangeBounds$1
  extends Property<Drawable, PointF>
{
  private Rect mBounds = new Rect();
  
  ChangeBounds$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(Drawable paramDrawable)
  {
    paramDrawable.copyBounds(this.mBounds);
    return new PointF(this.mBounds.left, this.mBounds.top);
  }
  
  public void set(Drawable paramDrawable, PointF paramPointF)
  {
    paramDrawable.copyBounds(this.mBounds);
    this.mBounds.offsetTo(Math.round(paramPointF.x), Math.round(paramPointF.y));
    paramDrawable.setBounds(this.mBounds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeBounds.1
 * JD-Core Version:    0.7.0.1
 */