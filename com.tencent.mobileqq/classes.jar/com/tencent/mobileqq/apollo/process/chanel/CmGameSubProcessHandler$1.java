package com.tencent.mobileqq.apollo.process.chanel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class CmGameSubProcessHandler$1
  extends ResultReceiver
{
  CmGameSubProcessHandler$1(CmGameSubProcessHandler paramCmGameSubProcessHandler, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject = CmGameUtil.a(CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler));
    if (localObject != null)
    {
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject != null)
      {
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[handleUpdateGameScore] rst:" + paramBundle.toString());
          }
          ((CmGameLauncher.RedPacketInfo)localObject).f = paramBundle.getString("state", "-1");
          ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("amount", "0");
        }
        CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_Long, 0, (CmGameLauncher.RedPacketInfo)localObject);
        if (!"0".equals(((CmGameLauncher.RedPacketInfo)localObject).f)) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      QWalletTools.a(((CmGameLauncher.RedPacketInfo)localObject).b, ((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Long, ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_JavaLangString), bool, false, CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1
 * JD-Core Version:    0.7.0.1
 */