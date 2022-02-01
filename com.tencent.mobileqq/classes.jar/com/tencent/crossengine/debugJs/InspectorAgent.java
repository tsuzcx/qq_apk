package com.tencent.crossengine.debugJs;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/crossengine/debugJs/InspectorAgent;", "", "destroy", "", "sendMessageToDebugger", "message", "", "setOnDebuggerMessageListener", "listener", "Lcom/tencent/crossengine/debugJs/InspectorAgent$DebuggerMessageListener;", "DebuggerMessageListener", "library_release"}, k=1, mv={1, 1, 16})
public abstract interface InspectorAgent
{
  public abstract void a(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener);
  
  public abstract void a(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.InspectorAgent
 * JD-Core Version:    0.7.0.1
 */