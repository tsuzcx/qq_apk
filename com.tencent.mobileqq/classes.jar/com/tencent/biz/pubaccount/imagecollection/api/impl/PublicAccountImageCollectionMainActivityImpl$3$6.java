package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.widget.TextView;

class PublicAccountImageCollectionMainActivityImpl$3$6
  implements Runnable
{
  PublicAccountImageCollectionMainActivityImpl$3$6(PublicAccountImageCollectionMainActivityImpl.3 param3, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = this.c.a.commentCountText;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(PublicAccountImageCollectionMainActivityImpl.access$1100(this.c.a));
    localTextView.setText(localStringBuilder.toString());
    PublicAccountImageCollectionMainActivityImpl.access$1200(this.c.a, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.6
 * JD-Core Version:    0.7.0.1
 */