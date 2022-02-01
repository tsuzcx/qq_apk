package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.view.RIJBlackWhiteModeLinearLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar;", "Lcom/tencent/biz/pubaccount/readinjoy/view/RIJBlackWhiteModeLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "deliverBtn", "Landroid/widget/ImageView;", "moreChannelBtn", "moreChannelBtnRedDot", "getMoreChannelBtnRedDot", "()Landroid/widget/ImageView;", "setMoreChannelBtnRedDot", "(Landroid/widget/ImageView;)V", "onBtnClickListener", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar$OnBtnClickListener;", "onPageChangeListener", "com/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar$onPageChangeListener$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar$onPageChangeListener$1;", "searchBtn", "selfBtn", "selfBtnNotifyIcon", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "getSelfBtnNotifyIcon", "()Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "setSelfBtnNotifyIcon", "(Lcom/tencent/mobileqq/tianshu/ui/RedTouch;)V", "tabLayout", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabLayout;", "topicBtn", "buildRedTouch", "configDtReportParam", "", "doOnTabChange", "visible", "", "getTabLayout", "init", "refreshDeliverBtnVisibility", "refreshMoreChannelBtnRedDotVisibility", "refreshTopicBtnVisibility", "reportTopicBtnExposure", "setOnBtnClickListener", "listener", "switchImmersiveMode", "immersive", "selectedIndex", "updateUI", "viewPager", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager;", "itemList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "viewPagerController", "Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;", "Companion", "OnBtnClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBar
  extends RIJBlackWhiteModeLinearLayout
{
  public static final RIJXTabBar.Companion a;
  @NotNull
  public ImageView a;
  private RIJXTabBar.OnBtnClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar$OnBtnClickListener;
  private final RIJXTabBar.onPageChangeListener.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar$onPageChangeListener$1 = new RIJXTabBar.onPageChangeListener.1(this);
  private RIJXTabLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout;
  @NotNull
  public RedTouch a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar$Companion = new RIJXTabBar.Companion(null);
  }
  
  public RIJXTabBar(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RIJXTabBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RIJXTabBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementId(localObject, "head_sculpture_button");
    localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").c("click_head_sculpture"), null, 1, null).a());
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementId(localObject, "search_box_button");
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").b("search_box").c("click_search_box"), null, 1, null).a());
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementId(localObject, "more_channel_button");
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").b("channel_bar").c("click_more_channel"), null, 1, null).a());
  }
  
  private final void c()
  {
    Object localObject = Aladdin.getConfig(440);
    int i;
    if (localObject != null)
    {
      i = ((AladdinConfig)localObject).getIntegerFromString("fourTab_button_hashTag", 0);
      if (i != 1) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("RIJXTabBar", 1, "[refreshTopicBtnVisibility] showTopic = " + bool);
      if (!bool) {
        break label125;
      }
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnRedDot");
      }
      ((ImageView)localObject).setVisibility(8);
      return;
      i = 0;
      break;
    }
    label125:
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setVisibility(0);
  }
  
  private final void d()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a().c().f();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800BA07", "0X800BA07", 0, 0, "", "", "", localReportR5Builder.a(), false);
  }
  
  @NotNull
  public final RIJXTabLayout a()
  {
    RIJXTabLayout localRIJXTabLayout = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout;
    if (localRIJXTabLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    return localRIJXTabLayout;
  }
  
  @NotNull
  public final RedTouch a()
  {
    RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localRedTouch == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    return localRedTouch;
  }
  
  public final void a()
  {
    boolean bool = RIJUgcUtils.m();
    ImageView localImageView;
    if (bool)
    {
      localImageView = this.d;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
        QLog.i("RIJXTabBar", 2, "[refreshDeliverButton] needShow = " + bool);
      }
      return;
      localImageView = this.d;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      localImageView.setVisibility(4);
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    LayoutInflater.from(paramContext).inflate(2131562901, (ViewGroup)this, true);
    paramContext = findViewById(2131376611);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_self_btn)");
    this.c = ((ImageView)paramContext);
    paramContext = findViewById(2131376622);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_tab_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout = ((RIJXTabLayout)paramContext);
    paramContext = findViewById(2131376592);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_more_tab_btn)");
    this.e = ((ImageView)paramContext);
    paramContext = findViewById(2131376545);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_deliver_btn)");
    this.d = ((ImageView)paramContext);
    paramContext = findViewById(2131376610);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_search_btn)");
    this.b = ((ImageView)paramContext);
    paramContext = findViewById(2131376633);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_topic_btn)");
    this.f = ((ImageView)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = b();
    paramContext = findViewById(2131376593);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_more_tab_red_dot)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.1(this));
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.2(this));
    paramContext = this.e;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.3(this));
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.4(this));
    paramContext = this.f;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.5(this));
    a();
    c();
    b();
  }
  
  public final void a(@NotNull ReadInJoyChannelViewPager paramReadInJoyChannelViewPager, @NotNull List<? extends TabChannelCoverInfo> paramList, @NotNull RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyChannelViewPager, "viewPager");
    Intrinsics.checkParameterIsNotNull(paramList, "itemList");
    Intrinsics.checkParameterIsNotNull(paramRIJXTabViewPagerController, "viewPagerController");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramReadInJoyChannelViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)localObject);
    removeAllViews();
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    a((Context)localObject);
    paramReadInJoyChannelViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar$onPageChangeListener$1);
    paramReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar$onPageChangeListener$1);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RIJXTabLayout)localObject).a(localContext, paramList, paramRIJXTabViewPagerController);
    paramReadInJoyChannelViewPager.post((Runnable)new RIJXTabBar.updateUI.1(this, paramReadInJoyChannelViewPager));
  }
  
  public final void a(boolean paramBoolean)
  {
    ImageView localImageView = this.e;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    if (localImageView.getVisibility() != 0)
    {
      QLog.i("RIJXTabBar", 1, "[refreshMoreChannelBtnRedDotVisibility] moreChannelBtn is not visible.");
      return;
    }
    localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnRedDot");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  @VisibleForTesting
  public final void a(boolean paramBoolean, int paramInt)
  {
    int i;
    int j;
    label18:
    int k;
    label27:
    int m;
    label36:
    int n;
    label45:
    Object localObject;
    if (paramBoolean)
    {
      i = 2130849949;
      if (!paramBoolean) {
        break label312;
      }
      j = 2130849941;
      if (!paramBoolean) {
        break label320;
      }
      k = 2130849945;
      if (!paramBoolean) {
        break label328;
      }
      m = 2130849947;
      if (!paramBoolean) {
        break label336;
      }
      n = 2130849951;
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selfBtn");
      }
      ((ImageView)localObject).setImageResource(i);
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      ((ImageView)localObject).setImageResource(j);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
      }
      ((ImageView)localObject).setImageResource(k);
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
      }
      ((ImageView)localObject).setImageResource(m);
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      ((ImageView)localObject).setImageResource(n);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      ((RIJXTabLayout)localObject).a(paramBoolean, paramInt);
      if (!paramBoolean) {
        break label344;
      }
    }
    label312:
    label320:
    label328:
    label336:
    label344:
    for (float f1 = 0.8F;; f1 = 1.0F)
    {
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selfBtn");
      }
      ((ImageView)localObject).setAlpha(f1);
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      ((ImageView)localObject).setAlpha(f1);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
      }
      ((ImageView)localObject).setAlpha(f1);
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
      }
      ((ImageView)localObject).setAlpha(f1);
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      ((ImageView)localObject).setAlpha(f1);
      return;
      i = 2130849948;
      break;
      j = 2130849940;
      break label18;
      k = 2130849944;
      break label27;
      m = 2130849946;
      break label36;
      n = 2130849950;
      break label45;
    }
  }
  
  @VisibleForTesting
  @NotNull
  public final RedTouch b()
  {
    RedTouch localRedTouch = new RedTouch(getContext(), findViewById(2131376612)).b(8388661).a();
    Intrinsics.checkExpressionValueIsNotNull(localRedTouch, "RedTouch(this.context, t…               .applyTo()");
    return localRedTouch;
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ImageView localImageView = this.f;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      if (localImageView.getVisibility() == 0) {
        d();
      }
    }
  }
  
  public final void setMoreChannelBtnRedDot(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void setOnBtnClickListener(@NotNull RIJXTabBar.OnBtnClickListener paramOnBtnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnBtnClickListener, "listener");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar$OnBtnClickListener = paramOnBtnClickListener;
  }
  
  public final void setSelfBtnNotifyIcon(@NotNull RedTouch paramRedTouch)
  {
    Intrinsics.checkParameterIsNotNull(paramRedTouch, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = paramRedTouch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar
 * JD-Core Version:    0.7.0.1
 */