import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class axlu
{
  public static int a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = -4;
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = axlc.e(BaseApplicationImpl.getContext());
    if (str == null) {
      return false;
    }
    if (!bbdj.a(str + "libObjectTracker.so")) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, " isTrackingSoExist =" + bool);
      }
      jdField_a_of_type_Boolean = bool;
      return jdField_a_of_type_Boolean;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlu
 * JD-Core Version:    0.7.0.1
 */