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
  private void a()
  {
    PatchConfig localPatchConfig = PatchConfigManager.b(BaseApplicationImpl.sApplication, "dex");
    if (localPatchConfig != null)
    {
      a(localPatchConfig);
      b(localPatchConfig);
    }
  }
  
  private void a(PatchConfig paramPatchConfig)
  {
    Object localObject = GuardManager.sInstance;
    if (localObject == null) {
      return;
    }
    if (!paramPatchConfig.a(BaseApplicationImpl.sApplication, "com.tencent.mobileqq:MSF")) {
      return;
    }
    paramPatchConfig = paramPatchConfig.e();
    if (!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramPatchConfig)) {
      return;
    }
    if (((GuardManager)localObject).mFgProcess != null) {
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
    ((StringBuilder)localObject).append(DexPatchInstaller.b);
    ((StringBuilder)localObject).append(", installStatus=");
    ((StringBuilder)localObject).append(DexPatchInstaller.a);
    QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
    MsfServiceSdk.get().onKillProcess();
  }
  
  private void b(PatchConfig paramPatchConfig)
  {
    Object localObject = GuardManager.sInstance;
    if (localObject == null) {
      return;
    }
    if (!paramPatchConfig.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName)) {
      return;
    }
    paramPatchConfig = paramPatchConfig.e();
    if (!PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, paramPatchConfig)) {
      return;
    }
    if (((GuardManager)localObject).mFgProcess != null) {
      return;
    }
    if (DexPatchInstaller.a != 0) {
      return;
    }
    if (DexPatchInstaller.b.equals(paramPatchConfig)) {
      return;
    }
    localObject = new StringBuilder("GuardManager exit Main Process to install patch, target patchName=");
    ((StringBuilder)localObject).append(paramPatchConfig);
    ((StringBuilder)localObject).append(", installed patchName=");
    ((StringBuilder)localObject).append(DexPatchInstaller.b);
    ((StringBuilder)localObject).append(", installStatus=");
    ((StringBuilder)localObject).append(DexPatchInstaller.a);
    QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
    System.exit(-1);
  }
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground() {}
  
  public void onBackgroundTimeTick(long paramLong)
  {
    if ((paramLong == 50L) || (paramLong == 51L)) {
      a();
    }
  }
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.PatchProcessor
 * JD-Core Version:    0.7.0.1
 */