import android.util.Log;
import com.tencent.mobileqq.together.writetogether.websocket.msg.ConnClosedMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class beqr
  extends WebSocketListener
{
  beqr(beqq parambeqq) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, "onClosed");
    beqq.a(this.a).set(false);
    beqq.a(this.a, null);
    if (this.a.a != null) {
      this.a.a.onClosed(paramWebSocket, paramInt, paramString);
    }
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    QLog.e("WriteTogether.WriteTogetherWebSocketEngine", 1, "openWebSocketConn onFailure, e = " + Log.getStackTraceString(paramThrowable));
    if (this.a.a != null) {
      this.a.a.onFailure(paramWebSocket, paramThrowable, paramResponse);
    }
    if (((paramThrowable instanceof EOFException)) || ((paramThrowable instanceof SocketException)) || ((paramThrowable instanceof SSLException)))
    {
      this.a.b();
      beqq.a(this.a).a(new ConnClosedMsg());
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 2, new Object[] { "onMessage: ", paramString });
    }
    beqq.a(this.a).a(paramString);
    if (this.a.a != null) {
      this.a.a.onMessage(paramWebSocket, paramString);
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    beqq.a(this.a).a(paramByteString);
    if (this.a.a != null) {
      this.a.a.onMessage(paramWebSocket, paramByteString);
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, "onOpen");
    beqq.a(this.a, paramWebSocket);
    if (!beqq.a(this.a).get())
    {
      beqq.a(this.a).set(true);
      if (this.a.a != null) {
        this.a.a.onOpen(paramWebSocket, paramResponse);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqr
 * JD-Core Version:    0.7.0.1
 */