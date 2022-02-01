package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopGagActivity$2$1$1
  implements Runnable
{
  TroopGagActivity$2$1$1(TroopGagActivity.2.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.b.b.a.i.clear();
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MemberGagInfo localMemberGagInfo = (MemberGagInfo)((Iterator)localObject).next();
        TroopGagActivity.GagMemInfo localGagMemInfo = new TroopGagActivity.GagMemInfo();
        localGagMemInfo.a = localMemberGagInfo.a;
        localGagMemInfo.c = localMemberGagInfo.b;
        this.b.b.a.i.add(localGagMemInfo);
      }
    }
    this.b.b.a.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */