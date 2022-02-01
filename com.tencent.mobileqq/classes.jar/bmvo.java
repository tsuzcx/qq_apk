import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class bmvo
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bmvp jdField_a_of_type_Bmvp;
  private int b = -1;
  
  public bmvo()
  {
    this.jdField_a_of_type_Bmvp = new bmvp();
  }
  
  public bmvo(bmvp parambmvp)
  {
    this.jdField_a_of_type_Bmvp = parambmvp;
    if (parambmvp != null)
    {
      h(parambmvp.d);
      h(parambmvp.b);
      h(parambmvp.c);
      h(parambmvp.e);
      h(parambmvp.f);
      h(parambmvp.g);
      h(parambmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Bmvp != null) && (this.jdField_a_of_type_Bmvp.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bmvp.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bmvp;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bmvp != null) && (this.jdField_a_of_type_Bmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bmvp != null) && ((this.jdField_a_of_type_Bmvp.d != null) || (this.jdField_a_of_type_Bmvp.f != null) || (this.jdField_a_of_type_Bmvp.e != null) || (this.jdField_a_of_type_Bmvp.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bmvp != null) && (this.jdField_a_of_type_Bmvp.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bmvp.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bmvp localbmvp = this.jdField_a_of_type_Bmvp;
    if (localbmvp != null)
    {
      if (localbmvp.d != null) {
        localbmvp.d.draw(paramCanvas);
      }
      if (localbmvp.f != null) {
        localbmvp.f.draw(paramCanvas);
      }
      if (localbmvp.g != null) {
        localbmvp.g.draw(paramCanvas);
      }
      if (localbmvp.e != null) {
        localbmvp.e.draw(paramCanvas);
      }
      if (localbmvp.b != null) {
        localbmvp.b.draw(paramCanvas);
      }
      if (localbmvp.c != null) {
        localbmvp.c.draw(paramCanvas);
      }
      if (localbmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bmvp != null)
    {
      this.jdField_a_of_type_Bmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bmvp.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bmvp.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bmvp;
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
        a(this.jdField_a_of_type_Bmvp.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmvp.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmvp.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmvp.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmvp.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmvp.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvo
 * JD-Core Version:    0.7.0.1
 */