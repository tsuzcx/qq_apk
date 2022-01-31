import NS_MINI_CLOUDSTORAGE.CloudStorage.StRemoveUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StRemoveUserCloudStorageRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bdub
  extends bdtz
{
  private CloudStorage.StRemoveUserCloudStorageReq a = new CloudStorage.StRemoveUserCloudStorageReq();
  
  public bdub(String[] paramArrayOfString, String paramString)
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
    CloudStorage.StRemoveUserCloudStorageRsp localStRemoveUserCloudStorageRsp = new CloudStorage.StRemoveUserCloudStorageRsp();
    try
    {
      localStRemoveUserCloudStorageRsp.mergeFrom(a(paramArrayOfByte));
      if (localStRemoveUserCloudStorageRsp != null) {
        return new JSONObject();
      }
      bdnw.a("ProtoBufRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "RemoveUserCloudStorage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdub
 * JD-Core Version:    0.7.0.1
 */