import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgzq
  extends bgzp
{
  private MiniAppMidasPay.StQueryStarCurrencyReq a = new MiniAppMidasPay.StQueryStarCurrencyReq();
  
  public bgzq(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
    this.a.appId.set(paramString1);
    this.a.prepayId.set(paramString2);
    this.a.starCurrency.set(paramInt1);
    this.a.sandboxEnv.set(paramInt2);
  }
  
  protected String a()
  {
    return "mini_app_pay";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    MiniAppMidasPay.StQueryStarCurrencyRsp localStQueryStarCurrencyRsp = new MiniAppMidasPay.StQueryStarCurrencyRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStQueryStarCurrencyRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStQueryStarCurrencyRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStQueryStarCurrencyRsp);
        paramArrayOfByte.put("resultCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QMLog.d("QueryCurrencyRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("QueryCurrencyRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "QueryStarCurrency";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzq
 * JD-Core Version:    0.7.0.1
 */