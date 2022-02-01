package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class DefaultGameCheckListener
  implements OnGameStartCheckListener
{
  private AppInterface a;
  private final boolean b;
  
  public DefaultGameCheckListener(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.a = paramAppInterface;
    this.b = paramBoolean;
  }
  
  public void a(int paramInt) {}
  
  public void a(StartCheckParam paramStartCheckParam) {}
  
  public void a(StartCheckParam paramStartCheckParam, int paramInt) {}
  
  public void a(StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void a(StartCheckParam paramStartCheckParam, String paramString)
  {
    if (paramStartCheckParam == null)
    {
      QLog.e("cmgame_process.DefaultGameCheckListener", 1, "onSsoCmdRuleRsp startCheckParam == null");
      return;
    }
    if (this.b)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("StartCheckParam", paramStartCheckParam);
      ((Bundle)localObject).putString("rule", paramString);
      paramStartCheckParam.mSSORule = paramString;
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_set_sso_rule", (Bundle)localObject, null);
      return;
    }
    Object localObject = CmGameUtil.c();
    if (localObject != null) {
      ((CmGameManager)localObject).a(paramStartCheckParam.gameId, paramString);
    }
  }
  
  public void b(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void c(StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null)
    {
      QLog.e("cmgame_process.DefaultGameCheckListener", 1, "onGameCheckStart startCheckParam == null");
      return;
    }
    if (!this.b)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "onGameCheckStart", localBundle, null);
    }
  }
  
  public void d(StartCheckParam paramStartCheckParam) {}
  
  public void e(StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null))
    {
      Object localObject;
      if (this.b)
      {
        localObject = this.a;
        if ((localObject instanceof QQAppInterface)) {
          ApolloGameResManager.a((QQAppInterface)localObject, paramStartCheckParam);
        }
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("StartCheckParam", paramStartCheckParam);
        QIPCClientHelper.getInstance().callServer("cm_game_module", "onDownloadGameResDown", (Bundle)localObject, null);
      }
      return;
    }
    QLog.e("cmgame_process.DefaultGameCheckListener", 1, "onDownloadGameResDown startCheckParam == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.DefaultGameCheckListener
 * JD-Core Version:    0.7.0.1
 */