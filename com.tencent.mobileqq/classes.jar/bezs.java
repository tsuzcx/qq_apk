import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezs
  extends bfad
{
  private MiniProgramShare.StAdaptShareInfoReq a;
  
  public bezs(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq)
  {
    this.a = paramStAdaptShareInfoReq;
  }
  
  protected String a()
  {
    return "mini_app_share";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject2 = new PROTOCAL.StQWebRsp();
    Object localObject1 = new MiniProgramShare.StAdaptShareInfoRsp();
    for (;;)
    {
      long l;
      boolean bool2;
      int i;
      try
      {
        ((PROTOCAL.StQWebRsp)localObject2).mergeFrom(paramArrayOfByte);
        ((MiniProgramShare.StAdaptShareInfoRsp)localObject1).mergeFrom(((PROTOCAL.StQWebRsp)localObject2).busiBuff.get().toByteArray());
        if ((localObject2 == null) || (localObject1 == null)) {
          break label306;
        }
        l = ((PROTOCAL.StQWebRsp)localObject2).retCode.get();
        paramArrayOfByte = ((PROTOCAL.StQWebRsp)localObject2).errMsg.get().toStringUtf8();
        bool2 = bool3;
        if (((MiniProgramShare.StAdaptShareInfoRsp)localObject1).extInfo == null) {
          break label347;
        }
        bool2 = bool3;
        if (((MiniProgramShare.StAdaptShareInfoRsp)localObject1).extInfo.mapInfo == null) {
          break label347;
        }
        i = 0;
        bool2 = bool1;
        if (i >= ((MiniProgramShare.StAdaptShareInfoRsp)localObject1).extInfo.mapInfo.size()) {
          break label347;
        }
        localObject2 = (COMM.Entry)((MiniProgramShare.StAdaptShareInfoRsp)localObject1).extInfo.mapInfo.get(i);
        if ((!"needShareCallBack".equals(((COMM.Entry)localObject2).key.get())) || (!"true".equals(((COMM.Entry)localObject2).value.get()))) {
          break label340;
        }
        bool1 = true;
      }
      catch (Exception paramArrayOfByte)
      {
        label186:
        besl.a("GetShareInfoRequest", "onResponse fail." + paramArrayOfByte);
        return null;
      }
      besl.d("GetShareInfoRequest", "onGetShareInfo isSuccess=false, retCode=" + l);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("retCode", l);
      ((JSONObject)localObject1).put("errMsg", paramArrayOfByte);
      ((JSONObject)localObject1).put("needShareCallBack", bool2);
      return localObject1;
      label306:
      label340:
      label347:
      do
      {
        paramArrayOfByte = new JSONObject(((MiniProgramShare.StAdaptShareInfoRsp)localObject1).jsonData.get());
        paramArrayOfByte.put("needShareCallBack", bool2);
        return paramArrayOfByte;
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("retCode", -1);
        paramArrayOfByte.put("errMsg", "数据解析错误");
        besl.a("GetShareInfoRequest", "onResponse fail.webRsp = null");
        return paramArrayOfByte;
        i += 1;
        break;
        if (l == -100070004L) {
          break label186;
        }
      } while (l != -1000710003L);
    }
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "AdaptShareInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezs
 * JD-Core Version:    0.7.0.1
 */