package com.tencent.biz.qqcircle.fragments.person.control;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.manager.QCirclePersonalPymkModelManager;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.widgets.person.QCirclePersonalPymkContainerView;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendAdapter.IWidgetHideIntercept;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QCirclePersonHeaderPymkControl
  extends QCircleBasePersonalHeaderControl
  implements View.OnClickListener, QCirclePYMKRecommendAdapter.IWidgetHideIntercept
{
  private FrameLayout a;
  private ImageView b;
  private ViewStub c;
  private View d;
  private View e;
  private QCirclePersonalPymkContainerView f;
  private Context g = null;
  private FeedCloudMeta.StFeed h = null;
  private boolean i = false;
  private int j;
  private QCirclePersonalPymkModelManager k;
  private int l;
  private FeedCloudMeta.StUser m;
  
  private ValueAnimator a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.addUpdateListener(new QCirclePersonHeaderPymkControl.3(this));
    localValueAnimator.setDuration(200L);
    localValueAnimator.addListener(new QCirclePersonHeaderPymkControl.4(this, paramBoolean));
    return localValueAnimator;
  }
  
  private void a(float paramFloat)
  {
    View localView = this.e;
    if (localView == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[handlerAlphaAnimationUpdate] personal base info view should not be null.");
      return;
    }
    localView.setAlpha(paramFloat);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("PYMK-QCirclePersonHeaderPymkControl", 1, "[handlerPersonalPymkResult] feeds should not be null.");
      b(8);
      return;
    }
    b(0);
    this.h = paramStFeed;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.h == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[updatePymkDisplayState] current pymk feed data is null.");
      return;
    }
    this.i = paramBoolean;
    QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, new Object[] { "[updatePymkDisplayState] isOpenPymk: ", Boolean.valueOf(paramBoolean) });
    int i1;
    if (paramBoolean) {
      i1 = 2130845409;
    } else {
      i1 = 2130845408;
    }
    int n;
    if (QCircleConfigHelper.bg())
    {
      if (paramBoolean) {
        n = 2130845782;
      } else {
        n = 2130845781;
      }
    }
    else if (paramBoolean) {
      n = 2130845319;
    } else {
      n = 2130845318;
    }
    Drawable localDrawable = QCircleSkinHelper.getInstance().getDrawable(i1);
    Object localObject = this.b;
    if ((localObject != null) && (localDrawable != null)) {
      ((ImageView)localObject).setImageDrawable(localDrawable);
    }
    localDrawable = QCircleSkinHelper.getInstance().getDrawable(n);
    localObject = this.a;
    if ((localObject != null) && (localDrawable != null)) {
      ((FrameLayout)localObject).setBackgroundDrawable(localDrawable);
    }
    b(paramBoolean ^ true);
    if (paramBoolean)
    {
      h();
      return;
    }
    g();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = this.e;
    if (localView == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[handlerAnimStateChange] personal base info view should not be null.");
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      localView.setVisibility(0);
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.e.setVisibility(8);
    }
  }
  
  private ValueAnimator b(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.addUpdateListener(new QCirclePersonHeaderPymkControl.5(this));
    localValueAnimator.setDuration(120L);
    localValueAnimator.addListener(new QCirclePersonHeaderPymkControl.6(this, paramBoolean));
    return localValueAnimator;
  }
  
  private void b(float paramFloat)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[handlerHeightAnimationUpdate] personal base info view should not be null.");
      return;
    }
    int n = (int)(this.j * paramFloat);
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof LinearLayout.LayoutParams))
    {
      localObject = (LinearLayout.LayoutParams)localObject;
      ((LinearLayout.LayoutParams)localObject).height = n;
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void b(int paramInt)
  {
    FrameLayout localFrameLayout = this.a;
    if (localFrameLayout == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[updateOperationIconVisible] operation view not is null.");
      return;
    }
    if (localFrameLayout.getVisibility() != paramInt) {
      this.a.setVisibility(paramInt);
    }
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    if (this.k == null)
    {
      this.k = new QCirclePersonalPymkModelManager();
      this.k.a();
    }
    this.k.a(new QCirclePersonHeaderPymkControl.2(this));
    this.k.a(paramStUser);
  }
  
  private void b(boolean paramBoolean)
  {
    float f2 = 0.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    if (paramBoolean) {
      f2 = 1.0F;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ValueAnimator localValueAnimator1 = b(paramBoolean, f1, f2);
    ValueAnimator localValueAnimator2 = a(paramBoolean, f1, f2);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(localValueAnimator2);
      localArrayList.add(localValueAnimator1);
    }
    else
    {
      localArrayList.add(localValueAnimator1);
      localArrayList.add(localValueAnimator2);
    }
    c(paramBoolean);
    localAnimatorSet.playSequentially(localArrayList);
    localAnimatorSet.start();
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject2 = new QCircleDTParamBuilder().buildElementParams();
    if (this.b != null)
    {
      if (paramBoolean) {
        localObject1 = "expand";
      } else {
        localObject1 = "fold";
      }
      ((Map)localObject2).put("xsj_button_status", localObject1);
      VideoReport.setElementId(this.b, "em_xsj_expand_button");
      VideoReport.setElementParams(this.b, (Map)localObject2);
      Object localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("xsj_button_status_");
      ((StringBuilder)localObject2).append(this.b.hashCode());
      VideoReport.setElementReuseIdentifier(localObject1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void d()
  {
    View localView = this.e;
    if (localView == null)
    {
      QLog.w("PYMK-QCirclePersonHeaderPymkControl", 1, "[updateBaseInfoHeight] personal should not be null.");
      return;
    }
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new QCirclePersonHeaderPymkControl.1(this));
  }
  
  private void e()
  {
    FrameLayout localFrameLayout = this.a;
    if (localFrameLayout != null) {
      localFrameLayout.setOnClickListener(this);
    }
  }
  
  private void f()
  {
    if (this.g == null)
    {
      QLog.w("PYMK-QCirclePersonHeaderPymkControl", 1, "[changeOperationShow] context should not click.");
      return;
    }
    if (FastClickUtils.a("PYMK-QCirclePersonHeaderPymkControlchangeOperationShow", 500L))
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[changeOperationShow] operate too fast to handle, try again later.");
      return;
    }
    a(this.i ^ true);
  }
  
  private void g()
  {
    if (this.d == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[hideProfilePymkRecommendView] container layout should not be null.");
      return;
    }
    QCirclePersonalPymkContainerView localQCirclePersonalPymkContainerView = this.f;
    if (localQCirclePersonalPymkContainerView == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[hideProfilePymkRecommendView] pymk view view should not be null.");
      return;
    }
    localQCirclePersonalPymkContainerView.a();
  }
  
  private void h()
  {
    if (this.d == null) {
      this.d = this.c.inflate();
    }
    this.f = ((QCirclePersonalPymkContainerView)this.d.findViewById(2131441766));
    QCirclePersonalPymkContainerView localQCirclePersonalPymkContainerView = this.f;
    if (localQCirclePersonalPymkContainerView == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[showProfilePymkRecommendView] pymk container view should not be null.");
      return;
    }
    localQCirclePersonalPymkContainerView.setPageId(this.l);
    this.f.setWidgetHideIntercept(this);
    this.f.a(this.h);
  }
  
  public void a()
  {
    QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[release] current pymk operation clear resource.");
    FrameLayout localFrameLayout = this.a;
    if (localFrameLayout != null)
    {
      localFrameLayout.setOnClickListener(null);
      this.a = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
    QCirclePersonalPymkContainerView localQCirclePersonalPymkContainerView = this.f;
    if (localQCirclePersonalPymkContainerView != null) {
      localQCirclePersonalPymkContainerView.setPageId(paramInt);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[onInitView] root view should not be null.");
      return;
    }
    this.g = paramContext;
    this.a = ((FrameLayout)paramView.findViewById(2131441836));
    this.b = ((ImageView)paramView.findViewById(2131441837));
    this.c = ((ViewStub)paramView.findViewById(2131437513));
    this.e = paramView.findViewById(2131429337);
    e();
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if (QCirclePluginUtil.b(paramStUser)) {
      return;
    }
    Object localObject = this.m;
    String str = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FeedCloudMeta.StUser)localObject).id.get();
    }
    if (paramStUser != null) {
      str = paramStUser.id.get();
    }
    if ((!TextUtils.isEmpty(str)) && (TextUtils.equals((CharSequence)localObject, str))) {
      return;
    }
    this.m = paramStUser;
    b(0);
    d();
    b(paramStUser);
    if (this.i) {
      a(false);
    }
  }
  
  public void b()
  {
    if (this.i)
    {
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[handlerRecommendPymkDisplay] current pymk is open state, not repeat handler.");
      return;
    }
    a(true);
  }
  
  public boolean c()
  {
    QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, "[onWidgetHideIntercept] intercept widget hide handler.");
    a(false);
    b(this.m);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441836) {
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl
 * JD-Core Version:    0.7.0.1
 */