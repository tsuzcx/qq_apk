package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ListView;

class ReadInJoyAdExpandCardPic$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInJoyAdExpandCardPic$2(ReadInJoyAdExpandCardPic paramReadInJoyAdExpandCardPic) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((ReadInJoyAdExpandCardPic.b(this.a) != null) && (ReadInJoyAdExpandCardPic.a(this.a) != null))
    {
      Float localFloat = (Float)paramValueAnimator.getAnimatedValue();
      float f = (float)paramValueAnimator.getCurrentPlayTime() / (float)paramValueAnimator.getDuration();
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("onAnimationUpdate");
      paramValueAnimator.append(f);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", paramValueAnimator.toString());
      ReadInJoyAdUtils.a(ReadInJoyAdExpandCardPic.b(this.a), Math.round(localFloat.floatValue()));
      ReadInJoyAdUtils.a(ReadInJoyAdExpandCardPic.a(this.a), Math.round(localFloat.floatValue()));
      if ((ReadInJoyAdExpandCardPic.a(this.a) != null) && (ReadInJoyAdExpandCardPic.a(this.a).a() != null) && (ReadInJoyAdExpandCardPic.a(this.a).a().a() != null)) {
        ReadInJoyAdExpandCardPic.a(this.a).a().a().smoothScrollBy(-(int)(ViewUtils.a(291.0F) * f), 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdExpandCardPic.2
 * JD-Core Version:    0.7.0.1
 */