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
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      a(paramBoolean, (List)paramObject);
      return;
    }
    a(paramBoolean, (String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialObserver
 * JD-Core Version:    0.7.0.1
 */