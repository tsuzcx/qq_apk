import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.StGetAdForSdkReq;
import NS_MINI_AD.MiniAppAd.StGetAdForSdkRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class bgyo
  extends bgzp
{
  private MiniAppAd.StGetAdForSdkReq a = new MiniAppAd.StGetAdForSdkReq();
  
  public bgyo(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap)
  {
    this.a.strAppid.set(paramString1);
    this.a.iAdType.set(paramInt);
    this.a.strGetAdUrl.set(paramString4);
    paramString1 = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramString4 = paramHashMap.entrySet().iterator();
      while (paramString4.hasNext())
      {
        localObject1 = (Map.Entry)paramString4.next();
        paramHashMap = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = new COMM.Entry();
        ((COMM.Entry)localObject2).key.set(paramHashMap);
        ((COMM.Entry)localObject2).value.set((String)localObject1);
        paramString1.add(localObject2);
      }
    }
    if (paramString1.size() > 0) {
      this.a.mapParam.addAll(paramString1);
    }
    paramString4 = new COMM.StCommonExt();
    paramHashMap = new ArrayList();
    Object localObject1 = new COMM.Entry();
    ((COMM.Entry)localObject1).key.set("refer");
    Object localObject2 = ((COMM.Entry)localObject1).value;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    ((PBStringField)localObject2).set(paramString1);
    paramHashMap.add(localObject1);
    paramString2 = new COMM.Entry();
    paramString2.key.set("via");
    localObject1 = paramString2.value;
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "";
    }
    ((PBStringField)localObject1).set(paramString1);
    paramHashMap.add(paramString2);
    paramString4.mapInfo.set(paramHashMap);
    this.a.extInfo.setHasFlag(true);
    this.a.extInfo.set(paramString4);
  }
  
  protected String a()
  {
    return "mini_app_ad";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    MiniAppAd.StGetAdForSdkRsp localStGetAdForSdkRsp = new MiniAppAd.StGetAdForSdkRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGetAdForSdkRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGetAdForSdkRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStGetAdForSdkRsp);
        paramArrayOfByte.put("resultCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QMLog.d("GetAdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetAdRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetAdForSdk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyo
 * JD-Core Version:    0.7.0.1
 */