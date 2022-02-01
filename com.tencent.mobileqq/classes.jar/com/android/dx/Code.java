package com.android.dx;

import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Code
{
  private final List<Label> catchLabels = new ArrayList();
  private final List<TypeId<?>> catchTypes = new ArrayList();
  private StdTypeList catches = StdTypeList.EMPTY;
  private Label currentLabel;
  private final List<Label> labels = new ArrayList();
  private final List<Local<?>> locals = new ArrayList();
  private boolean localsInitialized;
  private final MethodId<?, ?> method;
  private final List<Local<?>> parameters = new ArrayList();
  private SourcePosition sourcePosition = SourcePosition.NO_INFO;
  private final Local<?> thisLocal;
  
  Code(DexMaker.MethodDeclaration paramMethodDeclaration)
  {
    this.method = paramMethodDeclaration.method;
    if (paramMethodDeclaration.isStatic()) {
      this.thisLocal = null;
    }
    for (;;)
    {
      paramMethodDeclaration = this.method.parameters.types;
      int j = paramMethodDeclaration.length;
      int i = 0;
      while (i < j)
      {
        TypeId localTypeId = paramMethodDeclaration[i];
        this.parameters.add(Local.get(this, localTypeId));
        i += 1;
      }
      this.thisLocal = Local.get(this, this.method.declaringType);
      this.parameters.add(this.thisLocal);
    }
    this.currentLabel = new Label();
    adopt(this.currentLabel);
    this.currentLabel.marked = true;
  }
  
  private void addInstruction(Insn paramInsn)
  {
    addInstruction(paramInsn, null);
  }
  
  private void addInstruction(Insn paramInsn, Label paramLabel)
  {
    if ((this.currentLabel == null) || (!this.currentLabel.marked)) {
      throw new IllegalStateException("no current label");
    }
    this.currentLabel.instructions.add(paramInsn);
    switch (paramInsn.getOpcode().getBranchingness())
    {
    case 5: 
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if (paramLabel != null) {
        throw new IllegalArgumentException("unexpected branch: " + paramLabel);
      }
    case 2: 
      if (paramLabel != null) {
        throw new IllegalArgumentException("unexpected branch: " + paramLabel);
      }
      this.currentLabel = null;
      return;
    case 3: 
      if (paramLabel == null) {
        throw new IllegalArgumentException("branch == null");
      }
      this.currentLabel.primarySuccessor = paramLabel;
      this.currentLabel = null;
      return;
    case 4: 
      if (paramLabel == null) {
        throw new IllegalArgumentException("branch == null");
      }
      splitCurrentLabel(paramLabel, Collections.emptyList());
      return;
    }
    if (paramLabel != null) {
      throw new IllegalArgumentException("unexpected branch: " + paramLabel);
    }
    splitCurrentLabel(null, new ArrayList(this.catchLabels));
  }
  
  private void adopt(Label paramLabel)
  {
    if (paramLabel.code == this) {
      return;
    }
    if (paramLabel.code != null) {
      throw new IllegalArgumentException("Cannot adopt label; it belongs to another Code");
    }
    paramLabel.code = this;
    this.labels.add(paramLabel);
  }
  
  private void cleanUpLabels()
  {
    Iterator localIterator = this.labels.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel.isEmpty()) {
        localIterator.remove();
      }
      for (;;)
      {
        break;
        localLabel.compact();
        localLabel.id = i;
        i += 1;
      }
    }
  }
  
  private <T> Local<T> coerce(Local<?> paramLocal, TypeId<T> paramTypeId)
  {
    if (!paramLocal.type.equals(paramTypeId)) {
      throw new IllegalArgumentException("requested " + paramTypeId + " but was " + paramLocal.type);
    }
    return paramLocal;
  }
  
  private static RegisterSpecList concatenate(Local<?> paramLocal, Local<?>[] paramArrayOfLocal)
  {
    int k = 0;
    if (paramLocal != null) {}
    RegisterSpecList localRegisterSpecList;
    for (int i = 1;; i = 0)
    {
      localRegisterSpecList = new RegisterSpecList(paramArrayOfLocal.length + i);
      int j = k;
      if (paramLocal != null)
      {
        localRegisterSpecList.set(0, paramLocal.spec());
        j = k;
      }
      while (j < paramArrayOfLocal.length)
      {
        localRegisterSpecList.set(j + i, paramArrayOfLocal[j].spec());
        j += 1;
      }
    }
    return localRegisterSpecList;
  }
  
  private Rop getCastRop(Type paramType1, Type paramType2)
  {
    if (paramType1.getBasicType() == 6) {}
    switch (paramType2.getBasicType())
    {
    default: 
      return Rops.opConv(paramType2, paramType1);
    case 8: 
      return Rops.TO_SHORT;
    case 3: 
      return Rops.TO_CHAR;
    }
    return Rops.TO_BYTE;
  }
  
  private <D, R> void invoke(Rop paramRop, MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>... paramVarArgs)
  {
    addInstruction(new ThrowingCstInsn(paramRop, this.sourcePosition, concatenate(paramLocal1, paramVarArgs), this.catches, paramMethodId.constant));
    if (paramLocal != null) {
      moveResult(paramLocal, false);
    }
  }
  
  private void moveResult(Local<?> paramLocal, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Rop localRop = Rops.opMoveResultPseudo(paramLocal.type.ropType);; localRop = Rops.opMoveResult(paramLocal.type.ropType))
    {
      addInstruction(new PlainInsn(localRop, this.sourcePosition, paramLocal.spec(), RegisterSpecList.EMPTY));
      return;
    }
  }
  
  private void splitCurrentLabel(Label paramLabel, List<Label> paramList)
  {
    Label localLabel = new Label();
    adopt(localLabel);
    this.currentLabel.primarySuccessor = localLabel;
    this.currentLabel.alternateSuccessor = paramLabel;
    this.currentLabel.catchLabels = paramList;
    this.currentLabel = localLabel;
    this.currentLabel.marked = true;
  }
  
  private StdTypeList toTypeList(List<TypeId<?>> paramList)
  {
    StdTypeList localStdTypeList = new StdTypeList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      localStdTypeList.set(i, ((TypeId)paramList.get(i)).ropType);
      i += 1;
    }
    return localStdTypeList;
  }
  
  public void addCatchClause(TypeId<? extends Throwable> paramTypeId, Label paramLabel)
  {
    if (this.catchTypes.contains(paramTypeId)) {
      throw new IllegalArgumentException("Already caught: " + paramTypeId);
    }
    adopt(paramLabel);
    this.catchTypes.add(paramTypeId);
    this.catches = toTypeList(this.catchTypes);
    this.catchLabels.add(paramLabel);
  }
  
  public void aget(Local<?> paramLocal1, Local<?> paramLocal2, Local<Integer> paramLocal)
  {
    addInstruction(new ThrowingInsn(Rops.opAget(paramLocal1.type.ropType), this.sourcePosition, RegisterSpecList.make(paramLocal2.spec(), paramLocal.spec()), this.catches));
    moveResult(paramLocal1, true);
  }
  
  public void aput(Local<?> paramLocal1, Local<Integer> paramLocal, Local<?> paramLocal2)
  {
    addInstruction(new ThrowingInsn(Rops.opAput(paramLocal2.type.ropType), this.sourcePosition, RegisterSpecList.make(paramLocal2.spec(), paramLocal1.spec(), paramLocal.spec()), this.catches));
  }
  
  public <T> void arrayLength(Local<Integer> paramLocal, Local<T> paramLocal1)
  {
    addInstruction(new ThrowingInsn(Rops.ARRAY_LENGTH, this.sourcePosition, RegisterSpecList.make(paramLocal1.spec()), this.catches));
    moveResult(paramLocal, true);
  }
  
  public void cast(Local<?> paramLocal1, Local<?> paramLocal2)
  {
    if (paramLocal2.getType().ropType.isReference())
    {
      addInstruction(new ThrowingCstInsn(Rops.CHECK_CAST, this.sourcePosition, RegisterSpecList.make(paramLocal2.spec()), this.catches, paramLocal1.type.constant));
      moveResult(paramLocal1, true);
      return;
    }
    addInstruction(new PlainInsn(getCastRop(paramLocal2.type.ropType, paramLocal1.type.ropType), this.sourcePosition, paramLocal1.spec(), paramLocal2.spec()));
  }
  
  public <T> void compare(Comparison paramComparison, Label paramLabel, Local<T> paramLocal1, Local<T> paramLocal2)
  {
    adopt(paramLabel);
    addInstruction(new PlainInsn(paramComparison.rop(StdTypeList.make(paramLocal1.type.ropType, paramLocal2.type.ropType)), this.sourcePosition, null, RegisterSpecList.make(paramLocal1.spec(), paramLocal2.spec())), paramLabel);
  }
  
  public <T extends Number> void compareFloatingPoint(Local<Integer> paramLocal, Local<T> paramLocal1, Local<T> paramLocal2, int paramInt)
  {
    if (paramInt == 1) {}
    for (Rop localRop = Rops.opCmpg(paramLocal1.type.ropType);; localRop = Rops.opCmpl(paramLocal1.type.ropType))
    {
      addInstruction(new PlainInsn(localRop, this.sourcePosition, paramLocal.spec(), RegisterSpecList.make(paramLocal1.spec(), paramLocal2.spec())));
      return;
      if (paramInt != -1) {
        break;
      }
    }
    throw new IllegalArgumentException("expected 1 or -1 but was " + paramInt);
  }
  
  public void compareLongs(Local<Integer> paramLocal, Local<Long> paramLocal1, Local<Long> paramLocal2)
  {
    addInstruction(new PlainInsn(Rops.CMPL_LONG, this.sourcePosition, paramLocal.spec(), RegisterSpecList.make(paramLocal1.spec(), paramLocal2.spec())));
  }
  
  public <T> void compareZ(Comparison paramComparison, Label paramLabel, Local<?> paramLocal)
  {
    adopt(paramLabel);
    addInstruction(new PlainInsn(paramComparison.rop(StdTypeList.make(paramLocal.type.ropType)), this.sourcePosition, null, RegisterSpecList.make(paramLocal.spec())), paramLabel);
  }
  
  public <T> Local<T> getParameter(int paramInt, TypeId<T> paramTypeId)
  {
    int i = paramInt;
    if (this.thisLocal != null) {
      i = paramInt + 1;
    }
    return coerce((Local)this.parameters.get(i), paramTypeId);
  }
  
  public <T> Local<T> getThis(TypeId<T> paramTypeId)
  {
    if (this.thisLocal == null) {
      throw new IllegalStateException("static methods cannot access 'this'");
    }
    return coerce(this.thisLocal, paramTypeId);
  }
  
  public <D, V> void iget(FieldId<D, ? extends V> paramFieldId, Local<V> paramLocal, Local<D> paramLocal1)
  {
    addInstruction(new ThrowingCstInsn(Rops.opGetField(paramLocal.type.ropType), this.sourcePosition, RegisterSpecList.make(paramLocal1.spec()), this.catches, paramFieldId.constant));
    moveResult(paramLocal, true);
  }
  
  void initializeLocals()
  {
    if (this.localsInitialized) {
      throw new AssertionError();
    }
    this.localsInitialized = true;
    Object localObject = this.locals.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = ((Local)((Iterator)localObject).next()).initialize(i) + i) {}
    localObject = new ArrayList();
    Iterator localIterator = this.parameters.iterator();
    int j = i;
    while (localIterator.hasNext())
    {
      Local localLocal = (Local)localIterator.next();
      CstInteger localCstInteger = CstInteger.make(j - i);
      int k = localLocal.initialize(j);
      ((List)localObject).add(new PlainCstInsn(Rops.opMoveParam(localLocal.type.ropType), this.sourcePosition, localLocal.spec(), RegisterSpecList.EMPTY, localCstInteger));
      j += k;
    }
    ((Label)this.labels.get(0)).instructions.addAll(0, (Collection)localObject);
  }
  
  public void instanceOfType(Local<?> paramLocal1, Local<?> paramLocal2, TypeId<?> paramTypeId)
  {
    addInstruction(new ThrowingCstInsn(Rops.INSTANCE_OF, this.sourcePosition, RegisterSpecList.make(paramLocal2.spec()), this.catches, paramTypeId.constant));
    moveResult(paramLocal1, true);
  }
  
  public <D, R> void invokeDirect(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>... paramVarArgs)
  {
    invoke(Rops.opInvokeDirect(paramMethodId.prototype(true)), paramMethodId, paramLocal, paramLocal1, paramVarArgs);
  }
  
  public <D, R> void invokeInterface(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>... paramVarArgs)
  {
    invoke(Rops.opInvokeInterface(paramMethodId.prototype(true)), paramMethodId, paramLocal, paramLocal1, paramVarArgs);
  }
  
  public <R> void invokeStatic(MethodId<?, R> paramMethodId, Local<? super R> paramLocal, Local<?>... paramVarArgs)
  {
    invoke(Rops.opInvokeStatic(paramMethodId.prototype(true)), paramMethodId, paramLocal, null, paramVarArgs);
  }
  
  public <D, R> void invokeSuper(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>... paramVarArgs)
  {
    invoke(Rops.opInvokeSuper(paramMethodId.prototype(true)), paramMethodId, paramLocal, paramLocal1, paramVarArgs);
  }
  
  public <D, R> void invokeVirtual(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>... paramVarArgs)
  {
    invoke(Rops.opInvokeVirtual(paramMethodId.prototype(true)), paramMethodId, paramLocal, paramLocal1, paramVarArgs);
  }
  
  public <D, V> void iput(FieldId<D, V> paramFieldId, Local<? extends D> paramLocal, Local<? extends V> paramLocal1)
  {
    addInstruction(new ThrowingCstInsn(Rops.opPutField(paramLocal1.type.ropType), this.sourcePosition, RegisterSpecList.make(paramLocal1.spec(), paramLocal.spec()), this.catches, paramFieldId.constant));
  }
  
  public void jump(Label paramLabel)
  {
    adopt(paramLabel);
    addInstruction(new PlainInsn(Rops.GOTO, this.sourcePosition, null, RegisterSpecList.EMPTY), paramLabel);
  }
  
  public <T> void loadConstant(Local<T> paramLocal, T paramT)
  {
    if (paramT == null) {}
    for (Rop localRop = Rops.CONST_OBJECT_NOTHROW; localRop.getBranchingness() == 1; localRop = Rops.opConst(paramLocal.type.ropType))
    {
      addInstruction(new PlainCstInsn(localRop, this.sourcePosition, paramLocal.spec(), RegisterSpecList.EMPTY, Constants.getConstant(paramT)));
      return;
    }
    addInstruction(new ThrowingCstInsn(localRop, this.sourcePosition, RegisterSpecList.EMPTY, this.catches, Constants.getConstant(paramT)));
    moveResult(paramLocal, true);
  }
  
  public void mark(Label paramLabel)
  {
    adopt(paramLabel);
    if (paramLabel.marked) {
      throw new IllegalStateException("already marked");
    }
    paramLabel.marked = true;
    if (this.currentLabel != null) {
      jump(paramLabel);
    }
    this.currentLabel = paramLabel;
  }
  
  public void monitorEnter(Local<?> paramLocal)
  {
    addInstruction(new ThrowingInsn(Rops.MONITOR_ENTER, this.sourcePosition, RegisterSpecList.make(paramLocal.spec()), this.catches));
  }
  
  public void monitorExit(Local<?> paramLocal)
  {
    addInstruction(new ThrowingInsn(Rops.MONITOR_EXIT, this.sourcePosition, RegisterSpecList.make(paramLocal.spec()), this.catches));
  }
  
  public <T> void move(Local<T> paramLocal1, Local<T> paramLocal2)
  {
    addInstruction(new PlainInsn(Rops.opMove(paramLocal2.type.ropType), this.sourcePosition, paramLocal1.spec(), paramLocal2.spec()));
  }
  
  public <T> void newArray(Local<T> paramLocal, Local<Integer> paramLocal1)
  {
    addInstruction(new ThrowingCstInsn(Rops.opNewArray(paramLocal.type.ropType), this.sourcePosition, RegisterSpecList.make(paramLocal1.spec()), this.catches, paramLocal.type.constant));
    moveResult(paramLocal, true);
  }
  
  public <T> void newInstance(Local<T> paramLocal, MethodId<T, Void> paramMethodId, Local<?>... paramVarArgs)
  {
    if (paramLocal == null) {
      throw new IllegalArgumentException();
    }
    addInstruction(new ThrowingCstInsn(Rops.NEW_INSTANCE, this.sourcePosition, RegisterSpecList.EMPTY, this.catches, paramMethodId.declaringType.constant));
    moveResult(paramLocal, true);
    invokeDirect(paramMethodId, null, paramLocal, paramVarArgs);
  }
  
  public <T> Local<T> newLocal(TypeId<T> paramTypeId)
  {
    if (this.localsInitialized) {
      throw new IllegalStateException("Cannot allocate locals after adding instructions");
    }
    paramTypeId = Local.get(this, paramTypeId);
    this.locals.add(paramTypeId);
    return paramTypeId;
  }
  
  public <T1, T2> void op(BinaryOp paramBinaryOp, Local<T1> paramLocal1, Local<T1> paramLocal2, Local<T2> paramLocal)
  {
    paramBinaryOp = paramBinaryOp.rop(StdTypeList.make(paramLocal2.type.ropType, paramLocal.type.ropType));
    paramLocal2 = RegisterSpecList.make(paramLocal2.spec(), paramLocal.spec());
    if (paramBinaryOp.getBranchingness() == 1)
    {
      addInstruction(new PlainInsn(paramBinaryOp, this.sourcePosition, paramLocal1.spec(), paramLocal2));
      return;
    }
    addInstruction(new ThrowingInsn(paramBinaryOp, this.sourcePosition, paramLocal2, this.catches));
    moveResult(paramLocal1, true);
  }
  
  public <T> void op(UnaryOp paramUnaryOp, Local<T> paramLocal1, Local<T> paramLocal2)
  {
    addInstruction(new PlainInsn(paramUnaryOp.rop(paramLocal2.type), this.sourcePosition, paramLocal1.spec(), paramLocal2.spec()));
  }
  
  int paramSize()
  {
    Iterator localIterator = this.parameters.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Local)localIterator.next()).size() + i) {}
    return i;
  }
  
  public Label removeCatchClause(TypeId<? extends Throwable> paramTypeId)
  {
    int i = this.catchTypes.indexOf(paramTypeId);
    if (i == -1) {
      throw new IllegalArgumentException("No catch clause: " + paramTypeId);
    }
    this.catchTypes.remove(i);
    this.catches = toTypeList(this.catchTypes);
    return (Label)this.catchLabels.remove(i);
  }
  
  public void returnValue(Local<?> paramLocal)
  {
    if (!paramLocal.type.equals(this.method.returnType)) {
      throw new IllegalArgumentException("declared " + this.method.returnType + " but returned " + paramLocal.type);
    }
    addInstruction(new PlainInsn(Rops.opReturn(paramLocal.type.ropType), this.sourcePosition, null, RegisterSpecList.make(paramLocal.spec())));
  }
  
  public void returnVoid()
  {
    if (!this.method.returnType.equals(TypeId.VOID)) {
      throw new IllegalArgumentException("declared " + this.method.returnType + " but returned void");
    }
    addInstruction(new PlainInsn(Rops.RETURN_VOID, this.sourcePosition, null, RegisterSpecList.EMPTY));
  }
  
  public <V> void sget(FieldId<?, ? extends V> paramFieldId, Local<V> paramLocal)
  {
    addInstruction(new ThrowingCstInsn(Rops.opGetStatic(paramLocal.type.ropType), this.sourcePosition, RegisterSpecList.EMPTY, this.catches, paramFieldId.constant));
    moveResult(paramLocal, true);
  }
  
  public <V> void sput(FieldId<?, V> paramFieldId, Local<? extends V> paramLocal)
  {
    addInstruction(new ThrowingCstInsn(Rops.opPutStatic(paramLocal.type.ropType), this.sourcePosition, RegisterSpecList.make(paramLocal.spec()), this.catches, paramFieldId.constant));
  }
  
  public void throwValue(Local<? extends Throwable> paramLocal)
  {
    addInstruction(new ThrowingInsn(Rops.THROW, this.sourcePosition, RegisterSpecList.make(paramLocal.spec()), this.catches));
  }
  
  BasicBlockList toBasicBlocks()
  {
    if (!this.localsInitialized) {
      initializeLocals();
    }
    cleanUpLabels();
    BasicBlockList localBasicBlockList = new BasicBlockList(this.labels.size());
    int i = 0;
    while (i < this.labels.size())
    {
      localBasicBlockList.set(i, ((Label)this.labels.get(i)).toBasicBlock());
      i += 1;
    }
    return localBasicBlockList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.Code
 * JD-Core Version:    0.7.0.1
 */