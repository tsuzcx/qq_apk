package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import oat;
import pha;
import qjt;
import qkb;
import rgf;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(qkb paramqkb) {}
  
  public void run()
  {
    qjt.a(this.a.a).requestLayout();
    qjt.a(this.a.a, true);
    if (!qjt.a(this.a.a).mRecommendFollowInfos.b)
    {
      qjt.a(this.a.a).mRecommendFollowInfos.b = true;
      oat.a(null, pha.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */