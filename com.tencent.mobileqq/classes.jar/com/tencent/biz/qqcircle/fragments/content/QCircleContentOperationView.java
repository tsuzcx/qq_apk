package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCirclePoiUtils;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.biz.qqcircle.widgets.QCirclePushBubbleView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class QCircleContentOperationView
  extends QCircleBaseWidgetView<FeedBlockData>
  implements SimpleEventReceiver
{
  private boolean A = false;
  private FrameLayout B;
  private View C;
  private RecyclerView.ViewHolder D;
  private ImmersiveEventHelper E;
  private QCircleMaxHeightScrollView F;
  private int G = 2;
  private View.OnAttachStateChangeListener H;
  private final Rect I = new Rect();
  private LinearLayout J;
  private TextView K;
  private int L = -1;
  protected QCircleAvatarView a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected QCircleFollowView e;
  protected QCircleExpandableTextView f;
  protected QCircleCommentBottomBar g;
  public FrameLayout h;
  public TextView i;
  public int j;
  public int k = -1;
  public FrameLayout l;
  public TextView m;
  public TextView n;
  public LinearLayout o;
  public SeekBar p;
  public View q;
  public QCircleRocketView r;
  public QCirclePushBubbleView s;
  public QCircleDoublePraiseView t;
  protected LinearLayout u;
  protected TextView v;
  protected TextView w;
  protected ImageView x;
  public Point y;
  private QCircleContentOperationView.MyRunnable z;
  
  public QCircleContentOperationView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    if ((getData() != null) && (((FeedBlockData)getData()).b().poster.get() != null))
    {
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUin(((FeedBlockData)getData()).b().poster.id.get());
      localQCircleInitBean.setFromReportBean(getReportBean().clone());
      QCircleLauncher.b(getContext(), localQCircleInitBean);
      a(paramInt, 2, getExtraTypeInfo(), "");
    }
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleContentOperationView", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramStFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setExt3(paramString).setPageId(getPageId()).setfpageid(getParentPageId()));
  }
  
  private void a(Context paramContext)
  {
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)getData()).b();
    if (localStFeed == null)
    {
      QLog.w("QCircleContentOperationView", 1, "feed is null");
      return;
    }
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.gpsInfo = localStFeed.poiInfo.gps;
    localQCirclePolymerizationBean.setFeedListBusiReqData(localStFeedListBusiReqData);
    localQCirclePolymerizationBean.setFromReportBean(getReportBean().clone());
    localQCirclePolymerizationBean.setPolymerizationType(16);
    localQCirclePolymerizationBean.setExt1From(1);
    localQCirclePolymerizationBean.setPoiInfo(localStFeed.poiInfo);
    QCircleLauncher.a(paramContext, localQCirclePolymerizationBean);
    a(93, 2, getExtraTypeInfo(), "");
  }
  
  private void a(View paramView, int paramInt)
  {
    ImmersiveEventHelper localImmersiveEventHelper = this.E;
    if ((localImmersiveEventHelper != null) && (paramView != null))
    {
      localImmersiveEventHelper.b(paramView);
      this.E.a(paramView, paramInt);
    }
  }
  
  private void a(FeedBlockData paramFeedBlockData)
  {
    VideoReport.setElementId(this, "em_xsj_feed");
    Object localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).putAll(QCirclePluginReportUtil.a(paramFeedBlockData));
    VideoReport.setElementParams(this, (Map)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("em_xsj_feed_");
    ((StringBuilder)localObject).append(paramFeedBlockData.hashCode());
    VideoReport.setElementReuseIdentifier(this, ((StringBuilder)localObject).toString());
    VideoReport.traverseExposure();
  }
  
  private void a(String paramString)
  {
    if ((getContext() instanceof LifecycleOwner)) {
      QCircleFeedDataCenter.a().a(paramString, new QCircleContentOperationView.FeedStateObserver(this));
    }
  }
  
  private void a(View... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      boolean bool = QCircleContentImmersiveEvent.isImmersive();
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = paramVarArgs[i1];
        if (localView != null) {
          if (bool) {
            localView.setVisibility(8);
          } else {
            localView.setVisibility(0);
          }
        }
        i1 += 1;
      }
      return;
    }
    QLog.d("QCircleContentOperationView", 1, "[updateImmersiveVisible] view array not is null.");
  }
  
  private boolean a(QQCircleFeedBase.StSimulateData paramStSimulateData)
  {
    boolean bool = true;
    if ((paramStSimulateData != null) && (paramStSimulateData.is_show_button.get() == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      paramStSimulateData = this.u;
      if (paramStSimulateData == null) {
        return bool;
      }
      if (paramStSimulateData.getVisibility() != 0) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private int b(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0) && (paramInt <= paramView.getHeight() + ViewUtils.a(39.0F))) {
      return paramView.getHeight() + ViewUtils.a(47.0F);
    }
    return paramInt;
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    int i1 = paramStFeed.type.get();
    if (i1 != 2)
    {
      if (i1 != 3) {
        return;
      }
      b(paramStFeed);
      return;
    }
    a(paramStFeed);
  }
  
  private void d()
  {
    this.E = new ImmersiveEventHelper();
    this.E.a(this.F);
    this.E.a(this.h);
    this.E.a(this.J);
    this.E.a(this.u);
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    QCirclePushBubbleView localQCirclePushBubbleView = this.s;
    if (localQCirclePushBubbleView != null)
    {
      localQCirclePushBubbleView.setFeed(paramStFeed);
      this.s.setInteractor(getInteractor());
      this.s.setPageType(2);
      this.s.setExtraTypeInfo(getExtraTypeInfo());
    }
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(QCirclePoiUtils.a(getCurrentFeed())))
    {
      LinearLayout localLinearLayout = this.u;
      if (localLinearLayout != null)
      {
        localLinearLayout.setVisibility(8);
        return;
      }
    }
    a(new View[] { this.u });
  }
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.t != null)
    {
      m(paramStFeed);
      this.t.setFeed(paramStFeed);
      this.t.setPageType(getPageId());
    }
  }
  
  private void f(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((this.u != null) && (this.v != null) && (this.x != null))
    {
      paramStFeed = QCirclePoiUtils.a(paramStFeed);
      if (TextUtils.isEmpty(paramStFeed))
      {
        this.u.setVisibility(8);
        this.x.setVisibility(8);
        a(this.u, 8);
        return;
      }
      a(new View[] { this.u, this.x });
      this.v.setText(paramStFeed);
      a(this.u, 0);
    }
  }
  
  private boolean f()
  {
    Object localObject = getData();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (2 == ((FeedBlockData)getData()).b().type.get()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void g()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    QCircleInitBean localQCircleInitBean = (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
    int i2 = ViewUtils.a(42.0F);
    int i1 = i2;
    if (localQCircleInitBean != null) {
      if (localQCircleInitBean.getTagInfo().has())
      {
        i1 = b(((Activity)getContext()).findViewById(2131445034), i2);
      }
      else
      {
        i1 = i2;
        if (localQCircleInitBean.getPoiInfo() != null)
        {
          i1 = i2;
          if (localQCircleInitBean.getPoiInfo().has()) {
            i1 = b(((Activity)getContext()).findViewById(2131444976), i2);
          }
        }
      }
    }
    localLayoutParams.setMargins(ViewUtils.a(20.0F), i1, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    if (QCircleConfigHelper.ao())
    {
      localLayoutParams.gravity = 1;
      localLayoutParams.setMargins(ViewUtils.a(0.0F), i1, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      localLayoutParams.height = ViewUtils.a(22.0F);
    }
    this.h.setLayoutParams(localLayoutParams);
  }
  
  private void g(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = this.w;
    if (localObject == null)
    {
      QLog.w("QCircleContentOperationView", 1, "[updateDistanceInfo] distance view not is null.");
      return;
    }
    if (((TextView)localObject).getVisibility() == 0) {
      this.w.setVisibility(8);
    }
    if (this.L != 5)
    {
      QLog.d("QCircleContentOperationView", 1, "[updateDistanceInfo] source type not is city page.");
      return;
    }
    if ((paramStFeed.poiInfo != null) && (paramStFeed.poiInfo.distanceText != null)) {
      localObject = paramStFeed.poiInfo.distanceText.get();
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d("QCircleContentOperationView", 1, "[updateDistanceInfo] distance text not is empty.");
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(QCirclePoiUtils.a(paramStFeed)))
    {
      localSpannableStringBuilder.append("·");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-1), 0, 1, 33);
    }
    localSpannableStringBuilder.append((CharSequence)localObject);
    boolean bool = QCircleContentImmersiveEvent.isImmersive();
    paramStFeed = new StringBuilder();
    paramStFeed.append((String)localObject);
    paramStFeed.append(" | feed id: ");
    paramStFeed.append(getCurrentFeedId());
    QLog.d("QCircleContentOperationView", 1, new Object[] { "[updateDistanceInfo] distance text: ", paramStFeed.toString(), " | isImmersive: ", Boolean.valueOf(bool) });
    this.w.setText(localSpannableStringBuilder);
    this.w.setVisibility(0);
    a(this.u, 0);
    paramStFeed = this.u;
    if (paramStFeed != null) {
      a(new View[] { paramStFeed });
    }
  }
  
  private FeedCloudMeta.StFeed getCurrentFeed()
  {
    FeedBlockData localFeedBlockData = (FeedBlockData)getData();
    if (localFeedBlockData == null) {
      return null;
    }
    return localFeedBlockData.b();
  }
  
  private String getCurrentFeedId()
  {
    FeedCloudMeta.StFeed localStFeed = getCurrentFeed();
    if (localStFeed == null) {
      return "";
    }
    return localStFeed.id.get();
  }
  
  private void h()
  {
    this.a.setOnClickListener(new QCircleContentOperationView.5(this));
    this.b.setOnClickListener(new QCircleContentOperationView.6(this));
    this.e.setItemReportListener(new QCircleContentOperationView.7(this));
    Object localObject = new QCircleContentOperationView.8(this);
    this.f.setListener(new QCircleContentOperationView.9(this, (View.OnClickListener)localObject));
    this.f.getSourceTextView().setOnClickListener((View.OnClickListener)localObject);
    localObject = this.l;
    if (localObject != null)
    {
      ((FrameLayout)localObject).setOnClickListener(new QCircleContentOperationView.10(this));
      this.l.setOnLongClickListener(new QCircleContentOperationView.11(this));
      this.l.setOnTouchListener(new QCircleContentOperationView.12(this));
    }
    this.u.setOnClickListener(new QCircleContentOperationView.13(this));
  }
  
  private void h(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleRocketView localQCircleRocketView = this.r;
    if (localQCircleRocketView != null)
    {
      localQCircleRocketView.setFeedId(paramStFeed.id.get());
      this.r.setPageType(2);
    }
  }
  
  private void i(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleFollowView localQCircleFollowView = this.e;
    if (localQCircleFollowView != null) {
      localQCircleFollowView.setUserData(paramStFeed.poster, paramStFeed);
    }
  }
  
  private boolean i()
  {
    Object localObject = getContext();
    boolean bool1 = localObject instanceof Activity;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    localObject = ((Activity)localObject).findViewById(2131436572);
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((View)localObject).callOnClick()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void j()
  {
    if (this.A)
    {
      getMainHandler().removeCallbacks(this.z);
      if (getCurrentFeed() != null)
      {
        String str = getCurrentFeed().id.get();
        int i1 = getPageId();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleDoublePraiseAnimationEvent(str, i1, 0));
        this.A = false;
      }
    }
    else
    {
      this.A = true;
      if (this.z == null) {
        this.z = new QCircleContentOperationView.MyRunnable(this, null);
      }
      getMainHandler().postDelayed(this.z, 300L);
    }
  }
  
  private void j(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleCommentBottomBar localQCircleCommentBottomBar = this.g;
    if (localQCircleCommentBottomBar != null)
    {
      localQCircleCommentBottomBar.setExtraTypeInfo(getExtraTypeInfo());
      this.g.setInteractor(getInteractor());
      this.g.setData(paramStFeed);
    }
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(QCirclePoiUtils.a(getCurrentFeed())))
    {
      QLog.d("QCircleContentOperationView", 1, "[handleCallToLbsPolymerization] current poi name not is null.");
      return;
    }
    a(getContext());
  }
  
  private void k(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.d != null)
    {
      if (!TextUtils.isEmpty(paramStFeed.recomInfo.recomReason.get()))
      {
        TextView localTextView = this.c;
        if ((localTextView == null) || (localTextView.getVisibility() != 0))
        {
          this.d.setVisibility(0);
          this.d.setText(paramStFeed.recomInfo.recomReason.get());
          return;
        }
      }
      this.d.setVisibility(8);
    }
  }
  
  private void l()
  {
    if (!c())
    {
      QCircleExpandableTextView localQCircleExpandableTextView = this.f;
      if (localQCircleExpandableTextView != null)
      {
        if ((localQCircleExpandableTextView.getSourceTextView() instanceof QCircleAsyncTextView)) {
          ((QCircleAsyncTextView)this.f.getSourceTextView()).setPreloadText("layer_feed_title_", ((FeedBlockData)getData()).b().content.get());
        }
        this.f.setText(((FeedBlockData)getData()).b().content.get(), false, new QCircleContentOperationView.14(this));
      }
    }
  }
  
  private void l(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((QCircleAvatarView)localObject).setUser(paramStFeed.poster);
    }
    localObject = this.b;
    if (localObject != null) {
      ((TextView)localObject).setText(paramStFeed.poster.nick.get());
    }
    localObject = paramStFeed.opMask2.get();
    if (this.c != null)
    {
      if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(9))))
      {
        this.c.setVisibility(8);
        return;
      }
      this.c.setVisibility(0);
      this.c.setText(QCirclePluginUtil.a(paramStFeed.createTime.get() * 1000L));
    }
  }
  
  private void m(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    int i2 = paramStFeed.type.get();
    int i1 = 0;
    if (i2 != 2)
    {
      if (i2 == 3)
      {
        i1 = paramStFeed.cover.width.get();
        i2 = paramStFeed.cover.height.get();
        break label115;
      }
    }
    else
    {
      i2 = this.k;
      if ((i2 >= 0) && (i2 < paramStFeed.images.size()))
      {
        paramStFeed = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.k)).get();
        i1 = paramStFeed.width.get();
        i2 = paramStFeed.height.get();
        break label115;
      }
    }
    i2 = 0;
    label115:
    if (i2 > 0)
    {
      if (i1 <= 0) {
        return;
      }
      int i3 = ImmersiveUtils.b();
      i1 = (int)(i3 / i1 * i2);
      paramStFeed = (FrameLayout.LayoutParams)this.t.getLayoutParams();
      paramStFeed.width = i3;
      paramStFeed.height = i1;
      paramStFeed.gravity = 17;
      this.t.setLayoutParams(paramStFeed);
    }
  }
  
  private void setFeedContent(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleExpandableTextView localQCircleExpandableTextView = this.f;
    if (localQCircleExpandableTextView != null)
    {
      int i1;
      if (StringUtil.a(paramStFeed.content.get().trim())) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      localQCircleExpandableTextView.setVisibility(i1);
      this.E.a(this.f);
      this.f.setOnClickHashTagListener(new QCircleContentOperationView.2(this, paramStFeed));
      if (this.H == null)
      {
        this.H = new QCircleContentOperationView.3(this, paramStFeed);
        this.f.addOnAttachStateChangeListener(this.H);
      }
      this.f.setNeedSpecialAreaBold(true);
      if ((this.f.getSourceTextView() instanceof QCircleAsyncTextView)) {
        ((QCircleAsyncTextView)this.f.getSourceTextView()).setPreloadText("layer_feed_title_", paramStFeed.content.get());
      }
      this.f.setText(paramStFeed.content.get(), new QCircleContentOperationView.4(this));
    }
  }
  
  protected void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData == null)
    {
      QLog.w("QCircleContentOperationView", 1, "[bindData] block data not is null.");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    if (localStFeed == null)
    {
      QLog.d("QCircleContentOperationView", 1, "[bindData] feed not is null.");
      return;
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    l(localStFeed);
    k(localStFeed);
    setFeedContent(localStFeed);
    j(localStFeed);
    i(localStFeed);
    h(localStFeed);
    f(localStFeed);
    g(localStFeed);
    e(localStFeed);
    d(localStFeed);
    c(localStFeed);
    a(paramFeedBlockData);
    a(localStFeed.id.get());
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject1 = this.l;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setVisibility(8);
    }
    localObject1 = this.B;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setVisibility(8);
    }
    localObject1 = this.o;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).setVisibility(8);
    }
    Object localObject2;
    if (this.h != null)
    {
      if (paramStFeed == null) {
        localObject1 = null;
      } else {
        localObject1 = paramStFeed.images.get();
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 1))
      {
        localObject2 = this.E;
        if (localObject2 != null) {
          ((ImmersiveEventHelper)localObject2).a(this.h, 0);
        }
        a(new View[] { this.h });
      }
      else
      {
        this.h.setVisibility(8);
        localObject2 = this.E;
        if (localObject2 != null) {
          ((ImmersiveEventHelper)localObject2).b(this.h);
        }
      }
      setAllPicCount(((List)localObject1).size());
      if (paramStFeed != null) {
        setCurPicPos(QCircleFeedDataCenter.a().b(paramStFeed.id.get()));
      }
    }
    if ((this.J != null) && (this.K != null) && (this.k < paramStFeed.images.size())) {}
    for (;;)
    {
      try
      {
        localObject1 = new QQCircleFeedBase.StImageBusiData();
        ((QQCircleFeedBase.StImageBusiData)localObject1).mergeFrom(((FeedCloudMeta.StImage)paramStFeed.images.get(this.k)).busiData.get().toByteArray());
        if (a(((QQCircleFeedBase.StImageBusiData)localObject1).simulate_date))
        {
          this.J.setVisibility(0);
          paramStFeed = this.K;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((QQCircleFeedBase.StImageBusiData)localObject1).simulate_date.simulate_name.get());
          ((StringBuilder)localObject2).append("    ");
          paramStFeed.setText(((StringBuilder)localObject2).toString());
          this.J.setOnClickListener(new QCircleContentOperationView.15(this, (QQCircleFeedBase.StImageBusiData)localObject1));
          localObject1 = getExtraTypeInfo();
          if (!f()) {
            break label383;
          }
          paramStFeed = "1";
          a(83, 1, (QCircleExtraTypeInfo)localObject1, paramStFeed);
        }
        else
        {
          this.J.setVisibility(8);
        }
        this.E.a(this.J);
        return;
      }
      catch (Exception paramStFeed)
      {
        QLog.e("QCircleContentOperationView", 1, "exception:", paramStFeed);
      }
      return;
      label383:
      paramStFeed = "2";
    }
  }
  
  public boolean a()
  {
    QCircleCommentBottomBar localQCircleCommentBottomBar = this.g;
    return (localQCircleCommentBottomBar != null) && (localQCircleCommentBottomBar.b());
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    FrameLayout localFrameLayout = this.B;
    if (localFrameLayout != null)
    {
      localFrameLayout.getGlobalVisibleRect(this.I);
      return this.I.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public void b()
  {
    if ((getInteractor() instanceof QCircleInteractor)) {
      ((QCircleInteractor)getInteractor()).a("comment_panel_dismiss", null);
    }
    this.k = 0;
    l();
    this.D = null;
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.E;
    if (localObject != null) {
      ((ImmersiveEventHelper)localObject).b(this.h);
    }
    localObject = this.B;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 8)) {
      this.B.setVisibility(0);
    }
    if ((this.J != null) && (this.K != null)) {}
    for (;;)
    {
      try
      {
        localObject = new QQCircleFeedBase.StVideoBusiData();
        ((QQCircleFeedBase.StVideoBusiData)localObject).mergeFrom(paramStFeed.video.busiData.get().toByteArray());
        if (a(((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date))
        {
          paramStFeed = this.K;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.simulate_name.get());
          localStringBuilder.append("    ");
          paramStFeed.setText(localStringBuilder.toString());
          this.J.setVisibility(0);
          this.J.setOnClickListener(new QCircleContentOperationView.16(this, (QQCircleFeedBase.StVideoBusiData)localObject));
          localObject = getExtraTypeInfo();
          if (!f()) {
            break label248;
          }
          paramStFeed = "1";
          a(83, 1, (QCircleExtraTypeInfo)localObject, paramStFeed);
        }
        else
        {
          this.J.setVisibility(8);
        }
        if (this.E != null)
        {
          this.E.a(this.J);
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        QLog.e("QCircleContentOperationView", 1, "exception:", paramStFeed);
      }
      return;
      label248:
      paramStFeed = "2";
    }
  }
  
  public boolean c()
  {
    QCircleExpandableTextView localQCircleExpandableTextView = this.f;
    if (localQCircleExpandableTextView != null) {
      return localQCircleExpandableTextView.a();
    }
    return false;
  }
  
  public int getCurrentPicPos()
  {
    return this.k;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleContentImmersiveEvent.class);
    return localArrayList;
  }
  
  public QCircleExtraTypeInfo getExtraTypeInfo()
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.mFeed = ((FeedBlockData)getData()).b();
    localQCircleExtraTypeInfo.mDataPosition = getDataPosInList();
    localQCircleExtraTypeInfo.mPlayScene = this.G;
    return localQCircleExtraTypeInfo;
  }
  
  public int getLayoutId()
  {
    return 2131626786;
  }
  
  protected String getLogTag()
  {
    return "QCircleContentOperationView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    if (this.E != null) {
      if (QCircleContentImmersiveEvent.isImmersive()) {
        this.E.a(3);
      } else {
        this.E.a(2);
      }
    }
    e();
    if (this.u.getVisibility() == 0) {
      a(92, 1, getExtraTypeInfo(), "");
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = getExtraTypeInfo();
    String str;
    if (f()) {
      str = "1";
    } else {
      str = "2";
    }
    a(81, 1, localQCircleExtraTypeInfo, str);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.r = ((QCircleRocketView)paramView.findViewById(2131441865));
    this.a = ((QCircleAvatarView)paramView.findViewById(2131436644));
    this.b = ((TextView)paramView.findViewById(2131448853));
    this.C = paramView.findViewById(2131429713);
    this.c = ((TextView)paramView.findViewById(2131448855));
    this.d = ((TextView)paramView.findViewById(2131448694));
    this.e = ((QCircleFollowView)paramView.findViewById(2131433493));
    this.f = ((QCircleExpandableTextView)paramView.findViewById(2131441913));
    this.f.setSpecialAreaTextColor(2131167079);
    this.F = ((QCircleMaxHeightScrollView)paramView.findViewById(2131442087));
    this.F.setMaxHeight((int)(ImmersiveUtils.c() * 0.6F));
    this.g = ((QCircleCommentBottomBar)paramView.findViewById(2131430422));
    this.g.a();
    this.h = ((FrameLayout)paramView.findViewById(2131441797));
    this.i = ((TextView)paramView.findViewById(2131441798));
    this.l = ((FrameLayout)paramView.findViewById(2131433279));
    this.l.getLayoutParams().width = (ImmersiveUtils.b() * 3 / 5);
    this.l.getLayoutParams().height = (ImmersiveUtils.b() * 2 / 5);
    this.m = ((TextView)paramView.findViewById(2131448364));
    this.n = ((TextView)paramView.findViewById(2131448828));
    this.o = ((LinearLayout)paramView.findViewById(2131437579));
    this.p = ((SeekBar)paramView.findViewById(2131445502));
    this.B = ((FrameLayout)paramView.findViewById(2131433293));
    this.B.setOnTouchListener(new QCircleContentOperationView.1(this));
    this.q = paramView.findViewById(2131441605);
    this.e.setFollowedDismiss(true);
    this.e.setDtParentEmId("em_xsj_feed");
    this.r.setPageType(2);
    this.t = ((QCircleDoublePraiseView)paramView.findViewById(2131441611));
    this.s = ((QCirclePushBubbleView)paramView.findViewById(2131441825));
    this.J = ((LinearLayout)paramView.findViewById(2131441763));
    this.K = ((TextView)paramView.findViewById(2131441764));
    this.u = ((LinearLayout)paramView.findViewById(2131441726));
    this.v = ((TextView)paramView.findViewById(2131441908));
    this.w = ((TextView)paramView.findViewById(2131441760));
    this.x = ((ImageView)paramView.findViewById(2131441702));
    h();
    d();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleContentImmersiveEvent))
    {
      ImmersiveEventHelper localImmersiveEventHelper = this.E;
      if (localImmersiveEventHelper != null) {
        localImmersiveEventHelper.a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
      }
      e();
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.g;
    if (localObject != null) {
      ((QCircleCommentBottomBar)localObject).release();
    }
    localObject = this.E;
    if (localObject != null)
    {
      ((ImmersiveEventHelper)localObject).a();
      this.E = null;
    }
    if (this.z != null)
    {
      getMainHandler().removeCallbacks(this.z);
      this.z = null;
    }
  }
  
  public void setAllPicCount(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setCurPicPos(int paramInt)
  {
    if ((this.i != null) && (paramInt >= 0) && (this.j > paramInt))
    {
      this.k = paramInt;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.k + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.j);
      localObject = ((StringBuilder)localObject).toString();
      if (!((String)localObject).contentEquals(this.i.getText()))
      {
        this.i.setText((CharSequence)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[setCurPicPos] text: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" | mTvCurrentPos: ");
        localStringBuilder.append(this.i.hashCode());
        QLog.d("QCircleContentOperationView", 1, localStringBuilder.toString());
        g();
      }
    }
  }
  
  public void setCurrentHorizontalVH(RecyclerView.ViewHolder paramViewHolder)
  {
    this.D = paramViewHolder;
  }
  
  public void setPlayScene(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    paramQCircleReportBean = this.g;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.setReportBean(getReportBean());
    }
    paramQCircleReportBean = this.t;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.setReportBean(getReportBean());
    }
    paramQCircleReportBean = this.s;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.setReportBean(getReportBean());
    }
  }
  
  public void setSourceType(int paramInt)
  {
    this.L = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView
 * JD-Core Version:    0.7.0.1
 */