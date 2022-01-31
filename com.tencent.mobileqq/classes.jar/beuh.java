import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class beuh
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<beuf> jdField_a_of_type_JavaLangRefWeakReference;
  
  public beuh(QQToast paramQQToast, beuf parambeuf)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambeuf);
  }
  
  private boolean a()
  {
    beuf localbeuf = (beuf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbeuf != null) && (localbeuf.a());
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
 * Qualified Name:     beuh
 * JD-Core Version:    0.7.0.1
 */