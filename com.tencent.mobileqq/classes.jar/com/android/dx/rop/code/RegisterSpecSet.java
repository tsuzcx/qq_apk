package com.android.dx.rop.code;

import com.android.dx.util.MutabilityControl;

public final class RegisterSpecSet
  extends MutabilityControl
{
  public static final RegisterSpecSet EMPTY = new RegisterSpecSet(0);
  private int size;
  private final RegisterSpec[] specs;
  
  public RegisterSpecSet(int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RegisterSpecSet)) {}
    Object localObject1;
    int j;
    do
    {
      return false;
      localObject1 = (RegisterSpecSet)paramObject;
      paramObject = ((RegisterSpecSet)localObject1).specs;
      j = this.specs.length;
    } while ((j != paramObject.length) || (size() != ((RegisterSpecSet)localObject1).size()));
    int i = 0;
    label47:
    if (i < j)
    {
      localObject1 = this.specs[i];
      Object localObject2 = paramObject[i];
      if (localObject1 == localObject2) {}
      do
      {
        i += 1;
        break label47;
        if (localObject1 == null) {
          break;
        }
      } while (((RegisterSpec)localObject1).equals(localObject2));
      return false;
    }
    return true;
  }
  
  public RegisterSpec findMatchingLocal(RegisterSpec paramRegisterSpec)
  {
    int j = this.specs.length;
    int i = 0;
    if (i < j)
    {
      RegisterSpec localRegisterSpec = this.specs[i];
      if (localRegisterSpec == null) {}
      while (!paramRegisterSpec.matchesVariable(localRegisterSpec))
      {
        i += 1;
        break;
      }
      return localRegisterSpec;
    }
    return null;
  }
  
  public RegisterSpec get(int paramInt)
  {
    try
    {
      RegisterSpec localRegisterSpec = this.specs[paramInt];
      return localRegisterSpec;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("bogus reg");
    }
  }
  
  public RegisterSpec get(RegisterSpec paramRegisterSpec)
  {
    return get(paramRegisterSpec.getReg());
  }
  
  public int getMaxSize()
  {
    return this.specs.length;
  }
  
  public int hashCode()
  {
    int m = this.specs.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      RegisterSpec localRegisterSpec = this.specs[i];
      if (localRegisterSpec == null) {}
      for (int k = 0;; k = localRegisterSpec.hashCode())
      {
        j = j * 31 + k;
        i += 1;
        break;
      }
    }
    return j;
  }
  
  public void intersect(RegisterSpecSet paramRegisterSpecSet, boolean paramBoolean)
  {
    throwIfImmutable();
    paramRegisterSpecSet = paramRegisterSpecSet.specs;
    int m = this.specs.length;
    int k = Math.min(m, paramRegisterSpecSet.length);
    this.size = -1;
    int i = 0;
    int j = k;
    if (i < k)
    {
      RegisterSpec localRegisterSpec1 = this.specs[i];
      if (localRegisterSpec1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        RegisterSpec localRegisterSpec2 = localRegisterSpec1.intersect(paramRegisterSpecSet[i], paramBoolean);
        if (localRegisterSpec2 != localRegisterSpec1) {
          this.specs[i] = localRegisterSpec2;
        }
      }
    }
    while (j < m)
    {
      this.specs[j] = null;
      j += 1;
    }
  }
  
  public RegisterSpec localItemToSpec(LocalItem paramLocalItem)
  {
    int j = this.specs.length;
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = this.specs[i];
      if ((localRegisterSpec != null) && (paramLocalItem.equals(localRegisterSpec.getLocalItem()))) {
        return localRegisterSpec;
      }
      i += 1;
    }
    return null;
  }
  
  public RegisterSpecSet mutableCopy()
  {
    int j = this.specs.length;
    RegisterSpecSet localRegisterSpecSet = new RegisterSpecSet(j);
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = this.specs[i];
      if (localRegisterSpec != null) {
        localRegisterSpecSet.put(localRegisterSpec);
      }
      i += 1;
    }
    localRegisterSpecSet.size = this.size;
    return localRegisterSpecSet;
  }
  
  public void put(RegisterSpec paramRegisterSpec)
  {
    throwIfImmutable();
    if (paramRegisterSpec == null) {
      throw new NullPointerException("spec == null");
    }
    this.size = -1;
    try
    {
      int i = paramRegisterSpec.getReg();
      this.specs[i] = paramRegisterSpec;
      if (i > 0)
      {
        int j = i - 1;
        RegisterSpec localRegisterSpec = this.specs[j];
        if ((localRegisterSpec != null) && (localRegisterSpec.getCategory() == 2)) {
          this.specs[j] = null;
        }
      }
      if (paramRegisterSpec.getCategory() == 2) {
        this.specs[(i + 1)] = null;
      }
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramRegisterSpec)
    {
      throw new IllegalArgumentException("spec.getReg() out of range");
    }
  }
  
  public void putAll(RegisterSpecSet paramRegisterSpecSet)
  {
    int j = paramRegisterSpecSet.getMaxSize();
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = paramRegisterSpecSet.get(i);
      if (localRegisterSpec != null) {
        put(localRegisterSpec);
      }
      i += 1;
    }
  }
  
  public void remove(RegisterSpec paramRegisterSpec)
  {
    try
    {
      this.specs[paramRegisterSpec.getReg()] = null;
      this.size = -1;
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramRegisterSpec)
    {
      throw new IllegalArgumentException("bogus reg");
    }
  }
  
  public int size()
  {
    int j = 0;
    int k = this.size;
    int i = k;
    if (k < 0)
    {
      int m = this.specs.length;
      for (i = 0; j < m; i = k)
      {
        k = i;
        if (this.specs[j] != null) {
          k = i + 1;
        }
        j += 1;
      }
      this.size = i;
    }
    return i;
  }
  
  public String toString()
  {
    int i = 0;
    int m = this.specs.length;
    StringBuffer localStringBuffer = new StringBuffer(m * 25);
    localStringBuffer.append('{');
    int j = 0;
    if (j < m)
    {
      RegisterSpec localRegisterSpec = this.specs[j];
      int k = i;
      if (localRegisterSpec != null)
      {
        if (i == 0) {
          break label85;
        }
        localStringBuffer.append(", ");
      }
      for (;;)
      {
        localStringBuffer.append(localRegisterSpec);
        k = i;
        j += 1;
        i = k;
        break;
        label85:
        i = 1;
      }
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public RegisterSpecSet withOffset(int paramInt)
  {
    int j = this.specs.length;
    RegisterSpecSet localRegisterSpecSet = new RegisterSpecSet(j + paramInt);
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = this.specs[i];
      if (localRegisterSpec != null) {
        localRegisterSpecSet.put(localRegisterSpec.withOffset(paramInt));
      }
      i += 1;
    }
    localRegisterSpecSet.size = this.size;
    if (isImmutable()) {
      localRegisterSpecSet.setImmutable();
    }
    return localRegisterSpecSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.RegisterSpecSet
 * JD-Core Version:    0.7.0.1
 */