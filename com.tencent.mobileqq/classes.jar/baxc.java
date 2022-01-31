import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;

public abstract class baxc
  extends Drawable
{
  protected int a;
  protected ColorFilter a;
  protected Drawable a;
  protected boolean a;
  protected int b;
  protected Drawable b;
  protected Drawable c;
  
  protected baxc(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
    this.c = paramDrawable2;
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {
      return ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
    }
    return null;
  }
  
  public Drawable a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = a();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    int i = 0;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    int i = 0;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicWidth();
    }
    return i;
  }
  
  public int getMinimumHeight()
  {
    int i = 0;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      i = localDrawable.getMinimumHeight();
    }
    return i;
  }
  
  public int getMinimumWidth()
  {
    int i = 0;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      i = localDrawable.getMinimumWidth();
    }
    return i;
  }
  
  public int getOpacity()
  {
    int i = 0;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      i = localDrawable.getOpacity();
    }
    return i;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), bbay.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
      }
      invalidateSelf();
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = a();
    } while (localDrawable == null);
    localDrawable.setBounds(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = a();
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    Drawable localDrawable = a();
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baxc
 * JD-Core Version:    0.7.0.1
 */