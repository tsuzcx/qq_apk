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
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class bfna
{
  private int jdField_a_of_type_Int;
  private ConcurrentHashMap<String, GetVirtualListResult> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, bfmm> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Bundle> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<bezj>> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, arua> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, preAuth.PreAuthResponse> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> i = new ConcurrentHashMap();
  
  private void a(bfmm parambfmm, String paramString, JSONObject paramJSONObject, bfnj parambfnj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkVirtualManager", 2, new Object[] { "OpenVirtual.handleUploadAvatar.count:", Integer.valueOf(this.jdField_a_of_type_Int), ",imagePath:", paramString });
    }
    paramString = new bfne(this, parambfmm, parambfnj, paramString, paramJSONObject);
    bfnl.a("oidb_0xc7f_25", parambfmm, paramJSONObject.toString(), paramString);
  }
  
  private void a(String paramString)
  {
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (localTicketManager == null)
    {
      QLog.d("OpenSdkVirtualManager", 1, "preAuthWithRetry manager==null");
      return;
    }
    if (TextUtils.isEmpty(localTicketManager.getA2(paramString)))
    {
      str = "empty";
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry a ", str });
      if (!TextUtils.isEmpty(localTicketManager.getSkey(paramString))) {
        break label124;
      }
    }
    label124:
    for (String str = "empty";; str = "valid")
    {
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry s ", str });
      paramString = localTicketManager.getDA2(paramString);
      if (paramString != null) {
        break label130;
      }
      QLog.d("OpenSdkVirtualManager", 1, "preAuthWithRetry d==null");
      return;
      str = "valid";
      break;
    }
    label130:
    if (paramString.length == 0) {}
    for (paramString = "empty";; paramString = "valid")
    {
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry d ", paramString });
      return;
    }
  }
  
  private boolean a(preAuth.PreAuthResponse paramPreAuthResponse)
  {
    QLog.d("OpenSdkVirtualManager", 1, "onPreAuthResponse");
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
        localObject4 = new bezj();
        ((bezj)localObject4).jdField_b_of_type_JavaLangString = ((appType.AuthItem)localObject3).api_list.get();
        ((bezj)localObject4).jdField_a_of_type_Int = ((appType.AuthItem)localObject3).default_flag.get();
        ((bezj)localObject4).jdField_b_of_type_Int = ((appType.AuthItem)localObject3).id.get();
        if (((appType.AuthItem)localObject3).is_new.get() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((bezj)localObject4).jdField_a_of_type_Boolean = bool;
          ((bezj)localObject4).jdField_a_of_type_JavaLangString = ((appType.AuthItem)localObject3).title.get();
          QLog.d("OpenSdkVirtualManager", 1, new Object[] { "onPreAuthResponse Permission=", ((bezj)localObject4).toString() });
          ((List)localObject1).add(localObject4);
          break;
        }
      }
    }
    this.d.put(str, localObject1);
    if (paramPreAuthResponse.android_info.has()) {
      this.e.put(str, arua.a(paramPreAuthResponse, paramPreAuthResponse.android_info));
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
  
  public arua a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (arua)this.e.get(paramString);
  }
  
  public bfmm a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (bfmm)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
  
  public preAuth.PreAuthRequest a(bfmm parambfmm, String paramString1, String paramString2, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "-->createPreAuthRequest pkgName=", paramString1, ", appid=", paramString2 });
    preAuth.PreAuthRequest localPreAuthRequest = new preAuth.PreAuthRequest();
    localPreAuthRequest.appid.set(ForwardUtils.a(paramString2));
    Object localObject = paramBundle.getString("sdkp");
    PBStringField localPBStringField = localPreAuthRequest.sdkp;
    paramString2 = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString2 = "android";
    }
    localPBStringField.set(paramString2);
    localObject = paramBundle.getString("sdkv");
    localPBStringField = localPreAuthRequest.sdkv;
    paramString2 = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString2 = "1.5.9";
    }
    localPBStringField.set(paramString2);
    localPreAuthRequest.qqv.set(bexd.a().d());
    localObject = localPreAuthRequest.os;
    if (Build.VERSION.RELEASE == null) {}
    for (paramString2 = "";; paramString2 = Build.VERSION.RELEASE)
    {
      ((PBStringField)localObject).set(paramString2);
      localObject = paramBundle.getString("scope");
      localPBStringField = localPreAuthRequest.scope;
      paramString2 = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString2 = "";
      }
      localPBStringField.set(paramString2);
      localPreAuthRequest.skey.set(parambfmm.jdField_b_of_type_JavaLangString);
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
  
  public List<bezj> a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (List)this.d.get(paramString);
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "getPermissionListByAppid null for appid=", paramString });
    return null;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, bfnj parambfnj)
  {
    bfmm localbfmm = (bfmm)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (localbfmm == null))
    {
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.return for params error");
      if (parambfnj != null) {
        parambfnj.a(false, null, -1);
      }
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_appid", paramLong);
      localJSONObject.put("str_nick", paramString1);
      localJSONObject.put("str_head_id", paramString2);
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createVirtual.start:", bfnl.a(localJSONObject.toString(), localbfmm.jdField_a_of_type_JavaLangString) });
      ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.1(this, localbfmm, localJSONObject, parambfnj));
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
  
  public void a(preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity, bfmm parambfmm, bfnk parambfnk, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry activity==null, preAuthCallback=", parambfnk });
      if (parambfnk != null) {
        parambfnk.a(-1, "");
      }
      return;
    }
    if (!TextUtils.isEmpty(paramPreAuthRequest.appUniqueIdentifier.get()))
    {
      localObject = bfnl.a(paramActivity, paramPreAuthRequest.appUniqueIdentifier.get());
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry.getAuthorizeSign sign=", localObject[1], ", timestr=", localObject[2] });
      if (!TextUtils.isEmpty(localObject[1]))
      {
        paramPreAuthRequest.sign.set(localObject[1]);
        if (!TextUtils.isEmpty(localObject[2])) {
          paramPreAuthRequest.md5time.set(Long.parseLong(localObject[2]));
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), bfen.class);
    localNewIntent.putExtra("uin", parambfmm.jdField_a_of_type_JavaLangString);
    boolean bool = bfdz.a(parambfmm.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime());
    byte[] arrayOfByte = paramPreAuthRequest.toByteArray();
    String str = "QQConnectLogin.pre_auth";
    Object localObject = arrayOfByte;
    if (!bool)
    {
      localObject = bfnl.a(arrayOfByte, parambfmm);
      str = "QQConnectLogin.pre_auth_emp";
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry cmd=", str });
    a(parambfmm.jdField_a_of_type_JavaLangString);
    localNewIntent.putExtra("data", (byte[])localObject);
    localNewIntent.putExtra("cmd", str);
    localNewIntent.putExtra("timeout", 15000L);
    localNewIntent.putExtra("key_support_retry", true);
    localNewIntent.setWithouLogin(true);
    arzy.a("KEY_PRE_AUTH");
    localNewIntent.setObserver(new bfnh(this, parambfmm, bool, parambfnk, paramInt, paramPreAuthRequest, paramActivity));
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void a(OpenSDKAppInterface paramOpenSDKAppInterface, String paramString, bfni parambfni)
  {
    QLog.d("OpenSdkVirtualManager", 1, "getTicketNoPasswd uin=" + bfdz.a(paramString));
    new bfmm().jdField_a_of_type_JavaLangString = paramString;
    bfmn.a().a(paramString, 4096, new bfng(this, paramOpenSDKAppInterface, parambfni), false);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.h.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString, long paramLong, bfnj parambfnj)
  {
    bfmm localbfmm = (bfmm)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString));
    if (localbfmm == null)
    {
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.deleteVirtual.return for account is null");
      if (parambfnj != null) {
        parambfnj.a(false, -1);
      }
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uint64_vuid", paramLong);
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.deleteVirtual.start.appid=", paramString, ",body:", localJSONObject.toString() });
      ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.2(this, localbfmm, localJSONObject, parambfnj));
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
  
  public void a(String paramString1, Activity paramActivity, String paramString2, Bundle paramBundle, bfnk parambfnk)
  {
    bfmm localbfmm = (bfmm)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString1));
    if ((localbfmm == null) || (paramActivity == null))
    {
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer account=", localbfmm, ", context=", paramActivity });
      if (parambfnk != null) {
        parambfnk.a(-1, "");
      }
      return;
    }
    a(a(localbfmm, paramString2, paramString1, paramBundle), paramActivity, localbfmm, new bfnd(this, parambfnk), 2);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null)) {
      this.c.put(paramString, paramBundle);
    }
  }
  
  public void a(String paramString, bfmm parambfmm)
  {
    if ((!TextUtils.isEmpty(paramString)) && (parambfmm != null)) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambfmm);
    }
  }
  
  public void a(String paramString1, String paramString2, bfnj parambfnj)
  {
    bfmm localbfmm = (bfmm)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString1));
    if ((TextUtils.isEmpty(paramString2)) || (localbfmm == null))
    {
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.uploadAvatarImage.return for params error");
      if (parambfnj != null) {
        parambfnj.a(false, paramString2, null, -1);
      }
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OpenSdkVirtualManager.4(this, paramString2, paramString1, localbfmm, parambfnj));
  }
  
  public void a(boolean paramBoolean, String paramString1, List<bezj> paramList, long paramLong, bfnj parambfnj, String paramString2, Activity paramActivity)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    bfmm localbfmm = (bfmm)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    Object localObject1 = (Bundle)this.c.get(paramString1);
    if ((localAppRuntime == null) || (localObject1 == null) || (localbfmm == null))
    {
      QLog.e("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize return for param is null.");
      if (parambfnj != null) {
        parambfnj.a(false, -1, null);
      }
      return;
    }
    Object localObject4 = new Bundle((Bundle)localObject1);
    ((Bundle)localObject4).putString("openapi", "");
    ((Bundle)localObject4).putBoolean("doAuthorize", true);
    ((Bundle)localObject4).putString("need_pay", "1");
    ((Bundle)localObject4).putString("appid_for_getting_config", ((Bundle)localObject4).getString("client_id") + "");
    long l = Long.parseLong(paramString1);
    Object localObject3 = new SdkAuthorize.AuthorizeRequest();
    ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l);
    ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
    localObject1 = new StringBuilder("OpenVirtual.doAuthorize.appid:");
    ((StringBuilder)localObject1).append(paramString1).append(", virtual id =").append(paramLong).append(", checked api id [");
    Object localObject2;
    Object localObject5;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (bezj)((Iterator)localObject2).next();
        if (((bezj)localObject5).jdField_b_of_type_Boolean)
        {
          ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(((bezj)localObject5).jdField_b_of_type_Int));
          ((StringBuilder)localObject1).append(((bezj)localObject5).jdField_b_of_type_Int).append(",");
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    QLog.i("OpenSdkVirtualManager", 1, ((StringBuilder)localObject1).toString());
    label424:
    label453:
    label607:
    String str;
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(bexd.a().d());
      localObject2 = ((Bundle)localObject4).getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
      localObject1 = ((Bundle)localObject4).getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label702;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
      localObject1 = ((Bundle)localObject4).getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label715;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
      ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
      localObject1 = ((Bundle)localObject4).getString("sign");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label728;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
      localObject1 = ((Bundle)localObject4).getString("time");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        l = Long.parseLong((String)localObject1);
        ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l);
      }
      label527:
      localObject1 = ((Bundle)localObject4).keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject5 = ((Set)localObject1).iterator();
      if (!((Iterator)localObject5).hasNext()) {
        break label824;
      }
      str = (String)((Iterator)localObject5).next();
      localObject1 = ((Bundle)localObject4).get(str);
      if (localObject1 == null) {
        break label816;
      }
    }
    label816:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append(str + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label607;
      localObject1 = Build.VERSION.RELEASE;
      break;
      label702:
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
      break label424;
      label715:
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
      break label453;
      label728:
      localObject2 = bfnl.a(paramActivity, paramString2);
      localObject1 = localObject2[1];
      localObject2 = localObject2[2];
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign again");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.getAuthorizeSign sign is null");
        break label527;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label527;
      }
      l = Long.parseLong((String)localObject2);
      ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l);
      break label527;
    }
    label824:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(localbfmm.jdField_b_of_type_JavaLangString);
    if (paramBoolean) {
      ((SdkAuthorize.AuthorizeRequest)localObject3).referer.set(4);
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).vID.set(paramLong);
    boolean bool;
    if (!TextUtils.isEmpty(paramString2))
    {
      ((SdkAuthorize.AuthorizeRequest)localObject3).appUniqueIdentifier.set(paramString2);
      localObject4 = new NewIntent(BaseApplicationImpl.getApplication(), bfen.class);
      ((NewIntent)localObject4).setWithouLogin(true);
      ((NewIntent)localObject4).putExtra("uin", localbfmm.jdField_a_of_type_JavaLangString);
      localObject1 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
      localObject2 = "ConnAuthSvr.sdk_auth_api";
      bool = bfdz.a(localbfmm.jdField_a_of_type_JavaLangString, localAppRuntime);
      if (bool) {
        break label1139;
      }
      localObject1 = bfnl.a((byte[])localObject1, localbfmm);
      localObject2 = "ConnAuthSvr.sdk_auth_api_emp";
    }
    label1139:
    for (localObject3 = "s_a_a_emp";; localObject3 = "s_a_a")
    {
      ((NewIntent)localObject4).putExtra("data", (byte[])localObject1);
      ((NewIntent)localObject4).putExtra("cmd", (String)localObject2);
      ((NewIntent)localObject4).setObserver(new bfnf(this, System.currentTimeMillis(), localbfmm, parambfnj, bool, paramString1, (String)localObject2, paramBoolean, paramList, paramLong, paramString2, paramActivity));
      localAppRuntime.startServlet((NewIntent)localObject4);
      QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.doAuthorize.send | cmd: " + (String)localObject3, " | uin : *" + bfdz.a(localbfmm.jdField_a_of_type_JavaLangString) });
      return;
      QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.doAuthorize.appUniqueIdentifier is null");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfna
 * JD-Core Version:    0.7.0.1
 */