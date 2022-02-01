package com.tencent.crossengine.debugJs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/crossengine/debugJs/InspectorBridge$debugMessageListener$1", "Lcom/tencent/crossengine/debugJs/InspectorAgent$DebuggerMessageListener;", "real", "getReal", "()Lcom/tencent/crossengine/debugJs/InspectorAgent$DebuggerMessageListener;", "setReal", "(Lcom/tencent/crossengine/debugJs/InspectorAgent$DebuggerMessageListener;)V", "sendMessageToEngine", "", "message", "", "library_release"}, k=1, mv={1, 1, 16})
public final class InspectorBridge$debugMessageListener$1
  implements InspectorAgent.DebuggerMessageListener
{
  @Nullable
  private InspectorAgent.DebuggerMessageListener b = (InspectorAgent.DebuggerMessageListener)new InspectorBridge.debugMessageListener.1.real.1(this);
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    InspectorAgent.DebuggerMessageListener localDebuggerMessageListener = this.b;
    if (localDebuggerMessageListener != null) {
      localDebuggerMessageListener.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.InspectorBridge.debugMessageListener.1
 * JD-Core Version:    0.7.0.1
 */