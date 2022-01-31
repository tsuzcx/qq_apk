package com.tencent.mobileqq.activity;

import aabn;
import acgy;
import adap;
import adaq;
import adar;
import adas;
import adau;
import adav;
import aekt;
import alpo;
import alwf;
import alzf;
import ammv;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import anxn;
import apwo;
import apwu;
import arng;
import arni;
import arvo;
import asmg;
import asmj;
import asnb;
import auux;
import awuv;
import awux;
import awuz;
import azmz;
import bcgs;
import bdbi;
import bdcv;
import bddb;
import bddr;
import bdds;
import bddu;
import bdee;
import bdje;
import bfhq;
import bhoe;
import bhou;
import bioj;
import birl;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;
import cooperation.comic.VipComicJumpActivity;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import loz;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import mtz;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;
import owy;
import sno;
import xlb;
import ylr;
import zpa;

public class JumpActivity
  extends BaseActivity
  implements DialogInterface.OnDismissListener, Handler.Callback, asnb
{
  private static int jdField_a_of_type_Int = -1;
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  public static boolean a;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "mqq", "mqqapi", "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", "qqwifi", "mqqconnect", "qqstory", "mqqconferenceflyticket", "mqqavshare" };
  public static boolean b;
  private static volatile boolean g;
  private alwf jdField_a_of_type_Alwf;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bddu jdField_a_of_type_Bddu;
  private String jdField_a_of_type_JavaLangString;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adap(this);
  protected final MqqHandler a;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_b_of_type_AndroidContentIntent;
  private String jdField_b_of_type_JavaLangString;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public JumpActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  }
  
  private Uri a(Uri paramUri)
  {
    Object localObject1 = paramUri;
    Object localObject2;
    if (paramUri != null)
    {
      localObject1 = paramUri;
      if ("file".equals(paramUri.getScheme()))
      {
        localObject2 = paramUri.getPath();
        localObject1 = paramUri;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new File((String)localObject2);
          localObject1 = paramUri;
          if (!((File)localObject2).exists()) {}
        }
      }
    }
    try
    {
      localObject1 = ((File)localObject2).getCanonicalPath();
      if (!((String)localObject1).startsWith(File.separator + "data" + File.separator + "data" + File.separator + BaseApplicationImpl.getContext().getPackageName())) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = Uri.parse("file://" + (String)localObject1);
        return localObject1;
      }
      return null;
    }
    catch (Exception localException) {}
    return paramUri;
  }
  
  private static String a(Context paramContext)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if ((paramContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        if (paramContext.size() > 0) {
          break label42;
        }
        localObject1 = localObject2;
      }
    }
    return localObject1;
    label42:
    paramContext = paramContext.iterator();
    Fragment localFragment;
    do
    {
      localObject1 = localObject2;
      if (!paramContext.hasNext()) {
        break;
      }
      localFragment = (Fragment)paramContext.next();
    } while (!localFragment.isVisible());
    paramContext = localFragment.getClass().getName();
    if ((localFragment instanceof MainFragment))
    {
      localObject1 = (MainFragment)localFragment;
      paramContext = paramContext + "$" + ((MainFragment)localObject1).c();
    }
    for (;;)
    {
      localObject1 = paramContext;
      if (!(localFragment instanceof ChatFragment)) {
        break;
      }
      localObject2 = (ChatFragment)localFragment;
      localObject1 = paramContext;
      if (((ChatFragment)localObject2).a == null) {
        break;
      }
      return paramContext + "$" + ((ChatFragment)localObject2).a.b();
    }
  }
  
  private String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  private String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(bdbi.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.getComponent() != null)
      {
        Object localObject = paramIntent.getComponent().getClassName();
        if ((localObject != null) && ((((String)localObject).contains("QQBrowserActivity")) || (((String)localObject).contains("QQBrowserDelegationActivity"))) && (!paramIntent.hasExtra("StartClickTime")))
        {
          paramIntent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
          String str = a(paramContext);
          localObject = new StringBuilder().append(paramContext.getClass().getName());
          if (TextUtils.isEmpty(str)) {}
          for (paramContext = "";; paramContext = "$" + str)
          {
            paramIntent.putExtra("SourceActivityName", paramContext);
            return;
          }
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Intent paramIntent)
  {
    String str = paramIntent.getDataString();
    if ((paramIntent.getComponent() == null) && (!TextUtils.isEmpty(str)))
    {
      Object localObject = Uri.parse(str).getScheme();
      boolean bool2 = a((String)localObject);
      boolean bool1 = false;
      if (bool2) {
        bool1 = b((String)localObject);
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("JumpAction", 1, "processIntent, scheme[" + (String)localObject + "], isLegalScheme[" + bool2 + "], needForceSetComponent[" + bool1 + "]");
      }
      if ((bool2) && (bool1))
      {
        localObject = azmz.a(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("URL", str);
        ((azmz)localObject).a("", "JA_ILLEGAL", true, 0L, 0L, localHashMap, "");
        paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
      }
    }
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("jump_action_thread", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      asmg localasmg = new asmg(this, this);
      h();
      this.jdField_b_of_type_MqqOsMqqHandler.post(new JumpActivity.10(this, localasmg, paramIntent, paramInt));
      return;
    }
    finally {}
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    new JumpActivity.4(this, paramIntent, paramBundle).run();
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("din");
      paramBundle = paramBundle.getString("qrurl");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!"9971".equals(localObject)) {
          break label55;
        }
        aabn.a(this.app, this, null, "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html?from=2", null);
      }
    }
    for (;;)
    {
      finish();
      return;
      label55:
      zpa localzpa = (zpa)this.app.a(51);
      DeviceInfo localDeviceInfo = localzpa.a(Long.parseLong((String)localObject));
      if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din))))
      {
        localzpa.a(this, localDeviceInfo, false, null);
      }
      else if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramBundle);
        ((Intent)localObject).putExtra("title", alpo.a(2131706276));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("selfSet_leftViewText", alpo.a(2131706284));
        ((Intent)localObject).putExtra("leftViewText", alpo.a(2131706282));
        startActivity((Intent)localObject);
      }
      else
      {
        bfhq.a().a(alpo.a(2131706281));
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (this.jdField_c_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ("app".equals(this.jdField_a_of_type_JavaLangString));
        if (!"web".equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!"javascript".equals(this.jdField_b_of_type_JavaLangString));
      paramString = "javascript:" + this.jdField_c_of_type_JavaLangString + "('" + paramString + "')";
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    } while (!"internal".equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "initJASwitch with " + paramString + " inited=" + g);
        }
        boolean bool = g;
        if (bool) {
          return;
        }
      }
      finally {}
      try
      {
        jdField_a_of_type_Int = (int)Long.parseLong(paramString, 16);
        if (paramBoolean) {
          BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).edit().putString("JASwitch", paramString).commit();
        }
      }
      catch (NumberFormatException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JumpAction", 2, "initJASwitch error", paramString);
        continue;
      }
      g = true;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject3 = getIntent();
    Object localObject2 = ((Intent)localObject3).getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras((Intent)localObject3);
      startActivityForResult((Intent)localObject2, 24);
      return;
    }
    localObject2 = ((Intent)localObject3).getStringExtra("CONFIG_APPID");
    localObject1 = ((Intent)localObject3).getStringExtra("CONFIG_APPNAME");
    String str1 = ((Intent)localObject3).getStringExtra("CONFIG_APPICON");
    String str2 = ((Intent)localObject3).getStringExtra("MINI_CONFIG_DEV_DESC");
    int m = ((Intent)localObject3).getIntExtra("CONFIG_VER_TYPE", 3);
    int j = ((Intent)localObject3).getIntExtra("CONFIG_REPORTTYPE", 0);
    int k = ((Intent)localObject3).getIntExtra("CONFIG_ENGINETYPE", 0);
    int i = ((Intent)localObject3).getIntExtra("CONFIG_APPTYPE", -1);
    if (i != -1) {
      j = i;
    }
    for (;;)
    {
      k = ((Intent)localObject3).getIntExtra("MINI_CONFIG_SCENE", 10086);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)))
      {
        localObject3 = new MiniAppInfo();
        ((MiniAppInfo)localObject3).appId = ((String)localObject2);
        ((MiniAppInfo)localObject3).name = ((String)localObject1);
        ((MiniAppInfo)localObject3).iconUrl = str1;
        ((MiniAppInfo)localObject3).setEngineType(i);
        ((MiniAppInfo)localObject3).setReportType(j);
        ((MiniAppInfo)localObject3).developerDesc = str2;
        ((MiniAppInfo)localObject3).verType = m;
        localObject1 = new MiniAppConfig((MiniAppInfo)localObject3);
        ((MiniAppConfig)localObject1).launchParam = new LaunchParam();
        ((MiniAppConfig)localObject1).launchParam.miniAppId = ((String)localObject2);
        ((MiniAppConfig)localObject1).launchParam.scene = k;
      }
      for (;;)
      {
        if ((localObject1 != null) && (k == 1023) && (((MiniAppConfig)localObject1).config.isEngineTypeMiniGame())) {
          anxn.a(false, 0);
        }
        if (localObject1 != null) {
          MiniAppController.startApp(this, (MiniAppConfig)localObject1, null);
        }
        moveTaskToBack(true);
        finish();
        return;
        localObject1 = null;
      }
      i = k;
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return;
    }
    try
    {
      i = ((Intent)localObject).getIntExtra("busi_type", -1);
      j = ((Intent)localObject).getIntExtra("verify_type", -1);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("ticket");
        if (QLog.isColorLevel()) {
          QLog.d("Q.security_verify", 2, String.format("onWebSecVerifyResult, isSuc: %s, busiType: %s, verifyType: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) }));
        }
        localObject = ((Intent)localObject).getParcelableExtra("extra_data");
        switch (i)
        {
        default: 
          finish();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("JumpAction", 1, "onWebSecVerifyResult", localException);
        int j = -1;
        int i = -1;
        continue;
        if ((localObject instanceof InviteToGroupInfo))
        {
          localObject = (InviteToGroupInfo)localObject;
          alzf localalzf = (alzf)this.app.a(20);
          if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            ((InviteToGroupInfo)localObject).jdField_a_of_type_Int = j;
            ((InviteToGroupInfo)localObject).jdField_c_of_type_JavaLangString = paramIntent;
            localalzf.a((InviteToGroupInfo)localObject);
          }
          else
          {
            localalzf.notifyUI(6, false, new Object[] { Integer.valueOf(8), Integer.valueOf(-1) });
            continue;
            if ((localObject instanceof JoinGroupInfo))
            {
              localObject = (JoinGroupInfo)localObject;
              localalzf = (alzf)this.app.a(20);
              if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
              {
                ((JoinGroupInfo)localObject).b = j;
                ((JoinGroupInfo)localObject).f = paramIntent;
                localalzf.a((JoinGroupInfo)localObject);
              }
              else
              {
                localalzf.notifyUI(6, false, new Object[] { Integer.valueOf(1), Integer.valueOf(-1) });
                continue;
                paramIntent = null;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = getIntent();
    if ((paramBoolean1) && (!this.app.isLogin()))
    {
      jdField_b_of_type_Boolean = true;
      paramString = new Intent(this, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      startActivityForResult(paramString, 26);
    }
    do
    {
      return;
      if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())))
      {
        startActivityForResult(new Intent(getActivity(), GesturePWDUnlockActivity.class), 27);
        return;
      }
      jdField_b_of_type_Boolean = false;
      localObject = ((Intent)localObject).getDataString();
      localObject = bdds.a(this.app, this, (String)localObject);
      ((bddb)localObject).a(paramString);
      ((bddb)localObject).b(this.jdField_d_of_type_JavaLangString);
    } while (!((bddb)localObject).c());
    finish();
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getExtras();
        localObject1 = localObject3;
        StringBuilder localStringBuilder = new StringBuilder("system share.doShareCheckNeedSDPermission():");
        localObject1 = localObject3;
        localStringBuilder.append("phone info [mod:").append(Build.MODEL).append(",ver:").append(Build.VERSION.SDK).append(",maf:").append(Build.MANUFACTURER).append("]");
        localObject1 = localObject3;
        localObject4 = paramIntent.get("android.intent.extra.STREAM");
        paramIntent = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (!(localObject4 instanceof Uri)) {
            continue;
          }
          localObject1 = localObject3;
          paramIntent = (Uri)localObject4;
        }
        localObject1 = paramIntent;
        localStringBuilder.append(",intent.extra=").append(paramIntent);
        localObject1 = paramIntent;
        QLog.i("JumpAction", 1, localStringBuilder.toString());
      }
      catch (Exception paramIntent)
      {
        Object localObject4;
        QLog.e("JumpAction", 1, "system share.doShareCheckNeedSDPermission() e=", paramIntent);
        paramIntent = (Intent)localObject1;
        continue;
        boolean bool = false;
        continue;
      }
      if (paramIntent == null) {
        break;
      }
      bool = asmj.a(paramIntent, this);
      QLog.d("JumpAction", 1, new Object[] { "system share.doShareCheckNeedSDPermission() canReadFromUri=", Boolean.valueOf(bool) });
      if (bool) {
        continue;
      }
      bool = true;
      return bool;
      paramIntent = localObject2;
      localObject1 = localObject3;
      if ((localObject4 instanceof String))
      {
        localObject1 = localObject3;
        paramIntent = Uri.parse((String)localObject4);
      }
    }
  }
  
  private boolean a(bddb parambddb)
  {
    if ((parambddb == null) || (parambddb.jdField_a_of_type_JavaUtilHashMap == null)) {}
    while ((!MiniProgramOpenSdkUtil.isSharingMiniProgram(parambddb.jdField_a_of_type_JavaUtilHashMap)) || (parambddb.jdField_c_of_type_JavaLangString.equals("to_qzone"))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    try
    {
      if (jdField_a_of_type_JavaUtilHashMap == null)
      {
        jdField_a_of_type_JavaUtilHashMap = new HashMap();
        int i = 0;
        while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          String str = jdField_a_of_type_ArrayOfJavaLangString[i];
          jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(i));
          i += 1;
        }
        if (!g) {
          g();
        }
      }
      return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
    }
    finally {}
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adaq(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void b(Intent paramIntent)
  {
    Intent localIntent;
    if (!this.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QREADER_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(localIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
      startActivityForResult(localIntent, 571);
      return;
    }
    c(paramIntent);
  }
  
  private void b(Bundle paramBundle)
  {
    new JumpActivity.5(this, paramBundle).run();
  }
  
  private void b(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 20);
      return;
    }
    a(localIntent, 1);
  }
  
  private void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = getIntent();
    if ((paramBoolean1) && (!this.app.isLogin()))
    {
      jdField_a_of_type_Boolean = true;
      paramString = new Intent(this, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      startActivityForResult(paramString, 21);
      return;
    }
    if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())))
    {
      startActivityForResult(new Intent(getActivity(), GesturePWDUnlockActivity.class), 22);
      return;
    }
    jdField_a_of_type_Boolean = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = bdds.a(this.app, this, (String)localObject);
    ((bddb)localObject).a(paramString);
    ((bddb)localObject).c();
    finish();
  }
  
  private boolean b(bddb parambddb)
  {
    if (parambddb == null) {}
    String str2;
    String str1;
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(parambddb.b("share_id")));
      str2 = parambddb.b("req_type");
      str1 = parambddb.b("cflag");
    } while (TextUtils.isEmpty(str2));
    for (;;)
    {
      for (;;)
      {
        try
        {
          str2 = a(str2);
          if (TextUtils.isEmpty(str2)) {
            break label207;
          }
          i = Integer.valueOf(str2).intValue();
          if (((i == 3) || (i == 4)) && ("qzone".equals(parambddb.jdField_b_of_type_JavaLangString)) && ("publish".equals(parambddb.jdField_c_of_type_JavaLangString)))
          {
            QLog.i("JumpAction", 1, "ShareShuoshuoOrVideoToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("JumpAction", 1, "needToStartQZoneProcess catch NumberFormatException. ", localNumberFormatException);
          i = 1;
          continue;
        }
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        try
        {
          parambddb = a(str1);
          if (!TextUtils.isEmpty(parambddb))
          {
            j = Integer.valueOf(parambddb).intValue();
            if ((i != 5) || ((j & 0x1) == 0)) {
              break;
            }
            QLog.i("JumpAction", 1, "SharePictureToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException parambddb)
        {
          for (;;)
          {
            QLog.d("JumpAction", 1, "needToStartQZoneProcess catch NumberFormatException. ", parambddb);
            int j = 0;
          }
        }
      }
      label207:
      int i = 1;
    }
  }
  
  private static boolean b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (1 << ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() & jdField_a_of_type_Int) != 0;
    }
    return false;
  }
  
  private void c()
  {
    arni.a(this);
    arng.a("0X8005533");
    finish();
  }
  
  private void c(Intent paramIntent)
  {
    Intent localIntent = new Intent(this, QRBridgeActivity.class);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
    finish();
  }
  
  private void c(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.i("JumpAction", 1, "system share.doShare error intent is null");
      finish();
      return;
    }
    if (localIntent.getExtras() == null)
    {
      QLog.i("JumpAction", 1, "system share.doShare error extra is null");
      finish();
      return;
    }
    if (ForwardUtils.a(this))
    {
      d(paramBoolean);
      return;
    }
    HashMap localHashMap = new HashMap();
    azmz.a(BaseApplication.getContext()).a("", "noSDPermissionShare", true, 0L, 0L, localHashMap, "");
    boolean bool = a(localIntent);
    QLog.d("JumpAction", 1, new Object[] { "system share.doShare needGrantSDPermission=", Boolean.valueOf(bool) });
    if ((bool) && (Build.VERSION.SDK_INT >= 23))
    {
      ammv.a(this, 3, new adas(this, paramBoolean));
      return;
    }
    d(paramBoolean);
  }
  
  private void d()
  {
    String str1 = getPackageName();
    String str2 = InstallActivity.class.getName();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(str1, str2));
    startActivity(localIntent);
    finish();
  }
  
  private void d(Intent paramIntent)
  {
    Intent localIntent;
    if (!this.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QQCOMIC_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(localIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      this.jdField_b_of_type_AndroidContentIntent = new Intent();
      this.jdField_b_of_type_AndroidContentIntent.putExtras(paramIntent);
      startActivityForResult(localIntent, 572);
      return;
    }
    e(paramIntent);
  }
  
  private void d(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      QLog.i("JumpAction", 1, "system share.doShare error extra is null");
      finish();
      return;
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localIntent = new Intent(this, LoginActivity.class);
      localIntent.putExtra("isActionSend", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtras(localIntent);
      startActivityForResult(localIntent, 19);
      return;
    }
    if (localBundle.getBoolean("qqfav_extra_from_system_share", false))
    {
      int i = a(localBundle);
      if (i == 4) {
        birl.a(this, 2131698472, 1);
      }
      for (;;)
      {
        finish();
        return;
        if (i != 0) {
          birl.a(this, 2131698468, 1);
        }
      }
    }
    a(localIntent, 0);
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_Alwf == null) {
        this.jdField_a_of_type_Alwf = new alwf(this.app.getAccount());
      }
      startActivityForResult(new Intent(this, QQMapActivity.class).putExtra("uin", this.app.getAccount()), 18);
      return;
    }
    catch (Exception localException)
    {
      if (this.e) {
        a("Google Map not exist");
      }
      finish();
    }
  }
  
  private void e(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("comicID");
      if ((!((String)localObject).equalsIgnoreCase("0")) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label57;
      }
      localObject = new Intent(this, VipComicJumpActivity.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtras(paramIntent);
      startActivity((Intent)localObject);
      finish();
      return;
      label57:
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).setFlags(1073741824);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  private void f(Intent paramIntent)
  {
    Intent localIntent;
    if (!this.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QFILE_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(localIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      startActivityForResult(localIntent, 570);
      return;
    }
    c();
  }
  
  private static void g()
  {
    a(BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
  }
  
  private void g(Intent paramIntent)
  {
    if (!this.app.isLogin())
    {
      paramIntent = new Intent();
      paramIntent.setClass(this, LoginActivity.class);
      paramIntent.addFlags(67371008);
      startActivity(paramIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      Intent localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      startActivityForResult(localIntent, 573);
      return;
    }
    a(paramIntent.getExtras());
  }
  
  private void h()
  {
    try
    {
      setContentView(2131560983);
      this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)findViewById(2131368996));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, localThrowable, new Object[0]);
    }
  }
  
  private void h(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.buscard".equals(str)) {
      BuscardHelper.a(this.mRuntime, paramIntent, str);
    }
    for (;;)
    {
      finish();
      return;
      if ("android.nfc.action.TECH_DISCOVERED".equals(str)) {
        BuscardHelper.a(this.app.getCurrentAccountUin(), getActivity(), paramIntent);
      }
    }
  }
  
  private void i(Intent paramIntent)
  {
    int i = 0;
    try
    {
      boolean bool = paramIntent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
      i = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QLINK_SHORTCUT_JUMP_KEY", paramIntent);
      startActivity(localIntent);
      finish();
      return;
    }
    if (!this.app.isLogin()) {
      if (i != 0)
      {
        finish();
        return;
      }
    }
    bioj.a(this, 7, null);
    finish();
  }
  
  private static void j(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "reportJumpArguments action=" + str + "; data=" + paramIntent);
    }
    azmz localazmz = azmz.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", str);
    localHashMap.put("data", paramIntent);
    localazmz.a("", "JA_ARGUMENTS", true, 0L, 0L, localHashMap, "");
  }
  
  private void k(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getData();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new String(bdbi.decode(((Uri)localObject2).getQueryParameter("param"), 0));
      paramIntent = ((Uri)localObject2).getQueryParameter("appname");
      ((Uri)localObject2).getQueryParameter("src_type");
      ((Uri)localObject2).getQueryParameter("version");
      localObject2 = ((Uri)localObject2).getQueryParameter("share_id");
    }
    try
    {
      l = Long.parseLong((String)localObject2);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (l == 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "app id is null,can not share");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      do
      {
        do
        {
          for (;;)
          {
            l = 0L;
          }
          if ("wangzhe".equals(paramIntent)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("JumpAction", 2, "app name is not wangzhe");
        return;
        paramIntent = null;
        try
        {
          localObject1 = new JSONObject((String)localObject1).getString("url");
          paramIntent = (Intent)localObject1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          Intent localIntent = new Intent(this, ReadInJoyDeliverVideoActivity.class);
          localIntent.putExtra("arg_is_from_wang_zhe", true);
          localIntent.putExtra("arg_wang_zhe_app_id", l);
          startActivity(localIntent);
        }
        if ((!this.app.isLogin()) && (!TextUtils.isEmpty(paramIntent)))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(this, LoginActivity.class);
          ((Intent)localObject1).putExtra("is_from_king_moment", true);
          ((Intent)localObject1).putExtra("king_moment_cover_url", paramIntent);
          ((Intent)localObject1).putExtra("arg_wang_zhe_app_id", l);
          startActivity((Intent)localObject1);
          return;
        }
      } while (TextUtils.isEmpty(paramIntent));
      owy.a().a(paramIntent, this.app.c());
    }
  }
  
  private void l(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getParcelableExtra("extra_data");
      if ((!TextUtils.isEmpty(paramIntent.getStringExtra("url"))) && (((localObject instanceof InviteToGroupInfo)) || ((localObject instanceof JoinGroupInfo))))
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtras(paramIntent);
        startActivityForResult((Intent)localObject, 25);
        return;
      }
      QLog.d("Q.security_verify", 1, "goToWebSecVerify, error param!");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QLog.d("Q.security_verify", 1, "goToWebSecVerify", paramIntent);
      }
    }
    finish();
  }
  
  protected int a(Bundle paramBundle)
  {
    Object localObject2 = null;
    String str5;
    HashMap localHashMap;
    int i;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|beg");
        }
        Object localObject3 = (Uri)paramBundle.getParcelable("android.intent.extra.STREAM");
        if ((localObject3 != null) && ("file".equals(((Uri)localObject3).getScheme())) && (((Uri)localObject3).getPath().startsWith("/storage"))) {
          return 4;
        }
        Object localObject1 = paramBundle.getString("android.intent.extra.TITLE");
        paramBundle.getString("android.intent.extra.SUBJECT");
        String str4 = paramBundle.getString("android.intent.extra.TEXT");
        paramBundle.getString("image_url");
        paramBundle.getString("detail_url");
        str5 = getIntent().getType();
        if (TextUtils.isEmpty(str5))
        {
          if (!QLog.isColorLevel()) {
            break label1246;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|type null");
          break label1246;
        }
        localHashMap = new HashMap();
        localHashMap.put("src_type", "app");
        localHashMap.put("version", "1");
        localHashMap.put("cflag", bdbi.encodeToString("1".getBytes(), 0));
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = "";
          localHashMap.put("title", localObject1);
          if (!str5.startsWith("text")) {
            break label598;
          }
          if (paramBundle.containsKey("android.intent.extra.STREAM")) {
            continue;
          }
          localHashMap.put("req_type", bdbi.encodeToString("6".getBytes(), 0));
          if (TextUtils.isEmpty(str4))
          {
            paramBundle = "";
            localHashMap.put("description", paramBundle);
            paramBundle = new StringBuilder("mqqapi://share/to_qqfav?");
            localObject1 = localHashMap.keySet();
            localObject2 = ((Set)localObject1).iterator();
            i = 0;
            label308:
            if (!((Iterator)localObject2).hasNext()) {
              break label1177;
            }
            localObject3 = (String)((Iterator)localObject2).next();
            paramBundle.append((String)localObject3);
            paramBundle.append("=");
            paramBundle.append((String)localHashMap.get(localObject3));
            if (i == ((Set)localObject1).size() - 1) {
              break label1248;
            }
            paramBundle.append("&");
            break label1248;
          }
        }
        else
        {
          localObject1 = bdbi.encodeToString(((String)localObject1).getBytes(), 0);
          continue;
        }
        paramBundle = bdbi.encodeToString(str4.getBytes(), 0);
        continue;
        if (localObject3 == null) {
          continue;
        }
        try
        {
          paramBundle = super.getContentResolver().openInputStream((Uri)localObject3);
        }
        catch (Exception localException1)
        {
          try
          {
            localObject1 = a(paramBundle);
            paramBundle.close();
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (!QLog.isColorLevel()) {
                break label1255;
              }
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|text, extra_stream, empty");
              break label1255;
            }
            localHashMap.put("req_type", bdbi.encodeToString("6".getBytes(), 0));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            paramBundle = "";
            localHashMap.put("description", paramBundle);
          }
          catch (Exception localException2)
          {
            String str2;
            boolean bool;
            continue;
            paramBundle = null;
            break label1259;
          }
          localException1 = localException1;
          paramBundle = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|text, extra_stream, exp:" + localException1.getMessage());
        }
        if (paramBundle != null) {}
        try
        {
          paramBundle.close();
          return 1;
          paramBundle = bdbi.encodeToString(localException1.getBytes(), 0);
        }
        catch (IOException paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        if (!str5.startsWith("image")) {
          break label1140;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|outofmemoryerror");
        }
        return 1;
      }
      label598:
      localHashMap.put("req_type", bdbi.encodeToString("5".getBytes(), 0));
      if (getIntent().getAction().equals("android.intent.action.SEND"))
      {
        paramBundle = paramBundle.get("android.intent.extra.STREAM");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label1257;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
          break label1257;
        }
        if ((paramBundle instanceof Uri))
        {
          paramBundle = (Uri)paramBundle;
          break label1259;
        }
        if (!(paramBundle instanceof String)) {
          break label1241;
        }
        paramBundle = Uri.parse((String)paramBundle);
        break label1259;
        label708:
        paramBundle = arvo.a(this, paramBundle);
        if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + paramBundle);
          }
          return 1;
        }
        try
        {
          String str1 = URLEncoder.encode(paramBundle, "UTF-8");
          localHashMap.put("file_data", bdbi.encodeToString(str1.getBytes(), 0));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|encode fail. path=" + paramBundle + ",exp:" + localUnsupportedEncodingException1.getMessage());
          }
          return 1;
        }
      }
    }
    try
    {
      paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
      if (paramBundle == null)
      {
        if (!QLog.isColorLevel()) {
          break label1265;
        }
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        paramBundle = (Bundle)localObject2;
      }
      localObject2 = new ArrayList();
      i = 0;
      for (;;)
      {
        if (i < paramBundle.size())
        {
          str2 = arvo.a(this, (Uri)paramBundle.get(i));
          if (!TextUtils.isEmpty(str2))
          {
            bool = new File(str2).exists();
            if (!bool) {}
          }
          try
          {
            ((ArrayList)localObject2).add(URLEncoder.encode(str2, "UTF-8"));
            i += 1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + localUnsupportedEncodingException2.getMessage());
              }
            }
          }
        }
      }
      if (!((ArrayList)localObject2).isEmpty()) {
        break label1269;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
    }
    for (;;)
    {
      if (i < ((ArrayList)localObject2).size())
      {
        String str3 = paramBundle + (String)((ArrayList)localObject2).get(i);
        paramBundle = str3;
        if (i != ((ArrayList)localObject2).size() - 1) {
          paramBundle = str3 + ";";
        }
      }
      else
      {
        localHashMap.put("file_data", bdbi.encodeToString(paramBundle.getBytes(), 0));
        break;
        label1140:
        if (!QLog.isColorLevel()) {
          break label1284;
        }
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|unknown type. type=" + str5);
        break label1284;
        label1177:
        paramBundle = bdds.a(this.app, this, paramBundle.toString());
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label1286;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|jump parse fail");
          break label1286;
        }
        paramBundle.c();
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|end");
        }
        return 0;
        label1241:
        label1246:
        return 1;
        label1248:
        i += 1;
        break label308;
        label1255:
        return 1;
        label1257:
        return 1;
        label1259:
        if (paramBundle != null) {
          break label708;
        }
        return 1;
        label1265:
        return 1;
        return 1;
        label1269:
        paramBundle = "";
        i = 0;
        continue;
      }
      i += 1;
    }
    label1284:
    return 1;
    label1286:
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new adar(this);
      IntentFilter localIntentFilter = new IntentFilter("BroadcastReceiverFinishActivity");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void a(DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    apwo localapwo = apwo.a();
    if ((localapwo != null) && (localapwo.a() == apwo.c))
    {
      localIntent = new Intent();
      localIntent.setAction("mqq.intent.action.DEVLOCK_ROAM");
      if (paramDevlockInfo != null) {
        if (paramDevlockInfo.DevSetup == 1)
        {
          localIntent.putExtra("auth_dev_open", bool1);
          localIntent.putExtra("guardphone_state", localapwo.a());
          if (paramDevlockInfo == null) {
            break label122;
          }
        }
      }
      label122:
      for (paramDevlockInfo = paramDevlockInfo.Mobile;; paramDevlockInfo = "")
      {
        localIntent.putExtra("guardphone_mask", paramDevlockInfo);
        sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
        finish();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break;
      }
    }
    Intent localIntent = new Intent(getIntent());
    localIntent.putExtra("devlock_need_broadcast", true);
    if ((localIntent.getBooleanExtra("enable_open_allowset_dev", false)) && (paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 0) && (paramDevlockInfo.AllowSet == 1))
    {
      localIntent.setClass(this, AuthDevActivity.class);
      localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
      localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
      localIntent.putExtra("auth_dev_open", false);
      localIntent.putExtra("allow_set", true);
    }
    for (;;)
    {
      startActivity(localIntent);
      if (!localIntent.getBooleanExtra("open_devlock_from_roam", false)) {
        break;
      }
      overridePendingTransition(2130771979, 2130771977);
      break;
      if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1))
      {
        localIntent.setClass(this, AuthDevActivity.class);
        localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
        localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
        if (paramDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          label327:
          localIntent.putExtra("auth_dev_open", bool1);
          if (paramDevlockInfo.AllowSet != 1) {
            break label365;
          }
        }
        label365:
        for (bool1 = bool2;; bool1 = false)
        {
          localIntent.putExtra("allow_set", bool1);
          break;
          bool1 = false;
          break label327;
        }
      }
      localIntent.setClass(this, AuthDevOpenUgActivity.class);
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      if ((paramBoolean) && (paramInt1 == 0) && (paramInt2 == 1))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new Intent(this, QQBrowserActivity.class);
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("hide_more_button", true);
          startActivity(paramString2);
        }
        finish();
        return;
      }
      if (("android.intent.action.SEND".equals(paramString2)) || ("android.intent.action.SEND_MULTIPLE".equals(paramString2)))
      {
        b(getIntent().getExtras());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("JumpAction", 1, paramString1, new Object[0]);
      return;
    }
    if ("android.intent.action.VIEW".equals(paramString2))
    {
      Intent localIntent = getIntent();
      paramString2 = localIntent.getExtras();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = new Bundle();
      }
      a(localIntent, paramString1);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (!bddr.a(this, true))
      {
        super.finish();
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent != null)
      {
        localObject1 = paramIntent.toString();
        QLog.d("JumpAction", 2, (String)localObject1);
      }
    }
    else
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break label567;
      }
      switch (paramInt1)
      {
      }
    }
    label463:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = "null";
            break;
            if (this.e) {
              a("HexUtil.bytes2HexStr(fileKey)");
            }
            finish();
            return;
            if (this.jdField_a_of_type_Alwf != null) {
              this.jdField_a_of_type_Alwf = null;
            }
            localObject1 = localObject2;
            if (paramIntent != null) {
              localObject1 = paramIntent.getExtras();
            }
          } while (localObject1 == null);
          paramIntent = ((Bundle)localObject1).getString("latitude");
          localObject1 = ((Bundle)localObject1).getString("longitude");
          if (this.e) {
            a("ret=0&lon=" + (String)localObject1 + "&lat=" + paramIntent);
          }
          finish();
          return;
          c(false);
          return;
          b(false);
          return;
          b(false, null, true);
          return;
          b(true, null, false);
          return;
          a(false, null, true);
          return;
          a(true, null, false);
          return;
          a(false);
          return;
          if ((-1 != paramInt2) || (paramIntent == null)) {
            break label463;
          }
          paramIntent = paramIntent.getStringExtra("roomId");
        } while (paramIntent == null);
        localObject1 = new adau(this);
      } while (!ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, (acgy)localObject1, null));
      finish();
      return;
      finish();
      return;
      finish();
      return;
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        c(this.jdField_a_of_type_AndroidContentIntent);
      }
      finish();
      return;
      if (this.jdField_b_of_type_AndroidContentIntent != null) {
        e(this.jdField_b_of_type_AndroidContentIntent);
      }
      finish();
      return;
      a(true, paramIntent);
      return;
      new Handler().postDelayed(new JumpActivity.8(this), 10L);
      return;
      new Handler().postDelayed(new JumpActivity.9(this, paramIntent), 10L);
      return;
      if (paramInt1 == 25)
      {
        a(false, paramIntent);
        return;
      }
    } while (paramInt1 == 23);
    label567:
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    getWindow().addFlags(67108864);
    Intent localIntent;
    try
    {
      super.doOnCreate(paramBundle);
      QLog.d("JumpAction", 1, "JumpActivity doOnCreate()");
      localIntent = getIntent();
      j(localIntent);
      this.jdField_a_of_type_Bddu = new bddu();
      this.jdField_a_of_type_Bddu.a(this.app, this, localIntent);
      if ((localIntent != null) && (("com.tencent.apollo.SHORT_CUT".equals(localIntent.getAction())) || (localIntent.getBooleanExtra("jump_cm_game", false))))
      {
        if (!this.app.isLogin())
        {
          paramBundle = new Intent();
          paramBundle.setClass(this, LoginActivity.class);
          paramBundle.addFlags(67371008);
          startActivity(paramBundle);
          finish();
          return false;
        }
        if (localIntent.getBooleanExtra("jump_game_city", false))
        {
          ApolloGameUtil.a(this.app, new adav(this, 0, null));
          return false;
        }
        if (localIntent.getBooleanExtra("jump_cm_game", false))
        {
          i = localIntent.getIntExtra("jump_cm_game_id", -1);
          paramBundle = localIntent.getStringExtra("jump_cm_extendinfo");
          ApolloGameUtil.a(this.app, new adav(this, i, paramBundle));
          return false;
        }
      }
      if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.VIEW")) && (localIntent.getIntExtra("MINI_CONFIG_SCENE", -1) > 0) && (!TextUtils.isEmpty(localIntent.getStringExtra("CONFIG_APPID"))))
      {
        a(true);
        return false;
      }
      if (localIntent != null)
      {
        bool = "from_nearby_pb".equals(localIntent.getStringExtra("from"));
        if (bool)
        {
          try
          {
            paramBundle = localIntent.getDataString();
            if (!TextUtils.isEmpty(paramBundle))
            {
              paramBundle = bdds.a(this.app, this, paramBundle);
              if (paramBundle != null) {
                paramBundle.b();
              }
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.nearby", 2, "nearby_pb|exception:" + paramBundle.toString());
              }
            }
          }
          finish();
          return false;
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("JumpAction", 1, "doOnCreate|exp:" + paramBundle.getMessage());
      finish();
      return false;
    }
    if ((localIntent != null) && ("from_gesturemgr_download".equals(localIntent.getAction())))
    {
      finish();
      return false;
    }
    if ((localIntent != null) && ("from_qavgpsomgr_download".equals(localIntent.getAction())))
    {
      loz.a();
      finish();
      return false;
    }
    if ((localIntent != null) && ("from_webtool_launchshortvideo".equals(localIntent.getAction())))
    {
      paramBundle = localIntent.getExtras();
      xlb.a().b(this, paramBundle);
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && ((localIntent.getAction().equals("android.intent.action.SEND")) || (localIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
    {
      c(true);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(localIntent.getScheme())) && ((localIntent.getScheme().equals("file")) || (localIntent.getScheme().equals("content"))))
    {
      b(true);
      return false;
    }
    if (a()) {
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.SENDTO")) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("imto")))
    {
      d();
      return false;
    }
    if ((localIntent != null) && ("thridapp".equals(localIntent.getStringExtra("share_from"))))
    {
      if (!ylr.a().a(String.valueOf(Long.valueOf(localIntent.getLongExtra("req_share_id", 0L)))))
      {
        super.finish();
        return false;
      }
      paramBundle = new Intent(this, SplashActivity.class);
      paramBundle.putExtras(localIntent.getExtras());
      startActivity(aekt.a(paramBundle, null));
      return false;
    }
    if ((localIntent != null) && (((!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_qlink_shortcut", false))) || (localIntent.getBooleanExtra("_goto_qlink_when_login_suc_", false))))
    {
      i(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.qreader.SHORT_CUT")) && (localIntent.getBooleanExtra("is_from_qreader_shortcut", false)))
    {
      b(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.qqcomic.SHORT_CUT")))
    {
      d(localIntent);
      return false;
    }
    if ((localIntent != null) && (((!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_qfile_shortcut", false))) || (localIntent.getBooleanExtra("_goto_qfile_when_login_suc_", false))))
    {
      f(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.smartdevice.SHORT_CUT")))
    {
      g(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("kandianugc")))
    {
      k(localIntent);
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_kandian_shortcut", false)))
    {
      localIntent.addFlags(524288);
      localIntent.addFlags(134217728);
      localIntent.putExtra("url", "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/bundle_feeds.js");
      localIntent.putExtra(sno.jdField_a_of_type_JavaLangString, "QQ看点");
      PublicFragmentActivity.a(getActivity(), localIntent, ViolaFragment.class);
      getActivity().overridePendingTransition(2130771997, 0);
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration")))
    {
      paramBundle = new Intent(this, DataMigrationService.class);
      paramBundle.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
      paramBundle.putExtras(localIntent);
      try
      {
        startService(paramBundle);
        finish();
        return false;
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("JumpAction", 1, "mqqdatamigration", paramBundle);
        }
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqaudioassistant")))
    {
      QLog.d("JumpAction", 1, "get mqqaudioassistant Jump");
      paramBundle = localIntent.getData();
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getQueryParameter("jumpaction");
        QLog.d("JumpAction", 1, String.format("mqqaudioassistant Jump args host = %s, \nPath = %s, \ntype = %s \nEXTRA_TEXT = %s", new Object[] { paramBundle.getHost(), paramBundle.getPath(), paramBundle.getQueryParameter("type"), localIntent.getStringExtra("android.intent.extra.TEXT") }));
        localObject1 = (awuz)this.app.getManager(352);
        paramBundle = paramBundle.getHost();
        if (((awuz)localObject1).a(paramBundle))
        {
          localObject1 = ((awuz)localObject1).a((String)localObject2);
          if (localObject1 != null)
          {
            if (((awuv)localObject1).jdField_a_of_type_JavaUtilHashMap.size() > 0)
            {
              localObject2 = ((awuv)localObject1).jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localIntent.hasExtra((String)localObject3))
                {
                  localObject4 = localIntent.getStringExtra((String)localObject3);
                  if (!bdje.a((String)localObject4)) {
                    ((awuv)localObject1).jdField_a_of_type_JavaUtilHashMap.put(localObject3, localObject4);
                  }
                }
              }
            }
            ((awuv)localObject1).g = paramBundle;
            ((awuv)localObject1).a(this);
          }
        }
      }
      for (;;)
      {
        finish();
        return false;
        awux.a(paramBundle, (String)localObject2, 2);
        QLog.d("JumpAction", 1, "mqqaudioassistant Jump item = null");
        continue;
        awux.a(paramBundle, "", 1);
        continue;
        awux.a("", "", 101);
      }
    }
    if ((Build.VERSION.SDK_INT >= 10) && (localIntent != null))
    {
      paramBundle = localIntent.getAction();
      if (("android.nfc.action.TECH_DISCOVERED".equals(paramBundle)) || ("com.tencent.mobileqq.action.buscard".equals(paramBundle)))
      {
        h(localIntent);
        return false;
      }
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.security.VERIFY_WEB")))
    {
      l(localIntent);
      return false;
    }
    String str2 = getIntent().getDataString();
    String str3 = getIntent().getStringExtra("from");
    Object localObject5 = null;
    Object localObject6 = null;
    paramBundle = null;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject6;
      localObject4 = paramBundle;
      if (i < 3) {
        localObject3 = localObject5;
      }
      for (;;)
      {
        try
        {
          localObject2 = super.getCallingPackage();
          localObject1 = localObject2;
          localObject3 = localObject5;
          paramBundle = (Bundle)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            QLog.i("JumpAction", 1, "-->onCreate getCallingPackage returns null!");
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            localObject1 = super.getCallingActivity();
            if (localObject1 == null) {
              continue;
            }
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            localObject2 = ((ComponentName)localObject1).getPackageName();
            localObject1 = localObject2;
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = localObject5;
              paramBundle = (Bundle)localObject2;
              QLog.i("JumpAction", 1, "-->onCreate get package from activity returns null!");
              localObject1 = localObject2;
            }
          }
          localObject3 = localObject5;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          localObject3 = localObject5;
          paramBundle = (Bundle)localObject1;
          Object localObject7 = getPackageManager().getPackageInfo((String)localObject1, 64);
          localObject2 = localObject6;
          localObject4 = localObject1;
          if (localObject7 != null)
          {
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject1;
            localObject7 = ((PackageInfo)localObject7).signatures;
            localObject2 = localObject6;
            localObject4 = localObject1;
            if (localObject7 != null)
            {
              localObject2 = localObject6;
              localObject4 = localObject1;
              localObject3 = localObject5;
              paramBundle = (Bundle)localObject1;
              if (localObject7.length > 0)
              {
                localObject3 = localObject5;
                paramBundle = (Bundle)localObject1;
                localObject2 = MessageDigest.getInstance("MD5");
                localObject3 = localObject5;
                paramBundle = (Bundle)localObject1;
                ((MessageDigest)localObject2).update(localObject7[0].toByteArray());
                localObject3 = localObject5;
                paramBundle = (Bundle)localObject1;
                localObject2 = bdcv.a(((MessageDigest)localObject2).digest());
                if (localObject2 != null) {
                  continue;
                }
                localObject2 = "";
                localObject4 = localObject1;
              }
            }
          }
          paramBundle = (Bundle)localObject4;
        }
        catch (Exception localException)
        {
          localObject2 = localObject3;
          continue;
          i = 0;
          continue;
        }
        localObject1 = paramBundle;
        if (paramBundle == null)
        {
          localObject1 = getIntent().getStringExtra("pkg_name");
          paramBundle = azmz.a(BaseApplication.getContext());
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("osVersion", Build.VERSION.RELEASE);
          ((HashMap)localObject3).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
          paramBundle.a("", "GetCallingPackageEmpty", true, 0L, 0L, (HashMap)localObject3, "");
        }
        if (str2 == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "jump url:" + str2);
        }
        localObject3 = bdds.a(this.app, this, str2);
        if (("webview".equals(str3)) && (localObject3 != null)) {
          ((bddb)localObject3).a(str3);
        }
        if (localObject3 == null) {
          continue;
        }
        ((bddb)localObject3).jdField_a_of_type_Boolean = true;
        if ((!((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("qqidentifier")) || (localObject1 != null)) {
          continue;
        }
        QLog.e("JumpAction", 1, "can not get caller");
        finish();
        return false;
        localObject3 = localObject5;
        paramBundle = (Bundle)localObject2;
        QLog.i("JumpAction", 1, "-->onCreate getCallingActivity returns null!");
        localObject1 = localObject2;
        continue;
        localObject3 = localObject2;
        paramBundle = (Bundle)localObject1;
        localObject2 = ((String)localObject2).toLowerCase();
        localObject4 = localObject1;
      }
      i += 1;
      paramBundle = (Bundle)localObject1;
    }
    if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("puzzle_verify_code")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null))
    {
      paramBundle = new Intent(getIntent());
      if (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("PUZZLEVERIFYCODE"))
      {
        paramBundle.setClass(this, QQBrowserActivity.class);
        super.startActivity(paramBundle);
      }
      for (;;)
      {
        super.finish();
        return false;
        if (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("VERIFYCODE"))
        {
          paramBundle.setClass(this, VerifyCodeActivity.class);
          super.startActivity(paramBundle);
        }
        else if (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("DEVLOCK_CODE"))
        {
          paramBundle.setClass(this, AuthDevUgActivity.class);
          super.startActivity(paramBundle);
        }
        else if (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("GATEVERIFY"))
        {
          PublicFragmentActivity.a(this, paramBundle, NewAuthDevUgFragment.class);
        }
      }
    }
    boolean bool = true;
    if (((((bddb)localObject3).jdField_b_of_type_JavaLangString == null) || (!((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("ptlogin")) || (((bddb)localObject3).jdField_c_of_type_JavaLangString == null) || (!((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("qlogin"))) && ((((bddb)localObject3).jdField_b_of_type_JavaLangString == null) || (!((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("qqreg")))) {
      if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && ("invite_register".equals(((bddb)localObject3).jdField_c_of_type_JavaLangString)))
      {
        break label3741;
        if ((str2.startsWith("mqqwpa://im")) || (str2.startsWith("mqqwpaopenid://im")))
        {
          b(true, str3, true);
          return false;
        }
        if ((str2.startsWith("mqqapi:")) && ((localObject1 == null) || ("com.tencent.mobileqq".equals(localObject1))))
        {
          paramBundle = getIntent().getStringExtra("pkg_name");
          label2609:
          if ((str2.startsWith("mqqapi://im")) || (str2.startsWith("mqqapi://connect_miniapp")))
          {
            this.jdField_d_of_type_JavaLangString = paramBundle;
            a(true, str3, true);
            return false;
          }
          if ((!this.app.isLogin()) && (i != 0))
          {
            localObject2 = new StringBuilder().append(str2);
            if (str2.indexOf("?") <= -1) {
              break label3748;
            }
          }
        }
      }
    }
    label3741:
    label3746:
    label3748:
    String str1;
    for (Object localObject1 = "&";; str1 = "?")
    {
      localObject1 = (String)localObject1;
      localObject1 = (String)localObject1 + "jfrom=login";
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("scheme_content", (String)localObject1);
      ((Intent)localObject2).putExtra("pkg_name", paramBundle);
      ((Intent)localObject2).putExtras((Intent)localObject2);
      ((Intent)localObject2).setFlags(268435456);
      if (bhou.e()) {
        ((Intent)localObject2).addFlags(32768);
      }
      startActivity((Intent)localObject2);
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "JumpActivity is finish");
        }
        if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null)) {
          break;
        }
        finish();
        break label3746;
        if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)) && (!PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(this, this.app, str2)))
        {
          QLog.d("JumpAction", 1, new Object[] { "to GesturePWDUnlockActivity pkgName=", paramBundle });
          localObject1 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
          ((Intent)localObject1).putExtra("key_gesture_from_jumpactivity", true);
          ((Intent)localObject1).putExtra("scheme_content", str2);
          ((Intent)localObject1).putExtra("pkg_name", paramBundle);
          startActivity((Intent)localObject1);
        }
        else
        {
          if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("devlock")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("open")))
          {
            if (!bdee.d(this))
            {
              QQToast.a(this, getString(2131692397), 0).b(getTitleBarHeight());
              break label3756;
            }
            apwu.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_a_of_type_MqqObserverWtloginObserver);
            break label3756;
          }
          if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("gvideo")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("open_plugin")))
          {
            mtz.a(this.app, this, localIntent, 1);
            finish();
            return false;
          }
          if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("nearby_videochat")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("open_plugin")))
          {
            paramBundle = (bcgs)this.app.getManager(224);
            NearbyVideoChatProxyActivity.a(this.app, this, localIntent, paramBundle.a(), null, 123987);
            return false;
          }
          if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("qwerewolf")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("enterHomePage")))
          {
            auux.a(this, 16);
            finish();
            return false;
          }
          if (str2.startsWith("mqqapi://tenpay/pay?"))
          {
            localObject1 = null;
            if (localIntent != null) {
              localObject1 = localIntent.getStringExtra("url_app_info");
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((bddb)localObject3).a("url_app_info", (String)localObject1);
            }
          }
          ((bddb)localObject3).b(paramBundle);
          ((bddb)localObject3).c((String)localObject2);
          if ((((bddb)localObject3).jdField_b_of_type_JavaLangString != null) && (((bddb)localObject3).jdField_c_of_type_JavaLangString != null)) {
            ((bddb)localObject3).a(this);
          }
          bool = ((bddb)localObject3).c();
        }
      }
      if ((((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("gav")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("request")))
      {
        if ((!"0".equals(((bddb)localObject3).b("relation_id"))) && (bool)) {
          finish();
        }
      }
      else if ((("videochat".equals(((bddb)localObject3).jdField_b_of_type_JavaLangString)) && ("request".equals(((bddb)localObject3).jdField_c_of_type_JavaLangString))) || (("randomavchat".equals(((bddb)localObject3).jdField_b_of_type_JavaLangString)) && ("request".equals(((bddb)localObject3).jdField_c_of_type_JavaLangString))))
      {
        if (bool) {
          finish();
        }
      }
      else if ((((bddb)localObject3).jdField_b_of_type_JavaLangString.equals("wallet")) && (((bddb)localObject3).jdField_c_of_type_JavaLangString.equals("modify_pass")))
      {
        if (bool) {
          finish();
        }
      }
      else if (((bddb)localObject3).g())
      {
        if (bool) {
          finish();
        }
      }
      else if (a((bddb)localObject3))
      {
        QLog.d("JumpAction", 1, "asynShareJumpAction wait for finishing");
      }
      else if (!b((bddb)localObject3))
      {
        if (((bddb)localObject3).jdField_b_of_type_Boolean) {
          finish();
        } else if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "wait for finishing");
        }
      }
      else
      {
        b();
        break label3746;
        paramBundle = getIntent().getStringExtra("action");
        if (paramBundle == null)
        {
          finish();
          return false;
        }
        this.e = getIntent().getBooleanExtra("doCallBack", false);
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("src_type");
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("callback_type");
        this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("callback_name");
        if ("photo".equals(paramBundle)) {
          this.jdField_c_of_type_Boolean = true;
        }
        while (this.jdField_c_of_type_Boolean)
        {
          break label3758;
          if ("select_location".equals(paramBundle)) {
            this.jdField_d_of_type_Boolean = true;
          }
        }
        if (!this.jdField_d_of_type_Boolean) {
          break label3758;
        }
        e();
        break label3758;
        paramBundle = (Bundle)localObject1;
        break label2609;
        i = 1;
        break;
      }
      return false;
    }
    label3756:
    return false;
    label3758:
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    f();
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_Bddu != null)
    {
      this.jdField_a_of_type_Bddu.a(null);
      this.jdField_a_of_type_Bddu = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.f) {
      finish();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      f();
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      if ((paramMessage.obj instanceof Intent))
      {
        int i = paramMessage.arg1;
        Intent localIntent = (Intent)paramMessage.obj;
        f();
        if (i == 0)
        {
          if (!a()) {
            b(localIntent.getExtras());
          }
        }
        else if (!a())
        {
          Bundle localBundle = localIntent.getExtras();
          paramMessage = localBundle;
          if (localBundle == null) {
            paramMessage = new Bundle();
          }
          a(localIntent, paramMessage);
        }
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public boolean showPreview()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration"))) {}
    for (;;)
    {
      return true;
      try
      {
        boolean bool = bddr.a(this);
        if (bool) {}
      }
      catch (Throwable localThrowable)
      {
        label43:
        break label43;
      }
    }
    return super.showPreview();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    if (this.jdField_a_of_type_Bddu != null)
    {
      this.jdField_a_of_type_Bddu.a(paramIntent);
      this.jdField_a_of_type_Bddu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */