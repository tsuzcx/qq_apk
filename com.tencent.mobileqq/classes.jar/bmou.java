import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class bmou
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
  
  bmou() {}
  
  bmou(bmou parambmou)
  {
    if ((parambmou.b != null) && (parambmou.b.getConstantState() != null))
    {
      this.b = parambmou.b.getConstantState().newDrawable();
      this.b.setBounds(parambmou.b.getBounds());
    }
    if ((parambmou.c != null) && (parambmou.c.getConstantState() != null))
    {
      this.c = parambmou.c.getConstantState().newDrawable();
      this.c.setBounds(parambmou.c.getBounds());
    }
    if ((parambmou.d != null) && (parambmou.d.getConstantState() != null))
    {
      this.d = parambmou.d.getConstantState().newDrawable();
      this.d.setBounds(parambmou.d.getBounds());
    }
    if ((parambmou.e != null) && (parambmou.e.getConstantState() != null))
    {
      this.e = parambmou.e.getConstantState().newDrawable();
      this.e.setBounds(parambmou.e.getBounds());
    }
    if ((parambmou.f != null) && (parambmou.f.getConstantState() != null))
    {
      this.f = parambmou.f.getConstantState().newDrawable();
      this.f.setBounds(parambmou.f.getBounds());
    }
    if ((parambmou.g != null) && (parambmou.g.getConstantState() != null))
    {
      this.g = parambmou.g.getConstantState().newDrawable();
      this.g.setBounds(parambmou.g.getBounds());
    }
    if ((parambmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambmou.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambmou.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new bmot(new bmou(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmou
 * JD-Core Version:    0.7.0.1
 */