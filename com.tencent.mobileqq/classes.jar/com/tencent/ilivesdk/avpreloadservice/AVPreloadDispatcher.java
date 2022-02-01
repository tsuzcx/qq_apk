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
  private final HttpInterface jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private final HashMap<String, AVPreloadDispatcher.Result> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public AVPreloadDispatcher(HttpInterface paramHttpInterface)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface = paramHttpInterface;
  }
  
  private String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispatcher playUrl: ");
    ((StringBuilder)localObject).append(paramString);
    AVPreloadLog.b("StreamDispatcher", ((StringBuilder)localObject).toString(), new Object[0]);
    long l = System.currentTimeMillis();
    localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AVPreloadDispatcher.Result localResult = (AVPreloadDispatcher.Result)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (l - localResult.jdField_a_of_type_Long > localResult.jdField_a_of_type_Int * 1000) {
        ((Iterator)localObject).remove();
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = (AVPreloadDispatcher.Result)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if ((localObject != null) && (l - ((AVPreloadDispatcher.Result)localObject).jdField_a_of_type_Long < ((AVPreloadDispatcher.Result)localObject).jdField_a_of_type_Int * 1000) && (((AVPreloadDispatcher.Result)localObject).d != null) && (!((AVPreloadDispatcher.Result)localObject).d.isEmpty())) {
        return ((AVPreloadDispatcher.Result)localObject).d;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    return null;
  }
  
  private String b(String paramString)
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
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("?");
    ((StringBuilder)localObject2).append("cmd=mult_stream_dispatch_return_json");
    ((StringBuilder)localObject2).append("&stream=");
    ((StringBuilder)localObject2).append(paramString);
    return ((StringBuilder)localObject2).toString();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, AVPreloadDispatcher.Callback paramCallback)
  {
    String str = a(paramString);
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
    str = b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatcher reqUrl: ");
    localStringBuilder.append(str);
    AVPreloadLog.b("StreamDispatcher", localStringBuilder.toString(), new Object[0]);
    ThreadCenter.postLogicTask(new AVPreloadDispatcher.RequestRunnable(this, paramString, str, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadDispatcher
 * JD-Core Version:    0.7.0.1
 */