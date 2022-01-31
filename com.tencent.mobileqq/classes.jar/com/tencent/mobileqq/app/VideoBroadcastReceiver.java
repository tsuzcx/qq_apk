package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.av.VideoConstants;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.ScoreManager;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoC2CHandler;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qcall.QCallStartBrigeActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import zvs;
import zvt;
import zvu;
import zvv;
import zvw;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  static VideoBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver;
  public static String a;
  INetEngine.INetEngineListener jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new zvv(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoBroadCastReceiver";
  }
  
  VideoBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_MqqOsMqqHandler = new zvw(Looper.getMainLooper(), this);
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
    QCallFacade localQCallFacade = (QCallFacade)localQQAppInterface.getManager(37);
    if (localQCallFacade != null)
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        break label126;
      }
      localQCallFacade.a(paramString1, paramString2, paramString3, 8);
    }
    for (;;)
    {
      try
      {
        paramString2 = MessageRecordFactory.a(-4008);
        paramString2.selfuin = localQQAppInterface.getCurrentAccountUin();
        paramString2.frienduin = paramString1;
        paramString2.senderuin = paramString3;
        paramString2.msgtype = -4008;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = 3000;
        paramString2.time = MessageCache.a();
        localQQAppInterface.a(1, true, true, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label126:
      localQCallFacade.a(paramString1, paramString2, paramString3, 2);
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	com/tencent/mobileqq/app/VideoBroadcastReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 129	com/tencent/mobileqq/app/VideoBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 54	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   20: ldc 2
    //   22: monitorexit
    //   23: new 131	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 132	android/content/IntentFilter:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 134
    //   34: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: ldc 140
    //   40: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: ldc 142
    //   46: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: ldc 144
    //   52: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: ldc 146
    //   58: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: ldc 148
    //   64: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: ldc 150
    //   70: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc 152
    //   76: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: ldc 154
    //   82: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: ldc 156
    //   88: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: ldc 158
    //   94: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: ldc 160
    //   100: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: ldc 162
    //   106: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc 164
    //   112: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc 166
    //   118: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   121: aload_1
    //   122: ldc 168
    //   124: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   127: aload_1
    //   128: ldc 170
    //   130: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   133: aload_1
    //   134: ldc 172
    //   136: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: ldc 174
    //   142: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: ldc 176
    //   148: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: ldc 178
    //   154: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: ldc 180
    //   160: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: ldc 182
    //   166: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   169: aload_1
    //   170: ldc 184
    //   172: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: ldc 186
    //   178: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   181: aload_1
    //   182: ldc 188
    //   184: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: ldc 190
    //   190: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: ldc 192
    //   196: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc 194
    //   202: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: ldc 196
    //   208: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   211: aload_1
    //   212: ldc 198
    //   214: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   217: aload_1
    //   218: ldc 200
    //   220: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: ldc 202
    //   226: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 204
    //   232: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: ldc 206
    //   238: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: ldc 208
    //   244: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   247: aload_1
    //   248: ldc 210
    //   250: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   253: aload_1
    //   254: ldc 212
    //   256: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   259: aload_1
    //   260: ldc 214
    //   262: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   265: aload_1
    //   266: ldc 216
    //   268: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   271: aload_1
    //   272: ldc 218
    //   274: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   277: aload_1
    //   278: ldc 220
    //   280: invokevirtual 138	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: getstatic 54	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   290: aload_1
    //   291: ldc 222
    //   293: aconst_null
    //   294: invokevirtual 226	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   297: pop
    //   298: getstatic 54	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   301: iconst_1
    //   302: putfield 24	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_Boolean	Z
    //   305: return
    //   306: astore_0
    //   307: ldc 2
    //   309: monitorexit
    //   310: aload_0
    //   311: athrow
    //   312: astore_0
    //   313: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq -11 -> 305
    //   319: getstatic 17	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_2
    //   323: new 234	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   330: ldc 237
    //   332: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramQQAppInterface	QQAppInterface
    //   30	261	1	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   3	20	306	finally
    //   20	23	306	finally
    //   307	310	306	finally
    //   283	305	312	java/lang/Exception
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
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      break label201;
    }
    label201:
    while ((j == 0) && (localObject != null) && (paramIntent.getCurrentAccountUin() != null) && (!((String)localObject).equals(paramIntent.getCurrentAccountUin()))) {
      return;
    }
    boolean bool1;
    boolean bool2;
    if (((j == 2) || (j == 24)) && (paramContext == null))
    {
      bool1 = bool4;
      bool2 = bool3;
      if (QQUtils.a(paramIntent.getApp()))
      {
        bool1 = SettingCloneUtil.readValue(paramIntent.getApp(), paramIntent.getCurrentAccountUin(), paramIntent.getApp().getString(2131435420), "qqsetting_lock_screen_whenexit_key", true);
        bool2 = SettingCloneUtil.readValue(paramIntent.getApp(), paramIntent.getCurrentAccountUin(), paramIntent.getApp().getString(2131434218), "qqsetting_notify_showcontent_key", true);
        if ((!bool1) || (!bool2)) {
          break label705;
        }
        localObject = paramIntent.getHandler(ChatActivity.class);
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
      label370:
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
            localObject = paramIntent.a().a(l, 2);
            if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a > 0) && (j == 13)) {
              break;
            }
            if (paramIntent != null)
            {
              localObject = (TroopManager)paramIntent.getManager(51);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).a(str1);
                if (localObject == null) {
                  break;
                }
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label467:
            break label467;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype");
        }
        VideoMsgTools.a(paramIntent, i, j, bool5, str1, str2, bool6, paramContext, bool7, m, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype end");
        }
        if ((!bool2) || (!bool1)) {
          break;
        }
        paramContext = (QQLSRecentManager)paramIntent.getManager(71);
        paramContext.a(paramIntent, str1, i, true);
        paramContext.a(paramIntent, str1, i, true);
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
            break label370;
          }
        }
        if (i != 3000)
        {
          bool1 = bool4;
          bool2 = bool3;
          if (i != 1) {
            break label370;
          }
        }
        bool1 = bool4;
        bool2 = bool3;
        if (str1 == null) {
          break label370;
        }
        paramIntent.a().a(12, UITools.a(i), Long.valueOf(str1).longValue(), null, 0L);
        paramIntent.a().a(21, UITools.a(i), Long.valueOf(str1).longValue(), 0L);
        bool1 = bool4;
        bool2 = bool3;
        break label370;
      }
      label705:
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
        break label236;
      }
    }
    label236:
    for (Object localObject = "0";; localObject = "1")
    {
      localHashMap.put("isSender", localObject);
      StatisticCollector.a(localQQAppInterface.getApp().getApplicationContext()).a(localQQAppInterface.getAccount(), "qavFirstLauchInterval", true, l, 0L, localHashMap, "");
      if (UpdateAvSo.a(localQQAppInterface.getApp().getApplicationContext())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "start videochat  when download so is not ready ");
      }
      localObject = (EarlyDownloadManager)localQQAppInterface.getManager(76);
      if (localObject != null)
      {
        localObject = (QavSoDownloadHandler)((EarlyDownloadManager)localObject).a(QavSoDownloadHandler.e());
        if (localObject != null) {
          ((QavSoDownloadHandler)localObject).a(false);
        }
      }
      if (!paramBoolean) {
        break label244;
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004C70", "0X8004C70", 0, 0, "", "", "", "");
      return;
    }
    label244:
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004C6F", "0X8004C6F", 0, 0, "", "", "", "");
  }
  
  void b(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 20);
    boolean bool1 = paramIntent.getBooleanExtra("isStart", false);
    int j = paramIntent.getIntExtra("MultiAVType", 0);
    if ((AudioHelper.e()) || (i == 22) || (i == 23) || (i == 25)) {
      AudioHelper.a(jdField_a_of_type_JavaLangString + ".onMultiMsgV2Q", paramIntent.getExtras());
    }
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {}
    long l1;
    label245:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            do
            {
              Object localObject2;
              do
              {
                do
                {
                  long l2;
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
                              return;
                              if (i == 22)
                              {
                                k = paramIntent.getIntExtra("relationType", 0);
                                l1 = paramIntent.getLongExtra("relationId", 0L);
                                l2 = paramIntent.getLongExtra("friendUin", 0L);
                                m = paramIntent.getIntExtra("roomUserNum", 0);
                                paramContext.a().a(9, k, l1, 3);
                                if (l2 == Long.valueOf(paramContext.getCurrentAccountUin()).longValue())
                                {
                                  paramContext.a().a(k, Long.valueOf(l1), true);
                                  paramContext.a().a(9, k, l1, 3);
                                  paramContext.a().a(k, l1);
                                  paramContext.a().a(l1, j);
                                  if (m == 1)
                                  {
                                    paramContext.a().a(k, l1, true, false);
                                    paramIntent = paramContext.a().a();
                                    if (paramIntent != null)
                                    {
                                      localObject1 = String.valueOf(l1);
                                      j = UITools.b(k);
                                      if ((j != -1) && (j != 1011) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                                      {
                                        if (j != 1) {
                                          break label555;
                                        }
                                        localObject2 = (TroopManager)paramContext.getManager(51);
                                        if ((localObject2 != null) && (((TroopManager)localObject2).a((String)localObject1) != null))
                                        {
                                          localObject1 = paramIntent.a((String)localObject1, j);
                                          if (localObject1 != null)
                                          {
                                            ((RecentUser)localObject1).lastmsgtime = MessageCache.a();
                                            paramIntent.a((RecentUser)localObject1);
                                          }
                                        }
                                      }
                                    }
                                    if ((k != 1) && (k != 7) && (k != 9) && (k != 10))
                                    {
                                      paramIntent = (QCallFacade)paramContext.getManager(37);
                                      if (paramIntent != null) {
                                        paramIntent.a(l1, l2, true, -1L, bool1, false);
                                      }
                                    }
                                    if ((paramContext.a().b() == l1) && (paramContext.a().b() >= 4) && (paramContext.a().e()))
                                    {
                                      paramContext.a().c(true);
                                      paramContext.a().e(true);
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  paramContext.a().a(i, k, l1, l2);
                                  if (!QLog.isColorLevel()) {
                                    break;
                                  }
                                  QLog.d(jdField_a_of_type_JavaLangString, 2, "member join discussId: " + l1 + ", friendUin: " + l2 + ", roomUserNum:" + m);
                                  return;
                                  paramContext.a().a(k, l1, false, false);
                                  paramContext.a().c(true);
                                  break label245;
                                  localObject1 = paramIntent.a((String)localObject1, j);
                                  if (localObject1 == null) {
                                    break label354;
                                  }
                                  ((RecentUser)localObject1).lastmsgtime = MessageCache.a();
                                  paramIntent.a((RecentUser)localObject1);
                                  break label354;
                                  if ((paramContext.a().b() == l1) && (paramContext.a().e()))
                                  {
                                    paramContext.a().a(k, l1, false, false);
                                    paramContext.a().c(true);
                                    paramContext.a().e(true);
                                  }
                                }
                              }
                              if (i != 23) {
                                break;
                              }
                              k = paramIntent.getIntExtra("relationType", 0);
                              l1 = paramIntent.getLongExtra("relationId", 0L);
                              l2 = paramIntent.getLongExtra("friendUin", 0L);
                              int m = paramIntent.getIntExtra("roomUserNum", 0);
                              if (l2 == Long.valueOf(paramContext.getCurrentAccountUin()).longValue())
                              {
                                long l3 = paramIntent.getLongExtra("time", 0L);
                                boolean bool2 = paramIntent.getBooleanExtra("hasPstn", false);
                                paramContext.a().a(9, k, l1, 0);
                                paramContext.a().a(k, Long.valueOf(l1), false);
                                paramContext.a().a(k, l1, j);
                                paramContext.a().a(9, k, l1, 0);
                                paramContext.a().c(false);
                                if (k != 1)
                                {
                                  localObject1 = (QCallFacade)paramContext.getManager(37);
                                  if (localObject1 != null) {
                                    ((QCallFacade)localObject1).a(l1, l2, false, l3, bool1, Boolean.valueOf(bool2).booleanValue());
                                  }
                                }
                                QAVHrMeeting.a(paramContext, paramIntent, k, l1);
                              }
                              if (m == 1) {
                                paramContext.a().a(k, l1, true, false);
                              }
                              paramContext.a().a(i, k, l1, l2);
                            } while (!QLog.isColorLevel());
                            QLog.d(jdField_a_of_type_JavaLangString, 2, "member quit discussId: " + l1 + ", friendUin: " + l2);
                            return;
                            if (i != 32) {
                              break;
                            }
                            l1 = paramIntent.getLongExtra("relationId", -1L);
                            k = paramIntent.getIntExtra("uinType", -1);
                          } while (k != 1);
                          l2 = paramIntent.getIntExtra("closeType", 1);
                          paramContext.a().a(i, k, l1, l2, j);
                          return;
                          if (i != 33) {
                            break;
                          }
                          l1 = paramIntent.getLongExtra("relationId", -1L);
                          j = paramIntent.getIntExtra("uinType", -1);
                          l2 = paramIntent.getLongExtra("info", -1L);
                          paramIntent = paramIntent.getStringExtra("strMsg");
                        } while (j != 1);
                        paramContext.a().a(i, j, l1, l2, paramIntent);
                        return;
                        if (i != 25) {
                          break;
                        }
                        l1 = paramIntent.getLongExtra("relationId", -1L);
                        i = paramIntent.getIntExtra("relationType", -1);
                        int k = paramIntent.getIntExtra("reason", -1);
                        if (QLog.isColorLevel()) {
                          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_ROOM_DESTROY-->relationid=" + l1 + " relationType=" + i + " reason=" + k + " avtype" + j);
                        }
                        if (k == 4) {
                          paramContext.a().a(32, 1, l1, k, j);
                        }
                        if (paramContext.a().a(i, l1) > 0L)
                        {
                          paramContext.a().a(13, i, l1, null, 0L);
                          VideoMsgTools.a(paramContext, i, 14, false, String.valueOf(l1), paramContext.getCurrentAccountUin(), false, null, false, j, new Object[0]);
                          paramContext.a().a(21, i, l1, 0L);
                          return;
                        }
                      } while (!QLog.isColorLevel());
                      QLog.w(jdField_a_of_type_JavaLangString, 2, "MultiRoomMemberNum is 0");
                      return;
                      if (i != 401) {
                        break;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN");
                    return;
                    if (i != 402) {
                      break;
                    }
                    i = paramIntent.getIntExtra("relationType", 0);
                    l1 = paramIntent.getLongExtra("relationId", 0L);
                    l2 = paramIntent.getLongExtra("friendUin", 0L);
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_MEMBER_LEAVE: relationType: " + i + ", relationId:" + l1 + ", friendUin:" + l2);
                    }
                    paramContext.a().a(String.valueOf(l2), false);
                    paramContext.a().c(false);
                    paramContext = (QCallFacade)paramContext.getManager(37);
                  } while (paramContext == null);
                  paramContext.a("" + l2, 0, 0);
                  return;
                  if (i == 403)
                  {
                    i = paramIntent.getIntExtra("relationType", 3);
                    l1 = paramIntent.getLongExtra("relationId", 0L);
                    l2 = paramIntent.getLongExtra("friendUin", 0L);
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = " + i + " ,relationId = " + l1 + " ,friendUin = " + l2);
                    }
                    paramIntent = (QCallFacade)paramContext.getManager(37);
                    if (paramIntent != null) {
                      paramIntent.a("" + l2, 0, 0);
                    }
                    paramContext.a().a(String.valueOf(l2), false);
                    paramContext.a().c(false);
                    return;
                  }
                  if (i != 405) {
                    break label1762;
                  }
                  localObject1 = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
                  if (localObject1 != null) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_MEMBERS_ADD_PSTN_MEMBERS --> no data");
                return;
                l1 = paramIntent.getLongExtra("relationId", -1L);
                paramIntent = paramIntent.getStringExtra("sendUin");
                localObject1 = PstnUtils.a((ArrayList)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_MEMBERS_ADD_PSTN_MEMBERS --> JsonObject = " + (String)localObject1);
                }
                localObject2 = (QCallFacade)paramContext.getManager(37);
              } while (localObject2 == null);
              ((QCallFacade)localObject2).a(1, l1, paramIntent, (String)localObject1);
              paramContext = (DiscussionHandler)paramContext.a(6);
            } while ((paramContext == null) || (paramContext.a() == null));
            paramContext.a().e(String.valueOf(l1));
            return;
          } while (i != 411);
          localObject1 = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
          if (localObject1 != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
        return;
        l1 = paramIntent.getLongExtra("relationId", -1L);
        paramIntent = PstnUtils.a((ArrayList)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + paramIntent);
        }
        localObject1 = (QCallFacade)paramContext.getManager(37);
      } while (localObject1 == null);
      ((QCallFacade)localObject1).a(0, l1, "", paramIntent);
      paramContext = (DiscussionHandler)paramContext.a(6);
    } while ((paramContext == null) || (paramContext.a() == null));
    label354:
    paramContext.a().e(String.valueOf(l1));
    label555:
    label1762:
    return;
  }
  
  void c(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    boolean bool2 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_START_DOUBLE_VIDEO_MEETING uinType: " + i + ", peerUin: " + paramContext + ", updateTime: " + bool1 + ", showTime: " + bool3);
    }
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    if (bool1)
    {
      paramIntent.a().e(true);
      paramIntent.a().c(true);
    }
    paramIntent.a().a(7, paramContext, 2);
    paramIntent.a().a(i, paramContext, null, bool2);
    paramIntent.a().a(paramContext, true);
    Object localObject = paramIntent.a();
    long l = Long.valueOf(paramContext).longValue();
    if (!bool3)
    {
      bool1 = true;
      ((AVNotifyCenter)localObject).a(0, l, bool1, true);
      if (i == 0)
      {
        localObject = (QCallFacade)paramIntent.getManager(37);
        if (!bool3) {
          break label297;
        }
        ((QCallFacade)localObject).a(paramContext, i, 6);
      }
    }
    for (;;)
    {
      try
      {
        if ((MsgProxyUtils.a(paramContext, i)) || (!MsgProxyUtils.r(i))) {
          continue;
        }
        bool1 = paramIntent.a().b(paramContext, i);
        if (bool1) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        label297:
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
      ((QCallFacade)localObject).a(paramContext, i, 5);
      continue;
      paramIntent = paramIntent.a().a();
      if ((paramIntent != null) && (paramIntent.b(paramContext, i) == null) && (!TextUtils.isEmpty(paramContext)))
      {
        paramContext = paramIntent.a(paramContext, i);
        if (paramContext != null)
        {
          paramContext.lastmsgtime = MessageCache.a();
          paramIntent.a(paramContext);
        }
      }
    }
  }
  
  void d(Context paramContext, Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("bindType", 0);
    String str = paramIntent.getStringExtra("bindId");
    paramContext = paramIntent.getStringExtra("peerUin");
    Object localObject = paramIntent.getStringExtra("extraUin");
    boolean bool2 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool5 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    boolean bool4 = paramIntent.getBooleanExtra("isNearbyVideoChat", false);
    if (AudioHelper.e()) {
      AudioHelper.a("onStartVideoChat[VideoConstants.ACTION_START_VIDEO_CHAT]", paramIntent.getExtras(), true);
    }
    if (i == -1) {}
    do
    {
      do
      {
        return;
        if (!bool1) {
          break;
        }
      } while (((paramContext == null) || (paramContext.length() <= 2)) && ((localObject == null) || (((String)localObject).length() <= 2)));
      paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramIntent == null);
    if (bool2) {
      paramIntent.a().b(bool2);
    }
    if (bool5)
    {
      paramIntent.a().e(true);
      paramIntent.a().c(true);
    }
    if (bool1)
    {
      paramIntent.a().a(i, paramContext, (String)localObject, bool2);
      paramIntent.a().a(6, paramContext, k);
      AVNotifyCenter localAVNotifyCenter = paramIntent.a();
      k = UITools.a(i);
      if (!bool3)
      {
        bool1 = true;
        label279:
        localAVNotifyCenter.a(k, paramContext, bool1, bool2);
        label291:
        paramIntent.a().f(bool4);
        paramIntent.a().a(28, i, paramContext, (String)localObject);
        if ((i != 1) && (i != 9500) && (i != 1011))
        {
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (i != 1006) || ((paramContext != null) && (paramContext.indexOf("+") >= 0))) {
            break label702;
          }
          paramContext = (Context)localObject;
        }
      }
    }
    label389:
    label432:
    label702:
    for (;;)
    {
      for (;;)
      {
        localObject = (QCallFacade)paramIntent.getManager(37);
        try
        {
          ((QCallFacade)localObject).a().a(paramContext, i).isSystemCall = 0;
          if (localObject != null)
          {
            if ((j != 2) && (j != 3) && (i != 25)) {
              break label580;
            }
            if (bool3) {
              ((QCallFacade)localObject).a(paramContext, 8, i, j, str, 6);
            }
          }
          else if (i == 1008) {}
          for (;;)
          {
            try
            {
              if ((MsgProxyUtils.a(paramContext, i)) || (!MsgProxyUtils.r(i))) {
                continue;
              }
              bool1 = paramIntent.a().b(paramContext, i);
              if (bool1) {
                continue;
              }
            }
            catch (Exception paramContext)
            {
              label580:
              continue;
            }
            a(bool2);
            return;
            if (l >= 100L) {
              break;
            }
            return;
            bool1 = false;
            break label279;
            paramIntent.a().a(m, Long.valueOf(l), true);
            paramIntent.a().a(6, m, l, k);
            paramContext = paramIntent.a();
            if (!bool3)
            {
              bool1 = true;
              paramContext.a(m, l, bool1, bool2);
              paramContext = String.valueOf(l);
              break label291;
            }
            bool1 = false;
            continue;
            ((QCallFacade)localObject).a(paramContext, 8, i, j, str, 5);
            break label432;
            if (bool3)
            {
              ((QCallFacade)localObject).a(paramContext, i, 6);
              break label432;
            }
            if (bool2) {
              break label432;
            }
            ((QCallFacade)localObject).a(paramContext, i, 5);
            break label432;
            if ((j != 2) && (j != 3) && (i != 25))
            {
              paramIntent = paramIntent.a().a();
              if ((paramIntent != null) && (paramIntent.b(paramContext, i) == null) && (!TextUtils.isEmpty(paramContext)) && (paramContext.length() > 2))
              {
                paramContext = paramIntent.a(paramContext, i);
                if (paramContext != null)
                {
                  paramContext.lastmsgtime = MessageCache.a();
                  paramIntent.a(paramContext);
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          break label389;
        }
      }
    }
  }
  
  void e(Context paramContext, Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("uinType", 0);
    int i = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    paramContext = paramIntent.getStringExtra("peerUin");
    Object localObject = paramIntent.getStringExtra("extraUin");
    int j = paramIntent.getIntExtra("stopReason", 0);
    String str3 = paramIntent.getStringExtra("senderUin");
    String str1 = paramIntent.getStringExtra("selfUin");
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool2 = paramIntent.getBooleanExtra("isSystemCalling", false);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l5 = paramIntent.getLongExtra("relationId", 0L);
    long l1 = paramIntent.getLongExtra(VideoConstants.d, 0L);
    long l2 = paramIntent.getLongExtra(VideoConstants.jdField_e_of_type_JavaLangString, 0L);
    int m = paramIntent.getIntExtra(VideoConstants.f, 0);
    long l3 = paramIntent.getLongExtra(VideoConstants.i, 0L);
    long l4 = paramIntent.getLongExtra(VideoConstants.j, 0L);
    long l6 = paramIntent.getLongExtra("score_connect_duration", 0L);
    paramIntent.getIntExtra("sessionType", 0);
    if (AudioHelper.e()) {
      AudioHelper.a("onVideoChatEnd[VideoConstants.ACTION_STOP_VIDEO_CHAT]", paramIntent.getExtras(), true);
    }
    if (k == 26) {
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQAppInterface == null) {}
      label662:
      label664:
      label676:
      label1444:
      for (;;)
      {
        return;
        localQQAppInterface.a().b(false);
        if ((j == 4) || (j == 6) || (j == 1)) {
          if (bool1)
          {
            localQQAppInterface.a().a(k, paramContext, (String)localObject, false);
            localQQAppInterface.a().a(8, paramContext, 0);
          }
        }
        for (;;)
        {
          localQQAppInterface.a().a(28, k, paramContext, (String)localObject);
          if ((k == 1) || (k == 1011) || (k == 9500)) {
            break;
          }
          if ((j != 3) && (j != 4) && (j != 5) && (j != 6) && (j != 8)) {
            break label676;
          }
          if ((bool2) || (k == 1008)) {
            break;
          }
          if (k != 0) {
            break label664;
          }
          bool1 = false;
          if (!TextUtils.isEmpty(str1)) {
            bool1 = str1.equals(str3);
          }
          VideoMsgTools.a(localQQAppInterface, k, 1, true, paramContext, str3, bool1, null, true, new Object[0]);
          return;
          localQQAppInterface.a().a(n, Long.valueOf(l5), false);
          localQQAppInterface.a().a(8, n, l5, 0);
          continue;
          if ((j == 0) && ((localQQAppInterface.a().e() == 3) || (localQQAppInterface.a().e() == 4)))
          {
            localQQAppInterface.a().a(k, paramContext, (String)localObject, false);
            localQQAppInterface.a().a(8, paramContext, 0);
          }
          else
          {
            if (bool1) {
              if ((str1 != null) && (localQQAppInterface.getCurrentAccountUin() != null) && (str1.equals(localQQAppInterface.getCurrentAccountUin())))
              {
                localQQAppInterface.a().a(k, paramContext, (String)localObject, false);
                localQQAppInterface.a().a(8, paramContext, 0);
                localQQAppInterface.a().c(false);
              }
            }
            for (;;)
            {
              if (j != 7) {
                break label662;
              }
              String str4 = paramIntent.getStringExtra("actId");
              String str5 = paramIntent.getStringExtra("mp_ext_params");
              if (str4 == null) {
                break;
              }
              VideoMsgTools.a(localQQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", str4, str5, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener);
              break;
              localQQAppInterface.a().a(n, Long.valueOf(l5), false);
              localQQAppInterface.a().a(8, n, l5, 0);
              localQQAppInterface.a().c(false);
            }
          }
        }
        a(j, (String)localObject, paramContext, str3);
        return;
        if ((j == 0) || (j == 1) || (j == 2))
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (k == 1006) && ((paramContext == null) || (paramContext.indexOf("+") < 0))) {
            paramContext = (Context)localObject;
          }
          for (;;)
          {
            if ((str1 != null) && (localQQAppInterface.getCurrentAccountUin() != null) && (!str1.equals(localQQAppInterface.getCurrentAccountUin()))) {
              break label1444;
            }
            localObject = (QCallFacade)localQQAppInterface.getManager(37);
            if ((localQQAppInterface.a().d(paramContext)) || (localObject == null)) {
              break;
            }
            if ((i == 2) || (i == 3) || (k == 25)) {
              ((QCallFacade)localObject).a(paramContext, 8, k, i, str2, 0);
            }
            for (;;)
            {
              paramContext = paramIntent.getStringExtra("actId");
              paramIntent = paramIntent.getStringExtra("mp_ext_params");
              if (paramContext == null) {
                break;
              }
              VideoMsgTools.a(localQQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", paramContext, paramIntent, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener);
              return;
              ((QCallFacade)localObject).a(paramContext, k, 0);
              localObject = SharedPreUtils.f(localQQAppInterface.getCurrentAccountUin());
              i = ((SharedPreferences)localObject).getInt("qav_score_switch", 0);
              n = ((SharedPreferences)localObject).getInt("qav_score_rate", 5);
              j = ((SharedPreferences)localObject).getInt("qav_score_time", 0);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoChatEnd : addTipsVideoMsg duration : " + l6 + ", scoreRate : " + n);
              }
              if ((str1 != null) && (i == 1) && (n != 0) && (l6 >= j) && (ImageResUtil.a("qav_score_good.jpg")) && (ImageResUtil.a("qav_score_normal.jpg")) && (ImageResUtil.a("qav_score_bad.jpg")) && (str1 != null))
              {
                j = ((SharedPreferences)localObject).getInt(VideoConstants.c, 0) + 1;
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoChatEnd : addTipsVideoMsg scoreCount : " + j);
                }
                bool1 = ((SharedPreferences)localObject).getBoolean(VideoConstants.l, false);
                if ((j == 1) && (!bool1))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "delete score item");
                  }
                  l5 = ((SharedPreferences)localObject).getLong("qav_score_msg_uniseq", 0L);
                  if (l5 != 0L) {
                    localQQAppInterface.a().b(paramContext, k, l5);
                  }
                }
                i = j;
                if (j % n == 0)
                {
                  ScoreManager.a("{\n" + VideoConstants.d + ":" + l1 + ",\n" + VideoConstants.jdField_e_of_type_JavaLangString + ":" + l2 + ",\n" + VideoConstants.f + ":" + m + ",\n" + VideoConstants.i + ":" + l3 + ",\n" + VideoConstants.j + ":" + l4 + ",\n" + VideoConstants.k + ":" + paramContext + "\n}");
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "addTipsVideoMsg beginTime: " + l1 + ", endTime: " + l2 + ", sdkVersion: " + m + ", bussinessType: " + l3 + ", bussinessFlag: " + l4 + ",toUin: " + paramContext);
                  }
                  VideoMsgTools.a(localQQAppInterface, k, 61, true, paramContext, null);
                  i = 0;
                  ((SharedPreferences)localObject).edit().putBoolean(VideoConstants.l, false).commit();
                }
                ((SharedPreferences)localObject).edit().putInt(VideoConstants.c, i).commit();
              }
            }
          }
        }
      }
    }
  }
  
  void f(Context paramContext, Intent paramIntent)
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
    paramContext = (FriendsManager)localQQAppInterface.getManager(50);
    if ((paramContext != null) && (!paramContext.b(str)) && (i != 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "other terminal chating with: " + str + " , sessionType: " + i + " ,uintype: " + j);
    }
    QCallFacade localQCallFacade = (QCallFacade)localQQAppInterface.getManager(37);
    if (i == 0)
    {
      paramIntent = localQQAppInterface.a().b(l);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal roomId reset peerUin=" + paramIntent);
      localQQAppInterface.a().c(paramIntent);
      paramContext = paramIntent;
      if (localQCallFacade != null)
      {
        paramContext = paramIntent;
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramContext = paramIntent;
          if (j != 1)
          {
            paramContext = paramIntent;
            if (localQCallFacade.a(paramIntent, j) == 7)
            {
              localQCallFacade.a(paramIntent, j, 0);
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
      if (localQCallFacade == null) {
        break;
      }
      paramContext = str;
      if (localQCallFacade.a(str, j) == 6) {
        break;
      }
      localQCallFacade.a(str, j, 7);
      paramContext = str;
      break;
    }
  }
  
  void g(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    Object localObject = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("friendName");
    String str1 = paramIntent.getStringExtra("extraUin");
    String str3 = paramIntent.getStringExtra("replyMsg");
    boolean bool = paramIntent.getBooleanExtra("isDiyMsg", false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_MSG_REPLY uinType: " + i + ", friendUin: " + (String)localObject + ", friendNick: " + str2 + ", extraUin: " + str1 + ", replyMsg: " + str3 + ", isDiyMsg: " + bool);
    }
    if (bool)
    {
      paramContext = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
      paramContext.putExtra("uintype", i);
      paramContext.putExtra("uinname", str2);
      paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramIntent == null) {
        return;
      }
      if (i == 1006)
      {
        paramContext.putExtra("uin", str1);
        if (!QQUtils.a(paramIntent.getApp())) {
          break label364;
        }
        paramContext.putExtra("ext_panel_onresume", 2);
      }
      for (;;)
      {
        paramContext.putExtra("enter_ext_panel", 1);
        paramIntent.getApp().startActivity(paramContext);
        return;
        if (i == 1000)
        {
          paramContext.putExtra("uin", (String)localObject);
          localObject = ((TroopManager)paramIntent.getManager(51)).a(str1);
          paramContext.putExtra("troop_uin", ((TroopInfo)localObject).troopcode);
          paramContext.putExtra("troop_code", ((TroopInfo)localObject).troopuin);
          break;
        }
        if (i == 1004)
        {
          paramContext.putExtra("uin", (String)localObject);
          paramContext.putExtra("troop_uin", str1);
          break;
        }
        paramContext.putExtra("uin", (String)localObject);
        break;
        label364:
        paramContext.putExtra("ext_panel_onresume", 1);
      }
    }
    paramIntent = new Message();
    paramIntent.what = 0;
    paramIntent.obj = new Object[] { Integer.valueOf(i), str2, str1, localObject, paramContext, str3 };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 300L);
  }
  
  void h(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("isPtt", false);
    int i = paramIntent.getIntExtra("uinType", 0);
    Object localObject1 = paramIntent.getStringExtra("friendUin");
    Object localObject2 = paramIntent.getStringExtra("friendName");
    paramIntent = paramIntent.getStringExtra("extraUin");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_MSG_LEAVE uinType: " + i + ", friendUin: " + (String)localObject1 + ", friendNick: " + (String)localObject2 + ", extraUin: " + paramIntent + ", isPtt: " + bool);
    }
    paramContext = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
    paramContext.putExtra("uintype", i);
    paramContext.putExtra("uinname", (String)localObject2);
    localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    if (i == 1006)
    {
      paramContext.putExtra("uin", paramIntent);
      label196:
      if (!QQUtils.a(((QQAppInterface)localObject2).getApp())) {
        break label411;
      }
      paramContext.putExtra("ext_panel_onresume", 2);
      label216:
      if (!bool) {
        break label423;
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
        paramContext.putExtra("uin", (String)localObject1);
        localObject1 = ((TroopManager)((QQAppInterface)localObject2).getManager(51)).a(paramIntent);
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "findTroopInfo fail ,uin : " + paramIntent);
          return;
        }
        paramContext.putExtra("troop_uin", ((TroopInfo)localObject1).troopuin);
        paramContext.putExtra("troop_code", ((TroopInfo)localObject1).troopcode);
        break label196;
      }
      if (i == 1004)
      {
        paramContext.putExtra("uin", (String)localObject1);
        paramContext.putExtra("troop_uin", paramIntent);
        break label196;
      }
      paramContext.putExtra("uin", (String)localObject1);
      break label196;
      label411:
      paramContext.putExtra("ext_panel_onresume", 1);
      break label216;
      label423:
      paramContext.putExtra("enter_ext_panel", 1);
    }
  }
  
  void i(Context paramContext, Intent paramIntent)
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
  
  void j(Context paramContext, Intent paramIntent)
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
  
  void k(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("peerUin");
    int i = paramIntent.getIntExtra("sessionType", 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_START_VIDEO_AVSWITCH sessionType: " + i);
    }
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    paramIntent.a().a(5, paramContext, i);
  }
  
  void l(Context paramContext, Intent paramIntent)
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
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str3 = localQQAppInterface.getApp().getString(2131429224);
    paramIntent = ContactUtils.l(localQQAppInterface, str1);
    paramContext = paramIntent;
    if (paramIntent.length() > 10) {
      paramContext = paramIntent.substring(0, 4) + "...";
    }
    paramIntent = localQQAppInterface.getApp();
    if (bool1) {}
    for (int i = 2131429225;; i = 2131429226)
    {
      paramContext = String.format(paramIntent.getString(i), new Object[] { paramContext });
      paramContext = DialogUtil.b(localQQAppInterface.getApp().getApplicationContext(), 230, str3, paramContext, 2131433029, 2131429056, new zvs(this, localQQAppInterface, j, k, bool1, str1, str2, bool2), null);
      paramContext.getWindow().setType(2003);
      paramContext.show();
      DataReport.a(localQQAppInterface.isBackground_Pause, bool1);
      paramIntent = new Message();
      paramIntent.what = 1;
      paramIntent.obj = new Object[] { paramContext, Integer.valueOf(j), Boolean.valueOf(bool1), str1, str2, Boolean.valueOf(bool2) };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
      return;
    }
  }
  
  void m(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_CALLING_DIALOG_MULTI");
    }
    String str1 = String.valueOf(paramIntent.getLongExtra("friendUin", 0L));
    String str2 = String.valueOf(paramIntent.getLongExtra("discussId", 0L));
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("type", 0);
    String str3 = paramIntent.getStringExtra("realSenderUin");
    paramIntent = paramIntent.getStringExtra("peerUin");
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    String str4 = ((QQAppInterface)localObject).getApp().getString(2131429224);
    if (i == 3000) {
      paramContext = ContactUtils.c((QQAppInterface)localObject, str2, str1);
    }
    for (;;)
    {
      paramContext = String.format(((QQAppInterface)localObject).getApp().getString(2131429227), new Object[] { paramContext });
      paramContext = DialogUtil.b(((QQAppInterface)localObject).getApp().getApplicationContext(), 230, str4, paramContext, 2131433029, 2131429056, new zvt(this, (QQAppInterface)localObject, i, j, str2, str1, paramIntent, str3), null);
      paramContext.getWindow().setType(2003);
      paramContext.show();
      DataReport.c(((QQAppInterface)localObject).isBackground_Pause);
      localObject = new Message();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), str2, str1, paramIntent, str3 };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 10000L);
      return;
      if (i == 1) {
        paramContext = ContactUtils.d((QQAppInterface)localObject, str1, str2);
      } else {
        paramContext = ContactUtils.l((QQAppInterface)localObject, str1);
      }
    }
  }
  
  void n(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("msgType", 5);
    paramIntent.getIntExtra("bindType", 0);
    paramIntent.getStringExtra("bindId");
    boolean bool1 = paramIntent.getBooleanExtra("isVideoMsg", true);
    paramContext = paramIntent.getStringExtra("friendUin");
    String str = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool3 = paramIntent.getBooleanExtra("isRead", false);
    paramIntent = paramIntent.getStringExtra("extra");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {}
    label278:
    for (;;)
    {
      return;
      VideoMsgTools.a(localQQAppInterface, i, j, bool1, paramContext, str, bool2, paramIntent, bool3);
      bool1 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131434218), "qqsetting_notify_showcontent_key", true);
      if (QQUtils.a(localQQAppInterface.getApp()))
      {
        bool2 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131435420), "qqsetting_lock_screen_whenexit_key", true);
        bool1 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131434218), "qqsetting_notify_showcontent_key", true);
      }
      for (;;)
      {
        if ((!bool2) || (!bool1)) {
          break label278;
        }
        ((QQLSRecentManager)localQQAppInterface.getManager(71)).a(localQQAppInterface, paramContext, 8, true);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
        return;
        bool2 = false;
      }
    }
  }
  
  void o(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bindType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getByteArrayExtra("sig");
    String str = paramIntent.getStringExtra("peerUin");
    paramIntent = paramIntent.getStringExtra("phoneNum");
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (QCallFacade)((QQAppInterface)localObject).getManager(37);
    } while ((localObject == null) || ((i != 2) && (i != 3) && (j != 25)));
    ((QCallFacade)localObject).a(str, 8, paramContext, paramIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getAction();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onReceive action = " + (String)localObject1);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject4;
    label1793:
    label2207:
    label2293:
    label2300:
    do
    {
      do
      {
        Object localObject3;
        int i;
        Object localObject2;
        do
        {
          do
          {
            do
            {
              long l;
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
                                do
                                {
                                  return;
                                  localObject4 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                                  QLog.d(jdField_a_of_type_JavaLangString, 1, "onReceive app = " + localObject4);
                                } while (localObject4 == null);
                                if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(((QQAppInterface)localObject4).getApp().getPackageName())))
                                {
                                  QLog.d(jdField_a_of_type_JavaLangString, 1, "onReceive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + (String)localObject1);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddVideoMsg"))
                                {
                                  a(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.VideoFlowSize"))
                                {
                                  i(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.MultiVideo"))
                                {
                                  b(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.StartDoubleVideoMeeting"))
                                {
                                  c(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.StartVideoChat"))
                                {
                                  d(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.StopVideoChat"))
                                {
                                  e(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.AvSwitch"))
                                {
                                  k(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.AnotherTerChating"))
                                {
                                  f(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddMsgSig"))
                                {
                                  j(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.CallingDialog"))
                                {
                                  l(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.CallingDialogMulti"))
                                {
                                  m(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.setChatStatus"))
                                {
                                  p(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.updateChatInfo"))
                                {
                                  q(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.downloadAvSo"))
                                {
                                  r(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddLightalkMsg"))
                                {
                                  n(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.AddLightalkSig"))
                                {
                                  o(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.av.v2q.CheckChatAbility"))
                                {
                                  t(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.downloadGAudioSound"))
                                {
                                  s(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddContactsToDiscuss"))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d(jdField_a_of_type_JavaLangString, 2, "addDiscussMember");
                                  }
                                  localObject3 = paramIntent.getStringExtra("discussUin");
                                  i = paramIntent.getIntExtra("uiFlag", 0);
                                  paramContext = null;
                                  if (paramIntent.getSerializableExtra("notAcceptUserList") != null) {
                                    paramContext = (ArrayList)paramIntent.getSerializableExtra("notAcceptUserList");
                                  }
                                  localObject1 = null;
                                  if (paramIntent.getSerializableExtra("notAcceptPhoneList") != null) {
                                    localObject1 = (ArrayList)paramIntent.getSerializableExtra("notAcceptPhoneList");
                                  }
                                  localObject2 = null;
                                  if (paramIntent.getSerializableExtra("pstnInRoomPhoneList") != null) {
                                    localObject2 = (ArrayList)paramIntent.getSerializableExtra("pstnInRoomPhoneList");
                                  }
                                  VideoMsgTools.a((QQAppInterface)localObject4, (String)localObject3, i, paramContext, (ArrayList)localObject1, (ArrayList)localObject2, paramIntent.getBooleanExtra("selectNotAcceptFlag", false));
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.MeetingMemberManager"))
                                {
                                  VideoMsgTools.a((QQAppInterface)localObject4, paramIntent.getStringExtra("discussUin"));
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.AddContactsFromC2C"))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d(jdField_a_of_type_JavaLangString, 2, "addDiscussMemberFromC2C");
                                  }
                                  VideoMsgTools.b((QQAppInterface)localObject4, paramIntent.getStringExtra("peerUin"));
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.replyMsg"))
                                {
                                  g(paramContext, paramIntent);
                                  return;
                                }
                                if (((String)localObject1).equals("tencent.video.v2q.leaveMsg"))
                                {
                                  h(paramContext, paramIntent);
                                  return;
                                }
                                if (!((String)localObject1).equals("tencent.video.v2q.AudioEngineReady")) {
                                  break;
                                }
                                paramContext = paramIntent.getStringExtra("peerUin");
                                l = paramIntent.getLongExtra("roomId", 0L);
                              } while ((l == 0L) || (paramContext == null));
                              if (QLog.isColorLevel()) {
                                QLog.d(jdField_a_of_type_JavaLangString, 2, "<qav printer> message send: cmd[0x211, 0xb]");
                              }
                              paramIntent = (VideoC2CHandler)((QQAppInterface)localObject4).a(39);
                              paramIntent.b = paramContext;
                              paramIntent.a = l;
                              paramIntent.b();
                              return;
                              if (((String)localObject1).equals("tencent.video.v2q.GaudioOpenTroopCard"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_GAUDIO_TROOP_CARD");
                                }
                                localObject2 = paramIntent.getStringExtra("troopUin");
                                localObject1 = paramIntent.getStringExtra("memberUin");
                                if (paramIntent.getIntExtra("UinType", -1) == 3000)
                                {
                                  if (((String)localObject1).equals(((QQAppInterface)localObject4).getCurrentAccountUin()))
                                  {
                                    paramIntent = new ProfileActivity.AllInOne((String)localObject1, 0);
                                    paramIntent.g = 5;
                                    ProfileActivity.b(paramContext, paramIntent);
                                    return;
                                  }
                                  if (((FriendsManager)((QQAppInterface)localObject4).getManager(50)).b((String)localObject1))
                                  {
                                    paramIntent = new ProfileActivity.AllInOne((String)localObject1, 1);
                                    paramIntent.h = ContactUtils.a((QQAppInterface)localObject4, (String)localObject1, 0);
                                    paramIntent.g = 5;
                                    ProfileActivity.b(paramContext, paramIntent);
                                    return;
                                  }
                                  paramIntent = new ProfileActivity.AllInOne((String)localObject1, 46);
                                  paramIntent.h = ContactUtils.a((QQAppInterface)localObject4, (String)localObject1, 0);
                                  paramIntent.f = ((String)localObject1);
                                  paramIntent.jdField_e_of_type_Int = 3000;
                                  paramIntent.jdField_e_of_type_JavaLangString = ((String)localObject2);
                                  paramIntent.g = 5;
                                  ProfileActivity.b(paramContext, paramIntent);
                                  return;
                                }
                                TroopMemberCardUtils.a((QQAppInterface)localObject4, ((QQAppInterface)localObject4).getApp(), (String)localObject2, (String)localObject1, 0, -1);
                                return;
                              }
                              if (((String)localObject1).equals("tencent.video.v2q.BindContact"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_BIND_CONTACT from qav");
                                }
                                paramContext = new Intent(paramContext, BindNumberActivity.class);
                                paramContext.putExtra("kNeedUnbind", true);
                                paramContext.addFlags(268435456);
                                ((QQAppInterface)localObject4).getApp().startActivity(paramContext);
                                return;
                              }
                              if (((String)localObject1).equals("tencent.video.v2q.OpenContactList"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_OPEN_CONTACT_LIST from qav");
                                }
                                paramContext = new Intent(paramContext, PhoneFrameActivity.class);
                                paramContext.putExtra("key_req_type", 0);
                                paramContext.addFlags(268435456);
                                ((QQAppInterface)localObject4).getApp().startActivity(paramContext);
                                return;
                              }
                              if (!((String)localObject1).equals("tencent.video.v2q.AnnimateDownloadStart")) {
                                break;
                              }
                              i = paramIntent.getIntExtra("callId", 0);
                            } while ((i <= 0) || (!VipFunCallManager.b()));
                            paramContext = (VipFunCallManager)((QQAppInterface)localObject4).getManager(83);
                          } while (paramContext == null);
                          paramContext.a(i, VipFunCallManager.a(), false, 0);
                          return;
                          if (!((String)localObject1).equals("tencent.video.v2q.commingRingDownload")) {
                            break;
                          }
                          i = paramIntent.getIntExtra("comming_ring_down_key", 0);
                        } while ((i <= 0) || (!VipFunCallManager.b()));
                        ((ColorRingManager)((QQAppInterface)localObject4).getManager(44)).a(i, 3, false, 0, "comering");
                        int j = ((SVIPHandler)((QQAppInterface)localObject4).a(13)).j();
                        ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + j, i + "", "", "");
                        return;
                        if (((String)localObject1).equals("chatbgBroadcast"))
                        {
                          localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                          paramIntent = paramIntent.getStringExtra("friendUin");
                          ChatBackground.a(paramContext, ((QQAppInterface)localObject4).getAccount(), paramIntent, (String)localObject1);
                          return;
                        }
                        if (!((String)localObject1).equals("tencent.video.v2q.insertSystemCall")) {
                          break;
                        }
                        localObject1 = ((QQAppInterface)localObject4).a();
                      } while (localObject1 == null);
                      paramIntent = paramIntent.getStringExtra("phoneNumber");
                      paramContext = paramIntent;
                      if (paramIntent != null)
                      {
                        paramContext = paramIntent;
                        if (!paramIntent.startsWith("+")) {
                          paramContext = "+86" + paramIntent;
                        }
                      }
                      ((QCallFacade)localObject1).b(paramContext);
                      return;
                      if (((String)localObject1).equals("tencent.video.v2q.upgradeInvite"))
                      {
                        VideoMsgTools.a((QQAppInterface)localObject4, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("type", 0));
                        return;
                      }
                      if (!((String)localObject1).equals("tencent.video.v2q.SmallScreenState")) {
                        break;
                      }
                      i = paramIntent.getIntExtra("SmallScreenState", 0);
                      paramContext = paramIntent.getStringExtra("peerUin");
                      if (QLog.isColorLevel()) {
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_SMALL_SCREEN_STATE smallScreenState : " + i);
                      }
                      ((QQAppInterface)localObject4).a().b(i);
                    } while (TextUtils.isEmpty(paramContext));
                    ((QQAppInterface)localObject4).a().d(paramContext);
                    return;
                    if (!((String)localObject1).equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO")) {
                      break;
                    }
                    paramContext = new HashMap();
                    paramContext.put("MultiAVType", String.valueOf(2));
                    paramContext.put("enterType", paramIntent.getIntExtra("enterType", 0) + "");
                  } while (BaseActivity.sTopActivity == null);
                  ChatActivityUtils.a((QQAppInterface)localObject4, BaseActivity.sTopActivity, 1, paramIntent.getStringExtra("relationId"), true, true, null, paramContext);
                  return;
                  if (!((String)localObject1).equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO")) {
                    break label1793;
                  }
                  paramContext = paramIntent.getStringExtra("relationId");
                  l = paramIntent.getLongExtra("friendUin", 0L);
                  if (l != 0L) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:" + l);
                return;
                localObject1 = paramIntent.getStringExtra("inviteId");
                i = paramIntent.getIntExtra("dealResult", 1);
                ((TroopHandler)((QQAppInterface)localObject4).a(20)).a(paramContext, l, (String)localObject1, i);
                paramIntent = (TroopManager)((QQAppInterface)localObject4).getManager(51);
              } while (paramIntent == null);
              paramIntent.d(paramContext, l + "");
              return;
              if (!((String)localObject1).equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END")) {
                break;
              }
              paramContext = (TroopManager)((QQAppInterface)localObject4).getManager(51);
            } while (paramContext == null);
            paramContext.d(paramIntent.getStringExtra("relationId"), paramIntent.getStringExtra("inviterUin"));
            return;
            if (!((String)localObject1).equals("tencent.video.v2q.generalFuncCall")) {
              break;
            }
          } while (!"SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")));
          paramContext = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        } while (paramContext == null);
        ShareMsgHelper.a((QQAppInterface)localObject4, paramIntent.getStringExtra("uin"), paramIntent.getIntExtra("uintype", -1), paramContext, null);
        return;
        if (((String)localObject1).equals("tencent.av.v2q.CancelCallBack"))
        {
          paramContext = paramIntent.getStringExtra("fromPhone");
          localObject1 = paramIntent.getStringExtra("toPhone");
          localObject2 = paramIntent.getStringExtra("fromUin");
          i = paramIntent.getIntExtra("uinType", 0);
          localObject3 = paramIntent.getStringExtra("toUin");
          paramIntent = paramIntent.getStringExtra("callBackId");
          localObject4 = (PstnHandler)((QQAppInterface)localObject4).a(82);
          ((PstnHandler)localObject4).a(paramContext, (String)localObject1, (String)localObject2, i, (String)localObject3, paramIntent);
          ((PstnHandler)localObject4).a(60005, true, null);
          return;
        }
        if (((String)localObject1).equals("tencent.av.v2q.ip2Pstn"))
        {
          localObject1 = new Intent(paramContext, QCallStartBrigeActivity.class);
          ((Intent)localObject1).putExtras(paramIntent);
          ((Intent)localObject1).putExtra("param_from_type", 2);
          ((Intent)localObject1).addFlags(268435456);
          paramContext.startActivity((Intent)localObject1);
          ReportController.b((QQAppInterface)localObject4, "CliOper", "", "", "0X8006406", "0X8006406", 3, 0, "", "", "", "");
          return;
        }
        if (((String)localObject1).equals("tencent.av.v2q.multiPsntTryEnd"))
        {
          localObject1 = ((QQAppInterface)localObject4).getApplication().getResources().getString(2131438425);
          localObject2 = ((QQAppInterface)localObject4).getApplication().getResources().getString(2131438426);
          localObject3 = ((QQAppInterface)localObject4).getApplication().getResources().getString(2131438427);
          localObject4 = (PstnManager)((QQAppInterface)localObject4).getManager(142);
          String str2 = ((PstnManager)localObject4).a("key_pstn_multi_try_over_recharge_title");
          String str1 = ((PstnManager)localObject4).a("key_pstn_multi_try_over_recharge_content");
          localObject4 = ((PstnManager)localObject4).a("key_pstn_multi_try_over_recharge_confirm_text");
          if (TextUtils.isEmpty(str2))
          {
            if (!TextUtils.isEmpty(str1)) {
              break label2293;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label2300;
            }
          }
          for (;;)
          {
            localObject4 = new Intent(paramContext, SysCallTransparentActivity.class);
            ((Intent)localObject4).addFlags(268435456);
            ((Intent)localObject4).putExtra("pstn_dialog_type", 3);
            ((Intent)localObject4).putExtra("pstn_guide_title", (String)localObject1);
            ((Intent)localObject4).putExtra("pstn_guide_content", (String)localObject2);
            paramIntent.putExtra("pstn_guide_confirm", (String)localObject3);
            paramContext.startActivity((Intent)localObject4);
            return;
            localObject1 = str2;
            break;
            localObject2 = str1;
            break label2207;
            localObject3 = localObject4;
          }
        }
        if (!((String)localObject1).equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED")) {
          break;
        }
        paramContext = (NowProxy)((QQAppInterface)localObject4).getManager(181);
      } while (paramContext == null);
      paramContext.b();
      return;
    } while (!((String)localObject1).equals("tencent.video.v2q.AddMembersToGroup"));
    if (QLog.isColorLevel()) {
      AudioHelper.a(jdField_a_of_type_JavaLangString + ".addGroupMember", paramIntent.getExtras(), true);
    }
    VideoMsgTools.c((QQAppInterface)localObject4, paramIntent.getStringExtra("discussUin"));
  }
  
  void p(Context paramContext, Intent paramIntent)
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
  
  void q(Context paramContext, Intent paramIntent)
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
  
  void r(Context paramContext, Intent paramIntent)
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
        paramContext = (EarlyDownloadManager)paramContext.getManager(76);
      } while (paramContext == null);
      paramContext = (QavSoDownloadHandler)paramContext.a(QavSoDownloadHandler.e());
    } while (paramContext == null);
    paramContext.a(false);
  }
  
  void s(Context paramContext, Intent paramIntent)
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
        paramContext = (EarlyDownloadManager)paramContext.getManager(76);
      } while (paramContext == null);
      paramContext = (QavGAudioSoundHandler)paramContext.a("qq.android.qav.muteaudio");
    } while (paramContext == null);
    paramContext.a(false);
  }
  
  void t(Context paramContext, Intent paramIntent)
  {
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {
      return;
    }
    paramIntent = paramContext.getApp().getString(2131429045);
    String str = paramContext.getApp().getString(2131429041);
    paramContext = DialogUtil.b(paramContext.getApp().getApplicationContext(), 230, str, paramIntent, 2131433029, 2131429056, new zvu(this), null);
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