package com.tencent.biz.expand.utils;

import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/LoadingLifecycle;", "Lcom/tencent/mobileqq/app/guardinterface/IGuardInterface;", "applicationBackgroundListener", "Lcom/tencent/biz/expand/utils/OnApplicationBackgroundListener;", "(Lcom/tencent/biz/expand/utils/OnApplicationBackgroundListener;)V", "getApplicationBackgroundListener", "()Lcom/tencent/biz/expand/utils/OnApplicationBackgroundListener;", "setApplicationBackgroundListener", "onApplicationBackground", "", "onApplicationForeground", "onBackgroundTimeTick", "tick", "", "onBackgroundUnguardTimeTick", "onLiteTimeTick", "onScreensStateChanged", "isEnabled", "", "removeOnBackgroundListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LoadingLifecycle
  implements IGuardInterface
{
  @Nullable
  private OnApplicationBackgroundListener a;
  
  public LoadingLifecycle(@Nullable OnApplicationBackgroundListener paramOnApplicationBackgroundListener)
  {
    this.a = paramOnApplicationBackgroundListener;
  }
  
  public void a() {}
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    OnApplicationBackgroundListener localOnApplicationBackgroundListener = this.a;
    if (localOnApplicationBackgroundListener != null) {
      localOnApplicationBackgroundListener.a();
    }
  }
  
  public void b(long paramLong) {}
  
  public final void c()
  {
    this.a = ((OnApplicationBackgroundListener)null);
  }
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.LoadingLifecycle
 * JD-Core Version:    0.7.0.1
 */