import android.content.Intent;
import android.content.SharedPreferences;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

class bjfk
  extends WtloginObserver
{
  bjfk(bjfi parambjfi) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrAgentLoginManager", 2, "OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    }
    paramArrayOfByte1 = BaseActivity.sTopActivity;
    if (paramInt == 0)
    {
      if (bjhh.a(paramArrayOfByte1)) {
        paramArrayOfByte1.finish();
      }
      QIPCClientHelper.getInstance().callServer("QR_LOGIN_QIPC_MODULE_NAME", "QIPC_SHOW_TOAST_ACTION", null, null);
    }
    while (!bjhh.a(paramArrayOfByte1)) {
      return;
    }
    paramWUserSigInfo = new Intent(paramArrayOfByte1, QRLoginAuthActivity.class);
    paramWUserSigInfo.putExtra("QR_CODE_STRING", BaseApplicationImpl.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4).getString("KEY_QR_AGENT_LOGIN_CODE" + paramString, ""));
    paramWUserSigInfo.putExtra("KEY_QR_CODE_EXPIRED", true);
    paramArrayOfByte1.startActivity(paramWUserSigInfo);
    paramArrayOfByte1.finish();
  }
  
  public void onException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrAgentLoginManager", 2, "OnException e=" + paramString);
    }
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrAgentLoginManager", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt + " appName: " + paramArrayOfByte1);
    }
    if (paramInt != 0) {
      bjfi.a(this.a, paramArrayOfByte2);
    }
    while ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    while (paramInt < paramArrayList.size()) {
      try
      {
        paramString = HexUtil.hexStr2Bytes((String)paramArrayList.get(paramInt));
        int i = util.buf_to_int16(paramString, 0);
        int j = util.buf_to_int16(paramString, 2);
        if (i == 54)
        {
          paramArrayOfByte1 = new byte[j];
          System.arraycopy(paramString, 4, paramArrayOfByte1, 0, j);
          paramString = new String(paramArrayOfByte1);
          if (QLog.isColorLevel()) {
            QLog.i("QrAgentLoginManager", 2, "OnVerifyCode: invoked.  appidJson: " + paramString);
          }
          paramString = new JSONObject(paramString);
          paramLong = paramString.optLong("open_appid");
          paramArrayOfByte1 = paramString.optString("comefrom");
          paramString = paramArrayOfByte1;
          if ("app".equals(paramArrayOfByte1)) {
            paramString = "android";
          }
          this.a.a(paramLong, paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QrAgentLoginManager", 2, "OnVerifyCode: failed. ", paramString);
        }
        paramInt += 1;
      }
    }
    paramString = BaseActivity.sTopActivity;
    if (paramString == null)
    {
      QLog.e("QrAgentLoginManager", 1, "OnException null== BaseActivity.sTopActivity");
      return;
    }
    paramArrayOfByte1 = new Intent(paramString, QRLoginAuthActivity.class);
    paramArrayOfByte1.putExtra("QR_CODE_STRING", bjfi.a(this.a));
    if (bjfi.a(this.a))
    {
      paramArrayOfByte1.putExtra("KEY_ERROR_MSG", QRLoginAuthActivity.c);
      if (paramString.app != null) {
        bjfi.a(this.a, paramString.app, bjfi.a(this.a));
      }
    }
    if (paramString.getIntent().getBooleanExtra("QRDecode", false))
    {
      paramString.startActivityForResult(paramArrayOfByte1, 2);
      return;
    }
    paramString.startActivity(paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfk
 * JD-Core Version:    0.7.0.1
 */