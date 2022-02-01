package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;

public abstract class WSGridFeedPlayLikeController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  protected stSimpleMetaFeed g;
  private ImageView h;
  private TextView i;
  
  public WSGridFeedPlayLikeController(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    this.g = ((stSimpleMetaFeed)c());
  }
  
  protected void b()
  {
    int j = m();
    if (j > 0)
    {
      this.h.setVisibility(0);
      this.h.setImageResource(l());
      this.i.setVisibility(0);
      this.i.setTextColor(n());
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.i, j, "0");
      return;
    }
    this.h.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626473;
  }
  
  protected void j()
  {
    this.h = ((ImageView)c(2131436097));
    this.i = ((TextView)c(2131436096));
  }
  
  protected abstract int l();
  
  protected abstract int m();
  
  @ColorInt
  protected abstract int n();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedPlayLikeController
 * JD-Core Version:    0.7.0.1
 */