import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class bddm
  extends WtloginObserver
{
  public bddm(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void OnException(String paramString, int paramInt)
  {
    super.OnException(paramString, paramInt);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnException() e:" + paramString);
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnVerifyCode(): ret=" + paramInt);
    if (paramInt == 0)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        paramInt = 0;
      }
      while (paramInt < paramArrayList.size())
      {
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
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnVerifyCode(): getAppid sucess Json:" + paramString);
            paramString = new JSONObject(paramString);
            paramLong = paramString.optLong("open_appid");
            paramString = paramString.optString("comefrom");
            this.a.a(paramLong, paramString);
            if (!TextUtils.isEmpty(paramString))
            {
              paramArrayOfByte1 = Message.obtain();
              paramArrayOfByte1.what = 1004;
              paramArrayOfByte1.obj = paramString;
              this.a.b.sendMessage(paramArrayOfByte1);
            }
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnVerifyCode(): Exeption:", paramString);
          }
        }
        paramInt += 1;
        continue;
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnVerifyCode(): getAppid failed for data is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bddm
 * JD-Core Version:    0.7.0.1
 */