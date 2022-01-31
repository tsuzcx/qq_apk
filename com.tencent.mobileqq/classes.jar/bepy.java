import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class bepy
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<bepw> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bepy(QQToast paramQQToast, bepw parambepw)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambepw);
  }
  
  private boolean a()
  {
    bepw localbepw = (bepw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbepw != null) && (localbepw.a());
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
 * Qualified Name:     bepy
 * JD-Core Version:    0.7.0.1
 */