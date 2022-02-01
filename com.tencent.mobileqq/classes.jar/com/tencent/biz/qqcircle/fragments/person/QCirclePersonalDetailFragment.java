package com.tencent.biz.qqcircle.fragments.person;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.adapter.QCirclePersonalBottomBlock;
import com.tencent.biz.qqcircle.adapter.QCirclePersonalDetailHeaderBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleAchievementPopupWindowPart;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePluginDebugPart;
import com.tencent.biz.qqcircle.bizparts.QCircleProfilePublishPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleBroadcastEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailPushViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.util.RFWCompactUtil;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QCirclePersonalDetailFragment
  extends QCircleBaseFragment
  implements SimpleEventReceiver
{
  private static int t;
  protected BlockPart c;
  protected QCircleSharePartV2 d;
  protected QCirclePersonalDetailHeaderBlock e;
  private QCirclePersonalDetailFragment.QCirclePersonalBroadcastReceiver f;
  private QCirclePersonalTitleBarPart g;
  private QCirclePersonalBottomBlock h;
  private QCirclePersonalDetailViewModel i;
  private QCirclePersonalDetailPushViewModel j;
  private FeedCloudMeta.StUser k;
  private FeedCloudMeta.StFeed l;
  private String m;
  private QCircleInitBean n;
  private int o;
  private int p;
  private QCircleLightInteractListPart q;
  private QCircleCommentPanelPart r;
  private final QCircleSpecialFollowManager s = QCircleSpecialFollowManager.a();
  
  private void A()
  {
    Object localObject1 = this.k;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.e;
      if (localObject2 != null) {
        ((QCirclePersonalDetailHeaderBlock)localObject2).setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StUser[] { localObject1 })));
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("2001");
    ((StringBuilder)localObject1).append(this.m);
    if (PreLoader.exists(((StringBuilder)localObject1).toString()))
    {
      localObject1 = this.i;
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("2001");
        ((StringBuilder)localObject2).append(this.m);
        ((QCirclePersonalDetailViewModel)localObject1).d(((StringBuilder)localObject2).toString());
        return;
      }
    }
    a(true);
  }
  
  private List<MultiViewBlock> B()
  {
    ArrayList localArrayList = new ArrayList();
    QCircleInteractor localQCircleInteractor = C();
    this.e = new QCirclePersonalDetailHeaderBlock(new Bundle());
    this.e.a(n());
    this.e.setInteractor(localQCircleInteractor);
    this.e.setOnLoadDataDelegate(new QCirclePersonalDetailFragment.3(this));
    this.h = new QCirclePersonalBottomBlock(getActivity().getIntent().getExtras());
    this.h.a(k());
    this.h.setInteractor(localQCircleInteractor);
    this.h.a(n());
    localArrayList.add(this.e);
    localArrayList.add(this.h);
    return localArrayList;
  }
  
  private QCircleInteractor C()
  {
    return new QCirclePersonalDetailFragment.4(this);
  }
  
  private void D()
  {
    this.o = 0;
    a(0);
  }
  
  private void E()
  {
    if (getActivity() != null)
    {
      this.f = new QCirclePersonalDetailFragment.QCirclePersonalBroadcastReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.f, localIntentFilter);
    }
  }
  
  private void a(int paramInt)
  {
    this.o += paramInt;
    float f1 = this.o * 1.0F / this.p;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("computeShowTitleBarAnimation  dy:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("  mDistance:");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append("  percent:");
    ((StringBuilder)localObject).append(f1);
    QLog.d("QCirclePersonalDetailFragment", 1, ((StringBuilder)localObject).toString());
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
    this.g.a("personal_page_action_title_bar_animation", localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    QCirclePersonalDetailViewModel localQCirclePersonalDetailViewModel = this.i;
    if (localQCirclePersonalDetailViewModel != null) {
      localQCirclePersonalDetailViewModel.a(paramBoolean);
    }
  }
  
  private void b(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    this.g.a("personal_page_action_title_bar_follow_animation", localMessage);
  }
  
  private void b(boolean paramBoolean)
  {
    QCirclePersonalDetailPushViewModel localQCirclePersonalDetailPushViewModel = this.j;
    if (localQCirclePersonalDetailPushViewModel != null) {
      localQCirclePersonalDetailPushViewModel.a(paramBoolean);
    }
  }
  
  public int a()
  {
    return 32;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    w();
    y();
    A();
    b(true);
    E();
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null)
    {
      if (paramStUser.id.get().equals(this.m))
      {
        QLog.i("QCirclePersonalDetailFragment", 1, "refreshFragment same user id return");
        return;
      }
      this.k = paramStUser;
      this.m = paramStUser.id.get();
      a(false);
    }
  }
  
  public String b()
  {
    return "QCirclePersonalDetailFragment";
  }
  
  protected int c()
  {
    return 2131626895;
  }
  
  protected List<Part> d()
  {
    u();
    ArrayList localArrayList = new ArrayList();
    this.c = new BlockPart(2131431490, B(), 3, 1);
    this.g = new QCirclePersonalTitleBarPart(this.n);
    this.g.a(n());
    this.d = new QCircleSharePartV2();
    this.d.a(this);
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(this.m);
    localArrayList.add(this.c);
    localArrayList.add(this.g);
    localArrayList.add(this.d);
    localObject = new QCircleProfilePublishPart((FeedCloudMeta.StUser)localObject);
    ((QCircleProfilePublishPart)localObject).a(this);
    localArrayList.add(localObject);
    QCircleTaskCenterPart localQCircleTaskCenterPart = new QCircleTaskCenterPart();
    localQCircleTaskCenterPart.a(n());
    localArrayList.add(localQCircleTaskCenterPart);
    ((QCircleProfilePublishPart)localObject).a(3);
    this.q = new QCircleLightInteractListPart();
    this.q.a(this);
    localArrayList.add(this.q);
    this.r = new QCircleCommentPanelPart();
    this.r.a(this);
    localArrayList.add(new QCircleGoHomeButtonPart());
    localArrayList.add(this.r);
    localObject = new QCircleSplashTransitionPart();
    ((QCircleSplashTransitionPart)localObject).a(n());
    localArrayList.add(localObject);
    localArrayList.add(new QCircleRichMediaDownLoadPart());
    if (QCircleApplication.isRDMVersion()) {
      localArrayList.add(new QCirclePluginDebugPart());
    }
    localArrayList.add(new QCircleAchievementPopupWindowPart());
    return localArrayList;
  }
  
  protected Map<String, Object> e()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.k;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StUser)localObject).id.get()))) {
      localHashMap.put("xsj_profile_host", this.k.id.get());
    }
    localObject = this.l;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StFeed)localObject).id.get()))) {
      localHashMap.put("xsj_from_feed_id", this.l.id.get());
    }
    localHashMap.put("xsj_whether_immerse_version", "no");
    return localHashMap;
  }
  
  protected String f()
  {
    return "pg_xsj_profile_page";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleBroadcastEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.s.b();
    int i1 = t;
    t = i1 + 1;
    if (i1 == 0) {
      this.s.d();
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.n;
    if ((localObject != null) && (String.valueOf(10).equals(((QCircleInitBean)localObject).getLaunchFrom())))
    {
      localObject = new QCircleFolderBean();
      ((QCircleFolderBean)localObject).setAssignShowTabType(1);
      QCircleLauncher.a(getActivity(), (QCircleFolderBean)localObject);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QCirclePersonalDetailHeaderBlock localQCirclePersonalDetailHeaderBlock = this.e;
    if (localQCirclePersonalDetailHeaderBlock != null) {
      localQCirclePersonalDetailHeaderBlock.b();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if ((getActivity() != null) && (this.f != null)) {
      getActivity().unregisterReceiver(this.f);
    }
    t -= 1;
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleBroadcastEvent))
    {
      paramSimpleBaseEvent = ((QCircleBroadcastEvent)paramSimpleBaseEvent).mAction;
      if (TextUtils.isEmpty(paramSimpleBaseEvent)) {
        return;
      }
      if (TextUtils.equals(paramSimpleBaseEvent, "qcircle_personal_page_scroll_to_top_and_refresh")) {
        x();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QCircleReportHelper.getInstance().recordPageStartShow(a());
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    h();
  }
  
  protected void u()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject1 = getActivity().getIntent();
    if ((localObject1 != null) && (((Intent)localObject1).hasExtra("key_bundle_common_init_bean")))
    {
      this.n = ((QCircleInitBean)((Intent)localObject1).getSerializableExtra("key_bundle_common_init_bean"));
      localObject1 = this.n;
      if ((localObject1 != null) && (((QCircleInitBean)localObject1).getUser() != null) && (!TextUtils.isEmpty(this.n.getUser().id.get())))
      {
        this.m = this.n.getUser().id.get();
        this.k = this.n.getUser();
        this.l = this.n.getFeed();
        Object localObject2 = null;
        Object localObject3 = this.l;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((FeedCloudMeta.StFeed)localObject3).busiReport.has()) {
            localObject1 = this.l.busiReport.get().toByteArray();
          }
        }
        localObject3 = new QCircleLpReportDc05504.DataBuilder().setToUin(this.m).setActionType(11).setSubActionType(1).setThrActionType(0);
        localObject2 = this.l;
        if (localObject2 != null) {
          localObject2 = ((FeedCloudMeta.StFeed)localObject2).id.get();
        } else {
          localObject2 = "";
        }
        QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject3).setExt9((String)localObject2).setFeedReportInfo((byte[])localObject1).setPageId(a()));
      }
    }
  }
  
  protected void w()
  {
    String str = this.n.getUser().id.get();
    this.j = ((QCirclePersonalDetailPushViewModel)a(QCirclePersonalDetailPushViewModel.class));
    this.j.a(str);
    QCircleFeedDataCenter localQCircleFeedDataCenter = QCircleFeedDataCenter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(9);
    localStringBuilder.append(str);
    localQCircleFeedDataCenter.a(localStringBuilder.toString(), this.j);
    this.i = ((QCirclePersonalDetailViewModel)a(QCirclePersonalDetailViewModel.class));
    this.i.a(str, this.n);
    localQCircleFeedDataCenter = QCircleFeedDataCenter.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(8);
    localStringBuilder.append(str);
    localQCircleFeedDataCenter.a(localStringBuilder.toString(), this.i);
    this.i.b().observe(this, new QCirclePersonalDetailFragment.1(this));
  }
  
  public void x()
  {
    QLog.d("QCirclePersonalDetailFragment", 1, "scrollToTopAndRefresh");
    try
    {
      this.c.i().getBlockMerger().t();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTopAndRefresh exception:");
      localStringBuilder.append(localException.toString());
      QLog.d("QCirclePersonalDetailFragment", 1, localStringBuilder.toString());
    }
  }
  
  protected void y()
  {
    this.p = ViewUtils.a(200.0F);
    this.c.i().setEnableRefresh(true);
    this.c.i().setEnableLoadMore(false);
    this.c.i().setParentFragment(this);
    this.c.i().getRecyclerView().setTransDispatchDelegate(RFWCompactUtil.a());
    this.c.i().getRecyclerView().addOnScrollListener(new QCirclePersonalDetailFragment.2(this));
  }
  
  public BlockPart z()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */