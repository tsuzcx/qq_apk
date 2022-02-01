import android.content.Context;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class amry
{
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("ForwardMiniAppThirdPartyHelper", 1, "Data is null");
      return "";
    }
    oidb_0xd55.RspBody localRspBody = new oidb_0xd55.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.wording.has()) {
        return localRspBody.wording.get();
      }
      return "";
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ForwardMiniAppThirdPartyHelper", 1, "oidb_0xd55_RspBody merge fail:" + paramArrayOfByte.getMessage());
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      MiniAppLauncher.launchMiniAppById(paramContext, paramString1, paramString2, null, paramString3, null, 1069);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ForwardMiniAppThirdPartyHelper", 1, paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amry
 * JD-Core Version:    0.7.0.1
 */