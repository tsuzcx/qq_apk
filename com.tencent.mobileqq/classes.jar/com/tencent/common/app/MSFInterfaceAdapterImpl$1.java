package com.tencent.common.app;

import aafg;
import abvq;
import abvr;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public class MSFInterfaceAdapterImpl$1
  implements Runnable
{
  public MSFInterfaceAdapterImpl$1(aafg paramaafg) {}
  
  public void run()
  {
    abvq localabvq = abvr.a(BaseApplicationImpl.sApplication, "dex");
    if ((localabvq != null) && (localabvq.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName, localabvq.b(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.MSFInterfaceAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */