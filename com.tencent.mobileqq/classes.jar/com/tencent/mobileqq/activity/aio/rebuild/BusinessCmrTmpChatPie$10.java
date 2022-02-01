package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.view.View;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.statistics.ReportController;

class BusinessCmrTmpChatPie$10
  implements CustomMenuBar.OnMenuItemClickListener
{
  BusinessCmrTmpChatPie$10(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    this.a.i.setVisibility(0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
    Object localObject = this.a.a(paramInt1);
    EnterpriseQQManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString, this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.b(), (StructMsg.ButtonInfo)localObject);
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = this.a.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    ReportController.b(paramString, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.10
 * JD-Core Version:    0.7.0.1
 */