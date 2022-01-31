import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bhxe
{
  private static bhxe jdField_a_of_type_Bhxe;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.homeworkCfg.name();
  private int jdField_a_of_type_Int = 22;
  private ajuz jdField_a_of_type_Ajuz = new bhxf(this);
  
  private bhxe()
  {
    DeviceProfileManager.a(this.jdField_a_of_type_Ajuz);
    a();
  }
  
  public static bhxe a()
  {
    if (jdField_a_of_type_Bhxe == null) {}
    try
    {
      if (jdField_a_of_type_Bhxe == null) {
        jdField_a_of_type_Bhxe = new bhxe();
      }
      return jdField_a_of_type_Bhxe;
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
      if (arrayOfString.length < 1) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkDpcCfg", 2, String.format("loadConfig, mUseNewApiLevel: %s, dpc=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("HomeworkDpcCfg", 1, "loadConfig exception :" + localException.getMessage());
        this.jdField_a_of_type_Int = 22;
        continue;
      }
      this.jdField_a_of_type_Int = 22;
    }
  }
  
  public boolean a()
  {
    QLog.d("HomeworkDpcCfg", 1, String.format("hwUseNewAPI thisVer=%d cfgVer=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(this.jdField_a_of_type_Int) }));
    return Build.VERSION.SDK_INT <= this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhxe
 * JD-Core Version:    0.7.0.1
 */