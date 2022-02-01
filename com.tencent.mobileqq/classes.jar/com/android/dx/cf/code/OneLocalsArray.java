package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;

public class OneLocalsArray
  extends LocalsArray
{
  private final TypeBearer[] locals;
  
  public OneLocalsArray(int paramInt) {}
  
  private static TypeBearer throwSimException(int paramInt, String paramString)
  {
    throw new SimException("local " + Hex.u2(paramInt) + ": " + paramString);
  }
  
  public void annotate(ExceptionWithContext paramExceptionWithContext)
  {
    int i = 0;
    if (i < this.locals.length)
    {
      Object localObject = this.locals[i];
      if (localObject == null) {}
      for (localObject = "<invalid>";; localObject = localObject.toString())
      {
        paramExceptionWithContext.addContext("locals[" + Hex.u2(i) + "]: " + (String)localObject);
        i += 1;
        break;
      }
    }
  }
  
  public OneLocalsArray copy()
  {
    OneLocalsArray localOneLocalsArray = new OneLocalsArray(this.locals.length);
    System.arraycopy(this.locals, 0, localOneLocalsArray.locals, 0, this.locals.length);
    return localOneLocalsArray;
  }
  
  public TypeBearer get(int paramInt)
  {
    TypeBearer localTypeBearer2 = this.locals[paramInt];
    TypeBearer localTypeBearer1 = localTypeBearer2;
    if (localTypeBearer2 == null) {
      localTypeBearer1 = throwSimException(paramInt, "invalid");
    }
    return localTypeBearer1;
  }
  
  public TypeBearer getCategory1(int paramInt)
  {
    TypeBearer localTypeBearer = get(paramInt);
    Type localType = localTypeBearer.getType();
    if (localType.isUninitialized()) {
      localTypeBearer = throwSimException(paramInt, "uninitialized instance");
    }
    while (!localType.isCategory2()) {
      return localTypeBearer;
    }
    return throwSimException(paramInt, "category-2");
  }
  
  public TypeBearer getCategory2(int paramInt)
  {
    TypeBearer localTypeBearer2 = get(paramInt);
    TypeBearer localTypeBearer1 = localTypeBearer2;
    if (localTypeBearer2.getType().isCategory1()) {
      localTypeBearer1 = throwSimException(paramInt, "category-1");
    }
    return localTypeBearer1;
  }
  
  public int getMaxLocals()
  {
    return this.locals.length;
  }
  
  public TypeBearer getOrNull(int paramInt)
  {
    return this.locals[paramInt];
  }
  
  protected OneLocalsArray getPrimary()
  {
    return this;
  }
  
  public void invalidate(int paramInt)
  {
    throwIfImmutable();
    this.locals[paramInt] = null;
  }
  
  public void makeInitialized(Type paramType)
  {
    int j = this.locals.length;
    if (j == 0) {}
    for (;;)
    {
      return;
      throwIfImmutable();
      Type localType = paramType.getInitializedType();
      int i = 0;
      while (i < j)
      {
        if (this.locals[i] == paramType) {
          this.locals[i] = localType;
        }
        i += 1;
      }
    }
  }
  
  public LocalsArray merge(LocalsArray paramLocalsArray)
  {
    if ((paramLocalsArray instanceof OneLocalsArray)) {
      return merge((OneLocalsArray)paramLocalsArray);
    }
    return paramLocalsArray.merge(this);
  }
  
  public OneLocalsArray merge(OneLocalsArray paramOneLocalsArray)
  {
    try
    {
      OneLocalsArray localOneLocalsArray = Merger.mergeLocals(this, paramOneLocalsArray);
      return localOneLocalsArray;
    }
    catch (SimException localSimException)
    {
      localSimException.addContext("underlay locals:");
      annotate(localSimException);
      localSimException.addContext("overlay locals:");
      paramOneLocalsArray.annotate(localSimException);
      throw localSimException;
    }
  }
  
  public LocalsArraySet mergeWithSubroutineCaller(LocalsArray paramLocalsArray, int paramInt)
  {
    return new LocalsArraySet(getMaxLocals()).mergeWithSubroutineCaller(paramLocalsArray, paramInt);
  }
  
  public void set(int paramInt, TypeBearer paramTypeBearer)
  {
    throwIfImmutable();
    try
    {
      paramTypeBearer = paramTypeBearer.getFrameType();
      if (paramInt < 0) {
        throw new IndexOutOfBoundsException("idx < 0");
      }
    }
    catch (NullPointerException paramTypeBearer)
    {
      throw new NullPointerException("type == null");
    }
    if (paramTypeBearer.getType().isCategory2()) {
      this.locals[(paramInt + 1)] = null;
    }
    this.locals[paramInt] = paramTypeBearer;
    if (paramInt != 0)
    {
      paramTypeBearer = this.locals[(paramInt - 1)];
      if ((paramTypeBearer != null) && (paramTypeBearer.getType().isCategory2())) {
        this.locals[(paramInt - 1)] = null;
      }
    }
  }
  
  public void set(RegisterSpec paramRegisterSpec)
  {
    set(paramRegisterSpec.getReg(), paramRegisterSpec);
  }
  
  public String toHuman()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.locals.length)
    {
      Object localObject = this.locals[i];
      if (localObject == null) {}
      for (localObject = "<invalid>";; localObject = localObject.toString())
      {
        localStringBuilder.append("locals[" + Hex.u2(i) + "]: " + (String)localObject + "\n");
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.OneLocalsArray
 * JD-Core Version:    0.7.0.1
 */