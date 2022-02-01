package com.tencent.mm.game.liblockstep;

class LockStepNative$2
  implements LockStepNative.ILockStepReportListener
{
  LockStepNative$2(LockStepNative paramLockStepNative, LockStepNative.ILockStepReportListener paramILockStepReportListener) {}
  
  public int getNetworkType()
  {
    return this.a.getNetworkType();
  }
  
  public void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    this.a.onIdKeyStat(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
  }
  
  public void onKvStat(int paramInt, String paramString)
  {
    this.a.onKvStat(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.game.liblockstep.LockStepNative.2
 * JD-Core Version:    0.7.0.1
 */