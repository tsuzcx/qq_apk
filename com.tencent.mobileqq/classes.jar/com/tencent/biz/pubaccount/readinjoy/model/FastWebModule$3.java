package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ors;
import pfo;
import pfs;

public class FastWebModule$3
  implements Runnable
{
  public FastWebModule$3(pfo parampfo, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.a.get(i);
      if ((ors.a(localArticleInfo)) || ((localArticleInfo instanceof AdvertisementInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localArticleInfo != null) && (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) && (localArticleInfo.mArticleContentUrl.startsWith("http")) && (ors.a(localArticleInfo.mArticleContentUrl, localArticleInfo.mChannelID, localArticleInfo)))
        {
          pfs localpfs = (pfs)pfo.a(this.this$0).get(localArticleInfo.mChannelID + "_" + localArticleInfo.mArticleID);
          if ((localpfs == null) || (localpfs.a())) {
            this.this$0.a(localArticleInfo.mArticleContentUrl, localArticleInfo.innerUniqueID, localArticleInfo.mSubscribeID, 3, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.3
 * JD-Core Version:    0.7.0.1
 */