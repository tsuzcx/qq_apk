import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class asxg
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, asxk paramasxk)
  {
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    YTAGReflectLiveCheckInterface.getLiveCheckType(paramContext.getApplicationContext(), new asxi(localAtomicBoolean, paramString1, paramString2, paramString3, paramLong, paramasxk));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, oidb_0x5e1.RspBody paramRspBody, FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse, Runnable paramRunnable)
  {
    if (((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() == 0)
    {
      if ((paramSecureCheckResponse == null) || (!paramSecureCheckResponse.bool_sec_pass.get()))
      {
        if (System.currentTimeMillis() - AuthDevVerifyCodeActivity.a >= 60000L)
        {
          azbn.b(paramQQAppInterface, new asxh(paramActivity, paramString, paramRunnable));
          return;
        }
        paramRspBody = new Intent(paramActivity, AuthDevVerifyCodeActivity.class);
        paramRspBody.putExtra("k_from", "f_SetFaceData");
        paramQQAppInterface = paramString;
        if (paramString == null) {
          paramQQAppInterface = "";
        }
        paramRspBody.putExtra("phone_num", paramQQAppInterface);
        paramActivity.startActivityForResult(paramRspBody, 11);
        return;
      }
      paramQQAppInterface = new Intent(paramActivity, QQIdentiferLegacyActivity.class);
      paramQQAppInterface.putExtra("platformAppId", 101810106);
      paramQQAppInterface.putExtra("srcAppId", 101810106);
      paramQQAppInterface.putExtra("srcOpenId", paramSecureCheckResponse.str_openid.get());
      paramQQAppInterface.putExtra("key", paramSecureCheckResponse.str_tmpkey.get());
      paramQQAppInterface.putExtra("method", "setFaceData");
      paramQQAppInterface.putExtra("serviceType", 2);
      paramActivity.startActivityForResult(paramQQAppInterface, 21);
      return;
    }
    PublicFragmentActivity.a(paramActivity, DeleteFaceFragment.class, 12);
  }
  
  private static void b(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, asxk paramasxk)
  {
    QLog.d("FaceLoginHelper", 1, new Object[] { "start sendPacket appid : ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcAppId", paramInt);
      localBundle.putString("key", paramString1);
      localBundle.putString("lightInfo", paramString4);
      localBundle.putString("method", paramString2);
      localBundle.putString("uin", paramString3);
      localBundle.putLong("nonce", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("FaceLoginHelper", 1, "sendPacket" + paramString4);
      }
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new asxj(paramasxk));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxg
 * JD-Core Version:    0.7.0.1
 */