package com.tencent.mobileqq.apollo.cmgame;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
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
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString)
  {
    if (paramStartCheckParam == null) {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onSsoCmdRuleRsp startCheckParam == null");
    }
    Object localObject;
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("StartCheckParam", paramStartCheckParam);
        ((Bundle)localObject).putString("rule", paramString);
        paramStartCheckParam.mSSORule = paramString;
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_set_sso_rule", (Bundle)localObject, null);
        return;
      }
      localObject = CmGameUtil.a();
    } while (localObject == null);
    ((CmGameManager)localObject).a(paramStartCheckParam.gameId, paramString);
  }
  
  public void b(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onGameCheckStart startCheckParam == null");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
    ApolloGameUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramStartCheckParam);
    return;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "onGameCheckStart", localBundle, null);
  }
  
  public void c(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void d(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void e(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onDownloadGameResDown startCheckParam == null");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
    ApolloGameUtil.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramStartCheckParam);
    return;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "onDownloadGameResDown", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener
 * JD-Core Version:    0.7.0.1
 */