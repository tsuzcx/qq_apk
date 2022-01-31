import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment.3.1;
import com.tencent.mobileqq.fragment.NowLiveFragment.3.2;
import com.tencent.mobileqq.fragment.NowLiveFragment.3.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class appd
  implements WtTicketPromise
{
  public appd(NowLiveFragment paramNowLiveFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    if (paramTicket != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "preGetKeyInPreloadService : Done");
      }
      String str = new String((byte[])paramTicket._pskey_map.get("now.qq.com"));
      this.a.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + str);
      CookieSyncManager.getInstance().sync();
      this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit().putString("pskey", "" + str).commit();
      this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit().putLong("pskey_t", System.currentTimeMillis()).commit();
      NowLiveFragment.b = new String((byte[])paramTicket._pskey_map.get("now.qq.com"));
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new NowLiveFragment.3.1(this));
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowLiveFragment", 2, "preGetKeyInPreloadService failed " + paramErrMsg);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new NowLiveFragment.3.2(this));
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowLiveFragment", 2, "preGetKeyInPreloadService timeout!" + paramErrMsg);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new NowLiveFragment.3.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appd
 * JD-Core Version:    0.7.0.1
 */