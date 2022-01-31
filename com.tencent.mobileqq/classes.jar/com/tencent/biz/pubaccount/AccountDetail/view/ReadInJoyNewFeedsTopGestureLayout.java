package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector;
import nhd;

public class ReadInJoyNewFeedsTopGestureLayout
  extends AccountDetailTopGestureLayout
{
  public ReadInJoyNewFeedsTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(Context paramContext)
  {
    this.a = new nhd(this, paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.a);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */