package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.TabAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabLayout;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabLayout$RIJXTabAdapter;", "indicator", "Landroid/view/View;", "lastOffset", "", "needDeferAnimation", "", "scrollState", "tabLayout", "Lcom/tencent/biz/widgets/TabLayout;", "viewPagerController", "Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;", "animateSelectedTab", "", "textView", "Landroid/widget/TextView;", "animateTabTitle", "selectedIndex", "animateUnselectedTab", "doOnPageSelected", "index", "getTargetMargin", "init", "layoutInflater", "Landroid/view/LayoutInflater;", "isOutOfIndex", "moveIndicatorByOffset", "currentIndex", "targetIndex", "offset", "moveIndicatorToTargetIndex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffsetPixels", "onPageSelected", "settleIndicator", "switchImmersiveMode", "immersive", "updateRedDot", "updateUI", "itemList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "Companion", "RIJXTabAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabLayout
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  public static final RIJXTabLayout.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private RIJXTabViewPagerController jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
  private RIJXTabLayout.RIJXTabAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter;
  private TabLayout jdField_a_of_type_ComTencentBizWidgetsTabLayout;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$Companion = new RIJXTabLayout.Companion(null);
  }
  
  public RIJXTabLayout(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(localLayoutInflater, "LayoutInflater.from(context)");
    a(paramContext, localLayoutInflater);
  }
  
  public RIJXTabLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "LayoutInflater.from(context)");
    a(paramContext, paramAttributeSet);
  }
  
  public RIJXTabLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "LayoutInflater.from(context)");
    a(paramContext, paramAttributeSet);
  }
  
  private final int a(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      localObject = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      i += ((TabLayout)localObject).a(j);
      j += 1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramInt = ((TabLayout)localObject).a(paramInt) / 2;
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    return paramInt - ((View)localObject).getMeasuredWidth() / 2 + i;
  }
  
  private final void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if ((a(paramInt1)) || (a(paramInt2))) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    if (((View)localObject).getVisibility() != 0)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      ((View)localObject).setVisibility(0);
    }
    paramInt1 = a(paramInt1);
    paramInt2 = a(paramInt2);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localObject = ((View)localObject).getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    float f = paramInt1;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = ((int)((paramInt2 - paramInt1) * paramFloat + f));
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void a(TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramTextView.getScaleX(), 1.2F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new RIJXTabLayout.animateSelectedTab..inlined.apply.lambda.1(paramTextView));
    localValueAnimator.start();
  }
  
  private final boolean a(int paramInt)
  {
    TabLayout localTabLayout;
    if (paramInt >= 0)
    {
      localTabLayout = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
      if (localTabLayout == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
    }
    return paramInt > localTabLayout.a() - 1;
  }
  
  private final void b(TextView paramTextView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramTextView.getScaleX(), 1.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.1(paramTextView));
    localValueAnimator.addListener((Animator.AnimatorListener)new RIJXTabLayout.animateUnselectedTab..inlined.apply.lambda.2(paramTextView));
    localValueAnimator.start();
  }
  
  public final void a()
  {
    RIJXTabLayout.RIJXTabAdapter localRIJXTabAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter;
    if (localRIJXTabAdapter != null) {
      localRIJXTabAdapter.notifyDataSetChanged();
    }
  }
  
  @VisibleForTesting
  public final void a(int paramInt)
  {
    TabLayout localTabLayout = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (localTabLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    if (localTabLayout.a() == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      QLog.d("RIJXTabLayout", 1, "onPageSelected:" + paramInt + " needDeferAnimation:" + this.jdField_a_of_type_Boolean);
      return;
      this.jdField_a_of_type_Boolean = false;
      settleIndicator(paramInt);
      b(paramInt);
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull Context paramContext, @NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "layoutInflater");
    paramLayoutInflater.inflate(2131562904, (ViewGroup)this, true);
    paramContext = findViewById(2131378847);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.tab_layout)");
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = ((TabLayout)paramContext);
    paramContext = findViewById(2131378842);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.tab_indicator)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.setHorizontalFadingEdgeEnabled(false);
    paramContext = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.setOverScrollMode(2);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull List<? extends TabChannelCoverInfo> paramList, @NotNull RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramList, "itemList");
    Intrinsics.checkParameterIsNotNull(paramRIJXTabViewPagerController, "viewPagerController");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController = paramRIJXTabViewPagerController;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter = new RIJXTabLayout.RIJXTabAdapter(this, paramContext, paramList, paramRIJXTabViewPagerController);
    paramContext = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramContext.setAdapter((TabLayout.TabAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter);
    paramContext = ((Iterable)paramList).iterator();
    while (paramContext.hasNext())
    {
      paramList = (TabChannelCoverInfo)paramContext.next();
      RIJChannelReporter.a("0X8009495", new RIJTransMergeKanDianReport.ReportR5Builder().a(paramList.mChannelCoverId).f().a());
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 2130849943;; i = 2130849942)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      ((View)localObject).setBackgroundResource(i);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter;
      if (localObject != null) {
        ((RIJXTabLayout.RIJXTabAdapter)localObject).a(paramBoolean, paramInt);
      }
      return;
    }
  }
  
  @VisibleForTesting
  public final void b(int paramInt)
  {
    if (a(paramInt)) {}
    do
    {
      do
      {
        return;
        QLog.d("RIJXTabLayout", 1, "animateTabTitle:" + paramInt);
        localObject = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        localObject = ((TabLayout)localObject).a(paramInt);
      } while (localObject == null);
      localObject = (TextView)((View)localObject).findViewById(2131380651);
    } while (localObject == null);
    a((TextView)localObject);
    Object localObject = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    int j = ((TabLayout)localObject).a();
    int i = 0;
    label112:
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      localObject = ((TabLayout)localObject).a(i);
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131380651);
        if (localObject != null)
        {
          if (i != paramInt) {
            break label182;
          }
          a((TextView)localObject);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label112;
      break;
      label182:
      b((TextView)localObject);
    }
  }
  
  @VisibleForTesting
  public final void c(int paramInt)
  {
    if (a(paramInt)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    if (((View)localObject).getVisibility() != 0)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      ((View)localObject).setVisibility(0);
    }
    paramInt = a(paramInt);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localObject = ((View)localObject).getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = paramInt;
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter;
    if (paramConfiguration != null) {
      paramConfiguration.a(true);
    }
    paramConfiguration = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (paramConfiguration != null) {
      onPageSelected(paramConfiguration.a());
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController != null) {
      settleIndicator(localRIJXTabViewPagerController.a());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < this.jdField_a_of_type_Float) {
      a(paramInt1 + 1, paramInt1, 1 - paramFloat);
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = paramFloat;
      return;
      a(paramInt1, paramInt1 + 1, paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    if (localTabLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localTabLayout.post((Runnable)new RIJXTabLayout.onPageSelected.1(this, paramInt));
  }
  
  @VisibleForTesting
  public final void settleIndicator(int paramInt)
  {
    QLog.d("RIJXTabLayout", 1, "settleIndicator:" + paramInt + " scrollState:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0) {
      c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabLayout
 * JD-Core Version:    0.7.0.1
 */