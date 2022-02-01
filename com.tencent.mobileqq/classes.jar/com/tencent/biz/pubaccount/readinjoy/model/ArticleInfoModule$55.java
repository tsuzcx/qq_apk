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
import pwb;

public class ArticleInfoModule$55
  implements Runnable
{
  public ArticleInfoModule$55(pwb parampwb, int paramInt) {}
  
  public void run()
  {
    List localList = this.this$0.a.query(ArticleExposureInfo.class, true, "channelID = ?", new String[] { String.valueOf(this.a) }, null, null, "exposureTime desc", String.valueOf(100));
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
      localObject = (ConcurrentHashMap)pwb.c(this.this$0).get(Integer.valueOf(this.a));
      if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0)) {
        localConcurrentHashMap.putAll((Map)localObject);
      }
      pwb.c(this.this$0).put(Integer.valueOf(this.a), localConcurrentHashMap);
    }
    QLog.d("ArticleInfoModule", 1, "loadFeedsExposureInfo from db , channelID : " + this.a + ", result : " + localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.55
 * JD-Core Version:    0.7.0.1
 */