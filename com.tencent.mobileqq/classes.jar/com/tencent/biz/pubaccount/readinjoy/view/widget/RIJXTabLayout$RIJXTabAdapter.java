package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.TabAdapter;
import com.tencent.biz.widgets.TabLayout.TabAdapter.TabViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabLayout$RIJXTabAdapter;", "Lcom/tencent/biz/widgets/TabLayout$TabAdapter;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "context", "Landroid/content/Context;", "itemList", "", "viewPagerController", "Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabLayout;Landroid/content/Context;Ljava/util/List;Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;)V", "immersiveColor", "", "immersiveMode", "", "normalSelectedTextColor", "normalTextColor", "selectedIndex", "getData", "getViewId", "handleTabClick", "", "data", "position", "needFooter", "onAllItemViewReady", "switchImmersiveMode", "immersive", "update", "viewHolder", "Lcom/tencent/biz/widgets/TabLayout$TabAdapter$TabViewHolder;", "updateData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabLayout$RIJXTabAdapter
  extends TabLayout.TabAdapter<TabChannelCoverInfo>
{
  private final int jdField_a_of_type_Int;
  private final RIJXTabViewPagerController jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  private final int c;
  private int d;
  
  public RIJXTabLayout$RIJXTabAdapter(Context paramContext, @NotNull List<? extends TabChannelCoverInfo> paramList, @NotNull RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    super(paramList, paramRIJXTabViewPagerController);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController = localObject;
    this.jdField_a_of_type_Int = Color.parseColor("#FFFFFF");
    this.b = Color.parseColor("#737373");
    this.c = Color.parseColor("#00CAFB");
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController.a() == paramInt)
    {
      Fragment localFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController.a();
      Object localObject = localFragment;
      if (!(localFragment instanceof ReadInJoyBaseFragment)) {
        localObject = null;
      }
      localObject = (ReadInJoyBaseFragment)localObject;
      if (localObject != null) {
        ((ReadInJoyBaseFragment)localObject).a(5);
      }
    }
    ReadInJoyChannelViewPagerController.a(paramTabChannelCoverInfo.mChannelCoverId, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController.b(paramInt);
    RIJChannelReporter.a(paramTabChannelCoverInfo.mChannelCoverId, "302");
    RIJChannelReporter.a("0X8009496", new RIJTransMergeKanDianReport.ReportR5Builder().a(paramTabChannelCoverInfo.mChannelCoverId).f().a());
  }
  
  public int a()
  {
    return 2131562903;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onAllItemViewReady() tabLayout.childSize = ");
    TabLayout localTabLayout = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    Intrinsics.checkExpressionValueIsNotNull(localTabLayout, "tabLayout");
    QLog.d("RIJXTabLayout", 1, localTabLayout.a() + ' ' + "needDeferAnimation:" + RIJXTabLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout) + " currentIndex:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController.a());
    if (RIJXTabLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout)) {
      this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.postDelayed((Runnable)new RIJXTabLayout.RIJXTabAdapter.onAllItemViewReady.1(this), 50L);
    }
  }
  
  protected void a(@Nullable TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, @Nullable TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    float f2 = 1.0F;
    Object localObject;
    ImageView localImageView;
    label37:
    int i;
    label67:
    float f1;
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabViewHolder == null) {
        break label194;
      }
      localObject = (TextView)paramTabViewHolder.a(2131380651);
      if (paramTabViewHolder == null) {
        break label200;
      }
      localImageView = (ImageView)paramTabViewHolder.a(2131369789);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramTabChannelCoverInfo.mChannelCoverName);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label206;
      }
      i = this.jdField_a_of_type_Int;
      if (!this.jdField_a_of_type_Boolean) {
        break label215;
      }
      f1 = 0.8F;
      label78:
      if (paramInt != this.d) {
        break label249;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label221;
      }
      i = this.jdField_a_of_type_Int;
      f1 = f2;
    }
    label103:
    label249:
    for (;;)
    {
      if (localObject != null) {
        ((TextView)localObject).setTextColor(i);
      }
      if (localObject != null) {
        ((TextView)localObject).setAlpha(f1);
      }
      localObject = RIJXTabNormalRedDotStore.a.a(paramTabChannelCoverInfo.mChannelCoverId);
      if (localObject != null)
      {
        if (localImageView != null) {
          localImageView.setVisibility(0);
        }
        ReadInJoyLogicEngineEventDispatcher.a().a((RIJXTabRedDotInfo)localObject);
      }
      for (;;)
      {
        if (paramTabViewHolder != null)
        {
          paramTabViewHolder = paramTabViewHolder.a();
          if (paramTabViewHolder != null) {
            paramTabViewHolder.setOnClickListener((View.OnClickListener)new RIJXTabLayout.RIJXTabAdapter.update.1(this, paramTabChannelCoverInfo, paramInt));
          }
        }
        return;
        localObject = null;
        break;
        localImageView = null;
        break label37;
        i = this.b;
        break label67;
        f1 = 1.0F;
        break label78;
        i = this.c;
        f1 = f2;
        break label103;
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d = paramInt;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabLayout.RIJXTabAdapter
 * JD-Core Version:    0.7.0.1
 */