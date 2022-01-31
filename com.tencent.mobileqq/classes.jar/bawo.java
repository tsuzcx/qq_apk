import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bawo
{
  public static boolean a;
  private bawq a;
  
  public bawo()
  {
    this.jdField_a_of_type_Bawq = new bawq();
    a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name()));
    a();
  }
  
  private void a()
  {
    DeviceProfileManager.a(new bawp(this));
  }
  
  public bawq a()
  {
    return this.jdField_a_of_type_Bawq.a();
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "OldEngine Timeout Params : " + paramString);
      }
      paramString = paramString.split("\\|");
    } while ((paramString == null) || (paramString.length != 6));
    try
    {
      this.jdField_a_of_type_Bawq.d = (Integer.valueOf(paramString[0]).intValue() * 1000);
      this.jdField_a_of_type_Bawq.e = (Integer.valueOf(paramString[1]).intValue() * 1000);
      this.jdField_a_of_type_Bawq.f = (Integer.valueOf(paramString[2]).intValue() * 1000);
      this.jdField_a_of_type_Bawq.a = (Integer.valueOf(paramString[3]).intValue() * 1000);
      this.jdField_a_of_type_Bawq.b = (Integer.valueOf(paramString[4]).intValue() * 1000);
      this.jdField_a_of_type_Bawq.c = (Integer.valueOf(paramString[5]).intValue() * 1000);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawo
 * JD-Core Version:    0.7.0.1
 */