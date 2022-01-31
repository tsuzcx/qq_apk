import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bgrc
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
  
  bgrc() {}
  
  bgrc(bgrc parambgrc)
  {
    if ((parambgrc.b != null) && (parambgrc.b.getConstantState() != null))
    {
      this.b = parambgrc.b.getConstantState().newDrawable();
      this.b.setBounds(parambgrc.b.getBounds());
    }
    if ((parambgrc.c != null) && (parambgrc.c.getConstantState() != null))
    {
      this.c = parambgrc.c.getConstantState().newDrawable();
      this.c.setBounds(parambgrc.c.getBounds());
    }
    if ((parambgrc.d != null) && (parambgrc.d.getConstantState() != null))
    {
      this.d = parambgrc.d.getConstantState().newDrawable();
      this.d.setBounds(parambgrc.d.getBounds());
    }
    if ((parambgrc.e != null) && (parambgrc.e.getConstantState() != null))
    {
      this.e = parambgrc.e.getConstantState().newDrawable();
      this.e.setBounds(parambgrc.e.getBounds());
    }
    if ((parambgrc.f != null) && (parambgrc.f.getConstantState() != null))
    {
      this.f = parambgrc.f.getConstantState().newDrawable();
      this.f.setBounds(parambgrc.f.getBounds());
    }
    if ((parambgrc.g != null) && (parambgrc.g.getConstantState() != null))
    {
      this.g = parambgrc.g.getConstantState().newDrawable();
      this.g.setBounds(parambgrc.g.getBounds());
    }
    if ((parambgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambgrc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambgrc.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new bgrb(new bgrc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrc
 * JD-Core Version:    0.7.0.1
 */