package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public class AdMaterialObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, List<MaterialData> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (String)paramObject);
      return;
    }
    a(paramBoolean, (List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialObserver
 * JD-Core Version:    0.7.0.1
 */