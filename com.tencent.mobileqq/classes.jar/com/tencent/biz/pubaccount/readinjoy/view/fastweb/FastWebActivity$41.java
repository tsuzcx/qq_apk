package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import java.util.Map;

class FastWebActivity$41
  implements FollowListInfoModule.FollowStatusObserver
{
  FastWebActivity$41(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    if (FastWebActivity.a(this.a) != null)
    {
      FastWebActivity.a(this.a).a(paramMap);
      if (FastWebActivity.a(this.a) != null) {
        FastWebActivity.a(this.a).notifyDataSetChanged();
      }
      FastWebActivity.q(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.41
 * JD-Core Version:    0.7.0.1
 */