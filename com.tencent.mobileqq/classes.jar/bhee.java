import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StCurrChannelInfo;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppReq;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhee
  extends bhdw
{
  private INTERFACE.StUseUserAppReq a = new INTERFACE.StUseUserAppReq();
  
  public bhee(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.a.appId.set(paramString1);
    this.a.verType.set(paramInt1);
    this.a.source.set(paramInt2);
    paramString1 = new INTERFACE.StCurrChannelInfo();
    paramString1.refer.set(paramString2);
    paramString1.via.set(paramString3);
    this.a.channelInfo.set(paramString1);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
  }
  
  protected String a()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StUseUserAppRsp localStUseUserAppRsp = new INTERFACE.StUseUserAppRsp();
    try
    {
      localStUseUserAppRsp.mergeFrom(a(paramArrayOfByte));
      if (localStUseUserAppRsp != null)
      {
        if (localStUseUserAppRsp.extInfo != null)
        {
          paramArrayOfByte = new JSONObject();
          paramArrayOfByte.put("ext", localStUseUserAppRsp.extInfo.get());
          return paramArrayOfByte;
        }
        QMLog.d("UseUserAppRequest", "onResponse fail.extInfo = null");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("UseUserAppRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("UseUserAppRequest", "onResponse fail.rsp = null");
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "UseUserApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhee
 * JD-Core Version:    0.7.0.1
 */