import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bncm
{
  public static String a;
  
  public static boolean a()
  {
    a = amro.a + "QQEditPic" + File.separator;
    File localFile = new File(a);
    boolean bool1 = localFile.mkdirs();
    boolean bool2 = localFile.isDirectory();
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "thumbFilesDirPath=" + bool1 + " isdir=" + bool2);
    }
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncm
 * JD-Core Version:    0.7.0.1
 */