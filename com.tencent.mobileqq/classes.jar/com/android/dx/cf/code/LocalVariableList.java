package com.android.dx.cf.code;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.FixedSizeList;

public final class LocalVariableList
  extends FixedSizeList
{
  public static final LocalVariableList EMPTY = new LocalVariableList(0);
  
  public LocalVariableList(int paramInt)
  {
    super(paramInt);
  }
  
  public static LocalVariableList concat(LocalVariableList paramLocalVariableList1, LocalVariableList paramLocalVariableList2)
  {
    int k = 0;
    if (paramLocalVariableList1 == EMPTY) {
      return paramLocalVariableList2;
    }
    int m = paramLocalVariableList1.size();
    int n = paramLocalVariableList2.size();
    LocalVariableList localLocalVariableList = new LocalVariableList(m + n);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      localLocalVariableList.set(i, paramLocalVariableList1.get(i));
      i += 1;
    }
    while (j < n)
    {
      localLocalVariableList.set(m + j, paramLocalVariableList2.get(j));
      j += 1;
    }
    localLocalVariableList.setImmutable();
    return localLocalVariableList;
  }
  
  public static LocalVariableList mergeDescriptorsAndSignatures(LocalVariableList paramLocalVariableList1, LocalVariableList paramLocalVariableList2)
  {
    int j = paramLocalVariableList1.size();
    LocalVariableList localLocalVariableList = new LocalVariableList(j);
    int i = 0;
    while (i < j)
    {
      LocalVariableList.Item localItem2 = paramLocalVariableList1.get(i);
      LocalVariableList.Item localItem3 = paramLocalVariableList2.itemToLocal(localItem2);
      LocalVariableList.Item localItem1 = localItem2;
      if (localItem3 != null) {
        localItem1 = localItem2.withSignature(LocalVariableList.Item.access$000(localItem3));
      }
      localLocalVariableList.set(i, localItem1);
      i += 1;
    }
    localLocalVariableList.setImmutable();
    return localLocalVariableList;
  }
  
  public LocalVariableList.Item get(int paramInt)
  {
    return (LocalVariableList.Item)get0(paramInt);
  }
  
  public LocalVariableList.Item itemToLocal(LocalVariableList.Item paramItem)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      LocalVariableList.Item localItem = (LocalVariableList.Item)get0(i);
      if ((localItem != null) && (localItem.matchesAllButType(paramItem))) {
        return localItem;
      }
      i += 1;
    }
    return null;
  }
  
  public LocalVariableList.Item pcAndIndexToLocal(int paramInt1, int paramInt2)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      LocalVariableList.Item localItem = (LocalVariableList.Item)get0(i);
      if ((localItem != null) && (localItem.matchesPcAndIndex(paramInt1, paramInt2))) {
        return localItem;
      }
      i += 1;
    }
    return null;
  }
  
  public void set(int paramInt1, int paramInt2, int paramInt3, CstString paramCstString1, CstString paramCstString2, CstString paramCstString3, int paramInt4)
  {
    set0(paramInt1, new LocalVariableList.Item(paramInt2, paramInt3, paramCstString1, paramCstString2, paramCstString3, paramInt4));
  }
  
  public void set(int paramInt, LocalVariableList.Item paramItem)
  {
    if (paramItem == null) {
      throw new NullPointerException("item == null");
    }
    set0(paramInt, paramItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.LocalVariableList
 * JD-Core Version:    0.7.0.1
 */