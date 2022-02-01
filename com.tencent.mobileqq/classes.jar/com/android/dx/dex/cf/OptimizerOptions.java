package com.android.dx.dex.cf;

import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.ssa.Optimizer;
import com.android.dx.ssa.Optimizer.OptionalStep;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.EnumSet;
import java.util.HashSet;

public class OptimizerOptions
{
  private static HashSet<String> dontOptimizeList;
  private static HashSet<String> optimizeList;
  private static boolean optimizeListsLoaded;
  
  public static void compareOptimizerStep(RopMethod paramRopMethod1, int paramInt, boolean paramBoolean, CfOptions paramCfOptions, TranslationAdvice paramTranslationAdvice, RopMethod paramRopMethod2)
  {
    EnumSet localEnumSet = EnumSet.allOf(Optimizer.OptionalStep.class);
    localEnumSet.remove(Optimizer.OptionalStep.CONST_COLLECTOR);
    paramRopMethod1 = Optimizer.optimize(paramRopMethod1, paramInt, paramBoolean, paramCfOptions.localInfo, paramTranslationAdvice, localEnumSet);
    paramInt = paramRopMethod2.getBlocks().getEffectiveInstructionCount();
    int i = paramRopMethod1.getBlocks().getEffectiveInstructionCount();
    System.err.printf("optimize step regs:(%d/%d/%.2f%%) insns:(%d/%d/%.2f%%)\n", new Object[] { Integer.valueOf(paramRopMethod2.getBlocks().getRegCount()), Integer.valueOf(paramRopMethod1.getBlocks().getRegCount()), Double.valueOf(100.0D * ((paramRopMethod1.getBlocks().getRegCount() - paramRopMethod2.getBlocks().getRegCount()) / paramRopMethod1.getBlocks().getRegCount())), Integer.valueOf(paramInt), Integer.valueOf(i), Double.valueOf(100.0D * ((i - paramInt) / i)) });
  }
  
  public static void loadOptimizeLists(String paramString1, String paramString2)
  {
    if (optimizeListsLoaded) {
      return;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      throw new RuntimeException("optimize and don't optimize lists  are mutually exclusive.");
    }
    if (paramString1 != null) {
      optimizeList = loadStringsFromFile(paramString1);
    }
    if (paramString2 != null) {
      dontOptimizeList = loadStringsFromFile(paramString2);
    }
    optimizeListsLoaded = true;
  }
  
  private static HashSet<String> loadStringsFromFile(String paramString)
  {
    HashSet localHashSet = new HashSet();
    try
    {
      FileReader localFileReader = new FileReader(paramString);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localHashSet.add(str);
      }
      localFileReader.close();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Error with optimize list: " + paramString, localIOException);
    }
    return localIOException;
  }
  
  public static boolean shouldOptimize(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (optimizeList != null) {
      bool1 = optimizeList.contains(paramString);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (dontOptimizeList == null);
      bool1 = bool2;
    } while (!dontOptimizeList.contains(paramString));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.cf.OptimizerOptions
 * JD-Core Version:    0.7.0.1
 */