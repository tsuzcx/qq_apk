package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.comment.ICommentNumChangedListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

class FastWebActivity$CommentNumChangedlistener
  implements ICommentNumChangedListener
{
  private FastWebActivity$CommentNumChangedlistener(FastWebActivity paramFastWebActivity) {}
  
  public void onUpdate(long paramLong)
  {
    if (FastWebActivity.a(this.a) != null)
    {
      FastWebActivity.a(this.a).b = paramLong;
      if (FastWebActivity.a(this.a).b <= 0L)
      {
        FastWebActivity.a(this.a).b = 0L;
        this.a.e();
      }
      FastWebActivity.a(this.a).a(this.a, FastWebActivity.a(this.a), this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.CommentNumChangedlistener
 * JD-Core Version:    0.7.0.1
 */