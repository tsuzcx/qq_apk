import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
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
import java.util.List;
import org.json.JSONObject;

public class bhdv
  extends bhdw
{
  private MiniAppMidasPay.StGamePayReq a = new MiniAppMidasPay.StGamePayReq();
  
  public bhdv(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4)
  {
    this.a.appId.set(paramString1);
    this.a.prepayId.set(paramString2);
    this.a.starCurrency.set(paramInt1);
    this.a.balanceAmount.set(paramInt2);
    this.a.topupAmount.set(paramInt3);
    this.a.payChannel.set(paramInt4);
    this.a.sandboxEnv.set(paramInt5);
    paramString2 = new COMM.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new COMM.Entry();
    ((COMM.Entry)localObject).key.set("refer");
    PBStringField localPBStringField = ((COMM.Entry)localObject).value;
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "";
    }
    localPBStringField.set(paramString1);
    localArrayList.add(localObject);
    paramString3 = new COMM.Entry();
    paramString3.key.set("via");
    localObject = paramString3.value;
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "";
    }
    ((PBStringField)localObject).set(paramString1);
    localArrayList.add(paramString3);
    paramString2.mapInfo.set(localArrayList);
    this.a.extInfo.setHasFlag(true);
    this.a.extInfo.set(paramString2);
  }
  
  protected String a()
  {
    return "mini_app_pay";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    MiniAppMidasPay.StGamePayRsp localStGamePayRsp = new MiniAppMidasPay.StGamePayRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGamePayRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGamePayRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStGamePayRsp);
        paramArrayOfByte.put("resultCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      QMLog.d("MiniAppPayRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("MiniAppPayRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GamePay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdv
 * JD-Core Version:    0.7.0.1
 */