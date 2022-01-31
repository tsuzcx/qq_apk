import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class bekv
{
  public static final String a = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini/";
  public static final String b = a + "navigateback_appid";
  
  public static void a(String paramString)
  {
    Object localObject = new File(b);
    do
    {
      try
      {
        localObject = new BufferedWriter(new FileWriter((File)localObject));
        besl.d("NavigateBackUtils", "getTagAppid exception!", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          ((BufferedWriter)localObject).write(paramString);
          ((BufferedWriter)localObject).close();
          return;
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = paramString;
        localObject = null;
      }
    } while (localObject == null);
    try
    {
      ((BufferedWriter)localObject).close();
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekv
 * JD-Core Version:    0.7.0.1
 */