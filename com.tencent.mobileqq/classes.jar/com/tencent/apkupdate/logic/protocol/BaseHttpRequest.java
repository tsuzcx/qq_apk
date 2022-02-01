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
    if (isCancel()) {
      return;
    }
    prepareData();
    Object localObject3 = this.sendRequest;
    if (localObject3 == null) {
      return;
    }
    Object localObject4;
    int i;
    if (localObject3 == null)
    {
      localObject1 = null;
    }
    else
    {
      localObject2 = new Request();
      if (localObject3 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject4 = new Net((byte)b.a().e(), b.a().d(), 0, b.c());
        localObject1 = new ReqHead();
        ((ReqHead)localObject1).requestId = b.i();
        if (localObject3 == null)
        {
          i = -1;
        }
        else
        {
          String str = localObject3.getClass().getSimpleName();
          i = JceCmd.convert(str.substring(0, str.length() - 7)).value();
        }
        ((ReqHead)localObject1).cmdId = i;
        b.a();
        ((ReqHead)localObject1).qua = b.f();
        ((ReqHead)localObject1).phoneGuid = b.a().h();
        ((ReqHead)localObject1).terminal = b.a().g();
        ((ReqHead)localObject1).assistantAPILevel = 0;
        ((ReqHead)localObject1).assistantVersionCode = 0;
        ((ReqHead)localObject1).net = ((Net)localObject4);
        ((ReqHead)localObject1).hostPackageName = b.b(b.a().b());
        ((ReqHead)localObject1).hostVersionCode = b.c(b.a().b());
      }
      ((Request)localObject2).head = ((ReqHead)localObject1);
      if (localObject3 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = new JceOutputStream();
        ((JceOutputStream)localObject1).setServerEncoding("utf-8");
        ((JceStruct)localObject3).writeTo((JceOutputStream)localObject1);
        localObject1 = ((JceOutputStream)localObject1).toByteArray();
      }
      ((Request)localObject2).body = ((byte[])localObject1);
      localObject1 = localObject2;
    }
    if (localObject1 == null) {}
    do
    {
      localObject1 = null;
      break;
      ((Request)localObject1).head.encryptWithPack = 0;
      if (((Request)localObject1).body.length > 256)
      {
        ((Request)localObject1).body = com.tencent.apkupdate.a.a.b(((Request)localObject1).body);
        ((Request)localObject1).head.encryptWithPack = ((byte)(((Request)localObject1).head.encryptWithPack | 0x1));
      }
      localObject2 = ((Request)localObject1).body;
      localObject3 = "ji*9^&43U0X-~./(".getBytes();
      ((Request)localObject1).body = new com.tencent.apkupdate.b.a().b((byte[])localObject2, 0, localObject2.length, (byte[])localObject3);
      ((Request)localObject1).head.encryptWithPack = ((byte)(((Request)localObject1).head.encryptWithPack | 0x2));
    } while (localObject1 == null);
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((JceStruct)localObject1).writeTo((JceOutputStream)localObject2);
    Object localObject1 = ((JceOutputStream)localObject2).toByteArray();
    try
    {
      localObject2 = new URL(REQUEST_SERVER_URL);
      localObject3 = TAG;
      localObject4 = new StringBuilder(">run serverUrl=");
      ((StringBuilder)localObject4).append(localObject2);
      Log.i((String)localObject3, ((StringBuilder)localObject4).toString());
      localObject2 = (HttpsURLConnection)((URL)localObject2).openConnection();
      localObject3 = SSLContext.getInstance("SSL");
      ((SSLContext)localObject3).init(null, null, null);
      if (localObject3 != null)
      {
        ((HttpsURLConnection)localObject2).setSSLSocketFactory(((SSLContext)localObject3).getSocketFactory());
        ((HttpsURLConnection)localObject2).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      }
      ((HttpsURLConnection)localObject2).setRequestMethod("POST");
      ((HttpsURLConnection)localObject2).setDoOutput(true);
      ((HttpsURLConnection)localObject2).setDoInput(true);
      ((HttpsURLConnection)localObject2).setUseCaches(false);
      ((HttpsURLConnection)localObject2).addRequestProperty("User-Agent", "AssistantDownloader");
      ((HttpsURLConnection)localObject2).addRequestProperty("Content-Type", "application/octet-stream");
      ((HttpsURLConnection)localObject2).setConnectTimeout(30000);
      ((HttpsURLConnection)localObject2).setReadTimeout(30000);
      localObject3 = ((HttpsURLConnection)localObject2).getOutputStream();
      ((OutputStream)localObject3).write((byte[])localObject1);
      ((OutputStream)localObject3).flush();
      i = ((HttpsURLConnection)localObject2).getResponseCode();
      localObject1 = TAG;
      localObject3 = new StringBuilder(">run rspCode:");
      ((StringBuilder)localObject3).append(i);
      i.a((String)localObject1, ((StringBuilder)localObject3).toString());
      if (isCancel()) {
        return;
      }
      if (i == 200)
      {
        localObject1 = ((HttpsURLConnection)localObject2).getInputStream();
        if (localObject1 != null)
        {
          localObject1 = com.tencent.apkupdate.a.a.a((InputStream)localObject1);
          if ((localObject1 != null) && (localObject1.length > 4))
          {
            localObject2 = TAG;
            localObject3 = new StringBuilder(">run data.length:");
            ((StringBuilder)localObject3).append(localObject1.length);
            Log.i((String)localObject2, ((StringBuilder)localObject3).toString());
            localObject1 = com.tencent.apkupdate.a.a.a((byte[])localObject1);
            if ((localObject1 != null) && (((Response)localObject1).body != null))
            {
              localObject1 = com.tencent.apkupdate.a.a.a(this.sendRequest, ((Response)localObject1).body);
              if (localObject1 != null)
              {
                Log.i(TAG, ">run unpageageJceResponse succ");
                onFinished(this.sendRequest, (JceStruct)localObject1);
                return;
              }
              Log.e(TAG, ">run unpageageJceResponse failed, jceResponse is null");
            }
            else
            {
              Log.e(TAG, ">run unpageageJceResponse failed,jceResp or jceResp.body null");
            }
          }
          else
          {
            localObject2 = TAG;
            localObject3 = new StringBuilder(">run data maybe null:");
            ((StringBuilder)localObject3).append(localObject1);
            Log.e((String)localObject2, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          Log.e(TAG, ">run inputStream == null");
        }
      }
      onDataReceiveFailed();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, ">run error:", localThrowable);
      onDataReceiveFailed();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.BaseHttpRequest
 * JD-Core Version:    0.7.0.1
 */