package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.tianshu.TianShuManager;
import java.util.Map;

class QQSettingMeKingCardProcessor$3
  implements TianShuGetAdvCallback
{
  QQSettingMeKingCardProcessor$3(QQSettingMeKingCardProcessor paramQQSettingMeKingCardProcessor) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (paramBoolean)
    {
      if (paramGetAdsRsp == null) {
        return;
      }
      QQSettingMeKingCardProcessor.b((String)TianShuManager.getInstance().parseGetAdsRsp(paramGetAdsRsp, 76).get("information"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeKingCardProcessor.3
 * JD-Core Version:    0.7.0.1
 */