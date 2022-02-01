package com.tencent.luggage.scanner.scanner.util;

import android.net.Uri;

public class a
{
  /* Error */
  public static String a(android.content.Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 14	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 19
    //   5: if_icmplt +8 -> 13
    //   8: iconst_1
    //   9: istore_2
    //   10: goto +5 -> 15
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_1
    //   16: astore_3
    //   17: iload_2
    //   18: ifeq +202 -> 220
    //   21: aload_1
    //   22: astore_3
    //   23: aload_0
    //   24: invokevirtual 20	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   27: aload_1
    //   28: invokestatic 26	android/provider/DocumentsContract:isDocumentUri	(Landroid/content/Context;Landroid/net/Uri;)Z
    //   31: ifeq +189 -> 220
    //   34: aload_1
    //   35: invokestatic 29	com/tencent/luggage/scanner/scanner/util/a:a	(Landroid/net/Uri;)Z
    //   38: ifeq +49 -> 87
    //   41: aload_1
    //   42: invokestatic 33	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   45: ldc 35
    //   47: invokevirtual 41	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore_0
    //   51: new 43	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 53	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   63: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: ldc 59
    //   70: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: aload_0
    //   76: iconst_1
    //   77: aaload
    //   78: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_1
    //   83: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: areturn
    //   87: aload_1
    //   88: invokestatic 69	com/tencent/luggage/scanner/scanner/util/a:b	(Landroid/net/Uri;)Z
    //   91: ifeq +27 -> 118
    //   94: aload_1
    //   95: invokestatic 33	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   98: astore_1
    //   99: ldc 71
    //   101: invokestatic 77	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   104: aload_1
    //   105: invokestatic 83	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   108: invokevirtual 87	java/lang/Long:longValue	()J
    //   111: invokestatic 93	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   114: astore_3
    //   115: goto +105 -> 220
    //   118: aload_1
    //   119: astore_3
    //   120: aload_1
    //   121: invokestatic 96	com/tencent/luggage/scanner/scanner/util/a:c	(Landroid/net/Uri;)Z
    //   124: ifeq +96 -> 220
    //   127: aload_1
    //   128: invokestatic 33	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   131: ldc 35
    //   133: invokevirtual 41	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   136: astore_3
    //   137: aload_3
    //   138: iconst_0
    //   139: aaload
    //   140: astore 4
    //   142: ldc 98
    //   144: aload 4
    //   146: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +10 -> 159
    //   152: getstatic 108	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   155: astore_1
    //   156: goto +34 -> 190
    //   159: ldc 110
    //   161: aload 4
    //   163: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +10 -> 176
    //   169: getstatic 113	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   172: astore_1
    //   173: goto +17 -> 190
    //   176: ldc 115
    //   178: aload 4
    //   180: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifeq +7 -> 190
    //   186: getstatic 118	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   189: astore_1
    //   190: aload_3
    //   191: iconst_1
    //   192: aaload
    //   193: astore_3
    //   194: ldc 120
    //   196: astore 4
    //   198: iconst_1
    //   199: anewarray 37	java/lang/String
    //   202: dup
    //   203: iconst_0
    //   204: aload_3
    //   205: aastore
    //   206: astore 5
    //   208: aload_1
    //   209: astore_3
    //   210: aload 4
    //   212: astore_1
    //   213: aload 5
    //   215: astore 4
    //   217: goto +8 -> 225
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: astore 4
    //   225: ldc 122
    //   227: aload_3
    //   228: invokevirtual 125	android/net/Uri:getScheme	()Ljava/lang/String;
    //   231: invokevirtual 129	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   234: ifeq +122 -> 356
    //   237: aload_0
    //   238: invokevirtual 133	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   241: aload_3
    //   242: iconst_1
    //   243: anewarray 37	java/lang/String
    //   246: dup
    //   247: iconst_0
    //   248: ldc 135
    //   250: aastore
    //   251: aload_1
    //   252: aload 4
    //   254: aconst_null
    //   255: invokevirtual 141	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   258: astore_0
    //   259: aload_0
    //   260: ifnonnull +15 -> 275
    //   263: aload_0
    //   264: ifnull +9 -> 273
    //   267: aload_0
    //   268: invokeinterface 146 1 0
    //   273: aconst_null
    //   274: areturn
    //   275: aload_0
    //   276: ldc 135
    //   278: invokeinterface 150 2 0
    //   283: istore_2
    //   284: aload_0
    //   285: invokeinterface 154 1 0
    //   290: ifeq +23 -> 313
    //   293: aload_0
    //   294: iload_2
    //   295: invokeinterface 158 2 0
    //   300: astore_1
    //   301: aload_0
    //   302: ifnull +9 -> 311
    //   305: aload_0
    //   306: invokeinterface 146 1 0
    //   311: aload_1
    //   312: areturn
    //   313: aload_0
    //   314: ifnull +59 -> 373
    //   317: goto +31 -> 348
    //   320: astore_1
    //   321: goto +9 -> 330
    //   324: goto +20 -> 344
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_0
    //   330: aload_0
    //   331: ifnull +9 -> 340
    //   334: aload_0
    //   335: invokeinterface 146 1 0
    //   340: aload_1
    //   341: athrow
    //   342: aconst_null
    //   343: astore_0
    //   344: aload_0
    //   345: ifnull +28 -> 373
    //   348: aload_0
    //   349: invokeinterface 146 1 0
    //   354: aconst_null
    //   355: areturn
    //   356: ldc 160
    //   358: aload_3
    //   359: invokevirtual 125	android/net/Uri:getScheme	()Ljava/lang/String;
    //   362: invokevirtual 129	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   365: ifeq +8 -> 373
    //   368: aload_3
    //   369: invokevirtual 163	android/net/Uri:getPath	()Ljava/lang/String;
    //   372: areturn
    //   373: aconst_null
    //   374: areturn
    //   375: astore_0
    //   376: goto -34 -> 342
    //   379: astore_1
    //   380: goto -56 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramContext	android.content.Context
    //   0	383	1	paramUri	Uri
    //   9	286	2	i	int
    //   16	353	3	localObject1	Object
    //   140	113	4	localObject2	Object
    //   206	8	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   275	301	320	finally
    //   237	259	327	finally
    //   237	259	375	java/lang/Exception
    //   275	301	379	java/lang/Exception
  }
  
  public static boolean a(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean b(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean c(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */