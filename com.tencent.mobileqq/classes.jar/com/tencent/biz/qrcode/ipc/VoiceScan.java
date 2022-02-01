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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class VoiceScan
  implements Handler.Callback, PCMRecorder.OnQQRecorderListener, ChirpSoHandler.Callback
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716674);
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131716675);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChirpWrapper jdField_a_of_type_ComTencentChirpChirpWrapper;
  private PCMRecorder jdField_a_of_type_ComTencentChirpPCMRecorder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setTalkbackSwitch();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "checkVoiceScanEnable enableTalkBack = " + AppSetting.d);
    }
    return AppSetting.d;
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
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = ((ChirpSoHandler)((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.system.chirp"));
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
          BaseApplicationImpl.sUiHandler.post(new VoiceScan.1(this));
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
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
    //   3: getfield 217	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
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
    //   19: invokestatic 259	com/tencent/biz/qrcode/ipc/VoiceScan:a	([B[S)V
    //   22: aload_0
    //   23: getfield 217	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   26: aload_3
    //   27: bipush 15
    //   29: invokevirtual 262	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne -28 -> 9
    //   40: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 91
    //   48: iconst_2
    //   49: new 93	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 270
    //   59: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_1
    //   73: ldc_w 272
    //   76: invokevirtual 278	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifeq +270 -> 349
    //   82: iload_2
    //   83: aload_1
    //   84: invokevirtual 281	java/lang/String:length	()I
    //   87: if_icmpge +20 -> 107
    //   90: aload_1
    //   91: iload_2
    //   92: invokevirtual 285	java/lang/String:charAt	(I)C
    //   95: bipush 48
    //   97: if_icmpne +10 -> 107
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -22 -> 82
    //   107: aload_1
    //   108: iload_2
    //   109: invokevirtual 288	java/lang/String:substring	(I)Ljava/lang/String;
    //   112: astore_1
    //   113: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +29 -> 145
    //   119: ldc 91
    //   121: iconst_2
    //   122: new 93	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 290
    //   132: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_1
    //   146: invokestatic 296	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   149: pop2
    //   150: ldc_w 297
    //   153: invokestatic 31	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   156: invokestatic 301	com/tencent/mobileqq/app/QQAppInterface:speak	(Ljava/lang/String;)V
    //   159: ldc2_w 302
    //   162: invokestatic 309	java/lang/Thread:sleep	(J)V
    //   165: aload_1
    //   166: ifnull +27 -> 193
    //   169: ldc_w 311
    //   172: aload_1
    //   173: invokevirtual 315	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +17 -> 193
    //   179: aload_0
    //   180: getfield 53	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: invokevirtual 188	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   186: aload_1
    //   187: invokevirtual 315	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +82 -> 272
    //   193: new 317	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   196: dup
    //   197: aload_0
    //   198: getfield 53	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: invokevirtual 188	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   204: iconst_0
    //   205: invokespecial 320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   208: astore_1
    //   209: aload_0
    //   210: getfield 51	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   213: aload_1
    //   214: invokestatic 325	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   217: aload_0
    //   218: getfield 53	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   221: ldc_w 327
    //   224: ldc_w 311
    //   227: ldc_w 311
    //   230: ldc_w 329
    //   233: ldc_w 329
    //   236: iconst_0
    //   237: iconst_0
    //   238: ldc_w 311
    //   241: ldc_w 311
    //   244: ldc_w 311
    //   247: ldc_w 311
    //   250: invokestatic 334	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   253: return
    //   254: astore_1
    //   255: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -249 -> 9
    //   261: ldc 91
    //   263: iconst_2
    //   264: ldc_w 311
    //   267: aload_1
    //   268: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: return
    //   272: aload_0
    //   273: getfield 53	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: getstatic 340	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   279: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   282: checkcast 342	com/tencent/mobileqq/app/FriendsManager
    //   285: aload_1
    //   286: invokevirtual 345	com/tencent/mobileqq/app/FriendsManager:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   289: astore_3
    //   290: aload_3
    //   291: ifnull +39 -> 330
    //   294: aload_3
    //   295: invokevirtual 350	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   298: ifeq +32 -> 330
    //   301: new 317	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   304: dup
    //   305: aload_1
    //   306: iconst_1
    //   307: invokespecial 320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   310: astore_1
    //   311: aload_1
    //   312: aload_3
    //   313: getfield 353	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   316: putfield 356	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:h	Ljava/lang/String;
    //   319: aload_1
    //   320: aload_3
    //   321: getfield 359	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   324: putfield 362	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:i	Ljava/lang/String;
    //   327: goto -118 -> 209
    //   330: new 317	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   333: dup
    //   334: aload_1
    //   335: iconst_3
    //   336: invokespecial 320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   339: astore_1
    //   340: aload_1
    //   341: bipush 12
    //   343: putfield 365	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	I
    //   346: goto -137 -> 209
    //   349: getstatic 36	com/tencent/biz/qrcode/ipc/VoiceScan:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokestatic 301	com/tencent/mobileqq/app/QQAppInterface:speak	(Ljava/lang/String;)V
    //   355: return
    //   356: astore_3
    //   357: goto -192 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	VoiceScan
    //   0	360	1	paramArrayOfByte	byte[]
    //   1	108	2	i	int
    //   16	305	3	localObject	Object
    //   356	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   145	159	254	java/lang/Exception
    //   169	193	254	java/lang/Exception
    //   193	209	254	java/lang/Exception
    //   209	253	254	java/lang/Exception
    //   272	290	254	java/lang/Exception
    //   294	327	254	java/lang/Exception
    //   330	346	254	java/lang/Exception
    //   159	165	356	java/lang/Exception
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
      QQAppInterface.speak(jdField_a_of_type_JavaLangString);
      return true;
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    Process.setThreadPriority(-19);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    return true;
  }
  
  public void m()
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