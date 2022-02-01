package com.tencent.biz.qqcircle.fragments.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.adapter.QCircleMessageNoticeBubbleBlock;
import com.tencent.biz.qqcircle.adapter.QCircleTianShuBannerBlock;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCirclePageLayoutTypeHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCircleSealRankFeedViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleFolderRcmdTabFragment
  extends QCircleBaseTabFragment
{
  public static String B = "QCircleFolderRcmdTabFragment";
  private boolean F = false;
  private QCircleTianShuBannerBlock G;
  private String H;
  private boolean I;
  private boolean J;
  
  public QCircleFolderRcmdTabFragment(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.n != null) {
      this.n.c(paramString);
    }
    if (this.m == null) {
      return;
    }
    ArrayList localArrayList = this.m.getDataList();
    if (localArrayList == null) {
      return;
    }
    int i = 0;
    int j = localArrayList.size();
    while (i < j)
    {
      if (paramString.equals(((FeedBlockData)localArrayList.get(i)).b().id.get()))
      {
        b(i);
        return;
      }
      i += 1;
    }
  }
  
  private void ae()
  {
    if (!bg_()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleEeveeRedPoint_");
    localStringBuilder.append(B);
    QLog.d(localStringBuilder.toString(), 1, "[clearLocalOuterEntranceRedPoint");
    RFThreadManager.execute(new QCircleFolderRcmdTabFragment.2(this));
  }
  
  private void aj()
  {
    if (!bg_()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleEeveeRedPoint_");
    localStringBuilder.append(B);
    QLog.d(localStringBuilder.toString(), 1, "sendOuterEntranceRedPointRequest");
    RFThreadManager.execute(new QCircleFolderRcmdTabFragment.3(this));
  }
  
  private void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    try
    {
      this.m.delete(paramInt);
      this.m.notifyItemRemoved(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(B, 1, "onReceiveEvent() delete local feed error!", localThrowable);
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.n != null) {
      this.n.c(paramString);
    }
    if (this.m == null) {
      return;
    }
    ArrayList localArrayList = this.m.getDataList();
    if (localArrayList == null) {
      return;
    }
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      if (paramString.equals(((FeedBlockData)localArrayList.get(i)).b().poster.id.get()))
      {
        b(i);
        return;
      }
      i -= 1;
    }
  }
  
  protected int A()
  {
    return QCirclePageLayoutTypeHelper.a().b();
  }
  
  protected List<MultiViewBlock> B()
  {
    ArrayList localArrayList = new ArrayList();
    this.x = new QCircleMessageNoticeBubbleBlock(new Bundle());
    this.x.a(this.t);
    this.x.a(n());
    this.G = new QCircleTianShuBannerBlock(new Bundle());
    this.G.a(n());
    this.G.a(false);
    localArrayList.add(this.G);
    localArrayList.add(this.x);
    return localArrayList;
  }
  
  public void F()
  {
    super.F();
  }
  
  protected QCircleAbsTabFeedViewModel I()
  {
    if (QCirclePluginConfig.H())
    {
      QLog.d(B, 1, "native rerank init");
      return (QCircleAbsTabFeedViewModel)a(u(), QCircleSealRankFeedViewModel.class);
    }
    return (QCircleAbsTabFeedViewModel)a(u(), QCircleTabFeedViewModel.class);
  }
  
  protected void J()
  {
    super.J();
    this.n.c(this.s);
    this.n.g().observe(this, new QCircleFolderRcmdTabFragment.1(this));
  }
  
  protected void K()
  {
    super.K();
    ad();
    ae();
    aj();
  }
  
  public String N()
  {
    return e;
  }
  
  public void O()
  {
    ad();
    this.F = false;
    if (bg_())
    {
      ab();
      return;
    }
    this.I = true;
  }
  
  protected boolean Q()
  {
    boolean bool;
    if ((this.J) && (!TextUtils.isEmpty(this.H))) {
      bool = true;
    } else {
      bool = false;
    }
    this.J = false;
    String str = B;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldWrapRedDotWhenRefresh:");
    localStringBuilder.append(bool);
    QLog.d(str, 1, localStringBuilder.toString());
    return bool;
  }
  
  protected void Z()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      Object localObject = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      int i = ((QCircleFolderBean)localObject).getQQCircleUnreadRedNum();
      boolean bool2 = false;
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.t = bool1;
      if (this.t)
      {
        if (((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() > EeveeRedpointUtil.getFolderMessageNoticeBubbleLastExposeNum()) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.u = bool1;
      }
      this.A = ((QCircleFolderBean)localObject).getRedDotTransInfo();
      if ((this.A != null) && (this.A.length > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      this.w = ((QCircleFolderBean)localObject).hasRedDotShownOnEntrance();
      boolean bool1 = bool2;
      if (!this.u)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      this.s = bool1;
      localObject = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableMemCache:");
      localStringBuilder.append(this.s);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    if (QCirclePageLayoutTypeHelper.a().b() == 2) {
      return 93;
    }
    return 3;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.I)
    {
      this.I = false;
      W();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    super.a(paramUIStateData);
    if ((paramUIStateData != null) && (!paramUIStateData.i()))
    {
      paramUIStateData = new StringBuilder();
      paramUIStateData.append("QCircleEeveeRedPoint_");
      paramUIStateData.append(B);
      QLog.d(paramUIStateData.toString(), 1, "handleFeedDataRsp is refresh clearLocalOuterEntranceRedPoint");
      ae();
    }
  }
  
  public void ad()
  {
    Object localObject = QCircleHostRedPointHelper.getOuterEntranceRedPointInfoByAppid("circle_entrance");
    if ((localObject != null) && (((QQCircleCounter.RedPointInfo)localObject).allPushInfo.has()))
    {
      String str = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadRefreshUpdateTips:");
      localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject).allPushInfo.tabTipWording.get());
      QLog.d(str, 2, localStringBuilder.toString());
      this.H = ((QQCircleCounter.RedPointInfo)localObject).allPushInfo.tabTipWording.get();
      localObject = ((QQCircleCounter.RedPointInfo)localObject).transInfo.get();
      str = B;
      int i = 0;
      if (localObject != null) {
        i = ((ByteStringMicro)localObject).size();
      }
      QLog.d(str, 2, String.format("%s : getTransInfo = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
      if ((localObject != null) && (((ByteStringMicro)localObject).size() > 0))
      {
        this.A = ((ByteStringMicro)localObject).toByteArray();
        this.J = true;
      }
    }
  }
  
  public String b()
  {
    return B;
  }
  
  protected String f()
  {
    return "pg_xsj_explore_page";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    localArrayList.add(QCircleMessageNoticeEvent.class);
    localArrayList.add(QCircleCloseBannerEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDetach()
  {
    QLog.d(B, 1, "QCircleFolderRcmdTabFragment->onDetach");
    super.onDetach();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 3)
      {
        a(paramSimpleBaseEvent.mTargetId);
        return;
      }
      if (paramSimpleBaseEvent.mState == 6) {
        b(paramSimpleBaseEvent.mTargetId);
      }
    }
    else
    {
      if ((paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent))
      {
        G();
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCircleMessageNoticeEvent))
      {
        a(((QCircleMessageNoticeEvent)paramSimpleBaseEvent).mMessageNoticeInfo);
        return;
      }
      if (((paramSimpleBaseEvent instanceof QCircleCloseBannerEvent)) && (this.n != null)) {
        this.n.g().postValue(null);
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setPageId(a()).setActionType(23).setSubActionType(1));
    }
  }
  
  protected boolean x()
  {
    boolean bool;
    if ((QCircleHostGlobalInfo.isCurrentTabActive()) && (!this.F) && (!z())) {
      bool = true;
    } else {
      bool = false;
    }
    this.F = true;
    return bool;
  }
  
  protected String y()
  {
    return this.H;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */