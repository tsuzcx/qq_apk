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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.interfaces.OnApolloGameListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class CmGameUIManager
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameTipsBar jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  WeakReference b;
  
  public CmGameUIManager(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.b = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = new ApolloGameData();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar = new CmGameTipsBar((Context)this.b.get(), this);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
    }
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
        localObject2 = (ApolloManager)((AppInterface)localObject2).getManager(152);
        localObject1 = localChatFragment;
        if (localObject2 != null)
        {
          localObject2 = ((ApolloManager)localObject2).a();
          localObject1 = localChatFragment;
          if (localObject2 != null) {
            localObject1 = (BaseChatPie)((WeakReference)localObject2).get();
          }
        }
      }
    }
    if ((localObject1 == null) && (this.b != null) && (this.b.get() != null) && ((this.b.get() instanceof FragmentActivity)))
    {
      localChatFragment = (ChatFragment)((FragmentActivity)this.b.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localChatFragment != null) {
        return localChatFragment.a();
      }
    }
    return localObject1;
  }
  
  private void d()
  {
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    a();
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = null;
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUIManager", 2, "onDestroy");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((OnApolloGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g();
    }
  }
  
  private void e()
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
    if ((this.b != null) && (this.b.get() != null) && ((this.b.get() instanceof BaseActivity)) && ((BaseActivity)this.b.get() != null) && (BaseActivity.sTopActivity != null) && ((((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 2)) || ((BaseActivity.sTopActivity instanceof ChatActivity)))) {
      return 1;
    }
    return 4;
  }
  
  public void a()
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
    localObject = CmGameUtil.a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((AppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134052));
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameUIManager", 2, "cancelTipBar Conversation.MSG_APOLLO_GAME_HIDE");
        }
      }
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
    AppInterface localAppInterface = CmGameUtil.a();
    if (localAppInterface != null)
    {
      MqqHandler localMqqHandler = localAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        Message localMessage = localMqqHandler.obtainMessage(1134051);
        localMessage.obj = this.jdField_a_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
        {
          String str2 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = "轻游戏";
          }
          localMessage.obj = ("正在玩" + str1);
        }
        localMqqHandler.sendMessage(localMessage);
      }
      ((ApolloManager)localAppInterface.getManager(152)).a().b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label64;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.c.setVisibility(8);
    }
    label64:
    do
    {
      Object localObject;
      do
      {
        for (;;)
        {
          localObject = a();
          if (localObject != null) {
            break;
          }
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
          {
            String str = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
            localObject = str;
            if (TextUtils.isEmpty(str)) {
              localObject = "轻游戏";
            }
            localObject = "正在玩" + (String)localObject;
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
        }
        localObject = ((BaseChatPie)localObject).a();
      } while (localObject == null);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        ((TipsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar, new Object[0]);
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameUIManager", 2, "showAIOTips ");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label646:
    label879:
    do
    {
      do
      {
        Object localObject2;
        Object localObject1;
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
                      paramMessage.ai();
                      return false;
                      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null) && ((paramMessage.obj instanceof String)))
                      {
                        if (ApolloUtil.a((String)paramMessage.obj, "retcode") != 0) {
                          return true;
                        }
                        ApolloUtil.a(a(), 0);
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
                      localObject2 = paramMessage.a();
                      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null))
                      {
                        if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof ViewGroup)) {
                          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout);
                        }
                        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
                        {
                          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
                          paramMessage = (Message)localObject1;
                          if (TextUtils.isEmpty((CharSequence)localObject1)) {
                            paramMessage = "轻游戏";
                          }
                          paramMessage = "正在玩" + paramMessage;
                          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
                          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
                        }
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.c.setVisibility(8);
                        ((TipsManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar, new Object[0]);
                        if (QLog.isColorLevel()) {
                          QLog.d("cmgame_process.CmGameUIManager", 2, "showGameTips");
                        }
                      }
                    }
                    localObject2 = CmGameUtil.a();
                    if (localObject2 != null)
                    {
                      MqqHandler localMqqHandler = ((AppInterface)localObject2).getHandler(Conversation.class);
                      if (localMqqHandler != null)
                      {
                        Message localMessage = localMqqHandler.obtainMessage(1134051);
                        localMessage.obj = this.jdField_a_of_type_JavaLangString;
                        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
                        {
                          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
                          paramMessage = (Message)localObject1;
                          if (TextUtils.isEmpty((CharSequence)localObject1)) {
                            paramMessage = "轻游戏";
                          }
                          localMessage.obj = ("正在玩" + paramMessage);
                        }
                        localMqqHandler.sendMessage(localMessage);
                      }
                      ((ApolloManager)((AppInterface)localObject2).getManager(152)).a().b();
                    }
                    if (this.jdField_a_of_type_Int > 0) {
                      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "miniature_game", a(), 0, new String[] { Integer.toString(this.jdField_a_of_type_Int) });
                    }
                    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
                    {
                      paramMessage = (OnApolloGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                      if (paramMessage != null) {
                        paramMessage.a();
                      }
                    }
                    ApolloGameStateMachine.a().a(4, "message game min");
                    return false;
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                        break label646;
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
                      d();
                      QLog.i("cmgame_process.CmGameUIManager", 1, "MSG_CODE_CLOSE_GAME_TIMEOUT timeout colsegame");
                      return false;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_CLOSE_ROOM");
                    }
                    localObject1 = a();
                    if (localObject1 != null)
                    {
                      localObject1 = ((BaseChatPie)localObject1).a();
                      if (localObject1 != null)
                      {
                        if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != ((TipsManager)localObject1).a())) {
                          break label879;
                        }
                        ((TipsManager)localObject1).a();
                        if (QLog.isColorLevel()) {
                          QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage currentTipsTask dismissTipsBar()");
                        }
                      }
                    }
                    if ((this.b.get() != null) && ((this.b.get() instanceof FragmentActivity)))
                    {
                      localObject1 = CmGameUtil.a();
                      if ((localObject1 instanceof QQAppInterface)) {
                        ((ApolloManager)((AppInterface)localObject1).getManager(152)).a().a();
                      }
                    }
                    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
                    {
                      localObject2 = (OnApolloGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                      localObject1 = null;
                      if ((paramMessage.obj instanceof String)) {
                        localObject1 = (String)paramMessage.obj;
                      }
                      if (localObject2 != null) {
                        ((OnApolloGameListener)localObject2).d((String)localObject1);
                      }
                    }
                    paramMessage = CmGameUtil.a();
                    if ((paramMessage != null) && (this.jdField_a_of_type_Int > 0)) {
                      VipUtils.a(paramMessage, "cmshow", "Apollo", "shutdown_game", 0, 0, new String[] { Integer.toString(this.jdField_a_of_type_Int) });
                    }
                    for (;;)
                    {
                      d();
                      return false;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage not dismissTipsBar()");
                      break;
                      QLog.e("cmgame_process.CmGameUIManager", 1, "[min game] null app");
                    }
                    if ((paramMessage.obj instanceof String))
                    {
                      this.jdField_a_of_type_JavaLangString = ((String)paramMessage.obj);
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.c.setVisibility(8);
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetTextView.setText((String)paramMessage.obj);
                      }
                    }
                    paramMessage = CmGameUtil.a();
                  } while (!(paramMessage instanceof QQAppInterface));
                  paramMessage = paramMessage.getHandler(Conversation.class);
                } while (paramMessage == null);
                localObject1 = paramMessage.obtainMessage(1134051);
                ((Message)localObject1).arg1 = 1;
                ((Message)localObject1).obj = this.jdField_a_of_type_JavaLangString;
                paramMessage.sendMessage((Message)localObject1);
                return false;
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
                if (this.b != null) {
                  ApolloGameUtil.a((Context)this.b.get(), this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                }
                ApolloGameStateMachine.a().a(3, "message show game");
                paramMessage = a();
              } while (paramMessage == null);
              if (paramMessage != null)
              {
                paramMessage.ai();
                if (QLog.isColorLevel()) {
                  QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_SHOW_GAME hidePanel");
                }
              }
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(24, 500L);
              return false;
              paramMessage = a();
            } while (paramMessage == null);
            paramMessage.ai();
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_CHECK_HIDE_PANEL hidePanel");
          return false;
        } while (!(paramMessage.obj instanceof String));
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar != null))
        {
          localObject1 = (String)paramMessage.obj;
          localObject2 = new SpannableString((String)localObject1 + "加入游戏");
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(-16776961), 0, ((String)localObject1).length(), 17);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          e();
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_SHOW_JOIN_TIP, msg.obj is " + paramMessage.obj + ",mGameStarted:" + this.jdField_a_of_type_Boolean);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_RESET_JION_ROOM");
      }
      paramMessage = a();
    } while ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar == null) || (paramMessage.a().a() != this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar) || (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.jdField_a_of_type_AndroidWidgetRelativeLayout.isShown()));
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameTipsBar.b();
    return false;
  }
  
  public void onClick(View paramView)
  {
    AppInterface localAppInterface;
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
    {
      paramView = a();
      if (paramView == null) {
        break label96;
      }
      localAppInterface = CmGameUtil.a();
    }
    label96:
    for (int i = ApolloUtil.a(paramView.a(), localAppInterface);; i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType))
    {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", i, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name });
      a();
      paramView = a();
      if (paramView != null) {
        paramView.ai();
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(18, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameUIManager
 * JD-Core Version:    0.7.0.1
 */