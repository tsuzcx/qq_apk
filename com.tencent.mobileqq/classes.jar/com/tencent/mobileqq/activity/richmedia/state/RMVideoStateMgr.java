package com.tencent.mobileqq.activity.richmedia.state;

import ajli;
import ajlj;
import ajov;
import ajow;
import ajox;
import ajoy;
import ajoz;
import ajpa;
import ajpb;
import ajpc;
import ajpf;
import ajpg;
import ajpj;
import alpo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import axqz;
import axrl;
import axrn;
import azbo;
import azbs;
import azbt;
import azbv;
import azbw;
import azcg;
import azcu;
import azcw;
import azda;
import azdf;
import azdl;
import azdo;
import azds;
import azdt;
import azdx;
import azfm;
import azfz;
import azhf;
import azhh;
import azmz;
import bdcs;
import bjsb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import lnz;

public class RMVideoStateMgr
  implements azbt, azbw, azcu, azhh, AVCodec.AVCodecCallback
{
  private static RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 850, 780, 650, 480 };
  public static boolean c;
  public double a;
  public int a;
  public long a;
  public ajov a;
  public ajow a;
  final ajox jdField_a_of_type_Ajox = new ajox();
  final ajoy jdField_a_of_type_Ajoy = new ajoy();
  final ajoz jdField_a_of_type_Ajoz = new ajoz();
  final ajpa jdField_a_of_type_Ajpa = new ajpa();
  public ajpc a;
  public final ajpg a;
  public ajpj a;
  public Context a;
  public Handler a;
  private axqz jdField_a_of_type_Axqz;
  private axrn jdField_a_of_type_Axrn;
  public azcu a;
  public azdf a;
  public azfm a;
  public final RMVideoSwitchCameraPicMgr a;
  public AudioCapture a;
  public PreviewContext a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private WeakReference<axrl> jdField_a_of_type_JavaLangRefWeakReference;
  public AtomicBoolean a;
  public AtomicInteger a;
  public int b;
  public String b;
  public AtomicInteger b;
  public boolean b;
  private int[] b;
  public int c;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  private int f;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i = true;
  private boolean j;
  private boolean k;
  private volatile boolean l;
  private boolean m;
  private boolean n;
  private volatile boolean o;
  private boolean p = true;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  private RMVideoStateMgr()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Ajpg = new ajpg();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = 480;
    this.jdField_a_of_type_Ajpc = new ajpc();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Ajow = new ajow();
    this.jdField_b_of_type_ArrayOfInt = new int[8];
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i2 = azbo.h.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfInt[1] == azbo.h[i1])
      {
        paramArrayOfInt[0] = azbo.g[i1];
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static RMVideoStateMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = new RMVideoStateMgr();
      }
      RMVideoStateMgr localRMVideoStateMgr = jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      return localRMVideoStateMgr;
    }
    finally {}
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString2);
      if ((paramString1.exists()) && (paramString2.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "deleteDirectoryByTime rootDir:" + paramString1 + ", currentDirectory:" + paramString2);
        }
        paramString2 = paramString2.getName();
        paramString1 = paramString1.listFiles();
        if ((paramString1 != null) && (paramString1.length > 0) && (!TextUtils.isEmpty(paramString2)))
        {
          int i1 = 0;
          while (i1 < paramString1.length)
          {
            String str = paramString1[i1].getName();
            if ((!TextUtils.isEmpty(str)) && (str.compareTo(paramString2) < 0)) {
              bdcs.a(paramString1[i1].getAbsolutePath());
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    do
    {
      do
      {
        return;
        paramString1 = new File(paramString1);
      } while (!paramString1.exists());
      File[] arrayOfFile = paramString1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i1 = 0;
        if (i1 < arrayOfFile.length)
        {
          if ((paramString2 != null) && (!"".equals(paramString2)) && (arrayOfFile[i1].getAbsolutePath().equals(paramString2))) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (arrayOfFile[i1].isDirectory()) {
              a(arrayOfFile[i1].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[i1].delete();
            }
          }
        }
      }
    } while (!paramBoolean);
    paramString1.delete();
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 192
    //   8: iconst_2
    //   9: ldc_w 258
    //   12: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: invokestatic 266	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   19: invokevirtual 270	java/lang/Long:longValue	()J
    //   22: lstore 6
    //   24: lload 6
    //   26: ldc2_w 271
    //   29: lcmp
    //   30: ifne +51 -> 81
    //   33: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +30 -> 66
    //   39: ldc 192
    //   41: iconst_2
    //   42: new 194	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 274
    //   52: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: lload 6
    //   57: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   60: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iconst_0
    //   67: istore 9
    //   69: iload 9
    //   71: ireturn
    //   72: astore_2
    //   73: ldc2_w 271
    //   76: lstore 6
    //   78: goto -54 -> 24
    //   81: iconst_0
    //   82: istore 8
    //   84: invokestatic 281	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()I
    //   87: istore 5
    //   89: lload 6
    //   91: aload_1
    //   92: iload_3
    //   93: iload 4
    //   95: invokestatic 284	azbo:a	(JLandroid/content/Context;II)Z
    //   98: istore 9
    //   100: iload 9
    //   102: istore 8
    //   104: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +41 -> 148
    //   110: ldc 192
    //   112: iconst_2
    //   113: new 194	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 286
    //   123: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload 8
    //   128: invokevirtual 289	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   131: ldc_w 291
    //   134: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload 5
    //   139: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: iload 5
    //   150: ifeq +6 -> 156
    //   153: iconst_0
    //   154: istore 8
    //   156: iconst_0
    //   157: istore 9
    //   159: iload 9
    //   161: ifeq +71 -> 232
    //   164: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +41 -> 208
    //   170: ldc 192
    //   172: iconst_2
    //   173: new 194	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 296
    //   183: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload 9
    //   188: invokevirtual 289	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: ldc_w 291
    //   194: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload 5
    //   199: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: invokestatic 298	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	()V
    //   211: ldc_w 300
    //   214: aload_1
    //   215: iconst_1
    //   216: invokestatic 303	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Landroid/content/Context;Z)I
    //   219: istore 5
    //   221: lload 6
    //   223: aload_1
    //   224: iload_3
    //   225: iload 4
    //   227: invokestatic 284	azbo:a	(JLandroid/content/Context;II)Z
    //   230: istore 8
    //   232: iload 8
    //   234: istore 9
    //   236: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -170 -> 69
    //   242: ldc 192
    //   244: iconst_2
    //   245: ldc_w 305
    //   248: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: iload 8
    //   253: ireturn
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 308	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   259: ldc2_w 271
    //   262: putstatic 310	azbo:jdField_a_of_type_Long	J
    //   265: iconst_1
    //   266: istore 9
    //   268: goto -109 -> 159
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 308	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   276: iconst_0
    //   277: istore 10
    //   279: iload 10
    //   281: istore 8
    //   283: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -54 -> 232
    //   289: ldc 192
    //   291: iconst_2
    //   292: new 194	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 312
    //   302: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: iload 9
    //   307: invokevirtual 289	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   310: ldc_w 291
    //   313: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: iload 5
    //   318: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: iload 10
    //   329: istore 8
    //   331: goto -99 -> 232
    //   334: astore_2
    //   335: goto -80 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	RMVideoStateMgr
    //   0	338	1	paramContext	Context
    //   0	338	2	paramString	String
    //   0	338	3	paramInt1	int
    //   0	338	4	paramInt2	int
    //   87	230	5	i1	int
    //   22	200	6	l1	long
    //   82	248	8	bool1	boolean
    //   67	239	9	bool2	boolean
    //   277	51	10	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   15	24	72	java/lang/NumberFormatException
    //   89	100	254	java/lang/UnsatisfiedLinkError
    //   221	232	271	java/lang/UnsatisfiedLinkError
    //   104	148	334	java/lang/UnsatisfiedLinkError
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return (azcg.a()) || (paramBoolean);
  }
  
  private int b(int[] paramArrayOfInt)
  {
    int i2 = azbo.jdField_a_of_type_ArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if ((paramArrayOfInt[0] == azbo.jdField_a_of_type_ArrayOfInt[i1]) && (paramArrayOfInt[1] == azbo.jdField_b_of_type_ArrayOfInt[i1])) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = azbo.jdField_c_of_type_ArrayOfInt.length / 2;
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = a(azbo.jdField_c_of_type_ArrayOfInt[(i1 * 2 + 1)], paramBoolean);
      if ((azbo.jdField_c_of_type_ArrayOfInt[(i1 * 2)] != paramInt1) || (i3 != paramInt2)) {}
    }
    for (;;)
    {
      if ((i1 >= 0) && (jdField_a_of_type_ArrayOfInt[i1] != this.jdField_b_of_type_Int)) {
        this.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i1];
      }
      return;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + paramString);
    }
    String str = azbo.a();
    if ((str != null) && (!"".equals(str)) && (str.contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      a(str, paramString, false);
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = new File(paramString).getParentFile().getAbsolutePath();
    } while (TextUtils.isEmpty(str));
    a(str, paramString);
  }
  
  private void d(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < azbo.h.length))
    {
      paramInt *= 4;
      azds.j = azbo.jdField_c_of_type_ArrayOfInt[paramInt];
      azds.k = azbo.jdField_c_of_type_ArrayOfInt[(paramInt + 1)];
      azds.l = azbo.jdField_c_of_type_ArrayOfInt[(paramInt + 2)];
      azds.m = azbo.jdField_c_of_type_ArrayOfInt[(paramInt + 3)];
      return;
    }
    azds.j = azbo.jdField_d_of_type_Int;
    azds.k = azbo.jdField_d_of_type_Int * 3 / 4;
    azds.l = azds.j * azds.h / azds.i;
    azds.m = azds.k * azds.h / azds.i;
  }
  
  private void f(boolean paramBoolean)
  {
    if ((azcw.e(azcw.u)) || (paramBoolean)) {
      PtvFilterUtils.b(false);
    }
  }
  
  private boolean j()
  {
    int i3 = 1;
    this.n = true;
    if (Build.VERSION.SDK_INT < 18) {
      this.n = false;
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (!azfz.a())
      {
        this.n = false;
        i1 = 2;
      }
      int i2 = i3;
      if (this.jdField_f_of_type_Int != 10000)
      {
        i2 = i3;
        if (this.jdField_f_of_type_Int != 10002)
        {
          if (this.jdField_f_of_type_Int != 10007) {
            break label221;
          }
          i2 = i3;
        }
      }
      if (i2 == 0)
      {
        this.n = false;
        i1 = 3;
      }
      if (!this.m)
      {
        this.n = false;
        i1 = 4;
      }
      if (BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0) >= 2)
      {
        this.n = false;
        i1 = 5;
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(i1));
        azmz.a(BaseApplicationImpl.getContext()).a(null, "actMediaCodecSupport", this.n, 0L, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "mediacodec isMediaCodecSupport:" + this.n + ", code:" + i1);
        }
        return this.n;
        label221:
        i2 = 0;
        break;
      }
    }
  }
  
  private void o()
  {
    this.o = false;
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  public float a()
  {
    if ((this.jdField_a_of_type_Ajow.jdField_f_of_type_Int <= 0) || (this.jdField_a_of_type_Ajow.jdField_e_of_type_Int <= 0)) {
      return 1.333333F;
    }
    return this.jdField_a_of_type_Ajow.jdField_e_of_type_Int * 1.0F / this.jdField_a_of_type_Ajow.jdField_f_of_type_Int;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (a(paramBoolean))
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  public int a(azbt paramazbt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (paramazbt == this)
    {
      a().a(paramazbt, paramBoolean, paramInt1, paramInt2);
      i1 = 0;
    }
    return i1;
  }
  
  public ajpb a()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    ajoy localajoy = this.jdField_a_of_type_Ajoy;
    switch (i1)
    {
    default: 
      return localajoy;
    case 2: 
      return this.jdField_a_of_type_Ajox;
    case 3: 
      return this.jdField_a_of_type_Ajpa;
    }
    return this.jdField_a_of_type_Ajoz;
  }
  
  public void a()
  {
    if (this.i) {
      azbo.a();
    }
    azhf.a().a(this);
    a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_Azdf != null) && (!this.jdField_a_of_type_Azdf.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
    }
    this.jdField_a_of_type_Ajpc.b = false;
    this.jdField_a_of_type_Ajpc.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    a().a();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    k();
    int i1 = 0;
    while (i1 < paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.removeLatestVideo();
      if (paramBoolean) {
        AVCodec.get().removeLastCapture();
      }
      i1 += 1;
    }
    this.jdField_a_of_type_Double = paramInt1;
    azdx.a().a().b(paramInt1);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) < 3) {
      j();
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong, azdt paramazdt)
  {
    if (!this.n) {
      throw new RuntimeException("HWRecorder is not supported.");
    }
    if (this.jdField_a_of_type_Axrn == null) {
      throw new RuntimeException("hwVideoRecorder == null");
    }
    axrl localaxrl;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localaxrl = (axrl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while ((this.l) && (this.jdField_a_of_type_Axqz != null)) {
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_e_of_type_Int);
        localaxrl = null;
        break;
      case 0: 
        this.jdField_a_of_type_Axqz.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Axrn.a(this.jdField_a_of_type_Axqz, localaxrl);
        this.jdField_e_of_type_Int = 1;
      case 1: 
        this.jdField_a_of_type_Axrn.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        paramazdt.b();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RMVideoStateMgr", 2, "frameAvailableForHwRecorder:: hwRecordingEnabled = " + this.l + " ; hwEncodeConfig = " + this.jdField_a_of_type_Axqz);
  }
  
  public void a(int paramInt1, ajow paramajow, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 2: 
      paramajow.jdField_a_of_type_Int = paramInt2;
      paramajow.jdField_b_of_type_Int = 0;
      return;
    }
    paramajow.jdField_a_of_type_Int = (paramajow.jdField_e_of_type_Int - paramajow.jdField_d_of_type_Int - paramInt2);
    paramajow.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().f();
      if (paramInt == 0)
      {
        a(0, alpo.a(2131713860), false);
        if (1 == ajlj.jdField_a_of_type_Int) {
          bjsb.a(azbo.jdField_a_of_type_Long + "", "qzone_video_record", "1", null);
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label3;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajpj != null) {
      this.jdField_a_of_type_Ajpj.a(paramInt, paramString, paramBoolean);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_f_of_type_Int = paramInt;
    boolean bool2 = VideoEnvironment.b();
    if ((paramBoolean) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.m = bool1;
      j();
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "mediacodec set businessType:" + this.jdField_f_of_type_Int + ", isSoload:" + paramBoolean + ", isDeviceSupport:" + bool2 + ", isSurpportFilter:" + this.m);
      }
      return;
    }
  }
  
  public void a(ajow paramajow, boolean paramBoolean)
  {
    for (int i1 = 1;; i1 = 0)
    {
      try
      {
        boolean bool1 = azcw.d(azcw.e);
        boolean bool2 = azcw.b(azcw.f);
        boolean bool3 = azcw.b(azcw.x);
        if (((bool1) || (bool2) || (bool3)) && (ajli.jdField_a_of_type_Int == 1)) {
          paramajow.jdField_b_of_type_Int = (-paramajow.jdField_b_of_type_Int);
        }
        this.jdField_b_of_type_ArrayOfInt[0] = paramajow.jdField_a_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[1] = paramajow.jdField_b_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[2] = paramajow.jdField_c_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[3] = paramajow.jdField_d_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[4] = paramajow.jdField_e_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[5] = paramajow.jdField_f_of_type_Int;
        int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        if (ajli.jdField_a_of_type_Int != 1) {
          continue;
        }
        arrayOfInt[6] = i1;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "setVideoClipSpecdst_width=" + paramajow.jdField_e_of_type_Int + "spec.dst_height=" + paramajow.jdField_f_of_type_Int + "xoffset=" + paramajow.jdField_a_of_type_Int + "y_offset=" + paramajow.jdField_b_of_type_Int + "clip_width=" + paramajow.jdField_c_of_type_Int + "clip_height" + paramajow.jdField_d_of_type_Int);
        }
        setVideoClipSpec(this.jdField_b_of_type_ArrayOfInt);
      }
      catch (UnsatisfiedLinkError paramajow)
      {
        for (;;)
        {
          paramajow.printStackTrace();
        }
      }
      b(this.jdField_a_of_type_Ajow.jdField_e_of_type_Int, this.jdField_a_of_type_Ajow.jdField_f_of_type_Int, paramBoolean);
      return;
    }
  }
  
  public void a(axqz paramaxqz)
  {
    this.jdField_a_of_type_Axqz = paramaxqz;
  }
  
  public void a(axrl paramaxrl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxrl);
  }
  
  public void a(azdf paramazdf)
  {
    this.jdField_a_of_type_Azdf = paramazdf;
    if (this.jdField_a_of_type_Azdf != null) {
      paramazdf.a(this);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = 2;
    boolean bool2 = false;
    boolean bool1 = false;
    PtvFilterUtils.b(true);
    if (paramInt1 == 0)
    {
      PtvFilterUtils.a(0);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
      }
      azds.x = 0;
      azds.E = 0;
      azds.a();
      azds.jdField_c_of_type_Int = paramInt4 * 1000;
      VideoEnvironment.b();
      paramBoolean = azcw.a(azcw.l);
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
      }
      if (paramBoolean)
      {
        azbo.jdField_c_of_type_Int = 640;
        azbo.jdField_d_of_type_Int = 480;
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_Int = 1;
        AudioCapture.jdField_a_of_type_Int = 4000;
        return;
        paramBoolean = azcw.a(azcw.s);
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
        }
        if (paramBoolean)
        {
          azbo.jdField_c_of_type_Int = 1024;
          azbo.jdField_d_of_type_Int = 768;
          if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
          }
        }
        else
        {
          azbo.jdField_c_of_type_Int = 320;
          azbo.jdField_d_of_type_Int = 240;
        }
      }
    }
    if (paramInt1 == 1)
    {
      PtvFilterUtils.a(0);
      AudioCapture.jdField_a_of_type_Int = 4000;
      AudioCapture.jdField_b_of_type_Int = 1;
      azds.E = 1;
      azds.a();
    }
    for (;;)
    {
      int i1;
      try
      {
        VideoEnvironment.a(paramAppInterface, paramString, paramBoolean);
        VideoEnvironment.a();
        paramAppInterface = VideoEnvironment.a(paramInt2, false);
        if (a(paramAppInterface))
        {
          i1 = a(paramAppInterface);
          azbo.jdField_c_of_type_Int = paramAppInterface[0];
          azbo.jdField_d_of_type_Int = paramAppInterface[1];
          paramInt4 = paramAppInterface[2];
          paramInt1 = paramAppInterface[3];
          d(i1);
          paramAppInterface = VideoEnvironment.a(paramInt2);
          if (paramInt3 != 1) {
            continue;
          }
          paramInt2 = paramAppInterface[0];
          if (paramInt2 != 0) {
            break label1493;
          }
          if (paramInt4 > 0)
          {
            VideoEnvironment.c(paramInt4);
            VideoEnvironment.b(paramInt4);
            this.jdField_b_of_type_Int = paramInt4;
          }
          this.g = true;
          this.jdField_d_of_type_Int = 2;
        }
      }
      catch (Throwable paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        continue;
        azbo.jdField_c_of_type_Int = azbo.g[1];
        azbo.jdField_d_of_type_Int = azbo.h[1];
        paramInt4 = 450;
        paramInt1 = 750;
        i1 = 1;
        continue;
        if ((paramInt3 == 4) || (paramInt3 == 3))
        {
          paramInt2 = paramAppInterface[1];
          continue;
        }
        paramInt2 = paramAppInterface[2];
        continue;
      }
      if (paramInt1 == 2)
      {
        PtvFilterUtils.a(1);
        azds.x = 0;
        azds.E = 0;
        azds.a();
      }
      for (;;)
      {
        try
        {
          VideoEnvironment.a(paramAppInterface, paramString, false);
          VideoEnvironment.a();
          paramAppInterface = VideoEnvironment.a(paramInt2, true);
          if (a(paramAppInterface))
          {
            i1 = b(paramAppInterface);
            azbo.jdField_c_of_type_Int = paramAppInterface[0];
            azbo.jdField_d_of_type_Int = paramAppInterface[1];
            paramInt4 = paramAppInterface[2];
            paramInt1 = paramAppInterface[3];
            d(i1);
            paramAppInterface = VideoEnvironment.a(paramInt2);
            if (paramInt3 != 1) {
              continue;
            }
            paramInt2 = paramAppInterface[0];
            if (paramInt2 != 0) {
              break label1487;
            }
            if (paramInt4 > 0)
            {
              VideoEnvironment.c(paramInt4);
              VideoEnvironment.b(paramInt4);
              paramBoolean = bool1;
              if (paramInt2 == 1) {
                paramBoolean = true;
              }
              VideoEnvironment.a(paramInt4, paramBoolean);
              this.jdField_b_of_type_Int = paramInt4;
            }
            this.jdField_d_of_type_Int = 3;
            AudioCapture.jdField_a_of_type_Int = 4000;
            AudioCapture.jdField_b_of_type_Int = 1;
            f(true);
            paramInt2 = lnz.e();
            paramInt1 = paramInt2;
            if (paramInt2 > 4) {
              paramInt1 = 4;
            }
            paramInt2 = paramInt1;
            if (paramInt1 <= 0) {
              paramInt2 = 2;
            }
            paramInt1 = paramInt2;
            if (paramInt2 != 1)
            {
              paramInt1 = paramInt2;
              if (paramInt2 % 2 != 0) {
                paramInt1 = 2;
              }
            }
            PtvFilterUtils.b(paramInt1);
          }
        }
        catch (Throwable paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          continue;
          azbo.jdField_c_of_type_Int = azbo.jdField_a_of_type_ArrayOfInt[0];
          azbo.jdField_d_of_type_Int = azbo.jdField_b_of_type_ArrayOfInt[0];
          paramInt4 = 450;
          paramInt1 = 750;
          i1 = 0;
          continue;
          if ((paramInt3 == 4) || (paramInt3 == 3))
          {
            paramInt2 = paramAppInterface[1];
            continue;
          }
          paramInt2 = paramAppInterface[2];
          continue;
        }
        if (paramInt1 == 3)
        {
          PtvFilterUtils.a(1);
          azds.x = 0;
          azds.E = 0;
          azds.a();
        }
        for (;;)
        {
          try
          {
            VideoEnvironment.a(paramAppInterface, paramString, false);
            VideoEnvironment.a();
            paramAppInterface = VideoEnvironment.a(paramInt2, true);
            if (a(paramAppInterface))
            {
              i2 = b(paramAppInterface);
              azbo.jdField_c_of_type_Int = paramAppInterface[0];
              azbo.jdField_d_of_type_Int = paramAppInterface[1];
              i1 = paramAppInterface[2];
              paramInt1 = paramAppInterface[3];
              d(i2);
              paramAppInterface = VideoEnvironment.a(paramInt2);
              if (paramInt3 != 1) {
                continue;
              }
              paramInt2 = paramAppInterface[0];
              if (paramInt2 != 0) {
                break label1481;
              }
              if (i1 > 0)
              {
                VideoEnvironment.d(paramInt4);
                VideoEnvironment.b(i1);
                paramBoolean = bool2;
                if (paramInt2 == 1) {
                  paramBoolean = true;
                }
                VideoEnvironment.a(i1, paramBoolean);
                this.jdField_b_of_type_Int = i1;
              }
              this.jdField_d_of_type_Int = 3;
              AudioCapture.jdField_a_of_type_Int = 4000;
              AudioCapture.jdField_b_of_type_Int = 1;
              f(true);
              paramInt2 = lnz.e();
              paramInt1 = paramInt2;
              if (paramInt2 > 4) {
                paramInt1 = 4;
              }
              paramInt2 = paramInt1;
              if (paramInt1 <= 0) {
                paramInt2 = 2;
              }
              if ((paramInt2 == 1) || (paramInt2 % 2 == 0)) {
                break label1475;
              }
              paramInt1 = i3;
              PtvFilterUtils.b(paramInt1);
            }
          }
          catch (Throwable paramAppInterface)
          {
            paramAppInterface.printStackTrace();
            continue;
            azbo.jdField_c_of_type_Int = azbo.jdField_a_of_type_ArrayOfInt[1];
            azbo.jdField_d_of_type_Int = azbo.jdField_b_of_type_ArrayOfInt[1];
            i1 = 450;
            paramInt1 = 750;
            int i2 = 1;
            continue;
            if ((paramInt3 == 4) || (paramInt3 == 3))
            {
              paramInt2 = paramAppInterface[1];
              continue;
            }
            paramInt2 = paramAppInterface[2];
            continue;
          }
          if (paramInt1 == 4)
          {
            PtvFilterUtils.a(0);
            if (QLog.isColorLevel()) {
              QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
            }
            azds.x = 0;
            azds.E = 0;
            azds.a();
            azds.jdField_c_of_type_Int = paramInt4 * 1000;
            VideoEnvironment.b();
            azds.g = 18;
            paramBoolean = azcw.a(azcw.l);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              azbo.jdField_c_of_type_Int = 640;
              azbo.jdField_d_of_type_Int = 480;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
              }
            }
            for (;;)
            {
              this.jdField_d_of_type_Int = 4;
              AudioCapture.jdField_a_of_type_Int = 4000;
              return;
              paramBoolean = azcw.a(azcw.s);
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
              }
              if (paramBoolean)
              {
                azbo.jdField_c_of_type_Int = 1024;
                azbo.jdField_d_of_type_Int = 768;
                if (QLog.isColorLevel()) {
                  QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
                }
              }
              else
              {
                azbo.jdField_c_of_type_Int = 640;
                azbo.jdField_d_of_type_Int = 480;
              }
            }
          }
          if (paramInt1 != 5) {
            break;
          }
          PtvFilterUtils.a(0);
          azds.x = 0;
          azds.E = 0;
          azds.a();
          azds.jdField_c_of_type_Int = paramInt4 * 1000;
          VideoEnvironment.b();
          azds.g = 18;
          paramBoolean = azcw.a(azcw.l);
          if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
          }
          if (paramBoolean)
          {
            azbo.jdField_c_of_type_Int = 640;
            azbo.jdField_d_of_type_Int = 480;
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
            }
          }
          for (;;)
          {
            this.jdField_d_of_type_Int = 5;
            AudioCapture.jdField_a_of_type_Int = 4000;
            return;
            paramBoolean = azcw.a(azcw.s);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              azbo.jdField_c_of_type_Int = 1024;
              azbo.jdField_d_of_type_Int = 768;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
              }
            }
            else
            {
              azbo.jdField_c_of_type_Int = 1024;
              azbo.jdField_d_of_type_Int = 768;
            }
          }
          label1475:
          paramInt1 = paramInt2;
          continue;
          label1481:
          i1 = paramInt1;
        }
        label1487:
        paramInt4 = paramInt1;
      }
      label1493:
      paramInt4 = paramInt1;
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    if (this.jdField_a_of_type_Azdf != null) {
      this.jdField_a_of_type_Azdf.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      a().a(paramObject, paramInt, paramVarArgs);
    }
    do
    {
      return;
    } while ((!azdl.class.isInstance(paramObject)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    k();
    if (QLog.isColorLevel()) {
      QLog.d("" + paramString, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      bdcs.a(this.jdField_a_of_type_JavaLangString, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4;
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      setResolutionAlignedByteNative(paramInt);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, ajpj paramajpj)
  {
    c(1);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    azbo.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    azbo.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    this.j = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Double = 0.0D;
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_a_of_type_Ajpj = paramajpj;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.p = true;
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "rmStateMgr onCreate viewST:" + this.jdField_a_of_type_Ajpj + "\n videoStateMgr:" + jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    }
    if (!a(paramContext, paramString, azbo.jdField_c_of_type_ArrayOfInt[4], azbo.jdField_c_of_type_ArrayOfInt[5]))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "initTMMEngine[failed]");
      }
      if (1 == ajlj.jdField_a_of_type_Int) {
        bjsb.a(paramString, "qzone_video_record", "0", null);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_Azfm = new azfm(azbo.a());
      b(1);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = ((ajpf)paramContext);
        azdx.a().a().addCodecCallback(this);
        azdx.a().a().a(this);
        azhf.a();
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() > 0) && (this.jdField_a_of_type_Ajpj != null))
        {
          this.jdField_a_of_type_Ajpj.w();
          azdx.a().a().b();
          azdx.a().a();
        }
        azdx.a().a().a(this);
        azdx.a().a().a();
        if ((this.n) && (this.jdField_a_of_type_Axrn == null)) {
          this.jdField_a_of_type_Axrn = new axrn();
        }
        return true;
      }
      catch (ClassCastException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      return false;
    }
    catch (RuntimeException paramContext) {}
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length == 4) && (paramArrayOfInt[0] > 0) && (paramArrayOfInt[1] > 0);
  }
  
  public int b()
  {
    int i3 = azds.jdField_c_of_type_Int;
    int i2 = i3 / 1000;
    int i1 = i2;
    if (i3 % 1000 >= 500) {
      i1 = i2 + 1;
    }
    return i1;
  }
  
  public void b()
  {
    azbo.b();
    a().f();
    azhf.a().a(null);
    this.jdField_a_of_type_Ajpc.jdField_a_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    try
    {
      setBeautyLevelNative(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void b(int paramInt1, ajow paramajow, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramajow.jdField_a_of_type_Int = paramInt2;
      paramajow.jdField_b_of_type_Int = (paramajow.jdField_f_of_type_Int - paramajow.jdField_c_of_type_Int);
      return;
    case 2: 
      paramajow.jdField_a_of_type_Int = paramInt2;
      paramajow.jdField_b_of_type_Int = 0;
      return;
    case 4: 
      paramajow.jdField_a_of_type_Int = (paramajow.jdField_e_of_type_Int - paramajow.jdField_d_of_type_Int - paramInt2);
      paramajow.jdField_b_of_type_Int = (paramajow.jdField_f_of_type_Int - paramajow.jdField_c_of_type_Int);
      return;
    case 5: 
      paramajow.jdField_a_of_type_Int = (paramajow.jdField_e_of_type_Int - paramajow.jdField_d_of_type_Int - paramInt2);
      paramajow.jdField_b_of_type_Int = 0;
      return;
    }
    paramajow.jdField_a_of_type_Int = 0;
    paramajow.jdField_b_of_type_Int = (-(paramajow.jdField_f_of_type_Int - paramajow.jdField_c_of_type_Int) / 2);
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Toast.makeText(VideoEnvironment.a(), "" + paramString, 0).show();
  }
  
  public void b(boolean paramBoolean)
  {
    c(1);
    a().a(paramBoolean);
    a().a();
    if ((this.jdField_a_of_type_Ajpc.b) && (this.jdField_a_of_type_Ajpc.jdField_a_of_type_Boolean)) {
      a().f();
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3;
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.n);
    }
    return this.n;
  }
  
  public int c()
  {
    return azds.jdField_c_of_type_Int * 10 / 1000;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mActivtiyDestory = true;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "rmStateMgr onDestroy viewST:" + this.jdField_a_of_type_Ajpj + "\n videoStateMgr:" + jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
      }
      this.jdField_a_of_type_Ajpj.w();
      this.jdField_a_of_type_Ajpj = null;
      this.jdField_a_of_type_Ajoy.f();
      this.jdField_a_of_type_Ajoy.g();
      this.jdField_a_of_type_Ajox.f();
      this.jdField_a_of_type_Ajox.g();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      k();
      this.jdField_a_of_type_Ajov = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = null;
      this.jdField_a_of_type_Azcu = null;
      h();
      this.jdField_f_of_type_Int = 0;
      this.m = false;
      this.n = false;
    }
    if (this.jdField_a_of_type_Azdf != null) {
      this.jdField_a_of_type_Azdf.jdField_a_of_type_Azdd = null;
    }
    this.jdField_a_of_type_Azdf = null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean c(int paramInt)
  {
    int i2 = this.jdField_c_of_type_Int;
    int i1 = i2;
    if (i2 <= 0)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, " checkVideoFrameCount frameCount = " + i1);
    }
    return i1 >= paramInt;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Double = 0.0D;
    azdx.a().a().c();
    if (azdx.a().a().a.getState() == Thread.State.TERMINATED)
    {
      azdx.a().a();
      azdx.a().a().a(this);
      azdx.a().a().a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Azdf == null) {}
    do
    {
      return true;
      if ((this.jdField_a_of_type_Azdf.b.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Azdf.c.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Azdf.b.jdField_a_of_type_Azda.equals(this.jdField_a_of_type_Azdf.c.jdField_a_of_type_Azda))) {
        return false;
      }
    } while (!azcw.e(azcw.C));
    return false;
  }
  
  public void e()
  {
    o();
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "[enterRecordMode]currentState = " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " mCurrentSegInvalid=" + this.k);
    }
    a().b();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajoy.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 == 3) {
      a().b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "[exitRecordMode]currentState = " + i1 + " mCurrentSegInvalid=" + this.k);
      }
      return this.k;
      if (i1 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
        }
        this.jdField_a_of_type_Ajpc.b = true;
      }
    }
  }
  
  public void f()
  {
    this.l = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  boolean f()
  {
    long l1 = azhf.a(azhf.a().b);
    if (l1 <= azhf.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l1 + "StorageManager.FREESPACE_LIMIT_EXIT=" + azhf.jdField_a_of_type_Long + " 手机剩余存储空间不足");
      }
      a(0, alpo.a(2131713859), false);
      return false;
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.l = false;
    if (this.jdField_a_of_type_Axrn != null) {
      this.jdField_a_of_type_Axrn.b();
    }
    this.jdField_e_of_type_Int = 0;
  }
  
  public boolean g()
  {
    if (!this.o) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.o;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public void h()
  {
    if (this.j) {
      return;
    }
    azdx.a().a().b();
    azdx.a().a().a(null);
    azdx.a().a().removeCodecCallback(this);
    azdx.a().a().recycle();
    azdx.a().a().a();
    azdx.a().a();
    try
    {
      azbo.c();
      azhf.a().a();
      this.j = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.jdField_d_of_type_Boolean);
  }
  
  public void i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.o = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean i()
  {
    return this.p;
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Ajov != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      this.jdField_a_of_type_Ajov.startWatching();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ajov != null) {
      this.jdField_a_of_type_Ajov.stopWatching();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!h())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(this.jdField_a_of_type_Azfm);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (h())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.b(this.jdField_a_of_type_Azcu);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.g();
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
      }
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    a().a(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */