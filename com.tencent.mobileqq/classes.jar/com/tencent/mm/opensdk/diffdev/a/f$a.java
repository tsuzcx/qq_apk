package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

final class f$a
{
  public OAuthErrCode m;
  public String u;
  public int v;
  
  public static a b(byte[] paramArrayOfByte)
  {
    a locala = new a();
    Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        try
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          locala.v = paramArrayOfByte.getInt("wx_errcode");
          Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(locala.v) }));
          int i = locala.v;
          if (i != 408) {
            if (i == 500) {}
          }
          switch (i)
          {
          case 405: 
            paramArrayOfByte = OAuthErrCode.WechatAuth_Err_NormalErr;
            locala.m = paramArrayOfByte;
            return locala;
            locala.m = OAuthErrCode.WechatAuth_Err_OK;
            locala.u = paramArrayOfByte.getString("wx_code");
            return locala;
          case 404: 
            paramArrayOfByte = OAuthErrCode.WechatAuth_Err_OK;
            break;
          case 403: 
            paramArrayOfByte = OAuthErrCode.WechatAuth_Err_Cancel;
            break;
          case 402: 
            paramArrayOfByte = OAuthErrCode.WechatAuth_Err_Timeout;
            continue;
            paramArrayOfByte = OAuthErrCode.WechatAuth_Err_NormalErr;
            continue;
            paramArrayOfByte = OAuthErrCode.WechatAuth_Err_OK;
            continue;
            Log.e("MicroMsg.SDK.NoopingResult", paramArrayOfByte);
          }
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte = String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() });
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte = String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() });
        continue;
      }
      paramArrayOfByte = OAuthErrCode.WechatAuth_Err_NormalErr;
      locala.m = paramArrayOfByte;
      return locala;
      Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
      paramArrayOfByte = OAuthErrCode.WechatAuth_Err_NetworkErr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f.a
 * JD-Core Version:    0.7.0.1
 */