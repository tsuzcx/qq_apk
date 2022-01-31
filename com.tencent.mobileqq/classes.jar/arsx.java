import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class arsx
{
  private static arsx jdField_a_of_type_Arsx;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.qflutterCfg.name();
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private arsx()
  {
    DeviceProfileManager.a(new arsy(this));
    a();
  }
  
  public static arsx a()
  {
    if (jdField_a_of_type_Arsx == null) {}
    try
    {
      if (jdField_a_of_type_Arsx == null) {
        jdField_a_of_type_Arsx = new arsx();
      }
      return jdField_a_of_type_Arsx;
    }
    finally {}
  }
  
  public void a()
  {
    String str = DeviceProfileManager.b().a(jdField_a_of_type_JavaLangString);
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length < 2) {}
    }
    for (;;)
    {
      try
      {
        if (Integer.valueOf(arrayOfString[0]).intValue() != 1) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        if (jdField_a_of_type_JavaUtilRandom.nextFloat() >= Float.valueOf(arrayOfString[1]).floatValue()) {
          continue;
        }
        this.b = true;
      }
      catch (Exception localException)
      {
        QLog.d("QFlutterDPC", 1, "loadConfig exception :" + localException.getMessage());
        this.b = true;
        this.jdField_a_of_type_Boolean = true;
        continue;
        this.b = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QFlutterDPC", 2, String.format("loadConfig, dpcValue: %s, mIsSupport: %s, mNeedReport: %s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b) }));
      }
      return;
      this.jdField_a_of_type_Boolean = false;
      continue;
      this.b = true;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsx
 * JD-Core Version:    0.7.0.1
 */