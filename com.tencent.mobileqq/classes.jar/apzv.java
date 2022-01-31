import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class apzv
{
  private static apzv jdField_a_of_type_Apzv;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.qflutterCfg.name();
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ajuz jdField_a_of_type_Ajuz = new apzw(this);
  
  private apzv()
  {
    DeviceProfileManager.a(this.jdField_a_of_type_Ajuz);
    a();
  }
  
  public static apzv a()
  {
    if (jdField_a_of_type_Apzv == null) {}
    try
    {
      if (jdField_a_of_type_Apzv == null) {
        jdField_a_of_type_Apzv = new apzv();
      }
      return jdField_a_of_type_Apzv;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = DeviceProfileManager.b().a(jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 2) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        this.jdField_a_of_type_Float = Float.valueOf(localObject[1]).floatValue();
        if (QLog.isColorLevel()) {
          QLog.d("QFlutterDPC", 2, String.format("loadConfig, mFlutterSwitch: %s, mPerformanceReportRate = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(this.jdField_a_of_type_Float) }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("QFlutterDPC", 1, "loadConfig exception :" + localException.getMessage());
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Float = 1.0F;
        continue;
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Float = 1.0F;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b()
  {
    return jdField_a_of_type_JavaUtilRandom.nextFloat() <= this.jdField_a_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzv
 * JD-Core Version:    0.7.0.1
 */