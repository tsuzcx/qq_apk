import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;

public class bgkz
  implements bgkw
{
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public bgkz(Drawable paramDrawable)
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
  
  public void a(bgkx parambgkx)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new bgla(this, parambgkx);
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
 * Qualified Name:     bgkz
 * JD-Core Version:    0.7.0.1
 */