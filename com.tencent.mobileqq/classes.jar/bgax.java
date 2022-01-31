import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bgax
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bgay();
  static bgab jdField_a_of_type_Bgab;
  private static WeakReference<bgaz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bgaz parambgaz)
  {
    if ((jdField_a_of_type_Bgab != null) && (jdField_a_of_type_Bgab.b()))
    {
      if (parambgaz != null) {
        parambgaz.onQzonePluginClientReady(jdField_a_of_type_Bgab);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambgaz);
    bfzv.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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
 * Qualified Name:     bgax
 * JD-Core Version:    0.7.0.1
 */