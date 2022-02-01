package com.android.dx.command.dump;

import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.ssa.Optimizer;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.io.PrintStream;

public class DotDumper
  implements ParseObserver
{
  private final Args args;
  private final byte[] bytes;
  private DirectClassFile classFile;
  private final String filePath;
  private final boolean optimize;
  private final boolean strictParse;
  
  DotDumper(byte[] paramArrayOfByte, String paramString, Args paramArgs)
  {
    this.bytes = paramArrayOfByte;
    this.filePath = paramString;
    this.strictParse = paramArgs.strictParse;
    this.optimize = paramArgs.optimize;
    this.args = paramArgs;
  }
  
  static void dump(byte[] paramArrayOfByte, String paramString, Args paramArgs)
  {
    new DotDumper(paramArrayOfByte, paramString, paramArgs).run();
  }
  
  private void run()
  {
    Object localObject = new ByteArray(this.bytes);
    this.classFile = new DirectClassFile((ByteArray)localObject, this.filePath, this.strictParse);
    this.classFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
    this.classFile.getMagic();
    localObject = new DirectClassFile((ByteArray)localObject, this.filePath, this.strictParse);
    ((DirectClassFile)localObject).setAttributeFactory(StdAttributeFactory.THE_ONE);
    ((DirectClassFile)localObject).setObserver(this);
    ((DirectClassFile)localObject).getMagic();
  }
  
  public void changeIndent(int paramInt) {}
  
  public void endParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2, Member paramMember)
  {
    if (!(paramMember instanceof Method)) {}
    while (!shouldDumpMethod(paramString1)) {
      return;
    }
    paramMember = new ConcreteMethod((Method)paramMember, this.classFile, true, true);
    DexTranslationAdvice localDexTranslationAdvice = DexTranslationAdvice.THE_ONE;
    paramString2 = Ropper.convert(paramMember, localDexTranslationAdvice, this.classFile.getMethods());
    paramByteArray = paramString2;
    if (this.optimize)
    {
      boolean bool = AccessFlags.isStatic(paramMember.getAccessFlags());
      paramByteArray = Optimizer.optimize(paramString2, BaseDumper.computeParamWidth(paramMember, bool), bool, true, localDexTranslationAdvice);
    }
    System.out.println("digraph " + paramString1 + "{");
    System.out.println("\tfirst -> n" + Hex.u2(paramByteArray.getFirstLabel()) + ";");
    paramByteArray = paramByteArray.getBlocks();
    int j = paramByteArray.size();
    paramInt = 0;
    if (paramInt < j)
    {
      paramString1 = paramByteArray.get(paramInt);
      int k = paramString1.getLabel();
      paramString2 = paramString1.getSuccessors();
      if (paramString2.size() == 0) {
        System.out.println("\tn" + Hex.u2(k) + " -> returns;");
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (paramString2.size() == 1)
        {
          System.out.println("\tn" + Hex.u2(k) + " -> n" + Hex.u2(paramString2.get(0)) + ";");
        }
        else
        {
          System.out.print("\tn" + Hex.u2(k) + " -> {");
          int i = 0;
          while (i < paramString2.size())
          {
            int m = paramString2.get(i);
            if (m != paramString1.getPrimarySuccessor()) {
              System.out.print(" n" + Hex.u2(m) + " ");
            }
            i += 1;
          }
          System.out.println("};");
          System.out.println("\tn" + Hex.u2(k) + " -> n" + Hex.u2(paramString1.getPrimarySuccessor()) + " [label=\"primary\"];");
        }
      }
    }
    System.out.println("}");
  }
  
  public void parsed(ByteArray paramByteArray, int paramInt1, int paramInt2, String paramString) {}
  
  protected boolean shouldDumpMethod(String paramString)
  {
    return (this.args.method == null) || (this.args.method.equals(paramString));
  }
  
  public void startParsingMember(ByteArray paramByteArray, int paramInt, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dump.DotDumper
 * JD-Core Version:    0.7.0.1
 */