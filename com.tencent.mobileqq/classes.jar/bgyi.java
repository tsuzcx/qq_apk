import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bgyi
  extends bgzp
{
  private INTERFACE.StBatchGetUserInfoReq a = new INTERFACE.StBatchGetUserInfoReq();
  
  public bgyi(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.a.appid.set(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      this.a.lang.set(paramString2);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString1 = paramArrayOfString[i];
      this.a.openIds.add(paramString1);
      i += 1;
    }
  }
  
  protected String a()
  {
    return "mini_user_info";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new INTERFACE.StBatchGetUserInfoRsp();
    try
    {
      ((INTERFACE.StBatchGetUserInfoRsp)localObject).mergeFrom(a(paramArrayOfByte));
      if ((localObject == null) || (((INTERFACE.StBatchGetUserInfoRsp)localObject).user == null)) {
        break label270;
      }
      localObject = ((INTERFACE.StBatchGetUserInfoRsp)localObject).user.get();
      paramArrayOfByte = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        INTERFACE.StApiUserInfo localStApiUserInfo = (INTERFACE.StApiUserInfo)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("nickName", localStApiUserInfo.nick.get());
        localJSONObject.put("avatarUrl", localStApiUserInfo.avatar.get());
        localJSONObject.put("gender", localStApiUserInfo.gender.get());
        localJSONObject.put("language", localStApiUserInfo.language.get());
        localJSONObject.put("country", localStApiUserInfo.address.country.get());
        localJSONObject.put("province", localStApiUserInfo.address.province.get());
        localJSONObject.put("city", localStApiUserInfo.address.city.get());
        localJSONObject.put("openId", localStApiUserInfo.openid.get());
        paramArrayOfByte.put(localJSONObject);
      }
      localObject = new JSONObject();
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("BatchGetUserInfoRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    ((JSONObject)localObject).put("data", paramArrayOfByte);
    return localObject;
    label270:
    QMLog.d("BatchGetUserInfoRequest", "onResponse fail.rsp = null");
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "BatchGetUserInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyi
 * JD-Core Version:    0.7.0.1
 */