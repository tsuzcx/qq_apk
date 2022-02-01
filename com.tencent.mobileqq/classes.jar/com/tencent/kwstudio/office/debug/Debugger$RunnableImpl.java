package com.tencent.kwstudio.office.debug;

final class Debugger$RunnableImpl
  implements Runnable
{
  private static final int JOB_TYPE_CLEAN_CACHE = 3;
  private static final int JOB_TYPE_CLEAN_PLUGIN = 1;
  private static final int JOB_TYPE_UPGRADE_PLUGIN = 2;
  private final Debugger.IDebugCallback mCallback;
  private final int mJobType;
  private final String mModuleId;
  
  private Debugger$RunnableImpl(int paramInt, String paramString, Debugger.IDebugCallback paramIDebugCallback)
  {
    this.mJobType = paramInt;
    this.mModuleId = paramString;
    this.mCallback = paramIDebugCallback;
  }
  
  public void run()
  {
    int i = -1;
    int n = Debugger.access$400(this.mModuleId);
    if (n > 0)
    {
      int k = 0;
      int m = 1;
      if (k < n)
      {
        IDebugger localIDebugger = Debugger.access$500(this.mModuleId, k);
        i = m;
        if (localIDebugger != null) {
          switch (this.mJobType)
          {
          default: 
            i = m;
          }
        }
        for (;;)
        {
          k += 1;
          m = i;
          break;
          j = m & localIDebugger.discardPlugin(Noumenon.sHostInterface);
          continue;
          j = m & localIDebugger.upgradePlugin(Noumenon.sHostInterface);
          continue;
          j = m & localIDebugger.cleanCache(Noumenon.sHostInterface);
        }
      }
      if (m == 0) {
        break label177;
      }
    }
    label177:
    for (int j = 0;; j = 1)
    {
      if (this.mCallback != null) {}
      switch (this.mJobType)
      {
      default: 
        return;
      }
    }
    this.mCallback.onCleanPlugin(this.mModuleId, j);
    return;
    this.mCallback.onUpgradePlugin(this.mModuleId, j);
    return;
    this.mCallback.onCleanCache(this.mModuleId, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger.RunnableImpl
 * JD-Core Version:    0.7.0.1
 */