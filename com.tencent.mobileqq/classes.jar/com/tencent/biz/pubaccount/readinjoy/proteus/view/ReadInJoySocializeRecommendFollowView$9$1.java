package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import ocd;
import ozs;
import qcf;
import qcn;
import qwy;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(qcn paramqcn) {}
  
  public void run()
  {
    qcf.a(this.a.a).requestLayout();
    qcf.a(this.a.a, true);
    if (!qcf.a(this.a.a).mRecommendFollowInfos.b)
    {
      qcf.a(this.a.a).mRecommendFollowInfos.b = true;
      ocd.a(null, ozs.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */