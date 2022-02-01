package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class FriendChatPie$11
  extends BabyQObserver
{
  FriendChatPie$11(FriendChatPie paramFriendChatPie) {}
  
  protected void a()
  {
    if (this.a.g != null)
    {
      Animation localAnimation = this.a.g.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.g);
      this.a.g = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onStopGuide");
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (Integer)paramObject;
    int j = paramObject.intValue();
    int i = -1;
    Object localObject;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            i = FriendChatPie.a(this.a, AIOPanelUtiles.v);
          }
        }
        else if (!((AudioPanelProvider)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).c()) {
          i = FriendChatPie.a(this.a, AIOPanelUtiles.a);
        }
      }
      else
      {
        localObject = (PhotoListPanel)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
        if ((localObject == null) || (((PhotoListPanel)localObject).getVisibility() != 0)) {
          i = FriendChatPie.a(this.a, AIOPanelUtiles.l);
        }
      }
    }
    else if (ShortVideoUtils.needTwoEntrance()) {
      i = FriendChatPie.a(this.a, AIOPanelUtiles.s);
    } else {
      i = FriendChatPie.a(this.a, AIOPanelUtiles.v);
    }
    if (i < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStartGuide ");
        ((StringBuilder)localObject).append(paramObject);
        ((StringBuilder)localObject).append(" but panel is opened");
        QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
      }
      ((BabyQHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
      return;
    }
    if (this.a.g == null)
    {
      localObject = this.a;
      ((FriendChatPie)localObject).g = new View(((FriendChatPie)localObject).jdField_a_of_type_AndroidContentContext);
      this.a.g.setBackgroundResource(2130844923);
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() - ((View)localObject).getHeight()) / 2);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.g, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130772273);
      ((Animation)localObject).setAnimationListener(new FriendChatPie.11.1(this));
      this.a.g.startAnimation((Animation)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStartGuide ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.11
 * JD-Core Version:    0.7.0.1
 */