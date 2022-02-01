import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.io.File;
import mqq.app.AppRuntime;

public class bgia
{
  public static File a(Context paramContext)
  {
    return bgih.a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "GLDrawableV848.zip";
    }
    return paramContext + File.separator + "GLDrawableV848.zip";
  }
  
  public static void a()
  {
    try
    {
      a(false);
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
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        QLog.e("GLDrawableDownloadHelper", 1, "error: " + paramInt);
        return;
      }
      finally {}
      paramContext = bgio.a();
      if ((paramContext instanceof bgic)) {
        ((bgic)paramContext).b();
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface)) {
          ((VasQuickUpdateManager)((AppRuntime)localObject1).getManager(184)).downloadItem(1004L, "GLDrawableV848", "gldrawable");
        }
        return;
      }
      finally {}
      Object localObject1 = new bgib();
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gk.k, null, (EIPCResultCallback)localObject1);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return new File(a(paramContext)).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgia
 * JD-Core Version:    0.7.0.1
 */