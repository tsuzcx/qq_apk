import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;

public class bieo
  implements biel
{
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public bieo(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof ApngDrawable))
    {
      if (paramBoolean) {
        ((ApngDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).resume();
      }
    }
    else {
      return;
    }
    ((ApngDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).pause();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      a(true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, false);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
    }
  }
  
  public void a(biem parambiem)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new biep(this, parambiem);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      a(false);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bieo
 * JD-Core Version:    0.7.0.1
 */