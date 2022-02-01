package com.tencent.mobileqq.activity;

import Override;
import aarg;
import abur;
import ache;
import aeue;
import aeuf;
import aeug;
import aeuh;
import aeuj;
import aeuk;
import aeul;
import aeun;
import aeuo;
import aeup;
import aeuq;
import aeur;
import aeut;
import aeuu;
import aeuv;
import aeuw;
import aeux;
import aeuy;
import aeuz;
import aeva;
import aevb;
import aevc;
import aevd;
import agej;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import anzj;
import aofl;
import aoip;
import apdr;
import aqre;
import asuz;
import asvf;
import aunh;
import aunj;
import avpu;
import avpx;
import avqp;
import axzi;
import banj;
import banl;
import bann;
import bdll;
import bdmc;
import bgpt;
import bhkv;
import bhml;
import bhmr;
import bhnh;
import bhni;
import bhnk;
import bhnv;
import bhsr;
import bjuh;
import blha;
import bmim;
import bmlc;
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
import com.tencent.mobileqq.forward.ForwardFileOption;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.VersionUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.comic.VipComicJumpActivity;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lmk;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import msd;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import pfa;
import tdl;
import zmq;

public class JumpActivity
  extends BaseActivity
  implements DialogInterface.OnDismissListener, Handler.Callback, avqp
{
  private static int jdField_a_of_type_Int = -1;
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  public static boolean a;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "mqq", "mqqapi", "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", "qqwifi", "mqqconnect", "qqstory", "mqqconferenceflyticket", "mqqavshare" };
  public static boolean b;
  private static volatile boolean g;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private aofl jdField_a_of_type_Aofl;
  private bhnk jdField_a_of_type_Bhnk;
  private String jdField_a_of_type_JavaLangString;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aeue(this);
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
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  }
  
  private Uri a(Uri paramUri)
  {
    int i = 1;
    Object localObject = paramUri;
    String str;
    File localFile;
    if (paramUri != null)
    {
      localObject = paramUri;
      if ("file".equals(paramUri.getScheme()))
      {
        str = paramUri.getPath();
        localObject = paramUri;
        if (!TextUtils.isEmpty(str))
        {
          localFile = new File(str);
          localObject = paramUri;
          if (!localFile.exists()) {}
        }
      }
    }
    try
    {
      localObject = localFile.getCanonicalPath();
      QLog.d("JumpAction", 1, new Object[] { "checkAndRebuildFileUri path", str, ", actFilePath=", localObject });
      if (!((String)localObject).startsWith(ForwardUtils.a() + BaseApplicationImpl.getContext().getPackageName())) {}
      while (i != 0)
      {
        localObject = Uri.parse("file://" + (String)localObject);
        return localObject;
        i = 0;
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
      paramString = new String(bhkv.decode(paramString, 0));
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
      avpu localavpu = new avpu(this, this);
      u();
      this.jdField_b_of_type_MqqOsMqqHandler.post(new JumpActivity.10(this, localavpu, paramIntent, paramInt));
      return;
    }
    finally {}
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    new JumpActivity.4(this, paramIntent, paramBundle).run();
  }
  
  private void a(bhmr parambhmr, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "JumpActivity is finish");
    }
    if ((parambhmr.jdField_b_of_type_JavaLangString == null) || (parambhmr.jdField_c_of_type_JavaLangString == null)) {
      finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!a(parambhmr, "gav", "request")) {
                break;
              }
            } while (("0".equals(parambhmr.b("relation_id"))) || (!paramBoolean));
            finish();
            return;
            if ((!a(parambhmr, "videochat", "request")) && (!a(parambhmr, "randomavchat", "request"))) {
              break;
            }
          } while (!paramBoolean);
          finish();
          return;
          if (!a(parambhmr, "wallet", "modify_pass")) {
            break;
          }
        } while (!paramBoolean);
        finish();
        return;
        if (!parambhmr.m()) {
          break;
        }
      } while (!paramBoolean);
      finish();
      return;
      if (a(parambhmr))
      {
        QLog.d("JumpAction", 1, "asynShareJumpAction wait for finishing");
        return;
      }
      if (b(parambhmr)) {
        break;
      }
      if (parambhmr.f)
      {
        finish();
        overridePendingTransition(0, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpAction", 2, "wait for finishing");
    return;
    a();
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
          aoip localaoip = (aoip)this.app.a(20);
          if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            ((InviteToGroupInfo)localObject).jdField_a_of_type_Int = j;
            ((InviteToGroupInfo)localObject).jdField_c_of_type_JavaLangString = paramIntent;
            localaoip.a((InviteToGroupInfo)localObject);
          }
          else
          {
            localaoip.notifyUI(6, false, new Object[] { Integer.valueOf(8), Integer.valueOf(-1) });
            continue;
            if ((localObject instanceof JoinGroupInfo))
            {
              localObject = (JoinGroupInfo)localObject;
              localaoip = (aoip)this.app.a(20);
              if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
              {
                ((JoinGroupInfo)localObject).b = j;
                ((JoinGroupInfo)localObject).f = paramIntent;
                localaoip.a((JoinGroupInfo)localObject);
              }
              else
              {
                localaoip.notifyUI(6, false, new Object[] { Integer.valueOf(1), Integer.valueOf(-1) });
                continue;
                paramIntent = null;
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(Intent paramIntent, bhmr parambhmr, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((parambhmr.jdField_b_of_type_JavaLangString.equals("qqidentifier")) && (paramString3 == null))
    {
      QLog.e("JumpAction", 1, "can not get caller");
      finish();
      return false;
    }
    if ((parambhmr.jdField_b_of_type_JavaLangString.equals("puzzle_verify_code")) && (parambhmr.jdField_c_of_type_JavaLangString != null))
    {
      paramIntent = new Intent(getIntent());
      if (parambhmr.jdField_c_of_type_JavaLangString.equals("PUZZLEVERIFYCODE"))
      {
        paramIntent.setClass(this, QQBrowserActivity.class);
        super.startActivity(paramIntent);
      }
      for (;;)
      {
        super.finish();
        return false;
        if (parambhmr.jdField_c_of_type_JavaLangString.equals("VERIFYCODE"))
        {
          paramIntent.setClass(this, VerifyCodeActivity.class);
          super.startActivity(paramIntent);
        }
        else if (parambhmr.jdField_c_of_type_JavaLangString.equals("DEVLOCK_CODE"))
        {
          paramIntent.setClass(this, AuthDevUgActivity.class);
          super.startActivity(paramIntent);
        }
        else if (parambhmr.jdField_c_of_type_JavaLangString.equals("GATEVERIFY"))
        {
          PublicFragmentActivity.a(this, paramIntent, NewAuthDevUgFragment.class);
        }
      }
    }
    if ((paramString1.startsWith("mqqwpa://im")) || (paramString1.startsWith("mqqwpaopenid://im")))
    {
      b(true, paramString2, true);
      return false;
    }
    if ((paramString1.startsWith("mqqapi:")) && ((paramString3 == null) || ("com.tencent.mobileqq".equals(paramString3)))) {
      paramString3 = getIntent().getStringExtra("pkg_name");
    }
    for (;;)
    {
      if ((paramString1.startsWith("mqqapi://im")) || (paramString1.startsWith("mqqapi://connect_miniapp")))
      {
        this.jdField_d_of_type_JavaLangString = paramString3;
        a(true, paramString2, true);
        return false;
      }
      return b(paramIntent, parambhmr, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  private boolean a(bhmr parambhmr, String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {}
    while ((!paramString1.equals(parambhmr.jdField_b_of_type_JavaLangString)) || (!paramString2.equals(parambhmr.jdField_c_of_type_JavaLangString))) {
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
          t();
        }
      }
      return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
    }
    finally {}
  }
  
  private void b(Bundle paramBundle)
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
        ache.a(this.app, this, null, "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html?from=2", null);
      }
    }
    for (;;)
    {
      finish();
      return;
      label55:
      abur localabur = (abur)this.app.a(51);
      DeviceInfo localDeviceInfo = localabur.a(Long.parseLong((String)localObject));
      if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din))))
      {
        localabur.a(this, localDeviceInfo, false, null);
      }
      else if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramBundle);
        ((Intent)localObject).putExtra("title", anzj.a(2131704796));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("selfSet_leftViewText", anzj.a(2131704804));
        ((Intent)localObject).putExtra("leftViewText", anzj.a(2131704802));
        startActivity((Intent)localObject);
      }
      else
      {
        bjuh.a().a(anzj.a(2131704801));
      }
    }
  }
  
  private boolean b(Intent paramIntent)
  {
    return (d(paramIntent)) && (e(paramIntent)) && (f(paramIntent));
  }
  
  private boolean b(Intent paramIntent, bhmr parambhmr, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = true;
    if ((a(parambhmr, "ptlogin", "qlogin")) || (parambhmr.jdField_b_of_type_JavaLangString.equals("qqreg")) || ("invite_register".equals(parambhmr.jdField_c_of_type_JavaLangString))) {}
    for (int i = 0;; i = 1)
    {
      if ((!this.app.isLogin()) && (i != 0))
      {
        paramString2 = new StringBuilder().append(paramString1);
        if (paramString1.contains("?"))
        {
          paramIntent = "&";
          paramIntent = paramIntent;
          paramIntent = paramIntent + "jfrom=login";
          paramString1 = new Intent(this, LoginActivity.class);
          paramString1.putExtra("scheme_content", paramIntent);
          paramString1.putExtra("pkg_name", paramString3);
          paramString1.putExtras(paramString1);
          paramString1.setFlags(268435456);
          if (VersionUtils.isHoneycomb()) {
            paramString1.addFlags(32768);
          }
          startActivity(paramString1);
        }
      }
      for (;;)
      {
        a(parambhmr, bool);
        return false;
        paramIntent = "?";
        break;
        if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)) && (!PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(this, this.app, paramString1)))
        {
          QLog.d("JumpAction", 1, new Object[] { "to GesturePWDUnlockActivity pkgName=", paramString3 });
          paramIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
          paramIntent.putExtra("key_gesture_from_jumpactivity", true);
          paramIntent.putExtra("scheme_content", paramString1);
          paramIntent.putExtra("pkg_name", paramString3);
          startActivity(paramIntent);
        }
        else
        {
          if (a(parambhmr, "devlock", "open"))
          {
            if (!bhnv.d(this))
            {
              QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
              return false;
            }
            asvf.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_a_of_type_MqqObserverWtloginObserver);
            return false;
          }
          if (a(parambhmr, "gvideo", "open_plugin"))
          {
            msd.a(this.app, this, paramIntent, 1);
            finish();
            return false;
          }
          if (a(parambhmr, "nearby_videochat", "open_plugin"))
          {
            parambhmr = (bgpt)this.app.getManager(224);
            NearbyVideoChatProxyActivity.a(this.app, this, paramIntent, parambhmr.a(), null, 123987);
            return false;
          }
          if (a(parambhmr, "qwerewolf", "enterHomePage"))
          {
            axzi.a(this, 16);
            finish();
            return false;
          }
          if (paramString1.startsWith("mqqapi://tenpay/pay?"))
          {
            paramIntent = paramIntent.getStringExtra("url_app_info");
            if (!TextUtils.isEmpty(paramIntent)) {
              parambhmr.a("url_app_info", paramIntent);
            }
          }
          parambhmr.c(paramString3);
          parambhmr.d(paramString4);
          if ((parambhmr.jdField_b_of_type_JavaLangString != null) && (parambhmr.jdField_c_of_type_JavaLangString != null)) {
            parambhmr.a(this);
          }
          bool = parambhmr.a();
        }
      }
    }
  }
  
  private static boolean b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (1 << ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() & jdField_a_of_type_Int) != 0;
    }
    return false;
  }
  
  private boolean c(Intent paramIntent)
  {
    String str1 = getIntent().getDataString();
    String str2 = getIntent().getStringExtra("from");
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject4 = localObject8;
      Object localObject6 = localObject1;
      if (i < 3) {
        localObject5 = localObject7;
      }
      for (;;)
      {
        try
        {
          localObject4 = super.getCallingPackage();
          localObject2 = localObject4;
          localObject5 = localObject7;
          localObject1 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject5 = localObject7;
            localObject1 = localObject4;
            QLog.i("JumpAction", 1, "-->onCreate getCallingPackage returns null!");
            localObject5 = localObject7;
            localObject1 = localObject4;
            localObject2 = super.getCallingActivity();
            if (localObject2 == null) {
              continue;
            }
            localObject5 = localObject7;
            localObject1 = localObject4;
            localObject4 = ((ComponentName)localObject2).getPackageName();
            localObject2 = localObject4;
            localObject5 = localObject7;
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject5 = localObject7;
              localObject1 = localObject4;
              QLog.i("JumpAction", 1, "-->onCreate get package from activity returns null!");
              localObject2 = localObject4;
            }
          }
          localObject5 = localObject7;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject5 = localObject7;
          localObject1 = localObject2;
          Object localObject9 = getPackageManager().getPackageInfo((String)localObject2, 64);
          localObject4 = localObject8;
          localObject6 = localObject2;
          if (localObject9 != null)
          {
            localObject5 = localObject7;
            localObject1 = localObject2;
            localObject9 = ((PackageInfo)localObject9).signatures;
            localObject4 = localObject8;
            localObject6 = localObject2;
            if (localObject9 != null)
            {
              localObject4 = localObject8;
              localObject6 = localObject2;
              localObject5 = localObject7;
              localObject1 = localObject2;
              if (localObject9.length > 0)
              {
                localObject5 = localObject7;
                localObject1 = localObject2;
                localObject4 = MessageDigest.getInstance("MD5");
                localObject5 = localObject7;
                localObject1 = localObject2;
                ((MessageDigest)localObject4).update(localObject9[0].toByteArray());
                localObject5 = localObject7;
                localObject1 = localObject2;
                localObject4 = bhml.a(((MessageDigest)localObject4).digest());
                if (localObject4 != null) {
                  continue;
                }
                localObject4 = "";
                localObject6 = localObject2;
              }
            }
          }
          localObject2 = localObject4;
          localObject1 = localObject6;
        }
        catch (Exception localException)
        {
          Object localObject2;
          Object localObject3 = localObject5;
          continue;
        }
        localObject4 = localObject1;
        if (localObject1 == null)
        {
          localObject4 = getIntent().getStringExtra("pkg_name");
          localObject1 = bdmc.a(BaseApplication.getContext());
          localObject5 = new HashMap();
          ((HashMap)localObject5).put("osVersion", Build.VERSION.RELEASE);
          ((HashMap)localObject5).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
          ((bdmc)localObject1).a("", "GetCallingPackageEmpty", true, 0L, 0L, (HashMap)localObject5, "");
        }
        if (str1 == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "jump url:" + str1);
        }
        localObject1 = bhni.a(this.app, this, str1);
        if (("webview".equals(str2)) && (localObject1 != null)) {
          ((bhmr)localObject1).b(str2);
        }
        if ((localObject1 == null) || (((bhmr)localObject1).jdField_b_of_type_JavaLangString == null)) {
          continue;
        }
        ((bhmr)localObject1).jdField_a_of_type_Boolean = true;
        return a(paramIntent, (bhmr)localObject1, str1, str2, (String)localObject4, (String)localObject2);
        localObject5 = localObject7;
        localObject1 = localObject4;
        QLog.i("JumpAction", 1, "-->onCreate getCallingActivity returns null!");
        localObject2 = localObject4;
        continue;
        localObject5 = localObject4;
        localObject1 = localObject2;
        localObject4 = ((String)localObject4).toLowerCase();
        localObject6 = localObject2;
      }
      i += 1;
      localObject1 = localObject2;
    }
    paramIntent = getIntent().getStringExtra("action");
    if (paramIntent == null)
    {
      finish();
      return false;
    }
    this.e = getIntent().getBooleanExtra("doCallBack", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("src_type");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("callback_type");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("callback_name");
    if ("photo".equals(paramIntent))
    {
      this.jdField_c_of_type_Boolean = true;
      if (!this.jdField_c_of_type_Boolean) {
        break label701;
      }
    }
    for (;;)
    {
      return false;
      if (!"select_location".equals(paramIntent)) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      break;
      label701:
      if (this.jdField_d_of_type_Boolean) {
        r();
      }
    }
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
        bmlc.a(this, 2131697456, 1);
      }
      for (;;)
      {
        finish();
        return;
        if (i != 0) {
          bmlc.a(this, 2131697452, 1);
        }
      }
    }
    a(localIntent, 0);
  }
  
  private boolean d(Intent paramIntent)
  {
    if (("com.tencent.apollo.SHORT_CUT".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("jump_cm_game", false)))
    {
      if (!this.app.isLogin())
      {
        paramIntent = new Intent();
        paramIntent.setClass(this, LoginActivity.class);
        paramIntent.addFlags(67371008);
        startActivity(paramIntent);
        finish();
        return false;
      }
      if (paramIntent.getBooleanExtra("jump_game_city", false))
      {
        ApolloGameUtil.a(this.app, new aeul(this, 0, null));
        return false;
      }
      if (paramIntent.getBooleanExtra("jump_cm_game", false))
      {
        int i = paramIntent.getIntExtra("jump_cm_game_id", -1);
        paramIntent = paramIntent.getStringExtra("jump_cm_extendinfo");
        ApolloGameUtil.a(this.app, new aeul(this, i, paramIntent));
        return false;
      }
    }
    if (("android.intent.action.VIEW".equals(paramIntent.getAction())) && (paramIntent.getIntExtra("MINI_CONFIG_SCENE", -1) > 0) && (!TextUtils.isEmpty(paramIntent.getStringExtra("CONFIG_APPID"))))
    {
      a(true);
      return false;
    }
    if ("from_nearby_pb".equals(paramIntent.getStringExtra("from")))
    {
      try
      {
        paramIntent = paramIntent.getDataString();
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramIntent = bhni.a(this.app, this, paramIntent);
          if (paramIntent != null) {
            paramIntent.k();
          }
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby", 2, "nearby_pb|exception:" + paramIntent.toString());
          }
        }
      }
      finish();
      return false;
    }
    if ("from_gesturemgr_download".equals(paramIntent.getAction()))
    {
      finish();
      return false;
    }
    if ("from_qavgpsomgr_download".equals(paramIntent.getAction()))
    {
      lmk.a();
      finish();
      return false;
    }
    if ("from_webtool_launchshortvideo".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getExtras();
      zmq.a().b(this, paramIntent);
      finish();
      return false;
    }
    if (("android.intent.action.SEND".equals(paramIntent.getAction())) || ("android.intent.action.SEND_MULTIPLE".equals(paramIntent.getAction())))
    {
      c(true);
      return false;
    }
    if (("android.intent.action.VIEW".equals(paramIntent.getAction())) && (("file".equals(paramIntent.getScheme())) || ("content".equals(paramIntent.getScheme()))))
    {
      b(true);
      return false;
    }
    return true;
  }
  
  private boolean e(Intent paramIntent)
  {
    if (a()) {
      return false;
    }
    if (("android.intent.action.SENDTO".equals(paramIntent.getAction())) && ("imto".equals(paramIntent.getScheme())))
    {
      c();
      return false;
    }
    Intent localIntent;
    if ("thridapp".equals(paramIntent.getStringExtra("share_from")))
    {
      if (!aarg.a().a(String.valueOf(Long.valueOf(paramIntent.getLongExtra("req_share_id", 0L)))))
      {
        super.finish();
        return false;
      }
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(agej.a(localIntent, null));
      return false;
    }
    if ((("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_qlink_shortcut", false))) || (paramIntent.getBooleanExtra("_goto_qlink_when_login_suc_", false)))
    {
      f(paramIntent);
      return false;
    }
    if (("com.tencent.qreader.SHORT_CUT".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("is_from_qreader_shortcut", false)))
    {
      a(paramIntent);
      return false;
    }
    if ("com.tencent.qqcomic.SHORT_CUT".equals(paramIntent.getAction()))
    {
      b(paramIntent);
      return false;
    }
    if ((("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_qfile_shortcut", false))) || (paramIntent.getBooleanExtra("_goto_qfile_when_login_suc_", false)))
    {
      c(paramIntent);
      return false;
    }
    if ("com.tencent.smartdevice.SHORT_CUT".equals(paramIntent.getAction()))
    {
      d(paramIntent);
      return false;
    }
    if ("kandianugc".equals(paramIntent.getScheme()))
    {
      h(paramIntent);
      finish();
      return false;
    }
    if (("android.intent.action.MAIN".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("_is_from_kandian_shortcut", false)))
    {
      paramIntent.addFlags(524288);
      paramIntent.addFlags(134217728);
      paramIntent.putExtra("url", "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/bundle_feeds.js");
      paramIntent.putExtra(tdl.jdField_a_of_type_JavaLangString, "QQ看点");
      PublicFragmentActivity.a(getActivity(), paramIntent, ViolaFragment.class);
      getActivity().overridePendingTransition(2130771997, 0);
      finish();
      return false;
    }
    if ("mqqdatamigration".equals(paramIntent.getScheme()))
    {
      localIntent = new Intent(this, DataMigrationService.class);
      localIntent.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
      localIntent.putExtras(paramIntent);
      try
      {
        startService(localIntent);
        finish();
        return false;
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          QLog.e("JumpAction", 1, "mqqdatamigration", paramIntent);
        }
      }
    }
    return true;
  }
  
  private boolean f(Intent paramIntent)
  {
    if ("mqqaudioassistant".equals(paramIntent.getScheme()))
    {
      QLog.d("JumpAction", 1, "get mqqaudioassistant Jump");
      Object localObject1 = paramIntent.getData();
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((Uri)localObject1).getQueryParameter("jumpaction");
        QLog.d("JumpAction", 1, String.format("mqqaudioassistant Jump args host = %s, \nPath = %s, \ntype = %s \nEXTRA_TEXT = %s", new Object[] { ((Uri)localObject1).getHost(), ((Uri)localObject1).getPath(), ((Uri)localObject1).getQueryParameter("type"), paramIntent.getStringExtra("android.intent.extra.TEXT") }));
        Object localObject2 = (bann)this.app.getManager(352);
        localObject1 = ((Uri)localObject1).getHost();
        if (((bann)localObject2).a((String)localObject1))
        {
          localObject2 = ((bann)localObject2).a((String)localObject3);
          if (localObject2 != null)
          {
            if (((banj)localObject2).jdField_a_of_type_JavaUtilHashMap.size() > 0)
            {
              localObject3 = ((banj)localObject2).jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
              while (((Iterator)localObject3).hasNext())
              {
                String str1 = (String)((Iterator)localObject3).next();
                if (paramIntent.hasExtra(str1))
                {
                  String str2 = paramIntent.getStringExtra(str1);
                  if (!bhsr.a(str2)) {
                    ((banj)localObject2).jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
                  }
                }
              }
            }
            ((banj)localObject2).g = ((String)localObject1);
            ((banj)localObject2).a(this);
          }
        }
      }
      for (;;)
      {
        finish();
        return false;
        banl.a((String)localObject1, (String)localObject3, 2);
        QLog.d("JumpAction", 1, "mqqaudioassistant Jump item = null");
        continue;
        banl.a((String)localObject1, "", 1);
        continue;
        banl.a("", "", 101);
      }
    }
    if (("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) || ("com.tencent.mobileqq.action.buscard".equals(paramIntent.getAction())))
    {
      e(paramIntent);
      return false;
    }
    if ("com.tencent.security.VERIFY_WEB".equals(paramIntent.getAction()))
    {
      i(paramIntent);
      return false;
    }
    return true;
  }
  
  public static void g(Intent paramIntent)
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
        localObject = bdmc.a(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("URL", str);
        ((bdmc)localObject).a("", "JA_ILLEGAL", true, 0L, 0L, localHashMap, "");
        paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
      }
    }
  }
  
  private boolean g(Intent paramIntent)
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
      bool = avpx.a(paramIntent, this);
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
  
  private void j(Intent paramIntent)
  {
    Intent localIntent = new Intent(this, QRBridgeActivity.class);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
    finish();
  }
  
  private void k(Intent paramIntent)
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
  
  private static void l(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "reportJumpArguments action=" + str + "; data=" + paramIntent);
    }
    bdmc localbdmc = bdmc.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", str);
    localHashMap.put("data", paramIntent);
    localbdmc.a("", "JA_ARGUMENTS", true, 0L, 0L, localHashMap, "");
  }
  
  private void p()
  {
    aunj.a(this);
    aunh.a("0X8005533");
    finish();
  }
  
  private void q()
  {
    Object localObject2 = bhnh.a(this);
    Object localObject1 = new StringBuilder();
    if ((localObject2 != null) && (!((HashSet)localObject2).isEmpty()))
    {
      localObject2 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append("|");
        }
        ((StringBuilder)localObject1).append(str);
      }
    }
    int j = 5;
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!((String)localObject1).contains("com.tencent.mm")) {
        break label140;
      }
      i = 1;
    }
    for (;;)
    {
      bdll.b(this.app, "dc00898", "", "", "0X800B008", "0X800B008", i, 0, "", "", "", "");
      return;
      label140:
      if (((String)localObject1).contains("com.alibaba.android.rimet"))
      {
        i = 2;
      }
      else if (((String)localObject1).contains("com.tencent.wework"))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (((String)localObject1).contains("com.ss.android.lark.lite")) {
          i = 4;
        }
      }
    }
  }
  
  private void r()
  {
    try
    {
      if (this.jdField_a_of_type_Aofl == null) {
        this.jdField_a_of_type_Aofl = new aofl(this.app.getAccount());
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
  
  private void s()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  private static void t()
  {
    a(BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
  }
  
  private void u()
  {
    try
    {
      setContentView(2131561248);
      this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)findViewById(2131369490));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, localThrowable, new Object[0]);
    }
  }
  
  protected int a(Bundle paramBundle)
  {
    try
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|beg");
      Uri localUri = (Uri)paramBundle.getParcelable("android.intent.extra.STREAM");
      if ((localUri != null) && ("file".equals(localUri.getScheme())) && (localUri.getPath().startsWith("/storage"))) {
        return 4;
      }
      String str1 = paramBundle.getString("android.intent.extra.TITLE");
      String str2 = paramBundle.getString("android.intent.extra.TEXT");
      String str3 = getIntent().getType();
      if (TextUtils.isEmpty(str3))
      {
        QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|type null");
        return 1;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_type", "app");
      localHashMap.put("version", "1");
      localHashMap.put("cflag", bhkv.encodeToString("1".getBytes(), 0));
      if (TextUtils.isEmpty(str1)) {}
      for (str1 = "";; str1 = bhkv.encodeToString(str1.getBytes(), 0))
      {
        localHashMap.put("title", str1);
        if (!str3.startsWith("text")) {
          break;
        }
        return a(paramBundle, localHashMap, localUri, str2);
      }
      if (str3.startsWith("image")) {
        return a(paramBundle, localHashMap);
      }
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|unknown type. type=" + str3);
      return 1;
    }
    catch (OutOfMemoryError paramBundle)
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|outofmemoryerror");
    }
    return 1;
  }
  
  public int a(Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("req_type", bhkv.encodeToString("5".getBytes(), 0));
    if (getIntent().getAction().equals("android.intent.action.SEND"))
    {
      paramBundle = paramBundle.get("android.intent.extra.STREAM");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
        }
        return 1;
      }
      if ((paramBundle instanceof Uri)) {
        paramBundle = (Uri)paramBundle;
      }
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        return 1;
        if ((paramBundle instanceof String)) {
          paramBundle = Uri.parse((String)paramBundle);
        }
      }
      else
      {
        paramBundle = ForwardFileOption.a(this, paramBundle);
        if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + paramBundle);
          }
          return 1;
        }
        for (;;)
        {
          String str1;
          try
          {
            str1 = URLEncoder.encode(paramBundle, "UTF-8");
            paramHashMap.put("file_data", bhkv.encodeToString(str1.getBytes(), 0));
            return a(paramHashMap);
          }
          catch (UnsupportedEncodingException paramHashMap)
          {
            if (QLog.isColorLevel()) {
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|encode fail. path=" + paramBundle + ",exp:" + paramHashMap.getMessage());
            }
            return 1;
          }
          try
          {
            paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
            if (paramBundle == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
              }
              return 1;
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
              paramBundle = null;
            }
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            for (;;)
            {
              if (i < paramBundle.size())
              {
                str1 = ForwardFileOption.a(this, (Uri)paramBundle.get(i));
                if ((!TextUtils.isEmpty(str1)) && (new File(str1).exists())) {}
                try
                {
                  localArrayList.add(URLEncoder.encode(str1, "UTF-8"));
                  i += 1;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + localUnsupportedEncodingException.getMessage());
                    }
                  }
                }
              }
            }
            if (localArrayList.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
              }
              return 1;
            }
            paramBundle = "";
            i = 0;
            while (i < localArrayList.size())
            {
              String str2 = paramBundle + (String)localArrayList.get(i);
              paramBundle = str2;
              if (i != localArrayList.size() - 1) {
                paramBundle = str2 + ";";
              }
              i += 1;
            }
            paramHashMap.put("file_data", bhkv.encodeToString(paramBundle.getBytes(), 0));
          }
        }
      }
      paramBundle = null;
    }
  }
  
  /* Error */
  public int a(Bundle paramBundle, HashMap<String, String> paramHashMap, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 6
    //   6: aload_1
    //   7: ldc_w 1375
    //   10: invokevirtual 1600	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   13: ifne +64 -> 77
    //   16: aload_2
    //   17: ldc_w 1544
    //   20: ldc_w 1602
    //   23: invokevirtual 1522	java/lang/String:getBytes	()[B
    //   26: iconst_0
    //   27: invokestatic 1526	bhkv:encodeToString	([BI)Ljava/lang/String;
    //   30: invokevirtual 691	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload 4
    //   36: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +25 -> 64
    //   42: ldc 81
    //   44: astore_1
    //   45: aload_2
    //   46: ldc_w 1604
    //   49: aload_1
    //   50: invokevirtual 691	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 1565	com/tencent/mobileqq/activity/JumpActivity:a	(Ljava/util/HashMap;)I
    //   59: istore 5
    //   61: iload 5
    //   63: ireturn
    //   64: aload 4
    //   66: invokevirtual 1522	java/lang/String:getBytes	()[B
    //   69: iconst_0
    //   70: invokestatic 1526	bhkv:encodeToString	([BI)Ljava/lang/String;
    //   73: astore_1
    //   74: goto -29 -> 45
    //   77: aload_3
    //   78: ifnull -24 -> 54
    //   81: aload_0
    //   82: invokespecial 1608	com/tencent/mobileqq/app/BaseActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   85: aload_3
    //   86: invokevirtual 1614	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   89: astore_1
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 1616	com/tencent/mobileqq/activity/JumpActivity:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   95: astore_3
    //   96: aload_1
    //   97: invokevirtual 1617	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +80 -> 184
    //   107: iload 6
    //   109: istore 5
    //   111: invokestatic 394	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -53 -> 61
    //   117: ldc_w 1499
    //   120: iconst_2
    //   121: ldc_w 1619
    //   124: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_1
    //   130: aload 7
    //   132: astore_2
    //   133: ldc_w 1499
    //   136: iconst_1
    //   137: new 154	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 1621
    //   147: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 1622	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iload 6
    //   165: istore 5
    //   167: aload_2
    //   168: ifnull -107 -> 61
    //   171: aload_2
    //   172: invokevirtual 1617	java/io/InputStream:close	()V
    //   175: iconst_1
    //   176: ireturn
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 1623	java/io/IOException:printStackTrace	()V
    //   182: iconst_1
    //   183: ireturn
    //   184: aload_2
    //   185: ldc_w 1544
    //   188: ldc_w 1602
    //   191: invokevirtual 1522	java/lang/String:getBytes	()[B
    //   194: iconst_0
    //   195: invokestatic 1526	bhkv:encodeToString	([BI)Ljava/lang/String;
    //   198: invokevirtual 691	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_3
    //   203: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifeq +18 -> 224
    //   209: ldc 81
    //   211: astore_1
    //   212: aload_2
    //   213: ldc_w 1604
    //   216: aload_1
    //   217: invokevirtual 691	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: goto -167 -> 54
    //   224: aload_3
    //   225: invokevirtual 1522	java/lang/String:getBytes	()[B
    //   228: iconst_0
    //   229: invokestatic 1526	bhkv:encodeToString	([BI)Ljava/lang/String;
    //   232: astore_1
    //   233: goto -21 -> 212
    //   236: astore_3
    //   237: aload_1
    //   238: astore_2
    //   239: aload_3
    //   240: astore_1
    //   241: goto -108 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	JumpActivity
    //   0	244	1	paramBundle	Bundle
    //   0	244	2	paramHashMap	HashMap<String, String>
    //   0	244	3	paramUri	Uri
    //   0	244	4	paramString	String
    //   59	107	5	i	int
    //   4	160	6	j	int
    //   1	130	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   81	90	129	java/lang/Exception
    //   100	107	129	java/lang/Exception
    //   111	127	129	java/lang/Exception
    //   184	209	129	java/lang/Exception
    //   212	221	129	java/lang/Exception
    //   224	233	129	java/lang/Exception
    //   171	175	177	java/io/IOException
    //   90	100	236	java/lang/Exception
  }
  
  public int a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      QLog.e("qqfav|QfavJumpActivity", 1, "qqFavDoAction error: params are null");
      return 1;
    }
    StringBuilder localStringBuilder = new StringBuilder("mqqapi://share/to_qqfav?");
    Set localSet = paramHashMap.keySet();
    Iterator localIterator = localSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramHashMap.get(str));
      if (i != localSet.size() - 1) {
        localStringBuilder.append("&");
      }
      i += 1;
    }
    paramHashMap = bhni.a(this.app, this, localStringBuilder.toString());
    if (paramHashMap == null)
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|jump parse fail");
      return 1;
    }
    paramHashMap.a();
    QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|end");
    return 0;
  }
  
  public aeuk a(int paramInt)
  {
    QLog.d("JumpAction", 1, "createPlugin pluginKey: " + paramInt);
    switch (paramInt)
    {
    default: 
      QLog.d("JumpAction", 1, "createPlugin pluginKey: " + paramInt + " not match");
      return null;
    case 800: 
    case 880: 
      return new aeuq(this);
    case 18: 
      return new aeun(this);
    case 19: 
      return new aeur(this);
    case 20: 
      return new aeva(this);
    case 21: 
      return new aevc(this);
    case 22: 
      return new aevb(this);
    case 26: 
      return new aeuz(this);
    case 27: 
      return new aeuy(this);
    case 24: 
      return new aeuo(this);
    case 1: 
      return new aeup(this);
    case 2: 
      return new aeux(this);
    case 571: 
      return new aeuv(this);
    case 572: 
      return new aeuu(this);
    case 25: 
      return new aevd(this);
    case 570: 
      return new aeut(this);
    }
    return new aeuw(this);
  }
  
  @NotNull
  public Boolean a()
  {
    return QSecFramework.a().a(1003);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aeuf(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Aofl != null) {
      this.jdField_a_of_type_Aofl = null;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getExtras();
    }
    if (localObject != null)
    {
      paramIntent = ((Bundle)localObject).getString("latitude");
      localObject = ((Bundle)localObject).getString("longitude");
      if (this.e) {
        a("ret=0&lon=" + (String)localObject + "&lat=" + paramIntent);
      }
      finish();
    }
  }
  
  void a(Intent paramIntent)
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
    j(paramIntent);
  }
  
  void a(Bundle paramBundle)
  {
    new JumpActivity.5(this, paramBundle).run();
  }
  
  public void a(DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    asuz localasuz = asuz.a();
    if ((localasuz != null) && (localasuz.a() == asuz.c))
    {
      localIntent = new Intent();
      localIntent.setAction("mqq.intent.action.DEVLOCK_ROAM");
      if (paramDevlockInfo != null) {
        if (paramDevlockInfo.DevSetup == 1)
        {
          localIntent.putExtra("auth_dev_open", bool1);
          localIntent.putExtra("guardphone_state", localasuz.a());
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
  
  void a(boolean paramBoolean)
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
          aqre.a(false, 0);
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
        a(getIntent().getExtras());
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
  
  void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
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
      localObject = bhni.a(this.app, this, (String)localObject);
      ((bhmr)localObject).b(paramString);
      ((bhmr)localObject).c(this.jdField_d_of_type_JavaLangString);
    } while (!((bhmr)localObject).a());
    finish();
  }
  
  public boolean a()
  {
    try
    {
      if (!bhnh.a(this, true))
      {
        super.finish();
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  protected boolean a(Intent paramIntent)
  {
    return (b(paramIntent)) && (c(paramIntent));
  }
  
  boolean a(bhmr parambhmr)
  {
    if ((parambhmr == null) || (parambhmr.jdField_a_of_type_JavaUtilHashMap == null)) {}
    while (!MiniProgramOpenSdkUtil.asyncShareMiniProgram(parambhmr)) {
      return false;
    }
    return this.app.isLogin();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aeug(this);
      IntentFilter localIntentFilter = new IntentFilter("BroadcastReceiverFinishActivity");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        aeuj localaeuj = new aeuj(this);
        if (ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, localaeuj, null)) {
          finish();
        }
      }
      return;
    }
    finish();
  }
  
  void b(Intent paramIntent)
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
    k(paramIntent);
  }
  
  void b(boolean paramBoolean)
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
  
  void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
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
    localObject = bhni.a(this.app, this, (String)localObject);
    ((bhmr)localObject).b(paramString);
    ((bhmr)localObject).a();
    finish();
  }
  
  boolean b(bhmr parambhmr)
  {
    if (parambhmr == null) {}
    String str2;
    String str1;
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(parambhmr.b("share_id")));
      str2 = parambhmr.b("req_type");
      str1 = parambhmr.b("cflag");
    } while (TextUtils.isEmpty(str2));
    for (;;)
    {
      for (;;)
      {
        try
        {
          str2 = a(str2);
          if (TextUtils.isEmpty(str2)) {
            break label203;
          }
          i = Integer.valueOf(str2).intValue();
          if (((i == 3) || (i == 4)) && ("qzone".equals(parambhmr.jdField_b_of_type_JavaLangString)) && ("publish".equals(parambhmr.jdField_c_of_type_JavaLangString)))
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
          parambhmr = a(str1);
          if (!TextUtils.isEmpty(parambhmr))
          {
            j = Integer.valueOf(parambhmr).intValue();
            if ((i != 5) || ((j & 0x1) == 0)) {
              break;
            }
            QLog.i("JumpAction", 1, "SharePictureToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException parambhmr)
        {
          for (;;)
          {
            QLog.d("JumpAction", 1, "needToStartQZoneProcess catch NumberFormatException. ", parambhmr);
            int j = 0;
          }
        }
      }
      label203:
      int i = 1;
    }
  }
  
  void c()
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
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(true, paramIntent);
  }
  
  void c(Intent paramIntent)
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
    p();
  }
  
  void c(boolean paramBoolean)
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
    bdmc.a(BaseApplication.getContext()).a("", "noSDPermissionShare", true, 0L, 0L, localHashMap, "");
    boolean bool = g(localIntent);
    QLog.d("JumpAction", 1, new Object[] { "system share.doShare needGrantSDPermission=", Boolean.valueOf(bool) });
    if ((bool) && (Build.VERSION.SDK_INT >= 23))
    {
      apdr.a(this, 3, new aeuh(this, paramBoolean));
      return;
    }
    d(paramBoolean);
  }
  
  public void d()
  {
    if (this.e) {
      a("HexUtil.bytes2HexStr(fileKey)");
    }
    finish();
  }
  
  public void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new JumpActivity.9(this, paramIntent), 10L);
  }
  
  void d(Intent paramIntent)
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
    b(paramIntent.getExtras());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.toString();
      QLog.d("JumpAction", 1, (String)localObject);
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break label147;
      }
    }
    label147:
    do
    {
      try
      {
        localObject = a(paramInt1);
        if (localObject == null)
        {
          QLog.e("JumpAction", 1, "doOnActivityResult: result plugin not exist");
          finish();
          return;
          localObject = "null";
          break;
        }
        ((aeuk)localObject).a(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("JumpAction", 1, "doOnActivityResult error: " + paramIntent.getMessage());
        return;
      }
      if (paramInt1 == 25)
      {
        a(false, paramIntent);
        return;
      }
    } while (paramInt1 == 23);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    getWindow().addFlags(67108864);
    try
    {
      super.doOnCreate(paramBundle);
      QLog.d("JumpAction", 1, "JumpActivity doOnCreate()");
      paramBundle = getIntent();
      if (paramBundle == null)
      {
        QLog.d("JumpAction", 1, "onCreate intent is null");
        finish();
        return false;
      }
      l(paramBundle);
      this.jdField_a_of_type_Bhnk = new bhnk();
      this.jdField_a_of_type_Bhnk.a(this.app, this, paramBundle);
      boolean bool = a(paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      QLog.e("JumpAction", 1, "doOnCreate|exp:" + paramBundle.getMessage());
      finish();
    }
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
    s();
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_Bhnk != null)
    {
      this.jdField_a_of_type_Bhnk.a(null);
      this.jdField_a_of_type_Bhnk = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.f) {
      finish();
    }
  }
  
  public void e()
  {
    c(false);
  }
  
  void e(Intent paramIntent)
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
  
  public void f()
  {
    b(false);
  }
  
  void f(Intent paramIntent)
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
    bmim.a(this, 7, null);
    finish();
  }
  
  public void g()
  {
    b(false, null, true);
  }
  
  public void h()
  {
    b(true, null, false);
  }
  
  void h(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getData();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new String(bhkv.decode(((Uri)localObject2).getQueryParameter("param"), 0));
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
      pfa.a().a(paramIntent, this.app.c());
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
      s();
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      if ((paramMessage.obj instanceof Intent))
      {
        int i = paramMessage.arg1;
        Intent localIntent = (Intent)paramMessage.obj;
        s();
        if (i == 0)
        {
          if (!a()) {
            a(localIntent.getExtras());
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
  
  public void i()
  {
    a(false, null, true);
  }
  
  void i(Intent paramIntent)
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
  
  public void j()
  {
    a(true, null, false);
  }
  
  public void k()
  {
    a(false);
  }
  
  public void l()
  {
    finish();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      j(this.jdField_a_of_type_AndroidContentIntent);
    }
    finish();
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_AndroidContentIntent != null) {
      k(this.jdField_b_of_type_AndroidContentIntent);
    }
    finish();
  }
  
  public void o()
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new JumpActivity.8(this), 10L);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
        boolean bool = bhnh.a(this);
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
    if (this.jdField_a_of_type_Bhnk != null)
    {
      this.jdField_a_of_type_Bhnk.a(paramIntent);
      this.jdField_a_of_type_Bhnk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */