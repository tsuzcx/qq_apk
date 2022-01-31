package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import owy;
import pfo;
import sch;

public class FastWebArticleInfo$2
  implements Runnable
{
  FastWebArticleInfo$2(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    pfo localpfo = owy.a().a();
    if (localpfo == null) {
      return;
    }
    localpfo.a(this.a.mArticleContentUrl, this.a.innerUniqueID, this.a.mSubscribeID, 2, new sch(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2
 * JD-Core Version:    0.7.0.1
 */