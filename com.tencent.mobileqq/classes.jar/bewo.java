import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bewo
{
  public static boolean a;
  private bewq a;
  
  public bewo()
  {
    this.jdField_a_of_type_Bewq = new bewq();
    a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name()));
    a();
  }
  
  private void a()
  {
    DeviceProfileManager.a(new bewp(this));
  }
  
  public bewq a()
  {
    return this.jdField_a_of_type_Bewq.a();
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
      this.jdField_a_of_type_Bewq.d = (Integer.valueOf(paramString[0]).intValue() * 1000);
      this.jdField_a_of_type_Bewq.e = (Integer.valueOf(paramString[1]).intValue() * 1000);
      this.jdField_a_of_type_Bewq.f = (Integer.valueOf(paramString[2]).intValue() * 1000);
      this.jdField_a_of_type_Bewq.a = (Integer.valueOf(paramString[3]).intValue() * 1000);
      this.jdField_a_of_type_Bewq.b = (Integer.valueOf(paramString[4]).intValue() * 1000);
      this.jdField_a_of_type_Bewq.c = (Integer.valueOf(paramString[5]).intValue() * 1000);
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
 * Qualified Name:     bewo
 * JD-Core Version:    0.7.0.1
 */