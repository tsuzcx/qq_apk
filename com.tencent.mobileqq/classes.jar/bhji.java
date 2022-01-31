import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bhji
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bhjj();
  static bhim jdField_a_of_type_Bhim;
  private static WeakReference<bhjk> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bhjk parambhjk)
  {
    if ((jdField_a_of_type_Bhim != null) && (jdField_a_of_type_Bhim.b()))
    {
      if (parambhjk != null) {
        parambhjk.onQzonePluginClientReady(jdField_a_of_type_Bhim);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhjk);
    bhig.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhji
 * JD-Core Version:    0.7.0.1
 */