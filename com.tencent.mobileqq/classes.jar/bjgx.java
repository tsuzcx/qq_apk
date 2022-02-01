import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;

public class bjgx
{
  public int a;
  public WebSocketProxy.WebSocketListener a;
  public String a;
  private OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  public WebSocket a;
  public boolean a;
  
  public bjgx(int paramInt1, String paramString, Map<String, String> paramMap, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    this.jdField_a_of_type_Int = paramString;
    this.jdField_a_of_type_JavaLangString = paramMap;
    Iterator localIterator;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener = localIterator;
    paramMap = new Request.Builder().url(paramMap).build().newBuilder();
    if (paramInt2 != null)
    {
      localIterator = paramInt2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMap.addHeader(str, (String)paramInt2.get(str));
      }
    }
    paramMap = paramMap.build();
    long l = paramWebSocketListener / 1000 + 1;
    this.jdField_a_of_type_Okhttp3OkHttpClient = new OkHttpClient().newBuilder().connectTimeout(l, TimeUnit.SECONDS).writeTimeout(l, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.SECONDS).build();
    this.jdField_a_of_type_Okhttp3OkHttpClient.newWebSocket(paramMap, new bjgy(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgx
 * JD-Core Version:    0.7.0.1
 */