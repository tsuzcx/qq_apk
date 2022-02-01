package com.tencent.mobileqq.activity.aio.helper;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ILeftAppShortBarDataUI;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.IAppShortcutBarDataUI;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortcutBarAIOHelper
  implements ILifeCycleHelper
{
  private long jdField_a_of_type_Long;
  public View a;
  public BaseChatPie a;
  private ShortcutBarAIOHelper.OnVisibilityChangedListener jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper$OnVisibilityChangedListener = new ShortcutBarAIOHelper.1(this);
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private ILeftAppShortBarDataUI jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI;
  private IAppShortcutBarDataUI jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI;
  public AppShortcutBarScrollView a;
  private DrawerFrame.TouchEventConsumer jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer = new ShortcutBarAIOHelper.3(this);
  private String jdField_a_of_type_JavaLangString;
  protected List<ShortcutBarAIOHelper.OnVisibilityChangedListener> a;
  protected boolean a;
  protected boolean b;
  private boolean c;
  private boolean d = false;
  
  public ShortcutBarAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ShortcutBarAIOHelper.OnVisibilityChangedListener)localIterator.next()).a(paramInt);
      }
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "resetBlurViewTopMargin");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
      localLayoutParams.topMargin = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return 0L;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo is null");
        return 0L;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo.curFriendUin is null");
      return 0L;
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("ShortcutBarAIOHelper", 2, "getTroopUinNoEmpty is Exception");
    return 0L;
  }
  
  protected View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie is null");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie.app is null");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mChatPie.mAIORootView is null");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = a();
        this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
        if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
          QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mTroopUinStr: " + this.jdField_a_of_type_JavaLangString);
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558621, null));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) {
            this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372723);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init mAppShortcutBarView is null");
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init got OOM, e:" + localOutOfMemoryError.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init got InflateException, e:" + localInflateException.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
          return;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI = new LeftAppShortcutBarPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI = new AppShortcutBarPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, this);
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = new ShortBarDataProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new ShortcutBarAIOHelper.2(this));
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "initData.");
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131369142);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setMove(true);
  }
  
  public void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "onUpdatePanel from: " + paramInt + "bShowManageBtn" + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      if (paramInt == 0) {
        if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.a()))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (paramInt != 0) {
            break label180;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.a(paramArrayList, paramBoolean);
          }
        }
      }
    }
    label180:
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      do
      {
        for (;;)
        {
          return;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          continue;
          if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.a())) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          } else {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
      } while ((paramInt != 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI == null));
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.a(paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.b(paramView.getTag());
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (a() == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131371965);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131377560);
  }
  
  public void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView == null) || (a() == null)) {}
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (paramRelativeLayout != null)
      {
        i = j;
        if ((TextView)paramRelativeLayout.findViewById(2131371965) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131371965);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131377560);
  }
  
  public void a(ShortcutBarAIOHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramOnVisibilityChangedListener)) {
        if (QLog.isColorLevel()) {
          QLog.e("ShortcutBarAIOHelper", 2, "addShortcutBarVisibilityListener. mOnVisibilityChangedListeners already contains listener");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ShortcutBarAIOHelper", 2, "addShortcutBarVisibilityListener.");
      }
      this.jdField_a_of_type_JavaUtilList.add(paramOnVisibilityChangedListener);
      return;
    }
    QLog.e("ShortcutBarAIOHelper", 2, "addShortcutBarVisibilityListener. mOnVisibilityChangedListeners is null");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "notifyAIOIceBreakViewShowingStatus isShow = " + paramBoolean);
    }
    this.b = paramBoolean;
    if (paramBoolean)
    {
      i();
      return;
    }
    h();
  }
  
  public boolean a()
  {
    boolean bool = this.c;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "triggerSyncOnce() syncOnce = " + bool);
    }
    return bool;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!b()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (paramMotionEvent == null)) {
      bool = false;
    }
    int i;
    int j;
    do
    {
      return bool;
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getLocationOnScreen(paramMotionEvent);
    } while (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getWidth(), paramMotionEvent[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight()).contains(i, j));
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
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieShowFirstBegin");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.d();
    }
  }
  
  public void b(ShortcutBarAIOHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramOnVisibilityChangedListener)) {
        if (QLog.isColorLevel()) {
          QLog.i("ShortcutBarAIOHelper", 2, "removeShortcutBarVisibilityListener.");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnVisibilityChangedListener);
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ShortcutBarAIOHelper", 2, "removeShortcutBarVisibilityListener.mOnVisibilityChangedListeners doesn't contain listener");
      return;
    }
    QLog.e("ShortcutBarAIOHelper", 2, "removeShortcutBarVisibilityListener.mOnVisibilityChangedListeners is null");
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.b) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI == null) || (this.jdField_a_of_type_Boolean) || ((!this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.a()) && (!this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.a()))) {
      return false;
    }
    return true;
  }
  
  protected int c()
  {
    return 0;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieResume");
    }
    if (this.d) {
      this.d = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.c();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieCreate");
    }
    a();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper$OnVisibilityChangedListener);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.b();
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.onChatPieDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "onChatPieDestroy. null check return. ");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgILeftAppShortBarDataUI = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappIAppShortcutBarDataUI = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "onChatPieDestroy. ");
    }
    i();
    b(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper$OnVisibilityChangedListener);
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent() != null) && ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    this.d = false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setAppShortcutBarVisible");
    }
    a().setVisibility(0);
    a(0);
  }
  
  public void g()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout");
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    int i;
    if ((a() != null) && (a().isShown()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with scroll_panel_app_shorts");
      }
      i = ViewUtils.a(39.0F);
      boolean bool = AnonymousChatHelper.a().a(this.jdField_a_of_type_JavaLangString);
      if ((ThemeUtil.isSimpleDayTheme(false)) || (bool))
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
        if (localDrawable != null)
        {
          localDrawable = localDrawable.getConstantState().newDrawable();
          a().setBackgroundDrawable(localDrawable);
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout marginTop = " + i);
      }
      localLayoutParams.topMargin = (i * -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setLayoutParams(localLayoutParams);
      return;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        a().setBackgroundColor(-16777216);
      }
      else
      {
        a().setBackgroundResource(0);
        continue;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with inputBar");
          i = j;
        }
      }
    }
  }
  
  public String getTag()
  {
    return "ShortcutBarAIOHelper";
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (a() == null) || (this.jdField_a_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar mIsInputJump" + this.jdField_a_of_type_Boolean);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.b) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar return for AIOIceBreakViewShowing");
        return;
      } while (!b());
      TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(23);
      if ((localTroopRobotHelper == null) || (!localTroopRobotHelper.b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "resumeAppShorcutBar");
    }
    a().setPadding(a(), c(), b(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.b(2131377560);
    }
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestLayout();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (a() == null)) {}
    while (a().getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutBarAIOHelper", 2, "hideAppShortcutBar");
    }
    boolean bool = a().isShown();
    a().setPadding(a(), c(), b(), 0);
    a().setVisibility(8);
    a(8);
    if (bool) {
      b(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestLayout();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 6, 14 };
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(paramView.getTag());
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      d();
      return;
    case 7: 
      b();
      return;
    case 6: 
      c();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper
 * JD-Core Version:    0.7.0.1
 */