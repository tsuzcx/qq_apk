package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$10
  implements Runnable
{
  AddContactsView$10(AddContactsView paramAddContactsView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = this.this$0.r.h();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fillSearchConditions | sexIndex = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject1).toString());
    }
    if ((i != 0) && (i < ConditionSearchManager.i.length))
    {
      localObject1 = this.a;
      ((StringBuilder)localObject1).append(ConditionSearchManager.i[i]);
      ((StringBuilder)localObject1).append("、");
    }
    Object localObject1 = this.this$0.r.i();
    localObject1 = this.this$0.r.b(localObject1[0], localObject1[1]);
    StringBuilder localStringBuilder;
    if (!ConditionSearchManager.j[0].equals(localObject1))
    {
      localStringBuilder = this.a;
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("、");
    }
    i = this.this$0.r.f();
    if ((i != 0) && (i != ConditionSearchManager.l.length - 1))
    {
      localObject1 = this.a;
      ((StringBuilder)localObject1).append(ConditionSearchManager.m[i]);
      ((StringBuilder)localObject1).append("、");
    }
    if (this.this$0.s)
    {
      if ((this.this$0.B != null) && (this.this$0.y))
      {
        if ("-1".equals(this.this$0.B[0]))
        {
          localObject1 = ((FriendsManager)this.this$0.G.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.this$0.G.getCurrentAccountUin());
          if (localObject1 != null) {
            try
            {
              this.this$0.B = ((Card)localObject1).strLocationCodes.split("-");
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("card.strLocationCodes = ");
                localStringBuilder.append(((Card)localObject1).strLocationCodes);
                QLog.d("AddContactsView", 2, localStringBuilder.toString());
              }
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddContactsView", 2, "spliteLocationString | exception: ", localException1);
              }
            }
          }
        }
        try
        {
          this.this$0.B[3] = "0";
          String str = this.this$0.r.e(this.this$0.B);
          this.this$0.r.b(this.this$0.B);
          this.this$0.r.a(0, str);
          if ("0".equals(this.this$0.B[0])) {
            break label517;
          }
          localStringBuilder = this.a;
          localStringBuilder.append(this.this$0.r.c(str));
          localStringBuilder.append("、");
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label517;
          }
        }
        QLog.d("AddContactsView", 2, "parseLocationDesc", localException2);
      }
    }
    else
    {
      localObject2 = this.this$0.r.e(0);
      if (!((String)localObject2).startsWith("不限"))
      {
        localStringBuilder = this.a;
        localStringBuilder.append(this.this$0.r.c((String)localObject2));
        localStringBuilder.append("、");
      }
    }
    label517:
    Object localObject2 = this.this$0.r.e(1);
    if (!((String)localObject2).startsWith("不限"))
    {
      localStringBuilder = this.a;
      localStringBuilder.append(this.this$0.r.c((String)localObject2));
      localStringBuilder.append("、");
    }
    i = this.this$0.r.g();
    if (i != 0)
    {
      localObject2 = this.a;
      ((StringBuilder)localObject2).append(ConditionSearchManager.k[i]);
      ((StringBuilder)localObject2).append("、");
    }
    this.this$0.r.e();
    this.this$0.G.runOnUiThread(new AddContactsView.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.10
 * JD-Core Version:    0.7.0.1
 */