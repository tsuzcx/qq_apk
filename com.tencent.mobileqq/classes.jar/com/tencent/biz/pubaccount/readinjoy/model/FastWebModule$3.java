package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class FastWebModule$3
  implements Runnable
{
  FastWebModule$3(FastWebModule paramFastWebModule, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.a.get(i);
      if ((RIJFeedsType.a(localArticleInfo)) || ((localArticleInfo instanceof AdvertisementInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localArticleInfo != null) && (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) && (localArticleInfo.mArticleContentUrl.startsWith("http")) && (RIJFeedsType.a(localArticleInfo.mArticleContentUrl, localArticleInfo.mChannelID, localArticleInfo)))
        {
          FastWebModule.OutdateLimitCacheFeild localOutdateLimitCacheFeild = (FastWebModule.OutdateLimitCacheFeild)FastWebModule.a(this.this$0).get(localArticleInfo.mChannelID + "_" + localArticleInfo.mArticleID);
          if ((localOutdateLimitCacheFeild == null) || (localOutdateLimitCacheFeild.a())) {
            this.this$0.a(localArticleInfo.mArticleContentUrl, localArticleInfo.innerUniqueID, localArticleInfo.mSubscribeID, 3, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.3
 * JD-Core Version:    0.7.0.1
 */