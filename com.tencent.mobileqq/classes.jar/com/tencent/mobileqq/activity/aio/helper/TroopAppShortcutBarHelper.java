package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.ui.IChatPieApolloViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ILeftAppShortBarDataUI;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.IAppShortcutBarDataUI;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopAppShortcutBarHelper
{
  private long jdField_a_of_type_Long;
  protected Activity a;
  protected Context a;
  public View a;
  protected SessionInfo a;
  protected AIOShortcutBarContext a;
  protected IAIOShortcutBarLogic a;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private ILeftAppShortBarDataUI jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
  private IAppShortcutBarDataUI jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
  public AppShortcutBarScrollView a;
  private DrawerFrame.TouchEventConsumer jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer = new TroopAppShortcutBarHelper.2(this);
  private String jdField_a_of_type_JavaLangString;
  protected AppRuntime a;
  protected boolean a;
  protected boolean b = false;
  private boolean c;
  private boolean d = false;
  
  public TroopAppShortcutBarHelper(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic = paramIAIOShortcutBarLogic;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramIAIOShortcutBarLogic.a();
    paramIAIOShortcutBarLogic = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
    if (paramIAIOShortcutBarLogic != null)
    {
      this.jdField_a_of_type_AndroidContentContext = paramIAIOShortcutBarLogic.a();
      this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "resetBlurViewTopMargin");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((AIOShortcutBarContext)localObject).a();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a((ViewGroup.LayoutParams)localObject);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public long a()
  {
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty mChatPie is null");
      }
    }
    else
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
      if (localSessionInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo is null");
        }
      }
      else if (localSessionInfo.jdField_a_of_type_JavaLangString == null)
      {
        if (!QLog.isColorLevel()) {
          break label101;
        }
        QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo.curFriendUin is null");
      }
    }
    try
    {
      long l = Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString);
      return l;
    }
    catch (Exception localException)
    {
      label87:
      label101:
      break label87;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty is Exception");
    }
    return 0L;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  }
  
  public ViewGroup.LayoutParams a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131368875);
    return localLayoutParams;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = ((IAIOShortcutBarLogic)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic getAIOShortcutBarContext is null");
      }
      return;
    }
    if (((AIOShortcutBarContext)localObject).a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic AppRuntime is null");
      }
      return;
    }
    this.jdField_a_of_type_Long = a();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShortcutBarAioHelper.init mTroopUinStr: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.e("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558521, null));
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) {
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372300);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init mAppShortcutBarView is null");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI = new LeftAppShortcutBarPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, (AppShortcutBarScrollView)localObject, this);
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI = new AppShortcutBarPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = new ShortBarDataProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new TroopAppShortcutBarHelper.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutBarHelper", 2, "initData.");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setMove(true);
      return;
    }
    catch (InflateException localInflateException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortcutBarAioHelper.init got InflateException, e:");
        localStringBuilder.append(localInflateException.getMessage());
        QLog.e("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
      System.gc();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortcutBarAioHelper.init got OOM, e:");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.e("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
      System.gc();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      if (paramBundle != null) {
        this.b = paramBundle.getBoolean("InputJump", this.b);
      }
      g();
      return;
    case 10: 
      j();
      return;
    case 9: 
      i();
      return;
    case 8: 
      f();
      return;
    case 7: 
      a(false);
      return;
    case 6: 
      a(true);
      return;
    case 5: 
    case 11: 
      if (paramBundle != null) {
        this.b = paramBundle.getBoolean("InputJump", this.b);
      }
      h();
      return;
    case 4: 
      e();
      return;
    case 3: 
      c();
      return;
    case 2: 
      b();
      return;
    }
    d();
  }
  
  public void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdatePanel from: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("bShowManageBtn");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (paramInt == 0)
      {
        if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.a())) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        } else {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.a())) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramInt == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
        if (localObject != null) {
          ((IAppShortcutBarDataUI)localObject).a(paramArrayList, paramBoolean);
        }
      }
      else if (paramInt == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
        if (localObject != null) {
          ((ILeftAppShortBarDataUI)localObject).a(paramArrayList);
        }
      }
    }
    else
    {
      paramArrayList = this.jdField_a_of_type_AndroidViewView;
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      IShortcutBarDataProvider localIShortcutBarDataProvider = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
      if (localIShortcutBarDataProvider == null) {
        return;
      }
      localIShortcutBarDataProvider.b(paramView.getTag());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAIOIceBreakViewShowingStatus isShow = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      h();
      return;
    }
    g();
  }
  
  protected boolean a()
  {
    return (d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.b(2));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null))
    {
      if (paramMotionEvent == null) {
        return false;
      }
      int i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getLocationOnScreen(paramMotionEvent);
      if (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getWidth(), paramMotionEvent[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight()).contains(i, j)) {
        return true;
      }
    }
    return false;
  }
  
  protected int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieShowFirstBegin");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
    if (localObject != null) {
      ((ILeftAppShortBarDataUI)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
    if (localObject != null) {
      ((IAppShortcutBarDataUI)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localObject != null) {
      ((IShortcutBarDataProvider)localObject).d();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a(2);
  }
  
  protected int c()
  {
    return 0;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieResume");
    }
    if (this.d) {
      this.d = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
    if (localObject != null) {
      ((ILeftAppShortBarDataUI)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
    if (localObject != null) {
      ((IAppShortcutBarDataUI)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localObject != null) {
      ((IShortcutBarDataProvider)localObject).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = this.c;
    this.c = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("triggerSyncOnce() syncOnce = ");
      localStringBuilder.append(bool);
      QLog.d("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  void d()
  {
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieCreate");
    }
    a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("robot: init Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l1);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    long l2 = SystemClock.uptimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
    if (localObject != null) {
      ((AIOShortcutBarContext)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: addTouchEventConsumer Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
    if (localObject != null) {
      ((ILeftAppShortBarDataUI)localObject).b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: mLeftAppPanel Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
    if (localObject != null) {
      ((IAppShortcutBarDataUI)localObject).b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: mAppPanel Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localObject != null) {
      ((IShortcutBarDataProvider)localObject).b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: mProvider Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: AllTime = ");
    ((StringBuilder)localObject).append(l2 - l1);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
  }
  
  public boolean d()
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      }
      return false;
    }
    ILeftAppShortBarDataUI localILeftAppShortBarDataUI = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
    bool1 = bool2;
    if (localILeftAppShortBarDataUI != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) {
        if (!localILeftAppShortBarDataUI.a())
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.a()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieDestroy");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
    if (localObject != null)
    {
      ((ILeftAppShortBarDataUI)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
    if (localObject != null)
    {
      ((IAppShortcutBarDataUI)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localObject != null)
    {
      ((IShortcutBarDataProvider)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "onChatPieDestroy. ");
    }
    h();
    k();
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
    if (localObject != null)
    {
      ((AppShortcutBarScrollView)localObject).fullScroll(17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent() != null) && ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
    if (localObject != null) {
      ((AIOShortcutBarContext)localObject).b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.d = false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout");
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    Object localObject = b();
    int j = 0;
    int i;
    if ((localObject != null) && (b().isShown()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with scroll_panel_app_shorts");
      }
      i = ViewUtils.a(39.0F);
      boolean bool = AnonymousChatHelper.a().a(this.jdField_a_of_type_JavaLangString);
      if ((!ThemeUtil.isSimpleDayTheme(false)) && (!bool))
      {
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) {
          b().setBackgroundColor(-16777216);
        } else {
          b().setBackgroundResource(0);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
        i = j;
        if (localObject != null)
        {
          localObject = ((Drawable)localObject).getConstantState().newDrawable();
          b().setBackgroundDrawable((Drawable)localObject);
          i = j;
        }
      }
    }
    else
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with inputBar");
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShortcutBarAioHelper.setBlurViewLayout marginTop = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (localLayoutParams != null)
    {
      localLayoutParams.topMargin = (i * -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(localLayoutParams);
    }
  }
  
  public void g()
  {
    if (b() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar getShortCutBarContainerView is null");
      }
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar return for AIOIceBreakViewShowing");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic == null) {
      return;
    }
    if (this.b) {
      return;
    }
    Object localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(52);
    if ((localObject != null) && (((AIOShortcutBarHelper)localObject).e())) {
      return;
    }
    localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(15);
    if ((localObject != null) && (((AIOLongShotHelper)localObject).a())) {
      return;
    }
    localObject = (StickerRecHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(14);
    if ((localObject != null) && (((StickerRecHelper)localObject).a())) {
      return;
    }
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutBarHelper", 2, "resumeAppShorcutBar");
      }
      b().setPadding(a(), c(), b(), 0);
      localObject = ((IApolloAIOHelper)QRoute.api(IApolloAIOHelper.class)).getChatPieApolloViewController();
      if (localObject != null) {
        ((IChatPieApolloViewController)localObject).b(2131377004);
      }
      f();
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.b();
    }
  }
  
  public void h()
  {
    if (b() == null) {
      return;
    }
    if (b().getVisibility() == 8) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "hideAppShortcutBar");
    }
    boolean bool = b().isShown();
    if (b())
    {
      b().setPadding(a(), c(), b(), 0);
      f();
      if (bool) {
        b(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.b();
    }
  }
  
  public void i()
  {
    if ((b() != null) && (b().getVisibility() == 0))
    {
      AIOShortcutBarContext localAIOShortcutBarContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
      if (localAIOShortcutBarContext != null) {
        localAIOShortcutBarContext.d();
      }
    }
  }
  
  public void j()
  {
    if (b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      IShortcutBarDataProvider localIShortcutBarDataProvider = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
      if (localIShortcutBarDataProvider == null) {
        return;
      }
      localIShortcutBarDataProvider.a(paramView.getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */