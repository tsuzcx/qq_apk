package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

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
  
  public void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  public int b()
  {
    return 2131560539;
  }
  
  public void b()
  {
    int i = d();
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(c());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(e());
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetTextView, i, "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected abstract int c();
  
  public void c() {}
  
  protected abstract int d();
  
  @ColorInt
  protected abstract int e();
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369399));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369398));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedPlayLikeController
 * JD-Core Version:    0.7.0.1
 */