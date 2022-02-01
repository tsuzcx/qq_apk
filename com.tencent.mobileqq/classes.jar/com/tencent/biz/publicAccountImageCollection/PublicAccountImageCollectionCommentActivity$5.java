package com.tencent.biz.publicAccountImageCollection;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountImageCollectionCommentActivity$5
  implements View.OnClickListener
{
  PublicAccountImageCollectionCommentActivity$5(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void onClick(View paramView)
  {
    PublicAccountImageCollectionCommentActivity.a(this.a);
    PublicAccountImageCollectionCommentActivity.a(this.a, -1);
    PublicAccountImageCollectionCommentActivity.b(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity.5
 * JD-Core Version:    0.7.0.1
 */