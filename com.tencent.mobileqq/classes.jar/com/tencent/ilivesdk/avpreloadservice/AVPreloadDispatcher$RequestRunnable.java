package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.http.HttpResponse;
import java.util.HashMap;

class AVPreloadDispatcher$RequestRunnable
  implements Runnable
{
  private final AVPreloadDispatcher.Callback jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Callback;
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public AVPreloadDispatcher$RequestRunnable(AVPreloadDispatcher paramAVPreloadDispatcher, String paramString1, String paramString2, AVPreloadDispatcher.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Callback = paramCallback;
  }
  
  public void run()
  {
    Object localObject1 = new AVPreloadDispatcher.DispatcherResponse();
    AVPreloadDispatcher.a(this.this$0).get(this.b, (HttpResponse)localObject1);
    int i = 0;
    while ((i < 20) && (!AVPreloadDispatcher.DispatcherResponse.a((AVPreloadDispatcher.DispatcherResponse)localObject1)))
    {
      try
      {
        Thread.sleep(50L);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    if (AVPreloadDispatcher.DispatcherResponse.a((AVPreloadDispatcher.DispatcherResponse)localObject1) != null)
    {
      localObject1 = AVPreloadDispatcher.DispatcherResponse.a((AVPreloadDispatcher.DispatcherResponse)localObject1);
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_JavaLangString.startsWith("https://"))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://");
        localStringBuilder.append(((AVPreloadDispatcher.Result)localObject1).b);
        if (!((String)localObject2).startsWith(localStringBuilder.toString()))
        {
          localObject2 = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://");
          localStringBuilder.append(((AVPreloadDispatcher.Result)localObject1).b);
          localStringBuilder.append("/");
          ((AVPreloadDispatcher.Result)localObject1).d = ((String)localObject2).replace("https://", localStringBuilder.toString());
        }
      }
      if (this.jdField_a_of_type_JavaLangString.startsWith("http://"))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("http://");
        localStringBuilder.append(((AVPreloadDispatcher.Result)localObject1).b);
        if (!((String)localObject2).startsWith(localStringBuilder.toString()))
        {
          localObject2 = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(((AVPreloadDispatcher.Result)localObject1).b);
          localStringBuilder.append("/");
          ((AVPreloadDispatcher.Result)localObject1).d = ((String)localObject2).replace("http://", localStringBuilder.toString());
        }
      }
      AVPreloadDispatcher.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("new url: ");
      ((StringBuilder)localObject2).append(((AVPreloadDispatcher.Result)localObject1).d);
      AVPreloadLog.b("StreamDispatcher", ((StringBuilder)localObject2).toString(), new Object[0]);
      localObject2 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Callback;
      if (localObject2 != null) {
        ((AVPreloadDispatcher.Callback)localObject2).a(true, ((AVPreloadDispatcher.Result)localObject1).d);
      }
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Callback;
    if (localObject1 != null) {
      ((AVPreloadDispatcher.Callback)localObject1).a(false, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadDispatcher.RequestRunnable
 * JD-Core Version:    0.7.0.1
 */