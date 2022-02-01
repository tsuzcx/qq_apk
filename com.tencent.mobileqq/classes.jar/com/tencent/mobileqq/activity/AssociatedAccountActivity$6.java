package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$6
  implements Runnable
{
  AssociatedAccountActivity$6(AssociatedAccountActivity paramAssociatedAccountActivity, IMessageFacade paramIMessageFacade, IConversationFacade paramIConversationFacade) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    Object localObject2 = "";
    StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131901576));
    localStringBuilder.append(this.this$0.getString(2131917002));
    Object localObject3 = this.a;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      int i = ((IMessageFacade)localObject3).getUnreadMsgsNum();
      int j = i;
      if (this.b != null)
      {
        j = i;
        if (this.this$0.mSubAccountList != null)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.this$0.mSubAccountList);
          localObject3 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject3).next();
            i -= this.b.getUnreadCount(localSubAccountInfo.subuin, 7000);
          }
          ((ArrayList)localObject1).clear();
          j = i;
        }
      }
      localObject1 = localObject2;
      if (j > 0)
      {
        localObject1 = Integer.toString(j);
        if (j > 99) {
          localObject1 = "99+";
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateUnreadNumOnTitleBar unreadText = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        localStringBuilder.append(j);
        localStringBuilder.append("条未读");
      }
    }
    localObject2 = localStringBuilder.toString();
    this.this$0.runOnUiThread(new AssociatedAccountActivity.6.1(this, (String)localObject1, (String)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.6
 * JD-Core Version:    0.7.0.1
 */