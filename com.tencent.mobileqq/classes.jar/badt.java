import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;

public class badt
  implements URLDrawable.URLDrawableListener
{
  public badt(TroopHonorView paramTroopHonorView, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badt
 * JD-Core Version:    0.7.0.1
 */