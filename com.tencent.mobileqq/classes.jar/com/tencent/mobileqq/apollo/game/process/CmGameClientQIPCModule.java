package com.tencent.mobileqq.apollo.game.process;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

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
    return CmGameClientQIPCModule.CmGameClientClass.a();
  }
  
  public static void b()
  {
    CmGameClientQIPCModule localCmGameClientQIPCModule = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localCmGameClientQIPCModule);
      a = true;
    }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall main server action=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("cmgame_process.CmGameClientQIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      if ("action_set_sso_rule".equals(paramString))
      {
        paramString = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        paramBundle = paramBundle.getString("rule");
        if (paramString != null)
        {
          if (TextUtils.isEmpty(paramBundle)) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_SET_SSO_RULE startCheckParam:", paramString, " rule:", paramBundle });
          }
          localObject = CmGameUtil.c();
          if (localObject != null)
          {
            ((CmGameManager)localObject).a(paramString.gameId, paramBundle);
            return null;
          }
        }
        else
        {
          return null;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameClientQIPCModule", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */