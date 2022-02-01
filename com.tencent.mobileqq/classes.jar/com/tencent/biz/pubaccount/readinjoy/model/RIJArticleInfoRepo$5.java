package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class RIJArticleInfoRepo$5
  implements Runnable
{
  RIJArticleInfoRepo$5(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt) {}
  
  public void run()
  {
    List localList = RIJArticleInfoRepo.a(this.this$0).query(ArticleExposureInfo.class, true, "channelID = ?", new String[] { String.valueOf(this.a) }, null, null, "exposureTime desc", String.valueOf(100));
    if (localList != null)
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((Iterator)localObject).next();
        if ((localArticleExposureInfo != null) && (!TextUtils.isEmpty(localArticleExposureInfo.rowkey))) {
          localConcurrentHashMap.put(localArticleExposureInfo.rowkey, localArticleExposureInfo);
        }
      }
      localObject = (ConcurrentMap)RIJArticleInfoRepo.a(this.this$0).get(Integer.valueOf(this.a));
      if ((localObject != null) && (((ConcurrentMap)localObject).size() > 0)) {
        localConcurrentHashMap.putAll((Map)localObject);
      }
      RIJArticleInfoRepo.a(this.this$0).put(Integer.valueOf(this.a), localConcurrentHashMap);
    }
    QLog.d("RIJArticleInfoRepo", 1, "loadFeedsExposureInfo from db , channelID : " + this.a + ", result : " + localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.5
 * JD-Core Version:    0.7.0.1
 */