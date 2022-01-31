import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class bbsy
{
  public static File a(Context paramContext)
  {
    return bbsz.a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "GLDrawableV828.zip";
    }
    return paramContext + File.separator + "GLDrawableV828.zip";
  }
  
  public static void a()
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(1004L, "GLDrawableV828", "GLDrawable");
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
            bbdx.a(str, false);
          }
          bbdx.a(paramContext, str, false);
          if (localFile.exists()) {
            bbdx.a(localFile.getAbsolutePath(), false);
          }
          bbdx.c(str, localFile.getAbsolutePath());
          QLog.d("GLDrawable", 1, "unzip succ..." + new File(paramContext).length() + "..." + bdik.a(paramContext));
        }
        catch (IOException localIOException)
        {
          bbtb.a("unzip", localIOException.getMessage());
          QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + localFile, " zipPath=" + paramContext, localIOException });
          continue;
        }
        return;
      }
      finally {}
      QLog.e("GLDrawable", 1, "error: " + paramInt);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return new File(a(paramContext)).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsy
 * JD-Core Version:    0.7.0.1
 */