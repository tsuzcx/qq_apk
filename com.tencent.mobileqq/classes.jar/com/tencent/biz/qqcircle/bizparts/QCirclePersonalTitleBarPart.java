package com.tencent.biz.qqcircle.bizparts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleCommonClick;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.Builder;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.ContentIdBuilder;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleBroadcastEvent;
import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class QCirclePersonalTitleBarPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private int A;
  private QCircleInitBean a;
  private FeedCloudMeta.StFeed c;
  private String d;
  private byte[] e = null;
  private FeedCloudMeta.StUser f;
  private FeedCloudRead.StGetMainPageRsp g;
  private QCircleShareInfo h;
  private QQCircleFeedBase.StMainPageBusiRspData i;
  private QCirclePersonalDetailViewModel j;
  private QCirclePublishStatusBoxPart k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private TextView o;
  private RelativeLayout p;
  private QCircleTitleFollowView q;
  private ImageView r;
  private ImageView s;
  private ImageView t;
  private TextView u;
  private ImageView v;
  private ImageView w;
  private boolean x;
  private boolean y;
  private boolean z = false;
  
  static {}
  
  public QCirclePersonalTitleBarPart(QCircleInitBean paramQCircleInitBean)
  {
    this.a = paramQCircleInitBean;
    paramQCircleInitBean = this.a;
    if (paramQCircleInitBean != null)
    {
      this.f = paramQCircleInitBean.getUser();
      this.c = this.a.getFeed();
      this.d = this.c.id.get();
      if (this.c.busiReport.has()) {
        this.e = this.c.busiReport.get().toByteArray();
      }
    }
  }
  
  private void A()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(57).setThrActionType(1).setPageId(f()));
  }
  
  private void B()
  {
    if (this.s == null) {
      return;
    }
    Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
    localObject = QCircleFuelAnimationManager.a("https://sola.gtimg.cn/aoi/sola/20200514172111_1pmImmxMtm.png", new int[] { 34 }, (Drawable)localObject, 3);
    this.s.setImageDrawable((Drawable)localObject);
    ObjectAnimator.ofFloat(this.s, "scaleX", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
    ObjectAnimator.ofFloat(this.s, "scaleY", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
    ApngImage.playByTag(34);
    this.s.setVisibility(0);
  }
  
  private void a(int paramInt)
  {
    if (this.x) {
      return;
    }
    if (QCirclePluginUtil.b(this.f)) {
      return;
    }
    Object localObject = this.q;
    int i2 = 0;
    int i1 = 0;
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    ((QCircleTitleFollowView)localObject).setmCanShowUnfollow(bool);
    if (QCircleFollowManager.getInstance().hasUin(this.f.id.get()))
    {
      if (QCircleFollowManager.getInstance().isUinFollowed(this.f.id.get()))
      {
        this.q.setVisibility(8);
        localObject = this.n;
        paramInt = i1;
        if (QCirclePluginGlobalInfo.k()) {
          paramInt = 8;
        }
        ((ImageView)localObject).setVisibility(paramInt);
      }
    }
    else if (QCirclePluginUtil.c(this.f))
    {
      this.q.setVisibility(8);
      localObject = this.n;
      paramInt = i2;
      if (QCirclePluginGlobalInfo.k()) {
        paramInt = 8;
      }
      ((ImageView)localObject).setVisibility(paramInt);
      return;
    }
    if (paramInt == 2)
    {
      t();
      return;
    }
    u();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("followstate", paramInt1);
    localIntent.putExtra("blackstate", paramInt2);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void b(View paramView)
  {
    this.t = ((ImageView)paramView.findViewById(2131441684));
    this.u = ((TextView)paramView.findViewById(2131441687));
    this.v = ((ImageView)paramView.findViewById(2131441686));
    this.w = ((ImageView)paramView.findViewById(2131441685));
    if ((QCircleFuelAnimationManager.a().e()) && (QCirclePluginUtil.b(this.f)))
    {
      this.s.setVisibility(0);
      B();
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(16).setThrActionType(1).setExt1("1").setPageId(f()));
      return;
    }
    this.s.setVisibility(8);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(16).setThrActionType(1).setExt1("2").setPageId(f()));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.x) {
      return;
    }
    if ((!QCirclePluginUtil.b(this.f)) && (this.q.getVisibility() == 0))
    {
      boolean bool = QCircleFollowManager.getInstance().isUinFollowed(this.f.id.get());
      if ((paramBoolean) && (!bool)) {
        return;
      }
      this.x = true;
      Object localObject = this.n;
      int i1;
      if (QCirclePluginGlobalInfo.k()) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      ((ImageView)localObject).setVisibility(i1);
      this.n.setAlpha(0.0F);
      localObject = ValueAnimator.ofInt(new int[] { ViewUtils.a(24.0F), 0 }).setDuration(300L);
      ((ValueAnimator)localObject).addUpdateListener(new QCirclePersonalTitleBarPart.8(this));
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.q, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.n, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L);
      localObjectAnimator2.setStartDelay(150L);
      localObjectAnimator2.addListener(new QCirclePersonalTitleBarPart.9(this));
      ((ValueAnimator)localObject).start();
      localObjectAnimator1.start();
      localObjectAnimator2.start();
    }
  }
  
  private void n()
  {
    try
    {
      ImageView localImageView = this.r;
      if ((QCircleConfigHelper.ah()) && (localImageView != null) && (QCirclePluginUtil.b(this.f)))
      {
        Context localContext = localImageView.getContext();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("key_sp_profile_page_has_show_invite_guide");
        ((StringBuilder)localObject1).append(HostDataTransUtils.getAccount());
        localObject1 = ((StringBuilder)localObject1).toString();
        if ("1".equals(SharePreferenceUtils.a(localContext, (String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCirclePersonalTitleBar", 1, "no need showInviteGuideBubble");
          }
        }
        else
        {
          Rect localRect = new Rect();
          localImageView.getGlobalVisibleRect(localRect);
          Object localObject2 = new ImageView(localContext);
          ((ImageView)localObject2).setImageResource(2130845237);
          localObject2 = new PopupWindow((View)localObject2, -2, -2);
          ((PopupWindow)localObject2).setOutsideTouchable(true);
          ((PopupWindow)localObject2).setBackgroundDrawable(new ColorDrawable(0));
          int i1 = localRect.left;
          int i2 = ViewUtils.a(10.5F);
          int i3 = localRect.bottom;
          int i4 = ViewUtils.a(3.0F);
          ((PopupWindow)localObject2).showAtLocation(localImageView.getRootView(), 0, i1 - i2, i3 - i4);
          SharePreferenceUtils.a(localContext, (String)localObject1, "1");
          RFThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.2(this, (PopupWindow)localObject2), 5000L);
          if (QLog.isColorLevel())
          {
            QLog.d("QCirclePersonalTitleBar", 1, "showingInviteGuideBubble");
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCirclePersonalTitleBar", 2, "tryShowingInviteGuideBubble error! ", localThrowable);
    }
  }
  
  private void o()
  {
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.p.setOnClickListener(this);
    if (QCircleApplication.isRDMVersion()) {
      this.p.setOnLongClickListener(new QCirclePersonalTitleBarPart.3(this));
    }
  }
  
  private void p()
  {
    QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData;
    if (this.g.busiRspData.get() != null) {
      localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
    }
    try
    {
      localStMainPageBusiRspData.mergeFrom(this.g.busiRspData.get().toByteArray());
      this.i = localStMainPageBusiRspData;
      return;
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    QLog.e("QCirclePersonalTitleBar", 1, "mergeFrom stMainPageBusiRspData error");
  }
  
  private void q()
  {
    if ((this.g.user != null) && (this.g.share != null))
    {
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      Object localObject = new FeedCloudMeta.StUser();
      FeedCloudMeta.StShare localStShare = new FeedCloudMeta.StShare();
      ((FeedCloudMeta.StUser)localObject).set(this.g.user);
      localStShare.set(this.g.share);
      localStFeed.poster = ((FeedCloudMeta.StUser)localObject);
      localStFeed.share = localStShare;
      localObject = new QCircleShareInfo();
      ((QCircleShareInfo)localObject).b = localStFeed;
      this.h = ((QCircleShareInfo)localObject);
    }
  }
  
  private void r()
  {
    Object localObject = this.f;
    int i2 = 8;
    int i1;
    if (localObject != null)
    {
      localObject = this.m;
      if (s()) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
      if (QCirclePluginUtil.b(this.f)) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(2).setThrActionType(1).setPageId(f()));
      }
      this.q.setUserData(this.f);
      this.o.setText(this.f.nick.get());
      localObject = this.r;
      if (QCirclePluginUtil.b(this.f)) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
      if (!QCirclePluginUtil.b(this.f)) {
        this.o.setVisibility(0);
      } else {
        this.o.setVisibility(8);
      }
    }
    localObject = this.n;
    if (QCirclePluginGlobalInfo.k()) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    ((ImageView)localObject).setVisibility(i1);
  }
  
  private boolean s()
  {
    if (QCircleHostGlobalInfo.isCurrentTabActive()) {
      return false;
    }
    return QCirclePluginUtil.b(this.f);
  }
  
  private void t()
  {
    Object localObject = this.q;
    if ((localObject != null) && (this.f != null))
    {
      if (this.n == null) {
        return;
      }
      this.x = true;
      ((QCircleTitleFollowView)localObject).setVisibility(0);
      this.q.setAlpha(0.0F);
      this.q.a(this.f.followState.get());
      localObject = ValueAnimator.ofInt(new int[] { 0, ViewUtils.a(24.0F) }).setDuration(300L);
      ((ValueAnimator)localObject).setStartDelay(150L);
      ((ValueAnimator)localObject).addUpdateListener(new QCirclePersonalTitleBarPart.5(this));
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.q, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L);
      localObjectAnimator1.setStartDelay(150L);
      localObjectAnimator1.addListener(new QCirclePersonalTitleBarPart.6(this));
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.n, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      localObjectAnimator2.addListener(new QCirclePersonalTitleBarPart.7(this));
      ((ValueAnimator)localObject).start();
      localObjectAnimator1.start();
      localObjectAnimator2.start();
      v();
    }
  }
  
  private void u()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      if (this.n == null) {
        return;
      }
      int i2 = ((QCircleTitleFollowView)localObject).getVisibility();
      int i1 = 0;
      if (i2 == 0)
      {
        b(false);
        return;
      }
      this.q.setVisibility(8);
      localObject = this.n;
      if (QCirclePluginGlobalInfo.k()) {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
    }
  }
  
  private void v()
  {
    if (!this.y)
    {
      this.y = true;
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(3).setThrActionType(1).setExt1(String.valueOf(this.f.followState.get())).setExt2("1").setExt9(this.d).setFeedReportInfo(this.e).setPageId(f()));
    }
  }
  
  private void w()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((FeedCloudMeta.StUser)localObject).get() != null))
    {
      localObject = this.h;
      if (localObject != null)
      {
        ((QCircleShareInfo)localObject).d = 1;
        ((QCircleShareInfo)localObject).j = false;
      }
      c("share_action_show_share_sheet", this.h);
    }
  }
  
  private void x()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((FeedCloudMeta.StUser)localObject).get() != null))
    {
      ActionSheet localActionSheet = ActionSheet.a(g());
      if (QCirclePluginUtil.b(this.f))
      {
        localActionSheet.a(2131895943, 0);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(34).setThrActionType(1));
        localObject = this.i;
        if ((localObject != null) && (((QQCircleFeedBase.StMainPageBusiRspData)localObject).urlInfo != null))
        {
          String str = QCircleJsUrlConfig.a(this.i.urlInfo.get(), "personalInviteUrl");
          localObject = str;
          if ((TextUtils.isEmpty(str) ^ true))
          {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(31).setThrActionType(1));
            localActionSheet.a(2131895766, 0);
            localObject = str;
          }
        }
        else
        {
          localObject = "";
        }
        localActionSheet.a(2131895910, 0);
        localActionSheet.a(2131895907, 0);
        localActionSheet.e(2131887648);
        localActionSheet.a(new QCirclePersonalTitleBarPart.11(this, localActionSheet, (String)localObject));
      }
      else
      {
        localObject = new int[5];
        Object tmp233_232 = localObject;
        tmp233_232[0] = -1;
        Object tmp237_233 = tmp233_232;
        tmp237_233[1] = -1;
        Object tmp241_237 = tmp237_233;
        tmp241_237[2] = -1;
        Object tmp245_241 = tmp241_237;
        tmp245_241[3] = -1;
        Object tmp249_245 = tmp245_241;
        tmp249_245[4] = -1;
        tmp249_245;
        int i1;
        if (this.f.blackState.get() == 0)
        {
          localActionSheet.a(2131895750, 0);
          localObject[0] = 3;
          A();
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (this.f.blackState.get() == 0)
        {
          localActionSheet.a(2131895910, 0);
          int i2 = i1 + 1;
          localObject[i1] = 0;
          i1 = i2;
        }
        localActionSheet.a(2131895888, 0);
        localObject[i1] = 1;
        if ((!QCirclePluginUtil.b(this.f)) && (this.f.blackState.get() != 1) && (this.f.blackState.get() != 3))
        {
          localActionSheet.a(2131895622, 0);
          localObject[(i1 + 1)] = 2;
        }
        localActionSheet.e(2131887648);
        localActionSheet.a(new QCirclePersonalTitleBarPart.12(this, (int[])localObject, localActionSheet));
      }
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
    }
  }
  
  private void y()
  {
    QCircleCustomDialog.a(c(), null, HardCodeUtil.a(2131895624), 2131887648, 2131892267, new QCirclePersonalTitleBarPart.13(this), new QCirclePersonalTitleBarPart.14(this)).show();
  }
  
  private void z()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(57).setThrActionType(2));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QCircleConfigHelper.az());
    ((StringBuilder)localObject).append("&touin=");
    ((StringBuilder)localObject).append(this.f.id.get());
    ((StringBuilder)localObject).append("&sex=");
    ((StringBuilder)localObject).append(this.f.sex.get());
    localObject = ((StringBuilder)localObject).toString();
    QCircleLauncher.a(g(), (String)localObject, null, -1);
  }
  
  public String a()
  {
    return "QCirclePersonalTitleBar";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if ((this.f != null) && ((c() instanceof CompatPublicActivity)))
    {
      ((CompatPublicActivity)c()).getSupportFragmentManager().getFragments();
      BasePartFragment localBasePartFragment = (BasePartFragment)((CompatPublicActivity)c()).getSupportFragmentManager().getFragments().get(0);
      this.k = new QCirclePublishStatusBoxPart(this.f);
      this.k.a(localBasePartFragment, paramView, localBasePartFragment.p());
      this.k.a(paramView);
      this.k.a(d());
    }
    this.l = ((ImageView)paramView.findViewById(2131436618));
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.l);
    }
    this.m = ((ImageView)paramView.findViewById(2131436621));
    this.n = ((ImageView)paramView.findViewById(2131436620));
    this.o = ((TextView)paramView.findViewById(2131448818));
    this.q = ((QCircleTitleFollowView)paramView.findViewById(2131448816));
    this.p = ((RelativeLayout)paramView.findViewById(2131445044));
    this.q.setDtParentEmId("em_xsj_top_actionbar");
    this.q.setItemReportListener(new QCirclePersonalTitleBarPart.1(this));
    this.r = ((ImageView)paramView.findViewById(2131436623));
    this.s = ((ImageView)paramView.findViewById(2131436624));
    this.A = this.o.getCurrentTextColor();
    o();
    i();
    r();
    b(paramView);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (c() != null) {
      c().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "personal_page_action_title_bar_animation"))
    {
      if ((paramObject instanceof Message))
      {
        int i1 = ((Message)paramObject).what;
        this.o.setAlpha(i1);
        this.o.setTextColor(Color.argb(i1, Color.red(this.A), Color.green(this.A), Color.blue(this.A)));
        if (!QCirclePluginUtil.b(this.f)) {
          this.o.setVisibility(0);
        } else {
          this.o.setVisibility(8);
        }
        if (i1 == 0)
        {
          this.o.setVisibility(8);
          return;
        }
        if (i1 >= Color.alpha(this.A)) {
          this.o.setTextColor(this.A);
        }
      }
    }
    else
    {
      if (TextUtils.equals(paramString, "personal_page_action_title_bar_follow_animation"))
      {
        a(((Message)paramObject).what);
        return;
      }
      if (TextUtils.equals(paramString, "personal_page_action_title_bar_hide_follow_animation")) {
        b(true);
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFuelAnimationEvent.class);
    localArrayList.add(QCircleGoToCardSettingEvent.class);
    localArrayList.add(QCircleSpecialFollowUpdateEvent.class);
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void i()
  {
    this.j = ((QCirclePersonalDetailViewModel)a(QCirclePersonalDetailViewModel.class));
    this.j.b().observe(j(), new QCirclePersonalTitleBarPart.4(this));
  }
  
  public void l()
  {
    String str1 = QCircleEvilReportUtils.a(this.f.id.get());
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = new QCircleEvilReportInfo.ContentIdBuilder().g("1").a();
    QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().c("wezone_profile").d("25015").e(str1).g(str2).a());
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f.id.get()).setActionType(11).setSubActionType(8).setThrActionType(0).setExt9(this.d).setFeedReportInfo(this.e).setPageId(f()));
  }
  
  public void m()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleBroadcastEvent("qcircle_personal_page_scroll_to_top_and_refresh"));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
    QCirclePublishStatusBoxPart localQCirclePublishStatusBoxPart = this.k;
    if (localQCirclePublishStatusBoxPart != null) {
      localQCirclePublishStatusBoxPart.onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.z = true;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QCirclePublishStatusBoxPart localQCirclePublishStatusBoxPart = this.k;
    if (localQCirclePublishStatusBoxPart != null) {
      localQCirclePublishStatusBoxPart.onActivityResumed(paramActivity);
    }
    RFThreadManager.getUIHandler().postDelayed(new QCirclePersonalTitleBarPart.15(this), 500L);
    this.z = false;
  }
  
  @QCircleCommonClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(B, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart
 * JD-Core Version:    0.7.0.1
 */