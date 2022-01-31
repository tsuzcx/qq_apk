package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager.WakeLock;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import kgs;
import kgt;
import kgu;
import mqq.util.WeakReference;

public class SensorHelper
{
  static int jdField_b_of_type_Int = -1;
  public int a;
  Sensor jdField_a_of_type_AndroidHardwareSensor = null;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager = null;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  public VideoController a;
  public SensorReport a;
  public TraeHelper a;
  public String a;
  kgs jdField_a_of_type_Kgs = null;
  kgt jdField_a_of_type_Kgt = null;
  kgu jdField_a_of_type_Kgu = null;
  public WeakReference a;
  public boolean a;
  public Sensor b;
  boolean jdField_b_of_type_Boolean = false;
  public boolean c = false;
  public boolean d = false;
  private boolean e = true;
  private boolean f;
  private boolean g = true;
  private boolean h = true;
  private boolean i;
  private boolean j = true;
  
  private SensorHelper(Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    this.jdField_a_of_type_JavaLangString = "SensorHelper";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidHardwareSensor = null;
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport = new SensorReport();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = paramTraeHelper;
    b();
  }
  
  public static SensorHelper a(SensorHelper paramSensorHelper, Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    if (paramSensorHelper != null) {
      paramSensorHelper.a(false);
    }
    return new SensorHelper(paramActivity, paramVideoController, paramTraeHelper);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startSensor " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Kgs == null) || (this.jdField_a_of_type_Kgt == null) || (this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "startSensor error, start[" + paramBoolean);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorReport.a();
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Kgs, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Kgt, this.jdField_b_of_type_AndroidHardwareSensor, 3);
    if (this.jdField_a_of_type_Kgu == null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_Kgu = new kgu(this);
      ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).registerReceiver(this.jdField_a_of_type_Kgu, localIntentFilter);
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "startSensor error, mSreenActionReceive had exist");
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Kgs);
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Kgt);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "toggleProximityWakeLock[false], when[StopSensor]");
      a(false, true);
      b(false);
      c(false);
      if (this.jdField_a_of_type_Kgu != null)
      {
        ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_Kgu);
        this.jdField_a_of_type_Kgu = null;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport.b();
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 196	com/tencent/av/utils/SensorHelper:a	()Z
    //   6: istore_3
    //   7: aload_0
    //   8: getfield 75	com/tencent/av/utils/SensorHelper:d	Z
    //   11: iload_1
    //   12: if_icmpeq +17 -> 29
    //   15: aload_0
    //   16: getfield 102	com/tencent/av/utils/SensorHelper:f	Z
    //   19: ifne +324 -> 343
    //   22: iload_1
    //   23: ifne +6 -> 29
    //   26: goto +317 -> 343
    //   29: aload_0
    //   30: getfield 40	com/tencent/av/utils/SensorHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: iconst_1
    //   34: ldc 198
    //   36: iconst_4
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: iload_1
    //   43: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield 75	com/tencent/av/utils/SensorHelper:d	Z
    //   53: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload_0
    //   60: getfield 102	com/tencent/av/utils/SensorHelper:f	Z
    //   63: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: iload_3
    //   70: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 210	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   87: ifnonnull +51 -> 138
    //   90: aload_0
    //   91: getfield 67	com/tencent/av/utils/SensorHelper:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   94: invokevirtual 134	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   97: checkcast 168	android/content/Context
    //   100: ldc 212
    //   102: invokevirtual 216	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   105: checkcast 218	android/os/PowerManager
    //   108: astore 4
    //   110: aload_0
    //   111: aload 4
    //   113: bipush 32
    //   115: ldc 220
    //   117: invokevirtual 224	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   120: putfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   123: aload_0
    //   124: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   127: ifnull +11 -> 138
    //   130: aload_0
    //   131: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   134: iconst_0
    //   135: invokevirtual 229	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   138: aload_0
    //   139: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   142: ifnonnull +46 -> 188
    //   145: aload_0
    //   146: getfield 40	com/tencent/av/utils/SensorHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: iconst_1
    //   150: ldc 231
    //   152: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: goto -75 -> 80
    //   158: astore 4
    //   160: aload_0
    //   161: monitorexit
    //   162: aload 4
    //   164: athrow
    //   165: astore 4
    //   167: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -32 -> 138
    //   173: aload_0
    //   174: getfield 40	com/tencent/av/utils/SensorHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   177: iconst_2
    //   178: ldc 233
    //   180: aload 4
    //   182: invokestatic 236	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: goto -47 -> 138
    //   188: aload_0
    //   189: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   192: ifnull -112 -> 80
    //   195: aload_0
    //   196: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   199: invokevirtual 239	android/os/PowerManager$WakeLock:isHeld	()Z
    //   202: istore_3
    //   203: aload_0
    //   204: getfield 40	com/tencent/av/utils/SensorHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: iconst_1
    //   208: ldc 241
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: iload_1
    //   217: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: iload_3
    //   224: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   227: aastore
    //   228: invokestatic 210	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload_1
    //   235: ifeq +57 -> 292
    //   238: iload_3
    //   239: ifne +53 -> 292
    //   242: aload_0
    //   243: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   246: invokevirtual 244	android/os/PowerManager$WakeLock:acquire	()V
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 75	com/tencent/av/utils/SensorHelper:d	Z
    //   254: aload_0
    //   255: getfield 61	com/tencent/av/utils/SensorHelper:jdField_a_of_type_ComTencentAvUtilsSensorReport	Lcom/tencent/av/utils/SensorReport;
    //   258: invokevirtual 246	com/tencent/av/utils/SensorReport:c	()V
    //   261: aload_0
    //   262: iload_1
    //   263: putfield 75	com/tencent/av/utils/SensorHelper:d	Z
    //   266: goto -186 -> 80
    //   269: astore 4
    //   271: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -194 -> 80
    //   277: aload_0
    //   278: getfield 40	com/tencent/av/utils/SensorHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   281: iconst_2
    //   282: ldc 248
    //   284: aload 4
    //   286: invokestatic 236	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -209 -> 80
    //   292: iload_1
    //   293: ifne -32 -> 261
    //   296: iload_3
    //   297: ifeq -36 -> 261
    //   300: aload_0
    //   301: getfield 73	com/tencent/av/utils/SensorHelper:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   304: invokevirtual 251	android/os/PowerManager$WakeLock:release	()V
    //   307: aload_0
    //   308: iconst_0
    //   309: putfield 75	com/tencent/av/utils/SensorHelper:d	Z
    //   312: aload_0
    //   313: getfield 61	com/tencent/av/utils/SensorHelper:jdField_a_of_type_ComTencentAvUtilsSensorReport	Lcom/tencent/av/utils/SensorReport;
    //   316: aload_0
    //   317: getfield 81	com/tencent/av/utils/SensorHelper:j	Z
    //   320: aload_0
    //   321: getfield 102	com/tencent/av/utils/SensorHelper:f	Z
    //   324: aload_0
    //   325: getfield 79	com/tencent/av/utils/SensorHelper:h	Z
    //   328: aload_0
    //   329: getfield 63	com/tencent/av/utils/SensorHelper:jdField_a_of_type_Int	I
    //   332: iload_2
    //   333: aload_0
    //   334: getfield 65	com/tencent/av/utils/SensorHelper:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   337: invokevirtual 254	com/tencent/av/utils/SensorReport:a	(ZZZIZLcom/tencent/av/VideoController;)V
    //   340: goto -79 -> 261
    //   343: iload_3
    //   344: ifeq -261 -> 83
    //   347: goto -318 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	SensorHelper
    //   0	350	1	paramBoolean1	boolean
    //   0	350	2	paramBoolean2	boolean
    //   6	338	3	bool	boolean
    //   108	4	4	localPowerManager	android.os.PowerManager
    //   158	5	4	localObject	Object
    //   165	16	4	localException1	java.lang.Exception
    //   269	16	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	22	158	finally
    //   29	80	158	finally
    //   83	110	158	finally
    //   110	138	158	finally
    //   138	155	158	finally
    //   167	185	158	finally
    //   188	234	158	finally
    //   242	261	158	finally
    //   261	266	158	finally
    //   271	289	158	finally
    //   300	340	158	finally
    //   110	138	165	java/lang/Exception
    //   188	234	269	java/lang/Exception
    //   242	261	269	java/lang/Exception
    //   261	266	269	java/lang/Exception
    //   300	340	269	java/lang/Exception
  }
  
  boolean a()
  {
    if (jdField_b_of_type_Int == -1)
    {
      String str = Build.MODEL;
      if (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
        break label73;
      }
      if ((!str.equalsIgnoreCase("GT-I9200")) && (!str.equalsIgnoreCase("GT-I8262D")) && (!str.equalsIgnoreCase("SM-N9008"))) {
        break label66;
      }
      jdField_b_of_type_Int = 1;
    }
    while (jdField_b_of_type_Int == 1)
    {
      return true;
      label66:
      jdField_b_of_type_Int = 0;
      continue;
      label73:
      jdField_b_of_type_Int = 0;
    }
    return false;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((localContext != null) && (this.jdField_a_of_type_AndroidHardwareSensorManager == null)) {
        this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localContext.getSystemService("sensor"));
      }
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
        this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      }
      if (this.jdField_b_of_type_AndroidHardwareSensor == null) {
        this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
      }
    }
    if (this.jdField_a_of_type_Kgs == null) {
      this.jdField_a_of_type_Kgs = new kgs(this);
    }
    if (this.jdField_a_of_type_Kgt == null) {
      this.jdField_a_of_type_Kgt = new kgt(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper
 * JD-Core Version:    0.7.0.1
 */