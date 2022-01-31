import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class azpt
{
  private static volatile Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static volatile azpt jdField_a_of_type_Azpt;
  private static final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(azps.class, 50);
  public static final String[] a;
  public static final String[] b;
  private long jdField_a_of_type_Long;
  private azpv jdField_a_of_type_Azpv = new azpv(null);
  private azpw jdField_a_of_type_Azpw = new azpw(null);
  private String jdField_a_of_type_JavaLangString = "";
  private Field jdField_a_of_type_JavaLangReflectField;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private ArrayList<azps> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private boolean jdField_a_of_type_Boolean = true;
  private Field jdField_b_of_type_JavaLangReflectField;
  private ArrayList<azps> jdField_b_of_type_JavaUtilArrayList = new ArrayList(40);
  private boolean jdField_b_of_type_Boolean;
  private ArrayList<azps> c = new ArrayList(7);
  private ArrayList<azps> d = new ArrayList(7);
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "sdcard/Tencent/MobileQQ", "sdcard/Tencent/QQ_Images", "sdcard/Tencent/QQfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/QQ_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business", "sdcard/Tencent/msflogs" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "data/data/com.tencent.mobileqq", "data/data/com.tencent.mobileqq/files" };
  }
  
  private azpt()
  {
    if (0.001000000047497451D >= Math.random()) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private long a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    File localFile;
    do
    {
      return 0L;
      localFile = new File(paramString1 + "/" + paramString2);
    } while (localFile.isDirectory());
    azps localazps = (azps)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(azps.class);
    localazps.jdField_a_of_type_JavaLangString = paramString2;
    localazps.jdField_a_of_type_Boolean = true;
    localazps.jdField_a_of_type_Long = localFile.length();
    localazps.jdField_b_of_type_JavaLangString = (paramString1 + "/" + paramString2);
    localazps.jdField_b_of_type_Long = a(localFile);
    localazps.c = 1L;
    if (localazps.jdField_a_of_type_Long >= 524288.0D) {
      QLog.d("StorageReport", 1, "--scan qq-- file info: " + localazps.toString());
    }
    if (localazps.jdField_a_of_type_Long >= 2097152L) {
      a(localazps);
    }
    a(localazps, localazps.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 20)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localazps);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 20) {
        Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Azpv);
      }
      return localazps.jdField_a_of_type_Long;
    }
    paramString1 = (azps)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 20) && (localazps.jdField_b_of_type_Long > paramString1.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localazps);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Azpv);
      return localazps.jdField_a_of_type_Long;
    }
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(localazps);
    return localazps.jdField_a_of_type_Long;
  }
  
  private Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    Stack localStack = new Stack();
    localStack.push(paramString);
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    if (!localStack.isEmpty())
    {
      paramString = new File((String)localStack.pop());
      long l4;
      if (paramString.isDirectory())
      {
        String[] arrayOfString = paramString.list();
        long l5;
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          l4 = l1;
          l5 = l2;
          l1 = l4;
          if (i < j)
          {
            String str = arrayOfString[i];
            File localFile = new File(paramString, str);
            if (localFile.isDirectory()) {
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break;
              a(paramString.getAbsolutePath(), str);
              l4 += localFile.length();
              l2 += 1L;
            }
          }
        }
        else
        {
          l5 = l2;
        }
        l2 = l5;
        l3 += 1L;
        l4 = l1;
        l1 = l3;
      }
      for (;;)
      {
        l4 += paramString.length();
        l3 = l1;
        l1 = l4;
        break;
        a(paramString.getParent(), paramString.getName());
        l4 = l1;
        l1 = l3;
        l2 = 1L + l2;
      }
    }
    localBundle.putLong("key_size", l1);
    localBundle.putLong("key_file_count", l2);
    localBundle.putLong("key_dir_count", l3);
    return localBundle;
  }
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_AndroidOsHandler == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SETTING_STORAGE_CLEAN_SCAN", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static azpt a()
  {
    if (jdField_a_of_type_Azpt == null) {}
    try
    {
      if (jdField_a_of_type_Azpt == null) {
        jdField_a_of_type_Azpt = new azpt();
      }
      return jdField_a_of_type_Azpt;
    }
    finally {}
  }
  
  private String a(ArrayList<azps> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = 0;
    while (i < paramArrayList.size())
    {
      azps localazps = (azps)paramArrayList.get(i);
      localStringBuilder.append(localazps.c);
      localStringBuilder.append("-").append(localazps.jdField_a_of_type_Long);
      if (i < paramArrayList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_AndroidOsHandler != null)
      {
        jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
        jdField_a_of_type_AndroidOsHandler = null;
      }
      if (jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        jdField_a_of_type_AndroidOsHandlerThread.quit();
        jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      return;
    }
    finally {}
  }
  
  private void a(azps paramazps)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("report_key", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("path", paramazps.jdField_b_of_type_JavaLangString);
    localHashMap.put("name", paramazps.jdField_a_of_type_JavaLangString);
    localHashMap.put("size", String.valueOf(paramazps.jdField_a_of_type_Long));
    localHashMap.put("accessTime", String.valueOf(paramazps.jdField_b_of_type_Long));
    localHashMap.put("isFile", String.valueOf(paramazps.jdField_a_of_type_Boolean));
    localHashMap.put("fileCount", String.valueOf(paramazps.c));
    localHashMap.put("dirCount", String.valueOf(paramazps.d));
    if (QLog.isColorLevel()) {
      QLog.d("StorageReport", 2, "--scan qq-- file report to tdw : report key = " + this.jdField_a_of_type_JavaLangString + ",item info=" + paramazps.toString());
    }
    azmz.a(BaseApplicationImpl.getApplication()).a(null, "qqStorageReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(azps paramazps, long paramLong)
  {
    int i = 0;
    if ((paramazps == null) || (TextUtils.isEmpty(paramazps.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (paramLong < 10240L) {
      if (!paramazps.jdField_b_of_type_JavaLangString.contains("data/data/com.tencent.mobileqq")) {
        break label197;
      }
    }
    label197:
    for (paramazps = (azps)this.d.get(i);; paramazps = (azps)this.c.get(i))
    {
      paramazps.jdField_a_of_type_Long += paramLong;
      paramazps.c += 1L;
      return;
      if ((paramLong >= 10240L) && (paramLong < 102400L))
      {
        i = 1;
        break;
      }
      if ((paramLong >= 102400L) && (paramLong < 1048576L))
      {
        i = 2;
        break;
      }
      if ((paramLong >= 1048576L) && (paramLong < 2097152L))
      {
        i = 3;
        break;
      }
      if ((paramLong >= 2097152L) && (paramLong < 10485760L))
      {
        i = 4;
        break;
      }
      if ((paramLong >= 10485760L) && (paramLong < 104857600L))
      {
        i = 5;
        break;
      }
      if (paramLong < 104857600L) {
        break;
      }
      i = 6;
      break;
    }
  }
  
  /* Error */
  public long a(adnj paramadnj, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: iload_2
    //   8: invokeinterface 372 2 0
    //   13: lconst_0
    //   14: lstore 54
    //   16: aload_0
    //   17: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   20: ldc2_w 378
    //   23: ldiv
    //   24: putfield 380	azpt:jdField_a_of_type_Long	J
    //   27: invokestatic 340	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   30: invokevirtual 384	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   33: checkcast 386	com/tencent/mobileqq/app/QQAppInterface
    //   36: astore 64
    //   38: aload 64
    //   40: ifnull +12 -> 52
    //   43: aload_0
    //   44: aload 64
    //   46: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   49: putfield 98	azpt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: aload_0
    //   53: new 121	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 98	azpt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 391
    //   70: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 380	azpt:jdField_a_of_type_Long	J
    //   77: invokestatic 314	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: putfield 98	azpt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokestatic 340	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: ldc_w 393
    //   95: iconst_0
    //   96: invokevirtual 397	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   99: astore 64
    //   101: aload 64
    //   103: ldc_w 399
    //   106: lconst_0
    //   107: invokeinterface 405 4 0
    //   112: lstore 6
    //   114: aload_0
    //   115: getfield 94	azpt:jdField_a_of_type_Boolean	Z
    //   118: ifeq +41 -> 159
    //   121: lload 6
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +34 -> 159
    //   128: aload_0
    //   129: getfield 380	azpt:jdField_a_of_type_Long	J
    //   132: lload 6
    //   134: lsub
    //   135: invokestatic 409	java/lang/Math:abs	(J)J
    //   138: ldc2_w 410
    //   141: lcmp
    //   142: ifge +17 -> 159
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 94	azpt:jdField_a_of_type_Boolean	Z
    //   150: ldc 164
    //   152: iconst_2
    //   153: ldc_w 413
    //   156: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   163: invokevirtual 416	java/util/ArrayList:clear	()V
    //   166: aload_0
    //   167: getfield 78	azpt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   170: invokevirtual 416	java/util/ArrayList:clear	()V
    //   173: aload_0
    //   174: getfield 100	azpt:c	Ljava/util/ArrayList;
    //   177: invokevirtual 416	java/util/ArrayList:clear	()V
    //   180: aload_0
    //   181: getfield 102	azpt:d	Ljava/util/ArrayList;
    //   184: invokevirtual 416	java/util/ArrayList:clear	()V
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: bipush 7
    //   192: if_icmpge +80 -> 272
    //   195: getstatic 34	azpt:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   198: ldc 28
    //   200: invokevirtual 143	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   203: checkcast 28	azps
    //   206: astore 65
    //   208: aload 65
    //   210: lconst_0
    //   211: putfield 151	azps:jdField_a_of_type_Long	J
    //   214: aload 65
    //   216: lconst_0
    //   217: putfield 160	azps:c	J
    //   220: aload_0
    //   221: getfield 100	azpt:c	Ljava/util/ArrayList;
    //   224: aload 65
    //   226: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: getstatic 34	azpt:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   233: ldc 28
    //   235: invokevirtual 143	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   238: checkcast 28	azps
    //   241: astore 65
    //   243: aload 65
    //   245: lconst_0
    //   246: putfield 151	azps:jdField_a_of_type_Long	J
    //   249: aload 65
    //   251: lconst_0
    //   252: putfield 160	azps:c	J
    //   255: aload_0
    //   256: getfield 102	azpt:d	Ljava/util/ArrayList;
    //   259: aload 65
    //   261: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -80 -> 189
    //   272: new 119	java/io/File
    //   275: dup
    //   276: getstatic 62	azpt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   279: iconst_0
    //   280: aaload
    //   281: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: invokevirtual 226	java/io/File:list	()[Ljava/lang/String;
    //   287: astore 65
    //   289: aload 65
    //   291: ifnull +2726 -> 3017
    //   294: aload 65
    //   296: arraylength
    //   297: ifle +2720 -> 3017
    //   300: lconst_0
    //   301: lstore 10
    //   303: lconst_0
    //   304: lstore 12
    //   306: iconst_0
    //   307: istore_2
    //   308: lload 10
    //   310: lstore 8
    //   312: lload 12
    //   314: lstore 6
    //   316: iload_2
    //   317: aload 65
    //   319: arraylength
    //   320: if_icmpge +2703 -> 3023
    //   323: new 119	java/io/File
    //   326: dup
    //   327: new 121	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   334: getstatic 62	azpt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   337: iconst_0
    //   338: aaload
    //   339: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 128
    //   344: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 65
    //   349: iload_2
    //   350: aaload
    //   351: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: astore 66
    //   362: aload 66
    //   364: invokevirtual 139	java/io/File:isDirectory	()Z
    //   367: ifeq +98 -> 465
    //   370: new 28	azps
    //   373: dup
    //   374: invokespecial 417	azps:<init>	()V
    //   377: astore 67
    //   379: aload 67
    //   381: iconst_0
    //   382: putfield 145	azps:jdField_a_of_type_Boolean	Z
    //   385: aload 67
    //   387: aload_0
    //   388: aload 66
    //   390: invokevirtual 156	azpt:a	(Ljava/io/File;)J
    //   393: putfield 158	azps:jdField_b_of_type_Long	J
    //   396: aload 67
    //   398: aload 65
    //   400: iload_2
    //   401: aaload
    //   402: putfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   405: aload 67
    //   407: new 121	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   414: getstatic 62	azpt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   417: iconst_0
    //   418: aaload
    //   419: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 128
    //   424: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 65
    //   429: iload_2
    //   430: aaload
    //   431: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: putfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   440: aload 67
    //   442: lconst_0
    //   443: putfield 160	azps:c	J
    //   446: aload 67
    //   448: lconst_0
    //   449: putfield 327	azps:d	J
    //   452: aload_0
    //   453: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   456: aload 67
    //   458: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   461: pop
    //   462: goto +2548 -> 3010
    //   465: lload 12
    //   467: aload_0
    //   468: getstatic 62	azpt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   471: iconst_0
    //   472: aaload
    //   473: aload 65
    //   475: iload_2
    //   476: aaload
    //   477: invokespecial 234	azpt:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   480: ladd
    //   481: lstore 12
    //   483: lload 10
    //   485: lconst_1
    //   486: ladd
    //   487: lstore 10
    //   489: goto +2521 -> 3010
    //   492: iload_2
    //   493: getstatic 62	azpt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   496: arraylength
    //   497: if_icmpge +2538 -> 3035
    //   500: getstatic 62	azpt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   503: iload_2
    //   504: aaload
    //   505: astore 65
    //   507: new 119	java/io/File
    //   510: dup
    //   511: aload 65
    //   513: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   516: astore 66
    //   518: aload 66
    //   520: invokevirtual 139	java/io/File:isDirectory	()Z
    //   523: ifeq +2505 -> 3028
    //   526: new 28	azps
    //   529: dup
    //   530: invokespecial 417	azps:<init>	()V
    //   533: astore 67
    //   535: aload 67
    //   537: iconst_0
    //   538: putfield 145	azps:jdField_a_of_type_Boolean	Z
    //   541: aload 67
    //   543: aload_0
    //   544: aload 66
    //   546: invokevirtual 156	azpt:a	(Ljava/io/File;)J
    //   549: putfield 158	azps:jdField_b_of_type_Long	J
    //   552: aload 67
    //   554: aload 65
    //   556: ldc 128
    //   558: invokevirtual 421	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   561: iconst_2
    //   562: aaload
    //   563: putfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   566: aload 67
    //   568: aload 65
    //   570: putfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   573: aload 67
    //   575: lconst_0
    //   576: putfield 160	azps:c	J
    //   579: aload 67
    //   581: lconst_0
    //   582: putfield 327	azps:d	J
    //   585: aload_0
    //   586: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   589: aload 67
    //   591: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   594: pop
    //   595: goto +2433 -> 3028
    //   598: iload_2
    //   599: getstatic 68	azpt:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   602: arraylength
    //   603: if_icmpge +274 -> 877
    //   606: getstatic 68	azpt:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   609: iload_2
    //   610: aaload
    //   611: astore 65
    //   613: new 119	java/io/File
    //   616: dup
    //   617: aload 65
    //   619: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   622: invokevirtual 226	java/io/File:list	()[Ljava/lang/String;
    //   625: astore 66
    //   627: aload 66
    //   629: ifnull +2420 -> 3049
    //   632: aload 66
    //   634: arraylength
    //   635: ifle +2414 -> 3049
    //   638: iconst_0
    //   639: istore 4
    //   641: iload 4
    //   643: aload 66
    //   645: arraylength
    //   646: if_icmpge +2403 -> 3049
    //   649: new 119	java/io/File
    //   652: dup
    //   653: new 121	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   660: aload 65
    //   662: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: ldc 128
    //   667: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload 66
    //   672: iload 4
    //   674: aaload
    //   675: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   684: astore 67
    //   686: ldc 66
    //   688: new 121	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   695: aload 65
    //   697: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc 128
    //   702: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload 66
    //   707: iload 4
    //   709: aaload
    //   710: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   719: ifeq +36 -> 755
    //   722: ldc 164
    //   724: iconst_2
    //   725: new 121	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   732: ldc_w 426
    //   735: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload 66
    //   740: iload 4
    //   742: aaload
    //   743: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: goto +2288 -> 3040
    //   755: aload 67
    //   757: invokevirtual 139	java/io/File:isDirectory	()Z
    //   760: ifeq +102 -> 862
    //   763: new 28	azps
    //   766: dup
    //   767: invokespecial 417	azps:<init>	()V
    //   770: astore 68
    //   772: aload 68
    //   774: iconst_0
    //   775: putfield 145	azps:jdField_a_of_type_Boolean	Z
    //   778: aload 68
    //   780: aload_0
    //   781: aload 67
    //   783: invokevirtual 156	azpt:a	(Ljava/io/File;)J
    //   786: putfield 158	azps:jdField_b_of_type_Long	J
    //   789: aload 68
    //   791: aload 66
    //   793: iload 4
    //   795: aaload
    //   796: putfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   799: aload 68
    //   801: new 121	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   808: aload 65
    //   810: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: ldc 128
    //   815: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 66
    //   820: iload 4
    //   822: aaload
    //   823: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: putfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   832: aload 68
    //   834: lconst_0
    //   835: putfield 160	azps:c	J
    //   838: aload 68
    //   840: lconst_0
    //   841: putfield 327	azps:d	J
    //   844: aload_0
    //   845: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   848: aload 68
    //   850: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   853: pop
    //   854: goto +2186 -> 3040
    //   857: astore_1
    //   858: aload_0
    //   859: monitorexit
    //   860: aload_1
    //   861: athrow
    //   862: aload_0
    //   863: aload 65
    //   865: aload 66
    //   867: iload 4
    //   869: aaload
    //   870: invokespecial 234	azpt:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   873: pop2
    //   874: goto +2166 -> 3040
    //   877: ldc 164
    //   879: iconst_2
    //   880: new 121	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   887: ldc_w 428
    //   890: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload_0
    //   894: getfield 380	azpt:jdField_a_of_type_Long	J
    //   897: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   900: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   906: iconst_0
    //   907: istore_2
    //   908: lconst_0
    //   909: lstore 14
    //   911: lconst_0
    //   912: lstore 18
    //   914: lconst_0
    //   915: lstore 32
    //   917: lconst_0
    //   918: lstore 10
    //   920: lconst_0
    //   921: lstore 12
    //   923: lconst_0
    //   924: lstore 20
    //   926: lconst_0
    //   927: lstore 22
    //   929: lload 6
    //   931: lstore 24
    //   933: lload 8
    //   935: lstore 16
    //   937: lload 18
    //   939: lstore 8
    //   941: lload 12
    //   943: lstore 6
    //   945: aload_0
    //   946: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   949: invokevirtual 184	java/util/ArrayList:size	()I
    //   952: istore 4
    //   954: iload_2
    //   955: iload 4
    //   957: if_icmpge +1491 -> 2448
    //   960: aload_0
    //   961: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   964: invokevirtual 184	java/util/ArrayList:size	()I
    //   967: sipush 500
    //   970: if_icmplt +471 -> 1441
    //   973: ldc2_w 429
    //   976: invokestatic 436	java/lang/Thread:sleep	(J)V
    //   979: aload_0
    //   980: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   983: iload_2
    //   984: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   987: checkcast 28	azps
    //   990: astore 65
    //   992: aload 65
    //   994: lconst_0
    //   995: putfield 151	azps:jdField_a_of_type_Long	J
    //   998: aload 65
    //   1000: lconst_0
    //   1001: putfield 160	azps:c	J
    //   1004: aload 65
    //   1006: lconst_0
    //   1007: putfield 327	azps:d	J
    //   1010: aload 65
    //   1012: getfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1015: astore 66
    //   1017: lload 6
    //   1019: lstore 62
    //   1021: lload 14
    //   1023: lstore 46
    //   1025: lload 20
    //   1027: lstore 42
    //   1029: lload 8
    //   1031: lstore 60
    //   1033: lload 22
    //   1035: lstore 38
    //   1037: lload 32
    //   1039: lstore 36
    //   1041: lload 10
    //   1043: lstore 58
    //   1045: lload 16
    //   1047: lstore 18
    //   1049: lload 24
    //   1051: lstore 12
    //   1053: lload 54
    //   1055: lstore 56
    //   1057: new 119	java/io/File
    //   1060: dup
    //   1061: aload 66
    //   1063: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   1066: invokevirtual 226	java/io/File:list	()[Ljava/lang/String;
    //   1069: astore 67
    //   1071: aload 67
    //   1073: ifnull +387 -> 1460
    //   1076: lload 6
    //   1078: lstore 62
    //   1080: lload 14
    //   1082: lstore 46
    //   1084: lload 20
    //   1086: lstore 42
    //   1088: lload 8
    //   1090: lstore 60
    //   1092: lload 22
    //   1094: lstore 38
    //   1096: lload 32
    //   1098: lstore 36
    //   1100: lload 10
    //   1102: lstore 58
    //   1104: lload 16
    //   1106: lstore 18
    //   1108: lload 24
    //   1110: lstore 12
    //   1112: lload 54
    //   1114: lstore 56
    //   1116: aload 67
    //   1118: arraylength
    //   1119: ifle +341 -> 1460
    //   1122: lload 6
    //   1124: lstore 62
    //   1126: lload 14
    //   1128: lstore 46
    //   1130: lload 20
    //   1132: lstore 42
    //   1134: lload 8
    //   1136: lstore 60
    //   1138: lload 22
    //   1140: lstore 38
    //   1142: lload 32
    //   1144: lstore 36
    //   1146: lload 10
    //   1148: lstore 58
    //   1150: lload 16
    //   1152: lstore 18
    //   1154: lload 24
    //   1156: lstore 12
    //   1158: lload 54
    //   1160: lstore 56
    //   1162: aload 67
    //   1164: arraylength
    //   1165: istore 5
    //   1167: iconst_0
    //   1168: istore 4
    //   1170: iload 4
    //   1172: iload 5
    //   1174: if_icmpge +286 -> 1460
    //   1177: aload 67
    //   1179: iload 4
    //   1181: aaload
    //   1182: astore 68
    //   1184: lload 6
    //   1186: lstore 62
    //   1188: lload 14
    //   1190: lstore 46
    //   1192: lload 20
    //   1194: lstore 42
    //   1196: lload 8
    //   1198: lstore 60
    //   1200: lload 22
    //   1202: lstore 38
    //   1204: lload 32
    //   1206: lstore 36
    //   1208: lload 10
    //   1210: lstore 58
    //   1212: lload 16
    //   1214: lstore 18
    //   1216: lload 24
    //   1218: lstore 12
    //   1220: lload 54
    //   1222: lstore 56
    //   1224: aload_0
    //   1225: new 121	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1232: aload 66
    //   1234: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: ldc 128
    //   1239: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: aload 68
    //   1244: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokespecial 438	azpt:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1253: astore 68
    //   1255: lload 6
    //   1257: lstore 62
    //   1259: lload 14
    //   1261: lstore 46
    //   1263: lload 20
    //   1265: lstore 42
    //   1267: lload 8
    //   1269: lstore 60
    //   1271: lload 22
    //   1273: lstore 38
    //   1275: lload 32
    //   1277: lstore 36
    //   1279: lload 10
    //   1281: lstore 58
    //   1283: lload 16
    //   1285: lstore 18
    //   1287: lload 24
    //   1289: lstore 12
    //   1291: lload 54
    //   1293: lstore 56
    //   1295: aload 65
    //   1297: aload 65
    //   1299: getfield 151	azps:jdField_a_of_type_Long	J
    //   1302: aload 68
    //   1304: ldc 242
    //   1306: lconst_0
    //   1307: invokevirtual 439	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1310: ladd
    //   1311: putfield 151	azps:jdField_a_of_type_Long	J
    //   1314: lload 6
    //   1316: lstore 62
    //   1318: lload 14
    //   1320: lstore 46
    //   1322: lload 20
    //   1324: lstore 42
    //   1326: lload 8
    //   1328: lstore 60
    //   1330: lload 22
    //   1332: lstore 38
    //   1334: lload 32
    //   1336: lstore 36
    //   1338: lload 10
    //   1340: lstore 58
    //   1342: lload 16
    //   1344: lstore 18
    //   1346: lload 24
    //   1348: lstore 12
    //   1350: lload 54
    //   1352: lstore 56
    //   1354: aload 65
    //   1356: aload 65
    //   1358: getfield 160	azps:c	J
    //   1361: aload 68
    //   1363: ldc 248
    //   1365: lconst_0
    //   1366: invokevirtual 439	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1369: ladd
    //   1370: putfield 160	azps:c	J
    //   1373: lload 6
    //   1375: lstore 62
    //   1377: lload 14
    //   1379: lstore 46
    //   1381: lload 20
    //   1383: lstore 42
    //   1385: lload 8
    //   1387: lstore 60
    //   1389: lload 22
    //   1391: lstore 38
    //   1393: lload 32
    //   1395: lstore 36
    //   1397: lload 10
    //   1399: lstore 58
    //   1401: lload 16
    //   1403: lstore 18
    //   1405: lload 24
    //   1407: lstore 12
    //   1409: lload 54
    //   1411: lstore 56
    //   1413: aload 65
    //   1415: aload 65
    //   1417: getfield 327	azps:d	J
    //   1420: aload 68
    //   1422: ldc 250
    //   1424: lconst_0
    //   1425: invokevirtual 439	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1428: ladd
    //   1429: putfield 327	azps:d	J
    //   1432: iload 4
    //   1434: iconst_1
    //   1435: iadd
    //   1436: istore 4
    //   1438: goto -268 -> 1170
    //   1441: ldc2_w 440
    //   1444: invokestatic 436	java/lang/Thread:sleep	(J)V
    //   1447: goto -468 -> 979
    //   1450: astore 65
    //   1452: aload 65
    //   1454: invokevirtual 444	java/lang/InterruptedException:printStackTrace	()V
    //   1457: goto -478 -> 979
    //   1460: lload 6
    //   1462: lstore 62
    //   1464: lload 14
    //   1466: lstore 46
    //   1468: lload 20
    //   1470: lstore 42
    //   1472: lload 8
    //   1474: lstore 60
    //   1476: lload 22
    //   1478: lstore 38
    //   1480: lload 32
    //   1482: lstore 36
    //   1484: lload 10
    //   1486: lstore 58
    //   1488: lload 16
    //   1490: lstore 18
    //   1492: lload 24
    //   1494: lstore 12
    //   1496: lload 54
    //   1498: lstore 56
    //   1500: aload 66
    //   1502: ldc_w 446
    //   1505: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1508: ifeq +597 -> 2105
    //   1511: lload 6
    //   1513: lstore 62
    //   1515: lload 14
    //   1517: lstore 46
    //   1519: lload 20
    //   1521: lstore 42
    //   1523: lload 8
    //   1525: lstore 60
    //   1527: lload 22
    //   1529: lstore 38
    //   1531: lload 32
    //   1533: lstore 36
    //   1535: lload 10
    //   1537: lstore 58
    //   1539: lload 16
    //   1541: lstore 18
    //   1543: lload 24
    //   1545: lstore 12
    //   1547: lload 54
    //   1549: lstore 56
    //   1551: aload 66
    //   1553: ldc_w 448
    //   1556: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1559: ifeq +369 -> 1928
    //   1562: lload 6
    //   1564: lstore 62
    //   1566: lload 14
    //   1568: lstore 46
    //   1570: lload 20
    //   1572: lstore 42
    //   1574: lload 8
    //   1576: lstore 60
    //   1578: lload 22
    //   1580: lstore 38
    //   1582: lload 32
    //   1584: lstore 36
    //   1586: lload 10
    //   1588: lstore 58
    //   1590: lload 16
    //   1592: lstore 18
    //   1594: lload 24
    //   1596: lstore 12
    //   1598: lload 54
    //   1600: lstore 56
    //   1602: lload 20
    //   1604: aload 65
    //   1606: getfield 151	azps:jdField_a_of_type_Long	J
    //   1609: ladd
    //   1610: lstore 30
    //   1612: lload 6
    //   1614: lstore 62
    //   1616: lload 14
    //   1618: lstore 46
    //   1620: lload 30
    //   1622: lstore 42
    //   1624: lload 8
    //   1626: lstore 60
    //   1628: lload 22
    //   1630: lstore 38
    //   1632: lload 32
    //   1634: lstore 36
    //   1636: lload 10
    //   1638: lstore 58
    //   1640: lload 16
    //   1642: lstore 18
    //   1644: lload 24
    //   1646: lstore 12
    //   1648: lload 54
    //   1650: lstore 56
    //   1652: lload 14
    //   1654: aload 65
    //   1656: getfield 160	azps:c	J
    //   1659: ladd
    //   1660: lstore 28
    //   1662: lload 6
    //   1664: lstore 62
    //   1666: lload 28
    //   1668: lstore 46
    //   1670: lload 30
    //   1672: lstore 42
    //   1674: lload 8
    //   1676: lstore 60
    //   1678: lload 22
    //   1680: lstore 38
    //   1682: lload 32
    //   1684: lstore 36
    //   1686: lload 10
    //   1688: lstore 58
    //   1690: lload 16
    //   1692: lstore 18
    //   1694: lload 24
    //   1696: lstore 12
    //   1698: lload 54
    //   1700: lstore 56
    //   1702: lload 6
    //   1704: aload 65
    //   1706: getfield 327	azps:d	J
    //   1709: ladd
    //   1710: lstore 26
    //   1712: lload 24
    //   1714: lstore 52
    //   1716: lload 16
    //   1718: lstore 50
    //   1720: lload 10
    //   1722: lstore 48
    //   1724: lload 32
    //   1726: lstore 44
    //   1728: lload 22
    //   1730: lstore 40
    //   1732: lload 8
    //   1734: lstore 34
    //   1736: lload 26
    //   1738: lstore 62
    //   1740: lload 28
    //   1742: lstore 46
    //   1744: lload 30
    //   1746: lstore 42
    //   1748: lload 34
    //   1750: lstore 60
    //   1752: lload 40
    //   1754: lstore 38
    //   1756: lload 44
    //   1758: lstore 36
    //   1760: lload 48
    //   1762: lstore 58
    //   1764: lload 50
    //   1766: lstore 18
    //   1768: lload 52
    //   1770: lstore 12
    //   1772: lload 54
    //   1774: lstore 56
    //   1776: lload 54
    //   1778: aload 65
    //   1780: getfield 151	azps:jdField_a_of_type_Long	J
    //   1783: ladd
    //   1784: lstore 54
    //   1786: lload 26
    //   1788: lstore 62
    //   1790: lload 28
    //   1792: lstore 46
    //   1794: lload 30
    //   1796: lstore 42
    //   1798: lload 34
    //   1800: lstore 60
    //   1802: lload 40
    //   1804: lstore 38
    //   1806: lload 44
    //   1808: lstore 36
    //   1810: lload 48
    //   1812: lstore 58
    //   1814: lload 50
    //   1816: lstore 18
    //   1818: lload 52
    //   1820: lstore 12
    //   1822: lload 54
    //   1824: lstore 56
    //   1826: ldc 164
    //   1828: iconst_1
    //   1829: new 121	java/lang/StringBuilder
    //   1832: dup
    //   1833: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1836: ldc_w 450
    //   1839: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload 65
    //   1844: invokevirtual 167	azps:toString	()Ljava/lang/String;
    //   1847: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1856: lload 52
    //   1858: lstore 12
    //   1860: lload 50
    //   1862: lstore 16
    //   1864: lload 48
    //   1866: lstore 10
    //   1868: lload 44
    //   1870: lstore 32
    //   1872: lload 40
    //   1874: lstore 22
    //   1876: lload 34
    //   1878: lstore 8
    //   1880: lload 30
    //   1882: lstore 20
    //   1884: lload 28
    //   1886: lstore 14
    //   1888: lload 26
    //   1890: lstore 6
    //   1892: aload_1
    //   1893: ifnull +24 -> 1917
    //   1896: aload_1
    //   1897: iload_2
    //   1898: iconst_1
    //   1899: iadd
    //   1900: iload_3
    //   1901: iconst_2
    //   1902: isub
    //   1903: imul
    //   1904: aload_0
    //   1905: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1908: invokevirtual 184	java/util/ArrayList:size	()I
    //   1911: idiv
    //   1912: invokeinterface 372 2 0
    //   1917: iload_2
    //   1918: iconst_1
    //   1919: iadd
    //   1920: istore_2
    //   1921: lload 12
    //   1923: lstore 24
    //   1925: goto -980 -> 945
    //   1928: lload 6
    //   1930: lstore 62
    //   1932: lload 14
    //   1934: lstore 46
    //   1936: lload 20
    //   1938: lstore 42
    //   1940: lload 8
    //   1942: lstore 60
    //   1944: lload 22
    //   1946: lstore 38
    //   1948: lload 32
    //   1950: lstore 36
    //   1952: lload 10
    //   1954: lstore 58
    //   1956: lload 16
    //   1958: lstore 18
    //   1960: lload 24
    //   1962: lstore 12
    //   1964: lload 54
    //   1966: lstore 56
    //   1968: lload 24
    //   1970: aload 65
    //   1972: getfield 151	azps:jdField_a_of_type_Long	J
    //   1975: ladd
    //   1976: lstore 52
    //   1978: lload 6
    //   1980: lstore 62
    //   1982: lload 14
    //   1984: lstore 46
    //   1986: lload 20
    //   1988: lstore 42
    //   1990: lload 8
    //   1992: lstore 60
    //   1994: lload 22
    //   1996: lstore 38
    //   1998: lload 32
    //   2000: lstore 36
    //   2002: lload 10
    //   2004: lstore 58
    //   2006: lload 16
    //   2008: lstore 18
    //   2010: lload 52
    //   2012: lstore 12
    //   2014: lload 54
    //   2016: lstore 56
    //   2018: lload 16
    //   2020: aload 65
    //   2022: getfield 160	azps:c	J
    //   2025: ladd
    //   2026: lstore 50
    //   2028: lload 6
    //   2030: lstore 62
    //   2032: lload 14
    //   2034: lstore 46
    //   2036: lload 20
    //   2038: lstore 42
    //   2040: lload 8
    //   2042: lstore 60
    //   2044: lload 22
    //   2046: lstore 38
    //   2048: lload 32
    //   2050: lstore 36
    //   2052: lload 10
    //   2054: lstore 58
    //   2056: lload 50
    //   2058: lstore 18
    //   2060: lload 52
    //   2062: lstore 12
    //   2064: lload 54
    //   2066: lstore 56
    //   2068: lload 10
    //   2070: aload 65
    //   2072: getfield 327	azps:d	J
    //   2075: ladd
    //   2076: lstore 48
    //   2078: lload 6
    //   2080: lstore 26
    //   2082: lload 14
    //   2084: lstore 28
    //   2086: lload 20
    //   2088: lstore 30
    //   2090: lload 8
    //   2092: lstore 34
    //   2094: lload 22
    //   2096: lstore 40
    //   2098: lload 32
    //   2100: lstore 44
    //   2102: goto -366 -> 1736
    //   2105: lload 6
    //   2107: lstore 26
    //   2109: lload 14
    //   2111: lstore 28
    //   2113: lload 20
    //   2115: lstore 30
    //   2117: lload 8
    //   2119: lstore 34
    //   2121: lload 22
    //   2123: lstore 40
    //   2125: lload 32
    //   2127: lstore 44
    //   2129: lload 10
    //   2131: lstore 48
    //   2133: lload 16
    //   2135: lstore 50
    //   2137: lload 24
    //   2139: lstore 52
    //   2141: lload 6
    //   2143: lstore 62
    //   2145: lload 14
    //   2147: lstore 46
    //   2149: lload 20
    //   2151: lstore 42
    //   2153: lload 8
    //   2155: lstore 60
    //   2157: lload 22
    //   2159: lstore 38
    //   2161: lload 32
    //   2163: lstore 36
    //   2165: lload 10
    //   2167: lstore 58
    //   2169: lload 16
    //   2171: lstore 18
    //   2173: lload 24
    //   2175: lstore 12
    //   2177: lload 54
    //   2179: lstore 56
    //   2181: aload 66
    //   2183: ldc 64
    //   2185: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2188: ifeq -452 -> 1736
    //   2191: lload 6
    //   2193: lstore 62
    //   2195: lload 14
    //   2197: lstore 46
    //   2199: lload 20
    //   2201: lstore 42
    //   2203: lload 8
    //   2205: lstore 60
    //   2207: lload 22
    //   2209: lstore 38
    //   2211: lload 32
    //   2213: lstore 36
    //   2215: lload 10
    //   2217: lstore 58
    //   2219: lload 16
    //   2221: lstore 18
    //   2223: lload 24
    //   2225: lstore 12
    //   2227: lload 54
    //   2229: lstore 56
    //   2231: lload 32
    //   2233: aload 65
    //   2235: getfield 151	azps:jdField_a_of_type_Long	J
    //   2238: ladd
    //   2239: lstore 44
    //   2241: lload 6
    //   2243: lstore 62
    //   2245: lload 14
    //   2247: lstore 46
    //   2249: lload 20
    //   2251: lstore 42
    //   2253: lload 8
    //   2255: lstore 60
    //   2257: lload 22
    //   2259: lstore 38
    //   2261: lload 44
    //   2263: lstore 36
    //   2265: lload 10
    //   2267: lstore 58
    //   2269: lload 16
    //   2271: lstore 18
    //   2273: lload 24
    //   2275: lstore 12
    //   2277: lload 54
    //   2279: lstore 56
    //   2281: lload 22
    //   2283: aload 65
    //   2285: getfield 160	azps:c	J
    //   2288: ladd
    //   2289: lstore 40
    //   2291: lload 6
    //   2293: lstore 62
    //   2295: lload 14
    //   2297: lstore 46
    //   2299: lload 20
    //   2301: lstore 42
    //   2303: lload 8
    //   2305: lstore 60
    //   2307: lload 40
    //   2309: lstore 38
    //   2311: lload 44
    //   2313: lstore 36
    //   2315: lload 10
    //   2317: lstore 58
    //   2319: lload 16
    //   2321: lstore 18
    //   2323: lload 24
    //   2325: lstore 12
    //   2327: lload 54
    //   2329: lstore 56
    //   2331: aload 65
    //   2333: getfield 327	azps:d	J
    //   2336: lstore 22
    //   2338: lload 8
    //   2340: lload 22
    //   2342: ladd
    //   2343: lstore 34
    //   2345: lload 6
    //   2347: lstore 26
    //   2349: lload 14
    //   2351: lstore 28
    //   2353: lload 20
    //   2355: lstore 30
    //   2357: lload 10
    //   2359: lstore 48
    //   2361: lload 16
    //   2363: lstore 50
    //   2365: lload 24
    //   2367: lstore 52
    //   2369: goto -633 -> 1736
    //   2372: astore 65
    //   2374: aload 65
    //   2376: invokevirtual 451	java/lang/Exception:printStackTrace	()V
    //   2379: ldc 164
    //   2381: iconst_1
    //   2382: new 121	java/lang/StringBuilder
    //   2385: dup
    //   2386: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2389: ldc_w 453
    //   2392: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: aload 65
    //   2397: invokevirtual 457	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2400: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2403: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2406: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2409: lload 62
    //   2411: lstore 6
    //   2413: lload 46
    //   2415: lstore 14
    //   2417: lload 42
    //   2419: lstore 20
    //   2421: lload 60
    //   2423: lstore 8
    //   2425: lload 38
    //   2427: lstore 22
    //   2429: lload 36
    //   2431: lstore 32
    //   2433: lload 58
    //   2435: lstore 10
    //   2437: lload 18
    //   2439: lstore 16
    //   2441: lload 56
    //   2443: lstore 54
    //   2445: goto -553 -> 1892
    //   2448: aload_0
    //   2449: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2452: aload_0
    //   2453: getfield 92	azpt:jdField_a_of_type_Azpw	Lazpw;
    //   2456: invokestatic 194	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   2459: ldc 164
    //   2461: iconst_1
    //   2462: ldc_w 462
    //   2465: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2468: iconst_0
    //   2469: istore_2
    //   2470: iload_2
    //   2471: aload_0
    //   2472: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2475: invokevirtual 184	java/util/ArrayList:size	()I
    //   2478: if_icmpge +25 -> 2503
    //   2481: aload_0
    //   2482: aload_0
    //   2483: getfield 80	azpt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2486: iload_2
    //   2487: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2490: checkcast 28	azps
    //   2493: invokespecial 177	azpt:a	(Lazps;)V
    //   2496: iload_2
    //   2497: iconst_1
    //   2498: iadd
    //   2499: istore_2
    //   2500: goto -30 -> 2470
    //   2503: ldc 164
    //   2505: iconst_1
    //   2506: new 121	java/lang/StringBuilder
    //   2509: dup
    //   2510: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2513: ldc_w 464
    //   2516: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2519: lload 54
    //   2521: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2524: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2527: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2530: new 28	azps
    //   2533: dup
    //   2534: invokespecial 417	azps:<init>	()V
    //   2537: astore 65
    //   2539: aload 65
    //   2541: iconst_0
    //   2542: putfield 145	azps:jdField_a_of_type_Boolean	Z
    //   2545: aload 65
    //   2547: ldc_w 466
    //   2550: putfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2553: aload 65
    //   2555: lload 16
    //   2557: lload 22
    //   2559: ladd
    //   2560: lload 14
    //   2562: ladd
    //   2563: putfield 160	azps:c	J
    //   2566: aload 65
    //   2568: lload 10
    //   2570: lload 8
    //   2572: ladd
    //   2573: lload 6
    //   2575: ladd
    //   2576: putfield 327	azps:d	J
    //   2579: aload 65
    //   2581: lconst_0
    //   2582: putfield 158	azps:jdField_b_of_type_Long	J
    //   2585: aload 65
    //   2587: lload 54
    //   2589: putfield 151	azps:jdField_a_of_type_Long	J
    //   2592: aload_0
    //   2593: aload 65
    //   2595: invokespecial 177	azpt:a	(Lazps;)V
    //   2598: ldc 164
    //   2600: iconst_1
    //   2601: new 121	java/lang/StringBuilder
    //   2604: dup
    //   2605: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2608: ldc_w 468
    //   2611: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2614: aload 65
    //   2616: invokevirtual 167	azps:toString	()Ljava/lang/String;
    //   2619: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2625: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2628: new 28	azps
    //   2631: dup
    //   2632: invokespecial 417	azps:<init>	()V
    //   2635: astore 65
    //   2637: aload 65
    //   2639: iconst_0
    //   2640: putfield 145	azps:jdField_a_of_type_Boolean	Z
    //   2643: aload 65
    //   2645: ldc_w 470
    //   2648: putfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2651: aload 65
    //   2653: aload_0
    //   2654: aload_0
    //   2655: getfield 100	azpt:c	Ljava/util/ArrayList;
    //   2658: invokespecial 472	azpt:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2661: putfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2664: aload 65
    //   2666: lload 14
    //   2668: lload 16
    //   2670: ladd
    //   2671: putfield 160	azps:c	J
    //   2674: aload 65
    //   2676: lload 6
    //   2678: lload 10
    //   2680: ladd
    //   2681: putfield 327	azps:d	J
    //   2684: aload 65
    //   2686: lconst_0
    //   2687: putfield 158	azps:jdField_b_of_type_Long	J
    //   2690: aload 65
    //   2692: lload 24
    //   2694: lload 20
    //   2696: ladd
    //   2697: putfield 151	azps:jdField_a_of_type_Long	J
    //   2700: aload_0
    //   2701: aload 65
    //   2703: invokespecial 177	azpt:a	(Lazps;)V
    //   2706: ldc 164
    //   2708: iconst_1
    //   2709: new 121	java/lang/StringBuilder
    //   2712: dup
    //   2713: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2716: ldc_w 474
    //   2719: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2722: aload 65
    //   2724: invokevirtual 167	azps:toString	()Ljava/lang/String;
    //   2727: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2730: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2733: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2736: new 28	azps
    //   2739: dup
    //   2740: invokespecial 417	azps:<init>	()V
    //   2743: astore 65
    //   2745: aload 65
    //   2747: iconst_0
    //   2748: putfield 145	azps:jdField_a_of_type_Boolean	Z
    //   2751: aload 65
    //   2753: ldc_w 476
    //   2756: putfield 153	azps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2759: aload 65
    //   2761: aload_0
    //   2762: aload_0
    //   2763: getfield 102	azpt:d	Ljava/util/ArrayList;
    //   2766: invokespecial 472	azpt:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2769: putfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2772: aload 65
    //   2774: lload 22
    //   2776: putfield 160	azps:c	J
    //   2779: aload 65
    //   2781: lload 8
    //   2783: putfield 327	azps:d	J
    //   2786: aload 65
    //   2788: lconst_0
    //   2789: putfield 158	azps:jdField_b_of_type_Long	J
    //   2792: aload 65
    //   2794: lload 32
    //   2796: putfield 151	azps:jdField_a_of_type_Long	J
    //   2799: aload_0
    //   2800: aload 65
    //   2802: invokespecial 177	azpt:a	(Lazps;)V
    //   2805: ldc 164
    //   2807: iconst_1
    //   2808: new 121	java/lang/StringBuilder
    //   2811: dup
    //   2812: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2815: ldc_w 478
    //   2818: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2821: aload 65
    //   2823: invokevirtual 167	azps:toString	()Ljava/lang/String;
    //   2826: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2829: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2832: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2835: ldc 164
    //   2837: iconst_1
    //   2838: ldc_w 480
    //   2841: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2844: iconst_0
    //   2845: istore_2
    //   2846: iload_2
    //   2847: aload_0
    //   2848: getfield 78	azpt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2851: invokevirtual 184	java/util/ArrayList:size	()I
    //   2854: if_icmpge +58 -> 2912
    //   2857: aload_0
    //   2858: getfield 78	azpt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2861: iload_2
    //   2862: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2865: checkcast 28	azps
    //   2868: astore 65
    //   2870: aload 65
    //   2872: new 121	java/lang/StringBuilder
    //   2875: dup
    //   2876: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2879: ldc_w 482
    //   2882: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2885: aload 65
    //   2887: getfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2890: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2896: putfield 144	azps:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2899: aload_0
    //   2900: aload 65
    //   2902: invokespecial 177	azpt:a	(Lazps;)V
    //   2905: iload_2
    //   2906: iconst_1
    //   2907: iadd
    //   2908: istore_2
    //   2909: goto -63 -> 2846
    //   2912: aload_0
    //   2913: getfield 94	azpt:jdField_a_of_type_Boolean	Z
    //   2916: ifeq +140 -> 3056
    //   2919: aload 64
    //   2921: invokeinterface 486 1 0
    //   2926: ldc_w 399
    //   2929: aload_0
    //   2930: getfield 380	azpt:jdField_a_of_type_Long	J
    //   2933: invokeinterface 491 4 0
    //   2938: invokeinterface 494 1 0
    //   2943: pop
    //   2944: goto +112 -> 3056
    //   2947: iload_2
    //   2948: bipush 7
    //   2950: if_icmpge +44 -> 2994
    //   2953: getstatic 34	azpt:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2956: aload_0
    //   2957: getfield 100	azpt:c	Ljava/util/ArrayList;
    //   2960: iload_2
    //   2961: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2964: checkcast 496	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2967: invokevirtual 205	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2970: getstatic 34	azpt:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2973: aload_0
    //   2974: getfield 102	azpt:d	Ljava/util/ArrayList;
    //   2977: iload_2
    //   2978: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2981: checkcast 496	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2984: invokevirtual 205	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2987: iload_2
    //   2988: iconst_1
    //   2989: iadd
    //   2990: istore_2
    //   2991: goto -44 -> 2947
    //   2994: aload_1
    //   2995: ifnull +10 -> 3005
    //   2998: aload_1
    //   2999: iload_3
    //   3000: invokeinterface 372 2 0
    //   3005: aload_0
    //   3006: monitorexit
    //   3007: lload 24
    //   3009: lreturn
    //   3010: iload_2
    //   3011: iconst_1
    //   3012: iadd
    //   3013: istore_2
    //   3014: goto -2706 -> 308
    //   3017: lconst_0
    //   3018: lstore 8
    //   3020: lconst_0
    //   3021: lstore 6
    //   3023: iconst_1
    //   3024: istore_2
    //   3025: goto -2533 -> 492
    //   3028: iload_2
    //   3029: iconst_1
    //   3030: iadd
    //   3031: istore_2
    //   3032: goto -2540 -> 492
    //   3035: iconst_0
    //   3036: istore_2
    //   3037: goto -2439 -> 598
    //   3040: iload 4
    //   3042: iconst_1
    //   3043: iadd
    //   3044: istore 4
    //   3046: goto -2405 -> 641
    //   3049: iload_2
    //   3050: iconst_1
    //   3051: iadd
    //   3052: istore_2
    //   3053: goto -2455 -> 598
    //   3056: iconst_0
    //   3057: istore_2
    //   3058: goto -111 -> 2947
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3061	0	this	azpt
    //   0	3061	1	paramadnj	adnj
    //   0	3061	2	paramInt1	int
    //   0	3061	3	paramInt2	int
    //   639	2406	4	i	int
    //   1165	10	5	j	int
    //   112	2910	6	l1	long
    //   310	2709	8	l2	long
    //   301	2378	10	l3	long
    //   304	2022	12	l4	long
    //   909	1758	14	l5	long
    //   935	1734	16	l6	long
    //   912	1526	18	l7	long
    //   924	1771	20	l8	long
    //   927	1848	22	l9	long
    //   931	2077	24	l10	long
    //   1710	638	26	l11	long
    //   1660	692	28	l12	long
    //   1610	746	30	l13	long
    //   915	1880	32	l14	long
    //   1734	610	34	l15	long
    //   1039	1391	36	l16	long
    //   1035	1391	38	l17	long
    //   1730	578	40	l18	long
    //   1027	1391	42	l19	long
    //   1726	586	44	l20	long
    //   1023	1391	46	l21	long
    //   1722	638	48	l22	long
    //   1718	646	50	l23	long
    //   1714	654	52	l24	long
    //   14	2574	54	l25	long
    //   1055	1387	56	l26	long
    //   1043	1391	58	l27	long
    //   1031	1391	60	l28	long
    //   1019	1391	62	l29	long
    //   36	2884	64	localObject1	Object
    //   206	1210	65	localObject2	Object
    //   1450	882	65	localInterruptedException	java.lang.InterruptedException
    //   2372	24	65	localException	java.lang.Exception
    //   2537	364	65	localazps	azps
    //   360	1822	66	localObject3	Object
    //   377	801	67	localObject4	Object
    //   770	651	68	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	857	finally
    //   16	38	857	finally
    //   43	52	857	finally
    //   52	121	857	finally
    //   128	159	857	finally
    //   159	187	857	finally
    //   195	265	857	finally
    //   272	289	857	finally
    //   294	300	857	finally
    //   316	462	857	finally
    //   465	483	857	finally
    //   492	595	857	finally
    //   598	627	857	finally
    //   632	638	857	finally
    //   641	752	857	finally
    //   755	854	857	finally
    //   862	874	857	finally
    //   877	906	857	finally
    //   945	954	857	finally
    //   960	979	857	finally
    //   979	1017	857	finally
    //   1057	1071	857	finally
    //   1116	1122	857	finally
    //   1162	1167	857	finally
    //   1224	1255	857	finally
    //   1295	1314	857	finally
    //   1354	1373	857	finally
    //   1413	1432	857	finally
    //   1441	1447	857	finally
    //   1452	1457	857	finally
    //   1500	1511	857	finally
    //   1551	1562	857	finally
    //   1602	1612	857	finally
    //   1652	1662	857	finally
    //   1702	1712	857	finally
    //   1776	1786	857	finally
    //   1826	1856	857	finally
    //   1896	1917	857	finally
    //   1968	1978	857	finally
    //   2018	2028	857	finally
    //   2068	2078	857	finally
    //   2181	2191	857	finally
    //   2231	2241	857	finally
    //   2281	2291	857	finally
    //   2331	2338	857	finally
    //   2374	2409	857	finally
    //   2448	2468	857	finally
    //   2470	2496	857	finally
    //   2503	2844	857	finally
    //   2846	2905	857	finally
    //   2912	2944	857	finally
    //   2953	2987	857	finally
    //   2998	3005	857	finally
    //   960	979	1450	java/lang/InterruptedException
    //   1441	1447	1450	java/lang/InterruptedException
    //   1057	1071	2372	java/lang/Exception
    //   1116	1122	2372	java/lang/Exception
    //   1162	1167	2372	java/lang/Exception
    //   1224	1255	2372	java/lang/Exception
    //   1295	1314	2372	java/lang/Exception
    //   1354	1373	2372	java/lang/Exception
    //   1413	1432	2372	java/lang/Exception
    //   1500	1511	2372	java/lang/Exception
    //   1551	1562	2372	java/lang/Exception
    //   1602	1612	2372	java/lang/Exception
    //   1652	1662	2372	java/lang/Exception
    //   1702	1712	2372	java/lang/Exception
    //   1776	1786	2372	java/lang/Exception
    //   1826	1856	2372	java/lang/Exception
    //   1968	1978	2372	java/lang/Exception
    //   2018	2028	2372	java/lang/Exception
    //   2068	2078	2372	java/lang/Exception
    //   2181	2191	2372	java/lang/Exception
    //   2231	2241	2372	java/lang/Exception
    //   2281	2291	2372	java/lang/Exception
    //   2331	2338	2372	java/lang/Exception
  }
  
  public long a(File paramFile)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaLangReflectField == null)
        {
          this.jdField_a_of_type_JavaLangReflectField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
          if (!this.jdField_a_of_type_JavaLangReflectField.isAccessible()) {
            this.jdField_a_of_type_JavaLangReflectField.setAccessible(true);
          }
        }
        Object localObject = this.jdField_a_of_type_JavaLangReflectField.get(null);
        if (this.jdField_a_of_type_JavaLangReflectMethod == null) {
          this.jdField_a_of_type_JavaLangReflectMethod = localObject.getClass().getMethod("lstat", new Class[] { String.class });
        }
        paramFile = this.jdField_a_of_type_JavaLangReflectMethod.invoke(localObject, new Object[] { paramFile.getAbsolutePath() });
        if (this.jdField_b_of_type_JavaLangReflectField == null)
        {
          this.jdField_b_of_type_JavaLangReflectField = paramFile.getClass().getDeclaredField("st_atime");
          if (!this.jdField_b_of_type_JavaLangReflectField.isAccessible()) {
            this.jdField_b_of_type_JavaLangReflectField.setAccessible(true);
          }
        }
        l = this.jdField_b_of_type_JavaLangReflectField.getLong(paramFile);
        if (l != 0L) {
          continue;
        }
      }
      catch (ClassNotFoundException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (NoSuchMethodException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (IllegalAccessException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (InvocationTargetException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (NoSuchFieldException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        long l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      finally
      {
        if (0L != 0L) {
          break label313;
        }
      }
      return 0L;
      l = this.jdField_a_of_type_Long - l;
      if (l >= 0L) {
        return l;
      }
    }
    for (;;)
    {
      throw paramFile;
      label313:
      if (this.jdField_a_of_type_Long - 0L >= 0L) {}
    }
  }
  
  public long a(ArrayList<String> paramArrayList)
  {
    long l2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      l2 = 0L;
      return l2;
    }
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= paramArrayList.size()) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      String[] arrayOfString = new File(str).list();
      l2 = l1;
      if (arrayOfString != null)
      {
        l2 = l1;
        if (arrayOfString.length > 0)
        {
          int k = arrayOfString.length;
          int j = 0;
          for (;;)
          {
            l2 = l1;
            if (j >= k) {
              break;
            }
            File localFile = new File(str, arrayOfString[j]);
            l2 = l1;
            if (localFile.isFile()) {
              l2 = l1 + localFile.length();
            }
            j += 1;
            l1 = l2;
          }
        }
      }
      i += 1;
      l1 = l2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpt
 * JD-Core Version:    0.7.0.1
 */