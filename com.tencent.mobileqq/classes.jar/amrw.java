import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class amrw
  extends amti
{
  protected long a;
  private String a;
  protected long b;
  
  protected void a()
  {
    boolean bool2 = true;
    super.a();
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    if (this.d >= 3L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) {
        break label203;
      }
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(bool1, new String[] { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", this.jdField_a_of_type_JavaLangString });
      this.d = 0L;
      if (!bool1) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      }
    }
    if ((this.jdField_a_of_type_Long >= 15L) && (!DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.disable_qzone_kill.name())))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString != null)
      {
        bool1 = true;
        label139:
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b(bool1, "com.tencent.mobileqq:qzone");
        bcew.a().d(bcew.a());
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else if (this.b >= GuardManager.d) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) {
        break label213;
      }
    }
    label203:
    label213:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b(bool1, "com.tencent.mobileqq:tool");
      this.b = 0L;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label139;
    }
  }
  
  protected void a(String paramString)
  {
    if (!"com.tencent.mobileqq".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
      aowc.a();
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    QQAppInterface.getBatteryStats().c();
    amrq.a().a(paramString);
    apoh.a(true);
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    CoreService.startCoreService(amtg.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if ("com.tencent.mobileqq".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      aowc.b();
      apoh.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrw
 * JD-Core Version:    0.7.0.1
 */