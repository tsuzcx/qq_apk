import android.os.Debug;
import com.tencent.mobileqq.app.AppConstants;
import java.io.IOException;

public class bkxy
{
  private static boolean jdField_a_of_type_Boolean;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "35872667", "354653668", "270749863", "279242625", "1849510872" };
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(paramString))
        {
          localObject = AppConstants.SDCARD_IMG_SAVE + "dump_";
          try
          {
            Debug.dumpHprofData((String)localObject + paramString + System.currentTimeMillis());
            jdField_a_of_type_Boolean = true;
            return;
          }
          catch (IOException paramString)
          {
            return;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxy
 * JD-Core Version:    0.7.0.1
 */