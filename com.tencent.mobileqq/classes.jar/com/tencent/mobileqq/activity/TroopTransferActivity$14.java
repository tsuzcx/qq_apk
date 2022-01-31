package com.tencent.mobileqq.activity;

import aefa;
import aefb;
import android.text.TextUtils;
import bdal;
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
    aefa localaefa;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localaefa = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localaefa != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bdal.a(((TroopMemberCardInfo)localObject).name, localaefa.m))
      {
        localaefa.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localaefa.m))
        {
          localaefa.n = ChnToSpell.a(localaefa.m, 2);
          localaefa.o = ChnToSpell.a(localaefa.m, 1);
        }
      }
      else
      {
        label118:
        if (!bdal.a(((TroopMemberCardInfo)localObject).nick, localaefa.g))
        {
          localaefa.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localaefa.g)) {
            break label277;
          }
          localaefa.h = ChnToSpell.a(localaefa.g, 2);
          localaefa.i = ChnToSpell.a(localaefa.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localaefa.j)) {
          break label294;
        }
        localObject = localaefa.j;
      }
      for (;;)
      {
        if (!bdal.a(localObject, localaefa.b))
        {
          localaefa.b = ((String)localObject);
          if (!TextUtils.isEmpty(localaefa.b))
          {
            localaefa.c = ChnToSpell.a(localaefa.b, 2);
            localaefa.d = ChnToSpell.a(localaefa.b, 1);
            bool = true;
            break;
            localaefa.n = "";
            localaefa.o = "";
            break label118;
            label277:
            localaefa.h = "";
            localaefa.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localaefa.m))
            {
              localObject = localaefa.m;
              continue;
            }
            if (!TextUtils.isEmpty(localaefa.g))
            {
              localObject = localaefa.g;
              continue;
            }
            if (!TextUtils.isEmpty(localaefa.a))
            {
              localObject = localaefa.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localaefa.c = "";
          localaefa.d = "";
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