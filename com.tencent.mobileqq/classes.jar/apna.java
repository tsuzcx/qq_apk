import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class apna
  implements URLDrawableDownListener
{
  apna(apmt paramapmt, apuf paramapuf, apnb paramapnb) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Apuf.toString());
    apmt.a(this.jdField_a_of_type_Apmt, this.jdField_a_of_type_Apnb.a, this.jdField_a_of_type_Apnb);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Apuf.toString());
    apmt.a(this.jdField_a_of_type_Apmt, this.jdField_a_of_type_Apnb.a, this.jdField_a_of_type_Apnb);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Apuf.toString());
    apmt.a(this.jdField_a_of_type_Apmt, this.jdField_a_of_type_Apnb.a, this.jdField_a_of_type_Apnb);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadProgressed: " + this.jdField_a_of_type_Apuf.toString());
    }
    apmt.a(this.jdField_a_of_type_Apmt, this.jdField_a_of_type_Apnb.a, this.jdField_a_of_type_Apnb);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadSuccess: " + this.jdField_a_of_type_Apuf.toString());
    }
    apmt.a(this.jdField_a_of_type_Apmt, this.jdField_a_of_type_Apnb.a, this.jdField_a_of_type_Apnb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apna
 * JD-Core Version:    0.7.0.1
 */