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
  public DrawerFrame a;
  public BaseChatDrawer b;
  private final SessionInfo c;
  private final AIOContext d;
  private final QQAppInterface e;
  
  public ChatDrawerHelper(AIOContext paramAIOContext)
  {
    CoreHelperProvider localCoreHelperProvider = paramAIOContext.d();
    localCoreHelperProvider.a(this);
    localCoreHelperProvider.a(this);
    this.e = paramAIOContext.a();
    this.c = ((SessionInfo)paramAIOContext.O());
    this.d = paramAIOContext;
  }
  
  public BaseChatDrawer a()
  {
    Object localObject = this.d;
    if ((!(localObject instanceof FriendAIOContext)) && (!(localObject instanceof RobotContext))) {
      return null;
    }
    if (!AIODrawerDpc.b())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    localObject = this.c;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).b)))
    {
      if ((((FriendsManager)this.e.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.c.b)) && (!this.c.b.equalsIgnoreCase(this.e.getCurrentAccountUin())) && (!this.c.b.equalsIgnoreCase(String.valueOf(66600000L))))
      {
        if (!FriendIntimateRelationshipHelper.a(this.e.getCurrentUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "aio intimate is close");
          }
          return null;
        }
        return new IntimateInfoChatDrawer(this.d.n());
      }
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.c.b }));
      return null;
    }
    QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
    return null;
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.a.a(paramTouchEventConsumer);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.a.b(paramTouchEventConsumer);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseChatDrawer localBaseChatDrawer = this.b;
    if (localBaseChatDrawer != null) {
      localBaseChatDrawer.c(paramBoolean);
    }
  }
  
  public boolean b()
  {
    if (this.a != null)
    {
      this.b.a();
      return true;
    }
    return false;
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public boolean d(int paramInt)
  {
    if (paramInt == 0)
    {
      BaseChatDrawer localBaseChatDrawer = this.b;
      if ((localBaseChatDrawer != null) && (localBaseChatDrawer.d()))
      {
        if (!this.b.h()) {
          this.b.a(true);
        }
        return true;
      }
    }
    return false;
  }
  
  public void e(int paramInt) {}
  
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
    BaseChatDrawer localBaseChatDrawer = this.b;
    if ((localBaseChatDrawer != null) && (localBaseChatDrawer.d())) {
      this.b.a(paramInt1, paramInt2, paramIntent);
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
            localObject = this.b;
            if (localObject != null)
            {
              ((BaseChatDrawer)localObject).g();
              this.b = null;
            }
          }
          else
          {
            localObject = this.b;
            if (localObject != null) {
              ((BaseChatDrawer)localObject).f();
            }
          }
        }
        else
        {
          localObject = this.b;
          if (localObject != null) {
            ((BaseChatDrawer)localObject).e();
          }
        }
      }
      else {
        this.b = a();
      }
    }
    else
    {
      localObject = this.d.s();
      if ((((ViewGroup)localObject).getParent() instanceof DrawerFrame))
      {
        this.a = ((DrawerFrame)((ViewGroup)localObject).getParent());
        this.a.a();
        return;
      }
      this.a = new DrawerFrame(this.d.b(), (ViewGroup)localObject);
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 1)
    {
      localObject = this.b;
      if (localObject != null) {
        ((BaseChatDrawer)localObject).c(false);
      }
    }
    else if (this.b != null)
    {
      localObject = this.d.q();
      if ((((PanelManager)localObject).c() == null) || (!(((PanelManager)localObject).c() instanceof BaseVoicetoTextView))) {
        this.b.c(true);
      }
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper
 * JD-Core Version:    0.7.0.1
 */