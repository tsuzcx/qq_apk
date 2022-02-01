package com.tencent.common.app;

import abix;
import aczh;
import aczi;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public class MSFInterfaceAdapterImpl$1
  implements Runnable
{
  public MSFInterfaceAdapterImpl$1(abix paramabix) {}
  
  public void run()
  {
    aczh localaczh = aczi.a(BaseApplicationImpl.sApplication, "dex");
    if ((localaczh != null) && (localaczh.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName, localaczh.b(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.MSFInterfaceAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */