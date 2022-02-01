package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnGalleryImageClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnHorizontalSubArticleClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnSubRegionClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyViewController;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyProteusFamilyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, OnGalleryImageClickListener, OnHorizontalSubArticleClick, OnLastReadRefreshListener, OnSubRegionClickListener, VideoUIManager.OnScreenChangeListener, ReadInJoyBaseListView.RefreshCallback, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  RIJDataFetchManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager;
  RIJInvokeHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler;
  private KandianMergeManager.MessageObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver = new ReadInJoyProteusFamilyListViewGroup.6(this);
  private ReadInJoyProteusFamilyAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ReadInJoyProteusFamilyListViewGroup.7(this);
  protected IFaceDecoder a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadInJoyProteusFamilyListViewGroup.1(this);
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ReadInJoyProteusFamilyListViewGroup.5(this);
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  
  public ReadInJoyProteusFamilyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache, int paramInt4)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramInt3;
    setId(2131376589);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler = new RIJInvokeHandler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager = new RIJDataFetchManager(new RIJDataFetchManager.Builder().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_a_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController));
    m();
    r();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.c = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
  }
  
  private int b()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378728));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((BaseActivity)a()).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)a()).app);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter = new ReadInJoyProteusFamilyAdapter(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(), a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController + a());
    }
    o();
    n();
    q();
    s();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void o()
  {
    Activity localActivity;
    View localView2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController instanceof ReadInJoyProteusFamilyViewController))
    {
      localActivity = a();
      if (localActivity.findViewById(2131362005) == null) {
        break label189;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362005);
      localView1 = localActivity.findViewById(2131378451);
      localView2 = findViewById(2131367373);
      i = getResources().getDimensionPixelOffset(2131298859);
      i = AIOUtils.a(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.2(this, localView1, i, localView2));
    }
    label189:
    while (localActivity.findViewById(2131362006) == null) {
      return;
    }
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362006);
    View localView1 = localActivity.findViewById(2131379458);
    int i = AIOUtils.a(50.0F, getResources());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + i);
      }
      localView2 = findViewById(2131367373);
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyProteusFamilyListViewGroup.3(this, localView1, i, localView2));
      return;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.b(b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.a(this.jdField_a_of_type_Long);
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.a(localListenerBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter);
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyProteusFamilyListViewGroup.4(this), 3000L);
  }
  
  private void s()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131374174);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  public RIJDataFetchManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager;
  }
  
  public ReadInJoyProteusFamilyAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "jumpToGallery failed: atlas has undercarriage");
      }
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.notifyDataSetChanged();
      ReadinjoyReportUtils.a(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "rowKey is empty");
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.a(paramList);
  }
  
  public void b() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void c(Map<Integer, BaseReportData> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.notifyDataSetChanged();
    }
  }
  
  public void l() {}
  
  public void onClick(View paramView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void p() {}
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.a(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */