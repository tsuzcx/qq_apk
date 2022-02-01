package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import java.util.List;

class FastWebActivity$31
  implements Runnable
{
  FastWebActivity$31(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public void run()
  {
    int j = FastWebActivity.a(this.this$0).size();
    int i = 0;
    if (i < j)
    {
      BaseData localBaseData = (BaseData)FastWebActivity.a(this.this$0).get(i);
      if (((localBaseData.s == 10) || (localBaseData.s == 17) || (localBaseData.s == 22) || (localBaseData.s == 9)) && (localBaseData == this.a)) {
        FastWebActivity.a(this.this$0).remove(i);
      }
    }
    for (;;)
    {
      if (i >= 0) {
        FastWebActivity.a(this.this$0).a(i, j);
      }
      FastWebActivity.d(this.this$0);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.31
 * JD-Core Version:    0.7.0.1
 */