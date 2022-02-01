package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import com.android.dx.util.MutabilityControl;

public final class ExecutionStack
  extends MutabilityControl
{
  private final boolean[] local;
  private final TypeBearer[] stack;
  private int stackPtr;
  
  public ExecutionStack(int paramInt) {}
  
  private static String stackElementString(TypeBearer paramTypeBearer)
  {
    if (paramTypeBearer == null) {
      return "<invalid>";
    }
    return paramTypeBearer.toString();
  }
  
  private static TypeBearer throwSimException(String paramString)
  {
    throw new SimException("stack: " + paramString);
  }
  
  public void annotate(ExceptionWithContext paramExceptionWithContext)
  {
    int j = this.stackPtr - 1;
    int i = 0;
    if (i <= j)
    {
      if (i == j) {}
      for (String str = "top0";; str = Hex.u2(j - i))
      {
        paramExceptionWithContext.addContext("stack[" + str + "]: " + stackElementString(this.stack[i]));
        i += 1;
        break;
      }
    }
  }
  
  public void change(int paramInt, TypeBearer paramTypeBearer)
  {
    throwIfImmutable();
    try
    {
      paramTypeBearer = paramTypeBearer.getFrameType();
      paramInt = this.stackPtr - paramInt - 1;
      TypeBearer localTypeBearer = this.stack[paramInt];
      if ((localTypeBearer == null) || (localTypeBearer.getType().getCategory() != paramTypeBearer.getType().getCategory())) {
        throwSimException("incompatible substitution: " + stackElementString(localTypeBearer) + " -> " + stackElementString(paramTypeBearer));
      }
      this.stack[paramInt] = paramTypeBearer;
      return;
    }
    catch (NullPointerException paramTypeBearer)
    {
      throw new NullPointerException("type == null");
    }
  }
  
  public void clear()
  {
    throwIfImmutable();
    int i = 0;
    while (i < this.stackPtr)
    {
      this.stack[i] = null;
      this.local[i] = false;
      i += 1;
    }
    this.stackPtr = 0;
  }
  
  public ExecutionStack copy()
  {
    ExecutionStack localExecutionStack = new ExecutionStack(this.stack.length);
    System.arraycopy(this.stack, 0, localExecutionStack.stack, 0, this.stack.length);
    System.arraycopy(this.local, 0, localExecutionStack.local, 0, this.local.length);
    localExecutionStack.stackPtr = this.stackPtr;
    return localExecutionStack;
  }
  
  public int getMaxStack()
  {
    return this.stack.length;
  }
  
  public void makeInitialized(Type paramType)
  {
    if (this.stackPtr == 0) {}
    for (;;)
    {
      return;
      throwIfImmutable();
      Type localType = paramType.getInitializedType();
      int i = 0;
      while (i < this.stackPtr)
      {
        if (this.stack[i] == paramType) {
          this.stack[i] = localType;
        }
        i += 1;
      }
    }
  }
  
  public ExecutionStack merge(ExecutionStack paramExecutionStack)
  {
    try
    {
      ExecutionStack localExecutionStack = Merger.mergeStack(this, paramExecutionStack);
      return localExecutionStack;
    }
    catch (SimException localSimException)
    {
      localSimException.addContext("underlay stack:");
      annotate(localSimException);
      localSimException.addContext("overlay stack:");
      paramExecutionStack.annotate(localSimException);
      throw localSimException;
    }
  }
  
  public TypeBearer peek(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("n < 0");
    }
    if (paramInt >= this.stackPtr) {
      return throwSimException("underflow");
    }
    return this.stack[(this.stackPtr - paramInt - 1)];
  }
  
  public boolean peekLocal(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("n < 0");
    }
    if (paramInt >= this.stackPtr) {
      throw new SimException("stack: underflow");
    }
    return this.local[(this.stackPtr - paramInt - 1)];
  }
  
  public Type peekType(int paramInt)
  {
    return peek(paramInt).getType();
  }
  
  public TypeBearer pop()
  {
    throwIfImmutable();
    TypeBearer localTypeBearer = peek(0);
    this.stack[(this.stackPtr - 1)] = null;
    this.local[(this.stackPtr - 1)] = false;
    this.stackPtr -= localTypeBearer.getType().getCategory();
    return localTypeBearer;
  }
  
  public void push(TypeBearer paramTypeBearer)
  {
    throwIfImmutable();
    int i;
    try
    {
      paramTypeBearer = paramTypeBearer.getFrameType();
      i = paramTypeBearer.getType().getCategory();
      if (this.stackPtr + i > this.stack.length)
      {
        throwSimException("overflow");
        return;
      }
    }
    catch (NullPointerException paramTypeBearer)
    {
      throw new NullPointerException("type == null");
    }
    if (i == 2)
    {
      this.stack[this.stackPtr] = null;
      this.stackPtr += 1;
    }
    this.stack[this.stackPtr] = paramTypeBearer;
    this.stackPtr += 1;
  }
  
  public void setLocal()
  {
    throwIfImmutable();
    this.local[this.stackPtr] = true;
  }
  
  public int size()
  {
    return this.stackPtr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ExecutionStack
 * JD-Core Version:    0.7.0.1
 */