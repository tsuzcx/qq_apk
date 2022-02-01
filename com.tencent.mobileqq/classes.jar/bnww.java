import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class bnww
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bnwx jdField_a_of_type_Bnwx;
  private int b = -1;
  
  public bnww()
  {
    this.jdField_a_of_type_Bnwx = new bnwx();
  }
  
  public bnww(bnwx parambnwx)
  {
    this.jdField_a_of_type_Bnwx = parambnwx;
    if (parambnwx != null)
    {
      h(parambnwx.d);
      h(parambnwx.b);
      h(parambnwx.c);
      h(parambnwx.e);
      h(parambnwx.f);
      h(parambnwx.g);
      h(parambnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Bnwx != null) && (this.jdField_a_of_type_Bnwx.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bnwx.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bnwx;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bnwx != null) && (this.jdField_a_of_type_Bnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bnwx != null) && ((this.jdField_a_of_type_Bnwx.d != null) || (this.jdField_a_of_type_Bnwx.f != null) || (this.jdField_a_of_type_Bnwx.e != null) || (this.jdField_a_of_type_Bnwx.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bnwx != null) && (this.jdField_a_of_type_Bnwx.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bnwx.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bnwx localbnwx = this.jdField_a_of_type_Bnwx;
    if (localbnwx != null)
    {
      if (localbnwx.d != null) {
        localbnwx.d.draw(paramCanvas);
      }
      if (localbnwx.f != null) {
        localbnwx.f.draw(paramCanvas);
      }
      if (localbnwx.g != null) {
        localbnwx.g.draw(paramCanvas);
      }
      if (localbnwx.e != null) {
        localbnwx.e.draw(paramCanvas);
      }
      if (localbnwx.b != null) {
        localbnwx.b.draw(paramCanvas);
      }
      if (localbnwx.c != null) {
        localbnwx.c.draw(paramCanvas);
      }
      if (localbnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bnwx != null)
    {
      this.jdField_a_of_type_Bnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bnwx.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bnwx.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bnwx;
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
        a(this.jdField_a_of_type_Bnwx.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bnwx.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bnwx.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bnwx.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bnwx.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bnwx.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnww
 * JD-Core Version:    0.7.0.1
 */