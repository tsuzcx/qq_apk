package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.view.View;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.widget.AbsListView;

class FastWebActivity$8
  implements IScrollReader
{
  FastWebActivity$8(FastWebActivity paramFastWebActivity) {}
  
  public int readScroll(View paramView)
  {
    if ((paramView instanceof AbsListView)) {
      return ((AbsListView)paramView).getLastVisiblePosition();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.8
 * JD-Core Version:    0.7.0.1
 */