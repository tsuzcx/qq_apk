package com.tencent.mobileqq.activity;

import acnq;
import acnr;
import android.text.TextUtils;
import bbbr;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

class TroopTransferActivity$14
  implements Runnable
{
  TroopTransferActivity$14(TroopTransferActivity paramTroopTransferActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = false;
    Object localObject;
    acnq localacnq;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localacnq = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localacnq != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bbbr.a(((TroopMemberCardInfo)localObject).name, localacnq.m))
      {
        localacnq.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localacnq.m))
        {
          localacnq.n = ChnToSpell.a(localacnq.m, 2);
          localacnq.o = ChnToSpell.a(localacnq.m, 1);
        }
      }
      else
      {
        label118:
        if (!bbbr.a(((TroopMemberCardInfo)localObject).nick, localacnq.g))
        {
          localacnq.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localacnq.g)) {
            break label277;
          }
          localacnq.h = ChnToSpell.a(localacnq.g, 2);
          localacnq.i = ChnToSpell.a(localacnq.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localacnq.j)) {
          break label294;
        }
        localObject = localacnq.j;
      }
      for (;;)
      {
        if (!bbbr.a(localObject, localacnq.b))
        {
          localacnq.b = ((String)localObject);
          if (!TextUtils.isEmpty(localacnq.b))
          {
            localacnq.c = ChnToSpell.a(localacnq.b, 2);
            localacnq.d = ChnToSpell.a(localacnq.b, 1);
            bool = true;
            break;
            localacnq.n = "";
            localacnq.o = "";
            break label118;
            label277:
            localacnq.h = "";
            localacnq.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localacnq.m))
            {
              localObject = localacnq.m;
              continue;
            }
            if (!TextUtils.isEmpty(localacnq.g))
            {
              localObject = localacnq.g;
              continue;
            }
            if (!TextUtils.isEmpty(localacnq.a))
            {
              localObject = localacnq.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localacnq.c = "";
          localacnq.d = "";
          bool = true;
          break;
          this.this$0.a(bool);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.14
 * JD-Core Version:    0.7.0.1
 */