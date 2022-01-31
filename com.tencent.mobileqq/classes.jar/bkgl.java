import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
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

public class bkgl
  implements bapx, bkhb, bkhd, bkhg
{
  static bapw jdField_a_of_type_Bapw = new bkgn();
  private static Singleton<bkgl, Void> jdField_a_of_type_ComTencentWeiyunUtilsSingleton;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Context jdField_a_of_type_AndroidContentContext;
  private bapv jdField_a_of_type_Bapv;
  private final bkgk jdField_a_of_type_Bkgk = new bkgk();
  private bkgz jdField_a_of_type_Bkgz;
  private bkha jdField_a_of_type_Bkha;
  private bkhc jdField_a_of_type_Bkhc;
  private bkhe jdField_a_of_type_Bkhe;
  private final ThreadPoolWrapper jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper = new ThreadPoolWrapper("WyDownloader");
  private final DualHashMap<Long, String> jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap = new DualHashMap();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<Long, bkgi> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<bkgy> jdField_a_of_type_JavaUtilList;
  private Map<Long, baqv> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bapv jdField_b_of_type_Bapv;
  private final HashSet<Long> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, baps> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new bkgm();
  }
  
  private bkgl()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, new bkgo(this));
  }
  
  public static bkgl a()
  {
    return (bkgl)jdField_a_of_type_ComTencentWeiyunUtilsSingleton.get(null);
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
        localObject = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if ((localObject == null) || (((bkgi)localObject).d())) {
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
  
  private void a(long paramLong, baqv parambaqv)
  {
    if (parambaqv == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Long.valueOf(paramLong));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), parambaqv);
      a();
      b();
      return;
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bkgi localbkgi1 = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1) {
      localbkgi2.a(paramBoolean2);
    }
    if (paramBoolean3) {
      localbkgi2.b(paramBoolean4);
    }
    a(localbkgi2, 1, 0, null);
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
    //   7: invokestatic 222	bkib:a	()Ljava/lang/String;
    //   10: invokevirtual 228	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 231	java/io/File:getName	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: invokestatic 236	arni:a	(Ljava/lang/String;)I
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
    //   44: invokestatic 241	bavn:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: new 243	android/content/ContentValues
    //   52: dup
    //   53: invokespecial 244	android/content/ContentValues:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc 246
    //   62: aload_3
    //   63: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload 5
    //   68: ldc 251
    //   70: aload_3
    //   71: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 5
    //   76: ldc 253
    //   78: aload_1
    //   79: invokevirtual 257	java/io/File:lastModified	()J
    //   82: ldc2_w 258
    //   85: ldiv
    //   86: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload 5
    //   94: ldc_w 264
    //   97: aload 6
    //   99: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 5
    //   104: ldc_w 266
    //   107: aload_1
    //   108: invokevirtual 269	java/io/File:length	()J
    //   111: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   117: iload_2
    //   118: ifne +142 -> 260
    //   121: aload 5
    //   123: ldc_w 271
    //   126: invokestatic 276	java/lang/System:currentTimeMillis	()J
    //   129: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   135: getstatic 282	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   138: astore_3
    //   139: aload_0
    //   140: invokevirtual 288	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   143: astore_0
    //   144: aload_0
    //   145: aload_3
    //   146: aload 5
    //   148: invokevirtual 294	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull -137 -> 16
    //   156: aload_0
    //   157: aload_3
    //   158: ldc_w 296
    //   161: invokevirtual 300	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   164: astore_3
    //   165: aload_3
    //   166: ifnull -150 -> 16
    //   169: new 302	java/io/BufferedInputStream
    //   172: dup
    //   173: new 304	java/io/FileInputStream
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   181: invokespecial 310	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   184: astore_0
    //   185: new 312	java/io/BufferedOutputStream
    //   188: dup
    //   189: new 314	java/io/FileOutputStream
    //   192: dup
    //   193: aload_3
    //   194: invokevirtual 320	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   197: invokespecial 323	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   200: invokespecial 326	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   203: astore_1
    //   204: sipush 8192
    //   207: newarray byte
    //   209: astore_3
    //   210: aload_0
    //   211: aload_3
    //   212: invokevirtual 332	java/io/InputStream:read	([B)I
    //   215: istore_2
    //   216: iload_2
    //   217: ifle +76 -> 293
    //   220: aload_1
    //   221: aload_3
    //   222: iconst_0
    //   223: iload_2
    //   224: invokevirtual 338	java/io/OutputStream:write	([BII)V
    //   227: goto -17 -> 210
    //   230: astore 4
    //   232: aload_0
    //   233: astore_3
    //   234: aload 4
    //   236: astore_0
    //   237: aload_3
    //   238: invokestatic 344	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   241: aload_1
    //   242: invokestatic 344	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: ldc 90
    //   250: iconst_2
    //   251: ldc_w 346
    //   254: aload_0
    //   255: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: iconst_0
    //   259: ireturn
    //   260: iload_2
    //   261: iconst_2
    //   262: if_icmpne +24 -> 286
    //   265: aload 5
    //   267: ldc_w 271
    //   270: invokestatic 276	java/lang/System:currentTimeMillis	()J
    //   273: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   279: getstatic 355	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   282: astore_3
    //   283: goto -144 -> 139
    //   286: getstatic 358	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   289: astore_3
    //   290: goto -151 -> 139
    //   293: aload_1
    //   294: invokevirtual 361	java/io/OutputStream:flush	()V
    //   297: aload_0
    //   298: invokestatic 344	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   301: aload_1
    //   302: invokestatic 344	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   305: iconst_1
    //   306: ireturn
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_1
    //   310: aload 4
    //   312: astore_3
    //   313: goto -76 -> 237
    //   316: astore 4
    //   318: aconst_null
    //   319: astore_1
    //   320: aload_0
    //   321: astore_3
    //   322: aload 4
    //   324: astore_0
    //   325: goto -88 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   0	328	1	paramFile	File
    //   27	236	2	i	int
    //   22	300	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   230	81	4	localObject3	Object
    //   316	7	4	localObject4	Object
    //   56	210	5	localContentValues	android.content.ContentValues
    //   47	51	6	str	String
    // Exception table:
    //   from	to	target	type
    //   204	210	230	finally
    //   210	216	230	finally
    //   220	227	230	finally
    //   293	297	230	finally
    //   23	28	247	java/lang/Throwable
    //   42	117	247	java/lang/Throwable
    //   121	139	247	java/lang/Throwable
    //   139	152	247	java/lang/Throwable
    //   156	165	247	java/lang/Throwable
    //   237	247	247	java/lang/Throwable
    //   265	283	247	java/lang/Throwable
    //   286	290	247	java/lang/Throwable
    //   297	305	247	java/lang/Throwable
    //   169	185	307	finally
    //   185	204	316	finally
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      if (this.jdField_b_of_type_JavaUtilLinkedList.size() >= 2) {
        break label62;
      }
    }
    Long localLong;
    baqv localbaqv;
    label62:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localLong = (Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localbaqv = (baqv)this.jdField_a_of_type_JavaUtilMap.remove(localLong);
        if (localbaqv != null) {
          break;
        }
        b();
      }
      return;
    }
    bkgi localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
    if ((localbkgi == null) || (!a(localbkgi.c())) || (localbkgi.d()))
    {
      b();
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.add(localLong);
    if (this.jdField_a_of_type_Bapv == null) {
      this.jdField_a_of_type_Bapv = bkhh.a();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bkgs(this, localLong, localbaqv));
  }
  
  public int a()
  {
    ??? = this.jdField_a_of_type_Bkgk.a();
    int i = ((bkgk)???).d;
    int j = ((bkgk)???).c;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bkgt(this, localArrayList));
      }
      return j + i;
    }
  }
  
  public bkgi a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bkgi localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi == null) {
        return null;
      }
    }
    return bkgi.a(localObject.a(), localObject.a().a(), localObject.b(), localObject.a().a());
  }
  
  public bkgk a()
  {
    return this.jdField_a_of_type_Bkgk.a();
  }
  
  public String a(bkge parambkge, String paramString, bkgy parambkgy)
  {
    return b(parambkge, paramString, true, parambkgy);
  }
  
  public String a(bkge parambkge, String paramString, boolean paramBoolean, bkgy parambkgy)
  {
    return b(parambkge, paramString, paramBoolean, parambkgy);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, bkgy parambkgy)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new bkgp(this, parambkgy, i), Integer.toString(i));
    return Integer.toString(i);
  }
  
  void a(int paramInt, bkgi parambkgi)
  {
    if (parambkgi == null) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
      {
        this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.put(Long.valueOf(parambkgi.a()), Integer.toString(paramInt));
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)???).hasNext())
        {
          bkgy localbkgy = (bkgy)((Iterator)???).next();
          if (localbkgy != null) {
            localbkgy.a(Integer.toString(paramInt));
          }
        }
      }
    } while (parambkgi.a() == null);
    parambkgi.a().a(Integer.toString(paramInt));
  }
  
  public void a(int paramInt, bkgi parambkgi, String paramString)
  {
    for (;;)
    {
      bkgi localbkgi;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = parambkgi.a();
        localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
        if (localbkgi == null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), parambkgi);
          i = 1;
          a(paramInt, parambkgi);
          if (i != 0)
          {
            parambkgi.b(paramString);
            if (i == 0) {
              break label175;
            }
            a(parambkgi, 1, 0, null);
          }
        }
        else
        {
          if (!localbkgi.a().a()) {
            break label181;
          }
          parambkgi.a().jdField_a_of_type_Int = localbkgi.a().jdField_a_of_type_Int;
          parambkgi.a().jdField_b_of_type_Int = localbkgi.a().jdField_b_of_type_Int;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), parambkgi);
          i = 1;
        }
      }
      localbkgi.a(parambkgi.b());
      localbkgi.b(parambkgi.c());
      continue;
      label175:
      parambkgi = localbkgi;
      continue;
      label181:
      int i = 0;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    bkgi localbkgi;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi == null) {
        return;
      }
    }
    if (!localbkgi.d())
    {
      if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
      {
        a(localbkgi, 5, 1810004, null);
        return;
      }
      a(localbkgi, 5, paramInt, paramString);
    }
  }
  
  public void a(long paramLong, bkgg parambkgg)
  {
    bkgi localbkgi;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi == null) {
        return;
      }
    }
    if (!localbkgi.d())
    {
      if ((parambkgg == null) || (TextUtils.isEmpty(parambkgg.c)))
      {
        a(localbkgi, 5, 1829002, null);
        return;
      }
      if (!a(localbkgi.c()))
      {
        a(localbkgi, 5, 1810004, null);
        return;
      }
      ??? = bkgi.a(localbkgi, parambkgg.c, localbkgi.d(), parambkgg.jdField_b_of_type_JavaLangString, jdField_a_of_type_Bapw, this, a(localbkgi.d(), localbkgi.a().jdField_a_of_type_JavaLangString));
      localbkgi.a((baps)???);
      localbkgi.a(parambkgg.e);
      localbkgi.a().d = parambkgg.e;
      a(paramLong, (baqv)???);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, bkgi parambkgi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bkgi localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi != null) {
        a(localbkgi, 5, 1810002, null);
      }
      if (parambkgi != null)
      {
        parambkgi.a().jdField_a_of_type_Int = 0;
        parambkgi.a().jdField_b_of_type_Int = 1810002;
        a(parambkgi, true);
      }
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, bkgj parambkgj, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bkgi localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ??? = localbkgi;
      if (localbkgi != null) {
        break label66;
      }
      if (parambkgj == null) {
        parambkgj = null;
      }
    }
    parambkgj = parambkgj.jdField_a_of_type_Bkgi;
    label66:
    do
    {
      a((bkgi)???, paramBoolean2);
      return;
      ??? = parambkgj;
    } while (parambkgj != null);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    bkgi localbkgi;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbkgi = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi == null) {
        return;
      }
    }
    if (!localbkgi.d())
    {
      localbkgi.b(paramString);
      if (paramBoolean1)
      {
        a(localbkgi, 4, 0, null);
        return;
      }
      if (paramBoolean2)
      {
        a(localbkgi, 5, 1810008, null);
        return;
      }
      if (paramBoolean3)
      {
        a(localbkgi, 5, 1810031, null);
        return;
      }
      if (!a(localbkgi.c()))
      {
        a(localbkgi, 5, 1810004, null);
        return;
      }
      this.jdField_a_of_type_Bkhe.a(localbkgi, DownloadType.FILE_ORDINARY.ordinal());
    }
  }
  
  void a(bkgi parambkgi, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bkgk.a();
    this.jdField_a_of_type_Bkgk.a(parambkgi, paramInt1, paramInt2);
  }
  
  void a(bkgi parambkgi, int paramInt1, int paramInt2, String paramString)
  {
    if (parambkgi == null) {}
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
    int i = parambkgi.a().jdField_a_of_type_Int;
    parambkgi.a().jdField_a_of_type_Int = paramInt1;
    parambkgi.a().jdField_b_of_type_Int = paramInt2;
    parambkgi.a().jdField_a_of_type_JavaLangString = bkgh.a(paramInt2, paramString);
    this.jdField_a_of_type_Bkha.a(parambkgi, true);
    a(parambkgi, i, paramInt1);
    return;
    a(parambkgi.a());
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
            if ((i != 0) || (parambkgi.a().a()))
            {
              bool = true;
              label139:
              if (!bool) {
                break label793;
              }
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
              }
            }
            synchronized (this.jdField_b_of_type_JavaUtilHashSet)
            {
              this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
              parambkgi.c(false);
              this.jdField_a_of_type_Bkhc.a(parambkgi);
              break;
              bool = false;
              break label139;
              parambkgi = finally;
              throw parambkgi;
            }
          }
          bool = parambkgi.a().c();
          break;
          bool = parambkgi.a().b();
          if (!bool) {
            break label790;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashSet)
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
            parambkgi.c(true);
            parambkgi.b(false);
            if (this.jdField_a_of_type_Bapv == null) {
              this.jdField_a_of_type_Bapv = bkhh.a();
            }
            this.jdField_a_of_type_Bapv.b(parambkgi.a());
            a(parambkgi.a());
          }
        }
        if (paramInt2 == 1810002) {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambkgi.a()));
            synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
            {
              this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(parambkgi.a()));
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
              }
            }
          }
        }
        for (;;)
        {
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
            parambkgi.c(true);
            if (this.jdField_a_of_type_Bapv == null) {
              this.jdField_a_of_type_Bapv = bkhh.a();
            }
            this.jdField_a_of_type_Bapv.b(parambkgi.a());
            paramInt1 = 0;
            a(parambkgi.a());
            bool = true;
            break;
            parambkgi = finally;
            throw parambkgi;
            parambkgi = finally;
            throw parambkgi;
            parambkgi = finally;
            throw parambkgi;
          }
          if ((paramInt2 == 1810003) || (paramInt2 == 1810004)) {
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(parambkgi.a()));
              paramInt1 = 1;
            }
          }
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(parambkgi.a()));
          }
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambkgi.a()));
          synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
          {
            this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(parambkgi.a()));
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
            }
          }
        }
        synchronized (this.jdField_b_of_type_JavaUtilHashSet)
        {
          this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambkgi.a()));
          parambkgi.a().jdField_b_of_type_JavaLangString = parambkgi.d();
          parambkgi.a().jdField_b_of_type_Long = parambkgi.a().jdField_a_of_type_Long;
          parambkgi.a().jdField_a_of_type_Bkgi = parambkgi;
          a(parambkgi.a());
          break;
          parambkgi = finally;
          throw parambkgi;
          parambkgi = finally;
          throw parambkgi;
          parambkgi = finally;
          throw parambkgi;
        }
      }
      label790:
      break label47;
      label793:
      break label47;
      i = 0;
    }
  }
  
  void a(bkgi parambkgi, boolean paramBoolean)
  {
    if (parambkgi == null) {}
    do
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext())
      {
        bkgy localbkgy = (bkgy)localIterator.next();
        if (localbkgy != null) {
          localbkgy.a(parambkgi.a(), parambkgi.a(), parambkgi.b(), paramBoolean);
        }
      }
    } while (parambkgi.a() == null);
    parambkgi.a().a(parambkgi.a(), parambkgi.a(), parambkgi.b(), paramBoolean);
  }
  
  public void a(bkgy parambkgy)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambkgy);
  }
  
  public void a(bkgz parambkgz, Context paramContext)
  {
    this.jdField_a_of_type_Bkgz = parambkgz;
    if (this.jdField_a_of_type_Bkgz == null) {
      throw new NullPointerException("IFetchListener can not be null!");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    parambkgz = new ReleaseLooperHandler("weiyun_download-work-thread");
    this.jdField_a_of_type_Bkha = new bkha(this, parambkgz);
    this.jdField_a_of_type_Bkhc = new bkhc(this, parambkgz);
    this.jdField_a_of_type_Bkhe = new bkhe(this, this.jdField_a_of_type_Bkgz, parambkgz);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkha.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, bkgx parambkgx)
  {
    a(paramString1, paramString2, null, paramString3, parambkgx, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, bkgx parambkgx, String paramString5)
  {
    paramString1 = bkgi.a(paramString4, paramString1, paramString2, paramString3, jdField_a_of_type_Bapw, new bkgq(this, parambkgx, paramString4, paramString2));
    if (this.jdField_b_of_type_Bapv == null) {
      this.jdField_b_of_type_Bapv = bkhh.b();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bkgr(this, paramString1));
    if (paramString5 != null) {
      this.jdField_b_of_type_JavaUtilMap.put(paramString5, paramString1);
    }
  }
  
  public void a(String arg1, List<bkgi> paramList)
  {
    if ((!TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    for (;;)
    {
      bkgi localbkgi;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label199;
        }
        localbkgi = (bkgi)paramList.next();
        long l = localbkgi.a();
        int i = localbkgi.a().jdField_a_of_type_Int;
        localbkgi.a().jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localbkgi);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
          a(localbkgi, 1, 0, null);
        }
      }
      a(localbkgi, 3, 0, null);
      continue;
      a(localbkgi, 5, localbkgi.a().jdField_b_of_type_Int, localbkgi.a().jdField_a_of_type_JavaLangString);
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
      bkgi localbkgi;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localbkgi = (bkgi)((Map.Entry)localIterator.next()).getValue();
        if ((!localbkgi.c()) || (!paramBoolean2))
        {
          if (!localbkgi.a().b()) {
            continue;
          }
          localbkgi.c(true);
          if (this.jdField_a_of_type_Bapv != null) {
            this.jdField_a_of_type_Bapv.b(localbkgi.a());
          }
          a(localbkgi, 5, 1810004, null);
        }
      }
      if ((localbkgi.c()) && (paramBoolean2) && (localbkgi.a().d())) {
        a(localbkgi.a(), false, false, false, false);
      }
    }
  }
  
  public boolean a()
  {
    bkgk localbkgk = this.jdField_a_of_type_Bkgk.a();
    int i = localbkgk.jdField_a_of_type_Int;
    return localbkgk.jdField_b_of_type_Int + i > 0;
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bkgi localbkgi1 = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    a(localbkgi2, 3, 0, null);
    return true;
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bkgi localbkgi1 = (bkgi)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbkgi1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1)
    {
      localbkgi2.a(paramBoolean2);
      localbkgi2.b(paramBoolean3);
    }
    a(localbkgi2, 1, 0, null);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_b_of_type_Bapv != null)
    {
      ??? = (baps)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (??? != null) {
        this.jdField_b_of_type_Bapv.b((baqv)???);
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
    {
      paramString = (Long)this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.getByValue(paramString);
      if (paramString == null) {
        return false;
      }
    }
    this.jdField_a_of_type_Bkha.a(paramString.longValue(), true);
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
    ??? = this.jdField_a_of_type_Bkgk.a();
    int i = ((bkgk)???).d;
    int j = ((bkgk)???).jdField_a_of_type_Int;
    int k = ((bkgk)???).jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bkgu(this, localArrayList));
      }
      return k + (i + j);
    }
  }
  
  String b(bkge parambkge, String paramString, boolean paramBoolean, bkgy parambkgy)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    paramString = bkgi.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), parambkge, paramString, new bkgj());
    paramString.b(paramBoolean);
    paramString.a().c = parambkge.jdField_a_of_type_JavaLangString;
    paramString.a(parambkgy);
    this.jdField_a_of_type_Bkha.a(i, paramString);
    return Integer.toString(i);
  }
  
  public void b(bkgy parambkgy)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(parambkgy)) {
      this.jdField_a_of_type_JavaUtilList.remove(parambkgy);
    }
  }
  
  public boolean b(long paramLong)
  {
    this.jdField_a_of_type_Bkha.a(paramLong, true);
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
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bkgv(this, localArrayList));
      }
      return i;
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3) {}
    int j;
    label125:
    do
    {
      return;
      if (parambaqw.jdField_a_of_type_Int == 0) {}
      for (int i = 1;; i = 0)
      {
        j = parambaqw.jdField_b_of_type_Int;
        parambaqw = ((baps)parambaqw.jdField_a_of_type_Baqv).a();
        if ((parambaqw == null) || (!(parambaqw instanceof bkgi))) {
          break;
        }
        parambaqw = (bkgi)parambaqw;
        if ((parambaqw == null) || (parambaqw.d())) {
          break;
        }
        if (i == 0) {
          break label136;
        }
        File localFile = new File(parambaqw.d());
        if (!localFile.exists()) {
          break label125;
        }
        if (!a(WeiyunTransmissionGlobal.getInstance().getContext(), localFile)) {
          IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
        }
        a(parambaqw, 4, 0, null);
        return;
      }
      a(parambaqw, 5, 1810031, null);
      return;
    } while (parambaqw.d());
    label136:
    if (bkgh.a(j))
    {
      a(parambaqw, 0, j, null);
      return;
    }
    a(parambaqw, 5, j, null);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    parambaqv = parambaqv.a();
    if ((parambaqv != null) && ((parambaqv instanceof bkgi)))
    {
      parambaqv = (bkgi)parambaqv;
      if (parambaqv != null) {
        break label26;
      }
    }
    label26:
    while (parambaqv.d()) {
      return;
    }
    if (parambaqv.a().c()) {
      a(parambaqv, 2, 0, null);
    }
    parambaqv.a().jdField_a_of_type_Long = paramLong2;
    bkgj localbkgj = parambaqv.a();
    if (paramLong1 < paramLong2) {}
    for (;;)
    {
      localbkgj.jdField_b_of_type_Long = paramLong1;
      a(parambaqv, false);
      return;
      paramLong1 = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgl
 * JD-Core Version:    0.7.0.1
 */