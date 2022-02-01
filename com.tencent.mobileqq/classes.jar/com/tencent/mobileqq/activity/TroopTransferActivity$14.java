package com.tencent.mobileqq.activity;

import aert;
import aeru;
import android.text.TextUtils;
import bftf;
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
    aert localaert;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localaert = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localaert != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bftf.a(((TroopMemberCardInfo)localObject).name, localaert.m))
      {
        localaert.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localaert.m))
        {
          localaert.n = ChnToSpell.a(localaert.m, 2);
          localaert.o = ChnToSpell.a(localaert.m, 1);
        }
      }
      else
      {
        label118:
        if (!bftf.a(((TroopMemberCardInfo)localObject).nick, localaert.g))
        {
          localaert.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localaert.g)) {
            break label277;
          }
          localaert.h = ChnToSpell.a(localaert.g, 2);
          localaert.i = ChnToSpell.a(localaert.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localaert.j)) {
          break label294;
        }
        localObject = localaert.j;
      }
      for (;;)
      {
        if (!bftf.a(localObject, localaert.b))
        {
          localaert.b = ((String)localObject);
          if (!TextUtils.isEmpty(localaert.b))
          {
            localaert.c = ChnToSpell.a(localaert.b, 2);
            localaert.d = ChnToSpell.a(localaert.b, 1);
            bool = true;
            break;
            localaert.n = "";
            localaert.o = "";
            break label118;
            label277:
            localaert.h = "";
            localaert.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localaert.m))
            {
              localObject = localaert.m;
              continue;
            }
            if (!TextUtils.isEmpty(localaert.g))
            {
              localObject = localaert.g;
              continue;
            }
            if (!TextUtils.isEmpty(localaert.a))
            {
              localObject = localaert.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localaert.c = "";
          localaert.d = "";
          bool = true;
          break;
          this.this$0.a(bool);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.14
 * JD-Core Version:    0.7.0.1
 */