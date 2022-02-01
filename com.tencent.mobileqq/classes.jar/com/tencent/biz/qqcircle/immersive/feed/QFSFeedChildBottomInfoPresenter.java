package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.QCirclePolyListShowData;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean.TouchPoint;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils;
import com.tencent.biz.qqcircle.utils.QCirclePoiUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleMarqueeTextView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QFSFeedChildBottomInfoPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener
{
  private LinearLayout i;
  private TextView j;
  private QFSPlusFollowView k;
  private QCircleExpandableTextView l;
  private QCircleMarqueeTextView m;
  private View n;
  private TextView o;
  private View p;
  private TextView q;
  private TextView r;
  private View s;
  private QCircleAvatarListView t;
  private TextView u;
  private QCircleMaxHeightScrollView v;
  
  private String a(FeedCloudMeta.StPushList paramStPushList)
  {
    if (paramStPushList != null) {
      return paramStPushList.jumpUrl.get().replace("{id}", paramStPushList.id.get());
    }
    QLog.e("QFSFeedChildBottomInfoPresenter", 1, "getPushListUrl failed,return empty");
    return "";
  }
  
  private void a(int paramInt)
  {
    if (this.g != null) {
      localObject = this.g.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(paramInt).setSubActionType(2);
    if ((this.g != null) && (this.g.mFeed != null)) {
      localObject = this.g.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    if (this.g != null) {
      paramInt = this.g.mDataPosition;
    } else {
      paramInt = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(paramInt).setPageId(f())));
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(f()).setfpageid(n()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QFSFeedChildBottomInfoPresenter", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramStFeed).setActionType(paramInt1).setSubActionType(paramInt2).setExt1(paramString)).setPageId(f()));
  }
  
  private void a(Context paramContext)
  {
    if (this.c == null)
    {
      QLog.w("QFSFeedChildBottomInfoPresenter", 1, "[jumpLbsPage] invalid data");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.c;
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.gpsInfo = localStFeed.poiInfo.gps;
    localQCirclePolymerizationBean.setFeedListBusiReqData(localStFeedListBusiReqData);
    localQCirclePolymerizationBean.setPolymerizationType(16);
    localQCirclePolymerizationBean.setExt1From(1);
    localQCirclePolymerizationBean.setPoiInfo(localStFeed.poiInfo);
    QCircleLauncher.a(paramContext, localQCirclePolymerizationBean);
  }
  
  private void a(View paramView, String paramString)
  {
    if ((this.h != null) && (this.h.b() != null) && (paramView != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      VideoReport.setElementId(paramView, paramString);
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.h));
      localMap.put("xsj_feed_index", Integer.valueOf(this.d + 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.h.b().id.get());
      VideoReport.setElementReuseIdentifier(paramView, localStringBuilder.toString());
      VideoReport.setElementParams(this, localMap);
      VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    }
  }
  
  private void a(View paramView, String paramString, Map<String, Object> paramMap)
  {
    if ((this.h != null) && (this.c != null) && (paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.h));
      localMap.put("xsj_feed_index", Integer.valueOf(this.d + 1));
      localMap.put("xsj_target_qq", ((FeedCloudMeta.StFeed)this.c).poster.id.get());
      localMap.putAll(paramMap);
      VideoReport.reportEvent(paramString, paramView, localMap);
      return;
    }
    QLog.d("QFSFeedChildBottomInfoPresenter", 1, "dtReportCustomReport : mFeedBlockData, mData, view or eventId is null. ");
  }
  
  private void a(@NonNull QFSPlusFollowView paramQFSPlusFollowView)
  {
    paramQFSPlusFollowView.setItemReportListener(new QFSFeedChildBottomInfoPresenter.1(this, paramQFSPlusFollowView));
  }
  
  private void a(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    QFSPlusFollowView localQFSPlusFollowView = this.k;
    if (localQFSPlusFollowView == null)
    {
      QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[updateAuthorFollowView] author attention view not be null.");
      return;
    }
    localQFSPlusFollowView.setUserData((FeedCloudMeta.StUser)paramStFeed.poster.get(), paramStFeed);
  }
  
  private void a(List<FeedCloudMeta.StUser> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      QCircleAvatarListView localQCircleAvatarListView = this.t;
      if (localQCircleAvatarListView == null) {
        return;
      }
      localQCircleAvatarListView.setData(QCircleAvatarListUtils.a(paramList, 3));
    }
  }
  
  private void a(List<FeedCloudMeta.StUser> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (this.u == null) {
        return;
      }
      if (paramInt > 3)
      {
        paramList = new StringBuilder();
        paramList.append(HardCodeUtil.a(2131896227));
        paramList.append(QCirclePluginUtil.a(paramInt, true));
        paramList.append(HardCodeUtil.a(2131896225));
        paramList = paramList.toString();
      }
      else
      {
        paramList = HardCodeUtil.a(2131896226);
      }
      this.t.measure(0, 0);
      this.u.setText(paramList);
    }
  }
  
  private void a(List<FeedCloudMeta.StUser> paramList, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 != 0) && (paramList != null) && (paramList.size() != 0))
    {
      this.s.setVisibility(0);
      this.s.setOnClickListener(this);
      a(paramList);
      a(paramList, paramInt2);
      return;
    }
    this.s.setVisibility(8);
  }
  
  private boolean a(View paramView, QFSTouchBean.TouchPoint paramTouchPoint)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    if (paramTouchPoint == null) {
      return false;
    }
    float f1 = paramTouchPoint.a();
    float f2 = paramTouchPoint.b();
    paramTouchPoint = new int[2];
    paramView.getLocationOnScreen(paramTouchPoint);
    int i1 = paramTouchPoint[0];
    int i2 = paramTouchPoint[1];
    int i3 = paramView.getMeasuredWidth();
    int i4 = paramView.getMeasuredHeight();
    boolean bool1 = bool2;
    if (f2 >= i2)
    {
      bool1 = bool2;
      if (f2 <= i4 + i2)
      {
        bool1 = bool2;
        if (f1 >= i1)
        {
          bool1 = bool2;
          if (f1 <= i3 + i1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && ((this.a == null) || (this.a.d() != 16)))
    {
      QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
      Object localObject = QCirclePushInfoManager.a().a(paramStFeed.id.get());
      if (localObject != null) {
        localStFeedBusiReqData.pushList.set((MessageMicro)localObject);
      }
      localObject = localStFeedBusiReqData.pushList.vecUser.get();
      int i1;
      if (paramStFeed.opMask2.get().contains(Integer.valueOf(8))) {
        i1 = localStFeedBusiReqData.pushList.totalClickCount.get();
      } else {
        i1 = 0;
      }
      a((List)localObject, i1, localStFeedBusiReqData.pushList.count.get(), a((FeedCloudMeta.StPushList)localStFeedBusiReqData.pushList.get()));
      return;
    }
    this.s.setVisibility(8);
  }
  
  private void c(View paramView)
  {
    if (QCircleConfigHelper.aq() == 1)
    {
      this.k = ((QFSPlusFollowView)paramView.findViewById(2131433357));
      this.k.setFollowedDismiss(true);
      a(this.k);
    }
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (this.s.getVisibility() != 0))
    {
      if (paramStFeed != null)
      {
        Object localObject = QCirclePoiUtils.a(paramStFeed);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.p.setVisibility(8);
        }
        else
        {
          this.p.setVisibility(0);
          this.q.setText((CharSequence)localObject);
          if (!TextUtils.isEmpty(paramStFeed.poiInfo.distanceText.get()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("·");
            ((StringBuilder)localObject).append(paramStFeed.poiInfo.distanceText.get());
            paramStFeed = ((StringBuilder)localObject).toString();
            this.r.setText(paramStFeed);
          }
          else
          {
            this.r.setText("");
          }
          l();
        }
        this.p.setOnClickListener(this);
      }
      return;
    }
    this.p.setVisibility(8);
  }
  
  private void d(View paramView)
  {
    if (this.c == null) {
      return;
    }
    QFSMusicAggregationInitBean localQFSMusicAggregationInitBean = new QFSMusicAggregationInitBean();
    localQFSMusicAggregationInitBean.setFeedMusic((FeedCloudMeta.StFeedMusic)((FeedCloudMeta.StFeed)this.c).musicInfo.get());
    QCircleLauncher.a(paramView.getContext(), localQFSMusicAggregationInitBean);
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (this.n != null))
    {
      if (this.m == null) {
        return;
      }
      if (TextUtils.isEmpty(paramStFeed.musicInfo.musicName.get()))
      {
        this.n.setVisibility(8);
      }
      else
      {
        this.n.setVisibility(0);
        this.m.setText(paramStFeed.musicInfo.musicName.get());
      }
      a(this.n, "em_multimedia_music_bar");
    }
  }
  
  private void e(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    TextView localTextView = this.j;
    if (localTextView == null)
    {
      QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[updateAuthorNameView] author name view should not be null.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(paramStFeed.poster.nick.get());
    localTextView.setText(localStringBuilder.toString());
    a(this.j, "em_xsj_author_name");
  }
  
  private void f(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = this.l;
    if (localObject == null)
    {
      QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[updateFeedPostContentRichText] current feed post content view should be not null.");
      return;
    }
    localObject = ((QCircleExpandableTextView)localObject).getSourceTextView();
    if ((localObject instanceof QCircleAsyncTextView))
    {
      ((TextView)localObject).setTextSize(2, 14.0F);
      ((QCircleAsyncTextView)localObject).setPreloadText("immersive_feed_des_", paramStFeed.content.get());
      ((TextView)localObject).setOnClickListener(new QFSFeedChildBottomInfoPresenter.RichTextSourceClickListener(this, null));
    }
    localObject = this.l.getExpandTextView();
    if (localObject != null) {
      ((TextView)localObject).setTextSize(2, 14.0F);
    }
    this.l.setOnClickHashTagListener(new QFSFeedChildBottomInfoPresenter.RichTextClickHashTagListener(this, null));
    this.l.setSpecialAreaTextColor(2131168464);
    this.l.setNeedSpecialAreaBold(true);
    this.l.setText(paramStFeed.content.get(), false, new QFSFeedChildBottomInfoPresenter.RichTextAtClickListener(this, null));
    this.l.setVisibility(0);
    this.l.setOnClickListener(new QFSFeedChildBottomInfoPresenter.RichTextViewClickListener(this, null));
    this.l.setListener(new QFSFeedChildBottomInfoPresenter.3(this));
    if (TextUtils.isEmpty(paramStFeed.content.get())) {
      this.l.setVisibility(8);
    }
  }
  
  private void k()
  {
    this.l.setOnClickHashTagListener(new QFSFeedChildBottomInfoPresenter.2(this));
    this.n.setOnClickListener(this);
  }
  
  private void l()
  {
    if (b())
    {
      if (this.g != null) {
        localObject = this.g.mFeed;
      } else {
        localObject = null;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(92).setSubActionType(1);
      if ((this.g != null) && (this.g.mFeed != null)) {
        localObject = this.g.mFeed.poster.id.get();
      } else {
        localObject = "";
      }
      Object localObject = localDataBuilder.setToUin((String)localObject);
      int i1;
      if (this.g != null) {
        i1 = this.g.mDataPosition;
      } else {
        i1 = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i1).setPageId(f())));
    }
  }
  
  private void m()
  {
    if (this.a == null)
    {
      QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[openSharePanel] feed ioc should not be null.");
      return;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)this.c).setActionType(43).setSubActionType(2).setIndex(this.d).setPageId(f())));
    QCircleLightInteractListPart.QCirclePolyListShowData localQCirclePolyListShowData = new QCircleLightInteractListPart.QCirclePolyListShowData();
    localQCirclePolyListShowData.b = ((FeedCloudMeta.StFeed)this.c);
    localQCirclePolyListShowData.d = this.d;
    localQCirclePolyListShowData.e = 1;
    this.a.a("event_open_friend_push_panel", new Object[] { localQCirclePolyListShowData });
  }
  
  private int n()
  {
    QCircleReportBean localQCircleReportBean = i();
    if (localQCircleReportBean == null) {
      return 0;
    }
    return localQCircleReportBean.getFromPageId();
  }
  
  private boolean o()
  {
    return (this.c != null) && (2 == ((FeedCloudMeta.StFeed)this.c).type.get());
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.i = ((LinearLayout)paramView.findViewById(2131433365));
    this.j = ((TextView)paramView.findViewById(2131433358));
    this.j.setOnClickListener(this);
    c(paramView);
    this.l = ((QCircleExpandableTextView)paramView.findViewById(2131433368));
    this.v = ((QCircleMaxHeightScrollView)paramView.findViewById(2131442087));
    this.n = paramView.findViewById(2131441961);
    this.m = ((QCircleMarqueeTextView)paramView.findViewById(2131441962));
    this.o = ((TextView)paramView.findViewById(2131433373));
    this.p = paramView.findViewById(2131442008);
    this.q = ((TextView)paramView.findViewById(2131442007));
    this.r = ((TextView)paramView.findViewById(2131441957));
    this.s = paramView.findViewById(2131441967);
    this.t = ((QCircleAvatarListView)paramView.findViewById(2131441964));
    this.u = ((TextView)paramView.findViewById(2131441966));
    k();
    this.v.setMaxHeight((int)(ImmersiveUtils.getScreenHeight() * 0.6F));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    if (paramStFeed == null)
    {
      QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[onBindData] data should not be null.");
      return;
    }
    a(false);
    e(paramStFeed);
    f(paramStFeed);
    d(paramStFeed);
    b(paramStFeed);
    c(paramStFeed);
    a(paramStFeed);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    LinearLayout localLinearLayout = this.i;
    if (localLinearLayout == null) {
      return;
    }
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localLinearLayout.setVisibility(i1);
  }
  
  public boolean a(QFSTouchBean paramQFSTouchBean)
  {
    QCircleExpandableTextView localQCircleExpandableTextView = this.l;
    if (localQCircleExpandableTextView != null)
    {
      boolean bool1 = localQCircleExpandableTextView.a();
      boolean bool2 = a(this.v, paramQFSTouchBean.a());
      return (!bool1) && (bool2);
    }
    return super.a(paramQFSTouchBean);
  }
  
  void b(View paramView)
  {
    if (this.c == null) {
      return;
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFeed((FeedCloudMeta.StFeed)this.c);
    localQCircleInitBean.setUser((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)this.c).poster.get());
    localQCircleInitBean.setFromReportBean(i().clone());
    QCircleLauncher.b(paramView.getContext(), localQCircleInitBean);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.d(paramQFSFeedSelectInfo);
    if (paramQFSFeedSelectInfo.b() != this.d) {}
  }
  
  public void j()
  {
    super.j();
    if (this.g != null) {
      localObject1 = this.g.mFeed;
    } else {
      localObject1 = null;
    }
    Object localObject2 = QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject1).setActionType(81).setSubActionType(1);
    if ((this.g != null) && (this.g.mFeed != null)) {
      localObject1 = this.g.mFeed.poster.id.get();
    } else {
      localObject1 = "";
    }
    localObject2 = ((QCircleLpReportDc05507.DataBuilder)localObject2).setToUin((String)localObject1);
    if (o()) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(((QCircleLpReportDc05507.DataBuilder)localObject2).setExt1((String)localObject1).setPageId(f())));
    Object localObject1 = this.l;
    if (localObject1 != null)
    {
      localObject1 = ((QCircleExpandableTextView)localObject1).getHashTagList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a(16, 1, (FeedCloudMeta.StFeed)this.c, (String)localObject2);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131433358)
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)this.c).setActionType(5).setSubActionType(2).setPosition(this.d).setPageId(f())));
      b(paramView);
    }
    else if (i1 == 2131442008)
    {
      a(paramView.getContext());
      a(92);
    }
    else if (i1 == 2131441967)
    {
      m();
    }
    else if (i1 == 2131441961)
    {
      d(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter
 * JD-Core Version:    0.7.0.1
 */