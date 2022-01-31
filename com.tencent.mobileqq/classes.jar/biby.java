import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class biby
{
  public static String a;
  
  public static boolean a(long paramLong, Context paramContext)
  {
    a = ajed.ba + "QQEditPic" + File.separator;
    paramContext = new File(a);
    boolean bool1 = paramContext.mkdirs();
    boolean bool2 = paramContext.isDirectory();
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "thumbFilesDirPath=" + bool1 + " isdir=" + bool2);
    }
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biby
 * JD-Core Version:    0.7.0.1
 */