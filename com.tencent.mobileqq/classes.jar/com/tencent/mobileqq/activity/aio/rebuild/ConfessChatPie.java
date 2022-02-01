package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams.Builder;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.ConfessMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessListUI;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgLoader;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessUnreadTask;
import com.tencent.mobileqq.activity.aio.rebuild.tips.ConfessTipsController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessCache;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.confess.ConfessProgressView;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import mqq.os.MqqHandler;

public class ConfessChatPie
  extends BaseChatPie
  implements Handler.Callback
{
  protected boolean bi;
  protected ConfessInfo bj;
  QQProgressNotifier bk;
  MqqHandler bl = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  PopupWindow bm;
  ConfessHandler bn;
  ConfessObserver bo = new ConfessChatPie.1(this);
  protected MessageObserver bp = new ConfessChatPie.4(this);
  private String bq;
  private ImageView br;
  private ConfessProgressView bs;
  private View bt;
  private LottieDrawable bu;
  private View bv;
  private int bw = -1;
  
  public ConfessChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void bA()
  {
    if ((this.bt != null) && (this.ah.a == 1034))
    {
      String str = UinTypeUtil.a(this.ah.b, this.ah.a, this.ah.v);
      if (ConfessConfig.d(this.d, str))
      {
        this.bt.setVisibility(0);
        return;
      }
      this.bt.setVisibility(8);
    }
  }
  
  private void bB()
  {
    Object localObject2;
    if (this.ah.a == 1033)
    {
      this.p.setBackgroundResource(2130844752);
      this.ba.setBackgroundResource(2130844752);
      this.X.getBackground().setVisible(true, false);
      this.X.findViewById(2131446058).setVisibility(8);
      try
      {
        AIOUtils.a(this.X, 2130844758);
      }
      catch (Throwable localThrowable)
      {
        localObject2 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleConfessUI error: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
      }
      if (this.Y != null)
      {
        AIOUtils.a(this.Y, 2130844771);
        this.Y.setTextColor(-16777216);
      }
      this.C.setTextColor(AnonymousChatHelper.c);
      this.B.setTextColor(this.f.getResources().getColor(2131167990));
      if (this.s.getVisibility() == 0)
      {
        this.s.setBackgroundResource(2130844778);
        this.s.setTextColor(AnonymousChatHelper.c);
      }
      else if (this.w.getVisibility() == 0)
      {
        this.w.setBackgroundResource(2130853298);
        this.w.setPadding(0, 0, 0, 0);
        this.x.setTextColor(AnonymousChatHelper.c);
        this.x.setBackgroundResource(2130837967);
      }
      this.q.setOnClickListener(null);
      this.r.setOnClickListener(null);
      AIOUtils.a(this.u, null);
      if (this.W != null)
      {
        this.W.setBackgroundColor(-16777216);
        if (this.n.getCurrentPanel() == 8) {
          this.W.setSelected(8);
        }
        this.W.a(this.d, this.ah, this);
        this.W.a(this, new UpdateParams.Builder().a(true).a());
      }
      localObject1 = (AIOEmoticonUIHelper)q(105);
      if (localObject1 != null) {
        ((AIOEmoticonUIHelper)localObject1).c(true);
      }
      this.u.setVisibility(4);
      this.P = false;
      b(true);
      localObject1 = this.I;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900565));
      ((StringBuilder)localObject2).append(this.bq);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.I.setTextColor(-855638017);
      this.C.setTextColor(-855638017);
      localObject1 = new View(this.f);
      ((View)localObject1).setBackgroundColor(-2013265920);
      localObject2 = new RelativeLayout.LayoutParams(-1, 2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      this.p.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    else
    {
      this.C.setText(this.bq);
      this.A.setVisibility(4);
      this.u.setImageResource(2130847225);
      this.u.setBackgroundColor(0);
    }
    Object localObject1 = HardCodeUtil.a(2131900566);
    if (this.bi) {
      localObject1 = HardCodeUtil.a(2131900567);
    }
    this.s.setText((CharSequence)localObject1);
    this.p.findViewById(2131437136).setVisibility(8);
    this.s.setTextSize(16.0F);
    this.p.setLeftContentDescription((String)localObject1);
    localObject1 = new ConfessNewsBgView(this.e);
    ((ConfessNewsBgView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.o.addView((View)localObject1, 0);
    int i;
    if (this.ah.a == 1033) {
      i = 858006566;
    } else {
      i = 268234225;
    }
    ((ConfessNewsBgView)localObject1).setBgColor(i);
    ((ConfessNewsBgView)localObject1).setSize(2);
    if (ConfessConfig.a(this.d))
    {
      localObject1 = View.inflate(this.e, 2131627360, null);
      this.ba.addView((View)localObject1, new ViewGroup.LayoutParams(-2, -1));
      localObject2 = ((View)localObject1).findViewById(2131450035);
      this.br = ((ImageView)((View)localObject1).findViewById(2131435077));
      this.br.setOnClickListener(this);
      this.bs = ((ConfessProgressView)((View)localObject1).findViewById(2131431203));
      float f = this.e.getResources().getDisplayMetrics().density;
      this.bs.setSize(24.0F * f, 27.0F * f, -0.15F * f, -0.5F * f);
      this.bt = ((View)localObject1).findViewById(2131435069);
      this.bt.setVisibility(8);
      this.bv = ((View)localObject1).findViewById(2131435067);
      if (this.ah.a == 1033)
      {
        localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = ((int)(f * 9.0F));
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.bv.setVisibility(4);
      bC();
      if (!ConfessConfig.c(this.d, "holmes_guide"))
      {
        ConfessConfig.a(this.d, "holmes_guide", true);
        if (this.ah.a == 1033) {
          localObject1 = View.inflate(this.e, 2131627359, null);
        } else {
          localObject1 = View.inflate(this.e, 2131627358, null);
        }
        ((View)localObject1).findViewById(2131435072).setOnClickListener(this);
        ((View)localObject1).setOnClickListener(this);
        this.ba.getViewTreeObserver().addOnGlobalLayoutListener(new ConfessChatPie.2(this, (View)localObject1, (View)localObject2));
      }
      if (this.aO)
      {
        localObject1 = this.br;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(4);
        }
      }
    }
  }
  
  private void bC()
  {
    ThreadManager.excute(new ConfessChatPie.3(this), 16, null, true);
  }
  
  private void bD()
  {
    Object localObject = aX();
    if (localObject != null)
    {
      if (this.d == null) {
        return;
      }
      localObject = (ActionSheet)ActionSheetHelper.b((Context)localObject, null);
      ((ActionSheet)localObject).addButton(2131886585, 5);
      ((ActionSheet)localObject).addButton(2131887669, 5);
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnButtonClickListener(new ConfessChatPie.5(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  private void bz()
  {
    long l1;
    if (ConfessConfig.a(this.d))
    {
      p(false);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.ah.b);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    if (this.ah.a == 1033)
    {
      this.bn.a(this.d.getLongAccountUin(), l1, this.ah.v, this.ah.a, true);
      return;
    }
    this.bn.a(l1, this.d.getLongAccountUin(), this.ah.v, this.ah.a, false);
  }
  
  private void p(boolean paramBoolean)
  {
    if (this.bs != null)
    {
      if (this.br == null) {
        return;
      }
      ConfessConvInfo localConfessConvInfo = this.d.getProxyManager().j().b(this.ah.b, this.ah.a, this.ah.v);
      if (localConfessConvInfo != null)
      {
        int i;
        if ((localConfessConvInfo.holmesTolCount != 0) && (localConfessConvInfo.holmesCurCount == localConfessConvInfo.holmesTolCount))
        {
          this.br.setImageResource(2130846429);
          i = 0;
        }
        else
        {
          this.br.setImageResource(2130846428);
          i = 1;
        }
        this.bs.a(localConfessConvInfo.holmesCurCount, localConfessConvInfo.holmesTolCount);
        this.br.setContentDescription(String.format(HardCodeUtil.a(2131900575), new Object[] { Integer.valueOf(localConfessConvInfo.holmesTolCount), Integer.valueOf(localConfessConvInfo.holmesCurCount) }));
        if ((paramBoolean) && (localConfessConvInfo.holmesCurCount > this.bw) && (this.bu != null))
        {
          if (i != 0)
          {
            localObject = this.br;
            if (localObject != null) {
              ((ImageView)localObject).setVisibility(4);
            }
          }
          Object localObject = this.bv;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          this.bu.playAnimation();
        }
        this.bw = localConfessConvInfo.holmesCurCount;
      }
      bA();
    }
  }
  
  private int s(int paramInt)
  {
    int i = 2130846421;
    switch (paramInt)
    {
    default: 
      return 2130846421;
    case 10: 
      return 2130846417;
    case 9: 
      return 2130846425;
    case 8: 
      return 2130846424;
    case 7: 
      return 2130846423;
    case 6: 
      return 2130846422;
    case 4: 
      return 2130846420;
    case 3: 
      return 2130846419;
    case 2: 
      return 2130846418;
    case 1: 
      return 2130846416;
    case 0: 
      i = 2130846415;
    }
    return i;
  }
  
  public void B() {}
  
  public void K()
  {
    super.K();
    this.d.removeObserver(this.bo);
    this.bl.removeCallbacksAndMessages(null);
    a();
    PopupWindow localPopupWindow = this.bm;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  protected void Q()
  {
    super.Q();
    if (this.ah.a == 1033) {
      b(-16777216, false);
    }
  }
  
  protected void a()
  {
    QQProgressNotifier localQQProgressNotifier = this.bk;
    if (localQQProgressNotifier != null)
    {
      localQQProgressNotifier.b();
      this.bk = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.bk == null) {
      this.bk = new QQProgressNotifier(this.f);
    }
    this.bk.a(paramInt1, paramString, paramInt2);
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bB();
    this.d.addObserver(this.bo);
    this.bn = ((ConfessHandler)this.d.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER));
    bz();
    return paramBoolean;
  }
  
  public void ai()
  {
    Object localObject = aX().getSupportFragmentManager();
    ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).q().setBackgroundColor(1226741);
    }
  }
  
  protected void au()
  {
    super.au();
    this.d.addObserver(this.bp);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bp);
  }
  
  public void bf() {}
  
  protected void bg()
  {
    if ((this.ah != null) && (this.e != null))
    {
      if (this.p == null) {
        return;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false))
      {
        if (this.ah.a != 1033)
        {
          Object localObject = aX().getSupportFragmentManager();
          ((FragmentManager)localObject).beginTransaction();
          localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
          if (localObject != null) {
            ((ChatFragment)localObject).q().setBackgroundDrawable(aX().getResources().getDrawable(2130847834));
          }
          this.B.setTextColor(-1);
          this.C.setTextColor(-1);
          this.I.setTextColor(-1);
          this.s.setTextColor(-1);
          this.s.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852243));
          this.aZ.findViewById(2131437136).setVisibility(8);
          this.p.setIsDefaultTheme(false);
          this.p.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852228));
          this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
          AIOUtils.a(this.X, SkinEngine.getInstances().getDefaultThemeDrawable(2130851968));
          AIOUtils.a(this.Y, SkinEngine.getInstances().getDefaultThemeDrawable(2130851969));
          if (this.Y != null) {
            this.Y.setTextColor(-16777216);
          }
          localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130852117);
          Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130852114);
          Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130852118);
          StateListDrawable localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
          localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
          localStateListDrawable.addState(new int[0], (Drawable)localObject);
          if (this.Z != null)
          {
            this.Z.setBackgroundDrawable(localStateListDrawable);
            this.Z.setTextColor(-1);
          }
          this.W.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852018));
          return;
        }
        AIOUtils.a(this.Y, 2130844771);
        if (this.Y != null) {
          this.Y.setTextColor(-16777216);
        }
      }
    }
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new ConfessMessageSender(this.i)).a();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    this.bi = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.bq = str1;
    paramIntent = (ConfessManager)this.d.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (((this.f instanceof ChatActivity)) && (TextUtils.isEmpty(this.ah.b)))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("friend uin is null ,uintype = ");
      paramIntent.append(this.ah.a);
      QLog.d("ConfessChatPie", 1, paramIntent.toString());
      this.f.finish();
      return;
    }
    this.ah.w = this.bq;
    if (!this.aO)
    {
      ConfessCache localConfessCache = paramIntent.c();
      String str3 = this.ah.b;
      int j = this.ah.a;
      int k = this.ah.v;
      if (this.ah.a == 1033) {
        paramIntent = this.d.getCurrentAccountUin();
      } else {
        paramIntent = this.ah.b;
      }
      this.bj = localConfessCache.a(str3, j, k, paramIntent, str1, i, str2, l);
    }
    else
    {
      paramIntent = new ConfessInfo();
      paramIntent.reset();
      paramIntent.topicId = this.ah.v;
      paramIntent.confessorNick = str1;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.ah.b, Integer.valueOf(this.ah.a), Integer.valueOf(this.ah.v), str1, Integer.valueOf(i) }));
    }
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ConfessListUI(this.i)).a(new ConfessMsgLoader()).a(new ConfessUnreadTask(this.i, this)).a(new ConfessMsgListRefresher(this.i)).a();
  }
  
  protected TipsController f()
  {
    return new ConfessTipsController(this.i);
  }
  
  protected void h()
  {
    this.c = "ConfessChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.ah.a == 1033))
    {
      this.ba.setBackgroundResource(2130844752);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131436194) && (this.ah != null) && (this.ah.a == 1034))
    {
      bD();
    }
    else
    {
      Object localObject1;
      if (i == 2131435072)
      {
        localObject1 = this.bm;
        if (localObject1 != null)
        {
          ((PopupWindow)localObject1).dismiss();
          this.bm = null;
        }
      }
      else if (i != 2131435074)
      {
        if (i == 2131435077)
        {
          localObject1 = this.bt;
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
          {
            this.bt.setVisibility(8);
            localObject1 = UinTypeUtil.a(this.ah.b, this.ah.a, this.ah.v);
            ConfessConfig.b(this.d, (String)localObject1, false);
            i = 1;
          }
          else
          {
            i = 2;
          }
          if (this.ah.a == 1033)
          {
            str = this.d.getAccount();
            localObject1 = this.ah.b;
          }
          else
          {
            str = this.ah.b;
            localObject1 = this.d.getAccount();
          }
          QQAppInterface localQQAppInterface = this.d;
          Object localObject2 = this.e;
          int j = this.ah.v;
          boolean bool;
          if (this.ah.a == 1033) {
            bool = true;
          } else {
            bool = false;
          }
          ConfessConfig.a(localQQAppInterface, (Context)localObject2, str, (String)localObject1, j, bool);
          localQQAppInterface = this.d;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.ah.v);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("");
          String str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("");
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009573", "0X8009573", i, 0, (String)localObject2, "", str, localStringBuilder.toString());
        }
        else
        {
          super.onClick(paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie
 * JD-Core Version:    0.7.0.1
 */