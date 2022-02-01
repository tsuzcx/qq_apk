import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class bmea
{
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bmeb();
  static bmde jdField_a_of_type_Bmde;
  private static WeakReference<bmec> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(Context paramContext, bmec parambmec)
  {
    if ((jdField_a_of_type_Bmde != null) && (jdField_a_of_type_Bmde.b()))
    {
      if (parambmec != null) {
        parambmec.a(jdField_a_of_type_Bmde);
      }
      return;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmec);
    bmcy.a().a(paramContext, jdField_a_of_type_AndroidContentServiceConnection, 0);
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
 * Qualified Name:     bmea
 * JD-Core Version:    0.7.0.1
 */