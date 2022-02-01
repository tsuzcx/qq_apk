package com.android.dx.dex.cf;

import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.RopMethod;
import java.io.PrintStream;

public final class CodeStatistics
{
  private static final boolean DEBUG = false;
  public static int dexRunningDeltaInsns = 0;
  public static int dexRunningDeltaRegisters;
  public static int dexRunningTotalInsns = 0;
  public static int runningDeltaInsns;
  public static int runningDeltaRegisters = 0;
  public static int runningOriginalBytes = 0;
  public static int runningTotalInsns;
  
  static
  {
    runningDeltaInsns = 0;
    runningTotalInsns = 0;
    dexRunningDeltaRegisters = 0;
  }
  
  public static void dumpStatistics(PrintStream paramPrintStream)
  {
    paramPrintStream.printf("Optimizer Delta Rop Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", new Object[] { Integer.valueOf(runningDeltaInsns), Integer.valueOf(runningTotalInsns), Double.valueOf(runningDeltaInsns / (runningTotalInsns + Math.abs(runningDeltaInsns)) * 100.0D), Integer.valueOf(runningDeltaRegisters) });
    paramPrintStream.printf("Optimizer Delta Dex Insns: Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", new Object[] { Integer.valueOf(dexRunningDeltaInsns), Integer.valueOf(dexRunningTotalInsns), Double.valueOf(dexRunningDeltaInsns / (dexRunningTotalInsns + Math.abs(dexRunningDeltaInsns)) * 100.0D), Integer.valueOf(dexRunningDeltaRegisters) });
    paramPrintStream.printf("Original bytecode byte count: %d\n", new Object[] { Integer.valueOf(runningOriginalBytes) });
  }
  
  public static void updateDexStatistics(DalvCode paramDalvCode1, DalvCode paramDalvCode2)
  {
    dexRunningDeltaInsns += paramDalvCode2.getInsns().codeSize() - paramDalvCode1.getInsns().codeSize();
    dexRunningDeltaRegisters += paramDalvCode2.getInsns().getRegistersSize() - paramDalvCode1.getInsns().getRegistersSize();
    dexRunningTotalInsns += paramDalvCode2.getInsns().codeSize();
  }
  
  public static void updateOriginalByteCount(int paramInt)
  {
    runningOriginalBytes += paramInt;
  }
  
  public static void updateRopStatistics(RopMethod paramRopMethod1, RopMethod paramRopMethod2)
  {
    int i = paramRopMethod1.getBlocks().getEffectiveInstructionCount();
    int j = paramRopMethod1.getBlocks().getRegCount();
    int k = paramRopMethod2.getBlocks().getEffectiveInstructionCount();
    runningDeltaInsns = k - i + runningDeltaInsns;
    runningDeltaRegisters += paramRopMethod2.getBlocks().getRegCount() - j;
    runningTotalInsns += k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.cf.CodeStatistics
 * JD-Core Version:    0.7.0.1
 */