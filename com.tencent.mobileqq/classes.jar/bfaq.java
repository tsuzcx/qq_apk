import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfaq
  extends bfau
{
  private INTERFACE.StJudgeTimingReq a = new INTERFACE.StJudgeTimingReq();
  
  public bfaq(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3)
  {
    this.a.appid.set(paramString1);
    this.a.appType.set(paramInt1);
    this.a.scene.set(paramInt2);
    this.a.factType.set(paramInt3);
    this.a.reportTime.set(paramLong);
    this.a.totalTime.set(paramInt4);
    this.a.launchId.set(paramString2);
    this.a.afterCertify.set(paramInt5);
    this.a.via.set(paramString3);
  }
  
  protected String a()
  {
    return "mini_app_growguard";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStJudgeTimingRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStJudgeTimingRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStJudgeTimingRsp);
        paramArrayOfByte.put("resultCode", 0);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      betc.a("JudgeTimingRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("JudgeTimingRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "JudgeTiming";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfaq
 * JD-Core Version:    0.7.0.1
 */