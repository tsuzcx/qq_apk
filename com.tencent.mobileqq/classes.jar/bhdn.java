import NS_MINI_APP_MISC.MISC.StTrans4RoomidReq;
import NS_MINI_APP_MISC.MISC.StTrans4RoomidRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhdn
  extends bhdw
{
  private MISC.StTrans4RoomidReq a = new MISC.StTrans4RoomidReq();
  
  public bhdn(String paramString1, String paramString2)
  {
    this.a.appid.set(paramString1);
    this.a.groupid.set(paramString2);
  }
  
  protected String a()
  {
    return "mini_app_misc";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MISC.StTrans4RoomidRsp localStTrans4RoomidRsp = new MISC.StTrans4RoomidRsp();
    try
    {
      localStTrans4RoomidRsp.mergeFrom(a(paramArrayOfByte));
      if (localStTrans4RoomidRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("openId", localStTrans4RoomidRsp.openid.get());
        paramArrayOfByte.put("tinyId", localStTrans4RoomidRsp.tinyid.get());
        paramArrayOfByte.put("roomId", localStTrans4RoomidRsp.roomid.get());
        return paramArrayOfByte;
      }
      QMLog.d("GetTransRoomIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetTransRoomIdRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "Trans4Roomid";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdn
 * JD-Core Version:    0.7.0.1
 */