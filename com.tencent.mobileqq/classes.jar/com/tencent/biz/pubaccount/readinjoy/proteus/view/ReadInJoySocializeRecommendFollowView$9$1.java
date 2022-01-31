package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import nrt;
import ors;
import prr;
import prz;
import qlt;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(prz paramprz) {}
  
  public void run()
  {
    prr.a(this.a.a).requestLayout();
    prr.a(this.a.a, true);
    if (!prr.a(this.a.a).mRecommendFollowInfos.b)
    {
      prr.a(this.a.a).mRecommendFollowInfos.b = true;
      nrt.a(null, ors.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */