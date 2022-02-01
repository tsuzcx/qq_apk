package com.tencent.biz.qqcircle.fragments.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Value;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ChatActivityConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCirclePersonDetailClick;
import com.tencent.biz.qqcircle.beans.QCircleAchievementInfo;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl;
import com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderRankListControl;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleTextUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.biz.qqcircle.widgets.QCircleTagListView;
import com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView;
import com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFollowRecomInfo;
import feedcloud.FeedCloudMeta.StFollowUser;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleBase.CircleAchievement;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import qqcircle.QQCircleProfile.StProfileBizData;

public class QCirclePersonInfoWidget
  extends QCircleBaseWidgetView
  implements View.OnClickListener, SimpleEventReceiver
{
  private SquareImageView A;
  private TextView B;
  private ImageView C;
  private TextView D;
  private long E;
  private int F;
  private long G;
  private List<QQCircleBase.UserCircleInfo> H;
  private List<QQCircleBase.UserCircleInfo> I;
  private List<QQCircleBase.UserCircleInfo> J;
  private String K = "";
  private QCircleGuideBubbleView L;
  private QCircleTailExpandText M;
  private ImageView N;
  private TextView O;
  private ImageView P;
  private LinearLayout Q;
  private LinearLayout R;
  private RelativeLayout S;
  private Context a;
  private FeedCloudMeta.StFeed b;
  private volatile String c;
  private volatile byte[] d = null;
  private FeedCloudMeta.StUser e;
  private QQCircleBase.StUserBusiData f;
  private FeedCloudRead.StGetMainPageRsp g;
  private QQCircleFeedBase.StMainPageBusiRspData h;
  private QCirclePersonInfoWidget.HeaderClickListener i;
  private TextView j;
  private ImageView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private LinearLayout o;
  private LinearLayout p;
  private LinearLayout q;
  private QCircleAvatarView r;
  private QCircleTagListView s;
  private QCircleTroopTagListView t;
  private LinearLayout u;
  private QCircleFollowView v;
  private TextView w;
  private TextView x;
  private QCirclePersonHeaderPymkControl y;
  private QCirclePersonHeaderRankListControl z;
  
  static {}
  
  public QCirclePersonInfoWidget(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.a = paramContext;
  }
  
  private int a(TextView paramTextView)
  {
    if (paramTextView.getText() == null) {
      return 0;
    }
    return paramTextView.getText().toString().length();
  }
  
  private void a()
  {
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.P.setOnClickListener(this);
    b();
    this.t.a(new QCirclePersonInfoWidget.1(this));
  }
  
  private void a(int paramInt)
  {
    this.F = paramInt;
    this.n.setText(QCirclePluginUtil.d(paramInt));
    m();
  }
  
  private void a(long paramLong)
  {
    this.E = paramLong;
    this.m.setText(QCirclePluginUtil.d(paramLong));
    m();
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i1 = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" / ");
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(2131167085)), i1, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(View paramView)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (paramView == null) {
        return;
      }
      if (!QCirclePluginUtil.d(((FeedCloudMeta.StUser)localObject).id.get())) {
        return;
      }
      if (b(paramView)) {
        return;
      }
      if (!QCircleFlutterUtils.a())
      {
        c(paramView);
        return;
      }
      localObject = new QCircleEditProfileBean();
      ((QCircleEditProfileBean)localObject).setHostUin(this.e.id.get());
      ((QCircleEditProfileBean)localObject).setNick(this.e.nick.get());
      ((QCircleEditProfileBean)localObject).setGender(this.e.sex.get());
      ((QCircleEditProfileBean)localObject).setConstellation(this.e.constellation.get());
      ((QCircleEditProfileBean)localObject).setLocation(QCircleTextUtils.a(this.e.location.get()));
      ((QCircleEditProfileBean)localObject).setLocationCode(this.e.locationCode.get());
      ((QCircleEditProfileBean)localObject).setDesc(this.e.desc.get());
      List localList = this.I;
      if ((localList != null) && (localList.size() > 0)) {
        ((QCircleEditProfileBean)localObject).setSchool(((QQCircleBase.UserCircleInfo)this.I.get(0)).name.get());
      }
      localList = this.J;
      if ((localList != null) && (localList.size() > 0)) {
        ((QCircleEditProfileBean)localObject).setCompany(((QQCircleBase.UserCircleInfo)this.J.get(0)).name.get());
      }
      QCircleFlutterLauncher.a(paramView.getContext(), (QCircleEditProfileBean)localObject);
    }
  }
  
  private void a(QCirclePersonEditUpdateEvent paramQCirclePersonEditUpdateEvent)
  {
    if (paramQCirclePersonEditUpdateEvent.getNick() != null)
    {
      this.e.nick.set(paramQCirclePersonEditUpdateEvent.getNick());
      this.j.setText(this.e.nick.get());
    }
    if (paramQCirclePersonEditUpdateEvent.getGender() != 0)
    {
      this.e.sex.set(paramQCirclePersonEditUpdateEvent.getGender());
      c(this.e);
    }
    if (paramQCirclePersonEditUpdateEvent.getConstellation() != 0)
    {
      this.e.constellation.set(paramQCirclePersonEditUpdateEvent.getConstellation());
      c(this.e);
    }
    Object localObject;
    if (paramQCirclePersonEditUpdateEvent.getSchool() != null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (((QQCircleBase.StUserBusiData)localObject).schoolInfos.size() > 0)
        {
          ((QQCircleBase.UserCircleInfo)this.f.schoolInfos.get(0)).name.set(paramQCirclePersonEditUpdateEvent.getSchool());
        }
        else
        {
          localObject = new QQCircleBase.UserCircleInfo();
          ((QQCircleBase.UserCircleInfo)localObject).name.set(paramQCirclePersonEditUpdateEvent.getSchool());
          this.f.schoolInfos.add((MessageMicro)localObject);
        }
        c(this.e);
      }
    }
    if (paramQCirclePersonEditUpdateEvent.getCompany() != null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (((QQCircleBase.StUserBusiData)localObject).companyInfos.size() > 0)
        {
          ((QQCircleBase.UserCircleInfo)this.f.companyInfos.get(0)).name.set(paramQCirclePersonEditUpdateEvent.getCompany());
        }
        else
        {
          localObject = new QQCircleBase.UserCircleInfo();
          ((QQCircleBase.UserCircleInfo)localObject).name.set(paramQCirclePersonEditUpdateEvent.getCompany());
          this.f.companyInfos.add((MessageMicro)localObject);
        }
        c(this.e);
      }
    }
    if (paramQCirclePersonEditUpdateEvent.getLocation() != null)
    {
      this.e.location.set(paramQCirclePersonEditUpdateEvent.getLocation());
      if (paramQCirclePersonEditUpdateEvent.getLocationCode() != null) {
        this.e.locationCode.set(paramQCirclePersonEditUpdateEvent.getLocationCode());
      }
      c(this.e);
    }
    if (paramQCirclePersonEditUpdateEvent.getDesc() != null)
    {
      this.e.desc.set(paramQCirclePersonEditUpdateEvent.getDesc());
      a(this.e);
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.desc.get())))
    {
      VideoReport.setElementId(this.M, "em_xsj_personal_profile");
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      VideoReport.setElementParams(this.M, localMap);
      this.M.setOnExpandCallback(new QCirclePersonInfoWidget.4(this));
      this.M.setVisibility(0);
      this.M.setContent(paramStUser.desc.get());
      return;
    }
    this.M.setVisibility(8);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser, SpannableStringBuilder paramSpannableStringBuilder, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && (paramSpannableStringBuilder.length() > 3))
    {
      a(paramStringBuilder, paramBoolean, paramSpannableStringBuilder);
      paramStringBuilder = this.k;
      int i1;
      if (paramStUser.sex.get() == 1) {
        i1 = 2130845253;
      } else {
        i1 = 2130845252;
      }
      paramStringBuilder.setImageResource(i1);
      this.k.setVisibility(0);
      this.D.setText(paramSpannableStringBuilder);
      this.D.setVisibility(0);
      this.D.setMovementMethod(LinkMovementMethod.getInstance());
      this.R.setVisibility(0);
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, new Object[] { paramSpannableStringBuilder });
      return;
    }
    this.D.setVisibility(8);
    this.k.setVisibility(8);
    this.R.setVisibility(8);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    this.f = null;
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nickName is");
      ((StringBuilder)localObject).append(paramStUser.nick.get());
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject).toString());
      this.j.setText(paramStUser.nick.get());
      this.r.setUser(paramStUser);
      if ((paramStUser.busiData.has()) && (paramStUser.busiData.get() != null))
      {
        localObject = new QQCircleBase.StUserBusiData();
        try
        {
          ((QQCircleBase.StUserBusiData)localObject).mergeFrom(paramStUser.busiData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        this.f = ((QQCircleBase.StUserBusiData)localObject);
        b(this.f.fuelValue.get());
      }
      b(paramStUser, paramStMainPageBusiRspData);
      a(paramStUser);
      b(paramStUser);
      d();
      e();
      c(paramStUser);
      f();
      setAchievementLabel(paramStUser.id.get());
      localObject = this.f;
      if ((localObject != null) && (((QQCircleBase.StUserBusiData)localObject).achievement.rocketToast.get() == 1)) {
        i();
      }
      a(paramStMainPageBusiRspData);
      b(paramStMainPageBusiRspData);
      d(paramStUser);
    }
  }
  
  private void a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (!g())
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "[updateRankTagList] current no switch rank list.");
      return;
    }
    QCirclePersonHeaderRankListControl localQCirclePersonHeaderRankListControl = this.z;
    if (localQCirclePersonHeaderRankListControl == null)
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "[updateRankTagList] persona header rank list control not is null.");
      return;
    }
    localQCirclePersonHeaderRankListControl.a(paramStGetMainPageRsp);
  }
  
  private void a(StringBuilder paramStringBuilder, boolean paramBoolean, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramBoolean) && (paramStringBuilder.length() > 0))
    {
      QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.id.get()).setActionType(11).setSubActionType(51).setThrActionType(1);
      String str;
      if (QCirclePluginUtil.b(this.e)) {
        str = "1";
      } else {
        str = "2";
      }
      QCircleLpReportDc05504.report(localDataBuilder.setExt6(str).setExt7(paramStringBuilder.toString()));
      int i1 = 3;
      if (paramSpannableStringBuilder.toString().contains(paramStringBuilder.toString())) {
        i1 = paramSpannableStringBuilder.toString().indexOf(paramStringBuilder.toString());
      }
      paramSpannableStringBuilder.setSpan(new QCirclePersonInfoWidget.5(this, paramStringBuilder), i1, ((QQCircleBase.UserCircleInfo)this.I.get(0)).name.get().length() + i1, 33);
    }
  }
  
  private void a(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    if (g())
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "[updateTagListView] current switch rank list, hide tag list display.");
      return;
    }
    if (paramStMainPageBusiRspData != null)
    {
      this.s.a(getReportBean());
      Object localObject2 = null;
      QQCircleBase.StUserBusiData localStUserBusiData = this.f;
      Object localObject1 = localObject2;
      if (localStUserBusiData != null)
      {
        localObject1 = localObject2;
        if (localStUserBusiData.rankData.has()) {
          localObject1 = this.f.rankData.get();
        }
      }
      this.s.a(this.e);
      this.s.a((List)localObject1, paramStMainPageBusiRspData);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FeedCloudMeta.StUser localStUser = this.e;
      if (localStUser == null) {
        return;
      }
      if (this.y == null)
      {
        QLog.d("QCirclePersonInfoAndStatusWidget", 1, "[handleFollowOpenPymk] person header pymk control should not be null.");
        return;
      }
      e(localStUser);
      this.y.b();
    }
  }
  
  private boolean a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    Object localObject = this.f;
    boolean bool2 = false;
    if (localObject == null)
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "poster.busiData is null");
      return false;
    }
    this.H = new ArrayList();
    this.I = this.f.schoolInfos.get();
    this.J = this.f.companyInfos.get();
    localObject = this.I;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((List)localObject).size() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mSchoolCircleInfos size:");
        ((StringBuilder)localObject).append(this.I.size());
        QLog.d("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject).toString());
        bool2 = TextUtils.isEmpty(((QQCircleBase.UserCircleInfo)this.I.get(0)).circleJumpUrl.get()) ^ true;
        this.H.addAll(this.I);
        localObject = this.I.iterator();
        for (;;)
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramStringBuilder1.append(((QQCircleBase.UserCircleInfo)((Iterator)localObject).next()).name.get());
        }
      }
    }
    paramStringBuilder1 = this.J;
    if ((paramStringBuilder1 != null) && (paramStringBuilder1.size() > 0))
    {
      paramStringBuilder1 = new StringBuilder();
      paramStringBuilder1.append("mCompanyCircleInfos size:");
      paramStringBuilder1.append(this.J.size());
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, paramStringBuilder1.toString());
      this.H.addAll(this.J);
      paramStringBuilder1 = this.J.iterator();
      while (paramStringBuilder1.hasNext()) {
        paramStringBuilder2.append(((QQCircleBase.UserCircleInfo)paramStringBuilder1.next()).name.get());
      }
    }
    return bool1;
  }
  
  private void b()
  {
    this.v.setOnClickListener(new QCirclePersonInfoWidget.2(this));
    this.v.setItemReportListener(new QCirclePersonInfoWidget.3(this));
  }
  
  private void b(long paramLong)
  {
    this.G = paramLong;
    this.l.setText(QCirclePluginUtil.d(paramLong));
    m();
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    if (QCirclePluginUtil.b(paramStUser))
    {
      this.x.setVisibility(0);
      paramStUser = this.f;
      if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.completionDesc.get()))) {
        this.x.setText(this.f.completionDesc.get());
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.id.get()).setActionType(11).setSubActionType(24).setThrActionType(1).setPageId(getPageId()));
      return;
    }
    this.x.setVisibility(8);
  }
  
  private void b(FeedCloudMeta.StUser paramStUser, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    if (paramStMainPageBusiRspData != null)
    {
      if (paramStMainPageBusiRspData.giftCnt.get() > 0)
      {
        this.N.setVisibility(0);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramStUser.id.get()).setActionType(11).setSubActionType(32).setThrActionType(1).setExt1(String.valueOf(paramStUser.followState.get())));
        return;
      }
      this.N.setVisibility(8);
      return;
    }
    this.N.setVisibility(8);
  }
  
  private void b(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    Object localObject;
    if (paramStMainPageBusiRspData != null) {
      localObject = new QQCircleProfile.StProfileBizData();
    }
    try
    {
      ((QQCircleProfile.StProfileBizData)localObject).mergeFrom(paramStMainPageBusiRspData.profileBusiData.get().toByteArray());
      paramStMainPageBusiRspData = new StringBuilder();
      paramStMainPageBusiRspData.append("updateTroopTagList profileBizData.groupIDList.size:");
      paramStMainPageBusiRspData.append(((QQCircleProfile.StProfileBizData)localObject).groupIDList.size());
      paramStMainPageBusiRspData.append(", profileBizData.groupIDList:");
      paramStMainPageBusiRspData.append(((QQCircleProfile.StProfileBizData)localObject).groupIDList);
      QLog.d("QCirclePersonInfoAndStatusWidget", 2, paramStMainPageBusiRspData.toString());
    }
    catch (InvalidProtocolBufferMicroException paramStMainPageBusiRspData)
    {
      label90:
      break label90;
    }
    QLog.e("QCirclePersonInfoAndStatusWidget", 2, "updateTroopTagList mergeFrom error");
    this.t.a(((QQCircleProfile.StProfileBizData)localObject).groupIDList.get());
    paramStMainPageBusiRspData = new StringBuilder();
    if (((QQCircleProfile.StProfileBizData)localObject).groupIDList.get() != null)
    {
      localObject = ((QQCircleProfile.StProfileBizData)localObject).groupIDList.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l1 = ((Long)((Iterator)localObject).next()).longValue();
        if ("".equals(paramStMainPageBusiRspData.toString()))
        {
          paramStMainPageBusiRspData.append(l1);
        }
        else
        {
          paramStMainPageBusiRspData.append(";");
          paramStMainPageBusiRspData.append(l1);
        }
      }
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.id.get()).setActionType(11).setSubActionType(31).setThrActionType(1).setExt2(paramStMainPageBusiRspData.toString()).setPageId(getPageId()));
  }
  
  private boolean b(int paramInt)
  {
    if ((paramInt != 2131437452) && (paramInt != 2131437450)) {
      paramInt = 2131895791;
    } else {
      paramInt = 2131895641;
    }
    FeedCloudMeta.StUser localStUser = this.e;
    if ((localStUser != null) && ((localStUser.blackState.get() == 1) || (this.e.blackState.get() == 3)))
    {
      QCircleToast.a(QCircleToast.b, 2131895790, 0);
      return true;
    }
    localStUser = this.e;
    if ((localStUser != null) && (localStUser.blackState.get() == 2))
    {
      QCircleCustomDialog.a(getContext()).a(paramInt).b(2131895760, new QCirclePersonInfoWidget.7(this)).show();
      return true;
    }
    return false;
  }
  
  private boolean b(View paramView)
  {
    QQCircleProfile.StProfileBizData localStProfileBizData;
    if ((paramView != null) && (this.e != null))
    {
      if (this.h == null) {
        return false;
      }
      localStProfileBizData = new QQCircleProfile.StProfileBizData();
    }
    try
    {
      localStProfileBizData.mergeFrom(this.h.profileBusiData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label49:
      break label49;
    }
    QLog.e("QCirclePersonInfoAndStatusWidget", 2, "updateTroopTagList mergeFrom error");
    if (localStProfileBizData.bindGroupStatus.get() != 1) {
      return false;
    }
    c(paramView);
    return true;
    return false;
  }
  
  private void c()
  {
    RFWTypefaceUtil.a(this.l, false);
    RFWTypefaceUtil.a(this.m, false);
    RFWTypefaceUtil.a(this.n, false);
  }
  
  private void c(View paramView)
  {
    if ((paramView != null) && (this.e != null))
    {
      if (this.h == null) {
        return;
      }
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUser(this.e);
      localQCircleInitBean.setBusiInfoData(this.h.toByteArray());
      localQCircleInitBean.setFromReportBean(getReportBean().clone());
      QCircleLauncher.c(paramView.getContext(), localQCircleInitBean);
    }
  }
  
  private void c(FeedCloudMeta.StUser paramStUser)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(localSpannableStringBuilder);
    if (paramStUser.constellation.get() > 0) {
      localSpannableStringBuilder.append(com.tencent.biz.qqcircle.QCirclePluginInnerConstant.a[(paramStUser.constellation.get() - 1)]);
    }
    boolean bool = TextUtils.isEmpty(paramStUser.location.get());
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject3 = QCircleTextUtils.a(paramStUser.location.get());
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    localObject2 = new StringBuilder();
    Object localObject3 = new StringBuilder();
    bool = a((StringBuilder)localObject2, (StringBuilder)localObject3);
    if ((bool) && (((StringBuilder)localObject2).length() > 0))
    {
      a(localSpannableStringBuilder);
      localSpannableStringBuilder.append((CharSequence)localObject2);
      if (localObject1.length() > 0)
      {
        a(localSpannableStringBuilder);
        localSpannableStringBuilder.append(localObject1);
      }
      if (((StringBuilder)localObject3).length() > 0)
      {
        a(localSpannableStringBuilder);
        localSpannableStringBuilder.append((CharSequence)localObject3);
      }
    }
    else
    {
      if (localObject1.length() > 0)
      {
        a(localSpannableStringBuilder);
        localSpannableStringBuilder.append(localObject1);
      }
      if (((StringBuilder)localObject2).length() > 0)
      {
        if (localSpannableStringBuilder.length() > 3) {
          a(localSpannableStringBuilder);
        }
        localSpannableStringBuilder.append((CharSequence)localObject2);
      }
      if (((StringBuilder)localObject3).length() > 0)
      {
        if (localSpannableStringBuilder.length() > 3) {
          a(localSpannableStringBuilder);
        }
        localSpannableStringBuilder.append((CharSequence)localObject3);
      }
    }
    a(paramStUser, localSpannableStringBuilder, (StringBuilder)localObject2, bool);
  }
  
  private void d()
  {
    if ((!QCirclePluginUtil.b(this.e)) && (this.h != null))
    {
      if ((Build.VERSION.SDK_INT >= 19) && (this.v.isAttachedToWindow())) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.id.get()).setActionType(11).setSubActionType(3).setThrActionType(1).setExt1(String.valueOf(this.e.followState.get())).setExt2("2").setExt9(this.c).setFeedReportInfo(this.d).setPageId(getPageId()));
      }
      this.u.setVisibility(0);
      this.v.setUserData((FeedCloudMeta.StUser)this.e.get());
      ViewGroup.LayoutParams localLayoutParams = this.v.getLayoutParams();
      if ((QCirclePluginUtil.a(this.h.opMask.get())) && (QCirclePluginUtil.c(this.e.followState.get()))) {
        localLayoutParams.width = ImmersiveUtils.a(69.0F);
      } else {
        localLayoutParams.width = -1;
      }
      this.v.setLayoutParams(localLayoutParams);
      return;
    }
    this.u.setVisibility(8);
  }
  
  private void d(FeedCloudMeta.StUser paramStUser)
  {
    if (this.L != null)
    {
      if (paramStUser == null) {
        return;
      }
      if (!QCirclePluginUtil.b(paramStUser))
      {
        QLog.i("QCirclePersonInfoAndStatusWidget", 1, "updateEditGuideBubble  is not owner");
        return;
      }
      if (!QCirclePluginConfig.a().x())
      {
        QCirclePluginConfig.a().c(true);
        this.L.a(0, 0, 0);
        this.L.setText(getEditProfilePopupText());
        this.L.setShowDuration(3000);
        this.L.setNeedFadeAnim(true);
        this.L.a(1000);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.id.get()).setActionType(11).setSubActionType(13).setThrActionType(5).setPageId(getPageId()));
      }
    }
  }
  
  private void e()
  {
    if ((!QCirclePluginUtil.b(this.e)) && (this.e != null))
    {
      Object localObject = this.h;
      if (localObject != null)
      {
        boolean bool = QCirclePluginUtil.a(((QQCircleFeedBase.StMainPageBusiRspData)localObject).opMask.get());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isShowChatEntrance");
        ((StringBuilder)localObject).append(bool);
        QLog.d("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject).toString());
        if ((bool) && (QCirclePluginUtil.c(this.e.followState.get())))
        {
          this.w.setVisibility(0);
          if (this.e.blackState.get() != 0)
          {
            this.w.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167081));
            this.w.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845323));
          }
          else
          {
            this.w.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
            this.w.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845324));
          }
          QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.id.get()).setActionType(11).setSubActionType(4).setThrActionType(1).setExt9(this.c).setFeedReportInfo(this.d).setPageId(getPageId()));
        }
        else
        {
          this.w.setVisibility(8);
        }
        VideoReport.setElementId(this.w, "em_xsj_private_msg_button");
        localObject = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementParams(this.w, (Map)localObject);
        return;
      }
    }
    this.w.setVisibility(8);
  }
  
  private void e(FeedCloudMeta.StUser paramStUser)
  {
    QCirclePersonHeaderPymkControl localQCirclePersonHeaderPymkControl = this.y;
    if (localQCirclePersonHeaderPymkControl == null)
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "[updatePersonInfoPymkData] person info pymk child view should not be null.");
      return;
    }
    localQCirclePersonHeaderPymkControl.a(getPageId());
    this.y.a(paramStUser);
  }
  
  private void f()
  {
    if ((this.f != null) && (this.A != null) && (this.B != null))
    {
      Object localObject1 = this.Q;
      if (localObject1 != null)
      {
        ((LinearLayout)localObject1).setVisibility(8);
        if (!QCirclePluginUtil.d(this.e))
        {
          this.A.setVisibility(8);
          this.B.setVisibility(8);
          return;
        }
        this.Q.setVisibility(0);
        if (QCirclePluginUtil.e(this.e) == 2)
        {
          localObject1 = this.f.blueCertifiDesc.get();
          localObject2 = QCircleConfigHelper.z();
        }
        else
        {
          localObject1 = this.f.certificationDesc.get();
          localObject2 = QCircleConfigHelper.y();
        }
        QCircleFeedPicLoader.g().loadImage(new Option().setUrl((String)localObject2).setTargetView(this.A), null);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setAuthIcon: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject2).toString());
        this.A.setVisibility(0);
        if ((localObject1 != null) && (((String)localObject1).trim().length() != 0))
        {
          this.B.setText((CharSequence)localObject1);
          this.B.setVisibility(0);
          return;
        }
        this.B.setVisibility(8);
        return;
      }
    }
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, "[setAuthIcon] mUserBusiData == null || mIvAuthIcon == null || mTvAuthDesc == null || mLlAuthLayout == null.");
  }
  
  private boolean g()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_switch_rank_list", Integer.valueOf(1)).intValue() == 1;
  }
  
  private String getEditProfilePopupText()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_homepage_host_profile_edit_hint_text", getContext().getString(2131895752));
  }
  
  private void h()
  {
    this.S.setVisibility(8);
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = (FeedCloudMeta.StFollowRecomInfo)((FeedCloudRead.StGetMainPageRsp)localObject).followRecomInfo.get();
    if ((((FeedCloudMeta.StFollowRecomInfo)localObject).followUsers.size() > 0) && (!TextUtils.isEmpty(((FeedCloudMeta.StFollowRecomInfo)localObject).followText.get())))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      FeedCloudMeta.StFollowUser localStFollowUser = (FeedCloudMeta.StFollowUser)((FeedCloudMeta.StFollowRecomInfo)localObject).followUsers.get(0);
      BoldClickableSpan localBoldClickableSpan = new BoldClickableSpan(new QCirclePersonInfoWidget.6(this, localStFollowUser), 2131167085, true);
      localSpannableStringBuilder.append(localStFollowUser.nick.get());
      localSpannableStringBuilder.setSpan(localBoldClickableSpan, 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(((FeedCloudMeta.StFollowRecomInfo)localObject).followText.get());
      this.O.setMovementMethod(LinkMovementMethod.getInstance());
      this.O.setText(localSpannableStringBuilder);
      this.P.setVisibility(0);
    }
    else if (!TextUtils.isEmpty(((FeedCloudMeta.StFollowRecomInfo)localObject).commFriendText.get()))
    {
      this.O.setText(((FeedCloudMeta.StFollowRecomInfo)localObject).commFriendText.get());
    }
    else
    {
      if (TextUtils.isEmpty(((FeedCloudMeta.StFollowRecomInfo)localObject).commGroupText.get())) {
        return;
      }
      this.O.setText(((FeedCloudMeta.StFollowRecomInfo)localObject).commGroupText.get());
    }
    this.O.setVisibility(0);
    this.S.setVisibility(0);
    VideoReport.setElementId(this.O, "em_xsj_recom_reason");
    localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).put("xsj_recom_reason", this.O.getText());
    VideoReport.setElementParams(this.O, (Map)localObject);
    VideoReport.setElementId(this.P, "em_xsj_recom_reason");
    VideoReport.setElementParams(this.P, (Map)localObject);
  }
  
  private void i()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((QQCircleBase.StUserBusiData)localObject).achievement.has()) && (getQCircleBaseFragment() != null))
    {
      localObject = new QCircleAchievementInfo();
      ((QCircleAchievementInfo)localObject).a = this.f.achievement.rocketTitle.get();
      ((QCircleAchievementInfo)localObject).b = this.f.achievement.rocketDesc.get();
      ((QCircleAchievementInfo)localObject).c = this.f.achievement.rocketToastUrl.get();
      ((QCircleAchievementInfo)localObject).d = this.f.achievement.rocketButtonDesc.get();
      ((QCircleAchievementInfo)localObject).e = this.f.achievement.rocketButtonUrl.get();
      ((QCircleAchievementInfo)localObject).f = this.f.achievement.rocket.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAchievementPopUpWindow: ");
      localStringBuilder.append(((QCircleAchievementInfo)localObject).a);
      localStringBuilder.append(" ");
      localStringBuilder.append(((QCircleAchievementInfo)localObject).b);
      localStringBuilder.append(" ");
      localStringBuilder.append(((QCircleAchievementInfo)localObject).c);
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, localStringBuilder.toString());
      getQCircleBaseFragment().p().a("open_achievement_popup_window_message", localObject);
      return;
    }
    QLog.e("QCirclePersonInfoAndStatusWidget", 1, "showAchievementPopUpWindow: userBusiData or achievementData or BaseFragment is null");
  }
  
  private void j()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((QQCircleBase.StUserBusiData)localObject).fuelValueJumpUrl.get();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QCircleLauncher.a(this.a, (String)localObject, null, -1);
      }
    }
  }
  
  private void k()
  {
    if ((this.a instanceof Activity))
    {
      Object localObject1 = this.e;
      if (localObject1 != null)
      {
        if (TextUtils.isEmpty(((FeedCloudMeta.StUser)localObject1).id.get())) {
          return;
        }
        String str = this.e.id.get();
        Intent localIntent = new Intent(this.a, QCircleHostClassHelper.getChatActivityClass());
        localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.OPEN_CHAT_FRAGMENT(), true);
        localIntent.putExtra("PREVIOUS_WINDOW", QCirclePersonalDetailFragment.class.getName());
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN(), str);
        if (QCircleCommonUtil.isFriend(str))
        {
          localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_FRIEND());
        }
        else
        {
          localIntent.putExtra(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
          localIntent.putExtra(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
        }
        if (!TextUtils.isEmpty(this.K)) {
          localIntent.putExtra(HostChatUtils.QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY(), this.K);
        }
        localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
        Object localObject2 = HostDataTransUtils.getBuddyName(str, true);
        localObject1 = localObject2;
        if (str.equals(localObject2)) {
          localObject1 = this.e.nick.get();
        }
        str = QCircleHostConstants.AppConstants.Key.UIN_NAME();
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localIntent.putExtra(str, (String)localObject2);
        this.a.startActivity(localIntent);
      }
    }
  }
  
  private void l()
  {
    Object localObject = this.h;
    int i1;
    if ((localObject != null) && (QCirclePluginUtil.b(((QQCircleFeedBase.StMainPageBusiRspData)localObject).opMask.get()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("canJumpProfile");
    ((StringBuilder)localObject).append(this.e.id.get());
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject).toString());
    if (((i1 != 0) || (QCirclePluginUtil.d(this.e.id.get()))) && (this.a != null))
    {
      localObject = this.e;
      if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StUser)localObject).id.get())))
      {
        localObject = this.e.id.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        QCircleHostLauncher.startProfileCardActivity(getContext(), (String)localObject);
      }
    }
  }
  
  private void m()
  {
    if ((a(this.m) >= 4) && (a(this.l) >= 4) && (a(this.n) >= 4))
    {
      this.m.setTextSize(1, ViewUtils.a(5.0F));
      this.l.setTextSize(1, ViewUtils.a(5.0F));
      this.n.setTextSize(1, ViewUtils.a(5.0F));
    }
  }
  
  private void setAchievementLabel(String paramString)
  {
    Object localObject = this.C;
    if ((localObject != null) && (this.f != null))
    {
      ((ImageView)localObject).setVisibility(8);
      int i1 = this.f.achievement.rocket.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" achievementLevel: ");
      ((StringBuilder)localObject).append(i1);
      QLog.i("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject).toString());
      if (i1 == 0) {
        return;
      }
      if ((this.f.achievement.rocketIconUrl.has()) && (!TextUtils.isEmpty(this.f.achievement.rocketIconUrl.get())))
      {
        localObject = this.f.achievement.rocketIconUrl.get();
        Option localOption = new Option().setUrl((String)localObject).setRequestWidth(ViewUtils.a(19.0F)).setRequestHeight(ViewUtils.a(19.0F)).setTargetView(this.C);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("achievement icon url: ");
        localStringBuilder.append((String)localObject);
        QLog.d("QCirclePersonInfoAndStatusWidget", 1, localStringBuilder.toString());
        QCircleFeedPicLoader.g().loadImage(localOption, null);
        this.C.setVisibility(0);
        paramString = new QCircleLpReportDc05504.DataBuilder().setToUin(paramString).setActionType(11).setSubActionType(54).setThrActionType(1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("");
        QCircleLpReportDc05504.report(paramString.setExt6(((StringBuilder)localObject).toString()));
        return;
      }
      QLog.e("QCirclePersonInfoAndStatusWidget", 1, "achievement icon url is null");
      return;
    }
    QLog.e("QCirclePersonInfoAndStatusWidget", 1, "achievement label is null");
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if (paramObject == null)
    {
      QLog.e("QCirclePersonInfoAndStatusWidget", 1, "bindData error");
      return;
    }
    if ((paramObject instanceof FeedCloudMeta.StUser))
    {
      this.e = ((FeedCloudMeta.StUser)paramObject);
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail setSimpleUser");
      a(this.e, this.h);
      e(this.e);
      return;
    }
    if ((paramObject instanceof FeedCloudRead.StGetMainPageRsp))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail setRspUser");
      this.g = ((FeedCloudRead.StGetMainPageRsp)paramObject);
      if (this.g.busiRspData.get() != null) {
        paramObject = new QQCircleFeedBase.StMainPageBusiRspData();
      }
    }
    try
    {
      paramObject.mergeFrom(this.g.busiRspData.get().toByteArray());
      this.h = paramObject;
    }
    catch (Exception paramObject)
    {
      label133:
      StringBuilder localStringBuilder;
      break label133;
    }
    QLog.e("QCirclePersonInfoAndStatusWidget", 1, "personDetail mergeFrom stMainPageBusiRspData error");
    if (this.g.user != null)
    {
      this.e.set(this.g.user);
      a(this.e, this.h);
      e(this.g.user);
    }
    a(this.g.fansCount.get());
    a(this.g.followCount.get());
    this.K = this.g.pmBeginShow.get();
    h();
    a(this.g);
    return;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("personDetail bindData error");
    localStringBuilder.append(paramObject.toString());
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, localStringBuilder.toString());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCirclePersonEditUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131626897;
  }
  
  protected String getLogTag()
  {
    return "QCirclePersonInfoAndStatusWidget";
  }
  
  public FeedCloudMeta.StUser getUserData()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @QCirclePersonDetailClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(T, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onInitView(Context paramContext, View paramView)
  {
    if ((this.e == null) && ((paramContext instanceof Activity)))
    {
      Object localObject = (Activity)paramContext;
      if ((((Activity)localObject).getIntent() != null) && (((Activity)localObject).getIntent().hasExtra("key_bundle_common_init_bean")))
      {
        localObject = (QCircleInitBean)((Activity)localObject).getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (localObject != null)
        {
          this.e = ((QCircleInitBean)localObject).getUser();
          this.b = ((QCircleInitBean)localObject).getFeed();
          this.c = this.b.id.get();
          if (this.b.busiReport.has()) {
            this.d = this.b.busiReport.get().toByteArray();
          }
        }
      }
    }
    findViewById(2131429337);
    this.j = ((TextView)findViewById(2131448603));
    this.j.setMaxWidth(ImmersiveUtils.b() - ImmersiveUtils.a(92.0F));
    this.k = ((ImageView)findViewById(2131436568));
    this.v = ((QCircleFollowView)findViewById(2131448467));
    this.v.setDtParentEmId("em_xsj_bio");
    this.C = ((ImageView)findViewById(2131436246));
    this.l = ((TextView)findViewById(2131448480));
    this.m = ((TextView)findViewById(2131448442));
    this.n = ((TextView)findViewById(2131448471));
    this.o = ((LinearLayout)findViewById(2131437458));
    this.q = ((LinearLayout)findViewById(2131437450));
    this.p = ((LinearLayout)findViewById(2131437452));
    this.r = ((QCircleAvatarView)findViewById(2131436420));
    this.s = new QCircleTagListView();
    this.s.a(paramView);
    this.t = new QCircleTroopTagListView();
    this.t.a(paramView, 0);
    this.u = ((LinearLayout)findViewById(2131437437));
    this.w = ((TextView)findViewById(2131448657));
    this.x = ((TextView)findViewById(2131448658));
    this.A = ((SquareImageView)findViewById(2131436266));
    this.B = ((TextView)findViewById(2131448273));
    this.D = ((TextView)findViewById(2131448573));
    this.N = ((ImageView)findViewById(2131436394));
    this.L = ((QCircleGuideBubbleView)findViewById(2131441607));
    this.M = ((QCircleTailExpandText)findViewById(2131448375));
    this.M.a(ImmersiveUtils.b() - ImmersiveUtils.a(36.0F));
    this.O = ((TextView)findViewById(2131448694));
    this.P = ((ImageView)findViewById(2131436541));
    this.Q = ((LinearLayout)findViewById(2131437405));
    this.R = ((LinearLayout)findViewById(2131437557));
    this.S = ((RelativeLayout)findViewById(2131445008));
    this.y = new QCirclePersonHeaderPymkControl();
    this.y.a(paramContext, paramView);
    this.z = new QCirclePersonHeaderRankListControl();
    this.z.a(paramContext, paramView);
    a();
    c();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent))
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
        if (QCirclePluginUtil.b((FeedCloudMeta.StUser)localObject))
        {
          if (QCirclePluginUtil.c(paramSimpleBaseEvent.mFollowStatus))
          {
            this.F += 1;
          }
          else
          {
            int i1 = this.F;
            if (i1 > 0) {
              this.F = (i1 - 1);
            }
          }
          a(this.F);
        }
        else if (TextUtils.equals(this.e.id.get(), paramSimpleBaseEvent.mUserId))
        {
          if ((QCirclePluginUtil.c(paramSimpleBaseEvent.mFollowStatus)) && (QCirclePluginUtil.c(this.e.followState.get())))
          {
            this.E += 1L;
          }
          else if ((!QCirclePluginUtil.c(paramSimpleBaseEvent.mFollowStatus)) && (QCirclePluginUtil.c(this.e.followState.get())))
          {
            long l1 = this.E;
            if (l1 > 0L) {
              this.E = (l1 - 1L);
            }
          }
          this.e.followState.set(paramSimpleBaseEvent.mFollowStatus);
          d();
          e();
          boolean bool;
          if (paramSimpleBaseEvent.mFollowStatus == 1) {
            bool = true;
          } else {
            bool = false;
          }
          a(bool);
        }
        RFThreadManager.getUIHandler().post(new QCirclePersonInfoWidget.8(this));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceiveEvent  id:");
        ((StringBuilder)localObject).append(paramSimpleBaseEvent.mUserId);
        ((StringBuilder)localObject).append(" , status:");
        ((StringBuilder)localObject).append(paramSimpleBaseEvent.mFollowStatus);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(toString());
        QLog.i("QCirclePersonInfoAndStatusWidget", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (((paramSimpleBaseEvent instanceof QCirclePersonEditUpdateEvent)) && (QCirclePluginUtil.b(this.e))) {
      a((QCirclePersonEditUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void release()
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((QCirclePersonHeaderPymkControl)localObject).a();
    }
    localObject = this.z;
    if (localObject != null) {
      ((QCirclePersonHeaderRankListControl)localObject).a();
    }
  }
  
  public void setHeaderClickListener(QCirclePersonInfoWidget.HeaderClickListener paramHeaderClickListener)
  {
    this.i = paramHeaderClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget
 * JD-Core Version:    0.7.0.1
 */