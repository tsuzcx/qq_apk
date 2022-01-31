package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExoSoSource
  extends UnpackingSoSource
{
  public ExoSoSource(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ExoUnpacker(this);
  }
  
  private final class ExoUnpacker
    extends UnpackingSoSource.Unpacker
  {
    private final ExoSoSource.FileDso[] mDsos;
    
    /* Error */
    ExoUnpacker(UnpackingSoSource paramUnpackingSoSource)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 22	com/facebook/soloader/ExoSoSource$ExoUnpacker:this$0	Lcom/facebook/soloader/ExoSoSource;
      //   5: aload_0
      //   6: invokespecial 25	com/facebook/soloader/UnpackingSoSource$Unpacker:<init>	()V
      //   9: aload_1
      //   10: getfield 29	com/facebook/soloader/ExoSoSource:mContext	Landroid/content/Context;
      //   13: astore_1
      //   14: new 31	java/io/File
      //   17: dup
      //   18: new 33	java/lang/StringBuilder
      //   21: dup
      //   22: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   25: ldc 36
      //   27: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: aload_1
      //   31: invokevirtual 46	android/content/Context:getPackageName	()Ljava/lang/String;
      //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: ldc 48
      //   39: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
      //   48: astore 13
      //   50: new 56	java/util/ArrayList
      //   53: dup
      //   54: invokespecial 57	java/util/ArrayList:<init>	()V
      //   57: astore 14
      //   59: new 59	java/util/LinkedHashSet
      //   62: dup
      //   63: invokespecial 60	java/util/LinkedHashSet:<init>	()V
      //   66: astore 12
      //   68: invokestatic 66	com/facebook/soloader/SysUtil:getSupportedAbis	()[Ljava/lang/String;
      //   71: astore 15
      //   73: aload 15
      //   75: arraylength
      //   76: istore 7
      //   78: iconst_0
      //   79: istore_3
      //   80: iload_3
      //   81: iload 7
      //   83: if_icmpge +433 -> 516
      //   86: aload 15
      //   88: iload_3
      //   89: aaload
      //   90: astore_1
      //   91: new 31	java/io/File
      //   94: dup
      //   95: aload 13
      //   97: aload_1
      //   98: invokespecial 69	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   101: astore 16
      //   103: aload 16
      //   105: invokevirtual 73	java/io/File:isDirectory	()Z
      //   108: ifne +10 -> 118
      //   111: iload_3
      //   112: iconst_1
      //   113: iadd
      //   114: istore_3
      //   115: goto -35 -> 80
      //   118: aload 12
      //   120: aload_1
      //   121: invokeinterface 79 2 0
      //   126: pop
      //   127: new 31	java/io/File
      //   130: dup
      //   131: aload 16
      //   133: ldc 81
      //   135: invokespecial 69	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   138: astore_1
      //   139: aload_1
      //   140: invokevirtual 84	java/io/File:isFile	()Z
      //   143: ifeq -32 -> 111
      //   146: new 86	java/io/FileReader
      //   149: dup
      //   150: aload_1
      //   151: invokespecial 89	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   154: astore 10
      //   156: new 91	java/io/BufferedReader
      //   159: dup
      //   160: aload 10
      //   162: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   165: astore 11
      //   167: aconst_null
      //   168: astore_1
      //   169: aload 11
      //   171: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   174: astore 18
      //   176: aload 18
      //   178: ifnull +235 -> 413
      //   181: aload 18
      //   183: invokevirtual 103	java/lang/String:length	()I
      //   186: ifeq -17 -> 169
      //   189: aload 18
      //   191: bipush 32
      //   193: invokevirtual 107	java/lang/String:indexOf	(I)I
      //   196: istore 8
      //   198: iload 8
      //   200: iconst_m1
      //   201: if_icmpne +76 -> 277
      //   204: new 109	java/lang/RuntimeException
      //   207: dup
      //   208: new 33	java/lang/StringBuilder
      //   211: dup
      //   212: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   215: ldc 111
      //   217: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: aload 18
      //   222: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   225: ldc 113
      //   227: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   230: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   233: invokespecial 114	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   236: athrow
      //   237: astore_1
      //   238: aload_1
      //   239: athrow
      //   240: astore_2
      //   241: aload 11
      //   243: ifnull +12 -> 255
      //   246: aload_1
      //   247: ifnull +234 -> 481
      //   250: aload 11
      //   252: invokevirtual 117	java/io/BufferedReader:close	()V
      //   255: aload_2
      //   256: athrow
      //   257: astore_1
      //   258: aload_1
      //   259: athrow
      //   260: astore_2
      //   261: aload 10
      //   263: ifnull +12 -> 275
      //   266: aload_1
      //   267: ifnull +241 -> 508
      //   270: aload 10
      //   272: invokevirtual 118	java/io/FileReader:close	()V
      //   275: aload_2
      //   276: athrow
      //   277: new 33	java/lang/StringBuilder
      //   280: dup
      //   281: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   284: aload 18
      //   286: iconst_0
      //   287: iload 8
      //   289: invokevirtual 122	java/lang/String:substring	(II)Ljava/lang/String;
      //   292: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   295: ldc 124
      //   297: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   300: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   303: astore 17
      //   305: aload 14
      //   307: invokevirtual 127	java/util/ArrayList:size	()I
      //   310: istore 9
      //   312: iconst_0
      //   313: istore 6
      //   315: iconst_0
      //   316: istore 5
      //   318: iload 6
      //   320: istore 4
      //   322: iload 5
      //   324: iload 9
      //   326: if_icmpge +27 -> 353
      //   329: aload 14
      //   331: iload 5
      //   333: invokevirtual 131	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   336: checkcast 133	com/facebook/soloader/ExoSoSource$FileDso
      //   339: getfield 137	com/facebook/soloader/ExoSoSource$FileDso:name	Ljava/lang/String;
      //   342: aload 17
      //   344: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   347: ifeq +57 -> 404
      //   350: iconst_1
      //   351: istore 4
      //   353: iload 4
      //   355: ifne -186 -> 169
      //   358: aload 18
      //   360: iload 8
      //   362: iconst_1
      //   363: iadd
      //   364: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
      //   367: astore 18
      //   369: aload 14
      //   371: new 133	com/facebook/soloader/ExoSoSource$FileDso
      //   374: dup
      //   375: aload 17
      //   377: aload 18
      //   379: new 31	java/io/File
      //   382: dup
      //   383: aload 16
      //   385: aload 18
      //   387: invokespecial 69	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   390: invokespecial 146	com/facebook/soloader/ExoSoSource$FileDso:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
      //   393: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   396: pop
      //   397: goto -228 -> 169
      //   400: astore_2
      //   401: goto -160 -> 241
      //   404: iload 5
      //   406: iconst_1
      //   407: iadd
      //   408: istore 5
      //   410: goto -92 -> 318
      //   413: aload 11
      //   415: ifnull +12 -> 427
      //   418: iconst_0
      //   419: ifeq +43 -> 462
      //   422: aload 11
      //   424: invokevirtual 117	java/io/BufferedReader:close	()V
      //   427: aload 10
      //   429: ifnull -318 -> 111
      //   432: iconst_0
      //   433: ifeq +56 -> 489
      //   436: aload 10
      //   438: invokevirtual 118	java/io/FileReader:close	()V
      //   441: goto -330 -> 111
      //   444: astore_1
      //   445: new 149	java/lang/NullPointerException
      //   448: dup
      //   449: invokespecial 150	java/lang/NullPointerException:<init>	()V
      //   452: athrow
      //   453: astore_1
      //   454: new 149	java/lang/NullPointerException
      //   457: dup
      //   458: invokespecial 150	java/lang/NullPointerException:<init>	()V
      //   461: athrow
      //   462: aload 11
      //   464: invokevirtual 117	java/io/BufferedReader:close	()V
      //   467: goto -40 -> 427
      //   470: astore 11
      //   472: aload_1
      //   473: aload 11
      //   475: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   478: goto -223 -> 255
      //   481: aload 11
      //   483: invokevirtual 117	java/io/BufferedReader:close	()V
      //   486: goto -231 -> 255
      //   489: aload 10
      //   491: invokevirtual 118	java/io/FileReader:close	()V
      //   494: goto -383 -> 111
      //   497: astore 10
      //   499: aload_1
      //   500: aload 10
      //   502: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   505: goto -230 -> 275
      //   508: aload 10
      //   510: invokevirtual 118	java/io/FileReader:close	()V
      //   513: goto -238 -> 275
      //   516: aload_2
      //   517: aload 12
      //   519: aload 12
      //   521: invokeinterface 155 1 0
      //   526: anewarray 99	java/lang/String
      //   529: invokeinterface 159 2 0
      //   534: checkcast 161	[Ljava/lang/String;
      //   537: invokevirtual 167	com/facebook/soloader/UnpackingSoSource:setSoSourceAbis	([Ljava/lang/String;)V
      //   540: aload_0
      //   541: aload 14
      //   543: aload 14
      //   545: invokevirtual 127	java/util/ArrayList:size	()I
      //   548: anewarray 133	com/facebook/soloader/ExoSoSource$FileDso
      //   551: invokevirtual 168	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
      //   554: checkcast 169	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   557: putfield 171	com/facebook/soloader/ExoSoSource$ExoUnpacker:mDsos	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   560: return
      //   561: astore_2
      //   562: aconst_null
      //   563: astore_1
      //   564: goto -303 -> 261
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	567	0	this	ExoUnpacker
      //   0	567	1	this$1	ExoSoSource
      //   0	567	2	paramUnpackingSoSource	UnpackingSoSource
      //   79	36	3	i	int
      //   320	34	4	j	int
      //   316	93	5	k	int
      //   313	6	6	m	int
      //   76	8	7	n	int
      //   196	168	8	i1	int
      //   310	17	9	i2	int
      //   154	336	10	localFileReader	java.io.FileReader
      //   497	12	10	localThrowable1	java.lang.Throwable
      //   165	298	11	localBufferedReader	java.io.BufferedReader
      //   470	12	11	localThrowable2	java.lang.Throwable
      //   66	454	12	localLinkedHashSet	java.util.LinkedHashSet
      //   48	48	13	localFile1	File
      //   57	487	14	localArrayList	java.util.ArrayList
      //   71	16	15	arrayOfString	String[]
      //   101	283	16	localFile2	File
      //   303	73	17	str1	String
      //   174	212	18	str2	String
      // Exception table:
      //   from	to	target	type
      //   169	176	237	java/lang/Throwable
      //   181	198	237	java/lang/Throwable
      //   204	237	237	java/lang/Throwable
      //   277	312	237	java/lang/Throwable
      //   329	350	237	java/lang/Throwable
      //   358	397	237	java/lang/Throwable
      //   238	240	240	finally
      //   156	167	257	java/lang/Throwable
      //   255	257	257	java/lang/Throwable
      //   454	462	257	java/lang/Throwable
      //   462	467	257	java/lang/Throwable
      //   472	478	257	java/lang/Throwable
      //   481	486	257	java/lang/Throwable
      //   258	260	260	finally
      //   169	176	400	finally
      //   181	198	400	finally
      //   204	237	400	finally
      //   277	312	400	finally
      //   329	350	400	finally
      //   358	397	400	finally
      //   436	441	444	java/lang/Throwable
      //   422	427	453	java/lang/Throwable
      //   250	255	470	java/lang/Throwable
      //   270	275	497	java/lang/Throwable
      //   156	167	561	finally
      //   250	255	561	finally
      //   255	257	561	finally
      //   422	427	561	finally
      //   454	462	561	finally
      //   462	467	561	finally
      //   472	478	561	finally
      //   481	486	561	finally
    }
    
    protected UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException
    {
      return new UnpackingSoSource.DsoManifest(this.mDsos);
    }
    
    protected UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException
    {
      return new FileBackedInputDsoIterator(null);
    }
    
    private final class FileBackedInputDsoIterator
      extends UnpackingSoSource.InputDsoIterator
    {
      private int mCurrentDso;
      
      private FileBackedInputDsoIterator() {}
      
      public boolean hasNext()
      {
        return this.mCurrentDso < ExoSoSource.ExoUnpacker.this.mDsos.length;
      }
      
      public UnpackingSoSource.InputDso next()
        throws IOException
      {
        Object localObject1 = ExoSoSource.ExoUnpacker.this.mDsos;
        int i = this.mCurrentDso;
        this.mCurrentDso = (i + 1);
        Object localObject2 = localObject1[i];
        localObject1 = new FileInputStream(((ExoSoSource.FileDso)localObject2).backingFile);
        try
        {
          localObject2 = new UnpackingSoSource.InputDso((UnpackingSoSource.Dso)localObject2, (InputStream)localObject1);
          if (0 != 0) {
            throw new NullPointerException();
          }
          return localObject2;
        }
        finally
        {
          if (localObject1 != null) {
            ((FileInputStream)localObject1).close();
          }
        }
      }
    }
  }
  
  private static final class FileDso
    extends UnpackingSoSource.Dso
  {
    final File backingFile;
    
    FileDso(String paramString1, String paramString2, File paramFile)
    {
      super(paramString2);
      this.backingFile = paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.soloader.ExoSoSource
 * JD-Core Version:    0.7.0.1
 */