import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class bmot
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bmou jdField_a_of_type_Bmou;
  private int b = -1;
  
  public bmot()
  {
    this.jdField_a_of_type_Bmou = new bmou();
  }
  
  public bmot(bmou parambmou)
  {
    this.jdField_a_of_type_Bmou = parambmou;
    if (parambmou != null)
    {
      h(parambmou.d);
      h(parambmou.b);
      h(parambmou.c);
      h(parambmou.e);
      h(parambmou.f);
      h(parambmou.g);
      h(parambmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Bmou != null) && (this.jdField_a_of_type_Bmou.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bmou.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bmou;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bmou != null) && (this.jdField_a_of_type_Bmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bmou != null) && ((this.jdField_a_of_type_Bmou.d != null) || (this.jdField_a_of_type_Bmou.f != null) || (this.jdField_a_of_type_Bmou.e != null) || (this.jdField_a_of_type_Bmou.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bmou != null) && (this.jdField_a_of_type_Bmou.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bmou.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bmou localbmou = this.jdField_a_of_type_Bmou;
    if (localbmou != null)
    {
      if (localbmou.d != null) {
        localbmou.d.draw(paramCanvas);
      }
      if (localbmou.f != null) {
        localbmou.f.draw(paramCanvas);
      }
      if (localbmou.g != null) {
        localbmou.g.draw(paramCanvas);
      }
      if (localbmou.e != null) {
        localbmou.e.draw(paramCanvas);
      }
      if (localbmou.b != null) {
        localbmou.b.draw(paramCanvas);
      }
      if (localbmou.c != null) {
        localbmou.c.draw(paramCanvas);
      }
      if (localbmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmou != null)
    {
      this.jdField_a_of_type_Bmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bmou.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bmou.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bmou;
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
        a(this.jdField_a_of_type_Bmou.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmou.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmou.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmou.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmou.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmou.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmot
 * JD-Core Version:    0.7.0.1
 */