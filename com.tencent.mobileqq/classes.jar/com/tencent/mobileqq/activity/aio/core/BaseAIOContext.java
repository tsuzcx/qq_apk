package com.tencent.mobileqq.activity.aio.core;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import mqq.os.MqqHandler;

public abstract class BaseAIOContext
{
  @NonNull
  protected BaseSessionInfo d;
  
  public abstract void M();
  
  public abstract int N();
  
  @NonNull
  public BaseSessionInfo O()
  {
    return this.d;
  }
  
  public abstract <T extends IHelper> T a(int paramInt);
  
  public abstract boolean b(int paramInt);
  
  public abstract void e(int paramInt);
  
  public abstract MqqHandler g();
  
  public abstract PanelManager q();
  
  public abstract int v();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseAIOContext
 * JD-Core Version:    0.7.0.1
 */