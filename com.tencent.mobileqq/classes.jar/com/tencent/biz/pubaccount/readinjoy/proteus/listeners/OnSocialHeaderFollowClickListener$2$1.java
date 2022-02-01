package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pvm;
import qrm;
import qro;

public class OnSocialHeaderFollowClickListener$2$1
  implements Runnable
{
  public OnSocialHeaderFollowClickListener$2$1(qro paramqro) {}
  
  public void run()
  {
    qrm.a(this.a.a).invalidateProteusTemplateBean();
    pvm.a().b();
    pvm.a().a(qrm.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.2.1
 * JD-Core Version:    0.7.0.1
 */