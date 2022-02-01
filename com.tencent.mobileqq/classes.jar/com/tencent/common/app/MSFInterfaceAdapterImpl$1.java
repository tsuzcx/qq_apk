package com.tencent.common.app;

import abet;
import acvd;
import acve;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public class MSFInterfaceAdapterImpl$1
  implements Runnable
{
  public MSFInterfaceAdapterImpl$1(abet paramabet) {}
  
  public void run()
  {
    acvd localacvd = acve.a(BaseApplicationImpl.sApplication, "dex");
    if ((localacvd != null) && (localacvd.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName, localacvd.b(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.MSFInterfaceAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */