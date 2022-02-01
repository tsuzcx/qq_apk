package com.tencent.mobileqq.activity;

import afje;
import afjf;
import android.text.TextUtils;
import bhbx;
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
    afje localafje;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localafje = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localafje != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bhbx.a(((TroopMemberCardInfo)localObject).name, localafje.m))
      {
        localafje.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localafje.m))
        {
          localafje.n = ChnToSpell.a(localafje.m, 2);
          localafje.o = ChnToSpell.a(localafje.m, 1);
        }
      }
      else
      {
        label118:
        if (!bhbx.a(((TroopMemberCardInfo)localObject).nick, localafje.g))
        {
          localafje.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localafje.g)) {
            break label277;
          }
          localafje.h = ChnToSpell.a(localafje.g, 2);
          localafje.i = ChnToSpell.a(localafje.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localafje.j)) {
          break label294;
        }
        localObject = localafje.j;
      }
      for (;;)
      {
        if (!bhbx.a(localObject, localafje.b))
        {
          localafje.b = ((String)localObject);
          if (!TextUtils.isEmpty(localafje.b))
          {
            localafje.c = ChnToSpell.a(localafje.b, 2);
            localafje.d = ChnToSpell.a(localafje.b, 1);
            bool = true;
            break;
            localafje.n = "";
            localafje.o = "";
            break label118;
            label277:
            localafje.h = "";
            localafje.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localafje.m))
            {
              localObject = localafje.m;
              continue;
            }
            if (!TextUtils.isEmpty(localafje.g))
            {
              localObject = localafje.g;
              continue;
            }
            if (!TextUtils.isEmpty(localafje.a))
            {
              localObject = localafje.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localafje.c = "";
          localafje.d = "";
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