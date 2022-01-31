import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.lang.ref.WeakReference;

public class bgxm
{
  private static int jdField_a_of_type_Int;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(WeakReference<Activity> paramWeakReference, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if ((!jdField_a_of_type_Boolean) && (GameWnsUtils.enableStorageExceedDialog()))
    {
      jdField_a_of_type_Int += 1;
      if (jdField_a_of_type_Int >= GameWnsUtils.enableStorageExceedLimit())
      {
        jdField_a_of_type_Boolean = true;
        if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
          bgnc.a((Activity)paramWeakReference.get(), paramString, paramMiniAppInfo, GameWnsUtils.getCacheFreeContent());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxm
 * JD-Core Version:    0.7.0.1
 */