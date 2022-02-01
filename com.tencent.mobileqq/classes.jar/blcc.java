import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class blcc
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private blcd jdField_a_of_type_Blcd;
  private int b = -1;
  
  public blcc()
  {
    this.jdField_a_of_type_Blcd = new blcd();
  }
  
  public blcc(blcd paramblcd)
  {
    this.jdField_a_of_type_Blcd = paramblcd;
    if (paramblcd != null)
    {
      h(paramblcd.d);
      h(paramblcd.b);
      h(paramblcd.c);
      h(paramblcd.e);
      h(paramblcd.f);
      h(paramblcd.g);
      h(paramblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Blcd != null) && (this.jdField_a_of_type_Blcd.b != null)) {
      return Math.abs(this.jdField_a_of_type_Blcd.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Blcd;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Blcd != null) && (this.jdField_a_of_type_Blcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Blcd != null) && ((this.jdField_a_of_type_Blcd.d != null) || (this.jdField_a_of_type_Blcd.f != null) || (this.jdField_a_of_type_Blcd.e != null) || (this.jdField_a_of_type_Blcd.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Blcd != null) && (this.jdField_a_of_type_Blcd.b != null)) {
      return Math.abs(this.jdField_a_of_type_Blcd.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    blcd localblcd = this.jdField_a_of_type_Blcd;
    if (localblcd != null)
    {
      if (localblcd.d != null) {
        localblcd.d.draw(paramCanvas);
      }
      if (localblcd.f != null) {
        localblcd.f.draw(paramCanvas);
      }
      if (localblcd.g != null) {
        localblcd.g.draw(paramCanvas);
      }
      if (localblcd.e != null) {
        localblcd.e.draw(paramCanvas);
      }
      if (localblcd.b != null) {
        localblcd.b.draw(paramCanvas);
      }
      if (localblcd.c != null) {
        localblcd.c.draw(paramCanvas);
      }
      if (localblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Blcd != null)
    {
      this.jdField_a_of_type_Blcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Blcd.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Blcd.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Blcd;
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
        a(this.jdField_a_of_type_Blcd.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Blcd.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Blcd.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Blcd.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Blcd.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Blcd.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Blcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcc
 * JD-Core Version:    0.7.0.1
 */