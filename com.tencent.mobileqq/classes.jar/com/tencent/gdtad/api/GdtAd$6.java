package com.tencent.gdtad.api;

import android.os.SystemClock;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class GdtAd$6
  implements GdtAdLoader.Listener
{
  GdtAd$6(GdtAd paramGdtAd) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    if ((paramGdtAdLoader == GdtAd.access$100(this.a)) && (this.a.isValid()) && (this.a.getParams().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet != null))
    {
      GdtAdError localGdtAdError = null;
      int j = -2147483648;
      if ((paramGdtAdLoader == null) || (paramGdtAdLoader.a() == null)) {
        i = -2147483648;
      }
      do
      {
        k = -2147483648;
        paramGdtAdLoader = localGdtAdError;
        break;
        long l = paramGdtAdLoader.a().jdField_a_of_type_Long;
        i = paramGdtAdLoader.a().jdField_a_of_type_Int;
      } while (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null);
      int k = paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
      if (k != 0)
      {
        paramGdtAdLoader = localGdtAdError;
      }
      else if (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
      {
        paramGdtAdLoader = localGdtAdError;
      }
      else
      {
        j = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
        if (j != 0) {
          paramGdtAdLoader = localGdtAdError;
        } else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0) {
          paramGdtAdLoader = localGdtAdError;
        } else {
          paramGdtAdLoader = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
        }
      }
      int i = this.a.getErrorCode(paramGdtAdLoader, i, k, j);
      localGdtAdError = new GdtAdError(i);
      GdtLog.b("GdtAd", localGdtAdError.a());
      if (i == 0)
      {
        GdtAd.access$202(this.a, 2);
        this.a.getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramGdtAdLoader;
        GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
        GdtAd.access$500(this.a);
        return;
      }
      GdtAd.access$202(this.a, 3);
      GdtAd.access$300(this.a, localGdtAdError);
      return;
    }
    GdtLog.d("GdtAd", "onResponse error");
    GdtAd.access$202(this.a, 3);
    GdtAd.access$300(this.a, new GdtAdError(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.6
 * JD-Core Version:    0.7.0.1
 */