package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public abstract class UnpackingSoSource
  extends DirectorySoSource
{
  private static final String DEPS_FILE_NAME = "dso_deps";
  private static final String LOCK_FILE_NAME = "dso_lock";
  private static final String MANIFEST_FILE_NAME = "dso_manifest";
  private static final byte MANIFEST_VERSION = 1;
  private static final byte STATE_CLEAN = 1;
  private static final byte STATE_DIRTY = 0;
  private static final String STATE_FILE_NAME = "dso_state";
  private static final String TAG = "fb-UnpackingSoSource";
  private String[] mAbis;
  protected final Context mContext;
  
  protected UnpackingSoSource(Context paramContext, String paramString)
  {
    super(getSoStorePath(paramContext, paramString), 1);
    this.mContext = paramContext;
  }
  
  private void deleteUnmentionedFiles(Dso[] paramArrayOfDso)
    throws IOException
  {
    String[] arrayOfString = this.soDirectory.list();
    if (arrayOfString == null) {
      throw new IOException("unable to list directory " + this.soDirectory);
    }
    int i = 0;
    if (i < arrayOfString.length)
    {
      Object localObject = arrayOfString[i];
      if ((((String)localObject).equals("dso_state")) || (((String)localObject).equals("dso_lock")) || (((String)localObject).equals("dso_deps")) || (((String)localObject).equals("dso_manifest"))) {}
      for (;;)
      {
        i += 1;
        break;
        int k = 0;
        int j = 0;
        while ((k == 0) && (j < paramArrayOfDso.length))
        {
          if (paramArrayOfDso[j].name.equals(localObject)) {
            k = 1;
          }
          j += 1;
        }
        if (k == 0)
        {
          localObject = new File(this.soDirectory, (String)localObject);
          Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + localObject);
          SysUtil.dumbDeleteRecursive((File)localObject);
        }
      }
    }
  }
  
  private void extractDso(InputDso paramInputDso, byte[] paramArrayOfByte)
    throws IOException
  {
    Log.i("fb-UnpackingSoSource", "extracting DSO " + paramInputDso.dso.name);
    if (!this.soDirectory.setWritable(true, true)) {
      throw new IOException("cannot make directory writable for us: " + this.soDirectory);
    }
    File localFile = new File(this.soDirectory, paramInputDso.dso.name);
    try
    {
      RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile, "rw");
      try
      {
        int i = paramInputDso.content.available();
        if (i > 1) {
          SysUtil.fallocateIfSupported(localRandomAccessFile1.getFD(), i);
        }
        SysUtil.copyBytes(localRandomAccessFile1, paramInputDso.content, 2147483647, paramArrayOfByte);
        localRandomAccessFile1.setLength(localRandomAccessFile1.getFilePointer());
        if (!localFile.setExecutable(true, false)) {
          throw new IOException("cannot make file executable: " + localFile);
        }
      }
      finally
      {
        localRandomAccessFile1.close();
      }
    }
    catch (IOException localIOException)
    {
      RandomAccessFile localRandomAccessFile2;
      for (;;)
      {
        Log.w("fb-UnpackingSoSource", "error overwriting " + localFile + " trying to delete and start over", localIOException);
        SysUtil.dumbDeleteRecursive(localFile);
        localRandomAccessFile2 = new RandomAccessFile(localFile, "rw");
      }
      localRandomAccessFile2.close();
    }
  }
  
  public static File getSoStorePath(Context paramContext, String paramString)
  {
    return new File(paramContext.getApplicationInfo().dataDir + "/" + paramString);
  }
  
  /* Error */
  private boolean refreshLocked(final FileLocker paramFileLocker, int paramInt, final byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 75	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 73	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   8: ldc 40
    //   10: invokespecial 112	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 10
    //   15: new 145	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 10
    //   21: ldc 147
    //   23: invokespecial 148	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 6
    //   31: aload 7
    //   33: invokevirtual 219	java/io/RandomAccessFile:readByte	()B
    //   36: istore 5
    //   38: iload 5
    //   40: istore 4
    //   42: iload 5
    //   44: iconst_1
    //   45: if_icmpeq +39 -> 84
    //   48: ldc 43
    //   50: new 81	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   57: ldc 221
    //   59: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 73	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   66: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: ldc 223
    //   71: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 120	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: iconst_0
    //   82: istore 4
    //   84: aload 7
    //   86: ifnull +12 -> 98
    //   89: iconst_0
    //   90: ifeq +219 -> 309
    //   93: aload 7
    //   95: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   98: new 75	java/io/File
    //   101: dup
    //   102: aload_0
    //   103: getfield 73	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   106: ldc 25
    //   108: invokespecial 112	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   111: astore 11
    //   113: aconst_null
    //   114: astore 6
    //   116: new 145	java/io/RandomAccessFile
    //   119: dup
    //   120: aload 11
    //   122: ldc 147
    //   124: invokespecial 148	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore 8
    //   129: aload 8
    //   131: invokevirtual 226	java/io/RandomAccessFile:length	()J
    //   134: l2i
    //   135: newarray byte
    //   137: astore 7
    //   139: aload 8
    //   141: aload 7
    //   143: invokevirtual 230	java/io/RandomAccessFile:read	([B)I
    //   146: aload 7
    //   148: arraylength
    //   149: if_icmpeq +14 -> 163
    //   152: ldc 43
    //   154: ldc 232
    //   156: invokestatic 120	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: iconst_0
    //   161: istore 4
    //   163: aload 7
    //   165: aload_3
    //   166: invokestatic 237	java/util/Arrays:equals	([B[B)Z
    //   169: ifne +14 -> 183
    //   172: ldc 43
    //   174: ldc 239
    //   176: invokestatic 120	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   179: pop
    //   180: iconst_0
    //   181: istore 4
    //   183: iload 4
    //   185: ifne +86 -> 271
    //   188: ldc 43
    //   190: ldc 241
    //   192: invokestatic 120	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aload 10
    //   198: iconst_0
    //   199: invokestatic 66	com/facebook/soloader/UnpackingSoSource:writeState	(Ljava/io/File;B)V
    //   202: aload_0
    //   203: invokevirtual 245	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   206: astore 9
    //   208: aload 9
    //   210: invokevirtual 249	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   213: astore 7
    //   215: aload 9
    //   217: invokevirtual 253	com/facebook/soloader/UnpackingSoSource$Unpacker:openDsoIterator	()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    //   220: astore 12
    //   222: aconst_null
    //   223: astore 6
    //   225: aload_0
    //   226: iload 4
    //   228: aload 7
    //   230: aload 12
    //   232: invokespecial 257	com/facebook/soloader/UnpackingSoSource:regenerate	(BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;)V
    //   235: aload 12
    //   237: ifnull +12 -> 249
    //   240: iconst_0
    //   241: ifeq +164 -> 405
    //   244: aload 12
    //   246: invokevirtual 258	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   249: aload 7
    //   251: astore 6
    //   253: aload 9
    //   255: ifnull +16 -> 271
    //   258: iconst_0
    //   259: ifeq +211 -> 470
    //   262: aload 9
    //   264: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   267: aload 7
    //   269: astore 6
    //   271: aload 8
    //   273: ifnull +12 -> 285
    //   276: iconst_0
    //   277: ifeq +233 -> 510
    //   280: aload 8
    //   282: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   285: aload 6
    //   287: ifnonnull +250 -> 537
    //   290: iconst_0
    //   291: ireturn
    //   292: astore 6
    //   294: iconst_0
    //   295: istore 4
    //   297: goto -213 -> 84
    //   300: astore_1
    //   301: new 261	java/lang/NullPointerException
    //   304: dup
    //   305: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   308: athrow
    //   309: aload 7
    //   311: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   314: goto -216 -> 98
    //   317: astore_1
    //   318: aload_1
    //   319: athrow
    //   320: astore_3
    //   321: aload 7
    //   323: ifnull +12 -> 335
    //   326: aload_1
    //   327: ifnull +21 -> 348
    //   330: aload 7
    //   332: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   335: aload_3
    //   336: athrow
    //   337: astore 6
    //   339: aload_1
    //   340: aload 6
    //   342: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   345: goto -10 -> 335
    //   348: aload 7
    //   350: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   353: goto -18 -> 335
    //   356: astore_1
    //   357: new 261	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: astore_1
    //   366: aload_1
    //   367: athrow
    //   368: astore_3
    //   369: aload 9
    //   371: ifnull +12 -> 383
    //   374: aload_1
    //   375: ifnull +118 -> 493
    //   378: aload 9
    //   380: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   383: aload_3
    //   384: athrow
    //   385: astore_3
    //   386: aload_3
    //   387: athrow
    //   388: astore_1
    //   389: aload 8
    //   391: ifnull +12 -> 403
    //   394: aload_3
    //   395: ifnull +134 -> 529
    //   398: aload 8
    //   400: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   403: aload_1
    //   404: athrow
    //   405: aload 12
    //   407: invokevirtual 258	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   410: goto -161 -> 249
    //   413: astore_3
    //   414: aconst_null
    //   415: astore_1
    //   416: goto -47 -> 369
    //   419: astore_1
    //   420: aload_1
    //   421: astore 6
    //   423: aload_1
    //   424: athrow
    //   425: astore_1
    //   426: aload 12
    //   428: ifnull +13 -> 441
    //   431: aload 6
    //   433: ifnull +20 -> 453
    //   436: aload 12
    //   438: invokevirtual 258	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   441: aload_1
    //   442: athrow
    //   443: astore_3
    //   444: aload 6
    //   446: aload_3
    //   447: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   450: goto -9 -> 441
    //   453: aload 12
    //   455: invokevirtual 258	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   458: goto -17 -> 441
    //   461: astore_1
    //   462: new 261	java/lang/NullPointerException
    //   465: dup
    //   466: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   469: athrow
    //   470: aload 9
    //   472: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   475: aload 7
    //   477: astore 6
    //   479: goto -208 -> 271
    //   482: astore 6
    //   484: aload_1
    //   485: aload 6
    //   487: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   490: goto -107 -> 383
    //   493: aload 9
    //   495: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   498: goto -115 -> 383
    //   501: astore_1
    //   502: new 261	java/lang/NullPointerException
    //   505: dup
    //   506: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   509: athrow
    //   510: aload 8
    //   512: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   515: goto -230 -> 285
    //   518: astore 6
    //   520: aload_3
    //   521: aload 6
    //   523: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   526: goto -123 -> 403
    //   529: aload 8
    //   531: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   534: goto -131 -> 403
    //   537: new 6	com/facebook/soloader/UnpackingSoSource$1
    //   540: dup
    //   541: aload_0
    //   542: aload 11
    //   544: aload_3
    //   545: aload 6
    //   547: aload 10
    //   549: aload_1
    //   550: invokespecial 269	com/facebook/soloader/UnpackingSoSource$1:<init>	(Lcom/facebook/soloader/UnpackingSoSource;Ljava/io/File;[BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Ljava/io/File;Lcom/facebook/soloader/FileLocker;)V
    //   553: astore_1
    //   554: iload_2
    //   555: iconst_1
    //   556: iand
    //   557: ifeq +42 -> 599
    //   560: new 271	java/lang/Thread
    //   563: dup
    //   564: aload_1
    //   565: new 81	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 273
    //   575: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_0
    //   579: getfield 73	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   582: invokevirtual 276	java/io/File:getName	()Ljava/lang/String;
    //   585: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokespecial 279	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   594: invokevirtual 282	java/lang/Thread:start	()V
    //   597: iconst_1
    //   598: ireturn
    //   599: aload_1
    //   600: invokeinterface 287 1 0
    //   605: goto -8 -> 597
    //   608: astore_3
    //   609: aload 6
    //   611: astore_1
    //   612: goto -291 -> 321
    //   615: astore_1
    //   616: aconst_null
    //   617: astore_3
    //   618: goto -229 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	UnpackingSoSource
    //   0	621	1	paramFileLocker	FileLocker
    //   0	621	2	paramInt	int
    //   0	621	3	paramArrayOfByte	byte[]
    //   40	256	4	b1	byte
    //   36	10	5	b2	byte
    //   29	257	6	localObject1	Object
    //   292	1	6	localEOFException	java.io.EOFException
    //   337	4	6	localThrowable1	java.lang.Throwable
    //   421	57	6	localObject2	Object
    //   482	4	6	localThrowable2	java.lang.Throwable
    //   518	92	6	localThrowable3	java.lang.Throwable
    //   26	450	7	localObject3	Object
    //   127	403	8	localRandomAccessFile	RandomAccessFile
    //   206	288	9	localUnpacker	Unpacker
    //   13	535	10	localFile1	File
    //   111	432	11	localFile2	File
    //   220	234	12	localInputDsoIterator	InputDsoIterator
    // Exception table:
    //   from	to	target	type
    //   31	38	292	java/io/EOFException
    //   48	81	292	java/io/EOFException
    //   93	98	300	java/lang/Throwable
    //   31	38	317	java/lang/Throwable
    //   48	81	317	java/lang/Throwable
    //   318	320	320	finally
    //   330	335	337	java/lang/Throwable
    //   244	249	356	java/lang/Throwable
    //   208	222	365	java/lang/Throwable
    //   357	365	365	java/lang/Throwable
    //   405	410	365	java/lang/Throwable
    //   441	443	365	java/lang/Throwable
    //   444	450	365	java/lang/Throwable
    //   453	458	365	java/lang/Throwable
    //   366	368	368	finally
    //   129	139	385	java/lang/Throwable
    //   139	160	385	java/lang/Throwable
    //   163	180	385	java/lang/Throwable
    //   188	208	385	java/lang/Throwable
    //   383	385	385	java/lang/Throwable
    //   462	470	385	java/lang/Throwable
    //   470	475	385	java/lang/Throwable
    //   484	490	385	java/lang/Throwable
    //   493	498	385	java/lang/Throwable
    //   386	388	388	finally
    //   208	222	413	finally
    //   244	249	413	finally
    //   357	365	413	finally
    //   405	410	413	finally
    //   436	441	413	finally
    //   441	443	413	finally
    //   444	450	413	finally
    //   453	458	413	finally
    //   225	235	419	java/lang/Throwable
    //   225	235	425	finally
    //   423	425	425	finally
    //   436	441	443	java/lang/Throwable
    //   262	267	461	java/lang/Throwable
    //   378	383	482	java/lang/Throwable
    //   280	285	501	java/lang/Throwable
    //   398	403	518	java/lang/Throwable
    //   31	38	608	finally
    //   48	81	608	finally
    //   129	139	615	finally
    //   139	160	615	finally
    //   163	180	615	finally
    //   188	208	615	finally
    //   262	267	615	finally
    //   378	383	615	finally
    //   383	385	615	finally
    //   462	470	615	finally
    //   470	475	615	finally
    //   484	490	615	finally
    //   493	498	615	finally
  }
  
  /* Error */
  private void regenerate(byte paramByte, DsoManifest paramDsoManifest, InputDsoIterator paramInputDsoIterator)
    throws IOException
  {
    // Byte code:
    //   0: ldc 43
    //   2: new 81	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 291
    //   12: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 297	java/lang/Object:getClass	()Ljava/lang/Class;
    //   19: invokevirtual 300	java/lang/Class:getName	()Ljava/lang/String;
    //   22: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 120	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: new 145	java/io/RandomAccessFile
    //   35: dup
    //   36: new 75	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: getfield 73	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   44: ldc 31
    //   46: invokespecial 112	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: ldc 147
    //   51: invokespecial 148	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 8
    //   56: iload_1
    //   57: iconst_1
    //   58: if_icmpne +165 -> 223
    //   61: aload 8
    //   63: invokestatic 303	com/facebook/soloader/UnpackingSoSource$DsoManifest:read	(Ljava/io/DataInput;)Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnonnull +328 -> 398
    //   73: new 11	com/facebook/soloader/UnpackingSoSource$DsoManifest
    //   76: dup
    //   77: iconst_0
    //   78: anewarray 8	com/facebook/soloader/UnpackingSoSource$Dso
    //   81: invokespecial 305	com/facebook/soloader/UnpackingSoSource$DsoManifest:<init>	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   84: astore 7
    //   86: aload_0
    //   87: aload_2
    //   88: getfield 309	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   91: invokespecial 311	com/facebook/soloader/UnpackingSoSource:deleteUnmentionedFiles	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   94: ldc_w 312
    //   97: newarray byte
    //   99: astore 10
    //   101: aload_3
    //   102: invokevirtual 316	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:hasNext	()Z
    //   105: ifeq +236 -> 341
    //   108: aload_3
    //   109: invokevirtual 320	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:next	()Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    //   112: astore 9
    //   114: aconst_null
    //   115: astore_2
    //   116: iconst_1
    //   117: istore 5
    //   119: iconst_0
    //   120: istore_1
    //   121: iload 5
    //   123: ifeq +106 -> 229
    //   126: iload_1
    //   127: aload 7
    //   129: getfield 309	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   132: arraylength
    //   133: if_icmpge +96 -> 229
    //   136: iload 5
    //   138: istore 4
    //   140: aload 7
    //   142: getfield 309	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   145: iload_1
    //   146: aaload
    //   147: getfield 109	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   150: aload 9
    //   152: getfield 134	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   155: getfield 109	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   158: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +38 -> 199
    //   164: aload 7
    //   166: getfield 309	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   169: iload_1
    //   170: aaload
    //   171: getfield 323	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   174: aload 9
    //   176: getfield 134	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   179: getfield 323	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   182: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: istore 6
    //   187: iload 5
    //   189: istore 4
    //   191: iload 6
    //   193: ifeq +6 -> 199
    //   196: iconst_0
    //   197: istore 4
    //   199: iload_1
    //   200: iconst_1
    //   201: iadd
    //   202: istore_1
    //   203: iload 4
    //   205: istore 5
    //   207: goto -86 -> 121
    //   210: astore 7
    //   212: ldc 43
    //   214: ldc_w 325
    //   217: aload 7
    //   219: invokestatic 327	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   222: pop
    //   223: aconst_null
    //   224: astore 7
    //   226: goto -158 -> 68
    //   229: iload 5
    //   231: ifeq +11 -> 242
    //   234: aload_0
    //   235: aload 9
    //   237: aload 10
    //   239: invokespecial 329	com/facebook/soloader/UnpackingSoSource:extractDso	(Lcom/facebook/soloader/UnpackingSoSource$InputDso;[B)V
    //   242: aload 9
    //   244: ifnull -143 -> 101
    //   247: iconst_0
    //   248: ifeq +40 -> 288
    //   251: aload 9
    //   253: invokevirtual 330	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   256: goto -155 -> 101
    //   259: astore_2
    //   260: new 261	java/lang/NullPointerException
    //   263: dup
    //   264: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   267: athrow
    //   268: astore_2
    //   269: aload_2
    //   270: athrow
    //   271: astore_3
    //   272: aload 8
    //   274: ifnull +12 -> 286
    //   277: aload_2
    //   278: ifnull +104 -> 382
    //   281: aload 8
    //   283: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   286: aload_3
    //   287: athrow
    //   288: aload 9
    //   290: invokevirtual 330	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   293: goto -192 -> 101
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -27 -> 272
    //   302: astore_2
    //   303: aload_2
    //   304: athrow
    //   305: astore_3
    //   306: aload 9
    //   308: ifnull +12 -> 320
    //   311: aload_2
    //   312: ifnull +21 -> 333
    //   315: aload 9
    //   317: invokevirtual 330	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   320: aload_3
    //   321: athrow
    //   322: astore 7
    //   324: aload_2
    //   325: aload 7
    //   327: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   330: goto -10 -> 320
    //   333: aload 9
    //   335: invokevirtual 330	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   338: goto -18 -> 320
    //   341: aload 8
    //   343: ifnull +12 -> 355
    //   346: iconst_0
    //   347: ifeq +18 -> 365
    //   350: aload 8
    //   352: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   355: return
    //   356: astore_2
    //   357: new 261	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: aload 8
    //   367: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   370: return
    //   371: astore 7
    //   373: aload_2
    //   374: aload 7
    //   376: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   379: goto -93 -> 286
    //   382: aload 8
    //   384: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   387: goto -101 -> 286
    //   390: astore_2
    //   391: goto -122 -> 269
    //   394: astore_3
    //   395: goto -89 -> 306
    //   398: goto -312 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	UnpackingSoSource
    //   0	401	1	paramByte	byte
    //   0	401	2	paramDsoManifest	DsoManifest
    //   0	401	3	paramInputDsoIterator	InputDsoIterator
    //   138	66	4	i	int
    //   117	113	5	j	int
    //   185	7	6	bool	boolean
    //   66	99	7	localDsoManifest	DsoManifest
    //   210	8	7	localException	java.lang.Exception
    //   224	1	7	localObject	Object
    //   322	4	7	localThrowable1	java.lang.Throwable
    //   371	4	7	localThrowable2	java.lang.Throwable
    //   54	329	8	localRandomAccessFile	RandomAccessFile
    //   112	222	9	localInputDso	InputDso
    //   99	139	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	68	210	java/lang/Exception
    //   251	256	259	java/lang/Throwable
    //   61	68	268	java/lang/Throwable
    //   86	101	268	java/lang/Throwable
    //   101	114	268	java/lang/Throwable
    //   212	223	268	java/lang/Throwable
    //   260	268	268	java/lang/Throwable
    //   288	293	268	java/lang/Throwable
    //   320	322	268	java/lang/Throwable
    //   324	330	268	java/lang/Throwable
    //   333	338	268	java/lang/Throwable
    //   269	271	271	finally
    //   61	68	296	finally
    //   73	86	296	finally
    //   86	101	296	finally
    //   101	114	296	finally
    //   212	223	296	finally
    //   251	256	296	finally
    //   260	268	296	finally
    //   288	293	296	finally
    //   315	320	296	finally
    //   320	322	296	finally
    //   324	330	296	finally
    //   333	338	296	finally
    //   126	136	302	java/lang/Throwable
    //   140	187	302	java/lang/Throwable
    //   234	242	302	java/lang/Throwable
    //   303	305	305	finally
    //   315	320	322	java/lang/Throwable
    //   350	355	356	java/lang/Throwable
    //   281	286	371	java/lang/Throwable
    //   73	86	390	java/lang/Throwable
    //   126	136	394	finally
    //   140	187	394	finally
    //   234	242	394	finally
  }
  
  /* Error */
  private static void writeState(File paramFile, byte paramByte)
    throws IOException
  {
    // Byte code:
    //   0: new 145	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 147
    //   7: invokespecial 148	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_3
    //   14: lconst_0
    //   15: invokevirtual 333	java/io/RandomAccessFile:seek	(J)V
    //   18: aload_3
    //   19: iload_1
    //   20: invokevirtual 337	java/io/RandomAccessFile:write	(I)V
    //   23: aload_3
    //   24: aload_3
    //   25: invokevirtual 175	java/io/RandomAccessFile:getFilePointer	()J
    //   28: invokevirtual 179	java/io/RandomAccessFile:setLength	(J)V
    //   31: aload_3
    //   32: invokevirtual 162	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   35: invokevirtual 342	java/io/FileDescriptor:sync	()V
    //   38: aload_3
    //   39: ifnull +11 -> 50
    //   42: iconst_0
    //   43: ifeq +17 -> 60
    //   46: aload_3
    //   47: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   50: return
    //   51: astore_0
    //   52: new 261	java/lang/NullPointerException
    //   55: dup
    //   56: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   59: athrow
    //   60: aload_3
    //   61: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   64: return
    //   65: astore_0
    //   66: aload_0
    //   67: athrow
    //   68: astore_2
    //   69: aload_3
    //   70: ifnull +11 -> 81
    //   73: aload_0
    //   74: ifnull +18 -> 92
    //   77: aload_3
    //   78: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   81: aload_2
    //   82: athrow
    //   83: astore_3
    //   84: aload_0
    //   85: aload_3
    //   86: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   89: goto -8 -> 81
    //   92: aload_3
    //   93: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   96: goto -15 -> 81
    //   99: astore_2
    //   100: goto -31 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramFile	File
    //   0	103	1	paramByte	byte
    //   68	14	2	localObject1	Object
    //   99	1	2	localObject2	Object
    //   10	68	3	localRandomAccessFile	RandomAccessFile
    //   83	10	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   46	50	51	java/lang/Throwable
    //   13	38	65	java/lang/Throwable
    //   66	68	68	finally
    //   77	81	83	java/lang/Throwable
    //   13	38	99	finally
  }
  
  /* Error */
  protected byte[] getDepsBlock()
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 350	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 245	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload 4
    //   14: invokevirtual 249	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   17: getfield 309	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   20: astore 5
    //   22: aload_2
    //   23: iconst_1
    //   24: invokevirtual 354	android/os/Parcel:writeByte	(B)V
    //   27: aload_2
    //   28: aload 5
    //   30: arraylength
    //   31: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   34: iconst_0
    //   35: istore_1
    //   36: iload_1
    //   37: aload 5
    //   39: arraylength
    //   40: if_icmpge +32 -> 72
    //   43: aload_2
    //   44: aload 5
    //   46: iload_1
    //   47: aaload
    //   48: getfield 109	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   51: invokevirtual 360	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   54: aload_2
    //   55: aload 5
    //   57: iload_1
    //   58: aaload
    //   59: getfield 323	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   62: invokevirtual 360	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -33 -> 36
    //   72: aload 4
    //   74: ifnull +12 -> 86
    //   77: iconst_0
    //   78: ifeq +28 -> 106
    //   81: aload 4
    //   83: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   86: aload_2
    //   87: invokevirtual 363	android/os/Parcel:marshall	()[B
    //   90: astore_3
    //   91: aload_2
    //   92: invokevirtual 366	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: areturn
    //   97: astore_2
    //   98: new 261	java/lang/NullPointerException
    //   101: dup
    //   102: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   105: athrow
    //   106: aload 4
    //   108: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   111: goto -25 -> 86
    //   114: astore_3
    //   115: aload_3
    //   116: athrow
    //   117: astore_2
    //   118: aload 4
    //   120: ifnull +12 -> 132
    //   123: aload_3
    //   124: ifnull +21 -> 145
    //   127: aload 4
    //   129: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore 4
    //   136: aload_3
    //   137: aload 4
    //   139: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   142: goto -10 -> 132
    //   145: aload 4
    //   147: invokevirtual 259	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   150: goto -18 -> 132
    //   153: astore_2
    //   154: goto -36 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	UnpackingSoSource
    //   35	34	1	i	int
    //   3	89	2	localParcel	android.os.Parcel
    //   97	1	2	localThrowable1	java.lang.Throwable
    //   117	16	2	localObject1	Object
    //   153	1	2	localObject2	Object
    //   11	85	3	arrayOfByte	byte[]
    //   114	23	3	localThrowable2	java.lang.Throwable
    //   8	120	4	localUnpacker	Unpacker
    //   134	12	4	localThrowable3	java.lang.Throwable
    //   20	36	5	arrayOfDso	Dso[]
    // Exception table:
    //   from	to	target	type
    //   81	86	97	java/lang/Throwable
    //   12	34	114	java/lang/Throwable
    //   36	65	114	java/lang/Throwable
    //   115	117	117	finally
    //   127	132	134	java/lang/Throwable
    //   12	34	153	finally
    //   36	65	153	finally
  }
  
  public String[] getSoSourceAbis()
  {
    if (this.mAbis == null) {
      return super.getSoSourceAbis();
    }
    return this.mAbis;
  }
  
  protected abstract Unpacker makeUnpacker()
    throws IOException;
  
  protected void prepare(int paramInt)
    throws IOException
  {
    SysUtil.mkdirOrThrow(this.soDirectory);
    FileLocker localFileLocker = FileLocker.lock(new File(this.soDirectory, "dso_lock"));
    try
    {
      Log.v("fb-UnpackingSoSource", "locked dso store " + this.soDirectory);
      boolean bool = refreshLocked(localFileLocker, paramInt, getDepsBlock());
      if (bool) {
        localFileLocker = null;
      }
      while (localFileLocker != null)
      {
        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
        localFileLocker.close();
        return;
        Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.soDirectory);
      }
      Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
    }
    finally
    {
      if (localFileLocker == null) {
        break label218;
      }
    }
    localFileLocker.close();
    for (;;)
    {
      throw localObject;
      Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
      return;
      label218:
      Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
    }
  }
  
  public void setSoSourceAbis(String[] paramArrayOfString)
  {
    this.mAbis = paramArrayOfString;
  }
  
  public static class Dso
  {
    public final String hash;
    public final String name;
    
    public Dso(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.hash = paramString2;
    }
  }
  
  public static final class DsoManifest
  {
    public final UnpackingSoSource.Dso[] dsos;
    
    public DsoManifest(UnpackingSoSource.Dso[] paramArrayOfDso)
    {
      this.dsos = paramArrayOfDso;
    }
    
    static final DsoManifest read(DataInput paramDataInput)
      throws IOException
    {
      if (paramDataInput.readByte() != 1) {
        throw new RuntimeException("wrong dso manifest version");
      }
      int j = paramDataInput.readInt();
      if (j < 0) {
        throw new RuntimeException("illegal number of shared libraries");
      }
      UnpackingSoSource.Dso[] arrayOfDso = new UnpackingSoSource.Dso[j];
      int i = 0;
      while (i < j)
      {
        arrayOfDso[i] = new UnpackingSoSource.Dso(paramDataInput.readUTF(), paramDataInput.readUTF());
        i += 1;
      }
      return new DsoManifest(arrayOfDso);
    }
    
    public final void write(DataOutput paramDataOutput)
      throws IOException
    {
      paramDataOutput.writeByte(1);
      paramDataOutput.writeInt(this.dsos.length);
      int i = 0;
      while (i < this.dsos.length)
      {
        paramDataOutput.writeUTF(this.dsos[i].name);
        paramDataOutput.writeUTF(this.dsos[i].hash);
        i += 1;
      }
    }
  }
  
  protected static final class InputDso
    implements Closeable
  {
    public final InputStream content;
    public final UnpackingSoSource.Dso dso;
    
    public InputDso(UnpackingSoSource.Dso paramDso, InputStream paramInputStream)
    {
      this.dso = paramDso;
      this.content = paramInputStream;
    }
    
    public void close()
      throws IOException
    {
      this.content.close();
    }
  }
  
  protected static abstract class InputDsoIterator
    implements Closeable
  {
    public void close()
      throws IOException
    {}
    
    public abstract boolean hasNext();
    
    public abstract UnpackingSoSource.InputDso next()
      throws IOException;
  }
  
  protected static abstract class Unpacker
    implements Closeable
  {
    public void close()
      throws IOException
    {}
    
    protected abstract UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException;
    
    protected abstract UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.soloader.UnpackingSoSource
 * JD-Core Version:    0.7.0.1
 */