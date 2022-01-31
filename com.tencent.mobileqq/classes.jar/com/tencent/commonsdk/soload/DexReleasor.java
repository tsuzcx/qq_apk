package com.tencent.commonsdk.soload;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.zip.ZipException;

public class DexReleasor
  implements MyZipConstants
{
  private static final String DEX_NAME = "classes.dex";
  private static DexReleasor dexOperator = null;
  public static final String[] sExtraDexes = { "classes2.dex", "classes3.dex", "classes4.dex", "classes5.dex", "classes6.dex", "classes7.dex" };
  public static final String[] sExtraJarDexes = { "classes2.jar", "classes3.jar", "classes4.jar", "classes5.jar", "classes6.dex", "classes7.jar" };
  byte[] buffer = new byte[81920];
  byte[] commentOfEOCD = null;
  private String mDstPath;
  private final LinkedHashMap<String, MyZipEntry> mEntries = new LinkedHashMap();
  RandomAccessFile mRaf = null;
  private String mSrcFile;
  
  public DexReleasor(String paramString1, String paramString2)
  {
    this.mSrcFile = paramString1;
    this.mDstPath = paramString2;
    try
    {
      read();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static DexReleasor getInstance(String paramString1, String paramString2)
  {
    try
    {
      if (dexOperator == null) {
        dexOperator = new DexReleasor(paramString1, paramString2);
      }
      paramString1 = dexOperator;
      return paramString1;
    }
    finally {}
  }
  
  private boolean read()
    throws IOException
  {
    try
    {
      File localFile1 = new File(this.mSrcFile);
      if (!localFile1.exists()) {
        throw new IOException("no exist " + this.mSrcFile);
      }
    }
    finally {}
    this.mRaf = new RandomAccessFile(localFile2, "r");
    long l2 = this.mRaf.length() - 22L;
    Object localObject;
    int i;
    int j;
    int i9;
    int k;
    long l1;
    int m;
    int n;
    label242:
    long l3;
    label280:
    byte[] arrayOfByte;
    int i3;
    int i1;
    if (l2 < 0L)
    {
      throw new ZipException("too short to be Zip");
      do
      {
        this.mRaf.seek(l2);
        if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
        {
          localObject = new byte[18];
          this.mRaf.readFully((byte[])localObject);
          localObject = HeapBufferIterator.iterator((byte[])localObject, 0, localObject.length, ByteOrder.LITTLE_ENDIAN);
          i = ((BufferIterator)localObject).readShort();
          j = ((BufferIterator)localObject).readShort();
          i9 = ((BufferIterator)localObject).readShort();
          k = ((BufferIterator)localObject).readShort();
          l1 = ((BufferIterator)localObject).readInt();
          m = ((BufferIterator)localObject).readInt();
          n = ((BufferIterator)localObject).readShort();
          if (n <= 0) {
            break;
          }
          localObject = new byte[n];
          if (this.mRaf.read((byte[])localObject, 0, localObject.length) == -1) {
            break;
          }
          this.commentOfEOCD = ((byte[])localObject);
          break;
          throw new ZipException("spanned archives not supported");
        }
        l3 = l2 - 1L;
        l2 = l3;
      } while (l3 >= l1);
      throw new ZipException("EOCD not found; not a Zip archive?");
      localObject = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, m), 4096);
      arrayOfByte = new byte[46];
      m = 0;
      i3 = 0;
      k = 0;
      j = 0;
      i1 = 0;
      n = 0;
      i = 0;
    }
    label833:
    for (;;)
    {
      if (m != 0) {}
      label353:
      int i2;
      int i4;
      int i5;
      int i6;
      int i7;
      int i8;
      for (boolean bool = readLocalHeader(this.mRaf);; bool = false)
      {
        return bool;
        MyZipEntry localMyZipEntry = new MyZipEntry(arrayOfByte, (InputStream)localObject);
        String str = localMyZipEntry.getName();
        i2 = j;
        i4 = k;
        i5 = m;
        i6 = n;
        i7 = i1;
        i8 = i3;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        if (str.equals(sExtraDexes[0]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i5 = 1;
          i2 = j;
          i4 = k;
          i6 = n;
          i7 = i1;
          i8 = i3;
          break;
        }
        if (str.equals(sExtraDexes[1]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i8 = 1;
          i2 = j;
          i4 = k;
          i5 = m;
          i6 = n;
          i7 = i1;
          break;
        }
        if (str.equals(sExtraDexes[2]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i4 = 1;
          i2 = j;
          i5 = m;
          i6 = n;
          i7 = i1;
          i8 = i3;
          break;
        }
        if (str.equals(sExtraDexes[3]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i2 = 1;
          i4 = k;
          i5 = m;
          i6 = n;
          i7 = i1;
          i8 = i3;
          break;
        }
        if (str.equals(sExtraDexes[4]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i7 = 1;
          i2 = j;
          i4 = k;
          i5 = m;
          i6 = n;
          i8 = i3;
          break;
        }
        i2 = j;
        i4 = k;
        i5 = m;
        i6 = n;
        i7 = i1;
        i8 = i3;
        if (!str.equals(sExtraDexes[5])) {
          break;
        }
        this.mEntries.put(str, localMyZipEntry);
        i6 = 1;
        i2 = j;
        i4 = k;
        i5 = m;
        i7 = i1;
        i8 = i3;
        break;
      }
      l3 = l2 - 65536L;
      l1 = l3;
      if (l3 < 0L) {
        l1 = 0L;
      }
      break;
      if ((i9 != k) || (i != 0)) {
        break label242;
      }
      if (j == 0) {
        break label280;
      }
      break label242;
      for (;;)
      {
        if (i >= i9) {
          break label833;
        }
        if ((m == 0) || (i3 == 0) || (k == 0) || (j == 0) || (i1 == 0) || (n == 0)) {
          break label353;
        }
        break;
        i += 1;
        j = i2;
        k = i4;
        m = i5;
        n = i6;
        i1 = i7;
        i3 = i8;
      }
    }
  }
  
  private boolean readLocalHeader(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[30];
        Iterator localIterator = this.mEntries.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label229;
        }
        Object localObject = (String)localIterator.next();
        localObject = (MyZipEntry)this.mEntries.get(localObject);
        Streams.readFully(new BufferedInputStream(new MyZipFile.RAFStream(paramRandomAccessFile, ((MyZipEntry)localObject).mLocalHeaderRelOffset), 4096), arrayOfByte, 0, arrayOfByte.length);
        HeapBufferIterator localHeapBufferIterator = HeapBufferIterator.iterator(arrayOfByte, 0, arrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
        i = localHeapBufferIterator.readInt();
        if (i != 67324752L)
        {
          bool = false;
          return bool;
        }
        localHeapBufferIterator.skip(2);
        if ((localHeapBufferIterator.readShort() & 0x8) != 0)
        {
          bool = true;
          localHeapBufferIterator.skip(18);
          i = localHeapBufferIterator.readShort();
          int j = localHeapBufferIterator.readShort();
          ((MyZipEntry)localObject).hasDD = bool;
          long l1 = i + 30 + j;
          long l2 = ((MyZipEntry)localObject).compressedSize;
          if (!bool) {
            break label224;
          }
          i = 16;
          ((MyZipEntry)localObject).mLocContentSize = (l1 + l2 + i);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label224:
      int i = 0;
      continue;
      label229:
      boolean bool = true;
    }
  }
  
  private long writeLong(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private int writeShort(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  /* Error */
  private File writeToJar(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/commonsdk/soload/DexReleasor:mEntries	Ljava/util/LinkedHashMap;
    //   6: aload_2
    //   7: invokevirtual 239	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 194	com/tencent/commonsdk/soload/MyZipEntry
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: new 95	java/io/File
    //   27: dup
    //   28: new 103	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: getfield 80	com/tencent/commonsdk/soload/DexReleasor:mDstPath	Ljava/lang/String;
    //   39: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 101	java/io/File:exists	()Z
    //   57: ifne +8 -> 65
    //   60: aload_1
    //   61: invokevirtual 280	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: new 282	java/io/FileOutputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 285	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore 10
    //   75: new 287	java/io/BufferedOutputStream
    //   78: dup
    //   79: aload 10
    //   81: invokespecial 290	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore 11
    //   86: aload_0
    //   87: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   90: aload_2
    //   91: getfield 243	com/tencent/commonsdk/soload/MyZipEntry:mLocalHeaderRelOffset	J
    //   94: invokevirtual 137	java/io/RandomAccessFile:seek	(J)V
    //   97: aload_0
    //   98: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   101: aload_0
    //   102: getfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   105: iconst_0
    //   106: bipush 26
    //   108: invokevirtual 174	java/io/RandomAccessFile:read	([BII)I
    //   111: istore_3
    //   112: iload_3
    //   113: iconst_m1
    //   114: if_icmpeq +9 -> 123
    //   117: iload_3
    //   118: bipush 26
    //   120: if_icmpeq +18 -> 138
    //   123: aload 11
    //   125: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   128: aload 10
    //   130: invokevirtual 294	java/io/FileOutputStream:close	()V
    //   133: aconst_null
    //   134: astore_1
    //   135: goto -115 -> 20
    //   138: aload 11
    //   140: aload_0
    //   141: getfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   144: iconst_0
    //   145: bipush 26
    //   147: invokevirtual 297	java/io/BufferedOutputStream:write	([BII)V
    //   150: ldc 10
    //   152: ldc_w 299
    //   155: invokevirtual 303	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   158: astore 12
    //   160: aload 12
    //   162: arraylength
    //   163: istore 4
    //   165: aload_0
    //   166: aload 11
    //   168: iload 4
    //   170: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   173: pop
    //   174: aload_0
    //   175: aload 11
    //   177: aload_2
    //   178: getfield 309	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   181: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   184: pop
    //   185: aload 11
    //   187: aload 12
    //   189: invokevirtual 311	java/io/BufferedOutputStream:write	([B)V
    //   192: aload_0
    //   193: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   196: aload_2
    //   197: getfield 243	com/tencent/commonsdk/soload/MyZipEntry:mLocalHeaderRelOffset	J
    //   200: ldc2_w 312
    //   203: ladd
    //   204: aload_2
    //   205: getfield 316	com/tencent/commonsdk/soload/MyZipEntry:nameLength	I
    //   208: i2l
    //   209: ladd
    //   210: invokevirtual 137	java/io/RandomAccessFile:seek	(J)V
    //   213: aload_2
    //   214: getfield 264	com/tencent/commonsdk/soload/MyZipEntry:mLocContentSize	J
    //   217: ldc2_w 312
    //   220: lsub
    //   221: aload_2
    //   222: getfield 316	com/tencent/commonsdk/soload/MyZipEntry:nameLength	I
    //   225: i2l
    //   226: lsub
    //   227: lstore 8
    //   229: lconst_0
    //   230: lstore 6
    //   232: ldc2_w 317
    //   235: lload 6
    //   237: ladd
    //   238: lload 8
    //   240: lcmp
    //   241: ifgt +20 -> 261
    //   244: aload_0
    //   245: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   248: aload_0
    //   249: getfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   252: invokevirtual 321	java/io/RandomAccessFile:read	([B)I
    //   255: istore_3
    //   256: iload_3
    //   257: iconst_m1
    //   258: if_icmpne +448 -> 706
    //   261: lload 8
    //   263: lload 6
    //   265: lsub
    //   266: l2i
    //   267: istore_3
    //   268: aload_0
    //   269: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   272: aload_0
    //   273: getfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   276: iconst_0
    //   277: iload_3
    //   278: invokevirtual 174	java/io/RandomAccessFile:read	([BII)I
    //   281: istore 5
    //   283: iload 5
    //   285: iconst_m1
    //   286: if_icmpeq +470 -> 756
    //   289: iload 5
    //   291: iload_3
    //   292: if_icmpne +464 -> 756
    //   295: aload 11
    //   297: aload_0
    //   298: getfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   301: iconst_0
    //   302: iload_3
    //   303: invokevirtual 297	java/io/BufferedOutputStream:write	([BII)V
    //   306: new 323	java/io/ByteArrayOutputStream
    //   309: dup
    //   310: invokespecial 324	java/io/ByteArrayOutputStream:<init>	()V
    //   313: astore 13
    //   315: aload_0
    //   316: aload 13
    //   318: ldc2_w 325
    //   321: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   324: pop2
    //   325: aload_0
    //   326: aload 13
    //   328: aload_2
    //   329: getfield 331	com/tencent/commonsdk/soload/MyZipEntry:version	I
    //   332: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   335: pop
    //   336: aload_0
    //   337: aload 13
    //   339: aload_2
    //   340: getfield 334	com/tencent/commonsdk/soload/MyZipEntry:versionMinimum	I
    //   343: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   346: pop
    //   347: aload_0
    //   348: aload 13
    //   350: aload_2
    //   351: getfield 337	com/tencent/commonsdk/soload/MyZipEntry:flags	I
    //   354: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   357: pop
    //   358: aload_0
    //   359: aload 13
    //   361: aload_2
    //   362: getfield 340	com/tencent/commonsdk/soload/MyZipEntry:compressionMethod	I
    //   365: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   368: pop
    //   369: aload_0
    //   370: aload 13
    //   372: aload_2
    //   373: getfield 343	com/tencent/commonsdk/soload/MyZipEntry:time	I
    //   376: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   379: pop
    //   380: aload_0
    //   381: aload 13
    //   383: aload_2
    //   384: getfield 346	com/tencent/commonsdk/soload/MyZipEntry:modDate	I
    //   387: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   390: pop
    //   391: aload_0
    //   392: aload 13
    //   394: aload_2
    //   395: getfield 349	com/tencent/commonsdk/soload/MyZipEntry:crc	J
    //   398: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   401: pop2
    //   402: aload_0
    //   403: aload 13
    //   405: aload_2
    //   406: getfield 261	com/tencent/commonsdk/soload/MyZipEntry:compressedSize	J
    //   409: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   412: pop2
    //   413: aload_0
    //   414: aload 13
    //   416: aload_2
    //   417: getfield 352	com/tencent/commonsdk/soload/MyZipEntry:size	J
    //   420: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   423: pop2
    //   424: aload_0
    //   425: aload 13
    //   427: iload 4
    //   429: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   432: pop
    //   433: aload_0
    //   434: aload 13
    //   436: aload_2
    //   437: getfield 309	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   440: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   443: pop
    //   444: aload_0
    //   445: aload 13
    //   447: aload_2
    //   448: getfield 355	com/tencent/commonsdk/soload/MyZipEntry:commentLength	I
    //   451: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   454: pop
    //   455: aload_0
    //   456: aload 13
    //   458: aload_2
    //   459: getfield 358	com/tencent/commonsdk/soload/MyZipEntry:diskNumbers	I
    //   462: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   465: pop
    //   466: aload_0
    //   467: aload 13
    //   469: aload_2
    //   470: getfield 361	com/tencent/commonsdk/soload/MyZipEntry:internalFileAttri	I
    //   473: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   476: pop
    //   477: aload_0
    //   478: aload 13
    //   480: aload_2
    //   481: getfield 364	com/tencent/commonsdk/soload/MyZipEntry:externalFileAttri	J
    //   484: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   487: pop2
    //   488: aload_0
    //   489: aload 13
    //   491: lconst_0
    //   492: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   495: pop2
    //   496: aload 13
    //   498: aload 12
    //   500: invokevirtual 365	java/io/ByteArrayOutputStream:write	([B)V
    //   503: aload_2
    //   504: getfield 309	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   507: ifle +12 -> 519
    //   510: aload 13
    //   512: aload_2
    //   513: getfield 368	com/tencent/commonsdk/soload/MyZipEntry:extra	[B
    //   516: invokevirtual 365	java/io/ByteArrayOutputStream:write	([B)V
    //   519: aload_2
    //   520: getfield 355	com/tencent/commonsdk/soload/MyZipEntry:commentLength	I
    //   523: ifle +15 -> 538
    //   526: aload 13
    //   528: aload_2
    //   529: getfield 371	com/tencent/commonsdk/soload/MyZipEntry:comment	Ljava/lang/String;
    //   532: invokevirtual 374	java/lang/String:getBytes	()[B
    //   535: invokevirtual 365	java/io/ByteArrayOutputStream:write	([B)V
    //   538: aload_2
    //   539: getfield 258	com/tencent/commonsdk/soload/MyZipEntry:hasDD	Z
    //   542: ifeq +219 -> 761
    //   545: bipush 16
    //   547: istore_3
    //   548: iload_3
    //   549: bipush 30
    //   551: iadd
    //   552: iload 4
    //   554: iadd
    //   555: aload_2
    //   556: getfield 309	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   559: iadd
    //   560: i2l
    //   561: lstore 6
    //   563: aload_2
    //   564: getfield 261	com/tencent/commonsdk/soload/MyZipEntry:compressedSize	J
    //   567: lstore 8
    //   569: aload 13
    //   571: invokevirtual 376	java/io/ByteArrayOutputStream:size	()I
    //   574: istore_3
    //   575: aload_0
    //   576: aload 13
    //   578: ldc2_w 377
    //   581: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   584: pop2
    //   585: aload_0
    //   586: aload 13
    //   588: iconst_0
    //   589: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   592: pop
    //   593: aload_0
    //   594: aload 13
    //   596: iconst_0
    //   597: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   600: pop
    //   601: aload_0
    //   602: aload 13
    //   604: iconst_1
    //   605: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   608: pop
    //   609: aload_0
    //   610: aload 13
    //   612: iconst_1
    //   613: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   616: pop
    //   617: aload_0
    //   618: aload 13
    //   620: iload_3
    //   621: i2l
    //   622: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   625: pop2
    //   626: aload_0
    //   627: aload 13
    //   629: lload 6
    //   631: lload 8
    //   633: ladd
    //   634: invokespecial 328	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   637: pop2
    //   638: aload_0
    //   639: getfield 68	com/tencent/commonsdk/soload/DexReleasor:commentOfEOCD	[B
    //   642: ifnull +83 -> 725
    //   645: aload_0
    //   646: aload 13
    //   648: aload_0
    //   649: getfield 68	com/tencent/commonsdk/soload/DexReleasor:commentOfEOCD	[B
    //   652: arraylength
    //   653: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   656: pop
    //   657: aload 13
    //   659: aload_0
    //   660: getfield 68	com/tencent/commonsdk/soload/DexReleasor:commentOfEOCD	[B
    //   663: invokevirtual 365	java/io/ByteArrayOutputStream:write	([B)V
    //   666: aload 13
    //   668: aload 11
    //   670: invokevirtual 381	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   673: aload 11
    //   675: ifnull +13 -> 688
    //   678: aload 11
    //   680: invokevirtual 384	java/io/BufferedOutputStream:flush	()V
    //   683: aload 11
    //   685: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   688: aload 10
    //   690: ifnull +63 -> 753
    //   693: aload 10
    //   695: invokevirtual 385	java/io/FileOutputStream:flush	()V
    //   698: aload 10
    //   700: invokevirtual 294	java/io/FileOutputStream:close	()V
    //   703: goto +50 -> 753
    //   706: aload 11
    //   708: aload_0
    //   709: getfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   712: invokevirtual 311	java/io/BufferedOutputStream:write	([B)V
    //   715: lload 6
    //   717: iload_3
    //   718: i2l
    //   719: ladd
    //   720: lstore 6
    //   722: goto -490 -> 232
    //   725: aload_0
    //   726: aload 13
    //   728: iconst_0
    //   729: invokespecial 305	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   732: pop
    //   733: goto -67 -> 666
    //   736: astore_1
    //   737: aload_0
    //   738: monitorexit
    //   739: aload_1
    //   740: athrow
    //   741: astore_1
    //   742: goto -5 -> 737
    //   745: astore_1
    //   746: goto -9 -> 737
    //   749: astore_1
    //   750: goto -13 -> 737
    //   753: goto -733 -> 20
    //   756: aconst_null
    //   757: astore_1
    //   758: goto -738 -> 20
    //   761: iconst_0
    //   762: istore_3
    //   763: goto -215 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	this	DexReleasor
    //   0	766	1	paramString1	String
    //   0	766	2	paramString2	String
    //   111	652	3	i	int
    //   163	392	4	j	int
    //   281	12	5	k	int
    //   230	491	6	l1	long
    //   227	405	8	l2	long
    //   73	626	10	localFileOutputStream	java.io.FileOutputStream
    //   84	623	11	localBufferedOutputStream	java.io.BufferedOutputStream
    //   158	341	12	arrayOfByte	byte[]
    //   313	414	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   86	112	736	finally
    //   123	133	736	finally
    //   138	229	736	finally
    //   244	256	736	finally
    //   268	283	736	finally
    //   295	519	736	finally
    //   519	538	736	finally
    //   538	545	736	finally
    //   548	666	736	finally
    //   666	673	736	finally
    //   678	688	736	finally
    //   693	703	736	finally
    //   706	715	736	finally
    //   725	733	736	finally
    //   2	14	741	finally
    //   24	53	741	finally
    //   53	65	745	finally
    //   65	75	745	finally
    //   75	86	749	finally
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 387	java/io/RandomAccessFile:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 76	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   24: aconst_null
    //   25: putstatic 57	com/tencent/commonsdk/soload/DexReleasor:dexOperator	Lcom/tencent/commonsdk/soload/DexReleasor;
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   35: goto -16 -> 19
    //   38: astore_1
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 66	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	DexReleasor
    //   29	1	1	localIOException	IOException
    //   38	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	29	java/io/IOException
    //   7	14	38	finally
  }
  
  public long getEntryCrcCode(String paramString)
  {
    paramString = (MyZipEntry)this.mEntries.get(paramString);
    if (paramString != null) {
      return paramString.crc;
    }
    return -1L;
  }
  
  /* Error */
  public File releaseDex(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial 394	com/tencent/commonsdk/soload/DexReleasor:writeToJar	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: getstatic 43	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   14: iconst_5
    //   15: aaload
    //   16: aload_2
    //   17: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +9 -> 29
    //   23: aload_0
    //   24: invokevirtual 396	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   27: aload_3
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 397	java/io/IOException:printStackTrace	()V
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_3
    //   41: astore_1
    //   42: getstatic 43	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   45: iconst_5
    //   46: aaload
    //   47: aload_2
    //   48: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: ifeq -22 -> 29
    //   54: aload_0
    //   55: invokevirtual 396	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   58: aload_3
    //   59: astore_1
    //   60: goto -31 -> 29
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: getstatic 43	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   72: iconst_5
    //   73: aaload
    //   74: aload_2
    //   75: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 396	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	DexReleasor
    //   0	87	1	paramString1	String
    //   0	87	2	paramString2	String
    //   8	51	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	9	33	java/io/IOException
    //   11	27	63	finally
    //   42	58	63	finally
    //   69	85	63	finally
    //   85	87	63	finally
    //   2	9	68	finally
    //   34	38	68	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.DexReleasor
 * JD-Core Version:    0.7.0.1
 */