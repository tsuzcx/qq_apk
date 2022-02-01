package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Observable;
import org.jetbrains.annotations.NotNull;

public class UnreadBackBottomHelper
  extends Observable
  implements View.OnClickListener, ILifeCycleHelper
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  public UnreadBackBottomHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    if (paramSessionInfo != null)
    {
      int i = paramSessionInfo.jdField_a_of_type_Int;
      if ((i != 0) && (i != 1000) && (i != 1003) && (i != 1006) && (i != 1022) && (i != 1023) && (i != 10008) && (i != 10009)) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    boolean bool1 = false;
    if (paramBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "chatPie is null");
      }
      return false;
    }
    SessionInfo localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "sessionInfo is null");
      }
      return false;
    }
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if ((paramBaseChatPie instanceof FriendChatPie))
    {
      boolean bool3 = Utils.b(localSessionInfo.jdField_a_of_type_JavaLangString);
      boolean bool4 = RobotUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString);
      bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!bool4) {
          bool2 = true;
        }
      }
    }
    if ((paramBaseChatPie instanceof StrangerChatPie)) {
      bool1 = a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    } else {
      bool1 = bool2;
    }
    if ((paramBaseChatPie instanceof NearbyChatPie)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      localBaseChatPie.H();
    }
    this.jdField_c_of_type_Boolean = false;
    notifyObservers();
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "onScrollOutScreen");
    }
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 3;
      }
      i = 2;
    }
    return i;
  }
  
  public void a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setBackgroundResource(2130838330);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "resume button to unread mode");
      }
      if (AppSetting.d)
      {
        localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131689957));
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(HardCodeUtil.a(2131689958));
        localTextView.setContentDescription(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      this.jdField_b_of_type_Int = ((View)localObject).getTop();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("firstView != null. top: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        QLog.d("UnreadBackBottomHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (this.jdField_a_of_type_Int == 0))
    {
      ((TextView)localObject).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "unread count is 0, core button gone");
      }
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        return;
      }
      paramInt4 = 0;
      boolean bool;
      if (paramInt1 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_b_of_type_Boolean = bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (paramInt7 <= 0)
      {
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Int == 0))
        {
          localView = this.jdField_a_of_type_AndroidViewView;
          if ((localView != null) && (this.jdField_b_of_type_Int - localView.getTop() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            if (QLog.isColorLevel()) {
              QLog.d("UnreadBackBottomHelper", 2, "scroll to bottom, button gone");
            }
          }
        }
        this.jdField_c_of_type_Int = paramInt1;
        this.d = (paramInt3 - paramInt5 - paramInt1);
        localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
        if (localView != null) {
          this.jdField_a_of_type_AndroidViewView = localView;
        }
      }
      if (paramInt1 + paramInt2 < paramInt3 - paramInt5 - this.d) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      View localView = this.jdField_a_of_type_AndroidViewView;
      paramInt2 = paramInt4;
      if (localView != null)
      {
        paramInt2 = paramInt4;
        if (localView.getTop() > this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight()) {
          paramInt2 = 1;
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      c();
    }
  }
  
  public void a(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (paramView != null)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (paramView != null)
      {
        int i = a(paramView.jdField_a_of_type_Int);
        if (i != -1) {
          a("0X800AC89", i);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "core button on click");
    }
  }
  
  public void a(TextView paramTextView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramTextView == null) && (QLog.isColorLevel())) {
      QLog.e("UnreadBackBottomHelper", 1, "button is null");
    }
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "attachButton success");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switch is off. reportType: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", aioType: ");
        localStringBuilder.append(paramInt);
        QLog.d("UnreadBackBottomHelper", 2, localStringBuilder.toString());
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state changed from: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" to: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("UnreadBackBottomHelper", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    boolean bool = false;
    if (localTextView == null) {
      return false;
    }
    if (localTextView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update unread count: ");
      localStringBuilder.append(paramInt);
      QLog.d("UnreadBackBottomHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void c(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("delta: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("UnreadBackBottomHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if (Math.abs(paramInt) < 20) {
      return;
    }
    if (paramInt > 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((localObject1 != null) && (this.jdField_a_of_type_Int == 0)) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    else if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Int == 0) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      Object localObject2;
      if (localObject1 != null)
      {
        AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)((BaseChatPie)localObject1).a(15);
        localObject2 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
        localObject1 = localObject2;
        if (localAIOLongShotHelper != null)
        {
          localObject1 = localObject2;
          if (localAIOLongShotHelper.a())
          {
            paramInt = 1;
            localObject1 = localObject2;
            break label171;
          }
        }
      }
      else
      {
        localObject1 = null;
      }
      paramInt = 0;
      label171:
      if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8) && (paramInt == 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837927);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.d) {
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131689957));
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (localObject2 != null)
        {
          localObject2 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          if (localObject2 != null)
          {
            paramInt = a(((SessionInfo)localObject2).jdField_a_of_type_Int);
            if (paramInt != -1) {
              a("0X800AC88", paramInt);
            }
          }
        }
        if (localObject1 != null) {
          ((AIOShortcutBarHelper)localObject1).c(9);
        }
      }
    }
  }
  
  @NotNull
  public String getTag()
  {
    return "UnreadBackBottomHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 3 };
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131371572)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      ((IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all")).setActionPlayList(null);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
      ((MsgList)localObject1).a().a(((ChatAdapter1)localObject2).getCount(), ((MsgList)localObject1).a().a(((ChatAdapter1)localObject2).getCount()));
      if (((MsgList)localObject1).a().a() > 0)
      {
        ((MsgList)localObject1).a().e();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        ((ChatXListView)localObject1).setSelectionFromBottom(((ChatXListView)localObject1).getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if ((paramInt == 3) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie))) {
      a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper
 * JD-Core Version:    0.7.0.1
 */