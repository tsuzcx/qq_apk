package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mei;

public class GAudioMembersCtrlActivity$2$1
  implements Runnable
{
  public GAudioMembersCtrlActivity$2$1(mei parammei) {}
  
  public void run()
  {
    if ((GAudioMembersCtrlActivity.a(this.a.a) != null) && (GAudioMembersCtrlActivity.a(this.a.a).size() != 0))
    {
      this.a.a.c();
      return;
    }
    QLog.d("GAudioMembersCtrlActivity", 1, "mInviteMemberInfoChange null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.2.1
 * JD-Core Version:    0.7.0.1
 */