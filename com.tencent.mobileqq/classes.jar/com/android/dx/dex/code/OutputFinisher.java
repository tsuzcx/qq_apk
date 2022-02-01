package com.android.dx.dex.code;

import com.android.dex.DexException;
import com.android.dx.dex.DexOptions;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMemberRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.ssa.BasicRegisterMapper;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public final class OutputFinisher
{
  private final DexOptions dexOptions;
  private boolean hasAnyLocalInfo;
  private boolean hasAnyPositionInfo;
  private ArrayList<DalvInsn> insns;
  private final int paramSize;
  private int reservedCount;
  private int reservedParameterCount;
  private final int unreservedRegCount;
  
  public OutputFinisher(DexOptions paramDexOptions, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dexOptions = paramDexOptions;
    this.unreservedRegCount = paramInt2;
    this.insns = new ArrayList(paramInt1);
    this.reservedCount = -1;
    this.hasAnyPositionInfo = false;
    this.hasAnyLocalInfo = false;
    this.paramSize = paramInt3;
  }
  
  private static void addConstants(HashSet<Constant> paramHashSet, DalvInsn paramDalvInsn)
  {
    if ((paramDalvInsn instanceof CstInsn)) {
      paramHashSet.add(((CstInsn)paramDalvInsn).getConstant());
    }
    do
    {
      for (;;)
      {
        return;
        if (!(paramDalvInsn instanceof LocalSnapshot)) {
          break;
        }
        paramDalvInsn = ((LocalSnapshot)paramDalvInsn).getLocals();
        int j = paramDalvInsn.size();
        int i = 0;
        while (i < j)
        {
          addConstants(paramHashSet, paramDalvInsn.get(i));
          i += 1;
        }
      }
    } while (!(paramDalvInsn instanceof LocalStart));
    addConstants(paramHashSet, ((LocalStart)paramDalvInsn).getLocal());
  }
  
  private static void addConstants(HashSet<Constant> paramHashSet, RegisterSpec paramRegisterSpec)
  {
    if (paramRegisterSpec == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramRegisterSpec.getLocalItem();
      CstString localCstString = ((LocalItem)localObject).getName();
      localObject = ((LocalItem)localObject).getSignature();
      paramRegisterSpec = paramRegisterSpec.getType();
      if (paramRegisterSpec != Type.KNOWN_NULL) {
        paramHashSet.add(CstType.intern(paramRegisterSpec));
      }
      if (localCstString != null) {
        paramHashSet.add(localCstString);
      }
    } while (localObject == null);
    paramHashSet.add(localObject);
  }
  
  private void addReservedParameters(int paramInt)
  {
    shiftParameters(paramInt);
    this.reservedParameterCount += paramInt;
  }
  
  private void addReservedRegisters(int paramInt)
  {
    shiftAllRegisters(paramInt);
    this.reservedCount += paramInt;
  }
  
  private void align64bits(Dop[] paramArrayOfDop)
  {
    int i3 = this.unreservedRegCount;
    int i4 = this.reservedCount;
    int i5 = this.reservedParameterCount;
    int i6 = this.paramSize;
    Iterator localIterator = this.insns.iterator();
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    label43:
    int i1;
    int n;
    label140:
    if (localIterator.hasNext())
    {
      RegisterSpecList localRegisterSpecList = ((DalvInsn)localIterator.next()).getRegisters();
      i1 = m;
      int i2 = k;
      n = 0;
      m = i;
      k = j;
      j = i2;
      i = i1;
      label91:
      if (n < localRegisterSpecList.size())
      {
        RegisterSpec localRegisterSpec = localRegisterSpecList.get(n);
        if (!localRegisterSpec.isCategory2()) {
          break label298;
        }
        if (localRegisterSpec.getReg() >= i3 + i4 + i5 - i6)
        {
          i1 = 1;
          if (!localRegisterSpec.isEvenRegister()) {
            break label181;
          }
          if (i1 == 0) {
            break label172;
          }
          i += 1;
        }
      }
    }
    label298:
    for (;;)
    {
      n += 1;
      break label91;
      i1 = 0;
      break label140;
      label172:
      k += 1;
      continue;
      label181:
      if (i1 != 0)
      {
        j += 1;
      }
      else
      {
        m += 1;
        continue;
        n = m;
        i1 = k;
        m = i;
        k = j;
        j = i1;
        i = n;
        break label43;
        if ((k > m) && (i > j)) {
          addReservedRegisters(1);
        }
        while (!reserveRegisters(paramArrayOfDop))
        {
          do
          {
            return;
            if (k > m)
            {
              addReservedParameters(1);
              break;
            }
          } while (i <= j);
          addReservedRegisters(1);
          if ((this.paramSize != 0) && (m > k)) {
            addReservedParameters(1);
          }
        }
      }
    }
  }
  
  private void assignAddresses()
  {
    int k = this.insns.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      DalvInsn localDalvInsn = (DalvInsn)this.insns.get(i);
      localDalvInsn.setAddress(j);
      j += localDalvInsn.codeSize();
      i += 1;
    }
  }
  
  private void assignAddressesAndFixBranches()
  {
    do
    {
      assignAddresses();
    } while (fixBranches());
  }
  
  private static void assignIndices(CstInsn paramCstInsn, DalvCode.AssignIndicesCallback paramAssignIndicesCallback)
  {
    Constant localConstant = paramCstInsn.getConstant();
    int i = paramAssignIndicesCallback.getIndex(localConstant);
    if (i >= 0) {
      paramCstInsn.setIndex(i);
    }
    if ((localConstant instanceof CstMemberRef))
    {
      i = paramAssignIndicesCallback.getIndex(((CstMemberRef)localConstant).getDefiningClass());
      if (i >= 0) {
        paramCstInsn.setClassIndex(i);
      }
    }
  }
  
  private int calculateReservedCount(Dop[] paramArrayOfDop)
  {
    int m = this.insns.size();
    int i = this.reservedCount;
    int j = 0;
    if (j < m)
    {
      DalvInsn localDalvInsn = (DalvInsn)this.insns.get(j);
      Dop localDop1 = paramArrayOfDop[j];
      Dop localDop2 = findOpcodeForInsn(localDalvInsn, localDop1);
      int k;
      if (localDop2 == null)
      {
        k = localDalvInsn.getMinimumRegisterRequirement(findExpandedOpcodeForInsn(localDalvInsn).getFormat().compatibleRegs(localDalvInsn));
        if (k <= i) {
          break label113;
        }
        i = k;
      }
      label113:
      for (;;)
      {
        paramArrayOfDop[j] = localDop2;
        k = i;
        do
        {
          j += 1;
          i = k;
          break;
          k = i;
        } while (localDop1 == localDop2);
      }
    }
    return i;
  }
  
  private Dop findExpandedOpcodeForInsn(DalvInsn paramDalvInsn)
  {
    Dop localDop = findOpcodeForInsn(paramDalvInsn.getLowRegVersion(), paramDalvInsn.getOpcode());
    if (localDop == null) {
      throw new DexException("No expanded opcode for " + paramDalvInsn);
    }
    return localDop;
  }
  
  private Dop findOpcodeForInsn(DalvInsn paramDalvInsn, Dop paramDop)
  {
    for (;;)
    {
      if ((paramDop == null) || ((paramDop.getFormat().isCompatible(paramDalvInsn)) && ((!this.dexOptions.forceJumbo) || (paramDop.getOpcode() != 26)))) {
        return paramDop;
      }
      paramDop = Dops.getNextOrNull(paramDop, this.dexOptions);
    }
  }
  
  private boolean fixBranches()
  {
    int i = 0;
    int j = this.insns.size();
    boolean bool = false;
    if (i < j)
    {
      Object localObject2 = (DalvInsn)this.insns.get(i);
      if (!(localObject2 instanceof TargetInsn)) {}
      Object localObject3;
      Object localObject1;
      do
      {
        i += 1;
        break;
        localObject3 = ((DalvInsn)localObject2).getOpcode();
        localObject1 = (TargetInsn)localObject2;
      } while (((Dop)localObject3).getFormat().branchFits((TargetInsn)localObject1));
      if (((Dop)localObject3).getFamily() == 40)
      {
        localObject1 = findOpcodeForInsn((DalvInsn)localObject2, (Dop)localObject3);
        if (localObject1 == null) {
          throw new UnsupportedOperationException("method too long");
        }
        this.insns.set(i, ((DalvInsn)localObject2).withOpcode((Dop)localObject1));
      }
      for (;;)
      {
        bool = true;
        break;
        try
        {
          localObject2 = (CodeAddress)this.insns.get(i + 1);
          localObject3 = new TargetInsn(Dops.GOTO, ((TargetInsn)localObject1).getPosition(), RegisterSpecList.EMPTY, ((TargetInsn)localObject1).getTarget());
          this.insns.set(i, localObject3);
          this.insns.add(i, ((TargetInsn)localObject1).withNewTargetAndReversed((CodeAddress)localObject2));
          j += 1;
          i += 1;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new IllegalStateException("unpaired TargetInsn (dangling)");
        }
        catch (ClassCastException localClassCastException)
        {
          throw new IllegalStateException("unpaired TargetInsn");
        }
      }
    }
    return bool;
  }
  
  private static boolean hasLocalInfo(DalvInsn paramDalvInsn)
  {
    if ((paramDalvInsn instanceof LocalSnapshot))
    {
      paramDalvInsn = ((LocalSnapshot)paramDalvInsn).getLocals();
      j = paramDalvInsn.size();
      i = 0;
      if (i >= j) {
        break label67;
      }
      if (!hasLocalInfo(paramDalvInsn.get(i))) {}
    }
    while (((paramDalvInsn instanceof LocalStart)) && (hasLocalInfo(((LocalStart)paramDalvInsn).getLocal()))) {
      for (;;)
      {
        int j;
        int i;
        return true;
        i += 1;
      }
    }
    label67:
    return false;
  }
  
  private static boolean hasLocalInfo(RegisterSpec paramRegisterSpec)
  {
    return (paramRegisterSpec != null) && (paramRegisterSpec.getLocalItem().getName() != null);
  }
  
  private Dop[] makeOpcodesArray()
  {
    int j = this.insns.size();
    Dop[] arrayOfDop = new Dop[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDop[i] = ((DalvInsn)this.insns.get(i)).getOpcode();
      i += 1;
    }
    return arrayOfDop;
  }
  
  private void massageInstructions(Dop[] paramArrayOfDop)
  {
    if (this.reservedCount == 0)
    {
      int j = this.insns.size();
      int i = 0;
      while (i < j)
      {
        DalvInsn localDalvInsn = (DalvInsn)this.insns.get(i);
        Dop localDop1 = localDalvInsn.getOpcode();
        Dop localDop2 = paramArrayOfDop[i];
        if (localDop1 != localDop2) {
          this.insns.set(i, localDalvInsn.withOpcode(localDop2));
        }
        i += 1;
      }
    }
    this.insns = performExpansion(paramArrayOfDop);
  }
  
  private ArrayList<DalvInsn> performExpansion(Dop[] paramArrayOfDop)
  {
    int j = this.insns.size();
    ArrayList localArrayList1 = new ArrayList(j * 2);
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < j)
    {
      DalvInsn localDalvInsn1 = (DalvInsn)this.insns.get(i);
      Dop localDop2 = localDalvInsn1.getOpcode();
      Dop localDop1 = paramArrayOfDop[i];
      DalvInsn localDalvInsn2;
      Object localObject;
      if (localDop1 != null)
      {
        localDalvInsn2 = null;
        localObject = null;
        label72:
        if ((!(localDalvInsn1 instanceof CodeAddress)) || (!((CodeAddress)localDalvInsn1).getBindsClosely())) {
          break label159;
        }
        localArrayList2.add((CodeAddress)localDalvInsn1);
      }
      for (;;)
      {
        i += 1;
        break;
        localDop1 = findExpandedOpcodeForInsn(localDalvInsn1);
        BitSet localBitSet = localDop1.getFormat().compatibleRegs(localDalvInsn1);
        localObject = localDalvInsn1.expandedPrefix(localBitSet);
        localDalvInsn2 = localDalvInsn1.expandedSuffix(localBitSet);
        localDalvInsn1 = localDalvInsn1.expandedVersion(localBitSet);
        break label72;
        label159:
        if (localObject != null) {
          localArrayList1.add(localObject);
        }
        if ((!(localDalvInsn1 instanceof ZeroSizeInsn)) && (localArrayList2.size() > 0))
        {
          localObject = localArrayList2.iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList1.add((CodeAddress)((Iterator)localObject).next());
          }
          localArrayList2.clear();
        }
        localObject = localDalvInsn1;
        if (localDop1 != localDop2) {
          localObject = localDalvInsn1.withOpcode(localDop1);
        }
        localArrayList1.add(localObject);
        if (localDalvInsn2 != null) {
          localArrayList1.add(localDalvInsn2);
        }
      }
    }
    return localArrayList1;
  }
  
  private boolean reserveRegisters(Dop[] paramArrayOfDop)
  {
    int i;
    boolean bool;
    if (this.reservedCount < 0)
    {
      i = 0;
      bool = false;
    }
    for (;;)
    {
      int k = calculateReservedCount(paramArrayOfDop);
      if (i >= k)
      {
        this.reservedCount = i;
        return bool;
        i = this.reservedCount;
        break;
      }
      bool = true;
      int m = this.insns.size();
      int j = 0;
      while (j < m)
      {
        DalvInsn localDalvInsn = (DalvInsn)this.insns.get(j);
        if (!(localDalvInsn instanceof CodeAddress)) {
          this.insns.set(j, localDalvInsn.withRegisterOffset(k - i));
        }
        j += 1;
      }
      i = k;
    }
  }
  
  private void shiftAllRegisters(int paramInt)
  {
    int j = this.insns.size();
    int i = 0;
    while (i < j)
    {
      DalvInsn localDalvInsn = (DalvInsn)this.insns.get(i);
      if (!(localDalvInsn instanceof CodeAddress)) {
        this.insns.set(i, localDalvInsn.withRegisterOffset(paramInt));
      }
      i += 1;
    }
  }
  
  private void shiftParameters(int paramInt)
  {
    int j = this.insns.size();
    int i = this.unreservedRegCount;
    int k = this.reservedCount;
    k = this.reservedParameterCount + (i + k);
    int m = this.paramSize;
    BasicRegisterMapper localBasicRegisterMapper = new BasicRegisterMapper(k);
    i = 0;
    if (i < k)
    {
      if (i >= k - m) {
        localBasicRegisterMapper.addMapping(i, i + paramInt, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        localBasicRegisterMapper.addMapping(i, i, 1);
      }
    }
    paramInt = 0;
    while (paramInt < j)
    {
      DalvInsn localDalvInsn = (DalvInsn)this.insns.get(paramInt);
      if (!(localDalvInsn instanceof CodeAddress)) {
        this.insns.set(paramInt, localDalvInsn.withMapper(localBasicRegisterMapper));
      }
      paramInt += 1;
    }
  }
  
  private void updateInfo(DalvInsn paramDalvInsn)
  {
    if ((!this.hasAnyPositionInfo) && (paramDalvInsn.getPosition().getLine() >= 0)) {
      this.hasAnyPositionInfo = true;
    }
    if ((!this.hasAnyLocalInfo) && (hasLocalInfo(paramDalvInsn))) {
      this.hasAnyLocalInfo = true;
    }
  }
  
  public void add(DalvInsn paramDalvInsn)
  {
    this.insns.add(paramDalvInsn);
    updateInfo(paramDalvInsn);
  }
  
  public void assignIndices(DalvCode.AssignIndicesCallback paramAssignIndicesCallback)
  {
    Iterator localIterator = this.insns.iterator();
    while (localIterator.hasNext())
    {
      DalvInsn localDalvInsn = (DalvInsn)localIterator.next();
      if ((localDalvInsn instanceof CstInsn)) {
        assignIndices((CstInsn)localDalvInsn, paramAssignIndicesCallback);
      }
    }
  }
  
  public DalvInsnList finishProcessingAndGetList()
  {
    if (this.reservedCount >= 0) {
      throw new UnsupportedOperationException("already processed");
    }
    Dop[] arrayOfDop = makeOpcodesArray();
    reserveRegisters(arrayOfDop);
    if (this.dexOptions.ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER) {
      align64bits(arrayOfDop);
    }
    massageInstructions(arrayOfDop);
    assignAddressesAndFixBranches();
    return DalvInsnList.makeImmutable(this.insns, this.reservedCount + this.unreservedRegCount + this.reservedParameterCount);
  }
  
  public HashSet<Constant> getAllConstants()
  {
    HashSet localHashSet = new HashSet(20);
    Iterator localIterator = this.insns.iterator();
    while (localIterator.hasNext()) {
      addConstants(localHashSet, (DalvInsn)localIterator.next());
    }
    return localHashSet;
  }
  
  public boolean hasAnyLocalInfo()
  {
    return this.hasAnyLocalInfo;
  }
  
  public boolean hasAnyPositionInfo()
  {
    return this.hasAnyPositionInfo;
  }
  
  public void insert(int paramInt, DalvInsn paramDalvInsn)
  {
    this.insns.add(paramInt, paramDalvInsn);
    updateInfo(paramDalvInsn);
  }
  
  public void reverseBranch(int paramInt, CodeAddress paramCodeAddress)
  {
    paramInt = this.insns.size() - paramInt - 1;
    try
    {
      TargetInsn localTargetInsn = (TargetInsn)this.insns.get(paramInt);
      this.insns.set(paramInt, localTargetInsn.withNewTargetAndReversed(paramCodeAddress));
      return;
    }
    catch (IndexOutOfBoundsException paramCodeAddress)
    {
      throw new IllegalArgumentException("too few instructions");
    }
    catch (ClassCastException paramCodeAddress)
    {
      throw new IllegalArgumentException("non-reversible instruction");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.OutputFinisher
 * JD-Core Version:    0.7.0.1
 */