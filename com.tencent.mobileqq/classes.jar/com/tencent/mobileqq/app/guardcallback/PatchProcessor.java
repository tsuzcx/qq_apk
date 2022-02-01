package com.tencent.mobileqq.app.guardcallback;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;

public class PatchProcessor
  implements IGuardInterface
{
  private void a(PatchConfig paramPatchConfig)
  {
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
    if (localObject == null) {
      return;
    }
    if (!paramPatchConfig.a(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF")) {
      return;
    }
    paramPatchConfig = paramPatchConfig.b();
    if (!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramPatchConfig)) {
      return;
    }
    if (((GuardManager)localObject).jdField_a_of_type_JavaLangString != null) {
      return;
    }
    localObject = PatchSharedPreUtil.getInstalledPatchName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramPatchConfig))) {
      return;
    }
    PatchSharedPreUtil.saveInstalledPatchName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF", paramPatchConfig);
    localObject = new StringBuilder("GuardManager exit MSF Process to install patch, target patchName=");
    ((StringBuilder)localObject).append(paramPatchConfig);
    ((StringBuilder)localObject).append(", installed patchName=");
    ((StringBuilder)localObject).append(DexPatchInstaller.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", installStatus=");
    ((StringBuilder)localObject).append(DexPatchInstaller.jdField_a_of_type_Int);
    QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
    MsfServiceSdk.get().onKillProcess();
  }
  
  private void b(PatchConfig paramPatchConfig)
  {
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
    if (localObject == null) {
      return;
    }
    if (!paramPatchConfig.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName)) {
      return;
    }
    paramPatchConfig = paramPatchConfig.b();
    if (!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramPatchConfig)) {
      return;
    }
    if (((GuardManager)localObject).jdField_a_of_type_JavaLangString != null) {
      return;
    }
    if (DexPatchInstaller.jdField_a_of_type_Int != 0) {
      return;
    }
    if (DexPatchInstaller.jdField_a_of_type_JavaLangString.equals(paramPatchConfig)) {
      return;
    }
    localObject = new StringBuilder("GuardManager exit Main Process to install patch, target patchName=");
    ((StringBuilder)localObject).append(paramPatchConfig);
    ((StringBuilder)localObject).append(", installed patchName=");
    ((StringBuilder)localObject).append(DexPatchInstaller.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", installStatus=");
    ((StringBuilder)localObject).append(DexPatchInstaller.jdField_a_of_type_Int);
    QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
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
  
  public void G_() {}
  
  public void H_() {}
  
  public void a(long paramLong)
  {
    if ((paramLong == 50L) || (paramLong == 51L)) {
      c();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.PatchProcessor
 * JD-Core Version:    0.7.0.1
 */