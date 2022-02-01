package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;

public class SimpleWebSocketAdapter
  implements VWebSocketAdapter
{
  public static String a;
  private VWebSocketAdapter.EventListener jdField_a_of_type_ComTencentViolaAdapterVWebSocketAdapter$EventListener;
  private WebSocket jdField_a_of_type_Okhttp3WebSocket;
  
  static
  {
    jdField_a_of_type_JavaLangString = "viola.SimpleWebSocketAdapter";
  }
  
  public void close(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Okhttp3WebSocket != null) {}
    try
    {
      this.jdField_a_of_type_Okhttp3WebSocket.close(paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "close Exception:" + paramString.getMessage());
    }
  }
  
  public void connect(String paramString1, @Nullable String paramString2, VWebSocketAdapter.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentViolaAdapterVWebSocketAdapter$EventListener = paramEventListener;
    paramEventListener = new OkHttpClient().newBuilder().connectTimeout(3600L, TimeUnit.SECONDS).readTimeout(3600L, TimeUnit.SECONDS).writeTimeout(3600L, TimeUnit.SECONDS).build();
    Request.Builder localBuilder = new Request.Builder();
    if (paramString2 != null) {
      localBuilder.addHeader("Sec-WebSocket-Protocol", paramString2);
    }
    localBuilder.url(paramString1);
    paramEventListener.newWebSocket(localBuilder.build(), new SimpleWebSocketAdapter.1(this));
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Okhttp3WebSocket != null) {}
    try
    {
      this.jdField_a_of_type_Okhttp3WebSocket.close(WebSocketCloseCodes.CLOSE_GOING_AWAY.getCode(), WebSocketCloseCodes.CLOSE_GOING_AWAY.name());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "destroy Exception" + localException.getMessage());
    }
  }
  
  public void disconnect() {}
  
  public void send(String paramString)
  {
    if (this.jdField_a_of_type_Okhttp3WebSocket != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_Okhttp3WebSocket.send(paramString);
        if (QLog.isDebugVersion()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "send data:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "send Exception:" + paramString.getMessage());
        }
        paramString.printStackTrace();
        return;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "send ws is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.SimpleWebSocketAdapter
 * JD-Core Version:    0.7.0.1
 */