package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pkp;
import qfj;
import qfl;

public class OnSocialHeaderFollowClickListener$2$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$2$1(qfl paramqfl) {}
  
  public void run()
  {
    qfj.a(this.a.a).invalidateProteusTemplateBean();
    pkp.a().b();
    pkp.a().a(qfj.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.2.1
 * JD-Core Version:    0.7.0.1
 */