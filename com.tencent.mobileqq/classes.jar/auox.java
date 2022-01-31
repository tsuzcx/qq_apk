import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class auox
  implements URLDrawable.URLDrawableListener
{
  auox(Resources paramResources, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      int i = aekt.a(21.0F, this.jdField_a_of_type_AndroidContentResResources);
      int j = paramURLDrawable.getIntrinsicWidth() * i / paramURLDrawable.getIntrinsicHeight();
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auox
 * JD-Core Version:    0.7.0.1
 */