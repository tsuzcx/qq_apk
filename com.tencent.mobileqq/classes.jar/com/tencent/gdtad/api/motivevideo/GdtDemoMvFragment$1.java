package com.tencent.gdtad.api.motivevideo;

import android.support.annotation.NonNull;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.LinkedList;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class GdtDemoMvFragment$1
  implements GdtAdLoader.Listener
{
  GdtDemoMvFragment$1(GdtDemoMvFragment paramGdtDemoMvFragment) {}
  
  public void onResponse(@NonNull GdtAdLoader paramGdtAdLoader)
  {
    Object localObject = new LinkedList();
    GdtAdLoader.Session localSession = paramGdtAdLoader.a();
    int j = -2147483648;
    if (localSession == null) {
      i = -2147483648;
    }
    do
    {
      k = -2147483648;
      paramGdtAdLoader = (GdtAdLoader)localObject;
      break;
      i = paramGdtAdLoader.a().c;
    } while (paramGdtAdLoader.a().b == null);
    int k = paramGdtAdLoader.a().b.ret.get();
    if (k != 0)
    {
      paramGdtAdLoader = (GdtAdLoader)localObject;
    }
    else if (paramGdtAdLoader.a().b.pos_ads_info.size() <= 0)
    {
      paramGdtAdLoader = (GdtAdLoader)localObject;
    }
    else
    {
      j = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().b.pos_ads_info.get(0)).ret.get();
      if (j != 0) {
        paramGdtAdLoader = (GdtAdLoader)localObject;
      } else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().b.pos_ads_info.get(0)).ads_info.size() <= 0) {
        paramGdtAdLoader = (GdtAdLoader)localObject;
      } else {
        paramGdtAdLoader = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().b.pos_ads_info.get(0)).ads_info.get();
      }
    }
    int i = GdtDemoMvFragment.a(i, k, j);
    if (paramGdtAdLoader.isEmpty()) {
      i = 1;
    }
    GdtLog.b("GdtDemoMvFragment", new GdtAdError(i).b());
    if (i == 0)
    {
      this.a.a(paramGdtAdLoader);
      return;
    }
    paramGdtAdLoader = this.a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onResponse] load ad error, errorCode=");
    ((StringBuilder)localObject).append(i);
    paramGdtAdLoader.a(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.1
 * JD-Core Version:    0.7.0.1
 */