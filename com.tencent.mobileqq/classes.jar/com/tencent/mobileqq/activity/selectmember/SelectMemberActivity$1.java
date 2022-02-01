package com.tencent.mobileqq.activity.selectmember;

import aoep;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SelectMemberActivity$1
  implements Runnable
{
  SelectMemberActivity$1(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    aoep localaoep = (aoep)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localaoep != null) {}
    try
    {
      localaoep.b(Long.valueOf(this.this$0.mGroupCode));
      localaoep.a(Long.valueOf(this.this$0.mGroupCode));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SelectMemberActivity", 2, "NumberFormatException : mGroupCode = " + this.this$0.mGroupCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */