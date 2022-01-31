package com.tencent.mm.opensdk.diffdev.a;

import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

final class d$a
{
  public OAuthErrCode m;
  public String n;
  public String o;
  public String p;
  public int q;
  public String r;
  public byte[] s;
  
  public static a a(byte[] paramArrayOfByte)
  {
    a locala = new a();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
      locala.m = OAuthErrCode.WechatAuth_Err_NetworkErr;
      return locala;
    }
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
          locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
          locala.q = i;
          locala.r = paramArrayOfByte.optString("errmsg");
          return locala;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
        locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
      localObject = paramArrayOfByte.getJSONObject("qrcode").getString("qrcodebase64");
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
      locala.m = OAuthErrCode.WechatAuth_Err_NormalErr;
      return locala;
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
      locala.m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
      return locala;
    }
    Object localObject = Base64.decode((String)localObject, 0);
    if ((localObject == null) || (localObject.length == 0))
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
      locala.m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
      return locala;
    }
    locala.m = OAuthErrCode.WechatAuth_Err_OK;
    locala.s = ((byte[])localObject);
    locala.n = paramArrayOfByte.getString("uuid");
    locala.o = paramArrayOfByte.getString("appname");
    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { locala.n, locala.o, Integer.valueOf(locala.s.length) }));
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d.a
 * JD-Core Version:    0.7.0.1
 */