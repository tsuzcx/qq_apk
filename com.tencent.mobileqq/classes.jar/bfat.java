import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfat
  extends bfau
{
  private MiniAppMidasPay.StGamePayReq a = new MiniAppMidasPay.StGamePayReq();
  
  public bfat(String paramString1, COMM.StCommonExt paramStCommonExt, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
    this.a.appId.set(paramString1);
    this.a.prepayId.set(paramString2);
    this.a.starCurrency.set(paramInt1);
    this.a.balanceAmount.set(paramInt2);
    this.a.topupAmount.set(paramInt3);
    this.a.payChannel.set(paramInt4);
    this.a.sandboxEnv.set(paramInt5);
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
    MiniAppMidasPay.StGamePayRsp localStGamePayRsp = new MiniAppMidasPay.StGamePayRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGamePayRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGamePayRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStGamePayRsp);
        paramArrayOfByte.put("resultCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      betc.a("MiniAppPayRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("MiniAppPayRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GamePay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfat
 * JD-Core Version:    0.7.0.1
 */