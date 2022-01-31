import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.settings.FMSettings.1;
import com.tencent.mobileqq.filemanager.settings.FMSettings.4;
import com.tencent.mobileqq.filemanager.settings.FMSettings.5;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class armo
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  public bdfq a;
  public String a;
  public Map<String, armu> a;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  long c = System.currentTimeMillis() / 1000L;
  long d = 0L;
  
  private armo()
  {
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    a(2, "new FMSetting!");
    a();
  }
  
  private long a(String paramString, List<String> paramList)
  {
    long l1 = 0L;
    paramString = new File(paramString).listFiles();
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.length != 0) {
        break label35;
      }
      l2 = l1;
    }
    label35:
    int i;
    do
    {
      return l2;
      i = 0;
      l2 = l1;
    } while (i >= paramString.length);
    Object localObject = paramString[i];
    if (localObject.isDirectory()) {}
    for (l1 += a(localObject.getPath(), paramList);; l1 += paramString[i].length())
    {
      i += 1;
      break;
      if (paramList != null) {
        paramList.add(localObject.getAbsolutePath());
      }
    }
  }
  
  public static armo a()
  {
    return armt.a();
  }
  
  private String a(String paramString)
  {
    paramString = (paramString + "/Tencent/QQfile_recv/").replace("//", "/");
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  public static void a(int paramInt, String paramString) {}
  
  /* Error */
  private void a(File paramFile1, File paramFile2, armn paramarmn)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: invokevirtual 128	java/io/File:exists	()Z
    //   13: ifeq +12 -> 25
    //   16: aload_1
    //   17: invokevirtual 92	java/io/File:length	()J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifne +54 -> 76
    //   25: iconst_1
    //   26: ldc 150
    //   28: invokestatic 54	armo:a	(ILjava/lang/String;)V
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 152	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: iconst_0
    //   44: ifeq +11 -> 55
    //   47: new 152	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: aload_3
    //   56: aload_1
    //   57: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: aload_2
    //   61: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokeinterface 158 3 0
    //   69: aload_3
    //   70: invokeinterface 159 1 0
    //   75: return
    //   76: aload_2
    //   77: invokevirtual 128	java/io/File:exists	()Z
    //   80: ifeq +8 -> 88
    //   83: aload_2
    //   84: invokevirtual 162	java/io/File:delete	()Z
    //   87: pop
    //   88: new 164	java/io/FileOutputStream
    //   91: dup
    //   92: aload_2
    //   93: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   96: astore 5
    //   98: new 169	java/io/FileInputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: astore 6
    //   108: invokestatic 176	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   111: sipush 4096
    //   114: invokevirtual 180	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   117: astore 7
    //   119: aload 6
    //   121: aload 7
    //   123: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   126: istore 4
    //   128: iload 4
    //   130: iconst_m1
    //   131: if_icmpeq +69 -> 200
    //   134: aload_0
    //   135: getfield 29	armo:jdField_a_of_type_Boolean	Z
    //   138: ifne +62 -> 200
    //   141: aload 5
    //   143: aload 7
    //   145: iconst_0
    //   146: iload 4
    //   148: invokevirtual 188	java/io/FileOutputStream:write	([BII)V
    //   151: aload 5
    //   153: invokevirtual 191	java/io/FileOutputStream:flush	()V
    //   156: aload_3
    //   157: iload 4
    //   159: i2l
    //   160: lconst_0
    //   161: invokeinterface 194 5 0
    //   166: goto -47 -> 119
    //   169: astore_1
    //   170: aload 6
    //   172: astore_2
    //   173: aload 5
    //   175: astore_1
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 198	java/io/FileInputStream:close	()V
    //   192: aload_3
    //   193: iconst_m1
    //   194: invokeinterface 201 2 0
    //   199: return
    //   200: invokestatic 176	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   203: aload 7
    //   205: invokevirtual 205	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 198	java/io/FileInputStream:close	()V
    //   228: aload_3
    //   229: aload_1
    //   230: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   233: aload_2
    //   234: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   237: invokeinterface 158 3 0
    //   242: aload_3
    //   243: invokeinterface 159 1 0
    //   248: return
    //   249: astore_1
    //   250: aconst_null
    //   251: astore 5
    //   253: aload 8
    //   255: astore_1
    //   256: aload 5
    //   258: ifnull +8 -> 266
    //   261: aload 5
    //   263: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 198	java/io/FileInputStream:close	()V
    //   274: aload_3
    //   275: iconst_m1
    //   276: invokeinterface 201 2 0
    //   281: return
    //   282: astore_1
    //   283: aconst_null
    //   284: astore 5
    //   286: aload 9
    //   288: astore_1
    //   289: aload 5
    //   291: ifnull +8 -> 299
    //   294: aload 5
    //   296: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 198	java/io/FileInputStream:close	()V
    //   307: aload_3
    //   308: iconst_m1
    //   309: invokeinterface 201 2 0
    //   314: return
    //   315: astore 7
    //   317: aconst_null
    //   318: astore 5
    //   320: aconst_null
    //   321: astore 6
    //   323: aload 5
    //   325: ifnull +8 -> 333
    //   328: aload 5
    //   330: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   333: aload 6
    //   335: ifnull +8 -> 343
    //   338: aload 6
    //   340: invokevirtual 198	java/io/FileInputStream:close	()V
    //   343: aload_3
    //   344: aload_1
    //   345: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   348: aload_2
    //   349: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   352: invokeinterface 158 3 0
    //   357: aload_3
    //   358: invokeinterface 159 1 0
    //   363: aload 7
    //   365: athrow
    //   366: astore 5
    //   368: goto -325 -> 43
    //   371: astore 5
    //   373: goto -318 -> 55
    //   376: astore 5
    //   378: goto -160 -> 218
    //   381: astore 5
    //   383: goto -155 -> 228
    //   386: astore_1
    //   387: goto -203 -> 184
    //   390: astore_1
    //   391: goto -199 -> 192
    //   394: astore_2
    //   395: goto -129 -> 266
    //   398: astore_1
    //   399: goto -125 -> 274
    //   402: astore_2
    //   403: goto -104 -> 299
    //   406: astore_1
    //   407: goto -100 -> 307
    //   410: astore 5
    //   412: goto -79 -> 333
    //   415: astore 5
    //   417: goto -74 -> 343
    //   420: astore 7
    //   422: aconst_null
    //   423: astore 6
    //   425: goto -102 -> 323
    //   428: astore 7
    //   430: goto -107 -> 323
    //   433: astore_1
    //   434: aload 9
    //   436: astore_1
    //   437: goto -148 -> 289
    //   440: astore_1
    //   441: aload 6
    //   443: astore_1
    //   444: goto -155 -> 289
    //   447: astore_1
    //   448: aload 8
    //   450: astore_1
    //   451: goto -195 -> 256
    //   454: astore_1
    //   455: aload 6
    //   457: astore_1
    //   458: goto -202 -> 256
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_1
    //   464: aload 7
    //   466: astore_2
    //   467: goto -291 -> 176
    //   470: astore_1
    //   471: aload 5
    //   473: astore_1
    //   474: aload 7
    //   476: astore_2
    //   477: goto -301 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	armo
    //   0	480	1	paramFile1	File
    //   0	480	2	paramFile2	File
    //   0	480	3	paramarmn	armn
    //   126	32	4	i	int
    //   96	233	5	localFileOutputStream	java.io.FileOutputStream
    //   366	1	5	localException1	Exception
    //   371	1	5	localException2	Exception
    //   376	1	5	localException3	Exception
    //   381	1	5	localException4	Exception
    //   410	1	5	localException5	Exception
    //   415	57	5	localException6	Exception
    //   106	350	6	localFileInputStream	java.io.FileInputStream
    //   7	197	7	arrayOfByte	byte[]
    //   315	49	7	localObject1	Object
    //   420	1	7	localObject2	Object
    //   428	47	7	localObject3	Object
    //   1	448	8	localObject4	Object
    //   4	431	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   108	119	169	java/io/IOException
    //   119	128	169	java/io/IOException
    //   134	166	169	java/io/IOException
    //   200	208	169	java/io/IOException
    //   9	25	249	java/lang/OutOfMemoryError
    //   25	31	249	java/lang/OutOfMemoryError
    //   76	88	249	java/lang/OutOfMemoryError
    //   88	98	249	java/lang/OutOfMemoryError
    //   9	25	282	java/lang/Exception
    //   25	31	282	java/lang/Exception
    //   76	88	282	java/lang/Exception
    //   88	98	282	java/lang/Exception
    //   9	25	315	finally
    //   25	31	315	finally
    //   76	88	315	finally
    //   88	98	315	finally
    //   35	43	366	java/lang/Exception
    //   47	55	371	java/lang/Exception
    //   213	218	376	java/lang/Exception
    //   223	228	381	java/lang/Exception
    //   180	184	386	java/lang/Exception
    //   188	192	390	java/lang/Exception
    //   261	266	394	java/lang/Exception
    //   270	274	398	java/lang/Exception
    //   294	299	402	java/lang/Exception
    //   303	307	406	java/lang/Exception
    //   328	333	410	java/lang/Exception
    //   338	343	415	java/lang/Exception
    //   98	108	420	finally
    //   108	119	428	finally
    //   119	128	428	finally
    //   134	166	428	finally
    //   200	208	428	finally
    //   98	108	433	java/lang/Exception
    //   108	119	440	java/lang/Exception
    //   119	128	440	java/lang/Exception
    //   134	166	440	java/lang/Exception
    //   200	208	440	java/lang/Exception
    //   98	108	447	java/lang/OutOfMemoryError
    //   108	119	454	java/lang/OutOfMemoryError
    //   119	128	454	java/lang/OutOfMemoryError
    //   134	166	454	java/lang/OutOfMemoryError
    //   200	208	454	java/lang/OutOfMemoryError
    //   9	25	461	java/io/IOException
    //   25	31	461	java/io/IOException
    //   76	88	461	java/io/IOException
    //   88	98	461	java/io/IOException
    //   98	108	470	java/io/IOException
  }
  
  private void a(List<String> paramList, armn paramarmn)
  {
    a(1, "moveFileToDefaultPath");
    if ((paramList == null) || (paramList.size() == 0)) {
      a(1, "moveFileToDefaultPath,lstPath is null or size = 0");
    }
    Object localObject;
    String str1;
    int j;
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Long = 0L;
      try
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          this.jdField_b_of_type_Long += arof.a(str1);
        }
        a(1, "moveFileToDefaultPath,total size[" + this.jdField_b_of_type_Long + "]");
      }
      finally {}
      if (this.jdField_b_of_type_Long == 0L)
      {
        paramarmn.a();
        return;
      }
      str1 = d().jdField_b_of_type_JavaLangString + d().c;
      j = paramList.size();
      i = 0;
    } while (i >= j);
    String str2 = (String)paramList.get(i);
    if (str2.contains("/.tmp/")) {
      localObject = b(str1) + arni.a(str2);
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new File((String)localObject);
        try
        {
          ThreadManager.post(new FMSettings.4(this, str2, (File)localObject, j, paramarmn), 8, null, false);
          i += 1;
        }
        catch (Exception paramList)
        {
          a(1, "copyFile Fail! " + paramList.toString());
        }
      }
      if (str2.contains("/.thumbnails/")) {
        localObject = c(str1) + arni.a(str2);
      } else {
        localObject = a(str1) + arni.a(str2);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    File localFile = new File(paramString);
    boolean bool = false;
    if (!localFile.exists()) {
      bool = localFile.mkdirs();
    }
    if (bool) {
      a(2, "create [" + paramString + "] success!");
    }
    return bool;
  }
  
  private armu b()
  {
    return (armu)this.jdField_a_of_type_JavaUtilMap.get("sdCard");
  }
  
  private String b(String paramString)
  {
    paramString = (paramString + "/Tencent/QQfile_recv/.tmp/").replace("//", "/");
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  private armu c()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1) {
      return null;
    }
    return (armu)this.jdField_a_of_type_JavaUtilMap.get("externalSdCard");
  }
  
  private String c(String paramString)
  {
    paramString = (paramString + "/Tencent/QQfile_recv/.thumbnails/").replace("//", "/");
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  private void c()
  {
    armu localarmu = a();
    if (localarmu == null) {
      return;
    }
    ThreadManager.post(new FMSettings.1(this, b(localarmu.jdField_b_of_type_JavaLangString + localarmu.c)), 8, null, false);
  }
  
  private armu d()
  {
    a(2, "getDefaultStorage[" + this.jdField_a_of_type_JavaUtilMap.size() + "]");
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (armu)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      ((armu)localObject2).a();
      if (((armu)localObject2).jdField_a_of_type_Boolean)
      {
        a(2, "getDefaultStorage[" + ((armu)localObject2).jdField_b_of_type_JavaLangString + "] + ext[" + ((armu)localObject2).c + "]");
        return localObject2;
      }
    }
    a(2, "getDefaultStorage nothing is default refresh!");
    Object localObject2 = (armu)this.jdField_a_of_type_JavaUtilMap.get("sdCard");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new armu(this, null);
      ((armu)localObject1).jdField_a_of_type_Boolean = true;
      ((armu)localObject1).jdField_a_of_type_JavaLangString = "SD卡";
      ((armu)localObject1).jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath();
      ((armu)localObject1).c = "";
    }
    ((armu)localObject1).a(BaseApplicationImpl.getContext());
    return localObject1;
  }
  
  public long a()
  {
    Object localObject = d().jdField_b_of_type_JavaLangString;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public armu a()
  {
    a(2, "getOtherStorage[" + this.jdField_a_of_type_JavaUtilMap.size() + "]");
    armu localarmu = d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (armu)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      if (localarmu != localObject) {
        return localObject;
      }
    }
    a(2, "getOtherStorage nothing is default refresh!");
    return null;
  }
  
  public String a()
  {
    armu localarmu = a();
    if (localarmu == null) {
      return null;
    }
    return a(localarmu.jdField_b_of_type_JavaLangString + localarmu.c);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Map localMap = arni.a(localBaseApplication);
    a(1, "qurey strorages[" + localMap.size() + "]");
    String str1 = localBaseApplication.getSharedPreferences("FMSETTING_59", 4).getString("DefaultRootPath", aljq.aW);
    a(1, "qurey defaultRootPath[" + str1 + "]");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    Iterator localIterator = localMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      for (;;)
      {
        Object localObject;
        armu localarmu;
        try
        {
          localObject = ((File)localMap.get(str2)).getPath();
          localarmu = new armu(this, null);
          localarmu.jdField_a_of_type_Boolean = false;
          if (!str2.equalsIgnoreCase("sdCard")) {
            break label402;
          }
          localarmu.jdField_a_of_type_JavaLangString = "SD卡";
          localarmu.jdField_b_of_type_JavaLangString = ((String)localObject);
          localarmu.c = "";
          a(1, "rootPath[" + localarmu.jdField_b_of_type_JavaLangString + "],bDefault[" + localarmu.jdField_a_of_type_Boolean + "]");
          localObject = new StatFs((String)localObject);
          localarmu.jdField_a_of_type_Long = (((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize());
          a(4, "defaultRootPath[" + str1 + "].equalsIgnoreCase(si.rootPath[" + localarmu.jdField_b_of_type_JavaLangString + "])");
          if ((localMap.size() == 1) || (str1.equalsIgnoreCase(localarmu.jdField_b_of_type_JavaLangString)))
          {
            a(4, "defaultRootPath.equalsIgnoreCase(si.rootPath) = true");
            localarmu.jdField_a_of_type_Boolean = true;
            localarmu.a(localBaseApplication);
          }
          localarmu.a();
          this.jdField_a_of_type_JavaUtilMap.put(str2, localarmu);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        break;
        label402:
        if (localException.equalsIgnoreCase("externalSdCard"))
        {
          localarmu.jdField_a_of_type_JavaLangString = "外置SD卡";
          localBaseApplication.getExternalFilesDir(null);
          String str3 = BaseApplicationImpl.sApplication.getPackageName();
          localarmu.jdField_b_of_type_JavaLangString = ((String)localObject);
          localarmu.c = ("/Android/data/" + str3 + "/");
        }
      }
    }
  }
  
  public void a(long paramLong, List<String> arg3, Activity paramActivity, armn paramarmn)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      long l;
      synchronized (BaseApplicationImpl.getContext())
      {
        this.jdField_b_of_type_Boolean = true;
        l = b();
        if (!a())
        {
          paramarmn.a(12);
          synchronized (BaseApplicationImpl.getContext())
          {
            this.jdField_b_of_type_Boolean = false;
            return;
          }
        }
      }
      if (l < paramLong)
      {
        paramarmn.a(16);
        synchronized (BaseApplicationImpl.getContext())
        {
          this.jdField_b_of_type_Boolean = false;
          return;
        }
      }
      a(1, "showChoosePath, callback[" + paramarmn + "]");
      ??? = b();
      armu localarmu = c();
      if (((armu)???).jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = alpo.a(2131705043);
      }
      for (this.jdField_b_of_type_JavaLangString = (a().jdField_b_of_type_JavaLangString + a().c + "/Tencent/QQfile_recv/").replace("//", "/"); paramActivity != null; this.jdField_b_of_type_JavaLangString = (a().jdField_b_of_type_JavaLangString + a().c + "/Tencent/QQfile_recv/").replace("//", "/"))
      {
        label216:
        paramActivity.runOnUiThread(new FMSettings.5(this, paramActivity, ???, paramarmn));
        return;
        if ((localarmu == null) || (!localarmu.jdField_a_of_type_Boolean)) {
          break label216;
        }
        this.jdField_a_of_type_JavaLangString = alpo.a(2131705039);
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        if (paramString != null) {
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        }
        if ("externalSdCard".equalsIgnoreCase(paramString))
        {
          ((armu)this.jdField_a_of_type_JavaUtilMap.get("sdCard")).a(BaseApplicationImpl.getContext());
          return;
        }
      }
    }
    catch (Exception paramString) {}
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1) {}
    while (c() == null) {
      return false;
    }
    return true;
  }
  
  public long b()
  {
    Object localObject = a();
    if (localObject == null) {
      return 0L;
    }
    localObject = ((armu)localObject).jdField_b_of_type_JavaLangString;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public String b()
  {
    return aljq.bm;
  }
  
  public void b()
  {
    try
    {
      a(1, "FMSettings free");
      Field localField = this.jdField_a_of_type_Bdfq.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_Bdfq, Boolean.valueOf(true));
      this.jdField_a_of_type_Bdfq.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String c()
  {
    return aljq.bo;
  }
  
  public String d()
  {
    return aljq.bn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armo
 * JD-Core Version:    0.7.0.1
 */