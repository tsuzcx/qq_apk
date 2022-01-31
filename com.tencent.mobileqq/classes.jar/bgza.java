import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgza
  extends bgzp
{
  private CloudStorage.StGetPotentialFriendListReq a = new CloudStorage.StGetPotentialFriendListReq();
  
  public bgza(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.a.ext.set(paramStCommonExt);
    }
    this.a.appid.set(paramString);
  }
  
  protected String a()
  {
    return "mini_app_cloudstorage";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    CloudStorage.StGetPotentialFriendListRsp localStGetPotentialFriendListRsp = new CloudStorage.StGetPotentialFriendListRsp();
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGetPotentialFriendListRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGetPotentialFriendListRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStGetPotentialFriendListRsp);
        paramArrayOfByte.put("resultCode", 0);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QMLog.d("GetPotentialFriendListRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetPotentialFriendListRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetPotentialFriendList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgza
 * JD-Core Version:    0.7.0.1
 */