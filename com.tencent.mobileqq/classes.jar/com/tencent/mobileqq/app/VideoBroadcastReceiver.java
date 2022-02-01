package com.tencent.mobileqq.app;

import acmw;
import acnh;
import afrb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Window;
import antl;
import anvk;
import anvx;
import aocy;
import aoep;
import aogr;
import aogs;
import aogt;
import aogu;
import aogv;
import aoxz;
import asbm;
import asci;
import avux;
import awtk;
import awto;
import awui;
import azry;
import bapk;
import bapo;
import bcrg;
import bcsa;
import bdee;
import bdla;
import bdof;
import bhdj;
import bhgf;
import bhgy;
import bhhn;
import bhhr;
import bhml;
import bibh;
import bnkt;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lch;
import lne;
import lxf;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mrr;
import msa;
import msw;
import mtq;
import mud;
import mug;
import mur;
import mvk;
import mvo;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  static VideoBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver;
  public static String a;
  INetEngine.INetEngineListener jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aogu(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoBroadCastReceiver";
  }
  
  VideoBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_MqqOsMqqHandler = new aogv(Looper.getMainLooper(), this);
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (GesturePWDUtils.isAppOnForegroundByTasks(paramContext)) {
      return PopupDialog.a(paramContext, 230, paramString1, paramString2, 2131690697, 2131694399, paramOnClickListener, null);
    }
    paramString1 = bhdj.a(paramContext, 230, paramString1, paramString2, 2131690697, 2131694399, paramOnClickListener, null);
    if (Build.VERSION.SDK_INT >= 26) {
      paramString1.getWindow().setType(2038);
    }
    while (Build.VERSION.SDK_INT >= 23) {
      if (Settings.canDrawOverlays(paramContext))
      {
        paramString1.show();
        return paramString1;
        paramString1.getWindow().setType(2003);
      }
      else
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "can not DrawOverlays showAlertDialog()!!");
        return paramString1;
      }
    }
    paramString1.show();
    return paramString1;
  }
  
  public static void a()
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver != null) && (jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_Boolean))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localQQAppInterface != null) {
          localQQAppInterface.getApp().unregisterReceiver(jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver);
        }
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_Boolean = false;
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_JavaLangRefWeakReference = null;
        jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver = null;
      }
      return;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    bapk localbapk = (bapk)localQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (localbapk != null)
    {
      if ((paramInt1 != 3) && (paramInt1 != 4)) {
        break label137;
      }
      localbapk.a(paramInt2, paramString1, paramString2, paramString3, 8);
    }
    for (;;)
    {
      try
      {
        paramString2 = bcsa.a(-4008);
        paramString2.selfuin = localQQAppInterface.getCurrentAccountUin();
        paramString2.frienduin = paramString1;
        paramString2.senderuin = paramString3;
        paramString2.msgtype = -4008;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = paramInt2;
        paramString2.time = bcrg.a();
        mud.a(localQQAppInterface, 1, true, true, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label137:
      localbapk.a(paramInt2, paramString1, paramString2, paramString3, 2);
    }
  }
  
  private void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (((paramInt == 3000) || (paramInt == 1)) && (paramString != null))
    {
      paramQQAppInterface.getAVNotifyCenter().a(12, mvk.b(paramInt), Long.valueOf(paramString).longValue(), null, 0L);
      paramQQAppInterface.getAVNotifyCenter().a(21, mvk.b(paramInt), Long.valueOf(paramString).longValue(), 0L);
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    int i = paramIntent.getIntExtra("uinType", 0);
    String str2 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("effectId", 0);
    ThemeBackground.setThemeBackgroundPic(paramContext, "theme_bg_aio_path", paramQQAppInterface.getAccount(), str1, "", "", "", 0, null, false);
    afrb.a(paramContext, paramQQAppInterface.getAccount(), str2, str1, j, i);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = new Intent(paramContext, PhoneFrameActivity.class);
    paramContext.putExtra("key_req_type", 0);
    paramContext.addFlags(268435456);
    paramQQAppInterface.getApp().startActivity(paramContext);
  }
  
  private void a(Intent paramIntent)
  {
    QQAppInterface localQQAppInterface;
    int i;
    boolean bool2;
    boolean bool1;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localQQAppInterface = null;
      i = paramIntent.getIntExtra("packageIdx", bnkt.b.a);
      bool2 = false;
      if (i != bnkt.b.a) {
        break label146;
      }
      bool1 = bool2;
      if (localQQAppInterface != null)
      {
        paramIntent = new lxf(localQQAppInterface);
        bool1 = bdee.a(localQQAppInterface, localQQAppInterface.getApplication().getApplicationContext(), paramIntent);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtuResCheck", 2, "checkPtuRes, ret[" + bool1 + "], packageIndex[" + i + "], app[" + localQQAppInterface + "]");
      }
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      label146:
      bool1 = bool2;
      if (i == bnkt.c.a)
      {
        bool1 = bool2;
        if (localQQAppInterface != null)
        {
          bdee.a(new lxf(localQQAppInterface));
          bool1 = bool2;
        }
      }
    }
  }
  
  private void a(Intent paramIntent, long paramLong, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("SmallScreenState", 0);
    paramIntent = paramIntent.getStringExtra("uin");
    if (AudioHelper.f()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "ACTION_SMALL_SCREEN_STATE, smallScreenState[" + i + "], peerUin[" + paramIntent + "], seq[" + paramLong + "]");
    }
    paramQQAppInterface.getAVNotifyCenter().b(paramLong, i);
    if (!TextUtils.isEmpty(paramIntent)) {
      paramQQAppInterface.getAVNotifyCenter().d(paramIntent);
    }
  }
  
  private void a(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("relationType", 3);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = " + i + " ,relationId = " + l1 + " ,friendUin = " + l2);
    }
    paramIntent = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramIntent != null) {
      paramIntent.a("" + l2, 0, 0);
    }
    paramQQAppInterface.getAVNotifyCenter().a(String.valueOf(l2), false);
    paramQQAppInterface.getAVNotifyCenter().b(false);
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 106	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	com/tencent/mobileqq/app/VideoBroadcastReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 405	com/tencent/mobileqq/app/VideoBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 106	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   20: ldc 2
    //   22: monitorexit
    //   23: new 407	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 408	android/content/IntentFilter:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc_w 410
    //   35: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: ldc_w 415
    //   42: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: ldc_w 417
    //   49: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc_w 419
    //   56: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w 421
    //   63: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 423
    //   70: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc_w 425
    //   77: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ldc_w 427
    //   84: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: ldc_w 429
    //   91: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: ldc_w 431
    //   98: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: ldc_w 433
    //   105: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: ldc_w 435
    //   112: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc_w 437
    //   119: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: ldc_w 439
    //   126: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: ldc_w 441
    //   133: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: ldc_w 443
    //   140: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: ldc_w 445
    //   147: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: ldc_w 447
    //   154: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: ldc_w 449
    //   161: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: ldc_w 451
    //   168: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   171: aload_1
    //   172: ldc_w 453
    //   175: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   178: aload_1
    //   179: ldc_w 455
    //   182: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   185: aload_1
    //   186: ldc_w 457
    //   189: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: ldc_w 459
    //   196: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc_w 461
    //   203: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   206: aload_1
    //   207: ldc_w 463
    //   210: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc_w 465
    //   217: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   220: aload_1
    //   221: ldc_w 467
    //   224: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   227: aload_1
    //   228: ldc_w 469
    //   231: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   234: aload_1
    //   235: ldc_w 471
    //   238: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: ldc_w 473
    //   245: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   248: aload_1
    //   249: ldc_w 475
    //   252: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: ldc_w 477
    //   259: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   262: aload_1
    //   263: ldc_w 479
    //   266: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   269: aload_1
    //   270: ldc_w 481
    //   273: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   276: aload_1
    //   277: ldc_w 483
    //   280: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: ldc_w 485
    //   287: invokevirtual 413	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   290: aload_0
    //   291: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   294: getstatic 106	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   297: aload_1
    //   298: ldc_w 487
    //   301: aconst_null
    //   302: invokevirtual 491	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   305: pop
    //   306: getstatic 106	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   309: iconst_1
    //   310: putfield 25	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_Boolean	Z
    //   313: return
    //   314: astore_0
    //   315: ldc 2
    //   317: monitorexit
    //   318: aload_0
    //   319: athrow
    //   320: astore_0
    //   321: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq -11 -> 313
    //   327: getstatic 18	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: iconst_2
    //   331: new 307	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 493
    //   341: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramQQAppInterface	QQAppInterface
    //   30	268	1	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   3	20	314	finally
    //   20	23	314	finally
    //   315	318	314	finally
    //   290	313	320	java/lang/Exception
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    paramQQAppInterface = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramQQAppInterface != null) {}
    try
    {
      paramQQAppInterface.a().a(paramString1, paramInt1).isSystemCall = 0;
      label28:
      if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt1 == 25)) {
        if (paramBoolean1) {
          paramQQAppInterface.a(paramString1, 8, paramInt1, paramInt2, paramString2, 6);
        }
      }
      do
      {
        return;
        paramQQAppInterface.a(paramString1, 8, paramInt1, paramInt2, paramString2, 5);
        return;
        if (paramBoolean1)
        {
          paramQQAppInterface.a(paramString1, paramInt1, 6);
          return;
        }
      } while (paramBoolean2);
      paramQQAppInterface.a(paramString1, paramInt1, 5);
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, SharedPreferences paramSharedPreferences, int paramInt3, boolean paramBoolean)
  {
    int i = paramSharedPreferences.getInt(lch.c, 0) + 1;
    boolean bool2 = paramSharedPreferences.getBoolean(lch.l, false);
    long l2 = 0L;
    long l1 = l2;
    if (i == 1)
    {
      l1 = l2;
      if (!bool2)
      {
        l2 = paramSharedPreferences.getLong("qav_score_msg_uniseq", 0L);
        l1 = l2;
        if (l2 != 0L)
        {
          paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramString, paramInt1, l2);
          l1 = l2;
        }
      }
    }
    boolean bool1;
    if ((paramInt3 != 0) && (i % paramInt3 == 0))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onVideoChatEnd, scoreCount[" + i + "], hasCommit[" + bool2 + "], uniseq[" + l1 + "], show2[" + bool1 + "]");
      }
      if ((!paramBoolean) && (!bool1)) {
        break label495;
      }
      mug.a("{\n" + lch.d + ":" + paramLong1 + ",\n" + lch.jdField_e_of_type_JavaLangString + ":" + paramLong2 + ",\n" + lch.f + ":" + paramInt2 + ",\n" + lch.i + ":" + paramLong3 + ",\n" + lch.j + ":" + paramLong4 + ",\n" + lch.k + ":" + paramString + "\n}");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addTipsVideoMsg beginTime: " + paramLong1 + ", endTime: " + paramLong2 + ", sdkVersion: " + paramInt2 + ", bussinessType: " + paramLong3 + ", bussinessFlag: " + paramLong4 + ",toUin: " + paramString);
      }
      VideoMsgTools.a(paramQQAppInterface, paramInt1, 61, true, paramString, null);
      paramInt1 = 0;
      paramSharedPreferences.edit().putBoolean(lch.l, false).commit();
    }
    for (;;)
    {
      paramSharedPreferences.edit().putInt(lch.c, paramInt1).commit();
      return;
      bool1 = false;
      break;
      label495:
      paramInt1 = i;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    if ((!paramBoolean) && (paramInt2 != 1008))
    {
      if (paramInt2 == 0)
      {
        paramBoolean = false;
        if (!TextUtils.isEmpty(paramString1)) {
          paramBoolean = paramString1.equals(paramString2);
        }
        VideoMsgTools.a(paramQQAppInterface, paramInt2, 1, true, paramString4, paramString2, paramBoolean, null, true, new Object[0]);
      }
    }
    else {
      return;
    }
    a(paramInt1, paramInt2, paramString3, paramString4, paramString2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3, long paramLong4, long paramLong5)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 == 1006) && ((paramString3 == null) || (!paramString3.contains("+")))) {}
    for (;;)
    {
      if (!TextUtils.equals(paramString1, paramQQAppInterface.getCurrentAccountUin())) {}
      do
      {
        return;
        paramString3 = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      } while ((paramQQAppInterface.getAVNotifyCenter().d(paramString2)) || (paramString3 == null));
      if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt1 == 25)) {
        paramString3.a(paramString2, 8, paramInt1, paramInt2, paramString4, 0);
      }
      for (;;)
      {
        paramString1 = paramIntent.getStringExtra("actId");
        paramIntent = paramIntent.getStringExtra("mp_ext_params");
        if (paramString1 == null) {
          break;
        }
        VideoMsgTools.a(paramQQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", paramString1, paramIntent, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener);
        return;
        a(paramQQAppInterface, paramString1, paramInt1, paramString2, paramLong1, paramLong2, paramLong3, paramInt3, paramLong4, paramLong5, paramString3);
      }
      paramString2 = paramString3;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, bapk parambapk)
  {
    parambapk.a(paramString2, paramInt1, 0);
    parambapk = bhhr.e(paramQQAppInterface.getCurrentAccountUin());
    int i = parambapk.getInt("qav_score_switch", 0);
    int j = parambapk.getInt("qav_score_rate", 5);
    int k = parambapk.getInt("qav_score_time", 0);
    if ((paramString1 != null) && (i == 1) && (j != 0) && (paramLong1 >= k) && (msw.a("qav_score_good.jpg")) && (msw.a("qav_score_normal.jpg")) && (msw.a("qav_score_bad.jpg"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = false;
      if (AudioHelper.a(17) == 1)
      {
        AudioHelper.a(anvx.a(2131715474));
        bool2 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onVideoChatEnd, scoreSwitch[" + i + "], scoreRate[" + j + "], scoreTime[" + k + "], duration[" + paramLong1 + "], show1[" + bool1 + "], forceShow[" + bool2 + "]");
      }
      if (((bool2) || (bool1)) && (paramString1 != null)) {
        a(paramQQAppInterface, paramInt1, paramString2, paramLong2, paramLong3, paramInt2, paramLong4, paramLong5, parambapk, j, bool2);
      }
      return;
    }
  }
  
  private boolean a(String paramString, Context paramContext, Intent paramIntent)
  {
    long l = mur.a(paramIntent);
    if (paramString.equals("tencent.video.v2q.AddVideoMsg"))
    {
      a(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.VideoFlowSize"))
    {
      h(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.MultiVideo"))
    {
      a(l, paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.StartDoubleVideoMeeting"))
    {
      b(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.StartVideoChat"))
    {
      c(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.StopVideoChat"))
    {
      d(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.AvSwitch"))
    {
      j(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.AnotherTerChating"))
    {
      e(paramContext, paramIntent);
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = new Intent(paramContext, BindNumberActivity.class);
    paramContext.putExtra("kNeedUnbind", true);
    paramContext.addFlags(268435456);
    paramQQAppInterface.getApp().startActivity(paramContext);
  }
  
  private void b(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("relationType", 0);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("AVShare", 2, "TYPE_DOUBLE_MEETING_MEMBER_LEAVE, relationType[" + i + "], relationId[" + l1 + "], friendUin[" + l2 + "]");
    }
    paramQQAppInterface.getAVNotifyCenter().a(String.valueOf(l1), false);
    paramQQAppInterface.getAVNotifyCenter().b(false);
    paramIntent = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramIntent != null) {
      paramIntent.a("" + l2, 0, 0);
    }
  }
  
  private void c(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN");
    }
    int i = paramIntent.getIntExtra("relationType", 0);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("AVShare", 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN, relationType[" + i + "], relationId[" + l1 + "], friendUin[" + l2 + "]");
    }
    if (l2 == l1) {
      paramQQAppInterface.getAVNotifyCenter().a(0, Long.valueOf(l1), true);
    }
    paramQQAppInterface.getAVNotifyCenter().a(String.valueOf(l1), true);
    if (l2 == l1)
    {
      paramQQAppInterface.getAVNotifyCenter().d(true);
      paramQQAppInterface.getAVNotifyCenter().b(true);
    }
  }
  
  private void d(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
      }
    }
    long l;
    do
    {
      do
      {
        return;
        l = paramIntent.getLongExtra("relationId", -1L);
        paramIntent = mtq.a((ArrayList)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + paramIntent);
        }
        localObject = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      } while (localObject == null);
      ((bapk)localObject).a(0, l, "", paramIntent);
      paramIntent = (antl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    } while ((paramIntent == null) || (paramIntent.a() == null));
    paramIntent.a().e(String.valueOf(l));
  }
  
  private void e(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.d(paramIntent.getStringExtra("relationId"), paramIntent.getStringExtra("inviterUin"));
    }
  }
  
  private void f(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addMemberFromC2C");
    }
    VideoMsgTools.a(paramQQAppInterface, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("supportUinType", 3000));
  }
  
  private void g(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MultiAVType", String.valueOf(2));
    localHashMap.put("enterType", paramIntent.getIntExtra("enterType", 0) + "");
    if (BaseActivity.sTopActivity != null) {
      ChatActivityUtils.a(paramQQAppInterface, BaseActivity.sTopActivity, 1, paramIntent.getStringExtra("relationId"), true, true, null, localHashMap);
    }
  }
  
  private void h(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("callId", 0);
    if ((i > 0) && (bibh.b()))
    {
      paramIntent = (bibh)paramQQAppInterface.getManager(QQManagerFactory.VIP_FUNCALL_MANAGER);
      if (paramIntent != null) {
        paramIntent.a(i, bibh.a(), false, 0);
      }
    }
  }
  
  private void i(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("comming_ring_down_key", 0);
    if ((i > 0) && (bibh.b()))
    {
      ((bhml)paramQQAppInterface.getManager(QQManagerFactory.COLOR_RING_MANAGER)).a(i, 3, false, 0, "comering");
      int j = ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
      bdla.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + j, i + "", "", "");
    }
  }
  
  private void j(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    bapk localbapk = paramQQAppInterface.getCallFacade();
    if (localbapk != null)
    {
      paramQQAppInterface = paramIntent.getStringExtra("phoneNumber");
      paramIntent = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        paramIntent = paramQQAppInterface;
        if (!paramQQAppInterface.startsWith("+")) {
          paramIntent = "+86" + paramQQAppInterface;
        }
      }
      localbapk.b(paramIntent);
    }
  }
  
  private void k(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    AbsStructMsg localAbsStructMsg;
    if ("SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")))
    {
      localAbsStructMsg = bdof.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg != null) {}
    }
    else
    {
      return;
    }
    bhhn.a(paramQQAppInterface, paramIntent.getStringExtra("uin"), paramIntent.getIntExtra("uintype", -1), localAbsStructMsg, null);
  }
  
  void a(long paramLong, Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 20);
    boolean bool = paramIntent.getBooleanExtra("isStart", false);
    int j = paramIntent.getIntExtra("MultiAVType", 0);
    if ((AudioHelper.f()) || (i == 22) || (i == 23) || (i == 25)) {
      AudioHelper.a(jdField_a_of_type_JavaLangString + ".onMultiMsgV2Q", paramIntent.getExtras());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {}
    do
    {
      long l;
      do
      {
        int k;
        do
        {
          return;
          if (QLog.isDevelopLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 4, "onMultiMsgV2Q, type[" + i + "]");
          }
          if (i == 22)
          {
            a(localQQAppInterface, paramContext, paramIntent, i, bool, j);
            return;
          }
          if (i == 23)
          {
            b(localQQAppInterface, paramContext, paramIntent, i, bool, j);
            return;
          }
          if (i != 32) {
            break;
          }
          paramLong = paramIntent.getLongExtra("relationId", -1L);
          k = paramIntent.getIntExtra("uinType", -1);
        } while (k != 1);
        l = paramIntent.getIntExtra("closeType", 1);
        localQQAppInterface.getAVNotifyCenter().a(i, k, paramLong, l, j);
        return;
        if (i != 33) {
          break;
        }
        paramLong = paramIntent.getLongExtra("relationId", -1L);
        j = paramIntent.getIntExtra("uinType", -1);
        l = paramIntent.getLongExtra("info", -1L);
        paramContext = paramIntent.getStringExtra("strMsg");
      } while (j != 1);
      localQQAppInterface.getAVNotifyCenter().a(i, j, paramLong, l, paramContext);
      return;
      if (i == 25)
      {
        a(localQQAppInterface, paramContext, paramIntent, j);
        return;
      }
      if (i == 401)
      {
        c(paramIntent, localQQAppInterface);
        return;
      }
      if (i == 402)
      {
        b(paramIntent, localQQAppInterface);
        return;
      }
      if (i == 403)
      {
        a(paramIntent, localQQAppInterface);
        return;
      }
    } while (i != 411);
    d(paramIntent, localQQAppInterface);
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG");
    }
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("msgType", 5);
    int m = paramIntent.getIntExtra("msgDetail", 0);
    boolean bool1 = paramIntent.getBooleanExtra("isVideoMsg", true);
    String str1 = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("senderUin");
    String str3 = paramIntent.getStringExtra("selfUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool3 = paramIntent.getBooleanExtra("isRead", false);
    paramContext = paramIntent.getStringExtra("extra");
    int n = paramIntent.getIntExtra("MultiAVType", 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG selfUin = " + str3);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localQQAppInterface == null) || ((k == 0) && (!TextUtils.equals(str3, localQQAppInterface.getCurrentAccountUin())))) {}
    label299:
    label508:
    label509:
    for (;;)
    {
      return;
      int i;
      if (((k == 2) || (k == 24)) && (paramContext == null) && (bhgy.a(localQQAppInterface.getApp())))
      {
        boolean bool4 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131693714), "qqsetting_lock_screen_whenexit_key", true);
        boolean bool5 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131718178), "qqsetting_notify_showcontent_key", true);
        a(localQQAppInterface, bool4, bool5);
        if ((bool4) && (bool5))
        {
          i = 1;
          if (k != 17) {
            break label508;
          }
          paramContext = String.valueOf(m);
        }
      }
      for (;;)
      {
        if ((n == 2) && (str1 != null) && (!a(localQQAppInterface, str1, k))) {
          break label509;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype");
        }
        VideoMsgTools.a(localQQAppInterface, j, k, bool1, str1, str2, bool2, paramContext, bool3, n, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype end");
        }
        if (i == 0) {
          break;
        }
        paramContext = (awto)localQQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        paramContext.a(localQQAppInterface, str1, j, true, awtk.a(str1, j, paramIntent), true);
        paramContext.a(localQQAppInterface, str1, j, true, awtk.a(str1, j, paramIntent));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
        return;
        i = 0;
        break label299;
        if ((k == 17) || (k == 15) || (k == 16)) {
          a(j, str1, localQQAppInterface);
        }
        i = 0;
        break label299;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_GAUDIO_TROOP_CARD");
    }
    String str2 = paramIntent.getStringExtra("troopUin");
    String str1 = paramIntent.getStringExtra("memberUin");
    if (paramIntent.getIntExtra("uinType", -1) == 3000)
    {
      if (str1.equals(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramQQAppInterface = new ProfileActivity.AllInOne(str1, 0);
        paramQQAppInterface.g = 5;
        ProfileActivity.b(paramContext, paramQQAppInterface);
        return;
      }
      if (((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str1))
      {
        paramIntent = new ProfileActivity.AllInOne(str1, 1);
        paramIntent.h = ContactUtils.getNick(paramQQAppInterface, str1, 0);
        paramIntent.g = 5;
        ProfileActivity.b(paramContext, paramIntent);
        return;
      }
      paramIntent = new ProfileActivity.AllInOne(str1, 46);
      paramIntent.h = ContactUtils.getNick(paramQQAppInterface, str1, 0);
      paramIntent.f = str1;
      paramIntent.jdField_e_of_type_Int = 3000;
      paramIntent.jdField_e_of_type_JavaLangString = str2;
      paramIntent.g = 5;
      ProfileActivity.b(paramContext, paramIntent);
      return;
    }
    azry.a(paramQQAppInterface, paramQQAppInterface.getApp(), str2, str1, 0, -1);
  }
  
  void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    long l = paramIntent.getLongExtra("relationId", -1L);
    int m = paramIntent.getIntExtra("relationType", -1);
    int i = paramIntent.getIntExtra("reason", -1);
    boolean bool2 = paramIntent.getBooleanExtra("openClass", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_ROOM_DESTROY-->relationid=" + l + " relationType=" + m + " reason=" + i + " avtype" + paramInt);
    }
    if (i == 4) {
      paramQQAppInterface.getAVNotifyCenter().a(32, 1, l, i, paramInt);
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (m == 1)
      {
        bool1 = bool2;
        if (paramInt == 2)
        {
          paramContext = paramQQAppInterface.getAVNotifyCenter().a(l, paramInt);
          bool1 = bool2;
          if (paramContext != null)
          {
            bool1 = bool2;
            if (paramContext.d == 2)
            {
              bool1 = bool2;
              if (paramContext.jdField_e_of_type_Int == 4) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    paramContext = paramQQAppInterface.getAVNotifyCenter();
    int j;
    label229:
    int k;
    if (bool1)
    {
      i = 2;
      if (!bool1) {
        break label335;
      }
      j = 4;
      if (!bool1) {
        break label341;
      }
      k = 0;
      label237:
      paramContext.a(9, l, paramInt, i, j, k, 25, 0);
      if (paramQQAppInterface.getAVNotifyCenter().a(m, l) <= 0L) {
        break label347;
      }
      paramQQAppInterface.getAVNotifyCenter().a(13, m, l, null, 0L);
      VideoMsgTools.a(paramQQAppInterface, m, 14, false, String.valueOf(l), paramQQAppInterface.getCurrentAccountUin(), false, null, false, paramInt, new Object[0]);
      paramQQAppInterface.getAVNotifyCenter().a(21, m, l, 0L);
    }
    label335:
    label341:
    label347:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
      j = 0;
      break label229;
      k = -1;
      break label237;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 2, "MultiRoomMemberNum is 0");
  }
  
  void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramIntent.getIntExtra("relationType", 0);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    int j = paramIntent.getIntExtra("roomUserNum", 0);
    paramQQAppInterface.getAVNotifyCenter().a(9, i, l1, 3);
    if (l2 == Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue())
    {
      paramQQAppInterface.getAVNotifyCenter().a(i, Long.valueOf(l1), true);
      paramQQAppInterface.getAVNotifyCenter().a(9, i, l1, 3);
      paramQQAppInterface.getAVNotifyCenter().a(i, l1);
      paramQQAppInterface.getAVNotifyCenter().b(12, l1, paramInt2);
      if (j == 1)
      {
        paramQQAppInterface.getAVNotifyCenter().a(i, l1, true, false);
        paramContext = paramQQAppInterface.getProxyManager().a();
        if (paramContext != null)
        {
          paramIntent = String.valueOf(l1);
          paramInt2 = mvk.c(i);
          if ((paramInt2 != -1) && (paramInt2 != 1011) && (!TextUtils.isEmpty(paramIntent)))
          {
            if (paramInt2 != 1) {
              break label448;
            }
            TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if ((localTroopManager != null) && (localTroopManager.b(paramIntent) != null))
            {
              paramIntent = (RecentUser)paramContext.findRecentUserByUin(paramIntent, paramInt2);
              if (paramIntent != null)
              {
                paramIntent.lastmsgtime = bcrg.a();
                paramContext.saveRecentUser(paramIntent);
              }
            }
          }
        }
        label246:
        if ((i != 1) && (i != 7) && (i != 9) && (i != 10))
        {
          paramContext = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
          if (paramContext != null) {
            paramContext.a(l1, l2, true, -1L, paramBoolean);
          }
        }
        if ((paramQQAppInterface.getAVNotifyCenter().b() == l1) && (paramQQAppInterface.getAVNotifyCenter().b() >= 4) && (paramQQAppInterface.getAVNotifyCenter().f()))
        {
          paramQQAppInterface.getAVNotifyCenter().b(true);
          paramQQAppInterface.getAVNotifyCenter().d(true);
        }
      }
    }
    for (;;)
    {
      paramQQAppInterface.getAVNotifyCenter().a(paramInt1, i, l1, l2);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "member join discussId: " + l1 + ", friendUin: " + l2 + ", roomUserNum:" + j);
      }
      return;
      paramQQAppInterface.getAVNotifyCenter().a(i, l1, false, false);
      paramQQAppInterface.getAVNotifyCenter().b(true);
      break;
      label448:
      paramIntent = (RecentUser)paramContext.findRecentUserByUin(paramIntent, paramInt2);
      if (paramIntent == null) {
        break label246;
      }
      paramIntent.lastmsgtime = bcrg.a();
      paramContext.saveRecentUser(paramIntent);
      break label246;
      if ((paramQQAppInterface.getAVNotifyCenter().b() == l1) && (paramQQAppInterface.getAVNotifyCenter().f()))
      {
        paramQQAppInterface.getAVNotifyCenter().a(i, l1, false, false);
        paramQQAppInterface.getAVNotifyCenter().b(true);
        paramQQAppInterface.getAVNotifyCenter().d(true);
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, long paramLong1, long paramLong2, long paramLong3, int paramInt4, long paramLong4, long paramLong5)
  {
    if ((paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 8)) {
      a(paramQQAppInterface, paramInt1, paramBoolean, paramString1, paramString2, paramString3, paramInt2, paramString4);
    }
    while ((paramInt1 != 0) && (paramInt1 != 1) && (paramInt1 != 2)) {
      return;
    }
    a(paramQQAppInterface, paramIntent, paramString1, paramString3, paramInt2, paramString4, paramInt3, paramString5, paramLong1, paramLong2, paramLong3, paramInt4, paramLong4, paramLong5);
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramInt1 == 1006) && ((paramString2 == null) || (!paramString2.contains("+")))) {}
    for (;;)
    {
      a(paramQQAppInterface, paramInt1, paramString1, paramInt2, paramBoolean1, paramString3, paramBoolean2);
      if (paramInt1 == 1008) {
        break;
      }
      try
      {
        if ((!acnh.b(paramString1, paramInt1)) && (acnh.t(paramInt1)) && (!paramQQAppInterface.getConversationFacade().b(paramString1, paramInt1))) {
          return;
        }
        if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt1 == 25) || (paramBoolean3)) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
        if ((paramQQAppInterface == null) || ((RecentUser)paramQQAppInterface.findRecentUser(paramString1, paramInt1) != null) || (TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 2)) {
          break;
        }
        paramString1 = (RecentUser)paramQQAppInterface.findRecentUserByUin(paramString1, paramInt1);
        if (paramString1 == null) {
          break;
        }
        paramString1.lastmsgtime = bcrg.a();
        paramQQAppInterface.saveRecentUser(paramString1);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      paramString1 = paramString2;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(16711696));
      }
    }
  }
  
  boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (paramQQAppInterface == null) {
        return false;
      }
      lne locallne = paramQQAppInterface.getAVNotifyCenter().a(l, 2);
      if ((locallne != null) && (locallne.a > 0) && (paramInt == 13)) {
        return false;
      }
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(paramString);
          if (paramQQAppInterface == null) {
            return false;
          }
        }
      }
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    if (paramString.equals("tencent.video.v2q.AddMsgSig"))
    {
      i(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.CallingDialog"))
    {
      k(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.CallingDialogMulti"))
    {
      l(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.setChatStatus"))
    {
      m(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.updateChatInfo"))
    {
      n(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.av.v2q.CheckChatAbility"))
    {
      p(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.downloadGAudioSound"))
    {
      o(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.AddContactsToDiscuss"))
    {
      VideoMsgTools.b(paramQQAppInterface, paramIntent.getStringExtra("discussUin"));
      return true;
    }
    if (paramString.equals("tencent.video.v2q.MeetingMemberManager"))
    {
      VideoMsgTools.a(paramQQAppInterface, paramIntent.getStringExtra("discussUin"));
      return true;
    }
    if (paramString.equals("tencent.video.v2q.AddContactsFromC2C"))
    {
      f(paramIntent, paramQQAppInterface);
      return true;
    }
    return false;
  }
  
  void b(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    boolean bool1;
    Object localObject;
    for (;;)
    {
      long l;
      boolean bool2;
      try
      {
        l = Long.parseLong(paramContext);
        if (l == 0L)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "onStartVideoDoubleMeeting, uin is 0.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        l = 0L;
        continue;
        bool1 = paramIntent.getBooleanExtra("isReceiver", false);
        boolean bool3 = paramIntent.getBooleanExtra("updateTime", false);
        bool2 = paramIntent.getBooleanExtra("showTime", false);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_START_DOUBLE_VIDEO_MEETING uinType: " + i + ", peerUin: " + paramContext + ", updateTime: " + bool3 + ", showTime: " + bool2);
        }
        paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramIntent == null) {
          continue;
        }
        if (bool3)
        {
          paramIntent.getAVNotifyCenter().d(true);
          paramIntent.getAVNotifyCenter().b(true);
        }
        paramIntent.getAVNotifyCenter().a(7, paramContext, 2);
        paramIntent.getAVNotifyCenter().a(i, paramContext, null, bool1);
        paramIntent.getAVNotifyCenter().a(paramContext, true);
        localObject = paramIntent.getAVNotifyCenter();
        if (bool2) {
          break;
        }
      }
      bool1 = true;
      label239:
      ((AVNotifyCenter)localObject).a(0, l, bool1, true);
      if (i == 0)
      {
        localObject = (bapk)paramIntent.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (!bool2) {
          break label409;
        }
        ((bapk)localObject).a(paramContext, i, 6);
      }
    }
    for (;;)
    {
      try
      {
        if ((!acnh.b(paramContext, i)) && (acnh.t(i)) && (!paramIntent.getConversationFacade().b(paramContext, i))) {
          break;
        }
        paramIntent = paramIntent.getProxyManager().a();
        if ((paramIntent == null) || ((RecentUser)paramIntent.findRecentUser(paramContext, i) != null) || (TextUtils.isEmpty(paramContext))) {
          break;
        }
        paramContext = (RecentUser)paramIntent.findRecentUserByUin(paramContext, i);
        if (paramContext == null) {
          break;
        }
        paramContext.lastmsgtime = bcrg.a();
        paramIntent.saveRecentUser(paramContext);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Recent User Proxy Error-->e=" + paramContext.getMessage());
      return;
      bool1 = false;
      break label239;
      label409:
      ((bapk)localObject).a(paramContext, i, 5);
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("peerUin");
    long l = paramIntent.getLongExtra("roomId", 0L);
    if ((l != 0L) && (paramContext != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "<qav printer> message send: cmd[0x211, 0xb]");
      }
      paramQQAppInterface = (mvo)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_C2C_HANDLER);
      paramQQAppInterface.b = paramContext;
      paramQQAppInterface.a = l;
      paramQQAppInterface.a();
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramIntent.getIntExtra("relationType", 0);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    int j = paramIntent.getIntExtra("roomUserNum", 0);
    if (l2 == Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue())
    {
      long l3 = paramIntent.getLongExtra("time", 0L);
      paramQQAppInterface.getAVNotifyCenter().a(9, i, l1, 0);
      paramQQAppInterface.getAVNotifyCenter().a(i, Long.valueOf(l1), false);
      paramQQAppInterface.getAVNotifyCenter().a(i, l1, paramInt2);
      paramQQAppInterface.getAVNotifyCenter().a(9, i, l1, 0);
      paramQQAppInterface.getAVNotifyCenter().b(false);
      if (i != 1)
      {
        paramContext = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (paramContext != null) {
          paramContext.a(l1, l2, false, l3, paramBoolean);
        }
      }
      bhgf.a(paramQQAppInterface, paramIntent, i, l1);
    }
    if (j == 1) {
      paramQQAppInterface.getAVNotifyCenter().a(i, l1, true, false);
    }
    paramQQAppInterface.getAVNotifyCenter().a(paramInt1, i, l1, l2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "member quit discussId: " + l1 + ", friendUin: " + l2);
    }
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    if (paramString.equals("tencent.video.v2q.replyMsg"))
    {
      f(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.leaveMsg"))
    {
      g(paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.AudioEngineReady"))
    {
      b(paramQQAppInterface, paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.GaudioOpenTroopCard"))
    {
      a(paramQQAppInterface, paramContext, paramIntent);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.BindContact"))
    {
      b(paramContext, paramQQAppInterface);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.OpenContactList"))
    {
      a(paramContext, paramQQAppInterface);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.AnnimateDownloadStart"))
    {
      h(paramIntent, paramQQAppInterface);
      return true;
    }
    if (paramString.equals("tencent.video.v2q.commingRingDownload"))
    {
      i(paramIntent, paramQQAppInterface);
      return true;
    }
    if (paramString.equals("chatbgBroadcast"))
    {
      a(paramContext, paramIntent, paramQQAppInterface);
      return true;
    }
    return false;
  }
  
  void c(Context paramContext, Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    int m = paramIntent.getIntExtra("bindType", 0);
    String str1 = paramIntent.getStringExtra("bindId");
    Object localObject = paramIntent.getStringExtra("peerUin");
    String str2 = paramIntent.getStringExtra("extraUin");
    boolean bool2 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool6 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    boolean bool4 = paramIntent.getBooleanExtra("isNearbyVideoChat", false);
    boolean bool5 = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (bool5)
    {
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = String.valueOf(l);
      }
      if (j == 3)
      {
        i = 1;
        int k = 0;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "onStartVideoChat, double meeting. peer[" + paramContext + "], sessionType[" + i + "]");
        }
        j = i;
        bool1 = true;
        i = k;
      }
    }
    for (;;)
    {
      if (AudioHelper.f()) {
        AudioHelper.a("onStartVideoChat[VideoConstants.ACTION_START_VIDEO_CHAT]", paramIntent.getExtras(), true);
      }
      if (i == -1) {}
      label294:
      do
      {
        do
        {
          return;
          i = j;
          if (j != 4) {
            break;
          }
          i = 2;
          break;
          if (!bool1) {
            break label481;
          }
        } while (((paramContext == null) || (paramContext.length() <= 2)) && ((str2 == null) || (str2.length() <= 2)));
        paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (paramIntent == null);
      if (bool2) {
        paramIntent.getAVNotifyCenter().a(bool2);
      }
      if (bool6)
      {
        paramIntent.getAVNotifyCenter().d(true);
        paramIntent.getAVNotifyCenter().b(true);
        label344:
        if (!bool1) {
          break label523;
        }
        paramIntent.getAVNotifyCenter().a(6, paramContext, j);
        paramIntent.getAVNotifyCenter().a(i, paramContext, str2, bool2);
        localObject = paramIntent.getAVNotifyCenter();
        j = mvk.b(i);
        if (bool3) {
          break label517;
        }
        bool1 = true;
        label394:
        ((AVNotifyCenter)localObject).a(j, paramContext, bool1, bool2);
        if (!bool5) {
          break label593;
        }
        paramIntent.getAVNotifyCenter().a(paramContext, true);
      }
      label517:
      label523:
      label593:
      for (;;)
      {
        paramIntent.getAVNotifyCenter().e(bool4);
        paramIntent.getAVNotifyCenter().a(28, i, paramContext, str2);
        if ((i == 1) || (i == 9500) || (i == 1011)) {
          break;
        }
        a(paramIntent, str2, i, paramContext, m, bool3, str1, bool2, bool4);
        return;
        label481:
        if (l >= 100L) {
          break label294;
        }
        return;
        if ((!bool3) || (paramIntent.getAVNotifyCenter().e())) {
          break label344;
        }
        paramIntent.getAVNotifyCenter().b(true);
        break label344;
        bool1 = false;
        break label394;
        paramIntent.getAVNotifyCenter().a(n, Long.valueOf(l), true);
        paramIntent.getAVNotifyCenter().a(6, n, l, j);
        paramContext = paramIntent.getAVNotifyCenter();
        if (!bool3) {}
        for (bool1 = true;; bool1 = false)
        {
          paramContext.a(n, l, bool1, bool2);
          paramContext = String.valueOf(l);
          break;
        }
      }
      paramContext = (Context)localObject;
    }
  }
  
  void c(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("relationId");
    long l = paramIntent.getLongExtra("friendUin", 0L);
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:" + l);
      }
    }
    do
    {
      return;
      String str = paramIntent.getStringExtra("inviteId");
      int i = paramIntent.getIntExtra("dealResult", 1);
      ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramContext, l, str, i);
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.d(paramContext, l + "");
  }
  
  protected boolean c(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    long l = mur.a(paramIntent);
    if (paramString.equals("tencent.video.v2q.insertSystemCall"))
    {
      j(paramIntent, paramQQAppInterface);
      bool = true;
    }
    do
    {
      return bool;
      if (paramString.equals("tencent.video.v2q.upgradeInvite"))
      {
        VideoMsgTools.b(paramQQAppInterface, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("type", 0));
        return true;
      }
      if (paramString.equals("tencent.video.v2q.SmallScreenState"))
      {
        a(paramIntent, l, paramQQAppInterface);
        return true;
      }
      if (paramString.equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO"))
      {
        g(paramIntent, paramQQAppInterface);
        return true;
      }
      if (paramString.equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO"))
      {
        c(paramQQAppInterface, paramContext, paramIntent);
        return true;
      }
      if (paramString.equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END"))
      {
        e(paramIntent, paramQQAppInterface);
        return true;
      }
      if (paramString.equals("tencent.video.v2q.generalFuncCall"))
      {
        k(paramIntent, paramQQAppInterface);
        return true;
      }
      if (paramString.equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED"))
      {
        ((avux)paramQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).b();
        return true;
      }
      if (paramString.equals("tencent.video.v2q.AddMembersToGroup"))
      {
        VideoMsgTools.a(paramQQAppInterface, paramContext, paramIntent);
        return true;
      }
    } while (!"tencent.video.v2q.checkPtuRes".equals(paramString));
    a(paramIntent);
    return true;
  }
  
  void d(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    Object localObject = paramIntent.getStringExtra("peerUin");
    String str1 = paramIntent.getStringExtra("extraUin");
    int k = paramIntent.getIntExtra("stopReason", 0);
    String str3 = paramIntent.getStringExtra("senderUin");
    String str4 = paramIntent.getStringExtra("selfUin");
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool2 = paramIntent.getBooleanExtra("isSystemCalling", false);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    long l3 = paramIntent.getLongExtra(lch.d, 0L);
    long l4 = paramIntent.getLongExtra(lch.jdField_e_of_type_JavaLangString, 0L);
    int n = paramIntent.getIntExtra(lch.f, 0);
    long l5 = paramIntent.getLongExtra(lch.i, 0L);
    long l6 = paramIntent.getLongExtra(lch.j, 0L);
    long l7 = paramIntent.getLongExtra("score_connect_duration", 0L);
    paramIntent.getIntExtra("sessionType", 0);
    long l1;
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
    {
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = String.valueOf(l2);
      }
      l1 = l2;
      if (l2 == 0L) {
        l1 = mrr.a(paramContext);
      }
      bool1 = true;
    }
    for (;;)
    {
      if (AudioHelper.f()) {
        AudioHelper.a("onVideoChatEnd[VideoConstants.ACTION_STOP_VIDEO_CHAT]", paramIntent.getExtras(), true);
      }
      if (i == 26) {
        paramContext = str1;
      }
      for (;;)
      {
        localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject == null) {
          return;
        }
        ((QQAppInterface)localObject).getAVNotifyCenter().a(false);
        if ((k == 4) || (k == 6) || (k == 1)) {
          if (bool1)
          {
            ((QQAppInterface)localObject).getAVNotifyCenter().a(i, paramContext, str1, false);
            ((QQAppInterface)localObject).getAVNotifyCenter().a(8, paramContext, 0);
          }
        }
        label647:
        for (;;)
        {
          ((QQAppInterface)localObject).getAVNotifyCenter().a(28, i, paramContext, str1);
          if ((i == 1) || (i == 1011) || (i == 9500)) {
            break;
          }
          a((QQAppInterface)localObject, paramIntent, k, bool2, str4, str3, str1, i, paramContext, j, str2, l7, l3, l4, n, l5, l6);
          return;
          ((QQAppInterface)localObject).getAVNotifyCenter().a(m, Long.valueOf(l1), false);
          ((QQAppInterface)localObject).getAVNotifyCenter().a(8, m, l1, 0);
          continue;
          if ((k == 0) && ((((QQAppInterface)localObject).getAVNotifyCenter().e() == 3) || (((QQAppInterface)localObject).getAVNotifyCenter().e() == 4)))
          {
            ((QQAppInterface)localObject).getAVNotifyCenter().a(i, paramContext, str1, false);
            ((QQAppInterface)localObject).getAVNotifyCenter().a(8, paramContext, 0);
          }
          else
          {
            if (bool1) {
              if ((str4 != null) && (((QQAppInterface)localObject).getCurrentAccountUin() != null) && (str4.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
              {
                ((QQAppInterface)localObject).getAVNotifyCenter().a(i, paramContext, str1, false);
                ((QQAppInterface)localObject).getAVNotifyCenter().a(8, paramContext, 0);
                ((QQAppInterface)localObject).getAVNotifyCenter().b(false);
              }
            }
            for (;;)
            {
              if (k != 7) {
                break label647;
              }
              String str5 = paramIntent.getStringExtra("actId");
              String str6 = paramIntent.getStringExtra("mp_ext_params");
              if (str5 == null) {
                break;
              }
              VideoMsgTools.a((QQAppInterface)localObject, "https://iyouxi3.vip.qq.com/ams3.0.php?", str5, str6, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener);
              break;
              ((QQAppInterface)localObject).getAVNotifyCenter().a(m, Long.valueOf(l1), false);
              ((QQAppInterface)localObject).getAVNotifyCenter().a(8, m, l1, 0);
              ((QQAppInterface)localObject).getAVNotifyCenter().b(false);
            }
          }
        }
      }
      paramContext = (Context)localObject;
      l1 = l2;
    }
  }
  
  void e(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sessionType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    long l = paramIntent.getLongExtra("roomId", 0L);
    String str = paramIntent.getStringExtra("peerUin");
    boolean bool = paramIntent.getBooleanExtra("isReceiver", false);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal ACTION_VIDEO_ANOTHER_CHATING uinType: " + j + ", peerUin: " + str + ", roomId: " + l + ", isReceiver: " + bool + ",sessionType:" + i);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal app is null");
      return;
    }
    paramContext = (anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramContext != null) && (!paramContext.b(str)) && (i != 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "other terminal chating with: " + str + " , sessionType: " + i + " ,uintype: " + j);
    }
    bapk localbapk = (bapk)localQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (i == 0)
    {
      paramIntent = localQQAppInterface.getAVNotifyCenter().b(l);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal roomId reset peerUin=" + paramIntent);
      localQQAppInterface.getAVNotifyCenter().c(paramIntent);
      paramContext = paramIntent;
      if (localbapk != null)
      {
        paramContext = paramIntent;
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramContext = paramIntent;
          if (j != 1)
          {
            paramContext = paramIntent;
            if (localbapk.a(paramIntent, j) == 7)
            {
              localbapk.a(paramIntent, j, 0);
              paramContext = paramIntent;
            }
          }
        }
      }
      localQQAppInterface.getAVNotifyCenter().a(28, j, paramContext, "");
      return;
    }
    localQQAppInterface.getAVNotifyCenter().a(str, l, i);
    paramIntent = localQQAppInterface.getProxyManager();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.a();
    }
    if ((paramContext != null) && ((RecentUser)paramContext.findRecentUser(str, 0) == null) && (!bool)) {
      if (i != 2) {
        break label507;
      }
    }
    label507:
    for (bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, j, 53, bool, str, localQQAppInterface.getCurrentUin(), true, null, true, new Object[0]);
      paramContext = str;
      if (j == 1) {
        break;
      }
      paramContext = str;
      if (localbapk == null) {
        break;
      }
      paramContext = str;
      if (localbapk.a(str, j) == 6) {
        break;
      }
      localbapk.a(str, j, 7);
      paramContext = str;
      break;
    }
  }
  
  void f(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("friendUin");
    Object localObject = paramIntent.getStringExtra("friendName");
    String str2 = paramIntent.getStringExtra("extraUin");
    String str3 = paramIntent.getStringExtra("replyMsg");
    boolean bool = paramIntent.getBooleanExtra("isDiyMsg", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_MSG_REPLY uinType: " + i + ", friendUin: " + str1 + ", friendNick: " + (String)localObject + ", extraUin: " + str2 + ", replyMsg: " + str3 + ", isDiyMsg: " + bool);
    }
    if (bool)
    {
      paramIntent = AIOUtils.setOpenAIOIntent(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
      paramIntent.putExtra("uintype", i);
      paramIntent.putExtra("uinname", (String)localObject);
      localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        return;
      }
      if (i == 1006)
      {
        paramIntent.putExtra("uin", str2);
        paramContext = paramIntent;
        if (!bhgy.a(((QQAppInterface)localObject).getApp())) {
          break label392;
        }
        paramContext.putExtra("ext_panel_onresume", 2);
      }
      for (;;)
      {
        paramContext.putExtra("enter_ext_panel", 1);
        ((QQAppInterface)localObject).getApp().startActivity(paramContext);
        return;
        if (i == 1000)
        {
          paramIntent.putExtra("uin", str1);
          paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).b(str2);
          paramIntent.putExtra("troop_uin", paramContext.troopcode);
          paramIntent.putExtra("troop_code", paramContext.troopuin);
          paramContext = paramIntent;
          break;
        }
        if (i == 1004)
        {
          paramIntent.putExtra("uin", str1);
          paramIntent.putExtra("troop_uin", str2);
          paramContext = paramIntent;
          break;
        }
        if (i == 1044)
        {
          paramContext = awui.a(paramContext, str1, 21);
          break;
        }
        paramIntent.putExtra("uin", str1);
        paramContext = paramIntent;
        break;
        label392:
        paramContext.putExtra("ext_panel_onresume", 1);
      }
    }
    paramIntent = new Message();
    paramIntent.what = 0;
    paramIntent.obj = new Object[] { Integer.valueOf(i), localObject, str2, str1, paramContext, str3 };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 300L);
  }
  
  void g(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("isPtt", false);
    int i = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("friendUin");
    Object localObject = paramIntent.getStringExtra("friendName");
    String str2 = paramIntent.getStringExtra("extraUin");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_MSG_LEAVE uinType: " + i + ", friendUin: " + str1 + ", friendNick: " + (String)localObject + ", extraUin: " + str2 + ", isPtt: " + bool);
    }
    paramIntent = AIOUtils.setOpenAIOIntent(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
    paramIntent.putExtra("uintype", i);
    paramIntent.putExtra("uinname", (String)localObject);
    localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    if (i == 1006)
    {
      paramIntent.putExtra("uin", str2);
      paramContext = paramIntent;
      label199:
      if (!bhgy.a(((QQAppInterface)localObject).getApp())) {
        break label466;
      }
      paramContext.putExtra("ext_panel_onresume", 2);
      label219:
      if (!bool) {
        break label478;
      }
      paramContext.putExtra("enter_ext_panel", 2);
    }
    for (;;)
    {
      paramIntent = new Message();
      paramIntent.what = 4;
      paramIntent.obj = new Object[] { paramContext };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 300L);
      return;
      if (i == 1000)
      {
        paramIntent.putExtra("uin", str1);
        paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).b(str2);
        if (paramContext == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "findTroopInfo fail ,uin : " + str2);
          return;
        }
        paramIntent.putExtra("troop_uin", paramContext.troopuin);
        paramIntent.putExtra("troop_code", paramContext.troopcode);
        paramContext = paramIntent;
        break label199;
      }
      if (i == 1004)
      {
        paramIntent.putExtra("uin", str1);
        paramIntent.putExtra("troop_uin", str2);
        paramContext = paramIntent;
        break label199;
      }
      if (i == 1044)
      {
        paramContext = awui.a(paramContext, str1, 21);
        bdla.b(null, "dc00898", "", "", "0X800AD97", "0X800AD97", 0, 0, "", "", "", "");
        break label199;
      }
      paramIntent.putExtra("uin", str1);
      paramContext = paramIntent;
      break label199;
      label466:
      paramContext.putExtra("ext_panel_onresume", 1);
      break label219;
      label478:
      paramContext.putExtra("enter_ext_panel", 1);
    }
  }
  
  void h(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("size", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_VIDEO_FLOW_SIZE: " + l);
    }
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {
      return;
    }
    paramContext.sendAppDataIncerment(paramContext.getAccount(), new String[] { "param_XGVideoFlow", "param_XGFlow", "param_Flow" }, l);
  }
  
  void i(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    String str = paramIntent.getStringExtra("extraUin");
    paramIntent = paramIntent.getByteArrayExtra("sig");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    VideoMsgTools.a(localQQAppInterface, i, paramContext, str, paramIntent);
  }
  
  void j(Context paramContext, Intent paramIntent)
  {
    int m = paramIntent.getIntExtra("uinType", -2);
    paramContext = paramIntent.getStringExtra("peerUin");
    int k = paramIntent.getIntExtra("sessionType", 0);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    int j = k;
    int i;
    if (bool) {
      if (k == 3)
      {
        i = 1;
        j = i;
        if (!TextUtils.isEmpty(paramContext)) {
          break label367;
        }
        paramContext = String.valueOf(l2);
      }
    }
    for (;;)
    {
      long l1;
      if ((n == 0) && (l2 == 0L))
      {
        l1 = mrr.a(paramContext);
        label109:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_START_VIDEO_AVSWITCH relationType[" + n + "], relationId[" + l1 + "], sessionType[" + i + "], uinType[" + m + "], peerUin[" + paramContext + "], isDoubleVideoMeeting[" + bool + "]");
        }
        paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramIntent != null) {
          break label262;
        }
      }
      for (;;)
      {
        return;
        i = k;
        if (k != 4) {
          break;
        }
        i = 2;
        break;
        l1 = l2;
        if (n != 3) {
          break label109;
        }
        l1 = l2;
        if (l2 != 0L) {
          break label109;
        }
        l1 = mrr.a(paramContext);
        break label109;
        label262:
        AVNotifyCenter localAVNotifyCenter = paramIntent.getAVNotifyCenter();
        if ((bool) || (n == 0)) {
          localAVNotifyCenter.a(5, paramContext, i);
        }
        while (bool)
        {
          paramIntent.getAVNotifyCenter().a(paramContext, true);
          return;
          localAVNotifyCenter.a(5, n, l1, i);
          paramIntent.getAVNotifyCenter().a(28, m, paramContext, null);
          if (QLog.isDevelopLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 4, "onAvSwitch, SessionType[" + i + "]");
          }
        }
      }
      label367:
      i = j;
    }
  }
  
  void k(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG");
    }
    boolean bool1 = paramIntent.getBooleanExtra("isAudio", false);
    String str1 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("type", 0);
    String str2 = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", false);
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    String str3 = paramIntent.getApp().getString(2131695194);
    BaseApplication localBaseApplication = paramIntent.getApp();
    if (bool1) {}
    for (int i = 2131695191;; i = 2131695195)
    {
      paramContext = a(paramContext, str3, localBaseApplication.getString(i), new aogr(this, paramIntent, j, k, bool1, str1, str2, bool2));
      msa.a(paramIntent.isBackgroundPause, bool1);
      paramIntent = new Message();
      paramIntent.what = 1;
      paramIntent.obj = new Object[] { paramContext, Integer.valueOf(j), Boolean.valueOf(bool1), str1, str2, Boolean.valueOf(bool2) };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
      return;
    }
  }
  
  void l(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG_MULTI");
    }
    String str1 = String.valueOf(paramIntent.getLongExtra("friendUin", 0L));
    String str2 = String.valueOf(paramIntent.getLongExtra("relationId", 0L));
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("type", 0);
    String str3 = paramIntent.getStringExtra("realSenderUin");
    String str4 = paramIntent.getStringExtra("peerUin");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str5 = localQQAppInterface.getApp().getString(2131695194);
    if (i == 3000) {
      paramIntent = ContactUtils.getDiscussionMemberShowName(localQQAppInterface, str2, str1);
    }
    for (;;)
    {
      paramIntent = String.format(localQQAppInterface.getApp().getString(2131695193), new Object[] { paramIntent });
      msa.e(false, true);
      paramContext = a(paramContext, str5, paramIntent, new aogs(this, i, localQQAppInterface, j, str2, str1, str4, str3));
      msa.c(localQQAppInterface.isBackgroundPause);
      paramIntent = new Message();
      paramIntent.what = 2;
      paramIntent.obj = new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), str2, str1, str4, str3 };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
      return;
      if (i == 1) {
        paramIntent = ContactUtils.getTroopMemberNickByTroopCode(localQQAppInterface, str1, str2);
      } else {
        paramIntent = ContactUtils.getFriendDisplayName(localQQAppInterface, str1);
      }
    }
  }
  
  void m(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("status", 0);
    int j = paramIntent.getIntExtra("type", 0);
    long l = paramIntent.getLongExtra("guild_group_id", -1L);
    int k = paramIntent.getIntExtra("guild_member_num", -1);
    paramContext = paramIntent.getStringExtra("sessionName");
    String str1 = paramIntent.getStringExtra("guild_business_type");
    String str2 = paramIntent.getStringExtra("uin");
    String str3 = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_RANDOM_SET_CHAT_STATUS status:" + i + ", type" + j);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    if (i == 0)
    {
      localQQAppInterface.getAVNotifyCenter().a(null);
      localQQAppInterface.getAVNotifyCenter().a(-1L);
      localQQAppInterface.getAVNotifyCenter().a(-1);
      localQQAppInterface.getAVNotifyCenter().b(null);
    }
    for (;;)
    {
      localQQAppInterface.getAVNotifyCenter().a(i, j);
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        localQQAppInterface.getAVNotifyCenter().a(paramContext);
      }
      if (!TextUtils.isEmpty(str2)) {
        localQQAppInterface.getAVNotifyCenter().a(str2, str3, paramIntent);
      }
      localQQAppInterface.getAVNotifyCenter().a(l);
      localQQAppInterface.getAVNotifyCenter().a(k);
      localQQAppInterface.getAVNotifyCenter().b(str1);
    }
  }
  
  void n(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_RANDOM_UPDATE_CHAT_INFO uin:" + paramContext + ", nickName: " + str + ", headUrl: " + paramIntent);
    }
    QQAppInterface localQQAppInterface;
    if (!TextUtils.isEmpty(paramContext))
    {
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQAppInterface != null) {}
    }
    else
    {
      return;
    }
    localQQAppInterface.getAVNotifyCenter().a(paramContext, str, paramIntent);
  }
  
  void o(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "EarlyDownload trigger AV so EarlyDownload");
    }
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        paramContext = (asbm)paramContext.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      } while (paramContext == null);
      paramContext = (asci)paramContext.a("qq.android.qav.muteaudio");
    } while (paramContext == null);
    paramContext.a(false);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onReceive, action[" + str1 + "], seq[" + mur.a(paramIntent) + "]");
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localQQAppInterface = null;
      if ((localQQAppInterface != null) && (str1 != null)) {
        break label89;
      }
    }
    label89:
    boolean bool1;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      String str2 = paramIntent.getPackage();
      if ((TextUtils.isEmpty(str2)) || (!TextUtils.equals(str2, localQQAppInterface.getApp().getPackageName())))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "onReceive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + str1);
        return;
      }
      boolean bool2 = a(str1, paramContext, paramIntent);
      bool1 = bool2;
      if (!bool2) {
        bool1 = a(localQQAppInterface, str1, paramContext, paramIntent);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = b(localQQAppInterface, str1, paramContext, paramIntent);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = c(localQQAppInterface, str1, paramContext, paramIntent);
      }
    } while ((bool1) || (!QLog.isDevelopLevel()));
    QLog.i(jdField_a_of_type_JavaLangString, 4, "onReceive, no deal action[" + str1 + "]");
  }
  
  void p(Context paramContext, Intent paramIntent)
  {
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {
      return;
    }
    paramIntent = paramContext.getApp().getString(2131695457);
    String str = paramContext.getApp().getString(2131695436);
    paramContext = bhdj.a(paramContext.getApp().getApplicationContext(), 230, str, paramIntent, 2131690697, 2131695367, new aogt(this), null);
    paramContext.getWindow().setType(2003);
    paramContext.show();
    paramIntent = new Message();
    paramIntent.what = 3;
    paramIntent.obj = new Object[] { paramContext };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */