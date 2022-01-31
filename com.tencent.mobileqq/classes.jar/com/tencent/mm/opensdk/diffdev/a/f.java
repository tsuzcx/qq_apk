package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

final class f
  extends AsyncTask<Void, Void, a>
{
  private OAuthListener ah;
  private String ak;
  private int aq;
  private String url;
  
  public f(String paramString, OAuthListener paramOAuthListener)
  {
    this.ak = paramString;
    this.ah = paramOAuthListener;
    this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
  }
  
  static final class a
  {
    public OAuthErrCode aj;
    public String ar;
    public int as;
    
    public static a d(byte[] paramArrayOfByte)
    {
      a locala = new a();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
        locala.aj = OAuthErrCode.WechatAuth_Err_NetworkErr;
        return locala;
      }
      for (;;)
      {
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
          try
          {
            paramArrayOfByte = new JSONObject(paramArrayOfByte);
            locala.as = paramArrayOfByte.getInt("wx_errcode");
            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(locala.as) }));
            switch (locala.as)
            {
            case 405: 
              locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
              return locala;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
            locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
            return locala;
          }
          locala.aj = OAuthErrCode.WechatAuth_Err_OK;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        locala.ar = paramArrayOfByte.getString("wx_code");
        return locala;
        locala.aj = OAuthErrCode.WechatAuth_Err_OK;
        return locala;
        locala.aj = OAuthErrCode.WechatAuth_Err_OK;
        return locala;
        locala.aj = OAuthErrCode.WechatAuth_Err_Timeout;
        return locala;
        locala.aj = OAuthErrCode.WechatAuth_Err_Cancel;
        return locala;
        locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f
 * JD-Core Version:    0.7.0.1
 */