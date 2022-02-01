package com.tencent.common.app;

import aaus;
import aclx;
import acly;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public class MSFInterfaceAdapterImpl$1
  implements Runnable
{
  public MSFInterfaceAdapterImpl$1(aaus paramaaus) {}
  
  public void run()
  {
    aclx localaclx = acly.a(BaseApplicationImpl.sApplication, "dex");
    if ((localaclx != null) && (localaclx.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName, localaclx.b(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.MSFInterfaceAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */