package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import ogy;
import oph;
import qzu;

public class FastWebArticleInfo$2
  implements Runnable
{
  FastWebArticleInfo$2(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    oph localoph = ogy.a().a();
    if (localoph == null) {
      return;
    }
    localoph.a(this.a.mArticleContentUrl, this.a.innerUniqueID, this.a.mSubscribeID, 2, new qzu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2
 * JD-Core Version:    0.7.0.1
 */