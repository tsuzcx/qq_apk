package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$17
  implements Runnable
{
  TroopTransferActivity$17(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, TroopTransferActivity.TroopMemberItem paramTroopMemberItem) {}
  
  public void run()
  {
    boolean bool2 = Utils.a(this.a.remark, this.b.l);
    boolean bool1 = true;
    Object localObject;
    if (!bool2)
    {
      this.b.l = this.a.remark;
      if (!TextUtils.isEmpty(this.b.o))
      {
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).m = ChnToSpell.b(((TroopTransferActivity.TroopMemberItem)localObject).o, 2);
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).n = ChnToSpell.b(((TroopTransferActivity.TroopMemberItem)localObject).o, 1);
      }
      else
      {
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).m = "";
        ((TroopTransferActivity.TroopMemberItem)localObject).n = "";
      }
    }
    if (!Utils.a(this.a.name, this.b.i))
    {
      this.b.i = this.a.name;
      if (!TextUtils.isEmpty(this.b.i))
      {
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).j = ChnToSpell.b(((TroopTransferActivity.TroopMemberItem)localObject).i, 2);
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).k = ChnToSpell.b(((TroopTransferActivity.TroopMemberItem)localObject).i, 1);
      }
      else
      {
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).j = "";
        ((TroopTransferActivity.TroopMemberItem)localObject).k = "";
      }
    }
    if (!TextUtils.isEmpty(this.b.l)) {
      localObject = this.b.l;
    } else if (!TextUtils.isEmpty(this.b.o)) {
      localObject = this.b.o;
    } else if (!TextUtils.isEmpty(this.b.i)) {
      localObject = this.b.i;
    } else if (!TextUtils.isEmpty(this.b.c)) {
      localObject = this.b.c;
    } else {
      localObject = "";
    }
    if (!Utils.a(localObject, this.b.d))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = this.b;
      localTroopMemberItem.d = ((String)localObject);
      if (!TextUtils.isEmpty(localTroopMemberItem.d))
      {
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).e = ChnToSpell.b(((TroopTransferActivity.TroopMemberItem)localObject).d, 2);
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).f = ChnToSpell.b(((TroopTransferActivity.TroopMemberItem)localObject).d, 1);
      }
      else
      {
        localObject = this.b;
        ((TroopTransferActivity.TroopMemberItem)localObject).e = "";
        ((TroopTransferActivity.TroopMemberItem)localObject).f = "";
      }
    }
    else
    {
      bool1 = false;
    }
    this.this$0.a(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.17
 * JD-Core Version:    0.7.0.1
 */