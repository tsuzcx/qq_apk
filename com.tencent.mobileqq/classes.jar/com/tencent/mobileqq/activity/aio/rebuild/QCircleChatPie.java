package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.QCircleMsgLoader;
import com.tencent.mobileqq.activity.aio.rebuild.tips.QCircleTipsController;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  private String d = null;
  private volatile int g;
  
  public QCircleChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoFriendAio : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ((Intent)localObject).putExtra("uintype", 0);
    a().startActivity((Intent)localObject);
  }
  
  private void ao()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleChatPie.3(this));
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
  }
  
  private void aq()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void d(String paramString)
  {
    paramString = new QCircleChatGetPMBeginShowMsgRequest(paramString);
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_AndroidContentContext, paramString, new QCircleChatPie.4(this));
  }
  
  private boolean t()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (!((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).d())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConsumeBackEvent, comsumed:");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void E()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreThemeChanged");
      localStringBuilder.append(this.x);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged");
      localStringBuilder.append(this.x);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    aj();
  }
  
  protected void O()
  {
    super.O();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new QCircleMsgLoader()).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected TipsController a()
  {
    return new QCircleTipsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPanelChanged, old:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" new:");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
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
  
  protected void a(Intent paramIntent)
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
  
  protected boolean a()
  {
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((bool2) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    ap();
    ao();
    return paramBoolean;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "QCircleChatPie";
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.d = paramIntent.getStringExtra("qcircle_chat_show_fuel_tips_key");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("qcirlce_chat_gift_info_bytes_key");
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (t()) {
      return true;
    }
    return super.d();
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 45, 1, 1);
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
  }
  
  public void h(boolean paramBoolean) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131367417) {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 45, 6, 3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    super.p();
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
        if (paramObservable.isSend())
        {
          paramObject.d();
          return;
        }
        if (paramObservable.time > paramObject.b) {
          aq();
        }
      }
    }
  }
  
  public void y()
  {
    super.y();
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie
 * JD-Core Version:    0.7.0.1
 */