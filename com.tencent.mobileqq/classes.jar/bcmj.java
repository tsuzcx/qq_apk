import com.tencent.qphone.base.util.QLog;

public class bcmj
{
  private static boolean a;
  
  public static boolean a()
  {
    boolean bool = false;
    if (a) {
      return true;
    }
    String str = bcls.c();
    if (str == null) {
      return false;
    }
    if (!bgmg.a(str + "libObjectTracker.so")) {}
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
 * Qualified Name:     bcmj
 * JD-Core Version:    0.7.0.1
 */