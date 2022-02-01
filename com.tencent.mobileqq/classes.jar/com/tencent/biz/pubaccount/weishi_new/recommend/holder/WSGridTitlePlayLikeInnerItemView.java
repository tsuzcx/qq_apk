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
  
  public void b()
  {
    super.b();
    a(2131435991, new WSGridFeedInnerTitleController(this.b));
    a(2131435989, new WSGridFeedInnerPlayCountController(this.b));
    a(2131435990, new WSGridFeedInnerLikeCountController(this.b));
  }
  
  protected boolean e()
  {
    return (!TextUtils.isEmpty(this.d.feed_desc)) || (this.d.playNum != 0) || (this.d.ding_count != 0);
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitlePlayLikeInnerItemView
 * JD-Core Version:    0.7.0.1
 */