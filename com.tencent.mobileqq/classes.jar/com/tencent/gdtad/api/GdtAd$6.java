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
    if ((paramGdtAdLoader != GdtAd.access$100(this.a)) || (!this.a.isValid()) || (this.a.getParams().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet == null))
    {
      GdtLog.d("GdtAd", "onResponse error");
      GdtAd.access$202(this.a, 3);
      GdtAd.access$300(this.a, new GdtAdError(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramGdtAdLoader == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramGdtAdLoader = null;
    }
    GdtAdError localGdtAdError;
    for (;;)
    {
      i = this.a.getErrorCode(paramGdtAdLoader, k, j, i);
      localGdtAdError = new GdtAdError(i);
      GdtLog.b("GdtAd", localGdtAdError.a());
      if (i != 0) {
        break;
      }
      GdtAd.access$202(this.a, 2);
      this.a.getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramGdtAdLoader;
      GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      GdtAd.access$500(this.a);
      return;
      if (paramGdtAdLoader.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramGdtAdLoader = null;
      }
      else
      {
        long l = paramGdtAdLoader.a().jdField_a_of_type_Long;
        i = paramGdtAdLoader.a().jdField_a_of_type_Int;
        if (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramGdtAdLoader = null;
        }
        else
        {
          j = paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramGdtAdLoader = null;
          }
          else if (paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramGdtAdLoader = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramGdtAdLoader = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramGdtAdLoader = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramGdtAdLoader = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    GdtAd.access$202(this.a, 3);
    GdtAd.access$300(this.a, localGdtAdError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.6
 * JD-Core Version:    0.7.0.1
 */