import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qconn.protofile.auth.AuthRequest;
import com.tencent.qconn.protofile.auth.ProxyAuthRequest;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bjpv
{
  public void a(boolean paramBoolean, String paramString1, String paramString2, List<bjlv> paramList, long paramLong, bjpq parambjpq, String paramString3, Activity paramActivity, bjzb parambjzb, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("SDK_LOGIN.ProxyAuthManager", 1, "doAuthorize fail proxyAuthAppId is empty.");
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (paramBundle == null) || (parambjzb == null))
    {
      QLog.e("SDK_LOGIN.ProxyAuthManager", 1, "doAuthorize return for param is null.");
      parambjpq.a(false, -1, null);
      return;
    }
    Object localObject = new Bundle(paramBundle);
    ((Bundle)localObject).putString("openapi", "");
    ((Bundle)localObject).putBoolean("doAuthorize", true);
    ((Bundle)localObject).putString("need_pay", "1");
    ((Bundle)localObject).putString("appid_for_getting_config", ((Bundle)localObject).getString("client_id") + "");
    paramBundle = new auth.AuthRequest();
    paramBundle.appid.set(ForwardUtils.a(paramString1));
    paramBundle.need_paytoken.set(1);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (bjlv)paramString1.next();
        if (paramList.jdField_b_of_type_Boolean)
        {
          paramBundle.openapi.add(Integer.valueOf(paramList.jdField_b_of_type_Int));
          QLog.d("SDK_LOGIN.ProxyAuthManager", 1, new Object[] { "doAuthorize Permission.id=", Integer.valueOf(paramList.jdField_b_of_type_Int) });
        }
      }
    }
    paramList = paramBundle.os;
    long l;
    label411:
    label479:
    String str;
    if (Build.VERSION.RELEASE == null)
    {
      paramString1 = "";
      paramList.set(paramString1);
      paramBundle.qqv.set(bjjo.a().d());
      paramBundle.app_type.set(1);
      paramBundle.pf.set(bjqq.a((Bundle)localObject, "pf", "openmobile_android"));
      paramBundle.sdkp.set(bjqq.a((Bundle)localObject, "sdkp", "android"));
      paramBundle.sdkv.set(bjqq.a((Bundle)localObject, "sdkv", "1.5.9"));
      paramBundle.response_type.set(0);
      paramString1 = ((Bundle)localObject).getString("sign");
      if (TextUtils.isEmpty(paramString1)) {
        break label554;
      }
      paramBundle.sign.set(paramString1);
      paramString1 = ((Bundle)localObject).getString("time");
      if (!TextUtils.isEmpty(paramString1))
      {
        l = ForwardUtils.a(paramString1);
        paramBundle.md5time.set(l);
      }
      paramString1 = ((Bundle)localObject).keySet();
      paramString1.remove("sdkp");
      paramString1.remove("sign");
      paramString1.remove("sdkv");
      paramString1.remove("sign");
      paramString1.remove("time");
      paramList = new StringBuilder();
      paramActivity = paramString1.iterator();
      if (!paramActivity.hasNext()) {
        break label645;
      }
      str = (String)paramActivity.next();
      paramString1 = ((Bundle)localObject).get(str);
      if (paramString1 == null) {
        break label639;
      }
    }
    label554:
    label639:
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      paramList.append(str).append("=").append(URLEncoder.encode(paramString1)).append("&");
      break label479;
      paramString1 = Build.VERSION.RELEASE;
      break;
      paramList = bjzy.a(paramActivity, paramString3);
      paramString1 = paramList[1];
      paramList = paramList[2];
      QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign again");
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign sign is null");
        break label411;
      }
      paramBundle.sign.set(paramString1);
      if (TextUtils.isEmpty(paramList)) {
        break label411;
      }
      l = Long.parseLong(paramList);
      paramBundle.md5time.set(l);
      break label411;
    }
    label645:
    if (paramList.length() > 0)
    {
      paramList.delete(paramList.length() - 1, paramList.length());
      paramBundle.pass_data.set(paramList.toString());
    }
    paramBundle.skey.set(parambjzb.b);
    if (paramBoolean) {
      paramBundle.referer.set(4);
    }
    paramBundle.vid.set(paramLong);
    paramString1 = new auth.ProxyAuthRequest();
    paramString1.appid.set(ForwardUtils.a(paramString2));
    paramBundle.proxy_auth_req.set(paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      paramBundle.app_unique_identifier.set(paramString3);
    }
    for (;;)
    {
      paramString3 = String.valueOf(System.currentTimeMillis());
      paramBundle.state.set(paramString3);
      paramActivity = new NewIntent(BaseApplicationImpl.getApplication(), bjre.class);
      paramActivity.setWithouLogin(true);
      paramActivity.putExtra("uin", parambjzb.a);
      localObject = bjqq.a(localAppRuntime, parambjzb, paramBundle.login_sig, "QQConnectLogin.auth", "QQConnectLogin.auth_emp");
      paramBoolean = "QQConnectLogin.auth_emp".equals(localObject);
      paramList = paramBundle.toByteArray();
      paramString1 = paramList;
      if (paramBoolean) {
        paramString1 = bjzy.a(paramList, parambjzb);
      }
      paramActivity.putExtra("data", paramString1);
      paramActivity.putExtra("cmd", (String)localObject);
      paramLong = System.currentTimeMillis();
      QLog.d("SDK_LOGIN.ProxyAuthManager", 1, new Object[] { "cmd=" + (String)localObject, ", uin=*" + bjqq.a(parambjzb.a), ", reqState=", paramString3 });
      paramActivity.setObserver(new bjpw(this, paramLong, parambjzb, parambjpq, paramBoolean, paramString3, (String)localObject, paramString2));
      localAppRuntime.startServlet(paramActivity);
      return;
      QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "OpenVirtual.doAuthorize.appUniqueIdentifier is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpv
 * JD-Core Version:    0.7.0.1
 */