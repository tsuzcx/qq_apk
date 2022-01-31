import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class bdwe
{
  public static File a(Context paramContext)
  {
    return bdwf.a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "GLDrawableV833.zip";
    }
    return paramContext + File.separator + "GLDrawableV833.zip";
  }
  
  public static void a()
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(1004L, "GLDrawableV833", "GLDrawable");
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
      File localFile1;
      try
      {
        localFile1 = a(paramContext);
        paramContext = a(paramContext);
        try
        {
          String str1 = localFile1.getAbsolutePath() + "_temp";
          File localFile2 = new File(str1);
          if (localFile2.exists()) {
            bdhb.a(str1, false);
          }
          bdhb.a(paramContext, str1, false);
          if (localFile1.exists()) {
            bdhb.a(localFile1.getAbsolutePath(), false);
          }
          int j = 1;
          boolean bool = true;
          String[] arrayOfString = localFile2.list();
          if (arrayOfString != null)
          {
            int i = arrayOfString.length;
            paramInt = 0;
            j = bool;
            if (paramInt < i)
            {
              String str2 = arrayOfString[paramInt];
              if (!str2.startsWith("crc_")) {
                break label453;
              }
              File localFile3 = new File(localFile2, "gldrawable.dex");
              File localFile4 = new File(localFile2, "jni/armeabi-v7a/libgldrawable.so");
              File localFile5 = new File(localFile2, "jni/arm64-v8a/libgldrawable.so");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("crc_");
              localStringBuilder.append(Long.toHexString(IOUtil.getCRC32Value(localFile3))).append("_");
              localStringBuilder.append(Long.toHexString(IOUtil.getCRC32Value(localFile4))).append("_");
              localStringBuilder.append(Long.toHexString(IOUtil.getCRC32Value(localFile5)));
              bool = str2.toLowerCase().equals(localStringBuilder.toString().toLowerCase());
              break label453;
            }
          }
          if (j == 0) {
            continue;
          }
          bdhb.c(str1, localFile1.getAbsolutePath());
          QLog.d("GLDrawable", 1, "unzip succ..." + new File(paramContext).length() + "..." + bflr.a(paramContext));
        }
        catch (IOException localIOException)
        {
          bdwh.a("unzip", localIOException.getMessage());
          QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + localFile1, " zipPath=" + paramContext, localIOException });
          continue;
        }
        return;
      }
      finally {}
      bdwh.a("unzip", "unzip crc not valid.");
      continue;
      QLog.e("GLDrawable", 1, "error: " + paramInt);
      continue;
      label453:
      paramInt += 1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return new File(a(paramContext)).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwe
 * JD-Core Version:    0.7.0.1
 */