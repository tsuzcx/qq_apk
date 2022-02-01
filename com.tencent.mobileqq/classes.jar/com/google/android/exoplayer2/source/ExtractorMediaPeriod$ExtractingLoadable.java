package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;

final class ExtractorMediaPeriod$ExtractingLoadable
  implements Loader.Loadable
{
  private long bytesLoaded;
  private final DataSource dataSource;
  private DataSpec dataSpec;
  private final ExtractorMediaPeriod.ExtractorHolder extractorHolder;
  private long length;
  private volatile boolean loadCanceled;
  private final ConditionVariable loadCondition;
  private boolean pendingExtractorSeek;
  private final PositionHolder positionHolder;
  private long seekTimeUs;
  private final Uri uri;
  
  public ExtractorMediaPeriod$ExtractingLoadable(ExtractorMediaPeriod paramExtractorMediaPeriod, Uri paramUri, DataSource paramDataSource, ExtractorMediaPeriod.ExtractorHolder paramExtractorHolder, ConditionVariable paramConditionVariable)
  {
    this.uri = ((Uri)Assertions.checkNotNull(paramUri));
    this.dataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
    this.extractorHolder = ((ExtractorMediaPeriod.ExtractorHolder)Assertions.checkNotNull(paramExtractorHolder));
    this.loadCondition = paramConditionVariable;
    this.positionHolder = new PositionHolder();
    this.pendingExtractorSeek = true;
    this.length = -1L;
  }
  
  public void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  public boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  /* Error */
  public void load()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +362 -> 365
    //   6: aload_0
    //   7: getfield 81	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCanceled	Z
    //   10: ifne +355 -> 365
    //   13: aload_0
    //   14: getfield 59	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
    //   17: getfield 87	com/google/android/exoplayer2/extractor/PositionHolder:position	J
    //   20: lstore_3
    //   21: aload_0
    //   22: new 89	com/google/android/exoplayer2/upstream/DataSpec
    //   25: dup
    //   26: aload_0
    //   27: getfield 44	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:uri	Landroid/net/Uri;
    //   30: lload_3
    //   31: ldc2_w 62
    //   34: aload_0
    //   35: getfield 31	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
    //   38: invokestatic 95	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$800	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)Ljava/lang/String;
    //   41: invokespecial 98	com/google/android/exoplayer2/upstream/DataSpec:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
    //   44: putfield 70	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 48	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   52: aload_0
    //   53: getfield 70	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   56: invokeinterface 102 2 0
    //   61: putfield 65	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
    //   64: aload_0
    //   65: getfield 65	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
    //   68: ldc2_w 62
    //   71: lcmp
    //   72: ifeq +13 -> 85
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 65	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
    //   80: lload_3
    //   81: ladd
    //   82: putfield 65	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
    //   85: new 104	com/google/android/exoplayer2/extractor/DefaultExtractorInput
    //   88: dup
    //   89: aload_0
    //   90: getfield 48	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   93: lload_3
    //   94: aload_0
    //   95: getfield 65	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
    //   98: invokespecial 107	com/google/android/exoplayer2/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer2/upstream/DataSource;JJ)V
    //   101: astore 5
    //   103: aload_0
    //   104: getfield 52	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:extractorHolder	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder;
    //   107: aload 5
    //   109: aload_0
    //   110: getfield 48	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   113: invokeinterface 111 1 0
    //   118: invokevirtual 115	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:selectExtractor	(Lcom/google/android/exoplayer2/extractor/ExtractorInput;Landroid/net/Uri;)Lcom/google/android/exoplayer2/extractor/Extractor;
    //   121: astore 6
    //   123: aload_0
    //   124: getfield 61	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:pendingExtractorSeek	Z
    //   127: ifeq +20 -> 147
    //   130: aload 6
    //   132: lload_3
    //   133: aload_0
    //   134: getfield 74	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:seekTimeUs	J
    //   137: invokeinterface 121 5 0
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 61	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:pendingExtractorSeek	Z
    //   147: ldc 123
    //   149: invokestatic 129	com/google/android/exoplayer2/util/TraceUtil:beginSection	(Ljava/lang/String;)V
    //   152: iload_1
    //   153: ifne +90 -> 243
    //   156: aload_0
    //   157: getfield 81	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCanceled	Z
    //   160: ifne +83 -> 243
    //   163: aload_0
    //   164: getfield 54	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCondition	Lcom/google/android/exoplayer2/util/ConditionVariable;
    //   167: invokevirtual 134	com/google/android/exoplayer2/util/ConditionVariable:block	()V
    //   170: aload 6
    //   172: aload 5
    //   174: aload_0
    //   175: getfield 59	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
    //   178: invokeinterface 138 3 0
    //   183: istore_2
    //   184: iload_2
    //   185: istore_1
    //   186: aload 5
    //   188: invokeinterface 144 1 0
    //   193: aload_0
    //   194: getfield 31	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
    //   197: invokestatic 148	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$900	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)J
    //   200: lload_3
    //   201: ladd
    //   202: lcmp
    //   203: ifle +206 -> 409
    //   206: aload 5
    //   208: invokeinterface 144 1 0
    //   213: lstore_3
    //   214: aload_0
    //   215: getfield 54	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCondition	Lcom/google/android/exoplayer2/util/ConditionVariable;
    //   218: invokevirtual 151	com/google/android/exoplayer2/util/ConditionVariable:close	()Z
    //   221: pop
    //   222: aload_0
    //   223: getfield 31	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
    //   226: invokestatic 155	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$1100	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)Landroid/os/Handler;
    //   229: aload_0
    //   230: getfield 31	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
    //   233: invokestatic 159	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$1000	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)Ljava/lang/Runnable;
    //   236: invokevirtual 165	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   239: pop
    //   240: goto -88 -> 152
    //   243: invokestatic 168	com/google/android/exoplayer2/util/TraceUtil:endSection	()V
    //   246: iload_1
    //   247: iconst_1
    //   248: if_icmpne +15 -> 263
    //   251: iconst_0
    //   252: istore_1
    //   253: aload_0
    //   254: getfield 48	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   257: invokestatic 174	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
    //   260: goto -258 -> 2
    //   263: aload 5
    //   265: ifnull +36 -> 301
    //   268: aload_0
    //   269: getfield 59	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
    //   272: aload 5
    //   274: invokeinterface 144 1 0
    //   279: putfield 87	com/google/android/exoplayer2/extractor/PositionHolder:position	J
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 59	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
    //   287: getfield 87	com/google/android/exoplayer2/extractor/PositionHolder:position	J
    //   290: aload_0
    //   291: getfield 70	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   294: getfield 177	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   297: lsub
    //   298: putfield 77	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:bytesLoaded	J
    //   301: goto -48 -> 253
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 6
    //   309: iload_1
    //   310: iconst_1
    //   311: if_icmpne +13 -> 324
    //   314: aload_0
    //   315: getfield 48	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   318: invokestatic 174	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
    //   321: aload 5
    //   323: athrow
    //   324: aload 6
    //   326: ifnull -12 -> 314
    //   329: aload_0
    //   330: getfield 59	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
    //   333: aload 6
    //   335: invokeinterface 144 1 0
    //   340: putfield 87	com/google/android/exoplayer2/extractor/PositionHolder:position	J
    //   343: aload_0
    //   344: aload_0
    //   345: getfield 59	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
    //   348: getfield 87	com/google/android/exoplayer2/extractor/PositionHolder:position	J
    //   351: aload_0
    //   352: getfield 70	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   355: getfield 177	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   358: lsub
    //   359: putfield 77	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:bytesLoaded	J
    //   362: goto -48 -> 314
    //   365: return
    //   366: astore 6
    //   368: aload 5
    //   370: astore 7
    //   372: aload 6
    //   374: astore 5
    //   376: aload 7
    //   378: astore 6
    //   380: goto -71 -> 309
    //   383: astore 7
    //   385: aload 5
    //   387: astore 6
    //   389: aload 7
    //   391: astore 5
    //   393: goto -84 -> 309
    //   396: astore 7
    //   398: aload 5
    //   400: astore 6
    //   402: aload 7
    //   404: astore 5
    //   406: goto -97 -> 309
    //   409: goto -257 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	ExtractingLoadable
    //   1	311	1	i	int
    //   183	2	2	j	int
    //   20	194	3	l	long
    //   101	172	5	localDefaultExtractorInput	com.google.android.exoplayer2.extractor.DefaultExtractorInput
    //   304	65	5	localObject1	Object
    //   374	31	5	localObject2	Object
    //   121	213	6	localExtractor	com.google.android.exoplayer2.extractor.Extractor
    //   366	7	6	localObject3	Object
    //   378	23	6	localObject4	Object
    //   370	7	7	localObject5	Object
    //   383	7	7	localObject6	Object
    //   396	7	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   13	85	304	finally
    //   85	103	304	finally
    //   103	147	366	finally
    //   147	152	366	finally
    //   156	184	383	finally
    //   243	246	383	finally
    //   186	240	396	finally
  }
  
  public void setLoadPosition(long paramLong1, long paramLong2)
  {
    this.positionHolder.position = paramLong1;
    this.seekTimeUs = paramLong2;
    this.pendingExtractorSeek = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable
 * JD-Core Version:    0.7.0.1
 */