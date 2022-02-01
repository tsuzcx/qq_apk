package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTitleController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterAvatarController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterLikeCountController;

public class WSGridTitleInnerAvatarLikeOuterItemView
  extends AbsWSGridItemView
{
  public WSGridTitleInnerAvatarLikeOuterItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView, paramWSRecommendAdapter);
  }
  
  public void b()
  {
    super.b();
    a(2131435991, new WSGridFeedInnerTitleController(this.b));
    a(2131435998, new WSGridFeedOuterAvatarController(this.b));
    a(2131435999, new WSGridFeedOuterLikeCountController(this.b));
  }
  
  protected boolean e()
  {
    return TextUtils.isEmpty(this.d.feed_desc) ^ true;
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridTitleInnerAvatarLikeOuterItemView
 * JD-Core Version:    0.7.0.1
 */