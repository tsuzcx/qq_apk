import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apzp
  extends aojs
{
  apzp(apzn paramapzn) {}
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    this.a.a().removeObserver(this);
    paramBundle = new TroopInfoData();
    paramBundle.isMember = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onBatchGetTroopInfoResp, isSucc=").append(paramBoolean).append(", resp IsNull=");
      if (paramRespBatchProcess == null)
      {
        paramBoolean = true;
        QLog.d("ark.Troop", 2, paramBoolean);
      }
    }
    else
    {
      if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0)) {
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ark.Troop", 2, "onBatchGetTroopInfoResp, return");
      }
    }
    label121:
    int j;
    do
    {
      return;
      paramBoolean = false;
      break;
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        localObject = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localObject == null) || (((BatchResponse)localObject).result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((BatchResponse)localObject).type == 1)
          {
            TroopInfo localTroopInfo = ((TroopManager)this.a.a().getManager(52)).b(this.a.a);
            this.a.a((BatchResponse)localObject, paramBundle, localTroopInfo);
          }
        }
      }
    } while (j <= 0);
    apzn.a(this.a, this.a.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzp
 * JD-Core Version:    0.7.0.1
 */