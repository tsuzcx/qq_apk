package com.tencent.mobileqq.apollo.game.process;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
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
    return CmGameClientQIPCModule.CmgameClientClass.a();
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
    if (3112 == paramInt) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.excute(new CmGameClientQIPCModule.1(paramInt), 16, null, false);
      return;
    }
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
      if ("action_close_game".equals(paramString))
      {
        CmGameUtil.a(paramBundle.getInt("gameId"));
        return null;
      }
      boolean bool = "action_set_sso_rule".equals(paramString);
      if (bool)
      {
        paramString = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        paramBundle = paramBundle.getString("rule");
        if (paramString == null) {
          break label339;
        }
        if (TextUtils.isEmpty(paramBundle)) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_SET_SSO_RULE startCheckParam:", paramString, " rule:", paramBundle });
        }
        localObject = CmGameUtil.a();
        if (localObject != null)
        {
          ((CmGameManager)localObject).a(paramString.gameId, paramBundle);
          return null;
        }
      }
      else
      {
        if ("action_start_cmgame_direct".equals(paramString))
        {
          QLog.e("cmgame_process.CmGameClientQIPCModule", 1, "ACTION_START_CMGAME_DIRECT");
          return null;
        }
        if ("action_check_game_data".equals(paramString))
        {
          paramString = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (paramString == null) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_CHECK_GAME_DATA startCheckParam", paramString });
          }
          paramString = CmGameUtil.a(paramString.gameId);
          if (paramString != null)
          {
            paramString.a(paramBundle);
            return null;
          }
        }
        else if ("action_game_loading_closed".equals(paramString))
        {
          paramString = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (paramString == null) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameClientQIPCModule", 2, new Object[] { "ACTION_GAME_LOADING_CLOSED startCheckParam", paramString });
          }
          paramString = CmGameUtil.a(paramString.gameId);
          if (paramString != null)
          {
            paramString = paramString.a();
            if (paramString != null)
            {
              paramString.finish();
              return null;
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameClientQIPCModule", 1, paramString, new Object[0]);
    }
    return null;
    label339:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */