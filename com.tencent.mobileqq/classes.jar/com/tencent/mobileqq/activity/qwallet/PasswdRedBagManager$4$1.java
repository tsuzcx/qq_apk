package com.tencent.mobileqq.activity.qwallet;

import Wallet.BroadCastInfo;
import Wallet.GetBroadCastHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.observer.BusinessObserver;

class PasswdRedBagManager$4$1
  implements BusinessObserver
{
  PasswdRedBagManager$4$1(PasswdRedBagManager.4 param4) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 28)
    {
      paramBundle = (GetBroadCastHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null) {
        break label21;
      }
    }
    for (;;)
    {
      return;
      label21:
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a = false;
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          BroadCastInfo localBroadCastInfo = (BroadCastInfo)paramBundle.sendlistIdiomInfoDict.get(str);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(str) != null) && (localBroadCastInfo != null)) {
            if (localBroadCastInfo.isFinished == 1) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(str);
            } else {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(str, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localBroadCastInfo.idiomSeq, localBroadCastInfo.hbIdiom, localBroadCastInfo.hbIdiomLastPY, localBroadCastInfo.hbPoemRule);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.4.1
 * JD-Core Version:    0.7.0.1
 */