import NS_MINI_INTERFACE.INTERFACE.StBaseLibInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bfae
  extends bfau
{
  private INTERFACE.StGetNewBaseLibReq a = new INTERFACE.StGetNewBaseLibReq();
  
  public bfae(String paramString, int paramInt)
  {
    this.a.curVersion.set(paramString);
    this.a.type.set(paramInt);
  }
  
  protected String a()
  {
    return "mini_app_info";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetNewBaseLibRsp localStGetNewBaseLibRsp = new INTERFACE.StGetNewBaseLibRsp();
    try
    {
      localStGetNewBaseLibRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetNewBaseLibRsp == null) {
        break label338;
      }
      paramArrayOfByte = new JSONObject();
      int i = localStGetNewBaseLibRsp.interval.get();
      betc.b("GetNewBaseLibRequest", "[MiniEng] GetNewBaseLib interval:" + i);
      long l1 = i * 1000;
      long l2 = System.currentTimeMillis();
      bfhm.a().edit().putLong("baselib_min_update_time", l1 + l2).apply();
      Iterator localIterator = localStGetNewBaseLibRsp.jsOrsoLibs.get().iterator();
      while (localIterator.hasNext())
      {
        INTERFACE.StBaseLibInfo localStBaseLibInfo = (INTERFACE.StBaseLibInfo)localIterator.next();
        BaseLibInfo localBaseLibInfo = new BaseLibInfo();
        localBaseLibInfo.baseLibUrl = localStBaseLibInfo.downloadUrl.get();
        localBaseLibInfo.baseLibVersion = localStBaseLibInfo.version.get();
        localBaseLibInfo.baseLibKey = null;
        localBaseLibInfo.baseLibDesc = localStBaseLibInfo.extInfo.get();
        if (TextUtils.isEmpty(localBaseLibInfo.baseLibDesc)) {
          localBaseLibInfo.baseLibDesc = "{'file_length':-1}";
        }
        localBaseLibInfo.baseLibType = localStBaseLibInfo.libType.get();
        paramArrayOfByte.put(localBaseLibInfo.getKey(), localBaseLibInfo.toJSONObject());
        betc.b("GetNewBaseLibRequest", "[MiniEng] GetNewBaseLib " + localBaseLibInfo);
      }
      paramArrayOfByte.put("version", localStGetNewBaseLibRsp.libInfo.version.get());
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("GetNewBaseLibRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    paramArrayOfByte.put("downloadUrl", localStGetNewBaseLibRsp.libInfo.downloadUrl.get());
    return paramArrayOfByte;
    label338:
    betc.a("GetNewBaseLibRequest", "onResponse fail.rsp = null");
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetNewBaseLib";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfae
 * JD-Core Version:    0.7.0.1
 */