package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import nol;
import onh;
import plm;
import plu;
import qbx;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(plu paramplu) {}
  
  public void run()
  {
    plm.a(this.a.a).requestLayout();
    plm.a(this.a.a, true);
    if (!plm.a(this.a.a).mRecommendFollowInfos.b)
    {
      plm.a(this.a.a).mRecommendFollowInfos.b = true;
      nol.a(null, onh.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */