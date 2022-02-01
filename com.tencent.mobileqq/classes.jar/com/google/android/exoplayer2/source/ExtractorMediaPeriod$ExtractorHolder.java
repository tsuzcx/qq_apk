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
    if (this.extractor != null)
    {
      this.extractor.release();
      this.extractor = null;
    }
  }
  
  /* Error */
  public Extractor selectExtractor(com.google.android.exoplayer2.extractor.ExtractorInput paramExtractorInput, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   11: areturn
    //   12: aload_0
    //   13: getfield 17	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractors	[Lcom/google/android/exoplayer2/extractor/Extractor;
    //   16: astore 5
    //   18: aload 5
    //   20: arraylength
    //   21: istore 4
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_3
    //   26: iload 4
    //   28: if_icmpge +32 -> 60
    //   31: aload 5
    //   33: iload_3
    //   34: aaload
    //   35: astore 6
    //   37: aload 6
    //   39: aload_1
    //   40: invokeinterface 35 2 0
    //   45: ifeq +61 -> 106
    //   48: aload_0
    //   49: aload 6
    //   51: putfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   54: aload_1
    //   55: invokeinterface 40 1 0
    //   60: aload_0
    //   61: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   64: ifnonnull +75 -> 139
    //   67: new 42	com/google/android/exoplayer2/source/UnrecognizedInputFormatException
    //   70: dup
    //   71: new 44	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   78: ldc 47
    //   80: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 17	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractors	[Lcom/google/android/exoplayer2/extractor/Extractor;
    //   87: invokestatic 57	com/google/android/exoplayer2/util/Util:getCommaDelimitedSimpleClassNames	([Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 59
    //   95: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aload_2
    //   102: invokespecial 66	com/google/android/exoplayer2/source/UnrecognizedInputFormatException:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   105: athrow
    //   106: aload_1
    //   107: invokeinterface 40 1 0
    //   112: iload_3
    //   113: iconst_1
    //   114: iadd
    //   115: istore_3
    //   116: goto -91 -> 25
    //   119: astore 6
    //   121: aload_1
    //   122: invokeinterface 40 1 0
    //   127: goto -15 -> 112
    //   130: astore_2
    //   131: aload_1
    //   132: invokeinterface 40 1 0
    //   137: aload_2
    //   138: athrow
    //   139: aload_0
    //   140: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   143: aload_0
    //   144: getfield 19	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractorOutput	Lcom/google/android/exoplayer2/extractor/ExtractorOutput;
    //   147: invokeinterface 70 2 0
    //   152: aload_0
    //   153: getfield 23	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   156: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ExtractorHolder
    //   0	157	1	paramExtractorInput	com.google.android.exoplayer2.extractor.ExtractorInput
    //   0	157	2	paramUri	android.net.Uri
    //   24	92	3	i	int
    //   21	8	4	j	int
    //   16	16	5	arrayOfExtractor	Extractor[]
    //   35	15	6	localExtractor	Extractor
    //   119	1	6	localEOFException	java.io.EOFException
    // Exception table:
    //   from	to	target	type
    //   37	54	119	java/io/EOFException
    //   37	54	130	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder
 * JD-Core Version:    0.7.0.1
 */