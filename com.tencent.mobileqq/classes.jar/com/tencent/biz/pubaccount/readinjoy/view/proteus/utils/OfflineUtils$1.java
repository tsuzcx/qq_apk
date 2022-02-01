package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper;

final class OfflineUtils$1
  implements Runnable
{
  OfflineUtils$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      return;
    }
    TemplateFactory.a();
    TemplateFactory.a("default_feeds", true);
    new StyleConfigHelper().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils.1
 * JD-Core Version:    0.7.0.1
 */