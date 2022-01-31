import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.1;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bejl
{
  private static String jdField_a_of_type_JavaLangString = "MiniLogManager";
  private static boolean jdField_a_of_type_Boolean;
  private static final String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/";
  private static boolean jdField_b_of_type_Boolean;
  private static final String c = jdField_b_of_type_JavaLangString + "files/";
  private berk jdField_a_of_type_Berk;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  
  public static bejl a()
  {
    return bejm.a();
  }
  
  private String a()
  {
    if (beut.a().a() != null) {}
    for (String str = beut.a().a(); (this.jdField_a_of_type_Berk == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Berk.d)); str = "") {
      return c;
    }
    if (TextUtils.isEmpty(str)) {
      return c + bfgt.c(this.jdField_a_of_type_Berk.d) + "/" + bfgt.c(str);
    }
    return c + bfgt.c(this.jdField_a_of_type_Berk.d) + "/" + bfgt.c(str);
  }
  
  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      str = "tmp";
    }
    for (;;)
    {
      d();
      str = a() + "/" + str;
      if (paramInt == 2) {
        a(str);
      }
      return str;
      str = "tmp";
      continue;
      str = "store";
      continue;
      str = "usr";
      continue;
      str = "precache";
    }
  }
  
  public static String a(File paramFile)
  {
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf(".");
    if (i < 0) {
      return "";
    }
    return paramFile.substring(i + 1);
  }
  
  private static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    jdField_a_of_type_Boolean = true;
  }
  
  private void b()
  {
    bejn.b().post(new MiniAppFileManager.1(this));
  }
  
  private void c()
  {
    String str1 = a(0);
    String str2 = str1 + "_del_";
    belh.d(str1, str2);
    this.jdField_a_of_type_JavaUtilArrayList.add(str2);
  }
  
  /* Error */
  private static void d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 171	bejl:jdField_b_of_type_Boolean	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 33	java/io/File
    //   18: dup
    //   19: getstatic 52	bejl:c	Ljava/lang/String;
    //   22: ldc 173
    //   24: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 179	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +15 -> 49
    //   37: aload_2
    //   38: invokevirtual 137	java/io/File:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 140	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 137	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_1
    //   57: invokevirtual 182	java/io/File:createNewFile	()Z
    //   60: pop
    //   61: iconst_1
    //   62: putstatic 171	bejl:jdField_b_of_type_Boolean	Z
    //   65: goto -54 -> 11
    //   68: astore_1
    //   69: getstatic 20	bejl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: ldc 184
    //   74: aload_1
    //   75: invokestatic 189	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -67 -> 11
    //   81: astore_1
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   27	30	1	localFile1	File
    //   68	7	1	localIOException	java.io.IOException
    //   81	5	1	localObject	Object
    //   32	13	2	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   28	33	68	java/io/IOException
    //   37	49	68	java/io/IOException
    //   49	61	68	java/io/IOException
    //   61	65	68	java/io/IOException
    //   3	7	81	finally
    //   15	28	81	finally
    //   28	33	81	finally
    //   37	49	81	finally
    //   49	61	81	finally
    //   61	65	81	finally
    //   69	78	81	finally
  }
  
  private String i(String paramString)
  {
    if (paramString.startsWith("wxfile://tmp_")) {
      return paramString.replace("wxfile://tmp_", "");
    }
    if (paramString.startsWith("wxfile://store_")) {
      return paramString.replace("wxfile://store_", "");
    }
    if (paramString.startsWith("wxfile://usr")) {
      return new File(paramString.replace("wxfile://usr", "")).getName();
    }
    return "";
  }
  
  private static String j(String paramString)
  {
    String str2 = "";
    try
    {
      str1 = new URL(paramString).getPath();
      paramString = str1;
    }
    catch (Throwable localThrowable)
    {
      String str1;
      label17:
      int i;
      break label17;
    }
    str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf(".");
      str1 = str2;
      if (i != -1)
      {
        str1 = str2;
        if (i + 1 < paramString.length()) {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    return str1;
  }
  
  public int a(String paramString)
  {
    if (paramString.startsWith("wxfile://tmp_")) {
      return 0;
    }
    if (paramString.startsWith("wxfile://store_")) {
      return 1;
    }
    if (paramString.startsWith("wxfile://precache")) {
      return 4;
    }
    if (paramString.startsWith("wxfile://usr")) {
      return 2;
    }
    return 9999;
  }
  
  public String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))) {
        return paramString;
      }
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        String str2 = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          break label428;
        }
      }
      str1 = paramString;
      if (!paramString.startsWith("wxfile://"))
      {
        if (!paramString.startsWith("wxfile://")) {
          break label154;
        }
        str1 = paramString.replace("wxfile://", "wxfile://");
      }
      while (str1.startsWith("wxfile://tmp_"))
      {
        paramString = str1.replace("wxfile://tmp_", "");
        paramString = new File(a(0), paramString);
        if ((!paramString.exists()) || (!paramString.getCanonicalPath().startsWith(a()))) {
          break label425;
        }
        return paramString.getAbsolutePath();
        label154:
        str1 = paramString;
        if (paramString.startsWith("qqfile://")) {
          str1 = paramString.replace("qqfile://", "wxfile://");
        }
      }
      if (str1.startsWith("wxfile://store_"))
      {
        paramString = str1.replace("wxfile://store_", "");
        paramString = new File(a(1), paramString);
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(a()))) {
          return paramString.getAbsolutePath();
        }
      }
      else if (str1.startsWith("wxfile://usr"))
      {
        paramString = str1.replace("wxfile://usr", "");
        paramString = new File(a(2), paramString);
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(a()))) {
          return paramString.getAbsolutePath();
        }
      }
      else if (str1.startsWith("wxfile://precache"))
      {
        paramString = str1.replace("wxfile://precache", "");
        paramString = new File(a(4), paramString);
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(a()))) {
          return paramString.getAbsolutePath();
        }
      }
      else
      {
        paramString = new File(this.jdField_a_of_type_Berk.g(str1));
        if ((paramString.exists()) && (paramString.getCanonicalPath().startsWith(new File(this.jdField_a_of_type_Berk.e()).getCanonicalPath())))
        {
          paramString = this.jdField_a_of_type_Berk.g(str1);
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      betc.d(jdField_a_of_type_JavaLangString, "getAbsolutePath error.", paramString);
      return "";
    }
    label425:
    String str1 = "";
    label428:
    return str1;
    return paramString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.get(i) != null)
        {
          belh.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), false);
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public void a(berk paramberk)
  {
    this.jdField_a_of_type_Berk = paramberk;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
  }
  
  public void a(berk paramberk, boolean paramBoolean)
  {
    a(paramberk);
    if (paramBoolean)
    {
      c();
      return;
    }
    b();
  }
  
  public boolean a(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    int i;
    long l2;
    long l1;
    if (paramLong1 > 0L) {
      if (paramInt == 1)
      {
        i = 1;
        l2 = belh.b(a(i));
        if (!paramBoolean) {
          break label65;
        }
        l1 = 52428800L;
        label35:
        if ((paramInt != 2) || (paramLong2 <= 0L)) {
          break label75;
        }
      }
    }
    for (;;)
    {
      if (l2 + paramLong1 > paramLong2)
      {
        return false;
        i = 2;
        break;
        label65:
        l1 = 10485760L;
        break label35;
      }
      return true;
      label75:
      paramLong2 = l1;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new File(this.jdField_a_of_type_Berk.g(paramString));
      boolean bool1 = bool2;
      if (paramString.exists())
      {
        boolean bool3 = paramString.getCanonicalPath().startsWith(new File(this.jdField_a_of_type_Berk.e()).getCanonicalPath());
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public File[] a()
  {
    File localFile = new File(a(1));
    if (localFile.getCanonicalPath().startsWith(a())) {
      return localFile.listFiles();
    }
    return null;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "." + paramString)
    {
      paramString = bfgt.c(new StringBuilder().append(System.nanoTime()).append("").toString()) + paramString;
      File localFile = new File(a(0));
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, paramString).getAbsolutePath();
    }
  }
  
  public String c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramString.startsWith("wxfile://usr"))
      {
        paramString = paramString.replace("wxfile://usr", "");
        paramString = new File(a(2), paramString);
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.getCanonicalPath().startsWith(a())) {
        localObject1 = paramString.getAbsolutePath();
      }
      return localObject1;
    }
    catch (Throwable paramString)
    {
      betc.d(jdField_a_of_type_JavaLangString, "getUsrPath error", paramString);
    }
    return null;
  }
  
  public String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.startsWith("wxfile://store_"));
    String str = a(paramString);
    if (new File(str).exists())
    {
      paramString = i(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (belh.b(str, new File(a(1), paramString).getAbsolutePath())) {
        return "wxfile://" + "store" + "_" + paramString;
      }
    }
    return null;
  }
  
  public String e(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new File(paramString);
        String str = ((File)localObject).getParentFile().getAbsolutePath();
        if ((a(0).equals(str)) || (a(1).equals(str)))
        {
          if (((File)localObject).getParentFile().getName().equals("store"))
          {
            localObject = "store";
            paramString = new File(paramString).getName();
            return "wxfile://" + (String)localObject + "_" + paramString;
          }
        }
        else
        {
          if (str.startsWith(a(2)))
          {
            paramString = a(2);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return "wxfile://usr" + paramString;
          }
          if (str.startsWith(a(4)))
          {
            paramString = a(4);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return "wxfile://precache" + paramString;
          }
          if (new File(paramString).exists()) {
            return f(paramString);
          }
          return "";
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      Object localObject = "tmp";
    }
  }
  
  public String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = j(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (str = "";; str = "." + str)
    {
      str = bfgt.c(new StringBuilder().append(System.nanoTime()).append("").toString()) + str;
      str = "wxfile://" + "tmp" + "_" + str;
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      return str;
    }
  }
  
  public String g(String paramString)
  {
    return b(j(paramString));
  }
  
  /* Error */
  public String h(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 33	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: new 33	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: iconst_0
    //   19: invokespecial 115	bejl:a	(I)Ljava/lang/String;
    //   22: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 5
    //   27: aload 4
    //   29: invokevirtual 179	java/io/File:getParentFile	()Ljava/io/File;
    //   32: aload 5
    //   34: invokevirtual 333	java/io/File:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +5 -> 42
    //   40: aload_1
    //   41: areturn
    //   42: new 33	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: aload 4
    //   49: invokestatic 335	bejl:a	(Ljava/io/File;)Ljava/lang/String;
    //   52: invokevirtual 331	bejl:b	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 9
    //   60: sipush 8192
    //   63: newarray byte
    //   65: astore 7
    //   67: new 337	java/io/BufferedInputStream
    //   70: dup
    //   71: new 339	java/io/FileInputStream
    //   74: dup
    //   75: aload 4
    //   77: invokespecial 342	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   80: invokespecial 345	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore 4
    //   85: new 347	java/io/BufferedOutputStream
    //   88: dup
    //   89: new 349	java/io/FileOutputStream
    //   92: dup
    //   93: aload 9
    //   95: invokespecial 350	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: invokespecial 353	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: astore_1
    //   102: aload_1
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 4
    //   111: aload 7
    //   113: invokevirtual 359	java/io/InputStream:read	([B)I
    //   116: istore_2
    //   117: iload_2
    //   118: iconst_m1
    //   119: if_icmple +77 -> 196
    //   122: aload_1
    //   123: astore 6
    //   125: aload 4
    //   127: astore 5
    //   129: aload_1
    //   130: aload 7
    //   132: iconst_0
    //   133: iload_2
    //   134: invokevirtual 365	java/io/OutputStream:write	([BII)V
    //   137: goto -35 -> 102
    //   140: astore 7
    //   142: aload_1
    //   143: astore 6
    //   145: aload 4
    //   147: astore 5
    //   149: getstatic 20	bejl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   152: ldc_w 367
    //   155: aload 7
    //   157: invokestatic 372	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   160: pop
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 375	java/io/OutputStream:close	()V
    //   169: aload 4
    //   171: ifnull +154 -> 325
    //   174: aload 4
    //   176: invokevirtual 376	java/io/InputStream:close	()V
    //   179: iconst_0
    //   180: istore_2
    //   181: aload 8
    //   183: astore_1
    //   184: iload_2
    //   185: ifeq +9 -> 194
    //   188: aload 9
    //   190: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   193: astore_1
    //   194: aload_1
    //   195: areturn
    //   196: aload_1
    //   197: astore 6
    //   199: aload 4
    //   201: astore 5
    //   203: aload_1
    //   204: invokevirtual 379	java/io/OutputStream:flush	()V
    //   207: iconst_1
    //   208: istore_3
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 375	java/io/OutputStream:close	()V
    //   217: iload_3
    //   218: istore_2
    //   219: aload 4
    //   221: ifnull -40 -> 181
    //   224: aload 4
    //   226: invokevirtual 376	java/io/InputStream:close	()V
    //   229: iload_3
    //   230: istore_2
    //   231: goto -50 -> 181
    //   234: astore_1
    //   235: iload_3
    //   236: istore_2
    //   237: goto -56 -> 181
    //   240: astore_1
    //   241: iconst_0
    //   242: istore_2
    //   243: goto -62 -> 181
    //   246: astore_1
    //   247: aconst_null
    //   248: astore 6
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 6
    //   255: ifnull +8 -> 263
    //   258: aload 6
    //   260: invokevirtual 375	java/io/OutputStream:close	()V
    //   263: aload 4
    //   265: ifnull +8 -> 273
    //   268: aload 4
    //   270: invokevirtual 376	java/io/InputStream:close	()V
    //   273: aload_1
    //   274: athrow
    //   275: astore_1
    //   276: goto -59 -> 217
    //   279: astore_1
    //   280: goto -111 -> 169
    //   283: astore 5
    //   285: goto -22 -> 263
    //   288: astore 4
    //   290: goto -17 -> 273
    //   293: astore_1
    //   294: aconst_null
    //   295: astore 6
    //   297: goto -44 -> 253
    //   300: astore_1
    //   301: aload 5
    //   303: astore 4
    //   305: goto -52 -> 253
    //   308: astore 7
    //   310: aconst_null
    //   311: astore_1
    //   312: aconst_null
    //   313: astore 4
    //   315: goto -173 -> 142
    //   318: astore 7
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -180 -> 142
    //   325: iconst_0
    //   326: istore_2
    //   327: goto -146 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	bejl
    //   0	330	1	paramString	String
    //   116	211	2	i	int
    //   208	28	3	j	int
    //   11	258	4	localObject1	Object
    //   288	1	4	localIOException1	java.io.IOException
    //   303	11	4	localObject2	Object
    //   25	177	5	localObject3	Object
    //   283	19	5	localIOException2	java.io.IOException
    //   103	193	6	str	String
    //   65	66	7	arrayOfByte	byte[]
    //   140	16	7	localIOException3	java.io.IOException
    //   308	1	7	localIOException4	java.io.IOException
    //   318	1	7	localIOException5	java.io.IOException
    //   1	181	8	localObject4	Object
    //   58	131	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   109	117	140	java/io/IOException
    //   129	137	140	java/io/IOException
    //   203	207	140	java/io/IOException
    //   224	229	234	java/io/IOException
    //   174	179	240	java/io/IOException
    //   67	85	246	finally
    //   213	217	275	java/io/IOException
    //   165	169	279	java/io/IOException
    //   258	263	283	java/io/IOException
    //   268	273	288	java/io/IOException
    //   85	102	293	finally
    //   109	117	300	finally
    //   129	137	300	finally
    //   149	161	300	finally
    //   203	207	300	finally
    //   67	85	308	java/io/IOException
    //   85	102	318	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejl
 * JD-Core Version:    0.7.0.1
 */