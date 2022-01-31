import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StSetUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StSetUserCloudStorageRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class bfba
  extends bfau
{
  private CloudStorage.StSetUserCloudStorageReq a = new CloudStorage.StSetUserCloudStorageReq();
  
  public bfba(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      CloudStorage.StKVData localStKVData = new CloudStorage.StKVData();
      localStKVData.key.set((String)localEntry.getKey());
      localStKVData.value.set((String)localEntry.getValue());
      this.a.KVDataList.add(localStKVData);
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
    CloudStorage.StSetUserCloudStorageRsp localStSetUserCloudStorageRsp = new CloudStorage.StSetUserCloudStorageRsp();
    try
    {
      localStSetUserCloudStorageRsp.mergeFrom(a(paramArrayOfByte));
      if (localStSetUserCloudStorageRsp != null) {
        return new JSONObject();
      }
      betc.a("SetCloudStorageRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("SetCloudStorageRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "SetUserCloudStorage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfba
 * JD-Core Version:    0.7.0.1
 */