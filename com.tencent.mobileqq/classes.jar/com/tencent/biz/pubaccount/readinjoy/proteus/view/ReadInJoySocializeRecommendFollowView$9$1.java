package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import odq;
import pay;
import qid;
import qil;
import rdw;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(qil paramqil) {}
  
  public void run()
  {
    qid.a(this.a.a).requestLayout();
    qid.a(this.a.a, true);
    if (!qid.a(this.a.a).mRecommendFollowInfos.b)
    {
      qid.a(this.a.a).mRecommendFollowInfos.b = true;
      odq.a(null, pay.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */