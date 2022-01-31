import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bkgv
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
  
  bkgv() {}
  
  bkgv(bkgv parambkgv)
  {
    if ((parambkgv.b != null) && (parambkgv.b.getConstantState() != null))
    {
      this.b = parambkgv.b.getConstantState().newDrawable();
      this.b.setBounds(parambkgv.b.getBounds());
    }
    if ((parambkgv.c != null) && (parambkgv.c.getConstantState() != null))
    {
      this.c = parambkgv.c.getConstantState().newDrawable();
      this.c.setBounds(parambkgv.c.getBounds());
    }
    if ((parambkgv.d != null) && (parambkgv.d.getConstantState() != null))
    {
      this.d = parambkgv.d.getConstantState().newDrawable();
      this.d.setBounds(parambkgv.d.getBounds());
    }
    if ((parambkgv.e != null) && (parambkgv.e.getConstantState() != null))
    {
      this.e = parambkgv.e.getConstantState().newDrawable();
      this.e.setBounds(parambkgv.e.getBounds());
    }
    if ((parambkgv.f != null) && (parambkgv.f.getConstantState() != null))
    {
      this.f = parambkgv.f.getConstantState().newDrawable();
      this.f.setBounds(parambkgv.f.getBounds());
    }
    if ((parambkgv.g != null) && (parambkgv.g.getConstantState() != null))
    {
      this.g = parambkgv.g.getConstantState().newDrawable();
      this.g.setBounds(parambkgv.g.getBounds());
    }
    if ((parambkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambkgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambkgv.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new bkgu(new bkgv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgv
 * JD-Core Version:    0.7.0.1
 */