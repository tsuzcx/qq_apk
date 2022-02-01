package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import java.util.Iterator;
import java.util.List;
import qga;

public class RIJArticleInfoRepo$3
  implements Runnable
{
  public RIJArticleInfoRepo$3(qga paramqga, List paramList) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)localIterator.next();
        qga.a(this.this$0, localChannelTopCookie);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.3
 * JD-Core Version:    0.7.0.1
 */