import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager.1;
import com.tencent.open.virtual.OpenSdkVirtualManager.2;
import com.tencent.open.virtual.OpenSdkVirtualManager.4;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.qconn.protofile.appType.AndroidInfo;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qconn.protofile.preAuth.VirtualProfile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class bcjn
{
  private int jdField_a_of_type_Int;
  private ConcurrentHashMap<String, GetVirtualListResult> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, bciz> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Bundle> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<bbvs>> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, aphd> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, preAuth.PreAuthResponse> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> i = new ConcurrentHashMap();
  
  private void a(bciz parambciz, String paramString, JSONObject paramJSONObject, bcjw parambcjw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkVirtualManager", 2, new Object[] { "OpenVirtual.handleUploadAvatar.count:", Integer.valueOf(this.jdField_a_of_type_Int), ",imagePath:", paramString });
    }
    paramString = new bcjr(this, parambciz, parambcjw, paramString, paramJSONObject);
    bcjy.a("oidb_0xc7f_25", parambciz, paramJSONObject.toString(), paramString);
  }
  
  public aphd a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aphd)this.e.get(paramString);
  }
  
  public bciz a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (bciz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public GetVirtualListResult a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (GetVirtualListResult)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public preAuth.PreAuthRequest a(bciz parambciz, Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "-->createPreAuthRequest pkgName=", paramString1, ", appid=", paramString2, ", accountInfo=", parambciz });
    preAuth.PreAuthRequest localPreAuthRequest = new preAuth.PreAuthRequest();
    localPreAuthRequest.appid.set(ForwardUtils.a(paramString2));
    paramString2 = paramBundle.getString("sdkp");
    PBStringField localPBStringField = localPreAuthRequest.sdkp;
    paramActivity = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramActivity = "android";
    }
    localPBStringField.set(paramActivity);
    paramString2 = paramBundle.getString("sdkv");
    localPBStringField = localPreAuthRequest.sdkv;
    paramActivity = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramActivity = "1.5.9";
    }
    localPBStringField.set(paramActivity);
    localPreAuthRequest.qqv.set(bbtm.a().d());
    paramString2 = localPreAuthRequest.os;
    if (Build.VERSION.RELEASE == null) {}
    for (paramActivity = "";; paramActivity = Build.VERSION.RELEASE)
    {
      paramString2.set(paramActivity);
      paramString2 = paramBundle.getString("scope");
      localPBStringField = localPreAuthRequest.scope;
      paramActivity = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramActivity = "";
      }
      localPBStringField.set(paramActivity);
      localPreAuthRequest.skey.set(parambciz.jdField_b_of_type_JavaLangString);
      localPreAuthRequest.app_type.set(1);
      if (!TextUtils.isEmpty(paramString1)) {
        localPreAuthRequest.appUniqueIdentifier.set(paramString1);
      }
      if (!paramBundle.getBoolean("key_login_by_qr_scan", false)) {
        break;
      }
      localPreAuthRequest.referer.set(4);
      return localPreAuthRequest;
    }
    localPreAuthRequest.referer.set(1);
    return localPreAuthRequest;
  }
  
  public preAuth.PreAuthResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (preAuth.PreAuthResponse)this.f.get(paramString);
  }
  
  public List<bbvs> a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (List)this.d.get(paramString);
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "getPermissionListByAppid null for appid=", paramString });
    return null;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, bcjw parambcjw)
  {
    bciz localbciz = (bciz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (localbciz == null))
    {
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.return for params error");
      if (parambcjw != null) {
        parambcjw.a(false, null, -1);
      }
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_appid", paramLong);
      localJSONObject.put("str_nick", paramString1);
      localJSONObject.put("str_head_id", paramString2);
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createVirtual.start:", bcjy.a(localJSONObject.toString(), localbciz.jdField_a_of_type_JavaLangString) });
      ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.1(this, localbciz, localJSONObject, parambcjw));
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.e:", paramString1);
      }
    }
  }
  
  public void a(preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity, bciz parambciz, bcjx parambcjx, int paramInt)
  {
    QLog.d("OpenSdkVirtualManager", 1, "preAuthWithRetry");
    if (paramActivity == null)
    {
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry activity==null, preAuthCallback=", parambcjx });
      if (parambcjx != null) {
        parambcjx.a(-1, "");
      }
      return;
    }
    if (!TextUtils.isEmpty(paramPreAuthRequest.appUniqueIdentifier.get()))
    {
      localObject = bcjy.a(paramActivity, paramPreAuthRequest.appUniqueIdentifier.get());
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry.getAuthorizeSign sign=", localObject[1], ", timestr=", localObject[2] });
      if (!TextUtils.isEmpty(localObject[1]))
      {
        paramPreAuthRequest.sign.set(localObject[1]);
        if (!TextUtils.isEmpty(localObject[2])) {
          paramPreAuthRequest.md5time.set(Long.parseLong(localObject[2]));
        }
      }
    }
    Object localObject = new NewIntent(BaseApplicationImpl.getApplication(), bcaz.class);
    ((NewIntent)localObject).putExtra("uin", parambciz.jdField_a_of_type_JavaLangString);
    ((NewIntent)localObject).putExtra("data", bcjy.a(paramPreAuthRequest.toByteArray(), parambciz));
    ((NewIntent)localObject).putExtra("cmd", "QQConnectLogin.pre_auth_emp");
    ((NewIntent)localObject).putExtra("timeout", 15000L);
    ((NewIntent)localObject).putExtra("key_support_retry", true);
    ((NewIntent)localObject).setWithouLogin(true);
    apmt.a("KEY_PRE_AUTH");
    ((NewIntent)localObject).setObserver(new bcju(this, parambciz, parambcjx, paramInt, paramPreAuthRequest, paramActivity));
    BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
  }
  
  public void a(OpenSDKAppInterface paramOpenSDKAppInterface, String paramString, bcjv parambcjv)
  {
    QLog.d("OpenSdkVirtualManager", 1, "getTicketNoPasswd uin=" + bcam.a(paramString));
    new bciz().jdField_a_of_type_JavaLangString = paramString;
    bcja.a().a(paramString, 4096, new bcjt(this, paramOpenSDKAppInterface, parambcjv), false);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.h.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString, long paramLong, bcjw parambcjw)
  {
    bciz localbciz = (bciz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString));
    if (localbciz == null)
    {
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.deleteVirtual.return for account is null");
      if (parambcjw != null) {
        parambcjw.a(false, -1);
      }
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_vuid", paramLong);
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.deleteVirtual.start.appid=", paramString, ",body:", localJSONObject.toString() });
      ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.2(this, localbciz, localJSONObject, parambcjw));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.deleteVirtual.e:", localJSONException);
      }
    }
  }
  
  public void a(String paramString1, Activity paramActivity, String paramString2, Bundle paramBundle, bcjx parambcjx)
  {
    bciz localbciz = (bciz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString1));
    if ((localbciz == null) || (paramActivity == null))
    {
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer account=", localbciz, ", context=", paramActivity });
      if (parambcjx != null) {
        parambcjx.a(-1, "");
      }
      return;
    }
    a(a(localbciz, paramActivity, paramString2, paramString1, paramBundle), paramActivity, localbciz, new bcjq(this, parambcjx), 2);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null)) {
      this.c.put(paramString, paramBundle);
    }
  }
  
  public void a(String paramString, bciz parambciz)
  {
    if ((!TextUtils.isEmpty(paramString)) && (parambciz != null)) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambciz);
    }
  }
  
  public void a(String paramString1, String paramString2, bcjw parambcjw)
  {
    bciz localbciz = (bciz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString1));
    if ((TextUtils.isEmpty(paramString2)) || (localbciz == null))
    {
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.uploadAvatarImage.return for params error");
      if (parambcjw != null) {
        parambcjw.a(false, paramString2, null, -1);
      }
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.4(this, paramString2, paramString1, localbciz, parambcjw));
  }
  
  public void a(boolean paramBoolean, String paramString1, List<bbvs> paramList, long paramLong, bcjw parambcjw, String paramString2, Activity paramActivity)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    bciz localbciz = (bciz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    Object localObject1 = (Bundle)this.c.get(paramString1);
    if ((localAppRuntime == null) || (localObject1 == null) || (localbciz == null))
    {
      QLog.e("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize return for param is null.");
      if (parambcjw != null) {
        parambcjw.a(false, -1, null);
      }
      return;
    }
    Bundle localBundle = new Bundle((Bundle)localObject1);
    localBundle.putString("openapi", "");
    localBundle.putBoolean("doAuthorize", true);
    localBundle.putString("need_pay", "1");
    localBundle.putString("appid_for_getting_config", localBundle.getString("client_id") + "");
    long l = Long.parseLong(paramString1);
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(l);
    localAuthorizeRequest.need_pay.set(1);
    localObject1 = new StringBuilder("OpenVirtual.doAuthorize.appid:");
    ((StringBuilder)localObject1).append(paramString1).append(", virtual id =").append(paramLong).append(", checked api id [");
    Object localObject2;
    Object localObject3;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bbvs)((Iterator)localObject2).next();
        if (((bbvs)localObject3).jdField_b_of_type_Boolean)
        {
          localAuthorizeRequest.openapi.add(Integer.valueOf(((bbvs)localObject3).jdField_b_of_type_Int));
          ((StringBuilder)localObject1).append(((bbvs)localObject3).jdField_b_of_type_Int).append(",");
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    QLog.i("OpenSdkVirtualManager", 1, ((StringBuilder)localObject1).toString());
    label419:
    label446:
    label598:
    String str;
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      localAuthorizeRequest.os.set((String)localObject1);
      localAuthorizeRequest.qqv.set(bbtm.a().d());
      localObject2 = localBundle.getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      localAuthorizeRequest.pf.set((String)localObject1);
      localObject1 = localBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label693;
      }
      localAuthorizeRequest.sdkp.set("android");
      localObject1 = localBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label706;
      }
      localAuthorizeRequest.sdkv.set("1.5.9");
      localAuthorizeRequest.response_type.set("token");
      localObject1 = localBundle.getString("sign");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label719;
      }
      localAuthorizeRequest.sign.set((String)localObject1);
      localObject1 = localBundle.getString("time");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        l = Long.parseLong((String)localObject1);
        localAuthorizeRequest.time.set(l);
      }
      label520:
      localObject1 = localBundle.keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject3 = ((Set)localObject1).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label814;
      }
      str = (String)((Iterator)localObject3).next();
      localObject1 = localBundle.get(str);
      if (localObject1 == null) {
        break label807;
      }
    }
    label807:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label598;
      localObject1 = Build.VERSION.RELEASE;
      break;
      label693:
      localAuthorizeRequest.sdkp.set((String)localObject1);
      break label419;
      label706:
      localAuthorizeRequest.sdkv.set((String)localObject1);
      break label446;
      label719:
      localObject2 = bcjy.a(paramActivity, paramString2);
      localObject1 = localObject2[1];
      localObject2 = localObject2[2];
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign again");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign sign is null");
        break label520;
      }
      localAuthorizeRequest.sign.set((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label520;
      }
      l = Long.parseLong((String)localObject2);
      localAuthorizeRequest.time.set(l);
      break label520;
    }
    label814:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      localAuthorizeRequest.passData.set(((StringBuffer)localObject2).toString());
    }
    localAuthorizeRequest.skey.set(localbciz.jdField_b_of_type_JavaLangString);
    if (paramBoolean) {
      localAuthorizeRequest.referer.set(4);
    }
    localAuthorizeRequest.vID.set(paramLong);
    if (!TextUtils.isEmpty(paramString2)) {
      localAuthorizeRequest.appUniqueIdentifier.set(paramString2);
    }
    for (;;)
    {
      localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), bcaz.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("uin", localbciz.jdField_a_of_type_JavaLangString);
      ((NewIntent)localObject1).putExtra("data", bcjy.a(localAuthorizeRequest.toByteArray(), localbciz));
      ((NewIntent)localObject1).putExtra("cmd", "ConnAuthSvr.sdk_auth_api_emp");
      ((NewIntent)localObject1).setObserver(new bcjs(this, System.currentTimeMillis(), localbciz, parambcjw, paramString1, "ConnAuthSvr.sdk_auth_api_emp", paramBoolean, paramList, paramLong, paramString2, paramActivity));
      localAppRuntime.startServlet((NewIntent)localObject1);
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.doAuthorize.send | cmd: " + "s_a_a_emp", " | uin : *" + bcam.a(localbciz.jdField_a_of_type_JavaLangString) });
      return;
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.appUniqueIdentifier is null");
    }
  }
  
  public boolean a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "onPreAuthBack preAuth.PreAuthResponse=", paramPreAuthResponse.toString() });
    if (!paramPreAuthResponse.appid.has()) {
      return false;
    }
    String str = Long.toString(paramPreAuthResponse.appid.get());
    this.f.put(str, paramPreAuthResponse);
    Object localObject1 = new ArrayList();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramPreAuthResponse.auth_items.has())
    {
      localObject2 = paramPreAuthResponse.auth_items.get().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (appType.AuthItem)((Iterator)localObject2).next();
        localObject4 = new bbvs();
        ((bbvs)localObject4).jdField_b_of_type_JavaLangString = ((appType.AuthItem)localObject3).api_list.get();
        ((bbvs)localObject4).jdField_a_of_type_Int = ((appType.AuthItem)localObject3).default_flag.get();
        ((bbvs)localObject4).jdField_b_of_type_Int = ((appType.AuthItem)localObject3).id.get();
        if (((appType.AuthItem)localObject3).is_new.get() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((bbvs)localObject4).jdField_a_of_type_Boolean = bool;
          ((bbvs)localObject4).jdField_a_of_type_JavaLangString = ((appType.AuthItem)localObject3).title.get();
          QLog.d("OpenSdkVirtualManager", 1, new Object[] { "onPreAuthBack Permission=", ((bbvs)localObject4).toString() });
          ((List)localObject1).add(localObject4);
          break;
        }
      }
    }
    this.d.put(str, localObject1);
    if (paramPreAuthResponse.android_info.has()) {
      this.e.put(str, aphd.a(paramPreAuthResponse, paramPreAuthResponse.android_info));
    }
    localObject1 = new GetVirtualListResult();
    if (paramPreAuthResponse.profiles.has())
    {
      localObject2 = new ArrayList();
      localObject3 = paramPreAuthResponse.profiles.get().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (preAuth.VirtualProfile)((Iterator)localObject3).next();
        VirtualInfo localVirtualInfo = new VirtualInfo();
        localVirtualInfo.jdField_a_of_type_Long = ((preAuth.VirtualProfile)localObject4).vid.get();
        localVirtualInfo.jdField_a_of_type_JavaLangString = ((preAuth.VirtualProfile)localObject4).nick_name.get();
        localVirtualInfo.jdField_b_of_type_JavaLangString = ((preAuth.VirtualProfile)localObject4).avatar_url.get();
        ((ArrayList)localObject2).add(localVirtualInfo);
      }
      ((GetVirtualListResult)localObject1).jdField_a_of_type_Long = paramPreAuthResponse.vid.get();
      ((GetVirtualListResult)localObject1).jdField_a_of_type_Int = paramPreAuthResponse.ret.get();
      ((GetVirtualListResult)localObject1).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcjn
 * JD-Core Version:    0.7.0.1
 */