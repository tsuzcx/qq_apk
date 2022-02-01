import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bnfc
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bnfd();
  static bneg jdField_a_of_type_Bneg;
  private static WeakReference<bnfe> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bnfe parambnfe)
  {
    if ((jdField_a_of_type_Bneg != null) && (jdField_a_of_type_Bneg.b()))
    {
      if (parambnfe != null) {
        parambnfe.a(jdField_a_of_type_Bneg);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnfe);
    bnea.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      jdField_a_of_type_JavaLangRefWeakReference.clear();
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfc
 * JD-Core Version:    0.7.0.1
 */