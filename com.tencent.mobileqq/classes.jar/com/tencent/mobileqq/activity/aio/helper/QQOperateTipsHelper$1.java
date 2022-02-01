package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQOperateTipsHelper$1
  extends ConfigObserver
{
  QQOperateTipsHelper$1(QQOperateTipsHelper paramQQOperateTipsHelper) {}
  
  protected void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    if (((FullScreenInputHelper)QQOperateTipsHelper.a(this.a).a(24)).c()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
    }
    if ((QQOperateTipsHelper.a(this.a).a().jdField_a_of_type_JavaLangString.equals(paramString)) && (QQOperateTipsHelper.a(this.a).a().jdField_a_of_type_Int == paramInt))
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        if (QQOperateTipsHelper.a(this.a) != null) {
          QQOperateTipsHelper.a(this.a).a(paramArrayList);
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQOperateTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */