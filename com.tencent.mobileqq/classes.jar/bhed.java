import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;

public class bhed
  implements bhea
{
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public bhed(Drawable paramDrawable)
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
  
  public void a(bheb parambheb)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new bhee(this, parambheb);
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
 * Qualified Name:     bhed
 * JD-Core Version:    0.7.0.1
 */