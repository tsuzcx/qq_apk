package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

public class b
  extends AsyncTask<Void, Void, b.a>
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private OAuthListener f;
  private c g;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramOAuthListener;
  }
  
  public boolean a()
  {
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    c localc = this.g;
    if (localc == null) {
      return cancel(true);
    }
    return localc.cancel(true);
  }
  
  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    paramArrayOfObject = (Void[])paramArrayOfObject;
    Thread.currentThread().setName("OpenSdkGetQRCodeTask");
    Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
    paramArrayOfObject = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", new Object[] { this.a, this.c, this.d, this.b, this.e });
    long l = System.currentTimeMillis();
    byte[] arrayOfByte = a.a(paramArrayOfObject, 60000);
    Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[] { paramArrayOfObject, Long.valueOf(System.currentTimeMillis() - l) }));
    return b.a.a(arrayOfByte);
  }
  
  protected void onPostExecute(Object paramObject)
  {
    paramObject = (b.a)paramObject;
    Object localObject = paramObject.a;
    if (localObject == OAuthErrCode.WechatAuth_Err_OK)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute, get qrcode success imgBufSize = ");
      ((StringBuilder)localObject).append(paramObject.e.length);
      Log.d("MicroMsg.SDK.GetQRCodeTask", ((StringBuilder)localObject).toString());
      this.f.onAuthGotQrcode(paramObject.d, paramObject.e);
      paramObject = new c(paramObject.b, this.f);
      this.g = paramObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramObject.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      paramObject.execute(new Void[0]);
      return;
    }
    Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[] { localObject }));
    this.f.onAuthFinish(paramObject.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.b
 * JD-Core Version:    0.7.0.1
 */