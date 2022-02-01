package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.IntList;

public final class Frame
{
  private final LocalsArray locals;
  private final ExecutionStack stack;
  private final IntList subroutines;
  
  public Frame(int paramInt1, int paramInt2)
  {
    this(new OneLocalsArray(paramInt1), new ExecutionStack(paramInt2));
  }
  
  private Frame(LocalsArray paramLocalsArray, ExecutionStack paramExecutionStack)
  {
    this(paramLocalsArray, paramExecutionStack, IntList.EMPTY);
  }
  
  private Frame(LocalsArray paramLocalsArray, ExecutionStack paramExecutionStack, IntList paramIntList)
  {
    if (paramLocalsArray == null) {
      throw new NullPointerException("locals == null");
    }
    if (paramExecutionStack == null) {
      throw new NullPointerException("stack == null");
    }
    paramIntList.throwIfMutable();
    this.locals = paramLocalsArray;
    this.stack = paramExecutionStack;
    this.subroutines = paramIntList;
  }
  
  private static LocalsArray adjustLocalsForSubroutines(LocalsArray paramLocalsArray, IntList paramIntList)
  {
    if (!(paramLocalsArray instanceof LocalsArraySet)) {}
    LocalsArraySet localLocalsArraySet;
    do
    {
      return paramLocalsArray;
      localLocalsArraySet = (LocalsArraySet)paramLocalsArray;
      paramLocalsArray = localLocalsArraySet;
    } while (paramIntList.size() != 0);
    return localLocalsArraySet.getPrimary();
  }
  
  private IntList mergeSubroutineLists(IntList paramIntList)
  {
    if (this.subroutines.equals(paramIntList)) {
      return this.subroutines;
    }
    IntList localIntList = new IntList();
    int j = this.subroutines.size();
    int k = paramIntList.size();
    int i = 0;
    while ((i < j) && (i < k) && (this.subroutines.get(i) == paramIntList.get(i)))
    {
      localIntList.add(i);
      i += 1;
    }
    localIntList.setImmutable();
    return localIntList;
  }
  
  public void annotate(ExceptionWithContext paramExceptionWithContext)
  {
    this.locals.annotate(paramExceptionWithContext);
    this.stack.annotate(paramExceptionWithContext);
  }
  
  public Frame copy()
  {
    return new Frame(this.locals.copy(), this.stack.copy(), this.subroutines);
  }
  
  public LocalsArray getLocals()
  {
    return this.locals;
  }
  
  public ExecutionStack getStack()
  {
    return this.stack;
  }
  
  public IntList getSubroutines()
  {
    return this.subroutines;
  }
  
  public void initializeWithParameters(StdTypeList paramStdTypeList)
  {
    int i = 0;
    int k = paramStdTypeList.size();
    int j = 0;
    while (i < k)
    {
      Type localType = paramStdTypeList.get(i);
      this.locals.set(j, localType);
      j += localType.getCategory();
      i += 1;
    }
  }
  
  public Frame makeExceptionHandlerStartFrame(CstType paramCstType)
  {
    ExecutionStack localExecutionStack = getStack().copy();
    localExecutionStack.clear();
    localExecutionStack.push(paramCstType);
    return new Frame(getLocals(), localExecutionStack, this.subroutines);
  }
  
  public void makeInitialized(Type paramType)
  {
    this.locals.makeInitialized(paramType);
    this.stack.makeInitialized(paramType);
  }
  
  public Frame makeNewSubroutineStartFrame(int paramInt1, int paramInt2)
  {
    this.subroutines.mutableCopy().add(paramInt1);
    return new Frame(this.locals.getPrimary(), this.stack, IntList.makeImmutable(paramInt1)).mergeWithSubroutineCaller(this, paramInt1, paramInt2);
  }
  
  public Frame mergeWith(Frame paramFrame)
  {
    LocalsArray localLocalsArray = getLocals().merge(paramFrame.getLocals());
    ExecutionStack localExecutionStack = getStack().merge(paramFrame.getStack());
    paramFrame = mergeSubroutineLists(paramFrame.subroutines);
    localLocalsArray = adjustLocalsForSubroutines(localLocalsArray, paramFrame);
    if ((localLocalsArray == getLocals()) && (localExecutionStack == getStack()) && (this.subroutines == paramFrame)) {
      return this;
    }
    return new Frame(localLocalsArray, localExecutionStack, paramFrame);
  }
  
  public Frame mergeWithSubroutineCaller(Frame paramFrame, int paramInt1, int paramInt2)
  {
    LocalsArraySet localLocalsArraySet = getLocals().mergeWithSubroutineCaller(paramFrame.getLocals(), paramInt2);
    ExecutionStack localExecutionStack = getStack().merge(paramFrame.getStack());
    Object localObject1 = paramFrame.subroutines.mutableCopy();
    ((IntList)localObject1).add(paramInt1);
    ((IntList)localObject1).setImmutable();
    if ((localLocalsArraySet == getLocals()) && (localExecutionStack == getStack()) && (this.subroutines.equals(localObject1))) {
      return this;
    }
    Object localObject2;
    if (this.subroutines.equals(localObject1))
    {
      localObject2 = this.subroutines;
      return new Frame(localLocalsArraySet, localExecutionStack, (IntList)localObject2);
    }
    label131:
    int i;
    if (this.subroutines.size() > ((IntList)localObject1).size())
    {
      paramFrame = this.subroutines;
      paramInt2 = paramFrame.size();
      i = ((IntList)localObject1).size();
      paramInt1 = i - 1;
    }
    for (;;)
    {
      localObject2 = paramFrame;
      if (paramInt1 < 0) {
        break;
      }
      if (((IntList)localObject1).get(paramInt1) != paramFrame.get(paramInt2 - i + paramInt1))
      {
        throw new RuntimeException("Incompatible merged subroutines");
        localObject2 = this.subroutines;
        paramFrame = (Frame)localObject1;
        localObject1 = localObject2;
        break label131;
      }
      paramInt1 -= 1;
    }
  }
  
  public void setImmutable()
  {
    this.locals.setImmutable();
    this.stack.setImmutable();
  }
  
  public Frame subFrameForLabel(int paramInt1, int paramInt2)
  {
    if ((this.locals instanceof LocalsArraySet)) {}
    Object localObject;
    for (LocalsArray localLocalsArray = ((LocalsArraySet)this.locals).subArrayForLabel(paramInt2);; localObject = null)
    {
      IntList localIntList;
      try
      {
        localIntList = this.subroutines.mutableCopy();
        if (localIntList.pop() != paramInt1) {
          throw new RuntimeException("returning from invalid subroutine");
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new RuntimeException("returning from invalid subroutine");
        localIntList.setImmutable();
        if (localIndexOutOfBoundsException == null) {
          return null;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        throw new NullPointerException("can't return from non-subroutine");
      }
      return new Frame(localNullPointerException, this.stack, localIntList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Frame
 * JD-Core Version:    0.7.0.1
 */