package com.tencent.common.app;

import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

class MSFInterfaceAdapterImpl$1
  implements Runnable
{
  MSFInterfaceAdapterImpl$1(MSFInterfaceAdapterImpl paramMSFInterfaceAdapterImpl) {}
  
  public void run()
  {
    PatchConfig localPatchConfig = PatchConfigManager.a(BaseApplicationImpl.sApplication, "dex");
    if ((localPatchConfig != null) && (localPatchConfig.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName, localPatchConfig.b(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.MSFInterfaceAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */