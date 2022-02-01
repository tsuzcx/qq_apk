package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pay;
import pum;
import pur;

public class FastWebModule$3
  implements Runnable
{
  public FastWebModule$3(pum parampum, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.a.get(i);
      if ((pay.a(localArticleInfo)) || ((localArticleInfo instanceof AdvertisementInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localArticleInfo != null) && (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) && (localArticleInfo.mArticleContentUrl.startsWith("http")) && (pay.a(localArticleInfo.mArticleContentUrl, localArticleInfo.mChannelID, localArticleInfo)))
        {
          pur localpur = (pur)pum.a(this.this$0).get(localArticleInfo.mChannelID + "_" + localArticleInfo.mArticleID);
          if ((localpur == null) || (localpur.a())) {
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