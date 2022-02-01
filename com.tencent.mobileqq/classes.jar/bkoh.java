import android.text.TextUtils;
import android.util.Log;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONException;
import org.json.JSONObject;

public class bkoh
{
  public static int a(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable != null)
    {
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof SSLHandshakeException)) {
        return 15;
      }
      if ((paramThrowable instanceof IllegalStateException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("Connection is not open"))) {
          return 50007;
        }
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("No space left on device"))) {
          return 50003;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Network is unreachable"))) {
          return 50004;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("No route to host"))) {
          return 50005;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Connection refused"))) {
          return 50006;
        }
        return 2;
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      if ((paramThrowable instanceof OutOfMemoryError)) {
        return 3;
      }
    }
    return paramInt;
  }
  
  private static String a(String paramString)
  {
    if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
      return "image/jpg";
    }
    if (paramString.endsWith(".png")) {
      return "image/png";
    }
    return "application/octet-stream";
  }
  
  public static Request a(String paramString1, Map<String, String> paramMap, String paramString2, MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Request.Builder localBuilder = new Request.Builder();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.addHeader(str, (String)paramMap.get(str));
      }
    }
    localBuilder.url(paramString1);
    if ("GET".equals(paramString2)) {
      localBuilder.get();
    }
    for (;;)
    {
      return localBuilder.build();
      paramString1 = null;
      if (HttpMethod.requiresRequestBody(paramString2))
      {
        paramString1 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          paramString1 = new byte[0];
        }
        paramString1 = RequestBody.create(paramMediaType, paramString1);
      }
      localBuilder.method(paramString2, paramString1);
    }
  }
  
  public static RequestBody a(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, UploaderProxy.UploadListener paramUploadListener)
  {
    MultipartBody.Builder localBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.addFormDataPart(str, (String)paramMap.get(str));
      }
    }
    paramMap = new File(paramString1);
    paramUploadListener = new ProgressRequestBody(RequestBody.create(MediaType.parse(a(paramString1)), paramMap), new bkoi(paramUploadListener));
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = paramMap.getName();
    }
    localBuilder.addFormDataPart(paramString2, paramString1, paramUploadListener);
    return localBuilder.build();
  }
  
  public static JSONObject a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      JSONObject localJSONObject = new JSONObject();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        try
        {
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        catch (JSONException localJSONException) {}
      }
      return localJSONObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoh
 * JD-Core Version:    0.7.0.1
 */