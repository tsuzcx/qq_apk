package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.utils.ThreadCenter;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AVPreloadDispatcher
{
  private String a = "";
  private final HashMap<String, AVPreloadDispatcher.Result> b = new HashMap();
  private final HttpInterface c;
  
  public AVPreloadDispatcher(HttpInterface paramHttpInterface)
  {
    this.c = paramHttpInterface;
  }
  
  private String b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispatcher playUrl: ");
    ((StringBuilder)localObject).append(paramString);
    AVPreloadLog.b("StreamDispatcher", ((StringBuilder)localObject).toString(), new Object[0]);
    long l = System.currentTimeMillis();
    localObject = this.b.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AVPreloadDispatcher.Result localResult = (AVPreloadDispatcher.Result)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (l - localResult.d > localResult.e * 1000) {
        ((Iterator)localObject).remove();
      }
    }
    if (this.b.containsKey(paramString))
    {
      localObject = (AVPreloadDispatcher.Result)this.b.get(paramString);
      if ((localObject != null) && (l - ((AVPreloadDispatcher.Result)localObject).d < ((AVPreloadDispatcher.Result)localObject).e * 1000) && (((AVPreloadDispatcher.Result)localObject).f != null) && (!((AVPreloadDispatcher.Result)localObject).f.isEmpty())) {
        return ((AVPreloadDispatcher.Result)localObject).f;
      }
      this.b.remove(paramString);
    }
    return null;
  }
  
  private String c(String paramString)
  {
    Object localObject1 = URI.create(paramString).getPath();
    Object localObject2 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
    if (((String)localObject2).isEmpty())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse stream id fail! :");
      ((StringBuilder)localObject1).append((String)localObject2);
      AVPreloadLog.c("StreamDispatcher", ((StringBuilder)localObject1).toString(), new Object[0]);
      return paramString;
    }
    paramString = ((String)localObject2).replace(".flv", "");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://");
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("?");
    ((StringBuilder)localObject2).append("cmd=mult_stream_dispatch_return_json");
    ((StringBuilder)localObject2).append("&stream=");
    ((StringBuilder)localObject2).append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, AVPreloadDispatcher.Callback paramCallback)
  {
    String str = b(paramString);
    if (str != null)
    {
      paramString = new StringBuilder();
      paramString.append("dispatcher cacheUrl: ");
      paramString.append(str);
      AVPreloadLog.b("StreamDispatcher", paramString.toString(), new Object[0]);
      if (paramCallback != null) {
        paramCallback.a(true, str);
      }
      return;
    }
    str = c(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatcher reqUrl: ");
    localStringBuilder.append(str);
    AVPreloadLog.b("StreamDispatcher", localStringBuilder.toString(), new Object[0]);
    ThreadCenter.postLogicTask(new AVPreloadDispatcher.RequestRunnable(this, paramString, str, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadDispatcher
 * JD-Core Version:    0.7.0.1
 */