package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;

class FastWebActivity$25
  implements Runnable
{
  FastWebActivity$25(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (FastWebActivity.d(this.this$0) <= RIJRedPacketManager.a().c())
    {
      FastWebActivity.e(this.this$0, FastWebActivity.d(this.this$0) + FastWebActivity.a);
      FastWebActivity.a(this.this$0).post(new FastWebActivity.25.1(this));
    }
    for (;;)
    {
      FastWebActivity.a(this.this$0).postDelayed(FastWebActivity.a(this.this$0), FastWebActivity.a);
      return;
      FastWebActivity.a(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25
 * JD-Core Version:    0.7.0.1
 */