import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aobd
{
  private static final aobd jdField_a_of_type_Aobd = new aobd();
  private static String jdField_a_of_type_JavaLangString = aobd.class.getSimpleName();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "motorola", "mot", "FIH", "Sony Ericsson", "samsung", "HTC", "HUN", "LGE", "alps", "OPPO", "TCL", "LENOVO", "ZTE", "Meizu", "Xiaomi", "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", "asus", "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", "nubia", "KONKA" };
  private static final String[] b = { "MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", "TCL", "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA" };
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private aobd()
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_ArrayOfJavaLangString[i].toUpperCase(), b[i]);
      i += 1;
    }
    a();
  }
  
  public static aobd a()
  {
    return jdField_a_of_type_Aobd;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "****** DeviceInfo  (+) *****");
      QLog.i(jdField_a_of_type_JavaLangString, 2, "BRAND_KEYS.len = " + jdField_a_of_type_ArrayOfJavaLangString.length);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "BRAND_NAMES.len = " + b.length);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DeviceTypeName = " + a());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "SubTagName = " + a() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "MODEL = " + Build.MODEL);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "SDK_INT = " + Build.VERSION.SDK_INT);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "BRAND = " + Build.BRAND);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DEVICE = " + Build.DEVICE);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DISPLAY = " + Build.DISPLAY);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "HARDWARE = " + Build.HARDWARE);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "MANUFACTURER = " + Build.MANUFACTURER);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "PRODUCT = " + Build.PRODUCT);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "TAGS = " + Build.TAGS);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "USER = " + Build.USER);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "TYPE = " + Build.TYPE);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "****** DeviceInfo (-) *****");
    }
  }
  
  public String a()
  {
    String str;
    if (Build.MODEL.equalsIgnoreCase("K-Touch W619")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("TIANYU") + " " + Build.MODEL;
    }
    for (;;)
    {
      return str.replace(" ", "_").replace("+", "").replace("(t)", "");
      if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD"))) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("COOLPAD") + " " + Build.MODEL;
      } else {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Build.MANUFACTURER.toUpperCase()) + " " + Build.MODEL;
      }
    }
  }
  
  public String b()
  {
    return a() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobd
 * JD-Core Version:    0.7.0.1
 */