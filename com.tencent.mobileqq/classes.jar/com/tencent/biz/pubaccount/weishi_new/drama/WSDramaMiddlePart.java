package com.tencent.biz.pubaccount.weishi_new.drama;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.Checkable;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSCenterLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.part.WSAbsPart;
import com.tencent.biz.pubaccount.weishi_new.drama.presenter.WSDramaEpisodePresenter;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class WSDramaMiddlePart
  extends WSAbsPart
  implements WSDramaEpisodeContract.View, WSSimpleEventReceiver
{
  public static final int a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSDramaMiddlePart.OnDramaDataListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart$OnDramaDataListener;
  private final WSDramaPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment;
  private WSEpisodeAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter;
  private WSDramaGalleryAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter;
  private final WSDramaEpisodePresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPresenterWSDramaEpisodePresenter;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Int = WeishiUIUtil.c() / 2 - ScreenUtil.dip2px(51.5F) / 2;
  }
  
  public WSDramaMiddlePart(WSDramaPageFragment paramWSDramaPageFragment, ViewStub paramViewStub)
  {
    super(paramWSDramaPageFragment.getContext(), paramViewStub);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment = paramWSDramaPageFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPresenterWSDramaEpisodePresenter = new WSDramaEpisodePresenter(this);
  }
  
  public static WSDramaMiddlePart a(WSDramaPageFragment paramWSDramaPageFragment, ViewStub paramViewStub, Bundle paramBundle)
  {
    paramWSDramaPageFragment = new WSDramaMiddlePart(paramWSDramaPageFragment, paramViewStub);
    paramWSDramaPageFragment.a(paramBundle);
    return paramWSDramaPageFragment;
  }
  
  private WSDramaEpisodePresenter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPresenterWSDramaEpisodePresenter;
  }
  
  private void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.getItemCount()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.a(paramInt);
    ((WSCenterLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).scrollToPositionWithOffset(Math.max(0, paramInt), jdField_a_of_type_Int);
    b(0);
    WSDramaBeaconReport.a((WSEpisodeItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.getItem(paramInt), b(), a());
    n();
  }
  
  private <M extends Checkable, VH extends BaseViewHolder<M>> void a(RecyclerView paramRecyclerView, WSAbsSingleCheckAdapter<M, VH> paramWSAbsSingleCheckAdapter, RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
  {
    paramRecyclerView.setAdapter(paramWSAbsSingleCheckAdapter);
    paramRecyclerView.addItemDecoration(paramItemDecoration);
    paramItemDecoration = new WSCenterLayoutManager(this.jdField_a_of_type_AndroidContentContext, paramInt);
    paramItemDecoration.setOrientation(0);
    paramRecyclerView.setLayoutManager(paramItemDecoration);
    paramWSAbsSingleCheckAdapter.a(paramItemDecoration);
  }
  
  private void a(WSDramaItemData paramWSDramaItemData, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramWSDramaItemData.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaMiddlePart.java][dramaChecked] mDramaId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    WSLog.d("WSDramaMiddlePartnel-log", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart$OnDramaDataListener;
    if (localObject != null) {
      ((WSDramaMiddlePart.OnDramaDataListener)localObject).a(paramWSDramaItemData, paramInt);
    }
  }
  
  private void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt)
  {
    WSDramaMiddlePart.OnDramaDataListener localOnDramaDataListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart$OnDramaDataListener;
    if (localOnDramaDataListener != null) {
      localOnDramaDataListener.a(paramWSEpisodeItemData, paramInt);
    }
  }
  
  private void a(WSDramaFollowEvent paramWSDramaFollowEvent)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((WSDramaGalleryAdapter)localObject1).getDataList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (WSDramaItemData)((List)localObject1).get(i);
      if ((localObject2 != null) && (TextUtils.equals(((WSDramaItemData)localObject2).a(), paramWSDramaFollowEvent.getDramaId())))
      {
        localObject2 = ((WSDramaItemData)localObject2).a().dramaInfo;
        int j = paramWSDramaFollowEvent.getStatus();
        boolean bool = true;
        if (j != 1) {
          bool = false;
        }
        ((stDramaInfo)localObject2).isFollowed = bool;
      }
      i += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager().smoothScrollToPosition(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView, new RecyclerView.State(), paramInt1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][loadDramaData] dramaId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", episodeId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", episodeNum:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    a(paramString1);
    a(paramBoolean, paramString2, paramInt);
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void b(String paramString)
  {
    WSDramaUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment, b(), c(), paramString);
  }
  
  private String c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter;
    localObject = (WSEpisodeItemData)((WSEpisodeAdapter)localObject).getItem(((WSEpisodeAdapter)localObject).a());
    if (localObject != null) {
      return ((WSEpisodeItemData)localObject).a();
    }
    return "";
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRepeatMode(1);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsdrama_enter/data.json");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetsFolder("wsdrama_enter/images");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new WSDramaMiddlePart.1(this));
  }
  
  private void k()
  {
    Bundle localBundle = a();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = localBundle.getString("drama_id");
    this.jdField_b_of_type_JavaLangString = localBundle.getString("from");
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter = new WSEpisodeAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter, new WSEpisodeItemDecoration(), WSEpisodeItemDecoration.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.a(new WSDramaMiddlePart.2(this));
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter = new WSDramaGalleryAdapter(this, this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView);
    a(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter, new WSDramaGalleryItemDecoration(), WSDramaGalleryItemDecoration.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter.a(new WSDramaMiddlePart.3(this));
  }
  
  private void n()
  {
    b(-1);
  }
  
  private void o()
  {
    b(0);
    int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter.a() + 1;
    if (i > this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter.getItemCount() - 1) {
      return;
    }
    a((WSDramaItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter.getItem(i), i);
  }
  
  public void E_()
  {
    super.E_();
    k();
    e();
    m();
    l();
    j();
    WSSimpleEventBus.a().a(this);
  }
  
  public void F_()
  {
    super.F_();
    WSSimpleEventBus.a().b(this);
    WSEpisodeAdapter localWSEpisodeAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter;
    WSDramaBeaconReport.a((WSEpisodeItemData)localWSEpisodeAdapter.getItem(localWSEpisodeAdapter.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.a(), a());
  }
  
  protected int a()
  {
    return 2131560013;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSDramaVideoExposureEvent.class);
    localArrayList.add(WSDramaFollowEvent.class);
    return localArrayList;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(stDramaFeed paramstDramaFeed)
  {
    WSDramaMiddlePart.OnDramaDataListener localOnDramaDataListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart$OnDramaDataListener;
    if (localOnDramaDataListener != null) {
      localOnDramaDataListener.a(paramstDramaFeed);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(WSDramaMiddlePart.OnDramaDataListener paramOnDramaDataListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart$OnDramaDataListener = paramOnDramaDataListener;
  }
  
  public void a(AbsWSDramaHolder paramAbsWSDramaHolder, int paramInt)
  {
    if ((b() != 0) && (b() != 1)) {
      b(2);
    }
    paramAbsWSDramaHolder = paramAbsWSDramaHolder.a;
    this.jdField_a_of_type_JavaLangString = paramAbsWSDramaHolder.a();
    int i = paramAbsWSDramaHolder.a().dramaInfo.curWatchedFeedNum;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter;
    int j = i - 1;
    localObject = (WSEpisodeItemData)((WSEpisodeAdapter)localObject).getItem(Math.max(0, j));
    if (!this.jdField_a_of_type_Boolean)
    {
      WSDramaBeaconReport.a((WSEpisodeItemData)localObject, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.a(), a());
      WSDramaBeaconReport.a((WSEpisodeItemData)localObject, b(), a());
      WSDramaBeaconReport.a(paramAbsWSDramaHolder, paramInt, b(), false, a());
    }
    n();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter.a(paramInt);
    a(false, paramAbsWSDramaHolder.a(), paramAbsWSDramaHolder.a().dramaInfo.curWatchedFeedID, i);
    a(paramAbsWSDramaHolder.a().dramaInfo.name, paramInt, Math.max(0, j));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSDramaVideoExposureEvent))
    {
      a(((WSDramaVideoExposureEvent)paramWSSimpleBaseEvent).getCurrentEpisodeNum() - 1);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSDramaFollowEvent)) {
      a((WSDramaFollowEvent)paramWSSimpleBaseEvent);
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][loadDramaFeedIds] dramaId:");
    localStringBuilder.append(paramString);
    WSLog.a("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramString;
    a().c();
  }
  
  public void a(List<WSDramaItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaGalleryWSDramaGalleryAdapter.fillList(paramList);
  }
  
  public void a(List<WSEpisodeItemData> paramList, stDramaInfo paramstDramaInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.fillList(paramList);
    if (paramstDramaInfo != null) {
      paramList = paramstDramaInfo.name;
    } else {
      paramList = "";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
    int i = paramstDramaInfo.curWatchedFeedNum;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new WSDramaMiddlePart.4(this, i - 1));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][loadDramaFeeds] episodeId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", episodeNum:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    a().a(paramBoolean, paramString, paramInt);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(stDramaFeed paramstDramaFeed)
  {
    WSDramaMiddlePart.OnDramaDataListener localOnDramaDataListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart$OnDramaDataListener;
    if (localOnDramaDataListener != null) {
      localOnDramaDataListener.b(paramstDramaFeed);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131365898));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365905));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131365899));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131365897));
  }
  
  public void f()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.a() + 1;
    if (i > this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.getItemCount() - 1)
    {
      o();
      return;
    }
    WSEpisodeItemData localWSEpisodeItemData = (WSEpisodeItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.getItem(i);
    a(i);
    a(false, localWSEpisodeItemData.a(), i + 1);
  }
  
  public void g()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.a() + 1;
    if (i >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.getItemCount()) {
      return;
    }
    WSEpisodeItemData localWSEpisodeItemData = (WSEpisodeItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSEpisodeAdapter.getItem(i);
    a().a(localWSEpisodeItemData.a(), localWSEpisodeItemData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart
 * JD-Core Version:    0.7.0.1
 */