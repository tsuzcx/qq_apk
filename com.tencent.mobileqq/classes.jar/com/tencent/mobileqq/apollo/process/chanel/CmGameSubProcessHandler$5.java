package com.tencent.mobileqq.apollo.process.chanel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class CmGameSubProcessHandler$5
  extends ResultReceiver
{
  CmGameSubProcessHandler$5(CmGameSubProcessHandler paramCmGameSubProcessHandler, Handler paramHandler, long paramLong)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
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
        ((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_Int = 3;
        if ((localObject != null) && (((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Boolean))
        {
          CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler, this.jdField_a_of_type_Long, 0, (CmGameLauncher.RedPacketInfo)localObject);
          if (!((CmGameLauncher.RedPacketInfo)localObject).f.equals("0")) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      QWalletTools.a(((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_JavaLangString, ((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Long, ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_JavaLangString), bool, false, CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler));
      return;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleUpdateGameScore] launch is null");
      return;
      label210:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.5
 * JD-Core Version:    0.7.0.1
 */