package com.tencent.mobileqq.activity.pendant;

import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;

class AvatarPendantActivity$31
  implements TianShuGetAdvCallback
{
  AvatarPendantActivity$31(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (paramGetAdsRsp != null)
      {
        bool1 = bool2;
        if (!paramGetAdsRsp.mapAds.isEmpty())
        {
          paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.mapAds.get(0);
          if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (!paramGetAdsRsp.value.lst.isEmpty()))
          {
            paramGetAdsRsp = (TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0);
            if (paramGetAdsRsp != null)
            {
              AvatarPendantActivity.b(this.a, paramGetAdsRsp.iAdId.get());
              AvatarPendantActivity.e(this.a, paramGetAdsRsp.traceinfo.get());
              bool1 = true;
            }
            else
            {
              QLog.e("AvatarPendantActivity", 1, new Object[] { "onGetAdvs", "no adItem" });
              bool1 = bool2;
            }
          }
          else
          {
            QLog.e("AvatarPendantActivity", 1, new Object[] { "onGetAdvs", " no ad data" });
            bool1 = bool2;
          }
        }
      }
    }
    paramGetAdsRsp = new StringBuilder();
    paramGetAdsRsp.append("getCmshowAvatarRedDot should show:");
    paramGetAdsRsp.append(bool1);
    QLog.d("AvatarPendantActivity", 1, paramGetAdsRsp.toString());
    this.a.ao.putBoolean("cmshow_avatar_red_dot", bool1);
    this.a.ao.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.31
 * JD-Core Version:    0.7.0.1
 */