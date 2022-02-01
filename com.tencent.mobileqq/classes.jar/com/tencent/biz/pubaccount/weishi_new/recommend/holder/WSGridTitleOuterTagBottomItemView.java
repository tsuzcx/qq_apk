package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterAvatarController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterBottomTagController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterLikeCountController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterTitleSmallerController;

public class WSGridTitleOuterTagBottomItemView
  extends AbsWSGridItemView
{
  public WSGridTitleOuterTagBottomItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView, paramWSRecommendAdapter);
    a(2131369037, new WSGridFeedOuterTitleSmallerController(this.a));
    a(2131369035, new WSGridFeedOuterAvatarController(this.a));
    a(2131369036, new WSGridFeedOuterLikeCountController(this.a));
    a(2131369031, new WSGridFeedOuterBottomTagController(this.a));
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleOuterTagBottomItemView
 * JD-Core Version:    0.7.0.1
 */