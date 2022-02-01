package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter;

class FastWebActivity$25
  extends ReadInJoyObserver
{
  FastWebActivity$25(FastWebActivity paramFastWebActivity) {}
  
  public void b(String paramString)
  {
    super.b(paramString);
    paramString = FastWebActivity.a(this.a).a(paramString, FastWebActivity.d(this.a));
    if (paramString != null) {
      this.a.a(true, paramString.a.commentId, null);
    }
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25
 * JD-Core Version:    0.7.0.1
 */