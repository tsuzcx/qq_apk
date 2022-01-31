import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class bkcn
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bkco jdField_a_of_type_Bkco;
  private int b = -1;
  
  public bkcn()
  {
    this.jdField_a_of_type_Bkco = new bkco();
  }
  
  public bkcn(bkco parambkco)
  {
    this.jdField_a_of_type_Bkco = parambkco;
    if (parambkco != null)
    {
      h(parambkco.d);
      h(parambkco.b);
      h(parambkco.c);
      h(parambkco.e);
      h(parambkco.f);
      h(parambkco.g);
      h(parambkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Bkco != null) && (this.jdField_a_of_type_Bkco.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bkco.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bkco;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bkco != null) && (this.jdField_a_of_type_Bkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bkco != null) && ((this.jdField_a_of_type_Bkco.d != null) || (this.jdField_a_of_type_Bkco.f != null) || (this.jdField_a_of_type_Bkco.e != null) || (this.jdField_a_of_type_Bkco.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bkco != null) && (this.jdField_a_of_type_Bkco.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bkco.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bkco localbkco = this.jdField_a_of_type_Bkco;
    if (localbkco != null)
    {
      if (localbkco.d != null) {
        localbkco.d.draw(paramCanvas);
      }
      if (localbkco.f != null) {
        localbkco.f.draw(paramCanvas);
      }
      if (localbkco.g != null) {
        localbkco.g.draw(paramCanvas);
      }
      if (localbkco.e != null) {
        localbkco.e.draw(paramCanvas);
      }
      if (localbkco.b != null) {
        localbkco.b.draw(paramCanvas);
      }
      if (localbkco.c != null) {
        localbkco.c.draw(paramCanvas);
      }
      if (localbkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bkco != null)
    {
      this.jdField_a_of_type_Bkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bkco.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bkco.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bkco;
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
        a(this.jdField_a_of_type_Bkco.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkco.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkco.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkco.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkco.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkco.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcn
 * JD-Core Version:    0.7.0.1
 */