package com.tencent.mobileqq.ark.api.scheme;

import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopArkHelper$2
  extends TroopObserver
{
  TroopArkHelper$2(TroopArkHelper paramTroopArkHelper) {}
  
  protected void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    this.a.a().removeObserver(this);
    paramBundle = new TroopInfoData();
    paramBundle.isMember = true;
    boolean bool = QLog.isColorLevel();
    int i = 0;
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBatchGetTroopInfoResp, isSucc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", resp IsNull=");
      if (paramRespBatchProcess == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ark.Troop", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0))
    {
      int j = paramRespBatchProcess.batch_response_list.size();
      while (i < j)
      {
        localObject = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localObject != null) && (((BatchResponse)localObject).result == 0) && (((BatchResponse)localObject).type == 1))
        {
          TroopInfo localTroopInfo = ((TroopManager)this.a.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a.a);
          this.a.a((BatchResponse)localObject, paramBundle, localTroopInfo);
        }
        i += 1;
      }
      if (j > 0)
      {
        paramRespBatchProcess = this.a;
        TroopArkHelper.a(paramRespBatchProcess, paramRespBatchProcess.a, paramBundle);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ark.Troop", 2, "onBatchGetTroopInfoResp, return");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TroopArkHelper.2
 * JD-Core Version:    0.7.0.1
 */