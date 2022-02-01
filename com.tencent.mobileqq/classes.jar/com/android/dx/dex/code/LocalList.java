package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.util.FixedSizeList;
import java.io.PrintStream;

public final class LocalList
  extends FixedSizeList
{
  private static final boolean DEBUG = false;
  public static final LocalList EMPTY = new LocalList(0);
  
  public LocalList(int paramInt)
  {
    super(paramInt);
  }
  
  private static void debugVerify(LocalList paramLocalList)
  {
    try
    {
      debugVerify0(paramLocalList);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      int j = paramLocalList.size();
      int i = 0;
      while (i < j)
      {
        System.err.println(paramLocalList.get(i));
        i += 1;
      }
      throw localRuntimeException;
    }
  }
  
  private static void debugVerify0(LocalList paramLocalList)
  {
    int m = paramLocalList.size();
    LocalList.Entry[] arrayOfEntry = new LocalList.Entry[65536];
    int i = 0;
    if (i < m)
    {
      LocalList.Entry localEntry1 = paramLocalList.get(i);
      int n = localEntry1.getRegister();
      LocalList.Entry localEntry2;
      if (localEntry1.isStart())
      {
        localEntry2 = arrayOfEntry[n];
        if ((localEntry2 != null) && (localEntry1.matches(localEntry2))) {
          throw new RuntimeException("redundant start at " + Integer.toHexString(localEntry1.getAddress()) + ": got " + localEntry1 + "; had " + localEntry2);
        }
        arrayOfEntry[n] = localEntry1;
      }
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfEntry[n] == null) {
          throw new RuntimeException("redundant end at " + Integer.toHexString(localEntry1.getAddress()));
        }
        int i1 = localEntry1.getAddress();
        int j = i + 1;
        int k = 0;
        for (;;)
        {
          if (j < m)
          {
            localEntry2 = paramLocalList.get(j);
            if (localEntry2.getAddress() == i1) {}
          }
          else
          {
            if ((k != 0) || (localEntry1.getDisposition() != LocalList.Disposition.END_REPLACED)) {
              break label360;
            }
            throw new RuntimeException("improper end replacement claim at " + Integer.toHexString(i1));
          }
          if (localEntry2.getRegisterSpec().getReg() == n)
          {
            if (!localEntry2.isStart()) {
              break;
            }
            if (localEntry1.getDisposition() != LocalList.Disposition.END_REPLACED) {
              throw new RuntimeException("improperly marked end at " + Integer.toHexString(i1));
            }
            k = 1;
          }
          j += 1;
        }
        throw new RuntimeException("redundant end at " + Integer.toHexString(i1));
        label360:
        arrayOfEntry[n] = null;
      }
    }
  }
  
  public static LocalList make(DalvInsnList paramDalvInsnList)
  {
    int j = paramDalvInsnList.size();
    LocalList.MakeState localMakeState = new LocalList.MakeState(j);
    int i = 0;
    if (i < j)
    {
      DalvInsn localDalvInsn = paramDalvInsnList.get(i);
      Object localObject;
      if ((localDalvInsn instanceof LocalSnapshot))
      {
        localObject = ((LocalSnapshot)localDalvInsn).getLocals();
        localMakeState.snapshot(localDalvInsn.getAddress(), (RegisterSpecSet)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localDalvInsn instanceof LocalStart))
        {
          localObject = ((LocalStart)localDalvInsn).getLocal();
          localMakeState.startLocal(localDalvInsn.getAddress(), (RegisterSpec)localObject);
        }
      }
    }
    return localMakeState.finish();
  }
  
  public void debugPrint(PrintStream paramPrintStream, String paramString)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      paramPrintStream.print(paramString);
      paramPrintStream.println(get(i));
      i += 1;
    }
  }
  
  public LocalList.Entry get(int paramInt)
  {
    return (LocalList.Entry)get0(paramInt);
  }
  
  public void set(int paramInt, LocalList.Entry paramEntry)
  {
    set0(paramInt, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.LocalList
 * JD-Core Version:    0.7.0.1
 */