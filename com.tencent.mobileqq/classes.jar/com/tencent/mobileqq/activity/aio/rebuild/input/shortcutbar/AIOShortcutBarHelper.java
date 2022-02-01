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
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private AIOShortcutBarLogic jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic;
  
  public AIOShortcutBarHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic = new AIOShortcutBarLogic(this);
  }
  
  private void i()
  {
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a()
  {
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if ((localAIOContext instanceof TroopAIOContext)) {
      return 3;
    }
    if ((localAIOContext instanceof RobotContext)) {
      return 6;
    }
    if (a()) {
      return 4;
    }
    localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if ((localAIOContext instanceof LimitContext)) {
      return 5;
    }
    if ((localAIOContext instanceof StrangerContext)) {
      return 7;
    }
    if (b()) {
      return 2;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext instanceof FriendAIOContext)) {
      return 1;
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (c() == 0)
    {
      int j = b();
      i = paramInt;
      if (j != 0) {
        i = paramInt + j;
      }
    }
    return i;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
  }
  
  public ViewGroup.LayoutParams a()
  {
    QQBlurView localQQBlurView = (QQBlurView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131380356);
    if (localQQBlurView != null) {
      return localQQBlurView.getLayoutParams();
    }
    return null;
  }
  
  public SessionInfo a()
  {
    return (SessionInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(paramInt);
  }
  
  public NavigateBarManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  public XEditTextEx a()
  {
    return (XEditTextEx)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131368874);
  }
  
  public AppRuntime a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    int k = ((View)localObject).getId();
    localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131371572);
      i = j;
      if (localTextView != null)
      {
        i = j;
        if (localTextView.getVisibility() == 0) {
          i = 1;
        }
      }
    }
    localObject = ((ViewGroup)localObject).findViewById(2131362489);
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        if (i != 0)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131371572);
          return;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, k);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(124)).a instanceof TroopAppShortcutDrawer)) {
      ((TroopAppShortcutDrawer)((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(124)).a).c(paramInt);
    }
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
    if (localViewGroup == null) {
      return;
    }
    a(this.jdField_a_of_type_AndroidViewView);
    a(paramView);
    if (paramLayoutParams != null) {
      localViewGroup.addView(paramView, paramLayoutParams);
    } else {
      localViewGroup.addView(paramView);
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public void a(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic.a(paramInt, paramOnVisibilityChangedListener);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
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
    QQBlurView localQQBlurView = (QQBlurView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131380356);
    if (localQQBlurView != null) {
      localQQBlurView.setLayoutParams(paramLayoutParams);
    }
  }
  
  public void a(AIOShortcutBarHelper.AIOShortcutBarEvent paramAIOShortcutBarEvent)
  {
    if (paramAIOShortcutBarEvent == null) {
      return;
    }
    a(paramAIOShortcutBarEvent.jdField_a_of_type_Int, paramAIOShortcutBarEvent.a());
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(124)).a(paramTouchEventConsumer);
  }
  
  public void a(String paramString)
  {
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if ((localAIOContext instanceof LimitContext)) {
      ((LimitContext)localAIOContext).b(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if ((localAIOContext instanceof TroopAIOContext)) {
      ((TroopAIOContext)localAIOContext).a(paramString1, paramString2, paramBoolean, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    BaseChatDrawer localBaseChatDrawer = ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(124)).a;
    if (localBaseChatDrawer != null) {
      localBaseChatDrawer.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return a().jdField_a_of_type_Int == 3000;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic.a(paramMotionEvent);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    Object localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
    if (localObject != null) {
      return;
    }
    localObject = ((ViewGroup)localObject).findViewById(2131362489);
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams)) {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368875);
      }
    }
  }
  
  public void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public void b(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic.b(paramInt, paramOnVisibilityChangedListener);
  }
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(124)).b(paramTouchEventConsumer);
  }
  
  public boolean b()
  {
    return a().jdField_a_of_type_Int == 1;
  }
  
  public int c()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return 8;
    }
    return localView.getVisibility();
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getId();
    localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((ViewGroup)localObject).findViewById(2131371572);
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
    a();
  }
  
  public void c(int paramInt)
  {
    a(paramInt, null);
  }
  
  public boolean c()
  {
    return ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(124)).a();
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void d()
  {
    Object localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131364485);
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((ViewGroup)localObject).findViewById(2131371572);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOShortcutBarHelper", 2, "updateListUnRead unread textview is null");
      }
      return;
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams)) {
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368875);
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.g();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().c();
  }
  
  public boolean e()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131365819);
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().g();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic.a();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b();
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOShortcutBarHelper";
  }
  
  public void h()
  {
    i();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 7, 14, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarLogic == null) {
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
            c(4);
            h();
          }
          c(5);
          return;
        }
        c(2);
        return;
      }
      c(3);
      return;
    }
    c(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */