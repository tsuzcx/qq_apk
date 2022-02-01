package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pfd;
import pzp;
import pzr;

public class OnSocialHeaderFollowClickListener$2$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$2$1(pzr parampzr) {}
  
  public void run()
  {
    pzp.a(this.a.a).invalidateProteusTemplateBean();
    pfd.a().b();
    pfd.a().a(pzp.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.2.1
 * JD-Core Version:    0.7.0.1
 */