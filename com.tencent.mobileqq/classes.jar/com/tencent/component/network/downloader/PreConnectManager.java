package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

public class PreConnectManager
{
  private static final String CONNECTION_KEEP_ALIVE = "keep-alive";
  private static final String HEADER_CONNECTION = "Connection";
  
  public static void connectHost(OkHttpClient paramOkHttpClient, ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramOkHttpClient != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        tryConnectHost(paramOkHttpClient, (String)paramArrayList.next(), paramString);
      }
    }
  }
  
  private static void tryConnectHost(OkHttpClient paramOkHttpClient, String paramString1, String paramString2)
  {
    if ((paramOkHttpClient != null) && (!TextUtils.isEmpty(paramString1)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre-connect:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" method:");
      ((StringBuilder)localObject).append(paramString2);
      QDLog.i("downloader", ((StringBuilder)localObject).toString());
      long l = System.currentTimeMillis();
      localObject = paramString2;
      if (!paramString2.equals("HEAD"))
      {
        localObject = paramString2;
        if (!paramString2.equals("GET")) {
          localObject = "HEAD";
        }
      }
      paramString2 = new Request.Builder().url(paramString1).method((String)localObject, null).addHeader("Connection", "keep-alive");
      paramString1 = new PreConnectManager.1(paramString1, l);
      if (paramOkHttpClient != null) {
        paramOkHttpClient.newCall(paramString2.build()).enqueue(paramString1);
      }
      return;
    }
    paramOkHttpClient = new StringBuilder();
    paramOkHttpClient.append("pre-connect fail, url:");
    paramOkHttpClient.append(paramString1);
    QDLog.e("downloader", paramOkHttpClient.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.PreConnectManager
 * JD-Core Version:    0.7.0.1
 */