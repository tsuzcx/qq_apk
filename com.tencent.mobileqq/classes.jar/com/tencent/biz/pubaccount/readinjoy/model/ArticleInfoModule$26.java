package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import pon;

public class ArticleInfoModule$26
  implements Runnable
{
  public ArticleInfoModule$26(pon parampon) {}
  
  public void run()
  {
    List localList = this.this$0.a.query(ChannelTopCookie.class, true, null, null, null, null, null, null);
    this.this$0.a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.26
 * JD-Core Version:    0.7.0.1
 */