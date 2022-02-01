package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import java.util.ArrayList;

public abstract class BaseMachine
  implements Machine
{
  private int argCount;
  private TypeBearer[] args;
  private SwitchList auxCases;
  private Constant auxCst;
  private ArrayList<Constant> auxInitValues;
  private int auxInt;
  private int auxTarget;
  private Type auxType;
  private int localIndex;
  private boolean localInfo;
  private RegisterSpec localTarget;
  private final Prototype prototype;
  private int resultCount;
  private TypeBearer[] results;
  
  public BaseMachine(Prototype paramPrototype)
  {
    if (paramPrototype == null) {
      throw new NullPointerException("prototype == null");
    }
    this.prototype = paramPrototype;
    this.args = new TypeBearer[10];
    this.results = new TypeBearer[6];
    clearArgs();
  }
  
  public static void throwLocalMismatch(TypeBearer paramTypeBearer1, TypeBearer paramTypeBearer2)
  {
    throw new SimException("local variable type mismatch: attempt to set or access a value of type " + paramTypeBearer1.toHuman() + " using a local variable of type " + paramTypeBearer2.toHuman() + ". This is symptomatic of .class transformation tools that ignore local variable information.");
  }
  
  protected final void addResult(TypeBearer paramTypeBearer)
  {
    if (paramTypeBearer == null) {
      throw new NullPointerException("result == null");
    }
    this.results[this.resultCount] = paramTypeBearer;
    this.resultCount += 1;
  }
  
  protected final TypeBearer arg(int paramInt)
  {
    if (paramInt >= this.argCount) {
      throw new IllegalArgumentException("n >= argCount");
    }
    try
    {
      TypeBearer localTypeBearer = this.args[paramInt];
      return localTypeBearer;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("n < 0");
    }
  }
  
  protected final int argCount()
  {
    return this.argCount;
  }
  
  protected final int argWidth()
  {
    int i = 0;
    int j = 0;
    while (i < this.argCount)
    {
      j += this.args[i].getType().getCategory();
      i += 1;
    }
    return j;
  }
  
  public final void auxCstArg(Constant paramConstant)
  {
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    this.auxCst = paramConstant;
  }
  
  public final void auxInitValues(ArrayList<Constant> paramArrayList)
  {
    this.auxInitValues = paramArrayList;
  }
  
  public final void auxIntArg(int paramInt)
  {
    this.auxInt = paramInt;
  }
  
  public final void auxSwitchArg(SwitchList paramSwitchList)
  {
    if (paramSwitchList == null) {
      throw new NullPointerException("cases == null");
    }
    this.auxCases = paramSwitchList;
  }
  
  public final void auxTargetArg(int paramInt)
  {
    this.auxTarget = paramInt;
  }
  
  public final void auxType(Type paramType)
  {
    this.auxType = paramType;
  }
  
  public final void clearArgs()
  {
    this.argCount = 0;
    this.auxType = null;
    this.auxInt = 0;
    this.auxCst = null;
    this.auxTarget = 0;
    this.auxCases = null;
    this.auxInitValues = null;
    this.localIndex = -1;
    this.localInfo = false;
    this.localTarget = null;
    this.resultCount = -1;
  }
  
  protected final void clearResult()
  {
    this.resultCount = 0;
  }
  
  protected final SwitchList getAuxCases()
  {
    return this.auxCases;
  }
  
  protected final Constant getAuxCst()
  {
    return this.auxCst;
  }
  
  protected final int getAuxInt()
  {
    return this.auxInt;
  }
  
  protected final int getAuxTarget()
  {
    return this.auxTarget;
  }
  
  protected final Type getAuxType()
  {
    return this.auxType;
  }
  
  protected final ArrayList<Constant> getInitValues()
  {
    return this.auxInitValues;
  }
  
  protected final int getLocalIndex()
  {
    return this.localIndex;
  }
  
  protected final boolean getLocalInfo()
  {
    return this.localInfo;
  }
  
  protected final RegisterSpec getLocalTarget(boolean paramBoolean)
  {
    if (this.localTarget == null) {
      return null;
    }
    if (this.resultCount != 1)
    {
      localObject2 = new StringBuilder().append("local target with ");
      if (this.resultCount == 0) {}
      for (localObject1 = "no";; localObject1 = "multiple") {
        throw new SimException((String)localObject1 + " results");
      }
    }
    Object localObject1 = this.results[0];
    Object localObject2 = ((TypeBearer)localObject1).getType();
    Type localType = this.localTarget.getType();
    if (localObject2 == localType)
    {
      if (paramBoolean) {
        return this.localTarget.withType((TypeBearer)localObject1);
      }
      return this.localTarget;
    }
    if (!Merger.isPossiblyAssignableFrom(localType, (TypeBearer)localObject2))
    {
      throwLocalMismatch((TypeBearer)localObject2, localType);
      return null;
    }
    if (localType == Type.OBJECT) {
      this.localTarget = this.localTarget.withType((TypeBearer)localObject1);
    }
    return this.localTarget;
  }
  
  public Prototype getPrototype()
  {
    return this.prototype;
  }
  
  public final void localArg(Frame paramFrame, int paramInt)
  {
    clearArgs();
    this.args[0] = paramFrame.getLocals().get(paramInt);
    this.argCount = 1;
    this.localIndex = paramInt;
  }
  
  public final void localInfo(boolean paramBoolean)
  {
    this.localInfo = paramBoolean;
  }
  
  public final void localTarget(int paramInt, Type paramType, LocalItem paramLocalItem)
  {
    this.localTarget = RegisterSpec.makeLocalOptional(paramInt, paramType, paramLocalItem);
  }
  
  public final void popArgs(Frame paramFrame, int paramInt)
  {
    paramFrame = paramFrame.getStack();
    clearArgs();
    if (paramInt > this.args.length) {
      this.args = new TypeBearer[paramInt + 10];
    }
    int i = paramInt - 1;
    while (i >= 0)
    {
      this.args[i] = paramFrame.pop();
      i -= 1;
    }
    this.argCount = paramInt;
  }
  
  public void popArgs(Frame paramFrame, Prototype paramPrototype)
  {
    paramPrototype = paramPrototype.getParameterTypes();
    int j = paramPrototype.size();
    popArgs(paramFrame, j);
    int i = 0;
    while (i < j)
    {
      if (!Merger.isPossiblyAssignableFrom(paramPrototype.getType(i), this.args[i])) {
        throw new SimException("at stack depth " + (j - 1 - i) + ", expected type " + paramPrototype.getType(i).toHuman() + " but found " + this.args[i].getType().toHuman());
      }
      i += 1;
    }
  }
  
  public final void popArgs(Frame paramFrame, Type paramType)
  {
    popArgs(paramFrame, 1);
    if (!Merger.isPossiblyAssignableFrom(paramType, this.args[0])) {
      throw new SimException("expected type " + paramType.toHuman() + " but found " + this.args[0].getType().toHuman());
    }
  }
  
  public final void popArgs(Frame paramFrame, Type paramType1, Type paramType2)
  {
    popArgs(paramFrame, 2);
    if (!Merger.isPossiblyAssignableFrom(paramType1, this.args[0])) {
      throw new SimException("expected type " + paramType1.toHuman() + " but found " + this.args[0].getType().toHuman());
    }
    if (!Merger.isPossiblyAssignableFrom(paramType2, this.args[1])) {
      throw new SimException("expected type " + paramType2.toHuman() + " but found " + this.args[1].getType().toHuman());
    }
  }
  
  public final void popArgs(Frame paramFrame, Type paramType1, Type paramType2, Type paramType3)
  {
    popArgs(paramFrame, 3);
    if (!Merger.isPossiblyAssignableFrom(paramType1, this.args[0])) {
      throw new SimException("expected type " + paramType1.toHuman() + " but found " + this.args[0].getType().toHuman());
    }
    if (!Merger.isPossiblyAssignableFrom(paramType2, this.args[1])) {
      throw new SimException("expected type " + paramType2.toHuman() + " but found " + this.args[1].getType().toHuman());
    }
    if (!Merger.isPossiblyAssignableFrom(paramType3, this.args[2])) {
      throw new SimException("expected type " + paramType3.toHuman() + " but found " + this.args[2].getType().toHuman());
    }
  }
  
  protected final TypeBearer result(int paramInt)
  {
    if (paramInt >= this.resultCount) {
      throw new IllegalArgumentException("n >= resultCount");
    }
    try
    {
      TypeBearer localTypeBearer = this.results[paramInt];
      return localTypeBearer;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IllegalArgumentException("n < 0");
    }
  }
  
  protected final int resultCount()
  {
    if (this.resultCount < 0) {
      throw new SimException("results never set");
    }
    return this.resultCount;
  }
  
  protected final int resultWidth()
  {
    int i = 0;
    int j = 0;
    while (i < this.resultCount)
    {
      j += this.results[i].getType().getCategory();
      i += 1;
    }
    return j;
  }
  
  protected final void setResult(TypeBearer paramTypeBearer)
  {
    if (paramTypeBearer == null) {
      throw new NullPointerException("result == null");
    }
    this.results[0] = paramTypeBearer;
    this.resultCount = 1;
  }
  
  protected final void storeResults(Frame paramFrame)
  {
    int i = 0;
    if (this.resultCount < 0) {
      throw new SimException("results never set");
    }
    if (this.resultCount == 0) {}
    for (;;)
    {
      return;
      if (this.localTarget != null)
      {
        paramFrame.getLocals().set(getLocalTarget(false));
        return;
      }
      paramFrame = paramFrame.getStack();
      while (i < this.resultCount)
      {
        if (this.localInfo) {
          paramFrame.setLocal();
        }
        paramFrame.push(this.results[i]);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.BaseMachine
 * JD-Core Version:    0.7.0.1
 */