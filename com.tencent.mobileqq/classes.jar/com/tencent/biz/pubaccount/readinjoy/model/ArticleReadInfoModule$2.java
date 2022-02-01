package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import java.util.Iterator;
import java.util.List;
import pua;

public class ArticleReadInfoModule$2
  implements Runnable
{
  public ArticleReadInfoModule$2(pua parampua, List paramList) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)localIterator.next();
        this.this$0.a(localArticleReadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.2
 * JD-Core Version:    0.7.0.1
 */