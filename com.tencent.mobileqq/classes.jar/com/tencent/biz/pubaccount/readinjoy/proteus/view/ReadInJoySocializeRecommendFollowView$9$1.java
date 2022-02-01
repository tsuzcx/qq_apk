package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import olh;
import pkh;
import quh;
import qup;
import rqd;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(qup paramqup) {}
  
  public void run()
  {
    quh.a(this.a.a).requestLayout();
    quh.a(this.a.a, true);
    if (!quh.a(this.a.a).mRecommendFollowInfos.b)
    {
      quh.a(this.a.a).mRecommendFollowInfos.b = true;
      olh.a(null, pkh.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */