package com.tencent.luggage.wxa.qp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
  implements IMediaHTTPService
{
  private final Map<String, String> a = new ConcurrentHashMap();
  
  public void a(@NonNull String paramString1, @Nullable String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setReferrer, originUrl: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", referrer: ");
    ((StringBuilder)localObject).append(paramString2);
    Logger.d("MicroMsg.MMMediaHTTPService", ((StringBuilder)localObject).toString());
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    this.a.put(paramString1, localObject);
  }
  
  public IMediaHTTPConnection makeHTTPConnection()
  {
    Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
    return new a(Collections.unmodifiableMap(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qp.b
 * JD-Core Version:    0.7.0.1
 */