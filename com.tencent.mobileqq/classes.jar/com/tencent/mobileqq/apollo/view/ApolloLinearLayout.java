package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloActionUsedManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ApolloLinearLayout
  extends LinearLayout
{
  public static int a;
  public static Rect c = new Rect();
  IApolloResManager b;
  public FrameLayout d;
  public FrameLayout e;
  public boolean f = false;
  public ApolloLinearLayout.CheckForLongPress g;
  boolean h;
  View i = null;
  ApolloExtensionObserver j = new ApolloLinearLayout.2(this);
  private BaseChatPie k;
  private SessionInfo l;
  private View m;
  private AtomicInteger n = new AtomicInteger(0);
  private AtomicInteger o = new AtomicInteger(0);
  private int p;
  private int q = 0;
  private ApolloLinearLayout.OnSendListener r;
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(1);
    this.p = paramInt1;
    this.b = ApolloResManagerFacade.a.a(Scene.AIO);
    if (this.p == 4)
    {
      b(paramContext, paramInt2, paramInt3);
      return;
    }
    a(paramContext, paramInt2, paramInt3);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    float f1 = DeviceInfoUtil.h(super.getContext()) / 750.0F;
    int i4 = (int)(15.0F * f1);
    int i1 = (int)(f1 * 30.0F);
    int i5 = (DeviceInfoUtil.h(super.getContext()) - i4 * 2 - i1 * 8) / 4;
    a = i5;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("panel height = ");
      ((StringBuilder)localObject1).append(XPanelContainer.a);
      ((StringBuilder)localObject1).append("imgHeight = ");
      ((StringBuilder)localObject1).append(i5);
      ((StringBuilder)localObject1).append("addHeight=");
      ((StringBuilder)localObject1).append(XPanelContainer.d);
      QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
    }
    i1 = 0;
    while (i1 < paramInt2)
    {
      localObject1 = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(14.0F) + i5 + ViewUtils.dip2px(6.0F));
      localLayoutParams.leftMargin = i4;
      localLayoutParams.rightMargin = i4;
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setShowDividers(0);
      if (i1 == 0) {
        localLayoutParams.topMargin = ViewUtils.dip2px(10.0F);
      } else {
        localLayoutParams.topMargin = ViewUtils.dip2px(6.0F);
      }
      int i2 = 0;
      while (i2 < paramInt1)
      {
        Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        View localView = LayoutInflater.from(paramContext).inflate(2131624189, null);
        ((LinearLayout)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject2).a = ((RelativeLayout)localView.findViewById(2131428430));
        ((ApolloLinearLayout.ViewHolder)localObject2).b = ((ImageView)localView.findViewById(2131429021));
        ((ApolloLinearLayout.ViewHolder)localObject2).l = ((TextView)localView.findViewById(2131428428));
        ((ApolloLinearLayout.ViewHolder)localObject2).m = ((ImageView)localView.findViewById(2131428426));
        ((ApolloLinearLayout.ViewHolder)localObject2).n = ((RelativeLayout)localView.findViewById(2131428427));
        Object localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).height = i5;
        ((RelativeLayout.LayoutParams)localObject3).width = i5;
        ((ApolloLinearLayout.ViewHolder)localObject2).c = ((TextView)localView.findViewById(2131428461));
        ((ApolloLinearLayout.ViewHolder)localObject2).d = ((URLImageView)localView.findViewById(2131428464));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).d.getLayoutParams();
        int i3 = i5 / 2;
        ((RelativeLayout.LayoutParams)localObject3).width = i3;
        ((RelativeLayout.LayoutParams)localObject3).height = i3;
        ((ApolloLinearLayout.ViewHolder)localObject2).g = ((RelativeLayout)localView.findViewById(2131428467));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).g.getLayoutParams();
        f1 = 8.0F;
        ((RelativeLayout.LayoutParams)localObject3).width = ((i5 + ViewUtils.dip2px(8.0F)) / 2);
        i3 = XPanelContainer.d;
        float f2 = 16.0F;
        if (i3 > 0) {
          i3 = ViewUtils.dip2px(16.0F);
        } else {
          i3 = ViewUtils.dip2px(12.0F);
        }
        ((RelativeLayout.LayoutParams)localObject3).height = i3;
        ((ApolloLinearLayout.ViewHolder)localObject2).f = ((TextView)localView.findViewById(2131428460));
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject2).f;
        if (XPanelContainer.d <= 0) {
          f1 = 6.0F;
        }
        ((TextView)localObject3).setTextSize(f1);
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).f.getLayoutParams();
        if (XPanelContainer.d > 0) {
          f1 = f2;
        } else {
          f1 = 10.0F;
        }
        ((RelativeLayout.LayoutParams)localObject3).width = ((i5 - ViewUtils.dip2px(f1)) / 2);
        ((ApolloLinearLayout.ViewHolder)localObject2).e = ((ImageView)localView.findViewById(2131428466));
        ((ApolloLinearLayout.ViewHolder)localObject2).h = ((ImageView)localView.findViewById(2131428463));
        ((ApolloLinearLayout.ViewHolder)localObject2).i = ((ImageView)localView.findViewById(2131428465));
        ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).i.getLayoutParams()).width = ((i5 - ViewUtils.dip2px(4.0F)) / 2);
        localView.setTag(localObject2);
        i2 += 1;
      }
      super.addView((View)localObject1, localLayoutParams);
      i1 += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (!this.h)
    {
      paramMotionEvent = this.g;
      if (paramMotionEvent != null) {
        super.removeCallbacks(paramMotionEvent);
      }
    }
    paramMotionEvent = this.m;
    if ((paramMotionEvent != null) && (!this.h)) {
      a(paramMotionEvent);
    }
    paramMotionEvent = this.i;
    if ((paramMotionEvent != null) && (paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
    {
      paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
      if (paramMotionEvent.b != null) {
        paramMotionEvent.b.setImageDrawable(null);
      }
    }
    b();
    this.m = null;
  }
  
  private void a(ApolloInfo paramApolloInfo)
  {
    int i2 = this.l.a;
    int i1 = 1;
    Object localObject1;
    String str;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (CmShowAioMatcherImpl.judgeSupported(i2, 1))
    {
      localObject1 = this.k.d;
      str = this.l.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramApolloInfo.mAction.actionId);
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("655_");
      localStringBuilder.append(paramApolloInfo.mPackageId);
      VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "action_clk", str, -1, 0, new String[] { localObject2, localStringBuilder.toString(), "", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
    else if ((CmShowAioMatcherImpl.judgeSupported(this.l.a, 2)) && (paramApolloInfo.mAction.personNum == 0))
    {
      localObject1 = this.k.d;
      str = this.l.b;
      i2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.l.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramApolloInfo.mAction.actionId);
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("655_");
      localStringBuilder.append(paramApolloInfo.mPackageId);
      VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "g_action_single_clk", str, -1, i2, new String[] { localObject2, localStringBuilder.toString(), "", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
    if (paramApolloInfo.mPackageId == 9)
    {
      VipUtils.a(this.k.d, "cmshow", "Apollo", "y_bqclick", this.l.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.l.a), 0, new String[] { String.valueOf(paramApolloInfo.mAction.personNum), String.valueOf(paramApolloInfo.mAction.actionId), "", "" });
      ApolloDtReportUtil.a("panel", "sticker", "click", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.k.d)).b(ApolloDtReportUtil.a(this.l.a)).f(String.valueOf(paramApolloInfo.mAction.actionId)).c(this.l.b).a());
    }
    if (this.q == 1) {
      ApolloDtReportUtil.a("aio", "emojicmtab", "clicksticker", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.k.d)).b(ApolloDtReportUtil.a(this.l.a)).f(String.valueOf(paramApolloInfo.mAction.actionId)).k(EmoticonPanelCmShowHelper.a()).b(Integer.valueOf(EmoticonPanelCmShowHelper.b())).c(this.l.b).a());
    } else {
      ApolloDtReportUtil.a("panel", ApolloDtReportUtil.b(paramApolloInfo.mPackageId), "click", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.k.d)).b(ApolloDtReportUtil.a(this.l.a)).f(String.valueOf(paramApolloInfo.mAction.actionId)).c(this.l.b).a());
    }
    if ((ApolloDtReportUtil.a.containsKey(Integer.valueOf(paramApolloInfo.mPackageId))) && (ApolloDtReportUtil.a.get(Integer.valueOf(paramApolloInfo.mPackageId)) != null))
    {
      localObject1 = new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.k.d)).b(ApolloDtReportUtil.a(this.l.a));
      if (paramApolloInfo.mPackageId != 9) {
        i1 = 0;
      }
      ApolloDtReportUtil.a("aio", "tagpage", "clicktagaction", ((DtReportParamsBuilder)localObject1).c(i1).e(paramApolloInfo.mAction.personNum).a((String)ApolloDtReportUtil.a.get(Integer.valueOf(paramApolloInfo.mPackageId))).a());
    }
  }
  
  private static void a(ApolloLinearLayout.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.e.setVisibility(0);
    paramViewHolder.e.setImageResource(paramInt);
  }
  
  private boolean a(View paramView, ApolloInfo paramApolloInfo, ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((paramApolloInfo.mAction.feeType == 6) || (paramApolloInfo.mAction.feeType == 7)) && (!paramBoolean1) && (!paramBoolean2))
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131447459);
      ((RelativeLayout.LayoutParams)localImageView.getLayoutParams()).topMargin = (a / 2 - ViewUtils.dip2px(7.0F));
      localImageView.setVisibility(0);
      paramView.setClickable(false);
      paramView = this.k;
      if ((paramView != null) && (paramView.d != null)) {
        c(paramApolloDaoManagerServiceImpl.findActionById(paramApolloInfo.mAction.actionId));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, ApolloLinearLayout.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.j != null) && (this.k != null))
    {
      if (paramViewHolder.j.mType == 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo shop item = ");
        localStringBuilder.append(paramView.getClass());
        QLog.d("[cmshow]ApolloLinearLayout", 2, localStringBuilder.toString());
        ((IRedTouchManager)this.k.d.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103200");
        if (paramViewHolder.k != null) {
          paramViewHolder.k.g();
        }
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.k.f, null, "aio", ApolloConstant.H, null);
        if (this.l != null) {
          VipUtils.a(this.k.d, "cmshow", "Apollo", "enter_aio_clk", this.l.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.l.a), 0, new String[] { "0", "0", "AioMall", String.valueOf(System.currentTimeMillis() / 1000L) });
        }
        return true;
      }
      if (paramViewHolder.j.mType == 2)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("apollo fav manager item = ");
        paramViewHolder.append(paramView.getClass());
        QLog.d("[cmshow]ApolloLinearLayout", 2, paramViewHolder.toString());
        paramView = new Intent();
        paramView.putExtra("extra_key_url_append", "&view=customize_action");
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.k.f, paramView, "aio", ApolloConstant.H, null);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ApolloInfo paramApolloInfo, boolean paramBoolean)
  {
    return (paramApolloInfo.mAction.feeType == 9) && (!paramBoolean) && (!a(paramApolloInfo.mAction));
  }
  
  private boolean a(ApolloInfo paramApolloInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramApolloInfo.mAction.feeType == 2) && (!paramBoolean1) && (!paramBoolean2))
    {
      Object localObject = this.k;
      if ((localObject != null) && (((BaseChatPie)localObject).d != null))
      {
        localObject = ((ApolloManagerServiceImpl)this.k.d.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
        if (localObject != null) {
          ((ApolloPanelManager)localObject).a(this.k, paramApolloInfo);
        }
      }
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext, int paramInt1, int paramInt2)
  {
    int i4 = (int)((DeviceInfoUtil.h(super.getContext()) - (ViewUtils.dip2px(20.0F) + ViewUtils.dip2px(10.0F) + ViewUtils.dip2px(20.0F))) / 2 * 0.3765432F);
    a = i4;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("panel height = ");
      ((StringBuilder)localObject1).append(XPanelContainer.a);
      ((StringBuilder)localObject1).append("imgHeight = ");
      ((StringBuilder)localObject1).append(i4);
      ((StringBuilder)localObject1).append("addHeight=");
      ((StringBuilder)localObject1).append(XPanelContainer.d);
      QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = 0;
    while (i1 < paramInt2)
    {
      localObject1 = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, i4);
      localLayoutParams.leftMargin = ViewUtils.dip2px(10.0F);
      localLayoutParams.rightMargin = ViewUtils.dip2px(20.0F);
      ((LinearLayout)localObject1).setOrientation(0);
      if (i1 == 1) {
        localLayoutParams.topMargin = ViewUtils.dip2px(10.0F);
      }
      int i2 = 0;
      while (i2 < paramInt1)
      {
        Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(10.0F);
        View localView = LayoutInflater.from(paramContext).inflate(2131624190, null);
        ((LinearLayout)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject2).a = ((RelativeLayout)localView.findViewById(2131428430));
        ((ApolloLinearLayout.ViewHolder)localObject2).b = ((ImageView)localView.findViewById(2131429021));
        ((ApolloLinearLayout.ViewHolder)localObject2).l = ((TextView)localView.findViewById(2131428428));
        ((ApolloLinearLayout.ViewHolder)localObject2).m = ((ImageView)localView.findViewById(2131428426));
        ((ApolloLinearLayout.ViewHolder)localObject2).n = ((RelativeLayout)localView.findViewById(2131428427));
        Object localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).height = i4;
        ((RelativeLayout.LayoutParams)localObject3).width = i4;
        ((ApolloLinearLayout.ViewHolder)localObject2).c = ((TextView)localView.findViewById(2131428461));
        ((ApolloLinearLayout.ViewHolder)localObject2).d = ((URLImageView)localView.findViewById(2131428464));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).d.getLayoutParams();
        int i3 = i4 / 2;
        ((RelativeLayout.LayoutParams)localObject3).width = i3;
        ((RelativeLayout.LayoutParams)localObject3).height = i3;
        ((ApolloLinearLayout.ViewHolder)localObject2).g = ((RelativeLayout)localView.findViewById(2131428467));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).g.getLayoutParams();
        float f1 = 8.0F;
        ((RelativeLayout.LayoutParams)localObject3).width = ((i4 + ViewUtils.dip2px(8.0F)) / 2);
        i3 = XPanelContainer.d;
        float f2 = 16.0F;
        if (i3 > 0) {
          i3 = ViewUtils.dip2px(16.0F);
        } else {
          i3 = ViewUtils.dip2px(12.0F);
        }
        ((RelativeLayout.LayoutParams)localObject3).height = i3;
        ((ApolloLinearLayout.ViewHolder)localObject2).f = ((TextView)localView.findViewById(2131428460));
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject2).f;
        if (XPanelContainer.d <= 0) {
          f1 = 6.0F;
        }
        ((TextView)localObject3).setTextSize(f1);
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).f.getLayoutParams();
        if (XPanelContainer.d > 0) {
          f1 = f2;
        } else {
          f1 = 10.0F;
        }
        ((RelativeLayout.LayoutParams)localObject3).width = ((i4 - ViewUtils.dip2px(f1)) / 2);
        ((ApolloLinearLayout.ViewHolder)localObject2).e = ((ImageView)localView.findViewById(2131428466));
        ((ApolloLinearLayout.ViewHolder)localObject2).h = ((ImageView)localView.findViewById(2131428463));
        ((ApolloLinearLayout.ViewHolder)localObject2).i = ((ImageView)localView.findViewById(2131428465));
        ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).i.getLayoutParams()).width = ((i4 - ViewUtils.dip2px(4.0F)) / 2);
        localView.setTag(localObject2);
        i2 += 1;
      }
      super.addView((View)localObject1, localLayoutParams);
      i1 += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.h = false;
    this.m = a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (this.m != null)
    {
      if (this.g == null) {
        this.g = new ApolloLinearLayout.CheckForLongPress(this);
      }
      this.g.a();
      super.postDelayed(this.g, ViewConfiguration.getLongPressTimeout());
      paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.m.getTag();
      if ((paramMotionEvent != null) && (paramMotionEvent.b != null) && (paramMotionEvent.j != null))
      {
        paramMotionEvent.b.setImageResource(2130838585);
        this.i = this.m;
      }
    }
  }
  
  private void b(ApolloInfo paramApolloInfo)
  {
    ApolloPanelManager localApolloPanelManager = ((ApolloManagerServiceImpl)this.k.d.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
    if (localApolloPanelManager != null)
    {
      BaseChatPie localBaseChatPie = this.k;
      if (localBaseChatPie != null)
      {
        localApolloPanelManager.a(localBaseChatPie.bv(), paramApolloInfo);
        if ((paramApolloInfo.mPackageId == 0) || (paramApolloInfo.mPackageId == 1) || (paramApolloInfo.mPackageId == 9)) {
          ApolloActionUsedManager.a(this.k.d).a(paramApolloInfo.mPackageId, paramApolloInfo.mAction.actionId);
        }
        paramApolloInfo = this.r;
        if (paramApolloInfo != null) {
          paramApolloInfo.a();
        }
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.m;
    if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
    {
      paramMotionEvent = this.i;
      if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
      {
        paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
        if (paramMotionEvent.b != null) {
          paramMotionEvent.b.setImageDrawable(null);
        }
      }
      paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.m.getTag();
      if (paramMotionEvent.j != null)
      {
        if (paramMotionEvent.j.mAction == null) {
          return;
        }
        if (paramMotionEvent.b != null)
        {
          paramMotionEvent.b.setImageResource(2130838585);
          this.i = this.m;
        }
        if (paramMotionEvent.j.mType == 1) {
          return;
        }
        a(this.m, paramMotionEvent.j);
      }
    }
    else
    {
      b();
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    if ((this.h) && ((!a(this.m, c)) || (!c.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
    {
      this.m = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      c(paramMotionEvent);
      return;
    }
    if (!this.h)
    {
      View localView = this.m;
      if ((localView != null) && ((!a(localView, c)) || (!c.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
        this.m = null;
      }
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    super.setPressed(false);
    paramMotionEvent = this.g;
    if (paramMotionEvent != null) {
      super.removeCallbacks(paramMotionEvent);
    }
    paramMotionEvent = this.i;
    if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
    {
      paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
      if (paramMotionEvent.b != null) {
        paramMotionEvent.b.setImageDrawable(null);
      }
    }
    b();
    this.m = null;
  }
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, ApolloLinearLayout.ViewHolder paramViewHolder)
  {
    if ((paramInt & 0x1) > 0)
    {
      paramViewHolder.i.setImageResource(2130838600);
      paramViewHolder.i.setVisibility(0);
    }
    if ((paramInt & 0x400) > 0)
    {
      paramViewHolder.i.setImageResource(2130838597);
      paramViewHolder.i.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(paramViewHolder, 2130838590);
    }
    if ((paramInt & 0x80) > 0)
    {
      paramViewHolder.f.setVisibility(0);
      paramViewHolder.f.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(paramViewHolder, 2130838593);
    }
    if ((paramInt & 0x200) > 0) {
      a(paramViewHolder, 2130838592);
    }
    if ((paramInt & 0x4) > 0) {
      a(paramViewHolder, 2130838599);
    }
    if ((paramInt & 0x8) > 0) {
      a(paramViewHolder, 2130838599);
    }
    if ((paramInt & 0x10) > 0) {
      a(paramViewHolder, 2130838599);
    }
    if ((paramInt & 0x2) > 0) {
      a(paramViewHolder, 2130838595);
    }
    if ((paramInt & 0x2000) > 0)
    {
      paramViewHolder.e.setVisibility(0);
      ApolloUtilImpl.setApolloVipIcon(paramViewHolder.e, true, true);
    }
    paramApolloActionData = (RelativeLayout.LayoutParams)paramViewHolder.e.getLayoutParams();
    if (paramApolloActionData != null)
    {
      paramApolloActionData.addRule(9);
      paramApolloActionData.addRule(11, 0);
    }
  }
  
  public View a(float paramFloat1, float paramFloat2)
  {
    int i1 = super.getChildCount() - 1;
    while (i1 >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i1);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int i2 = localLinearLayout.getChildCount() - 1;
        while (i2 >= 0)
        {
          View localView = localLinearLayout.getChildAt(i2);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          i2 -= 1;
        }
      }
      i1 -= 1;
    }
    return null;
  }
  
  public void a()
  {
    int i1 = 0;
    while (i1 < super.getChildCount())
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i1);
      int i3 = localLinearLayout.getChildCount();
      int i2 = 0;
      while (i2 < i3)
      {
        Object localObject = localLinearLayout.getChildAt(i2);
        if (localObject != null)
        {
          localObject = (ApolloLinearLayout.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (((ApolloLinearLayout.ViewHolder)localObject).b != null))
          {
            ((ApolloLinearLayout.ViewHolder)localObject).b.setBackgroundDrawable(null);
            ((ApolloLinearLayout.ViewHolder)localObject).b.setImageDrawable(null);
            ((ApolloLinearLayout.ViewHolder)localObject).b.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).c.setText("");
            ((ApolloLinearLayout.ViewHolder)localObject).f.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).e.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).d.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).i.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).h.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).j = null;
            ((ApolloLinearLayout.ViewHolder)localObject).n.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).m.setVisibility(8);
            if (((ApolloLinearLayout.ViewHolder)localObject).k != null) {
              ((ApolloLinearLayout.ViewHolder)localObject).k.g();
            }
            if (((ApolloLinearLayout.ViewHolder)localObject).a != null) {
              ((ApolloLinearLayout.ViewHolder)localObject).a.setBackgroundDrawable(null);
            }
          }
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public void a(View paramView)
  {
    Object localObject1 = (ApolloLinearLayout.ViewHolder)paramView.getTag();
    if (a(paramView, (ApolloLinearLayout.ViewHolder)localObject1)) {
      return;
    }
    if (((ApolloLinearLayout.ViewHolder)localObject1).j != null)
    {
      if (((ApolloLinearLayout.ViewHolder)localObject1).j.mAction == null) {
        return;
      }
      localObject1 = ((ApolloLinearLayout.ViewHolder)localObject1).j;
      ((ApolloInfo)localObject1).mAction.peerUin = null;
      ((ApolloInfo)localObject1).mAction.boy1 = null;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("click action ");
      ((StringBuilder)localObject2).append(((ApolloInfo)localObject1).toString());
      QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject2).toString());
      if (!this.b.c(((ApolloInfo)localObject1).mAction.actionId, ((ApolloInfo)localObject1).mAction.personNum))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("action status = done but res don't exist actionid=");
        ((StringBuilder)localObject2).append(((ApolloInfo)localObject1).mAction.actionId);
        QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject2).toString());
        b(((ApolloInfo)localObject1).mAction);
      }
      localObject2 = this.k;
      if (localObject2 != null)
      {
        if (((BaseChatPie)localObject2).d == null) {
          return;
        }
        a((ApolloInfo)localObject1);
        localObject2 = (ApolloDaoManagerServiceImpl)this.k.d.getRuntimeService(IApolloDaoManagerService.class, "all");
        boolean bool1 = ((ApolloDaoManagerServiceImpl)localObject2).isObtainActionById(((ApolloInfo)localObject1).mAction.actionId);
        boolean bool2 = ((ApolloDaoManagerServiceImpl)localObject2).isLimitFreeActionById(((ApolloInfo)localObject1).mAction.actionId);
        if (a(paramView, (ApolloInfo)localObject1, (ApolloDaoManagerServiceImpl)localObject2, bool1, bool2)) {
          return;
        }
        if (a((ApolloInfo)localObject1, bool1, bool2)) {
          return;
        }
        if (a((ApolloInfo)localObject1, bool2)) {
          return;
        }
        b((ApolloInfo)localObject1);
      }
    }
  }
  
  public void a(View paramView, ApolloInfo paramApolloInfo)
  {
    a(this.k, paramApolloInfo);
  }
  
  protected void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null))
    {
      if (paramApolloInfo == null) {
        return;
      }
      ApolloPanelManager localApolloPanelManager = ((ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
      if (localApolloPanelManager != null) {
        localApolloPanelManager.b(paramBaseChatPie, paramApolloInfo);
      }
    }
  }
  
  public boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  public boolean a(ApolloActionData paramApolloActionData)
  {
    Object localObject1 = this.k;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((BaseChatPie)localObject1).d != null)
      {
        if (paramApolloActionData == null) {
          return false;
        }
        Object localObject2 = (ApolloManagerServiceImpl)this.k.d.getRuntimeService(IApolloManagerService.class, "all");
        localObject1 = new HashMap();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(ApolloConstant.s);
        ((StringBuilder)localObject3).append("&actionId=");
        ((StringBuilder)localObject3).append(paramApolloActionData.actionId);
        ((StringBuilder)localObject3).append("&_bid=2282");
        ((StringBuilder)localObject3).toString();
        if (!((ApolloManagerServiceImpl)localObject2).isSuperYellow(this.k.d.getCurrentUin()))
        {
          localObject2 = super.getResources().getString(2131886691);
          localObject3 = super.getResources().getString(2131886692);
          String str = super.getResources().getString(2131886690);
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(ApolloConstant.s);
          ((StringBuilder)localObject4).append("&actionId=");
          ((StringBuilder)localObject4).append(paramApolloActionData.actionId);
          ((StringBuilder)localObject4).append("&_bid=2282");
          localObject4 = ((StringBuilder)localObject4).toString();
          if (this.l != null)
          {
            QQAppInterface localQQAppInterface = this.k.d;
            int i1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.l.a);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramApolloActionData.actionId);
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "vip_alert_show", i1, 0, new String[] { localStringBuilder.toString(), "0" });
          }
          ((Map)localObject1).put("APOLLO_POP_TYPE", "dialog");
          ((Map)localObject1).put("feeType", String.valueOf(paramApolloActionData.feeType));
          ((Map)localObject1).put("title", localObject3);
          ((Map)localObject1).put("content", localObject2);
          ((Map)localObject1).put("rightString", str);
          ((Map)localObject1).put("url", localObject4);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramApolloActionData.actionId);
          ((Map)localObject1).put("actionId", ((StringBuilder)localObject2).toString());
          ((Map)localObject1).put("personNum", String.valueOf(paramApolloActionData.personNum));
          paramApolloActionData = this.k;
          if (paramApolloActionData != null)
          {
            if (paramApolloActionData.d == null) {
              return false;
            }
            paramApolloActionData = this.k.d.getHandler(ChatActivity.class);
            bool1 = bool2;
            if (paramApolloActionData != null)
            {
              paramApolloActionData = paramApolloActionData.obtainMessage(45);
              paramApolloActionData.obj = localObject1;
              paramApolloActionData.sendToTarget();
              return false;
            }
          }
          else
          {
            return false;
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if ((this.d != null) && (this.f))
    {
      ((WindowManager)super.getContext().getSystemService("window")).removeViewImmediate(this.e);
      this.f = false;
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    ThreadManager.post(new ApolloLinearLayout.1(this, paramApolloActionData), 5, null, false);
  }
  
  public void c(ApolloActionData paramApolloActionData)
  {
    BaseChatPie localBaseChatPie = this.k;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null))
    {
      if (paramApolloActionData == null) {
        return;
      }
      this.k.d.addObserver(this.j);
      ((ApolloExtensionHandler)this.k.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
      this.n.incrementAndGet();
    }
  }
  
  public View d(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < super.getChildCount())
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i1);
      int i2 = 0;
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (i2 >= localLinearLayout.getChildCount()) {
          break;
        }
        localObject2 = localLinearLayout.getChildAt(i2);
        Object localObject3 = (ApolloLinearLayout.ViewHolder)((View)localObject2).getTag();
        if (localObject3 != null)
        {
          localObject3 = ((ApolloLinearLayout.ViewHolder)localObject3).j;
          if ((localObject3 != null) && (((ApolloInfo)localObject3).mAction != null) && (((ApolloInfo)localObject3).mAction.actionId == paramApolloActionData.actionId)) {
            break;
          }
        }
        i2 += 1;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
          e(paramMotionEvent);
          return true;
        }
        d(paramMotionEvent);
        return true;
      }
      a(paramMotionEvent);
      return true;
    }
    b(paramMotionEvent);
    return true;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.k = paramBaseChatPie;
  }
  
  public void setOnSendListener(ApolloLinearLayout.OnSendListener paramOnSendListener)
  {
    this.r = paramOnSendListener;
  }
  
  public void setPanelType(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.l = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */