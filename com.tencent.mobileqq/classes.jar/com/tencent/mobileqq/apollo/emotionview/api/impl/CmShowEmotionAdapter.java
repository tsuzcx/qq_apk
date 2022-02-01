package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Space;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.ApolloRelationTag;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter.ViewHolder;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelExtendHelper;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class CmShowEmotionAdapter
  extends BaseEmotionAdapter
  implements ApolloStatusUpdateListener
{
  private static int p;
  private static int q;
  private static int r;
  private static int s;
  private BaseChatPie a;
  private int b;
  private int c;
  private List<ApolloInfo> d;
  private int e = -1;
  private SessionInfo f;
  private IApolloDaoManagerService g;
  private ApolloManagerServiceImpl h;
  private IApolloResManager i;
  private ViewGroup j;
  private boolean k = false;
  private Handler l;
  private ApolloTagActionViewBinder m;
  private View n = null;
  private int o;
  private Runnable t = new CmShowEmotionAdapter.5(this);
  
  public CmShowEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.a = paramBaseChatPie;
    this.f = paramBaseChatPie.ah;
    this.b = 0;
    this.c = paramInt1;
    this.g = ((IApolloDaoManagerService)this.a.d.getRuntimeService(IApolloDaoManagerService.class, "all"));
    this.h = ((ApolloManagerServiceImpl)this.a.d.getRuntimeService(IApolloManagerService.class, "all"));
    this.i = ApolloResManagerFacade.a.a(Scene.AIO);
    this.l = new Handler(Looper.getMainLooper());
    refreshPanelData();
    this.o = d();
    EmoticonPanelCmShowHelper.a(this.o);
    ((ApolloManagerServiceImpl)paramIEmoticonMainPanelApp.getService(IApolloManagerService.class)).addApolloStatusUpdateListener(this);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    int i1 = paramViewGroup.getMeasuredHeight();
    Object localObject1 = AIOEmoticonUIHelper.a(this.a.bv());
    int i2 = 0;
    if ((localObject1 != null) && (((IEmoticonMainPanel)localObject1).getEmoController() != null))
    {
      localObject1 = (IEmoticonPanelExtendHelper)((IEmoticonMainPanel)localObject1).getEmoController().getHelper(1);
      if (localObject1 != null)
      {
        bool = ((IEmoticonPanelExtendHelper)localObject1).isPanelOpen();
        i1 = ((IEmoticonPanelExtendHelper)localObject1).getOriginPanelHeight() - (int)this.mContext.getResources().getDimension(2131297347);
        break label94;
      }
    }
    boolean bool = false;
    label94:
    localObject1 = new LinearLayout(this.mContext);
    ((LinearLayout)localObject1).setOrientation(1);
    int i3 = ViewUtils.dip2px(46.0F);
    int i4 = ViewUtils.dip2px(16.0F);
    int i5 = ViewUtils.dip2px(14.0F);
    if (bool) {
      i2 = (paramViewGroup.getMeasuredHeight() - i1) / 2;
    }
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, i2);
    ((LinearLayout)localObject1).addView(new Space(this.mContext), localLayoutParams1);
    paramViewGroup = new URLImageView(this.mContext);
    paramViewGroup.setId(2131428440);
    i1 = i1 - i3 - i4 - i5;
    Object localObject2 = new LinearLayout.LayoutParams((int)(i1 / 316.0F * 520.0F), i1);
    ((LinearLayout.LayoutParams)localObject2).topMargin = i4;
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = i5;
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    ((LinearLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new Button(this.mContext);
    ((Button)localObject2).setId(2131428468);
    ((Button)localObject2).setText(2131886686);
    ((Button)localObject2).setBackgroundResource(2130838615);
    ((Button)localObject2).setTextSize(22.0F);
    ((Button)localObject2).setTextColor(-1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, i3);
    i1 = ViewUtils.dip2px(12.0F);
    localLayoutParams2.leftMargin = i1;
    localLayoutParams2.rightMargin = i1;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams2);
    ((LinearLayout)localObject1).addView(new Space(this.mContext), localLayoutParams1);
    this.j = ((ViewGroup)localObject1);
    localObject1 = new ColorDrawable();
    paramViewGroup.setBackgroundDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject1, (Drawable)localObject1));
    ((Button)localObject2).setOnClickListener(new CmShowEmotionAdapter.3(this));
    ApolloDtReportUtil.a("aio", "emojicmtab2d", "expose", new DtReportParamsBuilder().k(EmoticonPanelCmShowHelper.a()).b(Integer.valueOf(EmoticonPanelCmShowHelper.b())).a());
    return this.j;
  }
  
  private void a(ApolloLinearLayout paramApolloLinearLayout, int paramInt)
  {
    if (paramApolloLinearLayout == null) {
      return;
    }
    paramApolloLinearLayout.a();
    paramApolloLinearLayout.setSessionInfo(this.f);
    paramApolloLinearLayout.setCallback(this.a);
    paramApolloLinearLayout.setOnSendListener(new CmShowEmotionAdapter.6(this));
    paramApolloLinearLayout = (LinearLayout)paramApolloLinearLayout.getChildAt(0);
    Object localObject1 = (LinearLayout.LayoutParams)paramApolloLinearLayout.getLayoutParams();
    if (localObject1 != null)
    {
      if (paramInt == 0)
      {
        if (this.b != 4) {
          ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.dip2px(16.0F);
        } else {
          ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        }
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
      if (paramInt == getCount() - 1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.dip2px(16.0F);
      }
      if ((paramInt > 0) && (paramInt < getCount() - 1))
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.dip2px(10.0F);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
    }
    int i4 = this.c;
    if (this.d != null)
    {
      int i1 = 0;
      while (i1 < this.c)
      {
        localObject1 = paramApolloLinearLayout.getChildAt(i1);
        ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject1).getTag();
        int i3 = paramInt * i4 + i1;
        if (i3 < this.d.size())
        {
          ((View)localObject1).setVisibility(0);
          localViewHolder.b.setVisibility(0);
          localViewHolder.j = ((ApolloInfo)this.d.get(i3));
          if (this.b == 4) {
            localViewHolder.a.setBackgroundResource(2130838614);
          }
          if (((ApolloInfo)this.d.get(i3)).mAction.isForPlayerAction == 1) {
            QLog.i("[cmshow]CmShowEmotionAdapter", 4, "setBackgroundDrawable getview");
          }
          localViewHolder.b.setBackgroundDrawable(((ApolloInfo)this.d.get(i3)).getPanelDrawable(this.mContext, this.mContext.getResources().getDisplayMetrics().density));
          ApolloActionData localApolloActionData = ((ApolloInfo)this.d.get(i3)).mAction;
          localViewHolder.c.setText(localApolloActionData.actionName);
          if (this.b != 4) {
            localViewHolder.j.mBinderType = 0;
          }
          if ((this.b != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
          {
            localViewHolder.d.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
            localViewHolder.d.setVisibility(0);
          }
          if (!TextUtils.isEmpty(localViewHolder.j.mActionText))
          {
            localViewHolder.l.setVisibility(0);
            localViewHolder.n.setVisibility(0);
            localViewHolder.m.setVisibility(0);
            localViewHolder.l.setText(localViewHolder.j.mActionText);
            if (XPanelContainer.d == 0) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            float f2 = 5.0F;
            if (i2 != 0) {
              f1 = 3.0F;
            } else {
              f1 = 5.0F;
            }
            int i5 = ViewUtils.dip2px(f1);
            localObject2 = (RelativeLayout.LayoutParams)localViewHolder.n.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).topMargin = i5;
            int i6 = ApolloLinearLayout.a;
            int i7 = i5 * 2;
            ((RelativeLayout.LayoutParams)localObject2).width = (i6 - i7);
            localViewHolder.l.setMaxHeight(ApolloLinearLayout.a - i5 * 3);
            localObject2 = (RelativeLayout.LayoutParams)localViewHolder.l.getLayoutParams();
            float f1 = f2;
            if (i2 != 0) {
              f1 = 2.0F;
            }
            ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(f1);
            localViewHolder.m.setBackgroundResource(2130838453);
            if (localViewHolder.j.mTextType == 1)
            {
              if (i2 != 0)
              {
                localViewHolder.l.setTextSize(8.0F);
                if (r == 0) {
                  r = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
                }
                ((RelativeLayout.LayoutParams)localObject2).width = r;
              }
              else
              {
                localViewHolder.l.setMaxHeight(ApolloLinearLayout.a - i7);
                localViewHolder.l.setTextSize(12.0F);
                if (p == 0) {
                  p = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
                }
                ((RelativeLayout.LayoutParams)localObject2).width = p;
              }
              localViewHolder.l.setTextColor(-4473925);
              localViewHolder.n.setBackgroundDrawable(null);
            }
            else
            {
              if (i2 != 0)
              {
                localViewHolder.l.setTextSize(7.0F);
                if (s == 0) {
                  s = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
                }
                ((RelativeLayout.LayoutParams)localObject2).width = s;
              }
              else
              {
                localViewHolder.l.setTextSize(10.0F);
                if (q == 0) {
                  q = ApolloBarrageUtil.a(localViewHolder.l.getPaint());
                }
                ((RelativeLayout.LayoutParams)localObject2).width = q;
              }
              localObject2 = localViewHolder.l;
              if (i2 != 0) {
                f1 = 7.0F;
              } else {
                f1 = 10.0F;
              }
              ((TextView)localObject2).setTextSize(f1);
              localViewHolder.l.setTextColor(-8947849);
              localViewHolder.n.setBackgroundResource(2130838454);
            }
            localObject2 = localViewHolder.n;
            if (i2 != 0) {
              f1 = 3.0F;
            } else {
              f1 = 9.0F;
            }
            ((RelativeLayout)localObject2).setPadding(0, 0, 0, ViewUtils.dip2px(f1));
            localViewHolder.l.setMaxLines(3);
          }
          else
          {
            localViewHolder.m.setBackgroundDrawable(null);
            localViewHolder.l.setVisibility(8);
            localViewHolder.n.setVisibility(8);
            localViewHolder.m.setVisibility(8);
          }
          ApolloLinearLayout.setApolloActionIcon(localViewHolder.j.iconType, localViewHolder.j.mAction, localViewHolder);
          if ((localApolloActionData.personNum == 1) && ((this.f.a == 1) || (this.f.a == 3000))) {
            localViewHolder.h.setVisibility(0);
          }
          Object localObject2 = (RelativeLayout)localObject1;
          int i2 = this.e;
          if ((i2 != -1) && (i2 == i3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmShowEmotionAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.e), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
            }
            if (localViewHolder.o != null)
            {
              ((RelativeLayout)localObject2).removeView(localViewHolder.o);
              localViewHolder.o = null;
            }
            Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131429021);
            ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131429021);
            ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131429021);
            ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131429021);
            RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
            localRelativeLayout.setId(2131428429);
            localRelativeLayout.setBackgroundDrawable(null);
            ((RelativeLayout)localObject2).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject3);
            localViewHolder.o = localRelativeLayout;
            localObject3 = new ImageView(this.mContext);
            ((ImageView)localObject3).setImageResource(2130838611);
            ((ImageView)localObject3).setVisibility(8);
            localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
            ((ImageView)localObject3).postDelayed(new CmShowEmotionAdapter.7(this, (ImageView)localObject3, localRelativeLayout, (RelativeLayout)localObject2, localViewHolder), 200L);
            this.e = -1;
          }
          else if (localViewHolder.o != null)
          {
            ((RelativeLayout)localObject2).removeView(localViewHolder.o);
            localViewHolder.o = null;
          }
          ((View)localObject1).setContentDescription(localApolloActionData.actionName);
          if ((((ApolloInfo)this.d.get(i3)).mAction != null) && (((ApolloInfo)this.d.get(i3)).mAction.isForPlayerAction == 1)) {
            a(localViewHolder, (ApolloInfo)this.d.get(i3));
          }
        }
        else
        {
          ((View)localObject1).setContentDescription(null);
          ((View)localObject1).setOnClickListener(null);
          ((View)localObject1).setVisibility(4);
        }
        i1 += 1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      ApolloDtReportUtil.a("panel", paramString1, paramString2, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.a.d)).b(ApolloDtReportUtil.a(this.a.ah.a)).c(this.a.ah.b).a());
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateOpenCmShowStatus ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("[cmshow]CmShowEmotionAdapter", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean)
    {
      QQToast.makeText(this.mContext, 1, "开启2D厘米秀失败！", 0).show(0);
      a("panel_tips", "fail");
      return;
    }
    QQToast.makeText(this.mContext, 2, "开启2D厘米秀成功！", 0).show(0);
    a("panel_tips", "success");
    localObject = this.j;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    refreshPanelData();
    notifyDataSetChanged();
  }
  
  private void c()
  {
    if (EmoticonPanelCmShowHelper.a() != "1") {
      return;
    }
    if (IntimateUtil.a(this.o))
    {
      if (this.m == null) {
        return;
      }
      Object localObject = ((IApolloDaoManagerService)this.app.getAppRuntime().getRuntimeService(IApolloDaoManagerService.class, "all")).getRelationTagList();
      if (localObject != null)
      {
        if (((List)localObject).size() == 0) {
          return;
        }
        String str = null;
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloRelationTag localApolloRelationTag = (ApolloRelationTag)((Iterator)localObject).next();
          if ((this.o == localApolloRelationTag.type) && (g())) {
            str = localApolloRelationTag.tag2D;
          }
        }
        if (TextUtils.isEmpty(str)) {
          return;
        }
        this.m.b(str);
      }
    }
  }
  
  private int d()
  {
    Object localObject = this.app.getAppRuntime();
    if (localObject != null)
    {
      localObject = ((IFriendExtensionService)((AppRuntime)localObject).getRuntimeService(IFriendExtensionService.class, "")).getExtensionInfo(this.a.ae(), true);
      if (localObject != null) {
        return ((ExtensionInfo)localObject).intimate_type;
      }
    }
    return -1;
  }
  
  private View e()
  {
    this.m = new ApolloTagActionViewBinder(this.mContext, this.a.d, this.f);
    this.m.n = 9;
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.m.a(this.d);
    }
    this.m.a(new CmShowEmotionAdapter.2(this));
    this.m.a();
    localObject = this.m.g();
    this.m.b(false);
    return localObject;
  }
  
  private void f()
  {
    QLog.i("[cmshow]CmShowEmotionAdapter", 4, "openCmShow");
    ((ApolloExtensionHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("guide_open_cmshow", 0, new CmShowEmotionAdapter.4(this));
    this.l.removeCallbacks(this.t);
    this.l.postDelayed(this.t, 10000L);
    ApolloDtReportUtil.a("aio", "emojicmtab2d", "click", new DtReportParamsBuilder().k(EmoticonPanelCmShowHelper.a()).b(Integer.valueOf(EmoticonPanelCmShowHelper.b())).a());
  }
  
  private boolean g()
  {
    return ((ApolloManagerServiceImpl)this.app.getService(IApolloManagerService.class)).getApolloUserStatus() == 1;
  }
  
  private boolean h()
  {
    boolean bool3 = CmShowWnsUtils.W();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((ApolloManagerServiceImpl)this.app.getService(IApolloManagerService.class)).getApolloUserStatus() == 2)
      {
        bool1 = bool2;
        if (CMShowPlatform.a.b(Scene.MEME_PLAYER)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a()
  {
    boolean bool = g();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CmShowEmotionAdapter.onShow ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("[cmshow]CmShowEmotionAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (((bool) && (this.k)) || ((!bool) && (!this.k))) {
      notifyDataSetChanged();
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((ApolloTagActionViewBinder)localObject).b(true);
    }
    c();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Handler localHandler = this.l;
    if (localHandler != null) {
      localHandler.post(new CmShowEmotionAdapter.1(this));
    }
  }
  
  public void a(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMemeGetFrame : ");
    localStringBuilder.append(paramApolloInfo.toString());
    QLog.d("[cmshow]CmShowEmotionAdapter", 4, localStringBuilder.toString());
    this.h.handleMemeGetFrame("[cmshow]CmShowEmotionAdapter", paramApolloInfo.mAction, new CmShowEmotionAdapter.8(this, paramViewHolder, paramApolloInfo), this.i);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CmShowEmotionAdapter.onSelected ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("[cmshow]CmShowEmotionAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((ApolloTagActionViewBinder)localObject).b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmShowEmotionAdapter", 2, "CmShowEmotionAdapter.onHide");
    }
  }
  
  public int getCount()
  {
    if ((!g()) && (!h())) {
      return 1;
    }
    List localList = this.d;
    int i1;
    if (localList != null)
    {
      int i2 = localList.size() / this.c;
      i1 = i2;
      if (this.d.size() % this.c != 0) {
        return i2 + 1;
      }
    }
    else
    {
      i1 = 0;
    }
    return i1;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((!g()) && (!h()))
    {
      paramViewHolder = a(paramViewGroup);
      this.k = true;
      return paramViewHolder;
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("getEmotionView position = ");
        paramView.append(paramInt);
        paramView.append("; view from inflater");
        QLog.d("[cmshow]CmShowEmotionAdapter", 2, paramView.toString());
      }
      paramViewGroup = new ApolloLinearLayout(this.mContext, null, this.b, this.columnNum, 1);
      paramViewGroup.setPanelType(1);
    }
    a((ApolloLinearLayout)paramViewGroup, paramInt);
    paramViewGroup.setTag(paramViewHolder);
    this.k = false;
    return paramViewGroup;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new CmShowEmotionAdapter.CmShowEmotionViewHolder();
  }
  
  public void refreshPanelData()
  {
    String str = this.app.getCurrentAccountUin();
    this.d = new ArrayList();
    Object localObject1 = this.f;
    if (localObject1 != null) {
      localObject1 = this.g.getPackageInfoBySession(((SessionInfo)localObject1).a);
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      boolean bool = g();
      int i1 = 9;
      if (!bool) {
        if (h()) {
          i1 = 303;
        } else {
          QLog.d("[cmshow]CmShowEmotionAdapter", 1, "refreshPanelData failed, both 2D and 3D not support. ");
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshPanelData pageId = ");
      ((StringBuilder)localObject1).append(i1);
      QLog.d("[cmshow]CmShowEmotionAdapter", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.g.getActionByPackageId(i1);
      List localList = this.g.getPackageActionDataById(i1);
      if ((localObject1 != null) && (((List)localObject1).size() >= 1))
      {
        if ((localList != null) && (localList.size() >= 1))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("refreshPanelData actionPackageDatas.size = ");
          ((StringBuilder)localObject2).append(((List)localObject1).size());
          ((StringBuilder)localObject2).append("  actionInfoList.size =");
          ((StringBuilder)localObject2).append(localList.size());
          QLog.d("[cmshow]CmShowEmotionAdapter", 1, ((StringBuilder)localObject2).toString());
          int i3 = ((List)localObject1).size();
          int i2 = 0;
          while (i2 < i3)
          {
            localObject2 = new ApolloMainInfo(str);
            ((ApolloInfo)localObject2).mAction = ((ApolloActionData)((List)localObject1).get(i2));
            if ((((ApolloInfo)localObject2).mAction != null) && (((ApolloInfo)localObject2).mAction.isForPlayerAction == 1))
            {
              ((ApolloInfo)localObject2).mActionText = ((ApolloActionPackageData)localList.get(i2)).text;
              ((ApolloInfo)localObject2).mTextType = ((ApolloActionPackageData)localList.get(i2)).textType;
              ((ApolloInfo)localObject2).iconType = ApolloPanelUtil.a(this.a.i(), (ApolloInfo)localObject2, ((ApolloInfo)localObject2).mAction);
              ((ApolloInfo)localObject2).mPackageId = i1;
              this.d.add(localObject2);
            }
            i2 += 1;
          }
          localObject1 = this.m;
          if (localObject1 != null) {
            ((ApolloTagActionViewBinder)localObject1).b(this.d);
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshPanelData : mActionList size = ");
          ((StringBuilder)localObject1).append(this.d.size());
          QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject1).toString());
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshPanelData : actionInfoList is empty! packageId = ");
          ((StringBuilder)localObject1).append(i1);
          QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("refreshPanelData : actionPackageDatas is empty! packageId = ");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    QLog.e("[cmshow]CmShowEmotionAdapter", 4, "refreshPanelData : packageList is empty!");
  }
  
  public void setCurrentListView(EmotionPanelListView paramEmotionPanelListView)
  {
    super.setCurrentListView(paramEmotionPanelListView);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CmShowEmotionAdapter.onSetCurrentListView ");
      ((StringBuilder)localObject).append(this.n);
      QLog.d("[cmshow]CmShowEmotionAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (paramEmotionPanelListView != null)
    {
      localObject = e();
      View localView = this.n;
      if (localView != null) {
        paramEmotionPanelListView.removeHeaderView(localView);
      }
      if (localObject != null)
      {
        this.n = ((View)localObject);
        paramEmotionPanelListView.addHeaderView(this.n);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */