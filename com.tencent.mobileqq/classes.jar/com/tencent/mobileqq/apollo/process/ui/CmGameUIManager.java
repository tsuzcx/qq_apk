package com.tencent.mobileqq.apollo.process.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.interfaces.OnApolloGameListener;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class CmGameUIManager
  implements Handler.Callback, View.OnClickListener
{
  private static int jdField_a_of_type_Int = 600000;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameTipsBar jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  public WeakReference<OnApolloGameListener> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  
  public CmGameUIManager(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = new ApolloGameData();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameName;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar = new CmGameTipsBar((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
    }
    if (ApolloConfigUtils.jdField_a_of_type_Int > 0)
    {
      jdField_a_of_type_Int = ApolloConfigUtils.jdField_a_of_type_Int * 1000;
      if (jdField_a_of_type_Int < 30000) {
        jdField_a_of_type_Int = 30000;
      }
      if (jdField_a_of_type_Int > 1800000) {
        jdField_a_of_type_Int = 1800000;
      }
    }
    QLog.i("cmgame_process.CmGameUIManager", 1, "sMinimizeGameTimeOut :" + jdField_a_of_type_Int);
  }
  
  private BaseChatPie a()
  {
    ChatFragment localChatFragment = null;
    Object localObject2 = CmGameUtil.a();
    Object localObject1 = localChatFragment;
    if (localObject2 != null)
    {
      localObject1 = localChatFragment;
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (ApolloManagerServiceImpl)((AppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
        localObject1 = localChatFragment;
        if (localObject2 != null)
        {
          localObject2 = ((ApolloManagerServiceImpl)localObject2).getGameChatPieRef();
          localObject1 = localChatFragment;
          if (localObject2 != null) {
            localObject1 = (BaseChatPie)((WeakReference)localObject2).get();
          }
        }
      }
    }
    if ((localObject1 == null) && (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)))
    {
      localChatFragment = (ChatFragment)((FragmentActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localChatFragment != null) {
        return localChatFragment.a();
      }
    }
    return localObject1;
  }
  
  private void g()
  {
    BaseChatPie localBaseChatPie = a();
    if ((localBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null) && (localBaseChatPie.a().a() == this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.isShown()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.a();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(20);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(20, 1000L);
    }
  }
  
  public int a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof BaseActivity)) && ((BaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (BaseActivity.sTopActivity != null) && ((((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 2)) || ((BaseActivity.sTopActivity instanceof ChatActivity)))) {
      return 1;
    }
    return 4;
  }
  
  public void a()
  {
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    b();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUIManager", 2, "uimanager onDestroy");
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar = new CmGameTipsBar(paramActivity, this);
  }
  
  public void a(OnApolloGameListener paramOnApolloGameListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnApolloGameListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).a();
      if ((localObject != null) && (((TipsManager)localObject).a() == this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar))
      {
        ((TipsManager)localObject).a();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameUIManager", 2, "cancelTipBar currentTipsTask dismissTipsBar()");
        }
      }
    }
    if ((CmGameUtil.a() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameUIManager", 2, "cancelTipBar BANNER_STATE_HIDE");
      }
      BannerManager.a().a(38, 0, null);
    }
  }
  
  public void c()
  {
    Message localMessage;
    if (CmGameUtil.a() != null)
    {
      localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = this.jdField_a_of_type_JavaLangString;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
          break label107;
        }
      }
    }
    label107:
    for (Object localObject1 = null;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131702191);
      }
      localMessage.obj = (HardCodeUtil.a(2131702187) + (String)localObject2);
      BannerManager.a().b(38, localMessage);
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Int == 3112) {
      return;
    }
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      try
      {
        if (((Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get()).isFinishing())
        {
          QLog.e("cmgame_process.CmGameUIManager", 1, "showAIOTips error act is finishing");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUIManager", 1, "showAIOTips error e=" + localThrowable.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.c.setVisibility(8);
    }
    label251:
    while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)
    {
      localObject1 = a();
      if ((localObject1 == null) || ((((BaseChatPie)localObject1).a != null) && (((BaseChatPie)localObject1).a.jdField_a_of_type_Int == 1036))) {
        break;
      }
      localObject1 = ((BaseChatPie)localObject1).a();
      if (localObject1 == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        ((TipsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar, new Object[0]);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.CmGameUIManager", 2, "showAIOTips ");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) {}
    for (Object localObject1 = null;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131702190);
      }
      localObject1 = HardCodeUtil.a(2131702192) + (String)localObject2;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      break;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
    QLog.d("cmgame_process.CmGameUIManager", 2, "onActivityResume mGameId:" + this.jdField_b_of_type_Int);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(25, jdField_a_of_type_Int);
    QLog.d("cmgame_process.CmGameUIManager", 2, "onActivityStop mGameId:" + this.jdField_b_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    switch (paramMessage.what)
    {
    }
    label595:
    label609:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                      paramMessage = a();
                    } while (paramMessage == null);
                    paramMessage.an();
                    return false;
                    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null) && ((paramMessage.obj instanceof String)))
                    {
                      if (((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue((String)paramMessage.obj, "retcode") != 0) {
                        return true;
                      }
                      ApolloUtilImpl.addApolloGrayTip(a(), 0);
                      return false;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_JION_ROOM, msg.obj is null");
                  return false;
                  if (QLog.isColorLevel()) {
                    QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_ROOM_MIN");
                  }
                  paramMessage = a();
                  if (paramMessage != null)
                  {
                    localObject3 = paramMessage.a();
                    if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null))
                    {
                      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof ViewGroup)) {
                        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout);
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
                      {
                        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                          break label595;
                        }
                        paramMessage = null;
                        localObject1 = paramMessage;
                        if (TextUtils.isEmpty(paramMessage)) {
                          localObject1 = HardCodeUtil.a(2131702193);
                        }
                        paramMessage = HardCodeUtil.a(2131702188) + (String)localObject1;
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
                      }
                      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.c.setVisibility(8);
                      ((TipsManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar, new Object[0]);
                      if (QLog.isColorLevel()) {
                        QLog.d("cmgame_process.CmGameUIManager", 2, "showGameTips");
                      }
                    }
                  }
                  Object localObject3 = CmGameUtil.a();
                  Message localMessage;
                  if (localObject3 != null)
                  {
                    localMessage = Message.obtain();
                    localMessage.what = 3000;
                    localMessage.obj = this.jdField_a_of_type_JavaLangString;
                    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                        break label609;
                      }
                    }
                  }
                  for (paramMessage = (Message)localObject2;; paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
                  {
                    localObject1 = paramMessage;
                    if (TextUtils.isEmpty(paramMessage)) {
                      localObject1 = HardCodeUtil.a(2131702184);
                    }
                    localMessage.obj = (HardCodeUtil.a(2131702186) + (String)localObject1);
                    BannerManager.a().b(38, localMessage);
                    if (this.jdField_b_of_type_Int > 0) {
                      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "miniature_game", a(), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int) });
                    }
                    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
                    {
                      paramMessage = (OnApolloGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                      if (paramMessage != null) {
                        paramMessage.a();
                      }
                    }
                    ApolloGameStateMachine.a().a(4, "message game min");
                    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
                    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(25, jdField_a_of_type_Int);
                    return false;
                    paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
                    break;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                      break label736;
                    }
                  }
                  for (paramMessage = "";; paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
                  {
                    VipUtils.a(null, "cmshow", "Apollo", "game_shutdown", 0, 0, new String[] { paramMessage });
                    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
                    {
                      paramMessage = (OnApolloGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                      if (paramMessage != null) {
                        paramMessage.d("");
                      }
                    }
                    CmGameClientQIPCModule.a(this.jdField_b_of_type_Int);
                    QLog.i("cmgame_process.CmGameUIManager", 1, "MSG_CODE_CLOSE_GAME_TIMEOUT timeout colsegame mGameParams:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                    return false;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_CLOSE_ROOM");
                  }
                  localObject2 = a();
                  if (localObject2 != null)
                  {
                    localObject2 = ((BaseChatPie)localObject2).a();
                    if (localObject2 != null)
                    {
                      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != ((TipsManager)localObject2).a())) {
                        break label967;
                      }
                      ((TipsManager)localObject2).a();
                      if (QLog.isColorLevel()) {
                        QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage currentTipsTask dismissTipsBar()");
                      }
                    }
                  }
                  for (;;)
                  {
                    if (((this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (!(this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity))) || (this.jdField_a_of_type_JavaLangRefWeakReference != null))
                    {
                      localObject2 = (OnApolloGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                      if ((paramMessage.obj instanceof String)) {
                        localObject1 = (String)paramMessage.obj;
                      }
                      if (localObject2 != null) {
                        ((OnApolloGameListener)localObject2).d((String)localObject1);
                      }
                    }
                    paramMessage = CmGameUtil.a();
                    if ((paramMessage == null) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
                      break;
                    }
                    VipUtils.a(paramMessage, "cmshow", "Apollo", "shutdown_game", 0, 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), Integer.toString(CmGameUtil.b()), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag & 0x1) });
                    return false;
                    if (QLog.isColorLevel()) {
                      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage not dismissTipsBar()");
                    }
                  }
                  QLog.e("cmgame_process.CmGameUIManager", 1, "[min game] null app");
                  return false;
                  if ((paramMessage.obj instanceof String))
                  {
                    this.jdField_a_of_type_JavaLangString = ((String)paramMessage.obj);
                    if (QLog.isColorLevel()) {
                      QLog.d("cmgame_process.CmGameUIManager", 2, new Object[] { "MSG_CODE_SHOW_TIPS update tips:", this.jdField_a_of_type_JavaLangString });
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.c.setVisibility(8);
                      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText((String)paramMessage.obj);
                    }
                  }
                } while (!(CmGameUtil.a() instanceof QQAppInterface));
                paramMessage = Message.obtain();
                paramMessage.what = 3000;
                paramMessage.arg1 = 1;
                paramMessage.obj = this.jdField_a_of_type_JavaLangString;
                BannerManager.a().b(38, paramMessage);
                return false;
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
                if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
                    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mStartType = 1;
                  }
                  ApolloGameUtil.a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                }
                ApolloGameStateMachine.a().a(3, "message show game");
                paramMessage = a();
              } while (paramMessage == null);
              if (paramMessage != null)
              {
                paramMessage.an();
                if (QLog.isColorLevel()) {
                  QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_SHOW_GAME hidePanel");
                }
              }
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(24, 500L);
              return false;
              paramMessage = a();
            } while (paramMessage == null);
            paramMessage.an();
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_CHECK_HIDE_PANEL hidePanel");
          return false;
        } while (!(paramMessage.obj instanceof String));
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null))
        {
          localObject1 = (String)paramMessage.obj;
          localObject2 = new SpannableString((String)localObject1 + HardCodeUtil.a(2131702189));
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(-16776961), 0, ((String)localObject1).length(), 17);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          g();
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_SHOW_JOIN_TIP, msg.obj is " + paramMessage.obj + ",mGameStarted:" + this.jdField_a_of_type_Boolean);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_RESET_JION_ROOM");
      }
      paramMessage = a();
    } while ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar == null) || (paramMessage.a().a() != this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar) || (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.isShown()));
    label736:
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.b();
    label967:
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
    {
      Object localObject2 = a();
      if (localObject2 == null) {
        break label122;
      }
      localObject1 = CmGameUtil.a();
      localObject2 = ((BaseChatPie)localObject2).a();
      i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionTypeByContext((SessionInfo)localObject2, (AppInterface)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
        break label147;
      }
    }
    label147:
    for (Object localObject1 = "";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", i, 0, new String[] { localObject1 });
      localObject1 = a();
      if (localObject1 != null) {
        ((BaseChatPie)localObject1).an();
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 300L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label122:
      i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameUIManager
 * JD-Core Version:    0.7.0.1
 */