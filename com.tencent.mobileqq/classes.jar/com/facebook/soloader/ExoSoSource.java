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
      //   48: astore 15
      //   50: new 56	java/util/ArrayList
      //   53: dup
      //   54: invokespecial 57	java/util/ArrayList:<init>	()V
      //   57: astore 14
      //   59: new 59	java/util/LinkedHashSet
      //   62: dup
      //   63: invokespecial 60	java/util/LinkedHashSet:<init>	()V
      //   66: astore 16
      //   68: invokestatic 66	com/facebook/soloader/SysUtil:getSupportedAbis	()[Ljava/lang/String;
      //   71: astore_1
      //   72: aload_1
      //   73: arraylength
      //   74: istore 7
      //   76: iconst_0
      //   77: istore_3
      //   78: iload_3
      //   79: iload 7
      //   81: if_icmpge +442 -> 523
      //   84: aload_1
      //   85: iload_3
      //   86: aaload
      //   87: astore 10
      //   89: new 31	java/io/File
      //   92: dup
      //   93: aload 15
      //   95: aload 10
      //   97: invokespecial 69	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   100: astore 13
      //   102: aload 13
      //   104: invokevirtual 73	java/io/File:isDirectory	()Z
      //   107: ifne +10 -> 117
      //   110: iload_3
      //   111: iconst_1
      //   112: iadd
      //   113: istore_3
      //   114: goto -36 -> 78
      //   117: aload 16
      //   119: aload 10
      //   121: invokeinterface 79 2 0
      //   126: pop
      //   127: new 31	java/io/File
      //   130: dup
      //   131: aload 13
      //   133: ldc 81
      //   135: invokespecial 69	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   138: astore 10
      //   140: aload 10
      //   142: invokevirtual 84	java/io/File:isFile	()Z
      //   145: ifeq -35 -> 110
      //   148: new 86	java/io/FileReader
      //   151: dup
      //   152: aload 10
      //   154: invokespecial 89	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   157: astore 11
      //   159: new 91	java/io/BufferedReader
      //   162: dup
      //   163: aload 11
      //   165: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   168: astore 12
      //   170: aconst_null
      //   171: astore 10
      //   173: aload 12
      //   175: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   178: astore 18
      //   180: aload 18
      //   182: ifnull +238 -> 420
      //   185: aload 18
      //   187: invokevirtual 103	java/lang/String:length	()I
      //   190: ifeq -17 -> 173
      //   193: aload 18
      //   195: bipush 32
      //   197: invokevirtual 107	java/lang/String:indexOf	(I)I
      //   200: istore 8
      //   202: iload 8
      //   204: iconst_m1
      //   205: if_icmpne +76 -> 281
      //   208: new 109	java/lang/RuntimeException
      //   211: dup
      //   212: new 33	java/lang/StringBuilder
      //   215: dup
      //   216: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   219: ldc 111
      //   221: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   224: aload 18
      //   226: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   229: ldc 113
      //   231: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   234: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   237: invokespecial 114	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   240: athrow
      //   241: astore_2
      //   242: aload_2
      //   243: athrow
      //   244: astore_1
      //   245: aload 12
      //   247: ifnull +12 -> 259
      //   250: aload_2
      //   251: ifnull +237 -> 488
      //   254: aload 12
      //   256: invokevirtual 117	java/io/BufferedReader:close	()V
      //   259: aload_1
      //   260: athrow
      //   261: astore_2
      //   262: aload_2
      //   263: athrow
      //   264: astore_1
      //   265: aload 11
      //   267: ifnull +12 -> 279
      //   270: aload_2
      //   271: ifnull +244 -> 515
      //   274: aload 11
      //   276: invokevirtual 118	java/io/FileReader:close	()V
      //   279: aload_1
      //   280: athrow
      //   281: new 33	java/lang/StringBuilder
      //   284: dup
      //   285: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   288: aload 18
      //   290: iconst_0
      //   291: iload 8
      //   293: invokevirtual 122	java/lang/String:substring	(II)Ljava/lang/String;
      //   296: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   299: ldc 124
      //   301: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   304: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   307: astore 17
      //   309: aload 14
      //   311: invokevirtual 127	java/util/ArrayList:size	()I
      //   314: istore 9
      //   316: iconst_0
      //   317: istore 6
      //   319: iconst_0
      //   320: istore 4
      //   322: iload 6
      //   324: istore 5
      //   326: iload 4
      //   328: iload 9
      //   330: if_icmpge +27 -> 357
      //   333: aload 14
      //   335: iload 4
      //   337: invokevirtual 131	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   340: checkcast 133	com/facebook/soloader/ExoSoSource$FileDso
      //   343: getfield 137	com/facebook/soloader/ExoSoSource$FileDso:name	Ljava/lang/String;
      //   346: aload 17
      //   348: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   351: ifeq +60 -> 411
      //   354: iconst_1
      //   355: istore 5
      //   357: iload 5
      //   359: ifne -186 -> 173
      //   362: aload 18
      //   364: iload 8
      //   366: iconst_1
      //   367: iadd
      //   368: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
      //   371: astore 18
      //   373: aload 14
      //   375: new 133	com/facebook/soloader/ExoSoSource$FileDso
      //   378: dup
      //   379: aload 17
      //   381: aload 18
      //   383: new 31	java/io/File
      //   386: dup
      //   387: aload 13
      //   389: aload 18
      //   391: invokespecial 69	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   394: invokespecial 146	com/facebook/soloader/ExoSoSource$FileDso:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
      //   397: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   400: pop
      //   401: goto -228 -> 173
      //   404: astore_1
      //   405: aload 10
      //   407: astore_2
      //   408: goto -163 -> 245
      //   411: iload 4
      //   413: iconst_1
      //   414: iadd
      //   415: istore 4
      //   417: goto -95 -> 322
      //   420: aload 12
      //   422: ifnull +12 -> 434
      //   425: iconst_0
      //   426: ifeq +43 -> 469
      //   429: aload 12
      //   431: invokevirtual 117	java/io/BufferedReader:close	()V
      //   434: aload 11
      //   436: ifnull -326 -> 110
      //   439: iconst_0
      //   440: ifeq +56 -> 496
      //   443: aload 11
      //   445: invokevirtual 118	java/io/FileReader:close	()V
      //   448: goto -338 -> 110
      //   451: astore_1
      //   452: new 149	java/lang/NullPointerException
      //   455: dup
      //   456: invokespecial 150	java/lang/NullPointerException:<init>	()V
      //   459: athrow
      //   460: astore_1
      //   461: new 149	java/lang/NullPointerException
      //   464: dup
      //   465: invokespecial 150	java/lang/NullPointerException:<init>	()V
      //   468: athrow
      //   469: aload 12
      //   471: invokevirtual 117	java/io/BufferedReader:close	()V
      //   474: goto -40 -> 434
      //   477: astore 10
      //   479: aload_2
      //   480: aload 10
      //   482: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   485: goto -226 -> 259
      //   488: aload 12
      //   490: invokevirtual 117	java/io/BufferedReader:close	()V
      //   493: goto -234 -> 259
      //   496: aload 11
      //   498: invokevirtual 118	java/io/FileReader:close	()V
      //   501: goto -391 -> 110
      //   504: astore 10
      //   506: aload_2
      //   507: aload 10
      //   509: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   512: goto -233 -> 279
      //   515: aload 11
      //   517: invokevirtual 118	java/io/FileReader:close	()V
      //   520: goto -241 -> 279
      //   523: aload_2
      //   524: aload 16
      //   526: aload 16
      //   528: invokeinterface 155 1 0
      //   533: anewarray 99	java/lang/String
      //   536: invokeinterface 159 2 0
      //   541: checkcast 161	[Ljava/lang/String;
      //   544: invokevirtual 167	com/facebook/soloader/UnpackingSoSource:setSoSourceAbis	([Ljava/lang/String;)V
      //   547: aload_0
      //   548: aload 14
      //   550: aload 14
      //   552: invokevirtual 127	java/util/ArrayList:size	()I
      //   555: anewarray 133	com/facebook/soloader/ExoSoSource$FileDso
      //   558: invokevirtual 168	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
      //   561: checkcast 169	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   564: putfield 171	com/facebook/soloader/ExoSoSource$ExoUnpacker:mDsos	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   567: return
      //   568: astore_1
      //   569: aconst_null
      //   570: astore_2
      //   571: goto -306 -> 265
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	574	0	this	ExoUnpacker
      //   0	574	1	this$1	ExoSoSource
      //   0	574	2	paramUnpackingSoSource	UnpackingSoSource
      //   77	37	3	i	int
      //   320	96	4	j	int
      //   324	34	5	k	int
      //   317	6	6	m	int
      //   74	8	7	n	int
      //   200	168	8	i1	int
      //   314	17	9	i2	int
      //   87	319	10	localObject	Object
      //   477	4	10	localThrowable1	java.lang.Throwable
      //   504	4	10	localThrowable2	java.lang.Throwable
      //   157	359	11	localFileReader	java.io.FileReader
      //   168	321	12	localBufferedReader	java.io.BufferedReader
      //   100	288	13	localFile1	File
      //   57	494	14	localArrayList	java.util.ArrayList
      //   48	46	15	localFile2	File
      //   66	461	16	localLinkedHashSet	java.util.LinkedHashSet
      //   307	73	17	str1	String
      //   178	212	18	str2	String
      // Exception table:
      //   from	to	target	type
      //   173	180	241	java/lang/Throwable
      //   185	202	241	java/lang/Throwable
      //   208	241	241	java/lang/Throwable
      //   281	316	241	java/lang/Throwable
      //   333	354	241	java/lang/Throwable
      //   362	401	241	java/lang/Throwable
      //   242	244	244	finally
      //   159	170	261	java/lang/Throwable
      //   259	261	261	java/lang/Throwable
      //   461	469	261	java/lang/Throwable
      //   469	474	261	java/lang/Throwable
      //   479	485	261	java/lang/Throwable
      //   488	493	261	java/lang/Throwable
      //   262	264	264	finally
      //   173	180	404	finally
      //   185	202	404	finally
      //   208	241	404	finally
      //   281	316	404	finally
      //   333	354	404	finally
      //   362	401	404	finally
      //   443	448	451	java/lang/Throwable
      //   429	434	460	java/lang/Throwable
      //   254	259	477	java/lang/Throwable
      //   274	279	504	java/lang/Throwable
      //   159	170	568	finally
      //   254	259	568	finally
      //   259	261	568	finally
      //   429	434	568	finally
      //   461	469	568	finally
      //   469	474	568	finally
      //   479	485	568	finally
      //   488	493	568	finally
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