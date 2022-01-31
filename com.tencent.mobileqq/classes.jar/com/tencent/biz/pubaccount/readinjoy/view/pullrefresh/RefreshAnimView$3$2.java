package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.widget.ImageView;
import baxn;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import rqx;

public class RefreshAnimView$3$2
  implements Runnable
{
  public RefreshAnimView$3$2(rqx paramrqx) {}
  
  public void run()
  {
    float f = baxn.a(this.a.a.getContext(), 44.0F) / 88.0F;
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(RefreshAnimView.a(this.a.a));
    localLottieDrawable.loop(false);
    RefreshAnimView.a(this.a.a).setImageDrawable(localLottieDrawable);
    RefreshAnimView.a(this.a.a).invalidate();
    RefreshAnimView.a(this.a.a).setScaleX(f);
    RefreshAnimView.a(this.a.a).setScaleY(f);
    RefreshAnimView.a(this.a.a).setPivotX(RefreshAnimView.a(this.a.a).getWidth() / 2);
    RefreshAnimView.a(this.a.a).setPivotY(RefreshAnimView.a(this.a.a).getHeight() / 2);
    localLottieDrawable.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.2
 * JD-Core Version:    0.7.0.1
 */