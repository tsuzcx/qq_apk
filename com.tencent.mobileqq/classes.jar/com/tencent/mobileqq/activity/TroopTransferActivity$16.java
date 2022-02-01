package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

class TroopTransferActivity$16
  implements Runnable
{
  TroopTransferActivity$16(TroopTransferActivity paramTroopTransferActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = false;
    while (i < this.a.size())
    {
      Object localObject = (TroopMemberCardInfo)this.a.get(i);
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = this.this$0.h.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localTroopMemberItem != null)
      {
        if (!Utils.a(((TroopMemberCardInfo)localObject).name, localTroopMemberItem.o))
        {
          localTroopMemberItem.o = ((TroopMemberCardInfo)localObject).name;
          if (!TextUtils.isEmpty(localTroopMemberItem.o))
          {
            localTroopMemberItem.p = ChnToSpell.b(localTroopMemberItem.o, 2);
            localTroopMemberItem.q = ChnToSpell.b(localTroopMemberItem.o, 1);
          }
          else
          {
            localTroopMemberItem.p = "";
            localTroopMemberItem.q = "";
          }
        }
        if (!Utils.a(((TroopMemberCardInfo)localObject).nick, localTroopMemberItem.i))
        {
          localTroopMemberItem.i = ((TroopMemberCardInfo)localObject).nick;
          if (!TextUtils.isEmpty(localTroopMemberItem.i))
          {
            localTroopMemberItem.j = ChnToSpell.b(localTroopMemberItem.i, 2);
            localTroopMemberItem.k = ChnToSpell.b(localTroopMemberItem.i, 1);
          }
          else
          {
            localTroopMemberItem.j = "";
            localTroopMemberItem.k = "";
          }
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.l)) {
          localObject = localTroopMemberItem.l;
        } else if (!TextUtils.isEmpty(localTroopMemberItem.o)) {
          localObject = localTroopMemberItem.o;
        } else if (!TextUtils.isEmpty(localTroopMemberItem.i)) {
          localObject = localTroopMemberItem.i;
        } else if (!TextUtils.isEmpty(localTroopMemberItem.c)) {
          localObject = localTroopMemberItem.c;
        } else {
          localObject = "";
        }
        if (!Utils.a(localObject, localTroopMemberItem.d))
        {
          localTroopMemberItem.d = ((String)localObject);
          if (!TextUtils.isEmpty(localTroopMemberItem.d))
          {
            localTroopMemberItem.e = ChnToSpell.b(localTroopMemberItem.d, 2);
            localTroopMemberItem.f = ChnToSpell.b(localTroopMemberItem.d, 1);
          }
          else
          {
            localTroopMemberItem.e = "";
            localTroopMemberItem.f = "";
          }
          bool = true;
        }
      }
      i += 1;
    }
    this.this$0.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.16
 * JD-Core Version:    0.7.0.1
 */