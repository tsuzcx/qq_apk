package com.tencent.mobileqq.app;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/app/ViewActionObserver;", "Lmqq/observer/BusinessObserver;", "()V", "actionMap", "", "", "Lcom/tencent/mobileqq/app/ViewActionObserver$Action;", "onReceive", "", "type", "isSuccess", "", "bundle", "Landroid/os/Bundle;", "registerViewAction", "actionType", "action", "release", "Action", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ViewActionObserver
  implements BusinessObserver
{
  public static final ViewActionObserver.Companion a = new ViewActionObserver.Companion(null);
  private final Map<Integer, ViewActionObserver.Action> b = (Map)new LinkedHashMap();
  
  public final void a()
  {
    this.b.clear();
  }
  
  public final void a(int paramInt, @NotNull ViewActionObserver.Action paramAction)
  {
    Intrinsics.checkParameterIsNotNull(paramAction, "action");
    this.b.put(Integer.valueOf(paramInt), paramAction);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    ViewActionObserver.Action localAction = (ViewActionObserver.Action)this.b.get(Integer.valueOf(paramInt));
    if (localAction != null) {
      localAction.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ViewActionObserver
 * JD-Core Version:    0.7.0.1
 */