package com.tencent.gdtad.views.canvas.components.danmaku;

import android.os.Handler;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

class GdtDanmakuPresenter$DanmakuRunnable
  implements Runnable
{
  private int a;
  
  public GdtDanmakuPresenter$DanmakuRunnable(GdtDanmakuPresenter paramGdtDanmakuPresenter, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create new danmaku item in row ");
    ((StringBuilder)localObject).append(this.a);
    AdLog.i("GdtDanmakuPresenter", ((StringBuilder)localObject).toString());
    localObject = GdtDanmakuPresenter.a(this.this$0);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    ((GdtDanmakuItemView)localObject).measure(i, i);
    i = ((GdtDanmakuItemView)localObject).getMeasuredWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((GdtDanmakuItemView)localObject).getLayoutParams();
    localLayoutParams.topMargin = (this.a * (((GdtDanmakuItemView)localObject).getMeasuredHeight() + AdUIUtils.dp2px(GdtDanmakuPresenter.a(this.this$0), this.this$0.getResources())));
    ((GdtDanmakuItemView)localObject).setLayoutParams(localLayoutParams);
    this.this$0.addView((View)localObject);
    ((GdtDanmakuItemView)localObject).a();
    i = (int)((GdtDanmakuPresenter.b(this.this$0) + AdUIUtils.px2dp(this.this$0.getContext(), i)) / GdtDanmakuPresenter.a(this.this$0));
    GdtDanmakuPresenter.a(this.this$0).postDelayed(GdtDanmakuPresenter.a(this.this$0)[this.a], i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter.DanmakuRunnable
 * JD-Core Version:    0.7.0.1
 */