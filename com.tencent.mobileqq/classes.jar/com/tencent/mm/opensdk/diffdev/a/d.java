package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;
import org.json.JSONObject;

public final class d
  extends AsyncTask<Void, Void, a>
{
  private static final String ad = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png";
  private static String ae = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
  private String af;
  private String ag;
  private OAuthListener ah;
  private f ai;
  private String appId;
  private String scope;
  private String signature;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    this.appId = paramString1;
    this.scope = paramString2;
    this.af = paramString3;
    this.ag = paramString4;
    this.signature = paramString5;
    this.ah = paramOAuthListener;
  }
  
  public final boolean q()
  {
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    if (this.ai == null) {
      return cancel(true);
    }
    return this.ai.cancel(true);
  }
  
  static final class a
  {
    public OAuthErrCode aj;
    public String ak;
    public String al;
    public String am;
    public int an;
    public String ao;
    public byte[] ap;
    
    public static a c(byte[] paramArrayOfByte)
    {
      a locala = new a();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
        locala.aj = OAuthErrCode.WechatAuth_Err_NetworkErr;
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
            locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
            locala.an = i;
            locala.ao = paramArrayOfByte.optString("errmsg");
            return locala;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        localObject = paramArrayOfByte.getJSONObject("qrcode").getString("qrcodebase64");
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
        locala.aj = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
        locala.aj = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
        return locala;
      }
      Object localObject = Base64.decode((String)localObject, 0);
      if ((localObject == null) || (localObject.length == 0))
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
        locala.aj = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
        return locala;
      }
      locala.aj = OAuthErrCode.WechatAuth_Err_OK;
      locala.ap = ((byte[])localObject);
      locala.ak = paramArrayOfByte.getString("uuid");
      locala.al = paramArrayOfByte.getString("appname");
      Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { locala.ak, locala.al, Integer.valueOf(locala.ap.length) }));
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d
 * JD-Core Version:    0.7.0.1
 */