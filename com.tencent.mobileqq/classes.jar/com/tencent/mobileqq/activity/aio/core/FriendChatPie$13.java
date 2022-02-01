package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
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

class FriendChatPie$13
  extends BabyQObserver
{
  FriendChatPie$13(FriendChatPie paramFriendChatPie) {}
  
  public void a()
  {
    if (this.a.m != null)
    {
      Animation localAnimation = this.a.m.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.m);
      this.a.m = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onStopGuide");
      }
    }
  }
  
  public void a(Object paramObject)
  {
    paramObject = (Integer)paramObject;
    int i;
    switch (paramObject.intValue())
    {
    default: 
      i = -1;
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject + " but panel is opened");
        }
        ((BabyQHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
      }
      break;
    }
    do
    {
      do
      {
        return;
        localObject = (PhotoListPanel)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
        if ((localObject != null) && (((PhotoListPanel)localObject).getVisibility() == 0))
        {
          i = -1;
          break;
        }
        i = FriendChatPie.a(this.a, AIOPanelUtiles.l);
        break;
        i = FriendChatPie.a(this.a, AIOPanelUtiles.v);
        break;
        if (ShortVideoUtils.needTwoEntrance())
        {
          i = FriendChatPie.a(this.a, AIOPanelUtiles.s);
          break;
        }
        i = FriendChatPie.a(this.a, AIOPanelUtiles.v);
        break;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0))
        {
          i = -1;
          break;
        }
        i = FriendChatPie.a(this.a, AIOPanelUtiles.a);
        break;
      } while (this.a.m != null);
      this.a.m = new View(this.a.jdField_a_of_type_AndroidContentContext);
      this.a.m.setBackgroundResource(2130845047);
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() - ((View)localObject).getHeight()) / 2);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.m, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130772245);
      ((Animation)localObject).setAnimationListener(new FriendChatPie.13.1(this));
      this.a.m.startAnimation((Animation)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.13
 * JD-Core Version:    0.7.0.1
 */