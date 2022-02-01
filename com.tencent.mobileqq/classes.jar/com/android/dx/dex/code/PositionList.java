package com.android.dx.dex.code;

import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.FixedSizeList;

public final class PositionList
  extends FixedSizeList
{
  public static final PositionList EMPTY = new PositionList(0);
  public static final int IMPORTANT = 3;
  public static final int LINES = 2;
  public static final int NONE = 1;
  
  public PositionList(int paramInt)
  {
    super(paramInt);
  }
  
  public static PositionList make(DalvInsnList paramDalvInsnList, int paramInt)
  {
    int i1 = 0;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("bogus howMuch");
    case 1: 
      return EMPTY;
    }
    SourcePosition localSourcePosition1 = SourcePosition.NO_INFO;
    int i2 = paramDalvInsnList.size();
    PositionList.Entry[] arrayOfEntry = new PositionList.Entry[i2];
    int j = 0;
    int k = 0;
    int m = 0;
    Object localObject1 = localSourcePosition1;
    if (j < i2)
    {
      DalvInsn localDalvInsn = paramDalvInsnList.get(j);
      int i;
      Object localObject2;
      int n;
      if ((localDalvInsn instanceof CodeAddress))
      {
        i = 1;
        localObject2 = localObject1;
        n = k;
      }
      for (;;)
      {
        j += 1;
        k = n;
        m = i;
        localObject1 = localObject2;
        break;
        SourcePosition localSourcePosition2 = localDalvInsn.getPosition();
        n = k;
        i = m;
        localObject2 = localObject1;
        if (!localSourcePosition2.equals(localSourcePosition1))
        {
          n = k;
          i = m;
          localObject2 = localObject1;
          if (!localSourcePosition2.sameLine((SourcePosition)localObject1)) {
            if (paramInt == 3)
            {
              n = k;
              i = m;
              localObject2 = localObject1;
              if (m == 0) {}
            }
            else
            {
              arrayOfEntry[k] = new PositionList.Entry(localDalvInsn.getAddress(), localSourcePosition2);
              n = k + 1;
              i = 0;
              localObject2 = localSourcePosition2;
            }
          }
        }
      }
    }
    paramDalvInsnList = new PositionList(k);
    paramInt = i1;
    while (paramInt < k)
    {
      paramDalvInsnList.set(paramInt, arrayOfEntry[paramInt]);
      paramInt += 1;
    }
    paramDalvInsnList.setImmutable();
    return paramDalvInsnList;
  }
  
  public PositionList.Entry get(int paramInt)
  {
    return (PositionList.Entry)get0(paramInt);
  }
  
  public void set(int paramInt, PositionList.Entry paramEntry)
  {
    set0(paramInt, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.PositionList
 * JD-Core Version:    0.7.0.1
 */