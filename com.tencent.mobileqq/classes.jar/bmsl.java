import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.sdk.download.DownloadType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class bmsl
  implements bmtb, bmtd, bmtg, INetEngine.INetEngineListener
{
  static INetEngine.IBreakDownFix jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new bmsn();
  private static Singleton<bmsl, Void> jdField_a_of_type_ComTencentWeiyunUtilsSingleton;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Context jdField_a_of_type_AndroidContentContext;
  private final bmsk jdField_a_of_type_Bmsk = new bmsk();
  private bmsz jdField_a_of_type_Bmsz;
  private bmta jdField_a_of_type_Bmta;
  private bmtc jdField_a_of_type_Bmtc;
  private bmte jdField_a_of_type_Bmte;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private final ThreadPoolWrapper jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper = new ThreadPoolWrapper("WyDownloader");
  private final DualHashMap<Long, String> jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap = new DualHashMap();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<Long, bmsi> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<bmsy> jdField_a_of_type_JavaUtilList;
  private Map<Long, NetReq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private INetEngine jdField_b_of_type_ComTencentMobileqqTransfileINetEngine;
  private final HashSet<Long> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, HttpNetReq> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new bmsm();
  }
  
  private bmsl()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, new bmso(this));
  }
  
  public static bmsl a()
  {
    return (bmsl)jdField_a_of_type_ComTencentWeiyunUtilsSingleton.get(null);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2 + ".tmp";
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if ((localObject == null) || (((bmsi)localObject).d())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong)))
        {
          this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
          return;
        }
        if (this.jdField_b_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong))) {
          b();
        }
      }
      a();
      b();
    }
  }
  
  private void a(long paramLong, NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Long.valueOf(paramLong));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramNetReq);
      a();
      b();
      return;
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bmsi localbmsi1 = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1) {
      localbmsi2.a(paramBoolean2);
    }
    if (paramBoolean3) {
      localbmsi2.b(paramBoolean4);
    }
    a(localbmsi2, 1, 0, null);
    return true;
  }
  
  /* Error */
  private static boolean a(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 218	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   7: invokestatic 222	bmub:a	()Ljava/lang/String;
    //   10: invokevirtual 228	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 231	java/io/File:getName	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: invokestatic 236	auea:a	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +13 -> 42
    //   32: iload_2
    //   33: iconst_2
    //   34: if_icmpeq +8 -> 42
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpne -23 -> 16
    //   42: aload_0
    //   43: aload_3
    //   44: invokestatic 242	com/tencent/mobileqq/transfile/filebrowser/MimeTypesTools:getMimeType	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: new 244	android/content/ContentValues
    //   52: dup
    //   53: invokespecial 245	android/content/ContentValues:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc 247
    //   62: aload_3
    //   63: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload 5
    //   68: ldc 252
    //   70: aload_3
    //   71: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 5
    //   76: ldc 254
    //   78: aload_1
    //   79: invokevirtual 258	java/io/File:lastModified	()J
    //   82: ldc2_w 259
    //   85: ldiv
    //   86: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 263	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload 5
    //   94: ldc_w 265
    //   97: aload 6
    //   99: invokevirtual 250	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 5
    //   104: ldc_w 267
    //   107: aload_1
    //   108: invokevirtual 270	java/io/File:length	()J
    //   111: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokevirtual 263	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   117: iload_2
    //   118: ifne +150 -> 268
    //   121: aload 5
    //   123: ldc_w 272
    //   126: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   129: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: invokevirtual 263	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   135: getstatic 283	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   138: astore_3
    //   139: aload_0
    //   140: invokevirtual 289	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   143: astore_0
    //   144: aload_0
    //   145: aload_3
    //   146: aload 5
    //   148: invokevirtual 295	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull -137 -> 16
    //   156: aload_0
    //   157: aload_3
    //   158: ldc_w 297
    //   161: invokevirtual 301	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   164: astore 5
    //   166: aload 5
    //   168: ifnull -152 -> 16
    //   171: new 303	java/io/BufferedInputStream
    //   174: dup
    //   175: new 305	java/io/FileInputStream
    //   178: dup
    //   179: aload_1
    //   180: invokespecial 308	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   183: invokespecial 311	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   186: astore_0
    //   187: new 313	java/io/BufferedOutputStream
    //   190: dup
    //   191: new 315	java/io/FileOutputStream
    //   194: dup
    //   195: aload 5
    //   197: invokevirtual 321	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   200: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   203: invokespecial 327	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore_1
    //   207: sipush 8192
    //   210: newarray byte
    //   212: astore_3
    //   213: aload_0
    //   214: aload_3
    //   215: invokevirtual 333	java/io/InputStream:read	([B)I
    //   218: istore_2
    //   219: iload_2
    //   220: ifle +81 -> 301
    //   223: aload_1
    //   224: aload_3
    //   225: iconst_0
    //   226: iload_2
    //   227: invokevirtual 339	java/io/OutputStream:write	([BII)V
    //   230: goto -17 -> 213
    //   233: astore 4
    //   235: aload_0
    //   236: astore_3
    //   237: aload 4
    //   239: astore_0
    //   240: aload_3
    //   241: invokestatic 345	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   244: aload_1
    //   245: invokestatic 345	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   248: aload 5
    //   250: invokevirtual 348	android/os/ParcelFileDescriptor:close	()V
    //   253: aload_0
    //   254: athrow
    //   255: astore_0
    //   256: ldc 90
    //   258: iconst_2
    //   259: ldc_w 350
    //   262: aload_0
    //   263: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: iconst_0
    //   267: ireturn
    //   268: iload_2
    //   269: iconst_2
    //   270: if_icmpne +24 -> 294
    //   273: aload 5
    //   275: ldc_w 272
    //   278: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   281: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   284: invokevirtual 263	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   287: getstatic 359	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   290: astore_3
    //   291: goto -152 -> 139
    //   294: getstatic 362	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   297: astore_3
    //   298: goto -159 -> 139
    //   301: aload_1
    //   302: invokevirtual 365	java/io/OutputStream:flush	()V
    //   305: aload_0
    //   306: invokestatic 345	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   309: aload_1
    //   310: invokestatic 345	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   313: aload 5
    //   315: invokevirtual 348	android/os/ParcelFileDescriptor:close	()V
    //   318: iconst_1
    //   319: ireturn
    //   320: astore_0
    //   321: goto -3 -> 318
    //   324: astore_1
    //   325: goto -72 -> 253
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_1
    //   331: aload 4
    //   333: astore_3
    //   334: goto -94 -> 240
    //   337: astore 4
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_0
    //   342: astore_3
    //   343: aload 4
    //   345: astore_0
    //   346: goto -106 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramContext	Context
    //   0	349	1	paramFile	File
    //   27	244	2	i	int
    //   22	321	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   233	99	4	localObject3	Object
    //   337	7	4	localObject4	Object
    //   56	258	5	localObject5	Object
    //   47	51	6	str	String
    // Exception table:
    //   from	to	target	type
    //   207	213	233	finally
    //   213	219	233	finally
    //   223	230	233	finally
    //   301	305	233	finally
    //   23	28	255	java/lang/Throwable
    //   42	117	255	java/lang/Throwable
    //   121	139	255	java/lang/Throwable
    //   139	152	255	java/lang/Throwable
    //   156	166	255	java/lang/Throwable
    //   240	248	255	java/lang/Throwable
    //   253	255	255	java/lang/Throwable
    //   273	291	255	java/lang/Throwable
    //   294	298	255	java/lang/Throwable
    //   305	313	255	java/lang/Throwable
    //   313	318	320	java/lang/Throwable
    //   248	253	324	java/lang/Throwable
    //   171	187	328	finally
    //   187	207	337	finally
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      if (this.jdField_b_of_type_JavaUtilLinkedList.size() >= 2) {
        break label62;
      }
    }
    Long localLong;
    NetReq localNetReq;
    label62:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localLong = (Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localNetReq = (NetReq)this.jdField_a_of_type_JavaUtilMap.remove(localLong);
        if (localNetReq != null) {
          break;
        }
        b();
      }
      return;
    }
    bmsi localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
    if ((localbmsi == null) || (!a(localbmsi.c())) || (localbmsi.d()))
    {
      b();
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.add(localLong);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = bmth.a();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bmss(this, localLong, localNetReq));
  }
  
  public int a()
  {
    ??? = this.jdField_a_of_type_Bmsk.a();
    int i = ((bmsk)???).d;
    int j = ((bmsk)???).c;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bmst(this, localArrayList));
      }
      return j + i;
    }
  }
  
  public bmsi a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bmsi localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi == null) {
        return null;
      }
    }
    return bmsi.a(localObject.a(), localObject.a().a(), localObject.b(), localObject.a().a());
  }
  
  public bmsk a()
  {
    return this.jdField_a_of_type_Bmsk.a();
  }
  
  public String a(bmse parambmse, String paramString, bmsy parambmsy)
  {
    return b(parambmse, paramString, true, parambmsy);
  }
  
  public String a(bmse parambmse, String paramString, boolean paramBoolean, bmsy parambmsy)
  {
    return b(parambmse, paramString, paramBoolean, parambmsy);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, bmsy parambmsy)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new bmsp(this, parambmsy, i), Integer.toString(i));
    return Integer.toString(i);
  }
  
  void a(int paramInt, bmsi parambmsi)
  {
    if (parambmsi == null) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
      {
        this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.put(Long.valueOf(parambmsi.a()), Integer.toString(paramInt));
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)???).hasNext())
        {
          bmsy localbmsy = (bmsy)((Iterator)???).next();
          if (localbmsy != null) {
            localbmsy.a(Integer.toString(paramInt));
          }
        }
      }
    } while (parambmsi.a() == null);
    parambmsi.a().a(Integer.toString(paramInt));
  }
  
  public void a(int paramInt, bmsi parambmsi, String paramString)
  {
    for (;;)
    {
      bmsi localbmsi;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = parambmsi.a();
        localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
        if (localbmsi == null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), parambmsi);
          i = 1;
          a(paramInt, parambmsi);
          if (i != 0)
          {
            parambmsi.b(paramString);
            if (i == 0) {
              break label175;
            }
            a(parambmsi, 1, 0, null);
          }
        }
        else
        {
          if (!localbmsi.a().a()) {
            break label181;
          }
          parambmsi.a().jdField_a_of_type_Int = localbmsi.a().jdField_a_of_type_Int;
          parambmsi.a().jdField_b_of_type_Int = localbmsi.a().jdField_b_of_type_Int;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), parambmsi);
          i = 1;
        }
      }
      localbmsi.a(parambmsi.b());
      localbmsi.b(parambmsi.c());
      continue;
      label175:
      parambmsi = localbmsi;
      continue;
      label181:
      int i = 0;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    bmsi localbmsi;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi == null) {
        return;
      }
    }
    if (!localbmsi.d())
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        a(localbmsi, 5, 1810004, null);
        return;
      }
      a(localbmsi, 5, paramInt, paramString);
    }
  }
  
  public void a(long paramLong, bmsg parambmsg)
  {
    bmsi localbmsi;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi == null) {
        return;
      }
    }
    if (!localbmsi.d())
    {
      if ((parambmsg == null) || (TextUtils.isEmpty(parambmsg.c)))
      {
        a(localbmsi, 5, 1829002, null);
        return;
      }
      if (!a(localbmsi.c()))
      {
        a(localbmsi, 5, 1810004, null);
        return;
      }
      ??? = bmsi.a(localbmsi, parambmsg.c, localbmsi.d(), parambmsg.jdField_b_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix, this, a(localbmsi.d(), localbmsi.a().jdField_a_of_type_JavaLangString));
      localbmsi.a((HttpNetReq)???);
      localbmsi.a(parambmsg.e);
      localbmsi.a().d = parambmsg.e;
      a(paramLong, (NetReq)???);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, bmsi parambmsi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bmsi localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi != null) {
        a(localbmsi, 5, 1810002, null);
      }
      if (parambmsi != null)
      {
        parambmsi.a().jdField_a_of_type_Int = 0;
        parambmsi.a().jdField_b_of_type_Int = 1810002;
        a(parambmsi, true);
      }
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, bmsj parambmsj, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bmsi localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ??? = localbmsi;
      if (localbmsi != null) {
        break label66;
      }
      if (parambmsj == null) {
        parambmsj = null;
      }
    }
    parambmsj = parambmsj.jdField_a_of_type_Bmsi;
    label66:
    do
    {
      a((bmsi)???, paramBoolean2);
      return;
      ??? = parambmsj;
    } while (parambmsj != null);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    bmsi localbmsi;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbmsi = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi == null) {
        return;
      }
    }
    if (!localbmsi.d())
    {
      localbmsi.b(paramString);
      if (paramBoolean1)
      {
        a(localbmsi, 4, 0, null);
        return;
      }
      if (paramBoolean2)
      {
        a(localbmsi, 5, 1810008, null);
        return;
      }
      if (paramBoolean3)
      {
        a(localbmsi, 5, 1810031, null);
        return;
      }
      if (!a(localbmsi.c()))
      {
        a(localbmsi, 5, 1810004, null);
        return;
      }
      this.jdField_a_of_type_Bmte.a(localbmsi, DownloadType.FILE_ORDINARY.ordinal());
    }
  }
  
  void a(bmsi parambmsi, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bmsk.a();
    this.jdField_a_of_type_Bmsk.a(parambmsi, paramInt1, paramInt2);
  }
  
  void a(bmsi parambmsi, int paramInt1, int paramInt2, String paramString)
  {
    if (parambmsi == null) {}
    boolean bool;
    label47:
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        bool = true;
      }
    } while (!bool);
    int i = parambmsi.a().jdField_a_of_type_Int;
    parambmsi.a().jdField_a_of_type_Int = paramInt1;
    parambmsi.a().jdField_b_of_type_Int = paramInt2;
    parambmsi.a().jdField_a_of_type_JavaLangString = bmsh.a(paramInt2, paramString);
    this.jdField_a_of_type_Bmta.a(parambmsi, true);
    a(parambmsi, i, paramInt1);
    return;
    a(parambmsi.a());
    i = 1;
    paramInt1 = 1;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if ((i != 0) || (parambmsi.a().a()))
            {
              bool = true;
              label139:
              if (!bool) {
                break label793;
              }
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
              }
            }
            synchronized (this.jdField_b_of_type_JavaUtilHashSet)
            {
              this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
              parambmsi.c(false);
              this.jdField_a_of_type_Bmtc.a(parambmsi);
              break;
              bool = false;
              break label139;
              parambmsi = finally;
              throw parambmsi;
            }
          }
          bool = parambmsi.a().c();
          break;
          bool = parambmsi.a().b();
          if (!bool) {
            break label790;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashSet)
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
            parambmsi.c(true);
            parambmsi.b(false);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = bmth.a();
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.cancelReq(parambmsi.a());
            a(parambmsi.a());
          }
        }
        if (paramInt2 == 1810002) {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambmsi.a()));
            synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
            {
              this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(parambmsi.a()));
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
              }
            }
          }
        }
        for (;;)
        {
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
            parambmsi.c(true);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = bmth.a();
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.cancelReq(parambmsi.a());
            paramInt1 = 0;
            a(parambmsi.a());
            bool = true;
            break;
            parambmsi = finally;
            throw parambmsi;
            parambmsi = finally;
            throw parambmsi;
            parambmsi = finally;
            throw parambmsi;
          }
          if ((paramInt2 == 1810003) || (paramInt2 == 1810004)) {
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(parambmsi.a()));
              paramInt1 = 1;
            }
          }
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(parambmsi.a()));
          }
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambmsi.a()));
          synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
          {
            this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(parambmsi.a()));
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
            }
          }
        }
        synchronized (this.jdField_b_of_type_JavaUtilHashSet)
        {
          this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambmsi.a()));
          parambmsi.a().jdField_b_of_type_JavaLangString = parambmsi.d();
          parambmsi.a().jdField_b_of_type_Long = parambmsi.a().jdField_a_of_type_Long;
          parambmsi.a().jdField_a_of_type_Bmsi = parambmsi;
          a(parambmsi.a());
          break;
          parambmsi = finally;
          throw parambmsi;
          parambmsi = finally;
          throw parambmsi;
          parambmsi = finally;
          throw parambmsi;
        }
      }
      label790:
      break label47;
      label793:
      break label47;
      i = 0;
    }
  }
  
  void a(bmsi parambmsi, boolean paramBoolean)
  {
    if (parambmsi == null) {}
    do
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext())
      {
        bmsy localbmsy = (bmsy)localIterator.next();
        if (localbmsy != null) {
          localbmsy.a(parambmsi.a(), parambmsi.a(), parambmsi.b(), paramBoolean);
        }
      }
    } while (parambmsi.a() == null);
    parambmsi.a().a(parambmsi.a(), parambmsi.a(), parambmsi.b(), paramBoolean);
  }
  
  public void a(bmsy parambmsy)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambmsy);
  }
  
  public void a(bmsz parambmsz, Context paramContext)
  {
    this.jdField_a_of_type_Bmsz = parambmsz;
    if (this.jdField_a_of_type_Bmsz == null) {
      throw new NullPointerException("IFetchListener can not be null!");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    parambmsz = new ReleaseLooperHandler("weiyun_download-work-thread");
    this.jdField_a_of_type_Bmta = new bmta(this, parambmsz);
    this.jdField_a_of_type_Bmtc = new bmtc(this, parambmsz);
    this.jdField_a_of_type_Bmte = new bmte(this, this.jdField_a_of_type_Bmsz, parambmsz);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmta.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, bmsx parambmsx)
  {
    a(paramString1, paramString2, null, paramString3, parambmsx, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, bmsx parambmsx, String paramString5)
  {
    paramString1 = bmsi.a(paramString4, paramString1, paramString2, paramString3, jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix, new bmsq(this, parambmsx, paramString4, paramString2));
    if (this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine = bmth.b();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bmsr(this, paramString1));
    if (paramString5 != null) {
      this.jdField_b_of_type_JavaUtilMap.put(paramString5, paramString1);
    }
  }
  
  public void a(String arg1, List<bmsi> paramList)
  {
    if ((!TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    for (;;)
    {
      bmsi localbmsi;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label199;
        }
        localbmsi = (bmsi)paramList.next();
        long l = localbmsi.a();
        int i = localbmsi.a().jdField_a_of_type_Int;
        localbmsi.a().jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localbmsi);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
          a(localbmsi, 1, 0, null);
        }
      }
      a(localbmsi, 3, 0, null);
      continue;
      a(localbmsi, 5, localbmsi.a().jdField_b_of_type_Int, localbmsi.a().jdField_a_of_type_JavaLangString);
      continue;
      label199:
      return;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashSet);
        ??? = localArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          return;
        }
        a(((Long)((Iterator)???).next()).longValue(), false, false, false, false);
      }
    }
    for (;;)
    {
      bmsi localbmsi;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localbmsi = (bmsi)((Map.Entry)localIterator.next()).getValue();
        if ((!localbmsi.c()) || (!paramBoolean2))
        {
          if (!localbmsi.a().b()) {
            continue;
          }
          localbmsi.c(true);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine != null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.cancelReq(localbmsi.a());
          }
          a(localbmsi, 5, 1810004, null);
        }
      }
      if ((localbmsi.c()) && (paramBoolean2) && (localbmsi.a().d())) {
        a(localbmsi.a(), false, false, false, false);
      }
    }
  }
  
  public boolean a()
  {
    bmsk localbmsk = this.jdField_a_of_type_Bmsk.a();
    int i = localbmsk.jdField_a_of_type_Int;
    return localbmsk.jdField_b_of_type_Int + i > 0;
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bmsi localbmsi1 = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    a(localbmsi2, 3, 0, null);
    return true;
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bmsi localbmsi1 = (bmsi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbmsi1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1)
    {
      localbmsi2.a(paramBoolean2);
      localbmsi2.b(paramBoolean3);
    }
    a(localbmsi2, 1, 0, null);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine != null)
    {
      ??? = (HttpNetReq)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (??? != null) {
        this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine.cancelReq((NetReq)???);
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
    {
      paramString = (Long)this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.getByValue(paramString);
      if (paramString == null) {
        return false;
      }
    }
    this.jdField_a_of_type_Bmta.a(paramString.longValue(), true);
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    if ((paramBoolean) || (!bool)) {
      return NetworkUtils.isNetworkAvailable(localContext);
    }
    return NetworkUtils.isWifiAvailable(localContext);
  }
  
  public int b()
  {
    ??? = this.jdField_a_of_type_Bmsk.a();
    int i = ((bmsk)???).d;
    int j = ((bmsk)???).jdField_a_of_type_Int;
    int k = ((bmsk)???).jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bmsu(this, localArrayList));
      }
      return k + (i + j);
    }
  }
  
  String b(bmse parambmse, String paramString, boolean paramBoolean, bmsy parambmsy)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    paramString = bmsi.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), parambmse, paramString, new bmsj());
    paramString.b(paramBoolean);
    paramString.a().c = parambmse.jdField_a_of_type_JavaLangString;
    paramString.a(parambmsy);
    this.jdField_a_of_type_Bmta.a(i, paramString);
    return Integer.toString(i);
  }
  
  public void b(bmsy parambmsy)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(parambmsy)) {
      this.jdField_a_of_type_JavaUtilList.remove(parambmsy);
    }
  }
  
  public boolean b(long paramLong)
  {
    this.jdField_a_of_type_Bmta.a(paramLong, true);
    return true;
  }
  
  public int c()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaUtilHashSet)
    {
      int i = this.jdField_b_of_type_JavaUtilHashSet.size();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilHashSet);
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bmsv(this, localArrayList));
      }
      return i;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {}
    int j;
    label125:
    do
    {
      return;
      if (paramNetResp.mResult == 0) {}
      for (int i = 1;; i = 0)
      {
        j = paramNetResp.mErrCode;
        paramNetResp = ((HttpNetReq)paramNetResp.mReq).getUserData();
        if ((paramNetResp == null) || (!(paramNetResp instanceof bmsi))) {
          break;
        }
        paramNetResp = (bmsi)paramNetResp;
        if ((paramNetResp == null) || (paramNetResp.d())) {
          break;
        }
        if (i == 0) {
          break label136;
        }
        File localFile = new File(paramNetResp.d());
        if (!localFile.exists()) {
          break label125;
        }
        if (!a(WeiyunTransmissionGlobal.getInstance().getContext(), localFile)) {
          IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
        }
        a(paramNetResp, 4, 0, null);
        return;
      }
      a(paramNetResp, 5, 1810031, null);
      return;
    } while (paramNetResp.d());
    label136:
    if (bmsh.a(j))
    {
      a(paramNetResp, 0, j, null);
      return;
    }
    a(paramNetResp, 5, j, null);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = paramNetReq.getUserData();
    if ((paramNetReq != null) && ((paramNetReq instanceof bmsi)))
    {
      paramNetReq = (bmsi)paramNetReq;
      if (paramNetReq != null) {
        break label26;
      }
    }
    label26:
    while (paramNetReq.d()) {
      return;
    }
    if (paramNetReq.a().c()) {
      a(paramNetReq, 2, 0, null);
    }
    paramNetReq.a().jdField_a_of_type_Long = paramLong2;
    bmsj localbmsj = paramNetReq.a();
    if (paramLong1 < paramLong2) {}
    for (;;)
    {
      localbmsj.jdField_b_of_type_Long = paramLong1;
      a(paramNetReq, false);
      return;
      paramLong1 = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsl
 * JD-Core Version:    0.7.0.1
 */