package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterAvatarController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterLikeCountController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterTitleController;

public class WSGridTitleAvatarLikeOuterItemView
  extends AbsWSGridItemView
{
  public WSGridTitleAvatarLikeOuterItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView, paramWSRecommendAdapter);
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b()
  {
    super.b();
    a(2131369037, new WSGridFeedOuterTitleController(this.a));
    a(2131369035, new WSGridFeedOuterAvatarController(this.a));
    a(2131369036, new WSGridFeedOuterLikeCountController(this.a));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleAvatarLikeOuterItemView
 * JD-Core Version:    0.7.0.1
 */