import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aufk
{
  private static final String a = anhk.aZ + File.separator + "qflutter";
  private static final String b = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "qflutter-so" + File.separator;
  
  public static void a()
  {
    if (atwl.a(a))
    {
      int i = bgmg.a(a, b, false, true, true);
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
        aufo.a().a(true, b, true, true);
        return;
      }
    }
    aufo.a().a(false, b, true, true);
  }
  
  public static boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufk
 * JD-Core Version:    0.7.0.1
 */