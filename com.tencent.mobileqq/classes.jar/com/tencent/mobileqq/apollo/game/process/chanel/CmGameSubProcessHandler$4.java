package com.tencent.mobileqq.apollo.game.process.chanel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.RedPacketInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.qphone.base.util.QLog;

class CmGameSubProcessHandler$4
  extends ResultReceiver
{
  CmGameSubProcessHandler$4(CmGameSubProcessHandler paramCmGameSubProcessHandler, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject1 = CmGameUtil.a(CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler));
    if (localObject1 == null)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleUpdateGameScore] launch is null");
      return;
    }
    localObject1 = ((CmGameLauncher)localObject1).a();
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[handleUpdateGameScore] rst:");
        ((StringBuilder)localObject2).append(paramBundle.toString());
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, ((StringBuilder)localObject2).toString());
      }
      ((CmGameLauncher.RedPacketInfo)localObject1).f = paramBundle.getString("state", "-1");
      ((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
    }
    ((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_Int = 3;
    if ((localObject1 != null) && (((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Boolean))
    {
      CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_Long, 0, (CmGameLauncher.RedPacketInfo)localObject1);
      boolean bool = ((CmGameLauncher.RedPacketInfo)localObject1).f.equals("0");
      paramBundle = (IQWalletApi)QRoute.api(IQWalletApi.class);
      localObject2 = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_JavaLangString;
      long l = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Long;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int);
      localStringBuilder.append("");
      paramBundle.reqReportHBGame((String)localObject2, l, localStringBuilder.toString(), Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_JavaLangString), bool, false, CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler.4
 * JD-Core Version:    0.7.0.1
 */