import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import io.flutter.util.PathUtils;
import java.io.File;

public class auot
{
  private static final String a = AppConstants.SDCARD_ROOT + File.separator + "qflutter";
  private static final String b = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "qflutter" + File.separator;
  
  public static void a()
  {
    if (FileUtil.isFileExists(a))
    {
      int i = FileUtils.copyDirectory(a, b, false, true, true);
      if (i == 0)
      {
        QLog.d("QFlutter.launcher", 4, String.format("checkDebugInstall copy result: %s", new Object[] { Integer.valueOf(i) }));
        File[] arrayOfFile = new File(b).listFiles();
        int j = arrayOfFile.length;
        i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          QLog.d("QFlutter.launcher", 4, String.format("path: %s, time: %s, size: %s byte", new Object[] { localFile.getAbsolutePath(), Long.valueOf(localFile.lastModified()), Long.valueOf(localFile.length()) }));
          i += 1;
        }
        b();
        auoy.a().a(true, b, true, true);
        return;
      }
    }
    auoy.a().a(false, b, true, true);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static void b()
  {
    String str1 = PathUtils.getDataDirectory(BaseApplicationImpl.getContext());
    Object localObject = new File(str1);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).list(new auou());
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str2 = localObject[i];
        File localFile = new File(str1, str2);
        FileUtil.deleteFile(localFile);
        QLog.d("QFlutter.launcher", 4, "clearTimestamp: " + str2 + ", " + localFile.getAbsolutePath());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auot
 * JD-Core Version:    0.7.0.1
 */