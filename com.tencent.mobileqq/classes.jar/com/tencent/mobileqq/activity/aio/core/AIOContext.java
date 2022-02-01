package com.tencent.mobileqq.activity.aio.core;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Observer;
import mqq.os.MqqHandler;

public class AIOContext
  extends BaseAIOContext
{
  protected QQAppInterface a;
  protected BaseActivity b;
  @NonNull
  protected BaseChatPie c;
  
  public boolean A()
  {
    return this.c.br();
  }
  
  public boolean B()
  {
    return this.c.am;
  }
  
  public PanelIconLinearLayout C()
  {
    return this.c.W;
  }
  
  public void D()
  {
    this.c.aq();
  }
  
  public NavigateBarManager E()
  {
    BaseChatPie localBaseChatPie = this.c;
    return new NavigateBarManager(localBaseChatPie, localBaseChatPie.d, this.c.e, this.c.ah, this.c.bl());
  }
  
  public int F()
  {
    return this.c.aE;
  }
  
  public TroopAioTips G()
  {
    return (TroopAioTips)this.c.au;
  }
  
  public boolean H()
  {
    return this.c instanceof TroopChatPie;
  }
  
  public boolean I()
  {
    return this.c.aL;
  }
  
  public void J()
  {
    this.c.W.a(this.c);
  }
  
  public NavBarAIO K()
  {
    return this.c.p;
  }
  
  public void L()
  {
    this.c.aQ();
  }
  
  public void M()
  {
    this.c.as();
  }
  
  public int N()
  {
    return this.c.p.getBottom();
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.c.q(paramInt);
  }
  
  public QQAppInterface a()
  {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.c.h.a(paramInt1, paramInt2, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.c.n.a(paramInt, paramBoolean);
  }
  
  public void a(View paramView)
  {
    this.c.ba.removeView(paramView);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    this.c.onTouch(paramView, paramMotionEvent);
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.c.ba.addView(paramView, paramLayoutParams);
  }
  
  public void a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    this.c.a(paramList, paramMessageRecord);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.c.a(paramList, paramCharSequence);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.c.a(paramList, paramCharSequence, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.as = paramBoolean;
  }
  
  public BaseActivity b()
  {
    return this.b;
  }
  
  public void b(View paramView)
  {
    this.c.ba.removeViewInLayout(paramView);
  }
  
  public void b(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.c.bl().addView(paramView, paramLayoutParams);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.W.a(paramBoolean, this.c);
  }
  
  public boolean b(int paramInt)
  {
    return this.c.f(paramInt);
  }
  
  public TipsManager c()
  {
    return this.c.J();
  }
  
  public void c(int paramInt)
  {
    this.c.j(paramInt);
  }
  
  public void c(View paramView)
  {
    this.c.bl().removeViewInLayout(paramView);
  }
  
  public void c(boolean paramBoolean)
  {
    this.c.b(paramBoolean);
  }
  
  public <T extends View> T d(@IdRes int paramInt)
  {
    return this.c.aZ.findViewById(paramInt);
  }
  
  public CoreHelperProvider d()
  {
    return this.c.g;
  }
  
  public MsgList e()
  {
    return this.c.j;
  }
  
  public void e(int paramInt)
  {
    this.c.p.setVisibility(paramInt);
  }
  
  public Observer f()
  {
    return this.c;
  }
  
  public final MqqHandler g()
  {
    return this.c.j();
  }
  
  public final AIOAnimationConatiner h()
  {
    return this.c.aU;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public void i()
  {
    this.c.a(this.a);
  }
  
  public boolean j()
  {
    return this.c.aY();
  }
  
  public int k()
  {
    return this.c.aR();
  }
  
  public boolean l()
  {
    return this.c.aO;
  }
  
  public boolean m()
  {
    return this.c.aD;
  }
  
  public BaseChatPie n()
  {
    return this.c;
  }
  
  public boolean o()
  {
    return this.c.ba();
  }
  
  public void onClick(View paramView)
  {
    this.c.onClick(paramView);
  }
  
  public AIOInput p()
  {
    return this.c.l;
  }
  
  public PanelManager q()
  {
    return this.c.ae;
  }
  
  public ViewGroup r()
  {
    return this.c.ba;
  }
  
  public ViewGroup s()
  {
    return this.c.aZ;
  }
  
  public boolean t()
  {
    return this.c.aq;
  }
  
  public void u()
  {
    this.c.aZ.invalidate();
  }
  
  public int v()
  {
    return this.c.A();
  }
  
  public boolean w()
  {
    return this.c.as;
  }
  
  public int x()
  {
    return this.c.az;
  }
  
  public void y()
  {
    this.c.C();
  }
  
  public TipsController z()
  {
    return this.c.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.AIOContext
 * JD-Core Version:    0.7.0.1
 */