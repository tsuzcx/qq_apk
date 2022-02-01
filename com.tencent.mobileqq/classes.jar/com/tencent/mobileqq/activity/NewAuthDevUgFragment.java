package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.loginregister.EquipLockProxy;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager;
import com.tencent.mobileqq.loginwelcome.GatewayUtil;
import com.tencent.mobileqq.loginwelcome.IGatewayEntrance;
import com.tencent.mobileqq.loginwelcome.MultiGatewayCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.IPUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.GatewayLoadingDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneGetUrlV4;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrlV4;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class NewAuthDevUgFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, IGatewayEntrance
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private EquipLockProxy jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy;
  private ILoginApi jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi;
  private GateWayVerifyManager jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager;
  private GatewayLoadingDrawable jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new NewAuthDevUgFragment.1(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private TextView e;
  private TextView f;
  
  public static void a(int paramInt)
  {
    ReportController.a(null, "dc00898", "", "", "0X800B9E5", "0X800B9E5", paramInt, 0, "", "", "", "");
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "data is null");
      c();
      return;
    }
    try
    {
      paramObject = (byte[])paramObject;
      Object localObject = new GatewayVerify.RspBody();
      ((GatewayVerify.RspBody)localObject).mergeFrom(paramObject);
      this.jdField_d_of_type_JavaLangString = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_get_url_v4.str_msg_id.get();
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "msgid: ", this.jdField_d_of_type_JavaLangString });
      localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_get_url_v4.rpt_self_phone_url.get();
      if (localObject == null)
      {
        QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is null");
        a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is null");
        c();
        return;
      }
      int i = ((List)localObject).size();
      if (i == 0)
      {
        QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is empty");
        a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is empty");
        c();
        return;
      }
      paramObject = new MultiGatewayCallback(getQBaseActivity(), this.jdField_d_of_type_JavaLangString, i, this);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GatewayVerify.SelfPhoneUrl localSelfPhoneUrl = (GatewayVerify.SelfPhoneUrl)((Iterator)localObject).next();
        if (localSelfPhoneUrl == null)
        {
          a("V_GET_GATEWAY_URL_ERROR", -1, "url bean is null");
          c();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager.a(localSelfPhoneUrl, paramObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getGatewayToken, GatewayVerify.RspBody mergeFrom error : ", paramObject.getMessage() });
      a("V_GET_GATEWAY_URL_ERROR", -1, paramObject.getMessage());
      c();
      GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 3, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(String paramString)
  {
    this.e.setText(getString(2131698762, new Object[] { paramString }));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("K_RESULT_TYPE", paramString1);
    localHashMap.put("K_RET", String.valueOf(paramInt));
    localHashMap.put("K_UIN", str);
    localHashMap.put("K_RESULT_MSG", paramString2);
    if ("V_RET_SUCCESS".equals(paramString1)) {
      localHashMap.put("K_REDIRECT_TIME", String.valueOf(this.jdField_b_of_type_Int));
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "TGatewayVerifyResult", "V_RET_SUCCESS".equals(paramString1), 0L, 0L, localHashMap, "");
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      int j = paramString1.length();
      int i = 3;
      if (j < 3) {
        return false;
      }
      if (TextUtils.isEmpty(paramString2)) {
        return true;
      }
      if (("86".equals(paramString2)) && (paramString1.length() == 11)) {
        return true;
      }
      if ((!"852".equals(paramString2)) && (!"853".equals(paramString2)))
      {
        if ("886".equals(paramString2)) {
          i = 9;
        }
      }
      else {
        i = 6;
      }
      bool1 = bool2;
      if (paramString1.length() >= i) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    String str;
    if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getQQProcessName())) {
      str = "/base/login/authDevVerifyCodeOpenSdk";
    } else {
      str = "/base/login/authDevVerifyCode";
    }
    DevlockInfo localDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
    if (localDevlockInfo != null)
    {
      localIntent.putExtra("phone_num", localDevlockInfo.Mobile);
      localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      localIntent.putExtra("mobile_type", 0);
    }
    localIntent.putExtra("from_login", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("from_phone_num_login", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("seq", this.jdField_a_of_type_Int);
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localIntent, str, 1002);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B661", "0X800B661", this.jdField_c_of_type_Int, 0, "", "", "", "");
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDE", "0X800ADDE", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    Intent localIntent = new Intent();
    DevlockInfo localDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
    if (localDevlockInfo != null)
    {
      localIntent.putExtra("phone_num", localDevlockInfo.Mobile);
      localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      localIntent.putExtra("mobile_type", 0);
      localIntent.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
    }
    localIntent.putExtra("from_login", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("seq", this.jdField_a_of_type_Int);
    localIntent.putExtra("mainaccount", this.jdField_c_of_type_JavaLangString);
    QPublicFragmentActivity.startForResult(this, localIntent, GatewayVerifyFailedFragment.class, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new NewAuthDevUgFragment.2(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.broadcast.action.authdev.phonechange");
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void f()
  {
    g();
    Object localObject = new GatewayVerify.ReqBody();
    GatewayVerify.ReqBodySelfPhone localReqBodySelfPhone = new GatewayVerify.ReqBodySelfPhone();
    GatewayVerify.ReqBodySelfPhoneGetUrlV4 localReqBodySelfPhoneGetUrlV4 = new GatewayVerify.ReqBodySelfPhoneGetUrlV4();
    localReqBodySelfPhoneGetUrlV4.uint32_get_upload_url.set(1);
    try
    {
      i = DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    catch (Exception localException)
    {
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getCarrier error : ", localException.getMessage() });
      i = 0;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "carrier ：", Integer.valueOf(i) });
    localReqBodySelfPhoneGetUrlV4.uint32_isp_type.set(i);
    String str = IPUtils.a();
    if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)) && (!"0.0.0.0".equals(str))) {
      localReqBodySelfPhoneGetUrlV4.str_cell_ip.set(str);
    } else {
      QLog.d("NewAuthDevUgFragment", 1, "get ip error");
    }
    localReqBodySelfPhone.msg_req_get_url_v4.set(localReqBodySelfPhoneGetUrlV4);
    ((GatewayVerify.ReqBody)localObject).msg_req_self_phone.set(localReqBodySelfPhone);
    localObject = ((GatewayVerify.ReqBody)localObject).toByteArray();
    int i = this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), (byte[])localObject, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable.b();
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "refreshDevLockSms error , ret : ", Integer.valueOf(i) });
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.3(this));
  }
  
  private void h()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.4(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable.a();
    this.f.setText(2131691966);
  }
  
  private void j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    QLog.d("NewAuthDevUgFragment", 1, "beforeOpenBrowser do finish");
  }
  
  public void a(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onGetTokenError getActivity is null or activity is finish");
      return;
    }
    h();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onGetTokenError : ", paramException.getMessage() });
    a("V_GET_TOKEN_ERROR", paramInt, paramException.getMessage());
    c();
    GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 3, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onChangeNetworkError getActivity is null or activity is finish");
      return;
    }
    h();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onChangeNetworkError : ", paramException.getMessage() });
    a("V_CHANGE_NETWORK_TYPE_ERROR", -1, paramException.getMessage());
    c();
    GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 3, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onTokenCallback getActivity is null or activity is finish");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, paramArrayOfByte);
    if (i != 0) {
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "mEquipLockProxy.submitSms error, ret : ", Integer.valueOf(i) });
    }
  }
  
  boolean a()
  {
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    return (localQBaseActivity == null) || (localQBaseActivity.isFinishing());
  }
  
  protected void b()
  {
    QLog.d("NewAuthDevUgFragment", 1, "afterOpenBrowser do nothing");
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        localObject1 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        if (localObject1 != null)
        {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject1).Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramIntent, "/base/safe/authDevActivity");
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        localObject1 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        if (localObject1 != null) {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject1).Mobile);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(-1, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
    }
    else if (paramInt1 == 1002)
    {
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(paramInt2, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
    }
    else if (paramInt1 == 1003)
    {
      Object localObject2;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onActivityResult.resultCode= RESULT_OK  resultState =");
            ((StringBuilder)localObject1).append(paramInt1);
            QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject1).toString());
          }
          if (paramInt1 == 2)
          {
            localObject1 = paramIntent.getExtras().getString("resultMobileMask");
            boolean bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("onActivityResult.resultCode= RESULT_OK  resultMobileMask =");
              paramIntent.append((String)localObject1);
              paramIntent.append(" openSuccess=");
              paramIntent.append(bool);
              QLog.d("NewAuthDevUgFragment", 2, paramIntent.toString());
            }
            paramIntent = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
            if (paramIntent != null)
            {
              paramIntent.Mobile = ((String)localObject1);
              if (!TextUtils.isEmpty(paramIntent.Mobile))
              {
                a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691984));
                this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              }
            }
            if (!bool) {
              return;
            }
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy;
            localObject2 = this.jdField_a_of_type_MqqAppAppRuntime;
            paramIntent.a((AppRuntime)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ((AppRuntime)localObject2).getCurrentAccountUin(), true);
            paramIntent = new Intent();
            paramIntent.putExtra("phone_num", (String)localObject1);
            localObject1 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
            if (localObject1 != null) {
              paramIntent.putExtra("country_code", ((DevlockInfo)localObject1).CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramIntent, "/base/safe/authDevActivity");
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, getString(2131691980), 0).a();
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("auth_dev_open", true);
            ((Intent)localObject1).putExtra("allow_set", true);
            localObject2 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("phone_num", ((DevlockInfo)localObject2).Mobile);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(-1, paramIntent);
            this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
          }
        }
      }
      else if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onActivityResult.resultCode= RESULT_CANCELED resultState =");
          ((StringBuilder)localObject1).append(paramInt1);
          QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramInt1 == 2)
        {
          paramIntent = paramIntent.getExtras().getString("resultMobileMask");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =");
            ((StringBuilder)localObject1).append(paramIntent);
            QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject1).toString());
          }
          if (!TextUtils.isEmpty(paramIntent))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy;
            localObject2 = this.jdField_a_of_type_MqqAppAppRuntime;
            ((EquipLockProxy)localObject1).a((AppRuntime)localObject2, ((AppRuntime)localObject2).getCurrentAccountUin(), null);
          }
          localObject1 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if (localObject1 != null)
          {
            ((DevlockInfo)localObject1).Mobile = paramIntent;
            if (!TextUtils.isEmpty(((DevlockInfo)localObject1).Mobile))
            {
              a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691984));
              this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      int i = paramView.getId();
      Object localObject;
      if (i == 2131379566)
      {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA34", "0X800AA34", LoginStaticField.a(), 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDD", "0X800ADDD", this.jdField_c_of_type_Int, 0, "", "", "", "");
        this.jdField_a_of_type_MqqAppAppRuntime.sendWirelessMeibaoReq(1);
        if (QBaseActivity.mAppForground)
        {
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals("subaccount")))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("subaccount enter webview mUin=");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" mMainAccount=");
              ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
              QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject).toString());
            }
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1);
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("mainaccount enter webview mUin=");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject).toString());
            }
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, 1);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 1);
        }
      }
      else if (i == 2131379801)
      {
        if ((this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 3000L))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA36", "0X800AA36", LoginStaticField.a(), 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDC", "0X800ADDC", this.jdField_c_of_type_Int, 0, "", "", "", "");
          j();
        }
      }
      else if (i == 2131379969)
      {
        GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 2, this.jdField_a_of_type_JavaLangString);
        boolean bool3 = false;
        boolean bool4 = this.jdField_a_of_type_Boolean;
        boolean bool1;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        boolean bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if (TextUtils.isEmpty(((DevlockInfo)localObject).Mobile)) {
            bool2 = true;
          }
        }
        QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onCLick Verify btn, from login: ", Boolean.valueOf(bool4), "mDev is null ? ", Boolean.valueOf(bool1), " , mobile is null ? ", Boolean.valueOf(bool2) });
        localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        if (((localObject != null) && (TextUtils.isEmpty(((DevlockInfo)localObject).Mobile))) || (this.jdField_b_of_type_Boolean))
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800BA0C", "0X800BA0C", this.jdField_c_of_type_Int, 0, "", "", "", "");
          if (this.jdField_b_of_type_Boolean) {
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B9E4", "0X800B9E4", 0, 0, "", "", "", "");
          }
        }
        else
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B660", "0X800B660", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_Boolean))
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA35", "0X800AA35", LoginStaticField.a(), 0, "", "", "", "");
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) && (!this.jdField_b_of_type_Boolean)) {
            f();
          } else {
            j();
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).Mobile)))
          {
            ReportController.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, AuthDevVerifyCodeActivity.class);
            ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            startActivityForResult((Intent)localObject, 1001);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 1, 1003, null);
          }
        }
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDB", "0X800ADDB", 0, 0, "", "", "", "");
      }
      else if (i == 2131369292)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDA", "0X800ADDA", this.jdField_c_of_type_Int, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    int i;
    if ((!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) && (!ThemeUtil.isGoldenTheme())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131561047, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379969));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379801));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131369292);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379566));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379893));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131379808));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable = new GatewayLoadingDrawable();
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131755413);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558441);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131369411));
    this.f = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131379788));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable);
    paramLayoutInflater.findViewById(2131369292).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi = ((ILoginApi)QRoute.api(ILoginApi.class));
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy = new EquipLockProxy();
    paramViewGroup = getArguments();
    if (paramViewGroup == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    else
    {
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramBundle.topMargin = (Utils.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramBundle);
      try
      {
        this.jdField_a_of_type_Boolean = paramViewGroup.getBoolean("from_login");
        this.jdField_a_of_type_Int = paramViewGroup.getInt("seq");
        paramBundle = paramViewGroup.get("DevlockInfo");
        if ((paramBundle instanceof DevlockInfo)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle);
        }
        this.jdField_a_of_type_JavaLangString = paramViewGroup.getString("uin");
        this.jdField_b_of_type_JavaLangString = paramViewGroup.getString("from_where");
        this.jdField_c_of_type_JavaLangString = paramViewGroup.getString("mainaccount");
        if (this.jdField_a_of_type_Boolean)
        {
          LoginUtils.b(this.jdField_a_of_type_MqqAppAppRuntime);
          paramBundle = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.MbGuideInfo))) {
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
          }
        }
        paramBundle = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        if ((paramBundle != null) && (paramBundle.Mobile != null))
        {
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
          }
        }
        this.jdField_b_of_type_Boolean = paramViewGroup.getBoolean("from_phone_num_login");
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_c_of_type_Int = 3;
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B9E3", "0X800B9E3", 0, 0, "", "", "", "");
        }
        else
        {
          paramBundle = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if ((paramBundle != null) && (paramBundle.DevSetup == 1)) {
            this.jdField_c_of_type_Int = 1;
          } else {
            this.jdField_c_of_type_Int = 2;
          }
        }
        paramBundle = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        if ((paramBundle == null) || (!TextUtils.isEmpty(paramBundle.Mobile)))
        {
          i = this.jdField_c_of_type_Int;
          if (i != 3) {}
        }
        else
        {
          this.e.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698760));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800BA0B", "0X800BA0B", this.jdField_c_of_type_Int, 0, "", "", "", "");
          break label768;
        }
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADD9", "0X800ADD9", i, 0, "", "", "", "");
        label768:
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onCreate mIsFromLogin = ");
          paramBundle.append(this.jdField_a_of_type_Boolean);
          paramBundle.append(" mVerifySeq=");
          paramBundle.append(this.jdField_a_of_type_Int);
          paramBundle.append(" mUin=");
          paramBundle.append(this.jdField_a_of_type_JavaLangString);
          paramBundle.append(" mFromWhere=");
          paramBundle.append(this.jdField_b_of_type_JavaLangString);
          paramBundle.append(" mMainAccount=");
          paramBundle.append(this.jdField_c_of_type_JavaLangString);
          QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            paramBundle = new StringBuilder();
            paramBundle.append("onCreate DevlockInfo devSetup:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup);
            paramBundle.append(" countryCode:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            paramBundle.append(" mobile:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            paramBundle.append(" MbItemSmsCodeStatus:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus);
            paramBundle.append(" TimeLimit:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit);
            paramBundle.append(" AvailableMsgCount:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount);
            paramBundle.append(" AllowSet:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
            QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
            paramBundle = new StringBuilder();
            paramBundle.append("DevlockInfo.ProtectIntro:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
            paramBundle.append("  info.MbGuideType:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
            QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
            paramBundle = new StringBuilder();
            paramBundle.append("DevlockInfo.MbGuideMsg:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
            QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
            paramBundle = new StringBuilder();
            paramBundle.append("DevlockInfo.MbGuideInfoType:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
            QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
            paramBundle = new StringBuilder();
            paramBundle.append("DevlockInfo.MbGuideInfo:");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
            QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
            paramBundle = new StringBuilder();
            paramBundle.append("DevlockInfo.OtherDevLockVerifyUrl");
            paramBundle.append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl);
            QLog.d("NewAuthDevUgFragment", 2, paramBundle.toString());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().setFormat(-3);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setTheme(2131755933);
        }
        if (this.jdField_a_of_type_Boolean) {
          LoginUtils.b(this.jdField_a_of_type_MqqAppAppRuntime);
        }
        this.jdField_b_of_type_Boolean = paramViewGroup.getBoolean("from_phone_num_login");
        if (this.jdField_b_of_type_Boolean)
        {
          this.e.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698760));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B9E3", "0X800B9E3", LoginStaticField.a(), 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager = GateWayVerifyManager.a();
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new NewAuthDevUgFragment.VerifyObserverWrapper(this.jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_a_of_type_Int);
        e();
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA33", "0X800AA33", LoginStaticField.a(), 0, "", "", "", "");
        if (LoginStaticField.a() == 1) {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AC0B", "0X800AC0B", LoginStaticField.a(), 0, "", "", "", "");
        }
        GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "get devInfo error : ", paramViewGroup.getMessage() });
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable.c();
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */