import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class baqm
{
  public static File a(Context paramContext)
  {
    return baqn.a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "gldrawable.zip";
    }
    return paramContext + File.separator + "gldrawable.zip";
  }
  
  public static void a()
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(1004L, "GLDrawable", "GLDrawable");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      File localFile;
      try
      {
        localFile = a(paramContext);
        paramContext = a(paramContext);
        try
        {
          String str = localFile.getAbsolutePath() + "_temp";
          if (new File(str).exists()) {
            bace.a(str, false);
          }
          bace.a(paramContext, str, false);
          if (localFile.exists()) {
            bace.a(localFile.getAbsolutePath(), false);
          }
          bace.c(str, localFile.getAbsolutePath());
          QLog.d("GLDrawable", 1, "unzip succ");
        }
        catch (IOException localIOException)
        {
          baqn.b("unzip", localIOException.getMessage());
          QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + localFile, " zipPath=" + paramContext, localIOException });
          continue;
        }
        return;
      }
      finally {}
      QLog.e("GLDrawable", 1, "error: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqm
 * JD-Core Version:    0.7.0.1
 */