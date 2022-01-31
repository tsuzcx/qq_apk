import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class anre
  implements URLDrawableDownListener
{
  anre(anqx paramanqx, anyc paramanyc, anrf paramanrf) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Anyc.toString());
    anqx.a(this.jdField_a_of_type_Anqx, this.jdField_a_of_type_Anrf.a, this.jdField_a_of_type_Anrf);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Anyc.toString());
    anqx.a(this.jdField_a_of_type_Anqx, this.jdField_a_of_type_Anrf.a, this.jdField_a_of_type_Anrf);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Anyc.toString());
    anqx.a(this.jdField_a_of_type_Anqx, this.jdField_a_of_type_Anrf.a, this.jdField_a_of_type_Anrf);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadProgressed: " + this.jdField_a_of_type_Anyc.toString());
    }
    anqx.a(this.jdField_a_of_type_Anqx, this.jdField_a_of_type_Anrf.a, this.jdField_a_of_type_Anrf);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadSuccess: " + this.jdField_a_of_type_Anyc.toString());
    }
    anqx.a(this.jdField_a_of_type_Anqx, this.jdField_a_of_type_Anrf.a, this.jdField_a_of_type_Anrf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anre
 * JD-Core Version:    0.7.0.1
 */