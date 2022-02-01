package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCoverController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerMaskController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTagController;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public abstract class AbsWSGridItemView
  extends AbsWSItemView<stSimpleMetaFeed>
{
  private static final int jdField_a_of_type_Int = ScreenUtil.dip2px(10.0F);
  protected stSimpleMetaFeed a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private View b;
  private View c;
  
  public AbsWSGridItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
    e();
  }
  
  private void e()
  {
    a(2131369023, new WSGridFeedCoverController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter));
    if (c()) {
      a(2131369039, new WSGridFeedInnerTagController(this.jdField_a_of_type_AndroidContentContext));
    }
    a(2131369029, new WSGridFeedInnerMaskController(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void f()
  {
    View localView = this.b;
    int i;
    if (a()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    this.b.setBackgroundResource(b());
  }
  
  private void g()
  {
    View localView = this.c;
    int i;
    if (b()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i;
    if (a())
    {
      localLayoutParams.addRule(2, 2131369024);
      i = jdField_a_of_type_Int;
      localLayoutParams.setMargins(i, 0, i, 0);
    }
    else
    {
      localLayoutParams.addRule(8, 2131369040);
      i = jdField_a_of_type_Int;
      localLayoutParams.setMargins(i, 0, i, i);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  protected abstract int a();
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    f();
    g();
    h();
    super.a(paramstSimpleMetaFeed);
  }
  
  protected abstract boolean a();
  
  @DrawableRes
  protected int b()
  {
    return 2130841892;
  }
  
  public void b()
  {
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131369024);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131369025);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369041));
  }
  
  protected abstract boolean b();
  
  public void c() {}
  
  protected boolean c()
  {
    return true;
  }
  
  public void d() {}
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.AbsWSGridItemView
 * JD-Core Version:    0.7.0.1
 */