import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bhjz
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bhka();
  static bhjd jdField_a_of_type_Bhjd;
  private static WeakReference<bhkb> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bhkb parambhkb)
  {
    if ((jdField_a_of_type_Bhjd != null) && (jdField_a_of_type_Bhjd.b()))
    {
      if (parambhkb != null) {
        parambhkb.onQzonePluginClientReady(jdField_a_of_type_Bhjd);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhkb);
    bhix.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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
 * Qualified Name:     bhjz
 * JD-Core Version:    0.7.0.1
 */