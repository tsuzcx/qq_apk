package com.tencent.mobileqq.activity.aio;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleCounter.GroupInfo;
import qqcircle.QQCircleCounter.GroupInfoRsp;

class AIOTroopQcircleRedDotManager$8
  implements VSDispatchObserver.onVSRspCallBack<QQCircleCounter.GroupInfoRsp>
{
  AIOTroopQcircleRedDotManager$8(AIOTroopQcircleRedDotManager paramAIOTroopQcircleRedDotManager, List paramList1, String paramString, TroopChatPie paramTroopChatPie, List paramList2) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleCounter.GroupInfoRsp paramGroupInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramGroupInfoRsp != null)
      {
        if (paramGroupInfoRsp.groupinfo.size() == this.a.size())
        {
          int i = 0;
          while (i < paramGroupInfoRsp.groupinfo.size())
          {
            if (((QQCircleCounter.GroupInfo)paramGroupInfoRsp.groupinfo.get(i)).isOpen.get()) {
              AIOTroopQcircleRedDotManager.e(this.e).put(((QQCircleCounter.GroupInfo)paramGroupInfoRsp.groupinfo.get(i)).groupid.get(), Integer.valueOf(1));
            } else {
              AIOTroopQcircleRedDotManager.e(this.e).remove(((QQCircleCounter.GroupInfo)paramGroupInfoRsp.groupinfo.get(i)).groupid.get());
            }
            i += 1;
          }
        }
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "size of troop greyinfo rsp not equals to size of req");
        this.e.a(this.b, this.c, this.d);
        paramBaseRequest = this.e;
        AIOTroopQcircleRedDotManager.a(paramBaseRequest, AIOTroopQcircleRedDotManager.e(paramBaseRequest).keySet());
        AIOTroopQcircleRedDotManager.c(this.e, System.currentTimeMillis());
        AIOTroopQcircleRedDotManager.d(this.e, paramGroupInfoRsp.nextTime.get() * 1000);
        LocalMultiProcConfig.putLong("qcircle_troop_redpoint_grey_last_timestamp", AIOTroopQcircleRedDotManager.f(this.e));
        LocalMultiProcConfig.putLong("qcircle_troop_redpoint_grey_time_threshold", AIOTroopQcircleRedDotManager.g(this.e));
        paramBaseRequest = new StringBuilder();
        paramBaseRequest.append("new greyTimeLimits from backend: ");
        paramBaseRequest.append(AIOTroopQcircleRedDotManager.g(this.e));
        QZLog.d("AIOTroopQcircleRedDotManager", 2, paramBaseRequest.toString());
      }
    }
    else {
      this.e.a(this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.8
 * JD-Core Version:    0.7.0.1
 */