package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import zea;
import zeb;
import zec;
import zed;
import zee;
import zef;

public class ApolloGameHotChatController
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new zeb(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new zec(this);
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private zef jdField_a_of_type_Zef;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private WeakReference jdField_c_of_type_JavaLangRefWeakReference;
  private boolean jdField_c_of_type_Boolean;
  
  public ApolloGameHotChatController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    BaseActivity localBaseActivity;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (ApolloManager)paramQQAppInterface.getManager(152);
        } while (this.jdField_c_of_type_JavaLangRefWeakReference == null);
        localObject = (HotChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get();
      } while ((localObject == null) || (((HotChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      localBaseActivity = ((HotChatPie)localObject).a();
    } while (localBaseActivity == null);
    ApolloGameUtil.a(localBaseActivity, new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "launch", 0L, 6, 3, ((HotChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(paramQQAppInterface, ((HotChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((HotChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), ((HotChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 203));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaLangRefWeakReference == null) {}
    boolean bool;
    do
    {
      TipsManager localTipsManager;
      do
      {
        do
        {
          return;
          localObject = (HotChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        if (CmGameMainManager.a(this.jdField_b_of_type_JavaLangString) != null)
        {
          ((HotChatPie)localObject).p(false);
          ((HotChatPie)localObject).q(false);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        localTipsManager = ((HotChatPie)localObject).a();
      } while ((localTipsManager == null) || (this.jdField_a_of_type_Zef == null));
      ((HotChatPie)localObject).p(true);
      ((HotChatPie)localObject).q(true);
      bool = localTipsManager.a(this.jdField_a_of_type_Zef, new Object[0]);
      this.jdField_a_of_type_Boolean = true;
    } while ((!bool) || (!paramBoolean));
    Object localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setRepeatCount(0);
    ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((TranslateAnimation)localObject).setAnimationListener(new zee(this));
    zef.a(this.jdField_a_of_type_Zef).startAnimation((Animation)localObject);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int <= 0) {}
    HotChatPie localHotChatPie;
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_c_of_type_JavaLangRefWeakReference == null) || (this.jdField_c_of_type_JavaLangRefWeakReference.get() == null));
        localHotChatPie = (HotChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get();
      } while ((localHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      HotChatInfo localHotChatInfo = ((HotChatManager)localHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(localHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int j = this.jdField_a_of_type_Int;
      i = j;
      if (localHotChatInfo != null)
      {
        i = j;
        if (localHotChatInfo.apolloGameId > 0) {
          i = localHotChatInfo.apolloGameId;
        }
      }
    } while (i <= 0);
    ((VasExtensionHandler)localHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(i, "android.aio", false, 1, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext)
  {
    if (paramAppInterface == null) {}
    int i;
    int j;
    do
    {
      return;
      SharedPreferences localSharedPreferences = paramAppInterface.getPreferences();
      paramAppInterface = localSharedPreferences.getString("noActive_apollo_hotChatCode", null);
      i = localSharedPreferences.getInt("noActive_apollo_hotchatGameId", 0);
      j = localSharedPreferences.getInt("noActive_apollo_autojionflag", 0);
      if ((!TextUtils.isEmpty(paramAppInterface)) && (i > 0))
      {
        if (j > 0)
        {
          a(paramAppInterface, i, paramContext, false, 2);
          VipUtils.a(null, "cmshow", "Apollo", "auto_join_room", 0, 0, new String[] { String.valueOf(i) });
        }
        paramContext = localSharedPreferences.edit();
        paramContext.remove("noActive_apollo_hotChatCode");
        paramContext.remove("noActive_apollo_hotchatGameId");
        paramContext.commit();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameHotChatController", 2, new Object[] { "checkNeedRejionApolloHotChat, hotChatCode:", paramAppInterface, ",apolloGameId:", Integer.valueOf(i), "autoJionFlag:", Integer.valueOf(j) });
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameHotChatController", 2, new Object[] { "onApolloHotChatExitWhenNoActive, hotChatCode:", paramString1, ",apolloGameId:", Integer.valueOf(paramInt), ",troopUin:", paramString2 });
    }
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (paramInt <= 0)) {
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "Kicked_out_room", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public void a(HotChatPie paramHotChatPie)
  {
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Zef != null)
    {
      if ((zef.a(this.jdField_a_of_type_Zef).getParent() instanceof ViewGroup)) {
        ((ViewGroup)zef.a(this.jdField_a_of_type_Zef).getParent()).removeView(zef.a(this.jdField_a_of_type_Zef));
      }
      if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null))
      {
        TipsManager localTipsManager = ((HotChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a();
        if (localTipsManager.a() == this.jdField_a_of_type_Zef) {
          localTipsManager.a();
        }
      }
      this.jdField_a_of_type_Zef = null;
    }
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    if ((paramHotChatPie != null) && (paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(HotChatPie paramHotChatPie, boolean paramBoolean)
  {
    if ((paramHotChatPie == null) || (paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramHotChatPie.a() == null) || (paramHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      return;
      HotChatInfo localHotChatInfo = ((HotChatManager)paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localHotChatInfo == null)
      {
        this.jdField_a_of_type_Int = 0;
        return;
      }
      if (localHotChatInfo.apolloGameId <= 0)
      {
        ApolloGameData localApolloGameData = ((ApolloDaoManager)paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(localHotChatInfo.name);
        if (localApolloGameData != null) {
          this.jdField_a_of_type_Int = localApolloGameData.gameId;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int > 0) {
          break label150;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloGameHotChatController", 2, "checkShowGameTips, not apolloGameHotChat");
        return;
        this.jdField_a_of_type_Int = 0;
        continue;
        this.jdField_a_of_type_Int = localHotChatInfo.apolloGameId;
      }
      label150:
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHotChatPie.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramHotChatPie);
      this.jdField_c_of_type_Boolean = false;
      paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      this.jdField_b_of_type_Int = paramHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaLangString = paramHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (paramBoolean) {
        a(paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      while ((localHotChatInfo != null) && (QLog.isColorLevel()))
      {
        QLog.d("ApolloGameHotChatController", 2, new Object[] { "checkShowGameTips, info:", localHotChatInfo.name, ",info.apolloGameId:", Integer.valueOf(this.jdField_a_of_type_Int) });
        return;
        ((VasExtensionHandler)paramHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_Int, "android.aio", true, 1, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, Context paramContext, boolean paramBoolean, int paramInt2)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
        this.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_c_of_type_Int = paramInt2;
        paramContext = ((HotChatManager)((QQAppInterface)localObject).getManager(59)).a(paramInt1);
        if (paramContext == null) {
          break;
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 3;
        ((Message)localObject).obj = new Object[] { paramContext.troopUin, paramContext.troopCode, paramContext.name };
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
        this.jdField_a_of_type_JavaLangString = null;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloGameHotChatController", 2, "quickJionHotChat, local has hotChatCode:" + paramString + ",gameId:" + paramInt1);
      return;
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      this.jdField_a_of_type_JavaLangString = paramString;
      ThreadManager.postImmediately(new zea(this, (QQAppInterface)localObject, paramString, paramInt1), null, true);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameHotChatController", 2, "quickJionHotChat, query server, local no hotChatCode:" + paramString + ",gameId:" + paramInt1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int > 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int <= 0) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_c_of_type_JavaLangRefWeakReference == null);
        localObject = (HotChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      ((HotChatPie)localObject).p(false);
      ((HotChatPie)localObject).q(false);
      Object localObject = ((HotChatPie)localObject).a();
      if ((localObject != null) && (((TipsManager)localObject).a() == this.jdField_a_of_type_Zef))
      {
        ((TipsManager)localObject).a();
        if (this.jdField_a_of_type_Zef != null) {
          zef.a(this.jdField_a_of_type_Zef).setVisibility(8);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameHotChatController", 2, "refreshTipsBar, hideQuickJionTipsBar");
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localQQAppInterface != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int <= 0) {}
    HotChatPie localHotChatPie;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_JavaLangRefWeakReference == null);
      localHotChatPie = (HotChatPie)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    } while (localHotChatPie == null);
    TipsManager localTipsManager = localHotChatPie.a();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((localTipsManager != null) && (this.jdField_a_of_type_Zef != null) && (localTipsManager.a() == this.jdField_a_of_type_Zef) && (zef.a(this.jdField_a_of_type_Zef) != null) && (zef.a(this.jdField_a_of_type_Zef).getVisibility() == 0))
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
        localTranslateAnimation.setDuration(300L);
        localTranslateAnimation.setRepeatCount(0);
        localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        localTranslateAnimation.setAnimationListener(new zed(this, localTipsManager));
        zef.a(this.jdField_a_of_type_Zef).startAnimation(localTranslateAnimation);
      }
      localHotChatPie.p(true);
      localHotChatPie.q(false);
      this.jdField_a_of_type_Boolean = false;
      VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_bar", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      return;
    }
    a(true);
    VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_bar", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = (String)paramMessage.obj;
        QQToast.a(BaseApplication.getContext(), paramMessage, 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameHotChatController", 2, new Object[] { "not need open hotchat aio, mOperateType:", Integer.valueOf(this.jdField_c_of_type_Int) });
        }
        if (this.jdField_c_of_type_Int == 1)
        {
          if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
            return true;
          }
          Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localContext == null) {
            return true;
          }
          if ((paramMessage.obj instanceof Object[]))
          {
            paramMessage = (Object[])paramMessage.obj;
            if ((localContext != null) && (paramMessage.length >= 3) && ((paramMessage[0] instanceof String)) && ((paramMessage[1] instanceof String)) && ((paramMessage[2] instanceof String)))
            {
              Intent localIntent = AIOUtils.a(new Intent(localContext, SplashActivity.class), null);
              localIntent.putExtra("uin", (String)paramMessage[0]);
              localIntent.putExtra("uintype", 1);
              localIntent.putExtra("troop_uin", (String)paramMessage[1]);
              localIntent.putExtra("uinname", (String)paramMessage[2]);
              localIntent.putExtra("startApolloGame", this.jdField_b_of_type_Boolean);
              localContext.startActivity(localIntent);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameHotChatController", 2, new Object[] { "open hotchat aio, troopUin:", paramMessage[0], "troopCode:", paramMessage[1], ",UIN_NAME:", paramMessage[2], "mLaunchGameOnJioned", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
              }
            }
          }
        }
        else if ((this.jdField_c_of_type_Int == 2) && (this.jdField_b_of_type_JavaLangRefWeakReference != null))
        {
          paramMessage = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (paramMessage != null)
          {
            paramMessage = paramMessage.getHandler(Conversation.class);
            if (paramMessage != null)
            {
              paramMessage.sendMessage(paramMessage.obtainMessage(1009));
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameHotChatController", 2, "rejion apolloGame hotchat refresh conversation, mGameId:" + this.jdField_a_of_type_Int);
              }
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameHotChatController
 * JD-Core Version:    0.7.0.1
 */