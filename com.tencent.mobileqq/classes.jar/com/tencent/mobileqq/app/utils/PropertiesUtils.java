package com.tencent.mobileqq.app.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtils
{
  private static File jdField_a_of_type_JavaIoFile;
  private static Properties jdField_a_of_type_JavaUtilProperties;
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (jdField_a_of_type_JavaUtilProperties == null) {
      a(paramContext);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("read, size:");
    localStringBuilder.append(jdField_a_of_type_JavaUtilProperties.size());
    localStringBuilder.append(", names:");
    localStringBuilder.append(jdField_a_of_type_JavaUtilProperties.stringPropertyNames().toString());
    a(localStringBuilder.toString());
    if (jdField_a_of_type_JavaUtilProperties.stringPropertyNames().contains(paramString1)) {
      return jdField_a_of_type_JavaUtilProperties.getProperty(paramString1);
    }
    return b(paramContext, paramString1, paramString2);
  }
  
  /* Error */
  private static void a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   3: ifnull +4 -> 7
    //   6: return
    //   7: invokestatic 72	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +6 -> 18
    //   15: goto +5 -> 20
    //   18: aload_1
    //   19: astore_0
    //   20: aload_0
    //   21: ifnonnull +4 -> 25
    //   24: return
    //   25: new 21	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   32: astore_1
    //   33: aload_1
    //   34: aload_0
    //   35: invokevirtual 78	android/content/Context:getFilesDir	()Ljava/io/File;
    //   38: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: getstatic 87	java/io/File:separator	Ljava/lang/String;
    //   46: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: ldc 89
    //   53: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: new 83	java/io/File
    //   60: dup
    //   61: aload_1
    //   62: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: putstatic 93	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   71: new 21	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   78: astore_0
    //   79: aload_0
    //   80: ldc 95
    //   82: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_0
    //   87: getstatic 93	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   90: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   104: getstatic 93	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   107: invokevirtual 102	java/io/File:exists	()Z
    //   110: ifne +18 -> 128
    //   113: getstatic 93	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   116: invokevirtual 105	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: goto +8 -> 128
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   128: new 30	java/util/Properties
    //   131: dup
    //   132: invokespecial 109	java/util/Properties:<init>	()V
    //   135: putstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   138: aconst_null
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_0
    //   142: new 111	java/io/FileInputStream
    //   145: dup
    //   146: getstatic 93	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   149: invokevirtual 114	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   152: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   155: astore_1
    //   156: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   159: aload_1
    //   160: invokevirtual 121	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   163: aload_1
    //   164: invokevirtual 124	java/io/FileInputStream:close	()V
    //   167: return
    //   168: astore_0
    //   169: aload_1
    //   170: astore_2
    //   171: aload_0
    //   172: astore_1
    //   173: aload_2
    //   174: astore_0
    //   175: goto +37 -> 212
    //   178: astore_2
    //   179: goto +12 -> 191
    //   182: astore_1
    //   183: goto +29 -> 212
    //   186: astore_0
    //   187: aload_2
    //   188: astore_1
    //   189: aload_0
    //   190: astore_2
    //   191: aload_1
    //   192: astore_0
    //   193: aload_2
    //   194: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   197: aload_1
    //   198: ifnull +13 -> 211
    //   201: aload_1
    //   202: invokevirtual 124	java/io/FileInputStream:close	()V
    //   205: return
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   211: return
    //   212: aload_0
    //   213: ifnull +15 -> 228
    //   216: aload_0
    //   217: invokevirtual 124	java/io/FileInputStream:close	()V
    //   220: goto +8 -> 228
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   228: aload_1
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramContext	Context
    //   10	163	1	localObject1	Object
    //   182	1	1	localObject2	Object
    //   188	41	1	localObject3	Object
    //   139	35	2	localObject4	Object
    //   178	10	2	localIOException	java.io.IOException
    //   190	4	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   113	120	123	java/io/IOException
    //   156	163	168	finally
    //   156	163	178	java/io/IOException
    //   142	156	182	finally
    //   193	197	182	finally
    //   142	156	186	java/io/IOException
    //   163	167	206	java/io/IOException
    //   201	205	206	java/io/IOException
    //   216	220	223	java/io/IOException
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 129	mqq/app/MobileQQ:sProcessId	I
    //   3: iconst_1
    //   4: if_icmpeq +9 -> 13
    //   7: ldc 131
    //   9: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   12: return
    //   13: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   16: ifnonnull +7 -> 23
    //   19: aload_0
    //   20: invokestatic 19	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Landroid/content/Context;)V
    //   23: new 21	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   30: astore_0
    //   31: aload_0
    //   32: ldc 133
    //   34: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   42: invokevirtual 34	java/util/Properties:size	()I
    //   45: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_0
    //   50: ldc 39
    //   52: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   60: invokevirtual 43	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   63: invokevirtual 47	java/lang/Object:toString	()Ljava/lang/String;
    //   66: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_0
    //   71: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   77: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   80: aload_1
    //   81: aload_2
    //   82: invokevirtual 137	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   85: pop
    //   86: new 21	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   93: astore_0
    //   94: aload_0
    //   95: ldc 139
    //   97: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_0
    //   102: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   105: invokevirtual 34	java/util/Properties:size	()I
    //   108: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: ldc 39
    //   115: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   123: invokevirtual 43	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   126: invokevirtual 47	java/lang/Object:toString	()Ljava/lang/String;
    //   129: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_0
    //   134: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   140: aconst_null
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_0
    //   144: new 141	java/io/FileOutputStream
    //   147: dup
    //   148: getstatic 93	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   151: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   157: astore_1
    //   158: getstatic 16	com/tencent/mobileqq/app/utils/PropertiesUtils:jdField_a_of_type_JavaUtilProperties	Ljava/util/Properties;
    //   161: aload_1
    //   162: aconst_null
    //   163: invokevirtual 146	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   170: aload_1
    //   171: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   174: return
    //   175: astore_0
    //   176: goto +45 -> 221
    //   179: astore_0
    //   180: aload_0
    //   181: astore_2
    //   182: goto +14 -> 196
    //   185: astore_2
    //   186: aload_0
    //   187: astore_1
    //   188: aload_2
    //   189: astore_0
    //   190: goto +31 -> 221
    //   193: astore_2
    //   194: aload_3
    //   195: astore_1
    //   196: aload_1
    //   197: astore_0
    //   198: aload_2
    //   199: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   202: aload_1
    //   203: ifnull +17 -> 220
    //   206: aload_1
    //   207: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   210: aload_1
    //   211: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   214: return
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   220: return
    //   221: aload_1
    //   222: ifnull +19 -> 241
    //   225: aload_1
    //   226: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   229: aload_1
    //   230: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   233: goto +8 -> 241
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   241: aload_0
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramContext	Context
    //   0	243	1	paramString1	String
    //   0	243	2	paramString2	String
    //   141	54	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   158	166	175	finally
    //   158	166	179	java/io/IOException
    //   144	158	185	finally
    //   198	202	185	finally
    //   144	158	193	java/io/IOException
    //   166	174	215	java/io/IOException
    //   206	214	215	java/io/IOException
    //   225	233	236	java/io/IOException
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
    //   1: ifnull +239 -> 240
    //   4: ldc 162
    //   6: aload_1
    //   7: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +5 -> 15
    //   13: aload_2
    //   14: areturn
    //   15: invokestatic 72	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: ifnonnull +5 -> 30
    //   28: aload_0
    //   29: astore_3
    //   30: new 30	java/util/Properties
    //   33: dup
    //   34: invokespecial 109	java/util/Properties:<init>	()V
    //   37: astore 6
    //   39: new 21	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   46: astore 4
    //   48: aload 4
    //   50: aload_3
    //   51: invokevirtual 78	android/content/Context:getFilesDir	()Ljava/io/File;
    //   54: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: ldc 169
    //   62: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: new 83	java/io/File
    //   69: dup
    //   70: aload 4
    //   72: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 4
    //   80: aload 4
    //   82: invokevirtual 102	java/io/File:exists	()Z
    //   85: ifeq +155 -> 240
    //   88: aconst_null
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_3
    //   93: new 111	java/io/FileInputStream
    //   96: dup
    //   97: aload 4
    //   99: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: astore 4
    //   104: aload 6
    //   106: aload 4
    //   108: invokevirtual 121	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   111: aload 6
    //   113: ldc 171
    //   115: invokevirtual 61	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_3
    //   119: new 21	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   126: astore 5
    //   128: aload 5
    //   130: ldc 173
    //   132: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: aload_3
    //   139: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 5
    //   145: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: aload_1
    //   153: aload_3
    //   154: invokestatic 175	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: invokevirtual 124	java/io/FileInputStream:close	()V
    //   162: goto +11 -> 173
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   170: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   173: aload_3
    //   174: areturn
    //   175: astore_0
    //   176: goto +46 -> 222
    //   179: astore_1
    //   180: aload 4
    //   182: astore_0
    //   183: goto +14 -> 197
    //   186: astore_0
    //   187: aload_3
    //   188: astore 4
    //   190: goto +32 -> 222
    //   193: astore_1
    //   194: aload 5
    //   196: astore_0
    //   197: aload_0
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 179	java/io/IOException:getMessage	()Ljava/lang/String;
    //   203: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokevirtual 124	java/io/FileInputStream:close	()V
    //   210: aload_2
    //   211: areturn
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   220: aload_2
    //   221: areturn
    //   222: aload 4
    //   224: invokevirtual 124	java/io/FileInputStream:close	()V
    //   227: goto +11 -> 238
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   235: invokestatic 51	com/tencent/mobileqq/app/utils/PropertiesUtils:a	(Ljava/lang/String;)V
    //   238: aload_0
    //   239: athrow
    //   240: aload_2
    //   241: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	Context
    //   0	242	1	paramString1	String
    //   0	242	2	paramString2	String
    //   22	177	3	localObject1	Object
    //   18	205	4	localObject2	Object
    //   89	106	5	localStringBuilder	StringBuilder
    //   37	75	6	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   157	162	165	java/lang/Exception
    //   104	157	175	finally
    //   104	157	179	java/io/IOException
    //   93	104	186	finally
    //   199	206	186	finally
    //   93	104	193	java/io/IOException
    //   206	210	212	java/lang/Exception
    //   222	227	230	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PropertiesUtils
 * JD-Core Version:    0.7.0.1
 */