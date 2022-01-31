package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import oxb;
import pph;
import ppi;

public class OnSocialHeaderFollowClickListener$1$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$1$1(ppi paramppi) {}
  
  public void run()
  {
    pph.a(this.a.a).invalidateProteusTemplateBean();
    oxb.a().b();
    oxb.a().a(pph.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */