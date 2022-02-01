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
import com.tencent.mobileqq.login.authdev.AuthDevUgReporter;
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
  private EquipLockProxy A;
  private BroadcastReceiver B;
  private VerifyDevLockManager.VerifyDevLockObserver C = new NewAuthDevUgFragment.1(this);
  private AppRuntime a;
  private QBaseActivity b;
  private boolean c = false;
  private boolean d = false;
  private int e;
  private String f;
  private String g;
  private String h;
  private DevlockInfo i;
  private GatewayLoadingDrawable j;
  private TextView k;
  private TextView l;
  private long m;
  private long n;
  private View o;
  private TextView p;
  private TextView q;
  private TextView r;
  private ImageView s;
  private TextView t;
  private String u;
  private int v;
  private VerifyDevLockManager.VerifyDevLockObserver w;
  private GateWayVerifyManager x;
  private Dialog y;
  private ILoginApi z;
  
  public static void a(int paramInt)
  {
    ReportController.a(null, "dc00898", "", "", "0X800B9E5", "0X800B9E5", paramInt, 0, "", "", "", "");
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "data is null");
      e();
      return;
    }
    try
    {
      paramObject = (byte[])paramObject;
      Object localObject = new GatewayVerify.RspBody();
      ((GatewayVerify.RspBody)localObject).mergeFrom(paramObject);
      this.u = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_get_url_v4.str_msg_id.get();
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "msgid: ", this.u });
      localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_get_url_v4.rpt_self_phone_url.get();
      if (localObject == null)
      {
        QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is null");
        a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is null");
        e();
        return;
      }
      int i1 = ((List)localObject).size();
      if (i1 == 0)
      {
        QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is empty");
        a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is empty");
        e();
        return;
      }
      paramObject = new MultiGatewayCallback(getQBaseActivity(), this.u, i1, this);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GatewayVerify.SelfPhoneUrl localSelfPhoneUrl = (GatewayVerify.SelfPhoneUrl)((Iterator)localObject).next();
        if (localSelfPhoneUrl == null)
        {
          a("V_GET_GATEWAY_URL_ERROR", -1, "url bean is null");
          e();
          return;
        }
        this.x.a(localSelfPhoneUrl, paramObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getGatewayToken, GatewayVerify.RspBody mergeFrom error : ", paramObject.getMessage() });
      a("V_GET_GATEWAY_URL_ERROR", -1, paramObject.getMessage());
      e();
      GatewayUtil.a(this.b, this.a, 3, this.f);
    }
  }
  
  private void a(String paramString)
  {
    this.r.setText(getString(2131896720, new Object[] { paramString }));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = this.a.getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("K_RESULT_TYPE", paramString1);
    localHashMap.put("K_RET", String.valueOf(paramInt));
    localHashMap.put("K_UIN", str);
    localHashMap.put("K_RESULT_MSG", paramString2);
    if ("V_RET_SUCCESS".equals(paramString1)) {
      localHashMap.put("K_REDIRECT_TIME", String.valueOf(this.v));
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
      int i2 = paramString1.length();
      int i1 = 3;
      if (i2 < 3) {
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
          i1 = 9;
        }
      }
      else {
        i1 = 6;
      }
      bool1 = bool2;
      if (paramString1.length() >= i1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    String str;
    if ("com.tencent.mobileqq:openSdk".equals(this.a.getApplication().getQQProcessName())) {
      str = "/base/login/authDevVerifyCodeOpenSdk";
    } else {
      str = "/base/login/authDevVerifyCode";
    }
    DevlockInfo localDevlockInfo = this.i;
    if (localDevlockInfo != null)
    {
      localIntent.putExtra("phone_num", localDevlockInfo.Mobile);
      localIntent.putExtra("country_code", this.i.CountryCode);
      localIntent.putExtra("mobile_type", 0);
    }
    localIntent.putExtra("from_login", this.c);
    localIntent.putExtra("from_phone_num_login", this.d);
    localIntent.putExtra("uin", this.f);
    localIntent.putExtra("seq", this.e);
    localIntent.putExtra("verify_code_start_time", System.currentTimeMillis());
    LoginUtils.a(this.b, localIntent, str, 1002);
    d();
    AuthDevUgReporter.a().a(this.a, "0X800B661");
    ReportController.a(this.a, "dc00898", "", this.f, "0X800ADDE", "0X800ADDE", 0, 0, "", "", "", "");
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    DevlockInfo localDevlockInfo = this.i;
    if (localDevlockInfo != null)
    {
      localIntent.putExtra("phone_num", localDevlockInfo.Mobile);
      localIntent.putExtra("country_code", this.i.CountryCode);
      localIntent.putExtra("mobile_type", 0);
      localIntent.putExtra("DevlockInfo", this.i);
    }
    localIntent.putExtra("from_login", this.c);
    localIntent.putExtra("uin", this.f);
    localIntent.putExtra("seq", this.e);
    localIntent.putExtra("mainaccount", this.h);
    QPublicFragmentActivity.startForResult(this, localIntent, GatewayVerifyFailedFragment.class, 1);
    d();
  }
  
  private void g()
  {
    this.B = new NewAuthDevUgFragment.2(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.broadcast.action.authdev.phonechange");
    this.b.registerReceiver(this.B, localIntentFilter);
  }
  
  private void h()
  {
    i();
    Object localObject = new GatewayVerify.ReqBody();
    GatewayVerify.ReqBodySelfPhone localReqBodySelfPhone = new GatewayVerify.ReqBodySelfPhone();
    GatewayVerify.ReqBodySelfPhoneGetUrlV4 localReqBodySelfPhoneGetUrlV4 = new GatewayVerify.ReqBodySelfPhoneGetUrlV4();
    localReqBodySelfPhoneGetUrlV4.uint32_get_upload_url.set(1);
    try
    {
      i1 = DeviceInfoUtil.g(this.b);
    }
    catch (Exception localException)
    {
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getCarrier error : ", localException.getMessage() });
      i1 = 0;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "carrier ：", Integer.valueOf(i1) });
    localReqBodySelfPhoneGetUrlV4.uint32_isp_type.set(i1);
    String str = IPUtils.a();
    if ((!NetworkUtil.isWifiConnected(this.b)) && (!"0.0.0.0".equals(str))) {
      localReqBodySelfPhoneGetUrlV4.str_cell_ip.set(str);
    } else {
      QLog.d("NewAuthDevUgFragment", 1, "get ip error");
    }
    localReqBodySelfPhone.msg_req_get_url_v4.set(localReqBodySelfPhoneGetUrlV4);
    ((GatewayVerify.ReqBody)localObject).msg_req_self_phone.set(localReqBodySelfPhone);
    localObject = ((GatewayVerify.ReqBody)localObject).toByteArray();
    int i1 = this.A.a(this.b.getAppRuntime(), (byte[])localObject, this.w);
    if (i1 == 0)
    {
      this.j.b();
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "refreshDevLockSms error , ret : ", Integer.valueOf(i1) });
  }
  
  private void i()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.3(this));
  }
  
  private void j()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.4(this));
  }
  
  private void k()
  {
    this.j.a();
    this.t.setText(2131888933);
  }
  
  private void l()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onGetTokenError getActivity is null or activity is finish");
      return;
    }
    j();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onGetTokenError : ", paramException.getMessage() });
    a("V_GET_TOKEN_ERROR", paramInt, paramException.getMessage());
    e();
    GatewayUtil.a(this.b, this.a, 3, this.f);
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onChangeNetworkError getActivity is null or activity is finish");
      return;
    }
    j();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onChangeNetworkError : ", paramException.getMessage() });
    a("V_CHANGE_NETWORK_TYPE_ERROR", -1, paramException.getMessage());
    e();
    GatewayUtil.a(this.b, this.a, 3, this.f);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onTokenCallback getActivity is null or activity is finish");
      return;
    }
    int i1 = this.A.a(this.b.getAppRuntime(), this.w, paramArrayOfByte);
    if (i1 != 0) {
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "mEquipLockProxy.submitSms error, ret : ", Integer.valueOf(i1) });
    }
  }
  
  boolean a()
  {
    QBaseActivity localQBaseActivity = this.b;
    return (localQBaseActivity == null) || (localQBaseActivity.isFinishing());
  }
  
  protected void b()
  {
    d();
    QLog.d("NewAuthDevUgFragment", 1, "beforeOpenBrowser do finish");
  }
  
  protected void c()
  {
    QLog.d("NewAuthDevUgFragment", 1, "afterOpenBrowser do nothing");
  }
  
  protected void d()
  {
    this.b.finish();
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
        localObject1 = this.i;
        if (localObject1 != null)
        {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject1).Mobile);
          paramIntent.putExtra("country_code", this.i.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        LoginUtils.a(this.b, paramIntent, "/base/safe/authDevActivity");
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        localObject1 = this.i;
        if (localObject1 != null) {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject1).Mobile);
        }
        this.b.setResult(-1, paramIntent);
        d();
      }
    }
    else if (paramInt1 == 1002)
    {
      if (paramInt2 == -1)
      {
        this.b.setResult(paramInt2, paramIntent);
        d();
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
            paramIntent = this.i;
            if (paramIntent != null)
            {
              paramIntent.Mobile = ((String)localObject1);
              if (!TextUtils.isEmpty(paramIntent.Mobile))
              {
                a(this.i.Mobile);
                this.k.setText(getString(2131888951));
                this.p.setVisibility(8);
              }
            }
            if (!bool) {
              return;
            }
            paramIntent = this.A;
            localObject2 = this.a;
            paramIntent.a((AppRuntime)localObject2, this.b, ((AppRuntime)localObject2).getCurrentAccountUin(), true);
            paramIntent = new Intent();
            paramIntent.putExtra("phone_num", (String)localObject1);
            localObject1 = this.i;
            if (localObject1 != null) {
              paramIntent.putExtra("country_code", ((DevlockInfo)localObject1).CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            LoginUtils.a(this.b, paramIntent, "/base/safe/authDevActivity");
            QQToast.makeText(this.b, 2, getString(2131888947), 0).show();
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("auth_dev_open", true);
            ((Intent)localObject1).putExtra("allow_set", true);
            localObject2 = this.i;
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("phone_num", ((DevlockInfo)localObject2).Mobile);
            }
            this.b.setResult(-1, paramIntent);
            d();
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
            localObject1 = this.A;
            localObject2 = this.a;
            ((EquipLockProxy)localObject1).a((AppRuntime)localObject2, ((AppRuntime)localObject2).getCurrentAccountUin(), null);
          }
          localObject1 = this.i;
          if (localObject1 != null)
          {
            ((DevlockInfo)localObject1).Mobile = paramIntent;
            if (!TextUtils.isEmpty(((DevlockInfo)localObject1).Mobile))
            {
              a(this.i.Mobile);
              this.k.setText(getString(2131888951));
              this.p.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    AuthDevUgReporter.a().a(this.a, "0X800ADDA");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if ((this.m <= 0L) || (System.currentTimeMillis() - this.m <= 0L) || (System.currentTimeMillis() - this.m >= 500L))
    {
      this.m = System.currentTimeMillis();
      int i1 = paramView.getId();
      Object localObject;
      if (i1 == 2131448322)
      {
        ReportController.a(this.a, "dc00898", "", this.f, "0X800AA34", "0X800AA34", LoginStaticField.a(), 0, "", "", "", "");
        AuthDevUgReporter.a().a(this.a, "0X800ADDD");
        this.a.sendWirelessMeibaoReq(1);
        if (QBaseActivity.mAppForground)
        {
          if ((!TextUtils.isEmpty(this.g)) && (this.g.equals("subaccount")))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("subaccount enter webview mUin=");
              ((StringBuilder)localObject).append(this.f);
              ((StringBuilder)localObject).append(" mMainAccount=");
              ((StringBuilder)localObject).append(this.h);
              QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject).toString());
            }
            if ((TextUtils.isEmpty(this.f)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            this.A.a(this.b, this.h, this.f, 1);
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("mainaccount enter webview mUin=");
              ((StringBuilder)localObject).append(this.f);
              QLog.d("NewAuthDevUgFragment", 2, ((StringBuilder)localObject).toString());
            }
            if ((TextUtils.isEmpty(this.f)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            this.A.a(this.b, this.a.getCurrentAccountUin(), this.f, 1);
          }
        }
        else {
          this.A.a(this.b, this.a, 1);
        }
      }
      else if (i1 == 2131448632)
      {
        if ((this.n <= 0L) || (System.currentTimeMillis() - this.n <= 0L) || (System.currentTimeMillis() - this.n >= 3000L))
        {
          this.n = System.currentTimeMillis();
          ReportController.a(this.a, "dc00898", "", this.f, "0X800AA36", "0X800AA36", LoginStaticField.a(), 0, "", "", "", "");
          AuthDevUgReporter.a().a(this.a, "0X800ADDC");
          l();
        }
      }
      else if (i1 == 2131448862)
      {
        GatewayUtil.a(this.b, this.a, 2, this.f);
        boolean bool3 = false;
        boolean bool4 = this.c;
        boolean bool1;
        if (this.i == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject = this.i;
        boolean bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if (TextUtils.isEmpty(((DevlockInfo)localObject).Mobile)) {
            bool2 = true;
          }
        }
        QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onCLick Verify btn, from login: ", Boolean.valueOf(bool4), "mDev is null ? ", Boolean.valueOf(bool1), " , mobile is null ? ", Boolean.valueOf(bool2) });
        localObject = this.i;
        if (((localObject != null) && (TextUtils.isEmpty(((DevlockInfo)localObject).Mobile))) || (this.d))
        {
          AuthDevUgReporter.a().a(this.a, "0X800BA0C");
          if (this.d) {
            ReportController.a(this.a, "dc00898", "", this.f, "0X800B9E4", "0X800B9E4", 0, 0, "", "", "", "");
          }
        }
        else
        {
          AuthDevUgReporter.a().a(this.a, "0X800B660");
        }
        if ((this.i != null) && (this.c))
        {
          ReportController.a(this.a, "dc00898", "", this.f, "0X800AA35", "0X800AA35", LoginStaticField.a(), 0, "", "", "", "");
          if ((!TextUtils.isEmpty(this.i.Mobile)) && (!this.d)) {
            h();
          } else {
            l();
          }
        }
        else
        {
          localObject = this.i;
          if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).Mobile)))
          {
            ReportController.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
            localObject = new Intent(this.b, AuthDevVerifyCodeActivity.class);
            ((Intent)localObject).putExtra("phone_num", this.i.Mobile);
            ((Intent)localObject).putExtra("country_code", this.i.CountryCode);
            ((Intent)localObject).putExtra("verify_code_start_time", System.currentTimeMillis());
            startActivityForResult((Intent)localObject, 1001);
          }
          else
          {
            this.A.a(this.b, this.a, 1, 1003, null);
          }
        }
        ReportController.a(this.a, "dc00898", "", this.f, "0X800ADDB", "0X800ADDB", 0, 0, "", "", "", "");
      }
      else if (i1 == 2131436278)
      {
        onBackEvent();
        d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getQBaseActivity();
    this.a = this.b.getAppRuntime();
    int i1;
    if ((!ThemeUtil.isNowThemeIsNight(this.a, false, null)) && (!ThemeUtil.isGoldenTheme())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      ImmersiveUtils.setStatusTextColor(true, this.b.getWindow());
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131627389, paramViewGroup, false);
    this.k = ((TextView)paramLayoutInflater.findViewById(2131448862));
    this.l = ((TextView)paramLayoutInflater.findViewById(2131448632));
    this.o = paramLayoutInflater.findViewById(2131436278);
    this.p = ((TextView)paramLayoutInflater.findViewById(2131448322));
    this.q = ((TextView)paramLayoutInflater.findViewById(2131448767));
    this.r = ((TextView)paramLayoutInflater.findViewById(2131448639));
    this.j = new GatewayLoadingDrawable();
    this.y = new ReportDialog(this.b, 2131952183);
    this.y.setContentView(2131623977);
    this.s = ((ImageView)this.y.findViewById(2131436445));
    this.t = ((TextView)this.y.findViewById(2131448614));
    this.s.setImageDrawable(this.j);
    paramLayoutInflater.findViewById(2131436278).setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.z = ((ILoginApi)QRoute.api(ILoginApi.class));
    this.A = new EquipLockProxy();
    paramViewGroup = getArguments();
    if (paramViewGroup == null)
    {
      d();
    }
    else
    {
      paramBundle = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
      paramBundle.topMargin = (Utils.a(6.0F, this.b.getResources()) + ImmersiveUtils.getStatusBarHeight(this.b));
      this.o.setLayoutParams(paramBundle);
      try
      {
        this.c = paramViewGroup.getBoolean("from_login");
        this.e = paramViewGroup.getInt("seq");
        paramBundle = paramViewGroup.get("DevlockInfo");
        if ((paramBundle instanceof DevlockInfo)) {
          this.i = ((DevlockInfo)paramBundle);
        }
        this.f = paramViewGroup.getString("uin");
        this.g = paramViewGroup.getString("from_where");
        this.h = paramViewGroup.getString("mainaccount");
        if (this.c)
        {
          this.b.setTheme(2131953054);
          LoginUtils.b(this.a);
          paramBundle = this.i;
          if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.MbGuideInfo))) {
            this.A.a(this.i.MbGuideInfo);
          }
        }
        paramBundle = this.i;
        if ((paramBundle != null) && (paramBundle.Mobile != null))
        {
          a(this.i.Mobile);
          if (!TextUtils.isEmpty(this.i.VerifyReason)) {
            this.q.setText(this.i.VerifyReason);
          }
        }
        this.d = paramViewGroup.getBoolean("from_phone_num_login");
        AuthDevUgReporter.a().a(this.f, this.d);
        paramViewGroup = this.i;
        if (((paramViewGroup != null) && (TextUtils.isEmpty(paramViewGroup.Mobile))) || (this.d))
        {
          this.r.setVisibility(8);
          this.p.setVisibility(8);
          this.k.setText(getString(2131896718));
          this.l.setVisibility(8);
          AuthDevUgReporter.a().a(this.a, "0X800BA0B");
          if (this.d) {
            ReportController.a(this.a, "dc00898", "", this.f, "0X800B9E3", "0X800B9E3", LoginStaticField.a(), 0, "", "", "", "");
          }
        }
        else
        {
          AuthDevUgReporter.a().a(this.a, "0X800ADD9");
        }
        if (QLog.isColorLevel())
        {
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("onCreate mIsFromLogin = ");
          paramViewGroup.append(this.c);
          paramViewGroup.append(" mVerifySeq=");
          paramViewGroup.append(this.e);
          paramViewGroup.append(" mUin=");
          paramViewGroup.append(this.f);
          paramViewGroup.append(" mFromWhere=");
          paramViewGroup.append(this.g);
          paramViewGroup.append(" mMainAccount=");
          paramViewGroup.append(this.h);
          QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
          if (this.i != null)
          {
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("onCreate DevlockInfo devSetup:");
            paramViewGroup.append(this.i.DevSetup);
            paramViewGroup.append(" countryCode:");
            paramViewGroup.append(this.i.CountryCode);
            paramViewGroup.append(" mobile:");
            paramViewGroup.append(this.i.Mobile);
            paramViewGroup.append(" MbItemSmsCodeStatus:");
            paramViewGroup.append(this.i.MbItemSmsCodeStatus);
            paramViewGroup.append(" TimeLimit:");
            paramViewGroup.append(this.i.TimeLimit);
            paramViewGroup.append(" AvailableMsgCount:");
            paramViewGroup.append(this.i.AvailableMsgCount);
            paramViewGroup.append(" AllowSet:");
            paramViewGroup.append(this.i.AllowSet);
            QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("DevlockInfo.ProtectIntro:");
            paramViewGroup.append(this.i.ProtectIntro);
            paramViewGroup.append("  info.MbGuideType:");
            paramViewGroup.append(this.i.MbGuideType);
            QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("DevlockInfo.MbGuideMsg:");
            paramViewGroup.append(this.i.MbGuideMsg);
            QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("DevlockInfo.MbGuideInfoType:");
            paramViewGroup.append(this.i.MbGuideInfoType);
            QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("DevlockInfo.MbGuideInfo:");
            paramViewGroup.append(this.i.MbGuideInfo);
            QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
            paramViewGroup = new StringBuilder();
            paramViewGroup.append("DevlockInfo.OtherDevLockVerifyUrl");
            paramViewGroup.append(this.i.OtherDevLockVerifyUrl);
            QLog.d("NewAuthDevUgFragment", 2, paramViewGroup.toString());
          }
        }
        this.b.getWindow().setFormat(-3);
        this.x = GateWayVerifyManager.a();
        this.w = new NewAuthDevUgFragment.VerifyObserverWrapper(this.C);
        this.w.setSeq(this.e);
        g();
        ReportController.a(this.a, "dc00898", "", this.f, "0X800AA33", "0X800AA33", LoginStaticField.a(), 0, "", "", "", "");
        if (LoginStaticField.a() == 1) {
          ReportController.a(this.a, "dc00898", "", this.f, "0X800AC0B", "0X800AC0B", LoginStaticField.a(), 0, "", "", "", "");
        }
        GatewayUtil.a(this.b, this.a, 1, this.f);
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "get devInfo error : ", paramViewGroup.getMessage() });
        d();
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.x.e();
    this.j.c();
    if (this.y.isShowing()) {
      this.y.dismiss();
    }
    this.b.unregisterReceiver(this.B);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.c) {
      LoginUtils.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */