package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class BaseTroopListUI
  extends ListUI
{
  protected boolean a = false;
  
  public BaseTroopListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  private BaseMessageManagerForTroopAndDisc a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return (BaseMessageManagerForTroopAndDisc)paramQQAppInterface.getMessageFacade().a(paramInt);
  }
  
  public void a()
  {
    BaseSessionInfo localBaseSessionInfo = this.b.O();
    if (this.b.a().getTroopMask(localBaseSessionInfo.b) == 2)
    {
      this.a = this.b.a().getMessageFacade().p(localBaseSessionInfo.b, localBaseSessionInfo.a);
      if (this.a) {
        bJ_();
      }
    }
  }
  
  protected void bJ_()
  {
    b(true);
    BaseTroopListUI.1 local1 = new BaseTroopListUI.1(this);
    this.b.e().d().a(0, -1, local1, 9);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopListUI", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (paramInt == 1) {
      return true;
    }
    if (this.f.getCount() > 0)
    {
      paramView = this.b.O();
      paramListView = this.b.a();
      this.i = SystemClock.uptimeMillis();
      ((ChatContext)this.h.a).a(this.i);
      TroopAioTips localTroopAioTips = (TroopAioTips)this.b.e().d().f();
      if (localTroopAioTips != null)
      {
        if (localTroopAioTips.g)
        {
          this.h.g = true;
          a(paramListView, paramView.a).a(paramView.b, paramView.a, localTroopAioTips.h, localTroopAioTips.i, localTroopAioTips.j, this.h);
          localTroopAioTips.x();
        }
        else
        {
          this.h.g = false;
          this.h.h = true;
          if (!this.a)
          {
            paramListView.getMessageFacade().a(paramView.b, paramView.a, 20, this.h);
          }
          else
          {
            paramListView.getMessageFacade().a(paramView.b, paramView.a, this.h);
            this.a = false;
          }
        }
      }
      else
      {
        this.h.g = false;
        this.h.h = true;
        if (!this.a)
        {
          paramListView.getMessageFacade().a(paramView.b, paramView.a, 20, this.h);
        }
        else
        {
          paramListView.getMessageFacade().a(paramView.b, paramView.a, this.h);
          this.a = false;
        }
      }
      if ((paramView.a == 1) && (paramListView.getTroopMask(paramView.b) == 3))
      {
        ReportController.b(paramListView, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, paramView.b, "", "", "");
        return true;
      }
    }
    else
    {
      b(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopListUI
 * JD-Core Version:    0.7.0.1
 */