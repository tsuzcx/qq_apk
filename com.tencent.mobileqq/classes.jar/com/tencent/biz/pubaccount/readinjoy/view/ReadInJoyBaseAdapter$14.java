package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ndn;
import qmu;
import qmv;
import qoe;

public class ReadInJoyBaseAdapter$14
  implements Runnable
{
  public ReadInJoyBaseAdapter$14(qoe paramqoe, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (this.a != null) {
      ndn.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new qmv(null, null, this.a.mVideoVid, this.a.innerUniqueID).a((int)this.a.mChannelID).O((int)qoe.b(this.this$0)).R(0).a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */