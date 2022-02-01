import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@ProxyService(proxy=RequestProxy.class)
public class bkqu
  extends RequestProxy
{
  public ConcurrentHashMap<String, Call> a = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Call localCall = (Call)this.a.get(paramString);
    if (localCall != null) {
      localCall.cancel();
    }
    this.a.remove(paramString);
  }
  
  public boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener)
  {
    paramArrayOfByte = MiniOkHttpClientFactory.getRequestClient().newCall(bkoh.a(paramString1, paramMap, paramString2.toUpperCase(), null, paramArrayOfByte));
    paramArrayOfByte.enqueue(new bkqv(this, paramString1, paramRequestListener));
    this.a.put(paramString1, paramArrayOfByte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqu
 * JD-Core Version:    0.7.0.1
 */