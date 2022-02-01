package com.tencent.crossengine.debugJs;

import com.tencent.crossengine.log.Logger;
import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

class WebSocketServerInspectAgent$AgentServer
  extends WebSocketServer
{
  private final int a;
  
  WebSocketServerInspectAgent$AgentServer(WebSocketServerInspectAgent paramWebSocketServerInspectAgent, int paramInt)
  {
    super(new InetSocketAddress(paramInt));
    this.a = paramInt;
    setConnectionLostTimeout(2147483647);
  }
  
  public void onClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Debugger disconnected ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramWebSocket);
    Logger.c("AgentServer", localStringBuilder.toString());
    WebSocketServerInspectAgent.a(this.this$0, null);
  }
  
  public void onError(WebSocket paramWebSocket, Exception paramException)
  {
    WebSocketServerInspectAgent.a(this.this$0, null);
    Logger.c("AgentServer", "ScriptEngine Inspector Debugger server failed", paramException);
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    if (WebSocketServerInspectAgent.a(this.this$0) != null)
    {
      WebSocketServerInspectAgent.a(this.this$0).a(paramString);
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("<< ");
      paramWebSocket.append(paramString);
      Logger.b("AgentServer", paramWebSocket.toString());
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake)
  {
    WebSocketServerInspectAgent.a(this.this$0, paramWebSocket);
    paramClientHandshake = new StringBuilder();
    paramClientHandshake.append("Debugger connected ");
    paramClientHandshake.append(paramWebSocket);
    Logger.c("AgentServer", paramClientHandshake.toString());
  }
  
  public void onStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("World ");
    localStringBuilder.append(WebSocketServerInspectAgent.a(this.this$0));
    localStringBuilder.append(" ScriptEngine Inspector Debugger server successfully started on port:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\nfollow the steps to start debug:\n1. adb forward tcp:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" tcp:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n2. open chrome with url to start inspect\ndevtools://devtools/bundled/js_app.html?ws=localhost:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\nREADME: https://docs.qq.com/doc/DZmtmYUdMdXZ2a3lm");
    Logger.b("AgentServer", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.WebSocketServerInspectAgent.AgentServer
 * JD-Core Version:    0.7.0.1
 */