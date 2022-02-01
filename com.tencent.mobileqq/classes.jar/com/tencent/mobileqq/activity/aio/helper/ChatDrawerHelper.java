package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendAIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;

public class ChatDrawerHelper
  implements OnFinishListener, ILifeCycleHelper, OnActivityResultCallback, PanelListener
{
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  public BaseChatDrawer a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public DrawerFrame a;
  
  public ChatDrawerHelper(AIOContext paramAIOContext)
  {
    CoreHelperProvider localCoreHelperProvider = paramAIOContext.a();
    localCoreHelperProvider.a(this);
    localCoreHelperProvider.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramAIOContext.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public int a()
  {
    return 0;
  }
  
  public BaseChatDrawer a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if ((!(localObject instanceof FriendAIOContext)) && (!(localObject instanceof RobotContext))) {
      return null;
    }
    if (!AIODrawerDpc.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).a)))
    {
      if ((((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equalsIgnoreCase(String.valueOf(66600000L))))
      {
        if (!FriendIntimateRelationshipHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "aio intimate is close");
          }
          return null;
        }
        return new IntimateInfoChatDrawer(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      }
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }));
      return null;
    }
    QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
    return null;
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(paramTouchEventConsumer);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    BaseChatDrawer localBaseChatDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
    if (localBaseChatDrawer != null) {
      localBaseChatDrawer.c(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a();
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0)
    {
      BaseChatDrawer localBaseChatDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
      if ((localBaseChatDrawer != null) && (localBaseChatDrawer.a()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.b()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a(true);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(paramTouchEventConsumer);
    }
  }
  
  public void d(int paramInt) {}
  
  @NonNull
  public String getTag()
  {
    return "ChatDrawerHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 3, 7, 11, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BaseChatDrawer localBaseChatDrawer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
    if ((localBaseChatDrawer != null) && (localBaseChatDrawer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 3)
      {
        if (paramInt != 7)
        {
          if (paramInt != 11)
          {
            if (paramInt != 15) {
              return;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
            if (localObject != null)
            {
              ((BaseChatDrawer)localObject).e();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer = null;
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
            if (localObject != null) {
              ((BaseChatDrawer)localObject).d();
            }
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
          if (localObject != null) {
            ((BaseChatDrawer)localObject).c();
          }
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer = a();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b();
      if ((((ViewGroup)localObject).getParent() instanceof DrawerFrame))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = ((DrawerFrame)((ViewGroup)localObject).getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = new DrawerFrame(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (ViewGroup)localObject);
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer;
      if (localObject != null) {
        ((BaseChatDrawer)localObject).c(false);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      if ((((PanelManager)localObject).a() == null) || (!(((PanelManager)localObject).a() instanceof BaseVoicetoTextView))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.c(true);
      }
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper
 * JD-Core Version:    0.7.0.1
 */