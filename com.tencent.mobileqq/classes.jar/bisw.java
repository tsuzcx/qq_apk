import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class bisw
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<bist> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bisw(QQToast paramQQToast, bist parambist)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambist);
  }
  
  private boolean a()
  {
    bist localbist = (bist)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbist != null) && (localbist.a());
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
 * Qualified Name:     bisw
 * JD-Core Version:    0.7.0.1
 */