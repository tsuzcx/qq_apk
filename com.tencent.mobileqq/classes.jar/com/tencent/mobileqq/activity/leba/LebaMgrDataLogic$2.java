package com.tencent.mobileqq.activity.leba;

import ajzx;
import anxo;
import awcz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class LebaMgrDataLogic$2
  implements Runnable
{
  public LebaMgrDataLogic$2(ajzx paramajzx, List paramList) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "handleData AppRuntime error ");
      return;
    }
    localObject = (QQAppInterface)localObject;
    long l = NetConnInfoCenter.getServerTime();
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "saveUserSortInfo " + this.a + ", time" + l + ", type" + this.this$0.a);
    anxo.a(((QQAppInterface)localObject).getPreferences(), this.a, Long.valueOf(l), this.this$0.a);
    ((awcz)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.COMMPLGUGIN_HANDLER)).a(this.a, l, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.2
 * JD-Core Version:    0.7.0.1
 */