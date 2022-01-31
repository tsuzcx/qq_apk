import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetFriendCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetFriendCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StUserGameData;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bezj
  extends bfad
{
  private CloudStorage.StGetFriendCloudStorageReq a = new CloudStorage.StGetFriendCloudStorageReq();
  
  public bezj(String[] paramArrayOfString, String paramString)
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
    Object localObject1 = new CloudStorage.StGetFriendCloudStorageRsp();
    for (;;)
    {
      JSONObject localJSONObject1;
      try
      {
        ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).mergeFrom(a(paramArrayOfByte));
        if (localObject1 == null) {
          break label330;
        }
        Object localObject2 = ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).data.get();
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label339;
        }
        paramArrayOfByte = new JSONObject();
        localObject1 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = (CloudStorage.StUserGameData)((Iterator)localObject2).next();
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("avatarUrl", ((CloudStorage.StUserGameData)localObject3).avatarUrl.get());
        localJSONObject1.put("nickname", ((CloudStorage.StUserGameData)localObject3).nickname.get());
        localJSONObject1.put("openid", ((CloudStorage.StUserGameData)localObject3).openid.get());
        if ((((CloudStorage.StUserGameData)localObject3).KVDataList != null) && (((CloudStorage.StUserGameData)localObject3).KVDataList.size() > 0))
        {
          Object localObject4 = ((CloudStorage.StUserGameData)localObject3).KVDataList.get();
          localObject3 = new JSONArray();
          localObject4 = ((List)localObject4).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject4).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("key", localStKVData.key.get());
            localJSONObject2.put("value", localStKVData.value.get());
            ((JSONArray)localObject3).put(localJSONObject2);
            continue;
          }
          localJSONObject1.put("KVDataList", localObject3);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        besl.a("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
        return null;
      }
      ((JSONArray)localObject1).put(localJSONObject1);
    }
    paramArrayOfByte.put("data", localObject1);
    return paramArrayOfByte;
    label330:
    besl.a("ProtoBufRequest", "onResponse fail.rsp = null");
    return null;
    label339:
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetFriendCloudStorage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezj
 * JD-Core Version:    0.7.0.1
 */