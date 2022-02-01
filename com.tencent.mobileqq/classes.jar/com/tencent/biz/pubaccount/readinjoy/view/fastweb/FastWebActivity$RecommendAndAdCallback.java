package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.RecommendAndAdCallback;
import java.lang.ref.WeakReference;
import java.util.List;

class FastWebActivity$RecommendAndAdCallback
  implements FastWebRequestUtil.RecommendAndAdCallback
{
  private WeakReference<FastWebActivity> a;
  
  public FastWebActivity$RecommendAndAdCallback(FastWebActivity paramFastWebActivity)
  {
    this.a = new WeakReference(paramFastWebActivity);
  }
  
  public void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    FastWebActivity localFastWebActivity = (FastWebActivity)this.a.get();
    if (localFastWebActivity == null) {
      return;
    }
    localFastWebActivity.runOnUiThread(new FastWebActivity.RecommendAndAdCallback.1(this, paramList1, paramList2, localFastWebActivity, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.RecommendAndAdCallback
 * JD-Core Version:    0.7.0.1
 */