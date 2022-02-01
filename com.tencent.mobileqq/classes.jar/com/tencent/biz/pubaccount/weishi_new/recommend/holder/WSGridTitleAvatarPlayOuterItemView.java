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
  
  public void b()
  {
    super.b();
    a(2131436000, new WSGridFeedOuterTitleController(this.b));
    a(2131435998, new WSGridFeedOuterAvatarController(this.b));
    a(2131435999, new WSGridFeedOuterPlayCountController(this.b));
  }
  
  protected boolean e()
  {
    return false;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  protected int g()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleAvatarPlayOuterItemView
 * JD-Core Version:    0.7.0.1
 */