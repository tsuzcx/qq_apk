package com.eclipsesource.v8.inspector;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V8Inspector
{
  private List<DebuggerConnectionListener> debuggerConnectionListeners;
  private long inspectorPtr = 0L;
  private V8 runtime;
  private boolean waitingForConnection = true;
  
  protected V8Inspector(V8 paramV8, V8InspectorDelegate paramV8InspectorDelegate, String paramString)
  {
    this.runtime = paramV8;
    this.inspectorPtr = paramV8.createInspector(paramV8InspectorDelegate, paramString);
    this.debuggerConnectionListeners = new ArrayList();
  }
  
  public static V8Inspector createV8Inspector(V8 paramV8, V8InspectorDelegate paramV8InspectorDelegate)
  {
    return new V8Inspector(paramV8, paramV8InspectorDelegate, null);
  }
  
  public static V8Inspector createV8Inspector(V8 paramV8, V8InspectorDelegate paramV8InspectorDelegate, String paramString)
  {
    return new V8Inspector(paramV8, paramV8InspectorDelegate, paramString);
  }
  
  private void verifyDebuggerConnection(String paramString)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    try
    {
      V8 localV8 = this.runtime;
      localObject = localIterator;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = localIterator;
      localStringBuilder.append("JSON.parse(JSON.stringify(");
      localObject = localIterator;
      localStringBuilder.append(paramString);
      localObject = localIterator;
      localStringBuilder.append("))");
      localObject = localIterator;
      paramString = localV8.executeObjectScript(localStringBuilder.toString());
      localObject = paramString;
      if (paramString.getString("method").equals("Runtime.runIfWaitingForDebugger"))
      {
        localObject = paramString;
        this.waitingForConnection = false;
        localObject = paramString;
        this.runtime.schedulePauseOnNextStatement(this.inspectorPtr, "");
        localObject = paramString;
        localIterator = this.debuggerConnectionListeners.iterator();
        for (;;)
        {
          localObject = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = paramString;
          ((DebuggerConnectionListener)localIterator.next()).onDebuggerConnected();
        }
      }
      if (paramString != null) {
        paramString.close();
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        ((V8Object)localObject).close();
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void addDebuggerConnectionListener(DebuggerConnectionListener paramDebuggerConnectionListener)
  {
    this.debuggerConnectionListeners.add(paramDebuggerConnectionListener);
  }
  
  public void dispatchProtocolMessage(String paramString)
  {
    try
    {
      this.runtime.dispatchProtocolMessage(this.inspectorPtr, paramString);
      if (this.waitingForConnection)
      {
        verifyDebuggerConnection(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void removeDebuggerConnectionListener(DebuggerConnectionListener paramDebuggerConnectionListener)
  {
    this.debuggerConnectionListeners.remove(paramDebuggerConnectionListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.inspector.V8Inspector
 * JD-Core Version:    0.7.0.1
 */