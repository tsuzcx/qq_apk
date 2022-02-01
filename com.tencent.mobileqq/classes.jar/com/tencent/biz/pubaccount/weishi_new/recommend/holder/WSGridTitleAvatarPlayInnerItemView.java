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
  
  public void b()
  {
    super.b();
    a(2131435991, new WSGridFeedInnerTitleController(this.b));
    a(2131435989, new WSGridFeedInnerAvatarController(this.b));
    a(2131435990, new WSGridFeedInnerPlayCountController(this.b));
  }
  
  protected boolean e()
  {
    return true;
  }
  
  protected boolean f()
  {
    return false;
  }
  
  protected int g()
  {
    return 0;
  }
  
  protected int h()
  {
    return 2130842805;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleAvatarPlayInnerItemView
 * JD-Core Version:    0.7.0.1
 */