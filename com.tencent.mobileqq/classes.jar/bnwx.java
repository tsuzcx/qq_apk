import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bnwx
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  Drawable b = null;
  Drawable c = null;
  Drawable d = null;
  Drawable e = null;
  Drawable f = null;
  Drawable g = null;
  
  bnwx() {}
  
  bnwx(bnwx parambnwx)
  {
    if ((parambnwx.b != null) && (parambnwx.b.getConstantState() != null))
    {
      this.b = parambnwx.b.getConstantState().newDrawable();
      this.b.setBounds(parambnwx.b.getBounds());
    }
    if ((parambnwx.c != null) && (parambnwx.c.getConstantState() != null))
    {
      this.c = parambnwx.c.getConstantState().newDrawable();
      this.c.setBounds(parambnwx.c.getBounds());
    }
    if ((parambnwx.d != null) && (parambnwx.d.getConstantState() != null))
    {
      this.d = parambnwx.d.getConstantState().newDrawable();
      this.d.setBounds(parambnwx.d.getBounds());
    }
    if ((parambnwx.e != null) && (parambnwx.e.getConstantState() != null))
    {
      this.e = parambnwx.e.getConstantState().newDrawable();
      this.e.setBounds(parambnwx.e.getBounds());
    }
    if ((parambnwx.f != null) && (parambnwx.f.getConstantState() != null))
    {
      this.f = parambnwx.f.getConstantState().newDrawable();
      this.f.setBounds(parambnwx.f.getBounds());
    }
    if ((parambnwx.g != null) && (parambnwx.g.getConstantState() != null))
    {
      this.g = parambnwx.g.getConstantState().newDrawable();
      this.g.setBounds(parambnwx.g.getBounds());
    }
    if ((parambnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambnwx.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambnwx.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new bnww(new bnwx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwx
 * JD-Core Version:    0.7.0.1
 */