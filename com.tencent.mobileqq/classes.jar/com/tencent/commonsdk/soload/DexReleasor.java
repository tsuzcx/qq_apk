package com.tencent.commonsdk.soload;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
  public static int APK_DEX_COUNT = 11;
  private static final String DEX_COUNT_KEY = "mobileqq.dex.count";
  private static final String DEX_NAME = "classes.dex";
  private static final String TAG = "DexReleasor";
  private static DexReleasor dexOperator;
  public static String[] sExtraDexes;
  public static String[] sExtraJarDexes;
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
  
  public static void initDexCount(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        i = paramContext.metaData.getInt("mobileqq.dex.count", -1);
        if (i > 0)
        {
          paramContext = new StringBuilder();
          paramContext.append("DexReleasor.read, meta-data dexCount = ");
          paramContext.append(i);
          QLog.d("DexReleasor", 1, paramContext.toString());
          APK_DEX_COUNT = i;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("DexReleasor", 1, "DexReleaser.read meta-data dexCount Error", paramContext);
    }
    int i = APK_DEX_COUNT;
    sExtraDexes = new String[i - 1];
    sExtraJarDexes = new String[i - 1];
    i = 0;
    while (i < APK_DEX_COUNT - 1)
    {
      paramContext = sExtraDexes;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("classes");
      int j = i + 2;
      localStringBuilder.append(j);
      localStringBuilder.append(".dex");
      paramContext[i] = localStringBuilder.toString();
      paramContext = sExtraJarDexes;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("classes");
      localStringBuilder.append(j);
      localStringBuilder.append(".jar");
      paramContext[i] = localStringBuilder.toString();
      i += 1;
    }
  }
  
  private boolean read()
  {
    try
    {
      localObject1 = new File(this.mSrcFile);
      if (!((File)localObject1).exists()) {
        break label420;
      }
      this.mRaf = new RandomAccessFile((File)localObject1, "r");
      l1 = this.mRaf.length() - 22L;
      l2 = 0L;
      if (l1 < 0L) {
        break label410;
      }
      l3 = l1 - 65536L;
      if (l3 >= 0L) {
        break label474;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        long l1;
        long l3;
        int j;
        int n;
        int m;
        int i1;
        byte[] arrayOfByte;
        MyZipEntry localMyZipEntry;
        String str;
        String[] arrayOfString;
        boolean bool;
        for (;;)
        {
          label410:
          label420:
          throw localObject2;
        }
        label474:
        long l2 = l3;
        continue;
        k += 1;
        int i = m;
        continue;
        label491:
        int k = i;
        label493:
        j += 1;
        i = k;
        continue;
        l1 -= 1L;
        if (l1 < l2) {}
      }
    }
    this.mRaf.seek(l1);
    if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
    {
      localObject1 = new byte[18];
      this.mRaf.readFully((byte[])localObject1);
      localObject1 = HeapBufferIterator.iterator((byte[])localObject1, 0, localObject1.length, ByteOrder.LITTLE_ENDIAN);
      i = ((BufferIterator)localObject1).readShort();
      j = ((BufferIterator)localObject1).readShort();
      n = ((BufferIterator)localObject1).readShort();
      k = ((BufferIterator)localObject1).readShort();
      ((BufferIterator)localObject1).readInt();
      m = ((BufferIterator)localObject1).readInt();
      i1 = ((BufferIterator)localObject1).readShort();
      if (i1 > 0)
      {
        localObject1 = new byte[i1];
        if (this.mRaf.read((byte[])localObject1, 0, localObject1.length) != -1) {
          this.commentOfEOCD = ((byte[])localObject1);
        }
      }
      if ((n == k) && (i == 0) && (j == 0))
      {
        localObject1 = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, m), 4096);
        arrayOfByte = new byte[46];
        j = 0;
        i = 0;
        if ((j < n) && (i != APK_DEX_COUNT - 1))
        {
          localMyZipEntry = new MyZipEntry(arrayOfByte, (InputStream)localObject1);
          str = localMyZipEntry.getName();
          k = i;
          if (TextUtils.isEmpty(str)) {
            break label493;
          }
          arrayOfString = sExtraDexes;
          i1 = arrayOfString.length;
          k = 0;
          if (k >= i1) {
            break label491;
          }
          m = i;
          if (TextUtils.equals(str, arrayOfString[k]))
          {
            this.mEntries.put(str, localMyZipEntry);
            m = i + 1;
          }
        }
        else
        {
          if (i == APK_DEX_COUNT - 1)
          {
            bool = readLocalHeader(this.mRaf);
            return bool;
          }
          return false;
        }
      }
      else
      {
        throw new ZipException("spanned archives not supported");
        throw new ZipException("EOCD not found; not a Zip archive?");
        throw new ZipException("too short to be Zip");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("no exist ");
        ((StringBuilder)localObject1).append(this.mSrcFile);
        throw new IOException(((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private boolean readLocalHeader(RandomAccessFile paramRandomAccessFile)
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[30];
        Iterator localIterator = this.mEntries.keySet().iterator();
        boolean bool2 = localIterator.hasNext();
        bool1 = true;
        if (!bool2) {
          continue;
        }
        localObject1 = (String)localIterator.next();
        localObject1 = (MyZipEntry)this.mEntries.get(localObject1);
        localObject2 = new BufferedInputStream(new MyZipFile.RAFStream(paramRandomAccessFile, ((MyZipEntry)localObject1).mLocalHeaderRelOffset), 4096);
        j = arrayOfByte.length;
        i = 0;
        Streams.readFully((InputStream)localObject2, arrayOfByte, 0, j);
        localObject2 = HeapBufferIterator.iterator(arrayOfByte, 0, arrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
        j = ((BufferIterator)localObject2).readInt();
        if (j != 67324752L) {
          return false;
        }
        ((BufferIterator)localObject2).skip(2);
        if ((((BufferIterator)localObject2).readShort() & 0x8) == 0) {
          continue;
        }
      }
      finally
      {
        Object localObject1;
        Object localObject2;
        int j;
        int i;
        int k;
        long l1;
        long l2;
        continue;
        throw paramRandomAccessFile;
        continue;
        boolean bool1 = false;
        continue;
      }
      ((BufferIterator)localObject2).skip(18);
      j = ((BufferIterator)localObject2).readShort();
      k = ((BufferIterator)localObject2).readShort();
      ((MyZipEntry)localObject1).hasDD = bool1;
      l1 = j + 30 + k;
      l2 = ((MyZipEntry)localObject1).compressedSize;
      if (bool1) {
        i = 16;
      }
      ((MyZipEntry)localObject1).mLocContentSize = (l1 + l2 + i);
    }
    return true;
  }
  
  private long writeLong(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private int writeShort(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private File writeToJar(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = (MyZipEntry)this.mEntries.get(paramString2);
      if (paramString2 == null) {
        return null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mDstPath);
      ((StringBuilder)localObject).append(paramString1);
      paramString1 = new File(((StringBuilder)localObject).toString());
      if (!paramString1.exists()) {
        paramString1.createNewFile();
      }
      localObject = new FileOutputStream(paramString1);
      localBufferedOutputStream = new BufferedOutputStream((OutputStream)localObject);
      this.mRaf.seek(paramString2.mLocalHeaderRelOffset);
      i = this.mRaf.read(this.buffer, 0, 26);
      if ((i == -1) || (i != 26)) {
        break label733;
      }
      localBufferedOutputStream.write(this.buffer, 0, 26);
      byte[] arrayOfByte = "classes.dex".getBytes("UTF-8");
      j = arrayOfByte.length;
      writeShort(localBufferedOutputStream, j);
      writeShort(localBufferedOutputStream, paramString2.extraLength);
      localBufferedOutputStream.write(arrayOfByte);
      this.mRaf.seek(paramString2.mLocalHeaderRelOffset + 30L + paramString2.nameLength);
      l2 = paramString2.mLocContentSize - 30L - paramString2.nameLength;
      for (l1 = 0L; 81920L + l1 <= l2; l1 += i)
      {
        i = this.mRaf.read(this.buffer);
        if (i == -1) {
          break;
        }
        localBufferedOutputStream.write(this.buffer);
      }
      i = (int)(l2 - l1);
      int k = this.mRaf.read(this.buffer, 0, i);
      if ((k == -1) || (k != i)) {
        break label729;
      }
      localBufferedOutputStream.write(this.buffer, 0, i);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      writeLong(localByteArrayOutputStream, 33639248L);
      writeShort(localByteArrayOutputStream, paramString2.version);
      writeShort(localByteArrayOutputStream, paramString2.versionMinimum);
      writeShort(localByteArrayOutputStream, paramString2.flags);
      writeShort(localByteArrayOutputStream, paramString2.compressionMethod);
      writeShort(localByteArrayOutputStream, paramString2.time);
      writeShort(localByteArrayOutputStream, paramString2.modDate);
      writeLong(localByteArrayOutputStream, paramString2.crc);
      writeLong(localByteArrayOutputStream, paramString2.compressedSize);
      writeLong(localByteArrayOutputStream, paramString2.size);
      writeShort(localByteArrayOutputStream, j);
      writeShort(localByteArrayOutputStream, paramString2.extraLength);
      writeShort(localByteArrayOutputStream, paramString2.commentLength);
      writeShort(localByteArrayOutputStream, paramString2.diskNumbers);
      writeShort(localByteArrayOutputStream, paramString2.internalFileAttri);
      writeLong(localByteArrayOutputStream, paramString2.externalFileAttri);
      writeLong(localByteArrayOutputStream, 0L);
      localByteArrayOutputStream.write(arrayOfByte);
      if (paramString2.extraLength > 0) {
        localByteArrayOutputStream.write(paramString2.extra);
      }
      if (paramString2.commentLength > 0) {
        localByteArrayOutputStream.write(paramString2.comment.getBytes());
      }
      if (!paramString2.hasDD) {
        break label759;
      }
      i = 16;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        BufferedOutputStream localBufferedOutputStream;
        int j;
        long l2;
        long l1;
        ByteArrayOutputStream localByteArrayOutputStream;
        for (;;)
        {
          label729:
          label733:
          throw paramString1;
        }
        label759:
        int i = 0;
      }
    }
    l1 = 30 + i + j + paramString2.extraLength;
    l2 = paramString2.compressedSize;
    i = localByteArrayOutputStream.size();
    writeLong(localByteArrayOutputStream, 101010256L);
    writeShort(localByteArrayOutputStream, 0);
    writeShort(localByteArrayOutputStream, 0);
    writeShort(localByteArrayOutputStream, 1);
    writeShort(localByteArrayOutputStream, 1);
    writeLong(localByteArrayOutputStream, i);
    writeLong(localByteArrayOutputStream, l1 + l2);
    if (this.commentOfEOCD != null)
    {
      writeShort(localByteArrayOutputStream, this.commentOfEOCD.length);
      localByteArrayOutputStream.write(this.commentOfEOCD);
    }
    else
    {
      writeShort(localByteArrayOutputStream, 0);
    }
    localByteArrayOutputStream.writeTo(localBufferedOutputStream);
    localBufferedOutputStream.flush();
    localBufferedOutputStream.close();
    ((FileOutputStream)localObject).flush();
    ((FileOutputStream)localObject).close();
    return paramString1;
    for (;;)
    {
      return null;
      localBufferedOutputStream.close();
      ((FileOutputStream)localObject).close();
    }
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +23 -> 29
    //   9: aload_1
    //   10: invokevirtual 428	java/io/RandomAccessFile:close	()V
    //   13: goto +11 -> 24
    //   16: astore_1
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 45	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   22: aload_1
    //   23: athrow
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 45	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 55	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   34: aconst_null
    //   35: putstatic 70	com/tencent/commonsdk/soload/DexReleasor:dexOperator	Lcom/tencent/commonsdk/soload/DexReleasor;
    //   38: return
    //   39: astore_1
    //   40: goto -16 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	DexReleasor
    //   4	6	1	localRandomAccessFile	RandomAccessFile
    //   16	7	1	localObject	Object
    //   39	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	13	16	finally
    //   9	13	39	java/io/IOException
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
    //   5: invokespecial 435	com/tencent/commonsdk/soload/DexReleasor:writeToJar	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   8: astore 4
    //   10: aload 4
    //   12: astore_1
    //   13: getstatic 137	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   16: getstatic 127	com/tencent/commonsdk/soload/DexReleasor:APK_DEX_COUNT	I
    //   19: iconst_2
    //   20: isub
    //   21: aaload
    //   22: aload_2
    //   23: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +55 -> 81
    //   29: aload 4
    //   31: astore_1
    //   32: aload_0
    //   33: invokevirtual 440	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   36: goto +45 -> 81
    //   39: astore_1
    //   40: goto +67 -> 107
    //   43: astore_1
    //   44: goto +41 -> 85
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   52: aconst_null
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 4
    //   57: getstatic 137	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   60: getstatic 127	com/tencent/commonsdk/soload/DexReleasor:APK_DEX_COUNT	I
    //   63: iconst_2
    //   64: isub
    //   65: aaload
    //   66: aload_2
    //   67: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: istore_3
    //   71: iload_3
    //   72: ifeq +9 -> 81
    //   75: aload 4
    //   77: astore_1
    //   78: goto -46 -> 32
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: areturn
    //   85: getstatic 137	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   88: getstatic 127	com/tencent/commonsdk/soload/DexReleasor:APK_DEX_COUNT	I
    //   91: iconst_2
    //   92: isub
    //   93: aaload
    //   94: aload_2
    //   95: invokevirtual 438	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   98: ifeq +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 440	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   105: aload_1
    //   106: athrow
    //   107: aload_0
    //   108: monitorexit
    //   109: goto +5 -> 114
    //   112: aload_1
    //   113: athrow
    //   114: goto -2 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	DexReleasor
    //   0	117	1	paramString1	String
    //   0	117	2	paramString2	String
    //   70	2	3	bool	boolean
    //   8	68	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   13	29	39	finally
    //   32	36	39	finally
    //   57	71	39	finally
    //   85	105	39	finally
    //   105	107	39	finally
    //   2	10	43	finally
    //   48	52	43	finally
    //   2	10	47	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.soload.DexReleasor
 * JD-Core Version:    0.7.0.1
 */