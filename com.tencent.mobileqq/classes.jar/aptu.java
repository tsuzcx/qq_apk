import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class aptu
  implements URLDrawableDownListener
{
  aptu(apts paramapts, aptr paramaptr, URLImageView paramURLImageView, ImageView paramImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Aptr.toString());
    apts.a(this.jdField_a_of_type_Apts, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Aptr.toString());
    apts.a(this.jdField_a_of_type_Apts, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Aptr.toString());
    apts.a(this.jdField_a_of_type_Apts, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    apts.a(this.jdField_a_of_type_Apts, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionAdapter", 2, "onLoadSuccessed: " + this.jdField_a_of_type_Aptr.toString());
    }
    apts.a(this.jdField_a_of_type_Apts, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptu
 * JD-Core Version:    0.7.0.1
 */