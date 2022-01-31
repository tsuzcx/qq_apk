import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Properties;
import java.util.Set;

public class ammx
{
  private static File jdField_a_of_type_JavaIoFile;
  private static Properties jdField_a_of_type_JavaUtilProperties;
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (jdField_a_of_type_JavaUtilProperties == null) {
      a(paramContext);
    }
    a("read, size:" + jdField_a_of_type_JavaUtilProperties.size() + ", names:" + jdField_a_of_type_JavaUtilProperties.stringPropertyNames().toString());
    if (jdField_a_of_type_JavaUtilProperties.stringPropertyNames().contains(paramString1)) {
      return jdField_a_of_type_JavaUtilProperties.getProperty(paramString1);
    }
    return b(paramContext, paramString1, paramString2);
  }
  
  /* Error */
  private static void a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   3: ifnull +4 -> 7
    //   6: return
    //   7: getstatic 70	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +205 -> 217
    //   15: aload_0
    //   16: ifnull -10 -> 6
    //   19: new 72	java/io/File
    //   22: dup
    //   23: new 15	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: invokevirtual 78	android/content/Context:getFilesDir	()Ljava/io/File;
    //   34: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: getstatic 85	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 87
    //   45: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: putstatic 91	ammx:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   57: new 15	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   64: ldc 93
    //   66: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 91	ammx:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   72: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   84: getstatic 91	ammx:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   87: invokevirtual 100	java/io/File:exists	()Z
    //   90: ifne +10 -> 100
    //   93: getstatic 91	ammx:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   96: invokevirtual 103	java/io/File:createNewFile	()Z
    //   99: pop
    //   100: new 27	java/util/Properties
    //   103: dup
    //   104: invokespecial 104	java/util/Properties:<init>	()V
    //   107: putstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   110: aconst_null
    //   111: astore_0
    //   112: new 106	java/io/FileInputStream
    //   115: dup
    //   116: getstatic 91	ammx:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   119: invokevirtual 109	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   122: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_1
    //   126: aload_1
    //   127: astore_0
    //   128: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   131: aload_1
    //   132: invokevirtual 116	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   135: aload_1
    //   136: ifnull -130 -> 6
    //   139: aload_1
    //   140: invokevirtual 119	java/io/FileInputStream:close	()V
    //   143: return
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   149: return
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   155: goto -55 -> 100
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   167: aload_1
    //   168: ifnull -162 -> 6
    //   171: aload_1
    //   172: invokevirtual 119	java/io/FileInputStream:close	()V
    //   175: return
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   181: return
    //   182: astore_2
    //   183: aload_0
    //   184: astore_1
    //   185: aload_2
    //   186: astore_0
    //   187: aload_1
    //   188: ifnull +7 -> 195
    //   191: aload_1
    //   192: invokevirtual 119	java/io/FileInputStream:close	()V
    //   195: aload_0
    //   196: athrow
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   202: goto -7 -> 195
    //   205: astore_2
    //   206: aload_0
    //   207: astore_1
    //   208: aload_2
    //   209: astore_0
    //   210: goto -23 -> 187
    //   213: astore_2
    //   214: goto -53 -> 161
    //   217: aload_1
    //   218: astore_0
    //   219: goto -204 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramContext	Context
    //   10	182	1	localObject1	Object
    //   197	2	1	localIOException1	java.io.IOException
    //   207	11	1	localContext	Context
    //   158	6	2	localIOException2	java.io.IOException
    //   182	4	2	localObject2	Object
    //   205	4	2	localObject3	Object
    //   213	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   139	143	144	java/io/IOException
    //   93	100	150	java/io/IOException
    //   112	126	158	java/io/IOException
    //   171	175	176	java/io/IOException
    //   112	126	182	finally
    //   191	195	197	java/io/IOException
    //   128	135	205	finally
    //   163	167	205	finally
    //   128	135	213	java/io/IOException
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 127	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   5: iconst_1
    //   6: if_icmpeq +9 -> 15
    //   9: ldc 129
    //   11: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   14: return
    //   15: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   18: ifnonnull +7 -> 25
    //   21: aload_0
    //   22: invokestatic 13	ammx:a	(Landroid/content/Context;)V
    //   25: new 15	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   32: ldc 131
    //   34: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   40: invokevirtual 31	java/util/Properties:size	()I
    //   43: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc 36
    //   48: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   54: invokevirtual 40	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   57: invokevirtual 44	java/lang/Object:toString	()Ljava/lang/String;
    //   60: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   69: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 135	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   77: pop
    //   78: new 15	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   85: ldc 137
    //   87: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   93: invokevirtual 31	java/util/Properties:size	()I
    //   96: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc 36
    //   101: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   107: invokevirtual 40	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   110: invokevirtual 44	java/lang/Object:toString	()Ljava/lang/String;
    //   113: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   122: new 139	java/io/FileOutputStream
    //   125: dup
    //   126: getstatic 91	ammx:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   129: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   132: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   135: astore_1
    //   136: aload_1
    //   137: astore_0
    //   138: getstatic 10	ammx:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   141: aload_1
    //   142: aconst_null
    //   143: invokevirtual 144	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   146: aload_1
    //   147: ifnull -133 -> 14
    //   150: aload_1
    //   151: invokevirtual 147	java/io/FileOutputStream:flush	()V
    //   154: aload_1
    //   155: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   164: return
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: astore_0
    //   170: aload_2
    //   171: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   174: aload_1
    //   175: ifnull -161 -> 14
    //   178: aload_1
    //   179: invokevirtual 147	java/io/FileOutputStream:flush	()V
    //   182: aload_1
    //   183: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   186: return
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   192: return
    //   193: astore_0
    //   194: aload_3
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +11 -> 208
    //   200: aload_1
    //   201: invokevirtual 147	java/io/FileOutputStream:flush	()V
    //   204: aload_1
    //   205: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   215: goto -7 -> 208
    //   218: astore_2
    //   219: aload_0
    //   220: astore_1
    //   221: aload_2
    //   222: astore_0
    //   223: goto -27 -> 196
    //   226: astore_2
    //   227: goto -59 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramContext	Context
    //   0	230	1	paramString1	String
    //   0	230	2	paramString2	String
    //   1	194	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   150	158	159	java/io/IOException
    //   122	136	165	java/io/IOException
    //   178	186	187	java/io/IOException
    //   122	136	193	finally
    //   200	208	210	java/io/IOException
    //   138	146	218	finally
    //   170	174	218	finally
    //   138	146	226	java/io/IOException
  }
  
  private static void a(String paramString)
  {
    QLog.d("PropertiesUtils", 1, paramString);
  }
  
  /* Error */
  private static String b(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: ldc 160
    //   6: aload_1
    //   7: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +5 -> 15
    //   13: aload_2
    //   14: areturn
    //   15: getstatic 70	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: ifnonnull +5 -> 30
    //   28: aload_0
    //   29: astore_3
    //   30: new 27	java/util/Properties
    //   33: dup
    //   34: invokespecial 104	java/util/Properties:<init>	()V
    //   37: astore 5
    //   39: new 72	java/io/File
    //   42: dup
    //   43: new 15	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   50: aload_3
    //   51: invokevirtual 78	android/content/Context:getFilesDir	()Ljava/io/File;
    //   54: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc 167
    //   59: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 100	java/io/File:exists	()Z
    //   73: ifeq -60 -> 13
    //   76: new 106	java/io/FileInputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: astore 4
    //   86: aload 4
    //   88: astore_3
    //   89: aload 5
    //   91: aload 4
    //   93: invokevirtual 116	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   96: aload 4
    //   98: astore_3
    //   99: aload 5
    //   101: ldc 169
    //   103: invokevirtual 58	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload 4
    //   110: astore_3
    //   111: new 15	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   118: ldc 171
    //   120: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 5
    //   125: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   134: aload 4
    //   136: astore_3
    //   137: aload_0
    //   138: aload_1
    //   139: aload 5
    //   141: invokestatic 173	ammx:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 4
    //   146: invokevirtual 119	java/io/FileInputStream:close	()V
    //   149: aload 5
    //   151: areturn
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   157: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   160: aload 5
    //   162: areturn
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: astore_3
    //   168: aload_1
    //   169: invokevirtual 177	java/io/IOException:getMessage	()Ljava/lang/String;
    //   172: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   175: aload_0
    //   176: invokevirtual 119	java/io/FileInputStream:close	()V
    //   179: aload_2
    //   180: areturn
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   189: aload_2
    //   190: areturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: invokevirtual 119	java/io/FileInputStream:close	()V
    //   198: aload_0
    //   199: athrow
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   205: invokestatic 48	ammx:a	(Ljava/lang/String;)V
    //   208: goto -10 -> 198
    //   211: astore_0
    //   212: goto -18 -> 194
    //   215: astore_1
    //   216: aload 4
    //   218: astore_0
    //   219: goto -53 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramContext	Context
    //   0	222	1	paramString1	String
    //   0	222	2	paramString2	String
    //   22	173	3	localObject1	Object
    //   18	199	4	localObject2	Object
    //   37	124	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   144	149	152	java/lang/Exception
    //   76	86	163	java/io/IOException
    //   175	179	181	java/lang/Exception
    //   76	86	191	finally
    //   194	198	200	java/lang/Exception
    //   89	96	211	finally
    //   99	108	211	finally
    //   111	134	211	finally
    //   137	144	211	finally
    //   168	175	211	finally
    //   89	96	215	java/io/IOException
    //   99	108	215	java/io/IOException
    //   111	134	215	java/io/IOException
    //   137	144	215	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ammx
 * JD-Core Version:    0.7.0.1
 */