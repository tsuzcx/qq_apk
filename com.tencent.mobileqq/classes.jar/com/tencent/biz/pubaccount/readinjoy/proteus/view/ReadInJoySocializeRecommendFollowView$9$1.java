package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import ndn;
import obz;
import ozx;
import paf;
import pqe;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(paf parampaf) {}
  
  public void run()
  {
    ozx.a(this.a.a).requestLayout();
    ozx.a(this.a.a, true);
    if (!ozx.a(this.a.a).mRecommendFollowInfos.b)
    {
      ozx.a(this.a.a).mRecommendFollowInfos.b = true;
      ndn.a(null, obz.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */