package androidx.appcompat.widget;

import android.os.AsyncTask;

final class ActivityChooserModel$PersistHistoryAsyncTask
  extends AsyncTask<Object, Void, Void>
{
  ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel paramActivityChooserModel) {}
  
  /* Error */
  public Void doInBackground(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 30	java/util/List
    //   6: astore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: aaload
    //   11: checkcast 32	java/lang/String
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   20: getfield 38	androidx/appcompat/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   23: aload 5
    //   25: iconst_0
    //   26: invokevirtual 44	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   29: astore_1
    //   30: invokestatic 50	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   33: astore 5
    //   35: aload 5
    //   37: aload_1
    //   38: aconst_null
    //   39: invokeinterface 56 3 0
    //   44: aload 5
    //   46: ldc 58
    //   48: iconst_1
    //   49: invokestatic 64	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   52: invokeinterface 68 3 0
    //   57: aload 5
    //   59: aconst_null
    //   60: ldc 70
    //   62: invokeinterface 74 3 0
    //   67: pop
    //   68: aload 4
    //   70: invokeinterface 78 1 0
    //   75: istore_3
    //   76: iconst_0
    //   77: istore_2
    //   78: iload_2
    //   79: iload_3
    //   80: if_icmpge +102 -> 182
    //   83: aload 4
    //   85: iconst_0
    //   86: invokeinterface 82 2 0
    //   91: checkcast 84	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord
    //   94: astore 6
    //   96: aload 5
    //   98: aconst_null
    //   99: ldc 86
    //   101: invokeinterface 74 3 0
    //   106: pop
    //   107: aload 5
    //   109: aconst_null
    //   110: ldc 88
    //   112: aload 6
    //   114: getfield 91	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
    //   117: invokevirtual 97	android/content/ComponentName:flattenToString	()Ljava/lang/String;
    //   120: invokeinterface 101 4 0
    //   125: pop
    //   126: aload 5
    //   128: aconst_null
    //   129: ldc 103
    //   131: aload 6
    //   133: getfield 106	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:time	J
    //   136: invokestatic 109	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   139: invokeinterface 101 4 0
    //   144: pop
    //   145: aload 5
    //   147: aconst_null
    //   148: ldc 111
    //   150: aload 6
    //   152: getfield 114	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:weight	F
    //   155: invokestatic 117	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   158: invokeinterface 101 4 0
    //   163: pop
    //   164: aload 5
    //   166: aconst_null
    //   167: ldc 86
    //   169: invokeinterface 120 3 0
    //   174: pop
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: istore_2
    //   179: goto -101 -> 78
    //   182: aload 5
    //   184: aconst_null
    //   185: ldc 70
    //   187: invokeinterface 120 3 0
    //   192: pop
    //   193: aload 5
    //   195: invokeinterface 123 1 0
    //   200: aload_0
    //   201: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   204: iconst_1
    //   205: putfield 127	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
    //   208: aload_1
    //   209: ifnull +209 -> 418
    //   212: aload_1
    //   213: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore 4
    //   220: goto +200 -> 420
    //   223: astore 4
    //   225: getstatic 136	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   228: astore 5
    //   230: new 138	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   237: astore 6
    //   239: aload 6
    //   241: ldc 141
    //   243: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 6
    //   249: aload_0
    //   250: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   253: getfield 148	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   256: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 5
    //   262: aload 6
    //   264: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: aload 4
    //   269: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   272: pop
    //   273: aload_0
    //   274: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   277: iconst_1
    //   278: putfield 127	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
    //   281: aload_1
    //   282: ifnull +136 -> 418
    //   285: goto -73 -> 212
    //   288: astore 4
    //   290: getstatic 136	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   293: astore 5
    //   295: new 138	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   302: astore 6
    //   304: aload 6
    //   306: ldc 141
    //   308: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: aload_0
    //   315: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   318: getfield 148	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   321: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 5
    //   327: aload 6
    //   329: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload 4
    //   334: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   337: pop
    //   338: aload_0
    //   339: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   342: iconst_1
    //   343: putfield 127	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
    //   346: aload_1
    //   347: ifnull +71 -> 418
    //   350: goto -138 -> 212
    //   353: astore 4
    //   355: getstatic 136	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   358: astore 5
    //   360: new 138	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   367: astore 6
    //   369: aload 6
    //   371: ldc 141
    //   373: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 6
    //   379: aload_0
    //   380: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   383: getfield 148	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   386: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 5
    //   392: aload 6
    //   394: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: aload 4
    //   399: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   402: pop
    //   403: aload_0
    //   404: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   407: iconst_1
    //   408: putfield 127	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
    //   411: aload_1
    //   412: ifnull +6 -> 418
    //   415: goto -203 -> 212
    //   418: aconst_null
    //   419: areturn
    //   420: aload_0
    //   421: getfield 11	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
    //   424: iconst_1
    //   425: putfield 127	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
    //   428: aload_1
    //   429: ifnull +7 -> 436
    //   432: aload_1
    //   433: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   436: aload 4
    //   438: athrow
    //   439: astore_1
    //   440: getstatic 136	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   443: astore 4
    //   445: new 138	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   452: astore 6
    //   454: aload 6
    //   456: ldc 141
    //   458: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 6
    //   464: aload 5
    //   466: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 4
    //   472: aload 6
    //   474: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: aload_1
    //   478: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   481: pop
    //   482: aconst_null
    //   483: areturn
    //   484: astore_1
    //   485: aconst_null
    //   486: areturn
    //   487: astore_1
    //   488: goto -52 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	PersistHistoryAsyncTask
    //   0	491	1	paramVarArgs	Object[]
    //   77	102	2	i	int
    //   75	6	3	j	int
    //   6	78	4	localList	java.util.List
    //   218	1	4	localObject1	Object
    //   223	45	4	localIOException	java.io.IOException
    //   288	45	4	localIllegalStateException	java.lang.IllegalStateException
    //   353	84	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   443	28	4	str	java.lang.String
    //   14	451	5	localObject2	Object
    //   94	379	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	76	218	finally
    //   83	175	218	finally
    //   182	200	218	finally
    //   225	273	218	finally
    //   290	338	218	finally
    //   355	403	218	finally
    //   35	76	223	java/io/IOException
    //   83	175	223	java/io/IOException
    //   182	200	223	java/io/IOException
    //   35	76	288	java/lang/IllegalStateException
    //   83	175	288	java/lang/IllegalStateException
    //   182	200	288	java/lang/IllegalStateException
    //   35	76	353	java/lang/IllegalArgumentException
    //   83	175	353	java/lang/IllegalArgumentException
    //   182	200	353	java/lang/IllegalArgumentException
    //   16	30	439	java/io/FileNotFoundException
    //   212	216	484	java/io/IOException
    //   432	436	487	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask
 * JD-Core Version:    0.7.0.1
 */