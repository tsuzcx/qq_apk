package com.tencent.hotpatch;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

final class DexPatchInstaller$1
  implements Runnable
{
  DexPatchInstaller$1(PatchConfig paramPatchConfig, Context paramContext) {}
  
  public void run()
  {
    String str = this.a.e();
    int i = PatchSharedPreUtil.getCountFailStartupPatch(this.b, BaseApplicationImpl.processName, str);
    if (i <= 5) {
      PatchSharedPreUtil.updateCountFailStartupPatch(this.b, BaseApplicationImpl.processName, str, i + 1);
    }
    PatchConfigManager.a(this.b, this.a);
    if ((501 == DexPatchInstaller.a) || (502 == DexPatchInstaller.a))
    {
      i = PatchSharedPreUtil.getCountFailInstallPatch(this.b, BaseApplicationImpl.processName, str);
      PatchSharedPreUtil.updateCountFailInstallPatch(this.b, BaseApplicationImpl.processName, str, i + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.DexPatchInstaller.1
 * JD-Core Version:    0.7.0.1
 */