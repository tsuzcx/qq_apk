package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.biz.widgets.ElasticHorScrView;

class PublicAccountImageCollectionMainActivityImpl$12
  implements Runnable
{
  PublicAccountImageCollectionMainActivityImpl$12(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.mScrollView1.getWidth() < this.a) {
      this.this$0.mScrollView1.setMove(true);
    } else {
      this.this$0.mScrollView1.setMove(false);
    }
    if (this.this$0.mScrollView2.getWidth() < this.b)
    {
      this.this$0.mScrollView2.setMove(true);
      return;
    }
    this.this$0.mScrollView2.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.12
 * JD-Core Version:    0.7.0.1
 */