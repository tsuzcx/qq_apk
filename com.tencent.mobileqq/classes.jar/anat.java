import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class anat
  implements URLDrawableDownListener
{
  anat(anao paramanao, anht paramanht, anau paramanau) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Anht.toString());
    anao.a(this.jdField_a_of_type_Anao, this.jdField_a_of_type_Anau.a, this.jdField_a_of_type_Anau);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_Anht.toString());
    anao.a(this.jdField_a_of_type_Anao, this.jdField_a_of_type_Anau.a, this.jdField_a_of_type_Anau);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Anht.toString());
    anao.a(this.jdField_a_of_type_Anao, this.jdField_a_of_type_Anau.a, this.jdField_a_of_type_Anau);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadProgressed: " + this.jdField_a_of_type_Anht.toString());
    }
    anao.a(this.jdField_a_of_type_Anao, this.jdField_a_of_type_Anau.a, this.jdField_a_of_type_Anau);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadSuccess: " + this.jdField_a_of_type_Anht.toString());
    }
    anao.a(this.jdField_a_of_type_Anao, this.jdField_a_of_type_Anau.a, this.jdField_a_of_type_Anau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */