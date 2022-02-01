package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyCallback;

class FastWebActivity$TKDTuWenHippyCallback
  extends FastWebActivity.CommentNumChangedlistener
  implements ITKDTuWenHippyCallback
{
  private FastWebActivity$TKDTuWenHippyCallback(FastWebActivity paramFastWebActivity)
  {
    super(paramFastWebActivity, null);
  }
  
  public void onUpdate(long paramLong)
  {
    if (FastWebActivity.a(this.b) != null)
    {
      FastWebActivity.a(this.b).b = paramLong;
      if (FastWebActivity.a(this.b).b <= 0L) {
        FastWebActivity.a(this.b).b = 0L;
      }
      FastWebActivity.a(this.b).a(this.b, FastWebActivity.a(this.b), this.b.a);
    }
  }
  
  public void openSubCommentPage(String paramString1, String paramString2)
  {
    this.b.a(true, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.TKDTuWenHippyCallback
 * JD-Core Version:    0.7.0.1
 */