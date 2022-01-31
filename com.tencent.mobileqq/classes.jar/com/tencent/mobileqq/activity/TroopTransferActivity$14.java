package com.tencent.mobileqq.activity;

import aejp;
import aejq;
import android.text.TextUtils;
import bdeu;
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
    aejp localaejp;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localaejp = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localaejp != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bdeu.a(((TroopMemberCardInfo)localObject).name, localaejp.m))
      {
        localaejp.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localaejp.m))
        {
          localaejp.n = ChnToSpell.a(localaejp.m, 2);
          localaejp.o = ChnToSpell.a(localaejp.m, 1);
        }
      }
      else
      {
        label118:
        if (!bdeu.a(((TroopMemberCardInfo)localObject).nick, localaejp.g))
        {
          localaejp.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localaejp.g)) {
            break label277;
          }
          localaejp.h = ChnToSpell.a(localaejp.g, 2);
          localaejp.i = ChnToSpell.a(localaejp.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localaejp.j)) {
          break label294;
        }
        localObject = localaejp.j;
      }
      for (;;)
      {
        if (!bdeu.a(localObject, localaejp.b))
        {
          localaejp.b = ((String)localObject);
          if (!TextUtils.isEmpty(localaejp.b))
          {
            localaejp.c = ChnToSpell.a(localaejp.b, 2);
            localaejp.d = ChnToSpell.a(localaejp.b, 1);
            bool = true;
            break;
            localaejp.n = "";
            localaejp.o = "";
            break label118;
            label277:
            localaejp.h = "";
            localaejp.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localaejp.m))
            {
              localObject = localaejp.m;
              continue;
            }
            if (!TextUtils.isEmpty(localaejp.g))
            {
              localObject = localaejp.g;
              continue;
            }
            if (!TextUtils.isEmpty(localaejp.a))
            {
              localObject = localaejp.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localaejp.c = "";
          localaejp.d = "";
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