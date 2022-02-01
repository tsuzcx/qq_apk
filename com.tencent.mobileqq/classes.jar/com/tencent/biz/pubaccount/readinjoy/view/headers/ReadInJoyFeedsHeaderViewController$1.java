package com.tencent.biz.pubaccount.readinjoy.view.headers;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import java.util.List;

class ReadInJoyFeedsHeaderViewController$1
  extends ReadInJoyObserver
{
  ReadInJoyFeedsHeaderViewController$1(ReadInJoyFeedsHeaderViewController paramReadInJoyFeedsHeaderViewController) {}
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if (paramBoolean) {
      ReadInJoyFeedsHeaderViewController.a(this.a, ReadInJoyFeedsHeaderViewController.a(this.a, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.1
 * JD-Core Version:    0.7.0.1
 */