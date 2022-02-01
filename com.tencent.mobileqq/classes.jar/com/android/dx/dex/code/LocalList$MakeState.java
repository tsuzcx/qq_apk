package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LocalList$MakeState
{
  private int[] endIndices;
  private int lastAddress;
  private int nullResultCount;
  private RegisterSpecSet regs;
  private final ArrayList<LocalList.Entry> result;
  
  public LocalList$MakeState(int paramInt)
  {
    this.result = new ArrayList(paramInt);
    this.nullResultCount = 0;
    this.regs = null;
    this.endIndices = null;
    this.lastAddress = 0;
  }
  
  private void aboutToProcess(int paramInt1, int paramInt2)
  {
    int i;
    if (this.endIndices == null)
    {
      i = 1;
      if ((paramInt1 != this.lastAddress) || (i != 0)) {
        break label27;
      }
    }
    label27:
    do
    {
      return;
      i = 0;
      break;
      if (paramInt1 < this.lastAddress) {
        throw new RuntimeException("shouldn't happen");
      }
    } while ((i == 0) && (paramInt2 < this.endIndices.length));
    paramInt1 = paramInt2 + 1;
    RegisterSpecSet localRegisterSpecSet = new RegisterSpecSet(paramInt1);
    int[] arrayOfInt = new int[paramInt1];
    Arrays.fill(arrayOfInt, -1);
    if (i == 0)
    {
      localRegisterSpecSet.putAll(this.regs);
      System.arraycopy(this.endIndices, 0, arrayOfInt, 0, this.endIndices.length);
    }
    this.regs = localRegisterSpecSet;
    this.endIndices = arrayOfInt;
  }
  
  private void add(int paramInt, LocalList.Disposition paramDisposition, RegisterSpec paramRegisterSpec)
  {
    int i = paramRegisterSpec.getReg();
    this.result.add(new LocalList.Entry(paramInt, paramDisposition, paramRegisterSpec));
    if (paramDisposition == LocalList.Disposition.START)
    {
      this.regs.put(paramRegisterSpec);
      this.endIndices[i] = -1;
      return;
    }
    this.regs.remove(paramRegisterSpec);
    this.endIndices[i] = (this.result.size() - 1);
  }
  
  private void addOrUpdateEnd(int paramInt, LocalList.Disposition paramDisposition, RegisterSpec paramRegisterSpec)
  {
    if (paramDisposition == LocalList.Disposition.START) {
      throw new RuntimeException("shouldn't happen");
    }
    int i = paramRegisterSpec.getReg();
    i = this.endIndices[i];
    if (i >= 0)
    {
      LocalList.Entry localEntry = (LocalList.Entry)this.result.get(i);
      if ((localEntry.getAddress() == paramInt) && (localEntry.getRegisterSpec().equals(paramRegisterSpec)))
      {
        this.result.set(i, localEntry.withDisposition(paramDisposition));
        this.regs.remove(paramRegisterSpec);
        return;
      }
    }
    endLocal(paramInt, paramRegisterSpec, paramDisposition);
  }
  
  private boolean checkForEmptyRange(int paramInt, RegisterSpec paramRegisterSpec)
  {
    int k = 0;
    int i = this.result.size() - 1;
    if (i >= 0)
    {
      LocalList.Entry localEntry = (LocalList.Entry)this.result.get(i);
      if (localEntry == null) {}
      do
      {
        i -= 1;
        break;
        if (localEntry.getAddress() != paramInt) {
          return false;
        }
      } while (!localEntry.matches(paramRegisterSpec));
    }
    this.regs.remove(paramRegisterSpec);
    this.result.set(i, null);
    this.nullResultCount += 1;
    int m = paramRegisterSpec.getReg();
    i -= 1;
    paramRegisterSpec = null;
    int j = k;
    if (i >= 0)
    {
      paramRegisterSpec = (LocalList.Entry)this.result.get(i);
      if (paramRegisterSpec == null) {}
      while (paramRegisterSpec.getRegisterSpec().getReg() != m)
      {
        i -= 1;
        break;
      }
      j = 1;
    }
    if (j != 0)
    {
      this.endIndices[m] = i;
      if (paramRegisterSpec.getAddress() == paramInt) {
        this.result.set(i, paramRegisterSpec.withDisposition(LocalList.Disposition.END_SIMPLY));
      }
    }
    return true;
  }
  
  private static RegisterSpec filterSpec(RegisterSpec paramRegisterSpec)
  {
    RegisterSpec localRegisterSpec = paramRegisterSpec;
    if (paramRegisterSpec != null)
    {
      localRegisterSpec = paramRegisterSpec;
      if (paramRegisterSpec.getType() == Type.KNOWN_NULL) {
        localRegisterSpec = paramRegisterSpec.withType(Type.OBJECT);
      }
    }
    return localRegisterSpec;
  }
  
  public void endLocal(int paramInt, RegisterSpec paramRegisterSpec)
  {
    endLocal(paramInt, paramRegisterSpec, LocalList.Disposition.END_SIMPLY);
  }
  
  public void endLocal(int paramInt, RegisterSpec paramRegisterSpec, LocalList.Disposition paramDisposition)
  {
    int i = paramRegisterSpec.getReg();
    paramRegisterSpec = filterSpec(paramRegisterSpec);
    aboutToProcess(paramInt, i);
    if (this.endIndices[i] >= 0) {}
    while (checkForEmptyRange(paramInt, paramRegisterSpec)) {
      return;
    }
    add(paramInt, paramDisposition, paramRegisterSpec);
  }
  
  public LocalList finish()
  {
    int j = 0;
    aboutToProcess(2147483647, 0);
    int i = this.result.size();
    int k = i - this.nullResultCount;
    if (k == 0) {
      return LocalList.EMPTY;
    }
    LocalList.Entry[] arrayOfEntry = new LocalList.Entry[k];
    if (i == k)
    {
      this.result.toArray(arrayOfEntry);
      Arrays.sort(arrayOfEntry);
      localObject = new LocalList(k);
      i = j;
      while (i < k)
      {
        ((LocalList)localObject).set(i, arrayOfEntry[i]);
        i += 1;
      }
    }
    Object localObject = this.result.iterator();
    i = 0;
    label103:
    if (((Iterator)localObject).hasNext())
    {
      LocalList.Entry localEntry = (LocalList.Entry)((Iterator)localObject).next();
      if (localEntry == null) {
        break label151;
      }
      arrayOfEntry[i] = localEntry;
      i += 1;
    }
    label151:
    for (;;)
    {
      break label103;
      break;
      ((LocalList)localObject).setImmutable();
      return localObject;
    }
  }
  
  public void snapshot(int paramInt, RegisterSpecSet paramRegisterSpecSet)
  {
    int j = paramRegisterSpecSet.getMaxSize();
    aboutToProcess(paramInt, j - 1);
    int i = 0;
    if (i < j)
    {
      RegisterSpec localRegisterSpec1 = this.regs.get(i);
      RegisterSpec localRegisterSpec2 = filterSpec(paramRegisterSpecSet.get(i));
      if (localRegisterSpec1 == null) {
        if (localRegisterSpec2 != null) {
          startLocal(paramInt, localRegisterSpec2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localRegisterSpec2 == null)
        {
          endLocal(paramInt, localRegisterSpec1);
        }
        else if (!localRegisterSpec2.equalsUsingSimpleType(localRegisterSpec1))
        {
          endLocal(paramInt, localRegisterSpec1);
          startLocal(paramInt, localRegisterSpec2);
        }
      }
    }
  }
  
  public void startLocal(int paramInt, RegisterSpec paramRegisterSpec)
  {
    int i = paramRegisterSpec.getReg();
    paramRegisterSpec = filterSpec(paramRegisterSpec);
    aboutToProcess(paramInt, i);
    Object localObject = this.regs.get(i);
    if (paramRegisterSpec.equalsUsingSimpleType((RegisterSpec)localObject)) {
      return;
    }
    RegisterSpec localRegisterSpec = this.regs.findMatchingLocal(paramRegisterSpec);
    if (localRegisterSpec != null) {
      addOrUpdateEnd(paramInt, LocalList.Disposition.END_MOVED, localRegisterSpec);
    }
    int j = this.endIndices[i];
    if (localObject != null) {
      add(paramInt, LocalList.Disposition.END_REPLACED, (RegisterSpec)localObject);
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject = this.regs.get(i - 1);
        if ((localObject != null) && (((RegisterSpec)localObject).isCategory2())) {
          addOrUpdateEnd(paramInt, LocalList.Disposition.END_CLOBBERED_BY_NEXT, (RegisterSpec)localObject);
        }
      }
      if (paramRegisterSpec.isCategory2())
      {
        localObject = this.regs.get(i + 1);
        if (localObject != null) {
          addOrUpdateEnd(paramInt, LocalList.Disposition.END_CLOBBERED_BY_PREV, (RegisterSpec)localObject);
        }
      }
      add(paramInt, LocalList.Disposition.START, paramRegisterSpec);
      return;
      if (j >= 0)
      {
        localObject = (LocalList.Entry)this.result.get(j);
        if (((LocalList.Entry)localObject).getAddress() == paramInt)
        {
          if (((LocalList.Entry)localObject).matches(paramRegisterSpec))
          {
            this.result.set(j, null);
            this.nullResultCount += 1;
            this.regs.put(paramRegisterSpec);
            this.endIndices[i] = -1;
            return;
          }
          localObject = ((LocalList.Entry)localObject).withDisposition(LocalList.Disposition.END_REPLACED);
          this.result.set(j, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.LocalList.MakeState
 * JD-Core Version:    0.7.0.1
 */