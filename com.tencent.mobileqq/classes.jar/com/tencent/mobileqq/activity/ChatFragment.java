package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOEnterInAni;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import rvg;
import rvh;

public class ChatFragment
  extends Fragment
  implements Handler.Callback, TopGestureLayout.OnGestureListener
{
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  private static boolean c;
  public Context a;
  public FragmentActivity a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new rvh(this);
  public BaseChatPie a;
  ChatFragment.InterceptTouchEventListener jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener;
  ChatFragment.MyDispatchDrawListener jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener;
  AIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
  public TopGestureLayout a;
  public QQAppInterface a;
  public SystemBarCompact a;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public static ChatFragment a()
  {
    ChatFragment localChatFragment = new ChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localChatFragment.setArguments(localBundle);
    return localChatFragment;
  }
  
  private void a(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public static void a(boolean paramBoolean)
  {
    if (c != paramBoolean) {
      c = paramBoolean;
    }
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1);
  }
  
  private void f()
  {
    long l;
    if (isVisible())
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.hide(this);
      localFragmentTransaction.commitAllowingStateLoss();
      StartupTracker.a("AIO_preLoad_Cost", null);
      l = SystemClock.uptimeMillis() - AIOPreLoadEngine.a;
      PerformanceReportUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 10, l);
      if (QLog.isColorLevel()) {}
    }
    else
    {
      return;
    }
    QLog.d("Q.aio.ChatFragment", 2, "AIO preLoad cost:" + l);
  }
  
  private void g()
  {
    int i = -1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
      }
      if (QLog.isColorLevel())
      {
        String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("KEY_FROM");
        String str1 = str2;
        if (str2 == null)
        {
          ComponentName localComponentName = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCallingActivity();
          str1 = str2;
          if (localComponentName != null) {
            str1 = localComponentName.getClassName();
          }
        }
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + StartupTracker.a + ",from:" + str1);
      }
      if (!QQAppInterface.b) {
        break label227;
      }
    }
    label227:
    for (int j = 0;; j = 1)
    {
      PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
      PerformanceReportUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, StartupTracker.a);
      this.jdField_a_of_type_Boolean = false;
      ThreadManager.post(new rvg(this, i, j), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "AIOTime aioOpenTimeReport end Cost " + StartupTracker.a + " AIOType: " + i + " firstOpenAIO: " + j);
      }
      return;
    }
  }
  
  protected Dialog a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt);
    }
    return null;
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramInt);
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onBackEvent " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e();
    }
    return false;
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "canReuseChatPie: " + bool1);
      }
      return bool1;
      bool1 = paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false);
      boolean bool3 = ForwardOptionUtils.a(paramIntent);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.I)
        {
          String str1 = paramIntent.getStringExtra("uin");
          String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_JavaLangString;
          bool1 = bool2;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = bool2;
            if (str1.equals(str2))
            {
              int i = paramIntent.getIntExtra("uintype", -1);
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int == i) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.z();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie already cleared.");
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(paramInt);
      e();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n(paramBoolean);
    }
  }
  
  protected boolean b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.H();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "getChatPie doOnNewIntent_clearBusinessData " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    Object localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel())) {
      QLog.i("Q.aio.ChatFragment", 2, "getChatPie uin=" + ((String)localObject).substring(((String)localObject).length() - 4));
    }
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getChatPie subType = ").append(i).append(" type = ").append(paramIntent.getIntExtra("uintype", -1)).append(" mRootView is null?: ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
      {
        bool1 = true;
        QLog.i("Q.aio.ChatFragment", 2, bool1);
      }
    }
    else
    {
      switch (i)
      {
      case 2: 
      default: 
        i = paramIntent.getIntExtra("uintype", -1);
        if (i == 1026)
        {
          if (!QLog.isDevelopLevel()) {
            break label1684;
          }
          QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "AIOTime getChatPie no Type at default");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BaseChatPie))) {
          if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
            b();
          }
        }
        break;
      case 0: 
        label269:
        label574:
        do
        {
          do
          {
            do
            {
              return false;
              bool1 = false;
              break;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie))) {
                break label574;
              }
            } while (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity));
            b();
            return false;
            b();
            a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BusinessCmrTmpChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
            return true;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof MultiForwardChatPie))) {
              break label649;
            }
          } while (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity));
          b();
          return false;
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new MultiForwardChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          return true;
          if (i == 0)
          {
            if ((!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin"), i)) && (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin")))) {
              break label1681;
            }
            i = 1024;
            paramIntent.putExtra("uintype", 1024);
            break label269;
          }
          if (i != 1025) {
            break label1681;
          }
          localObject = paramIntent.getStringExtra("uin");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b((String)localObject))) {
            break label1681;
          }
          paramIntent.putExtra("uintype", 0);
          i = 0;
          break label269;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof FriendChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie))) {
            break label847;
          }
        } while (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity));
        label649:
        b();
        return false;
        label847:
        b();
        a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new FriendChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return true;
        localObject = paramIntent.getStringExtra("uin");
        HotChatManager localHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
        bool1 = localHotChatManager.b((String)localObject);
        boolean bool2 = paramIntent.getBooleanExtra("isGameRoom", false);
        if ((bool1) || (bool2))
        {
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          paramIntent = localHotChatManager.a((String)localObject);
          if (((paramIntent != null) && (paramIntent.isGameRoom)) || (bool2)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new GameRoomChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new HotChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getClass().equals(TroopChatPie.class)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new TroopChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new DiscussChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BusinessCmrTmpChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new PublicAccountChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DeviceMsgChatPie)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new DeviceMsgChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof StrangerChatPie)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new StrangerChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof NearbyChatPie)))
          {
            if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
              break;
            }
            b();
            return false;
          }
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new NearbyChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          b();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new ArkDebugChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          b();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new ConfessChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          continue;
          b();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BaseChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
        }
      }
      label1681:
      continue;
      label1684:
      i = 1;
    }
  }
  
  public void c()
  {
    if (a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent())) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aG();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
      {
        a(false);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      return;
      if (b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mRootView != null---created a new Pie");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
          View localView = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130968738, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(localView);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.ChatFragment", 2, "onNewIntent mRootView == null---created a new Pie");
        }
      }
      else if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.ChatFragment", 2, "onNewIntent ChatActivity ");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.ChatFragment", 2, "onNewIntent ChatActivity mBasePie == null");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mBasePie.doOnCreate(false) reuse the pie.");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
      }
    }
  }
  
  public void c(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(paramInt, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "fight doInMultiWindowModeStatusBarVisibilityChange  = " + paramInt);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131494247);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Q();
    }
  }
  
  public void e()
  {
    int j = 0;
    int k = 1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      i = k;
      if (getActivity() != null)
      {
        i = k;
        if (getActivity().isInMultiWindow())
        {
          i = k;
          if (getActivity().isNeedStatusBarGone())
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.aio.ChatFragment", 4, "fight onMulitWindowModePause isNeedStatusBarGone = true");
            }
            i = 0;
          }
        }
      }
      if (i == 0) {
        break label74;
      }
    }
    label74:
    for (int i = j;; i = 2)
    {
      c(i);
      return;
    }
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingLToR " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(true);
    }
  }
  
  public void flingRToL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingRToL " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public String getCIOPageName()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onAttach");
    }
    StartupTracker.a(null, "AIO_Super_onAttach");
    super.onAttach(paramActivity);
    StartupTracker.a("AIO_Super_onAttach", "AIO_onAttach");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter = new AIOTimeReporter();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("uintype", -1) == 1026))
    {
      localIntent.putExtra("uintype", 1);
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "check UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener = new ChatFragment.MyDispatchDrawListener(this);
    StartupTracker.a("AIO_onAttach", null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onConfigurationChanged");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreate");
    }
    StartupTracker.a(null, "AIO_Super_onCreate");
    super.onCreate(paramBundle);
    StartupTracker.a("AIO_Super_onCreate", null);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2131034173)
      {
        localObject = new AIOEnterInAni();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131689481));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
        ((Animation)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      }
      for (;;)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
        return localObject;
        localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      }
    }
    ((Animation)localObject).reset();
    return localObject;
  }
  
  @TargetApi(14)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreateView");
    }
    StartupTracker.a(null, "AIO_onCreateView");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener = new ChatFragment.InterceptTouchEventListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new TopGestureLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener);
      paramLayoutInflater = (View)paramViewGroup.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setBackgroundResource(2130845819);
      }
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setLayoutParams(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130968738, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(paramLayoutInflater);
        a(false);
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onCreateView mRootView == null");
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setFitsSystemWindows(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setPadding(0, ImmersiveUtils.a(getActivity()) - 10, 0, 0);
        }
        StartupTracker.a("AIO_onCreateView", null);
        return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.i("Q.aio.ChatFragment", 1, "onCreateView:", paramLayoutInflater);
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      }
    }
  }
  
  public void onDestroy()
  {
    StartupTracker.a(null, "AIO_Super_onDestroy");
    super.onDestroy();
    StartupTracker.a("AIO_Super_onDestroy", "AIO_onDestroy");
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.z();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onDestroy " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = null;
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp destroy");
      }
    }
    StartupTracker.a("AIO_onDestroy", null);
  }
  
  public void onDestroyView()
  {
    StartupTracker.a(null, "AIO_Super_onDestroyView");
    super.onDestroyView();
    StartupTracker.a("AIO_Super_onDestroyView", null);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onHiddenChanged hidden = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.b = true;
      onPause();
      onStop();
      this.b = false;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 500L);
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isFromMainTab", false))
      {
        onStart();
        onResume();
      }
    }
  }
  
  public void onPause()
  {
    StartupTracker.a(null, "AIO_Super_onPause");
    super.onPause();
    StartupTracker.a("AIO_Super_onPause", "AIO_onPause");
    if ((c()) && (!this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.E();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a();
    }
    StartupTracker.a("AIO_onPause", null);
  }
  
  public void onResume()
  {
    StartupTracker.a(null, "AIO_Super_onResume");
    super.onResume();
    StartupTracker.a("AIO_Super_onResume", "AIO_onResume");
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume return");
      }
      f();
      return;
    }
    long l1;
    Drawable localDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
      l1 = SystemClock.uptimeMillis();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
          break label480;
        }
        if (QLog.isColorLevel()) {
          QLog.d("systembar", 2, "mChatBarComp =null new compact");
        }
        int i = getResources().getColor(2131494247);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, i);
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
          break label361;
        }
        localDrawable = QIMUserManager.a().b(4);
        if (localDrawable == null) {
          break label334;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      }
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("systembar", 2, "duration=====" + (l2 - l1));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G();
      getActivity().getWindow().setSoftInputMode(18);
      if (BaseApplicationImpl.appStartTime > 0L) {
        Log.d("AutoMonitor", "actStartChat, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
      }
      StartupTracker.a("AIO_onResume", "AIO_onDrawView");
      return;
      label334:
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130843245));
      break;
      label361:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c))
      {
        localDrawable = TIMUserManager.a().b(4);
        if (localDrawable != null)
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
          break;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130843245));
        break;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130843245));
      break;
      label480:
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp isStatusBarVisible=" + this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c))
      {
        localDrawable = QIMUserManager.a().b(4);
        if (localDrawable != null) {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible) || (getActivity() == null)) {
          break label815;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
          break label817;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
        break;
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130843245));
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c))
          {
            localDrawable = TIMUserManager.a().b(4);
            if (localDrawable != null) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
            } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130843245));
            }
          }
          else if (ThemeUtil.isDefaultOrDIYTheme(false))
          {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130843245));
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131494247));
          }
        }
      }
      label815:
      continue;
      label817:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
      } else {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (c()) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C();
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onStart " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
        }
      }
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null);
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    ReadinjoySPEventReport.a().a(1, null, str, i);
  }
  
  public void onStop()
  {
    StartupTracker.a(null, "AIO_Super_onStop");
    super.onStop();
    StartupTracker.a("AIO_Super_onStop", "AIO_onStop");
    if (HapticManager.a())
    {
      HapticManager.a();
      HapticManager.c();
    }
    if ((c()) && (!this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.D();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    StartupTracker.a("AIO_onStop", null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    StartupTracker.a(null, "AIO_Super_onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    StartupTracker.a("AIO_Super_onViewCreated", "AIO_onViewCreated");
    StartupTracker.a(null, "AIO_onCreate_getPieCost");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    }
    b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onCreate_getPieCost", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (!c()) {
        break label143;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.R_();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_onViewCreated", null);
      return;
      label143:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */