package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Iterator;

public class LocalsArraySet
  extends LocalsArray
{
  private final OneLocalsArray primary;
  private final ArrayList<LocalsArray> secondaries;
  
  public LocalsArraySet(int paramInt) {}
  
  private LocalsArraySet(LocalsArraySet paramLocalsArraySet) {}
  
  public LocalsArraySet(OneLocalsArray paramOneLocalsArray, ArrayList<LocalsArray> paramArrayList) {}
  
  private LocalsArray getSecondaryForLabel(int paramInt)
  {
    if (paramInt >= this.secondaries.size()) {
      return null;
    }
    return (LocalsArray)this.secondaries.get(paramInt);
  }
  
  private LocalsArraySet mergeWithOne(OneLocalsArray paramOneLocalsArray)
  {
    OneLocalsArray localOneLocalsArray = this.primary.merge(paramOneLocalsArray.getPrimary());
    ArrayList localArrayList = new ArrayList(this.secondaries.size());
    int k = this.secondaries.size();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < k)
      {
        LocalsArray localLocalsArray = (LocalsArray)this.secondaries.get(j);
        Object localObject3 = null;
        Object localObject1 = localObject3;
        if (localLocalsArray != null) {}
        try
        {
          localObject1 = localLocalsArray.merge(paramOneLocalsArray);
          if ((i != 0) || (localLocalsArray != localObject1))
          {
            i = 1;
            localArrayList.add(localObject1);
            j += 1;
          }
        }
        catch (SimException localSimException)
        {
          for (;;)
          {
            localSimException.addContext("Merging one locals against caller block " + Hex.u2(j));
            Object localObject2 = localObject3;
            continue;
            i = 0;
          }
        }
      }
    }
    if ((this.primary == localOneLocalsArray) && (i == 0)) {
      return this;
    }
    return new LocalsArraySet(localOneLocalsArray, localArrayList);
  }
  
  private LocalsArraySet mergeWithSet(LocalsArraySet paramLocalsArraySet)
  {
    OneLocalsArray localOneLocalsArray = this.primary.merge(paramLocalsArraySet.getPrimary());
    int k = this.secondaries.size();
    int m = paramLocalsArraySet.secondaries.size();
    int n = Math.max(k, m);
    ArrayList localArrayList = new ArrayList(n);
    int j = 0;
    int i = 0;
    if (j < n)
    {
      LocalsArray localLocalsArray2;
      label80:
      LocalsArray localLocalsArray1;
      if (j < k)
      {
        localLocalsArray2 = (LocalsArray)this.secondaries.get(j);
        if (j >= m) {
          break label144;
        }
        localLocalsArray1 = (LocalsArray)paramLocalsArraySet.secondaries.get(j);
        label99:
        if (localLocalsArray2 != localLocalsArray1) {
          break label150;
        }
        localLocalsArray1 = localLocalsArray2;
        label110:
        if ((i == 0) && (localLocalsArray2 == localLocalsArray1)) {
          break label217;
        }
      }
      label144:
      label150:
      label217:
      for (i = 1;; i = 0)
      {
        for (;;)
        {
          localArrayList.add(localLocalsArray1);
          j += 1;
          break;
          localLocalsArray2 = null;
          break label80;
          localLocalsArray1 = null;
          break label99;
          if (localLocalsArray2 == null) {
            break label110;
          }
          if (localLocalsArray1 == null)
          {
            localLocalsArray1 = localLocalsArray2;
            break label110;
          }
          try
          {
            localLocalsArray1 = localLocalsArray2.merge(localLocalsArray1);
          }
          catch (SimException localSimException)
          {
            localSimException.addContext("Merging locals set for caller block " + Hex.u2(j));
            Object localObject = null;
          }
        }
        break label110;
      }
    }
    if ((this.primary == localOneLocalsArray) && (i == 0)) {
      return this;
    }
    return new LocalsArraySet(localOneLocalsArray, localArrayList);
  }
  
  public void annotate(ExceptionWithContext paramExceptionWithContext)
  {
    paramExceptionWithContext.addContext("(locals array set; primary)");
    this.primary.annotate(paramExceptionWithContext);
    int j = this.secondaries.size();
    int i = 0;
    while (i < j)
    {
      LocalsArray localLocalsArray = (LocalsArray)this.secondaries.get(i);
      if (localLocalsArray != null)
      {
        paramExceptionWithContext.addContext("(locals array set: primary for caller " + Hex.u2(i) + ')');
        localLocalsArray.getPrimary().annotate(paramExceptionWithContext);
      }
      i += 1;
    }
  }
  
  public LocalsArray copy()
  {
    return new LocalsArraySet(this);
  }
  
  public TypeBearer get(int paramInt)
  {
    return this.primary.get(paramInt);
  }
  
  public TypeBearer getCategory1(int paramInt)
  {
    return this.primary.getCategory1(paramInt);
  }
  
  public TypeBearer getCategory2(int paramInt)
  {
    return this.primary.getCategory2(paramInt);
  }
  
  public int getMaxLocals()
  {
    return this.primary.getMaxLocals();
  }
  
  public TypeBearer getOrNull(int paramInt)
  {
    return this.primary.getOrNull(paramInt);
  }
  
  protected OneLocalsArray getPrimary()
  {
    return this.primary;
  }
  
  public void invalidate(int paramInt)
  {
    throwIfImmutable();
    this.primary.invalidate(paramInt);
    Iterator localIterator = this.secondaries.iterator();
    while (localIterator.hasNext())
    {
      LocalsArray localLocalsArray = (LocalsArray)localIterator.next();
      if (localLocalsArray != null) {
        localLocalsArray.invalidate(paramInt);
      }
    }
  }
  
  public void makeInitialized(Type paramType)
  {
    if (this.primary.getMaxLocals() == 0) {}
    for (;;)
    {
      return;
      throwIfImmutable();
      this.primary.makeInitialized(paramType);
      Iterator localIterator = this.secondaries.iterator();
      while (localIterator.hasNext())
      {
        LocalsArray localLocalsArray = (LocalsArray)localIterator.next();
        if (localLocalsArray != null) {
          localLocalsArray.makeInitialized(paramType);
        }
      }
    }
  }
  
  /* Error */
  public LocalsArraySet merge(LocalsArray paramLocalsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 2
    //   4: ifeq +20 -> 24
    //   7: aload_0
    //   8: aload_1
    //   9: checkcast 2	com/android/dx/cf/code/LocalsArraySet
    //   12: invokespecial 168	com/android/dx/cf/code/LocalsArraySet:mergeWithSet	(Lcom/android/dx/cf/code/LocalsArraySet;)Lcom/android/dx/cf/code/LocalsArraySet;
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 171	com/android/dx/cf/code/LocalsArraySet:setImmutable	()V
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: checkcast 16	com/android/dx/cf/code/OneLocalsArray
    //   29: invokespecial 173	com/android/dx/cf/code/LocalsArraySet:mergeWithOne	(Lcom/android/dx/cf/code/OneLocalsArray;)Lcom/android/dx/cf/code/LocalsArraySet;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: goto -17 -> 18
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 175
    //   42: invokevirtual 95	com/android/dx/cf/code/SimException:addContext	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 176	com/android/dx/cf/code/LocalsArraySet:annotate	(Lcom/android/dex/util/ExceptionWithContext;)V
    //   50: aload_2
    //   51: ldc 178
    //   53: invokevirtual 95	com/android/dx/cf/code/SimException:addContext	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 179	com/android/dx/cf/code/LocalsArray:annotate	(Lcom/android/dex/util/ExceptionWithContext;)V
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	LocalsArraySet
    //   0	63	1	paramLocalsArray	LocalsArray
    //   15	19	2	localLocalsArraySet	LocalsArraySet
    //   38	24	2	localSimException	SimException
    // Exception table:
    //   from	to	target	type
    //   0	16	38	com/android/dx/cf/code/SimException
    //   24	33	38	com/android/dx/cf/code/SimException
  }
  
  public LocalsArraySet mergeWithSubroutineCaller(LocalsArray paramLocalsArray, int paramInt)
  {
    Object localObject1 = getSecondaryForLabel(paramInt);
    Object localObject2 = this.primary.merge(paramLocalsArray.getPrimary());
    if (localObject1 == paramLocalsArray) {
      paramLocalsArray = (LocalsArray)localObject1;
    }
    while ((paramLocalsArray == localObject1) && (localObject2 == this.primary))
    {
      return this;
      if (localObject1 != null) {
        paramLocalsArray = ((LocalsArray)localObject1).merge(paramLocalsArray);
      }
    }
    int j = this.secondaries.size();
    int k = Math.max(paramInt + 1, j);
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    localObject1 = null;
    if (i < k) {
      if (i == paramInt) {
        localObject2 = paramLocalsArray;
      }
    }
    for (;;)
    {
      label113:
      if (localObject2 != null) {
        if (localObject1 == null) {
          localObject1 = ((LocalsArray)localObject2).getPrimary();
        }
      }
      for (;;)
      {
        localArrayList.add(localObject2);
        i += 1;
        break;
        if (i >= j) {
          break label203;
        }
        localObject2 = (LocalsArray)this.secondaries.get(i);
        break label113;
        localObject1 = ((OneLocalsArray)localObject1).merge(((LocalsArray)localObject2).getPrimary());
        continue;
        paramLocalsArray = new LocalsArraySet((OneLocalsArray)localObject1, localArrayList);
        paramLocalsArray.setImmutable();
        return paramLocalsArray;
      }
      label203:
      localObject2 = null;
    }
  }
  
  public void set(int paramInt, TypeBearer paramTypeBearer)
  {
    throwIfImmutable();
    this.primary.set(paramInt, paramTypeBearer);
    Iterator localIterator = this.secondaries.iterator();
    while (localIterator.hasNext())
    {
      LocalsArray localLocalsArray = (LocalsArray)localIterator.next();
      if (localLocalsArray != null) {
        localLocalsArray.set(paramInt, paramTypeBearer);
      }
    }
  }
  
  public void set(RegisterSpec paramRegisterSpec)
  {
    set(paramRegisterSpec.getReg(), paramRegisterSpec);
  }
  
  public void setImmutable()
  {
    this.primary.setImmutable();
    Iterator localIterator = this.secondaries.iterator();
    while (localIterator.hasNext())
    {
      LocalsArray localLocalsArray = (LocalsArray)localIterator.next();
      if (localLocalsArray != null) {
        localLocalsArray.setImmutable();
      }
    }
    super.setImmutable();
  }
  
  public LocalsArray subArrayForLabel(int paramInt)
  {
    return getSecondaryForLabel(paramInt);
  }
  
  public String toHuman()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(locals array set; primary)\n");
    localStringBuilder.append(getPrimary().toHuman());
    localStringBuilder.append('\n');
    int j = this.secondaries.size();
    int i = 0;
    while (i < j)
    {
      LocalsArray localLocalsArray = (LocalsArray)this.secondaries.get(i);
      if (localLocalsArray != null)
      {
        localStringBuilder.append("(locals array set: primary for caller " + Hex.u2(i) + ")\n");
        localStringBuilder.append(localLocalsArray.getPrimary().toHuman());
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.LocalsArraySet
 * JD-Core Version:    0.7.0.1
 */