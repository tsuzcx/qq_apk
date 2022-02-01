package com.android.dx.command.dump;

import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.ssa.Optimizer;
import com.android.dx.ssa.Optimizer.OptionalStep;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;

public class SsaDumper
  extends BlockDumper
{
  private SsaDumper(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, Args paramArgs)
  {
    super(paramArrayOfByte, paramPrintStream, paramString, true, paramArgs);
  }
  
  public static void dump(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, Args paramArgs)
  {
    new SsaDumper(paramArrayOfByte, paramPrintStream, paramString, paramArgs).dump();
  }
  
  public void endParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2, Member paramMember)
  {
    if (!(paramMember instanceof Method)) {}
    while ((!shouldDumpMethod(paramString1)) || ((paramMember.getAccessFlags() & 0x500) != 0)) {
      return;
    }
    paramString1 = new ConcreteMethod((Method)paramMember, this.classFile, true, true);
    paramString2 = DexTranslationAdvice.THE_ONE;
    paramMember = Ropper.convert(paramString1, paramString2, this.classFile.getMethods());
    boolean bool = AccessFlags.isStatic(paramString1.getAccessFlags());
    paramInt = computeParamWidth(paramString1, bool);
    if (this.args.ssaStep == null) {
      paramString1 = Optimizer.debugNoRegisterAllocation(paramMember, paramInt, bool, true, paramString2, EnumSet.allOf(Optimizer.OptionalStep.class));
    }
    for (;;)
    {
      paramString2 = new StringBuffer(2000);
      paramString2.append("first ");
      paramString2.append(Hex.u2(paramString1.blockIndexToRopLabel(paramString1.getEntryBlockIndex())));
      paramString2.append('\n');
      paramMember = (ArrayList)paramString1.getBlocks().clone();
      Collections.sort(paramMember, SsaBasicBlock.LABEL_COMPARATOR);
      paramMember = paramMember.iterator();
      if (paramMember.hasNext())
      {
        SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)paramMember.next();
        paramString2.append("block ").append(Hex.u2(localSsaBasicBlock.getRopLabel())).append('\n');
        Object localObject = localSsaBasicBlock.getPredecessors();
        paramInt = ((BitSet)localObject).nextSetBit(0);
        for (;;)
        {
          if (paramInt >= 0)
          {
            paramString2.append("  pred ");
            paramString2.append(Hex.u2(paramString1.blockIndexToRopLabel(paramInt)));
            paramString2.append('\n');
            paramInt = ((BitSet)localObject).nextSetBit(paramInt + 1);
            continue;
            if ("edge-split".equals(this.args.ssaStep))
            {
              paramString1 = Optimizer.debugEdgeSplit(paramMember, paramInt, bool, true, paramString2);
              break;
            }
            if ("phi-placement".equals(this.args.ssaStep))
            {
              paramString1 = Optimizer.debugPhiPlacement(paramMember, paramInt, bool, true, paramString2);
              break;
            }
            if ("renaming".equals(this.args.ssaStep))
            {
              paramString1 = Optimizer.debugRenaming(paramMember, paramInt, bool, true, paramString2);
              break;
            }
            if (!"dead-code".equals(this.args.ssaStep)) {
              break label695;
            }
            paramString1 = Optimizer.debugDeadCodeRemover(paramMember, paramInt, bool, true, paramString2);
            break;
          }
        }
        paramString2.append("  live in:" + localSsaBasicBlock.getLiveInRegs());
        paramString2.append("\n");
        localObject = localSsaBasicBlock.getInsns().iterator();
        while (((Iterator)localObject).hasNext())
        {
          SsaInsn localSsaInsn = (SsaInsn)((Iterator)localObject).next();
          paramString2.append("  ");
          paramString2.append(localSsaInsn.toHuman());
          paramString2.append('\n');
        }
        if (localSsaBasicBlock.getSuccessors().cardinality() == 0) {
          paramString2.append("  returns\n");
        }
        for (;;)
        {
          paramString2.append("  live out:" + localSsaBasicBlock.getLiveOutRegs());
          paramString2.append("\n");
          break;
          int i = localSsaBasicBlock.getPrimarySuccessorRopLabel();
          localObject = localSsaBasicBlock.getRopLabelSuccessorList();
          int j = ((IntList)localObject).size();
          paramInt = 0;
          while (paramInt < j)
          {
            paramString2.append("  next ");
            paramString2.append(Hex.u2(((IntList)localObject).get(paramInt)));
            if ((j != 1) && (i == ((IntList)localObject).get(paramInt))) {
              paramString2.append(" *");
            }
            paramString2.append('\n');
            paramInt += 1;
          }
        }
      }
      this.suppressDump = false;
      setAt(paramByteArray, 0);
      parsed(paramByteArray, 0, paramByteArray.size(), paramString2.toString());
      this.suppressDump = true;
      return;
      label695:
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dump.SsaDumper
 * JD-Core Version:    0.7.0.1
 */