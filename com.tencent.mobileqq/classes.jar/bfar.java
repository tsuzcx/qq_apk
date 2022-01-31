import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfar
  extends bfau
{
  private MiniProgramShare.StGetGroupShareInfoReq a = new MiniProgramShare.StGetGroupShareInfoReq();
  
  public bfar(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
    this.a.appid.set(paramString1);
    this.a.shareTicket.set(paramString2);
  }
  
  protected String a()
  {
    return "mini_app_share";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniProgramShare.StGetGroupShareInfoRsp localStGetGroupShareInfoRsp = new MiniProgramShare.StGetGroupShareInfoRsp();
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGetGroupShareInfoRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGetGroupShareInfoRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStGetGroupShareInfoRsp);
        paramArrayOfByte.put("resultCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      betc.a("MiniAppGetGroupShareInfoRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("MiniAppGetGroupShareInfoRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetGroupShareInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfar
 * JD-Core Version:    0.7.0.1
 */