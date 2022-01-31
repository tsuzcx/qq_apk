import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class biar
  extends Drawable
{
  private int jdField_a_of_type_Int = -1;
  private bias jdField_a_of_type_Bias;
  private int b = -1;
  
  public biar()
  {
    this.jdField_a_of_type_Bias = new bias();
  }
  
  public biar(bias parambias)
  {
    this.jdField_a_of_type_Bias = parambias;
    if (parambias != null)
    {
      h(parambias.d);
      h(parambias.b);
      h(parambias.c);
      h(parambias.e);
      h(parambias.f);
      h(parambias.g);
      h(parambias.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    if ((this.jdField_a_of_type_Bias != null) && (this.jdField_a_of_type_Bias.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bias.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_Bias;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bias != null) && (this.jdField_a_of_type_Bias.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    while ((this.jdField_a_of_type_Bias != null) && ((this.jdField_a_of_type_Bias.d != null) || (this.jdField_a_of_type_Bias.f != null) || (this.jdField_a_of_type_Bias.e != null) || (this.jdField_a_of_type_Bias.c != null))) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Bias != null) && (this.jdField_a_of_type_Bias.b != null)) {
      return Math.abs(this.jdField_a_of_type_Bias.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bias localbias = this.jdField_a_of_type_Bias;
    if (localbias != null)
    {
      if (localbias.d != null) {
        localbias.d.draw(paramCanvas);
      }
      if (localbias.f != null) {
        localbias.f.draw(paramCanvas);
      }
      if (localbias.g != null) {
        localbias.g.draw(paramCanvas);
      }
      if (localbias.e != null) {
        localbias.e.draw(paramCanvas);
      }
      if (localbias.b != null) {
        localbias.b.draw(paramCanvas);
      }
      if (localbias.c != null) {
        localbias.c.draw(paramCanvas);
      }
      if (localbias.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localbias.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bias != null)
    {
      this.jdField_a_of_type_Bias.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Bias.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Bias.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Bias;
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
        a(this.jdField_a_of_type_Bias.d, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bias.e, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bias.f, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bias.b, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bias.c, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bias.g, paramInt1 - i, paramInt2 - j);
        a(this.jdField_a_of_type_Bias.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramInt1 - i, paramInt2 - j);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biar
 * JD-Core Version:    0.7.0.1
 */