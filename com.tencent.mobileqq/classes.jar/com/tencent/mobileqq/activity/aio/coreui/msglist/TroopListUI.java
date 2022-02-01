package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopListUI
  extends BaseTroopListUI
{
  private JumpStateMachineController k;
  
  public TroopListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  private boolean A()
  {
    if (this.f.getCount() > 0)
    {
      AioTips localAioTips = this.b.e().d().f();
      if ((localAioTips != null) && (localAioTips.g) && (this.k.a() == JumpState.INACTIVATED))
      {
        this.i = SystemClock.uptimeMillis();
        ((ChatContext)this.h.a).a(this.i);
        this.h.g = true;
        BaseSessionInfo localBaseSessionInfo = this.b.O();
        this.b.a().getMessageFacade().p().a(localBaseSessionInfo.b, localBaseSessionInfo.a, localAioTips.i, localAioTips.i, localAioTips.j, this.h, 20, localAioTips.h, true);
        localAioTips.x();
        return true;
      }
    }
    return false;
  }
  
  private void a(RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramRefreshMessageContext.g)
    {
      if (paramRefreshMessageContext.i)
      {
        this.b.c(131080);
        return;
      }
      this.b.c(131079);
      return;
    }
    if (paramRefreshMessageContext.k)
    {
      this.b.c(131077);
      paramRefreshMessageContext.k = false;
      return;
    }
    this.b.c(131076);
  }
  
  private void b(RefreshMessageContext paramRefreshMessageContext)
  {
    if ((this.k.a() == JumpState.JUMP_SUCCESS) && (!paramRefreshMessageContext.g) && (paramRefreshMessageContext.k))
    {
      if (((paramRefreshMessageContext.b == null) || (paramRefreshMessageContext.b.size() == 0)) && (!paramRefreshMessageContext.i))
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actAIOPullUpResult", false, 0L, 0L, null, "");
        this.k.a(JumpState.PULL_UP_FAILURE);
        return;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actAIOPullUpResult", true, 0L, 0L, null, "");
      this.k.a(JumpState.PULL_UP_SUCCESS);
    }
  }
  
  private void c(RefreshMessageContext paramRefreshMessageContext)
  {
    if ((this.k.a() == JumpState.INACTIVATED) && (paramRefreshMessageContext.g) && (paramRefreshMessageContext.i))
    {
      com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil.c = paramRefreshMessageContext.t;
      this.k.a(JumpState.JUMP_SUCCESS);
    }
  }
  
  public void a(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    super.a(paramChatXListView, paramChatAdapter1);
    this.k = new JumpStateMachineController(this.b);
    this.k.c();
  }
  
  public void a(Object paramObject)
  {
    Object localObject = this.b.O();
    paramObject = (RefreshMessageContext)paramObject;
    ChatContext localChatContext = (ChatContext)paramObject.a;
    if (!TextUtils.equals(((BaseSessionInfo)localObject).b, localChatContext.a())) {
      return;
    }
    if ((((BaseSessionInfo)localObject).a == paramObject.q) && (this.i != localChatContext.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopListUI", 2, "refreshMessageContext sync other MiniAIO");
      }
      this.b.c(131073);
      return;
    }
    if ((this.i == localChatContext.b()) && (paramObject.f) && (ConfessMsgUtil.a(paramObject.q, paramObject.w, ((BaseSessionInfo)localObject).a, ((BaseSessionInfo)localObject).v)))
    {
      localObject = paramObject.b;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.j += 1;
      }
      long l = this.i + 300L - SystemClock.uptimeMillis();
      if (l <= 0L) {
        l = 0L;
      }
      this.b.g().postDelayed(new TroopListUI.1(this, paramObject), l);
    }
  }
  
  public void b()
  {
    super.b();
    this.k = null;
  }
  
  public void c()
  {
    super.c();
    this.k.a(this.h);
  }
  
  public void d(boolean paramBoolean)
  {
    BaseSessionInfo localBaseSessionInfo = this.b.O();
    QQAppInterface localQQAppInterface = this.b.a();
    this.h.g = false;
    this.i = SystemClock.uptimeMillis();
    ((ChatContext)this.h.a).a(this.i);
    AioTips localAioTips = this.b.e().d().f();
    if (localAioTips != null)
    {
      long l = this.b.e().d().o();
      localQQAppInterface.getMessageFacade().p().a(localBaseSessionInfo.b, localBaseSessionInfo.a, l + 1L, localAioTips.i, false, this.h, 50, localAioTips.h, paramBoolean);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 1)
    {
      if ((this.f.getCount() > 0) && (this.k.a() == JumpState.JUMP_SUCCESS))
      {
        this.h.k = true;
        d(true);
        return true;
      }
      this.h.g = false;
      return true;
    }
    ((TroopManager)this.b.a().getManager(QQManagerFactory.TROOP_MANAGER)).z(this.b.O().b);
    if (A()) {
      return true;
    }
    return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
  }
  
  public JumpStateMachineController y()
  {
    return this.k;
  }
  
  public void z()
  {
    ThreadManager.post(new TroopListUI.2(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI
 * JD-Core Version:    0.7.0.1
 */