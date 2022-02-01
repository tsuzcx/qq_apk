package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StClientInfo;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StDividingLine;

public class QCircleNewPolymerizeDetailBodyPart
  extends QCircleBaseBlockPart
{
  private QCirclePolymerizeDetailBean b;
  private QCircleInsFeedAdapter e;
  private QCircleWaterfallFeedsBlock f;
  private QCirclePolymerizeDetailViewModel g;
  private QCircleFullScreenStatusView h;
  private QCirclePolyLikeAniView i;
  private String j = "";
  
  public QCircleNewPolymerizeDetailBodyPart(List<MultiViewBlock> paramList, int paramInt1, int paramInt2)
  {
    super(2131431490, paramList, paramInt1, paramInt2);
    if ((paramList != null) && (paramList.size() > 0)) {
      this.e = ((QCircleInsFeedAdapter)paramList.get(0));
    }
    if ((paramList != null) && (paramList.size() > 1)) {
      this.f = ((QCircleWaterfallFeedsBlock)paramList.get(1));
    }
  }
  
  private void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    QCircleInsFeedAdapter localQCircleInsFeedAdapter = this.e;
    if (localQCircleInsFeedAdapter != null)
    {
      localQCircleInsFeedAdapter.setInteractor(n());
      this.e.setReportBean(d());
      this.e.b(false);
      this.e.a(paramQCircleExtraTypeInfo);
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    boolean bool = paramUIStateData.h();
    int m = paramUIStateData.c();
    int k = 0;
    if (m != 0)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4) {
            break label73;
          }
          b(paramUIStateData);
        }
        else
        {
          c(paramUIStateData);
        }
      }
      else
      {
        c(paramUIStateData);
        break label73;
      }
    }
    else {
      a(paramUIStateData, bool);
    }
    k = 1;
    label73:
    if (k != 0)
    {
      paramUIStateData = this.f;
      if (paramUIStateData == null) {
        return;
      }
      paramUIStateData.getLoadInfo().a(bool);
      this.f.notifyLoadingComplete(true);
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    QLog.e("QCircleNewPolymerizeDetailBodyPart", 1, "handleFeedsRsp() return empty data");
    if (paramUIStateData.i())
    {
      paramUIStateData = this.f;
      if ((paramUIStateData != null) && (paramUIStateData.getItemCount() > 0))
      {
        this.f.getLoadInfo().a(paramBoolean);
        return;
      }
    }
    paramUIStateData = this.h;
    if (paramUIStateData == null) {
      return;
    }
    paramUIStateData.setBackgroundColor(0);
    this.h.a("");
    E().a("publish_show_or_hide", Boolean.valueOf(false));
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    Object localObject = null;
    try
    {
      paramStFeed = ((QQCircleDitto.StCircleDittoDataNew)new QQCircleDitto.StCircleDittoDataNew().mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray())).dividingLine;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseRecommendInfo error");
      localStringBuilder.append(paramStFeed.getMessage());
      QLog.e("QCircleNewPolymerizeDetailBodyPart", 1, localStringBuilder.toString());
      paramStFeed = localObject;
    }
    if (paramStFeed != null) {
      this.j = paramStFeed.summary.get();
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    if (this.h == null) {
      return;
    }
    if (((paramLong == 10029L) || (paramLong == 10030L)) && (g() != null) && (g().getResources() != null) && (this.b != null))
    {
      this.h.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"), paramString, g().getResources().getString(2131895721));
      this.h.a(paramString);
      return;
    }
    this.h.b(paramString);
    this.h.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
  }
  
  private void a(List<FeedBlockData> paramList)
  {
    int k = 0;
    while (k < paramList.size())
    {
      localObject = ((FeedBlockData)paramList.get(k)).b();
      if (localObject == null) {
        return;
      }
      if (((FeedCloudMeta.StFeed)localObject).dittoFeed.dittoId.get() == 13)
      {
        a((FeedCloudMeta.StFeed)localObject);
        break label63;
      }
      k += 1;
    }
    k = -1;
    label63:
    if (k < 0) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((QCircleInsFeedAdapter)localObject).setDatas(new ArrayList(paramList.subList(0, k + 1)));
    }
    paramList = paramList.subList(k + 1, paramList.size());
    localObject = this.f;
    if (localObject != null) {
      ((QCircleWaterfallFeedsBlock)localObject).setDatas(new ArrayList(paramList));
    }
    b(paramList);
    p();
  }
  
  private void b(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    QCircleWaterfallFeedsBlock localQCircleWaterfallFeedsBlock = this.f;
    if (localQCircleWaterfallFeedsBlock != null)
    {
      localQCircleWaterfallFeedsBlock.setOnLoadDataDelegate(new QCircleNewPolymerizeDetailBodyPart.2(this));
      this.f.setInteractor(n());
      this.f.setReportBean(d());
      this.f.a(paramQCircleExtraTypeInfo);
    }
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    String str;
    if (paramUIStateData.f() == null) {
      str = HardCodeUtil.a(2131895632);
    } else {
      str = paramUIStateData.f();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleFeedsRsp() return error！errMsg:");
    ((StringBuilder)localObject).append(str);
    QLog.e("QCircleNewPolymerizeDetailBodyPart", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    if ((localObject != null) && (((QCircleWaterfallFeedsBlock)localObject).getItemCount() > 0)) {
      QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, str, 1);
    }
    a(str, paramUIStateData.g());
  }
  
  private void b(List<FeedBlockData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (!TextUtils.isEmpty(this.j))
      {
        Object localObject = new FeedCloudCommon.Entry();
        ((FeedCloudCommon.Entry)localObject).key.set("key_polymerize_recommend_info");
        ((FeedCloudCommon.Entry)localObject).value.set(this.j);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = ((FeedBlockData)paramList.next()).b();
          if (localObject != null) {
            ((FeedCloudMeta.StFeed)localObject).clientInfo.clientMap.set(localArrayList);
          }
        }
      }
    }
  }
  
  private void c(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = this.h;
    if (localQCircleFullScreenStatusView != null) {
      localQCircleFullScreenStatusView.c();
    }
    if (this.f == null) {
      return;
    }
    if (paramUIStateData.i()) {
      this.f.addAll((List)paramUIStateData.e());
    } else {
      a((List)paramUIStateData.e());
    }
    this.f.getLoadInfo().a(paramUIStateData.h());
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    boolean bool = PreLoader.exists("2008");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshPolymerizationData isPreload : ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" =====  enableCache : ");
    localStringBuilder.append(paramBoolean);
    QLog.i("QCircleNewPolymerizeDetailBodyPart", 1, localStringBuilder.toString());
    if (bool)
    {
      QLog.i("QCircleNewPolymerizeDetailBodyPart", 1, "runPreload");
      PreLoader.addListener("2010", new QCircleNewPolymerizeDetailBodyPart.4(this));
      return;
    }
    this.g.a(this.b, false, paramBoolean, true);
  }
  
  private void l()
  {
    this.g = ((QCirclePolymerizeDetailViewModel)a(QCirclePolymerizeDetailViewModel.class));
    this.g.a.observe(bd_(), new QCircleNewPolymerizeDetailBodyPart.1(this));
  }
  
  private void m()
  {
    if ((be_() != null) && (be_().getRecyclerView() != null))
    {
      be_().setEnableRefresh(true);
      be_().setEnableLoadMore(true);
      be_().getBlockMerger().b(1);
    }
  }
  
  private QCircleInteractor n()
  {
    return new QCircleNewPolymerizeDetailBodyPart.3(this);
  }
  
  private void o()
  {
    this.h = new QCircleFullScreenStatusView(g());
    QCirclePolymerizeDetailBean localQCirclePolymerizeDetailBean = this.b;
    if ((localQCirclePolymerizeDetailBean != null) && (localQCirclePolymerizeDetailBean.getTagInfo().has())) {
      this.h.setTagInfo(this.b.getTagInfo());
    }
    this.h.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.h.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"), QCircleConfigHelper.R(), QCircleConfigHelper.S());
    this.h.setVisibility(8);
    this.h.setOnRetryClickListener(new QCircleNewPolymerizeDetailBodyPart.5(this));
    be_().setStatusViewInterface(this.h);
  }
  
  private void p()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(102).setSubActionType(1).setThrActionType(1).setPageId(f()).setExt7(this.j));
  }
  
  public void a(View paramView)
  {
    this.b = ((QCirclePolymerizeDetailBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    this.i = ((QCirclePolyLikeAniView)paramView.findViewById(2131441777));
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    QCirclePolymerizeDetailBean localQCirclePolymerizeDetailBean = this.b;
    int k;
    if (localQCirclePolymerizeDetailBean != null) {
      k = localQCirclePolymerizeDetailBean.getSourceType();
    } else {
      k = 1;
    }
    localQCircleExtraTypeInfo.pageType = k;
    l();
    a(localQCircleExtraTypeInfo);
    b(localQCircleExtraTypeInfo);
    super.a(paramView);
    o();
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleNewPolymerizeDetailBodyPart
 * JD-Core Version:    0.7.0.1
 */