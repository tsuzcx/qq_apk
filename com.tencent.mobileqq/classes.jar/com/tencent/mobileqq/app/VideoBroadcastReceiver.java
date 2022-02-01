package com.tencent.mobileqq.app;

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
import com.tencent.av.VideoConstants;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QavMsgNotificationUtil;
import com.tencent.av.utils.ScoreManager;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoC2CHandler;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  static VideoBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver;
  public static String a = "VideoBroadCastReceiver";
  INetEngineListener jdField_a_of_type_ComTencentMobileqqTransfileINetEngineListener = new VideoBroadcastReceiver.4(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = false;
  
  VideoBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_MqqOsMqqHandler = new VideoBroadcastReceiver.MyHandler(Looper.getMainLooper(), this);
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (GesturePWDUtils.isAppOnForegroundByTasks(paramContext, 0)) {
      return PopupDialog.a(paramContext, 230, paramString1, paramString2, 2131690728, 2131694583, paramOnClickListener, null);
    }
    paramString1 = DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131690728, 2131694583, paramOnClickListener, null);
    if (Build.VERSION.SDK_INT >= 26) {
      paramString1.getWindow().setType(2038);
    } else {
      paramString1.getWindow().setType(2003);
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (Settings.canDrawOverlays(paramContext)) {
        paramString1.show();
      } else {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "can not DrawOverlays showAlertDialog()!!");
      }
    }
    else {
      paramString1.show();
    }
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
    QCallFacade localQCallFacade = (QCallFacade)localQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (localQCallFacade != null) {
      if ((paramInt1 != 3) && (paramInt1 != 4)) {
        localQCallFacade.a(paramInt2, paramString1, paramString2, paramString3, 2);
      } else {
        localQCallFacade.a(paramInt2, paramString1, paramString2, paramString3, 8);
      }
    }
    try
    {
      paramString2 = MessageRecordFactory.a(-4008);
      paramString2.selfuin = localQQAppInterface.getCurrentAccountUin();
      paramString2.frienduin = paramString1;
      paramString2.senderuin = paramString3;
      paramString2.msgtype = -4008;
      paramString2.isread = true;
      paramString2.issend = 1;
      paramString2.istroop = paramInt2;
      paramString2.time = MessageCache.a();
      QavMsgNotificationUtil.a(localQQAppInterface, 1, true, true, paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (((paramInt == 3000) || (paramInt == 1)) && (paramString != null))
    {
      paramQQAppInterface.getAVNotifyCenter().a(12, UITools.b(paramInt), Long.valueOf(paramString).longValue(), null, 0L);
      paramQQAppInterface.getAVNotifyCenter().a(21, UITools.b(paramInt), Long.valueOf(paramString).longValue(), 0L);
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    int i = paramIntent.getIntExtra("uinType", 0);
    String str2 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("effectId", 0);
    ThemeBackground.a(paramContext, "theme_bg_aio_path", paramQQAppInterface.getAccount(), str1, "", "", "", 0, null, false);
    ChatBackgroundUtil.a(paramContext, paramQQAppInterface.getAccount(), str2, str1, j, i);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = new Intent(paramContext, PhoneFrameActivity.class);
    paramContext.putExtra("key_req_type", 0);
    paramContext.addFlags(268435456);
    paramQQAppInterface.getApp().startActivity(paramContext);
  }
  
  private void a(Intent paramIntent, long paramLong, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("SmallScreenState", 0);
    paramIntent = paramIntent.getStringExtra("uin");
    if (QQAudioHelper.c())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_SMALL_SCREEN_STATE, smallScreenState[");
      localStringBuilder.append(i);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    paramQQAppInterface.getAVNotifyCenter().b(paramLong, i);
    if (!TextUtils.isEmpty(paramIntent)) {
      paramQQAppInterface.getAVNotifyCenter().b(paramIntent);
    }
  }
  
  private void a(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("relationType", 3);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ,relationId = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" ,friendUin = ");
      localStringBuilder.append(l2);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
    paramIntent = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramIntent != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l2);
      paramIntent.a(localStringBuilder.toString(), 0, 0);
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
    //   3: getstatic 107	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	com/tencent/mobileqq/app/VideoBroadcastReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 355	com/tencent/mobileqq/app/VideoBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 107	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   20: ldc 2
    //   22: monitorexit
    //   23: new 357	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 358	android/content/IntentFilter:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc_w 360
    //   35: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: ldc_w 365
    //   42: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: ldc_w 367
    //   49: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc_w 369
    //   56: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w 371
    //   63: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 373
    //   70: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc_w 375
    //   77: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ldc_w 377
    //   84: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: ldc_w 379
    //   91: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: ldc_w 381
    //   98: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: ldc_w 383
    //   105: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: ldc_w 385
    //   112: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc_w 387
    //   119: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: ldc_w 389
    //   126: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: ldc_w 391
    //   133: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: ldc_w 393
    //   140: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: ldc_w 395
    //   147: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: ldc_w 397
    //   154: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: ldc_w 399
    //   161: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: ldc_w 401
    //   168: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   171: aload_1
    //   172: ldc_w 403
    //   175: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   178: aload_1
    //   179: ldc_w 405
    //   182: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   185: aload_1
    //   186: ldc_w 407
    //   189: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: ldc_w 409
    //   196: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc_w 411
    //   203: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   206: aload_1
    //   207: ldc_w 413
    //   210: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc_w 415
    //   217: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   220: aload_1
    //   221: ldc_w 417
    //   224: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   227: aload_1
    //   228: ldc_w 419
    //   231: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   234: aload_1
    //   235: ldc_w 421
    //   238: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: ldc_w 423
    //   245: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   248: aload_1
    //   249: ldc_w 425
    //   252: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: ldc_w 427
    //   259: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   262: aload_1
    //   263: ldc_w 429
    //   266: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   269: aload_1
    //   270: ldc_w 431
    //   273: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   276: aload_1
    //   277: ldc_w 433
    //   280: invokevirtual 363	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: getstatic 107	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   290: aload_1
    //   291: ldc_w 435
    //   294: aconst_null
    //   295: invokevirtual 439	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   298: pop
    //   299: getstatic 107	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   302: iconst_1
    //   303: putfield 25	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_Boolean	Z
    //   306: return
    //   307: astore_0
    //   308: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +38 -> 349
    //   314: getstatic 96	com/tencent/mobileqq/app/VideoBroadcastReceiver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   317: astore_1
    //   318: new 284	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   325: astore_2
    //   326: aload_2
    //   327: ldc_w 441
    //   330: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload_0
    //   336: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_1
    //   341: iconst_2
    //   342: aload_2
    //   343: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 447	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: return
    //   350: astore_0
    //   351: ldc 2
    //   353: monitorexit
    //   354: aload_0
    //   355: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramQQAppInterface	QQAppInterface
    //   30	311	1	localObject	Object
    //   325	18	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   283	306	307	java/lang/Exception
    //   3	20	350	finally
    //   20	23	350	finally
    //   351	354	350	finally
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramQQAppInterface != null) {}
    try
    {
      paramQQAppInterface.a().a(paramString1, paramInt1).isSystemCall = 0;
      label28:
      if ((paramInt2 != 2) && (paramInt2 != 3) && (paramInt1 != 25))
      {
        if (paramBoolean1)
        {
          paramQQAppInterface.a(paramString1, paramInt1, 6);
          return;
        }
        if (!paramBoolean2) {
          paramQQAppInterface.a(paramString1, paramInt1, 5);
        }
      }
      else
      {
        if (paramBoolean1)
        {
          paramQQAppInterface.a(paramString1, 8, paramInt1, paramInt2, paramString2, 6);
          return;
        }
        paramQQAppInterface.a(paramString1, 8, paramInt1, paramInt2, paramString2, 5);
      }
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, SharedPreferences paramSharedPreferences, int paramInt3, boolean paramBoolean)
  {
    int i = paramSharedPreferences.getInt(VideoConstants.c, 0) + 1;
    boolean bool2 = paramSharedPreferences.getBoolean(VideoConstants.l, false);
    long l = 0L;
    if ((i == 1) && (!bool2))
    {
      l = paramSharedPreferences.getLong("qav_score_msg_uniseq", 0L);
      if (l != 0L) {
        paramQQAppInterface.getMessageFacade().b(paramString, paramInt1, l);
      }
    }
    boolean bool1;
    if ((paramInt3 != 0) && (i % paramInt3 == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoChatEnd, scoreCount[");
      localStringBuilder.append(i);
      localStringBuilder.append("], hasCommit[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], show2[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if ((!paramBoolean) && (!bool1))
    {
      paramInt1 = i;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{\n");
      ((StringBuilder)localObject).append(VideoConstants.d);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",\n");
      ((StringBuilder)localObject).append(VideoConstants.e);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",\n");
      ((StringBuilder)localObject).append(VideoConstants.f);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",\n");
      ((StringBuilder)localObject).append(VideoConstants.i);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(",\n");
      ((StringBuilder)localObject).append(VideoConstants.j);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramLong4);
      ((StringBuilder)localObject).append(",\n");
      ((StringBuilder)localObject).append(VideoConstants.k);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\n}");
      ScoreManager.a(((StringBuilder)localObject).toString());
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addTipsVideoMsg beginTime: ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", endTime: ");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(", sdkVersion: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", bussinessType: ");
        localStringBuilder.append(paramLong3);
        localStringBuilder.append(", bussinessFlag: ");
        localStringBuilder.append(paramLong4);
        localStringBuilder.append(",toUin: ");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      VideoMsgTools.a(paramQQAppInterface, paramInt1, 61, true, paramString, null);
      paramQQAppInterface = paramSharedPreferences.edit();
      paramString = VideoConstants.l;
      paramInt1 = 0;
      paramQQAppInterface.putBoolean(paramString, false).commit();
    }
    paramSharedPreferences.edit().putInt(VideoConstants.c, paramInt1).commit();
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    if ((!paramBoolean) && (paramInt2 != 1008))
    {
      if (paramInt2 == 0)
      {
        if (!TextUtils.isEmpty(paramString1)) {
          paramBoolean = paramString1.equals(paramString2);
        } else {
          paramBoolean = false;
        }
        VideoMsgTools.a(paramQQAppInterface, paramInt2, 1, true, paramString4, paramString2, paramBoolean, null, true, new Object[0]);
        return;
      }
      a(paramInt1, paramInt2, paramString3, paramString4, paramString2);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3, long paramLong4, long paramLong5)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 != 1006) || ((paramString3 == null) || (paramString3.contains("+")))) {
      paramString2 = paramString3;
    }
    if (!TextUtils.equals(paramString1, paramQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    paramString3 = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if ((!paramQQAppInterface.getAVNotifyCenter().d(paramString2)) && (paramString3 != null))
    {
      if ((paramInt2 != 2) && (paramInt2 != 3) && (paramInt1 != 25)) {
        a(paramQQAppInterface, paramString1, paramInt1, paramString2, paramLong1, paramLong2, paramLong3, paramInt3, paramLong4, paramLong5, paramString3);
      } else {
        paramString3.a(paramString2, 8, paramInt1, paramInt2, paramString4, 0);
      }
      paramString1 = paramIntent.getStringExtra("actId");
      paramIntent = paramIntent.getStringExtra("mp_ext_params");
      if (paramString1 != null)
      {
        VideoMsgTools.a(paramQQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", paramString1, paramIntent, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngineListener);
        return;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, QCallFacade paramQCallFacade)
  {
    boolean bool2 = false;
    paramQCallFacade.a(paramString2, paramInt1, 0);
    paramQCallFacade = SharedPreUtils.e(paramQQAppInterface.getCurrentAccountUin());
    int i = paramQCallFacade.getInt("qav_score_switch", 0);
    int j = paramQCallFacade.getInt("qav_score_rate", 5);
    int k = paramQCallFacade.getInt("qav_score_time", 0);
    boolean bool1;
    if ((paramString1 != null) && (i == 1) && (j != 0) && (paramLong1 >= k) && (ImageResUtil.a("qav_score_good.jpg")) && (ImageResUtil.a("qav_score_normal.jpg")) && (ImageResUtil.a("qav_score_bad.jpg"))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QQAudioHelper.a(17) == 1)
    {
      QQAudioHelper.a(HardCodeUtil.a(2131715863));
      bool2 = true;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoChatEnd, scoreSwitch[");
      localStringBuilder.append(i);
      localStringBuilder.append("], scoreRate[");
      localStringBuilder.append(j);
      localStringBuilder.append("], scoreTime[");
      localStringBuilder.append(k);
      localStringBuilder.append("], duration[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], show1[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], forceShow[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (((bool2) || (bool1)) && (paramString1 != null)) {
      a(paramQQAppInterface, paramInt1, paramString2, paramLong2, paramLong3, paramInt2, paramLong4, paramLong5, paramQCallFacade, j, bool2);
    }
  }
  
  private boolean a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (QAVConfigUtils.e())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "only SupportLocalDavBubbleMessage ");
      }
      return true;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramInt1 == 0) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      paramQQAppInterface = VideoMsgTools.a(paramQQAppInterface.getApp(), paramInt2, paramInt1, paramBoolean, paramString3);
      return (TextUtils.isEmpty(paramQQAppInterface)) || (!paramQQAppInterface.contains(paramContext.getString(2131720243)));
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "only support double talk");
    }
    return true;
  }
  
  private boolean a(String paramString, Context paramContext, Intent paramIntent)
  {
    long l = SeqUtil.a(paramIntent);
    if (paramString.equals("tencent.video.v2q.AddVideoMsg"))
    {
      a(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.VideoFlowSize"))
    {
      h(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.av.v2q.MultiVideo"))
    {
      a(l, paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.av.v2q.StartDoubleVideoMeeting"))
    {
      b(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.av.v2q.StartVideoChat"))
    {
      c(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.av.v2q.StopVideoChat"))
    {
      d(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.av.v2q.AvSwitch"))
    {
      j(paramContext, paramIntent);
    }
    else
    {
      if (!paramString.equals("tencent.av.v2q.AnotherTerChating")) {
        break label159;
      }
      e(paramContext, paramIntent);
    }
    return true;
    label159:
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
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("TYPE_DOUBLE_MEETING_MEMBER_LEAVE, relationType[");
      paramIntent.append(i);
      paramIntent.append("], relationId[");
      paramIntent.append(l1);
      paramIntent.append("], friendUin[");
      paramIntent.append(l2);
      paramIntent.append("]");
      QLog.d("AVShare", 2, paramIntent.toString());
    }
    paramQQAppInterface.getAVNotifyCenter().a(String.valueOf(l1), false);
    paramQQAppInterface.getAVNotifyCenter().b(false);
    paramIntent = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramIntent != null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("");
      paramQQAppInterface.append(l2);
      paramIntent.a(paramQQAppInterface.toString(), 0, 0);
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
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("TYPE_DOUBLE_MEETING_MEMBER_JOIN, relationType[");
      paramIntent.append(i);
      paramIntent.append("], relationId[");
      paramIntent.append(l1);
      paramIntent.append("], friendUin[");
      paramIntent.append(l2);
      paramIntent.append("]");
      QLog.d("AVShare", 2, paramIntent.toString());
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
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
      }
      return;
    }
    long l = paramIntent.getLongExtra("relationId", -1L);
    paramIntent = PstnUtils.a((ArrayList)localObject);
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = ");
      localStringBuilder.append(paramIntent);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    localObject = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (localObject != null)
    {
      ((QCallFacade)localObject).a(0, l, "", paramIntent);
      paramIntent = (DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if ((paramIntent != null) && (paramIntent.a() != null)) {
        paramIntent.a().e(String.valueOf(l));
      }
    }
  }
  
  private void e(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b(paramIntent.getStringExtra("relationId"), paramIntent.getStringExtra("inviterUin"));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIntent.getIntExtra("enterType", 0));
    localStringBuilder.append("");
    localHashMap.put("enterType", localStringBuilder.toString());
    if (BaseActivity.sTopActivity != null) {
      ChatActivityUtils.a(paramQQAppInterface, BaseActivity.sTopActivity, 1, paramIntent.getStringExtra("relationId"), true, true, null, localHashMap);
    }
  }
  
  private void h(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("callId", 0);
    if ((i > 0) && (VipFunCallUtil.a()))
    {
      paramIntent = VasUtil.a().getFunCallManager();
      if (paramIntent != null) {
        paramIntent.startDownload(i, VipFunCallUtil.a(), false, 0);
      }
    }
  }
  
  private void i(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    int i = paramIntent.getIntExtra("comming_ring_down_key", 0);
    if ((i > 0) && (VipFunCallUtil.a()))
    {
      ((ColorRingManager)paramQQAppInterface.getManager(QQManagerFactory.COLOR_RING_MANAGER)).a(i, 3, false, 0, "comering");
      int j = ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(j);
      paramIntent = paramIntent.toString();
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(i);
      paramQQAppInterface.append("");
      ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, paramIntent, paramQQAppInterface.toString(), "", "");
    }
  }
  
  private void j(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    QCallFacade localQCallFacade = paramQQAppInterface.getCallFacade();
    if (localQCallFacade != null)
    {
      paramQQAppInterface = paramIntent.getStringExtra("phoneNumber");
      paramIntent = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        paramIntent = paramQQAppInterface;
        if (!paramQQAppInterface.startsWith("+"))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("+86");
          paramIntent.append(paramQQAppInterface);
          paramIntent = paramIntent.toString();
        }
      }
      localQCallFacade.b(paramIntent);
    }
  }
  
  private void k(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if ("SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")))
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      ShareMsgHelper.a(paramQQAppInterface, paramIntent.getStringExtra("uin"), paramIntent.getIntExtra("uintype", -1), localAbsStructMsg, null);
    }
  }
  
  void a(long paramLong, Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 20);
    boolean bool = paramIntent.getBooleanExtra("isStart", false);
    int j = paramIntent.getIntExtra("MultiAVType", 0);
    if ((QQAudioHelper.c()) || (i == 22) || (i == 23) || (i == 25))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(".onMultiMsgV2Q");
      QQAudioHelper.a(((StringBuilder)localObject).toString(), paramIntent.getExtras());
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMultiMsgV2Q, type[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    if (i == 22)
    {
      a((QQAppInterface)localObject, paramContext, paramIntent, i, bool, j);
      return;
    }
    if (i == 23)
    {
      b((QQAppInterface)localObject, paramContext, paramIntent, i, bool, j);
      return;
    }
    long l;
    if (i == 32)
    {
      paramLong = paramIntent.getLongExtra("relationId", -1L);
      int k = paramIntent.getIntExtra("uinType", -1);
      if (k == 1)
      {
        l = paramIntent.getIntExtra("closeType", 1);
        ((QQAppInterface)localObject).getAVNotifyCenter().a(i, k, paramLong, l, j);
      }
    }
    else if (i == 33)
    {
      paramLong = paramIntent.getLongExtra("relationId", -1L);
      j = paramIntent.getIntExtra("uinType", -1);
      l = paramIntent.getLongExtra("info", -1L);
      paramContext = paramIntent.getStringExtra("strMsg");
      if (j == 1) {
        ((QQAppInterface)localObject).getAVNotifyCenter().a(i, j, paramLong, l, paramContext);
      }
    }
    else
    {
      if (i == 25)
      {
        a((QQAppInterface)localObject, paramContext, paramIntent, j);
        return;
      }
      if (i == 401)
      {
        c(paramIntent, (QQAppInterface)localObject);
        return;
      }
      if (i == 402)
      {
        b(paramIntent, (QQAppInterface)localObject);
        return;
      }
      if (i == 403)
      {
        a(paramIntent, (QQAppInterface)localObject);
        return;
      }
      if (i == 411) {
        d(paramIntent, (QQAppInterface)localObject);
      }
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ACTION_ADD_VIDEO_MSG");
    }
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("msgType", 5);
    int m = paramIntent.getIntExtra("msgDetail", 0);
    boolean bool2 = paramIntent.getBooleanExtra("isVideoMsg", true);
    String str1 = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("senderUin");
    String str3 = paramIntent.getStringExtra("selfUin");
    boolean bool3 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool4 = paramIntent.getBooleanExtra("isRead", false);
    Object localObject1 = paramIntent.getStringExtra("extra");
    int n = paramIntent.getIntExtra("MultiAVType", 0);
    boolean bool1 = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_ADD_VIDEO_MSG selfUin = ");
      localStringBuilder.append(str3);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 != null)
    {
      if ((k == 0) && (!TextUtils.equals(str3, ((QQAppInterface)localObject2).getCurrentAccountUin()))) {
        return;
      }
      int i;
      if (((k == 2) || (k == 24)) && (localObject1 == null) && (QQUtils.a(((QQAppInterface)localObject2).getApp())))
      {
        boolean bool5 = SettingCloneUtil.readValue(((QQAppInterface)localObject2).getApp(), ((QQAppInterface)localObject2).getCurrentAccountUin(), ((QQAppInterface)localObject2).getApp().getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
        boolean bool6 = SettingCloneUtil.readValue(((QQAppInterface)localObject2).getApp(), ((QQAppInterface)localObject2).getCurrentAccountUin(), ((QQAppInterface)localObject2).getApp().getString(2131718400), "qqsetting_notify_showcontent_key", true);
        a((QQAppInterface)localObject2, bool5, bool6);
        if ((bool5) && (bool6)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else
      {
        if ((k == 17) || (k == 15) || (k == 16)) {
          a(j, str1, (QQAppInterface)localObject2);
        }
        i = 0;
      }
      if (k == 17) {
        localObject1 = String.valueOf(m);
      }
      if ((n == 2) && (str1 != null) && (!a((QQAppInterface)localObject2, str1, k))) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addVideoMsgWithAvtype");
      }
      if ((!bool1) && (!a(paramContext, (QQAppInterface)localObject2, j, k, str1, str2, bool3, (String)localObject1))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (bool1) {
        VideoMsgTools.a((QQAppInterface)localObject2, j, k, bool2, str1, str2, bool3, (String)localObject1, bool4, n, new Object[0]);
      }
      if (QLog.isColorLevel())
      {
        paramContext = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addVideoMsgWithAvtype end with enable:=");
        ((StringBuilder)localObject1).append(bool1);
        QLog.d(paramContext, 2, ((StringBuilder)localObject1).toString());
      }
      if (i != 0)
      {
        paramContext = (QQLSRecentManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        paramContext.a((AppInterface)localObject2, str1, j, true, MsgPushReportHelper.a(str1, j, paramIntent), true);
        paramContext.a((AppInterface)localObject2, str1, j, true, MsgPushReportHelper.a(str1, j, paramIntent));
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
        }
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
        paramQQAppInterface = new AllInOne(str1, 0);
        paramQQAppInterface.lastActivity = 5;
        ProfileUtils.openProfileCard(paramContext, paramQQAppInterface);
        return;
      }
      if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str1))
      {
        paramIntent = new AllInOne(str1, 1);
        paramIntent.nickname = ContactUtils.a(paramQQAppInterface, str1, 0);
        paramIntent.lastActivity = 5;
        ProfileUtils.openProfileCard(paramContext, paramIntent);
        return;
      }
      paramIntent = new AllInOne(str1, 46);
      paramIntent.nickname = ContactUtils.a(paramQQAppInterface, str1, 0);
      paramIntent.preWinUin = str1;
      paramIntent.preWinType = 3000;
      paramIntent.discussUin = str2;
      paramIntent.lastActivity = 5;
      ProfileUtils.openProfileCard(paramContext, paramIntent);
      return;
    }
    TroopMemberCardUtils.a(paramQQAppInterface, paramQQAppInterface.getApp(), str2, str1, 0, -1);
  }
  
  void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    long l = paramIntent.getLongExtra("relationId", -1L);
    int m = paramIntent.getIntExtra("relationType", -1);
    int i = paramIntent.getIntExtra("reason", -1);
    boolean bool1 = paramIntent.getBooleanExtra("openClass", false);
    if (QLog.isColorLevel())
    {
      paramContext = jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder();
      paramIntent.append("TYPE_GAUDIO_ROOM_DESTROY-->relationid=");
      paramIntent.append(l);
      paramIntent.append(" relationType=");
      paramIntent.append(m);
      paramIntent.append(" reason=");
      paramIntent.append(i);
      paramIntent.append(" avtype");
      paramIntent.append(paramInt);
      QLog.d(paramContext, 2, paramIntent.toString());
    }
    if (i == 4) {
      paramQQAppInterface.getAVNotifyCenter().a(32, 1, l, i, paramInt);
    }
    boolean bool2 = true;
    if ((!bool1) && (m == 1) && (paramInt == 2))
    {
      paramContext = paramQQAppInterface.getAVNotifyCenter().a(l, paramInt);
      if ((paramContext != null) && (paramContext.d == 2) && (paramContext.e == 4)) {
        bool1 = bool2;
      }
    }
    paramContext = paramQQAppInterface.getAVNotifyCenter();
    if (bool1) {
      i = 2;
    } else {
      i = 0;
    }
    int j;
    if (bool1) {
      j = 4;
    } else {
      j = 0;
    }
    int k;
    if (bool1) {
      k = 0;
    } else {
      k = -1;
    }
    paramContext.a(9, l, paramInt, i, j, k, 25, 0);
    if (paramQQAppInterface.getAVNotifyCenter().a(m, l) > 0L)
    {
      paramQQAppInterface.getAVNotifyCenter().a(13, m, l, null, 0L);
      VideoMsgTools.a(paramQQAppInterface, m, 14, false, String.valueOf(l), paramQQAppInterface.getCurrentAccountUin(), false, null, false, paramInt, new Object[0]);
      paramQQAppInterface.getAVNotifyCenter().a(21, m, l, 0L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "MultiRoomMemberNum is 0");
    }
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
      }
      else
      {
        paramQQAppInterface.getAVNotifyCenter().a(i, l1, false, false);
        paramQQAppInterface.getAVNotifyCenter().b(true);
      }
      paramContext = paramQQAppInterface.getProxyManager().a();
      if (paramContext != null)
      {
        paramIntent = String.valueOf(l1);
        paramInt2 = UITools.c(i);
        if ((paramInt2 != -1) && (paramInt2 != 1011) && (!TextUtils.isEmpty(paramIntent))) {
          if (paramInt2 == 1)
          {
            TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if ((localTroopManager != null) && (localTroopManager.b(paramIntent) != null))
            {
              paramIntent = paramContext.a(paramIntent, paramInt2);
              if (paramIntent != null)
              {
                paramIntent.lastmsgtime = MessageCache.a();
                paramContext.b(paramIntent);
              }
            }
          }
          else
          {
            paramIntent = paramContext.a(paramIntent, paramInt2);
            if (paramIntent != null)
            {
              paramIntent.lastmsgtime = MessageCache.a();
              paramContext.b(paramIntent);
            }
          }
        }
      }
      if ((i != 1) && (i != 7) && (i != 9) && (i != 10))
      {
        paramContext = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
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
    else
    {
      long l3 = l1;
      if ((paramQQAppInterface.getAVNotifyCenter().b() == l3) && (paramQQAppInterface.getAVNotifyCenter().f()))
      {
        paramQQAppInterface.getAVNotifyCenter().a(i, l3, false, false);
        paramQQAppInterface.getAVNotifyCenter().b(true);
        paramQQAppInterface.getAVNotifyCenter().d(true);
      }
    }
    paramQQAppInterface.getAVNotifyCenter().a(paramInt1, i, l1, l2);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramContext = new StringBuilder();
      paramContext.append("member join discussId: ");
      paramContext.append(l1);
      paramContext.append(", friendUin: ");
      paramContext.append(l2);
      paramContext.append(", roomUserNum:");
      paramContext.append(j);
      QLog.d(paramQQAppInterface, 2, paramContext.toString());
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, long paramLong1, long paramLong2, long paramLong3, int paramInt4, long paramLong4, long paramLong5)
  {
    if ((paramInt1 != 3) && (paramInt1 != 4) && (paramInt1 != 5) && (paramInt1 != 6) && (paramInt1 != 8))
    {
      if ((paramInt1 == 0) || (paramInt1 == 1) || (paramInt1 == 2)) {
        a(paramQQAppInterface, paramIntent, paramString1, paramString3, paramInt2, paramString4, paramInt3, paramString5, paramLong1, paramLong2, paramLong3, paramInt4, paramLong4, paramLong5);
      }
    }
    else {
      a(paramQQAppInterface, paramInt1, paramBoolean, paramString1, paramString2, paramString3, paramInt2, paramString4);
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramInt1 != 1006) || ((paramString2 == null) || (paramString2.contains("+")))) {
      paramString1 = paramString2;
    }
    a(paramQQAppInterface, paramInt1, paramString1, paramInt2, paramBoolean1, paramString3, paramBoolean2);
    if (paramInt1 != 1008) {}
    try
    {
      if ((!UinTypeUtil.a(paramString1, paramInt1)) && (UinTypeUtil.h(paramInt1)) && (!paramQQAppInterface.getConversationFacade().b(paramString1, paramInt1))) {
        return;
      }
      if ((paramInt2 != 2) && (paramInt2 != 3) && (paramInt1 != 25) && (!paramBoolean3))
      {
        paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramString1, paramInt1) == null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 2))
        {
          paramString1 = paramQQAppInterface.a(paramString1, paramInt1);
          if (paramString1 != null)
          {
            paramString1.lastmsgtime = MessageCache.a();
            paramQQAppInterface.b(paramString1);
          }
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
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
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = paramQQAppInterface.getAVNotifyCenter().a(l, 2);
      if ((localVideoRoomInfo != null) && (localVideoRoomInfo.a > 0) && (paramInt == 13)) {
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
      return true;
    }
    catch (NumberFormatException paramQQAppInterface) {}
    return false;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    if (paramString.equals("tencent.video.v2q.AddMsgSig"))
    {
      i(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.CallingDialog"))
    {
      k(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.CallingDialogMulti"))
    {
      l(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.updateChatInfo"))
    {
      m(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.av.v2q.CheckChatAbility"))
    {
      o(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.downloadGAudioSound"))
    {
      n(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.AddContactsToDiscuss"))
    {
      VideoMsgTools.b(paramQQAppInterface, paramIntent.getStringExtra("discussUin"));
    }
    else if (paramString.equals("tencent.video.v2q.MeetingMemberManager"))
    {
      VideoMsgTools.a(paramQQAppInterface, paramIntent.getStringExtra("discussUin"));
    }
    else
    {
      if (!paramString.equals("tencent.video.v2q.AddContactsFromC2C")) {
        break label189;
      }
      f(paramIntent, paramQQAppInterface);
    }
    return true;
    label189:
    return false;
  }
  
  void b(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    long l;
    try
    {
      l = Long.parseLong(paramContext);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l = 0L;
    }
    if (l == 0L)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onStartVideoDoubleMeeting, uin is 0.");
      return;
    }
    boolean bool1 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool2 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ACTION_START_DOUBLE_VIDEO_MEETING uinType: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", peerUin: ");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(", updateTime: ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", showTime: ");
      ((StringBuilder)localObject).append(bool3);
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    if (bool2)
    {
      paramIntent.getAVNotifyCenter().d(true);
      paramIntent.getAVNotifyCenter().b(true);
    }
    paramIntent.getAVNotifyCenter().a(7, paramContext, 2);
    paramIntent.getAVNotifyCenter().a(i, paramContext, null, bool1);
    paramIntent.getAVNotifyCenter().a(paramContext, true);
    paramIntent.getAVNotifyCenter().a(0, l, bool3 ^ true, true);
    if (i == 0)
    {
      localObject = (QCallFacade)paramIntent.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (bool3) {
        ((QCallFacade)localObject).a(paramContext, i, 6);
      } else {
        ((QCallFacade)localObject).a(paramContext, i, 5);
      }
      try
      {
        if ((!UinTypeUtil.a(paramContext, i)) && (UinTypeUtil.h(i)) && (!paramIntent.getConversationFacade().b(paramContext, i))) {
          return;
        }
        paramIntent = paramIntent.getProxyManager().a();
        if ((paramIntent != null) && (paramIntent.b(paramContext, i) == null) && (!TextUtils.isEmpty(paramContext)))
        {
          paramContext = paramIntent.a(paramContext, i);
          if (paramContext != null)
          {
            paramContext.lastmsgtime = MessageCache.a();
            paramIntent.b(paramContext);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramIntent = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Recent User Proxy Error-->e=");
          ((StringBuilder)localObject).append(paramContext.getMessage());
          QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
        }
      }
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
      paramQQAppInterface = (VideoC2CHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_C2C_HANDLER);
      paramQQAppInterface.b = paramContext;
      paramQQAppInterface.a = l;
      paramQQAppInterface.a();
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    long l1 = paramIntent.getLongExtra("friendUin", 0L);
    int j = paramIntent.getIntExtra("roomUserNum", 0);
    if (l1 == Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue())
    {
      long l3 = paramIntent.getLongExtra("time", 0L);
      paramQQAppInterface.getAVNotifyCenter().a(9, i, l2, 0);
      paramQQAppInterface.getAVNotifyCenter().a(i, Long.valueOf(l2), false);
      paramQQAppInterface.getAVNotifyCenter().a(i, l2, paramInt2);
      paramQQAppInterface.getAVNotifyCenter().a(9, i, l2, 0);
      paramQQAppInterface.getAVNotifyCenter().b(false);
      if (i != 1)
      {
        paramContext = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (paramContext != null) {
          paramContext.a(l2, l1, false, l3, paramBoolean);
        }
      }
      QAVHrMeeting.a(paramQQAppInterface, paramIntent, i, l2);
    }
    if (j == 1) {
      paramQQAppInterface.getAVNotifyCenter().a(i, l2, true, false);
    }
    paramQQAppInterface.getAVNotifyCenter().a(paramInt1, i, l2, l1);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramContext = new StringBuilder();
      paramContext.append("member quit discussId: ");
      paramContext.append(l2);
      paramContext.append(", friendUin: ");
      paramContext.append(l1);
      QLog.d(paramQQAppInterface, 2, paramContext.toString());
    }
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    if (paramString.equals("tencent.video.v2q.replyMsg"))
    {
      f(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.leaveMsg"))
    {
      g(paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.AudioEngineReady"))
    {
      b(paramQQAppInterface, paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.GaudioOpenTroopCard"))
    {
      a(paramQQAppInterface, paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.BindContact"))
    {
      b(paramContext, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.OpenContactList"))
    {
      a(paramContext, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.AnnimateDownloadStart"))
    {
      h(paramIntent, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.commingRingDownload"))
    {
      i(paramIntent, paramQQAppInterface);
    }
    else
    {
      if (!paramString.equals("chatbgBroadcast")) {
        break label180;
      }
      a(paramContext, paramIntent, paramQQAppInterface);
    }
    return true;
    label180:
    return false;
  }
  
  void c(Context paramContext, Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("sessionType", 0);
    int k = paramIntent.getIntExtra("uinType", 0);
    int m = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    String str1 = paramIntent.getStringExtra("peerUin");
    String str3 = paramIntent.getStringExtra("extraUin");
    boolean bool3 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool5 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool4 = paramIntent.getBooleanExtra("showTime", false);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    boolean bool2 = paramIntent.getBooleanExtra("isNearbyVideoChat", false);
    boolean bool6 = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    int i = j;
    paramContext = str1;
    if (bool6)
    {
      paramContext = str1;
      if (TextUtils.isEmpty(str1)) {
        paramContext = String.valueOf(l);
      }
      if (j == 3)
      {
        i = 1;
      }
      else
      {
        i = j;
        if (j == 4) {
          i = 2;
        }
      }
      if (QLog.isColorLevel())
      {
        str1 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onStartVideoChat, double meeting. peer[");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("], sessionType[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        QLog.i(str1, 2, localStringBuilder.toString());
      }
      k = 0;
      bool1 = true;
    }
    if (QQAudioHelper.c()) {
      QQAudioHelper.a("onStartVideoChat[VideoConstants.ACTION_START_VIDEO_CHAT]", paramIntent.getExtras(), true);
    }
    if (k == -1) {
      return;
    }
    if (bool1)
    {
      if (((paramContext != null) && (paramContext.length() > 2)) || ((str3 != null) && (str3.length() > 2))) {}
    }
    else if (l < 100L) {
      return;
    }
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    if (bool3) {
      paramIntent.getAVNotifyCenter().a(bool3);
    }
    if (bool5)
    {
      paramIntent.getAVNotifyCenter().d(true);
      paramIntent.getAVNotifyCenter().b(true);
    }
    else if ((bool4) && (!paramIntent.getAVNotifyCenter().e()))
    {
      paramIntent.getAVNotifyCenter().b(true);
    }
    if (bool1)
    {
      paramIntent.getAVNotifyCenter().a(6, paramContext, i);
      paramIntent.getAVNotifyCenter().a(k, paramContext, str3, bool3);
      paramIntent.getAVNotifyCenter().a(UITools.b(k), paramContext, bool4 ^ true, bool3);
      if (bool6) {
        paramIntent.getAVNotifyCenter().a(paramContext, true);
      }
    }
    else
    {
      paramIntent.getAVNotifyCenter().a(n, Long.valueOf(l), true);
      paramIntent.getAVNotifyCenter().a(6, n, l, i);
      paramIntent.getAVNotifyCenter().a(n, l, bool4 ^ true, bool3);
      paramContext = String.valueOf(l);
    }
    paramIntent.getAVNotifyCenter().e(bool2);
    paramIntent.getAVNotifyCenter().a(28, k, paramContext, str3);
    if ((k != 1) && (k != 9500) && (k != 1011)) {
      a(paramIntent, str3, k, paramContext, m, bool4, str2, bool3, bool2);
    }
  }
  
  void c(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("relationId");
    long l = paramIntent.getLongExtra("friendUin", 0L);
    if (l == 0L)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = jdField_a_of_type_JavaLangString;
        paramContext = new StringBuilder();
        paramContext.append("ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:");
        paramContext.append(l);
        QLog.d(paramQQAppInterface, 2, paramContext.toString());
      }
      return;
    }
    String str = paramIntent.getStringExtra("inviteId");
    int i = paramIntent.getIntExtra("dealResult", 1);
    ((GVideoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER)).a(paramContext, l, str, i);
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append(l);
      paramIntent.append("");
      paramQQAppInterface.b(paramContext, paramIntent.toString());
    }
  }
  
  protected boolean c(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, Intent paramIntent)
  {
    long l = SeqUtil.a(paramIntent);
    boolean bool2 = paramString.equals("tencent.video.v2q.insertSystemCall");
    boolean bool1 = false;
    if (bool2)
    {
      j(paramIntent, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.upgradeInvite"))
    {
      VideoMsgTools.b(paramQQAppInterface, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("type", 0));
    }
    else if (paramString.equals("tencent.video.v2q.SmallScreenState"))
    {
      a(paramIntent, l, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO"))
    {
      g(paramIntent, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO"))
    {
      c(paramQQAppInterface, paramContext, paramIntent);
    }
    else if (paramString.equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END"))
    {
      e(paramIntent, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.generalFuncCall"))
    {
      k(paramIntent, paramQQAppInterface);
    }
    else if (paramString.equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED"))
    {
      ((IDynamicNowManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).b();
    }
    else if (paramString.equals("tencent.video.v2q.AddMembersToGroup"))
    {
      VideoMsgTools.a(paramQQAppInterface, paramContext, paramIntent);
    }
    else
    {
      if (!"tencent.video.v2q.checkPtuRes".equals(paramString)) {
        break label260;
      }
      paramQQAppInterface = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramQQAppInterface == null) {
        paramQQAppInterface = null;
      } else {
        paramQQAppInterface = (QQAppInterface)paramQQAppInterface.get();
      }
      PtuResChecker.a(paramQQAppInterface, paramIntent);
    }
    bool1 = true;
    label260:
    return bool1;
  }
  
  void d(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    Object localObject2 = paramIntent.getStringExtra("peerUin");
    String str1 = paramIntent.getStringExtra("extraUin");
    int k = paramIntent.getIntExtra("stopReason", 0);
    String str3 = paramIntent.getStringExtra("senderUin");
    paramContext = paramIntent.getStringExtra("selfUin");
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool2 = paramIntent.getBooleanExtra("isSystemCalling", false);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    long l3 = paramIntent.getLongExtra(VideoConstants.d, 0L);
    long l4 = paramIntent.getLongExtra(VideoConstants.e, 0L);
    int n = paramIntent.getIntExtra(VideoConstants.f, 0);
    long l5 = paramIntent.getLongExtra(VideoConstants.i, 0L);
    long l6 = paramIntent.getLongExtra(VideoConstants.j, 0L);
    long l7 = paramIntent.getLongExtra("score_connect_duration", 0L);
    paramIntent.getIntExtra("sessionType", 0);
    Object localObject1;
    long l1;
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = String.valueOf(l2);
      }
      l1 = l2;
      if (l2 == 0L) {
        l1 = AVUtil.a((String)localObject1);
      }
      bool1 = true;
    }
    else
    {
      l1 = l2;
      localObject1 = localObject2;
    }
    if (QQAudioHelper.c()) {
      QQAudioHelper.a("onVideoChatEnd[VideoConstants.ACTION_STOP_VIDEO_CHAT]", paramIntent.getExtras(), true);
    }
    if (i == 26) {
      localObject1 = str1;
    }
    localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    ((QQAppInterface)localObject2).getAVNotifyCenter().a(false);
    if ((k != 4) && (k != 6) && (k != 1))
    {
      if ((k == 0) && ((((QQAppInterface)localObject2).getAVNotifyCenter().e() == 3) || (((QQAppInterface)localObject2).getAVNotifyCenter().e() == 4)))
      {
        ((QQAppInterface)localObject2).getAVNotifyCenter().a(i, (String)localObject1, str1, false);
        ((QQAppInterface)localObject2).getAVNotifyCenter().a(8, (String)localObject1, 0);
      }
      else
      {
        if (bool1)
        {
          if ((paramContext != null) && (((QQAppInterface)localObject2).getCurrentAccountUin() != null))
          {
            if (!paramContext.equals(((QQAppInterface)localObject2).getCurrentAccountUin())) {
              break label492;
            }
            ((QQAppInterface)localObject2).getAVNotifyCenter().a(i, (String)localObject1, str1, false);
            ((QQAppInterface)localObject2).getAVNotifyCenter().a(8, (String)localObject1, 0);
            ((QQAppInterface)localObject2).getAVNotifyCenter().b(false);
          }
        }
        else
        {
          ((QQAppInterface)localObject2).getAVNotifyCenter().a(m, Long.valueOf(l1), false);
          ((QQAppInterface)localObject2).getAVNotifyCenter().a(8, m, l1, 0);
          ((QQAppInterface)localObject2).getAVNotifyCenter().b(false);
        }
        label492:
        if (k == 7)
        {
          String str4 = paramIntent.getStringExtra("actId");
          String str5 = paramIntent.getStringExtra("mp_ext_params");
          if (str4 != null) {
            VideoMsgTools.a((QQAppInterface)localObject2, "https://iyouxi3.vip.qq.com/ams3.0.php?", str4, str5, this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngineListener);
          }
        }
      }
    }
    else if (bool1)
    {
      ((QQAppInterface)localObject2).getAVNotifyCenter().a(i, (String)localObject1, str1, false);
      ((QQAppInterface)localObject2).getAVNotifyCenter().a(8, (String)localObject1, 0);
    }
    else
    {
      ((QQAppInterface)localObject2).getAVNotifyCenter().a(m, Long.valueOf(l1), false);
      ((QQAppInterface)localObject2).getAVNotifyCenter().a(8, m, l1, 0);
    }
    ((QQAppInterface)localObject2).getAVNotifyCenter().a(28, i, (String)localObject1, str1);
    if ((i != 1) && (i != 1011) && (i != 9500)) {
      a((QQAppInterface)localObject2, paramIntent, k, bool2, paramContext, str3, str1, i, (String)localObject1, j, str2, l7, l3, l4, n, l5, l6);
    }
  }
  
  void e(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sessionType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    long l = paramIntent.getLongExtra("roomId", 0L);
    String str = paramIntent.getStringExtra("peerUin");
    boolean bool = paramIntent.getBooleanExtra("isReceiver", false);
    paramContext = jdField_a_of_type_JavaLangString;
    paramIntent = new StringBuilder();
    paramIntent.append("onAnotherTerminal ACTION_VIDEO_ANOTHER_CHATING uinType: ");
    paramIntent.append(j);
    paramIntent.append(", peerUin: ");
    paramIntent.append(str);
    paramIntent.append(", roomId: ");
    paramIntent.append(l);
    paramIntent.append(", isReceiver: ");
    paramIntent.append(bool);
    paramIntent.append(",sessionType:");
    paramIntent.append(i);
    QLog.d(paramContext, 1, paramIntent.toString());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal app is null");
      return;
    }
    paramContext = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramContext != null) && (!paramContext.b(str)) && (i != 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
      return;
    }
    if (QLog.isColorLevel())
    {
      paramContext = jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder();
      paramIntent.append("other terminal chating with: ");
      paramIntent.append(str);
      paramIntent.append(" , sessionType: ");
      paramIntent.append(i);
      paramIntent.append(" ,uintype: ");
      paramIntent.append(j);
      QLog.d(paramContext, 2, paramIntent.toString());
    }
    paramIntent = (QCallFacade)localQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    Object localObject;
    if (i == 0)
    {
      paramContext = localQQAppInterface.getAVNotifyCenter().b(l);
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAnotherTerminal roomId reset peerUin=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i(str, 1, ((StringBuilder)localObject).toString());
      localQQAppInterface.getAVNotifyCenter().a(paramContext);
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramContext)) && (j != 1) && (paramIntent.a(paramContext, j) == 7)) {
        paramIntent.a(paramContext, j, 0);
      }
    }
    else
    {
      localQQAppInterface.getAVNotifyCenter().a(str, l, i);
      localObject = localQQAppInterface.getProxyManager();
      paramContext = null;
      if (localObject != null) {
        paramContext = ((ProxyManager)localObject).a();
      }
      if ((paramContext != null) && (paramContext.b(str, 0) == null) && (!bool))
      {
        if (i == 2) {
          bool = true;
        } else {
          bool = false;
        }
        VideoMsgTools.a(localQQAppInterface, j, 53, bool, str, localQQAppInterface.getCurrentUin(), true, null, true, new Object[0]);
      }
      paramContext = str;
      if (j != 1)
      {
        paramContext = str;
        if (paramIntent != null)
        {
          paramContext = str;
          if (paramIntent.a(str, j) != 6)
          {
            paramIntent.a(str, j, 7);
            paramContext = str;
          }
        }
      }
    }
    localQQAppInterface.getAVNotifyCenter().a(28, j, paramContext, "");
  }
  
  void f(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("friendUin");
    Object localObject = paramIntent.getStringExtra("friendName");
    String str2 = paramIntent.getStringExtra("extraUin");
    String str3 = paramIntent.getStringExtra("replyMsg");
    boolean bool = paramIntent.getBooleanExtra("isDiyMsg", false);
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_MSG_REPLY uinType: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", friendUin: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", friendNick: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", extraUin: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", replyMsg: ");
      localStringBuilder.append(str3);
      localStringBuilder.append(", isDiyMsg: ");
      localStringBuilder.append(bool);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
    if (bool)
    {
      paramIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
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
      }
      else if (i == 1000)
      {
        paramIntent.putExtra("uin", str1);
        paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).b(str2);
        paramIntent.putExtra("troop_uin", paramContext.troopcode);
        paramIntent.putExtra("troop_code", paramContext.troopuin);
        paramContext = paramIntent;
      }
      else if (i == 1004)
      {
        paramIntent.putExtra("uin", str1);
        paramIntent.putExtra("troop_uin", str2);
        paramContext = paramIntent;
      }
      else if (i == 1044)
      {
        paramContext = MatchChatMsgUtil.a(paramContext, str1, 21);
      }
      else
      {
        paramIntent.putExtra("uin", str1);
        paramContext = paramIntent;
      }
      if (QQUtils.a(((QQAppInterface)localObject).getApp())) {
        paramContext.putExtra("ext_panel_onresume", 2);
      } else {
        paramContext.putExtra("ext_panel_onresume", 1);
      }
      paramContext.putExtra("enter_ext_panel", 1);
      ((QQAppInterface)localObject).getApp().startActivity(paramContext);
      return;
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
    String str2 = paramIntent.getStringExtra("friendUin");
    Object localObject = paramIntent.getStringExtra("friendName");
    String str1 = paramIntent.getStringExtra("extraUin");
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_MSG_LEAVE uinType: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", friendUin: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", friendNick: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", extraUin: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", isPtt: ");
      localStringBuilder.append(bool);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
    paramIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
    paramIntent.putExtra("uintype", i);
    paramIntent.putExtra("uinname", (String)localObject);
    localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    if (i == 1006)
    {
      paramIntent.putExtra("uin", str1);
      paramContext = paramIntent;
    }
    else if (i == 1000)
    {
      paramIntent.putExtra("uin", str2);
      paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).b(str1);
      if (paramContext == null)
      {
        if (QLog.isColorLevel())
        {
          paramContext = jdField_a_of_type_JavaLangString;
          paramIntent = new StringBuilder();
          paramIntent.append("findTroopInfo fail ,uin : ");
          paramIntent.append(str1);
          QLog.e(paramContext, 2, paramIntent.toString());
        }
        return;
      }
      paramIntent.putExtra("troop_uin", paramContext.troopuin);
      paramIntent.putExtra("troop_code", paramContext.troopcode);
      paramContext = paramIntent;
    }
    else if (i == 1004)
    {
      paramIntent.putExtra("uin", str2);
      paramIntent.putExtra("troop_uin", str1);
      paramContext = paramIntent;
    }
    else if (i == 1044)
    {
      paramContext = MatchChatMsgUtil.a(paramContext, str2, 21);
      ReportController.b(null, "dc00898", "", "", "0X800AD97", "0X800AD97", 0, 0, "", "", "", "");
    }
    else
    {
      paramIntent.putExtra("uin", str2);
      paramContext = paramIntent;
    }
    if (QQUtils.a(((QQAppInterface)localObject).getApp())) {
      paramContext.putExtra("ext_panel_onresume", 2);
    } else {
      paramContext.putExtra("ext_panel_onresume", 1);
    }
    if (bool) {
      paramContext.putExtra("enter_ext_panel", 2);
    } else {
      paramContext.putExtra("enter_ext_panel", 1);
    }
    paramIntent = new Message();
    paramIntent.what = 4;
    paramIntent.obj = new Object[] { paramContext };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 300L);
  }
  
  void h(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("size", 0L);
    if (QLog.isColorLevel())
    {
      paramContext = jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder();
      paramIntent.append("ACTION_VIDEO_FLOW_SIZE: ");
      paramIntent.append(l);
      QLog.d(paramContext, 2, paramIntent.toString());
    }
    if ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
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
    Object localObject = paramIntent.getStringExtra("peerUin");
    int j = paramIntent.getIntExtra("sessionType", 0);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    paramContext = (Context)localObject;
    int k = j;
    if (bool)
    {
      int i;
      if (j == 3)
      {
        i = 1;
      }
      else
      {
        i = j;
        if (j == 4) {
          i = 2;
        }
      }
      paramContext = (Context)localObject;
      k = i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramContext = String.valueOf(l2);
        k = i;
      }
    }
    if ((n == 0) && (l2 == 0L)) {}
    for (long l1 = AVUtil.a(paramContext);; l1 = AVUtil.a(paramContext))
    {
      break;
      l1 = l2;
      if (n != 3) {
        break;
      }
      l1 = l2;
      if (l2 != 0L) {
        break;
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoConstants.ACTION_START_VIDEO_AVSWITCH relationType[");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], sessionType[");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("], uinType[");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("], peerUin[");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("], isDoubleVideoMeeting[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    paramIntent = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramIntent == null) {
      return;
    }
    localObject = paramIntent.getAVNotifyCenter();
    if ((!bool) && (n != 0))
    {
      ((AVNotifyCenter)localObject).a(5, n, l1, k);
      paramIntent.getAVNotifyCenter().a(28, m, paramContext, null);
      if (QLog.isDevelopLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAvSwitch, SessionType[");
        localStringBuilder.append(k);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 4, localStringBuilder.toString());
      }
    }
    else
    {
      ((AVNotifyCenter)localObject).a(5, paramContext, k);
    }
    if (bool) {
      paramIntent.getAVNotifyCenter().a(paramContext, true);
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
    String str3 = paramIntent.getApp().getString(2131695447);
    BaseApplication localBaseApplication = paramIntent.getApp();
    int i;
    if (bool1) {
      i = 2131695444;
    } else {
      i = 2131695448;
    }
    paramContext = a(paramContext, str3, localBaseApplication.getString(i), new VideoBroadcastReceiver.1(this, paramIntent, j, k, bool1, str1, str2, bool2));
    DataReport.a(paramIntent.isBackgroundPause, bool1);
    paramIntent = new Message();
    paramIntent.what = 1;
    paramIntent.obj = new Object[] { paramContext, Integer.valueOf(j), Boolean.valueOf(bool1), str1, str2, Boolean.valueOf(bool2) };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
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
    String str5 = localQQAppInterface.getApp().getString(2131695447);
    if (i == 3000) {
      paramIntent = ContactUtils.a(localQQAppInterface, str2, str1);
    } else if (i == 1) {
      paramIntent = ((ITroopMemberNameService)localQQAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNickByTroopCode(str1, str2);
    } else {
      paramIntent = ContactUtils.d(localQQAppInterface, str1);
    }
    paramIntent = String.format(localQQAppInterface.getApp().getString(2131695446), new Object[] { paramIntent });
    DataReport.e(false, true);
    paramContext = a(paramContext, str5, paramIntent, new VideoBroadcastReceiver.2(this, i, localQQAppInterface, j, str2, str1, str4, str3));
    DataReport.c(localQQAppInterface.isBackgroundPause);
    paramIntent = new Message();
    paramIntent.what = 2;
    paramIntent.obj = new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), str2, str1, str4, str3 };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
  }
  
  void m(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_RANDOM_UPDATE_CHAT_INFO uin:");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", nickName: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", headUrl: ");
      localStringBuilder.append(paramIntent);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramContext))
    {
      localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        return;
      }
      ((QQAppInterface)localObject).getAVNotifyCenter().a(paramContext, str, paramIntent);
    }
  }
  
  void n(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "EarlyDownload trigger AV so EarlyDownload");
    }
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {
      return;
    }
    paramContext = (IEarlyDownloadService)paramContext.getRuntimeService(IEarlyDownloadService.class, "");
    if (paramContext != null)
    {
      paramContext = (QavGAudioSoundHandler)paramContext.getEarlyHandler("qq.android.qav.muteaudio");
      if (paramContext != null) {
        paramContext.a(false);
      }
    }
  }
  
  void o(Context paramContext, Intent paramIntent)
  {
    paramContext = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null) {
      return;
    }
    paramIntent = paramContext.getApp().getString(2131695712);
    String str = paramContext.getApp().getString(2131695691);
    paramContext = DialogUtil.a(paramContext.getApp().getApplicationContext(), 230, str, paramIntent, 2131690728, 2131695618, new VideoBroadcastReceiver.3(this), null);
    paramContext.getWindow().setType(2003);
    paramContext.show();
    paramIntent = new Message();
    paramIntent.what = 3;
    paramIntent.obj = new Object[] { paramContext };
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 5000L);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onReceive, action[");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(SeqUtil.a(paramIntent));
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (QQAppInterface)((WeakReference)localObject1).get();
    }
    if (localObject1 != null)
    {
      if (str == null) {
        return;
      }
      localObject2 = paramIntent.getPackage();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.equals((CharSequence)localObject2, ((QQAppInterface)localObject1).getApp().getPackageName())))
      {
        boolean bool2 = a(str, paramContext, paramIntent);
        boolean bool1 = bool2;
        if (!bool2) {
          bool1 = a((QQAppInterface)localObject1, str, paramContext, paramIntent);
        }
        bool2 = bool1;
        if (!bool1) {
          bool2 = b((QQAppInterface)localObject1, str, paramContext, paramIntent);
        }
        bool1 = bool2;
        if (!bool2) {
          bool1 = c((QQAppInterface)localObject1, str, paramContext, paramIntent);
        }
        if ((!bool1) && (QLog.isDevelopLevel()))
        {
          paramContext = jdField_a_of_type_JavaLangString;
          paramIntent = new StringBuilder();
          paramIntent.append("onReceive, no deal action[");
          paramIntent.append(str);
          paramIntent.append("]");
          QLog.i(paramContext, 4, paramIntent.toString());
        }
        return;
      }
      paramContext = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive broadcast from wrong package:");
      ((StringBuilder)localObject1).append(paramIntent.getPackage());
      ((StringBuilder)localObject1).append(",action:");
      ((StringBuilder)localObject1).append(str);
      QLog.d(paramContext, 1, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */