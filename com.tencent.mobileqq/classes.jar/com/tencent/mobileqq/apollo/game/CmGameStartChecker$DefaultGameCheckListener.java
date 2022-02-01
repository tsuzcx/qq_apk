package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class CmGameStartChecker$DefaultGameCheckListener
  implements OnGameStartCheckListener
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  
  public CmGameStartChecker$DefaultGameCheckListener(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt) {}
  
  public void a(StartCheckParam paramStartCheckParam) {}
  
  public void a(StartCheckParam paramStartCheckParam, int paramInt) {}
  
  public void a(StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void a(StartCheckParam paramStartCheckParam, String paramString)
  {
    if (paramStartCheckParam == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onSsoCmdRuleRsp startCheckParam == null");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("StartCheckParam", paramStartCheckParam);
      ((Bundle)localObject).putString("rule", paramString);
      paramStartCheckParam.mSSORule = paramString;
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_set_sso_rule", (Bundle)localObject, null);
      return;
    }
    Object localObject = CmGameUtil.a();
    if (localObject != null) {
      ((CmGameManager)localObject).a(paramStartCheckParam.gameId, paramString);
    }
  }
  
  public void b(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void c(StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onGameCheckStart startCheckParam == null");
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
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
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if ((localObject instanceof QQAppInterface)) {
          ApolloGameUtil.a((QQAppInterface)localObject, paramStartCheckParam);
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
    QLog.e("cmgame_process.CmGameStartChecker", 1, "onDownloadGameResDown startCheckParam == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameStartChecker.DefaultGameCheckListener
 * JD-Core Version:    0.7.0.1
 */