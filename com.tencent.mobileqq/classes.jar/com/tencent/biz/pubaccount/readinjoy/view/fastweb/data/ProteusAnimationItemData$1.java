package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.view.View;

class ProteusAnimationItemData$1
  implements Runnable
{
  ProteusAnimationItemData$1(ProteusAnimationItemData paramProteusAnimationItemData) {}
  
  public void run()
  {
    if (ProteusAnimationItemData.a(this.this$0).getLayoutParams() != null)
    {
      ProteusAnimationItemData.a(this.this$0).getLayoutParams().height = 1;
      ProteusAnimationItemData.a(this.this$0).requestLayout();
      ProteusAnimationItemData.a(this.this$0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData.1
 * JD-Core Version:    0.7.0.1
 */