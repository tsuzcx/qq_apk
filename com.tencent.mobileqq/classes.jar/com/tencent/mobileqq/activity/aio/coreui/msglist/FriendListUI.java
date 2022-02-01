package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.C2CMessageManager.C2CReplyContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class FriendListUI
  extends ListUI
{
  C2CMessageManager.C2CReplyContext a;
  
  public FriendListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a()
  {
    ThreadManager.post(new FriendListUI.1(this), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.a.a(paramLong1, paramLong2, paramBoolean);
  }
  
  public void a(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    super.a(paramChatXListView, paramChatAdapter1);
    this.a = new C2CMessageManager.C2CReplyContext();
  }
  
  public void b()
  {
    super.b();
    if ((this.h != null) && (this.h.x != null))
    {
      ((C2CRoamMsgFetcher)this.h.x).a();
      this.h.x = null;
    }
  }
  
  public void c()
  {
    super.c();
    if (!Utils.c(this.b.O().b)) {
      this.h.x = new C2CRoamMsgFetcher(this.b.a(), this.b.b(), this.b.O().b);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListUI", 2, "FriendChatPie onViewCompleteVisableAndReleased");
    }
    if (paramInt == 1) {
      return true;
    }
    BaseSessionInfo localBaseSessionInfo = this.b.O();
    if (((this.f != null) && (this.f.getCount() > 0)) || (!Utils.c(localBaseSessionInfo.b)))
    {
      if (this.a.b)
      {
        this.i = SystemClock.uptimeMillis();
        ((ChatContext)this.h.a).a(this.i);
        this.h.g = true;
        this.b.a().getMessageFacade().r().a(localBaseSessionInfo.b, localBaseSessionInfo.a, this.h, this.a, this.b.b());
        this.a.b = false;
        return true;
      }
      super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
      return true;
    }
    b(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI
 * JD-Core Version:    0.7.0.1
 */