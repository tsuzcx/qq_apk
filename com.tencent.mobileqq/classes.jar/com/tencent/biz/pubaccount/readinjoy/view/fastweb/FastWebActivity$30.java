package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.FastWebAdapterShowHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.util.ArrayList;
import java.util.List;

class FastWebActivity$30
  implements XListView.DrawFinishedListener
{
  FastWebActivity$30(FastWebActivity paramFastWebActivity) {}
  
  public void drawFinished()
  {
    if (FastWebActivity.f(this.a))
    {
      FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).getWidth());
      FastWebActivity.d(this.a, false);
      FastWebActivity.i(this.a);
      FastWebActivity.a(this.a, new FastWebAdapterShowHelper(FastWebActivity.a(this.a), FastWebActivity.a(this.a).getFirstVisiblePosition(), FastWebActivity.a(this.a).getLastVisiblePosition()));
      long l = TimeUtil.a("FastWebActivity.show");
      TimeUtil.b("fast_web_show_light_house_draw_finish");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FastWebActivity.a(this.a));
      ThreadManager.post(new FastWebActivity.30.1(this, l, localArrayList), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30
 * JD-Core Version:    0.7.0.1
 */