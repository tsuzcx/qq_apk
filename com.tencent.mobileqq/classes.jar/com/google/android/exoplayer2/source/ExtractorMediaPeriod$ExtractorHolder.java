package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;

final class ExtractorMediaPeriod$ExtractorHolder
{
  private Extractor extractor;
  private final ExtractorOutput extractorOutput;
  private final Extractor[] extractors;
  
  public ExtractorMediaPeriod$ExtractorHolder(Extractor[] paramArrayOfExtractor, ExtractorOutput paramExtractorOutput)
  {
    this.extractors = paramArrayOfExtractor;
    this.extractorOutput = paramExtractorOutput;
  }
  
  public void release()
  {
    Extractor localExtractor = this.extractor;
    if (localExtractor != null)
    {
      localExtractor.release();
      this.extractor = null;
    }
  }
  
  /* Error */
  public Extractor selectExtractor(com.google.android.exoplayer2.extractor.ExtractorInput paramExtractorInput, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnull +6 -> 14
    //   11: aload 5
    //   13: areturn
    //   14: aload_0
    //   15: getfield 17	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractors	[Lcom/google/android/exoplayer2/extractor/Extractor;
    //   18: astore 5
    //   20: aload 5
    //   22: arraylength
    //   23: istore 4
    //   25: iconst_0
    //   26: istore_3
    //   27: iload_3
    //   28: iload 4
    //   30: if_icmpge +57 -> 87
    //   33: aload 5
    //   35: iload_3
    //   36: aaload
    //   37: astore 6
    //   39: aload 6
    //   41: aload_1
    //   42: invokeinterface 35 2 0
    //   47: ifeq +27 -> 74
    //   50: aload_0
    //   51: aload 6
    //   53: putfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   56: aload_1
    //   57: invokeinterface 40 1 0
    //   62: goto +25 -> 87
    //   65: astore_2
    //   66: aload_1
    //   67: invokeinterface 40 1 0
    //   72: aload_2
    //   73: athrow
    //   74: aload_1
    //   75: invokeinterface 40 1 0
    //   80: iload_3
    //   81: iconst_1
    //   82: iadd
    //   83: istore_3
    //   84: goto -57 -> 27
    //   87: aload_0
    //   88: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +18 -> 111
    //   96: aload_1
    //   97: aload_0
    //   98: getfield 19	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractorOutput	Lcom/google/android/exoplayer2/extractor/ExtractorOutput;
    //   101: invokeinterface 44 2 0
    //   106: aload_0
    //   107: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   110: areturn
    //   111: new 46	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   118: astore_1
    //   119: aload_1
    //   120: ldc 49
    //   122: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 17	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractors	[Lcom/google/android/exoplayer2/extractor/Extractor;
    //   131: invokestatic 59	com/google/android/exoplayer2/util/Util:getCommaDelimitedSimpleClassNames	([Ljava/lang/Object;)Ljava/lang/String;
    //   134: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: ldc 61
    //   141: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: new 63	com/google/android/exoplayer2/source/UnrecognizedInputFormatException
    //   148: dup
    //   149: aload_1
    //   150: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload_2
    //   154: invokespecial 70	com/google/android/exoplayer2/source/UnrecognizedInputFormatException:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   157: astore_1
    //   158: goto +5 -> 163
    //   161: aload_1
    //   162: athrow
    //   163: goto -2 -> 161
    //   166: astore 6
    //   168: goto -94 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	ExtractorHolder
    //   0	171	1	paramExtractorInput	com.google.android.exoplayer2.extractor.ExtractorInput
    //   0	171	2	paramUri	android.net.Uri
    //   26	58	3	i	int
    //   23	8	4	j	int
    //   4	30	5	localObject1	Object
    //   37	15	6	localObject2	Object
    //   166	1	6	localEOFException	java.io.EOFException
    // Exception table:
    //   from	to	target	type
    //   39	56	65	finally
    //   39	56	166	java/io/EOFException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder
 * JD-Core Version:    0.7.0.1
 */