package com.tencent.biz.qqcircle.fragments.person;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleThreadManager;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGuidePublishBubble;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class QCirclePersonalBaseBottomFragment
  extends QCircleBaseFragment
  implements ReportBean<QCircleReportBean>, SimpleEventReceiver
{
  protected BlockPart c;
  protected QCirclePersonalDetailViewModel d;
  protected QCircleFakeAdapter e;
  protected String f;
  protected String g;
  private FeedCloudMeta.StUser h;
  private FeedCloudMeta.StFeed i;
  private QCircleReportBean j;
  private Handler k = new Handler(Looper.getMainLooper());
  
  public void A()
  {
    QCircleFakeAdapter localQCircleFakeAdapter = this.e;
    if (localQCircleFakeAdapter != null) {
      localQCircleFakeAdapter.c();
    }
  }
  
  public void B()
  {
    QLog.d("QCircleBaseFragment", 1, "scrollToTopAndRefresh");
    try
    {
      this.k.postDelayed(new QCirclePersonalBaseBottomFragment.4(this), 200L);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTopAndRefresh exception:");
      localStringBuilder.append(localException.toString());
      QLog.d("QCircleBaseFragment", 1, localStringBuilder.toString());
    }
  }
  
  protected void C()
  {
    try
    {
      if (((D() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)D()).z() != null) && (((QCirclePersonalDetailFragment)D()).z().i() != null) && (((QCirclePersonalDetailFragment)D()).z().i().getRecyclerView() != null))
      {
        int n = ((QCirclePersonalDetailFragment)D()).z().i().getRecyclerView().getChildCount();
        int m = 0;
        while (m < n)
        {
          View localView = ((QCirclePersonalDetailFragment)D()).z().i().getRecyclerView().getChildAt(m);
          if (((localView instanceof QCirclePersonInfoWidget)) && (this.k != null)) {
            this.k.post(new QCirclePersonalBaseBottomFragment.5(this, localView));
          }
          m += 1;
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustEmptyViewHeight()  e.getMessage : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleBaseFragment", 2, localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
  
  public BasePartFragment D()
  {
    if ((getActivity() != null) && ((getActivity() instanceof CompatPublicActivity)) && (getActivity().getSupportFragmentManager().getFragments() != null) && (getActivity().getSupportFragmentManager().getFragments().size() > 0) && ((getActivity().getSupportFragmentManager().getFragments().get(0) instanceof BasePartFragment))) {
      return (BasePartFragment)getActivity().getSupportFragmentManager().getFragments().get(0);
    }
    return null;
  }
  
  public boolean E()
  {
    return true;
  }
  
  protected QCircleFakeAdapter F()
  {
    QCircleInsFeedAdapter localQCircleInsFeedAdapter = new QCircleInsFeedAdapter(new Bundle());
    localQCircleInsFeedAdapter.b(true);
    localQCircleInsFeedAdapter.setReportBean(n());
    return localQCircleInsFeedAdapter;
  }
  
  protected boolean G()
  {
    QCircleInitBean localQCircleInitBean = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if (localQCircleInitBean == null) {
      return false;
    }
    return localQCircleInitBean.isNeedShowGoHomeButton();
  }
  
  public int a()
  {
    return QCircleReportBean.getPageId(b(), this.j);
  }
  
  public void a(int paramInt)
  {
    QCircleFakeAdapter localQCircleFakeAdapter = this.e;
    if (localQCircleFakeAdapter != null)
    {
      localQCircleFakeAdapter.b(paramInt);
      this.e.setReportBean(n());
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    z();
    u();
    this.e.e();
    C();
    if ((this.c.bc_() instanceof QCirclePersonalBottomStatusView)) {
      ((QCirclePersonalBottomStatusView)this.c.bc_()).setUser(this.h);
    }
    this.c.bc_().getStatusView().setVisibility(8);
    this.c.i().getRecyclerView().addOnScrollListener(new QCirclePersonalBaseBottomFragment.1(this));
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null)
    {
      QLog.e("QCircleBaseFragment", 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = paramUIStateData.h();
    int i1 = paramUIStateData.c();
    int n = 0;
    if (i1 != 0)
    {
      m = n;
      if (i1 == 1) {
        break label617;
      }
      Object localObject2;
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            m = n;
            break label617;
          }
          if (paramUIStateData.f() == null) {
            localObject1 = HardCodeUtil.a(2131895632);
          } else {
            localObject1 = paramUIStateData.f();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleFeedDataRsp() return error！errMsg:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.e("QCircleBaseFragment", 1, ((StringBuilder)localObject2).toString());
          QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, (String)localObject1, 1);
          if ((this.e == null) || (this.c == null)) {
            break label615;
          }
          if ((paramUIStateData.g() != 10022L) && (paramUIStateData.g() != 10028L))
          {
            if (this.e.getItemCount() <= 0)
            {
              ((QCircleStatusView)this.c.i().getStatusInterface()).b((String)localObject1);
              break label615;
            }
            this.c.i().getStatusInterface().getStatusView().setVisibility(8);
            break label615;
          }
          this.c.i().getStatusInterface().a(this.g);
          this.e.clearData();
          this.e.notifyDataSetChanged();
          break label615;
        }
        m = 1;
      }
      else
      {
        m = 0;
      }
      Object localObject1 = (ArrayList)paramUIStateData.e();
      if (this.e != null)
      {
        localObject2 = this.c;
        if (localObject2 != null)
        {
          ((BlockPart)localObject2).i().getStatusInterface().getStatusView().setVisibility(8);
          this.c.i().getRecyclerView().setVisibility(0);
        }
        this.e.setDatas((List)localObject1);
        if (!paramUIStateData.i()) {
          this.e.e();
        }
        this.e.getLoadInfo().a(bool);
      }
      break label617;
    }
    else
    {
      QLog.e("QCircleBaseFragment", 1, "handleFeedDataRsp() return empty data");
      if (paramUIStateData.i())
      {
        paramUIStateData = this.e;
        if ((paramUIStateData != null) && (paramUIStateData.getItemCount() > 0))
        {
          this.e.getLoadInfo().a(bool);
          break label615;
        }
      }
      QLog.i("QCircleBaseFragment", 1, "handleFeedDataRsp");
      if (this.c != null)
      {
        paramUIStateData = this.e;
        if (paramUIStateData != null) {
          if (!paramUIStateData.f())
          {
            this.c.i().getStatusInterface().a(this.g);
            if (QCirclePluginUtil.d(this.f))
            {
              paramUIStateData = this.d;
              if ((paramUIStateData != null) && (paramUIStateData.b().getValue() != null) && (((UIStateData)this.d.b().getValue()).e() != null))
              {
                paramUIStateData = (FeedCloudMeta.StGuidePublishBubble)((FeedCloudRead.StGetMainPageRsp)((UIStateData)this.d.b().getValue()).e()).guidePublishBubble.get();
                D().p().a("personal_page_publish_guide_rsp", paramUIStateData);
              }
            }
            this.e.clearData();
            this.e.notifyDataSetChanged();
            QLog.i("QCircleBaseFragment", 1, "handleFeedDataRsp  StatusView = visible");
          }
          else
          {
            this.c.i().getStatusInterface().getStatusView().setVisibility(8);
            QLog.i("QCircleBaseFragment", 1, "handleFeedDataRsp  StatusView = gone");
          }
        }
      }
    }
    label615:
    int m = 1;
    label617:
    if (m != 0)
    {
      paramUIStateData = this.e;
      if (paramUIStateData != null) {
        paramUIStateData.notifyLoadingComplete(true, bool);
      }
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.j = QCircleReportBean.setReportBean(b(), paramQCircleReportBean);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    this.h = paramStUser;
    if ((this.c.bc_() instanceof QCirclePersonalBottomStatusView)) {
      ((QCirclePersonalBottomStatusView)this.c.bc_()).setUser(paramStUser);
    }
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if ((QCirclePluginUtil.d(this.f)) && (paramUIStateData != null))
    {
      if (this.e == null) {
        return;
      }
      if ((paramUIStateData.c() == 0) && (!this.e.f()) && (getUserVisibleHint()) && (this.e.getDataList() != null) && (this.e.getDataList().size() == 0))
      {
        D().p().a("personal_page_show_publish_guide", Boolean.valueOf(true));
        D().p().a("publish_show_or_hide", Boolean.valueOf(true));
      }
      else if (getUserVisibleHint())
      {
        D().p().a("personal_page_show_publish_guide", Boolean.valueOf(false));
      }
      if ((paramUIStateData.c() != 1) && (!G())) {
        D().p().a("publish_show_or_hide", Boolean.valueOf(true));
      }
    }
  }
  
  protected int c()
  {
    return 2131626891;
  }
  
  protected List<Part> d()
  {
    x();
    ArrayList localArrayList = new ArrayList();
    this.c = new BlockPart(2131431490, y(), 3, 1);
    localArrayList.add(this.c);
    return localArrayList;
  }
  
  protected Map<String, Object> e()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.h;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StUser)localObject).id.get()))) {
      localHashMap.put("xsj_profile_host", this.h.id.get());
    }
    localObject = this.i;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StFeed)localObject).id.get()))) {
      localHashMap.put("xsj_from_feed_id", this.i.id.get());
    }
    return localHashMap;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void h() {}
  
  protected int j()
  {
    return QCirclePluginUtil.a();
  }
  
  public QCircleReportBean n()
  {
    if (this.j == null) {
      this.j = new QCircleReportBean();
    }
    return this.j.setPageId(32);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    Handler localHandler = this.k;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.k = null;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      if (!E()) {
        return;
      }
      if (this.k == null) {
        return;
      }
      QCircleFeedEvent localQCircleFeedEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (localQCircleFeedEvent.mState == 1)
      {
        this.k.postDelayed(new QCirclePersonalBaseBottomFragment.6(this), 200L);
        return;
      }
      if ((QCirclePluginUtil.d(this.f)) && (localQCircleFeedEvent.mState == 3))
      {
        RFThreadManager.getUIHandler().postDelayed(new QCirclePersonalBaseBottomFragment.7(this, paramSimpleBaseEvent), 200L);
        return;
      }
      if ((QCirclePluginUtil.d(this.f)) && (localQCircleFeedEvent.mState == 4))
      {
        paramSimpleBaseEvent = localQCircleFeedEvent.mFakeFeedDataList;
        if ((paramSimpleBaseEvent != null) && (paramSimpleBaseEvent.size() != 0)) {
          D().p().a("personal_page_show_publish_guide", Boolean.valueOf(false));
        }
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleThreadManager.a().c().postDelayed(new QCirclePersonalBaseBottomFragment.2(this), 100L);
    }
  }
  
  protected abstract void u();
  
  protected boolean v()
  {
    return false;
  }
  
  protected abstract void w();
  
  protected void x()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if ((((QCircleInitBean)localObject).getUser() != null) && (!TextUtils.isEmpty(((QCircleInitBean)localObject).getUser().id.get())))
      {
        this.f = ((QCircleInitBean)localObject).getUser().id.get();
        this.h = ((QCircleInitBean)localObject).getUser();
        this.i = ((QCircleInitBean)localObject).getFeed();
      }
    }
  }
  
  protected List<MultiViewBlock> y()
  {
    ArrayList localArrayList = new ArrayList();
    this.e = F();
    this.e.a(E());
    if (((D() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)D()).z() != null) && (((QCirclePersonalDetailFragment)D()).z().i() != null) && (((QCirclePersonalDetailFragment)D()).z().i().getRecyclerView() != null))
    {
      int n = ((QCirclePersonalDetailFragment)D()).z().i().getRecyclerView().getChildCount();
      int m = 0;
      while (m < n)
      {
        View localView = ((QCirclePersonalDetailFragment)D()).z().i().getRecyclerView().getChildAt(m);
        if ((localView instanceof QCirclePersonalBottomView)) {
          this.e.setInteractor(((QCirclePersonalBottomView)localView).getInteractor());
        }
        m += 1;
      }
    }
    this.e.setOnLoadDataDelegate(new QCirclePersonalBaseBottomFragment.3(this));
    localArrayList.add(this.e);
    return localArrayList;
  }
  
  protected void z()
  {
    this.c.i().getRecyclerView().setNestedScrollingEnabled(true);
    this.c.i().setEnableRefresh(false);
    this.c.i().setEnableLoadMore(true);
    this.c.i().setParentFragment(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment
 * JD-Core Version:    0.7.0.1
 */