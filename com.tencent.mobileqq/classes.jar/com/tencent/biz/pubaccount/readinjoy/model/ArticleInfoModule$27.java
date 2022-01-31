package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import java.util.Iterator;
import java.util.List;
import ooq;

public class ArticleInfoModule$27
  implements Runnable
{
  public ArticleInfoModule$27(ooq paramooq, List paramList) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)localIterator.next();
        this.this$0.a(localChannelTopCookie);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.27
 * JD-Core Version:    0.7.0.1
 */