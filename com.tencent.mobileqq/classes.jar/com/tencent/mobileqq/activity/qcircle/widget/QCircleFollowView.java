package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.ArrayList;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, SimpleEventReceiver
{
  protected FeedCloudMeta.StUser a = new FeedCloudMeta.StUser();
  protected boolean b = false;
  private String c;
  private QCircleFollowView.ItemPreClickListener d;
  private QCircleFollowView.FollowReportListener e;
  private QCircleFollowView.FollowChangeListener f;
  private boolean g;
  private boolean h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private String p;
  private String q;
  
  public QCircleFollowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFollowView);
    this.k = paramContext.getResourceId(2, 2130845048);
    this.j = paramContext.getResourceId(5, 2130845047);
    this.m = paramContext.getResourceId(0, 2130845049);
    this.l = paramContext.getResourceId(1, 2130845046);
    this.n = paramContext.getColor(3, getResources().getColor(2131165580));
    this.o = paramContext.getColor(6, getResources().getColor(2131167026));
    paramContext.recycle();
    a();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void a(FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp, int paramInt)
  {
    Object localObject = this.a;
    boolean bool = true;
    if (localObject == null)
    {
      QLog.w("QCircleFollowView", 1, "[onReceive] user info not is null.");
      return;
    }
    if (paramInt != 1) {
      bool = false;
    }
    localObject = this.f;
    if (localObject != null) {
      ((QCircleFollowView.FollowChangeListener)localObject).a(bool, this.a);
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(paramInt, this.a.id.get()));
    a(getContext(), this.a.id.get(), paramInt);
    ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.a.id.get(), paramInt);
    if (paramStDoFollowRsp != null) {
      ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.a.id.get(), this.a.nick.get(), bool);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean d()
  {
    if ((this.a.followState.get() == 1) && (this.a.blackState.get() == 2)) {
      return false;
    }
    if ((this.a.blackState.get() != 1) && (this.a.blackState.get() != 3))
    {
      if (this.a.blackState.get() == 2)
      {
        DialogUtil.a(getContext(), 230).setMessage(2131895729).setPositiveButton(2131895760, new QCircleFollowView.1(this)).show();
        return true;
      }
      return false;
    }
    QQToast.makeText(getContext(), 0, 2131895728, 0).show();
    return true;
  }
  
  private void e()
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.setMainTitle(getContext().getResources().getString(2131895940));
    localActionSheet.addButton(2131895941, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new QCircleFollowView.5(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  protected URLDrawable a(int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt);
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void a()
  {
    setOnClickListener(this);
    b();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((FeedCloudMeta.StUser)localObject).followState.set(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin:");
      ((StringBuilder)localObject).append(this.a.id.get());
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QCircleFollowView", 1, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      a(paramBoolean);
      return;
    }
    b();
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!QCircleHostUtil.isOwner(paramStUser)))
    {
      if (((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).hasUin(paramStUser.id.get()))
      {
        this.a.followState.set(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
        a(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
        QCircleFollowView.FollowChangeListener localFollowChangeListener = this.f;
        if (localFollowChangeListener != null)
        {
          int i1 = ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get());
          boolean bool = true;
          if (i1 != 1) {
            bool = false;
          }
          localFollowChangeListener.a(bool, this.a);
        }
      }
    }
    else {
      setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && ((localStUser.blackState.get() == 1) || (this.a.blackState.get() == 3))) {
      setBackgroundResource(this.m);
    } else if (!TextUtils.isEmpty(this.q)) {
      setBackgroundDrawable(a(this.k, this.q));
    } else {
      setBackgroundResource(this.k);
    }
    setTextColor(this.n);
    setText(2131895739);
    if (this.h)
    {
      if (paramBoolean)
      {
        c();
        return;
      }
      setVisibility(8);
    }
  }
  
  protected void b()
  {
    setVisibility(0);
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && (localStUser.blackState.get() != 0)) {
      setBackgroundResource(this.l);
    } else if (!TextUtils.isEmpty(this.p)) {
      setBackgroundDrawable(a(this.j, this.p));
    } else {
      setBackgroundResource(this.j);
    }
    setTextColor(this.o);
    setText(2131895727);
  }
  
  protected void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void c()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillEnabled(false);
    startAnimation(localAlphaAnimation);
    postDelayed(new QCircleFollowView.2(this), 500L);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
    FeedCloudMeta.StUser localStUser = this.a;
    if (localStUser != null)
    {
      QCircleFollowView.FollowReportListener localFollowReportListener = this.e;
      if (localFollowReportListener != null) {
        localFollowReportListener.a(localStUser.followState.get());
      }
    }
    a(this.a);
  }
  
  public void onClick(View paramView)
  {
    if (!FastClickUtils.a("QCircleFollowViewClick"))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        QCircleFollowView.FollowReportListener localFollowReportListener = this.e;
        if (localFollowReportListener != null) {
          localFollowReportListener.b(((FeedCloudMeta.StUser)localObject).followState.get());
        }
        localObject = this.d;
        if (localObject != null) {
          ((QCircleFollowView.ItemPreClickListener)localObject).a();
        }
        if (!d()) {
          if (!QCircleHostUtil.isFollow(this.a)) {
            b(true);
          } else {
            e();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if ((localStUser.id.get().equals(paramSimpleBaseEvent.mUserId)) && (this.a.followState.get() != paramSimpleBaseEvent.mFollowStatus))
      {
        a(paramSimpleBaseEvent.mFollowStatus);
        if (this.f != null)
        {
          int i1 = paramSimpleBaseEvent.mFollowStatus;
          boolean bool = true;
          if (i1 != 1) {
            bool = false;
          }
          this.f.a(bool, this.a);
        }
      }
    }
  }
  
  public void setFollowStateChangeListener(QCircleFollowView.FollowChangeListener paramFollowChangeListener)
  {
    this.f = paramFollowChangeListener;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setFollowedRemoteUrl(String paramString)
  {
    this.q = paramString;
  }
  
  public void setFollowedShowToast(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setFollowedTextColor(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setItemPreClickListener(QCircleFollowView.ItemPreClickListener paramItemPreClickListener)
  {
    this.d = paramItemPreClickListener;
  }
  
  public void setItemReportListener(QCircleFollowView.FollowReportListener paramFollowReportListener)
  {
    this.e = paramFollowReportListener;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setUnFollowRemoteUrl(String paramString)
  {
    this.p = paramString;
  }
  
  public void setUnFollowTextColor(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    setUserData(paramStUser, "");
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser, String paramString)
  {
    if (paramStUser != null)
    {
      this.a.id.set(paramStUser.id.get());
      this.a.nick.set(paramStUser.nick.get());
      this.a.blackState.set(paramStUser.blackState.get());
      if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!QCircleHostUtil.isOwner(paramStUser)))
      {
        if (((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).hasUin(paramStUser.id.get()))
        {
          this.a.followState.set(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
          a(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
        }
        else
        {
          this.a.followState.set(paramStUser.followState.get());
          a(this.a.followState.get());
        }
      }
      else {
        setVisibility(8);
      }
    }
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */