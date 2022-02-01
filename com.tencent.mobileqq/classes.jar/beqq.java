import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class beqq
{
  private beqs jdField_a_of_type_Beqs = new beqs();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  @Nullable
  private WebSocket jdField_a_of_type_Okhttp3WebSocket;
  WebSocketListener jdField_a_of_type_Okhttp3WebSocketListener;
  
  public void a()
  {
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, "openWebSocketConn, url = " + "wss://writetogether.3g.qq.com/websocket");
    Request localRequest = new Request.Builder().url("wss://writetogether.3g.qq.com/websocket").build().newBuilder().build();
    this.jdField_a_of_type_Okhttp3OkHttpClient = new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    this.jdField_a_of_type_Okhttp3OkHttpClient.newWebSocket(localRequest, new beqr(this));
  }
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    if (!a()) {
      a();
    }
    if ((a()) && (this.jdField_a_of_type_Okhttp3WebSocket != null))
    {
      paramBaseToWriteTogetherMsg = paramBaseToWriteTogetherMsg.toJson();
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 2, new Object[] { "sendData: ", paramBaseToWriteTogetherMsg });
      }
      this.jdField_a_of_type_Okhttp3WebSocket.send(paramBaseToWriteTogetherMsg);
    }
  }
  
  public void a(WebSocketListener paramWebSocketListener)
  {
    this.jdField_a_of_type_Okhttp3WebSocketListener = paramWebSocketListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Okhttp3WebSocket != null)
    {
      this.jdField_a_of_type_Okhttp3WebSocket.close(1000, null);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqq
 * JD-Core Version:    0.7.0.1
 */