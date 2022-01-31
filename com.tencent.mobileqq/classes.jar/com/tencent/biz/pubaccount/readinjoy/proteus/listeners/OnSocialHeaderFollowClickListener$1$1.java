package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import osj;
import piw;
import pix;

public class OnSocialHeaderFollowClickListener$1$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$1$1(pix parampix) {}
  
  public void run()
  {
    piw.a(this.a.a).invalidateProteusTemplateBean();
    osj.a().b();
    osj.a().a(piw.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */