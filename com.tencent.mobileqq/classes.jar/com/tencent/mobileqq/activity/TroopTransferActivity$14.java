package com.tencent.mobileqq.activity;

import acdf;
import acdg;
import android.text.TextUtils;
import azzz;
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
    acdf localacdf;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localacdf = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localacdf != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!azzz.a(((TroopMemberCardInfo)localObject).name, localacdf.m))
      {
        localacdf.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localacdf.m))
        {
          localacdf.n = ChnToSpell.a(localacdf.m, 2);
          localacdf.o = ChnToSpell.a(localacdf.m, 1);
        }
      }
      else
      {
        label118:
        if (!azzz.a(((TroopMemberCardInfo)localObject).nick, localacdf.g))
        {
          localacdf.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localacdf.g)) {
            break label277;
          }
          localacdf.h = ChnToSpell.a(localacdf.g, 2);
          localacdf.i = ChnToSpell.a(localacdf.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localacdf.j)) {
          break label294;
        }
        localObject = localacdf.j;
      }
      for (;;)
      {
        if (!azzz.a(localObject, localacdf.b))
        {
          localacdf.b = ((String)localObject);
          if (!TextUtils.isEmpty(localacdf.b))
          {
            localacdf.c = ChnToSpell.a(localacdf.b, 2);
            localacdf.d = ChnToSpell.a(localacdf.b, 1);
            bool = true;
            break;
            localacdf.n = "";
            localacdf.o = "";
            break label118;
            label277:
            localacdf.h = "";
            localacdf.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localacdf.m))
            {
              localObject = localacdf.m;
              continue;
            }
            if (!TextUtils.isEmpty(localacdf.g))
            {
              localObject = localacdf.g;
              continue;
            }
            if (!TextUtils.isEmpty(localacdf.a))
            {
              localObject = localacdf.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localacdf.c = "";
          localacdf.d = "";
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