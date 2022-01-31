package com.tencent.mobileqq.activity.aio;

import actu;
import actv;
import actw;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import bbkk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AudioSenorManager
  extends BroadcastReceiver
{
  public static int a;
  public float a;
  private actu jdField_a_of_type_Actu;
  private actv jdField_a_of_type_Actv;
  private actw jdField_a_of_type_Actw;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new AudioSenorManager.1(this);
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public boolean a;
  public float b;
  private volatile int jdField_b_of_type_Int = 0;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  Runnable jdField_b_of_type_JavaLangRunnable = new AudioSenorManager.2(this);
  private boolean jdField_b_of_type_Boolean;
  public float c;
  private float d;
  private float e = 0.6F;
  private float f = 0.02F;
  
  static
  {
    jdField_a_of_type_Int = 1000;
  }
  
  public AudioSenorManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramQQAppInterface.getApp().getSystemService("sensor"));
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    float f1;
    if ((str.equals("ZTE U880s")) || (str.equals("ZTE U807"))) {
      f1 = 97.0F;
    }
    do
    {
      return f1;
      if ((str.equals("Coolpad 5890")) || (str.equals("Coolpad 5891")) || (str.equals("Coolpad 8720L")) || (str.equals("Coolpad 5879")) || (str.equals("Coolpad 5891Q"))) {
        return 5.0F;
      }
      if ((str.equals("HUAWEI Y320-T00")) || (str.equals("Lenovo A658t")) || (str.equals("Lenovo A788t"))) {
        return 10.0F;
      }
      if (str.equals("ME860")) {
        return 99.0F;
      }
      if ((str.equals("ZTE U930HD")) || (str.equals("ZTE-T U960s"))) {
        return 100.0F;
      }
      f1 = 0.0F;
    } while (paramSensor == null);
    return paramSensor.getMaximumRange();
  }
  
  private void a(String paramString)
  {
    if (!bbkk.a(paramString))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramString);
      e();
      ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 16, null, false);
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  private void b(String paramString)
  {
    if (!bbkk.a(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.indexOf(paramString));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
        ThreadManager.excute(this.jdField_b_of_type_JavaLangRunnable, 16, null, false);
        if (this.jdField_b_of_type_Int != 0)
        {
          this.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_Actv != null) {
            this.jdField_a_of_type_Actv.a(this.jdField_b_of_type_Int);
          }
        }
      }
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 198	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 204	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:qq_audio_play	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   9: invokevirtual 208	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   12: aconst_null
    //   13: invokevirtual 211	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 7
    //   18: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +29 -> 50
    //   24: ldc 218
    //   26: iconst_2
    //   27: new 220	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   34: ldc 223
    //   36: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 7
    //   41: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload 7
    //   52: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +441 -> 496
    //   58: aload 7
    //   60: invokevirtual 242	java/lang/String:length	()I
    //   63: iconst_1
    //   64: if_icmple +432 -> 496
    //   67: aload 7
    //   69: ldc 244
    //   71: invokevirtual 248	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   74: astore 7
    //   76: ldc 250
    //   78: aload 7
    //   80: iconst_0
    //   81: aaload
    //   82: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: istore 6
    //   87: iload 6
    //   89: ifne +280 -> 369
    //   92: iconst_1
    //   93: istore 4
    //   95: aload 7
    //   97: iconst_1
    //   98: aaload
    //   99: invokestatic 256	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   102: fstore_2
    //   103: fload_2
    //   104: fstore_1
    //   105: iload 4
    //   107: istore_3
    //   108: aload 7
    //   110: arraylength
    //   111: iconst_5
    //   112: if_icmplt +40 -> 152
    //   115: aload_0
    //   116: aload 7
    //   118: iconst_2
    //   119: aaload
    //   120: invokestatic 256	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   123: putfield 35	com/tencent/mobileqq/activity/aio/AudioSenorManager:e	F
    //   126: aload_0
    //   127: aload 7
    //   129: iconst_3
    //   130: aaload
    //   131: invokestatic 256	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   134: putfield 38	com/tencent/mobileqq/activity/aio/AudioSenorManager:f	F
    //   137: aload 7
    //   139: iconst_4
    //   140: aaload
    //   141: invokestatic 262	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   144: putstatic 25	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_Int	I
    //   147: iload 4
    //   149: istore_3
    //   150: fload_2
    //   151: fstore_1
    //   152: getstatic 25	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_Int	I
    //   155: ifge +9 -> 164
    //   158: sipush 1000
    //   161: putstatic 25	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_Int	I
    //   164: aload_0
    //   165: getfield 35	com/tencent/mobileqq/activity/aio/AudioSenorManager:e	F
    //   168: fconst_0
    //   169: fcmpg
    //   170: ifgt +5 -> 175
    //   173: iconst_0
    //   174: istore_3
    //   175: invokestatic 198	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   178: getstatic 268	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:qq_audio_play_fix	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   181: invokevirtual 269	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   184: aconst_null
    //   185: invokevirtual 211	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 7
    //   190: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +30 -> 223
    //   196: ldc 218
    //   198: iconst_2
    //   199: new 220	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 271
    //   209: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 7
    //   214: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload 7
    //   225: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +262 -> 490
    //   231: aload 7
    //   233: invokevirtual 242	java/lang/String:length	()I
    //   236: iconst_1
    //   237: if_icmple +253 -> 490
    //   240: aload 7
    //   242: ldc 244
    //   244: invokevirtual 248	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   247: astore 7
    //   249: ldc_w 273
    //   252: aload 7
    //   254: iconst_4
    //   255: aaload
    //   256: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifne +228 -> 487
    //   262: aload 7
    //   264: iconst_4
    //   265: aaload
    //   266: invokestatic 256	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   269: fstore_2
    //   270: fload_2
    //   271: fstore_1
    //   272: ldc 250
    //   274: aload 7
    //   276: iconst_5
    //   277: aaload
    //   278: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: istore 6
    //   283: iload 5
    //   285: istore_3
    //   286: iload 6
    //   288: ifne +5 -> 293
    //   291: iconst_1
    //   292: istore_3
    //   293: iload_3
    //   294: istore 4
    //   296: iload 4
    //   298: ifeq +27 -> 325
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 75	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   306: iconst_1
    //   307: invokevirtual 277	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   310: putfield 169	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_b_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   313: aload_0
    //   314: new 279	actu
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 280	actu:<init>	(Lcom/tencent/mobileqq/activity/aio/AudioSenorManager;)V
    //   322: putfield 131	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_Actu	Lactu;
    //   325: aload_0
    //   326: aload_0
    //   327: getfield 75	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   330: bipush 8
    //   332: invokevirtual 277	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   335: putfield 140	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   338: aload_0
    //   339: new 282	actw
    //   342: dup
    //   343: aload_0
    //   344: invokespecial 283	actw:<init>	(Lcom/tencent/mobileqq/activity/aio/AudioSenorManager;)V
    //   347: putfield 137	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_Actw	Lactw;
    //   350: fload_1
    //   351: ldc_w 284
    //   354: fcmpl
    //   355: ifle +91 -> 446
    //   358: aload_0
    //   359: fload_1
    //   360: putfield 191	com/tencent/mobileqq/activity/aio/AudioSenorManager:d	F
    //   363: aload_0
    //   364: iconst_1
    //   365: putfield 286	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_b_of_type_Boolean	Z
    //   368: return
    //   369: iconst_0
    //   370: istore 4
    //   372: goto -277 -> 95
    //   375: astore 7
    //   377: iconst_1
    //   378: istore 4
    //   380: fconst_0
    //   381: fstore_2
    //   382: fload_2
    //   383: fstore_1
    //   384: iload 4
    //   386: istore_3
    //   387: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq -238 -> 152
    //   393: ldc 218
    //   395: iconst_2
    //   396: ldc_w 288
    //   399: aload 7
    //   401: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   404: fload_2
    //   405: fstore_1
    //   406: iload 4
    //   408: istore_3
    //   409: goto -257 -> 152
    //   412: astore 7
    //   414: fload_1
    //   415: fstore_2
    //   416: fload_2
    //   417: fstore_1
    //   418: iload_3
    //   419: istore 4
    //   421: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -128 -> 296
    //   427: ldc 218
    //   429: iconst_2
    //   430: ldc_w 293
    //   433: aload 7
    //   435: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   438: fload_2
    //   439: fstore_1
    //   440: iload_3
    //   441: istore 4
    //   443: goto -147 -> 296
    //   446: aload_0
    //   447: getfield 140	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   450: ifnull -87 -> 363
    //   453: aload_0
    //   454: aload_0
    //   455: aload_0
    //   456: getfield 140	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   459: invokespecial 295	com/tencent/mobileqq/activity/aio/AudioSenorManager:a	(Landroid/hardware/Sensor;)F
    //   462: putfield 191	com/tencent/mobileqq/activity/aio/AudioSenorManager:d	F
    //   465: goto -102 -> 363
    //   468: astore 7
    //   470: fload_1
    //   471: fstore_2
    //   472: goto -56 -> 416
    //   475: astore 7
    //   477: fconst_0
    //   478: fstore_2
    //   479: goto -97 -> 382
    //   482: astore 7
    //   484: goto -102 -> 382
    //   487: goto -215 -> 272
    //   490: iload_3
    //   491: istore 4
    //   493: goto -197 -> 296
    //   496: fconst_0
    //   497: fstore_1
    //   498: iconst_1
    //   499: istore_3
    //   500: goto -348 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	AudioSenorManager
    //   104	394	1	f1	float
    //   102	377	2	f2	float
    //   107	393	3	i	int
    //   93	399	4	j	int
    //   1	283	5	k	int
    //   85	202	6	bool	boolean
    //   16	259	7	localObject	java.lang.Object
    //   375	25	7	localException1	java.lang.Exception
    //   412	22	7	localException2	java.lang.Exception
    //   468	1	7	localException3	java.lang.Exception
    //   475	1	7	localException4	java.lang.Exception
    //   482	1	7	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   67	87	375	java/lang/Exception
    //   240	270	412	java/lang/Exception
    //   272	283	468	java/lang/Exception
    //   95	103	475	java/lang/Exception
    //   108	147	482	java/lang/Exception
  }
  
  private void e()
  {
    this.jdField_a_of_type_Float = -999.0F;
    this.jdField_b_of_type_Float = -999.0F;
    this.c = -999.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Actv = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Actu);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Actw);
  }
  
  public void a(actv paramactv)
  {
    this.jdField_a_of_type_Actv = paramactv;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioSenorManager", 2, "doOnAudioPlayStart");
    }
    if (!this.jdField_b_of_type_Boolean) {
      d();
    }
    e();
    ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
    ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 16, null, false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioSenorManager", 2, "doOnAudioPlayEnd");
    }
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
    ThreadManager.excute(this.jdField_b_of_type_JavaLangRunnable, 16, null, false);
    if (this.jdField_b_of_type_Int != 0)
    {
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_Actv != null) {
        this.jdField_a_of_type_Actv.a(this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("audiosenormanager.playkey");
    if ((paramContext != null) && (paramContext.equals("mqq.audiosenormanager.audio.start")))
    {
      if (!this.jdField_b_of_type_Boolean) {
        d();
      }
      a(paramIntent);
    }
    while ((paramContext == null) || (!paramContext.equals("mqq.audiosenormanager.audio.end"))) {
      return;
    }
    b(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioSenorManager
 * JD-Core Version:    0.7.0.1
 */