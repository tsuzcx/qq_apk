package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.gameplay.QavGPDownloadManager;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.comic.VipComicJumpActivity;
import cooperation.dingdong.DingdongPluginNotificationUtil;
import cooperation.jtcode.JtcodeHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavUtil;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tat;
import tau;
import tav;
import taw;
import tax;
import tay;
import taz;

public class JumpActivity
  extends BaseActivity
{
  private static int jdField_a_of_type_Int = -1;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static boolean a;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "mqq", "mqqapi", "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", "qqwifi", "mqqconnect", "qqstory", "mqqconferenceflyticket" };
  private static volatile boolean f;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  private String jdField_a_of_type_JavaLangString;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new tat(this);
  private Intent jdField_b_of_type_AndroidContentIntent;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
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
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new tau(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    String str = paramIntent.getDataString();
    if ((paramIntent.getComponent() == null) && (!TextUtils.isEmpty(str)))
    {
      Object localObject = Uri.parse(str).getScheme();
      if ((a((String)localObject)) && (b((String)localObject)))
      {
        localObject = StatisticCollector.a(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("URL", str);
        ((StatisticCollector)localObject).a("", "JA_ILLEGAL", true, 0L, 0L, localHashMap, "");
        paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
      }
    }
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    new tav(this, paramIntent, paramBundle).run();
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
          break label51;
        }
        SmartDeviceUtil.a(this.app, this, null, "http://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html?from=2", null);
      }
    }
    for (;;)
    {
      finish();
      return;
      label51:
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.app.a(51);
      DeviceInfo localDeviceInfo = localSmartDeviceProxyMgr.a(Long.parseLong((String)localObject));
      if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din))))
      {
        localSmartDeviceProxyMgr.a(this, localDeviceInfo, false, null);
      }
      else if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramBundle);
        ((Intent)localObject).putExtra("title", "正在跳转");
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("selfSet_leftViewText", "返回");
        ((Intent)localObject).putExtra("leftViewText", "返回");
        startActivity((Intent)localObject);
      }
      else
      {
        ToastUtil.a().a("设备信息为空，请确保设备已经绑定成功");
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
          QLog.d("JumpAction", 2, "initJASwitch with " + paramString + " inited=" + f);
        }
        boolean bool = f;
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
      f = true;
    }
  }
  
  private void a(boolean paramBoolean)
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
    a(localIntent, (Bundle)localObject1);
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
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
    localObject = JumpParser.a(this.app, this, (String)localObject);
    ((JumpAction)localObject).a(paramString);
    ((JumpAction)localObject).b();
    finish();
  }
  
  private boolean a(JumpAction paramJumpAction)
  {
    if (paramJumpAction == null) {}
    String str2;
    String str1;
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramJumpAction.a("share_id")));
      str2 = paramJumpAction.a("req_type");
      str1 = paramJumpAction.a("cflag");
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
          if (((i == 3) || (i == 4)) && ("qzone".equals(paramJumpAction.jdField_b_of_type_JavaLangString)) && ("publish".equals(paramJumpAction.jdField_c_of_type_JavaLangString)))
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
          paramJumpAction = a(str1);
          if (!TextUtils.isEmpty(paramJumpAction))
          {
            j = Integer.valueOf(paramJumpAction).intValue();
            if ((i != 5) || ((j & 0x1) == 0)) {
              break;
            }
            QLog.i("JumpAction", 1, "SharePictureToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException paramJumpAction)
        {
          for (;;)
          {
            QLog.d("JumpAction", 1, "needToStartQZoneProcess catch NumberFormatException. ", paramJumpAction);
            int j = 0;
          }
        }
      }
      label207:
      int i = 1;
    }
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
        if (!f) {
          e();
        }
      }
      return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
    }
    finally {}
  }
  
  private void b()
  {
    FileManagerUtil.a(this);
    FileManagerReporter.a("0X8005533");
    finish();
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
    new taw(this, paramBundle).run();
  }
  
  private void b(boolean paramBoolean)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      Intent localIntent = new Intent(this, LoginActivity.class);
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
        QfavUtil.a(this, 2131431689, 1);
      }
      for (;;)
      {
        finish();
        return;
        if (i != 0) {
          QfavUtil.a(this, 2131431690, 1);
        }
      }
    }
    b(localBundle);
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
    String str1 = getPackageName();
    String str2 = InstallActivity.class.getName();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(str1, str2));
    startActivity(localIntent);
    finish();
  }
  
  private void c(Intent paramIntent)
  {
    Intent localIntent = new Intent(this, QRBridgeActivity.class);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.app.getAccount());
      }
      startActivityForResult(new Intent(this, QQMapActivity.class).putExtra("uin", this.app.getAccount()), 18);
      return;
    }
    catch (Exception localException)
    {
      if (this.d) {
        a("Google Map not exist");
      }
      finish();
    }
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
  
  private static void e()
  {
    a(BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
  }
  
  private void e(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("comicID");
      if ((!((String)localObject).equalsIgnoreCase("0")) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label57;
      }
    }
    label57:
    for (Object localObject = new Intent(this, VipComicJumpActivity.class);; localObject = new Intent(this, QQBrowserActivity.class))
    {
      ((Intent)localObject).putExtras(paramIntent);
      startActivity((Intent)localObject);
      finish();
      return;
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
    b();
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
  
  private void h(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (("com.tencent.mobileqq.action.buscard".equals(str)) || ("com.tencent.mobileqq.action.wlx.service".equals(str))) {
      BuscardHelper.a(this.mRuntime, paramIntent, str);
    }
    for (;;)
    {
      finish();
      return;
      if ("android.nfc.action.TECH_DISCOVERED".equals(str)) {
        BuscardHelper.a(this.app.getCurrentAccountUin(), getActivity(), paramIntent);
      } else if ("com.tencent.mobileqq.action.jtcode".equals(str)) {
        JtcodeHelper.a(this.app.getCurrentAccountUin(), getActivity(), paramIntent);
      }
    }
  }
  
  private void i(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
    if (!this.app.isLogin())
    {
      if (bool)
      {
        finish();
        return;
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QLINK_SHORTCUT_JUMP_KEY", paramIntent);
      startActivity(localIntent);
      finish();
      return;
    }
    QQProxyForQlink.a(this, 7, null);
    finish();
  }
  
  private static void j(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "reportJumpArguments action=" + str + "; data=" + paramIntent);
    }
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", str);
    localHashMap.put("data", paramIntent);
    localStatisticCollector.a("", "JA_ARGUMENTS", true, 0L, 0L, localHashMap, "");
  }
  
  private void k(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getData();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new String(Base64Util.decode(((Uri)localObject2).getQueryParameter("param"), 0));
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
      ReadInJoyLogicEngine.a().a(paramIntent, this.app.c());
    }
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
            break label1245;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|type null");
          break label1245;
        }
        localHashMap = new HashMap();
        localHashMap.put("src_type", "app");
        localHashMap.put("version", "1");
        localHashMap.put("cflag", Base64Util.encodeToString("1".getBytes(), 0));
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = "";
          localHashMap.put("title", localObject1);
          if (!str5.startsWith("text")) {
            break label599;
          }
          if (paramBundle.containsKey("android.intent.extra.STREAM")) {
            continue;
          }
          localHashMap.put("req_type", Base64Util.encodeToString("6".getBytes(), 0));
          if (TextUtils.isEmpty(str4))
          {
            paramBundle = "";
            localHashMap.put("description", paramBundle);
            paramBundle = new StringBuilder("mqqapi://share/to_qqfav?");
            localObject1 = localHashMap.keySet();
            localObject2 = ((Set)localObject1).iterator();
            i = 0;
            label309:
            if (!((Iterator)localObject2).hasNext()) {
              break label1176;
            }
            localObject3 = (String)((Iterator)localObject2).next();
            paramBundle.append((String)localObject3);
            paramBundle.append("=");
            paramBundle.append((String)localHashMap.get(localObject3));
            if (i == ((Set)localObject1).size() - 1) {
              break label1247;
            }
            paramBundle.append("&");
            break label1247;
          }
        }
        else
        {
          localObject1 = Base64Util.encodeToString(((String)localObject1).getBytes(), 0);
          continue;
        }
        paramBundle = Base64Util.encodeToString(str4.getBytes(), 0);
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
                break label1254;
              }
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|text, extra_stream, empty");
              break label1254;
            }
            localHashMap.put("req_type", Base64Util.encodeToString("6".getBytes(), 0));
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
            break label1258;
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
          paramBundle = Base64Util.encodeToString(localException1.getBytes(), 0);
        }
        catch (IOException paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        if (!str5.startsWith("image")) {
          break label1139;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|outofmemoryerror");
        }
        return 1;
      }
      label599:
      localHashMap.put("req_type", Base64Util.encodeToString("5".getBytes(), 0));
      if (getIntent().getAction().equals("android.intent.action.SEND"))
      {
        paramBundle = paramBundle.get("android.intent.extra.STREAM");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label1256;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
          break label1256;
        }
        if ((paramBundle instanceof Uri))
        {
          paramBundle = (Uri)paramBundle;
          break label1258;
        }
        if (!(paramBundle instanceof String)) {
          break label1240;
        }
        paramBundle = Uri.parse((String)paramBundle);
        break label1258;
        label709:
        paramBundle = ForwardFileOption.a(this, paramBundle);
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
          localHashMap.put("file_data", Base64Util.encodeToString(str1.getBytes(), 0));
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
          break label1264;
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
          str2 = ForwardFileOption.a(this, (Uri)paramBundle.get(i));
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
        break label1268;
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
        localHashMap.put("file_data", Base64Util.encodeToString(paramBundle.getBytes(), 0));
        break;
        label1139:
        if (!QLog.isColorLevel()) {
          break label1283;
        }
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|unknown type. type=" + str5);
        break label1283;
        label1176:
        paramBundle = JumpParser.a(this.app, this, paramBundle.toString());
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label1285;
          }
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|jump parse fail");
          break label1285;
        }
        paramBundle.b();
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|end");
        }
        return 0;
        label1240:
        label1245:
        return 1;
        label1247:
        i += 1;
        break label309;
        label1254:
        return 1;
        label1256:
        return 1;
        label1258:
        if (paramBundle != null) {
          break label709;
        }
        return 1;
        label1264:
        return 1;
        return 1;
        label1268:
        paramBundle = "";
        i = 0;
        continue;
      }
      i += 1;
    }
    label1283:
    return 1;
    label1285:
    return 1;
  }
  
  public void a(DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    DevlockPhoneStatus localDevlockPhoneStatus = DevlockPhoneStatus.a();
    if ((localDevlockPhoneStatus != null) && (localDevlockPhoneStatus.a() == DevlockPhoneStatus.c))
    {
      localIntent = new Intent();
      localIntent.setAction("mqq.intent.action.DEVLOCK_ROAM");
      if (paramDevlockInfo != null) {
        if (paramDevlockInfo.DevSetup == 1)
        {
          localIntent.putExtra("auth_dev_open", bool1);
          localIntent.putExtra("guardphone_state", localDevlockPhoneStatus.a());
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
      overridePendingTransition(2131034123, 2131034121);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        break label506;
      }
      switch (paramInt1)
      {
      }
    }
    label409:
    label506:
    while (paramInt1 == 23)
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
            if (this.d) {
              a("HexUtil.bytes2HexStr(fileKey)");
            }
            finish();
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
            }
            localObject1 = localObject2;
            if (paramIntent != null) {
              localObject1 = paramIntent.getExtras();
            }
          } while (localObject1 == null);
          paramIntent = ((Bundle)localObject1).getString("latitude");
          localObject1 = ((Bundle)localObject1).getString("longitude");
          if (this.d) {
            a("ret=0&lon=" + (String)localObject1 + "&lat=" + paramIntent);
          }
          finish();
          return;
          b(false);
          return;
          a(false);
          return;
          a(false, null, true);
          return;
          a(true, null, false);
          return;
          if ((-1 != paramInt2) || (paramIntent == null)) {
            break label409;
          }
          paramIntent = paramIntent.getStringExtra("roomId");
        } while (paramIntent == null);
        localObject1 = new tax(this);
      } while (!ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, (ChatActivityUtils.StartVideoListener)localObject1, null));
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
      new Handler().postDelayed(new tay(this), 10L);
      return;
      new Handler().postDelayed(new taz(this, paramIntent), 10L);
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject4;
    boolean bool;
    try
    {
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "JumpActivity doOnCreate()");
      }
      localObject4 = getIntent();
      j((Intent)localObject4);
      if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("jump_cm_game", false)))
      {
        i = ((Intent)localObject4).getIntExtra("jump_cm_game_id", -1);
        if (!this.app.isLogin())
        {
          paramBundle = new Intent();
          paramBundle.setClass(this, LoginActivity.class);
          paramBundle.addFlags(67371008);
          startActivity(paramBundle);
          finish();
          return false;
        }
        paramBundle = (ApolloManager)this.app.getManager(152);
        localObject1 = new CmGameStartChecker.StartCheckParam(i, true, "launch", 0L, 10, 0, 0, 0, "", 222);
        ((CmGameStartChecker.StartCheckParam)localObject1).version = paramBundle.a(i);
        ApolloGameUtil.a(this, (CmGameStartChecker.StartCheckParam)localObject1);
        this.e = true;
        return false;
      }
      if (localObject4 != null)
      {
        bool = "from_nearby_pb".equals(((Intent)localObject4).getStringExtra("from"));
        if (bool)
        {
          try
          {
            paramBundle = ((Intent)localObject4).getDataString();
            if (!TextUtils.isEmpty(paramBundle))
            {
              paramBundle = JumpParser.a(this.app, this, paramBundle);
              if (paramBundle != null) {
                paramBundle.a();
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
    if ((localObject4 != null) && ("from_gesturemgr_download".equals(((Intent)localObject4).getAction())))
    {
      finish();
      return false;
    }
    if ((localObject4 != null) && ("from_qavgpsomgr_download".equals(((Intent)localObject4).getAction())))
    {
      QavGPDownloadManager.a();
      finish();
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getAction())) && ((((Intent)localObject4).getAction().equals("android.intent.action.SEND")) || (((Intent)localObject4).getAction().equals("android.intent.action.SEND_MULTIPLE"))))
    {
      b(true);
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(((Intent)localObject4).getScheme())) && ((((Intent)localObject4).getScheme().equals("file")) || (((Intent)localObject4).getScheme().equals("content"))))
    {
      a(true);
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("android.intent.action.SENDTO")) && (!TextUtils.isEmpty(((Intent)localObject4).getScheme())) && (((Intent)localObject4).getScheme().equals("imto")))
    {
      c();
      return false;
    }
    if ((localObject4 != null) && ("thridapp".equals(((Intent)localObject4).getStringExtra("share_from"))))
    {
      if (!ThridAppShareHelper.a().a(String.valueOf(Long.valueOf(((Intent)localObject4).getLongExtra("req_share_id", 0L)))))
      {
        super.finish();
        return false;
      }
      paramBundle = new Intent(this, SplashActivity.class);
      paramBundle.putExtras(((Intent)localObject4).getExtras());
      startActivity(AIOUtils.a(paramBundle, null));
      return false;
    }
    if ((localObject4 != null) && (((!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("android.intent.action.MAIN")) && (((Intent)localObject4).getBooleanExtra("_is_from_qlink_shortcut", false))) || (((Intent)localObject4).getBooleanExtra("_goto_qlink_when_login_suc_", false))))
    {
      i((Intent)localObject4);
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("com.tencent.qreader.SHORT_CUT")) && (((Intent)localObject4).getBooleanExtra("is_from_qreader_shortcut", false)))
    {
      b((Intent)localObject4);
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("com.tencent.qqcomic.SHORT_CUT")))
    {
      d((Intent)localObject4);
      return false;
    }
    if ((localObject4 != null) && (((!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("android.intent.action.MAIN")) && (((Intent)localObject4).getBooleanExtra("_is_from_qfile_shortcut", false))) || (((Intent)localObject4).getBooleanExtra("_goto_qfile_when_login_suc_", false))))
    {
      f((Intent)localObject4);
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getAction())) && (((Intent)localObject4).getAction().equals("com.tencent.smartdevice.SHORT_CUT")))
    {
      g((Intent)localObject4);
      return false;
    }
    if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("_dingdong_notification_schedule_has_flag_", false)))
    {
      DingdongPluginNotificationUtil.a(this, (Intent)localObject4);
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getScheme())) && (((Intent)localObject4).getScheme().equals("kandianugc")))
    {
      k((Intent)localObject4);
      finish();
      return false;
    }
    if ((localObject4 != null) && (!TextUtils.isEmpty(((Intent)localObject4).getScheme())) && (((Intent)localObject4).getScheme().equals("mqqdatamigration")))
    {
      paramBundle = new Intent(this, DataMigrationService.class);
      paramBundle.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
      paramBundle.putExtras((Intent)localObject4);
      startService(paramBundle);
      finish();
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 10) && (localObject4 != null))
    {
      paramBundle = ((Intent)localObject4).getAction();
      if (("android.nfc.action.TECH_DISCOVERED".equals(paramBundle)) || ("com.tencent.mobileqq.action.buscard".equals(paramBundle)) || ("com.tencent.mobileqq.action.jtcode".equals(paramBundle)) || ("com.tencent.mobileqq.action.wlx.service".equals(paramBundle)))
      {
        h((Intent)localObject4);
        return false;
      }
    }
    String str1 = getIntent().getDataString();
    String str2 = getIntent().getStringExtra("from");
    paramBundle = null;
    int i = 0;
    Object localObject1 = paramBundle;
    if (i < 3) {}
    Object localObject3;
    try
    {
      localObject3 = super.getCallingPackage();
      localObject1 = localObject3;
      paramBundle = (Bundle)localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramBundle = (Bundle)localObject3;
        QLog.i("JumpAction", 1, "-->onCreate getCallingPackage returns null!");
        paramBundle = (Bundle)localObject3;
        localObject1 = super.getCallingActivity();
        if (localObject1 == null) {
          break label1484;
        }
        paramBundle = (Bundle)localObject3;
        localObject3 = ((ComponentName)localObject1).getPackageName();
        localObject1 = localObject3;
        paramBundle = (Bundle)localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          paramBundle = (Bundle)localObject3;
          QLog.i("JumpAction", 1, "-->onCreate get package from activity returns null!");
          localObject1 = localObject3;
        }
      }
      label1208:
      paramBundle = (Bundle)localObject1;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool) {
        break label1512;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = paramBundle;
      }
      i += 1;
      paramBundle = (Bundle)localObject2;
    }
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = getIntent().getStringExtra("pkg_name");
      localObject1 = StatisticCollector.a(BaseApplication.getContext());
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("osVersion", Build.VERSION.RELEASE);
      ((HashMap)localObject3).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      ((StatisticCollector)localObject1).a("", "GetCallingPackageEmpty", true, 0L, 0L, (HashMap)localObject3, "");
    }
    if (str1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "jump url:" + str1);
      }
      localObject3 = JumpParser.a(this.app, this, str1);
      if (("webview".equals(str2)) && (localObject3 != null)) {
        ((JumpAction)localObject3).a(str2);
      }
      if (localObject3 != null)
      {
        ((JumpAction)localObject3).jdField_a_of_type_Boolean = true;
        if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("puzzle_verify_code")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null))
        {
          paramBundle = new Intent(getIntent());
          if (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("PUZZLEVERIFYCODE")) {
            paramBundle.setClass(this, QQBrowserActivity.class);
          }
          for (;;)
          {
            super.startActivity(paramBundle);
            super.finish();
            return false;
            label1484:
            paramBundle = (Bundle)localObject3;
            QLog.i("JumpAction", 1, "-->onCreate getCallingActivity returns null!");
            localObject1 = localObject3;
            break label1208;
            label1512:
            break;
            if (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("VERIFYCODE")) {
              paramBundle.setClass(this, VerifyCodeActivity.class);
            } else if (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("DEVLOCK_CODE")) {
              paramBundle.setClass(this, AuthDevUgActivity.class);
            }
          }
        }
        bool = true;
        if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("ptlogin")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("qlogin"))) {
          break label2759;
        }
        if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString == null) || (!((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("qqreg"))) {
          break label2754;
        }
        break label2759;
        if ((str1.startsWith("mqqwpa://im")) || (str1.startsWith("mqqwpaopenid://im")))
        {
          a(true, str2, true);
          return false;
        }
        if ((!str1.startsWith("mqqapi:")) || ((paramBundle != null) && (!"com.tencent.mobileqq".equals(paramBundle)))) {
          break label2751;
        }
        paramBundle = getIntent().getStringExtra("pkg_name");
        label1712:
        if ((!this.app.isLogin()) && (i != 0))
        {
          localObject4 = new StringBuilder().append(str1);
          if (str1.indexOf("?") <= -1) {
            break label2766;
          }
        }
      }
    }
    label2751:
    label2754:
    label2759:
    label2764:
    label2766:
    for (Object localObject2 = "&";; localObject2 = "?")
    {
      localObject2 = (String)localObject2;
      localObject2 = (String)localObject2 + "jfrom=login";
      localObject4 = new Intent(this, LoginActivity.class);
      ((Intent)localObject4).putExtra("scheme_content", (String)localObject2);
      ((Intent)localObject4).putExtra("pkg_name", paramBundle);
      ((Intent)localObject4).putExtras((Intent)localObject4);
      ((Intent)localObject4).setFlags(268435456);
      if (VersionUtils.e()) {
        ((Intent)localObject4).addFlags(32768);
      }
      startActivity((Intent)localObject4);
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "JumpActivity is finish");
        }
        if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null)) {
          break;
        }
        finish();
        break label2764;
        if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)) && (!PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(this, this.app, str1)))
        {
          localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
          ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
          ((Intent)localObject2).putExtra("scheme_content", str1);
          ((Intent)localObject2).putExtra("pkg_name", paramBundle);
          startActivity((Intent)localObject2);
        }
        else
        {
          if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("devlock")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("open")))
          {
            if (!NetworkUtil.d(this))
            {
              QQToast.a(this, getString(2131433023), 0).b(getTitleBarHeight());
              break label2774;
            }
            EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_a_of_type_MqqObserverWtloginObserver);
            break label2774;
          }
          if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("gvideo")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("open_plugin")))
          {
            GVideoGrayConfig.a(this.app, this, (Intent)localObject4, 1);
            return false;
          }
          if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("nearby_videochat")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("open_plugin")))
          {
            paramBundle = (NearbyVideoChatManager)this.app.getManager(223);
            NearbyVideoChatProxyActivity.a(this.app, this, (Intent)localObject4, paramBundle.a(), null, 123987);
            return false;
          }
          if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("qwerewolf")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString != null) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("enterHomePage")))
          {
            GameRoomUtils.a(this, 16);
            finish();
            return false;
          }
          if (str1.startsWith("mqqapi://tenpay/pay?"))
          {
            localObject2 = null;
            if (localObject4 != null) {
              localObject2 = ((Intent)localObject4).getStringExtra("url_app_info");
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((JumpAction)localObject3).a("url_app_info", (String)localObject2);
            }
          }
          ((JumpAction)localObject3).b(paramBundle);
          bool = ((JumpAction)localObject3).b();
        }
      }
      if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("gav")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("request")))
      {
        if ((!"0".equals(((JumpAction)localObject3).a("relation_id"))) && (bool)) {
          finish();
        }
      }
      else if ((("videochat".equals(((JumpAction)localObject3).jdField_b_of_type_JavaLangString)) && ("request".equals(((JumpAction)localObject3).jdField_c_of_type_JavaLangString))) || (("randomavchat".equals(((JumpAction)localObject3).jdField_b_of_type_JavaLangString)) && ("request".equals(((JumpAction)localObject3).jdField_c_of_type_JavaLangString))) || (("guildavchat".equals(((JumpAction)localObject3).jdField_b_of_type_JavaLangString)) && ("request".equals(((JumpAction)localObject3).jdField_c_of_type_JavaLangString))))
      {
        if (bool) {
          finish();
        }
      }
      else if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("wallet")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("modify_pass")))
      {
        if (bool) {
          finish();
        }
      }
      else if ((((JumpAction)localObject3).jdField_b_of_type_JavaLangString.equals("now")) && (((JumpAction)localObject3).jdField_c_of_type_JavaLangString.equals("openSmallVideoRecord")))
      {
        if (bool) {
          finish();
        }
      }
      else if (((JumpAction)localObject3).f())
      {
        if (bool) {
          finish();
        }
      }
      else if (!a((JumpAction)localObject3))
      {
        finish();
      }
      else
      {
        a();
        break label2764;
        paramBundle = getIntent().getStringExtra("action");
        if (paramBundle == null)
        {
          finish();
          return false;
        }
        this.d = getIntent().getBooleanExtra("doCallBack", false);
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("src_type");
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("callback_type");
        this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("callback_name");
        if ("photo".equals(paramBundle)) {
          this.jdField_b_of_type_Boolean = true;
        }
        while (this.jdField_b_of_type_Boolean)
        {
          break label2776;
          if ("select_location".equals(paramBundle)) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label2776;
        }
        d();
        break label2776;
        break label1712;
        i = 1;
        break;
        i = 0;
        break;
      }
      return false;
    }
    label2774:
    return false;
    label2776:
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.e) {
      finish();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public boolean showPreview()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration"))) {
      return true;
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */