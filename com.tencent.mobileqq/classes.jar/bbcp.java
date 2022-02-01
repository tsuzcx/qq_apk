import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bbcp
{
  private static bbcp jdField_a_of_type_Bbcp;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.troubleShootCfg.name();
  private int jdField_a_of_type_Int = 1;
  private ante jdField_a_of_type_Ante = new bbcq(this);
  
  private bbcp()
  {
    DeviceProfileManager.a(this.jdField_a_of_type_Ante);
    a();
  }
  
  public static bbcp a()
  {
    if (jdField_a_of_type_Bbcp == null) {}
    try
    {
      if (jdField_a_of_type_Bbcp == null) {
        jdField_a_of_type_Bbcp = new bbcp();
      }
      return jdField_a_of_type_Bbcp;
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
          QLog.d("TroubleShootCfg", 2, String.format("loadConfig dpc=%s", new Object[] { str }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("TroubleShootCfg", 1, "loadConfig exception :" + localException.getMessage());
        this.jdField_a_of_type_Int = 1;
        continue;
      }
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("TroubleShootCfg", 1, String.format("shouldPhoneContactUseNewUinType=%b", new Object[] { Boolean.valueOf(bool) }));
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcp
 * JD-Core Version:    0.7.0.1
 */