package com.tencent.mm.game.liblockstep;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.HashMap;

@Keep
public class LockStepNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_LOCKSTEP_ERROR = -1000;
  public static int REPEAT_INIT_ERROR = -1001;
  public static String TAG = "LockStepNative";
  private boolean initCallBackFlag = false;
  volatile long mNativeInst = 0L;
  
  @Keep
  public LockStepNative(long paramLong1, long paramLong2, long paramLong3)
  {
    this.mNativeInst = initBindingLockStep(paramLong1, paramLong2, paramLong3);
  }
  
  private native void destoryBindingLockStep(long paramLong);
  
  private native long initBindingLockStep(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, LockStepNative.ILockStepListener paramILockStepListener, LockStepNative.ILockStepReportListener paramILockStepReportListener);
  
  private static native void initConfigLockStep(long paramLong, HashMap<String, String> paramHashMap);
  
  public static native void test();
  
  private native void testLockStepBinding(long paramLong);
  
  private native void updateNativeUdpInterface(long paramLong1, long paramLong2);
  
  @Keep
  public void destoryLockStep()
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingLockStep(this.mNativeInst);
      this.mNativeInst = -1L;
    }
  }
  
  @Keep
  public void initConfig(HashMap<String, String> paramHashMap)
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    initConfigLockStep(this.mNativeInst, paramHashMap);
  }
  
  @Keep
  public int setCallback(LockStepNative.ILockStepListener paramILockStepListener, LockStepNative.ILockStepReportListener paramILockStepReportListener)
  {
    if (this.mNativeInst == -1L) {
      return NEW_LOCKSTEP_ERROR;
    }
    if (!this.initCallBackFlag)
    {
      int i = initCallBack(this.mNativeInst, new LockStepNative.1(this, paramILockStepListener), new LockStepNative.2(this, paramILockStepReportListener));
      if (i == 0)
      {
        this.initCallBackFlag = true;
        return i;
      }
      return INIT_ERROR;
    }
    return REPEAT_INIT_ERROR;
  }
  
  public void testLockStepBinding()
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    testLockStepBinding(this.mNativeInst);
  }
  
  @Keep
  public void updateNativeInterface(long paramLong)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmudp updateNativeInterface mNativeInst:");
    localStringBuilder.append(this.mNativeInst);
    localStringBuilder.append(",locksteplogicId:");
    localStringBuilder.append(paramLong);
    Log.i(str, localStringBuilder.toString());
    if (this.mNativeInst == -1L) {
      return;
    }
    updateNativeUdpInterface(this.mNativeInst, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.game.liblockstep.LockStepNative
 * JD-Core Version:    0.7.0.1
 */