package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdBuilderAdapter;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;

public final class GdtAdBuilderAdapter
  implements AdBuilderAdapter
{
  public Ad build(com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    try
    {
      paramAdInfo = AdJSON.fromObject(paramAdInfo);
      paramAdInfo = new GdtAd((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo(), paramAdInfo)));
      return paramAdInfo;
    }
    catch (Throwable paramAdInfo)
    {
      AdLog.e("", "build", paramAdInfo);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtAdBuilderAdapter
 * JD-Core Version:    0.7.0.1
 */