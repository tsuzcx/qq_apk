package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.GroupPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

class AIOTroopQcircleRedDotManager$7
  implements VSDispatchObserver.onVSRspCallBack<QQCircleCounter.CountInfoRsp>
{
  AIOTroopQcircleRedDotManager$7(AIOTroopQcircleRedDotManager paramAIOTroopQcircleRedDotManager, ArrayMap paramArrayMap, String paramString, TroopChatPie paramTroopChatPie, List paramList) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramCountInfoRsp != null))
    {
      if (paramCountInfoRsp.extInfo.mapInfo.size() > 1)
      {
        AIOTroopQcircleRedDotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager, Integer.valueOf(((FeedCloudCommon.Entry)paramCountInfoRsp.extInfo.mapInfo.get(0)).value.get()).intValue() * 1000);
        AIOTroopQcircleRedDotManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager, Integer.valueOf(((FeedCloudCommon.Entry)paramCountInfoRsp.extInfo.mapInfo.get(1)).value.get()).intValue());
      }
      if (paramCountInfoRsp.rptRedPoint.size() == this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.size())
      {
        int i = 0;
        if (i < paramCountInfoRsp.rptRedPoint.size())
        {
          String str = ((QQCircleCounter.GroupPointInfo)((QQCircleCounter.RedPointInfo)paramCountInfoRsp.rptRedPoint.get(i)).groupInfo.get()).touin.get();
          if (((QQCircleCounter.GroupPointInfo)((QQCircleCounter.RedPointInfo)paramCountInfoRsp.rptRedPoint.get(i)).groupInfo.get()).num.get() != 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramString = ((QQCircleCounter.GroupPointInfo)((QQCircleCounter.RedPointInfo)paramCountInfoRsp.rptRedPoint.get(i)).groupInfo.get()).jumpSchema.get();
            paramLong = System.currentTimeMillis();
            paramBaseRequest = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              paramBaseRequest = paramString;
              if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
                paramBaseRequest = paramString + "&xsj_share_from_group_id=" + this.jdField_a_of_type_JavaLangString;
              }
            }
            this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.put(str, new QcircleRedDotEntity(str, paramBoolean, paramLong, paramBaseRequest));
            i += 1;
            break;
          }
        }
      }
      else
      {
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "size of reddot rsp not equals to size of req");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a != null)) {
        ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.7.1(this));
      }
      AIOTroopQcircleRedDotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager, AIOTroopQcircleRedDotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager), this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.values());
      LocalMultiProcConfig.putLong("qcircle_troop_redpoint_pull_time_threshold", AIOTroopQcircleRedDotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager));
      LocalMultiProcConfig.putLong("qcircle_troop_redpoint_pull_amount_threshold", AIOTroopQcircleRedDotManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager));
      QZLog.d("AIOTroopQcircleRedDotManager", 2, "new timeLimits from backend: " + AIOTroopQcircleRedDotManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager));
      QZLog.d("AIOTroopQcircleRedDotManager", 2, "new amountLimits from backend: " + AIOTroopQcircleRedDotManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.7
 * JD-Core Version:    0.7.0.1
 */