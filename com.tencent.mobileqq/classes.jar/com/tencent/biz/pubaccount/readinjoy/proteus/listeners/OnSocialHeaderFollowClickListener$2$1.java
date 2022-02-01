package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class OnSocialHeaderFollowClickListener$2$1
  implements Runnable
{
  OnSocialHeaderFollowClickListener$2$1(OnSocialHeaderFollowClickListener.2 param2) {}
  
  public void run()
  {
    OnSocialHeaderFollowClickListener.a(this.a.a).invalidateProteusTemplateBean();
    ReadInJoyLogicEngineEventDispatcher.a().c();
    ReadInJoyLogicEngineEventDispatcher.a().a(OnSocialHeaderFollowClickListener.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.2.1
 * JD-Core Version:    0.7.0.1
 */