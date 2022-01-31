package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import ryx;

public class FastWebActivity$33
  implements Runnable
{
  FastWebActivity$33(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    RIJRedPacketManager.a().a(FastWebActivity.a(this.this$0).innerUniqueID, FastWebActivity.c(this.this$0), 5, new ryx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33
 * JD-Core Version:    0.7.0.1
 */