package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class BaseChatDrawer
  implements DrawerFrame.IDrawerCallbacks
{
  private int jdField_a_of_type_Int;
  public Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new BaseChatDrawer.1(this);
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  public SessionInfo a;
  public BaseChatPie a;
  public BaseActivity a;
  public QQAppInterface a;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks = new BaseChatDrawer.3(this);
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private boolean jdField_a_of_type_Boolean;
  public ViewGroup b;
  
  public BaseChatDrawer(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c;
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(124)).jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerCallbacks(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$IDrawerCallbacks);
    m();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private SystemBarCompact a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null)
    {
      localObject = ((BaseActivity)localObject).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null) {
        return ((ChatFragment)localObject).a;
      }
    }
    return null;
  }
  
  private boolean c()
  {
    ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
    return (localImmersiveTitleBar2 != null) && (localImmersiveTitleBar2.getParent() != null);
  }
  
  private boolean d()
  {
    return (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) && (!SimpleUIUtil.a());
  }
  
  private void m()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null) {
      localNavBarAIO.addOnLayoutChangeListener(new BaseChatDrawer.2(this, localNavBarAIO));
    }
  }
  
  private void n()
  {
    boolean bool = c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addImmersiveTitleBar, isVisible: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("BaseChatDrawer", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 == null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = new ImmersiveTitleBar2(this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, (ViewGroup.LayoutParams)localObject);
      ((TopGestureLayout)this.jdField_a_of_type_AndroidViewViewGroup).setPadding2(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewViewGroup.setFitsSystemWindows(false);
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin += this.jdField_a_of_type_AndroidGraphicsRect.left;
      ((RelativeLayout.LayoutParams)localObject).rightMargin += this.jdField_a_of_type_AndroidGraphicsRect.right;
      ((RelativeLayout.LayoutParams)localObject).topMargin += this.jdField_a_of_type_AndroidGraphicsRect.top;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin += this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      this.b.setFitsSystemWindows(true);
      p();
    }
  }
  
  private void o()
  {
    boolean bool = c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeImmersiveTitleBar, isVisible: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("BaseChatDrawer", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      this.jdField_a_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (localObject != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(((Rect)localObject).left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (this.jdField_a_of_type_AndroidGraphicsRect != null)
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin -= this.jdField_a_of_type_AndroidGraphicsRect.left;
        ((RelativeLayout.LayoutParams)localObject).rightMargin -= this.jdField_a_of_type_AndroidGraphicsRect.right;
        ((RelativeLayout.LayoutParams)localObject).topMargin -= this.jdField_a_of_type_AndroidGraphicsRect.top;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin -= this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      }
      this.b.setFitsSystemWindows(false);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a((Drawable)localObject);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(this.jdField_a_of_type_Int, false);
      }
      if (d()) {
        ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      }
    }
  }
  
  private void p()
  {
    boolean bool = c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateImmersiveTitleBar, isVisible: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("BaseChatDrawer", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = a();
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((SystemBarCompact)localObject).mStatusBarDarwable;
        this.jdField_a_of_type_Int = ((SystemBarCompact)localObject).mStatusBarColor;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(0, false);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundDrawable((Drawable)localObject);
      } else {
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(this.jdField_a_of_type_Int);
      }
      if (d()) {
        ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      }
    }
  }
  
  protected abstract View a();
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView = a();
        View localView1 = this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_Boolean = true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.d("BaseChatDrawer", 1, "BaseChatDrawer createDrawerView oom", localOutOfMemoryError);
      }
      View localView2 = this.jdField_a_of_type_AndroidViewView;
      if (localView2 != null)
      {
        DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
        if (localDrawerFrame != null)
        {
          localDrawerFrame.a(localView2, 1);
          b();
        }
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    if (localDrawerFrame != null) {
      localDrawerFrame.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    if (localDrawerFrame != null) {
      return localDrawerFrame.a();
    }
    return false;
  }
  
  protected abstract void b();
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    if (localDrawerFrame != null) {
      localDrawerFrame.a(1, paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    if ((localDrawerFrame != null) && (localDrawerFrame.a())) {
      p();
    }
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    if (localDrawerFrame != null) {
      localDrawerFrame.setDrawerEnabled(paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      l();
    }
  }
  
  public void e()
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    if (localDrawerFrame != null)
    {
      localDrawerFrame.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerCallbacks(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = null;
    }
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    o();
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, String.format("onDestroy, mHadInflated: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer
 * JD-Core Version:    0.7.0.1
 */