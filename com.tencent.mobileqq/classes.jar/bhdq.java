import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhdq
  extends bhdw
{
  private CloudStorage.StGetUserInteractiveStorageReq a = new CloudStorage.StGetUserInteractiveStorageReq();
  
  public bhdq(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString)
  {
    if (paramStCommonExt != null) {
      this.a.ext.set(paramStCommonExt);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramStCommonExt = paramArrayOfString[i];
      this.a.keyList.add(paramStCommonExt);
      i += 1;
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
    CloudStorage.StGetUserInteractiveStorageRsp localStGetUserInteractiveStorageRsp = new CloudStorage.StGetUserInteractiveStorageRsp();
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGetUserInteractiveStorageRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGetUserInteractiveStorageRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStGetUserInteractiveStorageRsp);
        paramArrayOfByte.put("resultCode", 0);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QMLog.d("GetUserInteractiveStorageRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetUserInteractiveStorageRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetUserInteractiveStorage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdq
 * JD-Core Version:    0.7.0.1
 */