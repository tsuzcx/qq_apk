import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class bhdu
  extends bhdw
{
  private CloudStorage.StModifyFriendInteractiveStorageReq a = new CloudStorage.StModifyFriendInteractiveStorageReq();
  
  public bhdu(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap)
  {
    if (paramStCommonExt != null) {
      this.a.ext.set(paramStCommonExt);
    }
    this.a.appid.set(paramString1);
    this.a.toUser.set(paramString2);
    this.a.shareId.set(paramString3);
    this.a.opNum.set(paramInt);
    this.a.operation.set(paramString4);
    paramStCommonExt = paramHashMap.entrySet().iterator();
    while (paramStCommonExt.hasNext())
    {
      paramString1 = (Map.Entry)paramStCommonExt.next();
      paramString2 = new CloudStorage.StKVData();
      paramString2.key.set((String)paramString1.getKey());
      paramString2.value.set((String)paramString1.getValue());
      this.a.KVDataList.add(paramString2);
    }
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
    CloudStorage.StModifyFriendInteractiveStorageRsp localStModifyFriendInteractiveStorageRsp = new CloudStorage.StModifyFriendInteractiveStorageRsp();
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStModifyFriendInteractiveStorageRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStModifyFriendInteractiveStorageRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStModifyFriendInteractiveStorageRsp);
        paramArrayOfByte.put("resultCode", 0);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QMLog.d("ModifyFriendInteractiveStorageRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ModifyFriendInteractiveStorageRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "ModifyFriendInteractiveStorage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdu
 * JD-Core Version:    0.7.0.1
 */