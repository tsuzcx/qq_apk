package com.tencent.crossengine.debugJs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.crossengine.log.Logger;
import org.java_websocket.WebSocket;

public class WebSocketServerInspectAgent
  implements InspectorAgent
{
  private final int jdField_a_of_type_Int = (int)(Math.random() * 10000.0D);
  private InspectorAgent.DebuggerMessageListener jdField_a_of_type_ComTencentCrossengineDebugJsInspectorAgent$DebuggerMessageListener;
  private final WebSocketServerInspectAgent.AgentServer jdField_a_of_type_ComTencentCrossengineDebugJsWebSocketServerInspectAgent$AgentServer;
  private String jdField_a_of_type_JavaLangString;
  private WebSocket jdField_a_of_type_OrgJava_websocketWebSocket;
  
  public WebSocketServerInspectAgent(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentCrossengineDebugJsWebSocketServerInspectAgent$AgentServer = new WebSocketServerInspectAgent.AgentServer(this, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentCrossengineDebugJsWebSocketServerInspectAgent$AgentServer.start();
  }
  
  public void a(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener)
  {
    this.jdField_a_of_type_ComTencentCrossengineDebugJsInspectorAgent$DebuggerMessageListener = paramDebuggerMessageListener;
  }
  
  public void a(@NonNull String paramString)
  {
    Object localObject = this.jdField_a_of_type_OrgJava_websocketWebSocket;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.debugJs.WebSocketServerInspectAgent
 * JD-Core Version:    0.7.0.1
 */