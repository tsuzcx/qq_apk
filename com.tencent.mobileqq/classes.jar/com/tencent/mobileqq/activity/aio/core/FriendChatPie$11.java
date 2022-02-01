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
    if (this.a.bm != null)
    {
      Animation localAnimation = this.a.bm.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      this.a.o.removeView(this.a.bm);
      this.a.bm = null;
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
            i = FriendChatPie.a(this.a, AIOPanelUtiles.w);
          }
        }
        else if (!((AudioPanelProvider)this.a.ae.f(2)).f()) {
          i = FriendChatPie.a(this.a, AIOPanelUtiles.b);
        }
      }
      else
      {
        localObject = (PhotoListPanel)this.a.ae.d(4);
        if ((localObject == null) || (((PhotoListPanel)localObject).getVisibility() != 0)) {
          i = FriendChatPie.a(this.a, AIOPanelUtiles.m);
        }
      }
    }
    else if (ShortVideoUtils.needTwoEntrance()) {
      i = FriendChatPie.a(this.a, AIOPanelUtiles.t);
    } else {
      i = FriendChatPie.a(this.a, AIOPanelUtiles.w);
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
      ((BabyQHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
      return;
    }
    if (this.a.bm == null)
    {
      localObject = this.a;
      ((FriendChatPie)localObject).bm = new View(((FriendChatPie)localObject).e);
      this.a.bm.setBackgroundResource(2130846357);
      localObject = this.a.W.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.W.getHeight() - ((View)localObject).getHeight()) / 2);
      this.a.o.addView(this.a.bm, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.e, 2130772359);
      ((Animation)localObject).setAnimationListener(new FriendChatPie.11.1(this));
      this.a.bm.startAnimation((Animation)localObject);
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
    if ((paramBoolean) && (this.a.bj != null)) {
      this.a.bj.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.11
 * JD-Core Version:    0.7.0.1
 */