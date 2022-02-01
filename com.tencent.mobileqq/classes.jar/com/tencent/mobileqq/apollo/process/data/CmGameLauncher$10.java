package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CmGameLauncher$10
  implements EIPCResultCallback
{
  CmGameLauncher$10(CmGameLauncher paramCmGameLauncher) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    long l1 = 0L;
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null)) {}
    Activity localActivity;
    do
    {
      int i;
      CmGameInitParams localCmGameInitParams;
      do
      {
        return;
        i = paramEIPCResult.data.getInt("result");
        localActivity = this.a.a();
        if (i != 0) {
          break;
        }
        long l2 = paramEIPCResult.data.getLong("ResultCode");
        localCmGameInitParams = (CmGameInitParams)paramEIPCResult.data.getSerializable("CmGameInitParams");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "queryCheckGameFromMainProcess onCallback cmGameInitParams", localCmGameInitParams });
        }
        if ((l2 != 0L) || (localCmGameInitParams == null)) {
          break;
        }
      } while (!(localActivity instanceof ApolloGameActivity));
      if (CmGameLauncher.a(this.a) == null) {}
      for (;;)
      {
        paramEIPCResult = (CmGameStartChecker.StartCheckParam)paramEIPCResult.data.getSerializable("StartCheckParam");
        this.a.b(paramEIPCResult);
        CmGameUtil.a(new Object[] { "[checkFinish], loading from main process but waiting for tool, before cost:", Long.valueOf(l1) });
        ((ApolloGameActivity)localActivity).a(paramEIPCResult);
        ((ApolloGameActivity)localActivity).a(localCmGameInitParams);
        return;
        l1 = System.currentTimeMillis() - CmGameLauncher.a(this.a).mCreateTs;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, new Object[] { "queryCheckGameFromMainProcess onCallback result:", Integer.valueOf(i) });
      if ((localActivity instanceof ApolloGameActivity)) {
        ((ApolloGameActivity)localActivity).i();
      }
    } while (localActivity == null);
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.10
 * JD-Core Version:    0.7.0.1
 */