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
    if ((paramEntity1 instanceof Groups))
    {
      paramEntity1 = (Groups)paramEntity1;
      paramEntity2 = (Groups)paramEntity2;
      return paramEntity1.seqid - paramEntity2.seqid;
    }
    boolean bool = paramEntity1 instanceof Friends;
    String str = "-";
    int j = 0;
    int i;
    if (bool)
    {
      paramEntity1 = (Friends)paramEntity1;
      paramEntity2 = (Friends)paramEntity2;
      j = paramEntity1.mComparePartInt;
      paramEntity1 = paramEntity1.mCompareSpell;
      i = paramEntity2.mComparePartInt;
      paramEntity2 = paramEntity2.mCompareSpell;
    }
    else if ((paramEntity1 instanceof TroopInfo))
    {
      paramEntity1 = (TroopInfo)paramEntity1;
      paramEntity2 = (TroopInfo)paramEntity2;
      j = paramEntity1.mComparePartInt;
      i = paramEntity2.mComparePartInt;
      paramEntity1 = paramEntity1.mCompareSpell;
      paramEntity2 = paramEntity2.mCompareSpell;
    }
    else if ((paramEntity1 instanceof DiscussionInfo))
    {
      paramEntity1 = (DiscussionInfo)paramEntity1;
      paramEntity2 = (DiscussionInfo)paramEntity2;
      j = paramEntity1.mComparePartInt;
      i = paramEntity2.mComparePartInt;
      paramEntity1 = paramEntity1.mCompareSpell;
      paramEntity2 = paramEntity2.mCompareSpell;
    }
    else if ((paramEntity1 instanceof PublicAccountInfo))
    {
      paramEntity1 = (PublicAccountInfo)paramEntity1;
      paramEntity2 = (PublicAccountInfo)paramEntity2;
      j = paramEntity1.mComparePartInt;
      i = paramEntity2.mComparePartInt;
      paramEntity1 = paramEntity1.mCompareSpell;
      paramEntity2 = paramEntity2.mCompareSpell;
    }
    else
    {
      paramEntity2 = "-";
      i = 0;
      paramEntity1 = str;
    }
    return ContactSorter.a(j, paramEntity1, i, paramEntity2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactSorter.1
 * JD-Core Version:    0.7.0.1
 */