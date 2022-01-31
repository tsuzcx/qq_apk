import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class bgpj
{
  public static final String a = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/mini/";
  public static final String b = a + "navigateback_appid";
  
  public static void a(String paramString)
  {
    Object localObject = new File(b);
    do
    {
      try
      {
        localObject = new BufferedWriter(new FileWriter((File)localObject));
        QMLog.e("NavigateBackUtils", "getTagAppid exception!", paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpj
 * JD-Core Version:    0.7.0.1
 */