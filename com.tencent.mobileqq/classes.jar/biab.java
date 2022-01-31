import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class biab
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
  
  biab() {}
  
  biab(biab parambiab)
  {
    if ((parambiab.b != null) && (parambiab.b.getConstantState() != null))
    {
      this.b = parambiab.b.getConstantState().newDrawable();
      this.b.setBounds(parambiab.b.getBounds());
    }
    if ((parambiab.c != null) && (parambiab.c.getConstantState() != null))
    {
      this.c = parambiab.c.getConstantState().newDrawable();
      this.c.setBounds(parambiab.c.getBounds());
    }
    if ((parambiab.d != null) && (parambiab.d.getConstantState() != null))
    {
      this.d = parambiab.d.getConstantState().newDrawable();
      this.d.setBounds(parambiab.d.getBounds());
    }
    if ((parambiab.e != null) && (parambiab.e.getConstantState() != null))
    {
      this.e = parambiab.e.getConstantState().newDrawable();
      this.e.setBounds(parambiab.e.getBounds());
    }
    if ((parambiab.f != null) && (parambiab.f.getConstantState() != null))
    {
      this.f = parambiab.f.getConstantState().newDrawable();
      this.f.setBounds(parambiab.f.getBounds());
    }
    if ((parambiab.g != null) && (parambiab.g.getConstantState() != null))
    {
      this.g = parambiab.g.getConstantState().newDrawable();
      this.g.setBounds(parambiab.g.getBounds());
    }
    if ((parambiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parambiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(parambiab.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = parambiab.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new biaa(new biab(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biab
 * JD-Core Version:    0.7.0.1
 */