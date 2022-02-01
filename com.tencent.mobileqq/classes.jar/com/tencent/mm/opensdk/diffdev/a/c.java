package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

class c
  extends AsyncTask<Void, Void, c.a>
{
  private String a;
  private String b;
  private OAuthListener c;
  private int d;
  
  public c(String paramString, OAuthListener paramOAuthListener)
  {
    this.a = paramString;
    this.c = paramOAuthListener;
    this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
  }
  
  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    paramArrayOfObject = (Void[])paramArrayOfObject;
    Thread.currentThread().setName("OpenSdkNoopingTask");
    paramArrayOfObject = this.a;
    Object localObject;
    String str;
    long l1;
    long l2;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length() != 0))
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("doInBackground start ");
      paramArrayOfObject.append(isCancelled());
      Log.i("MicroMsg.SDK.NoopingTask", paramArrayOfObject.toString());
      if (!isCancelled())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        if (this.d == 0)
        {
          paramArrayOfObject = "";
        }
        else
        {
          paramArrayOfObject = new StringBuilder();
          paramArrayOfObject.append("&last=");
          paramArrayOfObject.append(this.d);
          paramArrayOfObject = paramArrayOfObject.toString();
        }
        ((StringBuilder)localObject).append(paramArrayOfObject);
        str = ((StringBuilder)localObject).toString();
        l1 = System.currentTimeMillis();
        paramArrayOfObject = a.a(str, 60000);
        l2 = System.currentTimeMillis();
        localObject = new c.a();
        Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
        if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {}
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfObject = new String(paramArrayOfObject, "utf-8");
        try
        {
          paramArrayOfObject = new JSONObject(paramArrayOfObject);
          i = paramArrayOfObject.getInt("wx_errcode");
          ((c.a)localObject).c = i;
          Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(i) }));
          i = ((c.a)localObject).c;
          if (i != 408) {
            if (i == 500) {}
          }
          switch (i)
          {
          case 405: 
            ((c.a)localObject).a = OAuthErrCode.WechatAuth_Err_OK;
            ((c.a)localObject).b = paramArrayOfObject.getString("wx_code");
            break;
          case 403: 
            paramArrayOfObject = OAuthErrCode.WechatAuth_Err_Cancel;
            break;
          case 402: 
            paramArrayOfObject = OAuthErrCode.WechatAuth_Err_Timeout;
            continue;
            paramArrayOfObject = OAuthErrCode.WechatAuth_Err_NormalErr;
            break;
          case 404: 
            paramArrayOfObject = OAuthErrCode.WechatAuth_Err_OK;
            ((c.a)localObject).a = paramArrayOfObject;
          }
        }
        catch (Exception paramArrayOfObject)
        {
          paramArrayOfObject = String.format("parse json fail, ex = %s", new Object[] { paramArrayOfObject.getMessage() });
        }
        Log.e("MicroMsg.SDK.NoopingResult", paramArrayOfObject);
      }
      catch (Exception paramArrayOfObject)
      {
        paramArrayOfObject = String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfObject.getMessage() });
      }
      paramArrayOfObject = OAuthErrCode.WechatAuth_Err_NormalErr;
      break label415;
      Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
      paramArrayOfObject = OAuthErrCode.WechatAuth_Err_NetworkErr;
      label415:
      ((c.a)localObject).a = paramArrayOfObject;
      Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[] { str, ((c.a)localObject).a.toString(), Integer.valueOf(((c.a)localObject).c), Long.valueOf(l2 - l1) }));
      paramArrayOfObject = ((c.a)localObject).a;
      if (paramArrayOfObject == OAuthErrCode.WechatAuth_Err_OK)
      {
        i = ((c.a)localObject).c;
        this.d = i;
        if (i == d.d.a())
        {
          this.c.onQrcodeScanned();
          break;
        }
        if ((((c.a)localObject).c == d.f.a()) || (((c.a)localObject).c != d.e.a())) {
          break;
        }
        str = ((c.a)localObject).b;
        if (str != null)
        {
          paramArrayOfObject = (Object[])localObject;
          if (str.length() != 0) {
            break label669;
          }
        }
        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
        paramArrayOfObject = (Object[])localObject;
        break label658;
      }
      Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[] { paramArrayOfObject.toString(), Integer.valueOf(((c.a)localObject).c) }));
      return localObject;
      Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
      paramArrayOfObject = new c.a();
      localObject = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
      break label663;
      Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
      paramArrayOfObject = new c.a();
      label658:
      localObject = OAuthErrCode.WechatAuth_Err_NormalErr;
      label663:
      paramArrayOfObject.a = ((OAuthErrCode)localObject);
      label669:
      return paramArrayOfObject;
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    paramObject = (c.a)paramObject;
    this.c.onAuthFinish(paramObject.a, paramObject.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.c
 * JD-Core Version:    0.7.0.1
 */