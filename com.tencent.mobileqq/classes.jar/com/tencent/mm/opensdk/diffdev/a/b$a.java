package com.tencent.mm.opensdk.diffdev.a;

import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

class b$a
{
  public OAuthErrCode a;
  public String b;
  public String c;
  public String d;
  public byte[] e;
  
  public static a a(byte[] paramArrayOfByte)
  {
    a locala = new a();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        try
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          int i = paramArrayOfByte.getInt("errcode");
          if (i != 0)
          {
            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[] { Integer.valueOf(i) }));
            locala.a = OAuthErrCode.WechatAuth_Err_NormalErr;
            paramArrayOfByte.optString("errmsg");
            return locala;
          }
          Object localObject = paramArrayOfByte.getJSONObject("qrcode").getString("qrcodebase64");
          if ((localObject != null) && (((String)localObject).length() != 0))
          {
            localObject = Base64.decode((String)localObject, 0);
            if ((localObject != null) && (localObject.length != 0))
            {
              locala.a = OAuthErrCode.WechatAuth_Err_OK;
              locala.e = ((byte[])localObject);
              locala.b = paramArrayOfByte.getString("uuid");
              paramArrayOfByte = paramArrayOfByte.getString("appname");
              locala.c = paramArrayOfByte;
              Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { locala.b, paramArrayOfByte, Integer.valueOf(locala.e.length) }));
              return locala;
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
            locala.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
            return locala;
          }
          Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
          locala.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
          return locala;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte = String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() });
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte = String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() });
        }
      }
      Log.e("MicroMsg.SDK.GetQRCodeResult", paramArrayOfByte);
    }
    for (paramArrayOfByte = OAuthErrCode.WechatAuth_Err_NormalErr;; paramArrayOfByte = OAuthErrCode.WechatAuth_Err_NetworkErr)
    {
      locala.a = paramArrayOfByte;
      return locala;
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.b.a
 * JD-Core Version:    0.7.0.1
 */