import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class blcd
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
  
  blcd() {}
  
  blcd(blcd paramblcd)
  {
    if ((paramblcd.b != null) && (paramblcd.b.getConstantState() != null))
    {
      this.b = paramblcd.b.getConstantState().newDrawable();
      this.b.setBounds(paramblcd.b.getBounds());
    }
    if ((paramblcd.c != null) && (paramblcd.c.getConstantState() != null))
    {
      this.c = paramblcd.c.getConstantState().newDrawable();
      this.c.setBounds(paramblcd.c.getBounds());
    }
    if ((paramblcd.d != null) && (paramblcd.d.getConstantState() != null))
    {
      this.d = paramblcd.d.getConstantState().newDrawable();
      this.d.setBounds(paramblcd.d.getBounds());
    }
    if ((paramblcd.e != null) && (paramblcd.e.getConstantState() != null))
    {
      this.e = paramblcd.e.getConstantState().newDrawable();
      this.e.setBounds(paramblcd.e.getBounds());
    }
    if ((paramblcd.f != null) && (paramblcd.f.getConstantState() != null))
    {
      this.f = paramblcd.f.getConstantState().newDrawable();
      this.f.setBounds(paramblcd.f.getBounds());
    }
    if ((paramblcd.g != null) && (paramblcd.g.getConstantState() != null))
    {
      this.g = paramblcd.g.getConstantState().newDrawable();
      this.g.setBounds(paramblcd.g.getBounds());
    }
    if ((paramblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramblcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = paramblcd.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new blcc(new blcd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcd
 * JD-Core Version:    0.7.0.1
 */