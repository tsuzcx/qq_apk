import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import java.io.File;

public class bdgd
{
  public static bdgc a;
  public static String a = "1.2.0";
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.w("Tissue", "tissueEngineDir is empty");
      return false;
    }
    Object localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      Log.w("Tissue", localObject1 + " not exists or not a dir");
      return false;
    }
    localObject1 = EngineVersion.a(((File)localObject1).getName());
    Object localObject2 = a;
    bdnw.b("Tissue", "currentVersion:" + localObject1 + ",requiredVersion:" + (String)localObject2);
    if ((localObject1 != null) && (EngineVersion.a(((EngineVersion)localObject1).b, (String)localObject2) >= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        bdnw.b("Tissue", "versionCheck:" + bool);
        return false;
      }
      localObject1 = new String[3];
      localObject1[0] = "libtv8rt.so";
      localObject1[1] = "libflutter.so";
      localObject1[2] = "libapp.so";
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = new File(paramString, localObject1[i]);
        if (!((File)localObject2).exists())
        {
          Log.w("Tissue", ((File)localObject2).getAbsolutePath() + " not exists");
          return false;
        }
        if (!((File)localObject2).isFile())
        {
          Log.w("Tissue", ((File)localObject2).getAbsolutePath() + " not a file");
          return false;
        }
        if (!((File)localObject2).canRead())
        {
          Log.w("Tissue", ((File)localObject2).getAbsolutePath() + " not readable");
          return false;
        }
        i += 1;
      }
      Log.i("Tissue", paramString + " is fine");
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdgd
 * JD-Core Version:    0.7.0.1
 */