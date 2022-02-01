package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import com.tencent.tkd.comment.util.CollectionUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class AdMaterialResManager$2
  implements Runnable
{
  AdMaterialResManager$2(AdMaterialResManager paramAdMaterialResManager, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = AdMaterialResManager.a(this.this$0, this.a);
    if (CollectionUtil.isEmpty((Collection)localObject)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MaterialData localMaterialData = (MaterialData)((Iterator)localObject).next();
        AdMaterialResManager.a(this.this$0, localMaterialData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.2
 * JD-Core Version:    0.7.0.1
 */