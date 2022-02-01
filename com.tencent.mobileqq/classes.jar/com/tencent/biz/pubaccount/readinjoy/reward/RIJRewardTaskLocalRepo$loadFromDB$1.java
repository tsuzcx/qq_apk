package com.tencent.biz.pubaccount.readinjoy.reward;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.os.MqqHandler;
import qxt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJRewardTaskLocalRepo$loadFromDB$1
  implements Runnable
{
  public RIJRewardTaskLocalRepo$loadFromDB$1(qxt paramqxt) {}
  
  public final void run()
  {
    try
    {
      List localList = qxt.a(this.this$0).createEntityManager().query(RedPacketTaskData.class, true, null, null, null, null, "insertTime desc", "500");
      if (localList == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.tencent.biz.pubaccount.readinjoy.reward.RedPacketTaskData>");
      }
    }
    catch (Exception localException)
    {
      QLog.e("RIJRewardTaskRepo", 1, QLog.getStackTraceString((Throwable)localException));
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new RIJRewardTaskLocalRepo.loadFromDB.1.1(this, localException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.loadFromDB.1
 * JD-Core Version:    0.7.0.1
 */