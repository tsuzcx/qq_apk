package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class QCirclePolymerizeDetailBodyPart
  extends QCircleBaseBlockPart
  implements SimpleEventReceiver
{
  private QCircleInsFeedAdapter b;
  private QCirclePolymerizeDetailBean e;
  private QCirclePolymerizeDetailViewModel f;
  private QCircleFullScreenStatusView g;
  private View h;
  private int i = 0;
  private int j = 1;
  private RefreshHeaderView k;
  
  public QCirclePolymerizeDetailBodyPart(List<MultiViewBlock> paramList, int paramInt1, int paramInt2)
  {
    super(2131431490, paramList, paramInt1, paramInt2);
    if ((paramList != null) && (paramList.size() > 0)) {
      this.b = ((QCircleInsFeedAdapter)paramList.get(0));
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    n();
    boolean bool = paramUIStateData.h();
    int n = paramUIStateData.c();
    int m = 0;
    if (n != 0)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4) {
            break label248;
          }
          String str;
          if (paramUIStateData.f() == null) {
            str = HardCodeUtil.a(2131895632);
          } else {
            str = paramUIStateData.f();
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleFeedsRsp() return error！errMsg:");
          ((StringBuilder)localObject).append(str);
          QLog.e("QCirclePolymerizeDetailBodyPart", 1, ((StringBuilder)localObject).toString());
          localObject = this.b;
          if ((localObject != null) && (((QCircleInsFeedAdapter)localObject).getItemCount() > 0)) {
            QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, str, 1);
          }
          a(str);
        }
        else
        {
          a(paramUIStateData, bool);
        }
      }
      else
      {
        a(paramUIStateData, bool);
        break label248;
      }
    }
    else
    {
      QLog.e("QCirclePolymerizeDetailBodyPart", 1, "handleFeedsRsp() return empty data");
      if (paramUIStateData.i())
      {
        paramUIStateData = this.b;
        if ((paramUIStateData != null) && (paramUIStateData.getItemCount() > 0))
        {
          this.b.getLoadInfo().a(bool);
          break label246;
        }
      }
      paramUIStateData = this.g;
      if (paramUIStateData != null)
      {
        paramUIStateData.setBackgroundColor(0);
        this.g.a("");
        E().a("publish_show_or_hide", Boolean.valueOf(false));
      }
    }
    label246:
    m = 1;
    label248:
    if (m != 0)
    {
      paramUIStateData = this.b;
      if (paramUIStateData != null)
      {
        paramUIStateData.getLoadInfo().a(bool);
        this.b.notifyLoadingComplete(true);
      }
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = this.g;
    if (localQCircleFullScreenStatusView != null) {
      localQCircleFullScreenStatusView.c();
    }
    if (this.b == null) {
      return;
    }
    if (paramUIStateData.i()) {
      this.b.setDatas((List)paramUIStateData.e(), paramUIStateData.j());
    } else {
      this.b.setDatas((List)paramUIStateData.e());
    }
    this.b.getLoadInfo().a(paramBoolean);
  }
  
  private void a(String paramString)
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = this.g;
    if (localQCircleFullScreenStatusView != null)
    {
      localQCircleFullScreenStatusView.b(paramString);
      this.g.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
      E().a("publish_show_or_hide", Boolean.valueOf(false));
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((QCircleInsFeedAdapter)localObject).getDataList();
      if (localObject != null)
      {
        int i1 = -1;
        int m = 0;
        int i2 = ((ArrayList)localObject).size();
        int n;
        for (;;)
        {
          n = i1;
          if (m >= i2) {
            break;
          }
          if (paramString.equals(((FeedBlockData)((ArrayList)localObject).get(m)).b().id.get()))
          {
            n = m;
            break;
          }
          m += 1;
        }
        if (n >= 0) {
          try
          {
            this.b.delete(n);
            this.b.notifyItemRemoved(n);
            return;
          }
          catch (Throwable paramString)
          {
            QLog.e("QCirclePolymerizeDetailBodyPart", 1, "onReceiveEvent() delete local feed error!", paramString);
          }
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((QCircleInsFeedAdapter)localObject).getDataList();
      if (localObject != null)
      {
        int m = ((ArrayList)localObject).size() - 1;
        while (m >= 0)
        {
          if (paramString.equals(((FeedBlockData)((ArrayList)localObject).get(m)).b().poster.id.get())) {
            try
            {
              this.b.delete(m);
              this.b.notifyItemRemoved(m);
              return;
            }
            catch (Throwable paramString)
            {
              QLog.e("QCirclePolymerizeDetailBodyPart", 1, "onReceiveEvent() delete local feed error!", paramString);
              return;
            }
          }
          m -= 1;
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    boolean bool = PreLoader.exists("2008");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshPolymerizeDetailData isPreload : ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" =====  enableCache : ");
    localStringBuilder.append(paramBoolean);
    QLog.i("QCirclePolymerizeDetailBodyPart", 1, localStringBuilder.toString());
    if (bool)
    {
      QLog.i("QCirclePolymerizeDetailBodyPart", 1, "runPreload");
      PreLoader.addListener("2009", new QCirclePolymerizeDetailBodyPart.6(this));
      return;
    }
    this.f.a(this.e, false, paramBoolean);
  }
  
  private void l()
  {
    if (f() == 83)
    {
      if (QCirclePluginConfig.a().B()) {
        return;
      }
      this.f.b.observe(bd_(), new QCirclePolymerizeDetailBodyPart.3(this));
      if ((be_() != null) && (be_().getRecyclerView() != null)) {
        be_().getRecyclerView().addOnScrollListener(new QCirclePolymerizeDetailBodyPart.4(this));
      }
    }
  }
  
  private void m()
  {
    if ((f() != 85) && (f() != 83)) {
      return;
    }
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.d("QCirclePolymerizeDetailBodyPart", 2, "showRefreshHeaderView feed adapter is null.");
      return;
    }
    if (((QCircleInsFeedAdapter)localObject).getItemCount() > 0) {
      return;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((RefreshHeaderView)localObject).setState(4);
      this.k.setVisibility(0);
    }
  }
  
  private void n()
  {
    RefreshHeaderView localRefreshHeaderView = this.k;
    if ((localRefreshHeaderView != null) && (localRefreshHeaderView.getVisibility() == 0))
    {
      this.k.setState(0);
      this.k.setVisibility(8);
    }
  }
  
  private QCircleInteractor o()
  {
    return new QCirclePolymerizeDetailBodyPart.5(this);
  }
  
  private void p()
  {
    this.g = new QCircleFullScreenStatusView(g());
    this.g.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.g.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"), QCircleConfigHelper.R(), QCircleConfigHelper.S());
    this.g.setVisibility(8);
    this.g.setOnRetryClickListener(new QCirclePolymerizeDetailBodyPart.7(this));
    be_().setStatusViewInterface(this.g);
  }
  
  public void a(View paramView)
  {
    this.h = paramView;
    this.d = ((BlockContainer)paramView.findViewById(2131431490));
    this.k = ((RefreshHeaderView)paramView.findViewById(2131444556));
    this.f = ((QCirclePolymerizeDetailViewModel)a(QCirclePolymerizeDetailViewModel.class));
    this.f.a.observe(bd_(), new QCirclePolymerizeDetailBodyPart.1(this));
    l();
    this.b.setOnLoadDataDelegate(new QCirclePolymerizeDetailBodyPart.2(this));
    this.b.setInteractor(o());
    this.b.setReportBean(d());
    this.b.b(false);
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    QCirclePolymerizeDetailBean localQCirclePolymerizeDetailBean = this.e;
    int m;
    if (localQCirclePolymerizeDetailBean != null) {
      m = localQCirclePolymerizeDetailBean.getSourceType();
    } else {
      m = 1;
    }
    localQCircleExtraTypeInfo.pageType = m;
    localQCirclePolymerizeDetailBean = this.e;
    if (localQCirclePolymerizeDetailBean != null) {
      m = localQCirclePolymerizeDetailBean.getPageId();
    } else {
      m = 83;
    }
    localQCircleExtraTypeInfo.mGlobalViewModelKey = String.valueOf(m);
    this.b.a(localQCircleExtraTypeInfo);
    QCircleFeedDataCenter.a().a(localQCircleExtraTypeInfo.mGlobalViewModelKey, this.f);
    super.a(paramView);
    p();
    if (be_() != null)
    {
      be_().setEnableRefresh(false);
      be_().setEnableLoadMore(true);
      be_().getBlockMerger().b(1);
    }
  }
  
  public void a(QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean)
  {
    this.e = paramQCirclePolymerizeDetailBean;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 3)
      {
        if (paramSimpleBaseEvent.mState == 3)
        {
          b(paramSimpleBaseEvent.mTargetId);
          return;
        }
        if (paramSimpleBaseEvent.mState == 6) {
          c(paramSimpleBaseEvent.mTargetId);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart
 * JD-Core Version:    0.7.0.1
 */