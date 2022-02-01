package com.tencent.biz.pubaccount.readinjoy.reward;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import qye;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJVideoRewardCoinManager$showRewardCoinPopupWindow$2
  implements Runnable
{
  public RIJVideoRewardCoinManager$showRewardCoinPopupWindow$2(qye paramqye) {}
  
  public final void run()
  {
    ImageView localImageView = qye.a(this.this$0);
    if (localImageView != null) {
      localImageView.setImageDrawable((Drawable)qye.a(this.this$0, "https://kd.qpic.cn/bankjiang/apngs/one_cake_apng_ee6293e7.png"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */