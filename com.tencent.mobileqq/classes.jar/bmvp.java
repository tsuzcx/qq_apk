import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bmvp
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
  
  bmvp() {}
  
  bmvp(bmvp parambmvp)
  {
    if ((parambmvp.b != null) && (parambmvp.b.getConstantState() != null))
    {
      this.b = parambmvp.b.getConstantState().newDrawable();
      this.b.setBounds(parambmvp.b.getBounds());
    }
    if ((parambmvp.c != null) && (parambmvp.c.getConstantState() != null))
    {
      this.c = parambmvp.c.getConstantState().newDrawable();
      this.c.setBounds(parambmvp.c.getBounds());
    }
    if ((parambmvp.d != null) && (parambmvp.d.getConstantState() != null))
    {
      this.d = parambmvp.d.getConstantState().newDrawable();
      this.d.setBounds(parambmvp.d.getBounds());
    }
    if ((parambmvp.e != null) && (parambmvp.e.getConstantState() != null))
    {
      this.e = parambmvp.e.getConstantState().newDrawable();
      this.e.setBounds(parambmvp.e.getBounds());
    }
    if ((parambmvp.f != null) && (parambmvp.f.getConstantState() != null))
    {
      this.f = parambmvp.f.getConstantState().newDrawable();
      this.f.setBounds(parambmvp.f.getBounds());
    }
    if ((parambmvp.g != null) && (parambmvp.g.getConstantState() != null))
    {
      this.g = parambmvp.g.getConstantState().newDrawable();
      this.g.setBounds(parambmvp.g.getBounds());
    }
    if ((parambmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambmvp.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambmvp.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new bmvo(new bmvp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvp
 * JD-Core Version:    0.7.0.1
 */