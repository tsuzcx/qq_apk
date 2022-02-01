package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.game.process.data.CmGameMainManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class CmGameHandler
  implements CmGameCmdChannel.IRequestHandler
{
  private int jdField_a_of_type_Int;
  private CmGameMainManager jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager;
  
  public int a()
  {
    return 200;
  }
  
  public HandleResult a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    CmGameMainManager localCmGameMainManager = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager;
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (localCmGameMainManager == null) {
        return null;
      }
      if (this.jdField_a_of_type_Int != paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.jdField_a_of_type_Int), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
        }
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        localCmGameMainManager.a(paramString2, paramInt1);
        return null;
      }
      if ("cs.on_get_open_key.local".equals(paramString1)) {
        localCmGameMainManager.b(paramString2, paramInt1);
      }
    }
    return null;
  }
  
  public CmGameMainManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager;
  }
  
  public void a()
  {
    QLog.i("[cmshow]CmGameHandler", 1, "[destroyHandler]");
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameHandler
 * JD-Core Version:    0.7.0.1
 */