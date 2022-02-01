package com.tencent.apkupdate.logic.protocol;

import android.util.Log;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.b.b;
import com.tencent.apkupdate.b.i;
import com.tencent.apkupdate.logic.protocol.jce.JceCmd;
import com.tencent.apkupdate.logic.protocol.jce.Net;
import com.tencent.apkupdate.logic.protocol.jce.ReqHead;
import com.tencent.apkupdate.logic.protocol.jce.Request;
import com.tencent.apkupdate.logic.protocol.jce.Response;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

public abstract class BaseHttpRequest
  implements Runnable
{
  public static String REQUEST_SERVER_URL = "https://masdkv6.3g.qq.com";
  private static String TAG = "BaseHttpRequest";
  private boolean isCancel = false;
  private JceStruct sendRequest = null;
  
  public boolean isCancel()
  {
    return this.isCancel;
  }
  
  protected abstract void onDataReceiveFailed();
  
  protected abstract void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2);
  
  protected void prepareData() {}
  
  public void run()
  {
    Object localObject3 = null;
    if (isCancel()) {}
    do
    {
      return;
      prepareData();
    } while (this.sendRequest == null);
    Object localObject5 = this.sendRequest;
    Object localObject1;
    if (localObject5 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label574;
      }
    }
    Object localObject2;
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new URL(REQUEST_SERVER_URL);
        Log.i(TAG, ">run serverUrl=" + localObject1);
        localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
        localObject4 = SSLContext.getInstance("SSL");
        ((SSLContext)localObject4).init(null, null, null);
        if (localObject4 != null)
        {
          ((HttpsURLConnection)localObject1).setSSLSocketFactory(((SSLContext)localObject4).getSocketFactory());
          ((HttpsURLConnection)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        ((HttpsURLConnection)localObject1).setRequestMethod("POST");
        ((HttpsURLConnection)localObject1).setDoOutput(true);
        ((HttpsURLConnection)localObject1).setDoInput(true);
        ((HttpsURLConnection)localObject1).setUseCaches(false);
        ((HttpsURLConnection)localObject1).addRequestProperty("User-Agent", "AssistantDownloader");
        ((HttpsURLConnection)localObject1).addRequestProperty("Content-Type", "application/octet-stream");
        ((HttpsURLConnection)localObject1).setConnectTimeout(30000);
        ((HttpsURLConnection)localObject1).setReadTimeout(30000);
        localObject4 = ((HttpsURLConnection)localObject1).getOutputStream();
        ((OutputStream)localObject4).write((byte[])localObject3);
        ((OutputStream)localObject4).flush();
        i = ((HttpsURLConnection)localObject1).getResponseCode();
        i.a(TAG, ">run rspCode:" + i);
        if (isCancel()) {
          break;
        }
        if (i != 200) {
          break label717;
        }
        localObject1 = ((HttpsURLConnection)localObject1).getInputStream();
        if (localObject1 == null) {
          break label762;
        }
        localObject1 = com.tencent.apkupdate.a.a.a((InputStream)localObject1);
        if ((localObject1 == null) || (localObject1.length <= 4)) {
          break label735;
        }
        Log.i(TAG, ">run data.length:" + localObject1.length);
        localObject1 = com.tencent.apkupdate.a.a.a((byte[])localObject1);
        if ((localObject1 == null) || (((Response)localObject1).body == null)) {
          break label722;
        }
        localObject1 = com.tencent.apkupdate.a.a.a(this.sendRequest, ((Response)localObject1).body);
        if (localObject1 == null) {
          break label707;
        }
        Log.i(TAG, ">run unpageageJceResponse succ");
        onFinished(this.sendRequest, (JceStruct)localObject1);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e(TAG, ">run error:", localThrowable);
        onDataReceiveFailed();
        return;
      }
      Object localObject4 = new Request();
      if (localObject5 == null)
      {
        localObject2 = null;
        ((Request)localObject4).head = ((ReqHead)localObject2);
        if (localObject5 != null) {
          break label544;
        }
      }
      for (localObject2 = null;; localObject2 = ((JceOutputStream)localObject2).toByteArray())
      {
        ((Request)localObject4).body = ((byte[])localObject2);
        localObject2 = localObject4;
        break;
        Net localNet = new Net((byte)b.a().e(), b.a().d(), 0, b.c());
        localObject2 = new ReqHead();
        ((ReqHead)localObject2).requestId = b.i();
        if (localObject5 == null) {}
        String str;
        for (i = -1;; i = JceCmd.convert(str.substring(0, str.length() - 7)).value())
        {
          ((ReqHead)localObject2).cmdId = i;
          b.a();
          ((ReqHead)localObject2).qua = b.f();
          ((ReqHead)localObject2).phoneGuid = b.a().h();
          ((ReqHead)localObject2).terminal = b.a().g();
          ((ReqHead)localObject2).assistantAPILevel = 0;
          ((ReqHead)localObject2).assistantVersionCode = 0;
          ((ReqHead)localObject2).net = localNet;
          ((ReqHead)localObject2).hostPackageName = b.b(b.a().b());
          ((ReqHead)localObject2).hostVersionCode = b.c(b.a().b());
          break;
          str = localObject5.getClass().getSimpleName();
        }
        label544:
        localObject2 = new JceOutputStream();
        ((JceOutputStream)localObject2).setServerEncoding("utf-8");
        ((JceStruct)localObject5).writeTo((JceOutputStream)localObject2);
      }
      label574:
      ((Request)localObject2).head.encryptWithPack = 0;
      if (((Request)localObject2).body.length > 256)
      {
        ((Request)localObject2).body = com.tencent.apkupdate.a.a.b(((Request)localObject2).body);
        ((Request)localObject2).head.encryptWithPack = ((byte)(((Request)localObject2).head.encryptWithPack | 0x1));
      }
      localObject4 = ((Request)localObject2).body;
      localObject5 = "ji*9^&43U0X-~./(".getBytes();
      ((Request)localObject2).body = new com.tencent.apkupdate.b.a().b((byte[])localObject4, 0, localObject4.length, (byte[])localObject5);
      ((Request)localObject2).head.encryptWithPack = ((byte)(((Request)localObject2).head.encryptWithPack | 0x2));
      if (localObject2 != null)
      {
        localObject3 = new JceOutputStream();
        ((JceOutputStream)localObject3).setServerEncoding("utf-8");
        ((JceStruct)localObject2).writeTo((JceOutputStream)localObject3);
        localObject3 = ((JceOutputStream)localObject3).toByteArray();
      }
    }
    label707:
    Log.e(TAG, ">run unpageageJceResponse failed, jceResponse is null");
    for (;;)
    {
      label717:
      onDataReceiveFailed();
      return;
      label722:
      Log.e(TAG, ">run unpageageJceResponse failed,jceResp or jceResp.body null");
      continue;
      label735:
      Log.e(TAG, ">run data maybe null:" + localObject2);
      continue;
      label762:
      Log.e(TAG, ">run inputStream == null");
    }
  }
  
  public void setCancel(boolean paramBoolean)
  {
    this.isCancel = paramBoolean;
  }
  
  public void setData(JceStruct paramJceStruct)
  {
    this.sendRequest = paramJceStruct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.BaseHttpRequest
 * JD-Core Version:    0.7.0.1
 */