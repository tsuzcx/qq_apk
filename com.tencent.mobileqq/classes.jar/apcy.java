import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController.1;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController.2;
import com.tencent.mobileqq.minicode.DecodeProxy;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.mobileqq.minicode.recog.MiniCodeDetector;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class apcy
  implements RecogCallback
{
  private static long jdField_a_of_type_Long;
  public static volatile apcy a;
  private static boolean d;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private int jdField_a_of_type_Int = -1;
  private aoxb jdField_a_of_type_Aoxb;
  private MiniCodeDetector jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
  private Set<Long> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private CopyOnWriteArrayList<WeakReference<RecogCallback>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private CopyOnWriteArrayList<WeakReference<apdc>> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = aoxi.a().f;
  private boolean l = aoxi.a().g;
  
  private apcy()
  {
    boolean bool = RecogUtil.isX86VM();
    if (bool)
    {
      this.l = false;
      this.k = false;
      QLog.i("MiniRecog.MiniCodeController", 1, String.format("init return [%b %b]", new Object[] { Boolean.valueOf(false), Boolean.valueOf(bool) }));
    }
    if ((!g) || (RecogUtil.getMiniScanErrorCnt(false) > 0))
    {
      g = true;
      ThreadManager.post(new MiniCodeController.2(this), 5, null, true);
    }
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!e) {}
    do
    {
      return -1;
      try
      {
        YuvProxy.Yuv2Rgba(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
        return 0;
      }
      catch (Throwable paramArrayOfInt) {}
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniCodeController", 2, "Yuv2Rgba exception", paramArrayOfInt);
    return -1;
  }
  
  private aoxb a()
  {
    try
    {
      if (this.jdField_a_of_type_Aoxb == null) {
        this.jdField_a_of_type_Aoxb = new aoxb();
      }
      aoxb localaoxb = this.jdField_a_of_type_Aoxb;
      return localaoxb;
    }
    finally {}
  }
  
  public static apcy a()
  {
    if (jdField_a_of_type_Apcy == null) {}
    try
    {
      if (jdField_a_of_type_Apcy == null) {
        jdField_a_of_type_Apcy = new apcy();
      }
      return jdField_a_of_type_Apcy;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return d;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!paramString.equals("____JAVA_EXCEPTION____")) && (!paramString.equals("____NATIVE_ERROR____")) && (!paramString.equals("____NATIVE_EXCEPTION____")) && (!paramString.startsWith("____NATIVE_ERROR____")) && (!paramString.startsWith("____NATIVE_EXCEPTION____"));
  }
  
  public static boolean b()
  {
    return e;
  }
  
  private void c()
  {
    if (d)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        apdc localapdc = (apdc)((WeakReference)localIterator.next()).get();
        if (localapdc != null) {
          localapdc.b();
        }
      }
    }
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (!d) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("decode [w,h,barX,barY,barW,barH]=[%d,%d,%d,%d,%d,%d] mode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) }));
    }
    try
    {
      if (!f)
      {
        String str = DecodeProxy.getVersion();
        QLog.i("MiniRecog.MiniCodeController", 1, "call nativeDecode version = " + str);
        if (QLog.isColorLevel()) {
          DecodeProxy.setLogSwitch(true);
        }
        f = true;
      }
      paramArrayOfByte = DecodeProxy.nativeDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, "call nativeDecode error", paramArrayOfByte);
    }
    return "____JAVA_EXCEPTION____";
  }
  
  public void a()
  {
    boolean bool1;
    boolean bool2;
    label47:
    Object localObject3;
    String str1;
    label91:
    label114:
    try
    {
      if ((this.k) && (!d))
      {
        bool1 = apdh.a();
        if (!bool1) {}
      }
      try
      {
        if (apdh.b("minicode") != 0) {
          break label522;
        }
        bool1 = true;
        d = bool1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          Object localObject1;
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel decode error", localThrowable1);
        }
      }
      if (this.jdField_a_of_type_Int < 0) {
        break label550;
      }
      bool2 = true;
      if ((!this.l) || (!bool2)) {
        break label629;
      }
      localObject3 = apdj.c("QMCF_qr");
      str1 = apdi.b();
      if ((TextUtils.isEmpty(str1)) || (!str1.equalsIgnoreCase((String)localObject3))) {
        break label556;
      }
      bool1 = true;
      if (!QLog.isColorLevel()) {
        break label651;
      }
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label634;
      }
      localObject1 = "null";
    }
    finally {}
    QLog.i("MiniRecog.MiniCodeController", 2, String.format("loadSoAndModel detectSoMd5=%s modelNeedMd5=%s bMatch=%b", new Object[] { localObject1, localObject3, Boolean.valueOf(bool1) }));
    label522:
    label651:
    for (;;)
    {
      boolean bool3;
      if ((this.l) && (bool2) && (!e) && (bool1))
      {
        bool3 = apdj.a();
        if (!bool3) {}
      }
      for (;;)
      {
        try
        {
          int m = apdj.b("QMCF_qr");
          int n = apdj.b("yuvutil");
          if ((m != 0) || (n != 0)) {
            continue;
          }
          bool3 = true;
          e = bool3;
        }
        catch (Throwable localThrowable2)
        {
          label550:
          label556:
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect error", localThrowable2);
          continue;
          jdField_a_of_type_Long = 0L;
          continue;
          MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
          if (localMiniCodeDetector == null) {
            continue;
          }
          bool1 = true;
          continue;
          bool1 = false;
          continue;
        }
        if ((!this.l) || (!bool2) || (!e) || (!bool1) || (this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector != null)) {
          continue;
        }
        bool1 = apdi.a();
        if (!bool1) {
          continue;
        }
        try
        {
          if (jdField_a_of_type_Long != 0L) {
            continue;
          }
          jdField_a_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector = new MiniCodeDetector(null, this.jdField_a_of_type_Int, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.addRecogCallback(this);
          localObject1 = apdi.a() + File.separator + apdi.a("qr_detection_model.bin");
          localObject3 = apdi.a() + File.separator + apdi.a("qr_detection_model.txt");
          str1 = apdi.a() + File.separator + apdi.a("qr_anchor.bin");
          String str2 = RecogUtil.getKernalBinPath();
          File localFile = new File(str2);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.initEnv((String)localObject1, (String)localObject3, str1, str2);
          bool1 = true;
        }
        catch (Throwable localThrowable3)
        {
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect model error", localThrowable3);
          bool1 = false;
          continue;
        }
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d", new Object[] { Boolean.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(bool2), Boolean.valueOf(this.k), Boolean.valueOf(this.l), Boolean.valueOf(bool1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        c();
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label47;
        bool1 = false;
        break label91;
        bool3 = false;
      }
      label629:
      bool1 = false;
      continue;
      label634:
      localObject3 = str1;
      if (str1 != null) {
        break label114;
      }
      localObject3 = "null";
      break label114;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramLong));
    }
    boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onDestroy busiHash=%d desc=%s bDoDestroy=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(bool) }));
    }
    if (bool) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.close();
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector = null;
        }
        if (this.jdField_a_of_type_Aoxb != null) {
          this.jdField_a_of_type_Aoxb.a();
        }
        this.i = false;
        this.j = false;
        jdField_a_of_type_Apcy = null;
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(android.content.Context paramContext, long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	apcy:k	Z
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: getfield 72	apcy:l	Z
    //   13: istore 5
    //   15: iload 5
    //   17: ifne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_1
    //   24: invokevirtual 367	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 59	apcy:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   32: lload_2
    //   33: invokestatic 341	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokeinterface 370 2 0
    //   41: istore 5
    //   43: iload 5
    //   45: ifeq +37 -> 82
    //   48: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +31 -> 82
    //   54: ldc 78
    //   56: iconst_2
    //   57: ldc_w 372
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: lload_2
    //   67: invokestatic 341	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload 4
    //   75: aastore
    //   76: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iload 5
    //   84: ifeq -64 -> 20
    //   87: aload_0
    //   88: invokespecial 374	apcy:a	()Laoxb;
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 153	apcy:i	Z
    //   97: ifne +80 -> 177
    //   100: aload_0
    //   101: getfield 172	apcy:j	Z
    //   104: istore 5
    //   106: iload 5
    //   108: ifne +69 -> 177
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 172	apcy:j	Z
    //   116: aload 4
    //   118: aload_1
    //   119: new 376	apda
    //   122: dup
    //   123: aload_0
    //   124: aload 4
    //   126: invokespecial 379	apda:<init>	(Lapcy;Laoxb;)V
    //   129: new 381	apdb
    //   132: dup
    //   133: aload_0
    //   134: aconst_null
    //   135: invokespecial 384	apdb:<init>	(Lapcy;Lcom/tencent/mobileqq/ar/codeEngine/MiniCodeController$1;)V
    //   138: invokevirtual 387	aoxb:a	(Landroid/content/Context;Laowr;Laowu;)V
    //   141: getstatic 150	apcy:d	Z
    //   144: ifeq +7 -> 151
    //   147: aload_0
    //   148: invokespecial 329	apcy:c	()V
    //   151: aload_0
    //   152: invokevirtual 388	apcy:a	()V
    //   155: goto -135 -> 20
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: ldc 78
    //   166: iconst_1
    //   167: ldc_w 390
    //   170: aload_1
    //   171: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -33 -> 141
    //   177: aload_0
    //   178: invokevirtual 393	apcy:b	()V
    //   181: goto -40 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	apcy
    //   0	184	1	paramContext	android.content.Context
    //   0	184	2	paramLong	long
    //   0	184	4	paramString	String
    //   13	94	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	158	finally
    //   23	43	158	finally
    //   48	82	158	finally
    //   87	106	158	finally
    //   111	141	158	finally
    //   141	151	158	finally
    //   151	155	158	finally
    //   164	174	158	finally
    //   177	181	158	finally
    //   111	141	163	java/lang/RuntimeException
  }
  
  public void a(apdc paramapdc)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      apdc localapdc = (apdc)((WeakReference)localIterator.next()).get();
      if ((localapdc != null) && (localapdc == paramapdc)) {
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramapdc));
  }
  
  public void a(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if ((localRecogCallback != null) && (localRecogCallback == paramRecogCallback)) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramRecogCallback));
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong)
  {
    MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
    boolean bool1;
    if ((!e) || (!this.h) || (localMiniCodeDetector == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localMiniCodeDetector.detect(paramBitmap, paramLong);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniCodeController", 2, String.format("detect async exec=%b ts=%d", new Object[] { Boolean.valueOf(bool2), Long.valueOf(paramLong) }));
    return bool2;
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong, Rect paramRect)
  {
    MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
    if ((!e) || (localMiniCodeDetector == null) || (paramRect == null)) {
      return false;
    }
    Object localObject = new Object();
    boolean bool2 = this.h;
    int m;
    if (bool2) {
      m = 3000;
    }
    for (;;)
    {
      boolean[] arrayOfBoolean = new boolean[1];
      arrayOfBoolean[0] = false;
      paramRect = new apcz(this, paramRect, paramLong, localObject, localMiniCodeDetector, arrayOfBoolean, paramBitmap);
      boolean bool1;
      if ((bool2) && (localMiniCodeDetector.detect(paramBitmap, paramLong)))
      {
        bool1 = true;
        label97:
        arrayOfBoolean[0] = bool1;
        if ((bool2) && ((!bool2) || (arrayOfBoolean[0] == 0))) {
          break label232;
        }
        bool1 = true;
        label123:
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync needWait=%b bReady=%b exec=%b ts=%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(arrayOfBoolean[0]), Long.valueOf(paramLong) }));
        }
        if (bool1)
        {
          localMiniCodeDetector.addRecogCallback(paramRect);
          paramLong = m;
        }
      }
      try
      {
        localObject.wait(paramLong);
        localMiniCodeDetector.removeRecogCallback(paramRect);
        return arrayOfBoolean[0];
        m = 5000;
        continue;
        bool1 = false;
        break label97;
        label232:
        bool1 = false;
        break label123;
      }
      catch (InterruptedException paramBitmap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, "detectSync wait InterruptedException", paramBitmap);
          }
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    int m = 1;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("requestDownloadResourceIfNeed");
        if ((!d) && (!this.jdField_a_of_type_Boolean))
        {
          if (!apdh.a()) {
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" decode 0");
          }
        }
        if (this.jdField_a_of_type_Int >= 0)
        {
          if ((this.l) && (m != 0) && (!e) && (!this.jdField_b_of_type_Boolean))
          {
            if (!apdj.a()) {
              break label224;
            }
            this.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" detect 0");
            }
          }
          if ((this.l) && (m != 0) && (this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector == null) && (!this.c))
          {
            if (!apdi.a()) {
              break label256;
            }
            this.c = true;
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" model 0");
            }
          }
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            QLog.i("MiniRecog.MiniCodeController", 2, localStringBuilder.toString());
          }
          return;
          if (this.jdField_a_of_type_Aoxb != null) {
            this.jdField_a_of_type_Aoxb.c(0);
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder.append(" decode 1");
          continue;
        }
        m = 0;
      }
      finally {}
      continue;
      label224:
      if (this.jdField_a_of_type_Aoxb != null) {
        this.jdField_a_of_type_Aoxb.c(1);
      }
      if (QLog.isColorLevel())
      {
        localObject.append(" detect 1");
        continue;
        label256:
        if (this.jdField_a_of_type_Aoxb != null) {
          this.jdField_a_of_type_Aoxb.c(2);
        }
        if (QLog.isColorLevel()) {
          localObject.append(" model 1");
        }
      }
    }
  }
  
  public void b(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      RecogCallback localRecogCallback = (RecogCallback)localWeakReference.get();
      if ((localRecogCallback != null) && (localRecogCallback == paramRecogCallback)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public void c(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      apdc localapdc = (apdc)localWeakReference.get();
      if ((localapdc != null) && (localapdc == paramRecogCallback)) {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void onDetectReady(int paramInt)
  {
    this.h = true;
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, "onDetectReady");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if (localRecogCallback != null) {
        localRecogCallback.onDetectReady(paramInt);
      }
    }
    long l1;
    if (jdField_a_of_type_Long > 0L)
    {
      l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
      jdField_a_of_type_Long = 0L;
    }
    for (;;)
    {
      ThreadManager.post(new MiniCodeController.1(this, paramInt, l1), 5, null, true);
      return;
      l1 = 0L;
    }
  }
  
  public void onDetectResult(List<apcu> paramList, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if (localRecogCallback != null) {
        localRecogCallback.onDetectResult(paramList, paramLong);
      }
    }
  }
  
  public void onSaveImg(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if (localRecogCallback != null) {
        localRecogCallback.onSaveImg(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcy
 * JD-Core Version:    0.7.0.1
 */