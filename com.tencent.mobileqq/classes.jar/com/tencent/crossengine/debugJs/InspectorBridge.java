package com.tencent.crossengine.debugJs;

import com.tencent.crossengine.log.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/crossengine/debugJs/InspectorBridge;", "", "()V", "debugMessageListener", "com/tencent/crossengine/debugJs/InspectorBridge$debugMessageListener$1", "Lcom/tencent/crossengine/debugJs/InspectorBridge$debugMessageListener$1;", "mProxy", "Lcom/tencent/crossengine/debugJs/InspectorAgent;", "nativeInstance", "", "nativeCreate", "sendMessageToDebugger", "", "message", "", "setProxy", "proxy", "Companion", "library_release"}, k=1, mv={1, 1, 16})
public final class InspectorBridge
{
  public static final InspectorBridge.Companion Companion = new InspectorBridge.Companion(null);
  private static final String TAG = "InspectorBridge";
  private final InspectorBridge.debugMessageListener.1 debugMessageListener;
  private InspectorAgent mProxy;
  private final long nativeInstance;
  
  public InspectorBridge()
  {
    try
    {
      l = nativeCreate();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      long l;
      label12:
      break label12;
    }
    l = nativeCreate();
    this.nativeInstance = l;
    this.debugMessageListener = new InspectorBridge.debugMessageListener.1(this);
  }
  
  private final native long nativeCreate();
  
  private final void sendMessageToDebugger(String paramString)
  {
    try
    {
      localObject = this.mProxy;
      if (localObject != null)
      {
        ((InspectorAgent)localObject).a(paramString);
        localObject = Unit.INSTANCE;
        return;
      }
    }
    catch (Throwable paramString)
    {
      break label46;
      Object localObject = this.mProxy;
      if (localObject != null)
      {
        ((InspectorAgent)localObject).a(paramString);
        paramString = Unit.INSTANCE;
        return;
        Logger.d("InspectorBridge", "sendMessageToDebugger", paramString);
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label25:
      label46:
      break label25;
    }
  }
  
  @JvmStatic
  private static final native void sendMessageToEngine(long paramLong, String paramString);
  
  public final void setProxy(@NotNull InspectorAgent paramInspectorAgent)
  {
    Intrinsics.checkParameterIsNotNull(paramInspectorAgent, "proxy");
    this.mProxy = paramInspectorAgent;
    paramInspectorAgent.a((InspectorAgent.DebuggerMessageListener)this.debugMessageListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.InspectorBridge
 * JD-Core Version:    0.7.0.1
 */