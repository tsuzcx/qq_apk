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
    int n = Debugger.access$400(this.mModuleId);
    int i;
    int j;
    if (n > 0)
    {
      int m = 0;
      i = 0;
      int k;
      for (j = 1; i < n; j = k)
      {
        localObject = Debugger.access$500(this.mModuleId, i);
        k = j;
        if (localObject != null)
        {
          k = this.mJobType;
          int i1;
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3)
              {
                k = j;
                break label116;
              }
              i1 = ((IDebugger)localObject).cleanCache(Noumenon.sHostInterface);
            }
            else
            {
              i1 = ((IDebugger)localObject).upgradePlugin(Noumenon.sHostInterface);
            }
          }
          else {
            i1 = ((IDebugger)localObject).discardPlugin(Noumenon.sHostInterface);
          }
          k = j & i1;
        }
        label116:
        i += 1;
      }
      if (j != 0) {
        i = m;
      } else {
        i = 1;
      }
    }
    else
    {
      i = -1;
    }
    Object localObject = this.mCallback;
    if (localObject != null)
    {
      j = this.mJobType;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return;
          }
          ((Debugger.IDebugCallback)localObject).onCleanCache(this.mModuleId, i);
          return;
        }
        ((Debugger.IDebugCallback)localObject).onUpgradePlugin(this.mModuleId, i);
        return;
      }
      ((Debugger.IDebugCallback)localObject).onCleanPlugin(this.mModuleId, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger.RunnableImpl
 * JD-Core Version:    0.7.0.1
 */