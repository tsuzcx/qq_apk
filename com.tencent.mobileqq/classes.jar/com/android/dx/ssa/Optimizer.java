package com.android.dx.ssa;

import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.ssa.back.LivenessAnalyzer;
import com.android.dx.ssa.back.SsaToRop;
import java.util.EnumSet;

public class Optimizer
{
  private static TranslationAdvice advice;
  private static boolean preserveLocals = true;
  
  public static SsaMethod debugDeadCodeRemover(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice)
  {
    preserveLocals = paramBoolean2;
    advice = paramTranslationAdvice;
    paramRopMethod = SsaConverter.convertToSsaMethod(paramRopMethod, paramInt, paramBoolean1);
    DeadCodeRemover.process(paramRopMethod);
    return paramRopMethod;
  }
  
  public static SsaMethod debugEdgeSplit(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice)
  {
    preserveLocals = paramBoolean2;
    advice = paramTranslationAdvice;
    return SsaConverter.testEdgeSplit(paramRopMethod, paramInt, paramBoolean1);
  }
  
  public static SsaMethod debugNoRegisterAllocation(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice, EnumSet<Optimizer.OptionalStep> paramEnumSet)
  {
    preserveLocals = paramBoolean2;
    advice = paramTranslationAdvice;
    paramRopMethod = SsaConverter.convertToSsaMethod(paramRopMethod, paramInt, paramBoolean1);
    runSsaFormSteps(paramRopMethod, paramEnumSet);
    LivenessAnalyzer.constructInterferenceGraph(paramRopMethod);
    return paramRopMethod;
  }
  
  public static SsaMethod debugPhiPlacement(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice)
  {
    preserveLocals = paramBoolean2;
    advice = paramTranslationAdvice;
    return SsaConverter.testPhiPlacement(paramRopMethod, paramInt, paramBoolean1);
  }
  
  public static SsaMethod debugRenaming(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice)
  {
    preserveLocals = paramBoolean2;
    advice = paramTranslationAdvice;
    return SsaConverter.convertToSsaMethod(paramRopMethod, paramInt, paramBoolean1);
  }
  
  public static TranslationAdvice getAdvice()
  {
    return advice;
  }
  
  public static boolean getPreserveLocals()
  {
    return preserveLocals;
  }
  
  public static RopMethod optimize(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice)
  {
    return optimize(paramRopMethod, paramInt, paramBoolean1, paramBoolean2, paramTranslationAdvice, EnumSet.allOf(Optimizer.OptionalStep.class));
  }
  
  public static RopMethod optimize(RopMethod paramRopMethod, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TranslationAdvice paramTranslationAdvice, EnumSet<Optimizer.OptionalStep> paramEnumSet)
  {
    preserveLocals = paramBoolean2;
    advice = paramTranslationAdvice;
    paramTranslationAdvice = SsaConverter.convertToSsaMethod(paramRopMethod, paramInt, paramBoolean1);
    runSsaFormSteps(paramTranslationAdvice, paramEnumSet);
    RopMethod localRopMethod = SsaToRop.convertToRopMethod(paramTranslationAdvice, false);
    paramTranslationAdvice = localRopMethod;
    if (localRopMethod.getBlocks().getRegCount() > advice.getMaxOptimalRegisterCount()) {
      paramTranslationAdvice = optimizeMinimizeRegisters(paramRopMethod, paramInt, paramBoolean1, paramEnumSet);
    }
    return paramTranslationAdvice;
  }
  
  private static RopMethod optimizeMinimizeRegisters(RopMethod paramRopMethod, int paramInt, boolean paramBoolean, EnumSet<Optimizer.OptionalStep> paramEnumSet)
  {
    paramRopMethod = SsaConverter.convertToSsaMethod(paramRopMethod, paramInt, paramBoolean);
    paramEnumSet = paramEnumSet.clone();
    paramEnumSet.remove(Optimizer.OptionalStep.CONST_COLLECTOR);
    runSsaFormSteps(paramRopMethod, paramEnumSet);
    return SsaToRop.convertToRopMethod(paramRopMethod, true);
  }
  
  private static void runSsaFormSteps(SsaMethod paramSsaMethod, EnumSet<Optimizer.OptionalStep> paramEnumSet)
  {
    int j = 0;
    int i = 1;
    if (paramEnumSet.contains(Optimizer.OptionalStep.MOVE_PARAM_COMBINER)) {
      MoveParamCombiner.process(paramSsaMethod);
    }
    if (paramEnumSet.contains(Optimizer.OptionalStep.SCCP))
    {
      SCCP.process(paramSsaMethod);
      DeadCodeRemover.process(paramSsaMethod);
      i = 0;
    }
    if (paramEnumSet.contains(Optimizer.OptionalStep.LITERAL_UPGRADE))
    {
      LiteralOpUpgrader.process(paramSsaMethod);
      DeadCodeRemover.process(paramSsaMethod);
      i = 0;
    }
    paramEnumSet.remove(Optimizer.OptionalStep.ESCAPE_ANALYSIS);
    if (paramEnumSet.contains(Optimizer.OptionalStep.ESCAPE_ANALYSIS))
    {
      EscapeAnalysis.process(paramSsaMethod);
      DeadCodeRemover.process(paramSsaMethod);
      i = 0;
    }
    if (paramEnumSet.contains(Optimizer.OptionalStep.CONST_COLLECTOR))
    {
      ConstCollector.process(paramSsaMethod);
      DeadCodeRemover.process(paramSsaMethod);
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        DeadCodeRemover.process(paramSsaMethod);
      }
      PhiTypeResolver.process(paramSsaMethod);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.Optimizer
 * JD-Core Version:    0.7.0.1
 */