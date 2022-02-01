package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleAchievementPopupWindowPart;
import com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePluginDebugPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonInfoNumUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonInfoNumUpdateEvent.PersonNumInfo;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalBottomBlock;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalInfoBlock;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.util.RFWCompactUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleClosePageEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;

public class QFSPersonalDetailsFragment
  extends QFSBaseFragment
{
  protected QCircleSharePartV2 c;
  protected QFSPersonalViewModel d;
  private QFSPersonalDetailsFragment.QFSPersonalBroadcastReceiver e;
  private NestScrollRecyclerView f;
  private QFSBaseBlockPart g;
  private QFSPersonalTitleBarPart h;
  private QFSPersonalInfoBlock i;
  private QFSPersonalBottomBlock j;
  private boolean k = true;
  private FeedCloudMeta.StFeed l;
  private FeedCloudMeta.StUser m;
  private int n;
  private int o;
  private int p;
  private QCirclePersonInfoNumUpdateEvent.PersonNumInfo q;
  
  private void E()
  {
    this.o = ViewUtils.a(200.0F);
    RefreshHeaderView localRefreshHeaderView = new RefreshHeaderView(getContext());
    BlockContainer localBlockContainer = this.g.i();
    localBlockContainer.setEnableLoadMore(false);
    localBlockContainer.setParentFragment(this);
    localBlockContainer.setRefreshHeader(localRefreshHeaderView);
    localBlockContainer.setEnableRefresh(true);
    this.f = localBlockContainer.getRecyclerView();
    this.f.setTransDispatchDelegate(RFWCompactUtil.a());
    a(localBlockContainer);
  }
  
  private void F()
  {
    this.n = 0;
    a(0);
  }
  
  private void G()
  {
    QFSPersonalViewModel localQFSPersonalViewModel = this.d;
    if ((localQFSPersonalViewModel != null) && (!TextUtils.isEmpty(localQFSPersonalViewModel.n()))) {
      return;
    }
    QLog.i("QFSPersonalDetailsFragment", 1, "mViewModel did not set StUser");
  }
  
  private void H()
  {
    if (getActivity() != null)
    {
      this.e = new QFSPersonalDetailsFragment.QFSPersonalBroadcastReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.e, localIntentFilter);
    }
  }
  
  private void a(int paramInt)
  {
    this.n += paramInt;
    float f1 = this.n * 1.0F / this.o;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("computeShowTitleBarAnimation  dy:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("  mDistance:");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append("  percent:");
    ((StringBuilder)localObject).append(f1);
    QLog.d("QFSPersonalDetailsFragment", 1, ((StringBuilder)localObject).toString());
    int i1 = (int)(f1 * 255.0F);
    if (i1 > 255)
    {
      paramInt = 255;
    }
    else
    {
      paramInt = i1;
      if (i1 < 0) {
        paramInt = 0;
      }
    }
    localObject = Message.obtain();
    ((Message)localObject).what = paramInt;
    this.h.a("personal_page_action_title_bar_animation", localObject);
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("key_bundle_common_init_bean")))
    {
      paramIntent = paramIntent.getSerializableExtra("key_bundle_common_init_bean");
      if (!(paramIntent instanceof QCircleInitBean))
      {
        QLog.i("QFSPersonalDetailsFragment", 1, "InitBean is not FSPersonalDetailBean");
        return;
      }
      QCircleInitBean localQCircleInitBean = (QCircleInitBean)paramIntent;
      if (localQCircleInitBean.getFeed().has()) {
        paramIntent = localQCircleInitBean.getFeed();
      } else {
        paramIntent = this.l;
      }
      this.l = paramIntent;
      if (localQCircleInitBean.getUser().has()) {
        paramIntent = localQCircleInitBean.getUser();
      } else {
        paramIntent = this.m;
      }
      this.m = paramIntent;
      return;
    }
    QLog.i("QFSPersonalDetailsFragment", 1, "InitBean is null");
  }
  
  private void a(Bundle paramBundle)
  {
    this.i = new QFSPersonalInfoBlock(paramBundle);
    this.i.a(n());
    this.i.setOnLoadDataDelegate(new QFSPersonalDetailsFragment.3(this));
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (this.d != null)
    {
      if (paramQCircleFeedEvent.mState != 3) {
        return;
      }
      this.d.b(paramQCircleFeedEvent.mTargetId);
    }
  }
  
  private void a(QCirclePersonEditUpdateEvent paramQCirclePersonEditUpdateEvent)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((QFSPersonalViewModel)localObject).b().getValue() == null) {
        return;
      }
      localObject = (QFSPersonalInfo)this.d.b().getValue();
      FeedCloudMeta.StUser localStUser = ((QFSPersonalInfo)localObject).a;
      if (paramQCirclePersonEditUpdateEvent.getNick() != null) {
        localStUser.nick.set(paramQCirclePersonEditUpdateEvent.getNick());
      }
      if (paramQCirclePersonEditUpdateEvent.getGender() != 0) {
        localStUser.sex.set(paramQCirclePersonEditUpdateEvent.getGender());
      }
      if (paramQCirclePersonEditUpdateEvent.getConstellation() != 0) {
        localStUser.constellation.set(paramQCirclePersonEditUpdateEvent.getConstellation());
      }
      if (paramQCirclePersonEditUpdateEvent.getLocation() != null)
      {
        localStUser.location.set(paramQCirclePersonEditUpdateEvent.getLocation());
        if (paramQCirclePersonEditUpdateEvent.getLocationCode() != null) {
          localStUser.locationCode.set(paramQCirclePersonEditUpdateEvent.getLocationCode());
        }
      }
      if (paramQCirclePersonEditUpdateEvent.getDesc() != null) {
        localStUser.desc.set(paramQCirclePersonEditUpdateEvent.getDesc());
      }
      QQCircleBase.StUserBusiData localStUserBusiData = ((QFSPersonalInfo)localObject).b;
      QQCircleBase.UserCircleInfo localUserCircleInfo;
      if ((paramQCirclePersonEditUpdateEvent.getSchool() != null) && (localStUserBusiData != null)) {
        if (localStUserBusiData.schoolInfos.size() > 0)
        {
          ((QQCircleBase.UserCircleInfo)localStUserBusiData.schoolInfos.get(0)).name.set(paramQCirclePersonEditUpdateEvent.getSchool());
        }
        else
        {
          localUserCircleInfo = new QQCircleBase.UserCircleInfo();
          localUserCircleInfo.name.set(paramQCirclePersonEditUpdateEvent.getSchool());
          localStUserBusiData.schoolInfos.add(localUserCircleInfo);
        }
      }
      if ((paramQCirclePersonEditUpdateEvent.getCompany() != null) && (localStUserBusiData != null)) {
        if (localStUserBusiData.companyInfos.size() > 0)
        {
          ((QQCircleBase.UserCircleInfo)localStUserBusiData.companyInfos.get(0)).name.set(paramQCirclePersonEditUpdateEvent.getCompany());
        }
        else
        {
          localUserCircleInfo = new QQCircleBase.UserCircleInfo();
          localUserCircleInfo.name.set(paramQCirclePersonEditUpdateEvent.getCompany());
          localStUserBusiData.companyInfos.add(localUserCircleInfo);
        }
      }
      localStUser.busiData.set(ByteStringMicro.copyFrom(localStUserBusiData.toByteArray()));
      ((QFSPersonalInfo)localObject).a(localStUser);
      this.d.b().setValue(localObject);
      this.m = ((QFSPersonalInfo)localObject).a;
    }
  }
  
  private void a(QCirclePersonInfoNumUpdateEvent paramQCirclePersonInfoNumUpdateEvent)
  {
    if (paramQCirclePersonInfoNumUpdateEvent.hashCode != hashCode()) {
      return;
    }
    this.q = paramQCirclePersonInfoNumUpdateEvent.numInfo;
    h();
  }
  
  private void a(BlockContainer paramBlockContainer)
  {
    this.f.addOnScrollListener(new QFSPersonalDetailsFragment.4(this, paramBlockContainer));
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((QFSPersonalViewModel)localObject).p()) {
        return;
      }
      localObject = Message.obtain();
      ((Message)localObject).what = paramInt;
      this.h.a("personal_page_action_title_bar_follow_animation", localObject);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.j = new QFSPersonalBottomBlock(paramBundle);
    this.j.a(n());
  }
  
  private void b(boolean paramBoolean)
  {
    QFSPersonalViewModel localQFSPersonalViewModel = this.d;
    if (localQFSPersonalViewModel != null) {
      localQFSPersonalViewModel.b(paramBoolean);
    }
  }
  
  private boolean w()
  {
    return (getArguments() != null) && (TextUtils.equals(getArguments().getString("qfs_key_bundle_personal_fragment_scene"), "qfs_personal_fragment_scene_home_owner"));
  }
  
  private void x()
  {
    this.d.g().observe(this, new QFSPersonalDetailsFragment.1(this));
    this.d.e().observe(this, new QFSPersonalDetailsFragment.2(this));
  }
  
  private List<MultiViewBlock> z()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    a(localBundle);
    b(localBundle);
    localArrayList.add(this.i);
    localArrayList.add(this.j);
    return localArrayList;
  }
  
  protected void A()
  {
    b(true);
  }
  
  public NestScrollRecyclerView B()
  {
    return this.f;
  }
  
  void C()
  {
    if (getActivity() != null)
    {
      if (!(getActivity() instanceof QCircleFragmentActivity)) {
        return;
      }
      if (w()) {
        return;
      }
      FeedCloudMeta.StUser localStUser = this.m;
      if (localStUser != null)
      {
        if (!QFSCommonUtil.a(localStUser)) {
          return;
        }
        getActivity().onBackPressed();
      }
    }
  }
  
  public boolean D()
  {
    return this.k;
  }
  
  public int a()
  {
    return 532;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    E();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.l = paramStFeed;
    QFSPersonalViewModel localQFSPersonalViewModel = this.d;
    if (localQFSPersonalViewModel != null)
    {
      if (paramStFeed == null) {
        return;
      }
      localQFSPersonalViewModel.a(paramStFeed);
    }
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    this.m = paramStUser;
    QFSPersonalViewModel localQFSPersonalViewModel = this.d;
    if (localQFSPersonalViewModel != null)
    {
      if (paramStUser == null) {
        return;
      }
      localQFSPersonalViewModel.a(paramStUser);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String b()
  {
    return "QFSPersonalDetailsFragment";
  }
  
  protected int c()
  {
    return 2131627161;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.g = new QFSBaseBlockPart(2131433865, z(), 3, 1);
    localArrayList.add(this.g);
    this.h = new QFSPersonalTitleBarPart();
    localArrayList.add(this.h);
    this.c = new QCircleSharePartV2();
    this.c.a(this);
    localArrayList.add(this.c);
    localArrayList.add(new QCircleAchievementPopupWindowPart());
    localArrayList.add(new QCircleGoHomeButtonPart());
    if (QCircleApplication.isRDMVersion()) {
      localArrayList.add(new QCirclePluginDebugPart());
    }
    return localArrayList;
  }
  
  protected Map<String, Object> e()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.m;
    if (localObject != null)
    {
      if (QFSCommonUtil.a((FeedCloudMeta.StUser)localObject)) {
        localObject = "host";
      } else {
        localObject = "guest";
      }
      localHashMap.put("xsj_profile_host_guest_type", localObject);
    }
    localObject = this.q;
    if (localObject != null)
    {
      localHashMap.put("xsj_profile_burn_num", ((QCirclePersonInfoNumUpdateEvent.PersonNumInfo)localObject).a);
      localHashMap.put("xsj_profile_fans_num", this.q.c);
      localHashMap.put("xsj_profile_follow_num", this.q.b);
    }
    localHashMap.put("xsj_whether_immerse_version", "yes");
    return localHashMap;
  }
  
  protected String f()
  {
    return "pg_xsj_profile_page";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleUndoPushUpdateEvent.class);
    localArrayList.add(QCirclePersonEditUpdateEvent.class);
    localArrayList.add(QCircleClosePageEvent.class);
    localArrayList.add(QCirclePersonInfoNumUpdateEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public QCircleReportBean n()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    this.a.setPageId(a());
    return this.a;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(getActivity().getIntent());
    u();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.p = DisplayUtil.e();
    H();
    QCirclePeriodCollect.record("QFSPersonalDetailsFragmentdoOnCreateView");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.e != null)) {
      getActivity().unregisterReceiver(this.e);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("QFSPersonalDetailsFragment", 1, "fs_lifecycle onPause");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    QFSPersonalViewModel localQFSPersonalViewModel;
    if ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      localQFSPersonalViewModel = this.d;
      if (localQFSPersonalViewModel != null) {
        localQFSPersonalViewModel.a(paramSimpleBaseEvent.mTargetFeedId);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
    {
      paramSimpleBaseEvent = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
      localQFSPersonalViewModel = this.d;
      if (localQFSPersonalViewModel != null) {
        localQFSPersonalViewModel.a(paramSimpleBaseEvent.mTargetFeedId);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleUndoPushUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleUndoPushUpdateEvent)paramSimpleBaseEvent;
      localQFSPersonalViewModel = this.d;
      if (localQFSPersonalViewModel != null) {
        localQFSPersonalViewModel.a(paramSimpleBaseEvent.mTargetFeedId);
      }
    }
    else
    {
      if ((paramSimpleBaseEvent instanceof QCirclePersonEditUpdateEvent))
      {
        a((QCirclePersonEditUpdateEvent)paramSimpleBaseEvent);
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCircleClosePageEvent))
      {
        C();
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCirclePersonInfoNumUpdateEvent))
      {
        a((QCirclePersonInfoNumUpdateEvent)paramSimpleBaseEvent);
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
        a((QCircleFeedEvent)paramSimpleBaseEvent);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("QFSPersonalDetailsFragment", 1, "fs_lifecycle onResume");
    G();
    QFSPersonalViewModel localQFSPersonalViewModel = this.d;
    if (localQFSPersonalViewModel != null) {
      localQFSPersonalViewModel.t();
    }
  }
  
  void u()
  {
    y();
    A();
  }
  
  protected void y()
  {
    this.d = ((QFSPersonalViewModel)a(QFSPersonalViewModel.class));
    if ((getArguments() != null) && (TextUtils.equals(getArguments().getString("qfs_key_bundle_personal_fragment_scene"), "qfs_personal_fragment_scene_client"))) {
      this.d.a(true);
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      this.d.a((FeedCloudMeta.StFeed)localObject);
    }
    else
    {
      localObject = this.m;
      if (localObject != null) {
        this.d.a((FeedCloudMeta.StUser)localObject);
      }
    }
    QCircleFeedDataCenter.a().a(this.d.m(), this.d);
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment
 * JD-Core Version:    0.7.0.1
 */