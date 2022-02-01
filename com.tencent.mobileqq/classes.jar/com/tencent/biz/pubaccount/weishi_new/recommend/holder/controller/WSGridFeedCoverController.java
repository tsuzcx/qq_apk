package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSGridFeedCoverController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private static final int d = WSFeedUtils.a(5.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private final View b;
  private View c;
  private final int e;
  
  public WSGridFeedCoverController(Context paramContext, View paramView, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext);
    this.e = paramInt;
    this.b = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
  }
  
  private Drawable a()
  {
    String str = WeishiUtils.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, true);
    if (!TextUtils.isEmpty(str))
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      if (!WeishiUIUtil.a(str)) {
        str = "#D9D9D9";
      }
      localColorDrawable.setColor(Color.parseColor(str));
      return localColorDrawable;
    }
    return WSFeedUtils.a(2131165740);
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id)) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.b, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id)) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_Boolean))
    {
      if (this.c == null) {
        this.c = ((ViewStub)this.b.findViewById(2131369038)).inflate();
      }
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = ((Integer)paramPair.first).intValue();
        ((FrameLayout.LayoutParams)localObject).height = ((Integer)paramPair.second).intValue();
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.c.setVisibility(0);
      }
      return;
    }
    paramPair = this.c;
    if (paramPair != null) {
      paramPair.setVisibility(8);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(d, this.e);
    g();
  }
  
  private void g()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131379673);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int i;
    if (this.e == 1)
    {
      i = d;
      localGradientDrawable.setCornerRadii(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    }
    else
    {
      i = d;
      localGradientDrawable.setCornerRadii(new float[] { i, i, i, i, i, i, i, i });
    }
    localGradientDrawable.setColor(a().getColor(2131165329));
    ((TextView)localObject).setBackgroundDrawable(localGradientDrawable);
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.waterFallCardStyle;
    boolean bool;
    if ((localObject != null) && (((stWaterFallCardStyle)localObject).isFullSpan)) {
      bool = true;
    } else {
      bool = false;
    }
    ((StaggeredGridLayoutManager.LayoutParams)this.b.getLayoutParams()).setFullSpan(bool);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.getLayoutParams();
    Pair localPair = WeishiUIUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    ((FrameLayout.LayoutParams)localObject).width = ((Integer)localPair.first).intValue();
    ((FrameLayout.LayoutParams)localObject).height = ((Integer)localPair.second).intValue();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
    if ((localObject != null) && (!TextUtils.isEmpty(((WSRecommendAdapter)localObject).jdField_a_of_type_JavaLangString)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("feeds_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "feeds";
    }
    WSPicLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, a(), (String)localObject, true, a());
    a(localPair);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  protected int b()
  {
    return 2131560424;
  }
  
  protected void b()
  {
    h();
    f();
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)a(2131369120));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCoverController
 * JD-Core Version:    0.7.0.1
 */