package com.tencent.av.smallscreen;

import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lzc;
import lzk;
import lzl;
import lzq;
import lzr;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements lzl
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new lzc(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = true;
  final lzk[] jdField_a_of_type_ArrayOfLzk = new lzk[4];
  int jdField_b_of_type_Int = 7;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = true;
  public boolean f = false;
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.a().x;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public SmallScreenRelativeLayout a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfLzk[paramInt] != null) {
      return this.jdField_a_of_type_ArrayOfLzk[paramInt].jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
    }
    return null;
  }
  
  lzk a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfLzk[paramInt];
  }
  
  public lzq a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfLzk[paramInt] != null) {
      return this.jdField_a_of_type_ArrayOfLzk[paramInt].jdField_a_of_type_Lzq;
    }
    return null;
  }
  
  protected lzq a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < 4)
      {
        if (a(i) == paramSmallScreenRelativeLayout) {
          localObject1 = a(i);
        }
      }
      else {
        return localObject1;
      }
      i += 1;
    }
  }
  
  void a()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("BaseSmallScreenService", 1, "onIsLockChanged, mIsLock[" + this.jdField_c_of_type_Boolean + "], seq[" + l + "]");
    }
    a(l);
  }
  
  public void a(int paramInt, String paramString) {}
  
  void a(long paramLong) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.a();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.c();
    }
  }
  
  protected boolean a()
  {
    return lzr.f(((AppInterface)this.app).getApp());
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.a().y;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onHasSmartBarChanged mHasSmartBar = " + this.jdField_b_of_type_Boolean);
    }
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = a(1);
    if (localSmallScreenRelativeLayout != null) {
      localSmallScreenRelativeLayout.a();
    }
  }
  
  void c() {}
  
  void d() {}
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_1
    //   4: istore_2
    //   5: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 118
    //   13: iconst_2
    //   14: ldc 189
    //   16: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokespecial 191	mqq/app/AppService:onCreate	()V
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 31	com/tencent/av/smallscreen/BaseSmallScreenService:d	Z
    //   28: aload_0
    //   29: ldc 193
    //   31: invokevirtual 197	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   34: checkcast 199	android/view/LayoutInflater
    //   37: astore_3
    //   38: aload_3
    //   39: ifnonnull +133 -> 172
    //   42: ldc 118
    //   44: iconst_1
    //   45: ldc 201
    //   47: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 206	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   54: return
    //   55: astore_3
    //   56: ldc 118
    //   58: iconst_1
    //   59: new 120	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   66: ldc 208
    //   68: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_3
    //   72: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: invokevirtual 206	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   85: return
    //   86: astore 5
    //   88: aload 4
    //   90: astore_3
    //   91: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -56 -> 38
    //   97: ldc 118
    //   99: iconst_2
    //   100: new 120	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   107: ldc 208
    //   109: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 5
    //   114: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 4
    //   125: astore_3
    //   126: goto -88 -> 38
    //   129: astore 5
    //   131: aload 4
    //   133: astore_3
    //   134: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -99 -> 38
    //   140: ldc 118
    //   142: iconst_2
    //   143: new 120	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   150: ldc 208
    //   152: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 5
    //   157: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload 4
    //   168: astore_3
    //   169: goto -131 -> 38
    //   172: aload_0
    //   173: aload_0
    //   174: ldc 213
    //   176: invokevirtual 197	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   179: checkcast 215	android/telephony/TelephonyManager
    //   182: putfield 51	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   185: aload_0
    //   186: getfield 51	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   189: aload_0
    //   190: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   193: bipush 32
    //   195: invokevirtual 219	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   198: new 221	lzi
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 224	lzi:<init>	(Landroid/content/Context;)V
    //   206: astore 4
    //   208: aload 4
    //   210: aload_0
    //   211: aload_3
    //   212: aload_0
    //   213: invokevirtual 227	lzi:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llzl;)V
    //   216: aload_0
    //   217: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLzk	[Llzk;
    //   220: iconst_0
    //   221: aload 4
    //   223: aastore
    //   224: new 229	lzt
    //   227: dup
    //   228: aload_0
    //   229: invokespecial 230	lzt:<init>	(Landroid/content/Context;)V
    //   232: astore 4
    //   234: aload 4
    //   236: aload_0
    //   237: aload_3
    //   238: aload_0
    //   239: invokevirtual 231	lzt:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llzl;)V
    //   242: aload_0
    //   243: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLzk	[Llzk;
    //   246: iconst_1
    //   247: aload 4
    //   249: aastore
    //   250: new 233	lzp
    //   253: dup
    //   254: aload_0
    //   255: invokespecial 234	lzp:<init>	(Landroid/content/Context;)V
    //   258: astore 4
    //   260: aload 4
    //   262: aload_0
    //   263: aload_3
    //   264: aload_0
    //   265: invokevirtual 235	lzp:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llzl;)V
    //   268: aload_0
    //   269: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLzk	[Llzk;
    //   272: iconst_2
    //   273: aload 4
    //   275: aastore
    //   276: new 237	mac
    //   279: dup
    //   280: aload_0
    //   281: invokespecial 238	mac:<init>	(Landroid/content/Context;)V
    //   284: astore 4
    //   286: aload 4
    //   288: aload_0
    //   289: aload_3
    //   290: aload_0
    //   291: invokevirtual 239	mac:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llzl;)V
    //   294: aload_0
    //   295: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLzk	[Llzk;
    //   298: iconst_3
    //   299: aload 4
    //   301: aastore
    //   302: new 241	android/content/IntentFilter
    //   305: dup
    //   306: invokespecial 242	android/content/IntentFilter:<init>	()V
    //   309: astore_3
    //   310: aload_3
    //   311: ldc 244
    //   313: invokevirtual 248	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   316: aload_3
    //   317: ldc 250
    //   319: invokevirtual 248	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: invokestatic 253	lzr:i	()Z
    //   326: putfield 27	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Boolean	Z
    //   329: getstatic 258	android/os/Build$VERSION:SDK_INT	I
    //   332: bipush 21
    //   334: if_icmplt +160 -> 494
    //   337: invokestatic 263	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   340: invokevirtual 266	com/tencent/av/VideoController:a	()Lmjw;
    //   343: invokevirtual 270	mjw:c	()Z
    //   346: ifeq +148 -> 494
    //   349: iconst_1
    //   350: istore_1
    //   351: aload_0
    //   352: getfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   355: checkcast 164	com/tencent/common/app/AppInterface
    //   358: invokevirtual 168	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   361: invokestatic 272	lzr:c	(Landroid/content/Context;)Z
    //   364: ifeq +135 -> 499
    //   367: iload_1
    //   368: ifne +131 -> 499
    //   371: aload_0
    //   372: iload_2
    //   373: putfield 33	com/tencent/av/smallscreen/BaseSmallScreenService:e	Z
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   381: checkcast 164	com/tencent/common/app/AppInterface
    //   384: invokevirtual 168	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   387: invokestatic 274	lzr:b	(Landroid/content/Context;)Z
    //   390: putfield 29	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Boolean	Z
    //   393: aload_0
    //   394: aload_0
    //   395: getfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   398: checkcast 164	com/tencent/common/app/AppInterface
    //   401: invokevirtual 168	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   404: invokestatic 173	lzr:f	(Landroid/content/Context;)Z
    //   407: putfield 35	com/tencent/av/smallscreen/BaseSmallScreenService:f	Z
    //   410: aload_0
    //   411: getfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   414: ifnonnull +15 -> 429
    //   417: aload_0
    //   418: new 276	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable
    //   421: dup
    //   422: aload_0
    //   423: invokespecial 277	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   426: putfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   429: aload_0
    //   430: invokevirtual 279	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   433: aload_0
    //   434: getfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   437: ldc2_w 280
    //   440: invokevirtual 285	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   443: pop
    //   444: aload_0
    //   445: getfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   448: ifnonnull +15 -> 463
    //   451: aload_0
    //   452: new 287	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable
    //   455: dup
    //   456: aload_0
    //   457: invokespecial 288	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   460: putfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   463: aload_0
    //   464: invokevirtual 279	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   467: aload_0
    //   468: getfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   471: ldc2_w 289
    //   474: invokevirtual 285	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   477: pop
    //   478: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq -427 -> 54
    //   484: ldc 118
    //   486: iconst_2
    //   487: ldc_w 292
    //   490: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: return
    //   494: iconst_0
    //   495: istore_1
    //   496: goto -145 -> 351
    //   499: iconst_0
    //   500: istore_2
    //   501: goto -130 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	BaseSmallScreenService
    //   350	146	1	i	int
    //   4	497	2	bool	boolean
    //   37	2	3	localLayoutInflater	android.view.LayoutInflater
    //   55	17	3	localException1	java.lang.Exception
    //   90	227	3	localObject1	Object
    //   1	299	4	localObject2	Object
    //   86	27	5	localException2	java.lang.Exception
    //   129	27	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   19	23	55	java/lang/Exception
    //   28	38	86	java/lang/Exception
    //   28	38	129	java/lang/OutOfMemoryError
  }
  
  public void onDestroy()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    this.d = true;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    while (i < 4)
    {
      this.jdField_a_of_type_ArrayOfLzk[i].a();
      this.jdField_a_of_type_ArrayOfLzk[i] = null;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy end");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onLowMemory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */