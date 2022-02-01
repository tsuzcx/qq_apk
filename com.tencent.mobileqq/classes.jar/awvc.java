import android.content.Context;
import android.os.Environment;
import java.io.File;

public abstract class awvc
{
  static String a = "";
  static String b = "";
  static String c = "";
  
  public static String a(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      paramContext = new File(Environment.getExternalStorageDirectory().getPath() + paramString);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 40	java/io/File
    //   6: dup
    //   7: getstatic 84	antf:bf	Ljava/lang/String;
    //   10: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 65	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 68	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 86	java/io/FileWriter
    //   29: dup
    //   30: new 40	java/io/File
    //   33: dup
    //   34: new 46	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   41: getstatic 84	antf:bf	Ljava/lang/String;
    //   44: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 88
    //   49: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: iconst_1
    //   59: invokespecial 91	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   62: astore_3
    //   63: aload_3
    //   64: new 46	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   71: ldc 93
    //   73: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 14	awvc:a	Ljava/lang/String;
    //   79: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 95
    //   84: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: getstatic 16	awvc:b	Ljava/lang/String;
    //   90: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 97
    //   95: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: getstatic 18	awvc:c	Ljava/lang/String;
    //   101: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 99
    //   106: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokestatic 103	com/tencent/common/config/AppSetting:b	()Ljava/lang/String;
    //   112: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   121: aload_3
    //   122: ldc 108
    //   124: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   127: new 110	android/text/format/Time
    //   130: dup
    //   131: invokespecial 111	android/text/format/Time:<init>	()V
    //   134: astore 4
    //   136: aload 4
    //   138: invokevirtual 114	android/text/format/Time:setToNow	()V
    //   141: aload_3
    //   142: new 46	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   149: aload 4
    //   151: ldc 116
    //   153: invokevirtual 120	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 122
    //   161: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   170: aload_3
    //   171: ldc 124
    //   173: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   176: aload_3
    //   177: ldc 108
    //   179: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   182: aload_0
    //   183: ifnull +31 -> 214
    //   186: aload_3
    //   187: new 46	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   194: ldc 126
    //   196: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 128
    //   205: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   214: aload_3
    //   215: aload_1
    //   216: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   219: aload_3
    //   220: ldc 108
    //   222: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   225: aload_3
    //   226: invokevirtual 131	java/io/FileWriter:close	()V
    //   229: iconst_0
    //   230: ifeq +11 -> 241
    //   233: new 133	java/lang/NullPointerException
    //   236: dup
    //   237: invokespecial 134	java/lang/NullPointerException:<init>	()V
    //   240: athrow
    //   241: return
    //   242: astore_1
    //   243: aload 4
    //   245: astore_0
    //   246: aload_1
    //   247: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   250: aload_0
    //   251: ifnull -10 -> 241
    //   254: aload_0
    //   255: invokevirtual 131	java/io/FileWriter:close	()V
    //   258: return
    //   259: astore_0
    //   260: return
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull +7 -> 272
    //   268: aload_1
    //   269: invokevirtual 131	java/io/FileWriter:close	()V
    //   272: aload_0
    //   273: athrow
    //   274: astore_0
    //   275: return
    //   276: astore_1
    //   277: goto -5 -> 272
    //   280: astore_0
    //   281: aload_3
    //   282: astore_1
    //   283: goto -19 -> 264
    //   286: astore_3
    //   287: aload_0
    //   288: astore_1
    //   289: aload_3
    //   290: astore_0
    //   291: goto -27 -> 264
    //   294: astore_1
    //   295: aload_3
    //   296: astore_0
    //   297: goto -51 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramString1	String
    //   0	300	1	paramString2	String
    //   0	300	2	paramBoolean	boolean
    //   13	269	3	localObject1	Object
    //   286	10	3	localObject2	Object
    //   1	243	4	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   3	26	242	java/lang/Exception
    //   26	63	242	java/lang/Exception
    //   254	258	259	java/lang/Exception
    //   3	26	261	finally
    //   26	63	261	finally
    //   233	241	274	java/lang/Exception
    //   268	272	276	java/lang/Exception
    //   63	182	280	finally
    //   186	214	280	finally
    //   214	229	280	finally
    //   246	250	286	finally
    //   63	182	294	java/lang/Exception
    //   186	214	294	java/lang/Exception
    //   214	229	294	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvc
 * JD-Core Version:    0.7.0.1
 */