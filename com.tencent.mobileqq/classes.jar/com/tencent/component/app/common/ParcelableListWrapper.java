package com.tencent.component.app.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ParcelableListWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableListWrapper> CREATOR = new ParcelableListWrapper.1();
  public static final int POOL_SIZE = 5;
  private static ParcelableListWrapper[] sOwnedPool = new ParcelableListWrapper[5];
  private ArrayList parcelableList;
  
  ParcelableListWrapper(ArrayList<? extends SmartParcelable> paramArrayList)
  {
    this.parcelableList = paramArrayList;
  }
  
  public static ParcelableListWrapper obtain(ArrayList<? extends SmartParcelable> paramArrayList)
  {
    ParcelableListWrapper[] arrayOfParcelableListWrapper = sOwnedPool;
    int i = 0;
    for (;;)
    {
      ParcelableListWrapper localParcelableListWrapper;
      if (i < 5)
      {
        localParcelableListWrapper = arrayOfParcelableListWrapper[i];
        if (localParcelableListWrapper != null) {
          arrayOfParcelableListWrapper[i] = null;
        }
      }
      else
      {
        try
        {
          localParcelableListWrapper.parcelableList = paramArrayList;
          return localParcelableListWrapper;
        }
        finally
        {
          break label53;
        }
        return new ParcelableListWrapper(paramArrayList);
        label53:
        for (;;)
        {
          throw paramArrayList;
        }
      }
      i += 1;
    }
  }
  
  public static ArrayList<? extends SmartParcelable> readArrayList(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(i);
    readListInternal(paramParcel, localArrayList, i, paramClassLoader);
    return localArrayList;
  }
  
  private static void readListInternal(Parcel paramParcel, List paramList, int paramInt, ClassLoader paramClassLoader)
  {
    while (paramInt > 0)
    {
      paramList.add(((ParcelableWrapper)paramParcel.readValue(paramClassLoader)).getData());
      paramInt -= 1;
    }
  }
  
  /* Error */
  public static void recycle(ParcelableListWrapper paramParcelableListWrapper)
  {
    // Byte code:
    //   0: getstatic 20	com/tencent/component/app/common/ParcelableListWrapper:sOwnedPool	[Lcom/tencent/component/app/common/ParcelableListWrapper;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_1
    //   8: iload_1
    //   9: iconst_5
    //   10: if_icmpge +16 -> 26
    //   13: aload_2
    //   14: iload_1
    //   15: aaload
    //   16: ifnonnull +24 -> 40
    //   19: aload_2
    //   20: iload_1
    //   21: aload_0
    //   22: aastore
    //   23: aload_2
    //   24: monitorexit
    //   25: return
    //   26: aload_2
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: aload_2
    //   31: monitorexit
    //   32: goto +5 -> 37
    //   35: aload_0
    //   36: athrow
    //   37: goto -2 -> 35
    //   40: iload_1
    //   41: iconst_1
    //   42: iadd
    //   43: istore_1
    //   44: goto -36 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramParcelableListWrapper	ParcelableListWrapper
    //   7	37	1	i	int
    //   3	28	2	arrayOfParcelableListWrapper	ParcelableListWrapper[]
    // Exception table:
    //   from	to	target	type
    //   23	25	29	finally
    //   26	28	29	finally
    //   30	32	29	finally
  }
  
  public static void writeList(Parcel paramParcel, List<? extends SmartParcelable> paramList)
  {
    if (paramList == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    int j = paramList.size();
    int i = 0;
    paramParcel.writeInt(j);
    while (i < j)
    {
      ParcelableWrapper localParcelableWrapper = ParcelableWrapper.obtain((SmartParcelable)paramList.get(i));
      paramParcel.writeValue(localParcelableWrapper);
      ParcelableWrapper.recycle(localParcelableWrapper);
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public <T extends SmartParcelable> ArrayList<T> getParcelableList()
  {
    return this.parcelableList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    writeList(paramParcel, this.parcelableList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.app.common.ParcelableListWrapper
 * JD-Core Version:    0.7.0.1
 */