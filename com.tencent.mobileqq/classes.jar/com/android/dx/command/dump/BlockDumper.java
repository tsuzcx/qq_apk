package com.android.dx.command.dump;

import com.android.dx.cf.code.BasicBlocker;
import com.android.dx.cf.code.ByteBlock;
import com.android.dx.cf.code.ByteBlockList;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.ByteCatchList.Item;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.CodeObserver;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.CstType;
import com.android.dx.ssa.Optimizer;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.io.PrintStream;

public class BlockDumper
  extends BaseDumper
{
  protected DirectClassFile classFile;
  private boolean first;
  private boolean optimize;
  private boolean rop;
  protected boolean suppressDump;
  
  BlockDumper(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, boolean paramBoolean, Args paramArgs)
  {
    super(paramArrayOfByte, paramPrintStream, paramString, paramArgs);
    this.rop = paramBoolean;
    this.classFile = null;
    this.suppressDump = true;
    this.first = true;
    this.optimize = paramArgs.optimize;
  }
  
  public static void dump(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, boolean paramBoolean, Args paramArgs)
  {
    new BlockDumper(paramArrayOfByte, paramPrintStream, paramString, paramBoolean, paramArgs).dump();
  }
  
  private void regularDump(ConcreteMethod paramConcreteMethod)
  {
    BytecodeArray localBytecodeArray = paramConcreteMethod.getCode();
    ByteArray localByteArray = localBytecodeArray.getBytes();
    ByteBlockList localByteBlockList = BasicBlocker.identifyBlocks(paramConcreteMethod);
    int n = localByteBlockList.size();
    CodeObserver localCodeObserver = new CodeObserver(localByteArray, this);
    setAt(localByteArray, 0);
    this.suppressDump = false;
    int j = 0;
    int i = 0;
    while (i < n)
    {
      paramConcreteMethod = localByteBlockList.get(i);
      int m = paramConcreteMethod.getStart();
      int k = paramConcreteMethod.getEnd();
      if (j < m) {
        parsed(localByteArray, j, m - j, "dead code " + Hex.u2(j) + ".." + Hex.u2(m));
      }
      parsed(localByteArray, m, 0, "block " + Hex.u2(paramConcreteMethod.getLabel()) + ": " + Hex.u2(m) + ".." + Hex.u2(k));
      changeIndent(1);
      j = m;
      while (j < k)
      {
        m = localBytecodeArray.parseInstruction(j, localCodeObserver);
        localCodeObserver.setPreviousOffset(j);
        j += m;
      }
      Object localObject = paramConcreteMethod.getSuccessors();
      m = ((IntList)localObject).size();
      label273:
      ByteCatchList.Item localItem;
      StringBuilder localStringBuilder;
      if (m == 0)
      {
        parsed(localByteArray, k, 0, "returns");
        localObject = paramConcreteMethod.getCatches();
        m = ((ByteCatchList)localObject).size();
        j = 0;
        if (j >= m) {
          break label421;
        }
        localItem = ((ByteCatchList)localObject).get(j);
        paramConcreteMethod = localItem.getExceptionClass();
        localStringBuilder = new StringBuilder().append("catch ");
        if (paramConcreteMethod != CstType.OBJECT) {
          break label413;
        }
      }
      label413:
      for (paramConcreteMethod = "<any>";; paramConcreteMethod = paramConcreteMethod.toHuman())
      {
        parsed(localByteArray, k, 0, paramConcreteMethod + " -> " + Hex.u2(localItem.getHandlerPc()));
        j += 1;
        break label273;
        j = 0;
        while (j < m)
        {
          int i1 = ((IntList)localObject).get(j);
          parsed(localByteArray, k, 0, "next " + Hex.u2(i1));
          j += 1;
        }
        break;
      }
      label421:
      changeIndent(-1);
      i += 1;
      j = k;
    }
    i = localByteArray.size();
    if (j < i) {
      parsed(localByteArray, j, i - j, "dead code " + Hex.u2(j) + ".." + Hex.u2(i));
    }
    this.suppressDump = true;
  }
  
  private void ropDump(ConcreteMethod paramConcreteMethod)
  {
    Object localObject3 = DexTranslationAdvice.THE_ONE;
    ByteArray localByteArray = paramConcreteMethod.getCode().getBytes();
    Object localObject2 = Ropper.convert(paramConcreteMethod, (TranslationAdvice)localObject3, this.classFile.getMethods());
    StringBuffer localStringBuffer = new StringBuffer(2000);
    Object localObject1 = localObject2;
    if (this.optimize)
    {
      boolean bool = AccessFlags.isStatic(paramConcreteMethod.getAccessFlags());
      localObject1 = Optimizer.optimize((RopMethod)localObject2, computeParamWidth(paramConcreteMethod, bool), bool, true, (TranslationAdvice)localObject3);
    }
    paramConcreteMethod = ((RopMethod)localObject1).getBlocks();
    localObject2 = paramConcreteMethod.getLabelsInOrder();
    localStringBuffer.append("first " + Hex.u2(((RopMethod)localObject1).getFirstLabel()) + "\n");
    int k = localObject2.length;
    int i = 0;
    if (i < k)
    {
      int j = localObject2[i];
      localObject3 = paramConcreteMethod.get(paramConcreteMethod.indexOfLabel(j));
      localStringBuffer.append("block ");
      localStringBuffer.append(Hex.u2(j));
      localStringBuffer.append("\n");
      Object localObject4 = ((RopMethod)localObject1).labelToPredecessors(j);
      int m = ((IntList)localObject4).size();
      j = 0;
      while (j < m)
      {
        localStringBuffer.append("  pred ");
        localStringBuffer.append(Hex.u2(((IntList)localObject4).get(j)));
        localStringBuffer.append("\n");
        j += 1;
      }
      localObject4 = ((BasicBlock)localObject3).getInsns();
      m = ((InsnList)localObject4).size();
      j = 0;
      while (j < m)
      {
        ((InsnList)localObject4).get(j);
        localStringBuffer.append("  ");
        localStringBuffer.append(((InsnList)localObject4).get(j).toHuman());
        localStringBuffer.append("\n");
        j += 1;
      }
      localObject4 = ((BasicBlock)localObject3).getSuccessors();
      m = ((IntList)localObject4).size();
      if (m == 0) {
        localStringBuffer.append("  returns\n");
      }
      for (;;)
      {
        i += 1;
        break;
        int n = ((BasicBlock)localObject3).getPrimarySuccessor();
        j = 0;
        while (j < m)
        {
          int i1 = ((IntList)localObject4).get(j);
          localStringBuffer.append("  next ");
          localStringBuffer.append(Hex.u2(i1));
          if ((m != 1) && (i1 == n)) {
            localStringBuffer.append(" *");
          }
          localStringBuffer.append("\n");
          j += 1;
        }
      }
    }
    this.suppressDump = false;
    setAt(localByteArray, 0);
    parsed(localByteArray, 0, localByteArray.size(), localStringBuffer.toString());
    this.suppressDump = true;
  }
  
  public void changeIndent(int paramInt)
  {
    if (!this.suppressDump) {
      super.changeIndent(paramInt);
    }
  }
  
  public void dump()
  {
    Object localObject = new ByteArray(getBytes());
    this.classFile = new DirectClassFile((ByteArray)localObject, getFilePath(), getStrictParse());
    this.classFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
    this.classFile.getMagic();
    localObject = new DirectClassFile((ByteArray)localObject, getFilePath(), getStrictParse());
    ((DirectClassFile)localObject).setAttributeFactory(StdAttributeFactory.THE_ONE);
    ((DirectClassFile)localObject).setObserver(this);
    ((DirectClassFile)localObject).getMagic();
  }
  
  public void endParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2, Member paramMember)
  {
    if (!(paramMember instanceof Method)) {}
    while ((!shouldDumpMethod(paramString1)) || ((paramMember.getAccessFlags() & 0x500) != 0)) {
      return;
    }
    paramByteArray = new ConcreteMethod((Method)paramMember, this.classFile, true, true);
    if (this.rop)
    {
      ropDump(paramByteArray);
      return;
    }
    regularDump(paramByteArray);
  }
  
  public void parsed(ByteArray paramByteArray, int paramInt1, int paramInt2, String paramString)
  {
    if (!this.suppressDump) {
      super.parsed(paramByteArray, paramInt1, paramInt2, paramString);
    }
  }
  
  protected boolean shouldDumpMethod(String paramString)
  {
    return (this.args.method == null) || (this.args.method.equals(paramString));
  }
  
  public void startParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2)
  {
    if (paramString2.indexOf('(') < 0) {}
    while (!shouldDumpMethod(paramString1)) {
      return;
    }
    setAt(paramByteArray, paramInt);
    this.suppressDump = false;
    if (this.first) {
      this.first = false;
    }
    for (;;)
    {
      parsed(paramByteArray, paramInt, 0, "method " + paramString1 + " " + paramString2);
      this.suppressDump = true;
      return;
      parsed(paramByteArray, paramInt, 0, "\n");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dump.BlockDumper
 * JD-Core Version:    0.7.0.1
 */