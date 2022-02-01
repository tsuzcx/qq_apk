import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class bibf
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<bibc> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bibf(QQToast paramQQToast, bibc parambibc)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambibc);
  }
  
  private boolean a()
  {
    bibc localbibc = (bibc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbibc != null) && (localbibc.a());
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
 * Qualified Name:     bibf
 * JD-Core Version:    0.7.0.1
 */