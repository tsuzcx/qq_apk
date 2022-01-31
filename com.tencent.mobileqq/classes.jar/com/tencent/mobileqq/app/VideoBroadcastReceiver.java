package com.tencent.mobileqq.app;

import abta;
import abti;
import aepi;
import aeqq;
import alri;
import alto;
import alud;
import amca;
import amdu;
import amfm;
import amfn;
import amfo;
import amfp;
import amfq;
import amfr;
import amnz;
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
import apks;
import aplq;
import apls;
import atdh;
import atzx;
import auab;
import auau;
import awrt;
import axap;
import axat;
import ayzl;
import azaf;
import azqs;
import azri;
import azvd;
import baug;
import bdgc;
import bdgm;
import bdjn;
import bdjz;
import bdmh;
import bdna;
import bdne;
import bdse;
import becr;
import com.tencent.av.VideoConstants;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lpp;
import mqq.os.MqqHandler;
import mti;
import mtq;
import mum;
import mvg;
import mvs;
import mwd;
import mww;
import mxa;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  static VideoBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver;
  public static String a;
  baug jdField_a_of_type_Baug = new amfq(this);
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
    this.jdField_a_of_type_MqqOsMqqHandler = new amfr(Looper.getMainLooper(), this);
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
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    axap localaxap = (axap)localQQAppInterface.getManager(38);
    if (localaxap != null)
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        break label126;
      }
      localaxap.a(paramString1, paramString2, paramString3, 8);
    }
    for (;;)
    {
      try
      {
        paramString2 = azaf.a(-4008);
        paramString2.selfuin = localQQAppInterface.getCurrentAccountUin();
        paramString2.frienduin = paramString1;
        paramString2.senderuin = paramString3;
        paramString2.msgtype = -4008;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = 3000;
        paramString2.time = ayzl.a();
        localQQAppInterface.a(1, true, true, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label126:
      localaxap.a(paramString1, paramString2, paramString3, 2);
    }
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
    //   14: invokespecial 130	com/tencent/mobileqq/app/VideoBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   20: ldc 2
    //   22: monitorexit
    //   23: new 132	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 133	android/content/IntentFilter:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 135
    //   34: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: ldc 141
    //   40: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: ldc 143
    //   46: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: ldc 145
    //   52: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: ldc 147
    //   58: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: ldc 149
    //   64: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: ldc 151
    //   70: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc 153
    //   76: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: ldc 155
    //   82: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: ldc 157
    //   88: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: ldc 159
    //   94: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: ldc 161
    //   100: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: ldc 163
    //   106: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc 165
    //   112: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc 167
    //   118: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   121: aload_1
    //   122: ldc 169
    //   124: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   127: aload_1
    //   128: ldc 171
    //   130: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   133: aload_1
    //   134: ldc 173
    //   136: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: ldc 175
    //   142: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: ldc 177
    //   148: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: ldc 179
    //   154: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: ldc 181
    //   160: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: ldc 183
    //   166: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   169: aload_1
    //   170: ldc 185
    //   172: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: ldc 187
    //   178: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   181: aload_1
    //   182: ldc 189
    //   184: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: ldc 191
    //   190: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: ldc 193
    //   196: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc 195
    //   202: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: ldc 197
    //   208: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   211: aload_1
    //   212: ldc 199
    //   214: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   217: aload_1
    //   218: ldc 201
    //   220: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: ldc 203
    //   226: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 205
    //   232: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: ldc 207
    //   238: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: ldc 209
    //   244: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   247: aload_1
    //   248: ldc 211
    //   250: invokevirtual 139	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   253: aload_0
    //   254: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   257: getstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   260: aload_1
    //   261: ldc 213
    //   263: aconst_null
    //   264: invokevirtual 217	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   267: pop
    //   268: getstatic 55	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   271: iconst_1
    //   272: putfield 25	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_Boolean	Z
    //   275: return
    //   276: astore_0
    //   277: ldc 2
    //   279: monitorexit
    //   280: aload_0
    //   281: athrow
    //   282: astore_0
    //   283: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -11 -> 275
    //   289: getstatic 18	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   292: iconst_2
    //   293: new 225	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   300: ldc 228
    //   302: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramQQAppInterface	QQAppInterface
    //   30	231	1	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   3	20	276	finally
    //   20	23	276	finally
    //   277	280	276	finally
    //   253	275	282	java/lang/Exception
  }
  
  void a(long paramLong, Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 20);
    boolean bool1 = paramIntent.getBooleanExtra("isStart", false);
    int m = paramIntent.getIntExtra("MultiAVType", 0);
    if ((AudioHelper.e()) || (i == 22) || (i == 23) || (i == 25)) {
      AudioHelper.a(jdField_a_of_type_JavaLangString + ".onMultiMsgV2Q", paramIntent.getExtras());
    }
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {}
    label292:
    label603:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            long l1;
            do
            {
              do
              {
                do
                {
                  int j;
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        if (QLog.isDevelopLevel()) {
                          QLog.i(jdField_a_of_type_JavaLangString, 4, "onMultiMsgV2Q, type[" + i + "]");
                        }
                        if (i == 22)
                        {
                          j = paramIntent.getIntExtra("relationType", 0);
                          paramLong = paramIntent.getLongExtra("relationId", 0L);
                          l1 = paramIntent.getLongExtra("friendUin", 0L);
                          k = paramIntent.getIntExtra("roomUserNum", 0);
                          paramContext.a().a(9, j, paramLong, 3);
                          if (l1 == Long.valueOf(paramContext.getCurrentAccountUin()).longValue())
                          {
                            paramContext.a().a(j, Long.valueOf(paramLong), true);
                            paramContext.a().a(9, j, paramLong, 3);
                            paramContext.a().a(j, paramLong);
                            paramContext.a().b(12, paramLong, m);
                            if (k == 1)
                            {
                              paramContext.a().a(j, paramLong, true, false);
                              paramIntent = paramContext.a().a();
                              if (paramIntent != null)
                              {
                                localObject = String.valueOf(paramLong);
                                m = mww.c(j);
                                if ((m != -1) && (m != 1011) && (!TextUtils.isEmpty((CharSequence)localObject)))
                                {
                                  if (m != 1) {
                                    break label603;
                                  }
                                  TroopManager localTroopManager = (TroopManager)paramContext.getManager(52);
                                  if ((localTroopManager != null) && (localTroopManager.b((String)localObject) != null))
                                  {
                                    localObject = paramIntent.a((String)localObject, m);
                                    if (localObject != null)
                                    {
                                      ((RecentUser)localObject).lastmsgtime = ayzl.a();
                                      paramIntent.a((RecentUser)localObject);
                                    }
                                  }
                                }
                              }
                              if ((j != 1) && (j != 7) && (j != 9) && (j != 10))
                              {
                                paramIntent = (axap)paramContext.getManager(38);
                                if (paramIntent != null) {
                                  paramIntent.a(paramLong, l1, true, -1L, bool1);
                                }
                              }
                              if ((paramContext.a().b() == paramLong) && (paramContext.a().b() >= 4) && (paramContext.a().f()))
                              {
                                paramContext.a().b(true);
                                paramContext.a().d(true);
                              }
                            }
                          }
                          for (;;)
                          {
                            paramContext.a().a(i, j, paramLong, l1);
                            if (!QLog.isColorLevel()) {
                              break;
                            }
                            QLog.d(jdField_a_of_type_JavaLangString, 2, "member join discussId: " + paramLong + ", friendUin: " + l1 + ", roomUserNum:" + k);
                            return;
                            paramContext.a().a(j, paramLong, false, false);
                            paramContext.a().b(true);
                            break label292;
                            localObject = paramIntent.a((String)localObject, m);
                            if (localObject == null) {
                              break label404;
                            }
                            ((RecentUser)localObject).lastmsgtime = ayzl.a();
                            paramIntent.a((RecentUser)localObject);
                            break label404;
                            if ((paramContext.a().b() == paramLong) && (paramContext.a().f()))
                            {
                              paramContext.a().a(j, paramLong, false, false);
                              paramContext.a().b(true);
                              paramContext.a().d(true);
                            }
                          }
                        }
                        if (i != 23) {
                          break;
                        }
                        j = paramIntent.getIntExtra("relationType", 0);
                        paramLong = paramIntent.getLongExtra("relationId", 0L);
                        l1 = paramIntent.getLongExtra("friendUin", 0L);
                        k = paramIntent.getIntExtra("roomUserNum", 0);
                        if (l1 == Long.valueOf(paramContext.getCurrentAccountUin()).longValue())
                        {
                          long l2 = paramIntent.getLongExtra("time", 0L);
                          paramContext.a().a(9, j, paramLong, 0);
                          paramContext.a().a(j, Long.valueOf(paramLong), false);
                          paramContext.a().a(j, paramLong, m);
                          paramContext.a().a(9, j, paramLong, 0);
                          paramContext.a().b(false);
                          if (j != 1)
                          {
                            localObject = (axap)paramContext.getManager(38);
                            if (localObject != null) {
                              ((axap)localObject).a(paramLong, l1, false, l2, bool1);
                            }
                          }
                          bdjn.a(paramContext, paramIntent, j, paramLong);
                        }
                        if (k == 1) {
                          paramContext.a().a(j, paramLong, true, false);
                        }
                        paramContext.a().a(i, j, paramLong, l1);
                      } while (!QLog.isColorLevel());
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "member quit discussId: " + paramLong + ", friendUin: " + l1);
                      return;
                      if (i != 32) {
                        break;
                      }
                      paramLong = paramIntent.getLongExtra("relationId", -1L);
                      j = paramIntent.getIntExtra("uinType", -1);
                    } while (j != 1);
                    l1 = paramIntent.getIntExtra("closeType", 1);
                    paramContext.a().a(i, j, paramLong, l1, m);
                    return;
                    if (i != 33) {
                      break;
                    }
                    paramLong = paramIntent.getLongExtra("relationId", -1L);
                    j = paramIntent.getIntExtra("uinType", -1);
                    l1 = paramIntent.getLongExtra("info", -1L);
                    paramIntent = paramIntent.getStringExtra("strMsg");
                  } while (j != 1);
                  paramContext.a().a(i, j, paramLong, l1, paramIntent);
                  return;
                  if (i != 25) {
                    break;
                  }
                  paramLong = paramIntent.getLongExtra("relationId", -1L);
                  int n = paramIntent.getIntExtra("relationType", -1);
                  i = paramIntent.getIntExtra("reason", -1);
                  boolean bool2 = paramIntent.getBooleanExtra("openClass", false);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_ROOM_DESTROY-->relationid=" + paramLong + " relationType=" + n + " reason=" + i + " avtype" + m);
                  }
                  if (i == 4) {
                    paramContext.a().a(32, 1, paramLong, i, m);
                  }
                  bool1 = bool2;
                  if (!bool2)
                  {
                    bool1 = bool2;
                    if (n == 1)
                    {
                      bool1 = bool2;
                      if (m == 2)
                      {
                        paramIntent = paramContext.a().a(paramLong, m);
                        bool1 = bool2;
                        if (paramIntent != null)
                        {
                          bool1 = bool2;
                          if (paramIntent.d == 2)
                          {
                            bool1 = bool2;
                            if (paramIntent.jdField_e_of_type_Int == 4) {
                              bool1 = true;
                            }
                          }
                        }
                      }
                    }
                  }
                  paramIntent = paramContext.a();
                  if (bool1)
                  {
                    i = 2;
                    if (!bool1) {
                      break label1432;
                    }
                    j = 4;
                    if (!bool1) {
                      break label1438;
                    }
                  }
                  for (int k = 0;; k = -1)
                  {
                    paramIntent.a(9, paramLong, m, i, j, k, 25, 0);
                    if (paramContext.a().a(n, paramLong) <= 0L) {
                      break label1444;
                    }
                    paramContext.a().a(13, n, paramLong, null, 0L);
                    VideoMsgTools.a(paramContext, n, 14, false, String.valueOf(paramLong), paramContext.getCurrentAccountUin(), false, null, false, m, new Object[0]);
                    paramContext.a().a(21, n, paramLong, 0L);
                    return;
                    i = 0;
                    break;
                    j = 0;
                    break label1330;
                  }
                } while (!QLog.isColorLevel());
                QLog.w(jdField_a_of_type_JavaLangString, 2, "MultiRoomMemberNum is 0");
                return;
                if (i != 401) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN");
                }
                i = paramIntent.getIntExtra("relationType", 0);
                paramLong = paramIntent.getLongExtra("relationId", 0L);
                l1 = paramIntent.getLongExtra("friendUin", 0L);
                if (QLog.isColorLevel()) {
                  QLog.d("AVShare", 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN, relationType[" + i + "], relationId[" + paramLong + "], friendUin[" + l1 + "]");
                }
                if (l1 == paramLong) {
                  paramContext.a().a(0, Long.valueOf(paramLong), true);
                }
                paramContext.a().a(String.valueOf(paramLong), true);
              } while (l1 != paramLong);
              paramContext.a().d(true);
              paramContext.a().b(true);
              return;
              if (i != 402) {
                break;
              }
              i = paramIntent.getIntExtra("relationType", 0);
              paramLong = paramIntent.getLongExtra("relationId", 0L);
              l1 = paramIntent.getLongExtra("friendUin", 0L);
              if (QLog.isColorLevel()) {
                QLog.d("AVShare", 2, "TYPE_DOUBLE_MEETING_MEMBER_LEAVE, relationType[" + i + "], relationId[" + paramLong + "], friendUin[" + l1 + "]");
              }
              paramContext.a().a(String.valueOf(paramLong), false);
              paramContext.a().b(false);
              paramContext = (axap)paramContext.getManager(38);
            } while (paramContext == null);
            paramContext.a("" + l1, 0, 0);
            return;
            if (i == 403)
            {
              i = paramIntent.getIntExtra("relationType", 3);
              paramLong = paramIntent.getLongExtra("relationId", 0L);
              l1 = paramIntent.getLongExtra("friendUin", 0L);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = " + i + " ,relationId = " + paramLong + " ,friendUin = " + l1);
              }
              paramIntent = (axap)paramContext.getManager(38);
              if (paramIntent != null) {
                paramIntent.a("" + l1, 0, 0);
              }
              paramContext.a().a(String.valueOf(l1), false);
              paramContext.a().b(false);
              return;
            }
          } while (i != 411);
          localObject = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
          if (localObject != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
        return;
        paramLong = paramIntent.getLongExtra("relationId", -1L);
        paramIntent = mvg.a((ArrayList)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + paramIntent);
        }
        localObject = (axap)paramContext.getManager(38);
      } while (localObject == null);
      ((axap)localObject).a(0, paramLong, "", paramIntent);
      paramContext = (alri)paramContext.a(6);
    } while ((paramContext == null) || (paramContext.a() == null));
    label404:
    label1330:
    paramContext.a().e(String.valueOf(paramLong));
    label1432:
    label1438:
    label1444:
    return;
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG");
    }
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("msgType", 5);
    int k = paramIntent.getIntExtra("msgDetail", 0);
    paramIntent.getIntExtra("bindType", 0);
    paramIntent.getStringExtra("bindId");
    boolean bool5 = paramIntent.getBooleanExtra("isVideoMsg", true);
    String str1 = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("senderUin");
    Object localObject = paramIntent.getStringExtra("selfUin");
    boolean bool6 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool7 = paramIntent.getBooleanExtra("isRead", false);
    paramContext = paramIntent.getStringExtra("extra");
    boolean bool3 = false;
    boolean bool4 = false;
    int m = paramIntent.getIntExtra("MultiAVType", 0);
    paramIntent.getLongExtra("relationId", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG selfUin = " + (String)localObject);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      break label203;
    }
    label203:
    while ((j == 0) && (localObject != null) && (localQQAppInterface.getCurrentAccountUin() != null) && (!((String)localObject).equals(localQQAppInterface.getCurrentAccountUin()))) {
      return;
    }
    boolean bool1;
    boolean bool2;
    if (((j == 2) || (j == 24)) && (paramContext == null))
    {
      bool1 = bool4;
      bool2 = bool3;
      if (bdmh.a(localQQAppInterface.getApp()))
      {
        bool1 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131694138), "qqsetting_lock_screen_whenexit_key", true);
        bool2 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131719358), "qqsetting_notify_showcontent_key", true);
        if ((!bool1) || (!bool2)) {
          break label741;
        }
        localObject = localQQAppInterface.getHandler(ChatActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(16711696));
        }
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      label382:
      if (j == 17) {
        paramContext = String.valueOf(k);
      }
      for (;;)
      {
        for (;;)
        {
          if ((m == 2) && (str1 != null)) {}
          try
          {
            long l = Long.parseLong(str1);
            localObject = localQQAppInterface.a().a(l, 2);
            if ((localObject != null) && (((lpp)localObject).a > 0) && (j == 13)) {
              break;
            }
            if (localQQAppInterface != null)
            {
              localObject = (TroopManager)localQQAppInterface.getManager(52);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(str1);
                if (localObject == null) {
                  break;
                }
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label482:
            break label482;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype");
        }
        VideoMsgTools.a(localQQAppInterface, i, j, bool5, str1, str2, bool6, paramContext, bool7, m, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype end");
        }
        if ((!bool2) || (!bool1)) {
          break;
        }
        paramContext = (auab)localQQAppInterface.getManager(72);
        paramContext.a(localQQAppInterface, str1, i, true, atzx.a(str1, i, paramIntent), true);
        paramContext.a(localQQAppInterface, str1, i, true, atzx.a(str1, i, paramIntent));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
        return;
        if ((j != 17) && (j != 15))
        {
          bool1 = bool4;
          bool2 = bool3;
          if (j != 16) {
            break label382;
          }
        }
        if (i != 3000)
        {
          bool1 = bool4;
          bool2 = bool3;
          if (i != 1) {
            break label382;
          }
        }
        bool1 = bool4;
        bool2 = bool3;
        if (str1 == null) {
          break label382;
        }
        localQQAppInterface.a().a(12, mww.b(i), Long.valueOf(str1).longValue(), null, 0L);
        localQQAppInterface.a().a(21, mww.b(i), Long.valueOf(str1).longValue(), 0L);
        bool1 = bool4;
        bool2 = bool3;
        break label382;
      }
      label741:
      bool3 = bool1;
      bool1 = bool2;
      bool2 = bool3;
    }
  }
  
  void a(boolean paramBoolean)
  {
    long l = UpdateAvSo.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap;
    if (l != 0L)
    {
      l /= 1000L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "qavFirstLauchInterval:" + l);
      }
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label240;
      }
    }
    label240:
    for (Object localObject = "0";; localObject = "1")
    {
      localHashMap.put("isSender", localObject);
      azri.a(localQQAppInterface.getApp().getApplicationContext()).a(localQQAppInterface.getAccount(), "qavFirstLauchInterval", true, l, 0L, localHashMap, "");
      if (UpdateAvSo.a(localQQAppInterface.getApp().getApplicationContext(), Boolean.valueOf(false))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "start videochat  when download so is not ready ");
      }
      localObject = (apks)localQQAppInterface.getManager(77);
      if (localObject != null)
      {
        localObject = (apls)((apks)localObject).a(apls.e());
        if (localObject != null) {
          ((apls)localObject).a(false);
        }
      }
      if (!paramBoolean) {
        break label248;
      }
      azqs.b(localQQAppInterface, "CliOper", "", "", "0X8004C70", "0X8004C70", 0, 0, "", "", "", "");
      return;
    }
    label248:
    azqs.b(localQQAppInterface, "CliOper", "", "", "0X8004C6F", "0X8004C6F", 0, 0, "", "", "", "");
  }
  
  void b(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    long l;
    boolean bool2;
    boolean bool3;
    Object localObject;
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
      do
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          l = 0L;
        }
        bool2 = paramIntent.getBooleanExtra("isReceiver", false);
        bool1 = paramIntent.getBooleanExtra("updateTime", false);
        bool3 = paramIntent.getBooleanExtra("showTime", false);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_START_DOUBLE_VIDEO_MEETING uinType: " + i + ", peerUin: " + paramContext + ", updateTime: " + bool1 + ", showTime: " + bool3);
        }
        paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (paramIntent == null);
      if (bool1)
      {
        paramIntent.a().d(true);
        paramIntent.a().b(true);
      }
      paramIntent.a().a(7, paramContext, 2);
      paramIntent.a().a(i, paramContext, null, bool2);
      paramIntent.a().a(paramContext, true);
      localObject = paramIntent.a();
      if (bool3) {
        break label318;
      }
    }
    boolean bool1 = true;
    ((AVNotifyCenter)localObject).a(0, l, bool1, true);
    if (i == 0)
    {
      localObject = (axap)paramIntent.getManager(38);
      if (!bool3) {
        break label324;
      }
      ((axap)localObject).a(paramContext, i, 6);
    }
    for (;;)
    {
      try
      {
        if ((abti.b(paramContext, i)) || (!abti.t(i))) {
          continue;
        }
        bool1 = paramIntent.a().b(paramContext, i);
        if (bool1) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        label318:
        label324:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Recent User Proxy Error-->e=" + paramContext.getMessage());
        continue;
      }
      a(bool2);
      return;
      bool1 = false;
      break;
      ((axap)localObject).a(paramContext, i, 5);
      continue;
      paramIntent = paramIntent.a().a();
      if ((paramIntent != null) && (paramIntent.b(paramContext, i) == null) && (!TextUtils.isEmpty(paramContext)))
      {
        paramContext = paramIntent.a(paramContext, i);
        if (paramContext != null)
        {
          paramContext.lastmsgtime = ayzl.a();
          paramIntent.a(paramContext);
        }
      }
    }
  }
  
  void c(Context paramContext, Intent paramIntent)
  {
    int m = paramIntent.getIntExtra("sessionType", 0);
    int k = paramIntent.getIntExtra("uinType", 0);
    int n = paramIntent.getIntExtra("bindType", 0);
    String str3 = paramIntent.getStringExtra("bindId");
    String str1 = paramIntent.getStringExtra("peerUin");
    String str2 = paramIntent.getStringExtra("extraUin");
    boolean bool3 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool7 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool5 = paramIntent.getBooleanExtra("showTime", false);
    int i1 = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    boolean bool4 = paramIntent.getBooleanExtra("isNearbyVideoChat", false);
    boolean bool6 = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    int j = m;
    paramContext = str1;
    Object localObject;
    int i;
    if (bool6)
    {
      boolean bool2 = true;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = String.valueOf(l);
      }
      if (m != 3) {
        break label284;
      }
      i = 1;
      m = 0;
      j = i;
      bool1 = bool2;
      paramContext = (Context)localObject;
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onStartVideoChat, double meeting. peer[" + (String)localObject + "], sessionType[" + i + "]");
        k = m;
        paramContext = (Context)localObject;
        bool1 = bool2;
        j = i;
      }
    }
    if (AudioHelper.e()) {
      AudioHelper.a("onStartVideoChat[VideoConstants.ACTION_START_VIDEO_CHAT]", paramIntent.getExtras(), true);
    }
    if (k == -1) {}
    label284:
    do
    {
      do
      {
        return;
        i = m;
        if (m != 4) {
          break;
        }
        i = 2;
        break;
        if (!bool1) {
          break label664;
        }
      } while (((paramContext == null) || (paramContext.length() <= 2)) && ((str2 == null) || (str2.length() <= 2)));
      localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    if (bool3) {
      ((QQAppInterface)localObject).a().a(bool3);
    }
    if (bool7)
    {
      ((QQAppInterface)localObject).a().d(true);
      ((QQAppInterface)localObject).a().b(true);
      label384:
      if (!bool1) {
        break label708;
      }
      ((QQAppInterface)localObject).a().a(6, paramContext, j);
      ((QQAppInterface)localObject).a().a(k, paramContext, str2, bool3);
      paramIntent = ((QQAppInterface)localObject).a();
      i = mww.b(k);
      if (bool5) {
        break label702;
      }
      bool1 = true;
      label437:
      paramIntent.a(i, paramContext, bool1, bool3);
      paramIntent = paramContext;
      if (bool6)
      {
        ((QQAppInterface)localObject).a().a(paramContext, true);
        paramIntent = paramContext;
      }
      label466:
      ((QQAppInterface)localObject).a().e(bool4);
      ((QQAppInterface)localObject).a().a(28, k, paramIntent, str2);
      if ((k != 1) && (k != 9500) && (k != 1011)) {
        if ((TextUtils.isEmpty(str2)) || (k != 1006) || ((paramIntent != null) && (paramIntent.indexOf("+") >= 0))) {
          break label929;
        }
      }
    }
    label664:
    label798:
    label929:
    for (paramContext = str2;; paramContext = paramIntent) {
      for (;;)
      {
        paramIntent = (axap)((QQAppInterface)localObject).getManager(38);
        try
        {
          paramIntent.a().a(paramContext, k).isSystemCall = 0;
          label571:
          if (paramIntent != null)
          {
            if ((n != 2) && (n != 3) && (k != 25)) {
              break label798;
            }
            if (bool5) {
              paramIntent.a(paramContext, 8, k, n, str3, 6);
            }
          }
          else
          {
            label614:
            if (k == 1008) {}
          }
          for (;;)
          {
            try
            {
              if ((abti.b(paramContext, k)) || (!abti.t(k))) {
                continue;
              }
              bool1 = ((QQAppInterface)localObject).a().b(paramContext, k);
              if (bool1) {
                continue;
              }
            }
            catch (Exception paramContext)
            {
              label702:
              label708:
              continue;
            }
            a(bool3);
            return;
            if (l >= 100L) {
              break;
            }
            return;
            if ((!bool5) || (((QQAppInterface)localObject).a().e())) {
              break label384;
            }
            ((QQAppInterface)localObject).a().b(true);
            break label384;
            bool1 = false;
            break label437;
            ((QQAppInterface)localObject).a().a(i1, Long.valueOf(l), true);
            ((QQAppInterface)localObject).a().a(6, i1, l, j);
            paramContext = ((QQAppInterface)localObject).a();
            if (!bool5)
            {
              bool1 = true;
              paramContext.a(i1, l, bool1, bool3);
              paramIntent = String.valueOf(l);
              break label466;
            }
            bool1 = false;
            continue;
            paramIntent.a(paramContext, 8, k, n, str3, 5);
            break label614;
            if (bool5)
            {
              paramIntent.a(paramContext, k, 6);
              break label614;
            }
            if (bool3) {
              break label614;
            }
            paramIntent.a(paramContext, k, 5);
            break label614;
            if ((n != 2) && (n != 3) && (k != 25) && (!bool4))
            {
              paramIntent = ((QQAppInterface)localObject).a().a();
              if ((paramIntent != null) && (paramIntent.b(paramContext, k) == null) && (!TextUtils.isEmpty(paramContext)) && (paramContext.length() > 2))
              {
                paramContext = paramIntent.a(paramContext, k);
                if (paramContext != null)
                {
                  paramContext.lastmsgtime = ayzl.a();
                  paramIntent.a(paramContext);
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          break label571;
        }
      }
    }
  }
  
  void d(Context paramContext, Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("uinType", 0);
    int i = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    Object localObject2 = paramIntent.getStringExtra("peerUin");
    Object localObject1 = paramIntent.getStringExtra("extraUin");
    int m = paramIntent.getIntExtra("stopReason", 0);
    String str3 = paramIntent.getStringExtra("senderUin");
    String str1 = paramIntent.getStringExtra("selfUin");
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool2 = paramIntent.getBooleanExtra("isSystemCalling", false);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    long l3 = paramIntent.getLongExtra(VideoConstants.d, 0L);
    long l4 = paramIntent.getLongExtra(VideoConstants.jdField_e_of_type_JavaLangString, 0L);
    int k = paramIntent.getIntExtra(VideoConstants.f, 0);
    long l5 = paramIntent.getLongExtra(VideoConstants.i, 0L);
    long l6 = paramIntent.getLongExtra(VideoConstants.j, 0L);
    long l7 = paramIntent.getLongExtra("score_connect_duration", 0L);
    paramIntent.getIntExtra("sessionType", 0);
    long l1;
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
    {
      paramContext = (Context)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramContext = String.valueOf(l2);
      }
      l1 = l2;
      if (l2 == 0L) {
        l1 = mti.a(paramContext);
      }
      bool1 = true;
    }
    for (;;)
    {
      if (AudioHelper.e()) {
        AudioHelper.a("onVideoChatEnd[VideoConstants.ACTION_STOP_VIDEO_CHAT]", paramIntent.getExtras(), true);
      }
      if (j == 26) {
        paramContext = (Context)localObject1;
      }
      label711:
      label713:
      label725:
      label1237:
      label1624:
      for (;;)
      {
        localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 == null) {}
        label1007:
        label1649:
        label1653:
        for (;;)
        {
          return;
          ((QQAppInterface)localObject2).a().a(false);
          if ((m == 4) || (m == 6) || (m == 1)) {
            if (bool1)
            {
              ((QQAppInterface)localObject2).a().a(j, paramContext, (String)localObject1, false);
              ((QQAppInterface)localObject2).a().a(8, paramContext, 0);
            }
          }
          for (;;)
          {
            ((QQAppInterface)localObject2).a().a(28, j, paramContext, (String)localObject1);
            if ((j == 1) || (j == 1011) || (j == 9500)) {
              break;
            }
            if ((m != 3) && (m != 4) && (m != 5) && (m != 6) && (m != 8)) {
              break label725;
            }
            if ((bool2) || (j == 1008)) {
              break;
            }
            if (j != 0) {
              break label713;
            }
            bool1 = false;
            if (!TextUtils.isEmpty(str1)) {
              bool1 = str1.equals(str3);
            }
            VideoMsgTools.a((QQAppInterface)localObject2, j, 1, true, paramContext, str3, bool1, null, true, new Object[0]);
            return;
            ((QQAppInterface)localObject2).a().a(n, Long.valueOf(l1), false);
            ((QQAppInterface)localObject2).a().a(8, n, l1, 0);
            continue;
            if ((m == 0) && ((((QQAppInterface)localObject2).a().e() == 3) || (((QQAppInterface)localObject2).a().e() == 4)))
            {
              ((QQAppInterface)localObject2).a().a(j, paramContext, (String)localObject1, false);
              ((QQAppInterface)localObject2).a().a(8, paramContext, 0);
            }
            else
            {
              if (bool1) {
                if ((str1 != null) && (((QQAppInterface)localObject2).getCurrentAccountUin() != null) && (str1.equals(((QQAppInterface)localObject2).getCurrentAccountUin())))
                {
                  ((QQAppInterface)localObject2).a().a(j, paramContext, (String)localObject1, false);
                  ((QQAppInterface)localObject2).a().a(8, paramContext, 0);
                  ((QQAppInterface)localObject2).a().b(false);
                }
              }
              for (;;)
              {
                if (m != 7) {
                  break label711;
                }
                String str4 = paramIntent.getStringExtra("actId");
                String str5 = paramIntent.getStringExtra("mp_ext_params");
                if (str4 == null) {
                  break;
                }
                VideoMsgTools.a((QQAppInterface)localObject2, "https://iyouxi3.vip.qq.com/ams3.0.php?", str4, str5, this.jdField_a_of_type_Baug);
                break;
                ((QQAppInterface)localObject2).a().a(n, Long.valueOf(l1), false);
                ((QQAppInterface)localObject2).a().a(8, n, l1, 0);
                ((QQAppInterface)localObject2).a().b(false);
              }
            }
          }
          a(m, (String)localObject1, paramContext, str3);
          return;
          if ((m == 0) || (m == 1) || (m == 2))
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (j == 1006) && ((paramContext == null) || (paramContext.indexOf("+") < 0))) {
              paramContext = (Context)localObject1;
            }
            for (;;)
            {
              if ((str1 != null) && (((QQAppInterface)localObject2).getCurrentAccountUin() != null) && (!str1.equals(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
                break label1653;
              }
              localObject1 = (axap)((QQAppInterface)localObject2).getManager(38);
              if ((((QQAppInterface)localObject2).a().d(paramContext)) || (localObject1 == null)) {
                break;
              }
              if ((i == 2) || (i == 3) || (j == 25)) {
                ((axap)localObject1).a(paramContext, 8, j, i, str2, 0);
              }
              do
              {
                paramContext = paramIntent.getStringExtra("actId");
                paramIntent = paramIntent.getStringExtra("mp_ext_params");
                if (paramContext == null) {
                  break;
                }
                VideoMsgTools.a((QQAppInterface)localObject2, "https://iyouxi3.vip.qq.com/ams3.0.php?", paramContext, paramIntent, this.jdField_a_of_type_Baug);
                return;
                ((axap)localObject1).a(paramContext, j, 0);
                localObject1 = bdne.e(((QQAppInterface)localObject2).getCurrentAccountUin());
                i = ((SharedPreferences)localObject1).getInt("qav_score_switch", 0);
                m = ((SharedPreferences)localObject1).getInt("qav_score_rate", 5);
                n = ((SharedPreferences)localObject1).getInt("qav_score_time", 0);
                if ((str1 == null) || (i != 1) || (m == 0) || (l7 < n) || (!mum.a("qav_score_good.jpg")) || (!mum.a("qav_score_normal.jpg")) || (!mum.a("qav_score_bad.jpg"))) {
                  break label1624;
                }
                bool1 = true;
                bool2 = false;
                if (AudioHelper.a(17) == 1)
                {
                  AudioHelper.a(alud.a(2131716506));
                  bool2 = true;
                }
                if (QLog.isColorLevel()) {
                  QLog.w(jdField_a_of_type_JavaLangString, 1, "onVideoChatEnd, scoreSwitch[" + i + "], scoreRate[" + m + "], scoreTime[" + n + "], duration[" + l7 + "], show1[" + bool1 + "], forceShow[" + bool2 + "]");
                }
              } while (((!bool2) && (!bool1)) || (str1 == null));
              i = ((SharedPreferences)localObject1).getInt(VideoConstants.c, 0) + 1;
              boolean bool3 = ((SharedPreferences)localObject1).getBoolean(VideoConstants.l, false);
              l2 = 0L;
              l1 = l2;
              if (i == 1)
              {
                l1 = l2;
                if (!bool3)
                {
                  l2 = ((SharedPreferences)localObject1).getLong("qav_score_msg_uniseq", 0L);
                  l1 = l2;
                  if (l2 != 0L)
                  {
                    ((QQAppInterface)localObject2).a().b(paramContext, j, l2);
                    l1 = l2;
                  }
                }
              }
              if (m == 0)
              {
                bool1 = false;
                if (QLog.isColorLevel()) {
                  QLog.w(jdField_a_of_type_JavaLangString, 1, "onVideoChatEnd, scoreCount[" + i + "], hasCommit[" + bool3 + "], uniseq[" + l1 + "], show2[" + bool1 + "]");
                }
                if ((!bool2) && (!bool1)) {
                  break label1649;
                }
                mvs.a("{\n" + VideoConstants.d + ":" + l3 + ",\n" + VideoConstants.jdField_e_of_type_JavaLangString + ":" + l4 + ",\n" + VideoConstants.f + ":" + k + ",\n" + VideoConstants.i + ":" + l5 + ",\n" + VideoConstants.j + ":" + l6 + ",\n" + VideoConstants.k + ":" + paramContext + "\n}");
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "addTipsVideoMsg beginTime: " + l3 + ", endTime: " + l4 + ", sdkVersion: " + k + ", bussinessType: " + l5 + ", bussinessFlag: " + l6 + ",toUin: " + paramContext);
                }
                VideoMsgTools.a((QQAppInterface)localObject2, j, 61, true, paramContext, null);
                i = 0;
                ((SharedPreferences)localObject1).edit().putBoolean(VideoConstants.l, false).commit();
              }
              for (;;)
              {
                ((SharedPreferences)localObject1).edit().putInt(VideoConstants.c, i).commit();
                break;
                bool1 = false;
                break label1007;
                if (i % m == 0)
                {
                  bool1 = true;
                  break label1237;
                }
                bool1 = false;
                break label1237;
              }
            }
          }
        }
      }
      paramContext = (Context)localObject2;
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
    paramContext = (alto)localQQAppInterface.getManager(51);
    if ((paramContext != null) && (!paramContext.b(str)) && (i != 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "other terminal chating with: " + str + " , sessionType: " + i + " ,uintype: " + j);
    }
    axap localaxap = (axap)localQQAppInterface.getManager(38);
    if (i == 0)
    {
      paramIntent = localQQAppInterface.a().b(l);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal roomId reset peerUin=" + paramIntent);
      localQQAppInterface.a().c(paramIntent);
      paramContext = paramIntent;
      if (localaxap != null)
      {
        paramContext = paramIntent;
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramContext = paramIntent;
          if (j != 1)
          {
            paramContext = paramIntent;
            if (localaxap.a(paramIntent, j) == 7)
            {
              localaxap.a(paramIntent, j, 0);
              paramContext = paramIntent;
            }
          }
        }
      }
      localQQAppInterface.a().a(28, j, paramContext, "");
      return;
    }
    localQQAppInterface.a().a(str, l, i);
    paramIntent = localQQAppInterface.a();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.a();
    }
    if ((paramContext != null) && (paramContext.b(str, 0) == null) && (!bool)) {
      if (i != 2) {
        break label504;
      }
    }
    label504:
    for (bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, j, 53, bool, str, localQQAppInterface.c(), true, null, true, new Object[0]);
      paramContext = str;
      if (j == 1) {
        break;
      }
      paramContext = str;
      if (localaxap == null) {
        break;
      }
      paramContext = str;
      if (localaxap.a(str, j) == 6) {
        break;
      }
      localaxap.a(str, j, 7);
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
      paramIntent = aepi.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
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
        if (!bdmh.a(((QQAppInterface)localObject).getApp())) {
          break label393;
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
          paramContext = auau.a(paramContext, str1, 21);
          break;
        }
        paramIntent.putExtra("uin", str1);
        paramContext = paramIntent;
        break;
        label393:
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
    paramIntent = aepi.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
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
      label201:
      if (!bdmh.a(((QQAppInterface)localObject).getApp())) {
        break label473;
      }
      paramContext.putExtra("ext_panel_onresume", 2);
      label221:
      if (!bool) {
        break label485;
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
        break label201;
      }
      if (i == 1004)
      {
        paramIntent.putExtra("uin", str1);
        paramIntent.putExtra("troop_uin", str2);
        paramContext = paramIntent;
        break label201;
      }
      if (i == 1044)
      {
        paramContext = auau.a(paramContext, str1, 21);
        azqs.b(null, "dc00898", "", "", "0X800AD97", "0X800AD97", 0, 0, "", "", "", "");
        break label201;
      }
      paramIntent.putExtra("uin", str1);
      paramContext = paramIntent;
      break label201;
      label473:
      paramContext.putExtra("ext_panel_onresume", 1);
      break label221;
      label485:
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
          l1 = mti.a(paramContext);
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
          paramIntent.a().a(5, paramContext, i);
        }
        while (bool)
        {
          paramIntent.a().a(paramContext, true);
          return;
          paramIntent.a().a(5, m, l1, i);
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
    String str1 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("type", 0);
    String str2 = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", false);
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = paramIntent.getApp().getString(2131695920);
    Object localObject2 = bdgc.j(paramIntent, str1);
    if (((String)localObject2).length() > 10) {
      new StringBuilder().append(((String)localObject2).substring(0, 4)).append("...").toString();
    }
    localObject2 = paramIntent.getApp();
    int i;
    if (bool1)
    {
      i = 2131695917;
      localObject2 = ((BaseApplication)localObject2).getString(i);
      localObject1 = bdgm.a(paramIntent.getApp().getApplicationContext(), 230, (String)localObject1, (String)localObject2, 2131690648, 2131696090, new amfm(this, paramIntent, j, k, bool1, str1, str2, bool2), null);
      if (Build.VERSION.SDK_INT < 26) {
        break label352;
      }
      if (Settings.canDrawOverlays(paramContext)) {
        ((bdjz)localObject1).getWindow().setType(2038);
      }
      label242:
      if (Build.VERSION.SDK_INT < 23) {
        break label408;
      }
      if (!Settings.canDrawOverlays(paramContext)) {
        break label395;
      }
      ((bdjz)localObject1).show();
    }
    for (;;)
    {
      mtq.a(paramIntent.isBackground_Pause, bool1);
      paramContext = new Message();
      paramContext.what = 1;
      paramContext.obj = new Object[] { localObject1, Integer.valueOf(j), Boolean.valueOf(bool1), str1, str2, Boolean.valueOf(bool2) };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramContext, 10000L);
      return;
      i = 2131695921;
      break;
      label352:
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!Settings.canDrawOverlays(paramContext)) {
          break label242;
        }
        ((bdjz)localObject1).getWindow().setType(2003);
        break label242;
      }
      ((bdjz)localObject1).getWindow().setType(2003);
      break label242;
      label395:
      QLog.d(jdField_a_of_type_JavaLangString, 1, "can not DrawOverlays !!");
      continue;
      label408:
      ((bdjz)localObject1).show();
    }
  }
  
  void l(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG_MULTI");
    }
    String str1 = String.valueOf(paramIntent.getLongExtra("friendUin", 0L));
    String str2 = String.valueOf(paramIntent.getLongExtra("discussId", 0L));
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("type", 0);
    String str3 = paramIntent.getStringExtra("realSenderUin");
    String str4 = paramIntent.getStringExtra("peerUin");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str5 = localQQAppInterface.getApp().getString(2131695920);
    if (i == 3000)
    {
      paramIntent = bdgc.c(localQQAppInterface, str2, str1);
      paramIntent = String.format(localQQAppInterface.getApp().getString(2131695919), new Object[] { paramIntent });
      mtq.e(false, true);
      if (!GesturePWDUtils.isAppOnForegroundByTasks(localQQAppInterface.getApp().getApplicationContext())) {
        break label326;
      }
      paramContext = PopupDialog.a(localQQAppInterface.getApp().getApplicationContext(), 230, str5, paramIntent, 2131690648, 2131694953, new amfn(this, localQQAppInterface, i, j, str2, str1, str4, str3), null);
    }
    for (;;)
    {
      mtq.c(localQQAppInterface.isBackground_Pause);
      paramIntent = new Message();
      paramIntent.what = 2;
      paramIntent.obj = new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), str2, str1, str4, str3 };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
      return;
      if (i == 1)
      {
        paramIntent = bdgc.d(localQQAppInterface, str1, str2);
        break;
      }
      paramIntent = bdgc.j(localQQAppInterface, str1);
      break;
      label326:
      paramIntent = bdgm.a(localQQAppInterface.getApp().getApplicationContext(), 230, str5, paramIntent, 2131690648, 2131694953, new amfo(this, localQQAppInterface, i, j, str2, str1, str4, str3), null);
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
      localQQAppInterface.a().a(null);
      localQQAppInterface.a().a(-1L);
      localQQAppInterface.a().a(-1);
      localQQAppInterface.a().b(null);
    }
    for (;;)
    {
      localQQAppInterface.a().a(i, j);
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        localQQAppInterface.a().a(paramContext);
      }
      if (!TextUtils.isEmpty(str2)) {
        localQQAppInterface.a().a(str2, str3, paramIntent);
      }
      localQQAppInterface.a().a(l);
      localQQAppInterface.a().a(k);
      localQQAppInterface.a().b(str1);
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
    localQQAppInterface.a().a(paramContext, str, paramIntent);
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
        paramContext = (apks)paramContext.getManager(77);
      } while (paramContext == null);
      paramContext = (apls)paramContext.a(apls.e());
    } while (paramContext == null);
    paramContext.a(false);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    long l = mwd.a(paramIntent);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onReceive, action[" + str1 + "], seq[" + l + "]");
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    label1728:
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
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      String str2;
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
                                localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                              } while (localObject == null);
                              if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(((QQAppInterface)localObject).getApp().getPackageName())))
                              {
                                QLog.d(jdField_a_of_type_JavaLangString, 1, "onReceive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + str1);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.AddVideoMsg"))
                              {
                                a(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.VideoFlowSize"))
                              {
                                h(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.MultiVideo"))
                              {
                                a(l, paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.StartDoubleVideoMeeting"))
                              {
                                b(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.StartVideoChat"))
                              {
                                c(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.StopVideoChat"))
                              {
                                d(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.AvSwitch"))
                              {
                                j(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.AnotherTerChating"))
                              {
                                e(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.AddMsgSig"))
                              {
                                i(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.CallingDialog"))
                              {
                                k(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.CallingDialogMulti"))
                              {
                                l(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.setChatStatus"))
                              {
                                m(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.updateChatInfo"))
                              {
                                n(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.downloadAvSo"))
                              {
                                o(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.av.v2q.CheckChatAbility"))
                              {
                                q(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.downloadGAudioSound"))
                              {
                                p(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.AddContactsToDiscuss"))
                              {
                                VideoMsgTools.b((QQAppInterface)localObject, paramIntent.getStringExtra("discussUin"));
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.MeetingMemberManager"))
                              {
                                VideoMsgTools.a((QQAppInterface)localObject, paramIntent.getStringExtra("discussUin"));
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.AddContactsFromC2C"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(jdField_a_of_type_JavaLangString, 2, "addMemberFromC2C");
                                }
                                VideoMsgTools.a((QQAppInterface)localObject, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("supportUinType", 3000));
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.replyMsg"))
                              {
                                f(paramContext, paramIntent);
                                return;
                              }
                              if (str1.equals("tencent.video.v2q.leaveMsg"))
                              {
                                g(paramContext, paramIntent);
                                return;
                              }
                              if (!str1.equals("tencent.video.v2q.AudioEngineReady")) {
                                break;
                              }
                              paramContext = paramIntent.getStringExtra("peerUin");
                              l = paramIntent.getLongExtra("roomId", 0L);
                            } while ((l == 0L) || (paramContext == null));
                            if (QLog.isColorLevel()) {
                              QLog.d(jdField_a_of_type_JavaLangString, 2, "<qav printer> message send: cmd[0x211, 0xb]");
                            }
                            paramIntent = (mxa)((QQAppInterface)localObject).a(39);
                            paramIntent.b = paramContext;
                            paramIntent.a = l;
                            paramIntent.a();
                            return;
                            if (str1.equals("tencent.video.v2q.GaudioOpenTroopCard"))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_GAUDIO_TROOP_CARD");
                              }
                              str2 = paramIntent.getStringExtra("troopUin");
                              str1 = paramIntent.getStringExtra("memberUin");
                              if (paramIntent.getIntExtra("uinType", -1) == 3000)
                              {
                                if (str1.equals(((QQAppInterface)localObject).getCurrentAccountUin()))
                                {
                                  paramIntent = new ProfileActivity.AllInOne(str1, 0);
                                  paramIntent.g = 5;
                                  ProfileActivity.b(paramContext, paramIntent);
                                  return;
                                }
                                if (((alto)((QQAppInterface)localObject).getManager(51)).b(str1))
                                {
                                  paramIntent = new ProfileActivity.AllInOne(str1, 1);
                                  paramIntent.h = bdgc.a((QQAppInterface)localObject, str1, 0);
                                  paramIntent.g = 5;
                                  ProfileActivity.b(paramContext, paramIntent);
                                  return;
                                }
                                paramIntent = new ProfileActivity.AllInOne(str1, 46);
                                paramIntent.h = bdgc.a((QQAppInterface)localObject, str1, 0);
                                paramIntent.f = str1;
                                paramIntent.jdField_e_of_type_Int = 3000;
                                paramIntent.jdField_e_of_type_JavaLangString = str2;
                                paramIntent.g = 5;
                                ProfileActivity.b(paramContext, paramIntent);
                                return;
                              }
                              awrt.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getApp(), str2, str1, 0, -1);
                              return;
                            }
                            if (str1.equals("tencent.video.v2q.BindContact"))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_BIND_CONTACT from qav");
                              }
                              paramContext = new Intent(paramContext, BindNumberActivity.class);
                              paramContext.putExtra("kNeedUnbind", true);
                              paramContext.addFlags(268435456);
                              ((QQAppInterface)localObject).getApp().startActivity(paramContext);
                              return;
                            }
                            if (str1.equals("tencent.video.v2q.OpenContactList"))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_OPEN_CONTACT_LIST from qav");
                              }
                              paramContext = new Intent(paramContext, PhoneFrameActivity.class);
                              paramContext.putExtra("key_req_type", 0);
                              paramContext.addFlags(268435456);
                              ((QQAppInterface)localObject).getApp().startActivity(paramContext);
                              return;
                            }
                            if (!str1.equals("tencent.video.v2q.AnnimateDownloadStart")) {
                              break;
                            }
                            i = paramIntent.getIntExtra("callId", 0);
                          } while ((i <= 0) || (!becr.b()));
                          paramContext = (becr)((QQAppInterface)localObject).getManager(84);
                        } while (paramContext == null);
                        paramContext.a(i, becr.a(), false, 0);
                        return;
                        if (!str1.equals("tencent.video.v2q.commingRingDownload")) {
                          break;
                        }
                        i = paramIntent.getIntExtra("comming_ring_down_key", 0);
                      } while ((i <= 0) || (!becr.b()));
                      ((bdse)((QQAppInterface)localObject).getManager(45)).a(i, 3, false, 0, "comering");
                      int j = ((amca)((QQAppInterface)localObject).a(13)).g();
                      azqs.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + j, i + "", "", "");
                      return;
                      if (str1.equals("chatbgBroadcast"))
                      {
                        str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                        i = paramIntent.getIntExtra("uinType", 0);
                        str2 = paramIntent.getStringExtra("friendUin");
                        j = paramIntent.getIntExtra("effectId", 0);
                        ThemeBackground.setThemeBackgroundPic(paramContext, "theme_bg_aio_path", ((QQAppInterface)localObject).getAccount(), str1, "", "", "", 0, null, false);
                        aeqq.a(paramContext, ((QQAppInterface)localObject).getAccount(), str2, str1, j, i);
                        return;
                      }
                      if (!str1.equals("tencent.video.v2q.insertSystemCall")) {
                        break;
                      }
                      localObject = ((QQAppInterface)localObject).a();
                    } while (localObject == null);
                    paramIntent = paramIntent.getStringExtra("phoneNumber");
                    paramContext = paramIntent;
                    if (paramIntent != null)
                    {
                      paramContext = paramIntent;
                      if (!paramIntent.startsWith("+")) {
                        paramContext = "+86" + paramIntent;
                      }
                    }
                    ((axap)localObject).b(paramContext);
                    return;
                    if (str1.equals("tencent.video.v2q.upgradeInvite"))
                    {
                      VideoMsgTools.b((QQAppInterface)localObject, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("type", 0));
                      return;
                    }
                    if (!str1.equals("tencent.video.v2q.SmallScreenState")) {
                      break;
                    }
                    i = paramIntent.getIntExtra("SmallScreenState", 0);
                    paramContext = paramIntent.getStringExtra("uin");
                    if (AudioHelper.e()) {
                      QLog.w(jdField_a_of_type_JavaLangString, 1, "ACTION_SMALL_SCREEN_STATE, smallScreenState[" + i + "], peerUin[" + paramContext + "], seq[" + l + "]");
                    }
                    ((QQAppInterface)localObject).a().b(l, i);
                  } while (TextUtils.isEmpty(paramContext));
                  ((QQAppInterface)localObject).a().d(paramContext);
                  return;
                  if (!str1.equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO")) {
                    break;
                  }
                  paramContext = new HashMap();
                  paramContext.put("MultiAVType", String.valueOf(2));
                  paramContext.put("enterType", paramIntent.getIntExtra("enterType", 0) + "");
                } while (BaseActivity.sTopActivity == null);
                ChatActivityUtils.a((QQAppInterface)localObject, BaseActivity.sTopActivity, 1, paramIntent.getStringExtra("relationId"), true, true, null, paramContext);
                return;
                if (!str1.equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO")) {
                  break label1728;
                }
                paramContext = paramIntent.getStringExtra("relationId");
                l = paramIntent.getLongExtra("friendUin", 0L);
                if (l != 0L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:" + l);
              return;
              str1 = paramIntent.getStringExtra("inviteId");
              int i = paramIntent.getIntExtra("dealResult", 1);
              ((amdu)((QQAppInterface)localObject).a(20)).a(paramContext, l, str1, i);
              paramIntent = (TroopManager)((QQAppInterface)localObject).getManager(52);
            } while (paramIntent == null);
            paramIntent.d(paramContext, l + "");
            return;
            if (!str1.equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END")) {
              break;
            }
            paramContext = (TroopManager)((QQAppInterface)localObject).getManager(52);
          } while (paramContext == null);
          paramContext.d(paramIntent.getStringExtra("relationId"), paramIntent.getStringExtra("inviterUin"));
          return;
          if (!str1.equals("tencent.video.v2q.generalFuncCall")) {
            break;
          }
        } while (!"SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")));
        paramContext = azvd.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      } while (paramContext == null);
      bdna.a((QQAppInterface)localObject, paramIntent.getStringExtra("uin"), paramIntent.getIntExtra("uintype", -1), paramContext, null);
      return;
      if (str1.equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED"))
      {
        ((atdh)((QQAppInterface)localObject).getManager(306)).b();
        return;
      }
    } while (!str1.equals("tencent.video.v2q.AddMembersToGroup"));
    VideoMsgTools.a((QQAppInterface)localObject, paramContext, paramIntent);
  }
  
  void p(Context paramContext, Intent paramIntent)
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
        paramContext = (apks)paramContext.getManager(77);
      } while (paramContext == null);
      paramContext = (aplq)paramContext.a("qq.android.qav.muteaudio");
    } while (paramContext == null);
    paramContext.a(false);
  }
  
  void q(Context paramContext, Intent paramIntent)
  {
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {
      return;
    }
    paramIntent = paramContext.getApp().getString(2131696178);
    String str = paramContext.getApp().getString(2131696158);
    paramContext = bdgm.a(paramContext.getApp().getApplicationContext(), 230, str, paramIntent, 2131690648, 2131696090, new amfp(this), null);
    paramContext.getWindow().setType(2003);
    paramContext.show();
    paramIntent = new Message();
    paramIntent.what = 3;
    paramIntent.obj = new Object[] { paramContext };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */