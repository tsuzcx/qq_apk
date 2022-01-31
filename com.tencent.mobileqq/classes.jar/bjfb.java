import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bjfb
  implements URLDrawable.URLDrawableListener
{
  bjfb(bjfa parambjfa, String paramString, URLDrawable paramURLDrawable, bjcu parambjcu) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    bjfa.a.remove(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    bjfa.a.remove(this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bjfa.a(this.jdField_a_of_type_Bjfa, this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Bjcu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfb
 * JD-Core Version:    0.7.0.1
 */