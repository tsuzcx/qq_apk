package com.tencent.biz.qqcircle.immersive.personal.part;

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
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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
import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.QFSBasePart;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.qqcircle.richframework.compat.CompatSlideFragment;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.QCircleHippyBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QFSPersonalTitleBarPart
  extends QFSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private QFSPersonalViewModel a;
  private Observer<QFSPersonalInfo> b;
  private Observer<FeedCloudMeta.StFeed> c;
  private QFSPersonalInfo d;
  private String e = "";
  private String f = "";
  private volatile byte[] g;
  private QCircleShareInfo h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private TextView l;
  private RelativeLayout m;
  private QCircleTitleFollowView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private ImageView r;
  private boolean s;
  private boolean t;
  private boolean u = false;
  private int v;
  
  static {}
  
  private void A()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(57).setThrActionType(1).setPageId(i()));
  }
  
  private void B()
  {
    if (this.p == null) {
      return;
    }
    Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
    localObject = QCircleFuelAnimationManager.a("https://sola.gtimg.cn/aoi/sola/20200514172111_1pmImmxMtm.png", new int[] { 34 }, (Drawable)localObject, 3);
    this.p.setImageDrawable((Drawable)localObject);
    ObjectAnimator.ofFloat(this.p, "scaleX", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
    ObjectAnimator.ofFloat(this.p, "scaleY", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
    ApngImage.playByTag(34);
    this.p.setVisibility(0);
  }
  
  private void a(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    this.l.setAlpha(paramInt);
    this.l.setTextColor(Color.argb(paramInt, Color.red(this.v), Color.green(this.v), Color.blue(this.v)));
    TextView localTextView = this.l;
    int i1;
    if (this.d.v) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localTextView.setVisibility(i1);
    if (paramInt == 0)
    {
      this.l.setVisibility(8);
      return;
    }
    if (paramInt >= Color.alpha(this.v)) {
      this.l.setTextColor(this.v);
    }
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
  
  private void a(QCircleGoToCardSettingEvent paramQCircleGoToCardSettingEvent)
  {
    if (this.d.z == null) {
      return;
    }
    if (paramQCircleGoToCardSettingEvent.mShowCard)
    {
      if ((this.d.M != null) && (!this.d.M.contains(Integer.valueOf(3)))) {
        this.d.M.add(Integer.valueOf(3));
      }
    }
    else if ((this.d.M != null) && (this.d.M.contains(Integer.valueOf(3)))) {
      this.d.M.remove(Integer.valueOf(3));
    }
  }
  
  private void a(QCircleSpecialFollowUpdateEvent paramQCircleSpecialFollowUpdateEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(QCircleSyncToTroopSettingEvent paramQCircleSyncToTroopSettingEvent)
  {
    if (this.d.z == null) {
      return;
    }
    if (paramQCircleSyncToTroopSettingEvent.mCanSyncTroopARK)
    {
      if ((this.d.M != null) && (!this.d.M.contains(Integer.valueOf(4)))) {
        this.d.M.add(Integer.valueOf(4));
      }
    }
    else if ((this.d.M != null) && (this.d.M.contains(Integer.valueOf(4)))) {
      this.d.M.remove(Integer.valueOf(4));
    }
  }
  
  private void a(QFSPersonalInfo paramQFSPersonalInfo)
  {
    if (paramQFSPersonalInfo == null)
    {
      QLog.e("QFSPersonalTitleBarPart", 1, "mPersonalInfo is null");
      return;
    }
    this.d = paramQFSPersonalInfo;
    this.e = paramQFSPersonalInfo.c;
    p();
    q();
  }
  
  private void a(QCircleFollowUpdateEvent paramQCircleFollowUpdateEvent)
  {
    if (this.d.c.equals(paramQCircleFollowUpdateEvent.mUserId)) {
      this.d.a.followState.set(paramQCircleFollowUpdateEvent.mFollowStatus);
    }
  }
  
  private void a(QCircleFuelAnimationEvent paramQCircleFuelAnimationEvent)
  {
    if ((this.d.v) && (!this.u))
    {
      if (!QCircleFuelAnimationManager.a().c()) {
        return;
      }
      this.o.postDelayed(new QFSPersonalTitleBarPart.17(this, paramQCircleFuelAnimationEvent), 500L);
    }
  }
  
  private void b(int paramInt)
  {
    if (!this.s)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (((QFSPersonalInfo)localObject).v) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showFollowBtnAnimation() -> uin = ");
        ((StringBuilder)localObject).append(this.d.b());
        ((StringBuilder)localObject).append(" isOwner = ");
        ((StringBuilder)localObject).append(this.d.v);
        QLog.i("QFSPersonalTitleBarPart", 1, ((StringBuilder)localObject).toString());
        localObject = this.n;
        int i2 = 0;
        int i3 = 0;
        int i1 = 0;
        boolean bool;
        if (paramInt == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((QCircleTitleFollowView)localObject).setmCanShowUnfollow(bool);
        if (QCircleFollowManager.getInstance().hasUin(this.e))
        {
          if (QCircleFollowManager.getInstance().isUinFollowed(this.e))
          {
            this.n.setVisibility(8);
            localObject = this.k;
            paramInt = i1;
            if (QCirclePluginGlobalInfo.k()) {
              paramInt = 8;
            }
            ((ImageView)localObject).setVisibility(paramInt);
          }
        }
        else if (QCirclePluginUtil.c(this.d.a))
        {
          this.n.setVisibility(8);
          localObject = this.k;
          paramInt = i2;
          if (QCirclePluginGlobalInfo.k()) {
            paramInt = 8;
          }
          ((ImageView)localObject).setVisibility(paramInt);
          return;
        }
        if (paramInt == 2)
        {
          this.s = true;
          this.n.setVisibility(0);
          this.n.setAlpha(0.0F);
          this.n.a(this.d.a.followState.get());
          localObject = ValueAnimator.ofInt(new int[] { 0, ViewUtils.a(24.0F) }).setDuration(300L);
          ((ValueAnimator)localObject).setStartDelay(150L);
          ((ValueAnimator)localObject).addUpdateListener(new QFSPersonalTitleBarPart.6(this));
          ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.n, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L);
          localObjectAnimator1.setStartDelay(150L);
          localObjectAnimator1.addListener(new QFSPersonalTitleBarPart.7(this));
          ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.k, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
          localObjectAnimator2.addListener(new QFSPersonalTitleBarPart.8(this));
          ((ValueAnimator)localObject).start();
          localObjectAnimator1.start();
          localObjectAnimator2.start();
          if (!this.t)
          {
            this.t = true;
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e).setActionType(11).setSubActionType(3).setThrActionType(1).setExt1(String.valueOf(this.d.a.followState.get())).setExt2("1").setExt9(this.f).setFeedReportInfo(this.g).setPageId(i()));
          }
        }
        else
        {
          if (this.n.getVisibility() == 0)
          {
            b(false);
            return;
          }
          this.n.setVisibility(8);
          localObject = this.k;
          paramInt = i3;
          if (QCirclePluginGlobalInfo.k()) {
            paramInt = 8;
          }
          ((ImageView)localObject).setVisibility(paramInt);
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    this.q = ((ImageView)paramView.findViewById(2131441684));
    this.r = ((ImageView)paramView.findViewById(2131441685));
    paramView = new QCircleLpReportDc05504.DataBuilder().setToUin(this.e).setActionType(11).setSubActionType(16).setThrActionType(1).setPageId(i());
    if ((QCircleFuelAnimationManager.a().e()) && (QCirclePluginUtil.d(this.e)))
    {
      this.p.setVisibility(0);
      B();
      QCircleLpReportDc05504.report(paramView.setExt1("1"));
      return;
    }
    this.p.setVisibility(8);
    QCircleLpReportDc05504.report(paramView.setExt1("2"));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.s) && (!this.d.v))
    {
      int i2 = this.n.getVisibility();
      int i1 = 8;
      if (i2 == 8) {
        return;
      }
      boolean bool = QCircleFollowManager.getInstance().isUinFollowed(this.e);
      if ((paramBoolean) && (!bool)) {
        return;
      }
      this.s = true;
      Object localObject = this.k;
      if (!QCirclePluginGlobalInfo.k()) {
        i1 = 0;
      }
      ((ImageView)localObject).setVisibility(i1);
      this.k.setAlpha(0.0F);
      localObject = ValueAnimator.ofInt(new int[] { ViewUtils.a(24.0F), 0 }).setDuration(300L);
      ((ValueAnimator)localObject).addUpdateListener(new QFSPersonalTitleBarPart.9(this));
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.n, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.k, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L);
      localObjectAnimator2.setStartDelay(150L);
      localObjectAnimator2.addListener(new QFSPersonalTitleBarPart.10(this));
      ((ValueAnimator)localObject).start();
      localObjectAnimator1.start();
      localObjectAnimator2.start();
    }
  }
  
  private void f()
  {
    this.a = ((QFSPersonalViewModel)a(QFSPersonalViewModel.class));
    this.b = new QFSPersonalTitleBarPart.2(this);
    this.c = new QFSPersonalTitleBarPart.3(this);
    this.a.b().observeForever(this.b);
    this.a.f().observeForever(this.c);
    if (this.a.p()) {
      this.n.setVisibility(8);
    }
  }
  
  private void n()
  {
    try
    {
      ImageView localImageView = this.o;
      if ((QCircleConfigHelper.ah()) && (localImageView != null) && (QCirclePluginUtil.d(this.e)))
      {
        Context localContext = localImageView.getContext();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("key_sp_profile_page_has_show_invite_guide");
        ((StringBuilder)localObject1).append(QCircleCommonUtil.getCurrentAccount());
        localObject1 = ((StringBuilder)localObject1).toString();
        if ("1".equals(SharePreferenceUtils.a(localContext, (String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalTitleBarPart", 1, "no need showInviteGuideBubble");
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
          RFThreadManager.getUIHandler().postDelayed(new QFSPersonalTitleBarPart.4(this, (PopupWindow)localObject2), 5000L);
          if (QLog.isColorLevel())
          {
            QLog.d("QFSPersonalTitleBarPart", 1, "showingInviteGuideBubble");
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QFSPersonalTitleBarPart", 2, "tryShowingInviteGuideBubble error! ", localThrowable);
    }
  }
  
  private void o()
  {
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.m.setOnClickListener(this);
    if (QCircleApplication.isRDMVersion()) {
      this.m.setOnLongClickListener(new QFSPersonalTitleBarPart.5(this));
    }
  }
  
  private void p()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((QFSPersonalInfo)localObject1).a != null))
    {
      if (this.d.G == null) {
        return;
      }
      localObject1 = new FeedCloudMeta.StFeed();
      Object localObject2 = new FeedCloudMeta.StUser();
      FeedCloudMeta.StShare localStShare = new FeedCloudMeta.StShare();
      ((FeedCloudMeta.StUser)localObject2).set(this.d.a);
      localStShare.set(this.d.G);
      ((FeedCloudMeta.StFeed)localObject1).poster = ((FeedCloudMeta.StUser)localObject2);
      ((FeedCloudMeta.StFeed)localObject1).share = localStShare;
      localObject2 = new QCircleShareInfo();
      ((QCircleShareInfo)localObject2).b = ((FeedCloudMeta.StFeed)localObject1);
      this.h = ((QCircleShareInfo)localObject2);
    }
  }
  
  private void q()
  {
    Object localObject = this.k;
    boolean bool = QCirclePluginGlobalInfo.k();
    int i2 = 8;
    int i1;
    if (bool) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = this.d;
    if (localObject != null)
    {
      if (((QFSPersonalInfo)localObject).a == null) {
        return;
      }
      localObject = this.j;
      if (this.d.v) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
      if (QCirclePluginUtil.d(this.e)) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.e).setActionType(11).setSubActionType(2).setThrActionType(1).setPageId(i()));
      }
      this.n.setUserData(this.d.a);
      this.l.setText(this.d.a.nick.get());
      localObject = this.o;
      if (this.d.v) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.l;
      if (this.d.v) {
        i1 = i2;
      } else {
        i1 = 0;
      }
      ((TextView)localObject).setVisibility(i1);
    }
  }
  
  private void r()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (!((QFSPersonalInfo)localObject).v) {
        return;
      }
      localObject = new QCircleInitBean();
      ((QCircleInitBean)localObject).setFromReportBean(l().clone());
      QCircleLauncher.f(g(), (QCircleInitBean)localObject);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(2).setThrActionType(2).setPageId(i()));
    }
  }
  
  private void s()
  {
    if (this.d == null) {
      return;
    }
    x();
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(7).setThrActionType(1).setPageId(i()));
  }
  
  private void t()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((QFSPersonalInfo)localObject).v))
    {
      if (TextUtils.isEmpty(this.d.J)) {
        return;
      }
      QCircleLauncher.a(c(), new QCircleHippyBean().setModuleName("WeZoneTask").setDefaultUrl(this.d.J));
      localObject = new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(16).setThrActionType(2).setPageId(i());
      if (this.p.getVisibility() == 0)
      {
        QCircleFuelAnimationManager.a().b(false);
        this.p.postDelayed(new QFSPersonalTitleBarPart.11(this), 1500L);
        QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1("1"));
        return;
      }
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1("2"));
    }
  }
  
  private void u()
  {
    if (v()) {
      return;
    }
    if (c() != null) {
      c().onBackPressed();
    }
  }
  
  private boolean v()
  {
    if ((c() instanceof CompatPublicActivity))
    {
      CompatPublicFragment localCompatPublicFragment = ((CompatPublicActivity)c()).g();
      if ((localCompatPublicFragment instanceof CompatSlideFragment))
      {
        ((CompatSlideFragment)localCompatPublicFragment).a(0);
        return true;
      }
    }
    return false;
  }
  
  private void w()
  {
    if (this.d == null) {
      return;
    }
    QCircleShareInfo localQCircleShareInfo = this.h;
    if (localQCircleShareInfo != null)
    {
      localQCircleShareInfo.d = 1;
      localQCircleShareInfo.j = false;
    }
    c("share_action_show_share_sheet", this.h);
  }
  
  private void x()
  {
    if (this.d == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(g());
    if (this.d.v)
    {
      localActionSheet.a(2131895943, 0);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(34).setThrActionType(1));
      if (this.d.K != null)
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(31).setThrActionType(1));
        localActionSheet.a(2131895766, 0);
      }
      localActionSheet.a(2131895910, 0);
      localActionSheet.a(2131895907, 0);
      localActionSheet.e(2131887648);
      localActionSheet.a(new QFSPersonalTitleBarPart.12(this, localActionSheet));
    }
    else
    {
      int[] arrayOfInt = new int[5];
      int[] tmp166_164 = arrayOfInt;
      tmp166_164[0] = -1;
      int[] tmp170_166 = tmp166_164;
      tmp170_166[1] = -1;
      int[] tmp174_170 = tmp170_166;
      tmp174_170[2] = -1;
      int[] tmp178_174 = tmp174_170;
      tmp178_174[3] = -1;
      int[] tmp182_178 = tmp178_174;
      tmp182_178[4] = -1;
      tmp182_178;
      int i2 = this.d.a.blackState.get();
      int i1;
      if (i2 == 0)
      {
        localActionSheet.a(2131895750, 0);
        arrayOfInt[0] = 3;
        A();
        localActionSheet.a(2131895910, 0);
        arrayOfInt[1] = 0;
        i1 = 2;
      }
      else
      {
        i1 = 0;
      }
      localActionSheet.a(2131895888, 0);
      arrayOfInt[i1] = 1;
      if ((!this.d.v) && (i2 != 1) && (i2 != 3))
      {
        localActionSheet.a(2131895622, 0);
        arrayOfInt[(i1 + 1)] = 2;
      }
      localActionSheet.e(2131887648);
      localActionSheet.a(new QFSPersonalTitleBarPart.13(this, arrayOfInt, localActionSheet));
    }
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void y()
  {
    QCircleCustomDialog.a(c(), null, HardCodeUtil.a(2131895624), 2131887648, 2131892267, new QFSPersonalTitleBarPart.14(this), new QFSPersonalTitleBarPart.15(this)).show();
  }
  
  private void z()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(57).setThrActionType(2));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QCircleConfigHelper.az());
    ((StringBuilder)localObject).append("&touin=");
    ((StringBuilder)localObject).append(this.d.c);
    ((StringBuilder)localObject).append("&sex=");
    ((StringBuilder)localObject).append(this.d.a.sex.get());
    localObject = ((StringBuilder)localObject).toString();
    QCircleLauncher.a(g(), (String)localObject, null, -1);
  }
  
  public String a()
  {
    return "QFSPersonalTitleBarPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.i = ((ImageView)paramView.findViewById(2131436618));
    if ((m() instanceof QCircleBaseFragment)) {
      m().a(this.i);
    }
    this.j = ((ImageView)paramView.findViewById(2131436621));
    this.k = ((ImageView)paramView.findViewById(2131436620));
    this.l = ((TextView)paramView.findViewById(2131448818));
    this.n = ((QCircleTitleFollowView)paramView.findViewById(2131448816));
    this.m = ((RelativeLayout)paramView.findViewById(2131445044));
    this.n.setDtParentEmId("em_xsj_top_actionbar");
    this.n.setItemReportListener(new QFSPersonalTitleBarPart.1(this));
    this.o = ((ImageView)paramView.findViewById(2131436623));
    this.p = ((ImageView)paramView.findViewById(2131436624));
    this.v = this.l.getCurrentTextColor();
    o();
    q();
    b(paramView);
    f();
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
    int i1 = paramString.hashCode();
    if (i1 != -1779099775)
    {
      if (i1 != -1499647271)
      {
        if ((i1 == 672029096) && (paramString.equals("personal_page_action_title_bar_hide_follow_animation")))
        {
          i1 = 2;
          break label82;
        }
      }
      else if (paramString.equals("personal_page_action_title_bar_animation"))
      {
        i1 = 0;
        break label82;
      }
    }
    else if (paramString.equals("personal_page_action_title_bar_follow_animation"))
    {
      i1 = 1;
      break label82;
    }
    i1 = -1;
    label82:
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        b(true);
        return;
      }
      if (!(paramObject instanceof Message)) {
        return;
      }
      i1 = ((Message)paramObject).what;
      paramString = this.a;
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.n())) && (!this.a.p())) {
        b(i1);
      }
    }
    else
    {
      if (!(paramObject instanceof Message)) {
        return;
      }
      a(((Message)paramObject).what);
    }
  }
  
  public void d()
  {
    String str1 = QCircleEvilReportUtils.a(this.d.c);
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = new QCircleEvilReportInfo.ContentIdBuilder().g("1").a();
    QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().c("wezone_profile").d("25015").e(str1).g(str2).a());
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.c).setActionType(11).setSubActionType(8).setThrActionType(0).setExt9(this.f).setFeedReportInfo(this.g).setPageId(i()));
  }
  
  public void e()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleBroadcastEvent("qcircle_personal_page_scroll_to_top_and_refresh"));
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
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    this.a.b().removeObserver(this.b);
    this.a.f().removeObserver(this.c);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.u = true;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    RFThreadManager.getUIHandler().postDelayed(new QFSPersonalTitleBarPart.16(this), 500L);
    this.u = false;
  }
  
  @QCircleCommonClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(w, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QFSPersonalInfo localQFSPersonalInfo = this.d;
    if (localQFSPersonalInfo == null) {
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFuelAnimationEvent))
    {
      a((QCircleFuelAnimationEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent))
    {
      a((QCircleSpecialFollowUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent))
    {
      a((QCircleFollowUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if (((paramSimpleBaseEvent instanceof QCircleGoToCardSettingEvent)) && (localQFSPersonalInfo.b != null))
    {
      a((QCircleGoToCardSettingEvent)paramSimpleBaseEvent);
      return;
    }
    if (((paramSimpleBaseEvent instanceof QCircleSyncToTroopSettingEvent)) && (this.d.z != null)) {
      a((QCircleSyncToTroopSettingEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart
 * JD-Core Version:    0.7.0.1
 */