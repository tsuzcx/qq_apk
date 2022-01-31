import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezp
  extends bfau
{
  private MiniAppMidasPay.StMiniCheckOfferIdReq a = new MiniAppMidasPay.StMiniCheckOfferIdReq();
  
  public bezp(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    this.a.appId.set(paramString1);
    this.a.offerId.set(paramString2);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
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
    MiniAppMidasPay.StMiniCheckOfferIdRsp localStMiniCheckOfferIdRsp = new MiniAppMidasPay.StMiniCheckOfferIdRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStMiniCheckOfferIdRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStMiniCheckOfferIdRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("result", localStMiniCheckOfferIdRsp.result.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        paramArrayOfByte.put("ext", localStMiniCheckOfferIdRsp.extInfo);
        paramArrayOfByte.put("firstRefer", localStMiniCheckOfferIdRsp.firstRefer);
        paramArrayOfByte.put("firstVia", localStMiniCheckOfferIdRsp.firstVia);
        return paramArrayOfByte;
      }
      betc.a("CheckOfferIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("CheckOfferIdRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "MiniCheckOfferId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezp
 * JD-Core Version:    0.7.0.1
 */