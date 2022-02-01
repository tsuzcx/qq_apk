import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bnsl
{
  private static bnsl jdField_a_of_type_Bnsl;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.homeworkCfg.name();
  private int jdField_a_of_type_Int = 22;
  private anwh jdField_a_of_type_Anwh = new bnsm(this);
  
  private bnsl()
  {
    DeviceProfileManager.a(this.jdField_a_of_type_Anwh);
    a();
  }
  
  public static bnsl a()
  {
    if (jdField_a_of_type_Bnsl == null) {}
    try
    {
      if (jdField_a_of_type_Bnsl == null) {
        jdField_a_of_type_Bnsl = new bnsl();
      }
      return jdField_a_of_type_Bnsl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsl
 * JD-Core Version:    0.7.0.1
 */