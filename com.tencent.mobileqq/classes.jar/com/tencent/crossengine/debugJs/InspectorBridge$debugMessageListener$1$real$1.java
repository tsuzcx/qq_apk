package com.tencent.crossengine.debugJs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/crossengine/debugJs/InspectorBridge$debugMessageListener$1$real$1", "Lcom/tencent/crossengine/debugJs/InspectorAgent$DebuggerMessageListener;", "sendMessageToEngine", "", "message", "", "library_release"}, k=1, mv={1, 1, 16})
public final class InspectorBridge$debugMessageListener$1$real$1
  implements InspectorAgent.DebuggerMessageListener
{
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    try
    {
      InspectorBridge.Companion.a(InspectorBridge.Companion, InspectorBridge.access$getNativeInstance$p(this.a.a), paramString);
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label28:
      break label28;
    }
    InspectorBridge.Companion.a(InspectorBridge.Companion, InspectorBridge.access$getNativeInstance$p(this.a.a), paramString);
    paramString = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.InspectorBridge.debugMessageListener.1.real.1
 * JD-Core Version:    0.7.0.1
 */