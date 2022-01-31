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
  
  public static void connectHost(OkHttpClient paramOkHttpClient, ArrayList<String> paramArrayList)
  {
    if ((paramOkHttpClient != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        tryConnectHost(paramOkHttpClient, (String)paramArrayList.next());
      }
    }
  }
  
  private static void tryConnectHost(OkHttpClient paramOkHttpClient, String paramString)
  {
    if ((paramOkHttpClient == null) || (TextUtils.isEmpty(paramString))) {
      QDLog.e("downloader", "pre-connect fail, url:" + paramString);
    }
    Request.Builder localBuilder;
    do
    {
      return;
      QDLog.i("downloader", "pre-connect:" + paramString);
      long l = System.currentTimeMillis();
      localBuilder = new Request.Builder().url(paramString).addHeader("Connection", "keep-alive").head();
      paramString = new PreConnectManager.1(paramString, l);
    } while (paramOkHttpClient == null);
    paramOkHttpClient.newCall(localBuilder.build()).enqueue(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.PreConnectManager
 * JD-Core Version:    0.7.0.1
 */