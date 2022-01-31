import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import java.io.File;

public class bekd
{
  public static bekc a;
  public static String a = "1.2.0";
  
  public static boolean a(String paramString)
  {
    String str = a;
    return a(paramString, new String[] { "libtv8rt.so", "libflutter.so", "libapp.so" }, str);
  }
  
  public static boolean a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("Tissue", "basePath is empty");
      return false;
    }
    Object localObject = new File(paramString1);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      Log.w("Tissue", localObject + " not exists or not a dir");
      return false;
    }
    localObject = EngineVersion.a(((File)localObject).getName());
    besl.b("Tissue", "currentVersion:" + localObject + ",requiredVersion:" + paramString2);
    if ((localObject != null) && (EngineVersion.a(((EngineVersion)localObject).b, paramString2) >= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        besl.b("Tissue", "versionCheck:" + bool);
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = new File(paramString1, paramArrayOfString[i]);
        if (!paramString2.exists())
        {
          Log.w("Tissue", paramString2.getAbsolutePath() + " not exists");
          return false;
        }
        if (!paramString2.isFile())
        {
          Log.w("Tissue", paramString2.getAbsolutePath() + " not a file");
          return false;
        }
        if (!paramString2.canRead())
        {
          Log.w("Tissue", paramString2.getAbsolutePath() + " not readable");
          return false;
        }
        i += 1;
      }
      Log.i("Tissue", paramString1 + " is fine");
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekd
 * JD-Core Version:    0.7.0.1
 */