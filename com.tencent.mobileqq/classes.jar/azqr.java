import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class azqr
  extends avvd
{
  protected void e(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof mobile_get_qzone_public_msg_rsp)))
    {
      int i = azqp.a().decrementAndGet();
      azqp.a(0);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      localAppRuntime.getPreferences().edit().putInt(localAppRuntime.getAccount() + "_" + "qzone_xp_req_left", i).apply();
      azqp.b(((mobile_get_qzone_public_msg_rsp)paramBundle).next_req_tmstamp);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneReport", 2, "next req time: " + azqp.b() + ", left: " + i);
      }
      azqs.b(null, "CliOper", "", "", "0X800915D", "0X800915D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      azqp.a().set(false);
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(azqp.a());
      return;
      azqp.c();
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqr
 * JD-Core Version:    0.7.0.1
 */