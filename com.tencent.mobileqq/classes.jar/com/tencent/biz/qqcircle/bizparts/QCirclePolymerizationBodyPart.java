package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.manager.QCircleTagFollowManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCirclePolymerizationBodyPart
  extends QCircleBaseBlockPart
{
  private QCirclePolymerizationBean b;
  private QCircleBaseSingleViewBlock e;
  private QCircleWaterfallFeedsBlock f;
  private QCirclePolymerizationViewModel g;
  private QCircleFullScreenStatusView h;
  private int i;
  private float j;
  private QCircleBlockContainer k;
  
  public QCirclePolymerizationBodyPart(List<MultiViewBlock> paramList, int paramInt1, int paramInt2)
  {
    super(2131431490, paramList, paramInt1, paramInt2);
    if ((paramList != null) && (paramList.size() > 0)) {
      this.e = ((QCircleBaseSingleViewBlock)paramList.get(0));
    }
    if ((paramList != null) && (paramList.size() > 1)) {
      this.f = ((QCircleWaterfallFeedsBlock)paramList.get(1));
    }
  }
  
  private void a(int paramInt)
  {
    this.i += paramInt;
    int m = (int)(this.i * 1.0F / this.j * 255.0F);
    if (m > 255)
    {
      paramInt = 255;
    }
    else
    {
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
    }
    Message localMessage = new Message();
    localMessage.what = paramInt;
    c("polymerization_page_action_title_bar_animation", localMessage);
  }
  
  private void a(UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    int m = paramUIStateData.c();
    boolean bool = true;
    if (m != 0)
    {
      if ((m != 2) && (m != 3)) {
        return;
      }
      if (paramUIStateData.e() == null) {
        return;
      }
      this.e.setDatas(new ArrayList(Arrays.asList(new QQCircleFeedBase.StFeedListBusiRspData[] { (QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e() })));
      this.e.notifyLoadingComplete(true);
      Object localObject = this.b;
      if ((localObject != null) && (((QCirclePolymerizationBean)localObject).getPolymerizationType() == 7))
      {
        c("tab_rsp", paramUIStateData.e());
        paramUIStateData = (QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e();
        if ((paramUIStateData != null) && (paramUIStateData.tagPageData.tagInfo.has()))
        {
          localObject = QCircleTagFollowManager.a();
          String str = paramUIStateData.tagPageData.tagInfo.tagId.get();
          if (paramUIStateData.tagPageData.tagInfo.followState.get() != 1) {
            bool = false;
          }
          ((QCircleTagFollowManager)localObject).a(str, bool);
        }
      }
    }
    else
    {
      QLog.e("BlockPart", 1, "handleHeaderRsp() return empty data");
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    QLog.e("BlockPart", 1, "handleFeedsRsp() return empty data");
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
    if (paramUIStateData != null)
    {
      paramUIStateData.setBackgroundColor(0);
      this.h.a("");
      E().a("publish_show_or_hide", Boolean.valueOf(false));
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
    }
    else
    {
      this.h.b(paramString);
      this.h.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    }
    E().a("polymerization_header_hide_background", null);
    E().a("publish_show_or_hide", Boolean.valueOf(false));
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
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
            break label77;
          }
          c(paramUIStateData);
        }
        else
        {
          b(paramUIStateData, bool);
        }
      }
      else
      {
        b(paramUIStateData, bool);
        break label77;
      }
    }
    else {
      a(paramUIStateData, bool);
    }
    m = 1;
    label77:
    if (m != 0)
    {
      paramUIStateData = this.f;
      if (paramUIStateData != null)
      {
        paramUIStateData.getLoadInfo().a(bool);
        this.f.notifyLoadingComplete(true);
      }
    }
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
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
      this.f.setDatas((ArrayList)paramUIStateData.e());
    }
    this.f.getLoadInfo().a(paramBoolean);
  }
  
  private void c(UIStateData<List<FeedBlockData>> paramUIStateData)
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
    QLog.e("BlockPart", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    if ((localObject != null) && (((QCircleWaterfallFeedsBlock)localObject).getItemCount() > 0)) {
      QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, str, 1);
    }
    a(str, paramUIStateData.g());
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
    QLog.i("BlockPart", 1, localStringBuilder.toString());
    if (bool)
    {
      QLog.i("BlockPart", 1, "runPreload");
      PreLoader.addListener("2008", new QCirclePolymerizationBodyPart.6(this));
      return;
    }
    this.g.a(g(), this.b, false, paramBoolean);
  }
  
  private void l()
  {
    if (this.f != null)
    {
      if (this.b == null) {
        return;
      }
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
      int m = this.b.getPolymerizationType();
      if (m != 7)
      {
        if (m != 16)
        {
          if (m == 20)
          {
            localQCircleExtraTypeInfo.pageType = 13;
            E().a("publish_show_or_hide", Boolean.valueOf(true));
          }
        }
        else
        {
          localQCircleExtraTypeInfo.pageType = 12;
          E().a("publish_show_or_hide", Boolean.valueOf(false));
        }
      }
      else
      {
        localQCircleExtraTypeInfo.pageType = 7;
        E().a("publish_show_or_hide", Boolean.valueOf(true));
      }
      localQCircleExtraTypeInfo.title = this.b.getPolymerizationName();
      localQCircleExtraTypeInfo.mGlobalViewModelKey = String.valueOf(this.b.getPolymerizationType());
      this.f.a(localQCircleExtraTypeInfo);
    }
  }
  
  private QCircleInteractor m()
  {
    return new QCirclePolymerizationBodyPart.5(this);
  }
  
  private void n()
  {
    this.i = 0;
    a(0);
  }
  
  private void o()
  {
    this.h = new QCircleFullScreenStatusView(g());
    QCirclePolymerizationBean localQCirclePolymerizationBean = this.b;
    if ((localQCirclePolymerizationBean != null) && (localQCirclePolymerizationBean.getTagInfo().has())) {
      this.h.setTagInfo(this.b.getTagInfo());
    }
    this.h.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.h.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"), QCircleConfigHelper.R(), QCircleConfigHelper.S());
    this.h.setVisibility(8);
    this.h.setOnRetryClickListener(new QCirclePolymerizationBodyPart.7(this));
    be_().setStatusViewInterface(this.h);
  }
  
  public void a(View paramView)
  {
    this.k = ((QCircleBlockContainer)paramView.findViewById(2131431490));
    this.k.setPadding(0, ImmersiveUtils.a(50.0F) + ImmersiveUtils.a(paramView.getContext()), 0, 0);
    this.j = ViewUtils.a(40.0F);
    this.g = ((QCirclePolymerizationViewModel)a(QCirclePolymerizationViewModel.class));
    QCircleFeedDataCenter.a().a(String.valueOf(this.b.getPolymerizationType()), this.g);
    this.g.a.observe(bd_(), new QCirclePolymerizationBodyPart.1(this));
    this.g.c.observe(bd_(), new QCirclePolymerizationBodyPart.2(this));
    this.f.setOnLoadDataDelegate(new QCirclePolymerizationBodyPart.3(this));
    this.f.setInteractor(m());
    this.f.setReportBean(d());
    l();
    super.a(paramView);
    o();
    if ((be_() != null) && (be_().getRecyclerView() != null))
    {
      be_().setEnableRefresh(true);
      be_().setEnableLoadMore(true);
      be_().getBlockMerger().b(1);
      be_().getRecyclerView().addOnScrollListener(new QCirclePolymerizationBodyPart.4(this));
    }
  }
  
  public void a(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.b = paramQCirclePolymerizationBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart
 * JD-Core Version:    0.7.0.1
 */