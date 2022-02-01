package com.google.android.exoplayer2.extractor;

import java.lang.reflect.Constructor;

public final class DefaultExtractorsFactory
  implements ExtractorsFactory
{
  private static final Constructor<? extends Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
  private int fragmentedMp4Flags;
  private int matroskaFlags;
  private int mp3Flags;
  private int mp4Flags;
  private int tsFlags;
  private int tsMode = 1;
  
  static
  {
    Object localObject = null;
    try
    {
      Constructor localConstructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
      localObject = localConstructor;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Error instantiating FLAC extension", localException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label22:
      break label22;
    }
    FLAC_EXTRACTOR_CONSTRUCTOR = localObject;
  }
  
  /* Error */
  public Extractor[] createExtractors()
  {
    // Byte code:
    //   0: bipush 11
    //   2: istore_1
    //   3: aload_0
    //   4: monitorenter
    //   5: getstatic 42	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:FLAC_EXTRACTOR_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   8: ifnonnull +176 -> 184
    //   11: iload_1
    //   12: anewarray 32	com/google/android/exoplayer2/extractor/Extractor
    //   15: astore_2
    //   16: aload_2
    //   17: iconst_0
    //   18: new 59	com/google/android/exoplayer2/extractor/mp4/Mp4Extractor
    //   21: dup
    //   22: aload_0
    //   23: getfield 61	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:mp4Flags	I
    //   26: invokespecial 64	com/google/android/exoplayer2/extractor/mp4/Mp4Extractor:<init>	(I)V
    //   29: aastore
    //   30: aload_2
    //   31: iconst_1
    //   32: new 66	com/google/android/exoplayer2/extractor/ts/TsExtractor
    //   35: dup
    //   36: aload_0
    //   37: getfield 55	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:tsMode	I
    //   40: aload_0
    //   41: getfield 68	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:tsFlags	I
    //   44: invokespecial 71	com/google/android/exoplayer2/extractor/ts/TsExtractor:<init>	(II)V
    //   47: aastore
    //   48: aload_2
    //   49: iconst_2
    //   50: new 73	com/google/android/exoplayer2/extractor/mp3/Mp3Extractor
    //   53: dup
    //   54: aload_0
    //   55: getfield 75	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:mp3Flags	I
    //   58: invokespecial 76	com/google/android/exoplayer2/extractor/mp3/Mp3Extractor:<init>	(I)V
    //   61: aastore
    //   62: aload_2
    //   63: iconst_3
    //   64: new 78	com/google/android/exoplayer2/extractor/mp4/FragmentedMp4Extractor
    //   67: dup
    //   68: aload_0
    //   69: getfield 80	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:fragmentedMp4Flags	I
    //   72: invokespecial 81	com/google/android/exoplayer2/extractor/mp4/FragmentedMp4Extractor:<init>	(I)V
    //   75: aastore
    //   76: aload_2
    //   77: iconst_4
    //   78: new 83	com/google/android/exoplayer2/extractor/mkv/MatroskaExtractor
    //   81: dup
    //   82: aload_0
    //   83: getfield 85	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:matroskaFlags	I
    //   86: invokespecial 86	com/google/android/exoplayer2/extractor/mkv/MatroskaExtractor:<init>	(I)V
    //   89: aastore
    //   90: aload_2
    //   91: iconst_5
    //   92: new 88	com/google/android/exoplayer2/extractor/ts/AdtsExtractor
    //   95: dup
    //   96: invokespecial 89	com/google/android/exoplayer2/extractor/ts/AdtsExtractor:<init>	()V
    //   99: aastore
    //   100: aload_2
    //   101: bipush 6
    //   103: new 91	com/google/android/exoplayer2/extractor/ts/Ac3Extractor
    //   106: dup
    //   107: invokespecial 92	com/google/android/exoplayer2/extractor/ts/Ac3Extractor:<init>	()V
    //   110: aastore
    //   111: aload_2
    //   112: bipush 7
    //   114: new 94	com/google/android/exoplayer2/extractor/flv/FlvExtractor
    //   117: dup
    //   118: invokespecial 95	com/google/android/exoplayer2/extractor/flv/FlvExtractor:<init>	()V
    //   121: aastore
    //   122: aload_2
    //   123: bipush 8
    //   125: new 97	com/google/android/exoplayer2/extractor/ogg/OggExtractor
    //   128: dup
    //   129: invokespecial 98	com/google/android/exoplayer2/extractor/ogg/OggExtractor:<init>	()V
    //   132: aastore
    //   133: aload_2
    //   134: bipush 9
    //   136: new 100	com/google/android/exoplayer2/extractor/ts/PsExtractor
    //   139: dup
    //   140: invokespecial 101	com/google/android/exoplayer2/extractor/ts/PsExtractor:<init>	()V
    //   143: aastore
    //   144: aload_2
    //   145: bipush 10
    //   147: new 103	com/google/android/exoplayer2/extractor/wav/WavExtractor
    //   150: dup
    //   151: invokespecial 104	com/google/android/exoplayer2/extractor/wav/WavExtractor:<init>	()V
    //   154: aastore
    //   155: getstatic 42	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:FLAC_EXTRACTOR_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   158: astore_3
    //   159: aload_3
    //   160: ifnull +20 -> 180
    //   163: aload_2
    //   164: bipush 11
    //   166: getstatic 42	com/google/android/exoplayer2/extractor/DefaultExtractorsFactory:FLAC_EXTRACTOR_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokevirtual 110	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 32	com/google/android/exoplayer2/extractor/Extractor
    //   179: aastore
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_2
    //   183: areturn
    //   184: bipush 12
    //   186: istore_1
    //   187: goto -176 -> 11
    //   190: astore_2
    //   191: new 112	java/lang/IllegalStateException
    //   194: dup
    //   195: ldc 114
    //   197: aload_2
    //   198: invokespecial 115	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: athrow
    //   202: astore_2
    //   203: aload_0
    //   204: monitorexit
    //   205: aload_2
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	DefaultExtractorsFactory
    //   2	185	1	i	int
    //   15	168	2	arrayOfExtractor	Extractor[]
    //   190	8	2	localException	Exception
    //   202	4	2	localObject	Object
    //   158	2	3	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   163	180	190	java/lang/Exception
    //   5	11	202	finally
    //   11	159	202	finally
    //   163	180	202	finally
    //   191	202	202	finally
  }
  
  public DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int paramInt)
  {
    try
    {
      this.fragmentedMp4Flags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setMatroskaExtractorFlags(int paramInt)
  {
    try
    {
      this.matroskaFlags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setMp3ExtractorFlags(int paramInt)
  {
    try
    {
      this.mp3Flags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setMp4ExtractorFlags(int paramInt)
  {
    try
    {
      this.mp4Flags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setTsExtractorFlags(int paramInt)
  {
    try
    {
      this.tsFlags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setTsExtractorMode(int paramInt)
  {
    try
    {
      this.tsMode = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
 * JD-Core Version:    0.7.0.1
 */