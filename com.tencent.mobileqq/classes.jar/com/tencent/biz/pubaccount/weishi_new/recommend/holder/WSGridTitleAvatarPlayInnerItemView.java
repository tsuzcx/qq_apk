package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerAvatarController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerPlayCountController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTitleController;

public class WSGridTitleAvatarPlayInnerItemView
  extends AbsWSGridItemView
{
  public WSGridTitleAvatarPlayInnerItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView, paramWSRecommendAdapter);
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected int b()
  {
    return 2130841990;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    a(2131369299, new WSGridFeedInnerTitleController(this.a));
    a(2131369297, new WSGridFeedInnerAvatarController(this.a));
    a(2131369298, new WSGridFeedInnerPlayCountController(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleAvatarPlayInnerItemView
 * JD-Core Version:    0.7.0.1
 */