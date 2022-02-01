package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class DiscussListUI
  extends ListUI
{
  public DiscussListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussListUI", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (paramInt == 1) {
      return true;
    }
    if (this.f.getCount() > 0)
    {
      paramView = this.b.O();
      this.i = SystemClock.uptimeMillis();
      ((ChatContext)this.h.a).a(this.i);
      paramListView = (TroopAioTips)this.b.e().d().f();
      if (paramListView != null)
      {
        if (paramListView.g)
        {
          this.h.g = true;
          this.b.a().getMessageFacade().q().a(paramView.b, paramView.a, paramListView.h, paramListView.i, paramListView.j, this.h);
          paramListView.x();
          return true;
        }
        this.h.g = false;
        this.h.h = true;
        this.b.a().getMessageFacade().a(paramView.b, paramView.a, 20, this.h);
        return true;
      }
      this.h.g = false;
      this.h.h = true;
      this.b.a().getMessageFacade().a(paramView.b, paramView.a, 20, this.h);
      return true;
    }
    b(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.DiscussListUI
 * JD-Core Version:    0.7.0.1
 */