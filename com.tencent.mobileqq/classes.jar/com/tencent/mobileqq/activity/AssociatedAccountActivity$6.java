package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$6
  implements Runnable
{
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    Object localObject2 = new StringBuilder(HardCodeUtil.a(2131700863)).append(this.this$0.getString(2131719718));
    int i;
    Object localObject1;
    if (this.a != null)
    {
      i = this.a.b();
      localObject1 = this.this$0.app.getConversationFacade();
      if ((localObject1 == null) || (this.this$0.a == null)) {
        break label255;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.this$0.a);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        i -= ((ConversationFacade)localObject1).a(((SubAccountInfo)localIterator.next()).subuin, 7000);
      }
      localArrayList.clear();
    }
    label255:
    for (;;)
    {
      if (i > 0)
      {
        localObject1 = Integer.toString(i);
        if (i > 99) {
          localObject1 = "99+";
        }
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateUnreadNumOnTitleBar unreadText = " + (String)localObject1);
        }
        localObject1 = "" + (String)localObject1;
        ((StringBuilder)localObject2).append(i).append("条未读");
      }
      for (;;)
      {
        localObject2 = ((StringBuilder)localObject2).toString();
        this.this$0.runOnUiThread(new AssociatedAccountActivity.6.1(this, (String)localObject1, (String)localObject2));
        return;
        localObject1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.6
 * JD-Core Version:    0.7.0.1
 */