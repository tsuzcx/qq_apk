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
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class anaf
  implements Handler.Callback, View.OnClickListener
{
  private static int jdField_a_of_type_Int = 600000;
  private anae jdField_a_of_type_Anae;
  private bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference<amzu> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  
  public anaf(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = new ApolloGameData();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameName;
    }
    this.jdField_a_of_type_Anae = new anae((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
    }
    if (anjy.jdField_a_of_type_Int > 0)
    {
      jdField_a_of_type_Int = anjy.jdField_a_of_type_Int * 1000;
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
    Object localObject2 = amwn.a();
    Object localObject1 = localChatFragment;
    if (localObject2 != null)
    {
      localObject1 = localChatFragment;
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (amme)((AppInterface)localObject2).getManager(QQManagerFactory.APOLLO_MANAGER);
        localObject1 = localChatFragment;
        if (localObject2 != null)
        {
          localObject2 = ((amme)localObject2).a();
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
    if ((localBaseChatPie != null) && (this.jdField_a_of_type_Anae != null) && (localBaseChatPie.getTipManager().a() == this.jdField_a_of_type_Anae) && (this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout.isShown()))
    {
      this.jdField_a_of_type_Anae.a();
      this.jdField_a_of_type_Bkys.removeMessages(20);
      this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(20, 1000L);
    }
  }
  
  public int a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof BaseActivity)) && ((BaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (BaseActivity.sTopActivity != null) && ((((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 2)) || ((BaseActivity.sTopActivity instanceof ChatActivity)))) {
      return 1;
    }
    return 4;
  }
  
  public void a()
  {
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
    b();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUIManager", 2, "uimanager onDestroy");
    }
  }
  
  public void a(amzu paramamzu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamzu);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_Anae = new anae(paramActivity, this);
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
      localObject = ((BaseChatPie)localObject).getTipManager();
      if ((localObject != null) && (((ailr)localObject).a() == this.jdField_a_of_type_Anae))
      {
        ((ailr)localObject).a();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameUIManager", 2, "cancelTipBar currentTipsTask dismissTipsBar()");
        }
      }
    }
    localObject = amwn.a();
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
  
  public void c()
  {
    Object localObject1 = amwn.a();
    MqqHandler localMqqHandler;
    Message localMessage;
    if (localObject1 != null)
    {
      localMqqHandler = ((AppInterface)localObject1).getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        localMessage = localMqqHandler.obtainMessage(1134051);
        localMessage.obj = this.jdField_a_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
            break label118;
          }
        }
      }
    }
    label118:
    for (localObject1 = null;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = anvx.a(2131701636);
      }
      localMessage.obj = (anvx.a(2131701632) + (String)localObject2);
      localMqqHandler.sendMessage(localMessage);
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
    if (this.jdField_a_of_type_Anae != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label251;
      }
      this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Anae.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Anae.c.setVisibility(8);
    }
    label251:
    while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)
    {
      localObject1 = a();
      if ((localObject1 == null) || ((((BaseChatPie)localObject1).sessionInfo != null) && (((BaseChatPie)localObject1).sessionInfo.curType == 1036))) {
        break;
      }
      localObject1 = ((BaseChatPie)localObject1).getTipManager();
      if (localObject1 == null) {
        break;
      }
      if (this.jdField_a_of_type_Anae != null)
      {
        if ((this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        ((ailr)localObject1).a(this.jdField_a_of_type_Anae, new Object[0]);
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
        localObject2 = anvx.a(2131701635);
      }
      localObject1 = anvx.a(2131701637) + (String)localObject2;
      this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_Anae.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      break;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Bkys.removeMessages(25);
    QLog.d("cmgame_process.CmGameUIManager", 2, "onActivityResume mGameId:" + this.jdField_b_of_type_Int);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Bkys.removeMessages(25);
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(25, jdField_a_of_type_Int);
    QLog.d("cmgame_process.CmGameUIManager", 2, "onActivityStop mGameId:" + this.jdField_b_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    switch (paramMessage.what)
    {
    }
    label593:
    label607:
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
                      do
                      {
                        return false;
                        paramMessage = a();
                      } while (paramMessage == null);
                      paramMessage.hidePanel();
                      return false;
                      if ((this.jdField_a_of_type_Anae != null) && ((paramMessage.obj instanceof String)))
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
                      localObject3 = paramMessage.getTipManager();
                      if ((localObject3 != null) && (this.jdField_a_of_type_Anae != null))
                      {
                        if ((this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof ViewGroup)) {
                          ((ViewGroup)this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout);
                        }
                        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
                        {
                          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                            break label593;
                          }
                          paramMessage = null;
                          localObject1 = paramMessage;
                          if (TextUtils.isEmpty(paramMessage)) {
                            localObject1 = anvx.a(2131701638);
                          }
                          paramMessage = anvx.a(2131701633) + (String)localObject1;
                          this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
                          this.jdField_a_of_type_Anae.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
                        }
                        this.jdField_a_of_type_Anae.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                        this.jdField_a_of_type_Anae.c.setVisibility(8);
                        ((ailr)localObject3).a(this.jdField_a_of_type_Anae, new Object[0]);
                        if (QLog.isColorLevel()) {
                          QLog.d("cmgame_process.CmGameUIManager", 2, "showGameTips");
                        }
                      }
                    }
                    Object localObject3 = amwn.a();
                    MqqHandler localMqqHandler;
                    Message localMessage;
                    if (localObject3 != null)
                    {
                      localMqqHandler = ((AppInterface)localObject3).getHandler(Conversation.class);
                      if (localMqqHandler != null)
                      {
                        localMessage = localMqqHandler.obtainMessage(1134051);
                        localMessage.obj = this.jdField_a_of_type_JavaLangString;
                        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
                          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                            break label607;
                          }
                        }
                      }
                    }
                    for (paramMessage = (Message)localObject2;; paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
                    {
                      localObject1 = paramMessage;
                      if (TextUtils.isEmpty(paramMessage)) {
                        localObject1 = anvx.a(2131701629);
                      }
                      localMessage.obj = (anvx.a(2131701631) + (String)localObject1);
                      localMqqHandler.sendMessage(localMessage);
                      if (this.jdField_b_of_type_Int > 0) {
                        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "miniature_game", a(), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int) });
                      }
                      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
                      {
                        paramMessage = (amzu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                        if (paramMessage != null) {
                          paramMessage.a();
                        }
                      }
                      ApolloGameStateMachine.a().a(4, "message game min");
                      this.jdField_a_of_type_Bkys.removeMessages(25);
                      this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(25, jdField_a_of_type_Int);
                      return false;
                      paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
                      break;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                        break label734;
                      }
                    }
                    for (paramMessage = "";; paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
                    {
                      VipUtils.a(null, "cmshow", "Apollo", "game_shutdown", 0, 0, new String[] { paramMessage });
                      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
                      {
                        paramMessage = (amzu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                        if (paramMessage != null) {
                          paramMessage.d("");
                        }
                      }
                      amwd.a(this.jdField_b_of_type_Int);
                      QLog.i("cmgame_process.CmGameUIManager", 1, "MSG_CODE_CLOSE_GAME_TIMEOUT timeout colsegame mGameParams:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                      return false;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_CLOSE_ROOM");
                    }
                    localObject2 = a();
                    if (localObject2 != null)
                    {
                      localObject2 = ((BaseChatPie)localObject2).getTipManager();
                      if (localObject2 != null)
                      {
                        if ((this.jdField_a_of_type_Anae == null) || (this.jdField_a_of_type_Anae != ((ailr)localObject2).a())) {
                          break label965;
                        }
                        ((ailr)localObject2).a();
                        if (QLog.isColorLevel()) {
                          QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage currentTipsTask dismissTipsBar()");
                        }
                      }
                    }
                    for (;;)
                    {
                      if (((this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (!(this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity))) || (this.jdField_a_of_type_JavaLangRefWeakReference != null))
                      {
                        localObject2 = (amzu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                        if ((paramMessage.obj instanceof String)) {
                          localObject1 = (String)paramMessage.obj;
                        }
                        if (localObject2 != null) {
                          ((amzu)localObject2).d((String)localObject1);
                        }
                      }
                      paramMessage = amwn.a();
                      if ((paramMessage == null) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
                        break;
                      }
                      VipUtils.a(paramMessage, "cmshow", "Apollo", "shutdown_game", 0, 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), Integer.toString(amwn.b()), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag & 0x1) });
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
                      if (this.jdField_a_of_type_Anae != null)
                      {
                        this.jdField_a_of_type_Anae.c.setVisibility(8);
                        this.jdField_a_of_type_Anae.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                        this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetTextView.setText((String)paramMessage.obj);
                      }
                    }
                    paramMessage = amwn.a();
                  } while (!(paramMessage instanceof QQAppInterface));
                  paramMessage = paramMessage.getHandler(Conversation.class);
                } while (paramMessage == null);
                localObject1 = paramMessage.obtainMessage(1134051);
                ((Message)localObject1).arg1 = 1;
                ((Message)localObject1).obj = this.jdField_a_of_type_JavaLangString;
                paramMessage.sendMessage((Message)localObject1);
                return false;
                this.jdField_a_of_type_Bkys.removeMessages(25);
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
                paramMessage.hidePanel();
                if (QLog.isColorLevel()) {
                  QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_SHOW_GAME hidePanel");
                }
              }
              this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(24, 500L);
              return false;
              paramMessage = a();
            } while (paramMessage == null);
            paramMessage.hidePanel();
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_CHECK_HIDE_PANEL hidePanel");
          return false;
        } while (!(paramMessage.obj instanceof String));
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Anae != null))
        {
          localObject1 = (String)paramMessage.obj;
          localObject2 = new SpannableString((String)localObject1 + anvx.a(2131701634));
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(-16776961), 0, ((String)localObject1).length(), 17);
          this.jdField_a_of_type_Anae.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          g();
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_SHOW_JOIN_TIP, msg.obj is " + paramMessage.obj + ",mGameStarted:" + this.jdField_a_of_type_Boolean);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_RESET_JION_ROOM");
      }
      paramMessage = a();
    } while ((paramMessage == null) || (this.jdField_a_of_type_Anae == null) || (paramMessage.getTipManager().a() != this.jdField_a_of_type_Anae) || (!this.jdField_a_of_type_Anae.jdField_a_of_type_AndroidWidgetRelativeLayout.isShown()));
    label734:
    this.jdField_a_of_type_Anae.b();
    label965:
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
    {
      localObject = a();
      if (localObject == null) {
        break label106;
      }
      AppInterface localAppInterface = amwn.a();
      i = ApolloUtil.a(((BaseChatPie)localObject).getSessionInfo(), localAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
        break label120;
      }
    }
    label106:
    label120:
    for (Object localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", i, 0, new String[] { localObject });
      localObject = a();
      if (localObject != null) {
        ((BaseChatPie)localObject).hidePanel();
      }
      this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(18, 300L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anaf
 * JD-Core Version:    0.7.0.1
 */