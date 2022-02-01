package com.tencent.mobileqq.activity;

import afpv;
import afpw;
import android.text.TextUtils;
import bgjw;
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
    afpv localafpv;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localafpv = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localafpv != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bgjw.a(((TroopMemberCardInfo)localObject).name, localafpv.m))
      {
        localafpv.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localafpv.m))
        {
          localafpv.n = ChnToSpell.a(localafpv.m, 2);
          localafpv.o = ChnToSpell.a(localafpv.m, 1);
        }
      }
      else
      {
        label118:
        if (!bgjw.a(((TroopMemberCardInfo)localObject).nick, localafpv.g))
        {
          localafpv.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localafpv.g)) {
            break label277;
          }
          localafpv.h = ChnToSpell.a(localafpv.g, 2);
          localafpv.i = ChnToSpell.a(localafpv.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localafpv.j)) {
          break label294;
        }
        localObject = localafpv.j;
      }
      for (;;)
      {
        if (!bgjw.a(localObject, localafpv.b))
        {
          localafpv.b = ((String)localObject);
          if (!TextUtils.isEmpty(localafpv.b))
          {
            localafpv.c = ChnToSpell.a(localafpv.b, 2);
            localafpv.d = ChnToSpell.a(localafpv.b, 1);
            bool = true;
            break;
            localafpv.n = "";
            localafpv.o = "";
            break label118;
            label277:
            localafpv.h = "";
            localafpv.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localafpv.m))
            {
              localObject = localafpv.m;
              continue;
            }
            if (!TextUtils.isEmpty(localafpv.g))
            {
              localObject = localafpv.g;
              continue;
            }
            if (!TextUtils.isEmpty(localafpv.a))
            {
              localObject = localafpv.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localafpv.c = "";
          localafpv.d = "";
          bool = true;
          break;
          this.this$0.a(bool);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.14
 * JD-Core Version:    0.7.0.1
 */