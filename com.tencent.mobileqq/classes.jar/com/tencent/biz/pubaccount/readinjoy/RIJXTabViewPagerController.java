package com.tencent.biz.pubaccount.readinjoy;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;", "", "viewPager", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager;", "viewPagerAdapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "tabBar", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar;)V", "account", "", "onPageChangeListener", "com/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController$onPageChangeListener$1", "Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController$onPageChangeListener$1;", "tabChannelCoverInfoList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "getTabChannelCoverInfoList", "()Ljava/util/List;", "tag", "getChannelCover", "index", "", "getCurrentChannelCover", "getCurrentFragment", "Landroid/support/v4/app/Fragment;", "getCurrentIndex", "getFragment", "getIndexByChannelID", "channelID", "getRecommendIndex", "init", "", "onDestroy", "context", "Landroid/content/Context;", "onTabChange", "setCurrentItem", "setCurrentItemByChannelID", "switch2RecommendFragment", "switchToDefaultChannel", "updateViewPager", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabViewPagerController
{
  private final RIJXTabViewPagerController.onPageChangeListener.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController$onPageChangeListener$1;
  private final RIJXTabBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
  private final ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private final ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private final String b;
  
  public RIJXTabViewPagerController(@NotNull ReadInJoyChannelViewPager paramReadInJoyChannelViewPager, @NotNull ReadInJoyChannelViewPager.CustomFragmentPagerAdapter paramCustomFragmentPagerAdapter, @NotNull RIJXTabBar paramRIJXTabBar)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = paramReadInJoyChannelViewPager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = paramCustomFragmentPagerAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar = paramRIJXTabBar;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_JavaLangString = "0";
    this.b = "RIJXTabViewPagerController";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController$onPageChangeListener$1 = new RIJXTabViewPagerController.onPageChangeListener.1(this);
  }
  
  private final int a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == paramInt)
      {
        j = 1;
        label42:
        if (j == 0) {
          break label113;
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        j = i;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {}
      }
      else
      {
        j = b();
      }
      QLog.d(this.b, 1, "getIndexByChannelID,channelID=" + paramInt + ",index=" + j);
      return j;
      j = 0;
      break label42;
      label113:
      i += 1;
      break;
      i = -1;
    }
  }
  
  private final int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == 0)
      {
        j = 1;
        label38:
        if (j == 0) {
          break label54;
        }
      }
    }
    for (;;)
    {
      if (i != -1) {
        return i;
      }
      return 0;
      j = 0;
      break label38;
      label54:
      i += 1;
      break;
      i = -1;
    }
    return i;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
  }
  
  @Nullable
  public final Fragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
  }
  
  @Nullable
  public final Fragment a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
  }
  
  @Nullable
  public final TabChannelCoverInfo a()
  {
    return (TabChannelCoverInfo)CollectionsKt.getOrNull(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem());
  }
  
  @Nullable
  public final TabChannelCoverInfo a(int paramInt)
  {
    return (TabChannelCoverInfo)CollectionsKt.getOrNull(this.jdField_a_of_type_JavaUtilList, paramInt);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController$onPageChangeListener$1);
    RIJChannelStayTimeMonitor.a.a();
  }
  
  public final void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RIJChannelStayTimeMonitor.a.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.clearOnPageChangeListeners();
    if (((paramContext instanceof SplashActivity)) && (!((SplashActivity)paramContext).isFinishing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
    }
  }
  
  public final void b()
  {
    if (!StringsKt.equals(ReadInJoyHelper.a(), this.jdField_a_of_type_JavaLangString, true)) {
      c();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.post((Runnable)new RIJXTabViewPagerController.onTabChange.1(this));
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    for (int i = b();; i = paramInt)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setCurrentItem(i, true);
      QLog.d(this.b, 1, "setCurrentItem,index=" + paramInt);
      return;
    }
  }
  
  public final void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)RIJXTabFrameUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    a(RIJXTabConfigHandler.a.a().a());
    String str = ReadInJoyHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyHelper.getAccount()");
    this.jdField_a_of_type_JavaLangString = str;
    QLog.d(this.b, 1, "updateViewPager!");
  }
  
  public final void d()
  {
    int j = b();
    int i = j;
    if (j == -1) {
      i = a(RIJXTabConfigHandler.a.a().a());
    }
    b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController
 * JD-Core Version:    0.7.0.1
 */