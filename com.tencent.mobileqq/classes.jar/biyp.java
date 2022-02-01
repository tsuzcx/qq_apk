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
import com.tencent.open.model.AccountManage;
import com.tencent.open.model.AccountManage.RefreshReason;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager.1;
import com.tencent.open.virtual.OpenSdkVirtualManager.2;
import com.tencent.open.virtual.OpenSdkVirtualManager.4;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.qconn.protofile.appType.AndroidInfo;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qconn.protofile.preAuth.PreAuthProxyRequest;
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
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class biyp
{
  private int jdField_a_of_type_Int;
  private Set<String> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, GetVirtualListResult> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, biyc> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Bundle> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<bikw>> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, aufu> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, preAuth.PreAuthResponse> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> i = new ConcurrentHashMap();
  
  private void a(biyc parambiyc, String paramString, JSONObject paramJSONObject, bior parambior)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.handleUploadAvatar.count:", Integer.valueOf(this.jdField_a_of_type_Int), ",imagePath:", paramString });
    paramString = new biyt(this, parambiyc, parambior, paramString, paramJSONObject);
    biyz.a("oidb_0xc7f_25", parambiyc, paramJSONObject.toString(), paramString);
  }
  
  private void a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "onPreAuthResponse");
    if (!paramPreAuthResponse.appid.has()) {
      return;
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
        localObject4 = new bikw();
        ((bikw)localObject4).jdField_b_of_type_JavaLangString = ((appType.AuthItem)localObject3).api_list.get();
        ((bikw)localObject4).jdField_a_of_type_Int = ((appType.AuthItem)localObject3).default_flag.get();
        ((bikw)localObject4).jdField_b_of_type_Int = ((appType.AuthItem)localObject3).id.get();
        if (((appType.AuthItem)localObject3).is_new.get() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((bikw)localObject4).jdField_a_of_type_Boolean = bool;
          ((bikw)localObject4).jdField_a_of_type_JavaLangString = ((appType.AuthItem)localObject3).title.get();
          QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "onPreAuthResponse Permission=", ((bikw)localObject4).toString() });
          ((List)localObject1).add(localObject4);
          break;
        }
      }
    }
    this.d.put(str, localObject1);
    if (paramPreAuthResponse.android_info.has()) {
      this.e.put(str, aufu.a(paramPreAuthResponse, paramPreAuthResponse.android_info));
    }
    localObject1 = new GetVirtualListResult();
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "onPreAuthResponse response.profiles.has()=", Boolean.valueOf(paramPreAuthResponse.profiles.has()) });
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
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "onPreAuthResponse nickName=", localVirtualInfo.jdField_a_of_type_JavaLangString + ", avatarUrl=", localVirtualInfo.jdField_b_of_type_JavaLangString });
        ((ArrayList)localObject2).add(localVirtualInfo);
      }
      ((GetVirtualListResult)localObject1).jdField_a_of_type_Long = paramPreAuthResponse.vid.get();
      ((GetVirtualListResult)localObject1).jdField_a_of_type_Int = paramPreAuthResponse.ret.get();
      ((GetVirtualListResult)localObject1).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject1);
  }
  
  private void b(String paramString)
  {
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (localTicketManager == null)
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "preAuthWithRetry manager==null");
      return;
    }
    String str1;
    if (TextUtils.isEmpty(localTicketManager.getA2(paramString)))
    {
      str1 = "empty";
      if (!TextUtils.isEmpty(localTicketManager.getSkey(paramString))) {
        break label126;
      }
    }
    label126:
    for (String str2 = "empty";; str2 = "valid")
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry a=", str1, ", s=", str2 });
      paramString = localTicketManager.getDA2(paramString);
      if (paramString != null) {
        break label133;
      }
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "preAuthWithRetry d==null");
      return;
      str1 = "valid";
      break;
    }
    label133:
    if (paramString.length == 0) {}
    for (paramString = "empty";; paramString = "valid")
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry d ", paramString });
      return;
    }
  }
  
  public aufu a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aufu)this.e.get(paramString);
  }
  
  public biyc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (biyc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public GetVirtualListResult a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (GetVirtualListResult)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public preAuth.PreAuthRequest a(biyc parambiyc, String paramString, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    preAuth.PreAuthRequest localPreAuthRequest = new preAuth.PreAuthRequest();
    localPreAuthRequest.appid.set(paramLong1);
    localPreAuthRequest.sdkp.set(bipr.a(paramBundle, "sdkp", "android"));
    localPreAuthRequest.sdkv.set(bipr.a(paramBundle, "sdkv", "1.5.9"));
    localPreAuthRequest.qqv.set(biip.a().d());
    PBStringField localPBStringField = localPreAuthRequest.os;
    String str;
    if (Build.VERSION.RELEASE == null)
    {
      str = "";
      localPBStringField.set(str);
      localPreAuthRequest.scope.set(bipr.a(paramBundle, "scope", ""));
      localPreAuthRequest.skey.set(parambiyc.jdField_b_of_type_JavaLangString);
      localPreAuthRequest.app_type.set(1);
      if (!TextUtils.isEmpty(paramString)) {
        localPreAuthRequest.appUniqueIdentifier.set(paramString);
      }
      if (!paramBundle.getBoolean("key_login_by_qr_scan", false)) {
        break label264;
      }
      localPreAuthRequest.referer.set(4);
    }
    for (;;)
    {
      if (paramLong2 != 0L)
      {
        parambiyc = new preAuth.PreAuthProxyRequest();
        parambiyc.appid.set(paramLong2);
        localPreAuthRequest.proxy_req.set(parambiyc);
      }
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "-->createPreAuthRequest pkgName=", paramString, ", hostAppId=", Long.valueOf(paramLong1), ", proxyAppId=", Long.valueOf(paramLong2) });
      return localPreAuthRequest;
      str = Build.VERSION.RELEASE;
      break;
      label264:
      localPreAuthRequest.referer.set(1);
    }
  }
  
  public preAuth.PreAuthResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (preAuth.PreAuthResponse)this.f.get(paramString);
  }
  
  public List<bikw> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (List)this.d.get(paramString);
  }
  
  public void a(long paramLong, String paramString1, String paramString2, bior parambior)
  {
    biyc localbiyc = (biyc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (localbiyc == null))
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.return for params error");
      if (parambior != null) {
        parambior.a(false, null, -1);
      }
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_appid", paramLong);
      localJSONObject.put("str_nick", paramString1);
      localJSONObject.put("str_head_id", paramString2);
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createVirtual.start:", biyz.a(localJSONObject.toString(), localbiyc.jdField_a_of_type_JavaLangString) });
      ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.1(this, localbiyc, localJSONObject, parambior));
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.e:", paramString1);
      }
    }
  }
  
  public void a(preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity, biyc parambiyc, biyy parambiyy, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry activity==null, preAuthCallback=", parambiyy });
      if (parambiyy != null) {
        parambiyy.a(-1, "");
      }
      return;
    }
    if (!TextUtils.isEmpty(paramPreAuthRequest.appUniqueIdentifier.get()))
    {
      localObject = biyz.a(paramActivity, paramPreAuthRequest.appUniqueIdentifier.get());
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry.getAuthorizeSign sign=", localObject[1], ", timestr=", localObject[2] });
      if (!TextUtils.isEmpty(localObject[1]))
      {
        paramPreAuthRequest.sign.set(localObject[1]);
        if (!TextUtils.isEmpty(localObject[2])) {
          paramPreAuthRequest.md5time.set(Long.parseLong(localObject[2]));
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), biqf.class);
    localNewIntent.putExtra("uin", parambiyc.jdField_a_of_type_JavaLangString);
    String str = bipr.a(BaseApplicationImpl.getApplication().getRuntime(), parambiyc, paramPreAuthRequest.login_sig, "QQConnectLogin.pre_auth", "QQConnectLogin.pre_auth_emp");
    boolean bool = "QQConnectLogin.pre_auth_emp".equals(str);
    byte[] arrayOfByte = paramPreAuthRequest.toByteArray();
    Object localObject = arrayOfByte;
    if (bool) {
      localObject = biyz.a(arrayOfByte, parambiyc);
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry cmd=", str });
    b(parambiyc.jdField_a_of_type_JavaLangString);
    localNewIntent.putExtra("data", (byte[])localObject);
    localNewIntent.putExtra("cmd", str);
    localNewIntent.putExtra("timeout", 15000L);
    localNewIntent.putExtra("key_support_retry", true);
    localNewIntent.setWithouLogin(true);
    aukw.a("KEY_PRE_AUTH");
    localNewIntent.setObserver(new biyw(this, parambiyc, bool, parambiyy, paramInt, paramPreAuthRequest, paramActivity));
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void a(OpenSDKAppInterface paramOpenSDKAppInterface, String paramString1, String paramString2, AccountManage.RefreshReason paramRefreshReason, biyx parambiyx)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "getTicketNoPasswd uin=" + bipr.a(paramString1));
    new biyc().jdField_a_of_type_JavaLangString = paramString1;
    AccountManage.a().a(paramString1, new biyv(this, paramOpenSDKAppInterface, parambiyx), paramString2, paramRefreshReason);
  }
  
  public void a(String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "addForce540Account uin=" + bipr.a(paramString));
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.h.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString, long paramLong, bior parambior)
  {
    biyc localbiyc = (biyc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString));
    if (localbiyc == null)
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.deleteVirtual.return for account is null");
      if (parambior != null) {
        parambior.a(false, -1);
      }
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_vuid", paramLong);
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.deleteVirtual.start.realAppId=", paramString, ",body:", localJSONObject.toString() });
      ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.2(this, localbiyc, localJSONObject, parambior));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.deleteVirtual.e:", localJSONException);
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null)) {
      this.c.put(paramString, paramBundle);
    }
  }
  
  public void a(String paramString, biyc parambiyc)
  {
    if ((!TextUtils.isEmpty(paramString)) && (parambiyc != null)) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambiyc);
    }
  }
  
  public void a(String paramString1, String paramString2, Activity paramActivity, String paramString3, Bundle paramBundle, biyy parambiyy)
  {
    paramString2 = (biyc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString2));
    if ((paramString2 == null) || (paramActivity == null))
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer account=", paramString2, ", context=", paramActivity });
      if (parambiyy != null) {
        parambiyy.a(-1, "");
      }
      return;
    }
    long l = ForwardUtils.a(paramBundle.getString("key_proxy_appid"));
    a(a(paramString2, paramString3, ForwardUtils.a(paramString1), l, paramBundle), paramActivity, paramString2, new biys(this, parambiyy), 2);
  }
  
  public void a(String paramString1, String paramString2, bior parambior)
  {
    biyc localbiyc = (biyc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString1));
    if ((TextUtils.isEmpty(paramString2)) || (localbiyc == null))
    {
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.uploadAvatarImage.return for params error");
      if (parambior != null) {
        parambior.a(false, paramString2, null, -1);
      }
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.4(this, paramString2, paramString1, localbiyc, parambior));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, List<bikw> paramList, long paramLong, bior parambior, String paramString3, Activity paramActivity)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "doAuthorize");
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (TextUtils.isEmpty(paramString2)) {}
    biyc localbiyc;
    for (Object localObject1 = paramString1;; localObject1 = paramString2)
    {
      localbiyc = (biyc)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      localObject1 = (Bundle)this.c.get(localObject1);
      if ((localAppRuntime != null) && (localObject1 != null) && (localbiyc != null)) {
        break;
      }
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize return for param is null.");
      if (parambior != null) {
        parambior.a(false, -1, null);
      }
      return;
    }
    Object localObject3 = new Bundle((Bundle)localObject1);
    if (!TextUtils.isEmpty(paramString2))
    {
      new biow().a(paramBoolean, paramString1, paramString2, paramList, paramLong, parambior, paramString3, paramActivity, localbiyc, (Bundle)localObject1);
      return;
    }
    ((Bundle)localObject3).putString("openapi", "");
    ((Bundle)localObject3).putBoolean("doAuthorize", true);
    ((Bundle)localObject3).putString("need_pay", "1");
    ((Bundle)localObject3).putString("appid_for_getting_config", ((Bundle)localObject3).getString("client_id") + "");
    long l = Long.parseLong(paramString1);
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(l);
    localAuthorizeRequest.need_pay.set(1);
    localObject1 = new StringBuilder("OpenVirtual.doAuthorize.appid:");
    ((StringBuilder)localObject1).append(paramString1).append(", virtual id =").append(paramLong).append(", checked api id [");
    Object localObject2;
    Object localObject4;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (bikw)((Iterator)localObject2).next();
        if (((bikw)localObject4).jdField_b_of_type_Boolean)
        {
          localAuthorizeRequest.openapi.add(Integer.valueOf(((bikw)localObject4).jdField_b_of_type_Int));
          ((StringBuilder)localObject1).append(((bikw)localObject4).jdField_b_of_type_Int).append(",");
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    QLog.i("SDK_LOGIN.OpenSdkVirtualManager", 1, ((StringBuilder)localObject1).toString());
    label498:
    String str;
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      localAuthorizeRequest.os.set((String)localObject1);
      localAuthorizeRequest.qqv.set(biip.a().d());
      localAuthorizeRequest.app_type.set(1);
      localObject2 = ((Bundle)localObject3).getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      localAuthorizeRequest.pf.set((String)localObject1);
      localObject1 = ((Bundle)localObject3).getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label776;
      }
      localAuthorizeRequest.sdkp.set("android");
      localObject1 = ((Bundle)localObject3).getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label789;
      }
      localAuthorizeRequest.sdkv.set("1.5.9");
      label527:
      localAuthorizeRequest.response_type.set("token");
      localObject1 = ((Bundle)localObject3).getString("sign");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label802;
      }
      localAuthorizeRequest.sign.set((String)localObject1);
      localObject1 = ((Bundle)localObject3).getString("time");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        l = Long.parseLong((String)localObject1);
        localAuthorizeRequest.time.set(l);
      }
      label601:
      localObject1 = ((Bundle)localObject3).keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject4 = ((Set)localObject1).iterator();
      label681:
      if (!((Iterator)localObject4).hasNext()) {
        break label898;
      }
      str = (String)((Iterator)localObject4).next();
      localObject1 = ((Bundle)localObject3).get(str);
      if (localObject1 == null) {
        break label890;
      }
    }
    label776:
    label789:
    label802:
    label890:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label681;
      localObject1 = Build.VERSION.RELEASE;
      break;
      localAuthorizeRequest.sdkp.set((String)localObject1);
      break label498;
      localAuthorizeRequest.sdkv.set((String)localObject1);
      break label527;
      localObject2 = biyz.a(paramActivity, paramString3);
      localObject1 = localObject2[1];
      localObject2 = localObject2[2];
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign again");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign sign is null");
        break label601;
      }
      localAuthorizeRequest.sign.set((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label601;
      }
      l = Long.parseLong((String)localObject2);
      localAuthorizeRequest.time.set(l);
      break label601;
    }
    label898:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      localAuthorizeRequest.passData.set(((StringBuffer)localObject2).toString());
    }
    localAuthorizeRequest.skey.set(localbiyc.jdField_b_of_type_JavaLangString);
    if (paramBoolean) {
      localAuthorizeRequest.referer.set(4);
    }
    localAuthorizeRequest.vID.set(paramLong);
    if (!TextUtils.isEmpty(paramString3)) {
      localAuthorizeRequest.appUniqueIdentifier.set(paramString3);
    }
    for (;;)
    {
      localObject3 = new NewIntent(BaseApplicationImpl.getApplication(), biqf.class);
      ((NewIntent)localObject3).setWithouLogin(true);
      ((NewIntent)localObject3).putExtra("uin", localbiyc.jdField_a_of_type_JavaLangString);
      localObject4 = bipr.a(localAppRuntime, localbiyc, localAuthorizeRequest.login_sig, "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp");
      boolean bool = "ConnAuthSvr.sdk_auth_api_emp".equals(localObject4);
      localObject2 = localAuthorizeRequest.toByteArray();
      localObject1 = localObject2;
      if (bool) {
        localObject1 = biyz.a((byte[])localObject2, localbiyc);
      }
      ((NewIntent)localObject3).putExtra("data", (byte[])localObject1);
      ((NewIntent)localObject3).putExtra("cmd", (String)localObject4);
      ((NewIntent)localObject3).setObserver(new biyu(this, System.currentTimeMillis(), localbiyc, parambior, paramString1, bool, (String)localObject4, paramBoolean, paramString2, paramList, paramLong, paramString3, paramActivity));
      localAppRuntime.startServlet((NewIntent)localObject3);
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.doAuthorize.send | cmd: " + (String)localObject4, " | uin : *" + bipr.a(localbiyc.jdField_a_of_type_JavaLangString) });
      return;
      QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.appUniqueIdentifier is null");
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "isForceTo540 uin=" + bipr.a(paramString) + ", force540=" + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biyp
 * JD-Core Version:    0.7.0.1
 */