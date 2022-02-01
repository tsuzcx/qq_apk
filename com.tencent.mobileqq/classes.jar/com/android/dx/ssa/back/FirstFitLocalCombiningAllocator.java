package com.android.dx.ssa.back;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.type.TypeList;
import com.android.dx.ssa.InterferenceRegisterMapper;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.IntIterator;
import com.android.dx.util.IntSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FirstFitLocalCombiningAllocator
  extends RegisterAllocator
{
  private static final boolean DEBUG = false;
  private final ArrayList<NormalSsaInsn> invokeRangeInsns;
  private final Map<LocalItem, ArrayList<RegisterSpec>> localVariables;
  private final InterferenceRegisterMapper mapper;
  private final boolean minimizeRegisters;
  private final ArrayList<NormalSsaInsn> moveResultPseudoInsns;
  private final int paramRangeEnd;
  private final ArrayList<PhiInsn> phiInsns;
  private final BitSet reservedRopRegs;
  private final BitSet ssaRegsMapped;
  private final BitSet usedRopRegs;
  
  public FirstFitLocalCombiningAllocator(SsaMethod paramSsaMethod, InterferenceGraph paramInterferenceGraph, boolean paramBoolean)
  {
    super(paramSsaMethod, paramInterferenceGraph);
    this.ssaRegsMapped = new BitSet(paramSsaMethod.getRegCount());
    this.mapper = new InterferenceRegisterMapper(paramInterferenceGraph, paramSsaMethod.getRegCount());
    this.minimizeRegisters = paramBoolean;
    this.paramRangeEnd = paramSsaMethod.getParamWidth();
    this.reservedRopRegs = new BitSet(this.paramRangeEnd * 2);
    this.reservedRopRegs.set(0, this.paramRangeEnd);
    this.usedRopRegs = new BitSet(this.paramRangeEnd * 2);
    this.localVariables = new TreeMap();
    this.moveResultPseudoInsns = new ArrayList();
    this.invokeRangeInsns = new ArrayList();
    this.phiInsns = new ArrayList();
  }
  
  private void addMapping(RegisterSpec paramRegisterSpec, int paramInt)
  {
    int i = paramRegisterSpec.getReg();
    if ((this.ssaRegsMapped.get(i)) || (!canMapReg(paramRegisterSpec, paramInt))) {
      throw new RuntimeException("attempt to add invalid register mapping");
    }
    int j = paramRegisterSpec.getCategory();
    this.mapper.addMapping(paramRegisterSpec.getReg(), paramInt, j);
    this.ssaRegsMapped.set(i);
    this.usedRopRegs.set(paramInt, j + paramInt);
  }
  
  private void adjustAndMapSourceRangeRange(NormalSsaInsn paramNormalSsaInsn)
  {
    int i = findRangeAndAdjust(paramNormalSsaInsn);
    paramNormalSsaInsn = paramNormalSsaInsn.getSources();
    int m = paramNormalSsaInsn.size();
    int j = 0;
    if (j < m)
    {
      Object localObject1 = paramNormalSsaInsn.get(j);
      int k = ((RegisterSpec)localObject1).getReg();
      int n = ((RegisterSpec)localObject1).getCategory();
      if (this.ssaRegsMapped.get(k)) {}
      Object localObject2;
      do
      {
        j += 1;
        i += n;
        break;
        localObject2 = getLocalItemForReg(k);
        addMapping((RegisterSpec)localObject1, i);
      } while (localObject2 == null);
      markReserved(i, n);
      localObject1 = (ArrayList)this.localVariables.get(localObject2);
      int i1 = ((ArrayList)localObject1).size();
      k = 0;
      label123:
      if (k < i1)
      {
        localObject2 = (RegisterSpec)((ArrayList)localObject1).get(k);
        if (-1 == paramNormalSsaInsn.indexOfRegister(((RegisterSpec)localObject2).getReg())) {
          break label164;
        }
      }
      for (;;)
      {
        k += 1;
        break label123;
        break;
        label164:
        tryMapReg((RegisterSpec)localObject2, i, n);
      }
    }
  }
  
  private void analyzeInstructions()
  {
    this.ssaMeth.forEachInsn(new FirstFitLocalCombiningAllocator.1(this));
  }
  
  private boolean canMapReg(RegisterSpec paramRegisterSpec, int paramInt)
  {
    return (!spansParamRange(paramInt, paramRegisterSpec.getCategory())) && (!this.mapper.interferes(paramRegisterSpec, paramInt));
  }
  
  private boolean canMapRegs(ArrayList<RegisterSpec> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RegisterSpec localRegisterSpec = (RegisterSpec)paramArrayList.next();
      if ((!this.ssaRegsMapped.get(localRegisterSpec.getReg())) && (!canMapReg(localRegisterSpec, paramInt))) {
        return false;
      }
    }
    return true;
  }
  
  private int findAnyFittingRange(NormalSsaInsn paramNormalSsaInsn, int paramInt, int[] paramArrayOfInt, BitSet paramBitSet)
  {
    int j = 0;
    FirstFitLocalCombiningAllocator.Alignment localAlignment = FirstFitLocalCombiningAllocator.Alignment.UNSPECIFIED;
    int n = paramArrayOfInt.length;
    int m = 0;
    int i = 0;
    int k = 0;
    if (m < n)
    {
      if (paramArrayOfInt[m] == 2) {
        if (isEven(k))
        {
          i += 1;
          label50:
          k += 2;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        j += 1;
        break label50;
        k += 1;
      }
    }
    if (j > i) {
      if (isEven(this.paramRangeEnd)) {
        localAlignment = FirstFitLocalCombiningAllocator.Alignment.ODD;
      }
    }
    label191:
    for (;;)
    {
      i = this.paramRangeEnd;
      for (;;)
      {
        i = findNextUnreservedRopReg(i, paramInt, localAlignment);
        if (fitPlanForRange(i, paramNormalSsaInsn, paramArrayOfInt, paramBitSet) >= 0)
        {
          return i;
          localAlignment = FirstFitLocalCombiningAllocator.Alignment.EVEN;
          break;
          if (i <= 0) {
            break label191;
          }
          if (isEven(this.paramRangeEnd))
          {
            localAlignment = FirstFitLocalCombiningAllocator.Alignment.EVEN;
            break;
          }
          localAlignment = FirstFitLocalCombiningAllocator.Alignment.ODD;
          break;
        }
        i += 1;
        paramBitSet.clear();
      }
    }
  }
  
  private int findNextUnreservedRopReg(int paramInt1, int paramInt2)
  {
    return findNextUnreservedRopReg(paramInt1, paramInt2, getAlignment(paramInt2));
  }
  
  private int findNextUnreservedRopReg(int paramInt1, int paramInt2, FirstFitLocalCombiningAllocator.Alignment paramAlignment)
  {
    int i;
    for (paramInt1 = paramAlignment.nextClearBit(this.reservedRopRegs, paramInt1);; paramInt1 = paramAlignment.nextClearBit(this.reservedRopRegs, paramInt1 + i))
    {
      i = 1;
      while ((i < paramInt2) && (!this.reservedRopRegs.get(paramInt1 + i))) {
        i += 1;
      }
      if (i == paramInt2) {
        return paramInt1;
      }
    }
  }
  
  private int findRangeAndAdjust(NormalSsaInsn paramNormalSsaInsn)
  {
    RegisterSpecList localRegisterSpecList = paramNormalSsaInsn.getSources();
    int i4 = localRegisterSpecList.size();
    int[] arrayOfInt = new int[i4];
    int i = 0;
    for (int m = 0; i < i4; m = j + m)
    {
      arrayOfInt[i] = localRegisterSpecList.get(i).getCategory();
      j = arrayOfInt[i];
      i += 1;
    }
    int i2 = 0;
    Object localObject1 = null;
    i = -1;
    int j = -2147483648;
    int n = 0;
    Object localObject2 = localObject1;
    int k = i;
    if (n < i4)
    {
      k = localRegisterSpecList.get(n).getReg();
      int i1 = i2;
      if (n != 0) {
        i1 = i2 - arrayOfInt[(n - 1)];
      }
      if (!this.ssaRegsMapped.get(k))
      {
        k = j;
        i2 = i;
        localObject2 = localObject1;
      }
      int i5;
      do
      {
        int i3;
        BitSet localBitSet;
        do
        {
          do
          {
            do
            {
              n += 1;
              localObject1 = localObject2;
              i = i2;
              j = k;
              i2 = i1;
              break;
              i3 = this.mapper.oldToNew(k) + i1;
              localObject2 = localObject1;
              i2 = i;
              k = j;
            } while (i3 < 0);
            localObject2 = localObject1;
            i2 = i;
            k = j;
          } while (spansParamRange(i3, m));
          localBitSet = new BitSet(i4);
          i5 = fitPlanForRange(i3, paramNormalSsaInsn, arrayOfInt, localBitSet);
          localObject2 = localObject1;
          i2 = i;
          k = j;
        } while (i5 < 0);
        i2 = i5 - localBitSet.cardinality();
        k = j;
        if (i2 > j)
        {
          localObject1 = localBitSet;
          i = i3;
          k = i2;
        }
        localObject2 = localObject1;
        i2 = i;
      } while (i5 != m);
      k = i;
      localObject2 = localObject1;
    }
    i = k;
    if (k == -1)
    {
      localObject2 = new BitSet(i4);
      i = findAnyFittingRange(paramNormalSsaInsn, m, arrayOfInt, (BitSet)localObject2);
    }
    for (j = ((BitSet)localObject2).nextSetBit(0); j >= 0; j = ((BitSet)localObject2).nextSetBit(j + 1)) {
      paramNormalSsaInsn.changeOneSource(j, insertMoveBefore(paramNormalSsaInsn, localRegisterSpecList.get(j)));
    }
    return i;
  }
  
  private int findRopRegForLocal(int paramInt1, int paramInt2)
  {
    FirstFitLocalCombiningAllocator.Alignment localAlignment = getAlignment(paramInt2);
    int i;
    for (paramInt1 = localAlignment.nextClearBit(this.usedRopRegs, paramInt1);; paramInt1 = localAlignment.nextClearBit(this.usedRopRegs, paramInt1 + i))
    {
      i = 1;
      while ((i < paramInt2) && (!this.usedRopRegs.get(paramInt1 + i))) {
        i += 1;
      }
      if (i == paramInt2) {
        return paramInt1;
      }
    }
  }
  
  private int fitPlanForRange(int paramInt, NormalSsaInsn paramNormalSsaInsn, int[] paramArrayOfInt, BitSet paramBitSet)
  {
    RegisterSpecList localRegisterSpecList = paramNormalSsaInsn.getSources();
    int m = localRegisterSpecList.size();
    int j = 0;
    paramNormalSsaInsn = ssaSetToSpecs(paramNormalSsaInsn.getBlock().getLiveOutRegs());
    BitSet localBitSet = new BitSet(this.ssaMeth.getRegCount());
    int i = 0;
    int k = paramInt;
    paramInt = j;
    j = paramInt;
    RegisterSpec localRegisterSpec;
    int n;
    int i1;
    if (i < m)
    {
      localRegisterSpec = localRegisterSpecList.get(i);
      n = localRegisterSpec.getReg();
      i1 = paramArrayOfInt[i];
      j = k;
      if (i != 0) {
        j = k + paramArrayOfInt[(i - 1)];
      }
      if ((this.ssaRegsMapped.get(n)) && (this.mapper.oldToNew(n) == j)) {
        paramInt += i1;
      }
    }
    for (;;)
    {
      localBitSet.set(n);
      i += 1;
      k = j;
      break;
      if (rangeContainsReserved(j, i1))
      {
        j = -1;
        return j;
      }
      if ((!this.ssaRegsMapped.get(n)) && (canMapReg(localRegisterSpec, j)) && (!localBitSet.get(n)))
      {
        paramInt += i1;
      }
      else
      {
        if ((this.mapper.areAnyPinned(paramNormalSsaInsn, j, i1)) || (this.mapper.areAnyPinned(localRegisterSpecList, j, i1))) {
          break label255;
        }
        paramBitSet.set(i);
      }
    }
    label255:
    return -1;
  }
  
  private FirstFitLocalCombiningAllocator.Alignment getAlignment(int paramInt)
  {
    FirstFitLocalCombiningAllocator.Alignment localAlignment = FirstFitLocalCombiningAllocator.Alignment.UNSPECIFIED;
    if (paramInt == 2)
    {
      if (isEven(this.paramRangeEnd)) {
        localAlignment = FirstFitLocalCombiningAllocator.Alignment.EVEN;
      }
    }
    else {
      return localAlignment;
    }
    return FirstFitLocalCombiningAllocator.Alignment.ODD;
  }
  
  private LocalItem getLocalItemForReg(int paramInt)
  {
    Map.Entry localEntry;
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.localVariables.entrySet().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator1.next();
        localIterator2 = ((ArrayList)localEntry.getValue()).iterator();
      }
    } while (((RegisterSpec)localIterator2.next()).getReg() != paramInt);
    return (LocalItem)localEntry.getKey();
    return null;
  }
  
  private int getParameterIndexForReg(int paramInt)
  {
    SsaInsn localSsaInsn = this.ssaMeth.getDefinitionForRegister(paramInt);
    if (localSsaInsn == null) {}
    Rop localRop;
    do
    {
      return -1;
      localRop = localSsaInsn.getOpcode();
    } while ((localRop == null) || (localRop.getOpcode() != 3));
    return ((CstInteger)((CstInsn)localSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
  }
  
  private void handleCheckCastResults()
  {
    Iterator localIterator = this.moveResultPseudoInsns.iterator();
    Object localObject;
    RegisterSpec localRegisterSpec1;
    int k;
    RegisterSpec localRegisterSpec2;
    int j;
    int m;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (NormalSsaInsn)localIterator.next();
        localRegisterSpec1 = ((NormalSsaInsn)localObject).getResult();
        k = localRegisterSpec1.getReg();
        localObject = ((NormalSsaInsn)localObject).getBlock().getPredecessors();
        if (((BitSet)localObject).cardinality() == 1)
        {
          localObject = ((SsaBasicBlock)this.ssaMeth.getBlocks().get(((BitSet)localObject).nextSetBit(0))).getInsns();
          localObject = (SsaInsn)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
          if (((SsaInsn)localObject).getOpcode().getOpcode() == 43)
          {
            localRegisterSpec2 = ((SsaInsn)localObject).getSources().get(0);
            j = localRegisterSpec2.getReg();
            m = localRegisterSpec2.getCategory();
            bool3 = this.ssaRegsMapped.get(k);
            bool2 = this.ssaRegsMapped.get(j);
            if (!bool2)
            {
              bool1 = true;
              if (!(bool1 & bool3)) {
                break label391;
              }
              bool2 = tryMapReg(localRegisterSpec2, this.mapper.oldToNew(k), m);
            }
          }
        }
      }
    }
    label391:
    for (;;)
    {
      if (!bool3) {}
      for (bool1 = true;; i = 0)
      {
        if ((bool1 & bool2)) {
          bool3 = tryMapReg(localRegisterSpec1, this.mapper.oldToNew(j), m);
        }
        if ((bool3) && (bool2)) {
          break label308;
        }
        i = findNextUnreservedRopReg(this.paramRangeEnd, m);
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(localRegisterSpec1);
        localArrayList.add(localRegisterSpec2);
        while (!tryMapRegs(localArrayList, i, m, false)) {
          i = findNextUnreservedRopReg(i + 1, m);
        }
        i = 0;
        break;
      }
      label308:
      if (((SsaInsn)localObject).getOriginalRopInsn().getCatches().size() != 0) {}
      for (int i = 1;; i = 0)
      {
        k = this.mapper.oldToNew(k);
        if ((k == this.mapper.oldToNew(j)) || (i != 0)) {
          break;
        }
        ((NormalSsaInsn)localObject).changeOneSource(0, insertMoveBefore((SsaInsn)localObject, localRegisterSpec2));
        addMapping(((SsaInsn)localObject).getSources().get(0), k);
        break;
      }
      return;
    }
  }
  
  private void handleInvokeRangeInsns()
  {
    Iterator localIterator = this.invokeRangeInsns.iterator();
    while (localIterator.hasNext()) {
      adjustAndMapSourceRangeRange((NormalSsaInsn)localIterator.next());
    }
  }
  
  private void handleLocalAssociatedOther()
  {
    Iterator localIterator = this.localVariables.values().iterator();
    ArrayList localArrayList;
    int j;
    boolean bool;
    int k;
    int i;
    if (localIterator.hasNext())
    {
      localArrayList = (ArrayList)localIterator.next();
      j = this.paramRangeEnd;
      bool = false;
      int n = localArrayList.size();
      k = 0;
      i = 1;
      label57:
      if (k < n)
      {
        RegisterSpec localRegisterSpec = (RegisterSpec)localArrayList.get(k);
        int m = localRegisterSpec.getCategory();
        if ((this.ssaRegsMapped.get(localRegisterSpec.getReg())) || (m <= i)) {
          break label156;
        }
        i = m;
      }
    }
    label154:
    label156:
    for (;;)
    {
      k += 1;
      break label57;
      j = findRopRegForLocal(j, i);
      if (canMapRegs(localArrayList, j)) {
        bool = tryMapRegs(localArrayList, j, i, true);
      }
      for (;;)
      {
        if (bool) {
          break label154;
        }
        j += 1;
        break;
        return;
      }
      break;
    }
  }
  
  private void handleLocalAssociatedParams()
  {
    Iterator localIterator = this.localVariables.values().iterator();
    label48:
    label116:
    label119:
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      int j;
      if (localIterator.hasNext())
      {
        localArrayList = (ArrayList)localIterator.next();
        int k = localArrayList.size();
        i = -1;
        j = 0;
        if (j >= k) {
          break label116;
        }
        RegisterSpec localRegisterSpec = (RegisterSpec)localArrayList.get(j);
        i = getParameterIndexForReg(localRegisterSpec.getReg());
        if (i >= 0)
        {
          j = localRegisterSpec.getCategory();
          addMapping(localRegisterSpec, i);
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label119;
        }
        tryMapRegs(localArrayList, i, j, true);
        break;
        j += 1;
        break label48;
        return;
        j = 0;
      }
    }
  }
  
  private void handleNormalUnassociated()
  {
    int k = this.ssaMeth.getRegCount();
    int i = 0;
    if (i < k)
    {
      if (this.ssaRegsMapped.get(i)) {}
      for (;;)
      {
        i += 1;
        break;
        RegisterSpec localRegisterSpec = getDefinitionSpecForSsaReg(i);
        if (localRegisterSpec != null)
        {
          int m = localRegisterSpec.getCategory();
          for (int j = findNextUnreservedRopReg(this.paramRangeEnd, m); !canMapReg(localRegisterSpec, j); j = findNextUnreservedRopReg(j + 1, m)) {}
          addMapping(localRegisterSpec, j);
        }
      }
    }
  }
  
  private void handlePhiInsns()
  {
    Iterator localIterator = this.phiInsns.iterator();
    while (localIterator.hasNext()) {
      processPhiInsn((PhiInsn)localIterator.next());
    }
  }
  
  private void handleUnassociatedParameters()
  {
    int j = this.ssaMeth.getRegCount();
    int i = 0;
    if (i < j)
    {
      if (this.ssaRegsMapped.get(i)) {}
      for (;;)
      {
        i += 1;
        break;
        int k = getParameterIndexForReg(i);
        RegisterSpec localRegisterSpec = getDefinitionSpecForSsaReg(i);
        if (k >= 0) {
          addMapping(localRegisterSpec, k);
        }
      }
    }
  }
  
  private static boolean isEven(int paramInt)
  {
    return (paramInt & 0x1) == 0;
  }
  
  private boolean isThisPointerReg(int paramInt)
  {
    return (paramInt == 0) && (!this.ssaMeth.isStatic());
  }
  
  private void markReserved(int paramInt1, int paramInt2)
  {
    this.reservedRopRegs.set(paramInt1, paramInt1 + paramInt2, true);
  }
  
  private void printLocalVars()
  {
    System.out.println("Printing local vars");
    Iterator localIterator1 = this.localVariables.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('{');
      localStringBuilder.append(' ');
      Iterator localIterator2 = ((ArrayList)localEntry.getValue()).iterator();
      while (localIterator2.hasNext())
      {
        RegisterSpec localRegisterSpec = (RegisterSpec)localIterator2.next();
        localStringBuilder.append('v');
        localStringBuilder.append(localRegisterSpec.getReg());
        localStringBuilder.append(' ');
      }
      localStringBuilder.append('}');
      System.out.printf("Local: %s Registers: %s\n", new Object[] { localEntry.getKey(), localStringBuilder });
    }
  }
  
  private void processPhiInsn(PhiInsn paramPhiInsn)
  {
    RegisterSpec localRegisterSpec = paramPhiInsn.getResult();
    int i = localRegisterSpec.getReg();
    int j = localRegisterSpec.getCategory();
    paramPhiInsn = paramPhiInsn.getSources();
    int k = paramPhiInsn.size();
    ArrayList localArrayList = new ArrayList();
    FirstFitLocalCombiningAllocator.Multiset localMultiset = new FirstFitLocalCombiningAllocator.Multiset(k + 1);
    if (this.ssaRegsMapped.get(i))
    {
      localMultiset.add(this.mapper.oldToNew(i));
      i = 0;
      label77:
      if (i >= k) {
        break label169;
      }
      localRegisterSpec = paramPhiInsn.get(i);
      localRegisterSpec = this.ssaMeth.getDefinitionForRegister(localRegisterSpec.getReg()).getResult();
      int m = localRegisterSpec.getReg();
      if (!this.ssaRegsMapped.get(m)) {
        break label158;
      }
      localMultiset.add(this.mapper.oldToNew(m));
    }
    for (;;)
    {
      i += 1;
      break label77;
      localArrayList.add(localRegisterSpec);
      break;
      label158:
      localArrayList.add(localRegisterSpec);
    }
    label169:
    i = 0;
    while (i < localMultiset.getSize())
    {
      tryMapRegs(localArrayList, localMultiset.getAndRemoveHighestCount(), j, false);
      i += 1;
    }
    for (i = findNextUnreservedRopReg(this.paramRangeEnd, j); !tryMapRegs(localArrayList, i, j, false); i = findNextUnreservedRopReg(i + 1, j)) {}
  }
  
  private boolean rangeContainsReserved(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      if (this.reservedRopRegs.get(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean spansParamRange(int paramInt1, int paramInt2)
  {
    return (paramInt1 < this.paramRangeEnd) && (paramInt1 + paramInt2 > this.paramRangeEnd);
  }
  
  private boolean tryMapReg(RegisterSpec paramRegisterSpec, int paramInt1, int paramInt2)
  {
    if ((paramRegisterSpec.getCategory() <= paramInt2) && (!this.ssaRegsMapped.get(paramRegisterSpec.getReg())) && (canMapReg(paramRegisterSpec, paramInt1)))
    {
      addMapping(paramRegisterSpec, paramInt1);
      return true;
    }
    return false;
  }
  
  private boolean tryMapRegs(ArrayList<RegisterSpec> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    while (paramArrayList.hasNext())
    {
      RegisterSpec localRegisterSpec = (RegisterSpec)paramArrayList.next();
      if (!this.ssaRegsMapped.get(localRegisterSpec.getReg()))
      {
        boolean bool2 = tryMapReg(localRegisterSpec, paramInt1, paramInt2);
        if ((!bool2) || (j != 0)) {}
        for (int i = 1;; i = 0)
        {
          j = i;
          if (!bool2) {
            break;
          }
          j = i;
          if (!paramBoolean) {
            break;
          }
          markReserved(paramInt1, localRegisterSpec.getCategory());
          j = i;
          break;
        }
      }
    }
    paramBoolean = bool1;
    if (j == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public RegisterMapper allocateRegisters()
  {
    analyzeInstructions();
    handleLocalAssociatedParams();
    handleUnassociatedParameters();
    handleInvokeRangeInsns();
    handleLocalAssociatedOther();
    handleCheckCastResults();
    handlePhiInsns();
    handleNormalUnassociated();
    return this.mapper;
  }
  
  RegisterSpecList ssaSetToSpecs(IntSet paramIntSet)
  {
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(paramIntSet.elements());
    paramIntSet = paramIntSet.iterator();
    int i = 0;
    while (paramIntSet.hasNext())
    {
      localRegisterSpecList.set(i, getDefinitionSpecForSsaReg(paramIntSet.next()));
      i += 1;
    }
    return localRegisterSpecList;
  }
  
  public boolean wantsParamsMovedHigh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.FirstFitLocalCombiningAllocator
 * JD-Core Version:    0.7.0.1
 */