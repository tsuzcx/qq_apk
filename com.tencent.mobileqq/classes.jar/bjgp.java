import android.content.BroadcastReceiver;

class bjgp
  extends BroadcastReceiver
{
  bjgp(bjgl parambjgl) {}
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 6
    //   8: aload_0
    //   9: getfield 10	bjgp:a	Lbjgl;
    //   12: invokestatic 23	bjgl:a	(Lbjgl;)Z
    //   15: ifne +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 10	bjgp:a	Lbjgl;
    //   23: iconst_0
    //   24: invokestatic 26	bjgl:a	(Lbjgl;Z)Z
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 32	android/content/Intent:getAction	()Ljava/lang/String;
    //   32: astore 8
    //   34: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +23 -> 60
    //   40: ldc 40
    //   42: iconst_2
    //   43: ldc 42
    //   45: iconst_1
    //   46: anewarray 44	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload 8
    //   53: aastore
    //   54: invokestatic 50	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 56
    //   62: aload 8
    //   64: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq -49 -> 18
    //   70: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +17 -> 90
    //   76: ldc 40
    //   78: iconst_2
    //   79: iconst_1
    //   80: anewarray 44	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_2
    //   86: aastore
    //   87: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: ldc 65
    //   93: invokevirtual 69	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   96: checkcast 71	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   99: astore 11
    //   101: aload 11
    //   103: ifnonnull +21 -> 124
    //   106: aload_0
    //   107: getfield 10	bjgp:a	Lbjgl;
    //   110: aload_0
    //   111: getfield 10	bjgp:a	Lbjgl;
    //   114: invokestatic 74	bjgl:a	(Lbjgl;)I
    //   117: ldc 76
    //   119: aconst_null
    //   120: invokestatic 79	bjgl:a	(Lbjgl;ILjava/lang/String;Lorg/json/JSONObject;)V
    //   123: return
    //   124: iload 5
    //   126: istore 4
    //   128: getstatic 85	android/os/Build$VERSION:SDK_INT	I
    //   131: bipush 15
    //   133: if_icmple +105 -> 238
    //   136: new 87	java/io/FileInputStream
    //   139: dup
    //   140: aload 11
    //   142: getfield 91	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   145: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   148: astore 8
    //   150: new 96	android/media/MediaExtractor
    //   153: dup
    //   154: invokespecial 97	android/media/MediaExtractor:<init>	()V
    //   157: astore 9
    //   159: aload 9
    //   161: aload 8
    //   163: invokevirtual 101	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   166: invokevirtual 105	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   169: aload 9
    //   171: invokestatic 108	bjgl:a	(Landroid/media/MediaExtractor;)I
    //   174: istore 4
    //   176: iload 6
    //   178: istore_3
    //   179: iload 4
    //   181: iconst_m1
    //   182: if_icmple +30 -> 212
    //   185: aload 9
    //   187: iload 4
    //   189: invokevirtual 112	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   192: astore_1
    //   193: iload 6
    //   195: istore_3
    //   196: aload_1
    //   197: ldc 114
    //   199: invokevirtual 120	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   202: ifeq +10 -> 212
    //   205: aload_1
    //   206: ldc 114
    //   208: invokevirtual 124	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   211: istore_3
    //   212: aload 8
    //   214: ifnull +8 -> 222
    //   217: aload 8
    //   219: invokevirtual 127	java/io/FileInputStream:close	()V
    //   222: iload_3
    //   223: istore 4
    //   225: aload 9
    //   227: ifnull +11 -> 238
    //   230: aload 9
    //   232: invokevirtual 130	android/media/MediaExtractor:release	()V
    //   235: iload_3
    //   236: istore 4
    //   238: ldc 40
    //   240: iconst_2
    //   241: new 132	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   248: ldc 135
    //   250: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 4
    //   255: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: iload 4
    //   266: bipush 90
    //   268: if_icmpeq +11 -> 279
    //   271: iload 4
    //   273: sipush 270
    //   276: if_icmpne +25 -> 301
    //   279: aload 11
    //   281: getfield 151	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   284: istore_3
    //   285: aload 11
    //   287: aload 11
    //   289: getfield 154	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   292: putfield 151	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   295: aload 11
    //   297: iload_3
    //   298: putfield 154	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   301: ldc 156
    //   303: aload_2
    //   304: ldc 158
    //   306: invokevirtual 162	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   309: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: istore 7
    //   314: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +29 -> 346
    //   320: ldc 40
    //   322: iconst_2
    //   323: new 132	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   330: ldc 164
    //   332: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 7
    //   337: invokevirtual 167	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   340: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: iload 7
    //   348: ifeq +84 -> 432
    //   351: aload_0
    //   352: getfield 10	bjgp:a	Lbjgl;
    //   355: aload 11
    //   357: iconst_1
    //   358: invokestatic 170	bjgl:a	(Lbjgl;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   361: return
    //   362: astore 9
    //   364: aconst_null
    //   365: astore 8
    //   367: ldc 40
    //   369: iconst_1
    //   370: ldc 172
    //   372: aload 9
    //   374: invokestatic 176	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   377: aload 8
    //   379: ifnull +8 -> 387
    //   382: aload 8
    //   384: invokevirtual 127	java/io/FileInputStream:close	()V
    //   387: iload 5
    //   389: istore 4
    //   391: aload_1
    //   392: ifnull -154 -> 238
    //   395: aload_1
    //   396: invokevirtual 130	android/media/MediaExtractor:release	()V
    //   399: iload 5
    //   401: istore 4
    //   403: goto -165 -> 238
    //   406: astore_1
    //   407: aconst_null
    //   408: astore 8
    //   410: aconst_null
    //   411: astore_2
    //   412: aload 8
    //   414: ifnull +8 -> 422
    //   417: aload 8
    //   419: invokevirtual 127	java/io/FileInputStream:close	()V
    //   422: aload_2
    //   423: ifnull +7 -> 430
    //   426: aload_2
    //   427: invokevirtual 130	android/media/MediaExtractor:release	()V
    //   430: aload_1
    //   431: athrow
    //   432: aload 11
    //   434: getfield 91	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   437: astore_1
    //   438: aload_0
    //   439: getfield 10	bjgp:a	Lbjgl;
    //   442: invokestatic 179	bjgl:a	(Lbjgl;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   445: ldc 181
    //   447: invokeinterface 187 2 0
    //   452: checkcast 181	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   455: aload_1
    //   456: invokeinterface 190 2 0
    //   461: astore_1
    //   462: aload_0
    //   463: getfield 10	bjgp:a	Lbjgl;
    //   466: aload_1
    //   467: aload 11
    //   469: getfield 194	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   472: aload 11
    //   474: invokestatic 197	bjgl:a	(Lbjgl;Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   477: return
    //   478: astore_1
    //   479: goto -257 -> 222
    //   482: astore 8
    //   484: goto -97 -> 387
    //   487: astore 8
    //   489: goto -67 -> 422
    //   492: astore_1
    //   493: aconst_null
    //   494: astore_2
    //   495: goto -83 -> 412
    //   498: astore_1
    //   499: aload 9
    //   501: astore_2
    //   502: goto -90 -> 412
    //   505: astore 9
    //   507: aload_1
    //   508: astore_2
    //   509: aload 9
    //   511: astore_1
    //   512: goto -100 -> 412
    //   515: astore 9
    //   517: goto -150 -> 367
    //   520: astore 10
    //   522: aload 9
    //   524: astore_1
    //   525: aload 10
    //   527: astore 9
    //   529: goto -162 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	bjgp
    //   0	532	1	paramContext	android.content.Context
    //   0	532	2	paramIntent	android.content.Intent
    //   178	120	3	i	int
    //   126	276	4	j	int
    //   3	397	5	k	int
    //   6	188	6	m	int
    //   312	35	7	bool	boolean
    //   32	386	8	localObject1	java.lang.Object
    //   482	1	8	localIOException1	java.io.IOException
    //   487	1	8	localIOException2	java.io.IOException
    //   157	74	9	localMediaExtractor	android.media.MediaExtractor
    //   362	138	9	localIOException3	java.io.IOException
    //   505	5	9	localObject2	java.lang.Object
    //   515	8	9	localIOException4	java.io.IOException
    //   527	1	9	localObject3	java.lang.Object
    //   520	6	10	localIOException5	java.io.IOException
    //   99	374	11	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   136	150	362	java/io/IOException
    //   136	150	406	finally
    //   217	222	478	java/io/IOException
    //   382	387	482	java/io/IOException
    //   417	422	487	java/io/IOException
    //   150	159	492	finally
    //   159	176	498	finally
    //   185	193	498	finally
    //   196	212	498	finally
    //   367	377	505	finally
    //   150	159	515	java/io/IOException
    //   159	176	520	java/io/IOException
    //   185	193	520	java/io/IOException
    //   196	212	520	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgp
 * JD-Core Version:    0.7.0.1
 */