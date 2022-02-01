import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class arzn
  implements URLDrawableDownListener
{
  arzn(arzm paramarzm, arxg paramarxg) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("EmotionHotPicSearchAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Arxg.toString());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("EmotionHotPicSearchAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Arxg.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("EmotionHotPicSearchAdapter", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Arxg.toString());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmotionHotPicSearchAdapter", 2, "onLoadSuccessed: " + this.jdField_a_of_type_Arxg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzn
 * JD-Core Version:    0.7.0.1
 */