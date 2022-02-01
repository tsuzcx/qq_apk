package com.tencent.crossengine.debugJs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.crossengine.log.Logger;
import org.java_websocket.WebSocket;

public class WebSocketServerInspectAgent
  implements InspectorAgent
{
  private final int a = (int)(Math.random() * 10000.0D);
  private final WebSocketServerInspectAgent.AgentServer b;
  private WebSocket c;
  private InspectorAgent.DebuggerMessageListener d;
  private String e;
  
  public WebSocketServerInspectAgent(String paramString)
  {
    this.e = paramString;
    this.b = new WebSocketServerInspectAgent.AgentServer(this, this.a);
    this.b.start();
  }
  
  public void a(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener)
  {
    this.d = paramDebuggerMessageListener;
  }
  
  public void a(@NonNull String paramString)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((WebSocket)localObject).send(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">> ");
      ((StringBuilder)localObject).append(paramString);
      Logger.b("WebSocketServerInspectAgent", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.WebSocketServerInspectAgent
 * JD-Core Version:    0.7.0.1
 */