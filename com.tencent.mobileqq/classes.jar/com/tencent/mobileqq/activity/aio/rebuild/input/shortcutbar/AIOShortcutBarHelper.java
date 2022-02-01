package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendAIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.activity.aio.rebuild.LimitContext;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerContext;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

public final class AIOShortcutBarHelper
  implements ILifeCycleHelper, IAIOShortcutBarHelper
{
  private View a;
  private int b = 0;
  private AIOContext c;
  private AIOShortcutBarLogic d;
  
  public AIOShortcutBarHelper(AIOContext paramAIOContext)
  {
    this.c = paramAIOContext;
    this.d = new AIOShortcutBarLogic(this);
  }
  
  private void A()
  {
    a(this.a);
    this.a = null;
    this.b = 0;
  }
  
  public int a()
  {
    AIOContext localAIOContext = this.c;
    if ((localAIOContext instanceof TroopAIOContext)) {
      return 3;
    }
    if ((localAIOContext instanceof RobotContext)) {
      return 6;
    }
    if (b()) {
      return 4;
    }
    localAIOContext = this.c;
    if ((localAIOContext instanceof LimitContext)) {
      return 5;
    }
    if ((localAIOContext instanceof StrangerContext)) {
      return 7;
    }
    if (c()) {
      return 2;
    }
    if ((this.c instanceof FriendAIOContext)) {
      return 1;
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    if ((((ChatDrawerHelper)this.c.a(124)).b instanceof TroopAppShortcutDrawer)) {
      ((TroopAppShortcutDrawer)((ChatDrawerHelper)this.c.a(124)).b).c(paramInt);
    }
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    this.d.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.c.d(2131430542);
    if (localViewGroup == null) {
      return;
    }
    a(this.a);
    a(paramView);
    if (paramLayoutParams != null) {
      localViewGroup.addView(paramView, paramLayoutParams);
    } else {
      localViewGroup.addView(paramView);
    }
    this.a = paramView;
    this.b = paramInt;
    d();
  }
  
  public void a(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.d.a(paramInt, paramOnVisibilityChangedListener);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.c.d(2131430542);
    if (localViewGroup == null) {
      return;
    }
    paramView = localViewGroup.findViewById(paramView.getId());
    if (paramView != null) {
      localViewGroup.removeView(paramView);
    }
  }
  
  public void a(ViewGroup.LayoutParams paramLayoutParams)
  {
    QQBlurView localQQBlurView = (QQBlurView)this.c.d(2131449300);
    if (localQQBlurView != null) {
      localQQBlurView.setLayoutParams(paramLayoutParams);
    }
  }
  
  public void a(AIOShortcutBarHelper.AIOShortcutBarEvent paramAIOShortcutBarEvent)
  {
    if (paramAIOShortcutBarEvent == null) {
      return;
    }
    a(paramAIOShortcutBarEvent.a, paramAIOShortcutBarEvent.a());
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    ((ChatDrawerHelper)this.c.a(124)).a(paramTouchEventConsumer);
  }
  
  public void a(String paramString)
  {
    AIOContext localAIOContext = this.c;
    if ((localAIOContext instanceof LimitContext)) {
      ((LimitContext)localAIOContext).b(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AIOContext localAIOContext = this.c;
    if ((localAIOContext instanceof TroopAIOContext)) {
      ((TroopAIOContext)localAIOContext).a(paramString1, paramString2, paramBoolean, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    BaseChatDrawer localBaseChatDrawer = ((ChatDrawerHelper)this.c.a(124)).b;
    if (localBaseChatDrawer != null) {
      localBaseChatDrawer.b(paramBoolean);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.d.a(paramMotionEvent);
  }
  
  public <T extends IHelper> T b(int paramInt)
  {
    return this.c.a(paramInt);
  }
  
  public void b(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.d.b(paramInt, paramOnVisibilityChangedListener);
  }
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    ((ChatDrawerHelper)this.c.a(124)).b(paramTouchEventConsumer);
  }
  
  public boolean b()
  {
    return h().a == 3000;
  }
  
  public void c(int paramInt)
  {
    View localView = this.a;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public boolean c()
  {
    return h().a == 1;
  }
  
  public void d()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int k = ((View)localObject).getId();
    localObject = (ViewGroup)this.c.d(2131430542);
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131438953);
      i = j;
      if (localTextView != null)
      {
        i = j;
        if (localTextView.getVisibility() == 0) {
          i = 1;
        }
      }
    }
    localObject = ((ViewGroup)localObject).findViewById(2131428098);
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        if (i != 0)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131438953);
          return;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, k);
      }
    }
  }
  
  public void d(int paramInt)
  {
    a(paramInt, null);
  }
  
  public int e(int paramInt)
  {
    int i = paramInt;
    if (v() == 0)
    {
      int j = u();
      i = paramInt;
      if (j != 0) {
        i = paramInt + j;
      }
    }
    return i;
  }
  
  public void e()
  {
    Object localObject = (ViewGroup)this.c.d(2131430542);
    if (localObject == null) {
      return;
    }
    localObject = ((ViewGroup)localObject).findViewById(2131428098);
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams)) {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131435809);
      }
    }
  }
  
  public void f()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getId();
    localObject = (ViewGroup)this.c.d(2131430542);
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((ViewGroup)localObject).findViewById(2131438953);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOShortcutBarHelper", 2, "updateListUnRead unread textview is null");
      }
      return;
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams)) {
      ((RelativeLayout.LayoutParams)localObject).addRule(2, i);
    }
    d();
  }
  
  public void g()
  {
    Object localObject = (ViewGroup)this.c.d(2131430542);
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((ViewGroup)localObject).findViewById(2131438953);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOShortcutBarHelper", 2, "updateListUnRead unread textview is null");
      }
      return;
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams)) {
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131435809);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOShortcutBarHelper";
  }
  
  public SessionInfo h()
  {
    return (SessionInfo)this.c.O();
  }
  
  public AppRuntime i()
  {
    return this.c.a();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 7, 14, 15 };
  }
  
  public Activity j()
  {
    return this.c.b();
  }
  
  public Context k()
  {
    return this.c.b();
  }
  
  public void l()
  {
    this.c.p().d().e().h();
  }
  
  public void m()
  {
    this.c.e().b().r();
  }
  
  public boolean n()
  {
    return ((ChatDrawerHelper)this.c.a(124)).b();
  }
  
  public NavigateBarManager o()
  {
    return this.c.E();
  }
  
  public void onMoveToState(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 8)
        {
          if (paramInt != 14)
          {
            if (paramInt != 15) {
              return;
            }
            d(4);
            y();
          }
          d(5);
          return;
        }
        d(2);
        return;
      }
      d(3);
      return;
    }
    d(1);
  }
  
  public ViewGroup.LayoutParams p()
  {
    QQBlurView localQQBlurView = (QQBlurView)this.c.d(2131449300);
    if (localQQBlurView != null) {
      return localQQBlurView.getLayoutParams();
    }
    return null;
  }
  
  public Drawable q()
  {
    return this.c.p().d().e().f();
  }
  
  public XEditTextEx r()
  {
    return (XEditTextEx)this.c.d(2131435808);
  }
  
  public void s()
  {
    this.c.p().a().b();
  }
  
  public boolean t()
  {
    return this.c.A();
  }
  
  public int u()
  {
    return this.d.c(this.b);
  }
  
  public int v()
  {
    View localView = this.a;
    if (localView == null) {
      return 8;
    }
    return localView.getVisibility();
  }
  
  public boolean w()
  {
    View localView = this.c.d(2131432077);
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public int x()
  {
    return this.b;
  }
  
  public void y()
  {
    A();
  }
  
  public boolean z()
  {
    return this.d.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */