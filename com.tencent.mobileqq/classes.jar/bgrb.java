import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class bgrb
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bgrc jdField_a_of_type_Bgrc;
  private int b = -1;
  
  public bgrb()
  {
    this.jdField_a_of_type_Bgrc = new bgrc();
  }
  
  public bgrb(bgrc parambgrc)
  {
    this.jdField_a_of_type_Bgrc = parambgrc;
    if (parambgrc != null)
    {
      h(parambgrc.d);
      h(parambgrc.b);
      h(parambgrc.c);
      h(parambgrc.e);
      h(parambgrc.f);
      h(parambgrc.g);
      h(parambgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(paramDrawable.getBounds().left + paramInt1, paramDrawable.getBounds().top + paramInt2, paramDrawable.getBounds().right + paramInt1, paramDrawable.getBounds().bottom + paramInt2);
    }
  }
  
  private void h(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable = paramDrawable.getBounds();
      Rect localRect = getBounds();
      if ((localRect != null) && (paramDrawable != null))
      {
        localRect.left = Math.min(paramDrawable.left, localRect.left);
        localRect.right = Math.max(paramDrawable.right, localRect.right);
        localRect.top = Math.min(paramDrawable.top, localRect.top);
        localRect.bottom = Math.max(paramDrawable.bottom, localRect.bottom);
        setBounds(localRect);
        this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, localRect.right - localRect.left);
        this.b = Math.max(this.b, localRect.bottom - localRect.top);
      }
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Bgrc != null) && (this.jdField_a_of_type_Bgrc.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bgrc.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bgrc;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bgrc != null) && (this.jdField_a_of_type_Bgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bgrc != null) && ((this.jdField_a_of_type_Bgrc.d != null) || (this.jdField_a_of_type_Bgrc.f != null) || (this.jdField_a_of_type_Bgrc.e != null) || (this.jdField_a_of_type_Bgrc.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bgrc != null) && (this.jdField_a_of_type_Bgrc.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bgrc.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bgrc localbgrc = this.jdField_a_of_type_Bgrc;
    if (localbgrc != null)
    {
      if (localbgrc.d != null) {
        localbgrc.d.draw(paramCanvas);
      }
      if (localbgrc.f != null) {
        localbgrc.f.draw(paramCanvas);
      }
      if (localbgrc.g != null) {
        localbgrc.g.draw(paramCanvas);
      }
      if (localbgrc.e != null) {
        localbgrc.e.draw(paramCanvas);
      }
      if (localbgrc.b != null) {
        localbgrc.b.draw(paramCanvas);
      }
      if (localbgrc.c != null) {
        localbgrc.c.draw(paramCanvas);
      }
      if (localbgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgrc != null)
    {
      this.jdField_a_of_type_Bgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bgrc.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bgrc.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bgrc;
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getBounds() != null)
    {
      int i = getBounds().left;
      int j = getBounds().top;
      if ((i != paramInt1) || (j != paramInt2))
      {
        a(this.jdField_a_of_type_Bgrc.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bgrc.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bgrc.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bgrc.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bgrc.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bgrc.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrb
 * JD-Core Version:    0.7.0.1
 */