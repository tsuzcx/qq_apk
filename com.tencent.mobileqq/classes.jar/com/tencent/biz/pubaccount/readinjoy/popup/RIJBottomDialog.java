package com.tencent.biz.pubaccount.readinjoy.popup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJBottomDialog;", "Landroid/app/Dialog;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowRecommendPopupCommand;", "context", "Landroid/content/Context;", "source", "", "(Landroid/content/Context;I)V", "clickCloseBtn", "", "getClickCloseBtn", "()Z", "setClickCloseBtn", "(Z)V", "followPackData", "Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowPackUtils$RIJFollowPackData;", "getFollowPackData", "()Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowPackUtils$RIJFollowPackData;", "setFollowPackData", "(Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowPackUtils$RIJFollowPackData;)V", "isAnimating", "<set-?>", "Landroid/view/View;", "rootContentView", "getRootContentView", "()Landroid/view/View;", "getSource", "()I", "animateDown", "", "animateUp", "dismiss", "forceHeightWrapContent", "view", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onReceiveEvent", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onStart", "refreshFollowUI", "setContentView", "params", "Landroid/view/ViewGroup$LayoutParams;", "show", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJBottomDialog
  extends Dialog
  implements SimpleEventReceiver<RIJFollowRecommendPopupCommand>
{
  public static final RIJBottomDialog.Companion a;
  private final int jdField_a_of_type_Int;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private RIJFollowPackUtils.RIJFollowPackData jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils$RIJFollowPackData;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJBottomDialog$Companion = new RIJBottomDialog.Companion(null);
  }
  
  public RIJBottomDialog(@NotNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755327);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private final void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, localView.getHeight(), 0.0F);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
      localView.startAnimation((Animation)localTranslateAnimation);
    }
  }
  
  private final void a(View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      QLog.i("RIJBottomDialog", 1, "[forceHeightWrapContent] view is null.");
      return;
    }
    for (;;)
    {
      paramView = localView.getLayoutParams();
      if (paramView != null) {
        paramView.height = -2;
      }
      ViewParent localViewParent = localView.getParent();
      paramView = localView;
      if (localViewParent != null) {}
      try
      {
        paramView = (View)localViewParent;
        localView = paramView;
        if (paramView.getParent() != null) {
          continue;
        }
        paramView.requestLayout();
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          QLog.e("RIJBottomDialog", 1, "[forceHeightWrapContent] e = " + paramView);
          paramView = localView;
        }
      }
    }
  }
  
  private final void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localView.getHeight());
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
      localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new RIJBottomDialog.animateDown..inlined.let.lambda.1(this));
      localView.startAnimation((Animation)localTranslateAnimation);
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils$RIJFollowPackData;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((RIJFollowPackUtils.RIJFollowPackData)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((ArticleInfo)localObject1).mRecommendFollowInfos;
        if (localObject1 != null)
        {
          localObject2 = ((RecommendFollowInfos)localObject1).a;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.recommendFollowInfoList");
          if (((Collection)localObject2).isEmpty()) {
            break label98;
          }
        }
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = RIJFollowPackUtils.a;
        localObject1 = ((RecommendFollowInfos)localObject1).a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.recommendFollowInfoList");
        ((RIJFollowPackUtils)localObject2).a((List)localObject1);
        localObject1 = RIJFollowPackUtils.a;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils$RIJFollowPackData;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((RIJFollowPackUtils)localObject1).a((RIJFollowPackUtils.RIJFollowPackData)localObject2);
      }
      return;
    }
  }
  
  @Nullable
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public final void a(@Nullable RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils$RIJFollowPackData = paramRIJFollowPackData;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void dismiss()
  {
    if (this.b) {
      return;
    }
    b();
    RIJFollowPackUtils.a.a();
    Object localObject2 = RIJFollowRecommendReport.a.a(Integer.valueOf(this.jdField_a_of_type_Int));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).b("close_way", (String)localObject1);
      localObject1 = RIJFollowRecommendReport.a;
      localObject2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "r5Builder.toString()");
      ((RIJFollowRecommendReport.Companion)localObject1).a("0X800B997", (String)localObject2);
      SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
      return;
    }
  }
  
  @NotNull
  public ArrayList<Class<RIJFollowRecommendPopupCommand>> getEventClass()
  {
    return CollectionsKt.arrayListOf(new Class[] { RIJFollowRecommendPopupCommand.class });
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setGravity(80);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -2);
    }
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof RIJFollowRecommendPopupCommand)) {}
    switch (((RIJFollowRecommendPopupCommand)paramSimpleBaseEvent).getCommand())
    {
    default: 
      return;
    case 1: 
      dismiss();
      return;
    }
    c();
  }
  
  protected void onStart()
  {
    super.onStart();
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void setContentView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.jdField_a_of_type_AndroidViewView = paramView;
    super.setContentView(paramView);
  }
  
  public void setContentView(@NotNull View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.jdField_a_of_type_AndroidViewView = paramView;
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).post((Runnable)new RIJBottomDialog.show.1(this));
    }
    localObject = RIJFollowRecommendReport.a;
    String str = RIJFollowRecommendReport.a.a(Integer.valueOf(this.jdField_a_of_type_Int)).toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJFollowRecommendReport…uilder(source).toString()");
    ((RIJFollowRecommendReport.Companion)localObject).a("0X800B96A", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJBottomDialog
 * JD-Core Version:    0.7.0.1
 */