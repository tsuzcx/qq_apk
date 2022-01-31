import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class blav
{
  public static int a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Int = 1500;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportHwCodec=" + jdField_a_of_type_Boolean);
    }
    boolean bool = axhq.a(axhq.r);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:black=" + bool);
      }
    }
    while (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blav
 * JD-Core Version:    0.7.0.1
 */