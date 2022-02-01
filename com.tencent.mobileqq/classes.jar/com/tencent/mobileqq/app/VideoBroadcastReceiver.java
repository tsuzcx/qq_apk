package com.tencent.mobileqq.app;

import abwp;
import abwz;
import aezp;
import amqx;
import amsw;
import amtj;
import anaj;
import anca;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import anea;
import aneb;
import anec;
import aned;
import anee;
import anef;
import anuz;
import aqxc;
import aqxy;
import aupc;
import avnf;
import avnj;
import avod;
import aynd;
import azjc;
import azjg;
import bbko;
import bbli;
import bbxj;
import bcef;
import bchh;
import bfur;
import bfxn;
import bfyg;
import bfyv;
import bfyz;
import bgdt;
import bgqr;
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
import dov.com.qq.im.ae.download.AEResInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lcc;
import lmr;
import lws;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqu;
import mrd;
import mrz;
import mst;
import mti;
import mtt;
import mum;
import muq;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  static VideoBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver;
  public static String a;
  INetEngine.INetEngineListener jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new anee(this);
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
    this.jdField_a_of_type_MqqOsMqqHandler = new anef(Looper.getMainLooper(), this);
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
    azjc localazjc = (azjc)localQQAppInterface.getManager(38);
    if (localazjc != null)
    {
      if ((paramInt1 != 3) && (paramInt1 != 4)) {
        break label136;
      }
      localazjc.a(paramInt2, paramString1, paramString2, paramString3, 8);
    }
    for (;;)
    {
      try
      {
        paramString2 = bbli.a(-4008);
        paramString2.selfuin = localQQAppInterface.getCurrentAccountUin();
        paramString2.frienduin = paramString1;
        paramString2.senderuin = paramString3;
        paramString2.msgtype = -4008;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = paramInt2;
        paramString2.time = bbko.a();
        localQQAppInterface.receivedMsgNotificationForQAV(1, true, true, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label136:
      localazjc.a(paramInt2, paramString1, paramString2, paramString3, 2);
    }
  }
  
  private void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (((paramInt == 3000) || (paramInt == 1)) && (paramString != null))
    {
      paramQQAppInterface.getAVNotifyCenter().a(12, mum.b(paramInt), Long.valueOf(paramString).longValue(), null, 0L);
      paramQQAppInterface.getAVNotifyCenter().a(21, mum.b(paramInt), Long.valueOf(paramString).longValue(), 0L);
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    int i = paramIntent.getIntExtra("uinType", 0);
    String str2 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("effectId", 0);
    ThemeBackground.setThemeBackgroundPic(paramContext, "theme_bg_aio_path", paramQQAppInterface.getAccount(), str1, "", "", "", 0, null, false);
    aezp.a(paramContext, paramQQAppInterface.getAccount(), str2, str1, j, i);
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
      i = paramIntent.getIntExtra("packageIdx", AEResInfo.AE_RES_BASE_PACKAGE.index);
      bool2 = false;
      if (i != AEResInfo.AE_RES_BASE_PACKAGE.index) {
        break label144;
      }
      bool1 = bool2;
      if (localQQAppInterface != null)
      {
        paramIntent = new lws(localQQAppInterface);
        bool1 = bbxj.a(localQQAppInterface, localQQAppInterface.getApplication().getApplicationContext(), paramIntent);
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
      label144:
      bool1 = bool2;
      if (i == AEResInfo.AE_RES_ADDITIONAL_PACKAGE.index)
      {
        bool1 = bool2;
        if (localQQAppInterface != null)
        {
          bbxj.a(new lws(localQQAppInterface));
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
    paramIntent = (azjc)paramQQAppInterface.getManager(38);
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
    //   3: getstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	com/tencent/mobileqq/app/VideoBroadcastReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 357	com/tencent/mobileqq/app/VideoBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   20: ldc 2
    //   22: monitorexit
    //   23: new 359	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 360	android/content/IntentFilter:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc_w 362
    //   35: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: ldc_w 367
    //   42: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: ldc_w 369
    //   49: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc_w 371
    //   56: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w 373
    //   63: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 375
    //   70: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc_w 377
    //   77: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ldc_w 379
    //   84: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: ldc_w 381
    //   91: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: ldc_w 383
    //   98: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: ldc_w 385
    //   105: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: ldc_w 387
    //   112: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc_w 389
    //   119: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: ldc_w 391
    //   126: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: ldc_w 393
    //   133: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: ldc_w 395
    //   140: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: ldc_w 397
    //   147: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: ldc_w 399
    //   154: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: ldc_w 401
    //   161: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: ldc_w 403
    //   168: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   171: aload_1
    //   172: ldc_w 405
    //   175: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   178: aload_1
    //   179: ldc_w 407
    //   182: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   185: aload_1
    //   186: ldc_w 409
    //   189: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: ldc_w 411
    //   196: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc_w 413
    //   203: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   206: aload_1
    //   207: ldc_w 415
    //   210: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc_w 417
    //   217: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   220: aload_1
    //   221: ldc_w 419
    //   224: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   227: aload_1
    //   228: ldc_w 421
    //   231: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   234: aload_1
    //   235: ldc_w 423
    //   238: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: ldc_w 425
    //   245: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   248: aload_1
    //   249: ldc_w 427
    //   252: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: ldc_w 429
    //   259: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   262: aload_1
    //   263: ldc_w 431
    //   266: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   269: aload_1
    //   270: ldc_w 433
    //   273: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   276: aload_1
    //   277: ldc_w 435
    //   280: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: ldc_w 437
    //   287: invokevirtual 365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   290: aload_0
    //   291: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   294: getstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   297: aload_1
    //   298: ldc_w 439
    //   301: aconst_null
    //   302: invokevirtual 443	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   305: pop
    //   306: getstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   309: iconst_1
    //   310: putfield 25	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_Boolean	Z
    //   313: return
    //   314: astore_0
    //   315: ldc 2
    //   317: monitorexit
    //   318: aload_0
    //   319: athrow
    //   320: astore_0
    //   321: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq -11 -> 313
    //   327: getstatic 18	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: iconst_2
    //   331: new 255	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 445
    //   341: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 448	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    paramQQAppInterface = (azjc)paramQQAppInterface.getManager(38);
    if (paramQQAppInterface != null) {}
    try
    {
      paramQQAppInterface.a().a(paramString1, paramInt1).isSystemCall = 0;
      label27:
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
      break label27;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, SharedPreferences paramSharedPreferences, int paramInt3, boolean paramBoolean)
  {
    int i = paramSharedPreferences.getInt(lcc.c, 0) + 1;
    boolean bool2 = paramSharedPreferences.getBoolean(lcc.l, false);
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
      mti.a("{\n" + lcc.d + ":" + paramLong1 + ",\n" + lcc.jdField_e_of_type_JavaLangString + ":" + paramLong2 + ",\n" + lcc.f + ":" + paramInt2 + ",\n" + lcc.i + ":" + paramLong3 + ",\n" + lcc.j + ":" + paramLong4 + ",\n" + lcc.k + ":" + paramString + "\n}");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addTipsVideoMsg beginTime: " + paramLong1 + ", endTime: " + paramLong2 + ", sdkVersion: " + paramInt2 + ", bussinessType: " + paramLong3 + ", bussinessFlag: " + paramLong4 + ",toUin: " + paramString);
      }
      VideoMsgTools.a(paramQQAppInterface, paramInt1, 61, true, paramString, null);
      paramInt1 = 0;
      paramSharedPreferences.edit().putBoolean(lcc.l, false).commit();
    }
    for (;;)
    {
      paramSharedPreferences.edit().putInt(lcc.c, paramInt1).commit();
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
        paramString3 = (azjc)paramQQAppInterface.getManager(38);
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
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, azjc paramazjc)
  {
    paramazjc.a(paramString2, paramInt1, 0);
    paramazjc = bfyz.e(paramQQAppInterface.getCurrentAccountUin());
    int i = paramazjc.getInt("qav_score_switch", 0);
    int j = paramazjc.getInt("qav_score_rate", 5);
    int k = paramazjc.getInt("qav_score_time", 0);
    if ((paramString1 != null) && (i == 1) && (j != 0) && (paramLong1 >= k) && (mrz.a("qav_score_good.jpg")) && (mrz.a("qav_score_normal.jpg")) && (mrz.a("qav_score_bad.jpg"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = false;
      if (AudioHelper.a(17) == 1)
      {
        AudioHelper.a(amtj.a(2131715126));
        bool2 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onVideoChatEnd, scoreSwitch[" + i + "], scoreRate[" + j + "], scoreTime[" + k + "], duration[" + paramLong1 + "], show1[" + bool1 + "], forceShow[" + bool2 + "]");
      }
      if (((bool2) || (bool1)) && (paramString1 != null)) {
        a(paramQQAppInterface, paramInt1, paramString2, paramLong2, paramLong3, paramInt2, paramLong4, paramLong5, paramazjc, j, bool2);
      }
      return;
    }
  }
  
  private boolean a(String paramString, Context paramContext, Intent paramIntent)
  {
    long l = mtt.a(paramIntent);
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
    paramIntent = (azjc)paramQQAppInterface.getManager(38);
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
        paramIntent = mst.a((ArrayList)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + paramIntent);
        }
        localObject = (azjc)paramQQAppInterface.getManager(38);
      } while (localObject == null);
      ((azjc)localObject).a(0, l, "", paramIntent);
      paramIntent = (amqx)paramQQAppInterface.getBusinessHandler(6);
    } while ((paramIntent == null) || (paramIntent.a() == null));
    paramIntent.a().e(String.valueOf(l));
  }
  
  private void e(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
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
    if ((i > 0) && (bgqr.b()))
    {
      paramIntent = (bgqr)paramQQAppInterface.getManager(84);
      if (paramIntent != null) {
        paramIntent.a(i, bgqr.a(), false, 0);
      }
    }
  }
  
  private void i(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("comming_ring_down_key", 0);
    if ((i > 0) && (bgqr.b()))
    {
      ((bgdt)paramQQAppInterface.getManager(45)).a(i, 3, false, 0, "comering");
      int j = ((anaj)paramQQAppInterface.getBusinessHandler(13)).g();
      bcef.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + j, i + "", "", "");
    }
  }
  
  private void j(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    azjc localazjc = paramQQAppInterface.getCallFacade();
    if (localazjc != null)
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
      localazjc.b(paramIntent);
    }
  }
  
  private void k(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    AbsStructMsg localAbsStructMsg;
    if ("SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")))
    {
      localAbsStructMsg = bchh.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg != null) {}
    }
    else
    {
      return;
    }
    bfyv.a(paramQQAppInterface, paramIntent.getStringExtra("uin"), paramIntent.getIntExtra("uintype", -1), localAbsStructMsg, null);
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
    label507:
    label508:
    for (;;)
    {
      return;
      int i;
      if (((k == 2) || (k == 24)) && (paramContext == null) && (bfyg.a(localQQAppInterface.getApp())))
      {
        boolean bool4 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131693533), "qqsetting_lock_screen_whenexit_key", true);
        boolean bool5 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131717796), "qqsetting_notify_showcontent_key", true);
        a(localQQAppInterface, bool4, bool5);
        if ((bool4) && (bool5))
        {
          i = 1;
          if (k != 17) {
            break label507;
          }
          paramContext = String.valueOf(m);
        }
      }
      for (;;)
      {
        if ((n == 2) && (str1 != null) && (!a(localQQAppInterface, str1, k))) {
          break label508;
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
        paramContext = (avnj)localQQAppInterface.getManager(72);
        paramContext.a(localQQAppInterface, str1, j, true, avnf.a(str1, j, paramIntent), true);
        paramContext.a(localQQAppInterface, str1, j, true, avnf.a(str1, j, paramIntent));
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
      if (((amsw)paramQQAppInterface.getManager(51)).b(str1))
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
    aynd.a(paramQQAppInterface, paramQQAppInterface.getApp(), str2, str1, 0, -1);
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
          paramInt2 = mum.c(i);
          if ((paramInt2 != -1) && (paramInt2 != 1011) && (!TextUtils.isEmpty(paramIntent)))
          {
            if (paramInt2 != 1) {
              break label446;
            }
            TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
            if ((localTroopManager != null) && (localTroopManager.b(paramIntent) != null))
            {
              paramIntent = (RecentUser)paramContext.findRecentUserByUin(paramIntent, paramInt2);
              if (paramIntent != null)
              {
                paramIntent.lastmsgtime = bbko.a();
                paramContext.saveRecentUser(paramIntent);
              }
            }
          }
        }
        label245:
        if ((i != 1) && (i != 7) && (i != 9) && (i != 10))
        {
          paramContext = (azjc)paramQQAppInterface.getManager(38);
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
      label446:
      paramIntent = (RecentUser)paramContext.findRecentUserByUin(paramIntent, paramInt2);
      if (paramIntent == null) {
        break label245;
      }
      paramIntent.lastmsgtime = bbko.a();
      paramContext.saveRecentUser(paramIntent);
      break label245;
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
        if ((!abwz.b(paramString1, paramInt1)) && (abwz.t(paramInt1)) && (!paramQQAppInterface.getConversationFacade().b(paramString1, paramInt1))) {
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
        paramString1.lastmsgtime = bbko.a();
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
      lmr locallmr = paramQQAppInterface.getAVNotifyCenter().a(l, 2);
      if ((locallmr != null) && (locallmr.a > 0) && (paramInt == 13)) {
        return false;
      }
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
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
        localObject = (azjc)paramIntent.getManager(38);
        if (!bool2) {
          break label408;
        }
        ((azjc)localObject).a(paramContext, i, 6);
      }
    }
    for (;;)
    {
      try
      {
        if ((!abwz.b(paramContext, i)) && (abwz.t(i)) && (!paramIntent.getConversationFacade().b(paramContext, i))) {
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
        paramContext.lastmsgtime = bbko.a();
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
      label408:
      ((azjc)localObject).a(paramContext, i, 5);
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
      paramQQAppInterface = (muq)paramQQAppInterface.getBusinessHandler(39);
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
        paramContext = (azjc)paramQQAppInterface.getManager(38);
        if (paramContext != null) {
          paramContext.a(l1, l2, false, l3, paramBoolean);
        }
      }
      bfxn.a(paramQQAppInterface, paramIntent, i, l1);
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
        j = mum.b(i);
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
      ((anca)paramQQAppInterface.getBusinessHandler(20)).a(paramContext, l, str, i);
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.d(paramContext, l + "");
  }
  
  protected boolean c(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    long l = mtt.a(paramIntent);
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
        ((aupc)paramQQAppInterface.getManager(306)).b();
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
    long l3 = paramIntent.getLongExtra(lcc.d, 0L);
    long l4 = paramIntent.getLongExtra(lcc.jdField_e_of_type_JavaLangString, 0L);
    int n = paramIntent.getIntExtra(lcc.f, 0);
    long l5 = paramIntent.getLongExtra(lcc.i, 0L);
    long l6 = paramIntent.getLongExtra(lcc.j, 0L);
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
        l1 = mqu.a(paramContext);
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
    paramContext = (amsw)localQQAppInterface.getManager(51);
    if ((paramContext != null) && (!paramContext.b(str)) && (i != 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "other terminal chating with: " + str + " , sessionType: " + i + " ,uintype: " + j);
    }
    azjc localazjc = (azjc)localQQAppInterface.getManager(38);
    if (i == 0)
    {
      paramIntent = localQQAppInterface.getAVNotifyCenter().b(l);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal roomId reset peerUin=" + paramIntent);
      localQQAppInterface.getAVNotifyCenter().c(paramIntent);
      paramContext = paramIntent;
      if (localazjc != null)
      {
        paramContext = paramIntent;
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramContext = paramIntent;
          if (j != 1)
          {
            paramContext = paramIntent;
            if (localazjc.a(paramIntent, j) == 7)
            {
              localazjc.a(paramIntent, j, 0);
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
        break label505;
      }
    }
    label505:
    for (bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, j, 53, bool, str, localQQAppInterface.getCurrentUin(), true, null, true, new Object[0]);
      paramContext = str;
      if (j == 1) {
        break;
      }
      paramContext = str;
      if (localazjc == null) {
        break;
      }
      paramContext = str;
      if (localazjc.a(str, j) == 6) {
        break;
      }
      localazjc.a(str, j, 7);
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
        if (!bfyg.a(((QQAppInterface)localObject).getApp())) {
          break label391;
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
          paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(52)).b(str2);
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
          paramContext = avod.a(paramContext, str1, 21);
          break;
        }
        paramIntent.putExtra("uin", str1);
        paramContext = paramIntent;
        break;
        label391:
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
      if (!bfyg.a(((QQAppInterface)localObject).getApp())) {
        break label465;
      }
      paramContext.putExtra("ext_panel_onresume", 2);
      label219:
      if (!bool) {
        break label477;
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
        paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(52)).b(str2);
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
        paramContext = avod.a(paramContext, str1, 21);
        bcef.b(null, "dc00898", "", "", "0X800AD97", "0X800AD97", 0, 0, "", "", "", "");
        break label199;
      }
      paramIntent.putExtra("uin", str1);
      paramContext = paramIntent;
      break label199;
      label465:
      paramContext.putExtra("ext_panel_onresume", 1);
      break label219;
      label477:
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
    paramContext = paramIntent.getStringExtra("peerUin");
    int k = paramIntent.getIntExtra("sessionType", 0);
    int m = paramIntent.getIntExtra("relationType", 0);
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
          break label270;
        }
        paramContext = String.valueOf(l2);
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (m == 0)
      {
        l1 = l2;
        if (l2 == 0L) {
          l1 = mqu.a(paramContext);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_START_VIDEO_AVSWITCH relationType[" + m + "], relationId[" + l1 + "], sessionType[" + i + "], peerUin[" + paramContext + "], isDoubleVideoMeeting[" + bool + "]");
      }
      paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramIntent == null) {}
      for (;;)
      {
        return;
        i = k;
        if (k != 4) {
          break;
        }
        i = 2;
        break;
        if ((bool) || (m == 0)) {
          paramIntent.getAVNotifyCenter().a(5, paramContext, i);
        }
        while (bool)
        {
          paramIntent.getAVNotifyCenter().a(paramContext, true);
          return;
          paramIntent.getAVNotifyCenter().a(5, m, l1, i);
        }
      }
      label270:
      i = j;
    }
  }
  
  void k(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG");
    }
    boolean bool1 = paramIntent.getBooleanExtra("isAudio", false);
    paramContext = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("type", 0);
    String str = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", false);
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = paramIntent.getApp().getString(2131694978);
    Object localObject2 = ContactUtils.getFriendDisplayName(paramIntent, paramContext);
    if (((String)localObject2).length() > 10) {
      new StringBuilder().append(((String)localObject2).substring(0, 4)).append("...").toString();
    }
    localObject2 = paramIntent.getApp();
    if (bool1) {}
    for (int i = 2131694975;; i = 2131694979)
    {
      localObject2 = ((BaseApplication)localObject2).getString(i);
      localObject1 = bfur.a(paramIntent.getApp().getApplicationContext(), 230, (String)localObject1, (String)localObject2, 2131690620, 2131695151, new anea(this, paramIntent, j, k, bool1, paramContext, str, bool2), null);
      ((QQCustomDialog)localObject1).show();
      mrd.a(paramIntent.isBackgroundPause, bool1);
      paramIntent = new Message();
      paramIntent.what = 1;
      paramIntent.obj = new Object[] { localObject1, Integer.valueOf(j), Boolean.valueOf(bool1), paramContext, str, Boolean.valueOf(bool2) };
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
    String str5 = localQQAppInterface.getApp().getString(2131694978);
    if (i == 3000)
    {
      paramIntent = ContactUtils.getDiscussionMemberShowName(localQQAppInterface, str2, str1);
      paramIntent = String.format(localQQAppInterface.getApp().getString(2131694977), new Object[] { paramIntent });
      mrd.e(false, true);
      if (!GesturePWDUtils.isAppOnForegroundByTasks(localQQAppInterface.getApp().getApplicationContext())) {
        break label325;
      }
      paramContext = PopupDialog.a(localQQAppInterface.getApp().getApplicationContext(), 230, str5, paramIntent, 2131690620, 2131694201, new aneb(this, i, localQQAppInterface, j, str2, str1, str4, str3), null);
    }
    for (;;)
    {
      mrd.c(localQQAppInterface.isBackgroundPause);
      paramIntent = new Message();
      paramIntent.what = 2;
      paramIntent.obj = new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), str2, str1, str4, str3 };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
      return;
      if (i == 1)
      {
        paramIntent = ContactUtils.getTroopMemberNickByTroopCode(localQQAppInterface, str1, str2);
        break;
      }
      paramIntent = ContactUtils.getFriendDisplayName(localQQAppInterface, str1);
      break;
      label325:
      paramIntent = bfur.a(localQQAppInterface.getApp().getApplicationContext(), 230, str5, paramIntent, 2131690620, 2131694201, new anec(this, i, localQQAppInterface, j, str2, str1, str4, str3), null);
      if (Build.VERSION.SDK_INT >= 26) {
        paramIntent.getWindow().setType(2038);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (Settings.canDrawOverlays(paramContext))
          {
            paramIntent.show();
            paramContext = paramIntent;
            break;
            paramIntent.getWindow().setType(2003);
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, "can not DrawOverlays oncallingDialogMulti()!!");
          paramContext = paramIntent;
          break;
        }
      }
      paramIntent.show();
      paramContext = paramIntent;
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
        paramContext = (aqxc)paramContext.getManager(77);
      } while (paramContext == null);
      paramContext = (aqxy)paramContext.a("qq.android.qav.muteaudio");
    } while (paramContext == null);
    paramContext.a(false);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onReceive, action[" + str1 + "], seq[" + mtt.a(paramIntent) + "]");
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
    paramIntent = paramContext.getApp().getString(2131695240);
    String str = paramContext.getApp().getString(2131695219);
    paramContext = bfur.a(paramContext.getApp().getApplicationContext(), 230, str, paramIntent, 2131690620, 2131695151, new aned(this), null);
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