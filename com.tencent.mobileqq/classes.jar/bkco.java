import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bkco
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
  
  bkco() {}
  
  bkco(bkco parambkco)
  {
    if ((parambkco.b != null) && (parambkco.b.getConstantState() != null))
    {
      this.b = parambkco.b.getConstantState().newDrawable();
      this.b.setBounds(parambkco.b.getBounds());
    }
    if ((parambkco.c != null) && (parambkco.c.getConstantState() != null))
    {
      this.c = parambkco.c.getConstantState().newDrawable();
      this.c.setBounds(parambkco.c.getBounds());
    }
    if ((parambkco.d != null) && (parambkco.d.getConstantState() != null))
    {
      this.d = parambkco.d.getConstantState().newDrawable();
      this.d.setBounds(parambkco.d.getBounds());
    }
    if ((parambkco.e != null) && (parambkco.e.getConstantState() != null))
    {
      this.e = parambkco.e.getConstantState().newDrawable();
      this.e.setBounds(parambkco.e.getBounds());
    }
    if ((parambkco.f != null) && (parambkco.f.getConstantState() != null))
    {
      this.f = parambkco.f.getConstantState().newDrawable();
      this.f.setBounds(parambkco.f.getBounds());
    }
    if ((parambkco.g != null) && (parambkco.g.getConstantState() != null))
    {
      this.g = parambkco.g.getConstantState().newDrawable();
      this.g.setBounds(parambkco.g.getBounds());
    }
    if ((parambkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambkco.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambkco.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new bkcn(new bkco(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkco
 * JD-Core Version:    0.7.0.1
 */