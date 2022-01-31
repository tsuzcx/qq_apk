package com.tencent.gdtad.api.adbox;

import aasd;
import aase;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class GdtAdBoxData
  implements Serializable
{
  private List<GdtAd> ads = new ArrayList();
  private String json;
  
  public GdtAdBoxData(String paramString)
  {
    this.json = paramString;
    a(paramString);
  }
  
  public GdtAdBoxData(List<GdtAd> paramList)
  {
    this.ads = paramList;
  }
  
  private void a(String paramString)
  {
    Object localObject1;
    try
    {
      paramString = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp(), new JSONObject(paramString)))).pos_ads_info.get();
      if ((paramString == null) || (paramString.isEmpty()))
      {
        aase.d("GdtAdBoxData", "convertJson2GdtAds() posAdInfos.isEmpty");
        return;
      }
      if (this.ads != null) {
        this.ads.clear();
      }
      paramString = paramString.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label202;
        }
        localObject1 = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramString.next()).ads_info.get();
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break;
        }
        aase.d("GdtAdBoxData", "convertJson2GdtAds() adInfos.isEmpty");
      }
      localObject1 = ((List)localObject1).iterator();
    }
    catch (Exception paramString)
    {
      aase.d("GdtAdBoxData", "convertJson2GdtAds", paramString);
      return;
    }
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)((Iterator)localObject1).next();
      if (this.ads == null) {
        this.ads = new ArrayList();
      }
      localObject2 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
      this.ads.add(localObject2);
    }
    label202:
    if (this.ads != null) {
      aase.a("GdtAdBoxData", "convertJson2GdtAds() result = [" + Arrays.toString(this.ads.toArray()) + "]");
    }
  }
  
  public List<GdtAd> getAds()
  {
    return this.ads;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxData
 * JD-Core Version:    0.7.0.1
 */