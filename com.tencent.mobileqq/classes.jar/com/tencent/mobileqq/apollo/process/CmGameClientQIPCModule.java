package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import eipc.EIPCResult;
import ywh;

public class CmGameClientQIPCModule
  extends QIPCModule
{
  public static boolean a;
  
  public CmGameClientQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static CmGameClientQIPCModule a()
  {
    return ywh.a();
  }
  
  public static void a()
  {
    CmGameClientQIPCModule localCmGameClientQIPCModule = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localCmGameClientQIPCModule);
      a = true;
    }
  }
  
  public static void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("gameId", paramInt);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_close_game", localBundle, null);
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramString.equals("action_close_game")) {
      CmGameUtil.a(paramBundle.getInt("gameId"));
    }
    return null;
  }
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle)
  {
    super.onReceiveMsg(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */