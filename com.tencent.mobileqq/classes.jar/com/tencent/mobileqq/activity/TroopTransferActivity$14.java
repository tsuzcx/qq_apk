package com.tencent.mobileqq.activity;

import afyz;
import afza;
import android.text.TextUtils;
import bhjx;
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
    afyz localafyz;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localafyz = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localafyz != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bhjx.a(((TroopMemberCardInfo)localObject).name, localafyz.m))
      {
        localafyz.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localafyz.m))
        {
          localafyz.n = ChnToSpell.a(localafyz.m, 2);
          localafyz.o = ChnToSpell.a(localafyz.m, 1);
        }
      }
      else
      {
        label118:
        if (!bhjx.a(((TroopMemberCardInfo)localObject).nick, localafyz.g))
        {
          localafyz.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localafyz.g)) {
            break label277;
          }
          localafyz.h = ChnToSpell.a(localafyz.g, 2);
          localafyz.i = ChnToSpell.a(localafyz.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localafyz.j)) {
          break label294;
        }
        localObject = localafyz.j;
      }
      for (;;)
      {
        if (!bhjx.a(localObject, localafyz.b))
        {
          localafyz.b = ((String)localObject);
          if (!TextUtils.isEmpty(localafyz.b))
          {
            localafyz.c = ChnToSpell.a(localafyz.b, 2);
            localafyz.d = ChnToSpell.a(localafyz.b, 1);
            bool = true;
            break;
            localafyz.n = "";
            localafyz.o = "";
            break label118;
            label277:
            localafyz.h = "";
            localafyz.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localafyz.m))
            {
              localObject = localafyz.m;
              continue;
            }
            if (!TextUtils.isEmpty(localafyz.g))
            {
              localObject = localafyz.g;
              continue;
            }
            if (!TextUtils.isEmpty(localafyz.a))
            {
              localObject = localafyz.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localafyz.c = "";
          localafyz.d = "";
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