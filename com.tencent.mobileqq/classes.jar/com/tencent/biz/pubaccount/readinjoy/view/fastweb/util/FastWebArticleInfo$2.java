package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import osj;
import pai;
import rmm;

public class FastWebArticleInfo$2
  implements Runnable
{
  FastWebArticleInfo$2(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    pai localpai = osj.a().a();
    if (localpai == null) {
      return;
    }
    localpai.a(this.a.mArticleContentUrl, this.a.innerUniqueID, this.a.mSubscribeID, 2, new rmm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2
 * JD-Core Version:    0.7.0.1
 */