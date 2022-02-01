package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

class CmGameMainManager$OpenKeyObserver
  extends WtloginObserver
{
  public int a;
  public int b;
  
  public void onGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      paramString = util.buf_to_string(paramArrayOfByte2);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("OnGetOpenKeyWithoutPasswd token:");
        paramArrayOfByte1.append(paramString);
        QLog.i("cmgame_process.CmGameMainManager", 2, paramArrayOfByte1.toString());
      }
      paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager.a();
      if (paramArrayOfByte1 == null) {
        return;
      }
      try
      {
        paramArrayOfByte2 = new JSONObject();
        paramArrayOfByte2.put("appId", paramLong2);
        paramArrayOfByte2.put("gameId", this.jdField_a_of_type_Int);
        paramArrayOfByte2.put("openKey", paramString);
        CmGameCmdChannel.a(paramArrayOfByte1).a(0, "cs.on_get_open_key.local", paramArrayOfByte2.toString(), this.b);
        paramArrayOfByte1 = ((ApolloDaoManagerServiceImpl)paramArrayOfByte1.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager.a.gameId);
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1.openKey = paramString;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "OpenKeyObserver error:", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameMainManager.OpenKeyObserver
 * JD-Core Version:    0.7.0.1
 */