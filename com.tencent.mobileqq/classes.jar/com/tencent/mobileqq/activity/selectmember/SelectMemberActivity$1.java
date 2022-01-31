package com.tencent.mobileqq.activity.selectmember;

import amdu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SelectMemberActivity$1
  implements Runnable
{
  SelectMemberActivity$1(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    amdu localamdu = (amdu)this.this$0.app.a(20);
    if (localamdu != null) {}
    try
    {
      localamdu.b(Long.valueOf(this.this$0.c));
      localamdu.a(Long.valueOf(this.this$0.c));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SelectMemberActivity", 2, "NumberFormatException : mGroupCode = " + this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */