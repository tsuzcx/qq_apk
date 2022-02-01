import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import okhttp3.MediaType;
import okhttp3.WebSocket;
import okio.ByteString;

@ProxyService(proxy=WebSocketProxy.class)
public class bjzv
  extends WebSocketProxy
{
  public ConcurrentHashMap<Integer, bjzw> a = new ConcurrentHashMap();
  
  public boolean closeSocket(int paramInt1, int paramInt2, String paramString)
  {
    bjzw localbjzw = (bjzw)this.a.get(Integer.valueOf(paramInt1));
    if ((localbjzw != null) && (localbjzw.a != null)) {}
    try
    {
      localbjzw.a.close(paramInt2, paramString);
      ThreadManager.getSubThreadHandler().postDelayed(new WebSocketProxyImpl.1(this, localbjzw, paramInt1, paramInt2, paramString), 1000L);
      this.a.remove(Integer.valueOf(paramInt1));
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("WebSocketProxyImpl", 1, "closeSocket error:", paramString);
      }
    }
  }
  
  public boolean connectSocket(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    paramString1 = new bjzw(this, paramInt1, paramString1, paramMap, paramInt2, paramWebSocketListener);
    this.a.put(Integer.valueOf(paramInt1), paramString1);
    return true;
  }
  
  public boolean send(int paramInt, String paramString)
  {
    bjzw localbjzw = (bjzw)this.a.get(Integer.valueOf(paramInt));
    if ((localbjzw != null) && (localbjzw.a != null)) {
      try
      {
        MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
        localbjzw.a.send(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendStringMessage error:", paramString);
        return false;
      }
    }
    return false;
  }
  
  public boolean send(int paramInt, byte[] paramArrayOfByte)
  {
    bjzw localbjzw = (bjzw)this.a.get(Integer.valueOf(paramInt));
    if ((localbjzw != null) && (localbjzw.a != null)) {
      try
      {
        localbjzw.a.send(ByteString.of(paramArrayOfByte));
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendBinaryMessage error:", paramArrayOfByte);
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzv
 * JD-Core Version:    0.7.0.1
 */