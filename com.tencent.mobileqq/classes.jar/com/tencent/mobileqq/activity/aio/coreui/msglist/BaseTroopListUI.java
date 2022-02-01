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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class BaseTroopListUI
  extends ListUI
{
  protected boolean a;
  
  public BaseTroopListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void Z_()
  {
    a(true);
    BaseTroopListUI.1 local1 = new BaseTroopListUI.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(0, -1, local1, 9);
  }
  
  public void a()
  {
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getTroopMask(localBaseSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().f(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Boolean) {
        Z_();
      }
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopListUI", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      paramListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.a).a(this.jdField_a_of_type_Long);
      TroopAioTips localTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      if (localTroopAioTips != null)
      {
        if (localTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.e = true;
          paramListView.getMessageFacade().a().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, localTroopAioTips.jdField_a_of_type_Long, localTroopAioTips.jdField_b_of_type_Long, localTroopAioTips.c, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
          localTroopAioTips.j();
        }
        else
        {
          this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.e = false;
          this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.f = true;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramListView.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
          }
          else
          {
            paramListView.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.e = false;
        this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.f = true;
        if (!this.jdField_a_of_type_Boolean)
        {
          paramListView.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
        }
        else
        {
          paramListView.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if ((paramView.jdField_a_of_type_Int == 1) && (paramListView.getTroopMask(paramView.jdField_a_of_type_JavaLangString) == 3))
      {
        ReportController.b(paramListView, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, paramView.jdField_a_of_type_JavaLangString, "", "", "");
        return true;
      }
    }
    else
    {
      a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopListUI
 * JD-Core Version:    0.7.0.1
 */