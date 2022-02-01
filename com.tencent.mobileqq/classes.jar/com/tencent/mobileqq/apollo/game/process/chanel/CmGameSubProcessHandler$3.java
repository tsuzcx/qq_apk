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

class CmGameSubProcessHandler$3
  extends ResultReceiver
{
  CmGameSubProcessHandler$3(CmGameSubProcessHandler paramCmGameSubProcessHandler, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject1 = CmGameUtil.a(CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler));
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((CmGameLauncher)localObject1).a();
    if (localObject1 == null) {
      return;
    }
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
    CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_Long, 0, (CmGameLauncher.RedPacketInfo)localObject1);
    boolean bool = "0".equals(((CmGameLauncher.RedPacketInfo)localObject1).f);
    paramBundle = (IQWalletApi)QRoute.api(IQWalletApi.class);
    Object localObject2 = ((CmGameLauncher.RedPacketInfo)localObject1).b;
    long l = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int);
    localStringBuilder.append("");
    paramBundle.reqReportHBGame((String)localObject2, l, localStringBuilder.toString(), Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_JavaLangString), bool, false, CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler.3
 * JD-Core Version:    0.7.0.1
 */