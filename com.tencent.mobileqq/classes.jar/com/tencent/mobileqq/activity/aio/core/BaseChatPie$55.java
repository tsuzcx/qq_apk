package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class BaseChatPie$55
  extends ConfigObserver
{
  BaseChatPie$55(BaseChatPie paramBaseChatPie) {}
  
  public void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    if (this.a.y()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
        return;
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a(paramArrayList);
  }
  
  public void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.55
 * JD-Core Version:    0.7.0.1
 */