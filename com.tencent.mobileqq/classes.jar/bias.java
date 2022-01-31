import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bias
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
  
  bias() {}
  
  bias(bias parambias)
  {
    if ((parambias.b != null) && (parambias.b.getConstantState() != null))
    {
      this.b = parambias.b.getConstantState().newDrawable();
      this.b.setBounds(parambias.b.getBounds());
    }
    if ((parambias.c != null) && (parambias.c.getConstantState() != null))
    {
      this.c = parambias.c.getConstantState().newDrawable();
      this.c.setBounds(parambias.c.getBounds());
    }
    if ((parambias.d != null) && (parambias.d.getConstantState() != null))
    {
      this.d = parambias.d.getConstantState().newDrawable();
      this.d.setBounds(parambias.d.getBounds());
    }
    if ((parambias.e != null) && (parambias.e.getConstantState() != null))
    {
      this.e = parambias.e.getConstantState().newDrawable();
      this.e.setBounds(parambias.e.getBounds());
    }
    if ((parambias.f != null) && (parambias.f.getConstantState() != null))
    {
      this.f = parambias.f.getConstantState().newDrawable();
      this.f.setBounds(parambias.f.getBounds());
    }
    if ((parambias.g != null) && (parambias.g.getConstantState() != null))
    {
      this.g = parambias.g.getConstantState().newDrawable();
      this.g.setBounds(parambias.g.getBounds());
    }
    if ((parambias.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambias.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambias.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambias.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambias.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new biar(new bias(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bias
 * JD-Core Version:    0.7.0.1
 */