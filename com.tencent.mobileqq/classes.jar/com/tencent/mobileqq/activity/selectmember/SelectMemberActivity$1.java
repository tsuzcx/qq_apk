package com.tencent.mobileqq.activity.selectmember;

import alzf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SelectMemberActivity$1
  implements Runnable
{
  SelectMemberActivity$1(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    alzf localalzf = (alzf)this.this$0.app.a(20);
    if (localalzf != null) {}
    try
    {
      localalzf.b(Long.valueOf(this.this$0.c));
      localalzf.a(Long.valueOf(this.this$0.c));
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