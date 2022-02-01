package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.List;

class BusinessCmrTmpChatPie$12
  extends EnterpriseQQObserver
{
  BusinessCmrTmpChatPie$12(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = this.a;
      paramObject.bQ = EnterpriseQQManager.a(paramObject.d).a(this.a.d, this.a.ae());
      paramObject = this.a;
      paramObject.b(paramObject.bQ);
      if ((this.a.bQ != null) && (!this.a.bQ.isEmpty())) {
        this.a.p(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.12
 * JD-Core Version:    0.7.0.1
 */