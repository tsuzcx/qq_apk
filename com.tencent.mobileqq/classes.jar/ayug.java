import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ayug
{
  public static boolean a;
  private ayui a;
  
  public ayug()
  {
    this.jdField_a_of_type_Ayui = new ayui();
    a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name()));
    a();
  }
  
  private void a()
  {
    DeviceProfileManager.a(new ayuh(this));
  }
  
  public ayui a()
  {
    return this.jdField_a_of_type_Ayui.a();
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
      this.jdField_a_of_type_Ayui.d = (Integer.valueOf(paramString[0]).intValue() * 1000);
      this.jdField_a_of_type_Ayui.e = (Integer.valueOf(paramString[1]).intValue() * 1000);
      this.jdField_a_of_type_Ayui.f = (Integer.valueOf(paramString[2]).intValue() * 1000);
      this.jdField_a_of_type_Ayui.a = (Integer.valueOf(paramString[3]).intValue() * 1000);
      this.jdField_a_of_type_Ayui.b = (Integer.valueOf(paramString[4]).intValue() * 1000);
      this.jdField_a_of_type_Ayui.c = (Integer.valueOf(paramString[5]).intValue() * 1000);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayug
 * JD-Core Version:    0.7.0.1
 */