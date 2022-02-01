package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerLikeCountController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerPlayCountController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTitleController;

public class WSGridTitlePlayLikeInnerItemView
  extends AbsWSGridItemView
{
  public WSGridTitlePlayLikeInnerItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView, paramWSRecommendAdapter);
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_desc)) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.playNum != 0) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.ding_count != 0);
  }
  
  protected int b()
  {
    return 2130841887;
  }
  
  public void b()
  {
    super.b();
    a(2131369028, new WSGridFeedInnerTitleController(this.jdField_a_of_type_AndroidContentContext));
    a(2131369026, new WSGridFeedInnerPlayCountController(this.jdField_a_of_type_AndroidContentContext));
    a(2131369027, new WSGridFeedInnerLikeCountController(this.jdField_a_of_type_AndroidContentContext));
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitlePlayLikeInnerItemView
 * JD-Core Version:    0.7.0.1
 */