import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class bhie
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<bhib> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bhie(QQToast paramQQToast, bhib parambhib)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhib);
  }
  
  private boolean a()
  {
    bhib localbhib = (bhib)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbhib != null) && (localbhib.a());
  }
  
  @Nullable
  QQToast a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhie
 * JD-Core Version:    0.7.0.1
 */