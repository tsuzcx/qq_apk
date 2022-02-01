package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.part.WSAbsPart;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSGridSpacingItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.List;

public class WSDramaHistoryPart
  extends WSAbsPart
  implements WSDramaHistoryConstract.View, WSSimpleEventReceiver, IGuardInterface
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private WSDramaPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment;
  private WSDramaItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData;
  private WSDramaHistoryAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter;
  private WSDramaHistoryPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter = new WSDramaHistoryPresenter(this);
  private WSDragLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
  private WSXRecyclerView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView;
  private String jdField_a_of_type_JavaLangString;
  
  public WSDramaHistoryPart(Context paramContext, ViewStub paramViewStub, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext, paramViewStub);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment = paramWSDramaPageFragment;
  }
  
  public static WSDramaHistoryPart a(Context paramContext, ViewStub paramViewStub, WSDramaPageFragment paramWSDramaPageFragment, String paramString)
  {
    paramContext = new WSDramaHistoryPart(paramContext, paramViewStub, paramWSDramaPageFragment);
    paramContext.a(paramString);
    return paramContext;
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground().mutate().setAlpha((int)((1.0F - paramFloat) * 255.0F));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData == null) {
      return;
    }
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter;
    int i;
    if ((localWSDramaHistoryAdapter != null) && (localWSDramaHistoryAdapter.getDataList().size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    WSDramaBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData.c(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData.a(), this.jdField_a_of_type_JavaLangString, paramInt, i);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376672));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout = ((WSDragLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365891));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView = ((WSXRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376873));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379076));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369530));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setControlLitTongue(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setContentView(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.b(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setTouchListener(new WSDramaHistoryPart.1(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new WSDramaHistoryPart.2(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new WSDramaHistoryPart.3(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getLoadMoreLayoutHelper();
    if (localObject != null) {
      ((LoadingMoreHelper)localObject).setPreLoaderCount(12);
    }
    localObject = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 3);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter = new WSDramaHistoryAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setRefreshEnable(false);
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView();
    localRecyclerViewWithHeaderFooter.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter);
    localRecyclerViewWithHeaderFooter.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localRecyclerViewWithHeaderFooter.setItemAnimator(null);
    localRecyclerViewWithHeaderFooter.addItemDecoration(new WSGridSpacingItemDecoration(3, WeishiUIUtil.d));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setRefreshCallback(new WSDramaHistoryPart.4(this));
  }
  
  private void g()
  {
    WSSimpleEventBus.a().a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter.a(new FetcherParams(true, true));
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851299);
    a(0);
    l();
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter;
    if (localWSDramaHistoryAdapter != null) {
      localWSDramaHistoryAdapter.a(false);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851300);
    a(1);
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter;
    if (localWSDramaHistoryAdapter != null) {
      localWSDramaHistoryAdapter.a(true);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.a()) {
        return;
      }
      int i = WeishiUIUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView());
      int j = WeishiUIUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView());
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPanelItemExposure fistVisible:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", lastVisible:");
      ((StringBuilder)localObject).append(j);
      WSLog.b("WSDramaHistoryPart", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment.a();
      while (i <= j)
      {
        if (i < this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter.getDataList().size()) {
          WSDramaBeaconReport.b(WSDramaUtils.b((AbsWSDramaHolder)localObject), WSDramaUtils.a((AbsWSDramaHolder)localObject), WSDramaUtils.c((AbsWSDramaHolder)localObject), WSDramaUtils.a((AbsWSDramaHolder)localObject), (WSDramaHistoryData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter.getDataList().get(i), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment.a(), i);
        }
        i += 1;
      }
    }
  }
  
  public void E_()
  {
    super.E_();
    e();
    f();
    g();
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
  }
  
  public void F_()
  {
    super.F_();
    WSSimpleEventBus.a().b(this);
    if (GuardManager.a != null) {
      GuardManager.a.b(this);
    }
  }
  
  public void G_()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.a()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter.a(new FetcherParams(true, true));
    }
  }
  
  public void H_() {}
  
  protected int a()
  {
    return 2131560012;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSDramaVideoPlayEvent.class);
    return localArrayList;
  }
  
  public List<WSDramaHistoryData> a()
  {
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter;
    if (localWSDramaHistoryAdapter != null) {
      return localWSDramaHistoryAdapter.getDataList();
    }
    return new ArrayList();
  }
  
  public void a(long paramLong) {}
  
  public void a(AbsWSDramaHolder paramAbsWSDramaHolder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData = paramAbsWSDramaHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSDramaVideoPlayEvent))
    {
      paramWSSimpleBaseEvent = (WSDramaVideoPlayEvent)paramWSSimpleBaseEvent;
      if (paramWSSimpleBaseEvent.getDramaInfo() != null)
      {
        if (paramWSSimpleBaseEvent.getDramaInfo().dramaInfo == null) {
          return;
        }
        stDrama localstDrama = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter.a(paramWSSimpleBaseEvent.getDramaInfo());
        if (paramWSSimpleBaseEvent.getEpisodeNum() > localstDrama.dramaInfo.curWatchedFeedNum)
        {
          localstDrama.dramaInfo.curWatchedFeedNum = paramWSSimpleBaseEvent.getEpisodeNum();
          localstDrama.dramaInfo.curWatchedFeedID = paramWSSimpleBaseEvent.getEpisodeId();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onReceiveEvent] 接收到播放事件：");
        localStringBuilder.append(localstDrama.dramaInfo.name);
        localStringBuilder.append(", isDramaPreviewPage:");
        localStringBuilder.append(paramWSSimpleBaseEvent.isDramaPreviewPage());
        localStringBuilder.append(", 集数:");
        localStringBuilder.append(localstDrama.dramaInfo.curWatchedFeedNum);
        WSLog.b("WSDramaHistoryPart", localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter.a(localstDrama, paramWSSimpleBaseEvent.isDramaPreviewPage());
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<WSDramaHistoryData> paramList, boolean paramBoolean)
  {
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter;
    if (localWSDramaHistoryAdapter != null)
    {
      localWSDramaHistoryAdapter.fillList(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.backToTopAtOnce();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.loadMoreComplete(true, paramBoolean);
  }
  
  public void a(List<WSDramaHistoryData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter.fillList(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.backToTopAtOnce();
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryAdapter.appendList(paramList);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.loadMoreComplete(true, paramBoolean2);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPart
 * JD-Core Version:    0.7.0.1
 */