package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;

class FastWebActivity$2
  implements Runnable
{
  FastWebActivity$2(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    FastWebActivity.a(this.this$0).getLocationInWindow(arrayOfInt);
    FastWebActivity.a(this.this$0).a(true);
    FastWebActivity.a(this.this$0).b(true);
    FastWebActivity.a(this.this$0).setText(RIJRedPacketManager.a().c());
    FastWebActivity.a(this.this$0).setVisibility(4);
    FastWebActivity.a(this.this$0).post(new FastWebActivity.2.1(this, arrayOfInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.2
 * JD-Core Version:    0.7.0.1
 */