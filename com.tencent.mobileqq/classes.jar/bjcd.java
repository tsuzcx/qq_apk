import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class bjcd
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<bjca> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bjcd(QQToast paramQQToast, bjca parambjca)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjca);
  }
  
  private boolean a()
  {
    bjca localbjca = (bjca)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbjca != null) && (localbjca.a());
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
 * Qualified Name:     bjcd
 * JD-Core Version:    0.7.0.1
 */