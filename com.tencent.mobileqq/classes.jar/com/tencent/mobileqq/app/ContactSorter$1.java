package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

final class ContactSorter$1
  implements Comparator<Entity>
{
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    int i = 0;
    if ((paramEntity1 instanceof Groups))
    {
      paramEntity1 = (Groups)paramEntity1;
      paramEntity2 = (Groups)paramEntity2;
      return paramEntity1.seqid - paramEntity2.seqid;
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramEntity1 instanceof Friends))
    {
      paramEntity1 = (Friends)paramEntity1;
      localObject = (Friends)paramEntity2;
      j = paramEntity1.mComparePartInt;
      paramEntity2 = paramEntity1.mCompareSpell;
      i = ((Friends)localObject).mComparePartInt;
      paramEntity1 = ((Friends)localObject).mCompareSpell;
    }
    for (;;)
    {
      return ContactSorter.a(j, paramEntity2, i, paramEntity1);
      if ((paramEntity1 instanceof TroopInfo))
      {
        paramEntity1 = (TroopInfo)paramEntity1;
        localObject = (TroopInfo)paramEntity2;
        j = paramEntity1.mComparePartInt;
        i = ((TroopInfo)localObject).mComparePartInt;
        paramEntity2 = paramEntity1.mCompareSpell;
        paramEntity1 = ((TroopInfo)localObject).mCompareSpell;
      }
      else if ((paramEntity1 instanceof DiscussionInfo))
      {
        paramEntity1 = (DiscussionInfo)paramEntity1;
        localObject = (DiscussionInfo)paramEntity2;
        j = paramEntity1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramEntity2 = paramEntity1.mCompareSpell;
        paramEntity1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if ((paramEntity1 instanceof PublicAccountInfo))
      {
        paramEntity1 = (PublicAccountInfo)paramEntity1;
        localObject = (PublicAccountInfo)paramEntity2;
        j = paramEntity1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramEntity2 = paramEntity1.mCompareSpell;
        paramEntity1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramEntity1 = str;
        paramEntity2 = (Entity)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactSorter.1
 * JD-Core Version:    0.7.0.1
 */