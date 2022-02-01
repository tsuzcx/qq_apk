package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import java.util.List;
import sxp;

class FastWebActivity$38
  implements Runnable
{
  FastWebActivity$38(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public void run()
  {
    int j = FastWebActivity.a(this.this$0).size();
    int i = 0;
    if (i < j)
    {
      BaseData localBaseData = (BaseData)FastWebActivity.a(this.this$0).get(i);
      if (((localBaseData.t == 10) || (localBaseData.t == 17) || (localBaseData.t == 22) || (localBaseData.t == 24) || (localBaseData.t == 9)) && (localBaseData == this.a)) {
        FastWebActivity.a(this.this$0).remove(i);
      }
    }
    for (;;)
    {
      if (i >= 0) {
        FastWebActivity.a(this.this$0).a(i, j);
      }
      FastWebActivity.a(this.this$0).notifyDataSetChanged();
      return;
      i += 1;
      break;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.38
 * JD-Core Version:    0.7.0.1
 */