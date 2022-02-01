import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class anqt
  extends anvw
{
  private String a;
  
  private void a(float paramFloat)
  {
    float f;
    if (MagnifierSDK.a().a().d > 0.0F)
    {
      f = MagnifierSDK.a().a().d;
      if (MagnifierSDK.a().a().jdField_b_of_type_Long <= 0L) {
        break label94;
      }
    }
    label94:
    for (long l = MagnifierSDK.a().a().jdField_b_of_type_Long;; l = 50L)
    {
      if ((MagnifierSDK.a().a().jdField_b_of_type_Boolean) && (paramFloat >= f) && (this.c >= l)) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
      }
      return;
      f = 0.95F;
      break;
    }
  }
  
  private void a(aclx paramaclx)
  {
    if (!paramaclx.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName)) {}
    do
    {
      return;
      paramaclx = paramaclx.b();
    } while ((!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramaclx)) || (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString != null) || (acln.jdField_a_of_type_Int != 0) || (acln.jdField_a_of_type_JavaLangString.equals(paramaclx)));
    QLog.d("PatchLogTag", 1, "GuardManager exit Main Process to install patch, target patchName=" + paramaclx + ", installed patchName=" + acln.jdField_a_of_type_JavaLangString + ", installStatus=" + acln.jdField_a_of_type_Int);
    System.exit(-1);
  }
  
  private void b(aclx paramaclx)
  {
    String str1 = BaseApplicationImpl.sApplication.getPackageName() + ":MSF";
    if (!paramaclx.a(BaseApplicationImpl.sApplication, str1)) {}
    String str2;
    do
    {
      do
      {
        return;
        paramaclx = paramaclx.b();
      } while ((!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramaclx)) || (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString != null));
      str2 = PatchSharedPreUtil.getInstalledPatchName(BaseApplicationImpl.sApplication, str1);
    } while ((!TextUtils.isEmpty(str2)) && (str2.equals(paramaclx)));
    PatchSharedPreUtil.saveInstalledPatchName(BaseApplicationImpl.sApplication, str1, paramaclx);
    QLog.d("PatchLogTag", 1, "GuardManager exit MSF Process to install patch, target patchName=" + paramaclx + ", installed patchName=" + acln.jdField_a_of_type_JavaLangString + ", installStatus=" + acln.jdField_a_of_type_Int);
    MsfServiceSdk.get().onKillProcess();
  }
  
  private void c()
  {
    aclx localaclx = acly.a(BaseApplicationImpl.sApplication, "dex");
    if (localaclx != null)
    {
      b(localaclx);
      a(localaclx);
    }
  }
  
  private void d()
  {
    if ((this.d == GuardManager.e) || (this.d == GuardManager.e + 1))
    {
      if (!"com.tencent.mobileqq:qzone".equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b(false, "com.tencent.mobileqq:qzone");
      }
      GuardManager.a(false);
    }
  }
  
  private void e()
  {
    if (((this.d == GuardManager.d) || (this.d == GuardManager.d + 1)) && (!"com.tencent.mobileqq:tool".equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b(false, "com.tencent.mobileqq:tool");
    }
  }
  
  private void f()
  {
    if ((this.d == 1L) && (SetSplash.a()) && (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
      }
      bdla.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
      System.exit(-1);
    }
  }
  
  protected void a()
  {
    this.c += 1L;
    this.d += 1L;
    f();
    a(MemoryManager.getInstance().getHeapLevel());
    int i = anvu.a().a(MemoryManager.getMemory(Process.myPid()));
    int j = anvu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b);
    long l = anvu.a().b[(i + j)] / 12000;
    if (this.c >= l) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
    }
    while ((this.d == 50L) || (this.d == 51L))
    {
      GuardManager.a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[0]);
      c();
      return;
      if (this.d == 1L)
      {
        MemoryManager.getInstance().reportMemoryLevel(1L);
        MemoryManager.getInstance().reportMemory("BG_GUARD");
      }
      else if ((this.d == 3L) || (this.d == 4L))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(false, new String[] { "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:tool", this.jdField_a_of_type_JavaLangString });
      }
    }
    d();
    e();
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
    if ("com.tencent.mobileqq".equals(paramString)) {
      apzg.a();
    }
  }
  
  protected void b()
  {
    if (this.c > 2L) {
      this.c -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.c = (anvu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryManager.getMemory(Process.myPid())) / 12000L - 2L);
    }
    CoreService.startCoreService(anvu.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b();
    aqfv.a();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(1, 0L, 0L);
    if ("com.tencent.mobileqq".equals(paramString)) {
      apzg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anqt
 * JD-Core Version:    0.7.0.1
 */