package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class FastWebArticleInfo$2
  implements Runnable
{
  FastWebArticleInfo$2(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule == null) {
      return;
    }
    localFastWebModule.a(this.a.mArticleContentUrl, this.a.innerUniqueID, this.a.mSubscribeID, 2, new FastWebArticleInfo.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2
 * JD-Core Version:    0.7.0.1
 */