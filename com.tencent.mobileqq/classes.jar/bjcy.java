import android.content.Context;
import java.io.File;

public class bjcy
{
  private static final String a = bjhx.a("largeIntentTmp");
  
  /* Error */
  public static android.content.Intent a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: invokestatic 26	bjcy:a	(Landroid/content/Context;)Ljava/io/File;
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 32	java/io/File:exists	()Z
    //   13: ifne +61 -> 74
    //   16: new 34	android/content/Intent
    //   19: dup
    //   20: invokespecial 37	android/content/Intent:<init>	()V
    //   23: astore_0
    //   24: iconst_0
    //   25: ifeq +11 -> 36
    //   28: new 39	java/lang/NullPointerException
    //   31: dup
    //   32: invokespecial 40	java/lang/NullPointerException:<init>	()V
    //   35: athrow
    //   36: aload_0
    //   37: astore_1
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 39	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 40	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: ldc 42
    //   55: iconst_2
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: ldc 44
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_1
    //   68: aastore
    //   69: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: areturn
    //   74: new 52	java/io/BufferedInputStream
    //   77: dup
    //   78: new 54	java/io/FileInputStream
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 60	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 66	java/io/InputStream:available	()I
    //   94: newarray byte
    //   96: astore_2
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 70	java/io/InputStream:read	([B)I
    //   102: pop
    //   103: invokestatic 76	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   106: astore_1
    //   107: aload_1
    //   108: aload_2
    //   109: iconst_0
    //   110: aload_2
    //   111: arraylength
    //   112: invokevirtual 80	android/os/Parcel:unmarshall	([BII)V
    //   115: aload_1
    //   116: iconst_0
    //   117: invokevirtual 84	android/os/Parcel:setDataPosition	(I)V
    //   120: new 34	android/content/Intent
    //   123: dup
    //   124: invokespecial 37	android/content/Intent:<init>	()V
    //   127: astore_2
    //   128: new 86	android/os/Bundle
    //   131: dup
    //   132: invokespecial 87	android/os/Bundle:<init>	()V
    //   135: astore_3
    //   136: aload_3
    //   137: aload_1
    //   138: invokevirtual 91	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   141: aload_2
    //   142: aload_3
    //   143: invokevirtual 95	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   146: pop
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 98	android/os/Parcel:recycle	()V
    //   155: aload_2
    //   156: astore_1
    //   157: aload_0
    //   158: ifnull -108 -> 50
    //   161: aload_0
    //   162: invokevirtual 101	java/io/InputStream:close	()V
    //   165: aload_2
    //   166: areturn
    //   167: astore_0
    //   168: ldc 42
    //   170: iconst_2
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: ldc 44
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: aload_0
    //   183: aastore
    //   184: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   187: aload_2
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_3
    //   193: astore_0
    //   194: ldc 42
    //   196: iconst_2
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc 44
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_1
    //   209: aastore
    //   210: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   213: new 34	android/content/Intent
    //   216: dup
    //   217: invokespecial 37	android/content/Intent:<init>	()V
    //   220: astore_3
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 98	android/os/Parcel:recycle	()V
    //   229: aload_3
    //   230: astore_1
    //   231: aload_0
    //   232: ifnull -182 -> 50
    //   235: aload_0
    //   236: invokevirtual 101	java/io/InputStream:close	()V
    //   239: aload_3
    //   240: areturn
    //   241: astore_0
    //   242: ldc 42
    //   244: iconst_2
    //   245: iconst_2
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: ldc 44
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: aload_0
    //   257: aastore
    //   258: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   261: aload_3
    //   262: areturn
    //   263: astore_3
    //   264: aconst_null
    //   265: astore_2
    //   266: aload_1
    //   267: astore_0
    //   268: aload_3
    //   269: astore_1
    //   270: aload_2
    //   271: ifnull +7 -> 278
    //   274: aload_2
    //   275: invokevirtual 98	android/os/Parcel:recycle	()V
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 101	java/io/InputStream:close	()V
    //   286: aload_1
    //   287: athrow
    //   288: astore_0
    //   289: ldc 42
    //   291: iconst_2
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: ldc 44
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aload_0
    //   304: aastore
    //   305: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   308: goto -22 -> 286
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -44 -> 270
    //   317: astore_3
    //   318: aload_1
    //   319: astore_2
    //   320: aload_3
    //   321: astore_1
    //   322: goto -52 -> 270
    //   325: astore_1
    //   326: goto -56 -> 270
    //   329: astore_1
    //   330: aconst_null
    //   331: astore_2
    //   332: goto -138 -> 194
    //   335: astore_3
    //   336: aload_1
    //   337: astore_2
    //   338: aload_3
    //   339: astore_1
    //   340: goto -146 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramContext	Context
    //   1	50	1	localContext	Context
    //   52	16	1	localIOException	java.io.IOException
    //   106	51	1	localObject1	Object
    //   189	20	1	localException1	java.lang.Exception
    //   230	57	1	localObject2	Object
    //   311	8	1	localObject3	Object
    //   321	1	1	localObject4	Object
    //   325	1	1	localObject5	Object
    //   329	8	1	localException2	java.lang.Exception
    //   339	1	1	localObject6	Object
    //   96	242	2	localObject7	Object
    //   3	259	3	localObject8	Object
    //   263	6	3	localObject9	Object
    //   317	4	3	localObject10	Object
    //   335	4	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	36	52	java/io/IOException
    //   42	50	52	java/io/IOException
    //   151	155	167	java/io/IOException
    //   161	165	167	java/io/IOException
    //   4	24	189	java/lang/Exception
    //   74	90	189	java/lang/Exception
    //   225	229	241	java/io/IOException
    //   235	239	241	java/io/IOException
    //   4	24	263	finally
    //   74	90	263	finally
    //   274	278	288	java/io/IOException
    //   282	286	288	java/io/IOException
    //   90	107	311	finally
    //   107	147	317	finally
    //   194	221	325	finally
    //   90	107	329	java/lang/Exception
    //   107	147	335	java/lang/Exception
  }
  
  private static File a(Context paramContext)
  {
    return new File(a, "tmp.dat");
  }
  
  public static void a(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext.exists()) {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static void a(android.content.Intent paramIntent, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 76	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_0
    //   5: invokevirtual 115	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   8: astore_0
    //   9: aload_0
    //   10: ifnull +9 -> 19
    //   13: aload_0
    //   14: aload_3
    //   15: iconst_0
    //   16: invokevirtual 119	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   19: aload_3
    //   20: invokevirtual 123	android/os/Parcel:marshall	()[B
    //   23: astore 4
    //   25: aload_1
    //   26: invokestatic 26	bjcy:a	(Landroid/content/Context;)Ljava/io/File;
    //   29: astore 5
    //   31: aconst_null
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_1
    //   36: astore_0
    //   37: aload 5
    //   39: invokevirtual 32	java/io/File:exists	()Z
    //   42: ifeq +11 -> 53
    //   45: aload_1
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 110	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_1
    //   54: astore_0
    //   55: aload 5
    //   57: invokevirtual 127	java/io/File:getParentFile	()Ljava/io/File;
    //   60: invokevirtual 130	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: aload 5
    //   68: invokevirtual 133	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: aload_1
    //   73: astore_0
    //   74: new 135	java/io/BufferedOutputStream
    //   77: dup
    //   78: new 137	java/io/FileOutputStream
    //   81: dup
    //   82: aload 5
    //   84: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 141	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   90: astore_1
    //   91: aload_1
    //   92: aload 4
    //   94: invokevirtual 147	java/io/OutputStream:write	([B)V
    //   97: aload_3
    //   98: invokevirtual 98	android/os/Parcel:recycle	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 148	java/io/OutputStream:close	()V
    //   109: return
    //   110: astore_0
    //   111: ldc 42
    //   113: iconst_2
    //   114: iconst_2
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: ldc 44
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_0
    //   126: aastore
    //   127: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   130: return
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: astore_2
    //   136: aload_1
    //   137: astore_0
    //   138: ldc 42
    //   140: iconst_2
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc 44
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_2
    //   153: aastore
    //   154: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: aload_3
    //   158: invokevirtual 98	android/os/Parcel:recycle	()V
    //   161: aload_1
    //   162: ifnull -53 -> 109
    //   165: aload_1
    //   166: invokevirtual 148	java/io/OutputStream:close	()V
    //   169: return
    //   170: astore_0
    //   171: ldc 42
    //   173: iconst_2
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: ldc 44
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: aastore
    //   187: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   190: return
    //   191: astore_2
    //   192: aload_0
    //   193: astore_1
    //   194: aload_2
    //   195: astore_0
    //   196: aload_3
    //   197: invokevirtual 98	android/os/Parcel:recycle	()V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 148	java/io/OutputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: astore_1
    //   211: ldc 42
    //   213: iconst_2
    //   214: iconst_2
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: ldc 44
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: aload_1
    //   226: aastore
    //   227: invokestatic 50	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: goto -22 -> 208
    //   233: astore_0
    //   234: goto -38 -> 196
    //   237: astore_2
    //   238: goto -102 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramIntent	android.content.Intent
    //   0	241	1	paramContext	Context
    //   34	119	2	localIntent	android.content.Intent
    //   191	4	2	localObject	Object
    //   237	1	2	localException	java.lang.Exception
    //   3	194	3	localParcel	android.os.Parcel
    //   23	70	4	arrayOfByte	byte[]
    //   29	54	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	109	110	java/io/IOException
    //   37	45	131	java/lang/Exception
    //   47	53	131	java/lang/Exception
    //   55	64	131	java/lang/Exception
    //   66	72	131	java/lang/Exception
    //   74	91	131	java/lang/Exception
    //   165	169	170	java/io/IOException
    //   37	45	191	finally
    //   47	53	191	finally
    //   55	64	191	finally
    //   66	72	191	finally
    //   74	91	191	finally
    //   138	157	191	finally
    //   204	208	210	java/io/IOException
    //   91	97	233	finally
    //   91	97	237	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjcy
 * JD-Core Version:    0.7.0.1
 */