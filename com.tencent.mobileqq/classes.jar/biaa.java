import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class biaa
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private biab jdField_a_of_type_Biab;
  private int b = -1;
  
  public biaa()
  {
    this.jdField_a_of_type_Biab = new biab();
  }
  
  public biaa(biab parambiab)
  {
    this.jdField_a_of_type_Biab = parambiab;
    if (parambiab != null)
    {
      h(parambiab.d);
      h(parambiab.b);
      h(parambiab.c);
      h(parambiab.e);
      h(parambiab.f);
      h(parambiab.g);
      h(parambiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Biab != null) && (this.jdField_a_of_type_Biab.b != null)) {
      return Math.abs(this.jdField_a_of_type_Biab.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Biab;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Biab != null) && (this.jdField_a_of_type_Biab.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Biab != null) && ((this.jdField_a_of_type_Biab.d != null) || (this.jdField_a_of_type_Biab.f != null) || (this.jdField_a_of_type_Biab.e != null) || (this.jdField_a_of_type_Biab.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Biab != null) && (this.jdField_a_of_type_Biab.b != null)) {
      return Math.abs(this.jdField_a_of_type_Biab.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    biab localbiab = this.jdField_a_of_type_Biab;
    if (localbiab != null)
    {
      if (localbiab.d != null) {
        localbiab.d.draw(paramCanvas);
      }
      if (localbiab.f != null) {
        localbiab.f.draw(paramCanvas);
      }
      if (localbiab.g != null) {
        localbiab.g.draw(paramCanvas);
      }
      if (localbiab.e != null) {
        localbiab.e.draw(paramCanvas);
      }
      if (localbiab.b != null) {
        localbiab.b.draw(paramCanvas);
      }
      if (localbiab.c != null) {
        localbiab.c.draw(paramCanvas);
      }
      if (localbiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Biab.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Biab.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Biab;
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
        a(this.jdField_a_of_type_Biab.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Biab.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Biab.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Biab.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Biab.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Biab.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Biab.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biaa
 * JD-Core Version:    0.7.0.1
 */