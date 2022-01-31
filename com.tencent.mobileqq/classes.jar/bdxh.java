import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;

public class bdxh
  implements bdxe
{
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public bdxh(Drawable paramDrawable)
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
  
  public void a(bdxf parambdxf)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new bdxi(this, parambdxf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxh
 * JD-Core Version:    0.7.0.1
 */