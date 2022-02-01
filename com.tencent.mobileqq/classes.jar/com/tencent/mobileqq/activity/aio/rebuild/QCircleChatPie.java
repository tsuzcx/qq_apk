package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.QCircleMsgLoader;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.requests.QCircleChatGetPMBeginShowMsgRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import mqq.os.MqqHandler;

public class QCircleChatPie
  extends BaseChatPie
  implements Handler.Callback
{
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QCircleChatPie.2(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new QCircleChatPie.1(this);
  private MessageForQCircleIceBreak jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleIceBreak;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MessageForUniteGrayTip jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private MessageRecord b;
  private String f = null;
  private volatile int k;
  
  public QCircleChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean E()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "gotoFriendAio : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void bi()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleChatPie.3(this));
  }
  
  private void bj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
  }
  
  private void bk()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void i(String paramString)
  {
    paramString = new QCircleChatGetPMBeginShowMsgRequest(paramString);
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_AndroidContentContext, paramString, new QCircleChatPie.4(this));
  }
  
  public void J()
  {
    super.J();
  }
  
  public void R()
  {
    super.R();
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      a();
    }
  }
  
  public void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPreThemeChanged" + this.D);
    }
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPostThemeChanged" + this.D);
    }
    aP();
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new QCircleMsgLoader()).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
    if (paramInt2 == 1)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 45, 5, 2);
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "report input click");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((paramIntent.getBooleanExtra("qcircle_chat_hide_menu_key", false)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRightRootVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.D) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bj();
    bi();
    return paramBoolean;
  }
  
  public void al()
  {
    super.al();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "QCircleChatPie";
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.f = paramIntent.getStringExtra("qcircle_chat_show_fuel_tips_key");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("qcirlce_chat_gift_info_bytes_key");
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 45, 1, 1);
  }
  
  public boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (E()) {
      return true;
    }
    return super.g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
  }
  
  public void k(boolean paramBoolean) {}
  
  public void m(int paramInt)
  {
    super.m(paramInt);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131367663) {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 45, 6, 3);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2131374345) {}
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (InputStatusHelper)a(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label44;
        }
        paramObject.d();
      }
    }
    label44:
    while (paramObservable.time <= paramObject.b) {
      return;
    }
    bk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie
 * JD-Core Version:    0.7.0.1
 */