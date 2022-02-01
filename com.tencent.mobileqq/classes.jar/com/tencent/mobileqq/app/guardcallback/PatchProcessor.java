package com.tencent.mobileqq.app.guardcallback;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;

public class PatchProcessor
  implements IGuardInterface
{
  private void a(PatchConfig paramPatchConfig)
  {
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramPatchConfig.a(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF"));
        paramPatchConfig = paramPatchConfig.b();
      } while ((!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramPatchConfig)) || (((GuardManager)localObject).jdField_a_of_type_JavaLangString != null));
      localObject = PatchSharedPreUtil.getInstalledPatchName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF");
    } while ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramPatchConfig)));
    PatchSharedPreUtil.saveInstalledPatchName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF", paramPatchConfig);
    QLog.d("PatchLogTag", 1, "GuardManager exit MSF Process to install patch, target patchName=" + paramPatchConfig + ", installed patchName=" + DexPatchInstaller.jdField_a_of_type_JavaLangString + ", installStatus=" + DexPatchInstaller.jdField_a_of_type_Int);
    MsfServiceSdk.get().onKillProcess();
  }
  
  private void b(PatchConfig paramPatchConfig)
  {
    GuardManager localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if (localGuardManager == null) {}
    do
    {
      do
      {
        return;
      } while (!paramPatchConfig.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName));
      paramPatchConfig = paramPatchConfig.b();
    } while ((!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramPatchConfig)) || (localGuardManager.jdField_a_of_type_JavaLangString != null) || (DexPatchInstaller.jdField_a_of_type_Int != 0) || (DexPatchInstaller.jdField_a_of_type_JavaLangString.equals(paramPatchConfig)));
    QLog.d("PatchLogTag", 1, "GuardManager exit Main Process to install patch, target patchName=" + paramPatchConfig + ", installed patchName=" + DexPatchInstaller.jdField_a_of_type_JavaLangString + ", installStatus=" + DexPatchInstaller.jdField_a_of_type_Int);
    System.exit(-1);
  }
  
  private void c()
  {
    PatchConfig localPatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "dex");
    if (localPatchConfig != null)
    {
      a(localPatchConfig);
      b(localPatchConfig);
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    if ((paramLong == 50L) || (paramLong == 51L)) {
      c();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.PatchProcessor
 * JD-Core Version:    0.7.0.1
 */