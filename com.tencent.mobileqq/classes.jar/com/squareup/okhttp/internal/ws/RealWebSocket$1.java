package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocketListener;
import java.util.concurrent.Executor;
import okio.Buffer;

class RealWebSocket$1
  implements WebSocketReader.FrameCallback
{
  RealWebSocket$1(RealWebSocket paramRealWebSocket, WebSocketListener paramWebSocketListener, Executor paramExecutor, String paramString) {}
  
  public void onClose(int paramInt, String paramString)
  {
    RealWebSocket.access$102(this.this$0, true);
    this.val$replyExecutor.execute(new RealWebSocket.1.2(this, "OkHttp %s WebSocket Close Reply", new Object[] { this.val$url }, paramInt, paramString));
  }
  
  public void onMessage(ResponseBody paramResponseBody)
  {
    this.val$listener.onMessage(paramResponseBody);
  }
  
  public void onPing(Buffer paramBuffer)
  {
    this.val$replyExecutor.execute(new RealWebSocket.1.1(this, "OkHttp %s WebSocket Pong Reply", new Object[] { this.val$url }, paramBuffer));
  }
  
  public void onPong(Buffer paramBuffer)
  {
    this.val$listener.onPong(paramBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.RealWebSocket.1
 * JD-Core Version:    0.7.0.1
 */