package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import java.util.List;
import ttv;

public class AdMaterialResManager$3
  implements Runnable
{
  public AdMaterialResManager$3(ttv paramttv) {}
  
  public void run()
  {
    List localList = ttv.a(this.this$0, false);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        MaterialData localMaterialData = (MaterialData)localList.get(i);
        ttv.a(this.this$0, localMaterialData);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.3
 * JD-Core Version:    0.7.0.1
 */