import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bezg
  extends bfad
{
  private CloudStorage.StGetUserCloudStorageReq a = new CloudStorage.StGetUserCloudStorageReq();
  
  public bezg(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.a.keyList.add(str);
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
    Object localObject1 = new CloudStorage.StGetUserCloudStorageRsp();
    try
    {
      ((CloudStorage.StGetUserCloudStorageRsp)localObject1).mergeFrom(a(paramArrayOfByte));
      if ((localObject1 == null) || (((CloudStorage.StGetUserCloudStorageRsp)localObject1).KVDataList == null)) {
        break label174;
      }
      paramArrayOfByte = new JSONObject();
      Object localObject2 = ((CloudStorage.StGetUserCloudStorageRsp)localObject1).KVDataList.get();
      localObject1 = new JSONArray();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("key", localStKVData.key.get());
        localJSONObject.put("value", localStKVData.value.get());
        ((JSONArray)localObject1).put(localJSONObject);
      }
      paramArrayOfByte.put("KVDataList", localObject1);
    }
    catch (Exception paramArrayOfByte)
    {
      besl.a("GetCloudStorageRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    return paramArrayOfByte;
    label174:
    besl.a("GetCloudStorageRequest", "onResponse fail.rsp = null");
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetUserCloudStorage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezg
 * JD-Core Version:    0.7.0.1
 */