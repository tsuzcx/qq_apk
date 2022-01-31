package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import osm;
import piz;
import pja;

public class OnSocialHeaderFollowClickListener$1$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$1$1(pja parampja) {}
  
  public void run()
  {
    piz.a(this.a.a).invalidateProteusTemplateBean();
    osm.a().b();
    osm.a().a(piz.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */