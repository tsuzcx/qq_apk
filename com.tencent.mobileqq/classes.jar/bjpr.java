import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bjpr
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bjps();
  static bjov jdField_a_of_type_Bjov;
  private static WeakReference<bjpt> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bjpt parambjpt)
  {
    if ((jdField_a_of_type_Bjov != null) && (jdField_a_of_type_Bjov.b()))
    {
      if (parambjpt != null) {
        parambjpt.onQzonePluginClientReady(jdField_a_of_type_Bjov);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjpt);
    bjop.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpr
 * JD-Core Version:    0.7.0.1
 */