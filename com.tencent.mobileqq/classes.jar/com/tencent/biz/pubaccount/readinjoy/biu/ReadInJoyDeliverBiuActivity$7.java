package com.tencent.biz.pubaccount.readinjoy.biu;

import com.tencent.mobileqq.app.PublicAccountObserver;
import java.util.ArrayList;

class ReadInJoyDeliverBiuActivity$7
  extends PublicAccountObserver
{
  public void onGetGuideFriends(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (paramBoolean) {
      ReadInJoyDeliverBiuActivity.a(this.a, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity.7
 * JD-Core Version:    0.7.0.1
 */