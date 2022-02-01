import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class anmi
{
  public static final int a;
  public static final long a;
  public static final String a;
  public static final String b;
  public static final String c;
  public long b;
  public long c;
  public long d;
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceInfoUtil.getModel();
    b = DeviceInfoUtil.getDeviceOSVersion();
    c = DeviceInfoUtil.getCpuType();
    jdField_a_of_type_Int = DeviceInfoUtil.getCpuNumber();
    jdField_a_of_type_Long = DeviceInfoUtil.getCpuFrequency();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmi
 * JD-Core Version:    0.7.0.1
 */