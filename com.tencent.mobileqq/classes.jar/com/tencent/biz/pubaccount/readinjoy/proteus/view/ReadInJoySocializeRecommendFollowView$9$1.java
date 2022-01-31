package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import noo;
import onk;
import plp;
import plx;
import qca;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(plx paramplx) {}
  
  public void run()
  {
    plp.a(this.a.a).requestLayout();
    plp.a(this.a.a, true);
    if (!plp.a(this.a.a).mRecommendFollowInfos.b)
    {
      plp.a(this.a.a).mRecommendFollowInfos.b = true;
      noo.a(null, onk.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */