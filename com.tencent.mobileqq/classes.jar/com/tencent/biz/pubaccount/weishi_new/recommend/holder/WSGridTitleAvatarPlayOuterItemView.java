package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterAvatarController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterPlayCountController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterTitleController;

public class WSGridTitleAvatarPlayOuterItemView
  extends AbsWSGridItemView
{
  public WSGridTitleAvatarPlayOuterItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
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
  
  protected boolean b()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    a(2131369306, new WSGridFeedOuterTitleController(this.a));
    a(2131369304, new WSGridFeedOuterAvatarController(this.a));
    a(2131369305, new WSGridFeedOuterPlayCountController(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleAvatarPlayOuterItemView
 * JD-Core Version:    0.7.0.1
 */