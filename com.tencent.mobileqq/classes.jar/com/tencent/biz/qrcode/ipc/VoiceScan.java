package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PCMRecorder;
import com.tencent.chirp.PCMRecorder.OnQQRecorderListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import otd;

public class VoiceScan
  implements Handler.Callback, PCMRecorder.OnQQRecorderListener, ChirpSoHandler.Callback
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChirpWrapper jdField_a_of_type_ComTencentChirpChirpWrapper;
  private PCMRecorder jdField_a_of_type_ComTencentChirpPCMRecorder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public VoiceScan(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private static void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8 & 0xFF00));
      i += 1;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "checkVoiceScanEnable enableTalkBack = " + AppSetting.jdField_b_of_type_Boolean);
    }
    return AppSetting.jdField_b_of_type_Boolean;
  }
  
  private void d()
  {
    boolean bool = ChirpWrapper.a();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "isSoLoaded " + bool);
    }
    if (!bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = ((ChirpSoHandler)((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a("qq.android.system.chirp"));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(this);
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(true);
      }
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!AudioHelper.b(1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VoiceScan", 2, "checkInitVoiceScan, permission is forbidden, " + this.jdField_b_of_type_Boolean);
            }
          } while (this.jdField_b_of_type_Boolean);
          BaseApplicationImpl.sUiHandler.post(new otd(this));
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceScan", 2, "isVedioChatting");
        return;
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qrcode", 0);
        bool = localSharedPreferences.getBoolean("key_first_enter_voice_qrcode" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceScan", 2, "checkInitVoiceScan, isFirst = " + bool);
        }
        if (bool)
        {
          localSharedPreferences.edit().putBoolean("key_first_enter_voice_qrcode" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
          if (this.jdField_b_of_type_AndroidOsHandler != null) {
            this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(295, 2000L);
          }
        }
      } while (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null);
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = new ChirpWrapper();
      i = this.jdField_a_of_type_ComTencentChirpChirpWrapper.a();
      if (i == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceScan", 2, "decode chirp init failed = " + i);
    return;
    this.jdField_a_of_type_ComTencentChirpPCMRecorder = new PCMRecorder(this.jdField_a_of_type_AndroidContentContext, 44100, this);
    this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentChirpPCMRecorder != null)
    {
      this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
      this.jdField_a_of_type_ComTencentChirpPCMRecorder = null;
    }
    if (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null)
    {
      this.jdField_a_of_type_ComTencentChirpChirpWrapper.a();
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onScannerResume");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.c)
    {
      Process.setThreadPriority(-19);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    }
    while (this.d) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(292);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "record error = " + paramInt);
    }
    e();
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 191	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_1
    //   11: arraylength
    //   12: iconst_2
    //   13: idiv
    //   14: newarray short
    //   16: astore_3
    //   17: aload_1
    //   18: aload_3
    //   19: invokestatic 239	com/tencent/biz/qrcode/ipc/VoiceScan:a	([B[S)V
    //   22: aload_0
    //   23: getfield 191	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   26: aload_3
    //   27: bipush 15
    //   29: invokevirtual 242	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne -28 -> 9
    //   40: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +28 -> 71
    //   46: ldc 70
    //   48: iconst_2
    //   49: new 72	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   56: ldc 250
    //   58: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload_1
    //   72: ldc 252
    //   74: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   77: ifeq +260 -> 337
    //   80: iload_2
    //   81: aload_1
    //   82: invokevirtual 261	java/lang/String:length	()I
    //   85: if_icmpge +20 -> 105
    //   88: aload_1
    //   89: iload_2
    //   90: invokevirtual 265	java/lang/String:charAt	(I)C
    //   93: bipush 48
    //   95: if_icmpne +10 -> 105
    //   98: iload_2
    //   99: iconst_1
    //   100: iadd
    //   101: istore_2
    //   102: goto -22 -> 80
    //   105: aload_1
    //   106: iload_2
    //   107: invokevirtual 269	java/lang/String:substring	(I)Ljava/lang/String;
    //   110: astore_1
    //   111: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +29 -> 143
    //   117: ldc 70
    //   119: iconst_2
    //   120: new 72	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 271
    //   130: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_1
    //   144: invokestatic 277	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   147: pop2
    //   148: ldc_w 279
    //   151: invokestatic 283	com/tencent/mobileqq/app/QQAppInterface:f	(Ljava/lang/String;)V
    //   154: ldc2_w 284
    //   157: invokestatic 291	java/lang/Thread:sleep	(J)V
    //   160: aload_1
    //   161: ifnull +27 -> 188
    //   164: ldc_w 293
    //   167: aload_1
    //   168: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +17 -> 188
    //   174: aload_0
    //   175: getfield 31	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   178: invokevirtual 162	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   181: aload_1
    //   182: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifeq +82 -> 267
    //   188: new 299	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   191: dup
    //   192: aload_0
    //   193: getfield 31	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   196: invokevirtual 162	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   199: iconst_0
    //   200: invokespecial 302	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   203: astore_1
    //   204: aload_0
    //   205: getfield 29	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   208: aload_1
    //   209: invokestatic 307	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   212: aload_0
    //   213: getfield 31	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: ldc_w 309
    //   219: ldc_w 293
    //   222: ldc_w 293
    //   225: ldc_w 311
    //   228: ldc_w 311
    //   231: iconst_0
    //   232: iconst_0
    //   233: ldc_w 293
    //   236: ldc_w 293
    //   239: ldc_w 293
    //   242: ldc_w 293
    //   245: invokestatic 316	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   248: return
    //   249: astore_1
    //   250: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -244 -> 9
    //   256: ldc 70
    //   258: iconst_2
    //   259: ldc_w 293
    //   262: aload_1
    //   263: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: return
    //   267: aload_0
    //   268: getfield 31	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: bipush 50
    //   273: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   276: checkcast 321	com/tencent/mobileqq/app/FriendsManager
    //   279: aload_1
    //   280: invokevirtual 324	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   283: astore_3
    //   284: aload_3
    //   285: ifnull +39 -> 324
    //   288: aload_3
    //   289: invokevirtual 329	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   292: ifeq +32 -> 324
    //   295: new 299	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   298: dup
    //   299: aload_1
    //   300: iconst_1
    //   301: invokespecial 302	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   304: astore_1
    //   305: aload_1
    //   306: aload_3
    //   307: getfield 333	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   310: putfield 336	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:h	Ljava/lang/String;
    //   313: aload_1
    //   314: aload_3
    //   315: getfield 339	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   318: putfield 342	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:i	Ljava/lang/String;
    //   321: goto -117 -> 204
    //   324: new 299	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   327: dup
    //   328: aload_1
    //   329: iconst_3
    //   330: invokespecial 302	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   333: astore_1
    //   334: goto -130 -> 204
    //   337: ldc_w 344
    //   340: invokestatic 283	com/tencent/mobileqq/app/QQAppInterface:f	(Ljava/lang/String;)V
    //   343: return
    //   344: astore_3
    //   345: goto -185 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	VoiceScan
    //   0	348	1	paramArrayOfByte	byte[]
    //   1	106	2	i	int
    //   16	299	3	localObject	Object
    //   344	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   143	154	249	java/lang/Exception
    //   164	188	249	java/lang/Exception
    //   188	204	249	java/lang/Exception
    //   204	248	249	java/lang/Exception
    //   267	284	249	java/lang/Exception
    //   288	321	249	java/lang/Exception
    //   324	334	249	java/lang/Exception
    //   154	160	344	java/lang/Exception
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onScannerPause");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(291));
    if (this.c)
    {
      Process.setThreadPriority(0);
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onDestroy");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.b(this);
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = null;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      label109:
      e();
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        this.c = a();
        this.d = true;
      } while (!this.c);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(291);
      return true;
      d();
      return true;
      QQAppInterface.f("不用对准二维码，最新版QQ扫描声波也可加好友");
      return true;
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    Process.setThreadPriority(-19);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    return true;
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan
 * JD-Core Version:    0.7.0.1
 */