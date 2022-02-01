package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class LimitChatPie$31
  implements GdtAdLoader.Listener
{
  LimitChatPie$31(LimitChatPie paramLimitChatPie) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    if ((paramGdtAdLoader != null) && (paramGdtAdLoader.a() != null) && (paramGdtAdLoader.a().a != null)) {}
    try
    {
      paramGdtAdLoader = (qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.a().a.pos_ads_info.get(0)).ads_info.get(0);
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.a.a(), new GdtAd(paramGdtAdLoader));
      paramGdtAdLoader = GdtUtil.a(paramGdtAdLoader, GdtUtil.a(3));
      ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(this.a.a(), paramGdtAdLoader));
      return;
    }
    catch (Exception paramGdtAdLoader)
    {
      label111:
      break label111;
    }
    QLog.w("LimitChatPie", 1, "IGdtAdAPI loadAd error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.31
 * JD-Core Version:    0.7.0.1
 */