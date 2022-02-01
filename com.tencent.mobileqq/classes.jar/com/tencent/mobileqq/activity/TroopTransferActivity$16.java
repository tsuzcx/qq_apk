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
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localTroopMemberItem != null)
      {
        if (!Utils.a(((TroopMemberCardInfo)localObject).name, localTroopMemberItem.m))
        {
          localTroopMemberItem.m = ((TroopMemberCardInfo)localObject).name;
          if (!TextUtils.isEmpty(localTroopMemberItem.m))
          {
            localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
            localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
          }
          else
          {
            localTroopMemberItem.n = "";
            localTroopMemberItem.o = "";
          }
        }
        if (!Utils.a(((TroopMemberCardInfo)localObject).nick, localTroopMemberItem.g))
        {
          localTroopMemberItem.g = ((TroopMemberCardInfo)localObject).nick;
          if (!TextUtils.isEmpty(localTroopMemberItem.g))
          {
            localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
            localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
          }
          else
          {
            localTroopMemberItem.h = "";
            localTroopMemberItem.i = "";
          }
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.j)) {
          localObject = localTroopMemberItem.j;
        } else if (!TextUtils.isEmpty(localTroopMemberItem.m)) {
          localObject = localTroopMemberItem.m;
        } else if (!TextUtils.isEmpty(localTroopMemberItem.g)) {
          localObject = localTroopMemberItem.g;
        } else if (!TextUtils.isEmpty(localTroopMemberItem.a)) {
          localObject = localTroopMemberItem.a;
        } else {
          localObject = "";
        }
        if (!Utils.a(localObject, localTroopMemberItem.b))
        {
          localTroopMemberItem.b = ((String)localObject);
          if (!TextUtils.isEmpty(localTroopMemberItem.b))
          {
            localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.b, 2);
            localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.b, 1);
          }
          else
          {
            localTroopMemberItem.c = "";
            localTroopMemberItem.d = "";
          }
          bool = true;
        }
      }
      i += 1;
    }
    this.this$0.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.16
 * JD-Core Version:    0.7.0.1
 */