package com.tencent.biz.publicAccountImageCollection;

import com.tencent.biz.widgets.ElasticHorScrView;

class PublicAccountImageCollectionMainActivity$12
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$12(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.a.getWidth() < this.a) {
      this.this$0.a.setMove(true);
    }
    while (this.this$0.b.getWidth() < this.b)
    {
      this.this$0.b.setMove(true);
      return;
      this.this$0.a.setMove(false);
    }
    this.this$0.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.12
 * JD-Core Version:    0.7.0.1
 */