package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTitleController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterAvatarController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterPlayCountController;

public class WSGridTitleInnerAvatarPlayOuterItemView
  extends AbsWSGridItemView
{
  public WSGridTitleInnerAvatarPlayOuterItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView, paramWSRecommendAdapter);
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_desc);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    a(2131369299, new WSGridFeedInnerTitleController(this.jdField_a_of_type_AndroidContentContext));
    a(2131369304, new WSGridFeedOuterAvatarController(this.jdField_a_of_type_AndroidContentContext));
    a(2131369305, new WSGridFeedOuterPlayCountController(this.jdField_a_of_type_AndroidContentContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleInnerAvatarPlayOuterItemView
 * JD-Core Version:    0.7.0.1
 */