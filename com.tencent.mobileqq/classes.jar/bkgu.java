import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class bkgu
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bkgv jdField_a_of_type_Bkgv;
  private int b = -1;
  
  public bkgu()
  {
    this.jdField_a_of_type_Bkgv = new bkgv();
  }
  
  public bkgu(bkgv parambkgv)
  {
    this.jdField_a_of_type_Bkgv = parambkgv;
    if (parambkgv != null)
    {
      h(parambkgv.d);
      h(parambkgv.b);
      h(parambkgv.c);
      h(parambkgv.e);
      h(parambkgv.f);
      h(parambkgv.g);
      h(parambkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Bkgv != null) && (this.jdField_a_of_type_Bkgv.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bkgv.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bkgv;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bkgv != null) && (this.jdField_a_of_type_Bkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bkgv != null) && ((this.jdField_a_of_type_Bkgv.d != null) || (this.jdField_a_of_type_Bkgv.f != null) || (this.jdField_a_of_type_Bkgv.e != null) || (this.jdField_a_of_type_Bkgv.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bkgv != null) && (this.jdField_a_of_type_Bkgv.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bkgv.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bkgv localbkgv = this.jdField_a_of_type_Bkgv;
    if (localbkgv != null)
    {
      if (localbkgv.d != null) {
        localbkgv.d.draw(paramCanvas);
      }
      if (localbkgv.f != null) {
        localbkgv.f.draw(paramCanvas);
      }
      if (localbkgv.g != null) {
        localbkgv.g.draw(paramCanvas);
      }
      if (localbkgv.e != null) {
        localbkgv.e.draw(paramCanvas);
      }
      if (localbkgv.b != null) {
        localbkgv.b.draw(paramCanvas);
      }
      if (localbkgv.c != null) {
        localbkgv.c.draw(paramCanvas);
      }
      if (localbkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkgv != null)
    {
      this.jdField_a_of_type_Bkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bkgv.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bkgv.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bkgv;
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
        a(this.jdField_a_of_type_Bkgv.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkgv.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkgv.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkgv.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkgv.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkgv.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgu
 * JD-Core Version:    0.7.0.1
 */