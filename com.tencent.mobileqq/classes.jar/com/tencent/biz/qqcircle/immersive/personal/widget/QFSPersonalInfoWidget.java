package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Value;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ChatActivityConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCirclePersonDetailClick;
import com.tencent.biz.qqcircle.beans.QCircleAchievementInfo;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import com.tencent.biz.qqcircle.events.QCirclePersonInfoNumUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonInfoNumUpdateEvent.PersonNumInfo;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl;
import com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.control.QFSPersonHeaderRankListControl;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleJoinGroupReportRequest;
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
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
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
import feedcloud.FeedCloudMeta.StFollowRecomInfo;
import feedcloud.FeedCloudMeta.StFollowUser;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleBase.CircleAchievement;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import qqcircle.QQCircleProfile.StProfileBizData;

public class QFSPersonalInfoWidget
  extends QCircleBaseWidgetView<QFSPersonalInfo>
  implements View.OnClickListener, LifecycleOwner
{
  private QFSPersonHeaderRankListControl A;
  private ImageView B;
  private QCircleGuideBubbleView C;
  private QCircleTailExpandText D;
  private ImageView E;
  private TextView F;
  private ImageView G;
  private LinearLayout H;
  private LinearLayout I;
  private RelativeLayout J;
  private final Context a;
  private final LifecycleRegistry b = new LifecycleRegistry(this);
  private final QFSPersonalDetailsFragment c;
  private QFSPersonalViewModel d;
  private QFSPersonalInfo e;
  private volatile byte[] f;
  private String g;
  private TextView h;
  private ImageView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private QCircleAvatarView p;
  private SquareImageView q;
  private LinearLayout r;
  private LinearLayout s;
  private LinearLayout t;
  private TextView u;
  private LinearLayout v;
  private QCircleTagListView w;
  private QCircleTroopTagListView x;
  private QCircleFollowView y;
  private QCirclePersonHeaderPymkControl z;
  
  static {}
  
  public QFSPersonalInfoWidget(Context paramContext, QFSPersonalDetailsFragment paramQFSPersonalDetailsFragment)
  {
    super(paramContext);
    this.b.setCurrentState(Lifecycle.State.CREATED);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.a = paramContext;
    this.c = paramQFSPersonalDetailsFragment;
    a();
  }
  
  private void A()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.c).setActionType(11).setSubActionType(4).setThrActionType(2).setExt9(this.g).setFeedReportInfo(this.f).setPageId(getPageId()));
    Object localObject1 = this.e;
    if (localObject1 == null) {
      return;
    }
    String str = ((QFSPersonalInfo)localObject1).c;
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
    if (!TextUtils.isEmpty(this.e.D)) {
      localIntent.putExtra(HostChatUtils.QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY(), this.e.D);
    }
    localIntent.putExtra(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
    Object localObject2 = HostDataTransUtils.getBuddyName(str, true);
    localObject1 = localObject2;
    if (str.equals(localObject2)) {
      localObject1 = this.e.a.nick.get();
    }
    str = QCircleHostConstants.AppConstants.Key.UIN_NAME();
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localIntent.putExtra(str, (String)localObject2);
    this.a.startActivity(localIntent);
  }
  
  private void B()
  {
    QFSPersonalInfo localQFSPersonalInfo = this.e;
    if (localQFSPersonalInfo == null) {
      return;
    }
    if ((!localQFSPersonalInfo.v) && (!QCirclePluginUtil.b(this.e.M))) {
      return;
    }
    QCircleHostLauncher.startProfileCardActivity(this.a, this.e.c);
  }
  
  private void C()
  {
    if ((a(this.k) >= 4) && (a(this.j) >= 4) && (a(this.l) >= 4))
    {
      this.k.setTextSize(1, ViewUtils.a(5.0F));
      this.j.setTextSize(1, ViewUtils.a(5.0F));
      this.l.setTextSize(1, ViewUtils.a(5.0F));
    }
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
    this.d = ((QFSPersonalViewModel)getViewModel(this.c, QFSPersonalViewModel.class));
    this.d.b().observe(this, new QFSPersonalInfoWidget.1(this));
    this.d.f().observe(this, new QFSPersonalInfoWidget.2(this));
    this.d.k().observe(this, new QFSPersonalInfoWidget.3(this));
  }
  
  private void a(int paramInt)
  {
    this.l.setText(QCirclePluginUtil.d(paramInt));
    C();
  }
  
  private void a(long paramLong)
  {
    Bundle localBundle = HostStaticInvokeHelper.getTroopProfileExtra(String.valueOf(paramLong));
    localBundle.putBoolean(QCircleHostConstants.AppConstants.Key.TROOP_INFO_FROM_TROOPSETTING(), true);
    localBundle.putInt("exposureSource", 3);
    HostRouteUtils.openTroopInfoActivity(getContext(), localBundle);
    VSNetworkHelper.getInstance().sendRequest(getContext(), new QCircleJoinGroupReportRequest(paramLong), new QFSPersonalInfoWidget.5(this));
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.c).setActionType(11).setSubActionType(31).setThrActionType(2).setPageId(getPageId()));
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i1 = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" / ");
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(2131167085)), i1, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, StringBuilder paramStringBuilder)
  {
    if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && (paramSpannableStringBuilder.length() > 3))
    {
      a(paramStringBuilder, paramSpannableStringBuilder);
      paramStringBuilder = this.i;
      int i1;
      if (this.e.a.sex.get() == 1) {
        i1 = 2130845253;
      } else {
        i1 = 2130845252;
      }
      paramStringBuilder.setImageResource(i1);
      this.i.setVisibility(0);
      this.n.setText(paramSpannableStringBuilder);
      this.n.setVisibility(0);
      this.n.setMovementMethod(LinkMovementMethod.getInstance());
      this.I.setVisibility(0);
      VideoReport.setElementId(this.I, "em_xsj_other_tag");
      paramStringBuilder = new QCircleDTParamBuilder().buildElementParams();
      VideoReport.setElementParams(this.I, paramStringBuilder);
      QLog.d("QFSPersonalInfoWidget", 1, new Object[] { paramSpannableStringBuilder });
      return;
    }
    this.n.setVisibility(8);
    this.i.setVisibility(8);
    this.I.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    Object localObject = this.e;
    if ((localObject != null) && (QCirclePluginUtil.d(((QFSPersonalInfo)localObject).c)))
    {
      if (b(paramView)) {
        return;
      }
      if (!QCircleFlutterUtils.a())
      {
        c(paramView);
        return;
      }
      localObject = new QCircleEditProfileBean();
      ((QCircleEditProfileBean)localObject).setHostUin(this.e.c);
      ((QCircleEditProfileBean)localObject).setNick(this.e.a.nick.get());
      ((QCircleEditProfileBean)localObject).setGender(this.e.a.sex.get());
      ((QCircleEditProfileBean)localObject).setConstellation(this.e.a.constellation.get());
      ((QCircleEditProfileBean)localObject).setLocation(QCircleTextUtils.a(this.e.a.location.get()));
      ((QCircleEditProfileBean)localObject).setLocationCode(this.e.a.locationCode.get());
      ((QCircleEditProfileBean)localObject).setDesc(this.e.a.desc.get());
      if ((this.e.p != null) && (!this.e.p.isEmpty())) {
        ((QCircleEditProfileBean)localObject).setSchool(((QQCircleBase.UserCircleInfo)this.e.p.get(0)).name.get());
      }
      if ((this.e.q != null) && (!this.e.q.isEmpty())) {
        ((QCircleEditProfileBean)localObject).setCompany(((QQCircleBase.UserCircleInfo)this.e.q.get(0)).name.get());
      }
      QCircleFlutterLauncher.a(paramView.getContext(), (QCircleEditProfileBean)localObject);
    }
  }
  
  private void a(QFSUserFollowData paramQFSUserFollowData)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    if (((QFSPersonalInfo)localObject).v)
    {
      this.v.setVisibility(8);
      return;
    }
    localObject = this.e.a;
    ((FeedCloudMeta.StUser)localObject).followState.set(paramQFSUserFollowData.b());
    k();
    this.v.setVisibility(0);
    this.y.setUserData((FeedCloudMeta.StUser)localObject);
    localObject = this.y.getLayoutParams();
    if ((this.e.P) && (paramQFSUserFollowData.f())) {
      ((ViewGroup.LayoutParams)localObject).width = ImmersiveUtils.a(69.0F);
    } else {
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(QFSPersonalInfo paramQFSPersonalInfo)
  {
    if ((paramQFSPersonalInfo != null) && (paramQFSPersonalInfo.a != null))
    {
      Object localObject = this.e;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((QFSPersonalInfo)localObject).c;
      }
      this.e = paramQFSPersonalInfo;
      e();
      u();
      q();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.equals(this.e.c, (CharSequence)localObject))) {
        v();
      }
      return;
    }
    QLog.e("QFSPersonalInfoWidget", 1, "mPersonalInfo is null");
  }
  
  private void a(StringBuilder paramStringBuilder, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (TextUtils.isEmpty(this.e.r)) {
      return;
    }
    QCircleLpReportDc05504.DataBuilder localDataBuilder = f().setSubActionType(51).setThrActionType(1);
    String str;
    if (this.e.v) {
      str = "1";
    } else {
      str = "2";
    }
    QCircleLpReportDc05504.report(localDataBuilder.setExt6(str).setExt7(paramStringBuilder.toString()));
    int i1 = 3;
    if (paramSpannableStringBuilder.toString().contains(paramStringBuilder.toString())) {
      i1 = paramSpannableStringBuilder.toString().indexOf(paramStringBuilder.toString());
    }
    paramSpannableStringBuilder.setSpan(new QFSPersonalInfoWidget.9(this, paramStringBuilder), i1, ((QQCircleBase.UserCircleInfo)this.e.p.get(0)).name.get().length() + i1, 33);
  }
  
  private void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if ((this.e.p != null) && (!this.e.p.isEmpty()))
    {
      Iterator localIterator = this.e.p.iterator();
      while (localIterator.hasNext()) {
        paramStringBuilder1.append(((QQCircleBase.UserCircleInfo)localIterator.next()).name.get());
      }
    }
    if ((this.e.q != null) && (!this.e.q.isEmpty()))
    {
      paramStringBuilder1 = this.e.q.iterator();
      while (paramStringBuilder1.hasNext()) {
        paramStringBuilder2.append(((QQCircleBase.UserCircleInfo)paramStringBuilder1.next()).name.get());
      }
    }
  }
  
  private void b()
  {
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.G.setOnClickListener(this);
    c();
    this.x.a(new QFSPersonalInfoWidget.4(this));
  }
  
  private void b(long paramLong)
  {
    this.j.setText(QCirclePluginUtil.d(paramLong));
    C();
    g();
  }
  
  private boolean b(int paramInt)
  {
    int i1 = this.e.a.blackState.get();
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return false;
        }
      }
      else
      {
        QCircleCustomDialog localQCircleCustomDialog = QCircleCustomDialog.a(getContext());
        if ((paramInt != 2131437452) && (paramInt != 2131437450)) {
          paramInt = 2131895791;
        } else {
          paramInt = 2131895641;
        }
        localQCircleCustomDialog.a(paramInt).b(2131895760, new QFSPersonalInfoWidget.11(this)).show();
        return true;
      }
    }
    QCircleToast.a(QCircleToast.b, 2131895790, 0);
    return true;
  }
  
  private boolean b(View paramView)
  {
    QFSPersonalInfo localQFSPersonalInfo = this.e;
    if ((localQFSPersonalInfo != null) && (localQFSPersonalInfo.O != null) && (this.e.O.bindGroupStatus.get() == 1))
    {
      c(paramView);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.y.setOnClickListener(new QFSPersonalInfoWidget.6(this));
    this.y.setItemReportListener(new QFSPersonalInfoWidget.7(this));
  }
  
  private void c(long paramLong)
  {
    this.k.setText(QCirclePluginUtil.d(paramLong));
    C();
  }
  
  private void c(View paramView)
  {
    if (this.e == null) {
      return;
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(this.e.a);
    localQCircleInitBean.setBusiInfoData(this.e.z.toByteArray());
    localQCircleInitBean.setFromReportBean(getReportBean().clone());
    QCircleLauncher.c(paramView.getContext(), localQCircleInitBean);
  }
  
  private void d()
  {
    RFWTypefaceUtil.a(this.j, false);
    RFWTypefaceUtil.a(this.k, false);
    RFWTypefaceUtil.a(this.l, false);
  }
  
  private void e()
  {
    this.h.setText(this.e.d);
    this.p.setUser(this.e.a);
    b(this.e.j);
    h();
    i();
    j();
    m();
    n();
    o();
    p();
    s();
    t();
  }
  
  private QCircleLpReportDc05504.DataBuilder f()
  {
    return new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.c).setActionType(11).setPageId(getPageId());
  }
  
  private void g()
  {
    if ((this.j != null) && (this.l != null))
    {
      if (this.k == null) {
        return;
      }
      if (this.c == null) {
        return;
      }
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePersonInfoNumUpdateEvent(this.c.hashCode(), new QCirclePersonInfoNumUpdateEvent.PersonNumInfo(this.j.getText().toString(), this.l.getText().toString(), this.k.getText().toString())));
    }
  }
  
  private String getEditProfilePopupText()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_homepage_host_profile_edit_hint_text", getContext().getString(2131895752));
  }
  
  private void h()
  {
    if (this.e.L == 0)
    {
      this.E.setVisibility(8);
      return;
    }
    this.E.setVisibility(0);
    QCircleLpReportDc05504.report(f().setSubActionType(32).setThrActionType(1).setExt1(String.valueOf(this.e.a.followState.get())));
  }
  
  private void i()
  {
    if (TextUtils.isEmpty(this.e.e))
    {
      this.D.setVisibility(8);
      return;
    }
    VideoReport.setElementId(this.D, "em_xsj_personal_profile");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    VideoReport.setElementParams(this.D, localMap);
    this.D.setOnExpandCallback(new QFSPersonalInfoWidget.8(this));
    this.D.setVisibility(0);
    this.D.setContent(this.e.a.desc.get());
  }
  
  private void j()
  {
    if (QCirclePluginUtil.d(this.e.c))
    {
      this.o.setVisibility(0);
      this.o.setText(this.e.i);
      QCircleLpReportDc05504.report(f().setSubActionType(24).setThrActionType(1));
      return;
    }
    this.o.setVisibility(8);
  }
  
  private void k()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (!this.y.isAttachedToWindow()) {
        return;
      }
      QCircleLpReportDc05504.report(f().setSubActionType(3).setThrActionType(1).setExt1(String.valueOf(this.e.a.followState.get())).setExt2("2").setExt9(this.g).setFeedReportInfo(this.f));
    }
  }
  
  private void l()
  {
    Object localObject = this.e;
    if ((localObject != null) && (!((QFSPersonalInfo)localObject).v))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isShowChatEntrance");
      ((StringBuilder)localObject).append(this.e.P);
      QLog.d("QFSPersonalInfoWidget", 1, ((StringBuilder)localObject).toString());
      if ((this.e.P) && (this.e.a()))
      {
        this.u.setVisibility(0);
        this.u.setEnabled(this.e.w ^ true);
        QCircleLpReportDc05504.report(f().setSubActionType(4).setThrActionType(1).setExt9(this.g).setFeedReportInfo(this.f));
      }
      else
      {
        this.u.setVisibility(8);
      }
      VideoReport.setElementId(this.u, "em_xsj_private_msg_button");
      localObject = new QCircleDTParamBuilder().buildElementParams();
      VideoReport.setElementParams(this.u, (Map)localObject);
      return;
    }
    this.u.setVisibility(8);
  }
  
  private void m()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(localSpannableStringBuilder);
    localSpannableStringBuilder.append(this.e.f);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    a(localStringBuilder1, localStringBuilder2);
    if (localStringBuilder1.length() > 0)
    {
      a(localSpannableStringBuilder);
      localSpannableStringBuilder.append(localStringBuilder1);
      if (this.e.g.length() > 0)
      {
        a(localSpannableStringBuilder);
        localSpannableStringBuilder.append(this.e.g);
      }
      if (localStringBuilder2.length() > 0)
      {
        a(localSpannableStringBuilder);
        localSpannableStringBuilder.append(localStringBuilder2);
      }
    }
    else
    {
      if (this.e.g.length() > 0)
      {
        a(localSpannableStringBuilder);
        localSpannableStringBuilder.append(this.e.g);
      }
      if (localStringBuilder1.length() > 0)
      {
        if (localSpannableStringBuilder.length() > 3) {
          a(localSpannableStringBuilder);
        }
        localSpannableStringBuilder.append(localStringBuilder1);
      }
      if (localStringBuilder2.length() > 0)
      {
        if (localSpannableStringBuilder.length() > 3) {
          a(localSpannableStringBuilder);
        }
        localSpannableStringBuilder.append(localStringBuilder2);
      }
    }
    a(localSpannableStringBuilder, localStringBuilder1);
  }
  
  private void n()
  {
    if (!this.e.x)
    {
      this.H.setVisibility(8);
      this.q.setVisibility(8);
      this.m.setVisibility(8);
      return;
    }
    this.H.setVisibility(0);
    if (this.e.s == 2) {
      localObject = QCircleConfigHelper.z();
    } else {
      localObject = QCircleConfigHelper.y();
    }
    QCircleFeedPicLoader.g().loadImage(new Option().setUrl((String)localObject).setTargetView(this.q), null);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAuthIcon: ");
    ((StringBuilder)localObject).append(this.e.t);
    QLog.i("QFSPersonalInfoWidget", 1, ((StringBuilder)localObject).toString());
    this.q.setVisibility(0);
    if (TextUtils.isEmpty(this.e.t))
    {
      this.m.setVisibility(8);
      return;
    }
    this.m.setText(this.e.t);
    this.m.setVisibility(0);
  }
  
  private void o()
  {
    if ((this.e.n != null) && (this.e.n.rocket.get() != 0) && (!TextUtils.isEmpty(this.e.n.rocketIconUrl.get())))
    {
      int i1 = this.e.n.rocket.get();
      Object localObject = this.e.n.rocketIconUrl.get();
      localObject = new Option().setUrl((String)localObject).setRequestWidth(ViewUtils.a(19.0F)).setRequestHeight(ViewUtils.a(19.0F)).setTargetView(this.B);
      QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
      this.B.setVisibility(0);
      if (this.e.n.rocketToast.get() == 1) {
        y();
      }
      localObject = new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.c).setActionType(11).setSubActionType(54).setThrActionType(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1);
      localStringBuilder.append("");
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt6(localStringBuilder.toString()));
      return;
    }
    this.B.setVisibility(8);
  }
  
  private void p()
  {
    if (r())
    {
      QLog.d("QFSPersonalInfoWidget", 1, "[updateTagListView] current switch rank list, hide tag list display.");
      return;
    }
    this.w.a(getReportBean());
    this.w.a(this.e.a);
    this.w.a(this.e.o, this.e.z);
  }
  
  private void q()
  {
    if (!r())
    {
      QLog.d("QFSPersonalInfoWidget", 1, "[updateRankTagList] current no switch rank list.");
      return;
    }
    QFSPersonHeaderRankListControl localQFSPersonHeaderRankListControl = this.A;
    if (localQFSPersonHeaderRankListControl == null)
    {
      QLog.d("QFSPersonalInfoWidget", 1, "[updateRankTagList] persona header rank list control not is null.");
      return;
    }
    localQFSPersonHeaderRankListControl.a(this.e);
  }
  
  private boolean r()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_switch_rank_list", Integer.valueOf(1)).intValue() == 1;
  }
  
  private void s()
  {
    if (this.e.O == null) {
      return;
    }
    this.x.a(this.e.O.groupIDList.get());
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.e.O.groupIDList.get() != null)
    {
      Iterator localIterator = this.e.O.groupIDList.get().iterator();
      while (localIterator.hasNext())
      {
        long l1 = ((Long)localIterator.next()).longValue();
        if ("".equals(localStringBuilder.toString()))
        {
          localStringBuilder.append(l1);
        }
        else
        {
          localStringBuilder.append(";");
          localStringBuilder.append(l1);
        }
      }
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.c).setActionType(11).setSubActionType(31).setThrActionType(1).setExt2(localStringBuilder.toString()).setPageId(getPageId()));
  }
  
  private void t()
  {
    if (!QCirclePluginUtil.d(this.e.c))
    {
      QLog.i("QFSPersonalInfoWidget", 1, "updateEditGuideBubble  is not owner");
      return;
    }
    if (!QCirclePluginConfig.a().x())
    {
      QCirclePluginConfig.a().c(true);
      this.C.a(0, 0, 0);
      this.C.setText(getEditProfilePopupText());
      this.C.setShowDuration(3000);
      this.C.setNeedFadeAnim(true);
      this.C.a(1000);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e.c).setActionType(11).setSubActionType(13).setThrActionType(5).setPageId(getPageId()));
    }
  }
  
  private void u()
  {
    this.J.setVisibility(8);
    if (this.e.E == null) {
      return;
    }
    Object localObject = this.e.E;
    if ((((FeedCloudMeta.StFollowRecomInfo)localObject).followUsers.size() > 0) && (!TextUtils.isEmpty(((FeedCloudMeta.StFollowRecomInfo)localObject).followText.get())))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      FeedCloudMeta.StFollowUser localStFollowUser = (FeedCloudMeta.StFollowUser)((FeedCloudMeta.StFollowRecomInfo)localObject).followUsers.get(0);
      BoldClickableSpan localBoldClickableSpan = new BoldClickableSpan(new QFSPersonalInfoWidget.10(this, localStFollowUser), 2131167085, true);
      localSpannableStringBuilder.append(localStFollowUser.nick.get());
      localSpannableStringBuilder.setSpan(localBoldClickableSpan, 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(((FeedCloudMeta.StFollowRecomInfo)localObject).followText.get());
      this.F.setMovementMethod(LinkMovementMethod.getInstance());
      this.F.setText(localSpannableStringBuilder);
      this.G.setVisibility(0);
    }
    else if (!TextUtils.isEmpty(((FeedCloudMeta.StFollowRecomInfo)localObject).commFriendText.get()))
    {
      this.F.setText(((FeedCloudMeta.StFollowRecomInfo)localObject).commFriendText.get());
    }
    else
    {
      if (TextUtils.isEmpty(((FeedCloudMeta.StFollowRecomInfo)localObject).commGroupText.get())) {
        return;
      }
      this.F.setText(((FeedCloudMeta.StFollowRecomInfo)localObject).commGroupText.get());
    }
    this.F.setVisibility(0);
    this.J.setVisibility(0);
    VideoReport.setElementId(this.F, "em_xsj_recom_reason");
    localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).put("xsj_recom_reason", this.F.getText());
    VideoReport.setElementParams(this.F, (Map)localObject);
    VideoReport.setElementId(this.G, "em_xsj_recom_reason");
    VideoReport.setElementParams(this.G, (Map)localObject);
  }
  
  private void v()
  {
    QCirclePersonHeaderPymkControl localQCirclePersonHeaderPymkControl = this.z;
    if (localQCirclePersonHeaderPymkControl == null)
    {
      QLog.d("QFSPersonalInfoWidget", 1, "[updatePersonInfoPymkData] person info pymk child view should not be null.");
      return;
    }
    localQCirclePersonHeaderPymkControl.a(getPageId());
    this.z.a(this.e.a);
  }
  
  private void w()
  {
    if (!b(2131437452))
    {
      QFSPersonalInfo localQFSPersonalInfo = this.e;
      if (localQFSPersonalInfo != null)
      {
        if (localQFSPersonalInfo.H == null) {
          return;
        }
        if (this.e.y)
        {
          QCircleToast.a(QCircleToast.b, 2131895858, 0);
          return;
        }
        QCircleLauncher.a(this.a, this.e.H, null, -1);
      }
    }
  }
  
  private void x()
  {
    if (!b(2131437452))
    {
      QFSPersonalInfo localQFSPersonalInfo = this.e;
      if (localQFSPersonalInfo != null)
      {
        if (localQFSPersonalInfo.I == null) {
          return;
        }
        if (this.e.y)
        {
          QCircleToast.a(QCircleToast.b, 2131895857, 0);
          return;
        }
        QCircleLauncher.a(this.a, this.e.I, null, -1);
      }
    }
  }
  
  private void y()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((QFSPersonalInfo)localObject).n != null) && (this.c != null))
    {
      localObject = new QCircleAchievementInfo();
      ((QCircleAchievementInfo)localObject).a = this.e.n.rocketTitle.get();
      ((QCircleAchievementInfo)localObject).b = this.e.n.rocketDesc.get();
      ((QCircleAchievementInfo)localObject).c = this.e.n.rocketToastUrl.get();
      ((QCircleAchievementInfo)localObject).d = this.e.n.rocketButtonDesc.get();
      ((QCircleAchievementInfo)localObject).e = this.e.n.rocketButtonUrl.get();
      ((QCircleAchievementInfo)localObject).f = this.e.n.rocket.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAchievementPopUpWindow: ");
      localStringBuilder.append(((QCircleAchievementInfo)localObject).a);
      localStringBuilder.append(" ");
      localStringBuilder.append(((QCircleAchievementInfo)localObject).b);
      localStringBuilder.append(" ");
      localStringBuilder.append(((QCircleAchievementInfo)localObject).c);
      QLog.d("QFSPersonalInfoWidget", 1, localStringBuilder.toString());
      this.c.p().a("open_achievement_popup_window_message", localObject);
      return;
    }
    QLog.e("QFSPersonalInfoWidget", 1, "showAchievementPopUpWindow: userBusiData or achievementData or BaseFragment is null");
  }
  
  private void z()
  {
    if (TextUtils.isEmpty(this.e.k)) {
      return;
    }
    QCircleLauncher.a(this.a, this.e.k, null, -1);
  }
  
  public void a(QFSPersonalInfo paramQFSPersonalInfo, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131627155;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.b;
  }
  
  protected String getLogTag()
  {
    return "QFSPersonalInfoWidget";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.setCurrentState(Lifecycle.State.STARTED);
  }
  
  @QCirclePersonDetailClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(K, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onInitView(Context paramContext, View paramView)
  {
    findViewById(2131429337);
    this.h = ((TextView)findViewById(2131448603));
    this.h.setMaxWidth(ImmersiveUtils.b() - ImmersiveUtils.a(92.0F));
    this.i = ((ImageView)findViewById(2131436568));
    this.y = ((QCircleFollowView)findViewById(2131448467));
    this.y.setDtParentEmId("em_xsj_bio");
    this.B = ((ImageView)findViewById(2131436246));
    this.j = ((TextView)findViewById(2131448480));
    this.k = ((TextView)findViewById(2131448442));
    this.l = ((TextView)findViewById(2131448471));
    this.s = ((LinearLayout)findViewById(2131437458));
    this.r = ((LinearLayout)findViewById(2131437450));
    this.t = ((LinearLayout)findViewById(2131437452));
    this.p = ((QCircleAvatarView)findViewById(2131436420));
    this.w = new QCircleTagListView();
    this.w.a(paramView);
    this.x = new QCircleTroopTagListView();
    this.x.a(paramView, 0);
    this.v = ((LinearLayout)findViewById(2131437437));
    this.u = ((TextView)findViewById(2131448657));
    this.o = ((TextView)findViewById(2131448658));
    this.q = ((SquareImageView)findViewById(2131436266));
    this.m = ((TextView)findViewById(2131448273));
    this.n = ((TextView)findViewById(2131448573));
    this.E = ((ImageView)findViewById(2131436394));
    this.C = ((QCircleGuideBubbleView)findViewById(2131441607));
    this.D = ((QCircleTailExpandText)findViewById(2131448375));
    this.D.a(ImmersiveUtils.b() - ImmersiveUtils.a(36.0F));
    this.F = ((TextView)findViewById(2131448694));
    this.G = ((ImageView)findViewById(2131436541));
    this.H = ((LinearLayout)findViewById(2131437405));
    this.I = ((LinearLayout)findViewById(2131437557));
    this.J = ((RelativeLayout)findViewById(2131445008));
    this.z = new QCirclePersonHeaderPymkControl();
    this.z.a(paramContext, paramView);
    this.A = new QFSPersonHeaderRankListControl();
    this.A.a(paramContext, paramView);
    b();
    d();
  }
  
  public void release()
  {
    Object localObject = this.z;
    if (localObject != null) {
      ((QCirclePersonHeaderPymkControl)localObject).a();
    }
    localObject = this.A;
    if (localObject != null) {
      ((QFSPersonHeaderRankListControl)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget
 * JD-Core Version:    0.7.0.1
 */