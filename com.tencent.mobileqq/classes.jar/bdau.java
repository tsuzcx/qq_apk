import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3.1;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class bdau
  extends alxu
{
  bdau(bdat parambdat) {}
  
  protected void b(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(bdat.a(this.a));
    }
    if (paramInt != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcObserver", 2, "invalid notification type for onGetUinSafetyWordingConfig:" + Integer.toString(paramInt));
      }
    }
    while (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("config_name");
    localObject = str;
    if (!TextUtils.isEmpty(str))
    {
      localObject = str;
      if (TextUtils.equals("SenstiveMessageTipsCfg", str)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.post(new AntiFraudConfigFileUtil.3.1(this, (String)localObject, paramBundle.getInt("effect_time", 0), paramBundle.getString("md5"), paramBundle.getString("download_url")), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdau
 * JD-Core Version:    0.7.0.1
 */