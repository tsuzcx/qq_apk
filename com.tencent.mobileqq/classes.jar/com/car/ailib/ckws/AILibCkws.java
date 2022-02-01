package com.car.ailib.ckws;

import java.util.ArrayList;

public class AILibCkws
{
  public static int exit()
  {
    return nativeExit();
  }
  
  public static int getCkwsInfo(AILibCkwsOutParam paramAILibCkwsOutParam)
  {
    return nativeGetCkwsInfo(paramAILibCkwsOutParam);
  }
  
  public static String getVersion()
  {
    return nativeGetVerison();
  }
  
  public static int init(String paramString, int paramInt)
  {
    return nativeInit(paramString, paramInt);
  }
  
  private static native int nativeExit();
  
  private static native int nativeGetCkwsInfo(AILibCkwsOutParam paramAILibCkwsOutParam);
  
  private static native String nativeGetVerison();
  
  private static native int nativeInit(String paramString, int paramInt);
  
  private static native int nativeProcess(AILibCkwsParam paramAILibCkwsParam);
  
  private static native int nativeReset();
  
  private static native int nativeSetWords(ArrayList<String> paramArrayList, ArrayList<Float> paramArrayList1);
  
  public static int process(AILibCkwsParam paramAILibCkwsParam)
  {
    return nativeProcess(paramAILibCkwsParam);
  }
  
  public static int reset()
  {
    return nativeReset();
  }
  
  public static int setWords(ArrayList<String> paramArrayList, ArrayList<Float> paramArrayList1)
  {
    return nativeSetWords(paramArrayList, paramArrayList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.car.ailib.ckws.AILibCkws
 * JD-Core Version:    0.7.0.1
 */