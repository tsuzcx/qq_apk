package com.tencent.mobileqq.activity;

import acnu;
import acnv;
import android.text.TextUtils;
import bbbd;
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
    acnu localacnu;
    if (i < this.a.size())
    {
      localObject = (TroopMemberCardInfo)this.a.get(i);
      localacnu = this.this$0.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localacnu != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!bbbd.a(((TroopMemberCardInfo)localObject).name, localacnu.m))
      {
        localacnu.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localacnu.m))
        {
          localacnu.n = ChnToSpell.a(localacnu.m, 2);
          localacnu.o = ChnToSpell.a(localacnu.m, 1);
        }
      }
      else
      {
        label118:
        if (!bbbd.a(((TroopMemberCardInfo)localObject).nick, localacnu.g))
        {
          localacnu.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localacnu.g)) {
            break label277;
          }
          localacnu.h = ChnToSpell.a(localacnu.g, 2);
          localacnu.i = ChnToSpell.a(localacnu.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localacnu.j)) {
          break label294;
        }
        localObject = localacnu.j;
      }
      for (;;)
      {
        if (!bbbd.a(localObject, localacnu.b))
        {
          localacnu.b = ((String)localObject);
          if (!TextUtils.isEmpty(localacnu.b))
          {
            localacnu.c = ChnToSpell.a(localacnu.b, 2);
            localacnu.d = ChnToSpell.a(localacnu.b, 1);
            bool = true;
            break;
            localacnu.n = "";
            localacnu.o = "";
            break label118;
            label277:
            localacnu.h = "";
            localacnu.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localacnu.m))
            {
              localObject = localacnu.m;
              continue;
            }
            if (!TextUtils.isEmpty(localacnu.g))
            {
              localObject = localacnu.g;
              continue;
            }
            if (!TextUtils.isEmpty(localacnu.a))
            {
              localObject = localacnu.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localacnu.c = "";
          localacnu.d = "";
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