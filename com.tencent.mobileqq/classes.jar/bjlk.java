import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bjlk
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bjll();
  static bjko jdField_a_of_type_Bjko;
  private static WeakReference<bjlm> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bjlm parambjlm)
  {
    if ((jdField_a_of_type_Bjko != null) && (jdField_a_of_type_Bjko.b()))
    {
      if (parambjlm != null) {
        parambjlm.onQzonePluginClientReady(jdField_a_of_type_Bjko);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjlm);
    bjki.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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
 * Qualified Name:     bjlk
 * JD-Core Version:    0.7.0.1
 */