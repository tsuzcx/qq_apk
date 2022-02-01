import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class bbxw
{
  private static boolean a;
  
  public static boolean a()
  {
    boolean bool = false;
    if (a) {
      return true;
    }
    String str = bbxj.c();
    if (str == null) {
      return false;
    }
    if (!FileUtils.fileExists(str + "libObjectTracker.so")) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, " isTrackingSoExist =" + bool);
      }
      a = bool;
      return a;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxw
 * JD-Core Version:    0.7.0.1
 */