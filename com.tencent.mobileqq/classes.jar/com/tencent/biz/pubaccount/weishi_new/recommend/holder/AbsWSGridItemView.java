package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCoverController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerMaskController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTagController;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbsWSGridItemView
  implements IWSItemView<stSimpleMetaFeed>
{
  private static final int jdField_a_of_type_Int = ScreenUtil.dip2px(10.0F);
  protected stSimpleMetaFeed a;
  protected Context a;
  protected View a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private final Map<String, AbsWsUIGroup<stSimpleMetaFeed>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private View b;
  private View c;
  
  public AbsWSGridItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
    d();
  }
  
  private void e()
  {
    View localView = this.b;
    if (a()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.b.setBackgroundResource(b());
      return;
    }
  }
  
  private void f()
  {
    View localView = this.c;
    if (b()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void g()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (a())
    {
      localLayoutParams.addRule(2, 2131369295);
      localLayoutParams.setMargins(jdField_a_of_type_Int, 0, jdField_a_of_type_Int, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(8, 2131369308);
      localLayoutParams.setMargins(jdField_a_of_type_Int, 0, jdField_a_of_type_Int, jdField_a_of_type_Int);
    }
  }
  
  protected abstract int a();
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue()).d();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue()).b(paramInt);
    }
  }
  
  public void a(@IdRes int paramInt, AbsWsUIGroup<stSimpleMetaFeed> paramAbsWsUIGroup)
  {
    paramAbsWsUIGroup.a((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(paramInt));
    this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(paramAbsWsUIGroup.hashCode()), paramAbsWsUIGroup);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    e();
    f();
    g();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue()).a(paramstSimpleMetaFeed);
    }
  }
  
  protected abstract boolean a();
  
  @DrawableRes
  protected int b()
  {
    return 2130841995;
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  protected abstract boolean b();
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void d()
  {
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131369295);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131369296);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369309));
    a(2131369294, new WSGridFeedCoverController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter));
    a(2131369307, new WSGridFeedInnerTagController(this.jdField_a_of_type_AndroidContentContext));
    a(2131369300, new WSGridFeedInnerMaskController(this.jdField_a_of_type_AndroidContentContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.AbsWSGridItemView
 * JD-Core Version:    0.7.0.1
 */