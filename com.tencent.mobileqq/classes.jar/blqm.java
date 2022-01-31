import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class blqm
  implements URLDrawable.URLDrawableListener
{
  blqm(blql paramblql, String paramString, URLDrawable paramURLDrawable, blof paramblof) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    blql.a.remove(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    blql.a.remove(this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    blql.a(this.jdField_a_of_type_Blql, this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Blof);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqm
 * JD-Core Version:    0.7.0.1
 */