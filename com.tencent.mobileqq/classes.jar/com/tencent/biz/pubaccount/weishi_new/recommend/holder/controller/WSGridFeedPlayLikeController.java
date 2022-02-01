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
  protected stSimpleMetaFeed a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public WSGridFeedPlayLikeController(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  protected int b()
  {
    return 2131560428;
  }
  
  protected void b()
  {
    int i = d();
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(c());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(e());
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.jdField_a_of_type_AndroidWidgetTextView, i, "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected abstract int c();
  
  protected void c() {}
  
  protected abstract int d();
  
  @ColorInt
  protected abstract int e();
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369127));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369126));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedPlayLikeController
 * JD-Core Version:    0.7.0.1
 */