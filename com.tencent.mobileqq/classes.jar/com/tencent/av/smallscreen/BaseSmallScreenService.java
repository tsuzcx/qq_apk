package com.tencent.av.smallscreen;

import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lyh;
import lyn;
import lyo;
import lyt;
import lyu;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements lyo
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new lyh(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = true;
  final lyn[] jdField_a_of_type_ArrayOfLyn = new lyn[3];
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
    if (this.jdField_a_of_type_ArrayOfLyn[paramInt] != null) {
      return this.jdField_a_of_type_ArrayOfLyn[paramInt].jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
    }
    return null;
  }
  
  lyn a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfLyn[paramInt];
  }
  
  public lyt a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfLyn[paramInt] != null) {
      return this.jdField_a_of_type_ArrayOfLyn[paramInt].jdField_a_of_type_Lyt;
    }
    return null;
  }
  
  protected lyt a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < 3)
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
    return lyu.f(((AppInterface)this.app).getApp());
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
    //   198: new 221	lyk
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 224	lyk:<init>	(Landroid/content/Context;)V
    //   206: astore 4
    //   208: aload 4
    //   210: aload_0
    //   211: aload_3
    //   212: aload_0
    //   213: invokevirtual 227	lyk:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llyo;)V
    //   216: aload_0
    //   217: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLyn	[Llyn;
    //   220: iconst_0
    //   221: aload 4
    //   223: aastore
    //   224: new 229	lyw
    //   227: dup
    //   228: aload_0
    //   229: invokespecial 230	lyw:<init>	(Landroid/content/Context;)V
    //   232: astore 4
    //   234: aload 4
    //   236: aload_0
    //   237: aload_3
    //   238: aload_0
    //   239: invokevirtual 231	lyw:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llyo;)V
    //   242: aload_0
    //   243: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLyn	[Llyn;
    //   246: iconst_1
    //   247: aload 4
    //   249: aastore
    //   250: new 233	lys
    //   253: dup
    //   254: aload_0
    //   255: invokespecial 234	lys:<init>	(Landroid/content/Context;)V
    //   258: astore 4
    //   260: aload 4
    //   262: aload_0
    //   263: aload_3
    //   264: aload_0
    //   265: invokevirtual 235	lys:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Llyo;)V
    //   268: aload_0
    //   269: getfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfLyn	[Llyn;
    //   272: iconst_2
    //   273: aload 4
    //   275: aastore
    //   276: new 237	android/content/IntentFilter
    //   279: dup
    //   280: invokespecial 238	android/content/IntentFilter:<init>	()V
    //   283: astore_3
    //   284: aload_3
    //   285: ldc 240
    //   287: invokevirtual 244	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   290: aload_3
    //   291: ldc 246
    //   293: invokevirtual 244	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: invokestatic 249	lyu:i	()Z
    //   300: putfield 27	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Boolean	Z
    //   303: getstatic 254	android/os/Build$VERSION:SDK_INT	I
    //   306: bipush 21
    //   308: if_icmplt +160 -> 468
    //   311: invokestatic 259	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   314: invokevirtual 262	com/tencent/av/VideoController:a	()Lmiu;
    //   317: invokevirtual 266	miu:c	()Z
    //   320: ifeq +148 -> 468
    //   323: iconst_1
    //   324: istore_1
    //   325: aload_0
    //   326: getfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   329: checkcast 164	com/tencent/common/app/AppInterface
    //   332: invokevirtual 168	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   335: invokestatic 268	lyu:c	(Landroid/content/Context;)Z
    //   338: ifeq +135 -> 473
    //   341: iload_1
    //   342: ifne +131 -> 473
    //   345: aload_0
    //   346: iload_2
    //   347: putfield 33	com/tencent/av/smallscreen/BaseSmallScreenService:e	Z
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   355: checkcast 164	com/tencent/common/app/AppInterface
    //   358: invokevirtual 168	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   361: invokestatic 270	lyu:b	(Landroid/content/Context;)Z
    //   364: putfield 29	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Boolean	Z
    //   367: aload_0
    //   368: aload_0
    //   369: getfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   372: checkcast 164	com/tencent/common/app/AppInterface
    //   375: invokevirtual 168	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   378: invokestatic 173	lyu:f	(Landroid/content/Context;)Z
    //   381: putfield 35	com/tencent/av/smallscreen/BaseSmallScreenService:f	Z
    //   384: aload_0
    //   385: getfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   388: ifnonnull +15 -> 403
    //   391: aload_0
    //   392: new 272	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable
    //   395: dup
    //   396: aload_0
    //   397: invokespecial 273	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   400: putfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   403: aload_0
    //   404: invokevirtual 275	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   407: aload_0
    //   408: getfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   411: ldc2_w 276
    //   414: invokevirtual 281	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   417: pop
    //   418: aload_0
    //   419: getfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   422: ifnonnull +15 -> 437
    //   425: aload_0
    //   426: new 283	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable
    //   429: dup
    //   430: aload_0
    //   431: invokespecial 284	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   434: putfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   437: aload_0
    //   438: invokevirtual 275	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   441: aload_0
    //   442: getfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   445: ldc2_w 285
    //   448: invokevirtual 281	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   451: pop
    //   452: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq -401 -> 54
    //   458: ldc 118
    //   460: iconst_2
    //   461: ldc_w 288
    //   464: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: return
    //   468: iconst_0
    //   469: istore_1
    //   470: goto -145 -> 325
    //   473: iconst_0
    //   474: istore_2
    //   475: goto -130 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	BaseSmallScreenService
    //   324	146	1	i	int
    //   4	471	2	bool	boolean
    //   37	2	3	localLayoutInflater	android.view.LayoutInflater
    //   55	17	3	localException1	java.lang.Exception
    //   90	201	3	localObject1	Object
    //   1	273	4	localObject2	Object
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
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfLyn[i].a();
      this.jdField_a_of_type_ArrayOfLyn[i] = null;
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