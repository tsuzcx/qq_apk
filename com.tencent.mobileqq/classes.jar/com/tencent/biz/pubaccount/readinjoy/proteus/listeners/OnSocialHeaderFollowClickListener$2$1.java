package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pmk;
import qhe;
import qhg;

public class OnSocialHeaderFollowClickListener$2$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$2$1(qhg paramqhg) {}
  
  public void run()
  {
    qhe.a(this.a.a).invalidateProteusTemplateBean();
    pmk.a().b();
    pmk.a().a(qhe.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.2.1
 * JD-Core Version:    0.7.0.1
 */