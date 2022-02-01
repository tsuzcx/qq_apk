package com.tencent.biz.qqcircle.fragments.content;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.LbsDescPublishEvent;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.events.QCircleStickShareEvent;
import com.tencent.biz.qqcircle.events.TagDescPublishEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.ScrollMoreGuideView;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.transition.ITransAnimStateListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.utils.QCircleLiuHaiUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StGpsPageData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCircleContentPart
  extends QCircleBaseBlockPart
  implements ITransAnimStateListener, SimpleEventReceiver
{
  private QCircleExtraTypeInfo A;
  private LinearLayout B;
  private boolean C;
  private int D;
  private boolean E;
  private int F;
  private QCircleContentModel b;
  private IDataDisplaySurface<FeedBlockData> e;
  private RecyclerView f;
  private QCircleContentVerticalAdapter g;
  private ImageView h;
  private ImageView i;
  private ViewGroup j;
  private QCircleLayerStatusView k;
  private long l;
  private QCircleLayerBean m;
  private int n = 0;
  private int o = 0;
  private QCircleTransitionAnimHelper p;
  private ViewGroup q;
  private QCirclePolyLikeAniView r;
  private QCircleTransitionLayout s;
  private FrameLayout t;
  private QCircleTransitionInnerLayout u;
  private ScrollMoreGuideView v;
  private ProgressBar w;
  private ImmersiveEventHelper x;
  private int y = 0;
  private Drawable z;
  
  private void A()
  {
    I();
    H();
    B();
  }
  
  private void B()
  {
    ImageView localImageView = this.i;
    if (localImageView == null) {
      return;
    }
    localImageView.setOnClickListener(new QCircleContentPart.8(this));
  }
  
  private void H()
  {
    ImageView localImageView = this.h;
    if (localImageView == null) {
      return;
    }
    localImageView.setOnClickListener(new QCircleContentPart.9(this));
  }
  
  private void I()
  {
    RecyclerView localRecyclerView = this.f;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.addOnScrollListener(new QCircleContentPart.10(this));
  }
  
  private void J()
  {
    if (this.k.getVisibility() == 0) {
      return;
    }
    Object localObject2 = L();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = a((FeedCloudMeta.StFeed)localObject2);
    a((FeedCloudMeta.StFeed)localObject2, (QCircleShareInfo)localObject1, new QQCircleFeedBase.StFeedBusiReqData());
    List localList = ((FeedCloudMeta.StFeed)localObject2).opMask2.get();
    if (localList != null)
    {
      if ((!QCirclePluginUtil.b((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject2).poster.get())) && (localList.contains(Integer.valueOf(1)))) {
        bool = true;
      } else {
        bool = false;
      }
      ((QCircleShareInfo)localObject1).m = bool;
      ((QCircleShareInfo)localObject1).p = localList.contains(Integer.valueOf(10));
      ((QCircleShareInfo)localObject1).e = this.g.f();
      boolean bool = ((QCircleShareInfo)localObject1).m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((QCircleShareInfo)localObject1).p);
      ((StringBuilder)localObject2).append(" | picDownPos: ");
      QLog.d("QCircleContentPart", 1, new Object[] { "[Share-onClick] isShowHideThisWork: ", Boolean.valueOf(bool), " | isShowDownLoad: ", ((StringBuilder)localObject2).toString(), Integer.valueOf(((QCircleShareInfo)localObject1).e) });
    }
    c("share_action_show_share_sheet", localObject1);
    localObject2 = q();
    if (v()) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    a(21, 2, (QCircleExtraTypeInfo)localObject2, (String)localObject1);
  }
  
  private boolean K()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((IDataDisplaySurface)localObject).a(new Object[0]) != null) && (this.e.a(new Object[0]).getValue() != null)) {
      return ((UIStateData)this.e.a(new Object[0]).getValue()).h();
    }
    localObject = this.b;
    if ((localObject != null) && (((QCircleContentModel)localObject).b() != null)) {
      return this.b.b().a();
    }
    return true;
  }
  
  private FeedCloudMeta.StFeed L()
  {
    Object localObject3 = this.b;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((QCircleContentModel)localObject3).d() != null)
      {
        localObject3 = this.b.d();
        if ((localObject3 instanceof QCircleContentHorizontalAdapter.QCirclePicVH))
        {
          localObject3 = ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject3).a;
          localObject1 = localObject2;
          if (localObject3 != null) {
            return ((FeedBlockData)((QCircleContentImage)localObject3).getData()).b();
          }
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof QCircleContentHorizontalAdapter.QCircleVideoVH))
          {
            localObject3 = ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject3).a;
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((FeedBlockData)((QCircleContentVideo)localObject3).getData()).b();
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private void M()
  {
    if (System.currentTimeMillis() - this.l > 2000L)
    {
      Toast.makeText(g(), 2131895756, 0).show();
      this.l = System.currentTimeMillis();
    }
  }
  
  private void N()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((IDataDisplaySurface)localObject).b(new Object[0]);
    }
    else
    {
      localObject = this.b;
      if ((localObject != null) && (!((QCircleContentModel)localObject).b().a()) && (!this.b.b().b())) {
        this.b.a(this.m, true);
      }
    }
    W();
  }
  
  private void O()
  {
    if (this.g != null)
    {
      Object localObject1 = this.m.getFeed();
      if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).type.get() != 0))
      {
        localObject2 = ((FeedCloudMeta.StFeed)localObject1).opMask2.get();
        if ((localObject2 != null) && (((List)localObject2).contains(Integer.valueOf(9)))) {
          ((List)localObject2).remove(Integer.valueOf(9));
        }
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(new FeedBlockData((FeedCloudMeta.StFeed)localObject1).c());
        this.g.setDatas((List)localObject2);
        this.C = true;
      }
      this.y = this.m.getPicPos();
      this.g.b(this.y);
      this.g.a(this.m.getVideoCurrentPosition());
      Object localObject2 = this.g;
      if (this.m.getExtraTypeInfo() == null) {
        localObject1 = new QCircleExtraTypeInfo();
      } else {
        localObject1 = this.m.getExtraTypeInfo();
      }
      ((QCircleContentVerticalAdapter)localObject2).a((QCircleExtraTypeInfo)localObject1);
    }
  }
  
  private void P()
  {
    this.b.b().a(null);
    this.b.a(this.m, false);
  }
  
  private QCircleInteractor Q()
  {
    return new QCircleContentPart.11(this);
  }
  
  private void R()
  {
    ProgressBar localProgressBar = this.w;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      this.w.setIndeterminate(false);
    }
  }
  
  private void S()
  {
    if (c() == null) {
      return;
    }
    Object localObject1 = this.s;
    if (localObject1 != null) {
      ((QCircleTransitionLayout)localObject1).setInnerViewVisiable(8);
    }
    localObject1 = this.u;
    Object localObject3 = null;
    if (localObject1 != null) {
      localObject1 = ((QCircleTransitionInnerLayout)localObject1).getMatrix();
    } else {
      localObject1 = null;
    }
    if (this.p != null)
    {
      Object localObject4 = this.b;
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if (((QCircleContentModel)localObject4).d() != null)
        {
          localObject4 = this.b.d();
          localObject2 = localObject3;
          if ((localObject4 instanceof QCircleContentHorizontalAdapter.QCirclePicVH))
          {
            localObject4 = ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject4).a;
            localObject2 = localObject3;
            if (localObject4 != null) {
              localObject2 = ((QCircleContentImage)localObject4).getCover();
            }
          }
        }
      }
      this.p.a((Matrix)localObject1, (ImageView)localObject2, new QCircleContentPart.13(this));
    }
  }
  
  private boolean T()
  {
    return (this.p != null) && (this.n == this.F);
  }
  
  private void U()
  {
    QCircleContentModel localQCircleContentModel = this.b;
    if ((localQCircleContentModel != null) && ((localQCircleContentModel.d() instanceof QCircleContentHorizontalAdapter.QCircleVideoVH)))
    {
      this.g.a((QCircleContentHorizontalAdapter.QCircleVideoVH)this.b.d(), this.D);
      this.D = 0;
    }
  }
  
  private void V()
  {
    Object localObject = this.b;
    if ((localObject != null) && ((((QCircleContentModel)localObject).d() instanceof QCircleContentHorizontalAdapter.QCircleVideoVH)))
    {
      QLog.i("QCircleContentPart", 1, "onActivityPaused: get video from ContentModel");
      localObject = ((QCircleContentHorizontalAdapter.QCircleVideoVH)this.b.d()).a;
      if (localObject != null)
      {
        if (((QCircleContentHorizontalAdapter.QCircleVideoVH)this.b.d()).b != null) {
          ((QCircleContentHorizontalAdapter.QCircleVideoVH)this.b.d()).b.setVisibility(0);
        }
        if (!((QCircleContentVideo)localObject).o())
        {
          QLog.i("QCircleContentPart", 1, "onActivityPaused: video pause");
          ((QCircleContentVideo)localObject).release();
        }
        if ((((QCircleContentVideo)localObject).getParent() instanceof ViewGroup)) {
          ((ViewGroup)((QCircleContentVideo)localObject).getParent()).removeView((View)localObject);
        }
        String str = QCirclePluginUtil.c(((QCircleContentVideo)localObject).getPlayUrl());
        if (!TextUtils.isEmpty(str))
        {
          this.D = ((int)((QCircleContentVideo)localObject).getCurrentPosition());
          SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVideoPositionLinkEvent(str, this.D));
        }
      }
    }
  }
  
  private void W()
  {
    QCircleTransitionLayout localQCircleTransitionLayout = this.s;
    if (localQCircleTransitionLayout != null) {
      localQCircleTransitionLayout.b(false);
    }
  }
  
  private void X()
  {
    RFThreadManager.getUIHandler().postDelayed(new QCircleContentPart.14(this), 500L);
  }
  
  @NonNull
  private QCircleShareInfo a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleShareInfo localQCircleShareInfo = new QCircleShareInfo();
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    Object localObject = this.b;
    if ((localObject != null) && (((QCircleContentModel)localObject).d() != null))
    {
      localObject = this.b.d();
      localQCircleExtraTypeInfo.mFeed = paramStFeed;
      localQCircleExtraTypeInfo.mDataPosition = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
      localQCircleExtraTypeInfo.mPlayScene = 2;
    }
    localQCircleShareInfo.c = localQCircleExtraTypeInfo;
    localQCircleShareInfo.b = paramStFeed;
    localQCircleShareInfo.d = 0;
    localQCircleShareInfo.j = (QCirclePluginUtil.d(localQCircleShareInfo.b) ^ true);
    localQCircleShareInfo.k = true;
    localQCircleShareInfo.i = QCirclePluginUtil.d(localQCircleShareInfo.b);
    localQCircleShareInfo.l = false;
    localQCircleShareInfo.m = false;
    return localQCircleShareInfo;
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((RecyclerView)localObject).setAlpha(paramInt);
    }
    localObject = this.q;
    if (localObject != null) {
      ((ViewGroup)localObject).setAlpha(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setFloatValues(new float[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new QCircleContentPart.3(this));
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.start();
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setExt1(paramString).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(f()).setfpageid(e()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleContentPart", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(View paramView, ResponseBean paramResponseBean)
  {
    Object localObject = SharePreferenceUtils.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count");
    boolean bool = ((String)localObject).equals("");
    int i2 = 0;
    int i1;
    if (bool) {
      i1 = 0;
    } else {
      i1 = Integer.parseInt((String)localObject);
    }
    if (i1 < 3) {
      i2 = 1;
    }
    if ((i2 != 0) && (!QCircleConstants.a))
    {
      localObject = this.m;
      if ((localObject != null) && (!((QCircleLayerBean)localObject).isSingleFeed()) && (!a(paramResponseBean)))
      {
        W();
        this.v = new ScrollMoreGuideView(this.j);
        this.v.a(this.f);
        this.v.a();
        this.v.a(new QCircleContentPart.5(this));
        QCircleConstants.a = true;
        SharePreferenceUtils.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count", String.valueOf(i1 + 1));
        paramResponseBean = q();
        if (v()) {
          paramView = "1";
        } else {
          paramView = "2";
        }
        a(85, 1, paramResponseBean, paramView);
        return;
      }
    }
    X();
  }
  
  private void a(QCircleShareInfo paramQCircleShareInfo)
  {
    if (paramQCircleShareInfo == null) {
      return;
    }
    Object localObject = paramQCircleShareInfo.c;
    QCircleLpReportDc05507.DataBuilder localDataBuilder = null;
    if (localObject != null) {
      localObject = paramQCircleShareInfo.c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder1 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(1);
    localObject = paramQCircleShareInfo.c;
    String str = "";
    if ((localObject != null) && (paramQCircleShareInfo.c.mFeed != null)) {
      localObject = paramQCircleShareInfo.c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder1.setToUin((String)localObject)));
    localObject = localDataBuilder;
    if (paramQCircleShareInfo.c != null) {
      localObject = paramQCircleShareInfo.c.mFeed;
    }
    localDataBuilder = QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(1);
    localObject = str;
    if (paramQCircleShareInfo.c != null)
    {
      localObject = str;
      if (paramQCircleShareInfo.c.mFeed != null) {
        localObject = paramQCircleShareInfo.c.mFeed.poster.id.get();
      }
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(localDataBuilder.setToUin((String)localObject)));
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (this.g != null)
    {
      if (paramQCircleFeedEvent.mState == 3)
      {
        this.g.a(paramQCircleFeedEvent.mTargetId);
        if ((this.g.getDataList().size() == 0) && (c() != null)) {
          c().finish();
        }
      }
      else if (paramQCircleFeedEvent.mState == 6)
      {
        a(paramQCircleFeedEvent.mTargetId);
      }
      if (this.g.getDataList().size() == 0)
      {
        paramQCircleFeedEvent = this.b;
        QCircleLayerBean localQCircleLayerBean = this.m;
        if ((localQCircleLayerBean != null) && (localQCircleLayerBean.getExtraTypeInfo() != null) && (this.m.getExtraTypeInfo().sourceType == 10)) {
          paramQCircleFeedEvent.a(this.m, false);
        }
      }
    }
  }
  
  private void a(QCircleStickShareEvent paramQCircleStickShareEvent)
  {
    String str = paramQCircleStickShareEvent.mFeedId;
    FeedCloudMeta.StFeed localStFeed = L();
    if (!TextUtils.isEmpty(str))
    {
      if (localStFeed == null) {
        return;
      }
      if (!TextUtils.equals(str, localStFeed.id.get())) {
        return;
      }
      if ((this.i != null) && (paramQCircleStickShareEvent.mIsContentPage)) {
        this.i.callOnClick();
      }
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QCircleShareInfo paramQCircleShareInfo, QQCircleFeedBase.StFeedBusiReqData paramStFeedBusiReqData)
  {
    for (;;)
    {
      try
      {
        paramStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
        List localList = paramStFeedBusiReqData.uninterest_buttons.get();
        if ((localList == null) || (localList.size() <= 0)) {
          break label91;
        }
        bool = true;
        paramQCircleShareInfo.l = bool;
        if ((paramStFeedBusiReqData.pushList != null) && (QCirclePushInfoManager.a().d(paramStFeed.id.get())))
        {
          paramQCircleShareInfo.n = true;
          a(paramQCircleShareInfo);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
      return;
      label91:
      boolean bool = false;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCircleContentVerticalAdapter localQCircleContentVerticalAdapter = this.g;
    if (localQCircleContentVerticalAdapter != null)
    {
      ArrayList localArrayList = localQCircleContentVerticalAdapter.getDataList();
      if (localArrayList != null)
      {
        int i1 = localArrayList.size() - 1;
        while (i1 >= 0)
        {
          if (paramString.equals(((FeedBlockData)localArrayList.get(i1)).b().poster.id.get())) {
            try
            {
              localQCircleContentVerticalAdapter.delete(i1);
              localQCircleContentVerticalAdapter.notifyItemRemoved(i1);
              return;
            }
            catch (Throwable paramString)
            {
              QLog.e("QCircleContentPart", 1, "onReceiveEvent() delete local feed error!", paramString);
              return;
            }
          }
          i1 -= 1;
        }
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong == 10014L;
  }
  
  private boolean a(ResponseBean paramResponseBean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramResponseBean != null)
    {
      bool1 = bool2;
      if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedListRsp))
      {
        if (((FeedCloudRead.StGetFeedListRsp)paramResponseBean.c).vecFeed.size() == 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if (c() == null) {
      return;
    }
    c().finish();
    int i1;
    if (Math.abs(paramFloat1) <= Math.abs(paramFloat2))
    {
      if (paramFloat2 > 0.0F) {
        i1 = 2130772481;
      } else {
        i1 = 2130772489;
      }
    }
    else if (paramFloat1 > 0.0F) {
      i1 = 2130772452;
    } else {
      i1 = 2130772453;
    }
    int i2 = i1;
    if (paramFloat1 == 0.0F)
    {
      i2 = i1;
      if (paramFloat2 == 0.0F) {
        i2 = 0;
      }
    }
    c().overridePendingTransition(0, i2);
  }
  
  private void b(View paramView)
  {
    this.k = ((QCircleLayerStatusView)paramView.findViewById(2131446655));
    this.k.setOnRetryClickListener(new QCircleContentPart.4(this));
  }
  
  private void b(@NonNull ResponseBean paramResponseBean)
  {
    paramResponseBean = (FeedCloudRead.StGetFeedListRsp)paramResponseBean.c;
    if (paramResponseBean.busiRspData.has())
    {
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(paramResponseBean.busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (localStFeedListBusiRspData.tagPageData.has())
      {
        if (paramResponseBean.vecFeed.size() == 0) {
          this.k.a(true);
        }
        paramResponseBean = localStFeedListBusiRspData.tagPageData.tagDesc.get();
        if (!TextUtils.isEmpty(paramResponseBean)) {
          SimpleEventBus.getInstance().dispatchEvent(new TagDescPublishEvent(paramResponseBean));
        }
      }
      else if (localStFeedListBusiRspData.gpsPageData.has())
      {
        paramResponseBean = localStFeedListBusiRspData.gpsPageData.pageDesc.get();
        if (!TextUtils.isEmpty(paramResponseBean)) {
          SimpleEventBus.getInstance().dispatchEvent(new LbsDescPublishEvent(paramResponseBean));
        }
      }
    }
  }
  
  private void b(List<FeedBlockData> paramList)
  {
    if ((!this.E) && (this.m.getFeed() != null))
    {
      if (TextUtils.isEmpty(this.m.getFeed().id.get())) {
        return;
      }
      int i1 = QCircleFeedDataCenter.a().a(this.m.getFeed().id.get(), paramList);
      if (i1 < 0) {
        return;
      }
      this.F = i1;
      this.f.scrollToPosition(i1);
      this.E = true;
    }
  }
  
  private void s()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    if (!((StringBuilder)localObject1).toString().equalsIgnoreCase("Google")) {
      return;
    }
    localObject1 = this.q;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    if (!(localObject2 instanceof FrameLayout.LayoutParams)) {
      return;
    }
    localObject1 = c();
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return;
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (QCircleLiuHaiUtils.c((Activity)localObject1) + ViewUtils.a(9.0F));
      QLog.d("QCircleContentPart", 1, new Object[] { "[initPixel3XLBarMarginTop] top margin: ", Integer.valueOf(((FrameLayout.LayoutParams)localObject2).topMargin) });
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void t()
  {
    QCircleContentImmersiveEvent.resetImmersive();
    this.x = new ImmersiveEventHelper();
    this.x.a(this.i);
    this.x.a(this.h);
    this.x.a(this.t);
    this.x.a(this.B);
  }
  
  private void u()
  {
    Object localObject = c().getIntent();
    if (localObject == null)
    {
      QLog.w("QCircleContentPart", 1, "[initExtraTypeInfo] intent == null.");
      return;
    }
    localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
    if ((localObject != null) && (((QCircleInitBean)localObject).getTagInfo() != null) && (((QCircleInitBean)localObject).getTagInfo().has())) {
      q().mPlayScene = 3;
    } else {
      q().mPlayScene = 2;
    }
    if ((localObject != null) && (((QCircleInitBean)localObject).getExtraTypeInfo() != null))
    {
      int i1 = ((QCircleInitBean)localObject).getExtraTypeInfo().sourceType;
      if (this.g == null)
      {
        QLog.d("QCircleContentPart", 1, "[initExtraTypeInfo] adapter not is null.");
        return;
      }
      QLog.d("QCircleContentPart", 1, new Object[] { "[initExtraTypeInfo] source type: ", Integer.valueOf(i1) });
      this.g.a(i1);
    }
  }
  
  private boolean v()
  {
    FeedCloudMeta.StFeed localStFeed = L();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localStFeed != null)
    {
      bool1 = bool2;
      if (2 == localStFeed.type.get()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void w()
  {
    if ((c() != null) && (c().getIntent() != null) && ((c().getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleLayerBean)))
    {
      QCircleLayerBean localQCircleLayerBean = (QCircleLayerBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (QCircleTransitionAnimHelper.a(localQCircleLayerBean))
      {
        this.p = new QCircleTransitionAnimHelper(localQCircleLayerBean);
        if (this.p.b() != null)
        {
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
          this.j.addView(this.p.b(), localLayoutParams);
        }
        this.p.a(this);
      }
      if ((localQCircleLayerBean != null) && (localQCircleLayerBean.isUseLoadingPic())) {
        this.z = QCircleTransitionAnimHelper.c();
      }
    }
  }
  
  private void x()
  {
    this.e = QCircleFeedDataCenter.a().c(this.m.getGlobalViewModelKey());
    IDataDisplaySurface localIDataDisplaySurface = this.e;
    if (localIDataDisplaySurface != null)
    {
      if (localIDataDisplaySurface.a(new Object[0]) == null) {
        return;
      }
      this.e.a(new Object[0]).observe(bd_(), new QCircleContentPart.6(this));
      X();
    }
  }
  
  private void y()
  {
    this.b.c().observe(bd_(), new QCircleContentPart.7(this));
  }
  
  private void z()
  {
    QCircleTransitionAnimHelper localQCircleTransitionAnimHelper = this.p;
    if ((localQCircleTransitionAnimHelper != null) && (localQCircleTransitionAnimHelper.b() != null)) {
      this.p.b().setAlpha(0.0F);
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(2));
  }
  
  public String a()
  {
    return "QCircleContentPart";
  }
  
  public ArrayList<FeedBlockData> a(List<FeedBlockData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)paramList.next();
      if ((localFeedBlockData != null) && (localFeedBlockData.b() != null) && (!TextUtils.isEmpty(localFeedBlockData.b().id.get())) && (!localFeedBlockData.b().dittoFeed.has())) {
        localArrayList.add(localFeedBlockData);
      }
    }
    return localArrayList;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    RFThreadManager.getUIHandler().post(new QCircleContentPart.12(this, paramFloat1, paramFloat2));
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject;
    if ((paramView instanceof QCircleTransitionLayout))
    {
      this.s = ((QCircleTransitionLayout)paramView);
      this.u = ((QCircleTransitionInnerLayout)paramView.findViewById(2131433250));
      localObject = this.u;
      if ((localObject != null) && (((QCircleTransitionInnerLayout)localObject).getBackground() != null)) {
        this.u.getBackground().setAlpha(255);
      }
      if ((c() instanceof QCircleFragmentActivity))
      {
        W();
        this.s.a(this.u, new QCircleContentPart.1(this));
      }
      else
      {
        this.s.a();
      }
    }
    this.r = ((QCirclePolyLikeAniView)paramView.findViewById(2131441777));
    this.f = ((RecyclerView)paramView.findViewById(2131445206));
    this.f.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 1, false));
    this.g = new QCircleContentVerticalAdapter(this);
    this.g.a(Q());
    this.g.a(d());
    this.f.setAdapter(this.g);
    this.f.addOnScrollListener(new QCircleContentPart.2(this));
    this.q = ((ViewGroup)paramView.findViewById(2131437471));
    s();
    this.t = ((FrameLayout)paramView.findViewById(2131433302));
    if (QCircleConfigHelper.ao()) {
      localObject = (ViewStub)paramView.findViewById(2131450015);
    } else {
      localObject = (ViewStub)paramView.findViewById(2131450014);
    }
    ((ViewStub)localObject).inflate();
    ((ViewStub)localObject).setVisibility(0);
    this.q = ((ViewGroup)paramView.findViewById(2131437471));
    this.h = ((ImageView)paramView.findViewById(2131436276));
    this.i = ((ImageView)paramView.findViewById(2131436572));
    this.w = ((ProgressBar)paramView.findViewById(2131440909));
    this.B = ((LinearLayout)paramView.findViewById(2131441812));
    if (bd_() != null) {
      bd_().a(this.h);
    }
    this.m = ((QCircleLayerBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    u();
    b(paramView);
    A();
    this.b = ((QCircleContentModel)a(QCircleContentModel.class));
    if ((QCirclePluginConfig.G()) && (!TextUtils.isEmpty(this.m.getGlobalViewModelKey())) && (QCircleFeedDataCenter.a().c(this.m.getGlobalViewModelKey()) != null))
    {
      x();
    }
    else
    {
      O();
      y();
      P();
    }
    if ((paramView instanceof ViewGroup)) {
      this.j = ((ViewGroup)paramView);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    w();
    t();
  }
  
  public boolean ah_()
  {
    QCircleContentVerticalAdapter localQCircleContentVerticalAdapter = this.g;
    if ((localQCircleContentVerticalAdapter != null) && (localQCircleContentVerticalAdapter.a())) {
      return true;
    }
    return super.ah_();
  }
  
  public Object b(String paramString, Object paramObject)
  {
    if ("get_report_extra_type_info".equals(paramString)) {
      return q();
    }
    return super.b(paramString, paramObject);
  }
  
  public void e_(boolean paramBoolean)
  {
    super.e_(paramBoolean);
    if (paramBoolean)
    {
      U();
      return;
    }
    V();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleContentImmersiveEvent.class);
    localArrayList.add(QCircleStickShareEvent.class);
    return localArrayList;
  }
  
  public QCircleTransitionLayout l()
  {
    return this.s;
  }
  
  public void m()
  {
    a(0);
  }
  
  public void n()
  {
    a(0);
  }
  
  public void o()
  {
    a(1);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.f;
    if (paramActivity != null) {
      paramActivity.setAdapter(null);
    }
    paramActivity = this.x;
    if (paramActivity != null) {
      paramActivity.a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QLog.i("QCircleContentPart", 1, "onActivityPaused");
    V();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    U();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleContentImmersiveEvent))
    {
      ImmersiveEventHelper localImmersiveEventHelper = this.x;
      if (localImmersiveEventHelper != null) {
        localImmersiveEventHelper.a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleStickShareEvent))
    {
      a((QCircleStickShareEvent)paramSimpleBaseEvent);
    }
  }
  
  public void p()
  {
    a(1);
  }
  
  public QCircleExtraTypeInfo q()
  {
    if (this.A == null) {
      this.A = new QCircleExtraTypeInfo();
    }
    Object localObject = this.b;
    if ((localObject != null) && (((QCircleContentModel)localObject).d() != null))
    {
      localObject = this.b.d();
      this.A.mDataPosition = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
    }
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart
 * JD-Core Version:    0.7.0.1
 */