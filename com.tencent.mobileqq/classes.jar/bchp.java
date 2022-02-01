import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class bchp
{
  public static int a;
  public static boolean a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_Int = 1500;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportHwCodec=" + jdField_a_of_type_Boolean);
    }
    boolean bool = bcif.a(bcif.r);
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
  
  public static boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportPre_SendEncode=" + b + "dpcSupportHwCodec=" + jdField_a_of_type_Boolean);
    }
    if (Build.VERSION.SDK_INT < 18) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return false;
          bool = bcif.e(bcif.o);
          if (!bool) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool);
        return false;
        bool = bcif.a(bcif.r);
        if (!bool) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool + " hardware Black");
      return false;
    } while ((!b) || (!jdField_a_of_type_Boolean));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchp
 * JD-Core Version:    0.7.0.1
 */