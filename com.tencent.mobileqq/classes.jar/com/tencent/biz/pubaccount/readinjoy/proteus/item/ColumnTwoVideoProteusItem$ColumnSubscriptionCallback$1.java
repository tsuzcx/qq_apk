package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$1
  implements Runnable
{
  ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$1(ColumnTwoVideoProteusItem.ColumnSubscriptionCallback paramColumnSubscriptionCallback) {}
  
  public void run()
  {
    ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.a(this.this$0).invalidateProteusTemplateBean();
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1
 * JD-Core Version:    0.7.0.1
 */