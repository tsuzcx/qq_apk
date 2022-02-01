package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

public class WSGridFeedInnerTitleController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public WSGridFeedInnerTitleController(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  public int b()
  {
    return 2131560541;
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_desc;
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  @ColorInt
  protected int c()
  {
    return -1;
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369393));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTitleController
 * JD-Core Version:    0.7.0.1
 */