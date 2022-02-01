package com.tencent.biz.pubaccount.readinjoy.reward;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskRemoteRepo$reportTaskCompleted$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskRemoteRepo$reportTaskCompleted$1
  extends ProtoUtils.TroopProtocolObserver
{
  RIJRewardTaskRemoteRepo$reportTaskCompleted$1(RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    QLog.i("RIJRewardTaskRemoteRepo", 1, "report task completed onResult() <-- errorCode: " + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = this.a;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a();
      }
    }
    do
    {
      return;
      paramArrayOfByte = this.a;
    } while (paramArrayOfByte == null);
    paramArrayOfByte.a(paramInt, "");
  }
  
  public boolean a(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    QLog.e("RIJRewardTaskRemoteRepo", 1, "report task completed onError() <-- errorCode: " + paramInt + ", errorMsg: " + paramString);
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.a(paramInt, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.reportTaskCompleted.1
 * JD-Core Version:    0.7.0.1
 */