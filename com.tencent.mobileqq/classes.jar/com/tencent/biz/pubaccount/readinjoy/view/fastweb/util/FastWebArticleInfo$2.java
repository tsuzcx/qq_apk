package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import osg;
import paf;
import rmj;

public class FastWebArticleInfo$2
  implements Runnable
{
  FastWebArticleInfo$2(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    paf localpaf = osg.a().a();
    if (localpaf == null) {
      return;
    }
    localpaf.a(this.a.mArticleContentUrl, this.a.innerUniqueID, this.a.mSubscribeID, 2, new rmj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2
 * JD-Core Version:    0.7.0.1
 */