package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.AIOConfigurationListener;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.helper.TopGestureTouchEventListener;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkHelper
  implements AIOConfigurationListener, OnFinishListener, TopGestureTouchEventListener, ILifeCycleHelper, PanelProvider<ArkAppRootLayout>, AbsListView.OnScrollListener
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArkTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar;
  private ArkRecommendController jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
  
  public ArkHelper(AIOContext paramAIOContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramAIOContext = paramAIOContext.a();
    paramAIOContext.a(this);
    paramAIOContext.a(this);
    paramAIOContext.a(this);
  }
  
  private void c()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localChatXListView != null)
    {
      if (localChatXListView.getAdapter() == null) {
        return;
      }
      int i = localChatXListView.getFirstVisiblePosition();
      int j = localChatXListView.getLastVisiblePosition();
      while ((i <= j) && (i < localChatXListView.getAdapter().getCount()))
      {
        Object localObject = localChatXListView.getAdapter().getItem(i);
        if ((localObject instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)localObject;
          if (((MessageForArkApp)localObject).arkContainer != null) {
            ((MessageForArkApp)localObject).arkContainer.d();
          }
        }
        i += 1;
      }
    }
  }
  
  private void d()
  {
    if (a()) {
      return;
    }
    ArkTipsManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
    a();
  }
  
  private void e()
  {
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
  }
  
  private void f()
  {
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
  }
  
  private void g() {}
  
  public int a()
  {
    return 0;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    int i = paramMotionEvent.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramMotionEvent.getChildAt(i);
      if ((localView != null) && ((AIOUtils.a(localView) instanceof ArkAppItemBubbleBuilder.Holder)))
      {
        localView = localView.findViewById(2131362947);
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        if (localRect.contains((int)f1, (int)f2)) {
          return 2;
        }
      }
      i -= 1;
    }
    return 0;
  }
  
  public ArkAppRootLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
  }
  
  public ArkAppRootLayout a(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
  }
  
  public ArkTipsBar a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar = new ArkTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showArkTips : hide? :");
      boolean bool;
      if (paramString == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(",mID=");
      localStringBuilder.append(paramLong);
      QLog.d("ArkHelper", 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar, new Object[] { paramString, Long.valueOf(paramLong) });
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar;
  }
  
  public ArkRecommendController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
  }
  
  public void a()
  {
    ArkRecommendController localArkRecommendController = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
    if (localArkRecommendController != null)
    {
      localArkRecommendController.b();
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = null;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    ArkAppCenterUtil.a(paramConfiguration);
  }
  
  public void a(MotionEvent paramMotionEvent) {}
  
  public boolean a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
      return ((IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all")).isFromAllMsgGameSinglePage(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    ArkRecommendController localArkRecommendController = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
    if (localArkRecommendController != null) {
      localArkRecommendController.c();
    }
  }
  
  public void d(int paramInt)
  {
    if (a()) {
      return;
    }
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
  }
  
  public int getPanelId()
  {
    return 22;
  }
  
  @NonNull
  public String getTag()
  {
    return "ArkHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 0, 7, 11, 15, 19, 22 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 22)) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 11)
          {
            if (paramInt != 15)
            {
              if (paramInt != 19)
              {
                if (paramInt != 22) {
                  return;
                }
                ArkAppCenterUtil.a();
                return;
              }
              g();
              return;
            }
            d();
            return;
          }
          f();
          return;
        }
        ArkTipsManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
        return;
      }
      e();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = new ArkRecommendController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext instanceof RobotContext))
    {
      ArkRecommendController localArkRecommendController = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
      if (localArkRecommendController != null)
      {
        localArkRecommendController.b();
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = null;
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    ArkRecommendController localArkRecommendController = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
    if (localArkRecommendController != null) {
      localArkRecommendController.a(paramInt1, paramInt2);
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(22);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      c();
    }
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ArkHelper
 * JD-Core Version:    0.7.0.1
 */