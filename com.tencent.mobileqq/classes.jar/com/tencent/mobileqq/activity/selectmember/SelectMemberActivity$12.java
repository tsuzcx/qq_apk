package com.tencent.mobileqq.activity.selectmember;

import QQService.AddDiscussMemberInfo;
import android.text.TextUtils;
import antl;
import antp;
import anvk;
import bhdf;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SelectMemberActivity$12
  extends Thread
{
  SelectMemberActivity$12(SelectMemberActivity paramSelectMemberActivity, anvk paramanvk) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = ContactUtils.getAccountNickName(this.this$0.app, this.this$0.app.getCurrentAccountUin());
    int i = this.this$0.mResultList.size() - 1;
    ResultRecord localResultRecord;
    Object localObject2;
    String str;
    if (i >= 0)
    {
      localResultRecord = (ResultRecord)this.this$0.mResultList.get(i);
      localObject2 = new AddDiscussMemberInfo();
      if (localResultRecord.type == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.uin;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.type;
        localArrayList1.add(localObject2);
        localArrayList2.add(String.valueOf(((AddDiscussMemberInfo)localObject2).Uin));
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.type != 0) {
          break label330;
        }
        localObject2 = this.val$fm.e(localResultRecord.uin);
        if (localObject2 == null) {
          break label827;
        }
        localObject1 = ((Friends)localObject2).name;
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          break label320;
        }
        localObject2 = ((Friends)localObject2).name;
      }
    }
    for (;;)
    {
      label207:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.uin;
      }
      for (;;)
      {
        for (;;)
        {
          i -= 1;
          break;
          try
          {
            ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.uin).longValue();
            ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.groupUin).longValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SelectMemberActivity", 2, "NumberFormatException!!! uin=" + localResultRecord.uin);
            }
          }
        }
        continue;
        label320:
        localObject3 = localNumberFormatException.remark;
        break label207;
        label330:
        Object localObject5;
        if (localResultRecord.type == 1)
        {
          localObject5 = bhdf.a().a(this.this$0.app, localResultRecord.groupUin, localResultRecord.uin);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label207;
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).friendnick)) {
            break label207;
          }
          localObject1 = ((TroopMemberInfo)localObject5).friendnick;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).autoremark))
          {
            localObject3 = ((TroopMemberInfo)localObject5).friendnick;
            break label207;
          }
          localObject3 = ((TroopMemberInfo)localObject5).autoremark;
          break label207;
        }
        if (localResultRecord.type == 2)
        {
          localObject5 = ((antp)this.this$0.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(localResultRecord.groupUin, localResultRecord.uin);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label207;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark == null) {
            break label207;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark.length() <= 0) {
            break label207;
          }
          localObject1 = ((DiscussionMemberInfo)localObject5).inteRemark;
          localObject3 = ((DiscussionMemberInfo)localObject5).inteRemark;
          break label207;
        }
        if (localResultRecord.type == 3)
        {
          localObject1 = localResultRecord.name;
          localObject3 = localResultRecord.name;
          break label207;
        }
        localObject1 = localObject3;
        if (localResultRecord.type != 4) {
          break label207;
        }
        localObject1 = localResultRecord.name;
        localObject3 = localResultRecord.name;
        break label207;
        localObject1 = str + (String)localObject1;
      }
      Object localObject3 = localObject1;
      for (;;)
      {
        try
        {
          if (((String)localObject1).getBytes("utf-8").length > 48)
          {
            int j = ((String)localObject1).length();
            i = 1;
            localObject3 = localObject1;
            if (i <= j)
            {
              if (((String)localObject1).substring(0, i).getBytes("utf-8").length <= 48) {
                continue;
              }
              localObject3 = ((String)localObject1).substring(0, i - 1);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Object localObject4 = localObject1;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SelectMemberActivity", 2, "add discussion member: groupCode: " + this.this$0.mGroupCode + " member count: " + localArrayList1.size());
          ((antl)localObject1).b(Long.valueOf(this.this$0.mGroupCode).longValue(), localArrayList1);
          return;
        }
        localObject1 = (antl)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (this.this$0.mGroupCode != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion: " + (String)localObject3 + " member count: " + localArrayList1.size());
        }
        SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = false;
        ((antl)localObject1).a((String)localObject3, localArrayList1, this.this$0.mFrom);
        return;
        i += 1;
      }
      label827:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.12
 * JD-Core Version:    0.7.0.1
 */