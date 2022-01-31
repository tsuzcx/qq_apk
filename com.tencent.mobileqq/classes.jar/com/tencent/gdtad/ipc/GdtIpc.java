package com.tencent.gdtad.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class GdtIpc
  extends QIPCModule
{
  private static GdtIpc a;
  
  private GdtIpc(String paramString)
  {
    super(paramString);
  }
  
  public static GdtIpc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new GdtIpc("gdt_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    GdtLog.b("gdt_ipc", "Action  " + paramString);
    if ("do_app_jump".equals(paramString))
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        paramString = (GdtAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110);
        paramBundle = (GdtBaseAdItem)paramBundle.getSerializable("gdtBaseAdItem");
        paramString.a(BaseApplicationImpl.getContext(), paramBundle);
        callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      }
    }
    else {
      return null;
    }
    callbackResult(paramInt, EIPCResult.createResult(-1, null));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.ipc.GdtIpc
 * JD-Core Version:    0.7.0.1
 */